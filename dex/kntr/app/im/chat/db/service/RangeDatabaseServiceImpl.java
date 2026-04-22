package kntr.app.im.chat.db.service;

import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.im.chat.core.service.RangeDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.dao.RangeDao;
import kntr.app.im.chat.db.entity.RangeEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.util.RangeExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: RangeDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/db/service/RangeDatabaseServiceImpl;", "Lkntr/app/im/chat/core/service/RangeDatabaseService;", "session", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "<init>", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkntr/app/im/chat/db/DatabaseService;)V", "rangeDao", "Lkntr/app/im/chat/db/dao/RangeDao;", "mergeAll", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "range", "(Lkotlin/ranges/LongRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPrevious", "base", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAll", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RangeDatabaseServiceImpl implements RangeDatabaseService {
    private final DatabaseService databaseService;
    private final RangeDao rangeDao;
    private final SessionIdEntity session;

    @Inject
    public RangeDatabaseServiceImpl(SessionIdEntity session, DatabaseService databaseService) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        this.session = session;
        this.databaseService = databaseService;
        this.rangeDao = this.databaseService.getDb().rangeDao();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[LOOP:0: B:18:0x0076->B:20:0x007c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    @Override // kntr.app.im.chat.core.service.RangeDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mergeAll(Continuation<? super List<LongRange>> continuation) {
        RangeDatabaseServiceImpl$mergeAll$1 rangeDatabaseServiceImpl$mergeAll$1;
        Object queryAll;
        Iterator it;
        final Set dbRanges;
        RangeMergeResult mergedRanges;
        final RangeMergeResult mergedRanges2;
        if (continuation instanceof RangeDatabaseServiceImpl$mergeAll$1) {
            rangeDatabaseServiceImpl$mergeAll$1 = (RangeDatabaseServiceImpl$mergeAll$1) continuation;
            if ((rangeDatabaseServiceImpl$mergeAll$1.label & Integer.MIN_VALUE) != 0) {
                rangeDatabaseServiceImpl$mergeAll$1.label -= Integer.MIN_VALUE;
                Object $result = rangeDatabaseServiceImpl$mergeAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rangeDatabaseServiceImpl$mergeAll$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.d("Chat-RangeService", new Function0() { // from class: kntr.app.im.chat.db.service.RangeDatabaseServiceImpl$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                String mergeAll$lambda$0;
                                mergeAll$lambda$0 = RangeDatabaseServiceImpl.mergeAll$lambda$0(RangeDatabaseServiceImpl.this);
                                return mergeAll$lambda$0;
                            }
                        });
                        RangeDao rangeDao = this.rangeDao;
                        SessionIdEntity sessionIdEntity = this.session;
                        rangeDatabaseServiceImpl$mergeAll$1.label = 1;
                        queryAll = rangeDao.queryAll(sessionIdEntity, rangeDatabaseServiceImpl$mergeAll$1);
                        if (queryAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Iterable $this$map$iv = (Iterable) queryAll;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        Iterable $this$mapTo$iv$iv = $this$map$iv;
                        boolean z = false;
                        for (it = $this$mapTo$iv$iv.iterator(); it.hasNext(); it = it) {
                            Object item$iv$iv = it.next();
                            RangeEntity it2 = (RangeEntity) item$iv$iv;
                            destination$iv$iv.add(new LongRange(it2.getStart(), it2.getEnd()));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            z = z;
                        }
                        dbRanges = CollectionsKt.toSet((List) destination$iv$iv);
                        mergedRanges = RangeDatabaseServiceImplKt.merge(dbRanges);
                        rangeDatabaseServiceImpl$mergeAll$1.L$0 = dbRanges;
                        rangeDatabaseServiceImpl$mergeAll$1.L$1 = mergedRanges;
                        rangeDatabaseServiceImpl$mergeAll$1.label = 2;
                        if (this.rangeDao.removeAndAdd(this.session, mergedRanges.getToDelete(), mergedRanges.getToInsert(), rangeDatabaseServiceImpl$mergeAll$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mergedRanges2 = mergedRanges;
                        IMLog.Companion.d("Chat-RangeService", new Function0() { // from class: kntr.app.im.chat.db.service.RangeDatabaseServiceImpl$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                String mergeAll$lambda$2;
                                mergeAll$lambda$2 = RangeDatabaseServiceImpl.mergeAll$lambda$2(RangeDatabaseServiceImpl.this, dbRanges, mergedRanges2);
                                return mergeAll$lambda$2;
                            }
                        });
                        Iterable $this$sortedBy$iv = CollectionsKt.toList(mergedRanges2.getMergedRanges());
                        return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.db.service.RangeDatabaseServiceImpl$mergeAll$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                LongRange it3 = (LongRange) t;
                                LongRange it4 = (LongRange) t2;
                                return ComparisonsKt.compareValues(Long.valueOf(it3.getFirst()), Long.valueOf(it4.getFirst()));
                            }
                        });
                    case 1:
                        ResultKt.throwOnFailure($result);
                        queryAll = $result;
                        Iterable $this$map$iv2 = (Iterable) queryAll;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        Iterable $this$mapTo$iv$iv2 = $this$map$iv2;
                        boolean z2 = false;
                        while (it.hasNext()) {
                        }
                        dbRanges = CollectionsKt.toSet((List) destination$iv$iv2);
                        mergedRanges = RangeDatabaseServiceImplKt.merge(dbRanges);
                        rangeDatabaseServiceImpl$mergeAll$1.L$0 = dbRanges;
                        rangeDatabaseServiceImpl$mergeAll$1.L$1 = mergedRanges;
                        rangeDatabaseServiceImpl$mergeAll$1.label = 2;
                        if (this.rangeDao.removeAndAdd(this.session, mergedRanges.getToDelete(), mergedRanges.getToInsert(), rangeDatabaseServiceImpl$mergeAll$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        mergedRanges2 = (RangeMergeResult) rangeDatabaseServiceImpl$mergeAll$1.L$1;
                        dbRanges = (Set) rangeDatabaseServiceImpl$mergeAll$1.L$0;
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.d("Chat-RangeService", new Function0() { // from class: kntr.app.im.chat.db.service.RangeDatabaseServiceImpl$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                String mergeAll$lambda$2;
                                mergeAll$lambda$2 = RangeDatabaseServiceImpl.mergeAll$lambda$2(RangeDatabaseServiceImpl.this, dbRanges, mergedRanges2);
                                return mergeAll$lambda$2;
                            }
                        });
                        Iterable $this$sortedBy$iv2 = CollectionsKt.toList(mergedRanges2.getMergedRanges());
                        return CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: kntr.app.im.chat.db.service.RangeDatabaseServiceImpl$mergeAll$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                LongRange it3 = (LongRange) t;
                                LongRange it4 = (LongRange) t2;
                                return ComparisonsKt.compareValues(Long.valueOf(it3.getFirst()), Long.valueOf(it4.getFirst()));
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        rangeDatabaseServiceImpl$mergeAll$1 = new RangeDatabaseServiceImpl$mergeAll$1(this, continuation);
        Object $result2 = rangeDatabaseServiceImpl$mergeAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rangeDatabaseServiceImpl$mergeAll$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mergeAll$lambda$0(RangeDatabaseServiceImpl this$0) {
        return "Start merging ranges for session " + this$0.session;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mergeAll$lambda$2(RangeDatabaseServiceImpl this$0, Set $dbRanges, RangeMergeResult $mergedRanges) {
        SessionIdEntity sessionIdEntity = this$0.session;
        int size = $dbRanges.size();
        List<LongRange> toDelete = $mergedRanges.getToDelete();
        List<LongRange> toInsert = $mergedRanges.getToInsert();
        return "Merged ranges for session " + sessionIdEntity + ": Before merge: " + size + ", toDelete=" + toDelete + ", toInsert=" + toInsert + ", mergedCount=" + $mergedRanges.getMergedRanges().size();
    }

    @Override // kntr.app.im.chat.core.service.RangeDatabaseService
    public Object add(LongRange range, Continuation<? super Unit> continuation) {
        Object insert = this.databaseService.getDb().rangeDao().insert(new RangeEntity(0L, this.session, range.getFirst(), range.getLast(), 1, null), continuation);
        return insert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insert : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064 A[ORIG_RETURN, RETURN] */
    @Override // kntr.app.im.chat.core.service.RangeDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object queryPrevious(Long base, Continuation<? super LongRange> continuation) {
        RangeDatabaseServiceImpl$queryPrevious$1 rangeDatabaseServiceImpl$queryPrevious$1;
        Object queryPrevious;
        RangeEntity rangeEntity;
        if (continuation instanceof RangeDatabaseServiceImpl$queryPrevious$1) {
            rangeDatabaseServiceImpl$queryPrevious$1 = (RangeDatabaseServiceImpl$queryPrevious$1) continuation;
            if ((rangeDatabaseServiceImpl$queryPrevious$1.label & Integer.MIN_VALUE) != 0) {
                rangeDatabaseServiceImpl$queryPrevious$1.label -= Integer.MIN_VALUE;
                Object $result = rangeDatabaseServiceImpl$queryPrevious$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rangeDatabaseServiceImpl$queryPrevious$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        RangeDao rangeDao = this.rangeDao;
                        SessionIdEntity sessionIdEntity = this.session;
                        long longValue = base != null ? base.longValue() : Long.MAX_VALUE;
                        rangeDatabaseServiceImpl$queryPrevious$1.L$0 = SpillingKt.nullOutSpilledVariable(base);
                        rangeDatabaseServiceImpl$queryPrevious$1.label = 1;
                        queryPrevious = rangeDao.queryPrevious(sessionIdEntity, longValue, rangeDatabaseServiceImpl$queryPrevious$1);
                        if (queryPrevious == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Long l = (Long) rangeDatabaseServiceImpl$queryPrevious$1.L$0;
                        ResultKt.throwOnFailure($result);
                        queryPrevious = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rangeEntity = (RangeEntity) queryPrevious;
                if (rangeEntity == null) {
                    return RangeExtKt.asLongRange(rangeEntity);
                }
                return null;
            }
        }
        rangeDatabaseServiceImpl$queryPrevious$1 = new RangeDatabaseServiceImpl$queryPrevious$1(this, continuation);
        Object $result2 = rangeDatabaseServiceImpl$queryPrevious$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rangeDatabaseServiceImpl$queryPrevious$1.label) {
        }
        rangeEntity = (RangeEntity) queryPrevious;
        if (rangeEntity == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[LOOP:0: B:17:0x0059->B:19:0x005f, LOOP_END] */
    @Override // kntr.app.im.chat.core.service.RangeDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object queryAll(Continuation<? super List<LongRange>> continuation) {
        RangeDatabaseServiceImpl$queryAll$1 rangeDatabaseServiceImpl$queryAll$1;
        Object queryAll;
        if (continuation instanceof RangeDatabaseServiceImpl$queryAll$1) {
            rangeDatabaseServiceImpl$queryAll$1 = (RangeDatabaseServiceImpl$queryAll$1) continuation;
            if ((rangeDatabaseServiceImpl$queryAll$1.label & Integer.MIN_VALUE) != 0) {
                rangeDatabaseServiceImpl$queryAll$1.label -= Integer.MIN_VALUE;
                Object $result = rangeDatabaseServiceImpl$queryAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rangeDatabaseServiceImpl$queryAll$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        RangeDao rangeDao = this.rangeDao;
                        SessionIdEntity sessionIdEntity = this.session;
                        rangeDatabaseServiceImpl$queryAll$1.label = 1;
                        queryAll = rangeDao.queryAll(sessionIdEntity, rangeDatabaseServiceImpl$queryAll$1);
                        if (queryAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        queryAll = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable $this$map$iv = (Iterable) queryAll;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    RangeEntity it = (RangeEntity) item$iv$iv;
                    destination$iv$iv.add(RangeExtKt.asLongRange(it));
                }
                return (List) destination$iv$iv;
            }
        }
        rangeDatabaseServiceImpl$queryAll$1 = new RangeDatabaseServiceImpl$queryAll$1(this, continuation);
        Object $result2 = rangeDatabaseServiceImpl$queryAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rangeDatabaseServiceImpl$queryAll$1.label) {
        }
        Iterable $this$map$iv2 = (Iterable) queryAll;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r7.hasNext()) {
        }
        return (List) destination$iv$iv2;
    }
}