package kntr.app.im.chat.service;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.FetchMessagesDataLensKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "it", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindAck$2$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0}, l = {399}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindAck$2$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindAck$2$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindAck$2$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindAck$2$1 = new FusionFetchMessagesServiceImpl$bindAck$2$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindAck$2$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindAck$2$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object performAckSession;
        State it = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = it;
                this.label = 1;
                performAckSession = this.this$0.performAckSession((Continuation) this);
                if (performAckSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return it.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindAck$2$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                FetchMessagesData invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindAck$2$1.invokeSuspend$lambda$0((FetchMessagesData) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$0(FetchMessagesData $this$mutate) {
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindAck$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = FusionFetchMessagesServiceImpl$bindAck$2$1.invokeSuspend$lambda$0$0((CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(CopyScope $this$copy) {
        $this$copy.set(FetchMessagesDataLensKt.getPerformAck(FetchMessagesData.Companion), false);
        return Unit.INSTANCE;
    }
}