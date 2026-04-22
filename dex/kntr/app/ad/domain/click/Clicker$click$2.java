package kntr.app.ad.domain.click;

import java.util.Map;
import kntr.app.ad.domain.click.internal.ClickRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Clicker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.Clicker$click$2", f = "Clicker.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class Clicker$click$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Map<String, Object> $reportParams;
    final /* synthetic */ ClickRequest $request;
    int label;
    final /* synthetic */ Clicker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Clicker$click$2(Clicker clicker, Map<String, ? extends Object> map, ClickRequest clickRequest, Continuation<? super Clicker$click$2> continuation) {
        super(2, continuation);
        this.this$0 = clicker;
        this.$reportParams = map;
        this.$request = clickRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Clicker$click$2(this.this$0, this.$reportParams, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object innerClick;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.getContext$click_debug().reset();
                this.this$0.getContext$click_debug().solidifyReportParams(this.$reportParams);
                this.label = 1;
                innerClick = this.this$0.innerClick(this.$request, (Continuation) this);
                if (innerClick == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                innerClick = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Clicker clicker = this.this$0;
        boolean it = ((Boolean) innerClick).booleanValue();
        clicker.getContext$click_debug().setValidClick(it);
        return innerClick;
    }
}