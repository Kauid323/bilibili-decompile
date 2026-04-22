package kntr.app.im.chat.db.service;

import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.app.im.chat.db.dao.SessionMessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.util.EntityMessageExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.serialization.json.Json;

/* compiled from: MessageDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00190\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J$\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010'J\u001e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010'J\u001c\u00102\u001a\u00020&2\f\u00103\u001a\b\u0012\u0004\u0012\u00020+0\u0019H\u0096@¢\u0006\u0002\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl;", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "json", "Lkotlinx/serialization/json/Json;", "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "sessionIdDbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "<init>", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlinx/serialization/json/Json;Lkntr/app/im/chat/db/DatabaseService;Lkntr/app/im/chat/db/SessionIdDbConverters;)V", "sessionMessageDao", "Lkntr/app/im/chat/db/dao/SessionMessageDao;", "messageDao", "Lkntr/app/im/chat/db/dao/MessageDao;", "sessionIdDao", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "convertMessageToEntity", "Lkntr/app/im/chat/db/entity/MessageEntity;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "queryInRangeAsList", "Lkotlin/Pair;", "Lkotlinx/datetime/Instant;", RoomRecommendViewModel.EMPTY_CURSOR, "range", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInRangeAsFlow", "Lkotlinx/coroutines/flow/Flow;", "baselineTime", "querySequenceNumberInRange", RoomRecommendViewModel.EMPTY_CURSOR, "limit", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/ranges/LongRange;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/core/model/EntityMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContent", "resend", "messageId", "Lkntr/app/im/chat/core/model/MessageId;", "newValue", "(Lkntr/app/im/chat/core/model/MessageId;Lkntr/app/im/chat/core/model/EntityMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFailed", "(Lkntr/app/im/chat/core/model/MessageId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSuccess", "server", "batchSoftDeleteMessages", "messageIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageDatabaseServiceImpl implements MessageDatabaseService {
    private final DatabaseService databaseService;
    private final Json json;
    private final MessageDao messageDao;
    private final SessionIdEntity sessionId;
    private final SessionIdDao sessionIdDao;
    private final SessionIdDbConverters sessionIdDbConverters;
    private final SessionMessageDao sessionMessageDao;

    @Inject
    public MessageDatabaseServiceImpl(SessionIdEntity sessionId, Json json, DatabaseService databaseService, SessionIdDbConverters sessionIdDbConverters) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        Intrinsics.checkNotNullParameter(sessionIdDbConverters, "sessionIdDbConverters");
        this.sessionId = sessionId;
        this.json = json;
        this.databaseService = databaseService;
        this.sessionIdDbConverters = sessionIdDbConverters;
        this.sessionMessageDao = this.databaseService.getDb().sessionMessageDao();
        this.messageDao = this.databaseService.getDb().messageDao();
        this.sessionIdDao = this.databaseService.getDb().sessionIdDao();
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public /* bridge */ Object add(List<EntityMessage> list, Continuation<? super Unit> continuation) {
        return MessageDatabaseService.CC.add$suspendImpl(this, list, continuation);
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public /* bridge */ Object updateContent(List<EntityMessage> list, Continuation<? super Unit> continuation) {
        return MessageDatabaseService.CC.updateContent$suspendImpl(this, list, continuation);
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public MessageEntity convertMessageToEntity(EntityMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return EntityMessageExtKt.asEntity(message, this.json, this.sessionId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01df  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x01a8 -> B:38:0x01c4). Please submit an issue!!! */
    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object queryInRangeAsList(LongRange range, Continuation<? super Pair<Instant, ? extends List<EntityMessage>>> continuation) {
        Continuation<? super List<MessageEntity>> continuation2;
        Object obj;
        Object $result;
        LongRange it$iv$iv;
        List messageWithSessionList;
        Iterator it;
        Instant instant;
        Instant baselineTime;
        List $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Iterable $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        int $i$f$forEach;
        Collection destination$iv$iv;
        Iterable $this$forEach$iv$iv$iv;
        Iterator it2;
        Object $result2;
        Object obj2;
        Continuation $completion;
        Object $result3;
        Iterator it3;
        int $i$f$mapNotNullTo2;
        Iterable $this$mapNotNullTo$iv$iv2;
        Object element$iv$iv;
        Collection destination$iv$iv2;
        int $i$f$forEach2;
        Iterable $this$forEach$iv$iv$iv2;
        Object $result4;
        MessageDatabaseServiceImpl messageDatabaseServiceImpl;
        LongRange range2;
        List messageWithSessionList2;
        EntityMessage entityMessage;
        MessageDatabaseServiceImpl messageDatabaseServiceImpl2 = this;
        if (continuation instanceof MessageDatabaseServiceImpl$queryInRangeAsList$1) {
            MessageDatabaseServiceImpl$queryInRangeAsList$1 messageDatabaseServiceImpl$queryInRangeAsList$1 = (MessageDatabaseServiceImpl$queryInRangeAsList$1) continuation;
            if ((messageDatabaseServiceImpl$queryInRangeAsList$1.label & Integer.MIN_VALUE) != 0) {
                messageDatabaseServiceImpl$queryInRangeAsList$1.label -= Integer.MIN_VALUE;
                continuation2 = messageDatabaseServiceImpl$queryInRangeAsList$1;
                Object $result5 = continuation2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (continuation2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result5);
                        SessionMessageDao sessionMessageDao = messageDatabaseServiceImpl2.sessionMessageDao;
                        int sessionType = messageDatabaseServiceImpl2.sessionId.getSessionType();
                        long primaryId = messageDatabaseServiceImpl2.sessionId.getPrimaryId();
                        long secondaryId = messageDatabaseServiceImpl2.sessionId.getSecondaryId();
                        long thirdId = messageDatabaseServiceImpl2.sessionId.getThirdId();
                        long first = range.getFirst();
                        long last = range.getLast();
                        continuation2.L$0 = SpillingKt.nullOutSpilledVariable(range);
                        continuation2.label = 1;
                        obj = coroutine_suspended;
                        $result = $result5;
                        $result5 = sessionMessageDao.queryInRangeAsList(sessionType, primaryId, secondaryId, thirdId, first, last, continuation2);
                        if ($result5 == obj) {
                            return obj;
                        }
                        it$iv$iv = range;
                        messageWithSessionList = (List) $result5;
                        it = messageWithSessionList.iterator();
                        if (it.hasNext()) {
                            instant = null;
                        } else {
                            MessageEntity it4 = (MessageEntity) it.next();
                            Instant instant2 = (Comparable) it4.getUpdateTime();
                            while (it.hasNext()) {
                                MessageEntity it5 = (MessageEntity) it.next();
                                Comparable comparable = (Comparable) it5.getUpdateTime();
                                if (instant2.compareTo(comparable) < 0) {
                                    instant2 = comparable;
                                }
                            }
                            instant = instant2;
                        }
                        baselineTime = instant;
                        if (baselineTime == null) {
                            baselineTime = Instant.Companion.getDISTANT_PAST();
                        }
                        $this$mapNotNull$iv = messageWithSessionList;
                        $i$f$mapNotNull = 0;
                        Collection destination$iv$iv3 = new ArrayList();
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                        $i$f$mapNotNullTo = 0;
                        $i$f$forEach = 0;
                        destination$iv$iv = destination$iv$iv3;
                        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                        it2 = $this$mapNotNullTo$iv$iv.iterator();
                        $result2 = $result;
                        obj2 = obj;
                        $completion = continuation;
                        if (!it2.hasNext()) {
                            Object element$iv$iv$iv = it2.next();
                            Continuation $completion2 = $completion;
                            Object $result6 = $result2;
                            MessageEntity it6 = (MessageEntity) element$iv$iv$iv;
                            Object obj3 = obj2;
                            EntityMessage.Companion companion = EntityMessage.Companion;
                            Json json = messageDatabaseServiceImpl2.json;
                            SessionIdDbConverters sessionIdDbConverters = messageDatabaseServiceImpl2.sessionIdDbConverters;
                            MessageDatabaseServiceImpl messageDatabaseServiceImpl3 = messageDatabaseServiceImpl2;
                            continuation2.L$0 = SpillingKt.nullOutSpilledVariable(it$iv$iv);
                            continuation2.L$1 = SpillingKt.nullOutSpilledVariable(messageWithSessionList);
                            continuation2.L$2 = baselineTime;
                            continuation2.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNull$iv);
                            continuation2.L$4 = SpillingKt.nullOutSpilledVariable($this$mapNotNullTo$iv$iv);
                            continuation2.L$5 = destination$iv$iv;
                            continuation2.L$6 = SpillingKt.nullOutSpilledVariable($this$forEach$iv$iv$iv);
                            continuation2.L$7 = it2;
                            continuation2.L$8 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv);
                            continuation2.L$9 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv);
                            continuation2.L$10 = SpillingKt.nullOutSpilledVariable(it6);
                            continuation2.I$0 = $i$f$mapNotNull;
                            continuation2.I$1 = $i$f$mapNotNullTo;
                            continuation2.I$2 = $i$f$forEach;
                            continuation2.I$3 = 0;
                            continuation2.I$4 = 0;
                            continuation2.label = 2;
                            Object from = EntityMessageExtKt.from(companion, json, it6, sessionIdDbConverters, continuation2);
                            if (from == obj3) {
                                return obj3;
                            }
                            $result3 = $result6;
                            it3 = it2;
                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                            $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                            element$iv$iv = from;
                            destination$iv$iv2 = destination$iv$iv;
                            $i$f$forEach2 = $i$f$forEach;
                            $this$forEach$iv$iv$iv2 = $this$forEach$iv$iv$iv;
                            $result4 = obj3;
                            $completion = $completion2;
                            messageDatabaseServiceImpl = messageDatabaseServiceImpl3;
                            List list = messageWithSessionList;
                            range2 = it$iv$iv;
                            messageWithSessionList2 = list;
                            entityMessage = (EntityMessage) element$iv$iv;
                            if (entityMessage != null) {
                                destination$iv$iv2.add(entityMessage);
                            }
                            it$iv$iv = range2;
                            $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                            $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv2;
                            it2 = it3;
                            $i$f$forEach = $i$f$forEach2;
                            obj2 = $result4;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                            $result2 = $result3;
                            messageWithSessionList = messageWithSessionList2;
                            destination$iv$iv = destination$iv$iv2;
                            messageDatabaseServiceImpl2 = messageDatabaseServiceImpl;
                            if (!it2.hasNext()) {
                                List entityMessageList = (List) destination$iv$iv;
                                return new Pair(baselineTime, entityMessageList);
                            }
                        }
                    case 1:
                        ResultKt.throwOnFailure($result5);
                        it$iv$iv = (LongRange) continuation2.L$0;
                        obj = coroutine_suspended;
                        $result = $result5;
                        messageWithSessionList = (List) $result5;
                        it = messageWithSessionList.iterator();
                        if (it.hasNext()) {
                        }
                        baselineTime = instant;
                        if (baselineTime == null) {
                        }
                        $this$mapNotNull$iv = messageWithSessionList;
                        $i$f$mapNotNull = 0;
                        Collection destination$iv$iv32 = new ArrayList();
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                        $i$f$mapNotNullTo = 0;
                        $i$f$forEach = 0;
                        destination$iv$iv = destination$iv$iv32;
                        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                        it2 = $this$mapNotNullTo$iv$iv.iterator();
                        $result2 = $result;
                        obj2 = obj;
                        $completion = continuation;
                        if (!it2.hasNext()) {
                        }
                        break;
                    case 2:
                        int i = continuation2.I$4;
                        int i2 = continuation2.I$3;
                        int $i$f$forEach3 = continuation2.I$2;
                        int $i$f$mapNotNullTo3 = continuation2.I$1;
                        $i$f$mapNotNull = continuation2.I$0;
                        MessageEntity messageEntity = (MessageEntity) continuation2.L$10;
                        Object obj4 = continuation2.L$9;
                        Object obj5 = continuation2.L$8;
                        $this$forEach$iv$iv$iv2 = (Iterable) continuation2.L$6;
                        Collection destination$iv$iv4 = (Collection) continuation2.L$5;
                        $this$mapNotNullTo$iv$iv2 = (Iterable) continuation2.L$4;
                        Iterable $this$mapNotNull$iv2 = (Iterable) continuation2.L$3;
                        Instant baselineTime2 = (Instant) continuation2.L$2;
                        messageWithSessionList2 = (List) continuation2.L$1;
                        ResultKt.throwOnFailure($result5);
                        messageDatabaseServiceImpl = messageDatabaseServiceImpl2;
                        destination$iv$iv2 = destination$iv$iv4;
                        range2 = (LongRange) continuation2.L$0;
                        $i$f$forEach2 = $i$f$forEach3;
                        baselineTime = baselineTime2;
                        $completion = continuation;
                        $result3 = $result5;
                        $result4 = coroutine_suspended;
                        it3 = (Iterator) continuation2.L$7;
                        $i$f$mapNotNullTo2 = $i$f$mapNotNullTo3;
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        element$iv$iv = $result3;
                        entityMessage = (EntityMessage) element$iv$iv;
                        if (entityMessage != null) {
                        }
                        it$iv$iv = range2;
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                        $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv2;
                        it2 = it3;
                        $i$f$forEach = $i$f$forEach2;
                        obj2 = $result4;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        $result2 = $result3;
                        messageWithSessionList = messageWithSessionList2;
                        destination$iv$iv = destination$iv$iv2;
                        messageDatabaseServiceImpl2 = messageDatabaseServiceImpl;
                        if (!it2.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        continuation2 = new MessageDatabaseServiceImpl$queryInRangeAsList$1(messageDatabaseServiceImpl2, continuation);
        Object $result52 = continuation2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (continuation2.label) {
        }
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public Flow<List<EntityMessage>> queryInRangeAsFlow(LongRange range, Instant baselineTime) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(baselineTime, "baselineTime");
        return FlowKt.flow(new MessageDatabaseServiceImpl$queryInRangeAsFlow$1(this, range, baselineTime, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object querySequenceNumberInRange(LongRange range, int limit, Continuation<? super List<Long>> continuation) {
        Continuation<? super List<Long>> messageDatabaseServiceImpl$querySequenceNumberInRange$1;
        if (continuation instanceof MessageDatabaseServiceImpl$querySequenceNumberInRange$1) {
            messageDatabaseServiceImpl$querySequenceNumberInRange$1 = (MessageDatabaseServiceImpl$querySequenceNumberInRange$1) continuation;
            if ((messageDatabaseServiceImpl$querySequenceNumberInRange$1.label & Integer.MIN_VALUE) != 0) {
                messageDatabaseServiceImpl$querySequenceNumberInRange$1.label -= Integer.MIN_VALUE;
                Object $result = messageDatabaseServiceImpl$querySequenceNumberInRange$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (messageDatabaseServiceImpl$querySequenceNumberInRange$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MessageDao messageDao = this.messageDao;
                        int sessionType = this.sessionId.getSessionType();
                        long primaryId = this.sessionId.getPrimaryId();
                        long secondaryId = this.sessionId.getSecondaryId();
                        long thirdId = this.sessionId.getThirdId();
                        long first = range.getFirst();
                        long last = range.getLast();
                        messageDatabaseServiceImpl$querySequenceNumberInRange$1.L$0 = SpillingKt.nullOutSpilledVariable(range);
                        messageDatabaseServiceImpl$querySequenceNumberInRange$1.I$0 = limit;
                        messageDatabaseServiceImpl$querySequenceNumberInRange$1.label = 1;
                        $result = messageDao.queryLaterSequenceNumberInRange(sessionType, primaryId, secondaryId, thirdId, first, last, limit, messageDatabaseServiceImpl$querySequenceNumberInRange$1);
                        if ($result != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = messageDatabaseServiceImpl$querySequenceNumberInRange$1.I$0;
                        LongRange longRange = (LongRange) messageDatabaseServiceImpl$querySequenceNumberInRange$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return CollectionsKt.reversed((Iterable) $result);
            }
        }
        messageDatabaseServiceImpl$querySequenceNumberInRange$1 = new MessageDatabaseServiceImpl$querySequenceNumberInRange$1(this, continuation);
        Object $result2 = messageDatabaseServiceImpl$querySequenceNumberInRange$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageDatabaseServiceImpl$querySequenceNumberInRange$1.label) {
        }
        return CollectionsKt.reversed((Iterable) $result2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object add(EntityMessage message, Continuation<? super Unit> continuation) {
        MessageDatabaseServiceImpl$add$1 messageDatabaseServiceImpl$add$1;
        SessionIdEntity sessionIdEntity;
        MessageEntity messageEntity;
        MessageDao messageDao;
        if (continuation instanceof MessageDatabaseServiceImpl$add$1) {
            messageDatabaseServiceImpl$add$1 = (MessageDatabaseServiceImpl$add$1) continuation;
            if ((messageDatabaseServiceImpl$add$1.label & Integer.MIN_VALUE) != 0) {
                messageDatabaseServiceImpl$add$1.label -= Integer.MIN_VALUE;
                Object $result = messageDatabaseServiceImpl$add$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (messageDatabaseServiceImpl$add$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (message.isTemporaryMsg()) {
                            return Unit.INSTANCE;
                        }
                        sessionIdEntity = this.sessionIdDbConverters.convertToEntity(message.getMsgId().getSessionId());
                        SessionIdDao sessionIdDao = this.sessionIdDao;
                        messageDatabaseServiceImpl$add$1.L$0 = message;
                        messageDatabaseServiceImpl$add$1.L$1 = sessionIdEntity;
                        messageDatabaseServiceImpl$add$1.label = 1;
                        if (sessionIdDao.insert(sessionIdEntity, messageDatabaseServiceImpl$add$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        messageEntity = EntityMessageExtKt.asEntity(message, this.json, sessionIdEntity);
                        messageDao = this.messageDao;
                        messageDatabaseServiceImpl$add$1.L$0 = SpillingKt.nullOutSpilledVariable(message);
                        messageDatabaseServiceImpl$add$1.L$1 = SpillingKt.nullOutSpilledVariable(sessionIdEntity);
                        messageDatabaseServiceImpl$add$1.L$2 = SpillingKt.nullOutSpilledVariable(messageEntity);
                        messageDatabaseServiceImpl$add$1.label = 2;
                        if (messageDao.upsertWithToken(messageEntity, (Continuation<? super Unit>) messageDatabaseServiceImpl$add$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        sessionIdEntity = (SessionIdEntity) messageDatabaseServiceImpl$add$1.L$1;
                        message = (EntityMessage) messageDatabaseServiceImpl$add$1.L$0;
                        ResultKt.throwOnFailure($result);
                        messageEntity = EntityMessageExtKt.asEntity(message, this.json, sessionIdEntity);
                        messageDao = this.messageDao;
                        messageDatabaseServiceImpl$add$1.L$0 = SpillingKt.nullOutSpilledVariable(message);
                        messageDatabaseServiceImpl$add$1.L$1 = SpillingKt.nullOutSpilledVariable(sessionIdEntity);
                        messageDatabaseServiceImpl$add$1.L$2 = SpillingKt.nullOutSpilledVariable(messageEntity);
                        messageDatabaseServiceImpl$add$1.label = 2;
                        if (messageDao.upsertWithToken(messageEntity, (Continuation<? super Unit>) messageDatabaseServiceImpl$add$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        MessageEntity messageEntity2 = (MessageEntity) messageDatabaseServiceImpl$add$1.L$2;
                        SessionIdEntity sessionIdEntity2 = (SessionIdEntity) messageDatabaseServiceImpl$add$1.L$1;
                        EntityMessage entityMessage = (EntityMessage) messageDatabaseServiceImpl$add$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        messageDatabaseServiceImpl$add$1 = new MessageDatabaseServiceImpl$add$1(this, continuation);
        Object $result2 = messageDatabaseServiceImpl$add$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageDatabaseServiceImpl$add$1.label) {
        }
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public Object updateContent(EntityMessage message, Continuation<? super Unit> continuation) {
        try {
            String content = EntityMessageExtKt.toJsonString(message, this.json);
            Object update = this.messageDao.update(this.sessionId, message.getMsgId().getMsgKey(), message.getMsgId().getSequenceNumber(), message.getMsgId().getSubSequenceNumber(), content, Clock.System.INSTANCE.now().toEpochMilliseconds(), continuation);
            return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
        } catch (Exception e) {
            IMLog.Companion.e("Chat", "更新数据库消息时，EntityMessage -> JsonString失败", e);
            return Unit.INSTANCE;
        }
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public Object resend(MessageId messageId, EntityMessage newValue, Continuation<? super Unit> continuation) {
        Object update = this.messageDao.update(this.sessionId, messageId.getMsgKey(), messageId.getSequenceNumber(), messageId.getSubSequenceNumber(), newValue.getMsgId().getSequenceNumber(), newValue.getMsgId().getSubSequenceNumber(), EntityMessageExtKt.toJsonString(newValue, this.json), newValue.getSendStatus().getValue(), Clock.System.INSTANCE.now().toEpochMilliseconds(), newValue.getToken(), (Continuation<? super Integer>) continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    public Object sendFailed(MessageId messageId, Continuation<? super Unit> continuation) {
        IMLog.Companion.i("ChatDatabaseServiceImpl", "Mark message as failed: " + messageId);
        Object update = this.messageDao.update(this.sessionId, messageId.getMsgKey(), messageId.getSequenceNumber(), messageId.getSubSequenceNumber(), SendStatus.Failure.getValue(), Clock.System.INSTANCE.now().toEpochMilliseconds(), (Continuation<? super Integer>) continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendSuccess(EntityMessage server, Continuation<? super Unit> continuation) {
        MessageDatabaseServiceImpl$sendSuccess$1 messageDatabaseServiceImpl$sendSuccess$1;
        MessageDatabaseServiceImpl$sendSuccess$1 messageDatabaseServiceImpl$sendSuccess$12;
        EntityMessage copy;
        if (continuation instanceof MessageDatabaseServiceImpl$sendSuccess$1) {
            messageDatabaseServiceImpl$sendSuccess$1 = (MessageDatabaseServiceImpl$sendSuccess$1) continuation;
            if ((messageDatabaseServiceImpl$sendSuccess$1.label & Integer.MIN_VALUE) != 0) {
                messageDatabaseServiceImpl$sendSuccess$1.label -= Integer.MIN_VALUE;
                messageDatabaseServiceImpl$sendSuccess$12 = messageDatabaseServiceImpl$sendSuccess$1;
                Object $result = messageDatabaseServiceImpl$sendSuccess$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (messageDatabaseServiceImpl$sendSuccess$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("ChatDatabaseServiceImpl", "sendSuccess: " + server.getMsgId() + " token " + server.getToken());
                        try {
                            MessageDao messageDao = this.messageDao;
                            copy = server.copy((r30 & 1) != 0 ? server.entityKey : 0L, (r30 & 2) != 0 ? server.msgId : null, (r30 & 4) != 0 ? server.msgType : null, (r30 & 8) != 0 ? server.msgFrame : null, (r30 & 16) != 0 ? server.timestamp : null, (r30 & 32) != 0 ? server.token : null, (r30 & 64) != 0 ? server.isHidden : false, (r30 & 128) != 0 ? server.sendStatus : SendStatus.Normal, (r30 & 256) != 0 ? server.createTime : null, (r30 & 512) != 0 ? server.updateTime : null, (r30 & 1024) != 0 ? server.isRealtimeMessage : false, (r30 & 2048) != 0 ? server.isTemporaryMsg : false, (r30 & 4096) != 0 ? server.traceParams : null);
                            MessageEntity asEntity = EntityMessageExtKt.asEntity(copy, this.json, this.sessionId);
                            messageDatabaseServiceImpl$sendSuccess$12.L$0 = SpillingKt.nullOutSpilledVariable(server);
                            messageDatabaseServiceImpl$sendSuccess$12.label = 1;
                            if (messageDao.upsertWithToken(asEntity, (Continuation<? super Unit>) messageDatabaseServiceImpl$sendSuccess$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            e = th;
                            IMLog.Companion.e("ChatDatabaseServiceImpl", "sendSuccess failed", e);
                            throw e;
                        }
                    case 1:
                        EntityMessage entityMessage = (EntityMessage) messageDatabaseServiceImpl$sendSuccess$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            e = th2;
                            IMLog.Companion.e("ChatDatabaseServiceImpl", "sendSuccess failed", e);
                            throw e;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        messageDatabaseServiceImpl$sendSuccess$1 = new MessageDatabaseServiceImpl$sendSuccess$1(this, continuation);
        messageDatabaseServiceImpl$sendSuccess$12 = messageDatabaseServiceImpl$sendSuccess$1;
        Object $result2 = messageDatabaseServiceImpl$sendSuccess$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageDatabaseServiceImpl$sendSuccess$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    @Override // kntr.app.im.chat.core.service.MessageDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object batchSoftDeleteMessages(List<MessageId> list, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> messageDatabaseServiceImpl$batchSoftDeleteMessages$1;
        MessageDatabaseServiceImpl messageDatabaseServiceImpl;
        Continuation<? super Unit> continuation2;
        MessageDatabaseServiceImpl messageDatabaseServiceImpl2;
        Object obj;
        long timestamp;
        Iterator<MessageId> it;
        List messageIds;
        if (continuation instanceof MessageDatabaseServiceImpl$batchSoftDeleteMessages$1) {
            messageDatabaseServiceImpl$batchSoftDeleteMessages$1 = (MessageDatabaseServiceImpl$batchSoftDeleteMessages$1) continuation;
            if ((messageDatabaseServiceImpl$batchSoftDeleteMessages$1.label & Integer.MIN_VALUE) != 0) {
                messageDatabaseServiceImpl$batchSoftDeleteMessages$1.label -= Integer.MIN_VALUE;
                messageDatabaseServiceImpl = this;
                Object $result = messageDatabaseServiceImpl$batchSoftDeleteMessages$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (messageDatabaseServiceImpl$batchSoftDeleteMessages$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        long timestamp2 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                        continuation2 = messageDatabaseServiceImpl$batchSoftDeleteMessages$1;
                        messageDatabaseServiceImpl2 = messageDatabaseServiceImpl;
                        obj = coroutine_suspended;
                        timestamp = timestamp2;
                        it = list.iterator();
                        messageIds = list;
                        break;
                    case 1:
                        long timestamp3 = messageDatabaseServiceImpl$batchSoftDeleteMessages$1.J$0;
                        MessageId messageId = (MessageId) messageDatabaseServiceImpl$batchSoftDeleteMessages$1.L$2;
                        ResultKt.throwOnFailure($result);
                        continuation2 = messageDatabaseServiceImpl$batchSoftDeleteMessages$1;
                        obj = coroutine_suspended;
                        timestamp = timestamp3;
                        it = (Iterator) messageDatabaseServiceImpl$batchSoftDeleteMessages$1.L$1;
                        messageIds = (List) messageDatabaseServiceImpl$batchSoftDeleteMessages$1.L$0;
                        messageDatabaseServiceImpl2 = messageDatabaseServiceImpl;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    MessageId messageId2 = it.next();
                    MessageDao messageDao = messageDatabaseServiceImpl2.messageDao;
                    SessionIdEntity sessionIdEntity = messageDatabaseServiceImpl2.sessionId;
                    long msgKey = messageId2.getMsgKey();
                    long sequenceNumber = messageId2.getSequenceNumber();
                    long timestamp4 = messageId2.getSubSequenceNumber();
                    Long boxLong = Boxing.boxLong(timestamp);
                    continuation2.L$0 = SpillingKt.nullOutSpilledVariable(messageIds);
                    continuation2.L$1 = it;
                    continuation2.L$2 = SpillingKt.nullOutSpilledVariable(messageId2);
                    continuation2.J$0 = timestamp;
                    continuation2.label = 1;
                    MessageDatabaseServiceImpl messageDatabaseServiceImpl3 = messageDatabaseServiceImpl2;
                    long timestamp5 = timestamp;
                    Iterator<MessageId> it2 = it;
                    List messageIds2 = messageIds;
                    Object obj2 = obj;
                    if (messageDao.update(sessionIdEntity, msgKey, sequenceNumber, timestamp4, timestamp, boxLong, continuation2) == obj2) {
                        return obj2;
                    }
                    obj = obj2;
                    timestamp = timestamp5;
                    messageDatabaseServiceImpl2 = messageDatabaseServiceImpl3;
                    it = it2;
                    messageIds = messageIds2;
                }
                return Unit.INSTANCE;
            }
        }
        messageDatabaseServiceImpl = this;
        messageDatabaseServiceImpl$batchSoftDeleteMessages$1 = new MessageDatabaseServiceImpl$batchSoftDeleteMessages$1(messageDatabaseServiceImpl, continuation);
        Object $result2 = messageDatabaseServiceImpl$batchSoftDeleteMessages$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageDatabaseServiceImpl$batchSoftDeleteMessages$1.label) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}