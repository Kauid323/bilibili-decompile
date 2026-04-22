package tv.danmaku.bili.downloadeshare;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.network.DownloadShareFreeDataHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;

/* compiled from: NetworkTask.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/downloadeshare/NetworkTask;", "Ltv/danmaku/bili/downloadeshare/AbstractDownloadShareTask;", "<init>", "()V", "mTipDialog", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog;", "run", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "onMobileNetworkHandler", "isActive", "", SplashCustomReporterKt.STATE_CANCEL, "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetworkTask extends AbstractDownloadShareTask {
    public static final Companion Companion = new Companion(null);
    private static final int MOBILE_NETWORK_CLICK_LIMIT_TIMES = 3;
    private static final String TAG = "Download_Share_NetworkTask";
    private BiliCommonDialog mTipDialog;

    /* compiled from: NetworkTask.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/downloadeshare/NetworkTask$Companion;", "", "<init>", "()V", "TAG", "", "MOBILE_NETWORK_CLICK_LIMIT_TIMES", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask
    public void run(FragmentActivity activity, DownloadShareContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (DownloadShareFreeDataHelper.INSTANCE.isMobileNetWork()) {
            BLog.i(TAG, ": Mobile net work.");
            onMobileNetworkHandler(activity, context);
            return;
        }
        BLog.i(TAG, ": Wifi.");
        toNext(activity, context);
    }

    private final void onMobileNetworkHandler(final FragmentActivity activity, final DownloadShareContext context) {
        DownloadShareInfo downloadInfo = context.getDownloadInfo();
        final String downloadUrl = downloadInfo != null ? downloadInfo.getDownloadUrl() : null;
        DownloadShareInfo downloadInfo2 = context.getDownloadInfo();
        String backupDownloadUrl = downloadInfo2 != null ? downloadInfo2.getBackupDownloadUrl() : null;
        String str = downloadUrl;
        DownloadShareFreeDataHelper.INSTANCE.tryTransformedFreeDownloadUrl(activity, str == null || StringsKt.isBlank(str) ? backupDownloadUrl : downloadUrl, new Function2() { // from class: tv.danmaku.bili.downloadeshare.NetworkTask$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onMobileNetworkHandler$lambda$0;
                onMobileNetworkHandler$lambda$0 = NetworkTask.onMobileNetworkHandler$lambda$0(NetworkTask.this, activity, context, downloadUrl, ((Boolean) obj).booleanValue(), (String) obj2);
                return onMobileNetworkHandler$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMobileNetworkHandler$lambda$0(NetworkTask this$0, FragmentActivity $activity, DownloadShareContext $context, String $downloadUrl, boolean isFree, String freeDownloadUrl) {
        if (isFree) {
            String str = freeDownloadUrl;
            boolean z = false;
            if (!(str == null || StringsKt.isBlank(str))) {
                BLog.i(TAG, ": Free.");
                String str2 = $downloadUrl;
                if (str2 == null || StringsKt.isBlank(str2)) {
                    z = true;
                }
                if (z) {
                    DownloadShareInfo downloadInfo = $context.getDownloadInfo();
                    if (downloadInfo != null) {
                        downloadInfo.setBackupDownloadUrl(freeDownloadUrl);
                    }
                } else {
                    DownloadShareInfo downloadInfo2 = $context.getDownloadInfo();
                    if (downloadInfo2 != null) {
                        downloadInfo2.setDownloadUrl(freeDownloadUrl);
                    }
                }
                this$0.toNext($activity, $context);
                return Unit.INSTANCE;
            }
        }
        BLog.i(TAG, ": Not Free.");
        this$0.toNext($activity, $context);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public boolean isActive() {
        Dialog dialog;
        if (super.isActive()) {
            return true;
        }
        BiliCommonDialog biliCommonDialog = this.mTipDialog;
        return biliCommonDialog != null && (dialog = biliCommonDialog.getDialog()) != null && dialog.isShowing();
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void cancel() {
        BLog.i(TAG, ": Cancel.");
        BiliCommonDialog biliCommonDialog = this.mTipDialog;
        if (biliCommonDialog != null) {
            biliCommonDialog.dismiss();
        }
        this.mTipDialog = null;
    }
}