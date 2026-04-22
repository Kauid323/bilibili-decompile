package kntr.app.im.chat.service;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.FetchMessagesDataLensKt;
import kntr.app.im.chat.core.model.MessagesLensKt;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.LongRange;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchMessagesWithSendingProgressService.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1", f = "FetchMessagesWithSendingProgressService.kt", i = {0, 0, 0, 0}, l = {227}, m = "invokeSuspend", n = {"state", "currentRange", "it", "$i$a$-let-FetchMessagesWithSendingProgressService$bindDatabase$2$1$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class FetchMessagesWithSendingProgressService$bindDatabase$2$1 extends SuspendLambda implements Function2<State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMessagesWithSendingProgressService$bindDatabase$2$1(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, Continuation<? super FetchMessagesWithSendingProgressService$bindDatabase$2$1> continuation) {
        super(2, continuation);
        this.this$0 = fetchMessagesWithSendingProgressService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fetchMessagesWithSendingProgressService$bindDatabase$2$1 = new FetchMessagesWithSendingProgressService$bindDatabase$2$1(this.this$0, continuation);
        fetchMessagesWithSendingProgressService$bindDatabase$2$1.L$0 = obj;
        return fetchMessagesWithSendingProgressService$bindDatabase$2$1;
    }

    public final Object invoke(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014a A[LOOP:3: B:40:0x0144->B:42:0x014a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MessageDatabaseService messageDatabaseService;
        Object obj;
        final LongRange it;
        Pair pair;
        boolean z;
        Instant instant;
        Instant instant2;
        Instant instant3;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LongRange currentRange = ((FetchMessagesData) state.getSnapshot()).getCurrentRange();
                if (currentRange != null) {
                    messageDatabaseService = this.this$0.messageDatabaseService;
                    this.L$0 = state;
                    this.L$1 = currentRange;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(currentRange);
                    this.I$0 = 0;
                    this.label = 1;
                    Object queryInRangeAsList = messageDatabaseService.queryInRangeAsList(currentRange, this);
                    if (queryInRangeAsList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = queryInRangeAsList;
                    it = currentRange;
                    pair = (Pair) obj;
                    if (pair == null) {
                        currentRange = it;
                    }
                    final Instant baselineTime = (Instant) pair.component1();
                    List rawMessageList = (List) pair.component2();
                    List $this$filter$iv = rawMessageList;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        EntityMessage it2 = (EntityMessage) element$iv$iv;
                        if (!it2.isHidden()) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    Iterable messageList = (List) destination$iv$iv;
                    Iterable $this$filter$iv2 = CollectionsKt.plus((Collection) messageList, ((FetchMessagesData) state.getSnapshot()).getTempMessageInRange());
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv2 : $this$filter$iv2) {
                        EntityMessage it3 = (EntityMessage) element$iv$iv2;
                        if (it3.getNeedUpdate()) {
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                    }
                    Iterable $this$filter$iv3 = (List) destination$iv$iv2;
                    FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService = this.this$0;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv3 : $this$filter$iv3) {
                        EntityMessage it4 = (EntityMessage) element$iv$iv3;
                        Instant updateTime = it4.getUpdateTime();
                        instant3 = fetchMessagesWithSendingProgressService.updateBaseTime;
                        if (updateTime.compareTo(instant3) < 0) {
                            destination$iv$iv3.add(element$iv$iv3);
                        }
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv3;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        EntityMessage it5 = (EntityMessage) item$iv$iv;
                        destination$iv$iv4.add(it5.getMsgId());
                    }
                    final List msgListForUpdate = (List) destination$iv$iv4;
                    Iterable $this$filter$iv4 = messageList;
                    FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService2 = this.this$0;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv4 : $this$filter$iv4) {
                        EntityMessage it6 = (EntityMessage) element$iv$iv4;
                        List rawMessageList2 = rawMessageList;
                        Instant updateTime2 = it6.getUpdateTime();
                        Iterable $this$filter$iv5 = $this$filter$iv4;
                        instant2 = fetchMessagesWithSendingProgressService2.updateBaseTime;
                        if (updateTime2.compareTo(instant2) < 0 && it6.getSendStatus() == SendStatus.Sending) {
                            destination$iv$iv5.add(element$iv$iv4);
                        }
                        rawMessageList = rawMessageList2;
                        $this$filter$iv4 = $this$filter$iv5;
                    }
                    final List msgSendingBefore = (List) destination$iv$iv5;
                    Iterable $this$filter$iv6 = messageList;
                    FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService3 = this.this$0;
                    Collection destination$iv$iv6 = new ArrayList();
                    for (Object element$iv$iv5 : $this$filter$iv6) {
                        EntityMessage it7 = (EntityMessage) element$iv$iv5;
                        Iterable $this$filter$iv7 = $this$filter$iv6;
                        Iterable messageList2 = messageList;
                        if (it7.getSendStatus() == SendStatus.Sending) {
                            Instant updateTime3 = it7.getUpdateTime();
                            instant = fetchMessagesWithSendingProgressService3.updateBaseTime;
                            if (updateTime3.compareTo(instant) >= 0) {
                                z = false;
                                if (!z) {
                                    destination$iv$iv6.add(element$iv$iv5);
                                }
                                $this$filter$iv6 = $this$filter$iv7;
                                messageList = messageList2;
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                        $this$filter$iv6 = $this$filter$iv7;
                        messageList = messageList2;
                    }
                    final List messageListWithoutSending = (List) destination$iv$iv6;
                    IMLog.Companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            String invokeSuspend$lambda$7;
                            invokeSuspend$lambda$7 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$7(it, messageListWithoutSending, msgListForUpdate);
                            return invokeSuspend$lambda$7;
                        }
                    });
                    final FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService4 = this.this$0;
                    return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            FetchMessagesData invokeSuspend$lambda$8;
                            invokeSuspend$lambda$8 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$8(messageListWithoutSending, baselineTime, msgSendingBefore, fetchMessagesWithSendingProgressService4, msgListForUpdate, (FetchMessagesData) obj2);
                            return invokeSuspend$lambda$8;
                        }
                    });
                }
                it = currentRange;
                pair = new Pair(Instant.Companion.getDISTANT_PAST(), CollectionsKt.emptyList());
                final Instant baselineTime2 = (Instant) pair.component1();
                List rawMessageList3 = (List) pair.component2();
                List $this$filter$iv8 = rawMessageList3;
                Collection destination$iv$iv7 = new ArrayList();
                while (r11.hasNext()) {
                }
                Iterable messageList3 = (List) destination$iv$iv7;
                Iterable $this$filter$iv22 = CollectionsKt.plus((Collection) messageList3, ((FetchMessagesData) state.getSnapshot()).getTempMessageInRange());
                Collection destination$iv$iv22 = new ArrayList();
                while (r12.hasNext()) {
                }
                Iterable $this$filter$iv32 = (List) destination$iv$iv22;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService5 = this.this$0;
                Collection destination$iv$iv32 = new ArrayList();
                while (r13.hasNext()) {
                }
                Iterable $this$map$iv2 = (List) destination$iv$iv32;
                Collection destination$iv$iv42 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                }
                final List msgListForUpdate2 = (List) destination$iv$iv42;
                Iterable $this$filter$iv42 = messageList3;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService22 = this.this$0;
                Collection destination$iv$iv52 = new ArrayList();
                while (r13.hasNext()) {
                }
                final List msgSendingBefore2 = (List) destination$iv$iv52;
                Iterable $this$filter$iv62 = messageList3;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService32 = this.this$0;
                Collection destination$iv$iv62 = new ArrayList();
                while (r13.hasNext()) {
                }
                final List messageListWithoutSending2 = (List) destination$iv$iv62;
                IMLog.Companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        String invokeSuspend$lambda$7;
                        invokeSuspend$lambda$7 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$7(it, messageListWithoutSending2, msgListForUpdate2);
                        return invokeSuspend$lambda$7;
                    }
                });
                final FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService42 = this.this$0;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        FetchMessagesData invokeSuspend$lambda$8;
                        invokeSuspend$lambda$8 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$8(messageListWithoutSending2, baselineTime2, msgSendingBefore2, fetchMessagesWithSendingProgressService42, msgListForUpdate2, (FetchMessagesData) obj2);
                        return invokeSuspend$lambda$8;
                    }
                });
            case 1:
                int i = this.I$0;
                LongRange longRange = (LongRange) this.L$2;
                ResultKt.throwOnFailure($result);
                it = (LongRange) this.L$1;
                obj = $result;
                pair = (Pair) obj;
                if (pair == null) {
                }
                final Instant baselineTime22 = (Instant) pair.component1();
                List rawMessageList32 = (List) pair.component2();
                List $this$filter$iv82 = rawMessageList32;
                Collection destination$iv$iv72 = new ArrayList();
                while (r11.hasNext()) {
                }
                Iterable messageList32 = (List) destination$iv$iv72;
                Iterable $this$filter$iv222 = CollectionsKt.plus((Collection) messageList32, ((FetchMessagesData) state.getSnapshot()).getTempMessageInRange());
                Collection destination$iv$iv222 = new ArrayList();
                while (r12.hasNext()) {
                }
                Iterable $this$filter$iv322 = (List) destination$iv$iv222;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService52 = this.this$0;
                Collection destination$iv$iv322 = new ArrayList();
                while (r13.hasNext()) {
                }
                Iterable $this$map$iv22 = (List) destination$iv$iv322;
                Collection destination$iv$iv422 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10));
                while (r11.hasNext()) {
                }
                final List msgListForUpdate22 = (List) destination$iv$iv422;
                Iterable $this$filter$iv422 = messageList32;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService222 = this.this$0;
                Collection destination$iv$iv522 = new ArrayList();
                while (r13.hasNext()) {
                }
                final List msgSendingBefore22 = (List) destination$iv$iv522;
                Iterable $this$filter$iv622 = messageList32;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService322 = this.this$0;
                Collection destination$iv$iv622 = new ArrayList();
                while (r13.hasNext()) {
                }
                final List messageListWithoutSending22 = (List) destination$iv$iv622;
                IMLog.Companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        String invokeSuspend$lambda$7;
                        invokeSuspend$lambda$7 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$7(it, messageListWithoutSending22, msgListForUpdate22);
                        return invokeSuspend$lambda$7;
                    }
                });
                final FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService422 = this.this$0;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        FetchMessagesData invokeSuspend$lambda$8;
                        invokeSuspend$lambda$8 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$8(messageListWithoutSending22, baselineTime22, msgSendingBefore22, fetchMessagesWithSendingProgressService422, msgListForUpdate22, (FetchMessagesData) obj2);
                        return invokeSuspend$lambda$8;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$7(LongRange $currentRange, List $messageListWithoutSending, List $msgListForUpdate) {
        return "监听范围变化加载，当前范围" + $currentRange + "，消息数 " + $messageListWithoutSending.size() + "，需要更新的实时消息ID列表: " + $msgListForUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$8(final List $messageListWithoutSending, final Instant $baselineTime, final List $msgSendingBefore, final FetchMessagesWithSendingProgressService this$0, final List $msgListForUpdate, FetchMessagesData $this$mutate) {
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$8$0;
                invokeSuspend$lambda$8$0 = FetchMessagesWithSendingProgressService$bindDatabase$2$1.invokeSuspend$lambda$8$0($messageListWithoutSending, $baselineTime, $msgSendingBefore, this$0, $msgListForUpdate, (CopyScope) obj);
                return invokeSuspend$lambda$8$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$8$0(List $messageListWithoutSending, Instant $baselineTime, List $msgSendingBefore, FetchMessagesWithSendingProgressService this$0, List $msgListForUpdate, CopyScope $this$copy) {
        $this$copy.set(MessagesLensKt.getEntityMessages(FetchMessagesDataLensKt.getMessages(FetchMessagesData.Companion)), $messageListWithoutSending);
        $this$copy.set(FetchMessagesDataLensKt.getBaselineTime(FetchMessagesData.Companion), $baselineTime);
        Iterable $this$sortedBy$iv = CollectionsKt.distinct(CollectionsKt.plus((Collection) $this$copy.get(FetchMessagesDataLensKt.getMarkFailedMessage(FetchMessagesData.Companion)), $msgSendingBefore));
        $this$copy.set(FetchMessagesDataLensKt.getMarkFailedMessage(FetchMessagesData.Companion), CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindDatabase$2$1$invokeSuspend$lambda$8$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                EntityMessage it = (EntityMessage) t;
                EntityMessage it2 = (EntityMessage) t2;
                return ComparisonsKt.compareValues(it.getMsgId().getSequence(), it2.getMsgId().getSequence());
            }
        }));
        this$0.setUpdateIds($this$copy, $msgListForUpdate);
        return Unit.INSTANCE;
    }
}