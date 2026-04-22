package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.RangeDatabaseService;
import kotlin.Metadata;
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
import kotlin.ranges.LongRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindInitialize$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 1, 1}, l = {126, 130}, m = "invokeSuspend", n = {"state", "state", "previousRange"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindInitialize$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindInitialize$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindInitialize$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindInitialize$1 = new FusionFetchMessagesServiceImpl$bindInitialize$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindInitialize$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindInitialize$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        RangeDatabaseService rangeDatabaseService;
        Object mergeAll;
        LongRange longRange;
        MessageDatabaseService messageDatabaseService;
        Object querySequenceNumberInRange;
        LongRange previousRange;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                rangeDatabaseService = this.this$0.rangeDatabaseService;
                this.L$0 = state;
                this.label = 1;
                mergeAll = rangeDatabaseService.mergeAll((Continuation) this);
                if (mergeAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                mergeAll = $result;
                break;
            case 2:
                previousRange = (LongRange) this.L$1;
                ResultKt.throwOnFailure($result);
                querySequenceNumberInRange = $result;
                List sequenceNumber = (List) querySequenceNumberInRange;
                longRange = sequenceNumber.isEmpty() ? new LongRange(((Number) CollectionsKt.first(sequenceNumber)).longValue(), ((Number) CollectionsKt.last(sequenceNumber)).longValue()) : new LongRange(0L, 0L);
                final LongRange currentRange = longRange;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindInitialize$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindInitialize$1.invokeSuspend$lambda$0(currentRange, (FetchMessagesData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LongRange previousRange2 = (LongRange) CollectionsKt.lastOrNull((List) mergeAll);
        if (previousRange2 == null) {
            longRange = new LongRange(0L, 0L);
            final LongRange currentRange2 = longRange;
            return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindInitialize$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    FetchMessagesData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindInitialize$1.invokeSuspend$lambda$0(currentRange2, (FetchMessagesData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        }
        messageDatabaseService = this.this$0.messageDatabaseService;
        this.L$0 = state;
        this.L$1 = SpillingKt.nullOutSpilledVariable(previousRange2);
        this.label = 2;
        querySequenceNumberInRange = messageDatabaseService.querySequenceNumberInRange(previousRange2, 30, (Continuation) this);
        if (querySequenceNumberInRange == coroutine_suspended) {
            return coroutine_suspended;
        }
        previousRange = previousRange2;
        List sequenceNumber2 = (List) querySequenceNumberInRange;
        if (sequenceNumber2.isEmpty()) {
        }
        final LongRange currentRange22 = longRange;
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindInitialize$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                FetchMessagesData invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindInitialize$1.invokeSuspend$lambda$0(currentRange22, (FetchMessagesData) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$0(LongRange $currentRange, FetchMessagesData $this$mutate) {
        FetchMessagesData copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.databaseReady : true, (r30 & 2) != 0 ? $this$mutate.loadingLater : false, (r30 & 4) != 0 ? $this$mutate.pendingLoadLater : false, (r30 & 8) != 0 ? $this$mutate.loadingEarlier : false, (r30 & 16) != 0 ? $this$mutate.pendingLoadEarlier : false, (r30 & 32) != 0 ? $this$mutate.currentRange : $currentRange, (r30 & 64) != 0 ? $this$mutate.messages : null, (r30 & 128) != 0 ? $this$mutate.baselineTime : null, (r30 & 256) != 0 ? $this$mutate.tempMessages : null, (r30 & 512) != 0 ? $this$mutate.updateMsgIds : null, (r30 & 1024) != 0 ? $this$mutate.markFailedMessage : null, (r30 & 2048) != 0 ? $this$mutate.performAck : false, (r30 & 4096) != 0 ? $this$mutate.error : null, (r30 & 8192) != 0 ? $this$mutate.errorTime : null);
        return copy;
    }
}