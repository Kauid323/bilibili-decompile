package tv.danmaku.bili.primer;

import com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp;
import kntr.base.primer.GPrimer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* compiled from: PrimerInterceptor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/app/coldstart/v1/KColdStartBizResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.primer.PrimerInterceptor$intercept$resp$1", f = "PrimerInterceptor.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PrimerInterceptor$intercept$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KColdStartBizResp>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ PrimerInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimerInterceptor$intercept$resp$1(PrimerInterceptor primerInterceptor, String str, String str2, Continuation<? super PrimerInterceptor$intercept$resp$1> continuation) {
        super(2, continuation);
        this.this$0 = primerInterceptor;
        this.$host = str;
        this.$path = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrimerInterceptor$intercept$resp$1(this.this$0, this.$host, this.$path, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KColdStartBizResp> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GPrimer primer = this.this$0.getPrimer();
                String str = this.$host;
                Intrinsics.checkNotNull(str);
                String str2 = this.$path;
                Intrinsics.checkNotNull(str2);
                this.label = 1;
                Object hit = primer.hit(str, str2, (Continuation) this);
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