package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.MessageDatabaseService;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$6$1", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {308}, m = "invokeSuspend", n = {"state", "list", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-FusionFetchMessagesServiceImpl$bindDatabase$6$1$1"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "I$0", "I$1"}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindDatabase$6$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindDatabase$6$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindDatabase$6$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionFetchMessagesServiceImpl$bindDatabase$6$1 = new FusionFetchMessagesServiceImpl$bindDatabase$6$1(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$0 = obj;
        return fusionFetchMessagesServiceImpl$bindDatabase$6$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00ce -> B:16:0x00da). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterator it;
        final List list;
        Iterable $this$forEach$iv;
        FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl;
        int $i$f$forEach;
        FusionFetchMessagesServiceImpl$bindDatabase$6$1 fusionFetchMessagesServiceImpl$bindDatabase$6$1;
        Object obj;
        State state;
        MessageDatabaseService messageDatabaseService;
        Object obj2;
        List list2;
        Iterable $this$forEach$iv2;
        FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl2;
        Iterator it2;
        FusionFetchMessagesServiceImpl$bindDatabase$6$1 fusionFetchMessagesServiceImpl$bindDatabase$6$12;
        int $i$f$forEach2;
        State state2 = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List markFailedMessage = ((FetchMessagesData) state2.getSnapshot()).getMarkFailedMessage();
                IMLog.Companion.i("ChatFetchService", "标记 " + markFailedMessage.size() + " 条消息为发送失败");
                if (!markFailedMessage.isEmpty()) {
                    List $this$forEach$iv3 = markFailedMessage;
                    FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl3 = this.this$0;
                    it = $this$forEach$iv3.iterator();
                    list = markFailedMessage;
                    $this$forEach$iv = $this$forEach$iv3;
                    fusionFetchMessagesServiceImpl = fusionFetchMessagesServiceImpl3;
                    $i$f$forEach = 0;
                    fusionFetchMessagesServiceImpl$bindDatabase$6$1 = this;
                    obj = coroutine_suspended;
                    state = state2;
                    break;
                } else {
                    return state2.noChange();
                }
            case 1:
                int i = this.I$1;
                int $i$f$forEach3 = this.I$0;
                EntityMessage entityMessage = (EntityMessage) this.L$6;
                Object obj3 = this.L$5;
                List list3 = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                list2 = list3;
                $i$f$forEach2 = $i$f$forEach3;
                $this$forEach$iv2 = (Iterable) this.L$2;
                obj2 = coroutine_suspended;
                fusionFetchMessagesServiceImpl2 = (FusionFetchMessagesServiceImpl) this.L$3;
                state = state2;
                it2 = (Iterator) this.L$4;
                fusionFetchMessagesServiceImpl$bindDatabase$6$12 = this;
                obj = obj2;
                $i$f$forEach = $i$f$forEach2;
                fusionFetchMessagesServiceImpl$bindDatabase$6$1 = fusionFetchMessagesServiceImpl$bindDatabase$6$12;
                it = it2;
                fusionFetchMessagesServiceImpl = fusionFetchMessagesServiceImpl2;
                $this$forEach$iv = $this$forEach$iv2;
                list = list2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object element$iv = it.next();
            EntityMessage it3 = (EntityMessage) element$iv;
            messageDatabaseService = fusionFetchMessagesServiceImpl.messageDatabaseService;
            MessageId msgId = it3.getMsgId();
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$0 = state;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$1 = list;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$3 = fusionFetchMessagesServiceImpl;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$4 = it;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$5 = SpillingKt.nullOutSpilledVariable(element$iv);
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.L$6 = SpillingKt.nullOutSpilledVariable(it3);
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.I$0 = $i$f$forEach;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.I$1 = 0;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1.label = 1;
            if (messageDatabaseService.sendFailed(msgId, fusionFetchMessagesServiceImpl$bindDatabase$6$1) == obj) {
                return obj;
            }
            int i2 = $i$f$forEach;
            obj2 = obj;
            list2 = list;
            $this$forEach$iv2 = $this$forEach$iv;
            fusionFetchMessagesServiceImpl2 = fusionFetchMessagesServiceImpl;
            it2 = it;
            fusionFetchMessagesServiceImpl$bindDatabase$6$12 = fusionFetchMessagesServiceImpl$bindDatabase$6$1;
            $i$f$forEach2 = i2;
            obj = obj2;
            $i$f$forEach = $i$f$forEach2;
            fusionFetchMessagesServiceImpl$bindDatabase$6$1 = fusionFetchMessagesServiceImpl$bindDatabase$6$12;
            it = it2;
            fusionFetchMessagesServiceImpl = fusionFetchMessagesServiceImpl2;
            $this$forEach$iv = $this$forEach$iv2;
            list = list2;
            if (!it.hasNext()) {
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$6$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj4) {
                        FetchMessagesData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = FusionFetchMessagesServiceImpl$bindDatabase$6$1.invokeSuspend$lambda$1(list, (FetchMessagesData) obj4);
                        return invokeSuspend$lambda$1;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$1(List $list, FetchMessagesData $this$mutate) {
        FetchMessagesData copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.databaseReady : false, (r30 & 2) != 0 ? $this$mutate.loadingLater : false, (r30 & 4) != 0 ? $this$mutate.pendingLoadLater : false, (r30 & 8) != 0 ? $this$mutate.loadingEarlier : false, (r30 & 16) != 0 ? $this$mutate.pendingLoadEarlier : false, (r30 & 32) != 0 ? $this$mutate.currentRange : null, (r30 & 64) != 0 ? $this$mutate.messages : null, (r30 & 128) != 0 ? $this$mutate.baselineTime : null, (r30 & 256) != 0 ? $this$mutate.tempMessages : null, (r30 & 512) != 0 ? $this$mutate.updateMsgIds : null, (r30 & 1024) != 0 ? $this$mutate.markFailedMessage : CollectionsKt.minus($this$mutate.getMarkFailedMessage(), $list), (r30 & 2048) != 0 ? $this$mutate.performAck : false, (r30 & 4096) != 0 ? $this$mutate.error : null, (r30 & 8192) != 0 ? $this$mutate.errorTime : null);
        return copy;
    }
}