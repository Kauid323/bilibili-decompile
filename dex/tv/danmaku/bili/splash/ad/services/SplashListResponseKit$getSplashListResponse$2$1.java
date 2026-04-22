package tv.danmaku.bili.splash.ad.services;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashListResponseKit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.services.SplashListResponseKit$getSplashListResponse$2$1", f = "SplashListResponseKit.kt", i = {}, l = {BR.avatarListVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashListResponseKit$getSplashListResponse$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SplashListResponse>, Object> {
    final /* synthetic */ Function1<String, Unit> $onError;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SplashListResponseKit$getSplashListResponse$2$1(Function1<? super String, Unit> function1, Continuation<? super SplashListResponseKit$getSplashListResponse$2$1> continuation) {
        super(2, continuation);
        this.$onError = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashListResponseKit$getSplashListResponse$2$1(this.$onError, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SplashListResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object await = SplashListResponseKit.INSTANCE.getSplashDataDeferred().await((Continuation) this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = await;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                return (SplashListResponse) $result;
            } catch (Throwable th) {
                Object obj = $result2;
                t = th;
                $result = obj;
                Function1<String, Unit> function1 = this.$onError;
                String message = t.getMessage();
                if (message == null) {
                    message = t.toString();
                }
                function1.invoke(message);
                return null;
            }
        } catch (Throwable th2) {
            t = th2;
        }
    }
}