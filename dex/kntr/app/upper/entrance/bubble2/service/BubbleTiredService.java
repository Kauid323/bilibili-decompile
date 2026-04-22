package kntr.app.upper.entrance.bubble2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble2.bean.BubbleResourceShow;
import kntr.app.upper.entrance.bubble2.bean.BubbleResourceShowInfo;
import kntr.app.upper.entrance.bubble2.bean.BubbleShowTime;
import kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig;
import kntr.app.upper.entrance.bubble2.bean.FansShow;
import kntr.app.upper.entrance.bubble2.bean.FansShowInfo;
import kntr.app.upper.entrance.bubble2.bean.LimitTime;
import kntr.app.upper.entrance.bubble2.service.BubbleTiredService;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: BubbleTiredService.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001MB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J \u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u0007J$\u0010'\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u00020\u0005H\u0002JL\u00100\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000209J\u0018\u0010:\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u0007J(\u0010<\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u0002062\u0006\u0010=\u001a\u00020+J\"\u0010>\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\u0007J\u000e\u0010?\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010-\u001a\u00020*H\u0002J\u000e\u0010B\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u0005J\"\u0010E\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\u0007J*\u0010F\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00072\u001a\u0010G\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070I\u0018\u00010HJ*\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010HJ,\u0010K\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\u00072\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010HH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00060\"j\u0002`#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/BubbleTiredService;", "", "<init>", "()V", "DAY_TO_MS", "", "TAG", "", "RESOURCE_ID", "TEXT_ID", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/app/upper/entrance/bubble2/bean/BubbleTiredConfig;", "getConfig", "()Lkntr/app/upper/entrance/bubble2/bean/BubbleTiredConfig;", "config$delegate", "Lkotlin/Lazy;", "zeroTs", "getZeroTs", "()J", "zeroTs$delegate", "cacheMap", "", "Lkntr/app/upper/entrance/bubble2/service/BubbleTiredService$CacheDelegate;", "hitFansShowInfo", "Lkntr/app/upper/entrance/bubble2/bean/FansShowInfo;", "now", "getBubbleShowTimesCache", "mid", "getBubbleRequestTimesCache", "getRecomTextTimesCache", "getCache", "spName", "key", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "clearExpireData", "", "clearData", "filter", "predicate", "Lkotlin/Function1;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleShowTime;", "", "isConfigDataExpired", "showTime", "nullDataExpireTime", "nullDataHourTime", "exposure", "bubbleID", "resourceID", "textID", "fans", "interestScore", "", "hotScore", "isForce", "", "clearStrategy", "resourceId", "checkStrategy", "forceValue", "checkText", "checkBubbleRequest", "findConfigFansShow", "Lkntr/app/upper/entrance/bubble2/bean/FansShow;", "recordBubbleRequestEmpty", "checkBubbleRequestEmptyTimes", "bubbleRequestTimeLimit", "exposureRecom", "exposureRecomList", "textIDs", "", "", "checkRecomTextList", "checkRecomText", "records", "CacheDelegate", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BubbleTiredService {
    private static final long DAY_TO_MS = 86400000;
    private static final String RESOURCE_ID = "resource_id";
    private static final String TAG = "UperCenterPlusBubbleTiredService";
    private static final String TEXT_ID = "text_id";
    private static FansShowInfo hitFansShowInfo;
    public static final BubbleTiredService INSTANCE = new BubbleTiredService();
    private static final Lazy config$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda1
        public final Object invoke() {
            BubbleTiredConfig config_delegate$lambda$0;
            config_delegate$lambda$0 = BubbleTiredService.config_delegate$lambda$0();
            return config_delegate$lambda$0;
        }
    });
    private static final Lazy zeroTs$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda2
        public final Object invoke() {
            long zeroTs_delegate$lambda$0;
            zeroTs_delegate$lambda$0 = BubbleTiredService.zeroTs_delegate$lambda$0();
            return Long.valueOf(zeroTs_delegate$lambda$0);
        }
    });
    private static final Map<String, CacheDelegate> cacheMap = new LinkedHashMap();
    private static final ReentrantLock lock = new ReentrantLock();

    private BubbleTiredService() {
    }

    public final BubbleTiredConfig getConfig() {
        return (BubbleTiredConfig) config$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:2:0x0000, B:4:0x0016, B:10:0x0022, B:12:0x0046, B:11:0x0028), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:2:0x0000, B:4:0x0016, B:10:0x0022, B:12:0x0046, B:11:0x0028), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final BubbleTiredConfig config_delegate$lambda$0() {
        BubbleTiredConfig m2636constructorimpl;
        Throwable it;
        String jsonStr;
        String str;
        boolean z;
        BubbleTiredConfig bubbleTiredConfig;
        try {
            Result.Companion companion = Result.Companion;
            jsonStr = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "uper.center_plus_bubble_config_son3", null, 2, null);
            str = jsonStr;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (str != null && str.length() != 0) {
            z = false;
            if (!z) {
                bubbleTiredConfig = new BubbleTiredConfig();
            } else {
                Json jsonImpl = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit config_delegate$lambda$0$0$0;
                        config_delegate$lambda$0$0$0 = BubbleTiredService.config_delegate$lambda$0$0$0((JsonBuilder) obj);
                        return config_delegate$lambda$0$0$0;
                    }
                }, 1, (Object) null);
                jsonImpl.getSerializersModule();
                bubbleTiredConfig = (BubbleTiredConfig) jsonImpl.decodeFromString(BubbleTiredConfig.Companion.serializer(), jsonStr);
            }
            m2636constructorimpl = Result.m2636constructorimpl(bubbleTiredConfig);
            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
            if (it != null) {
                LogUtils.INSTANCE.e(TAG, "get config error", it);
            }
            if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
                m2636constructorimpl = new BubbleTiredConfig();
            }
            return (BubbleTiredConfig) m2636constructorimpl;
        }
        z = true;
        if (!z) {
        }
        m2636constructorimpl = Result.m2636constructorimpl(bubbleTiredConfig);
        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        return (BubbleTiredConfig) m2636constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit config_delegate$lambda$0$0$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    public final long getZeroTs() {
        return ((Number) zeroTs$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long zeroTs_delegate$lambda$0() {
        Instant now = Clock.System.INSTANCE.now();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault());
        long epochMilliseconds = now.toEpochMilliseconds();
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        return ((((epochMilliseconds / j) - localDateTime.getSecond()) - (localDateTime.getMinute() * 60)) - (localDateTime.getHour() * 3600)) * j;
    }

    private final long now() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    private final CacheDelegate getBubbleShowTimesCache(String mid) {
        return getCache(mid, "UpperCenterPlusBubbleB.pref", "uper_bubble_show_times");
    }

    private final CacheDelegate getBubbleRequestTimesCache(String mid) {
        return getCache(mid, "UpperCenterPlusBubbleRequestB.pref", "uper_bubble_request");
    }

    private final CacheDelegate getRecomTextTimesCache(String mid) {
        return getCache(mid, "UpperCenterPlusUploadPageTextB.pref", "uper_recom_text");
    }

    private final CacheDelegate getCache(String mid, String spName, String key) {
        CacheDelegate cacheDelegate;
        ReentrantLock lock$iv = lock;
        lock$iv.lock();
        try {
            String cacheKey = mid + "_" + key;
            Map $this$getOrPut$iv = cacheMap;
            CacheDelegate cacheDelegate2 = $this$getOrPut$iv.get(cacheKey);
            if (cacheDelegate2 == null) {
                cacheDelegate = new CacheDelegate(spName, cacheKey);
                $this$getOrPut$iv.put(cacheKey, cacheDelegate);
            } else {
                cacheDelegate = cacheDelegate2;
            }
            return cacheDelegate;
        } finally {
            lock$iv.unlock();
        }
    }

    public final void clearExpireData(String mid) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        LogUtils.INSTANCE.i(TAG, "开始清除过期数据：" + getConfig());
        Function1 predicate = new Function1() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean clearExpireData$lambda$0;
                clearExpireData$lambda$0 = BubbleTiredService.clearExpireData$lambda$0((BubbleShowTime) obj);
                return Boolean.valueOf(clearExpireData$lambda$0);
            }
        };
        filter(mid, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearExpireData$lambda$0(BubbleShowTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.isConfigDataExpired(it);
    }

    public final void clearData(String mid) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        LogUtils.INSTANCE.i(TAG, "直接清除缓存数据");
        Function1 predicate = new Function1() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean clearData$lambda$0;
                clearData$lambda$0 = BubbleTiredService.clearData$lambda$0((BubbleShowTime) obj);
                return Boolean.valueOf(clearData$lambda$0);
            }
        };
        filter(mid, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearData$lambda$0(BubbleShowTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    private final void filter(String mid, Function1<? super BubbleShowTime, Boolean> function1) {
        CacheDelegate it = getBubbleShowTimesCache(mid);
        it.filter(function1);
        LogUtils.INSTANCE.e(TAG, "气泡记录, bubbleShowTimes:" + it.get());
        CacheDelegate it2 = getRecomTextTimesCache(mid);
        it2.filter(function1);
        LogUtils.INSTANCE.e(TAG, "文案记录, bubbleShowTimes:" + it2.get());
        CacheDelegate it3 = getBubbleRequestTimesCache(mid);
        it3.filter(function1);
        LogUtils.INSTANCE.e(TAG, "接口请求记录, bubbleShowTimes:" + it3.get());
    }

    private final boolean isConfigDataExpired(BubbleShowTime showTime) {
        return getZeroTs() - showTime.getTimestamp() < ((long) getConfig().getCacheAvailableDay()) * DAY_TO_MS;
    }

    private final long nullDataExpireTime() {
        Instant now = Clock.System.INSTANCE.now();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault());
        long epochMilliseconds = now.toEpochMilliseconds();
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        return ((((epochMilliseconds / j) - localDateTime.getSecond()) - (localDateTime.getMinute() * 60)) - (Math.max(getConfig().getBubbleNullDataPeriod() - 1, 0) * 3600)) * j;
    }

    private final long nullDataHourTime() {
        Instant now = Clock.System.INSTANCE.now();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault());
        long epochMilliseconds = now.toEpochMilliseconds();
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        return (((epochMilliseconds / j) - localDateTime.getSecond()) - (localDateTime.getMinute() * 60)) * j;
    }

    public final void exposure(String mid, String bubbleID, String resourceID, String textID, long fans, float interestScore, float hotScore, int isForce) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        BubbleShowTime showTime = new BubbleShowTime();
        showTime.setTimestamp(INSTANCE.getZeroTs());
        showTime.setResourceId(resourceID);
        showTime.setBubbleId(bubbleID);
        showTime.setBubbleTextId(textID);
        showTime.setFans(fans);
        showTime.setBubbleInterestScore(interestScore);
        showTime.setBubbleHotScore(hotScore);
        showTime.setForce(isForce);
        getBubbleShowTimesCache(mid).add(showTime);
    }

    public final void clearStrategy(String mid, final String resourceId) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        getBubbleShowTimesCache(mid).update(new Function1() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit clearStrategy$lambda$0;
                clearStrategy$lambda$0 = BubbleTiredService.clearStrategy$lambda$0(resourceId, (BubbleShowTime) obj);
                return clearStrategy$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearStrategy$lambda$0(String $resourceId, BubbleShowTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it.getResourceId(), $resourceId)) {
            it.setExpire(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0195 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkStrategy(String mid, String resourceID, float interestScore, boolean forceValue) {
        int count$iv;
        boolean z;
        int count$iv2;
        boolean z2;
        Intrinsics.checkNotNullParameter(mid, "mid");
        FansShowInfo it = hitFansShowInfo;
        if (it == null || forceValue || ((interestScore <= 0.0f || it.getType() != 2) && (interestScore > 0.0f || it.getType() != 1))) {
            BubbleResourceShow bubbleResourceShow = getConfig().getBubbleResourceShow();
            int bubbleResourceShowDay = bubbleResourceShow.getDay();
            int bubbleResourceShowTimes = bubbleResourceShow.getTimes();
            long availableTime = bubbleResourceShowDay * DAY_TO_MS;
            Iterable $this$count$iv = getBubbleShowTimesCache(mid).get();
            if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                count$iv = 0;
            } else {
                count$iv = 0;
                for (Object element$iv : $this$count$iv) {
                    BubbleShowTime it2 = (BubbleShowTime) element$iv;
                    if (Intrinsics.areEqual(it2.getResourceId(), resourceID) && INSTANCE.getZeroTs() - it2.getTimestamp() < availableTime) {
                        String bubbleTextId = it2.getBubbleTextId();
                        if (!(bubbleTextId == null || bubbleTextId.length() == 0)) {
                            z = true;
                            if (z) {
                                count$iv++;
                                if (count$iv < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
            int count = count$iv;
            LogUtils.INSTANCE.e(TAG, "检查气泡供给：强插：" + forceValue + ", 条数：" + count + ", availableTime:" + availableTime + ", resourceID:" + resourceID + ", bubbleResourceShowTimes:" + bubbleResourceShowTimes);
            if (count >= bubbleResourceShowTimes) {
                return false;
            }
            if (forceValue) {
                return true;
            }
            BubbleResourceShowInfo info = bubbleResourceShow.getInfo();
            int bubbleResourceShowDayType = interestScore > 0.0f ? info.getInterestDay() : info.getHotDay();
            int bubbleResourceShowTimesType = interestScore > 0.0f ? info.getInterestTimes() : info.getHotTimes();
            long availableTimeType = bubbleResourceShowDayType * DAY_TO_MS;
            Iterable $this$count$iv2 = getBubbleShowTimesCache(mid).get();
            if (($this$count$iv2 instanceof Collection) && ((Collection) $this$count$iv2).isEmpty()) {
                count$iv2 = 0;
            } else {
                count$iv2 = 0;
                for (Object element$iv2 : $this$count$iv2) {
                    BubbleShowTime it3 = (BubbleShowTime) element$iv2;
                    Iterable $this$count$iv3 = $this$count$iv2;
                    if (Intrinsics.areEqual(it3.getResourceId(), resourceID) && INSTANCE.getZeroTs() - it3.getTimestamp() < availableTimeType) {
                        String bubbleTextId2 = it3.getBubbleTextId();
                        if (!(bubbleTextId2 == null || bubbleTextId2.length() == 0)) {
                            z2 = true;
                            if (z2) {
                                $this$count$iv2 = $this$count$iv3;
                            } else {
                                count$iv2++;
                                if (count$iv2 < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                                $this$count$iv2 = $this$count$iv3;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
            }
            int countType = count$iv2;
            LogUtils.INSTANCE.e(TAG, "检查气泡供给：偏向：" + (interestScore > 0.0f ? "兴趣偏向" : "热门供给") + ", 条数：" + countType + ", availableTimeType:" + availableTimeType + ", resourceID:" + resourceID + ", bubbleResourceShowTimesType:" + bubbleResourceShowTimesType);
            return countType < bubbleResourceShowTimesType;
        }
        return false;
    }

    public final boolean checkText(String mid, String resourceID, String textID) {
        int count$iv;
        BubbleShowTime it;
        Intrinsics.checkNotNullParameter(mid, "mid");
        long availableTime = getConfig().getBubbleTextShowDay() * DAY_TO_MS;
        Iterable $this$count$iv = getBubbleShowTimesCache(mid).get();
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
        } else {
            count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                BubbleShowTime it2 = (BubbleShowTime) element$iv;
                if (Intrinsics.areEqual(it2.getResourceId(), resourceID) && INSTANCE.getZeroTs() - it2.getTimestamp() < availableTime) {
                    if (Intrinsics.areEqual(it2.getBubbleTextId(), textID)) {
                        it = 1;
                        if (it != null && (count$iv = count$iv + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                it = null;
                if (it != null) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int count = count$iv;
        LogUtils.INSTANCE.e(TAG, "检查气泡文案, 条数：" + count + ", availableTime:" + availableTime + ", resourceID:" + resourceID + ", bubbleTextShowTimes:" + getConfig().getBubbleTextShowTimes());
        return count < getConfig().getBubbleTextShowTimes();
    }

    public final String checkBubbleRequest(String mid) {
        boolean z;
        int i;
        String str;
        Map.Entry entry;
        Map map;
        Iterator<BubbleShowTime> it;
        Object obj;
        Set fanShowSet;
        Object obj2;
        boolean z2;
        boolean z3;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(mid, "mid");
        List showRecords = getBubbleShowTimesCache(mid).get();
        hitFansShowInfo = null;
        Map map2 = new LinkedHashMap();
        List $this$forEach$iv = showRecords;
        for (Object element$iv : $this$forEach$iv) {
            BubbleShowTime showTime = (BubbleShowTime) element$iv;
            FansShow fanShowConfig = INSTANCE.findConfigFansShow(showTime);
            if (fanShowConfig != null) {
                int bubbleShowDay = fanShowConfig.getDay();
                int bubbleShowTimes = fanShowConfig.getTimes();
                int count = INSTANCE.getZeroTs() - showTime.getTimestamp() < ((long) bubbleShowDay) * DAY_TO_MS ? 1 : 0;
                TempBubbleShow bubbleShow = (TempBubbleShow) map2.get(fanShowConfig);
                if (bubbleShow == null) {
                    bubbleShow = new TempBubbleShow(bubbleShowTimes, count, showTime.getForce());
                } else {
                    bubbleShow.setDayRangeCount(bubbleShow.getDayRangeCount() + count);
                }
                map2.put(fanShowConfig, bubbleShow);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            FansShow key = (FansShow) entry2.getKey();
            TempBubbleShow value = (TempBubbleShow) entry2.getValue();
            if (value.getDayRangeCount() > 0 && value.getDayRangeCount() >= value.getBubbleShowTimes()) {
                LogUtils logUtils = LogUtils.INSTANCE;
                int fanStart = key.getFanStart();
                int fanEnd = key.getFanEnd();
                logUtils.e(TAG, "频次命中A日次数要求（粉丝量级：" + fanStart + "~" + fanEnd + "，强插：" + (value.getForce() == 1) + "）, " + value.getDayRangeCount() + ", " + value.getBubbleShowTimes());
                return TiredType2.DAY_RANGE.getValue();
            }
        }
        Map mapType = new LinkedHashMap();
        Iterator<BubbleShowTime> it2 = showRecords.iterator();
        while (it2.hasNext()) {
            BubbleShowTime showTime2 = it2.next();
            if (showTime2.forceValue()) {
                LogUtils.INSTANCE.e(TAG, "频次命中A日次数要求 忽略强插供给，resourceId=" + showTime2.getResourceId());
            } else {
                Set fanShowSet2 = map2.keySet();
                Set $this$forEach$iv2 = fanShowSet2;
                for (Object element$iv2 : $this$forEach$iv2) {
                    FansShow fansShow = (FansShow) element$iv2;
                    if (showTime2.getBubbleInterestScore() > 0.0f) {
                        Iterator<T> it3 = fansShow.getInfo().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it3.next();
                            FansShowInfo it4 = (FansShowInfo) obj3;
                            if (it4.getType() == 1) {
                                break;
                            }
                        }
                        FansShowInfo fanShowConfigInterest = (FansShowInfo) obj3;
                        if (fanShowConfigInterest != null) {
                            int bubbleShowDay2 = fanShowConfigInterest.getDay();
                            int bubbleShowTimes2 = fanShowConfigInterest.getTimes();
                            map = map2;
                            it = it2;
                            int count2 = INSTANCE.getZeroTs() - showTime2.getTimestamp() < ((long) bubbleShowDay2) * DAY_TO_MS ? 1 : 0;
                            TempBubbleShow bubbleShowType = (TempBubbleShow) mapType.get(fanShowConfigInterest);
                            if (bubbleShowType == null) {
                                int bubbleShowDay3 = showTime2.getForce();
                                bubbleShowType = new TempBubbleShow(bubbleShowTimes2, count2, bubbleShowDay3);
                            } else {
                                bubbleShowType.setDayRangeCount(bubbleShowType.getDayRangeCount() + count2);
                            }
                            mapType.put(fanShowConfigInterest, bubbleShowType);
                        } else {
                            map = map2;
                            it = it2;
                        }
                        Iterator it5 = fansShow.getInfo().iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it5.next();
                            FansShowInfo it6 = (FansShowInfo) obj4;
                            Iterator it7 = it5;
                            if (it6.getType() == 2) {
                                break;
                            }
                            it5 = it7;
                        }
                        FansShowInfo fanShowConfigHot = (FansShowInfo) obj4;
                        if (fanShowConfigHot == null || mapType.get(fanShowConfigHot) != null) {
                            fanShowSet = fanShowSet2;
                        } else {
                            mapType.put(fanShowConfigHot, new TempBubbleShow(fanShowConfigHot.getTimes(), 0, showTime2.getForce()));
                            fanShowSet = fanShowSet2;
                        }
                    } else {
                        map = map2;
                        it = it2;
                        Iterator<T> it8 = fansShow.getInfo().iterator();
                        while (true) {
                            if (!it8.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it8.next();
                            FansShowInfo it9 = (FansShowInfo) obj;
                            if (it9.getType() == 2) {
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                            if (z3) {
                                break;
                            }
                        }
                        FansShowInfo fanShowConfigHot2 = (FansShowInfo) obj;
                        if (fanShowConfigHot2 != null) {
                            int bubbleShowDay4 = fanShowConfigHot2.getDay();
                            int bubbleShowTimes3 = fanShowConfigHot2.getTimes();
                            fanShowSet = fanShowSet2;
                            int count3 = INSTANCE.getZeroTs() - showTime2.getTimestamp() < ((long) bubbleShowDay4) * DAY_TO_MS ? 1 : 0;
                            TempBubbleShow bubbleShowType2 = (TempBubbleShow) mapType.get(fanShowConfigHot2);
                            if (bubbleShowType2 == null) {
                                bubbleShowType2 = new TempBubbleShow(bubbleShowTimes3, count3, showTime2.getForce());
                            } else {
                                bubbleShowType2.setDayRangeCount(bubbleShowType2.getDayRangeCount() + count3);
                            }
                            mapType.put(fanShowConfigHot2, bubbleShowType2);
                        } else {
                            fanShowSet = fanShowSet2;
                        }
                        Iterator<T> it10 = fansShow.getInfo().iterator();
                        while (true) {
                            if (!it10.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it10.next();
                            FansShowInfo it11 = (FansShowInfo) obj2;
                            if (it11.getType() == 1) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                break;
                            }
                        }
                        FansShowInfo fanShowConfigInterest2 = (FansShowInfo) obj2;
                        if (fanShowConfigInterest2 != null && mapType.get(fanShowConfigInterest2) == null) {
                            mapType.put(fanShowConfigInterest2, new TempBubbleShow(fanShowConfigInterest2.getTimes(), 0, showTime2.getForce()));
                        }
                    }
                    fanShowSet2 = fanShowSet;
                    map2 = map;
                    it2 = it;
                }
            }
        }
        if (mapType.isEmpty()) {
            z = true;
        } else {
            Set entriesType = mapType.entrySet();
            Map.Entry entryType = null;
            Iterator it12 = entriesType.iterator();
            while (true) {
                str = "热门兜底";
                if (!it12.hasNext()) {
                    break;
                }
                entry = (Map.Entry) it12.next();
                FansShowInfo key2 = (FansShowInfo) entry.getKey();
                TempBubbleShow value2 = (TempBubbleShow) entry.getValue();
                if (value2.getDayRangeCount() <= 0) {
                    break;
                }
                Set entriesType2 = entriesType;
                if (value2.getDayRangeCount() < value2.getBubbleShowTimes()) {
                    break;
                }
                if (key2.getType() == 1) {
                    str = "兴趣偏向";
                } else if (key2.getType() != 2) {
                    str = "";
                }
                String type = str;
                LogUtils logUtils2 = LogUtils.INSTANCE;
                int fanStart2 = key2.getFanStart();
                logUtils2.e(TAG, "当前：频次命中A日次数要求（粉丝量级：" + fanStart2 + "~" + key2.getFanEnd() + "，偏好：" + type + "）, 条数：" + value2.getDayRangeCount() + ", " + value2.getBubbleShowTimes());
                entriesType = entriesType2;
                mapType = mapType;
                entryType = entryType;
                it12 = it12;
            }
            entryType = entry;
            hitFansShowInfo = (FansShowInfo) entry.getKey();
            if (entryType == null) {
                return TiredType2.DAY_RANGE.getValue();
            }
            z = true;
            if (((FansShowInfo) entryType.getKey()).getType() == 1) {
                str = "兴趣偏向";
            } else if (((FansShowInfo) entryType.getKey()).getType() != 2) {
                str = "";
            }
            String type2 = str;
            LogUtils logUtils3 = LogUtils.INSTANCE;
            int fanStart3 = ((FansShowInfo) entryType.getKey()).getFanStart();
            logUtils3.e(TAG, "注意：没有达到频次： 频次命中A日次数要求（粉丝量级：" + fanStart3 + "~" + ((FansShowInfo) entryType.getKey()).getFanEnd() + "，偏好：" + type2 + "）,条数： " + ((TempBubbleShow) entryType.getValue()).getDayRangeCount() + ", " + ((TempBubbleShow) entryType.getValue()).getBubbleShowTimes());
        }
        List $this$count$iv = showRecords;
        if (($this$count$iv instanceof Collection) && $this$count$iv.isEmpty()) {
            i = 0;
        } else {
            int count$iv = 0;
            for (Object element$iv3 : $this$count$iv) {
                BubbleShowTime it13 = (BubbleShowTime) element$iv3;
                if ((INSTANCE.getZeroTs() - it13.getTimestamp() < DAY_TO_MS ? z : false) && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            i = count$iv;
        }
        int todayCount = i;
        if (todayCount >= getConfig().getBubbleShowTimesDay()) {
            LogUtils.INSTANCE.e(TAG, "频次命中单日次数, " + todayCount + ", " + getConfig().getBubbleShowTimesDay());
            return TiredType2.ONE_DAY.getValue();
        }
        return TiredType2.SUCCESS.getValue();
    }

    private final FansShow findConfigFansShow(BubbleShowTime showTime) {
        Object obj;
        boolean fanOK;
        List bubbleFansShow = getConfig().getBubbleFansShow();
        Iterator<T> it = bubbleFansShow.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            FansShow fansShow = (FansShow) obj;
            if (showTime.getFans() < fansShow.getFanStart() || showTime.getFans() > fansShow.getFanEnd()) {
                fanOK = false;
                continue;
            } else {
                fanOK = true;
                continue;
            }
            if (fanOK) {
                break;
            }
        }
        FansShow fanShowConfig = (FansShow) obj;
        return fanShowConfig;
    }

    public final void recordBubbleRequestEmpty(String mid) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        BubbleShowTime req = new BubbleShowTime();
        req.setTimestamp(INSTANCE.nullDataHourTime());
        getBubbleRequestTimesCache(mid).add(req);
    }

    public final boolean checkBubbleRequestEmptyTimes(String mid) {
        int count$iv;
        Intrinsics.checkNotNullParameter(mid, "mid");
        Iterable requestRecords = getBubbleRequestTimesCache(mid).get();
        Iterable $this$count$iv = requestRecords;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
        } else {
            count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                BubbleShowTime it = (BubbleShowTime) element$iv;
                if (((it.getTimestamp() <= INSTANCE.nullDataExpireTime() || it.getExistData()) ? null : 1) != null && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int nullCount = count$iv;
        return nullCount >= 1;
    }

    public final boolean bubbleRequestTimeLimit(long zeroTs) {
        long now = now();
        long timeSinceZero = (now - zeroTs) / ((long) MediaAttrUtils.TYPE_PAY_SEASON);
        List<LimitTime> limitTimes = getConfig().getLimitTimes();
        if (limitTimes == null) {
            limitTimes = CollectionsKt.emptyList();
        }
        for (LimitTime limitTime : limitTimes) {
            if (limitTime.getStart() <= timeSinceZero && limitTime.getEnd() > timeSinceZero) {
                int randomInt = Random.Default.nextInt((int) MediaAttrUtils.TYPE_PAY_SEASON);
                LogUtils.INSTANCE.i(TAG, "命中限制时间段:" + limitTime + "， 随机数:" + randomInt);
                return randomInt >= limitTime.getPercent();
            }
        }
        LogUtils.INSTANCE.i(TAG, "未命中限制时间段");
        return false;
    }

    public final void exposureRecom(String mid, String resourceID, String textID) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        BubbleShowTime showTime = new BubbleShowTime();
        showTime.setTimestamp(INSTANCE.getZeroTs());
        showTime.setResourceId(resourceID);
        showTime.setBubbleTextId(textID);
        getRecomTextTimesCache(mid).add(showTime);
    }

    public final void exposureRecomList(String mid, List<? extends Map<String, String>> list) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        List<? extends Map<String, String>> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List newExposureList = new ArrayList();
        for (Map text : list) {
            String resourceID = text.get(RESOURCE_ID);
            String textID = text.get(TEXT_ID);
            String str = resourceID;
            if (!(str == null || str.length() == 0)) {
                String str2 = textID;
                if (!(str2 == null || str2.length() == 0)) {
                    BubbleShowTime showTime = new BubbleShowTime();
                    showTime.setTimestamp(INSTANCE.getZeroTs());
                    showTime.setResourceId(resourceID);
                    showTime.setBubbleTextId(textID);
                    newExposureList.add(showTime);
                }
            }
        }
        getRecomTextTimesCache(mid).addAll(newExposureList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String checkRecomTextList(String mid, final String resourceID, List<String> list) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(mid, "mid");
        String str2 = resourceID;
        String textID = null;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        final List textIDList = list == null ? new ArrayList() : list;
        CacheDelegate recordsCache = getRecomTextTimesCache(mid);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String it2 = (String) obj;
                if (INSTANCE.checkRecomText(resourceID, it2, recordsCache.get())) {
                    break;
                }
            }
            str = (String) obj;
        } else {
            str = null;
        }
        String textID2 = str;
        if (textID2 == null) {
            recordsCache.filter(new Function1() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2) {
                    boolean checkRecomTextList$lambda$1;
                    checkRecomTextList$lambda$1 = BubbleTiredService.checkRecomTextList$lambda$1(resourceID, textIDList, (BubbleShowTime) obj2);
                    return Boolean.valueOf(checkRecomTextList$lambda$1);
                }
            });
            if (list != null) {
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next = it3.next();
                    String it4 = (String) next;
                    if (INSTANCE.checkRecomText(resourceID, it4, recordsCache.get())) {
                        textID = next;
                        break;
                    }
                }
                textID = textID;
            }
            return textID;
        }
        return textID2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkRecomTextList$lambda$1(String $resourceID, List $textIDList, BubbleShowTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!Intrinsics.areEqual(it.getResourceId(), $resourceID)) {
            String bubbleTextId = it.getBubbleTextId();
            if (bubbleTextId == null) {
                bubbleTextId = "";
            }
            if (!$textIDList.contains(bubbleTextId)) {
                return true;
            }
        }
        return false;
    }

    private final boolean checkRecomText(String resourceID, String textID, List<BubbleShowTime> list) {
        int count$iv;
        String str = textID;
        if (str == null || str.length() == 0) {
            return false;
        }
        long availableTime = getConfig().getExposureTextDay() * DAY_TO_MS;
        if (list == null) {
            count$iv = 0;
        } else {
            List<BubbleShowTime> $this$count$iv = list;
            if (($this$count$iv instanceof Collection) && $this$count$iv.isEmpty()) {
                count$iv = 0;
            } else {
                count$iv = 0;
                for (Object element$iv : $this$count$iv) {
                    BubbleShowTime it = (BubbleShowTime) element$iv;
                    if (((Intrinsics.areEqual(it.getResourceId(), resourceID) && INSTANCE.getZeroTs() - it.getTimestamp() < availableTime && Intrinsics.areEqual(it.getBubbleTextId(), textID)) ? 1 : null) != null && (count$iv = count$iv + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        int count = count$iv;
        LogUtils.INSTANCE.e(TAG, "检查坑位文案, 条数：" + count + ", availableTime:" + availableTime + ", resourceID:" + resourceID + ", textID:" + textID + ", exposureTextShowTimes:" + getConfig().getExposureTextShowTimes());
        return count < getConfig().getExposureTextShowTimes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BubbleTiredService.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\fJ\u0014\u0010\u001f\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u001a\u0010 \u001a\u00020\u001b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\"J\u001a\u0010#\u001a\u00020\u001b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020%0\"R\u0012\u0010\u0007\u001a\u00060\bj\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/BubbleTiredService$CacheDelegate;", "", "spName", "", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "<set-?>", "", "Lkntr/app/upper/entrance/bubble2/bean/BubbleShowTime;", "delegate", "getDelegate", "()Ljava/util/List;", "setDelegate", "(Ljava/util/List;)V", "delegate$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "cacheList", "getCacheList", "cacheList$delegate", "Lkotlin/Lazy;", "get", "", "set", "", "list", "add", "showTime", "addAll", "update", "action", "Lkotlin/Function1;", "filter", "predicate", "", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CacheDelegate {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CacheDelegate.class, "delegate", "getDelegate()Ljava/util/List;", 0))};
        private final Lazy cacheList$delegate;
        private final SerializableSharedPreferencesProperty delegate$delegate;
        private final ReentrantLock lock;

        public CacheDelegate(String spName, String key) {
            Intrinsics.checkNotNullParameter(spName, "spName");
            Intrinsics.checkNotNullParameter(key, "key");
            this.lock = new ReentrantLock();
            Function0 initializer$iv = new Function0() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$CacheDelegate$$ExternalSyntheticLambda0
                public final Object invoke() {
                    List delegate_delegate$lambda$0;
                    delegate_delegate$lambda$0 = BubbleTiredService.CacheDelegate.delegate_delegate$lambda$0();
                    return delegate_delegate$lambda$0;
                }
            };
            this.delegate$delegate = new SerializableSharedPreferencesProperty(spName, false, new ArrayListSerializer(BubbleShowTime.Companion.serializer()), key, initializer$iv, null);
            this.cacheList$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.bubble2.service.BubbleTiredService$CacheDelegate$$ExternalSyntheticLambda1
                public final Object invoke() {
                    List delegate;
                    delegate = BubbleTiredService.CacheDelegate.this.getDelegate();
                    return delegate;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List delegate_delegate$lambda$0() {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<BubbleShowTime> getDelegate() {
            return (List) this.delegate$delegate.getValue(this, $$delegatedProperties[0]);
        }

        private final void setDelegate(List<BubbleShowTime> list) {
            this.delegate$delegate.setValue(this, $$delegatedProperties[0], list);
        }

        private final List<BubbleShowTime> getCacheList() {
            return (List) this.cacheList$delegate.getValue();
        }

        public final List<BubbleShowTime> get() {
            ReentrantLock lock$iv = this.lock;
            lock$iv.lock();
            try {
                return CollectionsKt.toList(getCacheList());
            } finally {
                lock$iv.unlock();
            }
        }

        public final void set(List<BubbleShowTime> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ReentrantLock lock$iv = this.lock;
            lock$iv.lock();
            try {
                getCacheList().clear();
                getCacheList().addAll(list);
                setDelegate(getCacheList());
                Unit unit = Unit.INSTANCE;
            } finally {
                lock$iv.unlock();
            }
        }

        public final void add(BubbleShowTime showTime) {
            Intrinsics.checkNotNullParameter(showTime, "showTime");
            ReentrantLock lock$iv = this.lock;
            lock$iv.lock();
            try {
                getCacheList().add(showTime);
                setDelegate(getCacheList());
                Unit unit = Unit.INSTANCE;
            } finally {
                lock$iv.unlock();
            }
        }

        public final void addAll(List<BubbleShowTime> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ReentrantLock lock$iv = this.lock;
            lock$iv.lock();
            try {
                getCacheList().addAll(list);
                setDelegate(getCacheList());
                Unit unit = Unit.INSTANCE;
            } finally {
                lock$iv.unlock();
            }
        }

        public final void update(Function1<? super BubbleShowTime, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "action");
            ReentrantLock lock$iv = this.lock;
            lock$iv.lock();
            try {
                Iterable $this$forEach$iv = getCacheList();
                for (Object element$iv : $this$forEach$iv) {
                    BubbleShowTime it = (BubbleShowTime) element$iv;
                    function1.invoke(it);
                }
                setDelegate(getCacheList());
                Unit unit = Unit.INSTANCE;
            } finally {
                lock$iv.unlock();
            }
        }

        public final void filter(Function1<? super BubbleShowTime, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            ReentrantLock lock$iv = this.lock;
            lock$iv.lock();
            try {
                int size = getCacheList().size() - 1;
                if (size >= 0) {
                    do {
                        int i = size;
                        size--;
                        if (!((Boolean) function1.invoke(getCacheList().get(i))).booleanValue()) {
                            getCacheList().remove(i);
                            continue;
                        }
                    } while (size >= 0);
                    setDelegate(getCacheList());
                    Unit unit = Unit.INSTANCE;
                }
                setDelegate(getCacheList());
                Unit unit2 = Unit.INSTANCE;
            } finally {
                lock$iv.unlock();
            }
        }
    }
}