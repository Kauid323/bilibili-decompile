package kntr.app.im.chat.service;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.FetchMessagesDataLensKt;
import kntr.app.im.chat.core.model.MessagesLensKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "messages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$4$2", f = "FusionFetchMessagesServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FusionFetchMessagesServiceImpl$bindDatabase$4$2 extends SuspendLambda implements Function3<List<? extends EntityMessage>, State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$bindDatabase$4$2(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$bindDatabase$4$2> continuation) {
        super(3, continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Object invoke(List<EntityMessage> list, State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FusionFetchMessagesServiceImpl$bindDatabase$4$2 fusionFetchMessagesServiceImpl$bindDatabase$4$2 = new FusionFetchMessagesServiceImpl$bindDatabase$4$2(this.this$0, continuation);
        fusionFetchMessagesServiceImpl$bindDatabase$4$2.L$0 = list;
        fusionFetchMessagesServiceImpl$bindDatabase$4$2.L$1 = state;
        return fusionFetchMessagesServiceImpl$bindDatabase$4$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Instant instant;
        final List messages = (List) this.L$0;
        final State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$4$2$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        String invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FusionFetchMessagesServiceImpl$bindDatabase$4$2.invokeSuspend$lambda$0(state, messages);
                        return invokeSuspend$lambda$0;
                    }
                });
                final List displayMessages = CollectionsKt.plus(messages, ((FetchMessagesData) state.getSnapshot()).getTempMessageInRange());
                List $this$filter$iv = displayMessages;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    EntityMessage it = (EntityMessage) element$iv$iv;
                    if (it.getNeedUpdate()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable $this$filter$iv2 = (List) destination$iv$iv;
                FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl = this.this$0;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    EntityMessage it2 = (EntityMessage) element$iv$iv2;
                    Instant updateTime = it2.getUpdateTime();
                    List messages2 = messages;
                    instant = fusionFetchMessagesServiceImpl.updateBaseTime;
                    if (updateTime.compareTo(instant) < 0) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                    messages = messages2;
                }
                Iterable $this$map$iv = (List) destination$iv$iv2;
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    EntityMessage it3 = (EntityMessage) item$iv$iv;
                    destination$iv$iv3.add(it3.getMsgId());
                }
                final List msgListForUpdate = (List) destination$iv$iv3;
                IMLog.Companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$4$2$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        String invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = FusionFetchMessagesServiceImpl$bindDatabase$4$2.invokeSuspend$lambda$4(msgListForUpdate);
                        return invokeSuspend$lambda$4;
                    }
                });
                final FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl2 = this.this$0;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$4$2$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$5;
                        invokeSuspend$lambda$5 = FusionFetchMessagesServiceImpl$bindDatabase$4$2.invokeSuspend$lambda$5(displayMessages, fusionFetchMessagesServiceImpl2, msgListForUpdate, (FetchMessagesData) obj);
                        return invokeSuspend$lambda$5;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0(State $state, List $messages) {
        LongRange currentRange = ((FetchMessagesData) $state.getSnapshot()).getCurrentRange();
        Long valueOf = currentRange != null ? Long.valueOf(currentRange.getFirst()) : null;
        LongRange currentRange2 = ((FetchMessagesData) $state.getSnapshot()).getCurrentRange();
        return "范围[" + valueOf + ", " + (currentRange2 != null ? Long.valueOf(currentRange2.getLast()) : null) + "]的消息变化: " + $messages.size() + "条";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$4(List $msgListForUpdate) {
        return "监听范围内有消息更新，需要更新的实时消息ID列表: " + $msgListForUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$5(final List $displayMessages, final FusionFetchMessagesServiceImpl this$0, final List $msgListForUpdate, FetchMessagesData $this$mutate) {
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$4$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$5$0;
                invokeSuspend$lambda$5$0 = FusionFetchMessagesServiceImpl$bindDatabase$4$2.invokeSuspend$lambda$5$0($displayMessages, this$0, $msgListForUpdate, (CopyScope) obj);
                return invokeSuspend$lambda$5$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$5$0(List $displayMessages, FusionFetchMessagesServiceImpl this$0, List $msgListForUpdate, CopyScope $this$copy) {
        Iterable $this$associateByTo$iv = ((FetchMessagesData) $this$copy.getCurrent()).getMessages().getEntityMessages();
        Map destination$iv = new LinkedHashMap();
        for (Object element$iv : $this$associateByTo$iv) {
            EntityMessage it = (EntityMessage) element$iv;
            destination$iv.put(Long.valueOf(it.getEntityKey()), element$iv);
        }
        LinkedHashMap messageMap = (LinkedHashMap) destination$iv;
        Iterator it2 = $displayMessages.iterator();
        while (it2.hasNext()) {
            EntityMessage message = (EntityMessage) it2.next();
            messageMap.put(Long.valueOf(message.getEntityKey()), message);
        }
        Iterable $this$forEach$iv = messageMap.values();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "<get-values>(...)");
        Iterable $this$sortedBy$iv = $this$forEach$iv;
        Iterable $this$filter$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$bindDatabase$4$2$invokeSuspend$lambda$5$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                EntityMessage it3 = (EntityMessage) t;
                EntityMessage it4 = (EntityMessage) t2;
                return ComparisonsKt.compareValues(it3.getMsgId().getSequence(), it4.getMsgId().getSequence());
            }
        });
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            EntityMessage it3 = (EntityMessage) element$iv$iv;
            if (!it3.isHidden()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List newMessageList = (List) destination$iv$iv;
        $this$copy.set(MessagesLensKt.getEntityMessages(FetchMessagesDataLensKt.getMessages(FetchMessagesData.Companion)), newMessageList);
        this$0.setUpdateIds($this$copy, $msgListForUpdate);
        return Unit.INSTANCE;
    }
}