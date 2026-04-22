package kntr.app.im.chat.db.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.db.entity.RangeEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.ranges.LongRange;

/* compiled from: RangeDao.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J>\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0010J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0015J4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0019J8\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u001cJ \u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u001dJ2\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0097@¢\u0006\u0002\u0010#¨\u0006$À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/RangeDao;", RoomRecommendViewModel.EMPTY_CURSOR, "insert", RoomRecommendViewModel.EMPTY_CURSOR, "range", "Lkntr/app/im/chat/db/entity/RangeEntity;", "(Lkntr/app/im/chat/db/entity/RangeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "start", "end", "(IJJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllRange", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAll", RoomRecommendViewModel.EMPTY_CURSOR, "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPrevious", "base", "(IJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAdd", "toDelete", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "toInsert", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/util/Collection;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RangeDao {
    Object delete(int i, long j2, long j3, long j4, long j5, long j6, Continuation<? super Unit> continuation);

    Object delete(SessionIdEntity sessionIdEntity, long j2, long j3, Continuation<? super Unit> continuation);

    Object deleteAllRange(Continuation<? super Unit> continuation);

    Object insert(RangeEntity rangeEntity, Continuation<? super Unit> continuation);

    Object queryAll(int i, long j2, long j3, long j4, Continuation<? super List<RangeEntity>> continuation);

    Object queryAll(SessionIdEntity sessionIdEntity, Continuation<? super List<RangeEntity>> continuation);

    Object queryPrevious(int i, long j2, long j3, long j4, long j5, Continuation<? super RangeEntity> continuation);

    Object queryPrevious(SessionIdEntity sessionIdEntity, long j2, Continuation<? super RangeEntity> continuation);

    Object removeAndAdd(SessionIdEntity sessionIdEntity, Collection<LongRange> collection, Collection<LongRange> collection2, Continuation<? super Unit> continuation);

    /* compiled from: RangeDao.kt */
    /* renamed from: kntr.app.im.chat.db.dao.RangeDao$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static Object $default$delete(RangeDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, Continuation continuation) {
            return delete$suspendImpl(_this, sessionIdEntity, j2, j3, continuation);
        }

        public static Object $default$queryAll(RangeDao _this, SessionIdEntity sessionIdEntity, Continuation continuation) {
            return queryAll$suspendImpl(_this, sessionIdEntity, continuation);
        }

        public static Object $default$queryPrevious(RangeDao _this, SessionIdEntity sessionIdEntity, long j2, Continuation continuation) {
            return queryPrevious$suspendImpl(_this, sessionIdEntity, j2, continuation);
        }

        public static Object $default$removeAndAdd(RangeDao _this, SessionIdEntity sessionIdEntity, Collection collection, Collection collection2, Continuation continuation) {
            return removeAndAdd$suspendImpl(_this, sessionIdEntity, collection, collection2, continuation);
        }

        public static /* synthetic */ Object delete$suspendImpl(RangeDao $this, SessionIdEntity sessionId, long start, long end, Continuation<? super Unit> continuation) {
            Object delete = $this.delete(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), start, end, continuation);
            return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
        }

        public static /* synthetic */ Object queryAll$suspendImpl(RangeDao $this, SessionIdEntity sessionId, Continuation<? super List<RangeEntity>> continuation) {
            return $this.queryAll(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), continuation);
        }

        public static /* synthetic */ Object queryPrevious$suspendImpl(RangeDao $this, SessionIdEntity sessionId, long base, Continuation<? super RangeEntity> continuation) {
            return $this.queryPrevious(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), base, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0191  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0104 -> B:53:0x010b). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x017e -> B:61:0x018a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object removeAndAdd$suspendImpl(RangeDao $this, SessionIdEntity sessionId, Collection<LongRange> collection, Collection<LongRange> collection2, Continuation<? super Unit> continuation) {
            Continuation $continuation;
            RangeDao $this2;
            Iterable $this$forEach$iv;
            int $i$f$forEach;
            Iterator it;
            Continuation $continuation2;
            Object $result;
            Object $result2;
            Collection toDelete;
            Collection $result3;
            Continuation $completion;
            SessionIdEntity sessionId2;
            Collection toInsert;
            Collection $this$forEach$iv2;
            int $i$f$forEach2;
            Iterator it2;
            Iterable $this$forEach$iv3;
            Object element$iv;
            Object $result4;
            Continuation $continuation3;
            if (continuation instanceof RangeDao$removeAndAdd$1) {
                $continuation = (RangeDao$removeAndAdd$1) continuation;
                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                    $continuation.label -= Integer.MIN_VALUE;
                    $this2 = $this;
                    Object $result5 = $continuation.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                        case 0:
                            ResultKt.throwOnFailure($result5);
                            Collection<LongRange> $this$forEach$iv4 = collection;
                            $this$forEach$iv = $this$forEach$iv4;
                            $i$f$forEach = 0;
                            it = $this$forEach$iv4.iterator();
                            $continuation2 = $continuation;
                            $result = $result5;
                            $result2 = coroutine_suspended;
                            toDelete = collection;
                            $result3 = collection2;
                            $completion = continuation;
                            sessionId2 = sessionId;
                            break;
                        case 1:
                            int i = $continuation.I$1;
                            int $i$f$forEach3 = $continuation.I$0;
                            LongRange longRange = (LongRange) $continuation.L$7;
                            Object obj = $continuation.L$6;
                            Collection toInsert2 = (Collection) $continuation.L$3;
                            Collection toDelete2 = (Collection) $continuation.L$2;
                            SessionIdEntity sessionId3 = (SessionIdEntity) $continuation.L$1;
                            $this2 = (RangeDao) $continuation.L$0;
                            ResultKt.throwOnFailure($result5);
                            $i$f$forEach = $i$f$forEach3;
                            it = (Iterator) $continuation.L$5;
                            $this$forEach$iv = (Iterable) $continuation.L$4;
                            $continuation3 = $continuation;
                            $result4 = $result5;
                            element$iv = coroutine_suspended;
                            $result3 = toInsert2;
                            toDelete = toDelete2;
                            $completion = continuation;
                            sessionId2 = sessionId3;
                            $continuation2 = $continuation3;
                            $result = $result4;
                            $result2 = element$iv;
                            break;
                        case 2:
                            int i2 = $continuation.I$1;
                            $i$f$forEach2 = $continuation.I$0;
                            LongRange longRange2 = (LongRange) $continuation.L$7;
                            Object obj2 = $continuation.L$6;
                            Collection toInsert3 = (Collection) $continuation.L$3;
                            Collection toDelete3 = (Collection) $continuation.L$2;
                            SessionIdEntity sessionId4 = (SessionIdEntity) $continuation.L$1;
                            $this2 = (RangeDao) $continuation.L$0;
                            ResultKt.throwOnFailure($result5);
                            $completion = continuation;
                            sessionId2 = sessionId4;
                            Collection toDelete4 = toDelete3;
                            Collection toDelete5 = toInsert3;
                            Iterable $this$forEach$iv5 = (Iterable) $continuation.L$4;
                            Iterator it3 = (Iterator) $continuation.L$5;
                            Object element$iv2 = coroutine_suspended;
                            $result2 = element$iv2;
                            it2 = it3;
                            $this$forEach$iv3 = $this$forEach$iv5;
                            $this$forEach$iv2 = toDelete5;
                            toInsert = toDelete4;
                            if (it2.hasNext()) {
                                Object element$iv3 = it2.next();
                                LongRange it4 = (LongRange) element$iv3;
                                Object $result6 = $result5;
                                Continuation $completion2 = $completion;
                                RangeEntity rangeEntity = new RangeEntity(0L, sessionId2, it4.getFirst(), it4.getLast(), 1, null);
                                $continuation.L$0 = $this2;
                                $continuation.L$1 = sessionId2;
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(toInsert);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$forEach$iv2);
                                $continuation.L$4 = SpillingKt.nullOutSpilledVariable($this$forEach$iv3);
                                $continuation.L$5 = it2;
                                $continuation.L$6 = SpillingKt.nullOutSpilledVariable(element$iv3);
                                $continuation.L$7 = SpillingKt.nullOutSpilledVariable(it4);
                                $continuation.I$0 = $i$f$forEach2;
                                $continuation.I$1 = 0;
                                $continuation.label = 2;
                                if ($this2.insert(rangeEntity, $continuation) == $result2) {
                                    return $result2;
                                }
                                $completion = $completion2;
                                toDelete4 = toInsert;
                                toDelete5 = $this$forEach$iv2;
                                $this$forEach$iv5 = $this$forEach$iv3;
                                it3 = it2;
                                element$iv2 = $result2;
                                $result5 = $result6;
                                $result2 = element$iv2;
                                it2 = it3;
                                $this$forEach$iv3 = $this$forEach$iv5;
                                $this$forEach$iv2 = toDelete5;
                                toInsert = toDelete4;
                                if (it2.hasNext()) {
                                    return Unit.INSTANCE;
                                }
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    if (it.hasNext()) {
                        Object element$iv4 = it.next();
                        LongRange it5 = (LongRange) element$iv4;
                        long first = it5.getFirst();
                        long last = it5.getLast();
                        $continuation2.L$0 = $this2;
                        $continuation2.L$1 = sessionId2;
                        $continuation2.L$2 = SpillingKt.nullOutSpilledVariable(toDelete);
                        $continuation2.L$3 = $result3;
                        $continuation2.L$4 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        $continuation2.L$5 = it;
                        $continuation2.L$6 = SpillingKt.nullOutSpilledVariable(element$iv4);
                        $continuation2.L$7 = SpillingKt.nullOutSpilledVariable(it5);
                        $continuation2.I$0 = $i$f$forEach;
                        $continuation2.I$1 = 0;
                        $continuation2.label = 1;
                        Iterator it6 = it;
                        if ($this2.delete(sessionId2, first, last, $continuation2) == $result2) {
                            return $result2;
                        }
                        element$iv = $result2;
                        it = it6;
                        $result4 = $result;
                        $continuation3 = $continuation2;
                        $continuation2 = $continuation3;
                        $result = $result4;
                        $result2 = element$iv;
                        if (it.hasNext()) {
                            Collection $this$forEach$iv6 = $result3;
                            toInsert = toDelete;
                            $this$forEach$iv2 = $result3;
                            $continuation = $continuation2;
                            $result5 = $result;
                            $i$f$forEach2 = 0;
                            it2 = $this$forEach$iv6.iterator();
                            $this$forEach$iv3 = $this$forEach$iv6;
                            if (it2.hasNext()) {
                            }
                        }
                    }
                }
            }
            $this2 = $this;
            $continuation = new RangeDao$removeAndAdd$1($this2, continuation);
            Object $result52 = $continuation.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
            }
            if (it.hasNext()) {
            }
        }
    }

    /* compiled from: RangeDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object delete(RangeDao $this, SessionIdEntity sessionId, long start, long end, Continuation<? super Unit> continuation) {
            return CC.delete$suspendImpl($this, sessionId, start, end, continuation);
        }

        @Deprecated
        public static Object queryAll(RangeDao $this, SessionIdEntity sessionId, Continuation<? super List<RangeEntity>> continuation) {
            return CC.queryAll$suspendImpl($this, sessionId, continuation);
        }

        @Deprecated
        public static Object queryPrevious(RangeDao $this, SessionIdEntity sessionId, long base, Continuation<? super RangeEntity> continuation) {
            return CC.queryPrevious$suspendImpl($this, sessionId, base, continuation);
        }

        @Deprecated
        public static Object removeAndAdd(RangeDao $this, SessionIdEntity sessionId, Collection<LongRange> collection, Collection<LongRange> collection2, Continuation<? super Unit> continuation) {
            return CC.removeAndAdd$suspendImpl($this, sessionId, collection, collection2, continuation);
        }
    }
}