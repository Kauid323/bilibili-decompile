package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import bolts.CancellationToken;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.DisplaySizeHelper;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import tv.danmaku.bili.R;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper;
import video.base.utils.VBNumberExtKt;

public class SDExternalStorageTestActivity extends BaseToolbarActivity implements Handler.Callback {
    private static final int RESULT_CODE = 111;
    private static final int STEP_ADVICE = 4;
    private static final int STEP_INIT = 1;
    private static final int STEP_RESULT = 3;
    private static final int STEP_TEST = 2;
    private Handler mHandler;
    private TextView mTextAdvice;
    private TextView mTextAdviceContent;
    private TextView mTextInfoContent;
    private TextView mTextResult;
    private TextView mTextResultContent;
    private TextView mTextTest;
    private TextView mTextTestContent;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView() {
        setContentView(R.layout.bili_app_activity_sdexternalstorage_test);
        ensureToolbar();
        showBackButton();
        getToolbar().setTitle(bili.resource.downloads.R.string.downloads_global_string_11);
        this.mTextInfoContent = (TextView) findViewById(R.id.video_info_content);
        this.mTextTest = (TextView) findViewById(R.id.video_test);
        this.mTextTestContent = (TextView) findViewById(R.id.video_test_content);
        this.mTextResult = (TextView) findViewById(R.id.video_result);
        this.mTextResultContent = (TextView) findViewById(R.id.video_result_content);
        this.mTextAdvice = (TextView) findViewById(R.id.video_advice);
        this.mTextAdviceContent = (TextView) findViewById(R.id.video_advice_content);
        this.mHandler = new Handler(this);
        startTest();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == -1) {
            obtainPermission(true);
            return;
        }
        sendMessage(3, bili.resource.downloads.R.string.downloads_global_string_75);
        sendMessage(4, bili.resource.downloads.R.string.downloads_global_string_83);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startTest() {
        StorageHelper.Storage storage = StorageHelper.getSecondaryStorage(getApplicationContext());
        if (storage == null) {
            sendMessage(1, bili.resource.downloads.R.string.downloads_global_string_12);
        } else if (storage.getAvailableByte() < VBNumberExtKt.MB) {
            sendMessage(1, bili.resource.downloads.R.string.downloads_global_string_78);
        } else {
            sendMessage(1, getString(bili.resource.downloads.R.string.downloads_global_string_96, new Object[]{DisplaySizeHelper.byteCountToDisplaySize(storage.getTotalByte()), DisplaySizeHelper.byteCountToDisplaySize(storage.getAvailableByte())}));
            sendMessage(2, bili.resource.downloads.R.string.downloads_global_string_107);
            File file = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(this);
            DocumentProviderCompatHelper.obtainExternalPathStoragePermission((Activity) this, file.getAbsolutePath(), 111, new DocumentProviderCompatHelper.AuthorizedCallback() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.SDExternalStorageTestActivity.1
                @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.AuthorizedCallback
                public void onHasBeenAuthorized() {
                    SDExternalStorageTestActivity.this.obtainPermission(true);
                }

                @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.AuthorizedCallback
                public void onAuthorizeStartFail() {
                    SDExternalStorageTestActivity.this.obtainPermission(false);
                }

                @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.AuthorizedCallback
                public void onAuthorizedCancel() {
                    SDExternalStorageTestActivity.this.obtainPermission(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void obtainPermission(boolean flag) {
        if (flag) {
            final CancellationTokenSource tokenSource = new CancellationTokenSource();
            CancellationToken cancellationToken = tokenSource.getToken();
            Task.callInBackground(new Callable<Boolean>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.SDExternalStorageTestActivity.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    SDExternalStorageTestActivity.this.sendMessage(2, bili.resource.downloads.R.string.downloads_global_string_56);
                    Context context = SDExternalStorageTestActivity.this.getApplicationContext();
                    FileOutputStream outputStream = null;
                    try {
                        File file = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(context);
                        VideoFile videoFile = DocumentProviderCompatHelper.getVideoFileFromFile(context, file);
                        VideoFile testFile = VideoFile.fromVideoFile(videoFile, "test");
                        outputStream = testFile.getFileOutputStream();
                        IOUtils.write("{\"code\":0,\"msg\":\"\",\"message\":\"\",\"data\":[]}", outputStream, "UTF-8");
                        return true;
                    } catch (Exception e) {
                        LogHelper.printStackTrace(e);
                        return false;
                    } finally {
                        IOUtils.closeQuietly((InputStream) null);
                        IOUtils.closeQuietly(outputStream);
                    }
                }
            }).continueWith(new Continuation<Boolean, Boolean>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.SDExternalStorageTestActivity.3
                /* renamed from: then  reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1732then(Task task) throws Exception {
                    return then((Task<Boolean>) task);
                }

                public Boolean then(Task<Boolean> task) throws Exception {
                    Context context = SDExternalStorageTestActivity.this.getApplicationContext();
                    File file = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(context);
                    VideoFile videoFile = DocumentProviderCompatHelper.getVideoFileFromFile(context, file);
                    VideoFile testFile = VideoFile.fromVideoFile(videoFile, "test");
                    try {
                        if (task != null) {
                            try {
                                if (!task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
                                    SDExternalStorageTestActivity.this.sendMessage(2, bili.resource.downloads.R.string.downloads_global_string_114);
                                    FileInputStream inputStream = testFile.getFileInputStream();
                                    String text = IOUtils.toString(inputStream, "UTF-8");
                                    JSONObject jsonObject = new JSONObject(text);
                                    Boolean valueOf = Boolean.valueOf(jsonObject.getInt("code") == 0);
                                    if (testFile != null && testFile.exists()) {
                                        testFile.delete();
                                    }
                                    IOUtils.closeQuietly(inputStream);
                                    return valueOf;
                                }
                            } catch (Exception e) {
                                LogHelper.printStackTrace(e);
                                if (testFile != null && testFile.exists()) {
                                    testFile.delete();
                                }
                                IOUtils.closeQuietly((InputStream) null);
                                return false;
                            }
                        }
                        SDExternalStorageTestActivity.this.sendMessage(3, bili.resource.downloads.R.string.downloads_global_string_45);
                        SDExternalStorageTestActivity.this.sendMessage(4, bili.resource.downloads.R.string.downloads_global_string_108);
                        tokenSource.cancel();
                        if (testFile != null && testFile.exists()) {
                            testFile.delete();
                        }
                        IOUtils.closeQuietly((InputStream) null);
                        return false;
                    } catch (Throwable th) {
                        if (testFile != null && testFile.exists()) {
                            testFile.delete();
                        }
                        IOUtils.closeQuietly((InputStream) null);
                        throw th;
                    }
                }
            }).continueWith(new Continuation<Boolean, Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.SDExternalStorageTestActivity.2
                public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                    return m1731then((Task<Boolean>) task);
                }

                /* renamed from: then  reason: collision with other method in class */
                public Void m1731then(Task<Boolean> task) throws Exception {
                    if (task == null || task.isFaulted() || !((Boolean) task.getResult()).booleanValue()) {
                        SDExternalStorageTestActivity.this.sendMessage(3, bili.resource.downloads.R.string.downloads_global_string_66);
                        SDExternalStorageTestActivity.this.sendMessage(4, bili.resource.downloads.R.string.downloads_global_string_108);
                        return null;
                    }
                    SDExternalStorageTestActivity.this.sendMessage(3, bili.resource.downloads.R.string.downloads_global_string_87);
                    SDExternalStorageTestActivity.this.sendMessage(4, bili.resource.downloads.R.string.downloads_global_string_29);
                    return null;
                }
            }, cancellationToken);
            return;
        }
        sendMessage(3, bili.resource.downloads.R.string.downloads_global_string_75);
        sendMessage(4, bili.resource.downloads.R.string.downloads_global_string_69);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(int step, int contentId) {
        sendMessage(step, getString(contentId));
    }

    private void sendMessage(int step, String content) {
        Message msg = Message.obtain();
        msg.what = step;
        msg.obj = content;
        this.mHandler.sendMessageDelayed(msg, 350L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        String content = (String) msg.obj;
        switch (msg.what) {
            case 1:
                this.mTextInfoContent.setVisibility(0);
                this.mTextInfoContent.setText(content);
                return true;
            case 2:
                this.mTextTest.setVisibility(0);
                this.mTextTestContent.setVisibility(0);
                this.mTextTestContent.append(content);
                return true;
            case 3:
                this.mTextResult.setVisibility(0);
                this.mTextResultContent.setVisibility(0);
                this.mTextResultContent.setText(content);
                return true;
            case 4:
                this.mTextAdvice.setVisibility(0);
                this.mTextAdviceContent.setVisibility(0);
                this.mTextAdviceContent.setText(content);
                return true;
            default:
                return true;
        }
    }
}