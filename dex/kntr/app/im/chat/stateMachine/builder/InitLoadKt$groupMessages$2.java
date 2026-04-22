package kntr.app.im.chat.stateMachine.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.localization.DateTimeFormatKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageGroup;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.InitLoadKt$groupMessages$2", f = "InitLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InitLoadKt$groupMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MessageGroup>>, Object> {
    final /* synthetic */ MessageGroupingService $groupingService;
    final /* synthetic */ List<EntityMessage> $messages;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitLoadKt$groupMessages$2(List<EntityMessage> list, MessageGroupingService messageGroupingService, Continuation<? super InitLoadKt$groupMessages$2> continuation) {
        super(2, continuation);
        this.$messages = list;
        this.$groupingService = messageGroupingService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitLoadKt$groupMessages$2(this.$messages, this.$groupingService, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<MessageGroup>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List result;
        List currentGroup;
        MessageGroup messageGroup;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$messages.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                List result2 = new ArrayList();
                List currentGroup2 = new ArrayList();
                Iterable $this$forEachIndexed$iv = this.$messages;
                List<EntityMessage> list = this.$messages;
                MessageGroupingService messageGroupingService = this.$groupingService;
                int index = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv = index + 1;
                    if (index < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    EntityMessage message = (EntityMessage) item$iv;
                    if (index == 0) {
                        currentGroup2.add(message);
                    } else {
                        EntityMessage lastMessage = list.get(index - 1);
                        if (messageGroupingService.isInSameGroup(lastMessage, message)) {
                            currentGroup2.add(message);
                        } else {
                            result2.add(CollectionsKt.toList(currentGroup2));
                            currentGroup2.clear();
                            currentGroup2.add(message);
                        }
                    }
                    index = index$iv;
                }
                if (!currentGroup2.isEmpty()) {
                    result2.add(CollectionsKt.toList(currentGroup2));
                }
                List $this$mapNotNull$iv = result2;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    List it = (List) element$iv$iv$iv;
                    EntityMessage first = (EntityMessage) CollectionsKt.firstOrNull(it);
                    if (first == null) {
                        messageGroup = null;
                        result = result2;
                        currentGroup = currentGroup2;
                    } else {
                        result = result2;
                        currentGroup = currentGroup2;
                        messageGroup = new MessageGroup(first.getTimestamp(), DateTimeFormatKt.formatIMDateTimeFromSeconds(first.getTimestamp().getEpochSeconds()), it);
                    }
                    if (messageGroup != null) {
                        destination$iv$iv.add(messageGroup);
                    }
                    result2 = result;
                    currentGroup2 = currentGroup;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}