package kntr.app.im.chat.network;

import im.base.model.SessionId;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/network/ChatSendEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "<init>", "(Lim/base/model/SessionId;)V", "eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/app/im/chat/network/MessageEvent;", "event", "Lkotlinx/coroutines/flow/Flow;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "notifyNewMessageSent", RoomRecommendViewModel.EMPTY_CURSOR, "messageId", "Lkntr/app/im/chat/core/model/MessageId;", "(Lkntr/app/im/chat/core/model/MessageId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyMessageRecalled", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSendEvent {
    private final Flow<MessageEvent> event;
    private final MutableSharedFlow<MessageEvent> eventFlow;
    private final SessionId sessionId;

    public ChatSendEvent(SessionId sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.eventFlow = SharedFlowKt.MutableSharedFlow$default(0, 5, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        this.event = this.eventFlow;
    }

    public final Flow<MessageEvent> getEvent() {
        return this.event;
    }

    public final Object notifyNewMessageSent(MessageId messageId, Continuation<? super Unit> continuation) {
        Object emit;
        return (Intrinsics.areEqual(this.sessionId, messageId.getSessionId()) && (emit = this.eventFlow.emit(new MessageEvent(MessageEventType.Send, messageId), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? emit : Unit.INSTANCE;
    }

    public final Object notifyMessageRecalled(MessageId messageId, Continuation<? super Unit> continuation) {
        Object emit;
        return (Intrinsics.areEqual(this.sessionId, messageId.getSessionId()) && (emit = this.eventFlow.emit(new MessageEvent(MessageEventType.Recall, messageId), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? emit : Unit.INSTANCE;
    }
}