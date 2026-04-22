package kntr.app.im.chat.service;

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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "<unused var>", "Lkntr/app/im/chat/service/FetchMessagesAction$LoadLater;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindPagination$1", f = "FusionFetchMessagesServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindPagination$1 extends SuspendLambda implements Function3<FetchMessagesAction.LoadLater, State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FusionFetchMessagesServiceImpl$bindPagination$1(Continuation<? super FusionFetchMessagesServiceImpl$bindPagination$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FetchMessagesAction.LoadLater loadLater, State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FusionFetchMessagesServiceImpl$bindPagination$1 fusionFetchMessagesServiceImpl$bindPagination$1 = new FusionFetchMessagesServiceImpl$bindPagination$1(continuation);
        fusionFetchMessagesServiceImpl$bindPagination$1.L$0 = state;
        return fusionFetchMessagesServiceImpl$bindPagination$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindPagination$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindPagination$1.invokeSuspend$lambda$0((FetchMessagesData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$0(FetchMessagesData $this$mutate) {
        FetchMessagesData copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.databaseReady : false, (r30 & 2) != 0 ? $this$mutate.loadingLater : true, (r30 & 4) != 0 ? $this$mutate.pendingLoadLater : $this$mutate.getLoadingLater() || $this$mutate.getPendingLoadLater(), (r30 & 8) != 0 ? $this$mutate.loadingEarlier : false, (r30 & 16) != 0 ? $this$mutate.pendingLoadEarlier : false, (r30 & 32) != 0 ? $this$mutate.currentRange : null, (r30 & 64) != 0 ? $this$mutate.messages : null, (r30 & 128) != 0 ? $this$mutate.baselineTime : null, (r30 & 256) != 0 ? $this$mutate.tempMessages : null, (r30 & 512) != 0 ? $this$mutate.updateMsgIds : null, (r30 & 1024) != 0 ? $this$mutate.markFailedMessage : null, (r30 & 2048) != 0 ? $this$mutate.performAck : false, (r30 & 4096) != 0 ? $this$mutate.error : null, (r30 & 8192) != 0 ? $this$mutate.errorTime : null);
        return copy;
    }
}