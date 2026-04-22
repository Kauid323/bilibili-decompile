package tv.danmaku.bili.splash.ad.core;

import com.bilibili.lib.performance.BootOpt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashOrderSelectComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashOrderSelectComponentKt$requestRealShowSplashInner$1", f = "SplashOrderSelectComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashOrderSelectComponentKt$requestRealShowSplashInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashSource $source;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashOrderSelectComponentKt$requestRealShowSplashInner$1(SplashSource splashSource, Continuation<? super SplashOrderSelectComponentKt$requestRealShowSplashInner$1> continuation) {
        super(2, continuation);
        this.$source = splashSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashOrderSelectComponentKt$requestRealShowSplashInner$1(this.$source, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BLog.i("[Splash]SplashOrderSelectComponent", "requestRealShowSplashInner " + BootOpt.INSTANCE.record());
                SplashOrderSelectComponentKt.requestRealShowSplashInnerApi(this.$source);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}