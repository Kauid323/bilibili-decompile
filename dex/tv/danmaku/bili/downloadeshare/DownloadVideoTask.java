package tv.danmaku.bili.downloadeshare;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import bili.resource.share.R;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.downloadshare.DownloadHelper;
import com.bilibili.lib.downloadshare.EventListener;
import com.bilibili.lib.downloadshare.IDownloadListener;
import com.bilibili.lib.downloadshare.IDownloadRequest;
import com.bilibili.lib.downloadshare.SimpleDownloader;
import com.bilibili.lib.downloadshare.SimpleMD5Verifier;
import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.network.DownloadShareFreeDataHelper;
import tv.danmaku.bili.downloadeshare.panel.DefaultDownloadVideoPanel;
import tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel;
import tv.danmaku.bili.downloadeshare.panel.UgcDownloadVideoPanel;
import tv.danmaku.bili.downloadeshare.report.DownloadShareReporter;
import tv.danmaku.bili.downloadeshare.utils.DownloadShareHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadVideoTask.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J6\u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0002J \u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0003H\u0002J8\u0010\"\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020\u001d2\b\b\u0002\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0015H\u0002J\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadVideoTask;", "Ltv/danmaku/bili/downloadeshare/AbstractDownloadShareTask;", "panelType", "", "<init>", "(I)V", "getPanelType", "()I", "value", "Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel;", "mDownloadPanel", "getMDownloadPanel", "()Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel;", "mDownloadRequest", "Lcom/bilibili/lib/downloadshare/IDownloadRequest;", "mStartTime", "", "isSilentDownload", "", "mVideoSize", "run", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "startDownload", "downloadContext", "downloadUrl", "", "isBackup", "backupCode", "tryDownloadBackup", "errorCode", "trackShareDownload", "backupState", "errorDomain", "errorMsg", "isActive", SplashCustomReporterKt.STATE_CANCEL, "cancelDownloadTask", "cancelWithoutDownloadRequest", "doSilentDownload", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadVideoTask extends AbstractDownloadShareTask {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "Download_Share_DownloadVideoTask";
    private boolean isSilentDownload;
    private DownloadVideoPanel mDownloadPanel;
    private IDownloadRequest mDownloadRequest;
    private long mStartTime;
    private long mVideoSize;
    private final int panelType;

    /* compiled from: DownloadVideoTask.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadVideoTask$Companion;", "", "<init>", "()V", "TAG", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DownloadVideoTask(int panelType) {
        this.panelType = panelType;
    }

    public final int getPanelType() {
        return this.panelType;
    }

    public final DownloadVideoPanel getMDownloadPanel() {
        return this.mDownloadPanel;
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask
    public void run(final FragmentActivity activity, final DownloadShareContext context) {
        UgcDownloadVideoPanel ugcDownloadVideoPanel;
        DownloadShareInfo downloadInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        if (activity == null) {
            return;
        }
        DownloadShareInfo downloadInfo2 = context.getDownloadInfo();
        String downloadUrl = downloadInfo2 != null ? downloadInfo2.getDownloadUrl() : null;
        if (downloadUrl == null || StringsKt.isBlank(downloadUrl)) {
            DownloadShareInfo downloadInfo3 = context.getDownloadInfo();
            String backupDownloadUrl = downloadInfo3 != null ? downloadInfo3.getBackupDownloadUrl() : null;
            if (!(backupDownloadUrl == null || StringsKt.isBlank(backupDownloadUrl)) && (downloadInfo = context.getDownloadInfo()) != null) {
                DownloadShareInfo downloadInfo4 = context.getDownloadInfo();
                downloadInfo.setDownloadUrl(downloadInfo4 != null ? downloadInfo4.getBackupDownloadUrl() : null);
            }
        }
        if (DownloadHelper.INSTANCE.isDownloadTaskRunning()) {
            Application application = BiliContext.application();
            String msg = application != null ? application.getString(R.string.share_global_string_24) : null;
            BLog.i(TAG, ": Wait for the last video to be finished.");
            ToastHelper.showToast((Context) activity, msg, 0, 17);
            return;
        }
        DownloadHelper.INSTANCE.setDownloadTaskRunning(true);
        switch (this.panelType) {
            case 0:
                ugcDownloadVideoPanel = new UgcDownloadVideoPanel((Context) activity);
                break;
            case 1:
                ugcDownloadVideoPanel = new DefaultDownloadVideoPanel((Context) activity);
                break;
            default:
                ugcDownloadVideoPanel = new DefaultDownloadVideoPanel((Context) activity);
                break;
        }
        this.mDownloadPanel = ugcDownloadVideoPanel;
        DownloadShareInfo downloadInfo5 = context.getDownloadInfo();
        this.mVideoSize = downloadInfo5 != null ? downloadInfo5.getSize() : 0L;
        DownloadVideoPanel downloadVideoPanel = this.mDownloadPanel;
        if (downloadVideoPanel != null) {
            DownloadShareInfo downloadInfo6 = context.getDownloadInfo();
            Intrinsics.checkNotNull(downloadInfo6);
            downloadVideoPanel.show(downloadInfo6, context.getParameter(), new DownloadVideoPanel.DownloadStateChangeListener() { // from class: tv.danmaku.bili.downloadeshare.DownloadVideoTask$run$1
                @Override // tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel.DownloadStateChangeListener
                public void onSilentDownload() {
                    DownloadVideoTask.this.isSilentDownload = true;
                    BLog.i(DownloadVideoTask.TAG, ": Start silent download.");
                }

                @Override // tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel.DownloadStateChangeListener
                public void onDownloadCanceled() {
                    long j;
                    Context context2 = activity;
                    Application application2 = BiliContext.application();
                    ToastHelper.showToast(context2, application2 != null ? application2.getString(R.string.share_global_string_52) : null, 0, 17);
                    BLog.i(DownloadVideoTask.TAG, ": Download Canceled.");
                    DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
                    String valueOf = String.valueOf(context.getParameter().getAvid());
                    j = DownloadVideoTask.this.mVideoSize;
                    String valueOf2 = String.valueOf(j);
                    String shareId = context.getParameter().getShareId();
                    if (shareId == null) {
                        shareId = "";
                    }
                    String shareOrigin = context.getParameter().getShareOrigin();
                    downloadShareReporter.reportDownloadVideoDialogCloseClick(valueOf, valueOf2, shareId, shareOrigin != null ? shareOrigin : "");
                    DownloadVideoTask.this.cancel();
                }
            });
        }
        DownloadShareInfo downloadInfo7 = context.getDownloadInfo();
        String downloadUrl2 = downloadInfo7 != null ? downloadInfo7.getDownloadUrl() : null;
        Intrinsics.checkNotNull(downloadUrl2);
        startDownload$default(this, activity, context, downloadUrl2, false, 0, 24, null);
    }

    static /* synthetic */ void startDownload$default(DownloadVideoTask downloadVideoTask, FragmentActivity fragmentActivity, DownloadShareContext downloadShareContext, String str, boolean z, int i, int i2, Object obj) {
        boolean z2;
        int i3;
        if ((i2 & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        if ((i2 & 16) == 0) {
            i3 = i;
        } else {
            i3 = -1;
        }
        downloadVideoTask.startDownload(fragmentActivity, downloadShareContext, str, z2, i3);
    }

    private final void startDownload(final FragmentActivity activity, final DownloadShareContext downloadContext, final String downloadUrl, final boolean isBackup, final int backupCode) {
        final DownloadShareInfo downloadInfo;
        IDownloadRequest iDownloadRequest;
        IDownloadRequest iDownloadRequest2;
        BLog.i(TAG, ": Start download.");
        if (activity == null || (downloadInfo = downloadContext.getDownloadInfo()) == null) {
            return;
        }
        if (StringsKt.isBlank(downloadUrl)) {
            if (!isBackup) {
                tryDownloadBackup(activity, downloadContext, 10000);
                return;
            }
            Application application = BiliContext.application();
            String msg = application != null ? application.getString(R.string.share_global_string_50) : null;
            ToastHelper.showToast((Context) activity, msg, 0, 17);
            trackShareDownload$default(this, downloadContext, String.valueOf(backupCode), "10000", null, null, 24, null);
            cancel();
            return;
        }
        if (this.mDownloadRequest != null && (iDownloadRequest2 = this.mDownloadRequest) != null) {
            iDownloadRequest2.cancel();
        }
        this.mDownloadRequest = SimpleDownloader.Companion.with((Context) activity, downloadUrl);
        if (!TextUtils.isEmpty(downloadInfo.getMd5()) && (iDownloadRequest = this.mDownloadRequest) != null) {
            String md5 = downloadInfo.getMd5();
            Intrinsics.checkNotNull(md5);
            iDownloadRequest.setVerifier(new SimpleMD5Verifier(md5));
        }
        IDownloadRequest iDownloadRequest3 = this.mDownloadRequest;
        if (iDownloadRequest3 != null) {
            iDownloadRequest3.setMoveToMediaStoreOnSuccess(true);
        }
        IDownloadRequest iDownloadRequest4 = this.mDownloadRequest;
        if (iDownloadRequest4 != null) {
            iDownloadRequest4.setDeleteDestFileOnFailure(true);
        }
        IDownloadRequest iDownloadRequest5 = this.mDownloadRequest;
        if (iDownloadRequest5 != null) {
            iDownloadRequest5.enableDownloadOnNetworkChange(true);
        }
        IDownloadRequest iDownloadRequest6 = this.mDownloadRequest;
        if (iDownloadRequest6 != null) {
            iDownloadRequest6.setNotifyInterval(0L);
        }
        IDownloadRequest iDownloadRequest7 = this.mDownloadRequest;
        if (iDownloadRequest7 != null) {
            iDownloadRequest7.setDownloadListener(new IDownloadListener() { // from class: tv.danmaku.bili.downloadeshare.DownloadVideoTask$startDownload$1
                private int mProgress = -1;

                public final int getMProgress() {
                    return this.mProgress;
                }

                public final void setMProgress(int i) {
                    this.mProgress = i;
                }

                public boolean isCanceled() {
                    return false;
                }

                public void onFailed(IDownloadRequest request, int errorCode, String errorMessage) {
                    String backupState;
                    BLog.i(DownloadVideoTask.TAG, ": Download Failed.");
                    DownloadVideoTask.this.isSilentDownload = false;
                    if (errorCode == 1201) {
                        return;
                    }
                    if (!isBackup && !TextUtils.isEmpty(downloadInfo.getBackupDownloadUrl()) && this.mProgress <= 0 && !TextUtils.equals(downloadUrl, downloadInfo.getBackupDownloadUrl()) && errorCode != 1202 && errorCode != 1001 && errorCode != 1201) {
                        DownloadVideoTask.this.tryDownloadBackup(activity, downloadContext, errorCode);
                        return;
                    }
                    Application application2 = BiliContext.application();
                    String msg2 = application2 != null ? application2.getString(R.string.share_global_string_50) : null;
                    ToastHelper.showToast(activity, msg2, 0, 17);
                    if (isBackup) {
                        backupState = String.valueOf(backupCode);
                    } else {
                        backupState = "0";
                    }
                    DownloadVideoTask.this.trackShareDownload(downloadContext, backupState, String.valueOf(errorCode), "", errorMessage == null ? "" : errorMessage);
                    DownloadVideoTask.this.cancel();
                }

                public void onComplete(IDownloadRequest request) {
                    boolean z;
                    long j;
                    long j2;
                    String backupState;
                    z = DownloadVideoTask.this.isSilentDownload;
                    if (z) {
                        BLog.i(DownloadVideoTask.TAG, ": Silent download completed.");
                        Application application2 = BiliContext.application();
                        Application application3 = BiliContext.application();
                        ToastHelper.showToast(application2, application3 != null ? application3.getString(R.string.share_global_string_37) : null, 0, 17);
                    } else {
                        BLog.i(DownloadVideoTask.TAG, ": Download completed.");
                        DownloadShareHelper.INSTANCE.vibrate((Context) activity, 30L, BR.hallCover);
                        DownloadVideoTask.this.isSilentDownload = false;
                        if (DownloadVideoTask.this.isActive()) {
                            if (DownloadVideoTask.this.getPanelType() == 0) {
                                DownloadVideoPanel mDownloadPanel = DownloadVideoTask.this.getMDownloadPanel();
                                UgcDownloadVideoPanel ugcDownloadVideoPanel = mDownloadPanel instanceof UgcDownloadVideoPanel ? (UgcDownloadVideoPanel) mDownloadPanel : null;
                                if (ugcDownloadVideoPanel != null) {
                                    UgcDownloadVideoPanel panel = ugcDownloadVideoPanel;
                                    panel.showSharePanel();
                                }
                                DownloadVideoTask.this.cancelDownloadTask();
                            } else {
                                DownloadVideoTask.this.toNext(activity, downloadContext);
                                DownloadVideoTask.this.cancel();
                            }
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    j = DownloadVideoTask.this.mStartTime;
                    long time = (currentTimeMillis - j) / 1000;
                    DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
                    String valueOf = String.valueOf(downloadContext.getParameter().getAvid());
                    j2 = DownloadVideoTask.this.mVideoSize;
                    String valueOf2 = String.valueOf(j2);
                    String valueOf3 = String.valueOf(time);
                    String shareId = downloadContext.getParameter().getShareId();
                    if (shareId == null) {
                        shareId = "";
                    }
                    String shareOrigin = downloadContext.getParameter().getShareOrigin();
                    downloadShareReporter.reportDownloadVideoEnd(valueOf, valueOf2, valueOf3, shareId, shareOrigin != null ? shareOrigin : "", downloadContext.getParameter().getSpmid(), downloadContext.getParameter().getObjectExtraFields());
                    if (isBackup) {
                        backupState = String.valueOf(backupCode);
                    } else {
                        backupState = "0";
                    }
                    DownloadVideoTask.trackShareDownload$default(DownloadVideoTask.this, downloadContext, backupState, null, null, null, 28, null);
                }

                public void onProgress(IDownloadRequest request, long totalBytes, long downloadedBytes, int progress, long bytesPerSecond) {
                    DownloadVideoPanel mDownloadPanel;
                    if (progress != this.mProgress && (mDownloadPanel = DownloadVideoTask.this.getMDownloadPanel()) != null) {
                        mDownloadPanel.setProgress(progress);
                    }
                    this.mProgress = progress;
                }
            });
        }
        IDownloadRequest iDownloadRequest8 = this.mDownloadRequest;
        if (iDownloadRequest8 != null) {
            iDownloadRequest8.setEventListener(new EventListener() { // from class: tv.danmaku.bili.downloadeshare.DownloadVideoTask$startDownload$2
                public void onWifiChangeToMobileData() {
                    if (DownloadShareContext.this.getParameter().getShowMobileToast()) {
                        BLog.i(DownloadVideoTask.TAG, ": Wifi change to mobile data.");
                        Application application2 = BiliContext.application();
                        String message = application2 != null ? application2.getString(R.string.share_global_string_21) : null;
                        ToastHelper.showToast(BiliContext.application(), message, 0, 17);
                    }
                }
            });
        }
        DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
        String valueOf = String.valueOf(downloadContext.getParameter().getAvid());
        String valueOf2 = String.valueOf(this.mVideoSize);
        String shareId = downloadContext.getParameter().getShareId();
        String str = shareId == null ? "" : shareId;
        String shareOrigin = downloadContext.getParameter().getShareOrigin();
        downloadShareReporter.reportDownloadVideoBegin(valueOf, valueOf2, str, shareOrigin == null ? "" : shareOrigin, downloadContext.getParameter().getSpmid(), downloadContext.getParameter().getObjectExtraFields());
        this.mStartTime = System.currentTimeMillis();
        IDownloadRequest iDownloadRequest9 = this.mDownloadRequest;
        if (iDownloadRequest9 != null) {
            iDownloadRequest9.enqueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryDownloadBackup(final FragmentActivity activity, final DownloadShareContext downloadContext, final int errorCode) {
        IDownloadRequest iDownloadRequest = this.mDownloadRequest;
        if (iDownloadRequest != null) {
            iDownloadRequest.cancel();
        }
        this.mDownloadRequest = null;
        BLog.i(TAG, ": Try with backup url.");
        DownloadShareInfo downloadInfo = downloadContext.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        final Ref.ObjectRef backupUrl = new Ref.ObjectRef();
        backupUrl.element = downloadInfo.getBackupDownloadUrl();
        if (DownloadShareFreeDataHelper.INSTANCE.shouldProcessUrl()) {
            Task.call(new Callable() { // from class: tv.danmaku.bili.downloadeshare.DownloadVideoTask$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void tryDownloadBackup$lambda$0;
                    tryDownloadBackup$lambda$0 = DownloadVideoTask.tryDownloadBackup$lambda$0(activity, backupUrl, this, downloadContext, errorCode);
                    return tryDownloadBackup$lambda$0;
                }
            }, Task.BACKGROUND_EXECUTOR);
            return;
        }
        Object obj = backupUrl.element;
        Intrinsics.checkNotNull(obj);
        startDownload(activity, downloadContext, (String) obj, true, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void tryDownloadBackup$lambda$0(final FragmentActivity $activity, final Ref.ObjectRef $backupUrl, final DownloadVideoTask this$0, final DownloadShareContext $downloadContext, final int $errorCode) {
        if (!$activity.isFinishing() && !$activity.isDestroyed()) {
            String processedUrl = DownloadShareFreeDataHelper.INSTANCE.processUrl(FreeDataManager.ResType.RES_VIDEO, (String) $backupUrl.element);
            if (!TextUtils.isEmpty(processedUrl)) {
                $backupUrl.element = processedUrl;
            }
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.downloadeshare.DownloadVideoTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadVideoTask.tryDownloadBackup$lambda$0$0(DownloadVideoTask.this, $activity, $downloadContext, $backupUrl, $errorCode);
                }
            });
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryDownloadBackup$lambda$0$0(DownloadVideoTask this$0, FragmentActivity $activity, DownloadShareContext $downloadContext, Ref.ObjectRef $backupUrl, int $errorCode) {
        Object obj = $backupUrl.element;
        Intrinsics.checkNotNull(obj);
        this$0.startDownload($activity, $downloadContext, (String) obj, true, $errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void trackShareDownload$default(DownloadVideoTask downloadVideoTask, DownloadShareContext downloadShareContext, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "0";
        }
        downloadVideoTask.trackShareDownload(downloadShareContext, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackShareDownload(DownloadShareContext downloadContext, String backupState, String errorCode, String errorDomain, String errorMsg) {
        long time = (System.currentTimeMillis() - this.mStartTime) / 1000;
        DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
        DownloadShareInfo downloadInfo = downloadContext.getDownloadInfo();
        String str = (downloadInfo == null || (str = downloadInfo.getDownloadUrl()) == null) ? "" : "";
        DownloadShareInfo downloadInfo2 = downloadContext.getDownloadInfo();
        String str2 = (downloadInfo2 == null || (str2 = downloadInfo2.getBackupDownloadUrl()) == null) ? "" : "";
        DownloadShareInfo downloadInfo3 = downloadContext.getDownloadInfo();
        String str3 = (downloadInfo3 == null || (str3 = downloadInfo3.getMd5()) == null) ? "" : "";
        DownloadShareInfo downloadInfo4 = downloadContext.getDownloadInfo();
        downloadShareReporter.trackDownloadShare(str, str2, str3, (downloadInfo4 == null || (r8 = String.valueOf(downloadInfo4.getSize())) == null) ? "" : "", backupState, String.valueOf(time), errorCode, errorDomain, errorMsg);
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public boolean isActive() {
        if (super.isActive() || this.mDownloadRequest != null) {
            return true;
        }
        DownloadVideoPanel downloadVideoPanel = this.mDownloadPanel;
        return downloadVideoPanel != null && downloadVideoPanel.isShowing();
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void cancel() {
        DownloadVideoPanel downloadVideoPanel;
        super.cancel();
        BLog.i(TAG, ": Cancel.");
        IDownloadRequest iDownloadRequest = this.mDownloadRequest;
        if (iDownloadRequest != null) {
            iDownloadRequest.cancel();
        }
        this.mDownloadRequest = null;
        DownloadVideoPanel panel = this.mDownloadPanel;
        if (panel != null && panel.isShowing() && (downloadVideoPanel = this.mDownloadPanel) != null) {
            downloadVideoPanel.dismiss();
        }
        this.mDownloadPanel = null;
        DownloadHelper.INSTANCE.setDownloadTaskRunning(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelDownloadTask() {
        BLog.i(TAG, ": Cancel download task.");
        IDownloadRequest iDownloadRequest = this.mDownloadRequest;
        if (iDownloadRequest != null) {
            iDownloadRequest.cancel();
        }
        this.mDownloadRequest = null;
        DownloadHelper.INSTANCE.setDownloadTaskRunning(false);
    }

    public final void cancelWithoutDownloadRequest() {
        DownloadVideoPanel downloadVideoPanel;
        BLog.i(TAG, ": Cancel without download reques.");
        super.cancel();
        DownloadVideoPanel panel = this.mDownloadPanel;
        if (panel != null && panel.isShowing() && (downloadVideoPanel = this.mDownloadPanel) != null) {
            downloadVideoPanel.dismiss();
        }
        this.mDownloadRequest = null;
        this.mDownloadPanel = null;
    }

    public final void doSilentDownload() {
        if (this.mDownloadRequest == null) {
            cancel();
            return;
        }
        BLog.i(TAG, ": Start silent download.");
        DownloadVideoPanel downloadVideoPanel = this.mDownloadPanel;
        if (downloadVideoPanel != null) {
            downloadVideoPanel.dismiss();
        }
        this.isSilentDownload = true;
    }
}