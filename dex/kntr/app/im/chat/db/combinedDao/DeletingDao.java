package kntr.app.im.chat.db.combinedDao;

import java.util.Collection;
import java.util.List;
import kntr.app.im.chat.db.dao.ChatInfoDao;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.dao.RangeDao;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.app.im.chat.db.entity.ChatInfoEntity;
import kntr.app.im.chat.db.entity.DraftEntity;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.RangeEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeletingDao.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0097@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/combinedDao/DeletingDao;", "Lkntr/app/im/chat/db/dao/ChatInfoDao;", "Lkntr/app/im/chat/db/dao/MessageDao;", "Lkntr/app/im/chat/db/dao/RangeDao;", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "Lkntr/app/im/chat/db/dao/DraftDao;", "deleteAllTables", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeletingDao extends ChatInfoDao, MessageDao, RangeDao, SessionIdDao, DraftDao {
    Object deleteAllTables(Continuation<? super Unit> continuation);

    /* compiled from: DeletingDao.kt */
    /* renamed from: kntr.app.im.chat.db.combinedDao.DeletingDao$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x009b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object deleteAllTables$suspendImpl(DeletingDao $this, Continuation<? super Unit> continuation) {
            DeletingDao$deleteAllTables$1 deletingDao$deleteAllTables$1;
            if (continuation instanceof DeletingDao$deleteAllTables$1) {
                deletingDao$deleteAllTables$1 = (DeletingDao$deleteAllTables$1) continuation;
                if ((deletingDao$deleteAllTables$1.label & Integer.MIN_VALUE) != 0) {
                    deletingDao$deleteAllTables$1.label -= Integer.MIN_VALUE;
                    Object $result = deletingDao$deleteAllTables$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (deletingDao$deleteAllTables$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 1;
                            if ($this.deleteAllChatInfo(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 2;
                            if ($this.deleteAllMessages(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 3;
                            if ($this.deleteAllRange(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 4;
                            if ($this.deleteAllSessions(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deletingDao$deleteAllTables$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            deletingDao$deleteAllTables$1.label = 5;
                            if ($this.deleteAllDraft(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            $this = (DeletingDao) deletingDao$deleteAllTables$1.L$0;
                            ResultKt.throwOnFailure($result);
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 2;
                            if ($this.deleteAllMessages(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 3;
                            if ($this.deleteAllRange(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 4;
                            if ($this.deleteAllSessions(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            deletingDao$deleteAllTables$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            deletingDao$deleteAllTables$1.label = 5;
                            if ($this.deleteAllDraft(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                            $this = (DeletingDao) deletingDao$deleteAllTables$1.L$0;
                            ResultKt.throwOnFailure($result);
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 3;
                            if ($this.deleteAllRange(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 4;
                            if ($this.deleteAllSessions(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            deletingDao$deleteAllTables$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            deletingDao$deleteAllTables$1.label = 5;
                            if ($this.deleteAllDraft(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 3:
                            $this = (DeletingDao) deletingDao$deleteAllTables$1.L$0;
                            ResultKt.throwOnFailure($result);
                            deletingDao$deleteAllTables$1.L$0 = $this;
                            deletingDao$deleteAllTables$1.label = 4;
                            if ($this.deleteAllSessions(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            deletingDao$deleteAllTables$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            deletingDao$deleteAllTables$1.label = 5;
                            if ($this.deleteAllDraft(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 4:
                            $this = (DeletingDao) deletingDao$deleteAllTables$1.L$0;
                            ResultKt.throwOnFailure($result);
                            deletingDao$deleteAllTables$1.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            deletingDao$deleteAllTables$1.label = 5;
                            if ($this.deleteAllDraft(deletingDao$deleteAllTables$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 5:
                            DeletingDao deletingDao = (DeletingDao) deletingDao$deleteAllTables$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            deletingDao$deleteAllTables$1 = new DeletingDao$deleteAllTables$1($this, continuation);
            Object $result2 = deletingDao$deleteAllTables$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (deletingDao$deleteAllTables$1.label) {
            }
        }
    }

    /* compiled from: DeletingDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object chatInfo(DeletingDao $this, SessionIdEntity sessionId, Continuation<? super ChatInfoEntity> continuation) {
            return ChatInfoDao.CC.$default$chatInfo($this, sessionId, continuation);
        }

        @Deprecated
        public static Object delete(DeletingDao $this, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super Unit> continuation) {
            return MessageDao.CC.$default$delete($this, sessionId, msgKey, sequenceNumber, subsequenceNumber, continuation);
        }

        @Deprecated
        public static Object delete(DeletingDao $this, SessionIdEntity sessionId, long start, long end, Continuation<? super Unit> continuation) {
            return RangeDao.CC.$default$delete($this, sessionId, start, end, continuation);
        }

        @Deprecated
        public static Object deleteDraft(DeletingDao $this, SessionIdEntity sessionId, Continuation<? super Unit> continuation) {
            return DraftDao.CC.$default$deleteDraft($this, sessionId, continuation);
        }

        @Deprecated
        public static Flow<DraftEntity> observe(DeletingDao $this, SessionIdEntity sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return DraftDao.CC.$default$observe($this, sessionId);
        }

        @Deprecated
        public static Object query(DeletingDao $this, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super MessageEntity> continuation) {
            return MessageDao.CC.$default$query($this, sessionId, msgKey, sequenceNumber, subsequenceNumber, continuation);
        }

        @Deprecated
        public static Object query(DeletingDao $this, SessionIdEntity sessionId, Continuation<? super DraftEntity> continuation) {
            return DraftDao.CC.$default$query($this, sessionId, continuation);
        }

        @Deprecated
        public static Object queryAll(DeletingDao $this, SessionIdEntity sessionId, Continuation<? super List<RangeEntity>> continuation) {
            return RangeDao.CC.$default$queryAll($this, sessionId, continuation);
        }

        @Deprecated
        public static Object queryPrevious(DeletingDao $this, SessionIdEntity sessionId, long base, Continuation<? super RangeEntity> continuation) {
            return RangeDao.CC.$default$queryPrevious($this, sessionId, base, continuation);
        }

        @Deprecated
        public static Object removeAndAdd(DeletingDao $this, SessionIdEntity sessionId, Collection<LongRange> collection, Collection<LongRange> collection2, Continuation<? super Unit> continuation) {
            return RangeDao.CC.$default$removeAndAdd($this, sessionId, collection, collection2, continuation);
        }

        @Deprecated
        public static Object update(DeletingDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
            return MessageDao.CC.$default$update($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, sendStatus, updateTime, continuation);
        }

        @Deprecated
        public static Object update(DeletingDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long newSequenceNumber, long newSubsequenceNumber, String content, int sendStatus, long updateTime, String token, Continuation<? super Integer> continuation) {
            return MessageDao.CC.$default$update($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, newSequenceNumber, newSubsequenceNumber, content, sendStatus, updateTime, token, continuation);
        }

        @Deprecated
        public static Object update(DeletingDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long updateTime, Long deleteTime, Continuation<? super Unit> continuation) {
            return MessageDao.CC.$default$update($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, updateTime, deleteTime, continuation);
        }

        @Deprecated
        public static Object update(DeletingDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
            return MessageDao.CC.$default$update($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, content, sendStatus, updateTime, continuation);
        }

        @Deprecated
        public static Object update(DeletingDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, long updateTime, Continuation<? super Unit> continuation) {
            return MessageDao.CC.$default$update($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, content, updateTime, continuation);
        }

        @Deprecated
        public static Object updateChatInfo(DeletingDao $this, SessionIdEntity sessionId, String content, long updateTime, Continuation<? super Unit> continuation) {
            return ChatInfoDao.CC.$default$updateChatInfo($this, sessionId, content, updateTime, continuation);
        }

        @Deprecated
        public static Object upsertWithToken(DeletingDao $this, List<MessageEntity> list, Continuation<? super Unit> continuation) {
            return MessageDao.CC.$default$upsertWithToken($this, list, continuation);
        }

        @Deprecated
        public static Object upsertWithToken(DeletingDao $this, MessageEntity message, Continuation<? super Unit> continuation) {
            return MessageDao.CC.$default$upsertWithToken($this, message, continuation);
        }

        @Deprecated
        public static Object deleteAllTables(DeletingDao $this, Continuation<? super Unit> continuation) {
            return CC.deleteAllTables$suspendImpl($this, continuation);
        }
    }
}