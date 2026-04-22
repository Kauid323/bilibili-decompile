package tv.danmaku.bili.downloadeshare.network;

import android.app.Application;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.freedata.util.TfTransformKt;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadShareFreeDataHelper.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005JT\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000528\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\u0012J\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/downloadeshare/network/DownloadShareFreeDataHelper;", "", "<init>", "()V", "TAG", "", "shouldProcessUrl", "", "processUrl", "resType", "Lcom/bilibili/fd_service/FreeDataManager$ResType;", "originUrl", "tryTransformedFreeDownloadUrl", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "downloadUrl", "callBack", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "isFree", "freeDownloadUrl", "isMobileNetWork", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareFreeDataHelper {
    public static final DownloadShareFreeDataHelper INSTANCE = new DownloadShareFreeDataHelper();
    private static final String TAG = "DownloadShareFreeDataHelper";

    private DownloadShareFreeDataHelper() {
    }

    public final boolean shouldProcessUrl() {
        return FreeDataManager.getInstance().isTf();
    }

    public final String processUrl(FreeDataManager.ResType resType, String originUrl) {
        Intrinsics.checkNotNullParameter(resType, "resType");
        Application context = BiliContext.application();
        if (context == null) {
            return null;
        }
        TfTransformResp result = FreeDataManager.getInstance().processUrl(context, resType, originUrl);
        Intrinsics.checkNotNullExpressionValue(result, "processUrl(...)");
        if (TfTransformKt.isSuccessful(result)) {
            String url = result.getUrl();
            if (url == null || url.length() == 0) {
                return null;
            }
            return Uri.parse(result.getUrl()).buildUpon().appendQueryParameter("free_traffic", "1").build().toString();
        }
        return null;
    }

    public final void tryTransformedFreeDownloadUrl(final FragmentActivity activity, final String downloadUrl, final Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callBack");
        if (shouldProcessUrl()) {
            Task.call(new Callable() { // from class: tv.danmaku.bili.downloadeshare.network.DownloadShareFreeDataHelper$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void tryTransformedFreeDownloadUrl$lambda$0;
                    tryTransformedFreeDownloadUrl$lambda$0 = DownloadShareFreeDataHelper.tryTransformedFreeDownloadUrl$lambda$0(downloadUrl, activity, function2);
                    return tryTransformedFreeDownloadUrl$lambda$0;
                }
            }, Task.BACKGROUND_EXECUTOR);
            return;
        }
        BLog.w(TAG, "transformed free download url fail");
        function2.invoke(false, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void tryTransformedFreeDownloadUrl$lambda$0(String $downloadUrl, FragmentActivity $activity, final Function2 $callBack) {
        final String formedUrl = INSTANCE.processUrl(FreeDataManager.ResType.RES_VIDEO, $downloadUrl);
        if ($activity == null || $activity.isFinishing() || $activity.isDestroyed()) {
            BLog.w(TAG, "The Activity is invalid after transformed free DownloadUrl");
            return null;
        }
        String str = formedUrl;
        if (str == null || StringsKt.isBlank(str)) {
            BLog.w(TAG, "transformed free download url fail");
        }
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.downloadeshare.network.DownloadShareFreeDataHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadShareFreeDataHelper.tryTransformedFreeDownloadUrl$lambda$0$0($callBack, formedUrl);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryTransformedFreeDownloadUrl$lambda$0$0(Function2 $callBack, String $formedUrl) {
        $callBack.invoke(true, $formedUrl);
    }

    public final boolean isMobileNetWork() {
        return ConnectivityMonitor.getInstance().getNetworkWithoutCache() == 2;
    }
}