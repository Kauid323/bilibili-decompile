package tv.danmaku.bili.ui.splash.ad.component;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.ad.page.FullImageSplash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: StateObserverComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"observerOnViewCreated", "", "Ltv/danmaku/bili/ui/splash/ad/page/BaseSplash;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StateObserverComponentKt {
    public static final void observerOnViewCreated(BaseSplash $this$observerOnViewCreated) {
        Intrinsics.checkNotNullParameter($this$observerOnViewCreated, "<this>");
        PlayerStateComponentKt.observerPlayerState($this$observerOnViewCreated);
        if ($this$observerOnViewCreated instanceof FullImageSplash) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerOnViewCreated), (CoroutineContext) null, (CoroutineStart) null, new StateObserverComponentKt$observerOnViewCreated$1($this$observerOnViewCreated, null), 3, (Object) null);
            AlphaEggLayerComponentKt.observerSplashLinkageAnimationState((FullImageSplash) $this$observerOnViewCreated);
        }
    }
}