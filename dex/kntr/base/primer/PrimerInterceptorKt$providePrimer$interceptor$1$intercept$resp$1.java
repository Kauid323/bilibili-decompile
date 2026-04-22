package kntr.base.primer;

import com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PrimerInterceptor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/app/coldstart/v1/KColdStartBizResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.primer.PrimerInterceptorKt$providePrimer$interceptor$1$intercept$resp$1", f = "PrimerInterceptor.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PrimerInterceptorKt$providePrimer$interceptor$1$intercept$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KColdStartBizResp>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ String $path;
    final /* synthetic */ GPrimer $primer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimerInterceptorKt$providePrimer$interceptor$1$intercept$resp$1(GPrimer gPrimer, String str, String str2, Continuation<? super PrimerInterceptorKt$providePrimer$interceptor$1$intercept$resp$1> continuation) {
        super(2, continuation);
        this.$primer = gPrimer;
        this.$host = str;
        this.$path = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrimerInterceptorKt$providePrimer$interceptor$1$intercept$resp$1(this.$primer, this.$host, this.$path, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KColdStartBizResp> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object hit = this.$primer.hit(this.$host, this.$path, (Continuation) this);
                if (hit == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return hit;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}