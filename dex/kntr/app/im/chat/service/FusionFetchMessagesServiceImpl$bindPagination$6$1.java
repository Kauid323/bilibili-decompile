package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindPagination$6$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0}, l = {184}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindPagination$6$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FusionFetchMessagesServiceImpl$bindPagination$6$1(Continuation<? super FusionFetchMessagesServiceImpl$bindPagination$6$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindPagination$6$1 = new FusionFetchMessagesServiceImpl$bindPagination$6$1(continuation);
        fusionFetchMessagesServiceImpl$bindPagination$6$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindPagination$6$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("ChatFetchService", "延迟2s开始处理积压的加载上一页请求");
                Duration.Companion companion = Duration.Companion;
                this.L$0 = state;
                this.label = 1;
                if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(2, DurationUnit.SECONDS), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindPagination$6$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                FetchMessagesData copy$default;
                copy$default = FetchMessagesData.copy$default((FetchMessagesData) obj, false, false, false, true, false, null, null, null, null, null, null, false, null, null, 16359, null);
                return copy$default;
            }
        });
    }
}