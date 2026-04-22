package tv.danmaku.bili.ui.splash.ad.chronos;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashChronosView.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.chronos.SplashChronosViewKt", f = "SplashChronosView.kt", i = {0, 0, 0, 0}, l = {78}, m = "tryCreateSplashChronosView", n = {"context", "packageMd5", "coldStart", "startTime"}, s = {"L$0", "L$1", "Z$0", "J$0"}, v = 1)
public final class SplashChronosViewKt$tryCreateSplashChronosView$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplashChronosViewKt$tryCreateSplashChronosView$1(Continuation<? super SplashChronosViewKt$tryCreateSplashChronosView$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplashChronosViewKt.tryCreateSplashChronosView(null, false, (Continuation) this);
    }
}