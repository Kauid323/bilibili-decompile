package tv.danmaku.bili.ui.splash.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCoreServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.service.SplashCoreServiceImpl$addIPCCallBack$1$onVisibleCountChanged$1", f = "SplashCoreServiceImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SplashCoreServiceImpl$addIPCCallBack$1$onVisibleCountChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $checkShowHotSplash;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashCoreServiceImpl$addIPCCallBack$1$onVisibleCountChanged$1(Function0<Unit> function0, Continuation<? super SplashCoreServiceImpl$addIPCCallBack$1$onVisibleCountChanged$1> continuation) {
        super(2, continuation);
        this.$checkShowHotSplash = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashCoreServiceImpl$addIPCCallBack$1$onVisibleCountChanged$1(this.$checkShowHotSplash, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(SplashConfigKt.getDelayShowHotSplashMs(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$checkShowHotSplash.invoke();
        return Unit.INSTANCE;
    }
}