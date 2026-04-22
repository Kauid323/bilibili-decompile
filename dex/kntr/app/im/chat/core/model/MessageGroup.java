package kntr.app.im.chat.core.model;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.datetime.Instant;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0016HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006$"}, d2 = {"Lkntr/app/im/chat/core/model/MessageGroup;", RoomRecommendViewModel.EMPTY_CURSOR, "timestamp", "Lkotlinx/datetime/Instant;", "timeDescription", RoomRecommendViewModel.EMPTY_CURSOR, "messages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "<init>", "(Lkotlinx/datetime/Instant;Ljava/lang/String;Ljava/util/List;)V", "getTimestamp", "()Lkotlinx/datetime/Instant;", "getTimeDescription", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "messageRange", "Lkotlin/ranges/LongRange;", "getMessageRange", "()Lkotlin/ranges/LongRange;", "itemCount", RoomRecommendViewModel.EMPTY_CURSOR, "getItemCount", "()I", "itemCountWithTime", "getItemCountWithTime", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageGroup {
    public static final int $stable = 8;
    private final int itemCount;
    private final int itemCountWithTime;
    private final LongRange messageRange;
    private final List<EntityMessage> messages;
    private final String timeDescription;
    private final Instant timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageGroup copy$default(MessageGroup messageGroup, Instant instant, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            instant = messageGroup.timestamp;
        }
        if ((i & 2) != 0) {
            str = messageGroup.timeDescription;
        }
        if ((i & 4) != 0) {
            list = messageGroup.messages;
        }
        return messageGroup.copy(instant, str, list);
    }

    public final Instant component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.timeDescription;
    }

    public final List<EntityMessage> component3() {
        return this.messages;
    }

    public final MessageGroup copy(Instant instant, String str, List<EntityMessage> list) {
        Intrinsics.checkNotNullParameter(instant, "timestamp");
        Intrinsics.checkNotNullParameter(str, "timeDescription");
        Intrinsics.checkNotNullParameter(list, "messages");
        return new MessageGroup(instant, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageGroup) {
            MessageGroup messageGroup = (MessageGroup) obj;
            return Intrinsics.areEqual(this.timestamp, messageGroup.timestamp) && Intrinsics.areEqual(this.timeDescription, messageGroup.timeDescription) && Intrinsics.areEqual(this.messages, messageGroup.messages);
        }
        return false;
    }

    public int hashCode() {
        return (((this.timestamp.hashCode() * 31) + this.timeDescription.hashCode()) * 31) + this.messages.hashCode();
    }

    public String toString() {
        Instant instant = this.timestamp;
        String str = this.timeDescription;
        return "MessageGroup(timestamp=" + instant + ", timeDescription=" + str + ", messages=" + this.messages + ")";
    }

    public MessageGroup(Instant timestamp, String timeDescription, List<EntityMessage> list) {
        MessageId msgId;
        MessageId msgId2;
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(timeDescription, "timeDescription");
        Intrinsics.checkNotNullParameter(list, "messages");
        this.timestamp = timestamp;
        this.timeDescription = timeDescription;
        this.messages = list;
        EntityMessage entityMessage = (EntityMessage) CollectionsKt.firstOrNull(this.messages);
        long j2 = 0;
        long sequenceNumber = (entityMessage == null || (msgId2 = entityMessage.getMsgId()) == null) ? 0L : msgId2.getSequenceNumber();
        EntityMessage entityMessage2 = (EntityMessage) CollectionsKt.lastOrNull(this.messages);
        if (entityMessage2 != null && (msgId = entityMessage2.getMsgId()) != null) {
            j2 = msgId.getSequenceNumber();
        }
        this.messageRange = new LongRange(sequenceNumber, j2);
        this.itemCount = this.messages.size();
        this.itemCountWithTime = this.itemCount + 1;
    }

    public final Instant getTimestamp() {
        return this.timestamp;
    }

    public final String getTimeDescription() {
        return this.timeDescription;
    }

    public final List<EntityMessage> getMessages() {
        return this.messages;
    }

    public final LongRange getMessageRange() {
        return this.messageRange;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final int getItemCountWithTime() {
        return this.itemCountWithTime;
    }
}