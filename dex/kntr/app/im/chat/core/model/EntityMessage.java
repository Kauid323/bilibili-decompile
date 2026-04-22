package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bilibili.blens.Lens;
import java.util.Map;
import kntr.app.im.chat.core.model.ItemKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: Message.kt */
@Lens
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GB\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u000bHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\u0015\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017HÆ\u0003J\u0099\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017HÆ\u0001J\u0013\u0010A\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010&R\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010&R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b2\u0010&¨\u0006H"}, d2 = {"Lkntr/app/im/chat/core/model/EntityMessage;", "Lkntr/app/im/chat/core/model/Message;", "entityKey", RoomRecommendViewModel.EMPTY_CURSOR, "msgId", "Lkntr/app/im/chat/core/model/MessageId;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "msgFrame", "Lkntr/app/im/chat/core/model/MsgFrame;", "timestamp", "Lkotlinx/datetime/Instant;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "isHidden", RoomRecommendViewModel.EMPTY_CURSOR, "sendStatus", "Lkntr/app/im/chat/core/model/SendStatus;", "createTime", "updateTime", "isRealtimeMessage", "isTemporaryMsg", "traceParams", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLkntr/app/im/chat/core/model/MessageId;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lkntr/app/im/chat/core/model/MsgFrame;Lkotlinx/datetime/Instant;Ljava/lang/String;ZLkntr/app/im/chat/core/model/SendStatus;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;ZZLjava/util/Map;)V", "getEntityKey", "()J", "getMsgId", "()Lkntr/app/im/chat/core/model/MessageId;", "getMsgType", "()Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "getMsgFrame", "()Lkntr/app/im/chat/core/model/MsgFrame;", "getTimestamp", "()Lkotlinx/datetime/Instant;", "getToken", "()Ljava/lang/String;", "()Z", "getSendStatus", "()Lkntr/app/im/chat/core/model/SendStatus;", "getCreateTime", "getUpdateTime", "getTraceParams", "()Ljava/util/Map;", "itemKey", "Lkntr/app/im/chat/core/model/ItemKey;", "getItemKey", "()Lkntr/app/im/chat/core/model/ItemKey;", "needUpdate", "getNeedUpdate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EntityMessage implements Message {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Instant createTime;
    private final long entityKey;
    private final boolean isHidden;
    private final boolean isRealtimeMessage;
    private final boolean isTemporaryMsg;
    private final ItemKey itemKey;
    private final MsgFrame msgFrame;
    private final MessageId msgId;
    private final KEntityMsgType msgType;
    private final SendStatus sendStatus;
    private final Instant timestamp;
    private final String token;
    private final Map<String, String> traceParams;
    private final Instant updateTime;

    public final long component1() {
        return this.entityKey;
    }

    public final Instant component10() {
        return this.updateTime;
    }

    public final boolean component11() {
        return this.isRealtimeMessage;
    }

    public final boolean component12() {
        return this.isTemporaryMsg;
    }

    public final Map<String, String> component13() {
        return this.traceParams;
    }

    public final MessageId component2() {
        return this.msgId;
    }

    public final KEntityMsgType component3() {
        return this.msgType;
    }

    public final MsgFrame component4() {
        return this.msgFrame;
    }

    public final Instant component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.token;
    }

    public final boolean component7() {
        return this.isHidden;
    }

    public final SendStatus component8() {
        return this.sendStatus;
    }

    public final Instant component9() {
        return this.createTime;
    }

    public final EntityMessage copy(long j2, MessageId messageId, KEntityMsgType kEntityMsgType, MsgFrame msgFrame, Instant instant, String str, boolean z, SendStatus sendStatus, Instant instant2, Instant instant3, boolean z2, boolean z3, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(messageId, "msgId");
        Intrinsics.checkNotNullParameter(kEntityMsgType, "msgType");
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        Intrinsics.checkNotNullParameter(instant, "timestamp");
        Intrinsics.checkNotNullParameter(sendStatus, "sendStatus");
        Intrinsics.checkNotNullParameter(instant2, "createTime");
        Intrinsics.checkNotNullParameter(instant3, "updateTime");
        Intrinsics.checkNotNullParameter(map, "traceParams");
        return new EntityMessage(j2, messageId, kEntityMsgType, msgFrame, instant, str, z, sendStatus, instant2, instant3, z2, z3, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EntityMessage) {
            EntityMessage entityMessage = (EntityMessage) obj;
            return this.entityKey == entityMessage.entityKey && Intrinsics.areEqual(this.msgId, entityMessage.msgId) && Intrinsics.areEqual(this.msgType, entityMessage.msgType) && Intrinsics.areEqual(this.msgFrame, entityMessage.msgFrame) && Intrinsics.areEqual(this.timestamp, entityMessage.timestamp) && Intrinsics.areEqual(this.token, entityMessage.token) && this.isHidden == entityMessage.isHidden && this.sendStatus == entityMessage.sendStatus && Intrinsics.areEqual(this.createTime, entityMessage.createTime) && Intrinsics.areEqual(this.updateTime, entityMessage.updateTime) && this.isRealtimeMessage == entityMessage.isRealtimeMessage && this.isTemporaryMsg == entityMessage.isTemporaryMsg && Intrinsics.areEqual(this.traceParams, entityMessage.traceParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.entityKey) * 31) + this.msgId.hashCode()) * 31) + this.msgType.hashCode()) * 31) + this.msgFrame.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + (this.token == null ? 0 : this.token.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isHidden)) * 31) + this.sendStatus.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.updateTime.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRealtimeMessage)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isTemporaryMsg)) * 31) + this.traceParams.hashCode();
    }

    public String toString() {
        long j2 = this.entityKey;
        MessageId messageId = this.msgId;
        KEntityMsgType kEntityMsgType = this.msgType;
        MsgFrame msgFrame = this.msgFrame;
        Instant instant = this.timestamp;
        String str = this.token;
        boolean z = this.isHidden;
        SendStatus sendStatus = this.sendStatus;
        Instant instant2 = this.createTime;
        Instant instant3 = this.updateTime;
        boolean z2 = this.isRealtimeMessage;
        boolean z3 = this.isTemporaryMsg;
        return "EntityMessage(entityKey=" + j2 + ", msgId=" + messageId + ", msgType=" + kEntityMsgType + ", msgFrame=" + msgFrame + ", timestamp=" + instant + ", token=" + str + ", isHidden=" + z + ", sendStatus=" + sendStatus + ", createTime=" + instant2 + ", updateTime=" + instant3 + ", isRealtimeMessage=" + z2 + ", isTemporaryMsg=" + z3 + ", traceParams=" + this.traceParams + ")";
    }

    public EntityMessage(long entityKey, MessageId msgId, KEntityMsgType msgType, MsgFrame msgFrame, Instant timestamp, String token, boolean isHidden, SendStatus sendStatus, Instant createTime, Instant updateTime, boolean isRealtimeMessage, boolean isTemporaryMsg, Map<String, String> map) {
        ItemKey.Sending sending;
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(sendStatus, "sendStatus");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        Intrinsics.checkNotNullParameter(map, "traceParams");
        this.entityKey = entityKey;
        this.msgId = msgId;
        this.msgType = msgType;
        this.msgFrame = msgFrame;
        this.timestamp = timestamp;
        this.token = token;
        this.isHidden = isHidden;
        this.sendStatus = sendStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isRealtimeMessage = isRealtimeMessage;
        this.isTemporaryMsg = isTemporaryMsg;
        this.traceParams = map;
        if (this.entityKey > 0) {
            sending = new ItemKey.Message(this.entityKey);
        } else {
            String str = this.token;
            sending = new ItemKey.Sending(str == null ? RoomRecommendViewModel.EMPTY_CURSOR : str);
        }
        this.itemKey = sending;
    }

    public /* synthetic */ EntityMessage(long j2, MessageId messageId, KEntityMsgType kEntityMsgType, MsgFrame msgFrame, Instant instant, String str, boolean z, SendStatus sendStatus, Instant instant2, Instant instant3, boolean z2, boolean z3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? MessageId.Companion.getEmpty() : messageId, kEntityMsgType, msgFrame, instant, (i & 32) != 0 ? null : str, (i & 64) != 0 ? false : z, (i & 128) != 0 ? SendStatus.Normal : sendStatus, (i & 256) != 0 ? Clock.System.INSTANCE.now() : instant2, (i & 512) != 0 ? Clock.System.INSTANCE.now() : instant3, (i & 1024) != 0 ? false : z2, (i & 2048) != 0 ? false : z3, (i & 4096) != 0 ? MapsKt.emptyMap() : map);
    }

    public final long getEntityKey() {
        return this.entityKey;
    }

    @Override // kntr.app.im.chat.core.model.Message
    public MessageId getMsgId() {
        return this.msgId;
    }

    public final KEntityMsgType getMsgType() {
        return this.msgType;
    }

    public final MsgFrame getMsgFrame() {
        return this.msgFrame;
    }

    public final Instant getTimestamp() {
        return this.timestamp;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final SendStatus getSendStatus() {
        return this.sendStatus;
    }

    public final Instant getCreateTime() {
        return this.createTime;
    }

    public final Instant getUpdateTime() {
        return this.updateTime;
    }

    public final boolean isRealtimeMessage() {
        return this.isRealtimeMessage;
    }

    public final boolean isTemporaryMsg() {
        return this.isTemporaryMsg;
    }

    public final Map<String, String> getTraceParams() {
        return this.traceParams;
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/EntityMessage$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ItemKey getItemKey() {
        return this.itemKey;
    }

    public final boolean getNeedUpdate() {
        return this.isRealtimeMessage || this.msgFrame.getRequireUpdate();
    }
}