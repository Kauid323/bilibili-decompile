package tv.danmaku.bili.downloadeshare;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import bili.resource.share.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.downloadshare.api.DownloadShareApiService;
import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadInfoTask.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadInfoTask;", "Ltv/danmaku/bili/downloadeshare/AbstractDownloadShareTask;", "<init>", "()V", "isWait", "", "run", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "showFailToast", "isActive", SplashCustomReporterKt.STATE_CANCEL, "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadInfoTask extends AbstractDownloadShareTask {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "Download_Share_DownloadInfoTask";
    private boolean isWait;

    /* compiled from: DownloadInfoTask.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadInfoTask$Companion;", "", "<init>", "()V", "TAG", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask
    public void run(final FragmentActivity activity, final DownloadShareContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DownloadShareParameter params = context.getParameter();
        Object createService = ServiceGenerator.createService(DownloadShareApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        DownloadShareApiService downloadShareApiService = (DownloadShareApiService) createService;
        String shareId = params.getShareId();
        String str = shareId == null ? "" : shareId;
        String shareOrigin = params.getShareOrigin();
        String str2 = shareOrigin == null ? "" : shareOrigin;
        long avid = params.getAvid();
        long cid = params.getCid();
        String spmid = context.getParameter().getSpmid();
        String objectExtraFields = params.getObjectExtraFields();
        BiliCall call = DownloadShareApiService.-CC.download$default(downloadShareApiService, str, str2, avid, cid, spmid, objectExtraFields == null ? "" : objectExtraFields, params.getPanelType(), (String) null, (String) null, (int) BR.negativeBtnVisible, (Object) null);
        this.isWait = true;
        BLog.i(TAG, ": Get download url.");
        call.enqueue(new BiliApiDataCallback<DownloadShareInfo>() { // from class: tv.danmaku.bili.downloadeshare.DownloadInfoTask$run$1
            public boolean isCancel() {
                return activity == null || activity.isFinishing() || activity.isDestroyed();
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
                if ((r1 == null || kotlin.text.StringsKt.isBlank(r1)) == false) goto L24;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onDataSuccess(DownloadShareInfo response) {
                context.setDownloadInfo(response);
                String downloadUrl = response != null ? response.getDownloadUrl() : null;
                boolean z = true;
                if (downloadUrl == null || StringsKt.isBlank(downloadUrl)) {
                    String backupDownloadUrl = response != null ? response.getBackupDownloadUrl() : null;
                }
                String md5 = response != null ? response.getMd5() : null;
                if (md5 != null && !StringsKt.isBlank(md5)) {
                    z = false;
                }
                if (!z) {
                    BLog.i(DownloadInfoTask.TAG, ": Get download url success.");
                    this.isWait = false;
                    this.toNext(activity, context);
                    return;
                }
                this.showFailToast(activity);
                this.cancel();
                BLog.i(DownloadInfoTask.TAG, ": Get download url fail: no data.");
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                BLog.i(DownloadInfoTask.TAG, ": Get download url fail.");
                this.showFailToast(activity);
                this.cancel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFailToast(FragmentActivity activity) {
        Application application = BiliContext.application();
        String msg = application != null ? application.getString(R.string.share_global_string_50) : null;
        if (isActive()) {
            ToastHelper.showToast((Context) activity, msg, 0, 17);
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public boolean isActive() {
        return super.isActive() || this.isWait;
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void cancel() {
        BLog.i(TAG, ": Cancel.");
        super.cancel();
        this.isWait = false;
    }
}