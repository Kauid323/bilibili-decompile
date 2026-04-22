package tv.danmaku.bili.splash.ad.page.component;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.state.actions.SplashRealReadyAction;

/* compiled from: PrepareComponent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "prepareSplash", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "needPrepare", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PrepareComponentKt {
    private static final String TAG = "[Splash]PrepareComponent";

    public static final void prepareSplash(BaseSplash $this$prepareSplash) {
        Intrinsics.checkNotNullParameter($this$prepareSplash, "<this>");
        if (needPrepare($this$prepareSplash)) {
            $this$prepareSplash.getComponentHolder$adsplash_debug().setPrepareJob(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$prepareSplash), (CoroutineContext) null, (CoroutineStart) null, new PrepareComponentKt$prepareSplash$1($this$prepareSplash, null), 3, (Object) null));
            return;
        }
        $this$prepareSplash.getViewModel$adsplash_debug().update(new SplashRealReadyAction("render_start"));
        ISplashEvent.CC.onSplashReady$default($this$prepareSplash, false, 1, null);
    }

    public static final boolean needPrepare(BaseSplash $this$needPrepare) {
        Intrinsics.checkNotNullParameter($this$needPrepare, "<this>");
        return ExtSplashOrderKt.getNeedPrepare($this$needPrepare.getSplash$adsplash_debug()) && !$this$needPrepare.getComponentHolder$adsplash_debug().isReady();
    }
}