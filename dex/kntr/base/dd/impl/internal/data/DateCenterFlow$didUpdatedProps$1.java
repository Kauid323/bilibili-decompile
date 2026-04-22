package kntr.base.dd.impl.internal.data;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateCenterFlow.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.data.DateCenterFlow$didUpdatedProps$1", f = "DateCenterFlow.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DateCenterFlow$didUpdatedProps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $props;
    int label;
    final /* synthetic */ DateCenterFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateCenterFlow$didUpdatedProps$1(DateCenterFlow dateCenterFlow, Set<String> set, Continuation<? super DateCenterFlow$didUpdatedProps$1> continuation) {
        super(2, continuation);
        this.this$0 = dateCenterFlow;
        this.$props = set;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DateCenterFlow$didUpdatedProps$1(this.this$0, this.$props, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableSharedFlow = this.this$0._props;
                this.label = 1;
                if (mutableSharedFlow.emit(this.$props, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DDConst.INSTANCE.logD("data flow did updated " + this.$props.size() + " props.");
        return Unit.INSTANCE;
    }
}