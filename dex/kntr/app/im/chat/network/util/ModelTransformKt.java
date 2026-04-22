package kntr.app.im.chat.network.util;

import com.bapis.bilibili.app.im.v1.KEntityMsg;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KFetchDirection;
import com.bapis.bilibili.app.im.v1.KGhostMsg;
import com.bapis.bilibili.app.im.v1.KGhostMsgType;
import com.bapis.bilibili.app.im.v1.KMsgFrame;
import com.bapis.bilibili.app.im.v1.KMsgId;
import im.base.model.SessionId;
import kntr.app.im.chat.core.RequestMessagesPolicy;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.GhostMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.network.MsgFrameTransformers;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: ModelTransform.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0000¨\u0006\u0011"}, d2 = {"asMessageId", "Lkntr/app/im/chat/core/model/MessageId;", "Lcom/bapis/bilibili/app/im/v1/KMsgId;", "sessionId", "Lim/base/model/SessionId;", "asEntityMessage", "Lkntr/app/im/chat/core/model/EntityMessage;", "Lcom/bapis/bilibili/app/im/v1/KEntityMsg;", "transformers", "Lkntr/app/im/chat/network/MsgFrameTransformers;", "asKEntityMsg", "asGhostMessage", "Lkntr/app/im/chat/core/model/GhostMessage;", "Lcom/bapis/bilibili/app/im/v1/KGhostMsg;", "asKFetchDirection", "Lcom/bapis/bilibili/app/im/v1/KFetchDirection;", "Lkntr/app/im/chat/core/RequestMessagesPolicy;", "network_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModelTransformKt {

    /* compiled from: ModelTransform.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestMessagesPolicy.values().length];
            try {
                iArr[RequestMessagesPolicy.SEQUENCE_NUMBER_BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RequestMessagesPolicy.SEQUENCE_NUMBER_AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final MessageId asMessageId(KMsgId $this$asMessageId, SessionId sessionId) {
        Intrinsics.checkNotNullParameter($this$asMessageId, "<this>");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new MessageId(sessionId, $this$asMessageId.getMsgKey(), $this$asMessageId.getSequenceNumber(), $this$asMessageId.getSubSequenceNumber());
    }

    public static final EntityMessage asEntityMessage(KEntityMsg $this$asEntityMessage, SessionId sessionId, MsgFrameTransformers transformers) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter($this$asEntityMessage, "<this>");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        KMsgFrame msgFrame = $this$asEntityMessage.getMsgFrame();
        KMsgId msgId = $this$asEntityMessage.getMsgId();
        MessageId msgId2 = msgId != null ? asMessageId(msgId, sessionId) : null;
        if (msgFrame != null) {
            if (msgId2 != null) {
                if (!Intrinsics.areEqual(msgId2.getSessionId(), sessionId)) {
                    throw new IllegalArgumentException(("EntityMsg sessionId not belongs to current session. msgId.sessionId is " + msgId2.getSessionId() + ", but current is " + sessionId).toString());
                }
                long j2 = $this$asEntityMessage.isTemporary() ? -msgId2.getSequenceNumber() : 0L;
                KEntityMsgType msgType = $this$asEntityMessage.getMsgType();
                MsgFrame transformToMsgFrame = transformers.transformToMsgFrame(msgFrame);
                String it = $this$asEntityMessage.getSendToken();
                return new EntityMessage(j2, msgId2, msgType, transformToMsgFrame, Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$asEntityMessage.getTimestamp(), 0L, 2, (Object) null), it.length() > 0 ? it : null, $this$asEntityMessage.isHidden(), null, null, null, $this$asEntityMessage.isRealtimeMsg(), $this$asEntityMessage.isTemporary(), $this$asEntityMessage.getTraceParams(), 896, null);
            }
            throw new IllegalArgumentException("EntityMsg.msgId is required but null".toString());
        }
        throw new IllegalArgumentException("EntityMsg.msgFrame is required but null".toString());
    }

    public static final KEntityMsg asKEntityMsg(EntityMessage $this$asKEntityMsg, MsgFrameTransformers transformers) {
        Intrinsics.checkNotNullParameter($this$asKEntityMsg, "<this>");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        KMsgId kMsgId = new KMsgId($this$asKEntityMsg.getMsgId().getMsgKey(), $this$asKEntityMsg.getMsgId().getSequenceNumber(), 0L, 4, (DefaultConstructorMarker) null);
        KEntityMsgType msgType = $this$asKEntityMsg.getMsgType();
        KMsgFrame transformToKFrame = transformers.transformToKFrame($this$asKEntityMsg.getMsgFrame());
        String token = $this$asKEntityMsg.getToken();
        if (token == null) {
            token = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        String str = token;
        return new KEntityMsg(kMsgId, msgType, transformToKFrame, $this$asKEntityMsg.getTimestamp().getEpochSeconds(), $this$asKEntityMsg.isHidden(), $this$asKEntityMsg.getTraceParams(), str, $this$asKEntityMsg.isRealtimeMessage(), false, 256, (DefaultConstructorMarker) null);
    }

    public static final GhostMessage asGhostMessage(KGhostMsg $this$asGhostMessage, SessionId sessionId) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter($this$asGhostMessage, "<this>");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        KMsgId msgId = $this$asGhostMessage.getMsgId();
        MessageId msgId2 = msgId != null ? asMessageId(msgId, sessionId) : null;
        if (msgId2 != null) {
            if (!Intrinsics.areEqual(msgId2.getSessionId(), sessionId)) {
                throw new IllegalArgumentException(("EntityMsg sessionId not belongs to current session. msgId.sessionId is " + msgId2.getSessionId() + ", but current is " + sessionId).toString());
            }
            KGhostMsgType msgType = $this$asGhostMessage.getMsgType();
            KMsgId associatedMsgId = $this$asGhostMessage.getAssociatedMsgId();
            return new GhostMessage(msgId2, msgType, associatedMsgId != null ? asMessageId(associatedMsgId, sessionId) : null);
        }
        throw new IllegalArgumentException("GhostMsg.msgId is necessary but null".toString());
    }

    public static final KFetchDirection asKFetchDirection(RequestMessagesPolicy $this$asKFetchDirection) {
        Intrinsics.checkNotNullParameter($this$asKFetchDirection, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$asKFetchDirection.ordinal()]) {
            case 1:
                return KFetchDirection.FETCH_DIRECTION_EARLIER.INSTANCE;
            case 2:
                return KFetchDirection.FETCH_DIRECTION_LATER.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}