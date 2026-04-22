package kntr.app.im.chat.network;

import kntr.app.im.chat.core.model.MessageId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/network/MessageEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/im/chat/network/MessageEventType;", "messageId", "Lkntr/app/im/chat/core/model/MessageId;", "<init>", "(Lkntr/app/im/chat/network/MessageEventType;Lkntr/app/im/chat/core/model/MessageId;)V", "getType", "()Lkntr/app/im/chat/network/MessageEventType;", "getMessageId", "()Lkntr/app/im/chat/core/model/MessageId;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageEvent {
    private final MessageId messageId;
    private final MessageEventType type;

    public static /* synthetic */ MessageEvent copy$default(MessageEvent messageEvent, MessageEventType messageEventType, MessageId messageId, int i, Object obj) {
        if ((i & 1) != 0) {
            messageEventType = messageEvent.type;
        }
        if ((i & 2) != 0) {
            messageId = messageEvent.messageId;
        }
        return messageEvent.copy(messageEventType, messageId);
    }

    public final MessageEventType component1() {
        return this.type;
    }

    public final MessageId component2() {
        return this.messageId;
    }

    public final MessageEvent copy(MessageEventType messageEventType, MessageId messageId) {
        Intrinsics.checkNotNullParameter(messageEventType, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        return new MessageEvent(messageEventType, messageId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) obj;
            return this.type == messageEvent.type && Intrinsics.areEqual(this.messageId, messageEvent.messageId);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.messageId.hashCode();
    }

    public String toString() {
        MessageEventType messageEventType = this.type;
        return "MessageEvent(type=" + messageEventType + ", messageId=" + this.messageId + ")";
    }

    public MessageEvent(MessageEventType type, MessageId messageId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        this.type = type;
        this.messageId = messageId;
    }

    public final MessageEventType getType() {
        return this.type;
    }

    public final MessageId getMessageId() {
        return this.messageId;
    }
}