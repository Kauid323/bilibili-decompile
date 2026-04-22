package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.commons.compress.ZipUtils;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.videodownloader.directory.file.VideoFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.userfeedback.UserFeedbackHelper;
import tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask;

public class VideoDownloadResolveTestFragment extends BaseFragment implements Handler.Callback, ResolveTask.ResolveTaskListener {
    private static final String BUNDLE_ENTRY = "bundle_entry";
    private static final String LOG_MESSAGE_NAME = "resolve_message.log";
    private static final String LOG_PHOTO_NAME = "resolve_photo.jpg";
    private static final String LOG_ZIP_NAME = "resolve_record.zip";
    public static final int MSG_SHOW_VIDEO_DES = 2;
    public static final int MSG_SHOW_VIDEO_FINISH = 5;
    public static final int MSG_SHOW_VIDEO_RESULT = 3;
    public static final int MSG_SHOW_VIDEO_STORAGE = 1;
    public static final int MSG_SHOW_VIDEO_TIPS = 4;
    public static final String TAG = "VideoDownloadResolveTestFragment";
    private int mDiagnosisType;
    private Handler mHandler;
    private File mLogMessageFile;
    private File mLogPhotoFile;
    private File mLogZipFile;
    private TintProgressDialog mProgressDialog;
    private Button mReportBtn;
    private int mResolveErrorCode;
    private ResolveTask mResolveTask;
    private View mRootView;
    private ScanEntry mScanEntry;
    private TextView mTextDes;
    private TextView mTextDesContent;
    private TextView mTextResult;
    private TextView mTextResultContent;
    private TextView mTextStorage;
    private TextView mTextStorageContent;
    private TextView mTextTips;
    private TextView mTextTipsContent;
    private TextView mTextTree;
    private TextView mTextTreeContent;

