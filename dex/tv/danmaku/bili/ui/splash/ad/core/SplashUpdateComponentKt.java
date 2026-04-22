package tv.danmaku.bili.ui.splash.ad.core;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashUpdateComponent.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"TAG", "", "observerAppVisibleChange", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashUpdateComponentKt {
    private static final String TAG = "[Splash]SplashUpdateComponent";

    public static final void observerAppVisibleChange() {
        if (SplashConfigKt.getSplashUpdateListWhenEnterBackground()) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashUpdateComponentKt$observerAppVisibleChange$1(null), 3, (Object) null);
        }
    }
}