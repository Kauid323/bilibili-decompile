package tv.danmaku.bili.components;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeStatusBarComponent.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.components.HomeStatusBarComponentKt", f = "HomeStatusBarComponent.kt", i = {0}, l = {BR.contentAlpha}, m = "enterFullscreen", n = {"$this$enterFullscreen"}, s = {"L$0"}, v = 1)
public final class HomeStatusBarComponentKt$enterFullscreen$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeStatusBarComponentKt$enterFullscreen$1(Continuation<? super HomeStatusBarComponentKt$enterFullscreen$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object enterFullscreen;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        enterFullscreen = HomeStatusBarComponentKt.enterFullscreen(null, (Continuation) this);
        return enterFullscreen;
    }
}