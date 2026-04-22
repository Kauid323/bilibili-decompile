package tv.danmaku.bili.splash.ad.page.component;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashDanmaku;
import tv.danmaku.bili.splash.ad.model.SplashTopViewType;
import tv.danmaku.bili.splash.ad.page.BaseSplash;

/* compiled from: DanmakuComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"initDanmakuView", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DanmakuComponentKt {
    public static final void initDanmakuView(BaseSplash $this$initDanmakuView) {
        Intrinsics.checkNotNullParameter($this$initDanmakuView, "<this>");
        List<SplashDanmaku> danmukus = $this$initDanmakuView.getSplash$adsplash_debug().getDanmukus();
        if ((danmukus == null || danmukus.isEmpty()) || $this$initDanmakuView.getSplash$adsplash_debug().getTopViewType() != SplashTopViewType.LAUNCH_DANMAKU.getType()) {
            return;
        }
        Ref.ObjectRef danmakuView = new Ref.ObjectRef();
        LifecycleOwner viewLifecycleOwner = $this$initDanmakuView.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DanmakuComponentKt$initDanmakuView$1($this$initDanmakuView, danmakuView, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = $this$initDanmakuView.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new DanmakuComponentKt$initDanmakuView$2($this$initDanmakuView, danmakuView, null), 3, (Object) null);
    }
}