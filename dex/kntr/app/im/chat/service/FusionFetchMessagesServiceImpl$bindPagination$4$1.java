package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindPagination$4$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0}, l = {177}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindPagination$4$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindPagination$4$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindPagination$4$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindPagination$4$1 = new FusionFetchMessagesServiceImpl$bindPagination$4$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindPagination$4$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindPagination$4$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loadPrev;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                loadPrev = this.this$0.loadPrev(state, (Continuation) this);
                if (loadPrev == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return loadPrev;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}