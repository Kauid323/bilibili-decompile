package kntr.app.im.chat.service.personal;

import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KHintTextModule;
import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KSystemHintFrame;
import im.base.IMLog;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.dao.PushInfoMessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.entity.SessionPushInfoMessage;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.im.chat.frame.hint.SystemHintFrame;
import kntr.app.im.chat.module.notifyText.HintTextModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.datetime.Instant;

/* compiled from: PushInfoMsgService.kt */
@ChatScope
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0086@¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001cH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkntr/app/im/chat/service/personal/PushInfoMsgService;", RoomRecommendViewModel.EMPTY_CURSOR, "dbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "sessionId", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "messageDatabaseService", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "<init>", "(Lkntr/app/im/chat/db/SessionIdDbConverters;Lkntr/app/im/chat/db/DatabaseService;Lkntr/app/im/chat/di/module/personal/PersonalChat;Lkntr/app/im/chat/core/service/MessageDatabaseService;)V", "infoDao", "Lkntr/app/im/chat/db/dao/PushInfoMessageDao;", "dbSession", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "checkMessageDisplayPushInfo", RoomRecommendViewModel.EMPTY_CURSOR, "info", "Lcom/bapis/bilibili/app/im/v1/KChatHintMessages$KPushInfoMessage;", "messages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lcom/bapis/bilibili/app/im/v1/KChatHintMessages$KPushInfoMessage;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendPhaseTwoInfoForMessage", "messageSequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "relatedTimeStamp", "Lkotlinx/datetime/Instant;", "(Lcom/bapis/bilibili/app/im/v1/KChatHintMessages$KPushInfoMessage;Lkntr/app/im/chat/core/model/MessageSequence;Lkotlinx/datetime/Instant;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPushHintMessage", "paragraph", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;", "phase", RoomRecommendViewModel.EMPTY_CURSOR, "sequence", "time", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushInfoMsgService {
    public static final int $stable = 8;
    private final SessionIdEntity dbSession;
    private final PushInfoMessageDao infoDao;
    private final MessageDatabaseService messageDatabaseService;
    private final PersonalChat sessionId;

    @Inject
    public PushInfoMsgService(SessionIdDbConverters dbConverters, DatabaseService databaseService, PersonalChat sessionId, MessageDatabaseService messageDatabaseService) {
        Intrinsics.checkNotNullParameter(dbConverters, "dbConverters");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
        this.sessionId = sessionId;
        this.messageDatabaseService = messageDatabaseService;
        this.infoDao = databaseService.getDb().pushInfoDao();
        this.dbSession = dbConverters.convertToEntity(this.sessionId);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkMessageDisplayPushInfo(KChatHintMessages.KPushInfoMessage info, List<EntityMessage> list, Continuation<? super Unit> continuation) {
        Continuation pushInfoMsgService$checkMessageDisplayPushInfo$1;
        List list2;
        KChatHintMessages.KPushInfoMessage info2;
        Object obj;
        SessionPushInfoMessage sessionPushInfoMessage;
        KParagraph paragraph;
        Object obj2;
        List<EntityMessage> list3;
        int $i$f$runSuspendCatching;
        Object savePhaseOnePushInfoMessage;
        Object obj3;
        Throwable e;
        if (continuation instanceof PushInfoMsgService$checkMessageDisplayPushInfo$1) {
            pushInfoMsgService$checkMessageDisplayPushInfo$1 = (PushInfoMsgService$checkMessageDisplayPushInfo$1) continuation;
            if ((pushInfoMsgService$checkMessageDisplayPushInfo$1.label & Integer.MIN_VALUE) != 0) {
                pushInfoMsgService$checkMessageDisplayPushInfo$1.label -= Integer.MIN_VALUE;
                Object $result = pushInfoMsgService$checkMessageDisplayPushInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushInfoMsgService$checkMessageDisplayPushInfo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (info != null && info.getPushInfo1() != null) {
                            if (info.getPushInfo2() != null) {
                                PushInfoMessageDao pushInfoMessageDao = this.infoDao;
                                SessionIdEntity sessionIdEntity = this.dbSession;
                                pushInfoMsgService$checkMessageDisplayPushInfo$1.L$0 = info;
                                list2 = list;
                                pushInfoMsgService$checkMessageDisplayPushInfo$1.L$1 = list2;
                                pushInfoMsgService$checkMessageDisplayPushInfo$1.label = 1;
                                Object pushInfo = pushInfoMessageDao.getPushInfo(sessionIdEntity, pushInfoMsgService$checkMessageDisplayPushInfo$1);
                                if (pushInfo != coroutine_suspended) {
                                    info2 = info;
                                    obj = pushInfo;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        IMLog.Companion.w("PushInfo", "PushMessageAdditionalInfoHolder无效，无法处理推送信息");
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        list2 = (List) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$1;
                        info2 = (KChatHintMessages.KPushInfoMessage) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$0;
                        obj = $result;
                        break;
                    case 2:
                        int i = pushInfoMsgService$checkMessageDisplayPushInfo$1.I$2;
                        int i2 = pushInfoMsgService$checkMessageDisplayPushInfo$1.I$1;
                        $i$f$runSuspendCatching = pushInfoMsgService$checkMessageDisplayPushInfo$1.I$0;
                        PushInfoMsgService$checkMessageDisplayPushInfo$1 pushInfoMsgService$checkMessageDisplayPushInfo$12 = (PushInfoMsgService$checkMessageDisplayPushInfo$1) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$7;
                        MessageEntity messageEntity = (MessageEntity) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$6;
                        EntityMessage entityMessage = (EntityMessage) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$5;
                        EntityMessage entityMessage2 = (EntityMessage) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$4;
                        KParagraph kParagraph = (KParagraph) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$3;
                        SessionPushInfoMessage sessionPushInfoMessage2 = (SessionPushInfoMessage) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$2;
                        list3 = (List) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$1;
                        KChatHintMessages.KPushInfoMessage kPushInfoMessage = (KChatHintMessages.KPushInfoMessage) pushInfoMsgService$checkMessageDisplayPushInfo$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            savePhaseOnePushInfoMessage = $result;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(pushInfoMsgService$checkMessageDisplayPushInfo$1.getContext());
                            e = Result.exceptionOrNull-impl(obj3);
                            if (e != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        try {
                            obj3 = Result.constructor-impl(Boxing.boxLong(((Number) savePhaseOnePushInfoMessage).longValue()));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(pushInfoMsgService$checkMessageDisplayPushInfo$1.getContext());
                            e = Result.exceptionOrNull-impl(obj3);
                            if (e != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        JobKt.ensureActive(pushInfoMsgService$checkMessageDisplayPushInfo$1.getContext());
                        e = Result.exceptionOrNull-impl(obj3);
                        if (e != null) {
                            IMLog.Companion.e("PushInfo", "保存推送信息第一阶段提示消息失败", e);
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sessionPushInfoMessage = (SessionPushInfoMessage) obj;
                if (sessionPushInfoMessage == null) {
                    sessionPushInfoMessage = new SessionPushInfoMessage(this.dbSession, null, 2, null);
                }
                SessionPushInfoMessage currentInfo = sessionPushInfoMessage;
                paragraph = info2.getPushInfo1();
                if (paragraph != null) {
                    return Unit.INSTANCE;
                }
                List $this$lastOrNull$iv = list2;
                ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
                while (true) {
                    if (iterator$iv.hasPrevious()) {
                        Object element$iv = iterator$iv.previous();
                        EntityMessage it = (EntityMessage) element$iv;
                        if (Intrinsics.areEqual(it.getMsgType(), KEntityMsgType.ENTITY_MSG_TYPE_WORKS_PUSH.INSTANCE)) {
                            obj2 = element$iv;
                        }
                    } else {
                        obj2 = null;
                    }
                }
                EntityMessage pushMessage = (EntityMessage) obj2;
                if (pushMessage != null && currentInfo.getPhaseOneId() == null) {
                    EntityMessage hintMessage = buildPushHintMessage(paragraph, 1, pushMessage.getMsgId().getSequence(), pushMessage.getTimestamp());
                    IMLog.Companion.i("PushInfo", "为消息" + pushMessage.getMsgId() + "添加推送信息第一阶段提示, seq no " + hintMessage.getMsgId().getSequence());
                    MessageEntity messageEntity2 = this.messageDatabaseService.convertMessageToEntity(hintMessage);
                    Continuation $completion$iv = pushInfoMsgService$checkMessageDisplayPushInfo$1;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        PushInfoMessageDao pushInfoMessageDao2 = this.infoDao;
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$0 = SpillingKt.nullOutSpilledVariable(info2);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$2 = SpillingKt.nullOutSpilledVariable(currentInfo);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$3 = SpillingKt.nullOutSpilledVariable(paragraph);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$4 = SpillingKt.nullOutSpilledVariable(pushMessage);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$5 = SpillingKt.nullOutSpilledVariable(hintMessage);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$6 = SpillingKt.nullOutSpilledVariable(messageEntity2);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.L$7 = SpillingKt.nullOutSpilledVariable($completion$iv);
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.I$0 = 0;
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.I$1 = 0;
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.I$2 = 0;
                        pushInfoMsgService$checkMessageDisplayPushInfo$1.label = 2;
                        savePhaseOnePushInfoMessage = pushInfoMessageDao2.savePhaseOnePushInfoMessage(currentInfo, messageEntity2, pushInfoMsgService$checkMessageDisplayPushInfo$1);
                    } catch (Throwable th3) {
                        th = th3;
                        list3 = list2;
                        $i$f$runSuspendCatching = 0;
                        Result.Companion companion22 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        JobKt.ensureActive(pushInfoMsgService$checkMessageDisplayPushInfo$1.getContext());
                        e = Result.exceptionOrNull-impl(obj3);
                        if (e != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (savePhaseOnePushInfoMessage == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list3 = list2;
                    $i$f$runSuspendCatching = 0;
                    obj3 = Result.constructor-impl(Boxing.boxLong(((Number) savePhaseOnePushInfoMessage).longValue()));
                    JobKt.ensureActive(pushInfoMsgService$checkMessageDisplayPushInfo$1.getContext());
                    e = Result.exceptionOrNull-impl(obj3);
                    if (e != null) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        pushInfoMsgService$checkMessageDisplayPushInfo$1 = new PushInfoMsgService$checkMessageDisplayPushInfo$1(this, continuation);
        Object $result2 = pushInfoMsgService$checkMessageDisplayPushInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushInfoMsgService$checkMessageDisplayPushInfo$1.label) {
        }
        sessionPushInfoMessage = (SessionPushInfoMessage) obj;
        if (sessionPushInfoMessage == null) {
        }
        SessionPushInfoMessage currentInfo2 = sessionPushInfoMessage;
        paragraph = info2.getPushInfo1();
        if (paragraph != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object appendPhaseTwoInfoForMessage(KChatHintMessages.KPushInfoMessage info, MessageSequence messageSequence, Instant relatedTimeStamp, Continuation<? super Unit> continuation) {
        PushInfoMsgService$appendPhaseTwoInfoForMessage$1 pushInfoMsgService$appendPhaseTwoInfoForMessage$1;
        Instant relatedTimeStamp2;
        MessageSequence messageSequence2;
        KChatHintMessages.KPushInfoMessage info2;
        Object obj;
        SessionPushInfoMessage currentInfo;
        KParagraph paragraph;
        KChatHintMessages.KPushInfoMessage info3;
        MessageSequence messageSequence3;
        KParagraph paragraph2;
        Instant relatedTimeStamp3;
        Object savePhaseTwoPushInfoMessage;
        Object obj2;
        Throwable e;
        if (continuation instanceof PushInfoMsgService$appendPhaseTwoInfoForMessage$1) {
            pushInfoMsgService$appendPhaseTwoInfoForMessage$1 = (PushInfoMsgService$appendPhaseTwoInfoForMessage$1) continuation;
            if ((pushInfoMsgService$appendPhaseTwoInfoForMessage$1.label & Integer.MIN_VALUE) != 0) {
                pushInfoMsgService$appendPhaseTwoInfoForMessage$1.label -= Integer.MIN_VALUE;
                Object $result = pushInfoMsgService$appendPhaseTwoInfoForMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushInfoMsgService$appendPhaseTwoInfoForMessage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (info != null && info.getPushInfo1() != null) {
                            if (info.getPushInfo2() != null) {
                                PushInfoMessageDao pushInfoMessageDao = this.infoDao;
                                SessionIdEntity sessionIdEntity = this.dbSession;
                                pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$0 = info;
                                pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$1 = messageSequence;
                                relatedTimeStamp2 = relatedTimeStamp;
                                pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$2 = relatedTimeStamp2;
                                pushInfoMsgService$appendPhaseTwoInfoForMessage$1.label = 1;
                                Object pushInfo = pushInfoMessageDao.getPushInfo(sessionIdEntity, pushInfoMsgService$appendPhaseTwoInfoForMessage$1);
                                if (pushInfo != coroutine_suspended) {
                                    messageSequence2 = messageSequence;
                                    info2 = info;
                                    obj = pushInfo;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        Instant relatedTimeStamp4 = (Instant) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$2;
                        messageSequence2 = (MessageSequence) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$1;
                        ResultKt.throwOnFailure($result);
                        relatedTimeStamp2 = relatedTimeStamp4;
                        info2 = (KChatHintMessages.KPushInfoMessage) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$0;
                        obj = $result;
                        break;
                    case 2:
                        int i = pushInfoMsgService$appendPhaseTwoInfoForMessage$1.I$1;
                        int i2 = pushInfoMsgService$appendPhaseTwoInfoForMessage$1.I$0;
                        MessageEntity messageEntity = (MessageEntity) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$6;
                        EntityMessage entityMessage = (EntityMessage) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$5;
                        paragraph2 = (KParagraph) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$4;
                        SessionPushInfoMessage sessionPushInfoMessage = (SessionPushInfoMessage) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$3;
                        relatedTimeStamp3 = (Instant) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$2;
                        messageSequence3 = (MessageSequence) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$1;
                        info3 = (KChatHintMessages.KPushInfoMessage) pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            savePhaseTwoPushInfoMessage = $result;
                            obj2 = Result.constructor-impl(Boxing.boxLong(((Number) savePhaseTwoPushInfoMessage).longValue()));
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(pushInfoMsgService$appendPhaseTwoInfoForMessage$1.getContext());
                            e = Result.exceptionOrNull-impl(obj2);
                            if (e != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        JobKt.ensureActive(pushInfoMsgService$appendPhaseTwoInfoForMessage$1.getContext());
                        e = Result.exceptionOrNull-impl(obj2);
                        if (e != null) {
                            IMLog.Companion.e("PushInfo", "保存推送信息第二阶段提示消息失败", e);
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                currentInfo = (SessionPushInfoMessage) obj;
                if (currentInfo == null && (paragraph = info2.getPushInfo2()) != null) {
                    if (currentInfo.getPhaseOneId() != null) {
                        EntityMessage hintMessage = buildPushHintMessage(paragraph, 2, messageSequence2, relatedTimeStamp2);
                        IMLog.Companion.i("PushInfo", "为消息" + messageSequence2 + "添加推送信息第二阶段提示, seq no " + hintMessage.getMsgId().getSequence());
                        MessageEntity messageEntity2 = this.messageDatabaseService.convertMessageToEntity(hintMessage);
                        try {
                            Result.Companion companion2 = Result.Companion;
                            PushInfoMessageDao pushInfoMessageDao2 = this.infoDao;
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$0 = SpillingKt.nullOutSpilledVariable(info2);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(messageSequence2);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(relatedTimeStamp2);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$3 = SpillingKt.nullOutSpilledVariable(currentInfo);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$4 = SpillingKt.nullOutSpilledVariable(paragraph);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$5 = SpillingKt.nullOutSpilledVariable(hintMessage);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.L$6 = SpillingKt.nullOutSpilledVariable(messageEntity2);
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.I$0 = 0;
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.I$1 = 0;
                            pushInfoMsgService$appendPhaseTwoInfoForMessage$1.label = 2;
                            savePhaseTwoPushInfoMessage = pushInfoMessageDao2.savePhaseTwoPushInfoMessage(currentInfo, messageEntity2, pushInfoMsgService$appendPhaseTwoInfoForMessage$1);
                        } catch (Throwable th2) {
                            th = th2;
                            info3 = info2;
                            messageSequence3 = messageSequence2;
                            Instant instant = relatedTimeStamp2;
                            paragraph2 = paragraph;
                            relatedTimeStamp3 = instant;
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(pushInfoMsgService$appendPhaseTwoInfoForMessage$1.getContext());
                            e = Result.exceptionOrNull-impl(obj2);
                            if (e != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (savePhaseTwoPushInfoMessage == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        info3 = info2;
                        messageSequence3 = messageSequence2;
                        Instant instant2 = relatedTimeStamp2;
                        paragraph2 = paragraph;
                        relatedTimeStamp3 = instant2;
                        obj2 = Result.constructor-impl(Boxing.boxLong(((Number) savePhaseTwoPushInfoMessage).longValue()));
                        JobKt.ensureActive(pushInfoMsgService$appendPhaseTwoInfoForMessage$1.getContext());
                        e = Result.exceptionOrNull-impl(obj2);
                        if (e != null) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        pushInfoMsgService$appendPhaseTwoInfoForMessage$1 = new PushInfoMsgService$appendPhaseTwoInfoForMessage$1(this, continuation);
        Object $result2 = pushInfoMsgService$appendPhaseTwoInfoForMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushInfoMsgService$appendPhaseTwoInfoForMessage$1.label) {
        }
        currentInfo = (SessionPushInfoMessage) obj;
        if (currentInfo == null) {
            return Unit.INSTANCE;
        }
        if (currentInfo.getPhaseOneId() != null) {
        }
        return Unit.INSTANCE;
    }

    private final EntityMessage buildPushHintMessage(KParagraph paragraph, int phase, MessageSequence sequence, Instant time) {
        MessageId messageId = new MessageId(this.sessionId, 0L, sequence.nextSendSequence(phase));
        KEntityMsgType kEntityMsgType = KEntityMsgType.ENTITY_MSG_TYPE_TEXT.INSTANCE;
        return new EntityMessage(0L, messageId, kEntityMsgType, new SystemHintFrame(new KSystemHintFrame(CollectionsKt.listOf(new KMsgModule(new KMsgModule.KHintTextModule(new KHintTextModule(paragraph))))), CollectionsKt.listOf(new HintTextModule(new KMsgModule.KHintTextModule(new KHintTextModule(paragraph)), sequence, time))), time, null, false, SendStatus.Normal, null, null, false, false, null, 7937, null);
    }
}