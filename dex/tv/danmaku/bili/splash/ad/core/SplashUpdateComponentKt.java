package tv.danmaku.bili.splash.ad.core;

import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashListResponseKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.services.SplashListResponseKit;
import tv.danmaku.bili.splash.ad.services.SplashListStreamReaderWriterHelperKt;
import tv.danmaku.bili.splash.ad.services.SplashServiceHelperKt;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.splash.ad.utils.ExtSplashOrderResourcesKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashLocalInfoHelper;
import tv.danmaku.bili.splash.ad.utils.SplashStateStorageHelperKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashUpdateComponent.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0080@¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001a\b\u0010\u0015\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0014H\u0000\u001a\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0019\u001a\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0002\u001a \u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001a\u000e\u0010!\u001a\u00020\u000b*\u0004\u0018\u00010\rH\u0002\u001a\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u0004\u0018\u00010\rH\u0002\u001a\b\u0010#\u001a\u00020\u0007H\u0000\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"updateJob", "Lkotlinx/coroutines/Job;", "canUpdateJobInterrupt", "", "readWriteLock", "", "updateSplash", "", "delay", "", "openEvent", "", "readConfigFromDisk", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "saveConfigToDisk", "response", "(Ltv/danmaku/bili/splash/ad/model/SplashListResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSaveToDisk", "encryptData", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "needRePreloadOnPageCreateInner", "increaseSplashShowCount", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "forceUpdateSplash", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeSplashList", "", "newData", "localData", "saveResourceToDisk", "localListData", "saveList", "getLoadedResSplashList", "getResReadySplashListFromDisk", "observerAppVisibleChange", "TAG", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashUpdateComponentKt {
    private static final String TAG = "[Splash]SplashUpdateComponent";
    private static boolean canUpdateJobInterrupt = true;
    private static final Object readWriteLock = new Object();
    private static Job updateJob;

    public static final void updateSplash(long delay, String openEvent) {
        Intrinsics.checkNotNullParameter(openEvent, "openEvent");
        BLog.i(TAG, "update splash delay = " + delay + "ms, openEvent = " + openEvent);
        if (!canUpdateJobInterrupt) {
            BLog.i(TAG, "updateSplash, cancel this task caused by prev task is running.");
            SplashCustomReporterKt.reportSplashListRequest(openEvent, SplashCustomReporterKt.STATE_CANCEL);
            return;
        }
        if (updateJob != null) {
            BLog.i(TAG, "updateSplash, prev task is not running, cancel prev delay task");
            Job job = updateJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            SplashCustomReporterKt.reportSplashListRequest(openEvent, SplashCustomReporterKt.STATE_REMOVE_PREV_DELAY_TASK);
        }
        updateJob = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new SplashUpdateComponentKt$updateSplash$1(delay, openEvent, null), 2, (Object) null);
        SplashCustomReporterKt.reportSplashListRequest(openEvent, SplashCustomReporterKt.STATE_ADD_TO_DELAY_TASK);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002c A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:5:0x0004, B:11:0x0016, B:13:0x0020, B:19:0x002c, B:20:0x0035, B:22:0x003b, B:23:0x003f, B:25:0x0047), top: B:32:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:5:0x0004, B:11:0x0016, B:13:0x0020, B:19:0x002c, B:20:0x0035, B:22:0x003b, B:23:0x003f, B:25:0x0047), top: B:32:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:11:0x0016, B:13:0x0020, B:19:0x002c, B:20:0x0035, B:22:0x003b, B:23:0x003f, B:25:0x0047), top: B:32:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SplashListResponse readConfigFromDisk() {
        boolean z;
        List encryptedSplash;
        List<SplashOrder> splashList;
        synchronized (readWriteLock) {
            SplashListResponse data = SplashListResponseKit.INSTANCE.getSplashListResponse(new Function1() { // from class: tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit readConfigFromDisk$lambda$0$0;
                    readConfigFromDisk$lambda$0$0 = SplashUpdateComponentKt.readConfigFromDisk$lambda$0$0((String) obj);
                    return readConfigFromDisk$lambda$0$0;
                }
            });
            if (data == null) {
                return null;
            }
            String lastSplashRequestId$adsplash_debug = SplashAdHelper.INSTANCE.getLastSplashRequestId$adsplash_debug();
            if (lastSplashRequestId$adsplash_debug != null && !StringsKt.isBlank(lastSplashRequestId$adsplash_debug)) {
                z = false;
                if (z) {
                    SplashAdHelper.INSTANCE.setLastSplashRequestId$adsplash_debug(data.getSplashRequestId());
                }
                encryptedSplash = SplashListStreamReaderWriterHelperKt.readEncryptSplashListFromDisk();
                if (encryptedSplash == null) {
                    encryptedSplash = CollectionsKt.emptyList();
                }
                splashList = data.getSplashList();
                if (splashList != null) {
                    splashList.addAll(encryptedSplash);
                }
                return data;
            }
            z = true;
            if (z) {
            }
            encryptedSplash = SplashListStreamReaderWriterHelperKt.readEncryptSplashListFromDisk();
            if (encryptedSplash == null) {
            }
            splashList = data.getSplashList();
            if (splashList != null) {
            }
            return data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readConfigFromDisk$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SplashCustomReporterKt.reportSplashSerializeFailed(false, it);
        return Unit.INSTANCE;
    }

    public static final Object saveConfigToDisk(SplashListResponse response, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new SplashUpdateComponentKt$saveConfigToDisk$2(response, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSaveToDisk(SplashListResponse response, List<SplashOrder> list) {
        synchronized (readWriteLock) {
            SplashListStreamReaderWriterHelperKt.saveSplashListResponseToDisk(response, new Function1() { // from class: tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit doSaveToDisk$lambda$0$0;
                    doSaveToDisk$lambda$0$0 = SplashUpdateComponentKt.doSaveToDisk$lambda$0$0((String) obj);
                    return doSaveToDisk$lambda$0$0;
                }
            });
            SplashListStreamReaderWriterHelperKt.saveEncryptSplashListToDisk(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doSaveToDisk$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SplashCustomReporterKt.reportSplashSerializeFailed(true, it);
        return Unit.INSTANCE;
    }

    public static final boolean needRePreloadOnPageCreateInner() {
        long now = System.currentTimeMillis();
        long expireTimeMs = SplashConfigKt.getSplashMaxPreloadExpireTimeMs();
        long preloadTimeMs = SplashManagerKt.getSplashState().getPreloadStartTime();
        boolean preloadDataExpired = now - preloadTimeMs > expireTimeMs && SplashConfigKt.getSplashEnablePreloadExpireReload();
        if (preloadDataExpired) {
            BLog.i(TAG, "needRePreloadOnPageCreate, needPreload = true, now = " + now + ", preloadTimeMs = " + preloadTimeMs + ", timeoutMs = " + expireTimeMs);
            long timeDifference = (now - preloadTimeMs) / 1000;
            SplashAdHelper.INSTANCE.reportPreloadDataExpired$adsplash_debug(timeDifference);
            SplashCustomReporterKt.reportPreloadDataExpired(timeDifference);
            SplashManagerKt.getSplashState().setPreloadStartTime(System.currentTimeMillis());
        }
        return preloadDataExpired;
    }

    public static final Job increaseSplashShowCount(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        return BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new SplashUpdateComponentKt$increaseSplashShowCount$1(splash, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forceUpdateSplash(String openEvent, Continuation<? super Unit> continuation) {
        SplashUpdateComponentKt$forceUpdateSplash$1 splashUpdateComponentKt$forceUpdateSplash$1;
        SplashListResponse localData;
        String openEvent2;
        SplashListResponse newData;
        SplashListResponse newData2;
        String openEvent3;
        List mergeList;
        if (continuation instanceof SplashUpdateComponentKt$forceUpdateSplash$1) {
            splashUpdateComponentKt$forceUpdateSplash$1 = (SplashUpdateComponentKt$forceUpdateSplash$1) continuation;
            if ((splashUpdateComponentKt$forceUpdateSplash$1.label & Integer.MIN_VALUE) != 0) {
                splashUpdateComponentKt$forceUpdateSplash$1.label -= Integer.MIN_VALUE;
                Object $result = splashUpdateComponentKt$forceUpdateSplash$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (splashUpdateComponentKt$forceUpdateSplash$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BLog.i(TAG, "forceUpdateSplash, start update splash, openEvent = " + openEvent);
                        localData = readConfigFromDisk();
                        SplashListResponse newData3 = SplashServiceHelperKt.requestSplashList(getLoadedResSplashList(localData), SplashListResponseKt.getUnExposeKeepIds(localData), openEvent);
                        if (newData3 == null) {
                            BLog.i(TAG, "forceUpdateSplash, server data invalid");
                            return Unit.INSTANCE;
                        }
                        SplashAdHelper.INSTANCE.reportNewKeepIdReceive$adsplash_debug(newData3.getKeepIds(), newData3.getSplashList());
                        SplashManagerKt.getSplashState().setSplashHotShowInterval(SplashListResponseKt.getValidIntervalForShow(newData3));
                        List mergeList2 = mergeSplashList(newData3, localData);
                        newData3.setSplashList(mergeList2);
                        if (SplashConfigKt.getSplashListResponseSaveImmediate()) {
                            splashUpdateComponentKt$forceUpdateSplash$1.L$0 = openEvent;
                            splashUpdateComponentKt$forceUpdateSplash$1.L$1 = localData;
                            splashUpdateComponentKt$forceUpdateSplash$1.L$2 = newData3;
                            splashUpdateComponentKt$forceUpdateSplash$1.L$3 = mergeList2;
                            splashUpdateComponentKt$forceUpdateSplash$1.label = 1;
                            if (saveConfigToDisk(newData3, splashUpdateComponentKt$forceUpdateSplash$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            newData2 = newData3;
                            openEvent3 = openEvent;
                            mergeList = mergeList2;
                            saveResourceToDisk(localData, mergeList);
                            long nextUpdateTimeMs = SplashListResponseKt.getValidIntervalForUpdate(newData2) * 1000;
                            SplashStateStorageHelperKt.setSplashLastRequestIntervalMs(nextUpdateTimeMs);
                            BLog.i(TAG, "forceUpdateSplash, end update splash, openEvent = " + openEvent3 + ", next update time = " + nextUpdateTimeMs + "ms");
                            return Unit.INSTANCE;
                        }
                        saveResourceToDisk(localData, mergeList2);
                        splashUpdateComponentKt$forceUpdateSplash$1.L$0 = openEvent;
                        splashUpdateComponentKt$forceUpdateSplash$1.L$1 = newData3;
                        splashUpdateComponentKt$forceUpdateSplash$1.label = 2;
                        if (saveConfigToDisk(newData3, splashUpdateComponentKt$forceUpdateSplash$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        openEvent2 = openEvent;
                        newData = newData3;
                        openEvent3 = openEvent2;
                        newData2 = newData;
                        long nextUpdateTimeMs2 = SplashListResponseKt.getValidIntervalForUpdate(newData2) * 1000;
                        SplashStateStorageHelperKt.setSplashLastRequestIntervalMs(nextUpdateTimeMs2);
                        BLog.i(TAG, "forceUpdateSplash, end update splash, openEvent = " + openEvent3 + ", next update time = " + nextUpdateTimeMs2 + "ms");
                        return Unit.INSTANCE;
                    case 1:
                        mergeList = (List) splashUpdateComponentKt$forceUpdateSplash$1.L$3;
                        newData2 = (SplashListResponse) splashUpdateComponentKt$forceUpdateSplash$1.L$2;
                        localData = (SplashListResponse) splashUpdateComponentKt$forceUpdateSplash$1.L$1;
                        openEvent3 = (String) splashUpdateComponentKt$forceUpdateSplash$1.L$0;
                        ResultKt.throwOnFailure($result);
                        saveResourceToDisk(localData, mergeList);
                        long nextUpdateTimeMs22 = SplashListResponseKt.getValidIntervalForUpdate(newData2) * 1000;
                        SplashStateStorageHelperKt.setSplashLastRequestIntervalMs(nextUpdateTimeMs22);
                        BLog.i(TAG, "forceUpdateSplash, end update splash, openEvent = " + openEvent3 + ", next update time = " + nextUpdateTimeMs22 + "ms");
                        return Unit.INSTANCE;
                    case 2:
                        newData = (SplashListResponse) splashUpdateComponentKt$forceUpdateSplash$1.L$1;
                        openEvent2 = (String) splashUpdateComponentKt$forceUpdateSplash$1.L$0;
                        ResultKt.throwOnFailure($result);
                        openEvent3 = openEvent2;
                        newData2 = newData;
                        long nextUpdateTimeMs222 = SplashListResponseKt.getValidIntervalForUpdate(newData2) * 1000;
                        SplashStateStorageHelperKt.setSplashLastRequestIntervalMs(nextUpdateTimeMs222);
                        BLog.i(TAG, "forceUpdateSplash, end update splash, openEvent = " + openEvent3 + ", next update time = " + nextUpdateTimeMs222 + "ms");
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        splashUpdateComponentKt$forceUpdateSplash$1 = new SplashUpdateComponentKt$forceUpdateSplash$1(continuation);
        Object $result2 = splashUpdateComponentKt$forceUpdateSplash$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (splashUpdateComponentKt$forceUpdateSplash$1.label) {
        }
    }

    private static final List<SplashOrder> mergeSplashList(SplashListResponse newData, SplashListResponse localData) {
        List oldList;
        List<SplashOrder> newList;
        if (localData == null || (oldList = localData.getSplashList()) == null) {
            oldList = new ArrayList();
        }
        if (newData == null || (newList = newData.getSplashList()) == null) {
            newList = new ArrayList();
        }
        List<Number> mergeIds = new ArrayList();
        if (newData != null && newData.getKeepIds() != null) {
            LongSparseArray newIds = new LongSparseArray();
            Object value = new Object();
            for (SplashOrder splash : newList) {
                newIds.put(splash.getId(), value);
            }
            for (Long l : newData.getKeepIds()) {
                long id = l.longValue();
                if (newIds.indexOfKey(id) < 0) {
                    mergeIds.add(Long.valueOf(id));
                }
            }
        }
        LongSparseArray oldSplash = new LongSparseArray();
        for (SplashOrder splash2 : oldList) {
            oldSplash.put(splash2.getId(), splash2);
        }
        for (Number number : mergeIds) {
            SplashOrder splash3 = (SplashOrder) oldSplash.get(number.longValue());
            if (splash3 != null) {
                newList.add(splash3);
            }
        }
        Set idSet = new HashSet();
        for (SplashOrder splash4 : newList) {
            idSet.add(Long.valueOf(splash4.getId()));
            SplashOrder old = (SplashOrder) oldSplash.get(splash4.getId());
            if (old != null) {
                splash4.setLocalExposeCount(old.getLocalExposeCount());
                splash4.setLastExposeTime(old.getLastExposeTime());
            }
        }
        List deleteIds = new ArrayList();
        int size = oldSplash.size();
        for (int i = 0; i < size; i++) {
            long id2 = oldSplash.keyAt(i);
            if (!idSet.contains(Long.valueOf(id2))) {
                deleteIds.add(Long.valueOf(id2));
            }
        }
        SplashAdHelper.INSTANCE.reportSplashOrderDelete$adsplash_debug(deleteIds);
        return newList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void saveResourceToDisk(SplashListResponse localListData, List<SplashOrder> list) {
        List oldResList = getResReadySplashListFromDisk(localListData);
        BusinessSplashResHelper.INSTANCE.deleteUselessResources(list, oldResList);
        SplashLocalInfoHelper.getDeviceSize();
        boolean isPeakDownloaderEnable = SplashConfigKt.getBusinessSplashUsePeakDownloader();
        List<SplashOrder> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            SplashOrder splash = (SplashOrder) element$iv;
            if (!ExtSplashOrderResourcesKt.isSplashDownloadEnable(splash)) {
                SplashCustomReporterKt.reportSplashDownloadDisable(splash);
            } else {
                if (isPeakDownloaderEnable) {
                    List it = ExtSplashOrderResourcesKt.getUnReadyPeakTaskList(splash);
                    if (!it.isEmpty()) {
                        BusinessSplashResHelper.INSTANCE.downloadUsePeak(it == null ? CollectionsKt.emptyList() : it, splash);
                        BusinessSplashResHelper.INSTANCE.downloadEggResourceAsync(splash);
                        BusinessSplashResHelper.INSTANCE.downloadSecondPageEggVideo(splash);
                        BusinessSplashResHelper.INSTANCE.downloadMainLogo(splash.getLogoUrl(), splash.getLogoHash(), splash.getSplashType());
                        BusinessSplashResHelper.INSTANCE.downloadButtonRes(splash.getSplashGuideButton(), splash.getSplashType());
                        if (splash.getSecondPage() != null) {
                            BusinessSplashResHelper.INSTANCE.downloadButtonRes(splash.getSecondPage().getSecondPageButtons(), splash.getSplashType());
                        }
                        BusinessSplashResHelper.INSTANCE.downloadAnimationResourceAsync(splash);
                    }
                }
                BusinessSplashResHelper.INSTANCE.handleMainImageDownload$adsplash_debug(splash);
                BusinessSplashResHelper.INSTANCE.handleMainVideoDownload$adsplash_debug(splash);
                BusinessSplashResHelper.INSTANCE.downloadEggResourceAsync(splash);
                BusinessSplashResHelper.INSTANCE.downloadSecondPageEggVideo(splash);
                BusinessSplashResHelper.INSTANCE.downloadMainLogo(splash.getLogoUrl(), splash.getLogoHash(), splash.getSplashType());
                BusinessSplashResHelper.INSTANCE.downloadButtonRes(splash.getSplashGuideButton(), splash.getSplashType());
                if (splash.getSecondPage() != null) {
                }
                BusinessSplashResHelper.INSTANCE.downloadAnimationResourceAsync(splash);
            }
        }
        BusinessSplashResHelper.INSTANCE.downloadTopViewRes(list, oldResList);
    }

    private static final String getLoadedResSplashList(SplashListResponse $this$getLoadedResSplashList) {
        List<Long> keepIds;
        Iterable savedResList = getResReadySplashListFromDisk($this$getLoadedResSplashList);
        List savedResIds = new ArrayList();
        Iterable $this$forEach$iv = savedResList;
        for (Object element$iv : $this$forEach$iv) {
            SplashOrder splash = (SplashOrder) element$iv;
            boolean z = false;
            if ($this$getLoadedResSplashList != null && (keepIds = $this$getLoadedResSplashList.getKeepIds()) != null && keepIds.contains(Long.valueOf(splash.getId()))) {
                z = true;
            }
            if (!z || !splash.isLocalExposed()) {
                savedResIds.add(String.valueOf(splash.getId()));
            }
        }
        return CollectionsKt.joinToString$default(savedResIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private static final List<SplashOrder> getResReadySplashListFromDisk(SplashListResponse $this$getResReadySplashListFromDisk) {
        if ($this$getResReadySplashListFromDisk == null) {
            return CollectionsKt.emptyList();
        }
        List localResReadySplashList = new ArrayList();
        Iterable localSplashList = $this$getResReadySplashListFromDisk.getSplashList();
        List<SplashOrder> list = (Collection) localSplashList;
        if (list == null || list.isEmpty()) {
            return localResReadySplashList;
        }
        Iterable $this$forEach$iv = localSplashList;
        for (Object element$iv : $this$forEach$iv) {
            SplashOrder splash = (SplashOrder) element$iv;
            boolean isImageReady = BusinessSplashResHelper.INSTANCE.isResourceExistByHash(splash.getImageHash());
            boolean isVideoReady = BusinessSplashResHelper.INSTANCE.isResourceExistByHash(splash.getVideoHash());
            if (isImageReady && ExtSplashOrderKt.isOnlyImageSplash(splash)) {
                localResReadySplashList.add(splash);
            } else if (isVideoReady && ExtSplashOrderKt.isOnlyVideoSplash(splash)) {
                localResReadySplashList.add(splash);
            } else if (isImageReady && isVideoReady && ExtSplashOrderKt.isImageVideoMixCardType(splash)) {
                localResReadySplashList.add(splash);
            }
        }
        return localResReadySplashList;
    }

    public static final void observerAppVisibleChange() {
        if (SplashConfigKt.getSplashUpdateListWhenEnterBackground()) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashUpdateComponentKt$observerAppVisibleChange$1(null), 3, (Object) null);
        }
    }
}