package tv.danmaku.bili.ui.splash.ad;

import com.bilibili.lib.performance.EntryPointKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.SplashOrderFilterReason;
import tv.danmaku.bili.ui.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: AdReporter.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aX\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0000¨\u0006\u0011"}, d2 = {"reportAd", "", "step", "", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "splashId", "", "index", "splashRequestId", "", "openEvent", "isRealShow", "", "reason", "Ltv/danmaku/bili/ui/splash/SplashOrderFilterReason;", PeakTaskDefine.AD_CB, "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AdReporterKt {
    public static /* synthetic */ void reportAd$default(int i, Splash splash, long j, int i2, String str, int i3, boolean z, SplashOrderFilterReason splashOrderFilterReason, String str2, int i4, Object obj) {
        String str3;
        if ((i4 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        reportAd(i, splash, j, i2, str, i3, z, splashOrderFilterReason, str3);
    }

    public static final void reportAd(int step, Splash splash, long splashId, int index, String splashRequestId, int openEvent, boolean isRealShow, SplashOrderFilterReason reason, String adCb) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (EntryPointKt.getBootOptEnable()) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AdReporterKt$reportAd$1(step, splash, splashId, index, splashRequestId, openEvent, isRealShow, reason, adCb, null), 3, (Object) null);
        } else {
            SplashAdHelper.reportSplashOrderSelectFilterEvent(step, splash, splashId, index, splashRequestId, openEvent, isRealShow, reason, adCb);
        }
    }
}