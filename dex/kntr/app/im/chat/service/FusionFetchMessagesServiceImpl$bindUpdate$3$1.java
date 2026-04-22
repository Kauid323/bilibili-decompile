package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import java.util.List;
import java.util.Map;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.NetworkFetchMessageService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindUpdate$3$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 0, 1, 1, 1, 1}, l = {335, 338}, m = "invokeSuspend", n = {"state", "consumed", "state", "consumed", "result", "$i$a$-fold-FusionFetchMessagesServiceImpl$bindUpdate$3$1$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindUpdate$3$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindUpdate$3$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindUpdate$3$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindUpdate$3$1 = new FusionFetchMessagesServiceImpl$bindUpdate$3$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindUpdate$3$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindUpdate$3$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        final List consumed;
        NetworkFetchMessageService networkFetchMessageService;
        Object mo1361messageDetailgIAlus;
        Throwable it;
        MessageDatabaseService messageDatabaseService;
        List consumed2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                consumed = ((FetchMessagesData) state.getSnapshot()).getUpdateMsgIds();
                IMLog.Companion.i("ChatFetchService", "批量更新 " + consumed.size() + " 条消息");
                if (!consumed.isEmpty()) {
                    networkFetchMessageService = this.this$0.networkService;
                    this.L$0 = state;
                    this.L$1 = consumed;
                    this.label = 1;
                    mo1361messageDetailgIAlus = networkFetchMessageService.mo1361messageDetailgIAlus(consumed, (Continuation) this);
                    if (mo1361messageDetailgIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl = this.this$0;
                    it = Result.exceptionOrNull-impl(mo1361messageDetailgIAlus);
                    if (it != null) {
                        Map result = (Map) mo1361messageDetailgIAlus;
                        messageDatabaseService = fusionFetchMessagesServiceImpl.messageDatabaseService;
                        List<EntityMessage> list = CollectionsKt.toList(result.values());
                        this.L$0 = state;
                        this.L$1 = consumed;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                        this.I$0 = 0;
                        this.label = 2;
                        if (messageDatabaseService.updateContent(list, (Continuation<? super Unit>) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        consumed2 = consumed;
                        consumed = consumed2;
                    } else {
                        IMLog.Companion.e("ChatFetchService", "批量更新消息失败", it);
                    }
                }
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindUpdate$3$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = FusionFetchMessagesServiceImpl$bindUpdate$3$1.invokeSuspend$lambda$2(consumed, (FetchMessagesData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case 1:
                consumed = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                mo1361messageDetailgIAlus = ((Result) $result).unbox-impl();
                FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl2 = this.this$0;
                it = Result.exceptionOrNull-impl(mo1361messageDetailgIAlus);
                if (it != null) {
                }
                break;
            case 2:
                int i = this.I$0;
                Map map = (Map) this.L$2;
                consumed2 = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                consumed = consumed2;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindUpdate$3$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = FusionFetchMessagesServiceImpl$bindUpdate$3$1.invokeSuspend$lambda$2(consumed, (FetchMessagesData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$2(List $consumed, FetchMessagesData $this$mutate) {
        FetchMessagesData copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.databaseReady : false, (r30 & 2) != 0 ? $this$mutate.loadingLater : false, (r30 & 4) != 0 ? $this$mutate.pendingLoadLater : false, (r30 & 8) != 0 ? $this$mutate.loadingEarlier : false, (r30 & 16) != 0 ? $this$mutate.pendingLoadEarlier : false, (r30 & 32) != 0 ? $this$mutate.currentRange : null, (r30 & 64) != 0 ? $this$mutate.messages : null, (r30 & 128) != 0 ? $this$mutate.baselineTime : null, (r30 & 256) != 0 ? $this$mutate.tempMessages : null, (r30 & 512) != 0 ? $this$mutate.updateMsgIds : CollectionsKt.minus($this$mutate.getUpdateMsgIds(), $consumed), (r30 & 1024) != 0 ? $this$mutate.markFailedMessage : null, (r30 & 2048) != 0 ? $this$mutate.performAck : false, (r30 & 4096) != 0 ? $this$mutate.error : null, (r30 & 8192) != 0 ? $this$mutate.errorTime : null);
        return copy;
    }
}