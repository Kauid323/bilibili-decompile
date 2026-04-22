package tv.danmaku.bili.ui.splash.ad.component;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashDanmaku;
import tv.danmaku.bili.ui.splash.ad.model.SplashTopViewType;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"initDanmakuView", "", "Ltv/danmaku/bili/ui/splash/ad/page/BaseSplash;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuComponentKt {
    public static final void initDanmakuView(BaseSplash $this$initDanmakuView) {
        SplashViewModel viewModel;
        Intrinsics.checkNotNullParameter($this$initDanmakuView, "<this>");
        Splash splash = $this$initDanmakuView.getSplash();
        if (splash == null) {
            return;
        }
        List<SplashDanmaku> list = splash.danmukus;
        if ((list == null || list.isEmpty()) || splash.topViewType != SplashTopViewType.LAUNCH_DANMAKU.getType() || (viewModel = $this$initDanmakuView.mSplashViewModel) == null) {
            return;
        }
        Ref.ObjectRef danmakuView = new Ref.ObjectRef();
        LifecycleOwner viewLifecycleOwner = $this$initDanmakuView.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DanmakuComponentKt$initDanmakuView$1(viewModel, $this$initDanmakuView, danmakuView, splash, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = $this$initDanmakuView.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new DanmakuComponentKt$initDanmakuView$2(viewModel, danmakuView, null), 3, (Object) null);
    }
}