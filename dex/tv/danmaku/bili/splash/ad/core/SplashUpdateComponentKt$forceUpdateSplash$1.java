package tv.danmaku.bili.splash.ad.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashUpdateComponent.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt", f = "SplashUpdateComponent.kt", i = {0, 0, 0, 0, 1, 1}, l = {BR.followBackDrawable, BR.followDesc}, m = "forceUpdateSplash", n = {"openEvent", "localData", "newData", "mergeList", "openEvent", "newData"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"}, v = 1)
public final class SplashUpdateComponentKt$forceUpdateSplash$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplashUpdateComponentKt$forceUpdateSplash$1(Continuation<? super SplashUpdateComponentKt$forceUpdateSplash$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object forceUpdateSplash;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        forceUpdateSplash = SplashUpdateComponentKt.forceUpdateSplash(null, (Continuation) this);
        return forceUpdateSplash;
    }
}