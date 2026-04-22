package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.entity.SessionPushInfoMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* compiled from: PushInfoMessageDao.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0097@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0097@¢\u0006\u0002\u0010\u0016¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/PushInfoMessageDao;", RoomRecommendViewModel.EMPTY_CURSOR, "getPushInfo", "Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionIdEntity", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPushInfoMessage", "pushInfoMessage", "Lkntr/app/im/chat/db/entity/MessageEntity;", "(Lkntr/app/im/chat/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPushInfoRecord", "pushInfoRecord", "(Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePhaseOnePushInfoMessage", "(Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;Lkntr/app/im/chat/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePhaseTwoPushInfoMessage", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PushInfoMessageDao {
    Object getPushInfo(int i, long j2, long j3, long j4, Continuation<? super SessionPushInfoMessage> continuation);

    Object getPushInfo(SessionIdEntity sessionIdEntity, Continuation<? super SessionPushInfoMessage> continuation);

    Object insertPushInfoMessage(MessageEntity messageEntity, Continuation<? super Long> continuation);

    Object insertPushInfoRecord(SessionPushInfoMessage sessionPushInfoMessage, Continuation<? super Long> continuation);

    Object savePhaseOnePushInfoMessage(SessionPushInfoMessage sessionPushInfoMessage, MessageEntity messageEntity, Continuation<? super Long> continuation);

    Object savePhaseTwoPushInfoMessage(SessionPushInfoMessage sessionPushInfoMessage, MessageEntity messageEntity, Continuation<? super Long> continuation);

    /* compiled from: PushInfoMessageDao.kt */
    /* renamed from: kntr.app.im.chat.db.dao.PushInfoMessageDao$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object getPushInfo$suspendImpl(PushInfoMessageDao $this, SessionIdEntity sessionIdEntity, Continuation<? super SessionPushInfoMessage> continuation) {
            return $this.getPushInfo(sessionIdEntity.getSessionType(), sessionIdEntity.getPrimaryId(), sessionIdEntity.getSecondaryId(), sessionIdEntity.getThirdId(), continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00a4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object savePhaseOnePushInfoMessage$suspendImpl(PushInfoMessageDao $this, SessionPushInfoMessage pushInfoRecord, MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
            PushInfoMessageDao$savePhaseOnePushInfoMessage$1 pushInfoMessageDao$savePhaseOnePushInfoMessage$1;
            Object insertPushInfoMessage;
            SessionPushInfoMessage recordWithIds;
            long messageId;
            if (continuation instanceof PushInfoMessageDao$savePhaseOnePushInfoMessage$1) {
                pushInfoMessageDao$savePhaseOnePushInfoMessage$1 = (PushInfoMessageDao$savePhaseOnePushInfoMessage$1) continuation;
                if ((pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label & Integer.MIN_VALUE) != 0) {
                    pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label -= Integer.MIN_VALUE;
                    Object $result = pushInfoMessageDao$savePhaseOnePushInfoMessage$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$0 = $this;
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$1 = pushInfoRecord;
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(pushInfoMessage);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label = 1;
                            insertPushInfoMessage = $this.insertPushInfoMessage(pushInfoMessage, pushInfoMessageDao$savePhaseOnePushInfoMessage$1);
                            if (insertPushInfoMessage == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            long messageId2 = ((Number) insertPushInfoMessage).longValue();
                            recordWithIds = SessionPushInfoMessage.copy$default(pushInfoRecord, null, Boxing.boxLong(messageId2), 1, null);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(pushInfoRecord);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(pushInfoMessage);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$3 = SpillingKt.nullOutSpilledVariable(recordWithIds);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.J$0 = messageId2;
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label = 2;
                            if ($this.insertPushInfoRecord(recordWithIds, pushInfoMessageDao$savePhaseOnePushInfoMessage$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            messageId = messageId2;
                            return Boxing.boxLong(messageId);
                        case 1:
                            pushInfoMessage = (MessageEntity) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$2;
                            pushInfoRecord = (SessionPushInfoMessage) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$1;
                            $this = (PushInfoMessageDao) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$0;
                            ResultKt.throwOnFailure($result);
                            insertPushInfoMessage = $result;
                            long messageId22 = ((Number) insertPushInfoMessage).longValue();
                            recordWithIds = SessionPushInfoMessage.copy$default(pushInfoRecord, null, Boxing.boxLong(messageId22), 1, null);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(pushInfoRecord);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(pushInfoMessage);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$3 = SpillingKt.nullOutSpilledVariable(recordWithIds);
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.J$0 = messageId22;
                            pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label = 2;
                            if ($this.insertPushInfoRecord(recordWithIds, pushInfoMessageDao$savePhaseOnePushInfoMessage$1) != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            messageId = pushInfoMessageDao$savePhaseOnePushInfoMessage$1.J$0;
                            SessionPushInfoMessage sessionPushInfoMessage = (SessionPushInfoMessage) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$3;
                            MessageEntity messageEntity = (MessageEntity) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$2;
                            SessionPushInfoMessage sessionPushInfoMessage2 = (SessionPushInfoMessage) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$1;
                            PushInfoMessageDao pushInfoMessageDao = (PushInfoMessageDao) pushInfoMessageDao$savePhaseOnePushInfoMessage$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return Boxing.boxLong(messageId);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            pushInfoMessageDao$savePhaseOnePushInfoMessage$1 = new PushInfoMessageDao$savePhaseOnePushInfoMessage$1($this, continuation);
            Object $result2 = pushInfoMessageDao$savePhaseOnePushInfoMessage$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (pushInfoMessageDao$savePhaseOnePushInfoMessage$1.label) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object savePhaseTwoPushInfoMessage$suspendImpl(PushInfoMessageDao $this, SessionPushInfoMessage pushInfoRecord, MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
            PushInfoMessageDao$savePhaseTwoPushInfoMessage$1 pushInfoMessageDao$savePhaseTwoPushInfoMessage$1;
            Object insertPushInfoMessage;
            if (continuation instanceof PushInfoMessageDao$savePhaseTwoPushInfoMessage$1) {
                pushInfoMessageDao$savePhaseTwoPushInfoMessage$1 = (PushInfoMessageDao$savePhaseTwoPushInfoMessage$1) continuation;
                if ((pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.label & Integer.MIN_VALUE) != 0) {
                    pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.label -= Integer.MIN_VALUE;
                    Object $result = pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(pushInfoRecord);
                            pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(pushInfoMessage);
                            pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.label = 1;
                            insertPushInfoMessage = $this.insertPushInfoMessage(pushInfoMessage, pushInfoMessageDao$savePhaseTwoPushInfoMessage$1);
                            if (insertPushInfoMessage == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            MessageEntity messageEntity = (MessageEntity) pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.L$2;
                            SessionPushInfoMessage sessionPushInfoMessage = (SessionPushInfoMessage) pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.L$1;
                            PushInfoMessageDao pushInfoMessageDao = (PushInfoMessageDao) pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.L$0;
                            ResultKt.throwOnFailure($result);
                            insertPushInfoMessage = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long messageId = ((Number) insertPushInfoMessage).longValue();
                    return Boxing.boxLong(messageId);
                }
            }
            pushInfoMessageDao$savePhaseTwoPushInfoMessage$1 = new PushInfoMessageDao$savePhaseTwoPushInfoMessage$1($this, continuation);
            Object $result2 = pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (pushInfoMessageDao$savePhaseTwoPushInfoMessage$1.label) {
            }
            long messageId2 = ((Number) insertPushInfoMessage).longValue();
            return Boxing.boxLong(messageId2);
        }
    }

    /* compiled from: PushInfoMessageDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object getPushInfo(PushInfoMessageDao $this, SessionIdEntity sessionIdEntity, Continuation<? super SessionPushInfoMessage> continuation) {
            return CC.getPushInfo$suspendImpl($this, sessionIdEntity, continuation);
        }

        @Deprecated
        public static Object savePhaseOnePushInfoMessage(PushInfoMessageDao $this, SessionPushInfoMessage pushInfoRecord, MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
            return CC.savePhaseOnePushInfoMessage$suspendImpl($this, pushInfoRecord, pushInfoMessage, continuation);
        }

        @Deprecated
        public static Object savePhaseTwoPushInfoMessage(PushInfoMessageDao $this, SessionPushInfoMessage pushInfoRecord, MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
            return CC.savePhaseTwoPushInfoMessage$suspendImpl($this, pushInfoRecord, pushInfoMessage, continuation);
        }
    }
}