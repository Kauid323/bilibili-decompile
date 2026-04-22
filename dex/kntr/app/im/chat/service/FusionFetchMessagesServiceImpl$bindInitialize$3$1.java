package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import kntr.app.im.chat.core.RequestMessagesPolicy;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.FetchMessagesResult;
import kntr.app.im.chat.core.service.NetworkFetchMessageService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindInitialize$3$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 1, 1, 1}, l = {152, 156}, m = "invokeSuspend", n = {"state", "state", "it", "$i$a$-fold-FusionFetchMessagesServiceImpl$bindInitialize$3$1$1"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindInitialize$3$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindInitialize$3$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindInitialize$3$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindInitialize$3$1 = new FusionFetchMessagesServiceImpl$bindInitialize$3$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindInitialize$3$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindInitialize$3$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        NetworkFetchMessageService networkFetchMessageService;
        Object mo1360load0E7RQCE;
        final Throwable it;
        Object obj;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                networkFetchMessageService = this.this$0.networkService;
                this.L$0 = state;
                this.label = 1;
                mo1360load0E7RQCE = networkFetchMessageService.mo1360load0E7RQCE(Long.MAX_VALUE, RequestMessagesPolicy.SEQUENCE_NUMBER_BEFORE, (Continuation) this);
                if (mo1360load0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl = this.this$0;
                it = Result.exceptionOrNull-impl(mo1360load0E7RQCE);
                if (it != null) {
                    FetchMessagesResult it2 = (FetchMessagesResult) mo1360load0E7RQCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(it2);
                    this.I$0 = 0;
                    this.label = 2;
                    Object handleFetchMessagesResult$default = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$default(fusionFetchMessagesServiceImpl, state, it2, true, null, this, 8, null);
                    if (handleFetchMessagesResult$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = handleFetchMessagesResult$default;
                    return (ChangedState) obj;
                }
                IMLog.Companion.e("ChatFetchService", "首次请求FetchMessages失败", it);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindInitialize$3$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        FetchMessagesData invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = FusionFetchMessagesServiceImpl$bindInitialize$3$1.invokeSuspend$lambda$1$0(it, (FetchMessagesData) obj2);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                mo1360load0E7RQCE = ((Result) $result).unbox-impl();
                FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl2 = this.this$0;
                it = Result.exceptionOrNull-impl(mo1360load0E7RQCE);
                if (it != null) {
                }
                break;
            case 2:
                int i = this.I$0;
                FetchMessagesResult fetchMessagesResult = (FetchMessagesResult) this.L$1;
                ResultKt.throwOnFailure($result);
                obj = $result;
                return (ChangedState) obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$1$0(Throwable $it, FetchMessagesData $this$mutate) {
        FetchMessagesData copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.databaseReady : false, (r30 & 2) != 0 ? $this$mutate.loadingLater : false, (r30 & 4) != 0 ? $this$mutate.pendingLoadLater : false, (r30 & 8) != 0 ? $this$mutate.loadingEarlier : false, (r30 & 16) != 0 ? $this$mutate.pendingLoadEarlier : false, (r30 & 32) != 0 ? $this$mutate.currentRange : null, (r30 & 64) != 0 ? $this$mutate.messages : null, (r30 & 128) != 0 ? $this$mutate.baselineTime : null, (r30 & 256) != 0 ? $this$mutate.tempMessages : null, (r30 & 512) != 0 ? $this$mutate.updateMsgIds : null, (r30 & 1024) != 0 ? $this$mutate.markFailedMessage : null, (r30 & 2048) != 0 ? $this$mutate.performAck : false, (r30 & 4096) != 0 ? $this$mutate.error : $it, (r30 & 8192) != 0 ? $this$mutate.errorTime : Clock.System.INSTANCE.now());
        return copy;
    }
}