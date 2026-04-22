package tv.danmaku.bili.splash.ad.page.component;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.BaseSplash;

/* compiled from: PlayerStateComponent.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"observerPlayerState", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "handleRenderStart", "TAG", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PlayerStateComponentKt {
    private static final String TAG = "[Splash]PlayerStateComponent";

    public static final void observerPlayerState(BaseSplash $this$observerPlayerState) {
        Intrinsics.checkNotNullParameter($this$observerPlayerState, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerPlayerState), (CoroutineContext) null, (CoroutineStart) null, new PlayerStateComponentKt$observerPlayerState$1($this$observerPlayerState, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRenderStart(BaseSplash $this$handleRenderStart) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$handleRenderStart), Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new PlayerStateComponentKt$handleRenderStart$1($this$handleRenderStart, null), 2, (Object) null);
    }
}