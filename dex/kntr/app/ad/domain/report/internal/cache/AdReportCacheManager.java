package kntr.app.ad.domain.report.internal.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.domain.report.internal.ReportConfig;
import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdReportCacheManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/AdReportCacheManager;", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "memoryCache", "Lkntr/app/ad/domain/report/internal/cache/IAdReportCache;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/internal/ReportRecord;", "localStorageCache", "Lkntr/app/ad/domain/report/internal/cache/IAdReportLocalStorageCache;", "config", "Lkntr/app/ad/domain/report/internal/ReportConfig;", "<init>", "(Lkntr/app/ad/domain/report/internal/cache/IAdReportCache;Lkntr/app/ad/domain/report/internal/cache/IAdReportLocalStorageCache;Lkntr/app/ad/domain/report/internal/ReportConfig;)V", "saveOrUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "record", "(Lkntr/app/ad/domain/report/internal/ReportRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "abandon", "load", RoomRecommendViewModel.EMPTY_CURSOR, "isFromStartUp", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdReportCacheManager implements IReportStorageManager {
    private final ReportConfig config;
    private final IAdReportLocalStorageCache<String, ReportRecord> localStorageCache;
    private final IAdReportCache<String, ReportRecord> memoryCache;

    public AdReportCacheManager(IAdReportCache<String, ReportRecord> iAdReportCache, IAdReportLocalStorageCache<String, ReportRecord> iAdReportLocalStorageCache, ReportConfig config) {
        Intrinsics.checkNotNullParameter(iAdReportCache, "memoryCache");
        Intrinsics.checkNotNullParameter(iAdReportLocalStorageCache, "localStorageCache");
        Intrinsics.checkNotNullParameter(config, "config");
        this.memoryCache = iAdReportCache;
        this.localStorageCache = iAdReportLocalStorageCache;
        this.config = config;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    @Override // kntr.app.ad.domain.report.internal.cache.IReportStorageManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object saveOrUpdate(ReportRecord record, Continuation<? super Unit> continuation) {
        AdReportCacheManager$saveOrUpdate$1 adReportCacheManager$saveOrUpdate$1;
        String key;
        int retryCount;
        if (continuation instanceof AdReportCacheManager$saveOrUpdate$1) {
            adReportCacheManager$saveOrUpdate$1 = (AdReportCacheManager$saveOrUpdate$1) continuation;
            if ((adReportCacheManager$saveOrUpdate$1.label & Integer.MIN_VALUE) != 0) {
                adReportCacheManager$saveOrUpdate$1.label -= Integer.MIN_VALUE;
                Object $result = adReportCacheManager$saveOrUpdate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (adReportCacheManager$saveOrUpdate$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        key = record.getTs();
                        retryCount = record.getRetryCount();
                        if (retryCount > this.config.getMAX_RETRY_COUNT()) {
                            IAdReportCache<String, ReportRecord> iAdReportCache = this.memoryCache;
                            adReportCacheManager$saveOrUpdate$1.L$0 = record;
                            adReportCacheManager$saveOrUpdate$1.L$1 = key;
                            adReportCacheManager$saveOrUpdate$1.I$0 = retryCount;
                            adReportCacheManager$saveOrUpdate$1.label = 1;
                            if (iAdReportCache.delete(key, record, adReportCacheManager$saveOrUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            IAdReportCache<String, ReportRecord> iAdReportCache2 = this.memoryCache;
                            adReportCacheManager$saveOrUpdate$1.L$0 = record;
                            adReportCacheManager$saveOrUpdate$1.L$1 = key;
                            adReportCacheManager$saveOrUpdate$1.I$0 = retryCount;
                            adReportCacheManager$saveOrUpdate$1.label = 2;
                            if (iAdReportCache2.add(key, record, adReportCacheManager$saveOrUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        int retryCount2 = retryCount + 1;
                        record.setRetryCount(retryCount2);
                        IAdReportLocalStorageCache<String, ReportRecord> iAdReportLocalStorageCache = this.localStorageCache;
                        adReportCacheManager$saveOrUpdate$1.L$0 = SpillingKt.nullOutSpilledVariable(record);
                        adReportCacheManager$saveOrUpdate$1.L$1 = SpillingKt.nullOutSpilledVariable(key);
                        adReportCacheManager$saveOrUpdate$1.I$0 = retryCount2;
                        adReportCacheManager$saveOrUpdate$1.label = 3;
                        return iAdReportLocalStorageCache.saveOrUpdateToLocalStorage(key, record, adReportCacheManager$saveOrUpdate$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    case 1:
                        retryCount = adReportCacheManager$saveOrUpdate$1.I$0;
                        key = (String) adReportCacheManager$saveOrUpdate$1.L$1;
                        record = (ReportRecord) adReportCacheManager$saveOrUpdate$1.L$0;
                        ResultKt.throwOnFailure($result);
                        int retryCount22 = retryCount + 1;
                        record.setRetryCount(retryCount22);
                        IAdReportLocalStorageCache<String, ReportRecord> iAdReportLocalStorageCache2 = this.localStorageCache;
                        adReportCacheManager$saveOrUpdate$1.L$0 = SpillingKt.nullOutSpilledVariable(record);
                        adReportCacheManager$saveOrUpdate$1.L$1 = SpillingKt.nullOutSpilledVariable(key);
                        adReportCacheManager$saveOrUpdate$1.I$0 = retryCount22;
                        adReportCacheManager$saveOrUpdate$1.label = 3;
                        if (iAdReportLocalStorageCache2.saveOrUpdateToLocalStorage(key, record, adReportCacheManager$saveOrUpdate$1) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        retryCount = adReportCacheManager$saveOrUpdate$1.I$0;
                        key = (String) adReportCacheManager$saveOrUpdate$1.L$1;
                        record = (ReportRecord) adReportCacheManager$saveOrUpdate$1.L$0;
                        ResultKt.throwOnFailure($result);
                        int retryCount222 = retryCount + 1;
                        record.setRetryCount(retryCount222);
                        IAdReportLocalStorageCache<String, ReportRecord> iAdReportLocalStorageCache22 = this.localStorageCache;
                        adReportCacheManager$saveOrUpdate$1.L$0 = SpillingKt.nullOutSpilledVariable(record);
                        adReportCacheManager$saveOrUpdate$1.L$1 = SpillingKt.nullOutSpilledVariable(key);
                        adReportCacheManager$saveOrUpdate$1.I$0 = retryCount222;
                        adReportCacheManager$saveOrUpdate$1.label = 3;
                        if (iAdReportLocalStorageCache22.saveOrUpdateToLocalStorage(key, record, adReportCacheManager$saveOrUpdate$1) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int i = adReportCacheManager$saveOrUpdate$1.I$0;
                        String str = (String) adReportCacheManager$saveOrUpdate$1.L$1;
                        ReportRecord reportRecord = (ReportRecord) adReportCacheManager$saveOrUpdate$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        adReportCacheManager$saveOrUpdate$1 = new AdReportCacheManager$saveOrUpdate$1(this, continuation);
        Object $result2 = adReportCacheManager$saveOrUpdate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adReportCacheManager$saveOrUpdate$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    @Override // kntr.app.ad.domain.report.internal.cache.IReportStorageManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object abandon(ReportRecord record, Continuation<? super Unit> continuation) {
        AdReportCacheManager$abandon$1 adReportCacheManager$abandon$1;
        String key;
        IAdReportLocalStorageCache<String, ReportRecord> iAdReportLocalStorageCache;
        if (continuation instanceof AdReportCacheManager$abandon$1) {
            adReportCacheManager$abandon$1 = (AdReportCacheManager$abandon$1) continuation;
            if ((adReportCacheManager$abandon$1.label & Integer.MIN_VALUE) != 0) {
                adReportCacheManager$abandon$1.label -= Integer.MIN_VALUE;
                Object $result = adReportCacheManager$abandon$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (adReportCacheManager$abandon$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        key = record.getTs();
                        IAdReportCache<String, ReportRecord> iAdReportCache = this.memoryCache;
                        adReportCacheManager$abandon$1.L$0 = record;
                        adReportCacheManager$abandon$1.L$1 = SpillingKt.nullOutSpilledVariable(key);
                        adReportCacheManager$abandon$1.label = 1;
                        if (iAdReportCache.delete(key, record, adReportCacheManager$abandon$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        iAdReportLocalStorageCache = this.localStorageCache;
                        adReportCacheManager$abandon$1.L$0 = SpillingKt.nullOutSpilledVariable(record);
                        adReportCacheManager$abandon$1.L$1 = SpillingKt.nullOutSpilledVariable(key);
                        adReportCacheManager$abandon$1.label = 2;
                        if (iAdReportLocalStorageCache.deleteLocalStorage(record, adReportCacheManager$abandon$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        key = (String) adReportCacheManager$abandon$1.L$1;
                        record = (ReportRecord) adReportCacheManager$abandon$1.L$0;
                        ResultKt.throwOnFailure($result);
                        iAdReportLocalStorageCache = this.localStorageCache;
                        adReportCacheManager$abandon$1.L$0 = SpillingKt.nullOutSpilledVariable(record);
                        adReportCacheManager$abandon$1.L$1 = SpillingKt.nullOutSpilledVariable(key);
                        adReportCacheManager$abandon$1.label = 2;
                        if (iAdReportLocalStorageCache.deleteLocalStorage(record, adReportCacheManager$abandon$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        String str = (String) adReportCacheManager$abandon$1.L$1;
                        ReportRecord reportRecord = (ReportRecord) adReportCacheManager$abandon$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        adReportCacheManager$abandon$1 = new AdReportCacheManager$abandon$1(this, continuation);
        Object $result2 = adReportCacheManager$abandon$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adReportCacheManager$abandon$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087 A[LOOP:0: B:20:0x0081->B:22:0x0087, LOOP_END] */
    @Override // kntr.app.ad.domain.report.internal.cache.IReportStorageManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(boolean isFromStartUp, Continuation<? super List<ReportRecord>> continuation) {
        AdReportCacheManager$load$1 adReportCacheManager$load$1;
        Object all;
        boolean isFromStartUp2 = isFromStartUp;
        if (continuation instanceof AdReportCacheManager$load$1) {
            adReportCacheManager$load$1 = (AdReportCacheManager$load$1) continuation;
            if ((adReportCacheManager$load$1.label & Integer.MIN_VALUE) != 0) {
                adReportCacheManager$load$1.label -= Integer.MIN_VALUE;
                Object $result = adReportCacheManager$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (adReportCacheManager$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!isFromStartUp2) {
                            KLog_androidKt.getKLog().d("AdReport", "AdReportCacheManager load re-upload data from memory cache");
                            IAdReportCache<String, ReportRecord> iAdReportCache = this.memoryCache;
                            adReportCacheManager$load$1.Z$0 = isFromStartUp2;
                            adReportCacheManager$load$1.label = 1;
                            all = iAdReportCache.getAll(adReportCacheManager$load$1);
                            if (all == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            KLog_androidKt.getKLog().d("AdReport", "AdReportCacheManager load re-upload data from local storage");
                            IAdReportLocalStorageCache<String, ReportRecord> iAdReportLocalStorageCache = this.localStorageCache;
                            adReportCacheManager$load$1.Z$0 = isFromStartUp2;
                            adReportCacheManager$load$1.label = 2;
                            Object load = iAdReportLocalStorageCache.load(true, adReportCacheManager$load$1);
                            if (load == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return load;
                        }
                        break;
                    case 1:
                        isFromStartUp2 = adReportCacheManager$load$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        all = $result;
                        break;
                    case 2:
                        boolean z = adReportCacheManager$load$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable $this$map$iv = CollectionsKt.toList(((Map) all).values());
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    ReportRecord it = (ReportRecord) item$iv$iv;
                    boolean isFromStartUp3 = isFromStartUp2;
                    final Function1 e = it.getExtraInfo();
                    it.setExtraInfo(new Function1() { // from class: kntr.app.ad.domain.report.internal.cache.AdReportCacheManager$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit load$lambda$0$0$0;
                            load$lambda$0$0$0 = AdReportCacheManager.load$lambda$0$0$0(e, (ReportExtraHandler) obj);
                            return load$lambda$0$0$0;
                        }
                    });
                    destination$iv$iv.add(it);
                    isFromStartUp2 = isFromStartUp3;
                }
                return (List) destination$iv$iv;
            }
        }
        adReportCacheManager$load$1 = new AdReportCacheManager$load$1(this, continuation);
        Object $result2 = adReportCacheManager$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adReportCacheManager$load$1.label) {
        }
        Iterable $this$map$iv2 = CollectionsKt.toList(((Map) all).values());
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r10.hasNext()) {
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0$0(Function1 $e, ReportExtraHandler reportExtraHandler) {
        Intrinsics.checkNotNullParameter(reportExtraHandler, "<this>");
        reportExtraHandler.put(ReportBuildInParam.IS_REUPLOAD, "1");
        if ($e != null) {
            $e.invoke(reportExtraHandler);
        }
        return Unit.INSTANCE;
    }
}