package kntr.app.im.chat.service;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.service.FetchMessagesAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "action", "Lkntr/app/im/chat/service/FetchMessagesAction$UpdateMessages;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindUpdate$1", f = "FusionFetchMessagesServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindUpdate$1 extends SuspendLambda implements Function3<FetchMessagesAction.UpdateMessages, State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindUpdate$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindUpdate$1> continuation) {
        super(3, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Object invoke(FetchMessagesAction.UpdateMessages updateMessages, State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FusionFetchMessagesServiceImpl$bindUpdate$1 fusionFetchMessagesServiceImpl$bindUpdate$1 = new FusionFetchMessagesServiceImpl$bindUpdate$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindUpdate$1.L$0 = updateMessages;
        fusionFetchMessagesServiceImpl$bindUpdate$1.L$1 = state;
        return fusionFetchMessagesServiceImpl$bindUpdate$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final FetchMessagesAction.UpdateMessages action = (FetchMessagesAction.UpdateMessages) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl = this.this$0;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindUpdate$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindUpdate$1.invokeSuspend$lambda$0(FusionFetchMessagesServiceImpl.this, action, (FetchMessagesData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$0(final FusionFetchMessagesServiceImpl this$0, final FetchMessagesAction.UpdateMessages $action, FetchMessagesData $this$mutate) {
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindUpdate$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = FusionFetchMessagesServiceImpl$bindUpdate$1.invokeSuspend$lambda$0$0(FusionFetchMessagesServiceImpl.this, $action, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(FusionFetchMessagesServiceImpl this$0, FetchMessagesAction.UpdateMessages $action, CopyScope $this$copy) {
        this$0.setUpdateIds($this$copy, $action.getMessageIds());
        return Unit.INSTANCE;
    }
}