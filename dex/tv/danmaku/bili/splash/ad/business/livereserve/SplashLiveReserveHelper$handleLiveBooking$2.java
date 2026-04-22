package tv.danmaku.bili.splash.ad.business.livereserve;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashLiveReserveHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper$handleLiveBooking$2", f = "SplashLiveReserveHelper.kt", i = {}, l = {BR.bottomText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashLiveReserveHelper$handleLiveBooking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $bookingListener;
    final /* synthetic */ boolean $needToast;
    final /* synthetic */ SplashOrder $splash;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SplashLiveReserveHelper$handleLiveBooking$2(SplashOrder splashOrder, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super SplashLiveReserveHelper$handleLiveBooking$2> continuation) {
        super(2, continuation);
        this.$splash = splashOrder;
        this.$needToast = z;
        this.$bookingListener = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashLiveReserveHelper$handleLiveBooking$2(this.$splash, this.$needToast, this.$bookingListener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object reserveLive;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                reserveLive = SplashLiveReserveHelper.INSTANCE.reserveLive(this.$splash, this.$needToast, (Continuation) this);
                if (reserveLive != coroutine_suspended) {
                    $result = reserveLive;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean success = ((Boolean) $result).booleanValue();
        this.$bookingListener.invoke(Boxing.boxBoolean(success));
        return Unit.INSTANCE;
    }
}