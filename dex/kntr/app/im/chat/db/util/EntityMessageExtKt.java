package kntr.app.im.chat.db.util;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import im.base.IMLog;
import java.util.concurrent.CancellationException;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

/* compiled from: EntityMessageExt.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a,\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"messageContent", "Lkntr/app/im/chat/db/util/MessageContent;", "Lkntr/app/im/chat/core/model/EntityMessage;", "asEntity", "Lkntr/app/im/chat/db/entity/MessageEntity;", "json", "Lkotlinx/serialization/json/Json;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "toJsonString", RoomRecommendViewModel.EMPTY_CURSOR, "from", "Lkntr/app/im/chat/core/model/EntityMessage$Companion;", "entity", "sessionIdDbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "(Lkntr/app/im/chat/core/model/EntityMessage$Companion;Lkotlinx/serialization/json/Json;Lkntr/app/im/chat/db/entity/MessageEntity;Lkntr/app/im/chat/db/SessionIdDbConverters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EntityMessageExtKt {
    public static final MessageContent messageContent(EntityMessage $this$messageContent) {
        Intrinsics.checkNotNullParameter($this$messageContent, "<this>");
        return new MessageContent($this$messageContent.getMsgType(), $this$messageContent.getMsgFrame(), $this$messageContent.getTimestamp(), $this$messageContent.getTraceParams());
    }

    public static final MessageEntity asEntity(EntityMessage $this$asEntity, Json json, SessionIdEntity sessionId) throws SerializationException {
        Intrinsics.checkNotNullParameter($this$asEntity, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        long sequenceNumber = $this$asEntity.getMsgId().getSequenceNumber();
        long subSequenceNumber = $this$asEntity.getMsgId().getSubSequenceNumber();
        return new MessageEntity(0L, sessionId, $this$asEntity.getMsgId().getMsgKey(), sequenceNumber, subSequenceNumber, $this$asEntity.getToken(), toJsonString($this$asEntity, json), $this$asEntity.getSendStatus().getValue(), $this$asEntity.getCreateTime(), $this$asEntity.getUpdateTime(), $this$asEntity.isHidden() ? Clock.System.INSTANCE.now() : null, $this$asEntity.isRealtimeMessage(), 1, null);
    }

    public static final String toJsonString(EntityMessage $this$toJsonString, Json json) throws SerializationException {
        Intrinsics.checkNotNullParameter($this$toJsonString, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        return json.encodeToString(MessageContent.Companion.serializer(), messageContent($this$toJsonString));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object from(EntityMessage.Companion $this$from, Json json, MessageEntity entity, SessionIdDbConverters sessionIdDbConverters, Continuation<? super EntityMessage> continuation) throws SerializationException, IllegalArgumentException, CancellationException {
        EntityMessageExtKt$from$1 entityMessageExtKt$from$1;
        EntityMessageExtKt$from$1 entityMessageExtKt$from$12;
        Json json2;
        Object obj;
        Throwable it;
        MessageContent messageContent;
        MessageContent messageContent2;
        MessageId messageId;
        long j2;
        KEntityMsgType kEntityMsgType;
        Object obj2;
        MessageEntity entity2;
        SendStatus fromValue;
        if (continuation instanceof EntityMessageExtKt$from$1) {
            entityMessageExtKt$from$1 = (EntityMessageExtKt$from$1) continuation;
            if ((entityMessageExtKt$from$1.label & Integer.MIN_VALUE) != 0) {
                entityMessageExtKt$from$1.label -= Integer.MIN_VALUE;
                entityMessageExtKt$from$12 = entityMessageExtKt$from$1;
                Object $result = entityMessageExtKt$from$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (entityMessageExtKt$from$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            json2 = json;
                        } catch (Throwable th) {
                            th = th;
                            json2 = json;
                        }
                        try {
                            obj = Result.constructor-impl((MessageContent) json2.decodeFromString(MessageContent.Companion.serializer(), entity.getContent()));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            if (Result.isFailure-impl(obj)) {
                            }
                            messageContent = (MessageContent) obj;
                            if (messageContent == null) {
                            }
                        }
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            IMLog.Companion.e("EntityMessage", "decode message content failed, content=" + entity.getContent(), it);
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        messageContent = (MessageContent) obj;
                        if (messageContent == null) {
                            messageContent2 = messageContent;
                            long id = entity.getId();
                            MessageId messageId2 = new MessageId(sessionIdDbConverters.convertToSessionId(entity.getSessionId()), entity.getMsgKey(), entity.getSequenceNumber(), entity.getSubsequenceNumber());
                            KEntityMsgType msgType = messageContent2.getMsgType();
                            MsgFrame msgFrame = messageContent2.getMsgFrame();
                            entityMessageExtKt$from$12.L$0 = SpillingKt.nullOutSpilledVariable($this$from);
                            entityMessageExtKt$from$12.L$1 = SpillingKt.nullOutSpilledVariable(json);
                            entityMessageExtKt$from$12.L$2 = entity;
                            entityMessageExtKt$from$12.L$3 = SpillingKt.nullOutSpilledVariable(sessionIdDbConverters);
                            entityMessageExtKt$from$12.L$4 = messageContent2;
                            entityMessageExtKt$from$12.L$5 = messageId2;
                            entityMessageExtKt$from$12.L$6 = msgType;
                            entityMessageExtKt$from$12.J$0 = id;
                            entityMessageExtKt$from$12.label = 1;
                            Object restoreFrame = msgFrame.restoreFrame(entityMessageExtKt$from$12);
                            if (restoreFrame == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            messageId = messageId2;
                            j2 = id;
                            kEntityMsgType = msgType;
                            obj2 = restoreFrame;
                            entity2 = entity;
                            break;
                        } else {
                            return null;
                        }
                    case 1:
                        long j3 = entityMessageExtKt$from$12.J$0;
                        messageContent2 = (MessageContent) entityMessageExtKt$from$12.L$4;
                        SessionIdDbConverters sessionIdDbConverters2 = (SessionIdDbConverters) entityMessageExtKt$from$12.L$3;
                        entity2 = (MessageEntity) entityMessageExtKt$from$12.L$2;
                        Json json3 = (Json) entityMessageExtKt$from$12.L$1;
                        EntityMessage.Companion companion3 = (EntityMessage.Companion) entityMessageExtKt$from$12.L$0;
                        ResultKt.throwOnFailure($result);
                        kEntityMsgType = (KEntityMsgType) entityMessageExtKt$from$12.L$6;
                        obj2 = $result;
                        messageId = (MessageId) entityMessageExtKt$from$12.L$5;
                        j2 = j3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MsgFrame msgFrame2 = (MsgFrame) obj2;
                Instant timestamp = messageContent2.getTimestamp();
                String token = entity2.getToken();
                boolean z = entity2.getDeleteTime() != null;
                fromValue = SendStatus.Companion.fromValue(entity2.getSendStatus());
                if (fromValue == null) {
                    fromValue = SendStatus.Normal;
                }
                return new EntityMessage(j2, messageId, kEntityMsgType, msgFrame2, timestamp, token, z, fromValue, entity2.getCreateTime(), entity2.getUpdateTime(), entity2.isRealtimeMessage(), false, messageContent2.getTraceParams());
            }
        }
        entityMessageExtKt$from$1 = new EntityMessageExtKt$from$1(continuation);
        entityMessageExtKt$from$12 = entityMessageExtKt$from$1;
        Object $result2 = entityMessageExtKt$from$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (entityMessageExtKt$from$12.label) {
        }
        MsgFrame msgFrame22 = (MsgFrame) obj2;
        Instant timestamp2 = messageContent2.getTimestamp();
        String token2 = entity2.getToken();
        boolean z2 = entity2.getDeleteTime() != null;
        fromValue = SendStatus.Companion.fromValue(entity2.getSendStatus());
        if (fromValue == null) {
        }
        return new EntityMessage(j2, messageId, kEntityMsgType, msgFrame22, timestamp2, token2, z2, fromValue, entity2.getCreateTime(), entity2.getUpdateTime(), entity2.isRealtimeMessage(), false, messageContent2.getTraceParams());
    }
}