    public static Fragment create(ScanEntry entry) {
        VideoDownloadResolveTestFragment fragment = new VideoDownloadResolveTestFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_ENTRY, entry);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.mScanEntry = (ScanEntry) bundle.getParcelable(BUNDLE_ENTRY);
        }
        this.mLogPhotoFile = new File(getContext().getExternalCacheDir(), LOG_PHOTO_NAME);
        this.mLogMessageFile = new File(getContext().getExternalCacheDir(), LOG_MESSAGE_NAME);
        this.mLogZipFile = new File(getContext().getExternalCacheDir(), LOG_ZIP_NAME);
        this.mHandler = new Handler(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bili_app_fragment_video_resolve_test, container, false);
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        int i;
        super.onViewCreated(view2, savedInstanceState);
        this.mRootView = view2.findViewById(R.id.root_layout);
        this.mTextDes = (TextView) view2.findViewById(R.id.video_desc);
        this.mTextDesContent = (TextView) view2.findViewById(R.id.video_desc_content);
        this.mTextStorage = (TextView) view2.findViewById(R.id.video_storage);
        this.mTextStorageContent = (TextView) view2.findViewById(R.id.video_storage_content);
        this.mTextResult = (TextView) view2.findViewById(R.id.video_result);
        this.mTextResultContent = (TextView) view2.findViewById(R.id.video_result_content);
        this.mTextTips = (TextView) view2.findViewById(R.id.video_tips);
        this.mTextTipsContent = (TextView) view2.findViewById(R.id.video_tips_content);
        this.mTextTree = (TextView) view2.findViewById(R.id.video_tree);
        this.mTextTreeContent = (TextView) view2.findViewById(R.id.video_tree_content);
        this.mReportBtn = (Button) view2.findViewById(R.id.report_log);
        this.mReportBtn.setVisibility(8);
        this.mReportBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadResolveTestFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                v.setEnabled(false);
                VideoDownloadResolveTestFragment.this.reportResolveLog();
            }
        });
        TextView textView = this.mTextDes;
        if (this.mScanEntry.isCompleted()) {
            i = bili.resource.downloads.R.string.downloads_global_string_71;
        } else {
            i = bili.resource.downloads.R.string.downloads_global_string_10;
        }
        textView.setText(i);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startResolveTask();
    }

    public void onDestroy() {
        if (this.mResolveTask != null) {
            this.mResolveTask.cancelResolve();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void startResolveTask() {
        this.mResolveTask = ResolveTask.create(this.mScanEntry, this);
        this.mDiagnosisType = DiagnosisTagHelper.getTagType(this.mScanEntry);
        this.mResolveTask.startResolve(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportResolveLog() {
        final Context context = getApplicationContext();
        if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
            hideLoadingDialog();
            ToastHelper.showToastShort(context, context.getString(bili.resource.common.R.string.common_global_string_111));
            return;
        }
        showLoadingDialog(getString(bili.resource.homepage.R.string.homepage_global_string_159));
        final TaskCompletionSource<String[]> uploadTs = new TaskCompletionSource<>();
        uploadTs.getTask().onSuccess(new Continuation<String[], Boolean>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadResolveTestFragment.3
            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1742then(Task task) throws Exception {
                return then((Task<String[]>) task);
            }

            public Boolean then(Task<String[]> task) throws Exception {
                String[] results = (String[]) task.getResult();
                return Boolean.valueOf(UserFeedbackHelper.addFeedbackItem(results[0], results[1], VideoDownloadResolveTestFragment.this.mResolveTask.getErrorContent(context, VideoDownloadResolveTestFragment.this.mResolveErrorCode), DiagnosisTagHelper.getTagId(VideoDownloadResolveTestFragment.this.mDiagnosisType, VideoDownloadResolveTestFragment.this.mResolveErrorCode), null));
            }
        }, Task.BACKGROUND_EXECUTOR).onSuccess(new Continuation<Boolean, Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadResolveTestFragment.2
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1741then((Task<Boolean>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1741then(Task<Boolean> task) throws Exception {
                int i;
                VideoDownloadResolveTestFragment.this.hideLoadingDialog();
                Context context2 = context;
                if (task.getResult() != null && ((Boolean) task.getResult()).booleanValue()) {
                    i = bili.resource.homepage.R.string.homepage_global_string_251;
                } else {
                    i = bili.resource.homepage.R.string.homepage_global_string_349;
                }
                ToastHelper.showToastShort(context2, i);
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
        Task.callInBackground(new Callable<String[]>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadResolveTestFragment.5
            @Override // java.util.concurrent.Callable
            public String[] call() throws Exception {
                String[] results = new String[2];
                String logUrl = VideoDownloadResolveTestFragment.this.prepareResolveLog();
                if (!TextUtils.isEmpty(logUrl)) {
                    String result = UserFeedbackHelper.uploadFile(logUrl);
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONObject data = (JSONObject) jsonObject.get("data");
                        results[0] = (String) data.get("url");
                    } catch (Exception e) {
                    }
                }
                if (!TextUtils.isEmpty(null)) {
                    String result2 = UserFeedbackHelper.uploadFile(null);
                    try {
                        JSONObject jsonObject2 = new JSONObject(result2);
                        JSONObject data2 = (JSONObject) jsonObject2.get("data");
                        results[1] = (String) data2.get("url");
                    } catch (Exception e2) {
                    }
                }
                String result3 = results[0];
                if (result3 == null && results[1] == null) {
                    return null;
                }
                return results;
            }
        }).continueWith(new Continuation<String[], Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadResolveTestFragment.4
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1743then((Task<String[]>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1743then(Task<String[]> task) throws Exception {
                if (task.isFaulted() || task.getResult() == null) {
                    VideoDownloadResolveTestFragment.this.hideLoadingDialog();
                    ToastHelper.showToastShort(context, bili.resource.homepage.R.string.homepage_global_string_205);
                    uploadTs.setCancelled();
                    return null;
                }
                uploadTs.setResult((String[]) task.getResult());
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    private String prepareResolvePhotoRecord() {
        Bitmap bitmap = Bitmap.createBitmap(this.mRootView.getMeasuredWidth(), this.mRootView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.mRootView.draw(canvas);
        FileOutputStream outputStream = null;
        try {
            try {
                outputStream = new FileOutputStream(this.mLogPhotoFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, outputStream);
                outputStream.flush();
                IOUtils.closeQuietly(outputStream);
                if (this.mLogPhotoFile.isFile()) {
                    return this.mLogPhotoFile.getAbsolutePath();
                }
                return null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                IOUtils.closeQuietly(outputStream);
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                IOUtils.closeQuietly(outputStream);
                return null;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(outputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r8.mLogMessageFile.length() > 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        r0 = com.bilibili.videodownloader.directory.file.VideoFile.fromFile(r8.mLogMessageFile);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (r8.mLogMessageFile.length() > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String prepareResolveLog() {
        VideoFile logFile = null;
        FragmentActivity activity = getActivity();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(this.mLogMessageFile);
            outputStream.write(this.mResolveTask.mInfo.toString().getBytes("UTF-8"));
            IOUtils.closeQuietly(outputStream);
            if (this.mLogMessageFile.isFile()) {
            }
        } catch (Exception e) {
            IOUtils.closeQuietly(outputStream);
            if (this.mLogMessageFile.isFile()) {
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(outputStream);
            if (this.mLogMessageFile.isFile() && this.mLogMessageFile.length() > 0) {
                VideoFile.fromFile(this.mLogMessageFile);
            }
            throw th;
        }
        VideoFile errorFile = VideoFile.fromPath(activity, this.mResolveTask.mErrorFilePath);
        VideoFileAdapter[] files = new VideoFileAdapter[2];
        if (errorFile != null && errorFile.isFile()) {
            files[0] = new VideoFileAdapter(errorFile);
        }
        if (logFile != null && logFile.isFile()) {
            files[1] = new VideoFileAdapter(logFile);
        }
        try {
            ZipUtils.zip(this.mLogZipFile.getAbsolutePath(), files);
        } catch (Exception e2) {
        }
        return this.mLogZipFile.getAbsolutePath();
    }

    private void copyStream(InputStream is, OutputStream os) {
        byte[] buffer = new byte[8196];
        while (true) {
            try {
                int size = is.read(buffer);
                if (size > 0) {
                    os.write(buffer, 0, size);
                } else {
                    os.flush();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void clearLogFiles() {
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadResolveTestFragment.6
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (VideoDownloadResolveTestFragment.this.mLogMessageFile.exists()) {
                    FileUtils.deleteQuietly(VideoDownloadResolveTestFragment.this.mLogMessageFile);
                }
                if (VideoDownloadResolveTestFragment.this.mLogPhotoFile.exists()) {
                    FileUtils.deleteQuietly(VideoDownloadResolveTestFragment.this.mLogPhotoFile);
                }
                if (VideoDownloadResolveTestFragment.this.mLogZipFile.exists()) {
                    FileUtils.deleteQuietly(VideoDownloadResolveTestFragment.this.mLogZipFile);
                    return null;
                }
                return null;
            }
        });
    }

    public void showLoadingDialog(String msg) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new TintProgressDialog(getContext());
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setCancelable(false);
        }
        this.mProgressDialog.setMessage(msg);
        if (this.mProgressDialog.isShowing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    public void hideLoadingDialog() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    private void sendMessage(int step, CharSequence title, CharSequence content) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("content", content);
        bundle.putCharSequence(RankRouter.BundleKey.ACTION_PARAM_TITLE, title);
        Message msg = Message.obtain();
        msg.what = step;
        msg.obj = bundle;
        this.mHandler.sendMessageDelayed(msg, step * 300);
    }

    private void sendReportEnable() {
        Message msg = Message.obtain();
        msg.what = 5;
        msg.arg1 = 1;
        this.mHandler.sendMessage(msg);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Bundle bundle = (Bundle) msg.obj;
        String content = bundle != null ? bundle.getCharSequence("content") : "";
        String title = bundle != null ? bundle.getCharSequence(RankRouter.BundleKey.ACTION_PARAM_TITLE) : "";
        switch (msg.what) {
            case 1:
                this.mTextStorage.setVisibility(0);
                this.mTextStorageContent.setVisibility(0);
                this.mTextStorageContent.append(content);
                break;
            case 2:
                this.mTextDes.setVisibility(0);
                this.mTextDesContent.setVisibility(0);
                this.mTextDesContent.append(content);
                break;
            case 3:
                this.mTextResult.setVisibility(0);
                this.mTextResultContent.setVisibility(0);
                this.mTextResultContent.append(content);
                break;
            case 4:
                this.mTextTips.setVisibility(0);
                this.mTextTipsContent.setVisibility(0);
                if (!TextUtils.isEmpty(title)) {
                    this.mTextTips.setText(title);
                }
                this.mTextTipsContent.append(content);
                break;
            case 5:
                if (this.mReportBtn.getVisibility() != 0) {
                    this.mReportBtn.setVisibility(msg.arg1 >= 1 ? 0 : 8);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mTextTree.setVisibility(0);
                    this.mTextTreeContent.setVisibility(0);
                    this.mTextTreeContent.append(content);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask.ResolveTaskListener
    public void onProgress(int step, CharSequence title, CharSequence content) {
        sendMessage(step, title, content);
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask.ResolveTaskListener
    public void onFinish(int errorCode) {
        if (errorCode == 0) {
            sendMessage(5, null, this.mScanEntry.getDirectoryTree(getActivity()));
            return;
        }
        this.mResolveErrorCode = errorCode;
        sendMessage(5, null, getString(R.string.diagonsis_resolve_dec_tree_error_code, new Object[]{Integer.valueOf(errorCode)}));
        sendReportEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class VideoFileAdapter implements ZipUtils.AbstractFile {
        private final VideoFile mFile;

        public VideoFileAdapter(VideoFile file) {
            this.mFile = file;
        }

        public boolean exists() {
            return this.mFile.exists();
        }

        public boolean isDirectory() {
            return this.mFile.isDirectory();
        }

        public String getName() {
            return this.mFile.getName();
        }

        public FileInputStream getFileInputStream() throws IOException {
            return this.mFile.getFileInputStream();
        }

        public ZipUtils.AbstractFile[] listFiles() {
            VideoFile[] files = this.mFile.listFiles();
            if (files != null && files.length > 0) {
                VideoFileAdapter[] fileAdapters = new VideoFileAdapter[files.length];
                for (int i = 0; i < fileAdapters.length; i++) {
                    fileAdapters[i] = new VideoFileAdapter(files[i]);
                }
                return fileAdapters;
            }
            return null;
        }
    }
}