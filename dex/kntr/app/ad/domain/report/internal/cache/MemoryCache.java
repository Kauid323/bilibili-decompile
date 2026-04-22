package kntr.app.ad.domain.report.internal.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: MemoryCache.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/MemoryCache;", "Lkntr/app/ad/domain/report/internal/cache/IAdReportCache;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/internal/ReportRecord;", "maxSize", RoomRecommendViewModel.EMPTY_CURSOR, "onMemoryCacheOverFlow", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILkotlin/jvm/functions/Function1;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "memoryCache", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "add", "key", "value", "(Ljava/lang/String;Lkntr/app/ad/domain/report/internal/ReportRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MemoryCache implements IAdReportCache<String, ReportRecord> {
    private final int maxSize;
    private final LinkedHashMap<String, ReportRecord> memoryCache;
    private final Mutex mutex;
    private final Function1<Map<String, ReportRecord>, Unit> onMemoryCacheOverFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public MemoryCache(int maxSize, Function1<? super Map<String, ReportRecord>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onMemoryCacheOverFlow");
        this.maxSize = maxSize;
        this.onMemoryCacheOverFlow = function1;
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.memoryCache = new LinkedHashMap<>();
    }

    @Override // kntr.app.ad.domain.report.internal.cache.IAdReportCache
    public /* bridge */ /* synthetic */ Object add(String str, ReportRecord reportRecord, Continuation $completion) {
        return add2(str, reportRecord, (Continuation<? super Unit>) $completion);
    }

    @Override // kntr.app.ad.domain.report.internal.cache.IAdReportCache
    public /* bridge */ /* synthetic */ Object delete(String str, ReportRecord reportRecord, Continuation $completion) {
        return delete2(str, reportRecord, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:13:0x0043, B:29:0x00a5, B:30:0x00bf, B:23:0x0081, B:25:0x008b), top: B:35:0x0021 }] */
    /* renamed from: add  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object add2(String key, ReportRecord value, Continuation<? super Unit> continuation) {
        MemoryCache$add$1 memoryCache$add$1;
        Mutex $this$withLock_u24default$iv;
        int $i$f$withLock;
        Object owner$iv;
        Object all;
        int i;
        Function1<Map<String, ReportRecord>, Unit> function1;
        try {
            if (continuation instanceof MemoryCache$add$1) {
                memoryCache$add$1 = (MemoryCache$add$1) continuation;
                if ((memoryCache$add$1.label & Integer.MIN_VALUE) != 0) {
                    memoryCache$add$1.label -= Integer.MIN_VALUE;
                    Object $result = memoryCache$add$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (memoryCache$add$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Mutex $this$withLock_u24default$iv2 = this.mutex;
                            memoryCache$add$1.L$0 = key;
                            memoryCache$add$1.L$1 = value;
                            memoryCache$add$1.L$2 = $this$withLock_u24default$iv2;
                            memoryCache$add$1.I$0 = 0;
                            memoryCache$add$1.label = 1;
                            if ($this$withLock_u24default$iv2.lock((Object) null, memoryCache$add$1) != coroutine_suspended) {
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                $i$f$withLock = 0;
                                owner$iv = null;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            $i$f$withLock = memoryCache$add$1.I$0;
                            value = (ReportRecord) memoryCache$add$1.L$1;
                            key = (String) memoryCache$add$1.L$0;
                            ResultKt.throwOnFailure($result);
                            $this$withLock_u24default$iv = (Mutex) memoryCache$add$1.L$2;
                            owner$iv = null;
                            break;
                        case 2:
                            i = memoryCache$add$1.I$1;
                            int i2 = memoryCache$add$1.I$0;
                            function1 = (Function1) memoryCache$add$1.L$3;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) memoryCache$add$1.L$2;
                            value = (ReportRecord) memoryCache$add$1.L$1;
                            key = (String) memoryCache$add$1.L$0;
                            ResultKt.throwOnFailure($result);
                            all = $result;
                            function1.invoke(all);
                            LinkedHashMap<String, ReportRecord> linkedHashMap = this.memoryCache;
                            Set<String> keySet = this.memoryCache.keySet();
                            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                            linkedHashMap.remove(CollectionsKt.first(keySet));
                            this.memoryCache.put(CacheUtilsKt.generateFileName(key, value.getUuid()), value);
                            Unit unit = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    if (this.memoryCache.size() >= this.maxSize) {
                        Function1<Map<String, ReportRecord>, Unit> function12 = this.onMemoryCacheOverFlow;
                        memoryCache$add$1.L$0 = key;
                        memoryCache$add$1.L$1 = value;
                        memoryCache$add$1.L$2 = $this$withLock_u24default$iv;
                        memoryCache$add$1.L$3 = function12;
                        memoryCache$add$1.I$0 = $i$f$withLock;
                        memoryCache$add$1.I$1 = 0;
                        memoryCache$add$1.label = 2;
                        all = getAll(memoryCache$add$1);
                        if (all == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                        function1 = function12;
                        function1.invoke(all);
                        LinkedHashMap<String, ReportRecord> linkedHashMap2 = this.memoryCache;
                        Set<String> keySet2 = this.memoryCache.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet2, "<get-keys>(...)");
                        linkedHashMap2.remove(CollectionsKt.first(keySet2));
                    }
                    this.memoryCache.put(CacheUtilsKt.generateFileName(key, value.getUuid()), value);
                    Unit unit2 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                }
            }
            switch (memoryCache$add$1.label) {
            }
            if (this.memoryCache.size() >= this.maxSize) {
            }
            this.memoryCache.put(CacheUtilsKt.generateFileName(key, value.getUuid()), value);
            Unit unit22 = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        memoryCache$add$1 = new MemoryCache$add$1(this, continuation);
        Object $result2 = memoryCache$add$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    @Override // kntr.app.ad.domain.report.internal.cache.IAdReportCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAll(Continuation<? super Map<String, ? extends ReportRecord>> continuation) {
        MemoryCache$getAll$1 memoryCache$getAll$1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        try {
            if (continuation instanceof MemoryCache$getAll$1) {
                memoryCache$getAll$1 = (MemoryCache$getAll$1) continuation;
                if ((memoryCache$getAll$1.label & Integer.MIN_VALUE) != 0) {
                    memoryCache$getAll$1.label -= Integer.MIN_VALUE;
                    Object $result = memoryCache$getAll$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (memoryCache$getAll$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            $this$withLock_u24default$iv = this.mutex;
                            owner$iv = null;
                            memoryCache$getAll$1.L$0 = $this$withLock_u24default$iv;
                            memoryCache$getAll$1.I$0 = 0;
                            memoryCache$getAll$1.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, memoryCache$getAll$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            int i = memoryCache$getAll$1.I$0;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) memoryCache$getAll$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return MapsKt.toMap(this.memoryCache);
                }
            }
            return MapsKt.toMap(this.memoryCache);
        } finally {
            $this$withLock_u24default$iv.unlock(owner$iv);
        }
        memoryCache$getAll$1 = new MemoryCache$getAll$1(this, continuation);
        Object $result2 = memoryCache$getAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (memoryCache$getAll$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* renamed from: delete  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object delete2(String key, ReportRecord value, Continuation<? super Unit> continuation) {
        MemoryCache$delete$1 memoryCache$delete$1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        try {
            if (continuation instanceof MemoryCache$delete$1) {
                memoryCache$delete$1 = (MemoryCache$delete$1) continuation;
                if ((memoryCache$delete$1.label & Integer.MIN_VALUE) != 0) {
                    memoryCache$delete$1.label -= Integer.MIN_VALUE;
                    Object $result = memoryCache$delete$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (memoryCache$delete$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            $this$withLock_u24default$iv = this.mutex;
                            owner$iv = null;
                            memoryCache$delete$1.L$0 = key;
                            memoryCache$delete$1.L$1 = value;
                            memoryCache$delete$1.L$2 = $this$withLock_u24default$iv;
                            memoryCache$delete$1.I$0 = 0;
                            memoryCache$delete$1.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, memoryCache$delete$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            int i = memoryCache$delete$1.I$0;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) memoryCache$delete$1.L$2;
                            value = (ReportRecord) memoryCache$delete$1.L$1;
                            key = (String) memoryCache$delete$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    this.memoryCache.remove(CacheUtilsKt.generateFileName(key, value.getUuid()));
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                }
            }
            this.memoryCache.remove(CacheUtilsKt.generateFileName(key, value.getUuid()));
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        memoryCache$delete$1 = new MemoryCache$delete$1(this, continuation);
        Object $result2 = memoryCache$delete$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (memoryCache$delete$1.label) {
        }
    }
}