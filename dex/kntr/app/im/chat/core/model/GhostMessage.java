package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.im.v1.KGhostMsgType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lkntr/app/im/chat/core/model/GhostMessage;", "Lkntr/app/im/chat/core/model/Message;", "msgId", "Lkntr/app/im/chat/core/model/MessageId;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KGhostMsgType;", "associatedMsgId", "<init>", "(Lkntr/app/im/chat/core/model/MessageId;Lcom/bapis/bilibili/app/im/v1/KGhostMsgType;Lkntr/app/im/chat/core/model/MessageId;)V", "getMsgId", "()Lkntr/app/im/chat/core/model/MessageId;", "getMsgType", "()Lcom/bapis/bilibili/app/im/v1/KGhostMsgType;", "getAssociatedMsgId", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GhostMessage implements Message {
    public static final int $stable = 8;
    private final MessageId associatedMsgId;
    private final MessageId msgId;
    private final KGhostMsgType msgType;

    public static /* synthetic */ GhostMessage copy$default(GhostMessage ghostMessage, MessageId messageId, KGhostMsgType kGhostMsgType, MessageId messageId2, int i, Object obj) {
        if ((i & 1) != 0) {
            messageId = ghostMessage.msgId;
        }
        if ((i & 2) != 0) {
            kGhostMsgType = ghostMessage.msgType;
        }
        if ((i & 4) != 0) {
            messageId2 = ghostMessage.associatedMsgId;
        }
        return ghostMessage.copy(messageId, kGhostMsgType, messageId2);
    }

    public final MessageId component1() {
        return this.msgId;
    }

    public final KGhostMsgType component2() {
        return this.msgType;
    }

    public final MessageId component3() {
        return this.associatedMsgId;
    }

    public final GhostMessage copy(MessageId messageId, KGhostMsgType kGhostMsgType, MessageId messageId2) {
        Intrinsics.checkNotNullParameter(messageId, "msgId");
        Intrinsics.checkNotNullParameter(kGhostMsgType, "msgType");
        return new GhostMessage(messageId, kGhostMsgType, messageId2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GhostMessage) {
            GhostMessage ghostMessage = (GhostMessage) obj;
            return Intrinsics.areEqual(this.msgId, ghostMessage.msgId) && Intrinsics.areEqual(this.msgType, ghostMessage.msgType) && Intrinsics.areEqual(this.associatedMsgId, ghostMessage.associatedMsgId);
        }
        return false;
    }

    public int hashCode() {
        return (((this.msgId.hashCode() * 31) + this.msgType.hashCode()) * 31) + (this.associatedMsgId == null ? 0 : this.associatedMsgId.hashCode());
    }

    public String toString() {
        MessageId messageId = this.msgId;
        KGhostMsgType kGhostMsgType = this.msgType;
        return "GhostMessage(msgId=" + messageId + ", msgType=" + kGhostMsgType + ", associatedMsgId=" + this.associatedMsgId + ")";
    }

    public GhostMessage(MessageId msgId, KGhostMsgType msgType, MessageId associatedMsgId) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        this.msgId = msgId;
        this.msgType = msgType;
        this.associatedMsgId = associatedMsgId;
    }

    @Override // kntr.app.im.chat.core.model.Message
    public MessageId getMsgId() {
        return this.msgId;
    }

    public final KGhostMsgType getMsgType() {
        return this.msgType;
    }

    public final MessageId getAssociatedMsgId() {
        return this.associatedMsgId;
    }
}