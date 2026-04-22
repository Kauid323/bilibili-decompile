package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.downloads.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.videodownloader.directory.VideoDownloadDirectoryFactory;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.resolver.downloaded.DownloadResolveApi;
import com.bilibili.videodownloader.resolver.downloaded.DownloadedParams;
import com.bilibili.videodownloader.resolver.downloaded.ResolveCallback;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask;

public class DownloadedResolveTask extends ResolveTask {
    public DownloadedResolveTask(ScanEntry entry, ResolveTask.ResolveTaskListener listener) {
        super(entry, listener);
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask
    public void startResolve(final Context context) {
        super.startResolve(context);
        Task.callInBackground(new Callable<VideoDownloadEntry>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadedResolveTask.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VideoDownloadEntry call() throws Exception {
                return DownloadedResolveTask.this.obtainVideoDownloadEntry(context, DownloadedResolveTask.this.mScanEntry);
            }
        }).continueWith(new Continuation<VideoDownloadEntry, Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadedResolveTask.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1720then((Task<VideoDownloadEntry>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1720then(Task<VideoDownloadEntry> task) throws Exception {
                VideoDownloadEntry entry = (VideoDownloadEntry) task.getResult();
                if (entry != null) {
                    DownloadedResolveTask.this.resolveVideo(context, entry);
                    return null;
                }
                return null;
            }
        });
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask
    public void cancelResolve() {
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask
    public String getErrorContent(Context context, int errorCode) {
        switch (errorCode) {
            case 1:
                return context.getString(R.string.downloads_global_string_19, "entry");
            case 2:
            case 3:
                return context.getString(R.string.downloads_global_string_52, "entry");
            case 4:
                return context.getString(R.string.downloads_global_string_19, "typeTag");
            case 5:
                return context.getString(R.string.downloads_global_string_19, "index");
            case 6:
            case 7:
                return context.getString(R.string.downloads_global_string_52, "index");
            case 8:
                return context.getString(R.string.downloads_global_string_73);
            default:
                return context.getString(tv.danmaku.bili.R.string.diagonsis_downloaded_report_content_default, Integer.valueOf(errorCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoDownloadEntry obtainVideoDownloadEntry(Context context, ScanEntry scanEntry) {
        if (scanEntry.isValid()) {
            progressContent(2, scanEntry.getContent(context));
            return scanEntry.entry;
        }
        progressContent(context, 2, R.string.downloads_global_string_26);
        switch (scanEntry.step) {
            case 1:
            case 3:
                progressContent(context, 3, R.string.downloads_global_string_60);
                progressContent(context, 4, R.string.downloads_global_string_6);
                finish(context, scanEntry.storagePath, 1);
                return null;
            case 2:
                progressContent(context, 3, R.string.downloads_global_string_46);
                progressContent(context, 4, R.string.downloads_global_string_95);
                finish(context, scanEntry.storagePath, 1);
                return null;
            case 4:
                progressContent(context, 3, R.string.downloads_global_string_103);
                progressContent(context, 4, R.string.downloads_global_string_99);
                finish(context, scanEntry.storagePath, 1);
                return null;
            case 5:
                if (scanEntry.entry == null) {
                    progressContent(context, 3, R.string.downloads_global_string_50);
                    progressContent(context, 4, R.string.downloads_global_string_97);
                    finish(context, scanEntry.storagePath, 2);
                    return null;
                }
                progressContent(context, 3, R.string.downloads_global_string_113);
                progressContent(context, 4, R.string.downloads_global_string_49);
                finish(context, scanEntry.storagePath, 3);
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolveVideo(Context context, final VideoDownloadEntry entry) {
        MediaResource mediaResource;
        if (!entry.isCompleted()) {
            progressContent(context, 3, R.string.downloads_global_string_89);
            finish(context, this.mScanEntry.storagePath, 0);
            return;
        }
        DownloadedParams params = transform(context, entry);
        if (params != null && (mediaResource = DownloadResolveApi.getDownloadedMediaResource(context, params, (VideoFile[]) null, new ResolveCallback() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadedResolveTask.3
            public void onResolveFailed(Context context2, DownloadedParams params2, int errorCode) {
                switch (errorCode) {
                    case 4:
                        DownloadedResolveTask.this.progressContent(context2, 3, R.string.downloads_global_string_93);
                        DownloadedResolveTask.this.progressContent(context2, 4, R.string.downloads_global_string_84);
                        break;
                    case 5:
                        DownloadedResolveTask.this.progressContent(context2, 3, R.string.downloads_global_string_60);
                        DownloadedResolveTask.this.progressContent(context2, 4, R.string.downloads_global_string_6);
                        break;
                    case 6:
                        DownloadedResolveTask.this.progressContent(context2, 3, R.string.downloads_global_string_50);
                        DownloadedResolveTask.this.progressContent(context2, 4, R.string.downloads_global_string_97);
                        break;
                    case 7:
                        DownloadedResolveTask.this.progressContent(context2, 3, R.string.downloads_global_string_113);
                        DownloadedResolveTask.this.progressContent(context2, 4, R.string.downloads_global_string_49);
                    case 8:
                    case 10:
                        DownloadedResolveTask.this.progressContent(context2, 3, R.string.downloads_global_string_118);
                        DownloadedResolveTask.this.progressContent(context2, 4, R.string.downloads_global_string_7);
                        break;
                    case 11:
                        DownloadedResolveTask.this.progressContent(context2, 3, R.string.downloads_global_string_85);
                        DownloadedResolveTask.this.progressContent(context2, 4, R.string.downloads_global_string_48);
                        break;
                }
                try {
                    String rootPath = VideoDownloadStorageStrategy.getDownloadPath(context2, entry);
                    VideoFile file = VideoDownloadDirectoryFactory.create(VideoFile.fromPath(context2, rootPath), entry).getIndexFile(context2, false);
                    DownloadedResolveTask.this.finish(context2, file.getAbsolutePath(), errorCode);
                } catch (IOException e) {
                    DownloadedResolveTask.this.finish(context2, errorCode);
                }
            }
        })) != null && mediaResource.isPlayable()) {
            progressContent(context, 3, R.string.downloads_global_string_51);
            progressContent(context, 4, R.string.downloads_global_string_32, R.string.downloads_global_string_13);
            finish(context, 0);
        }
    }

    private DownloadedParams transform(Context context, VideoDownloadEntry entry) {
        if (entry instanceof VideoDownloadAVPageEntry) {
            VideoDownloadAVPageEntry av = (VideoDownloadAVPageEntry) entry;
            return new DownloadedParams(av.getAvid(), av.mPageData.page, -1L, (String) null, "downloaded", VideoDownloadStorageStrategy.getDownloadPath(context, entry), av.mPageData.cid);
        } else if (entry instanceof VideoDownloadSeasonEpEntry) {
            VideoDownloadSeasonEpEntry season = (VideoDownloadSeasonEpEntry) entry;
            return new DownloadedParams(season.getAvid(), -1, season.mEpisode.id, season.getSeasonId(), "downloaded", VideoDownloadStorageStrategy.getDownloadPath(context, entry), 0L);
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Context context, String errorFilePath, int code) {
        if (this.mListener != null) {
            try {
                this.mInfo.put("error_code", code);
            } catch (JSONException e) {
            }
            if (!TextUtils.isEmpty(errorFilePath)) {
                recordErrorFilePath(errorFilePath);
            }
            String fileStructure = this.mScanEntry.getDirectoryTree(context);
            recordInfo("file_structure", fileStructure);
            this.mListener.onFinish(code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Context context, int code) {
        finish(context, null, code);
    }
}