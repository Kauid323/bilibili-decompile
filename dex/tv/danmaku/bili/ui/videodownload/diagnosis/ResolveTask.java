package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import bili.resource.downloads.R;
import com.bilibili.videodownloader.directory.file.VideoFile;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.bili.utils.storage.StorageHelper;
import video.biz.offline.base.infra.utils.StorageHelperKt;

public abstract class ResolveTask {
    static final String RESOLVE_ERROR_CODE = "error_code";
    static final String RESOLVE_ERROR_INFO = "error_info";
    static final String RESOLVE_FLE_STRUCTURE = "file_structure";
    private static final String RESOLVE_IS_PRIMARY = "is_primary";
    private static final String RESOLVE_PATH = "path";
    private static final String RESOLVE_TYPE = "type";
    String mErrorFilePath;
    JSONObject mInfo = new JSONObject();
    ResolveTaskListener mListener;
    ScanEntry mScanEntry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ResolveTaskListener {
        void onFinish(int i);

        void onProgress(int i, CharSequence charSequence, CharSequence charSequence2);
    }

    public abstract void cancelResolve();

    public abstract String getErrorContent(Context context, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveTask(ScanEntry entry, ResolveTaskListener listener) {
        this.mScanEntry = entry;
        this.mListener = listener;
    }

    public static ResolveTask create(ScanEntry scanEntry, ResolveTaskListener listener) {
        if (scanEntry.isCompleted()) {
            return new DownloadedResolveTask(scanEntry, listener);
        }
        return new DownloadingResolveTask(scanEntry, listener);
    }

    public void startResolve(Context context) {
        int i;
        try {
            this.mInfo.put("type", DiagnosisTagHelper.getTagType(this.mScanEntry));
            String downloadPath = this.mScanEntry.getDownloadPath(context);
            this.mInfo.put(RESOLVE_PATH, downloadPath);
            this.mInfo.put(RESOLVE_IS_PRIMARY, isPrimaryPath(context, downloadPath));
            if (isPrimaryPath(context, this.mScanEntry.storagePath)) {
                i = R.string.downloads_global_string_79;
            } else {
                i = R.string.downloads_global_string_4;
            }
            progressContent(context, 1, i);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void progressContent(Context context, int step, int titleId, int contentId) {
        if (this.mListener != null) {
            this.mListener.onProgress(step, context.getString(titleId), context.getString(contentId));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void progressContent(Context context, int step, int msgId) {
        if (this.mListener != null) {
            this.mListener.onProgress(step, null, context.getString(msgId));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void progressContent(int step, CharSequence msg) {
        if (this.mListener != null) {
            this.mListener.onProgress(step, null, msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recordInfo(String key, String value) {
        try {
            this.mInfo.put(key, value);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRecordInfoValue(String key) {
        String value = this.mInfo.optString(key);
        return value == null ? "" : value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recordErrorFilePath(String errorFilePath) {
        this.mErrorFilePath = errorFilePath;
    }

    private static boolean isPrimaryPath(Context context, String path) {
        int splitIndex;
        if (!TextUtils.isEmpty(path)) {
            Uri uri = Uri.parse(path);
            if (VideoFile.isTreeUri(uri)) {
                String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
                if (!TextUtils.isEmpty(treeDocumentId) && (splitIndex = treeDocumentId.indexOf(":")) != -1 && splitIndex < treeDocumentId.length()) {
                    String uuid = treeDocumentId.substring(0, splitIndex);
                    return !TextUtils.isEmpty(uuid) && uuid.equals(StorageHelperKt.PRIMARY);
                }
            } else if ("file".equals(uri.getScheme())) {
                return StorageHelper.isPrimary(context, uri.getPath());
            }
        }
        return true;
    }
}