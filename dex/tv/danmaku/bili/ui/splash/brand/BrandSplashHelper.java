package tv.danmaku.bili.ui.splash.brand;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.RandomUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResCallback;
import com.bilibili.lib.resmanager.ResDownloadRequest;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.stagger.StaggerManager;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.search.DefaultWordItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.BuildConfig;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashParam;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfo;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfoKt;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashData;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashDataKt;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.model.NormalBrandShow;
import tv.danmaku.bili.ui.splash.brand.model.NormalBrandShowKt;
import tv.danmaku.bili.ui.splash.brand.model.PreloadBrandData;
import tv.danmaku.bili.ui.splash.brand.model.PreloadBrandDataKt;
import tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper;
import tv.danmaku.bili.ui.splash.common.search.QueryItem;
import tv.danmaku.bili.ui.splash.common.search.QueryItemKt;
import tv.danmaku.bili.ui.splash.common.search.SplashSearchServiceImpl;
import tv.danmaku.bili.ui.splash.common.search.SplashSearchServiceImplKt;
import tv.danmaku.bili.ui.splash.event.EventSplashManagerKt;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.utils.UiUtilsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: BrandSplashHelper.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u001e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u001a\u0010!\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0016\u0010\"\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0$H\u0002J\u0018\u0010%\u001a\u00020\r2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0$H\u0003J\u0012\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010(\u001a\u00020\r2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001fH\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u001a\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u007f\u0010/\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010$2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010$2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00172\b\b\u0002\u00104\u001a\u0002052-\b\u0002\u00106\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\u001f¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u000107H\u0002J2\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010$2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010$H\u0002J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0002J\u0018\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020 H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010A\u001a\u00020\rH\u0002J\u0014\u0010B\u001a\u00020\r2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020 0$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/BrandSplashHelper;", "", "<init>", "()V", "TAG", "", "SPLASH_QUERY_FF", "mPreloadTask", "Ljava/util/concurrent/Future;", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "mQueryItem", "Ltv/danmaku/bili/ui/splash/common/search/QueryItem;", "update", "", "delay", "", "preloadBrandData", "context", "Landroid/content/Context;", "getBrandSplashForShow", "release", "updateInternal", "hasBrandResChanged", "", "oldData", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;", "newData", "refreshBrandForceInfo", "data", "checkCustomData", "brandList", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "removeUnusedRes", "saveCollectionResToDisk", "splashList", "", "saveResourceToDisk", "newSplash", "loadBrandSplashForShow", "setSplashQuery", "queryList", "getCustomBrands", "getPreloadShowInfo", "getForceShowInfo", "hasValidPreload", "getDefaultShowInfo", "getShowInfoByConfig", "showList", "Ltv/danmaku/bili/ui/splash/brand/model/NormalBrandShow;", "rule", "isForce", "forceShowTimes", "", "forceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "getBrandShowInfoList", "getCustomShowInfo", "mapping", "show", "brand", "obtainDefault", "setBrandSplashSearchData", "saveCustomBrands", "brands", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashHelper {
    private static final String SPLASH_QUERY_FF = "ff_splash_search_word_enable";
    public static final String TAG = "[BrandSplash]BrandSplashHelper";
    private static Future<BrandShowInfo> mPreloadTask;
    private static QueryItem mQueryItem;
    public static final BrandSplashHelper INSTANCE = new BrandSplashHelper();
    public static final int $stable = 8;

    @JvmStatic
    public static final void update() {
        update$default(0L, 1, null);
    }

    private BrandSplashHelper() {
    }

    public static /* synthetic */ void update$default(long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        update(j);
    }

    @JvmStatic
    public static final void update(long delay) {
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BrandSplashHelper.update$lambda$0(context);
            }
        }, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$0(Application $context) {
        INSTANCE.updateInternal($context);
    }

    @JvmStatic
    public static final void preloadBrandData(Context context) {
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        BrandSplashStorage.INSTANCE.ensureMigrated();
        mPreloadTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BrandShowInfo preloadBrandData$lambda$0;
                preloadBrandData$lambda$0 = BrandSplashHelper.preloadBrandData$lambda$0(context2);
                return preloadBrandData$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandShowInfo preloadBrandData$lambda$0(Context $context) {
        BrandShowInfo $this$preloadBrandData_u24lambda_u240_u240 = INSTANCE.loadBrandSplashForShow($context);
        if ($this$preloadBrandData_u24lambda_u240_u240 != null) {
            $this$preloadBrandData_u24lambda_u240_u240.setLocalBitmap(BrandShowInfoKt.getBitmap($this$preloadBrandData_u24lambda_u240_u240));
            return $this$preloadBrandData_u24lambda_u240_u240;
        }
        return null;
    }

    public final BrandShowInfo getBrandSplashForShow(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Future it = mPreloadTask;
        if (it != null) {
            if (!(it.isDone() || !it.isCancelled())) {
                it = null;
            }
            if (it != null) {
                try {
                    Future<BrandShowInfo> future = mPreloadTask;
                    Intrinsics.checkNotNull(future);
                    return future.get();
                } catch (Exception e) {
                    BLog.e(TAG, "Preload brand splash data error.", e);
                    return INSTANCE.obtainDefault();
                }
            }
        }
        return loadBrandSplashForShow(context2);
    }

    public final void release() {
        if (mPreloadTask != null) {
            Future<BrandShowInfo> future = mPreloadTask;
            if (future != null) {
                future.cancel(true);
            }
            mPreloadTask = null;
        }
        EventSplashManagerKt.releaseEventSplashPreloadTask();
    }

    private final void updateInternal(Context context) {
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit updateInternal$lambda$0;
                updateInternal$lambda$0 = BrandSplashHelper.updateInternal$lambda$0(context2);
                return updateInternal$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateInternal$lambda$0(Context $context) {
        BLog.i(TAG, "Start update brand splash data.");
        BrandSplashData newData = BrandSplashServiceHelper.INSTANCE.getBrandSplashData();
        if (newData == null) {
            return Unit.INSTANCE;
        }
        BrandSplashData oldData = BrandSplashStorage.INSTANCE.readBrandData();
        if (SplashConfigKt.getUseStagger() && INSTANCE.hasBrandResChanged(oldData, newData)) {
            StaggerManager.INSTANCE.onManifestChanged();
        }
        INSTANCE.removeUnusedRes(oldData, newData);
        if (!SplashConfigKt.getUseStagger()) {
            INSTANCE.saveResourceToDisk(BrandSplashDataKt.getBrandSplashList(newData));
        }
        INSTANCE.saveCollectionResToDisk(BrandSplashDataKt.getCollectionSplashList(newData));
        BrandSplashStorage.INSTANCE.saveBrandData(newData);
        INSTANCE.refreshBrandForceInfo($context, newData);
        BLog.i(TAG, "End update brand splash data.");
        if (newData.getPullInterval() <= 0) {
            newData.setPullInterval(900L);
        }
        INSTANCE.checkCustomData($context, BrandSplashDataKt.getAllSplash(newData));
        update(newData.getPullInterval() * ((long) IjkMediaCodecInfo.RANK_MAX));
        return Unit.INSTANCE;
    }

    private final boolean hasBrandResChanged(BrandSplashData oldData, BrandSplashData newData) {
        Iterable brandSplashList;
        Iterable brandList;
        if (oldData != null && (brandSplashList = BrandSplashDataKt.getBrandSplashList(oldData)) != null) {
            Iterable $this$map$iv = brandSplashList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(((BrandSplash) item$iv$iv).getThumbHash());
            }
            HashSet oldRes = CollectionsKt.toHashSet((List) destination$iv$iv);
            if (oldRes != null && (brandList = newData.getBrandList()) != null) {
                Iterable $this$forEach$iv = brandList;
                for (Object element$iv : $this$forEach$iv) {
                    BrandSplash it = (BrandSplash) element$iv;
                    String hash = it != null ? it.getThumbHash() : null;
                    String str = hash;
                    if (!(str == null || StringsKt.isBlank(str)) && !oldRes.contains(hash)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private final void refreshBrandForceInfo(Context context, BrandSplashData data) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (!Intrinsics.areEqual(data.getForceShowHash(), BrandSplashStorage.INSTANCE.getLocalForceShowHash(context2))) {
            BrandSplashStorage.INSTANCE.saveLocalForceShowHash(context2, data.getForceShowHash());
            BrandSplashStorage.INSTANCE.getForceInfoSharedPreferences(context2).edit().clear().apply();
        }
    }

    private final void checkCustomData(Context context, List<BrandSplash> list) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Iterable $this$map$iv = BrandSplashStorage.readCustomBrands$default(BrandSplashStorage.INSTANCE, false, 1, null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(BrandSplashKt.getUniqueId((BrandSplash) item$iv$iv));
        }
        Set customSet = CollectionsKt.toSet((List) destination$iv$iv);
        List validCustomBrands = new ArrayList();
        List<BrandSplash> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            BrandSplash brandSplash = (BrandSplash) element$iv;
            if (customSet.contains(BrandSplashKt.getUniqueId(brandSplash))) {
                validCustomBrands.add(brandSplash);
            }
        }
        if (validCustomBrands.isEmpty()) {
            BrandSplashStorage.INSTANCE.clearCustomData();
            BrandSplashStorage.INSTANCE.setCustomMode(false);
            BrandSplashStorage.INSTANCE.setShowInvalidToast(context2, true);
        } else {
            BrandSplashStorage.INSTANCE.saveCustomSplash(validCustomBrands);
        }
        List $this$filter$iv = validCustomBrands;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!BrandSplashKt.isResValid((BrandSplash) element$iv$iv)) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv2 = (List) destination$iv$iv2;
        for (Object element$iv2 : $this$forEach$iv2) {
            BrandSplash it = (BrandSplash) element$iv2;
            ResManager.download$default(new ResDownloadRequest(it.getThumb(), it.getThumbHash()).md5(it.getThumbHash()).downloadTag("brand_splash").bizType(DownloadBizType.BrandSplash), (ResCallback) null, 2, (Object) null);
        }
    }

    private final void removeUnusedRes(BrandSplashData oldData, BrandSplashData newData) {
        Sequence asSequence;
        Sequence mapNotNull;
        Sequence filter;
        Set hashSet;
        if (oldData == null) {
            return;
        }
        List<BrandSplash> brandList = newData.getBrandList();
        Set newDataHash = (brandList == null || (asSequence = CollectionsKt.asSequence(brandList)) == null || (mapNotNull = SequencesKt.mapNotNull(asSequence, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                String removeUnusedRes$lambda$0;
                removeUnusedRes$lambda$0 = BrandSplashHelper.removeUnusedRes$lambda$0((BrandSplash) obj);
                return removeUnusedRes$lambda$0;
            }
        })) == null || (filter = SequencesKt.filter(mapNotNull, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean removeUnusedRes$lambda$1;
                removeUnusedRes$lambda$1 = BrandSplashHelper.removeUnusedRes$lambda$1((String) obj);
                return Boolean.valueOf(removeUnusedRes$lambda$1);
            }
        })) == null || (hashSet = SequencesKt.toHashSet(filter)) == null) ? SetsKt.emptySet() : hashSet;
        Iterable brandList2 = oldData.getBrandList();
        if (brandList2 != null) {
            Iterable $this$forEach$iv = brandList2;
            for (Object element$iv : $this$forEach$iv) {
                BrandSplash it = (BrandSplash) element$iv;
                String hash = it != null ? it.getThumbHash() : null;
                String str = hash;
                if (!(str == null || StringsKt.isBlank(str)) && !newDataHash.contains(hash)) {
                    BLog.i(TAG, "removeUnusedRes hash:" + hash);
                    UiUtilsKt.delete(ResManager.INSTANCE, null, hash);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String removeUnusedRes$lambda$0(BrandSplash it) {
        if (it != null) {
            return it.getThumbHash();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeUnusedRes$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length() > 0;
    }

    private final void saveCollectionResToDisk(List<BrandSplash> list) {
        Iterable splashList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Iterable $this$filter$iv = splashList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            BrandSplash it = (BrandSplash) element$iv$iv;
            String thumb = it.getThumb();
            boolean z = false;
            if (!(thumb == null || StringsKt.isBlank(thumb)) && !BrandSplashKt.isResValid(it)) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            BrandSplash it2 = (BrandSplash) element$iv;
            ResManager.downloadSync(new ResDownloadRequest(it2.getThumb(), it2.getThumbHash()).md5(it2.getThumbHash()).downloadTag("brand_splash").bizType(DownloadBizType.BrandSplash));
        }
    }

    private final void saveResourceToDisk(List<BrandSplash> list) {
        Iterable newSplash = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Iterable $this$filter$iv = newSplash;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$filter$iv.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            BrandSplash it2 = (BrandSplash) element$iv$iv;
            String thumbHash = it2 != null ? it2.getThumbHash() : null;
            if (!(thumbHash == null || StringsKt.isBlank(thumbHash))) {
                String thumb = it2 != null ? it2.getThumb() : null;
                if (!(thumb == null || StringsKt.isBlank(thumb))) {
                    if (!UiUtilsKt.isFileExistByHash(ResManager.INSTANCE, it2 != null ? it2.getThumbHash() : null)) {
                        z = true;
                    }
                }
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            BrandSplash it3 = (BrandSplash) element$iv;
            ResDownloadRequest req = new ResDownloadRequest(it3 != null ? it3.getThumb() : null, it3 != null ? it3.getThumbHash() : null).md5(it3 != null ? it3.getThumbHash() : null).cleanable(false).bizType(DownloadBizType.BrandSplash).encrypted(true).downloadTag("brand_splash");
            boolean result = ResManager.downloadSync(req);
            BLog.i(TAG, "Download url " + (it3 != null ? it3.getThumb() : null) + " data done, result is: " + result + " ");
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("state", result ? "0" : "1");
            pairArr[1] = TuplesKt.to("type", "1");
            pairArr[2] = TuplesKt.to("url", it3 != null ? it3.getThumb() : null);
            Neurons.trackT(false, "main.brand-splash.download.state", MapsKt.mapOf(pairArr), 1, new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean saveResourceToDisk$lambda$1$0;
                    saveResourceToDisk$lambda$1$0 = BrandSplashHelper.saveResourceToDisk$lambda$1$0();
                    return Boolean.valueOf(saveResourceToDisk$lambda$1$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean saveResourceToDisk$lambda$1$0() {
        return true;
    }

    private final BrandShowInfo loadBrandSplashForShow(Context context) {
        BrandShowInfo showInfo;
        BrandShowInfo result;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (!BrandSplashParam.INSTANCE.brandSplashEnable()) {
            BLog.i(TAG, "loadBrandSplashForShow disabled");
            return null;
        }
        BrandSplashData brandData = BrandSplashStorage.INSTANCE.readBrandData();
        setSplashQuery(brandData != null ? brandData.getQueryList() : null);
        if (brandData != null) {
            List<BrandSplash> brandList = brandData.getBrandList();
            boolean z = false;
            if (!(brandList == null || brandList.isEmpty())) {
                try {
                    boolean hasPreload = hasValidPreload(brandData);
                    if (hasPreload) {
                        showInfo = getPreloadShowInfo(context2, brandData);
                    } else if (brandData.getForcibly()) {
                        showInfo = getForceShowInfo(context2, brandData);
                    } else {
                        showInfo = getDefaultShowInfo(context2, brandData);
                    }
                    BLog.i(TAG, "get custom brands");
                    BrandShowInfo customInfo = getCustomBrands(context2);
                    if (showInfo != null && (BrandShowInfoKt.isForceShowValid(showInfo) || customInfo == null)) {
                        result = showInfo;
                    } else {
                        result = customInfo;
                    }
                    if (result != null && result.isValid()) {
                        z = true;
                    }
                    return z ? result : obtainDefault();
                } catch (Exception e) {
                    if (BuildConfig.DEBUG) {
                        throw e;
                    }
                    CrashReporter.INSTANCE.postCaughtException(e);
                    BLog.e(TAG, "Find brand show info error.", e);
                    return obtainDefault();
                }
            }
        }
        BLog.i(TAG, "brandData is null  get default");
        return obtainDefault();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSplashQuery(List<QueryItem> list) {
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get(SPLASH_QUERY_FF, true), false)) {
            return;
        }
        QueryItem queryItem = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                QueryItem it2 = (QueryItem) next;
                if (QueryItemKt.isValid(it2)) {
                    queryItem = next;
                    break;
                }
            }
            queryItem = queryItem;
        }
        mQueryItem = queryItem;
        BLog.i(TAG, "setSplashQuery");
    }

    private final BrandShowInfo getCustomBrands(Context context) {
        BrandShowInfo customData;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        List customDataList = getCustomShowInfo();
        if (customDataList.isEmpty()) {
            customDataList = null;
        }
        if (customDataList == null) {
            return null;
        }
        String lastShowId = BrandSplashStorage.INSTANCE.getLastShowStrId(context2);
        List $this$indexOfFirst$iv = customDataList;
        int index$iv = 0;
        Iterator<BrandShowInfo> it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                BrandShowInfo it2 = (BrandShowInfo) item$iv;
                if (Intrinsics.areEqual(BrandShowInfoKt.getUniqueId(it2), lastShowId)) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int lastShowIndex = index$iv;
        boolean z = false;
        if (lastShowIndex < 0) {
            customData = customDataList.get(0);
        } else {
            int next = (lastShowIndex + 1) % customDataList.size();
            if (next >= 0 && next < customDataList.size()) {
                customData = customDataList.get(next);
            } else {
                customData = null;
            }
        }
        if (customData != null) {
            BrandShowInfo $this$getCustomBrands_u24lambda_u242 = customData;
            $this$getCustomBrands_u24lambda_u242.setReportFlag(2);
        } else {
            customData = null;
        }
        BLog.i(TAG, "getCustomBrands url:" + (customData != null ? customData.getThumb() : null) + " hash:" + (customData != null ? customData.getThumbHash() : null));
        if (customData != null && customData.isValid()) {
            z = true;
        }
        if (z) {
            return customData;
        }
        return null;
    }

    private final BrandShowInfo getPreloadShowInfo(Context context, BrandSplashData data) {
        BrandShowInfo info;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Iterable preloadList = data.getPreloadList();
        if (preloadList == null) {
            return null;
        }
        Iterable $this$filter$iv = preloadList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PreloadBrandData it = (PreloadBrandData) element$iv$iv;
            if (it != null && PreloadBrandDataKt.isTimeValid(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            PreloadBrandData it2 = (PreloadBrandData) element$iv;
            if (it2 != null && (info = getShowInfoByConfig$default(INSTANCE, context2, it2.getShowList(), data.getBrandList(), it2.getRule(), it2.getForcibly(), 0, null, 96, null)) != null && info.isValid()) {
                return info;
            }
        }
        return null;
    }

    private final BrandShowInfo getForceShowInfo(Context context, final BrandSplashData data) {
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        return getShowInfoByConfig(context2, data.getShowList(), data.getBrandList(), data.getRule(), data.getForcibly(), data.getForceShowTimes(), new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.BrandSplashHelper$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                BrandShowInfo forceShowInfo$lambda$0;
                forceShowInfo$lambda$0 = BrandSplashHelper.getForceShowInfo$lambda$0(BrandSplashData.this, context2, (List) obj);
                return forceShowInfo$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandShowInfo getForceShowInfo$lambda$0(BrandSplashData $data, Context $context, List validBrandList) {
        Intrinsics.checkNotNullParameter(validBrandList, "validBrandList");
        int total = 0;
        ArrayList unconsumedInfo = new ArrayList();
        Iterator it = validBrandList.iterator();
        while (it.hasNext()) {
            BrandShowInfo info = (BrandShowInfo) it.next();
            if ($data.getForceShowTimes() <= 0 || BrandSplashStorage.INSTANCE.isBrandSplashShowCountNotLimit($context, $data.getForceShowTimes(), info.getId())) {
                unconsumedInfo.add(info);
                total += info.getProbability();
            }
        }
        if (total <= 0) {
            total = 100;
        }
        int random = RandomUtils.nextInt(total);
        int lastIndex = 0;
        Iterator it2 = unconsumedInfo.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            BrandShowInfo info2 = (BrandShowInfo) it2.next();
            if (random >= lastIndex && random < info2.getProbability() + lastIndex) {
                return info2;
            }
            lastIndex += info2.getProbability();
        }
        return null;
    }

    private final boolean hasValidPreload(BrandSplashData data) {
        Iterable preloadList;
        PreloadBrandData it;
        if (data == null || (preloadList = data.getPreloadList()) == null) {
            return false;
        }
        Iterable $this$any$iv = preloadList;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            PreloadBrandData it2 = (PreloadBrandData) element$iv;
            if (it2 == null || !PreloadBrandDataKt.isTimeValid(it2)) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    private final BrandShowInfo getDefaultShowInfo(Context context, BrandSplashData data) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        return getShowInfoByConfig$default(this, context2, data.getShowList(), data.getBrandList(), data.getRule(), data.getForcibly(), 0, null, 96, null);
    }

    static /* synthetic */ BrandShowInfo getShowInfoByConfig$default(BrandSplashHelper brandSplashHelper, Context context, List list, List list2, String str, boolean z, int i, Function1 function1, int i2, Object obj) {
        int i3;
        Function1 function12;
        if ((i2 & 32) == 0) {
            i3 = i;
        } else {
            i3 = 0;
        }
        if ((i2 & 64) == 0) {
            function12 = function1;
        } else {
            function12 = null;
        }
        return brandSplashHelper.getShowInfoByConfig(context, list, list2, str, z, i3, function12);
    }

    private final BrandShowInfo getShowInfoByConfig(Context context, List<NormalBrandShow> list, List<BrandSplash> list2, String rule, boolean isForce, int forceShowTimes, Function1<? super List<BrandShowInfo>, BrandShowInfo> function1) {
        Object obj;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        List showList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List brandList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        BrandShowInfo result = null;
        Iterable $this$filter$iv = getBrandShowInfoList(showList, brandList);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            BrandShowInfo it = (BrandShowInfo) element$iv$iv;
            if (it.isValid()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List<BrandShowInfo> brandsInfo = CollectionsKt.toMutableList((List) destination$iv$iv);
        if (brandsInfo.isEmpty()) {
            return null;
        }
        boolean z = false;
        if (Intrinsics.areEqual(BrandSplashDataKt.ORDER_RULE, rule)) {
            String lastShowId = BrandSplashStorage.INSTANCE.getLastShowStrId(context2);
            if (StringsKt.isBlank(lastShowId)) {
                result = (BrandShowInfo) brandsInfo.get(0);
            } else {
                Iterator it2 = brandsInfo.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    BrandShowInfo it3 = (BrandShowInfo) obj;
                    if (Intrinsics.areEqual(BrandShowInfoKt.getUniqueId(it3), lastShowId)) {
                        break;
                    }
                }
                BrandShowInfo showed = (BrandShowInfo) obj;
                int index = showed == null ? -1 : brandsInfo.indexOf(showed);
                int next = (index + 1) % brandsInfo.size();
                if (next < brandsInfo.size() && next >= 0) {
                    result = (BrandShowInfo) brandsInfo.get(next);
                }
            }
        } else if (function1 != null) {
            result = (BrandShowInfo) function1.invoke(brandsInfo);
        } else {
            int total = 0;
            for (BrandShowInfo info : brandsInfo) {
                total += info.getProbability();
            }
            if (total <= 0) {
                total = 100;
            }
            int random = RandomUtils.nextInt(total);
            int lastIndex = 0;
            Iterator it4 = brandsInfo.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                BrandShowInfo info2 = (BrandShowInfo) it4.next();
                if (random > lastIndex && random <= info2.getProbability() + lastIndex) {
                    result = info2;
                    break;
                }
                lastIndex += info2.getProbability();
            }
        }
        if (result != null) {
            result.setForce(isForce);
        }
        if (result != null) {
            result.setForceShowTimes(forceShowTimes);
        }
        if (result != null) {
            result.setReportFlag(isForce ? 4 : 1);
        }
        if (result != null && result.isValid()) {
            z = true;
        }
        if (z) {
            return result;
        }
        return null;
    }

    private final List<BrandShowInfo> getBrandShowInfoList(List<NormalBrandShow> list, List<BrandSplash> list2) {
        List showList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List brandList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        List list3 = showList;
        if (!(list3 == null || list3.isEmpty())) {
            List list4 = brandList;
            if (!(list4 == null || list4.isEmpty())) {
                Iterable $this$map$iv = BrandSplashStorage.readCustomBrands$default(BrandSplashStorage.INSTANCE, false, 1, null);
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    BrandSplash it = (BrandSplash) item$iv$iv;
                    destination$iv$iv.add(BrandSplashKt.getUniqueId(it));
                }
                Set customSet = CollectionsKt.toSet((List) destination$iv$iv);
                ArrayList list5 = new ArrayList();
                Iterable $this$associateBy$iv = CollectionsKt.filterNotNull(brandList);
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv : $this$associateBy$iv) {
                    BrandSplash it2 = (BrandSplash) element$iv$iv;
                    BrandSplash it3 = (BrandSplash) element$iv$iv;
                    destination$iv$iv2.put(BrandSplashKt.getUniqueId(it2), it3);
                }
                Iterable $this$forEach$iv = CollectionsKt.filterNotNull(showList);
                for (Object element$iv : $this$forEach$iv) {
                    NormalBrandShow show = (NormalBrandShow) element$iv;
                    BrandSplash brandSplash = (BrandSplash) destination$iv$iv2.get(NormalBrandShowKt.getUniqueId(show));
                    if (brandSplash != null) {
                        BrandShowInfo info = INSTANCE.mapping(show, brandSplash);
                        if (customSet.contains(BrandShowInfoKt.getUniqueId(info))) {
                            info.setSelected(true);
                        }
                        list5.add(info);
                    }
                }
                return list5;
            }
        }
        return new ArrayList();
    }

    private final List<BrandShowInfo> getCustomShowInfo() {
        Iterable customList = BrandSplashStorage.readCustomBrands$default(BrandSplashStorage.INSTANCE, false, 1, null);
        Iterable $this$map$iv = customList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            BrandSplash splash = (BrandSplash) item$iv$iv;
            BrandShowInfo $this$getCustomShowInfo_u24lambda_u240_u240 = new BrandShowInfo();
            $this$getCustomShowInfo_u24lambda_u240_u240.setId(splash.getId());
            $this$getCustomShowInfo_u24lambda_u240_u240.setThumb(splash.getThumb());
            $this$getCustomShowInfo_u24lambda_u240_u240.setThumbHash(splash.getThumbHash());
            $this$getCustomShowInfo_u24lambda_u240_u240.setMode(splash.getMode());
            $this$getCustomShowInfo_u24lambda_u240_u240.setLogoUrl(splash.getLogoUrl());
            $this$getCustomShowInfo_u24lambda_u240_u240.setLogoHash(splash.getLogoHash());
            $this$getCustomShowInfo_u24lambda_u240_u240.setSelected(splash.isSelected());
            $this$getCustomShowInfo_u24lambda_u240_u240.setShowLogo(splash.getShowLogo());
            $this$getCustomShowInfo_u24lambda_u240_u240.setCustom(true);
            $this$getCustomShowInfo_u24lambda_u240_u240.setSource(splash.getSource());
            $this$getCustomShowInfo_u24lambda_u240_u240.setThumbName(splash.getThumbName());
            $this$getCustomShowInfo_u24lambda_u240_u240.setDuration(BrandSplashParam.INSTANCE.getDefaultDuration());
            destination$iv$iv.add($this$getCustomShowInfo_u24lambda_u240_u240);
        }
        return CollectionsKt.toMutableList((List) destination$iv$iv);
    }

    private final BrandShowInfo mapping(NormalBrandShow show, BrandSplash brand) {
        BrandShowInfo $this$mapping_u24lambda_u240 = new BrandShowInfo();
        $this$mapping_u24lambda_u240.setId(show.getId());
        $this$mapping_u24lambda_u240.setBeginTime(show.getBeginTime());
        $this$mapping_u24lambda_u240.setEndTime(show.getEndTime());
        $this$mapping_u24lambda_u240.setProbability(show.getProbability());
        $this$mapping_u24lambda_u240.setDuration(show.getDuration() > 0 ? show.getDuration() : BrandSplashParam.INSTANCE.getDefaultDuration());
        $this$mapping_u24lambda_u240.setThumb(brand.getThumb());
        $this$mapping_u24lambda_u240.setThumbHash(brand.getThumbHash());
        $this$mapping_u24lambda_u240.setThumbName(brand.getThumbName());
        $this$mapping_u24lambda_u240.setLogoUrl(brand.getLogoUrl());
        $this$mapping_u24lambda_u240.setLogoHash(brand.getLogoHash());
        $this$mapping_u24lambda_u240.setMode(brand.getMode());
        $this$mapping_u24lambda_u240.setShowLogo(show.getShowLogo());
        $this$mapping_u24lambda_u240.setSource(brand.getSource());
        return $this$mapping_u24lambda_u240;
    }

    private final BrandShowInfo obtainDefault() {
        if (!BrandSplashParam.INSTANCE.defaultBrandEnable()) {
            return null;
        }
        BrandShowInfo $this$obtainDefault_u24lambda_u240 = new BrandShowInfo();
        $this$obtainDefault_u24lambda_u240.setDefault(true);
        $this$obtainDefault_u24lambda_u240.setDuration(BrandSplashParam.INSTANCE.getDefaultDuration());
        $this$obtainDefault_u24lambda_u240.setReportFlag(3);
        $this$obtainDefault_u24lambda_u240.setQueryItem(mQueryItem);
        INSTANCE.setBrandSplashSearchData();
        BLog.i(TAG, "obtainDefault");
        return $this$obtainDefault_u24lambda_u240;
    }

    private final void setBrandSplashSearchData() {
        MutableLiveData<DefaultWordItem> defaultWordItem;
        QueryItem queryItem = mQueryItem;
        if (queryItem == null) {
            return;
        }
        String query = queryItem.getQuery();
        if (query == null || StringsKt.isBlank(query)) {
            return;
        }
        SplashSearchServiceImpl splashSearchServiceImpl = SplashSearchServiceImplKt.getSplashSearchServiceImpl();
        if (splashSearchServiceImpl != null) {
            splashSearchServiceImpl.setBrandShow(true);
        }
        SplashSearchServiceImpl splashSearchServiceImpl2 = SplashSearchServiceImplKt.getSplashSearchServiceImpl();
        if (splashSearchServiceImpl2 != null && (defaultWordItem = splashSearchServiceImpl2.getDefaultWordItem()) != null) {
            DefaultWordItem $this$setBrandSplashSearchData_u24lambda_u240 = new DefaultWordItem();
            $this$setBrandSplashSearchData_u24lambda_u240.setId(queryItem.getId());
            $this$setBrandSplashSearchData_u24lambda_u240.setQuery(queryItem.getQuery());
            $this$setBrandSplashSearchData_u24lambda_u240.setDefaultWordType(1);
            defaultWordItem.postValue($this$setBrandSplashSearchData_u24lambda_u240);
        }
    }

    public final void saveCustomBrands(List<BrandSplash> list) {
        List brands = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(brands, "brands");
        List $this$filter$iv = brands;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!BrandSplashKt.isThumbExists((BrandSplash) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            BrandSplash it = (BrandSplash) element$iv;
            String thumb = it.getThumb();
            BLog.i(TAG, "save brands start download " + thumb + " " + it.getThumbHash());
            ResManager.download$default(new ResDownloadRequest(it.getThumb(), it.getThumbHash()).md5(it.getThumbHash()).downloadTag("brand_splash").bizType(DownloadBizType.BrandSplash), (ResCallback) null, 2, (Object) null);
        }
        BrandSplashStorage.INSTANCE.saveCustomSplash(brands);
        BrandSplashServiceHelper.INSTANCE.reportBrandSelect(brands);
    }
}