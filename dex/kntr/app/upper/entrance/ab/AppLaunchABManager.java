package kntr.app.upper.entrance.ab;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.ab.AppLaunchABManager;
import kntr.app.upper.entrance.utils.FeatureConfig;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: AppLaunchABManager.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001RB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002040;J\u001d\u0010<\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005H\u0000¢\u0006\u0002\b=J2\u00103\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\fH\u0080@¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ&\u0010B\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005H\u0002J\u001a\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005H\u0002J0\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u00107\u001a\u00020\u0005H\u0002J\u0010\u0010H\u001a\u00020)2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0010\u0010I\u001a\u00020)2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0010\u0010J\u001a\u00020)2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0018\u0010K\u001a\u00020)2\u0006\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u000206H\u0002J\u0018\u0010L\u001a\u00020)2\u0006\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u000206H\u0002J*\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010012\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0002J\b\u0010N\u001a\u00020\fH\u0002J\u0011\u0010O\u001a\u00020\u0005*\u000206H\u0000¢\u0006\u0002\bPJ\f\u0010\u001b\u001a\u00020\f*\u000206H\u0002J\b\u0010Q\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b$\u0010%R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060+j\u0002`,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00060+j\u0002`,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u00100\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lkntr/app/upper/entrance/ab/AppLaunchABManager;", "", "<init>", "()V", "TAG", "", "PREF_UPPER_LIMIT_AB", "KEY_CACHE_TIME", "KEY_CACHE_ZERO_TIME", "KEY_QUERY_TIMES_TODAY", "KEY_REQUEST_MIN_INTERVAL", "DEFAULT_REQUEST_MIN_INTERVAL", "", "jsonImpl", "Lkotlinx/serialization/json/Json;", "dynamicAbKey", "", "getDynamicAbKey", "()Ljava/util/Map;", "dynamicAbKey$delegate", "Lkotlin/Lazy;", "emptyAbKey", "", "getEmptyAbKey$entrance_debug", "()Ljava/util/List;", "emptyAbKey$delegate", "cacheValidTime", "getCacheValidTime", "cacheValidTime$delegate", "maxQueryTimesEveryday", "", "getMaxQueryTimesEveryday", "()I", "maxQueryTimesEveryday$delegate", "enableNewCache", "", "getEnableNewCache", "()Z", "enableNewCache$delegate", "cacheMap", "", "Lkntr/app/upper/entrance/ab/AppLaunchABManager$CacheDelegate;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "cacheLock", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "currentJob", "Lkotlinx/coroutines/Deferred;", "resultMap", "abAsyncWithTimeout", "", "ab", "Lkntr/app/upper/entrance/ab/AppLaunchAB;", "mid", "abExtra", "timeMillis", "callback", "Lkotlin/Function1;", "getCache", "getCache$entrance_debug", "abAsyncWithTimeout$entrance_debug", "(Lkntr/app/upper/entrance/ab/AppLaunchAB;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAbCache", "fetchAbCache$entrance_debug", "getAbInternal", "(Lkntr/app/upper/entrance/ab/AppLaunchAB;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryFromCache", "queryFromCacheNew", "toOriginKeyAndSaveToCache", "map", "getTimeCache", "getTimeZeroCache", "getQueryTimesCache", "getAbCache", "getAbCacheNew", "getAllAbFromNet", "getCurrentZeroTime", "getDynamicKey", "getDynamicKey$entrance_debug", "getMinRequestInterval", "CacheDelegate", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AppLaunchABManager {
    private static final long DEFAULT_REQUEST_MIN_INTERVAL = 86400;
    private static final String KEY_CACHE_TIME = "key_cache_time";
    private static final String KEY_CACHE_ZERO_TIME = "key_cache_zero_time";
    private static final String KEY_QUERY_TIMES_TODAY = "key_query_net_times_today";
    private static final String KEY_REQUEST_MIN_INTERVAL = "key_request_min_interval";
    private static final String PREF_UPPER_LIMIT_AB = "pref_upper_app_launch_ab";
    private static final String TAG = "AppLaunchABManager";
    private static Deferred<? extends Map<String, String>> currentJob;
    private static Map<String, String> resultMap;
    public static final AppLaunchABManager INSTANCE = new AppLaunchABManager();
    private static final Json jsonImpl = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit jsonImpl$lambda$0;
            jsonImpl$lambda$0 = AppLaunchABManager.jsonImpl$lambda$0((JsonBuilder) obj);
            return jsonImpl$lambda$0;
        }
    }, 1, (Object) null);
    private static final Lazy dynamicAbKey$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$$ExternalSyntheticLambda1
        public final Object invoke() {
            Map dynamicAbKey_delegate$lambda$0;
            dynamicAbKey_delegate$lambda$0 = AppLaunchABManager.dynamicAbKey_delegate$lambda$0();
            return dynamicAbKey_delegate$lambda$0;
        }
    });
    private static final Lazy emptyAbKey$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$$ExternalSyntheticLambda2
        public final Object invoke() {
            List emptyAbKey_delegate$lambda$0;
            emptyAbKey_delegate$lambda$0 = AppLaunchABManager.emptyAbKey_delegate$lambda$0();
            return emptyAbKey_delegate$lambda$0;
        }
    });
    private static final Lazy cacheValidTime$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$$ExternalSyntheticLambda3
        public final Object invoke() {
            Map cacheValidTime_delegate$lambda$0;
            cacheValidTime_delegate$lambda$0 = AppLaunchABManager.cacheValidTime_delegate$lambda$0();
            return cacheValidTime_delegate$lambda$0;
        }
    });
    private static final Lazy maxQueryTimesEveryday$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$$ExternalSyntheticLambda4
        public final Object invoke() {
            int maxQueryTimesEveryday_delegate$lambda$0;
            maxQueryTimesEveryday_delegate$lambda$0 = AppLaunchABManager.maxQueryTimesEveryday_delegate$lambda$0();
            return Integer.valueOf(maxQueryTimesEveryday_delegate$lambda$0);
        }
    });
    private static final Lazy enableNewCache$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$$ExternalSyntheticLambda5
        public final Object invoke() {
            boolean enableNewCache_delegate$lambda$0;
            enableNewCache_delegate$lambda$0 = AppLaunchABManager.enableNewCache_delegate$lambda$0();
            return Boolean.valueOf(enableNewCache_delegate$lambda$0);
        }
    });
    private static final Map<String, CacheDelegate> cacheMap = new LinkedHashMap();
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock cacheLock = new ReentrantLock();
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    private AppLaunchABManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jsonImpl$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    private final Map<String, String> getDynamicAbKey() {
        return (Map) dynamicAbKey$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:2:0x0000, B:4:0x0015, B:10:0x0021, B:12:0x003f, B:11:0x0026), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:2:0x0000, B:4:0x0015, B:10:0x0021, B:12:0x003f, B:11:0x0026), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map dynamicAbKey_delegate$lambda$0() {
        Map m2636constructorimpl;
        Throwable it;
        String jsonStr;
        String str;
        boolean z;
        Map map;
        try {
            Result.Companion companion = Result.Companion;
            jsonStr = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "uper.ab_key_mapper", null, 2, null);
            str = jsonStr;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (str != null && str.length() != 0) {
            z = false;
            if (!z) {
                map = MapsKt.emptyMap();
            } else {
                Json this_$iv = jsonImpl;
                this_$iv.getSerializersModule();
                map = (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), jsonStr);
            }
            m2636constructorimpl = Result.m2636constructorimpl(map);
            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
            if (it != null) {
                LogUtils.INSTANCE.e(TAG, "get abConfig error", it);
            }
            if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
                m2636constructorimpl = MapsKt.emptyMap();
            }
            return (Map) m2636constructorimpl;
        }
        z = true;
        if (!z) {
        }
        m2636constructorimpl = Result.m2636constructorimpl(map);
        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        return (Map) m2636constructorimpl;
    }

    public final List<String> getEmptyAbKey$entrance_debug() {
        return (List) emptyAbKey$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:2:0x0000, B:4:0x0015, B:10:0x0021, B:12:0x003d, B:11:0x0026), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:2:0x0000, B:4:0x0015, B:10:0x0021, B:12:0x003d, B:11:0x0026), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List emptyAbKey_delegate$lambda$0() {
        List m2636constructorimpl;
        Throwable it;
        String jsonStr;
        String str;
        boolean z;
        List list;
        try {
            Result.Companion companion = Result.Companion;
            jsonStr = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "uper.ab_key_empty_launch", null, 2, null);
            str = jsonStr;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (str != null && str.length() != 0) {
            z = false;
            if (!z) {
                list = CollectionsKt.emptyList();
            } else {
                Json this_$iv = jsonImpl;
                this_$iv.getSerializersModule();
                list = (List) this_$iv.decodeFromString(new ArrayListSerializer(StringSerializer.INSTANCE), jsonStr);
            }
            m2636constructorimpl = Result.m2636constructorimpl(list);
            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
            if (it != null) {
                LogUtils.INSTANCE.e(TAG, "get empty ab key error", it);
            }
            if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
                m2636constructorimpl = CollectionsKt.emptyList();
            }
            return (List) m2636constructorimpl;
        }
        z = true;
        if (!z) {
        }
        m2636constructorimpl = Result.m2636constructorimpl(list);
        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        return (List) m2636constructorimpl;
    }

    private final Map<String, Long> getCacheValidTime() {
        return (Map) cacheValidTime$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:2:0x0000, B:4:0x0015, B:10:0x0021, B:12:0x003f, B:11:0x0026), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:2:0x0000, B:4:0x0015, B:10:0x0021, B:12:0x003f, B:11:0x0026), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map cacheValidTime_delegate$lambda$0() {
        Map m2636constructorimpl;
        Throwable it;
        String jsonStr;
        String str;
        boolean z;
        Map map;
        try {
            Result.Companion companion = Result.Companion;
            jsonStr = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "uper.ab_cache_valid_time", null, 2, null);
            str = jsonStr;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (str != null && str.length() != 0) {
            z = false;
            if (!z) {
                map = MapsKt.emptyMap();
            } else {
                Json this_$iv = jsonImpl;
                this_$iv.getSerializersModule();
                map = (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, LongSerializer.INSTANCE), jsonStr);
            }
            m2636constructorimpl = Result.m2636constructorimpl(map);
            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
            if (it != null) {
                LogUtils.INSTANCE.e(TAG, "get cacheValidTime error", it);
            }
            if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
                m2636constructorimpl = MapsKt.emptyMap();
            }
            return (Map) m2636constructorimpl;
        }
        z = true;
        if (!z) {
        }
        m2636constructorimpl = Result.m2636constructorimpl(map);
        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        return (Map) m2636constructorimpl;
    }

    private final int getMaxQueryTimesEveryday() {
        return ((Number) maxQueryTimesEveryday$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxQueryTimesEveryday_delegate$lambda$0() {
        int m2636constructorimpl;
        Integer intOrNull;
        try {
            Result.Companion companion = Result.Companion;
            String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "uper.app_launch_ab_query_max_times_everyday", null, 2, null);
            m2636constructorimpl = Result.m2636constructorimpl(Integer.valueOf((config$default == null || (intOrNull = StringsKt.toIntOrNull(config$default)) == null) ? 1 : intOrNull.intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
            LogUtils.INSTANCE.e(TAG, "get cacheValidTime error", it);
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            m2636constructorimpl = 1;
        }
        return ((Number) m2636constructorimpl).intValue();
    }

    private final boolean getEnableNewCache() {
        return ((Boolean) enableNewCache$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableNewCache_delegate$lambda$0() {
        boolean m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(Boolean.valueOf(IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "uper.enable_app_launch_ab_new_cache", false, 2, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            m2636constructorimpl = false;
        }
        return ((Boolean) m2636constructorimpl).booleanValue();
    }

    public static /* synthetic */ void abAsyncWithTimeout$default(AppLaunchABManager appLaunchABManager, AppLaunchAB appLaunchAB, String str, String str2, long j, Function1 function1, int i, Object obj) {
        long j2;
        if ((i & 8) == 0) {
            j2 = j;
        } else {
            j2 = -1;
        }
        appLaunchABManager.abAsyncWithTimeout(appLaunchAB, str, str2, j2, function1);
    }

    public final void abAsyncWithTimeout(AppLaunchAB ab, String mid, String abExtra, long timeMillis, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(ab, "ab");
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(abExtra, "abExtra");
        Intrinsics.checkNotNullParameter(function1, "callback");
        BuildersKt.launch$default(ioScope, (CoroutineContext) null, (CoroutineStart) null, new AppLaunchABManager$abAsyncWithTimeout$1(ab, mid, abExtra, timeMillis, function1, null), 3, (Object) null);
    }

    public final String getCache$entrance_debug(AppLaunchAB ab, String mid) {
        Object m2636constructorimpl;
        Intrinsics.checkNotNullParameter(ab, "ab");
        Intrinsics.checkNotNullParameter(mid, "mid");
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(INSTANCE.getAbCache(mid, ab).getValue());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
            LogUtils.INSTANCE.e(TAG, "getCache error", it);
        }
        if (Result.m2642isFailureimpl(m2636constructorimpl)) {
            m2636constructorimpl = null;
        }
        String str = (String) m2636constructorimpl;
        return str == null ? ab.getDefault() : str;
    }

    public static /* synthetic */ Object abAsyncWithTimeout$entrance_debug$default(AppLaunchABManager appLaunchABManager, AppLaunchAB appLaunchAB, String str, String str2, long j, Continuation continuation, int i, Object obj) {
        long j2;
        if ((i & 8) == 0) {
            j2 = j;
        } else {
            j2 = -1;
        }
        return appLaunchABManager.abAsyncWithTimeout$entrance_debug(appLaunchAB, str, str2, j2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object abAsyncWithTimeout$entrance_debug(AppLaunchAB ab, String mid, String abExtra, long timeMillis, Continuation<? super String> continuation) {
        AppLaunchABManager$abAsyncWithTimeout$2 appLaunchABManager$abAsyncWithTimeout$2;
        Object abInternal;
        Object withTimeout;
        try {
            if (continuation instanceof AppLaunchABManager$abAsyncWithTimeout$2) {
                appLaunchABManager$abAsyncWithTimeout$2 = (AppLaunchABManager$abAsyncWithTimeout$2) continuation;
                if ((appLaunchABManager$abAsyncWithTimeout$2.label & Integer.MIN_VALUE) != 0) {
                    appLaunchABManager$abAsyncWithTimeout$2.label -= Integer.MIN_VALUE;
                    Object $result = appLaunchABManager$abAsyncWithTimeout$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (appLaunchABManager$abAsyncWithTimeout$2.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            LogUtils.INSTANCE.i(TAG, "abAsyncWithTimeout, " + ab + ", " + timeMillis);
                            Result.Companion companion = Result.Companion;
                            if (timeMillis > 0) {
                                appLaunchABManager$abAsyncWithTimeout$2.L$0 = ab;
                                appLaunchABManager$abAsyncWithTimeout$2.L$1 = SpillingKt.nullOutSpilledVariable(mid);
                                appLaunchABManager$abAsyncWithTimeout$2.L$2 = SpillingKt.nullOutSpilledVariable(abExtra);
                                appLaunchABManager$abAsyncWithTimeout$2.J$0 = timeMillis;
                                appLaunchABManager$abAsyncWithTimeout$2.I$0 = 0;
                                appLaunchABManager$abAsyncWithTimeout$2.label = 1;
                                withTimeout = TimeoutKt.withTimeout(timeMillis, new AppLaunchABManager$abAsyncWithTimeout$3$1(ab, mid, abExtra, null), appLaunchABManager$abAsyncWithTimeout$2);
                                return withTimeout == coroutine_suspended ? coroutine_suspended : (String) withTimeout;
                            }
                            AppLaunchABManager appLaunchABManager = INSTANCE;
                            appLaunchABManager$abAsyncWithTimeout$2.L$0 = ab;
                            appLaunchABManager$abAsyncWithTimeout$2.L$1 = SpillingKt.nullOutSpilledVariable(mid);
                            appLaunchABManager$abAsyncWithTimeout$2.L$2 = SpillingKt.nullOutSpilledVariable(abExtra);
                            appLaunchABManager$abAsyncWithTimeout$2.J$0 = timeMillis;
                            appLaunchABManager$abAsyncWithTimeout$2.I$0 = 0;
                            appLaunchABManager$abAsyncWithTimeout$2.label = 2;
                            abInternal = appLaunchABManager.getAbInternal(ab, mid, abExtra, appLaunchABManager$abAsyncWithTimeout$2);
                            return abInternal == coroutine_suspended ? coroutine_suspended : (String) abInternal;
                        case 1:
                            int i = appLaunchABManager$abAsyncWithTimeout$2.I$0;
                            long timeMillis2 = appLaunchABManager$abAsyncWithTimeout$2.J$0;
                            String str = (String) appLaunchABManager$abAsyncWithTimeout$2.L$2;
                            String str2 = (String) appLaunchABManager$abAsyncWithTimeout$2.L$1;
                            AppLaunchAB appLaunchAB = (AppLaunchAB) appLaunchABManager$abAsyncWithTimeout$2.L$0;
                            ResultKt.throwOnFailure($result);
                            withTimeout = $result;
                        case 2:
                            int i2 = appLaunchABManager$abAsyncWithTimeout$2.I$0;
                            long timeMillis3 = appLaunchABManager$abAsyncWithTimeout$2.J$0;
                            String str3 = (String) appLaunchABManager$abAsyncWithTimeout$2.L$2;
                            String str4 = (String) appLaunchABManager$abAsyncWithTimeout$2.L$1;
                            AppLaunchAB appLaunchAB2 = (AppLaunchAB) appLaunchABManager$abAsyncWithTimeout$2.L$0;
                            ResultKt.throwOnFailure($result);
                            abInternal = $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (appLaunchABManager$abAsyncWithTimeout$2.label) {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Object m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
            Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
            if (it != null) {
                LogUtils.INSTANCE.e(TAG, "abAsyncWithTimeout error" + it, it);
            }
            return Result.m2639exceptionOrNullimpl(m2636constructorimpl) == null ? m2636constructorimpl : ab.getDefault();
        }
        appLaunchABManager$abAsyncWithTimeout$2 = new AppLaunchABManager$abAsyncWithTimeout$2(this, continuation);
        Object $result2 = appLaunchABManager$abAsyncWithTimeout$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final String fetchAbCache$entrance_debug(AppLaunchAB ab, String mid) {
        Intrinsics.checkNotNullParameter(ab, "ab");
        Intrinsics.checkNotNullParameter(mid, "mid");
        return queryFromCache(ab, mid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r5 != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAbInternal(AppLaunchAB ab, String mid, String abExtra, Continuation<? super String> continuation) {
        AppLaunchABManager$getAbInternal$1 appLaunchABManager$getAbInternal$1;
        Map<String, String> map;
        Object await;
        String it;
        String str;
        if (continuation instanceof AppLaunchABManager$getAbInternal$1) {
            appLaunchABManager$getAbInternal$1 = (AppLaunchABManager$getAbInternal$1) continuation;
            if ((appLaunchABManager$getAbInternal$1.label & Integer.MIN_VALUE) != 0) {
                appLaunchABManager$getAbInternal$1.label -= Integer.MIN_VALUE;
                Object $result = appLaunchABManager$getAbInternal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (appLaunchABManager$getAbInternal$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Map<String, String> map2 = resultMap;
                        map = null;
                        boolean z = false;
                        if (map2 != null && (it = map2.get(ab.getKey())) != null) {
                            if (!(it.length() > 0)) {
                                it = null;
                            }
                            if (it != null) {
                                String it2 = it;
                                LogUtils.INSTANCE.i(TAG, "当前已有内存缓存，直接使用" + it2);
                                return it2;
                            }
                        }
                        ReentrantLock lock$iv = lock;
                        lock$iv.lock();
                        try {
                            if (currentJob != null) {
                                Deferred<? extends Map<String, String>> deferred = currentJob;
                                if (deferred != null && deferred.isCompleted()) {
                                    z = true;
                                    break;
                                }
                            }
                            String cache = INSTANCE.queryFromCache(ab, mid);
                            if (cache == null) {
                                currentJob = INSTANCE.getAllAbFromNet(mid, abExtra);
                                Unit unit = Unit.INSTANCE;
                                lock$iv.unlock();
                                Deferred<? extends Map<String, String>> deferred2 = currentJob;
                                if (deferred2 != null) {
                                    appLaunchABManager$getAbInternal$1.L$0 = ab;
                                    appLaunchABManager$getAbInternal$1.L$1 = SpillingKt.nullOutSpilledVariable(mid);
                                    appLaunchABManager$getAbInternal$1.L$2 = SpillingKt.nullOutSpilledVariable(abExtra);
                                    appLaunchABManager$getAbInternal$1.label = 1;
                                    await = deferred2.await(appLaunchABManager$getAbInternal$1);
                                    if (await == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    map = (Map) await;
                                    break;
                                }
                            } else {
                                return cache;
                            }
                        } finally {
                            lock$iv.unlock();
                        }
                        break;
                    case 1:
                        String str2 = (String) appLaunchABManager$getAbInternal$1.L$2;
                        String str3 = (String) appLaunchABManager$getAbInternal$1.L$1;
                        ab = (AppLaunchAB) appLaunchABManager$getAbInternal$1.L$0;
                        ResultKt.throwOnFailure($result);
                        await = $result;
                        map = (Map) await;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                resultMap = map;
                Map<String, String> map3 = resultMap;
                return (map3 != null || (str = map3.get(ab.getKey())) == null) ? ab.getDefault() : str;
            }
        }
        appLaunchABManager$getAbInternal$1 = new AppLaunchABManager$getAbInternal$1(this, continuation);
        Object $result2 = appLaunchABManager$getAbInternal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (appLaunchABManager$getAbInternal$1.label) {
        }
        resultMap = map;
        Map<String, String> map32 = resultMap;
        if (map32 != null) {
        }
    }

    private final String queryFromCache(AppLaunchAB ab, String mid) {
        Long longOrNull;
        if (getEnableNewCache()) {
            return queryFromCacheNew(ab, mid);
        }
        String value = getTimeCache(mid).getValue();
        long cacheTime = (value == null || (longOrNull = StringsKt.toLongOrNull(value)) == null) ? 0L : longOrNull.longValue();
        String cache = getAbCache(mid, ab).getValue();
        long currentTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
        long minRequestInterval = getMinRequestInterval();
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        long minRequestInterval2 = minRequestInterval * j;
        LogUtils.INSTANCE.i(TAG, "queryFromCache, " + ab + ", " + cache + ", " + cacheTime + ", " + currentTime + ", " + minRequestInterval2);
        if (currentTime - cacheTime <= minRequestInterval2) {
            LogUtils.INSTANCE.i(TAG, "两次请求时间小于最小时间间隔，直接使用缓存 " + cache);
            if (cache == null) {
                return ab.getDefault();
            }
        } else if (currentTime - cacheTime <= getCacheValidTime(ab) * j) {
            LogUtils.INSTANCE.i(TAG, "缓存在有效期，直接使用缓存 " + cache);
        } else {
            LogUtils.INSTANCE.i(TAG, "缓存在不在有效期");
            return null;
        }
        return cache;
    }

    private final String queryFromCacheNew(AppLaunchAB ab, String mid) {
        Integer intOrNull;
        Long longOrNull;
        String value = getTimeZeroCache(mid).getValue();
        long cacheZeroTime = (value == null || (longOrNull = StringsKt.toLongOrNull(value)) == null) ? 0L : longOrNull.longValue();
        String value2 = getQueryTimesCache(mid).getValue();
        int queryTimes = (value2 == null || (intOrNull = StringsKt.toIntOrNull(value2)) == null) ? 0 : intOrNull.intValue();
        Instant now = Clock.System.INSTANCE.now();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault());
        long epochMilliseconds = now.toEpochMilliseconds();
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        long currentZeroTime = ((((epochMilliseconds / j) - localDateTime.getSecond()) - (localDateTime.getMinute() * 60)) - (localDateTime.getHour() * 3600)) * j;
        LogUtils.INSTANCE.i(TAG, "queryFromCacheNew, " + ab + ", 当前缓存的0点时间戳=" + cacheZeroTime + ", 当前有缓存的这一天调用AB接口次数=" + queryTimes + ", 当前0点时间戳=" + currentZeroTime + ", 每天最大调用AB接口次数=" + getMaxQueryTimesEveryday());
        if (cacheZeroTime != currentZeroTime) {
            LogUtils.INSTANCE.i(TAG, "当天未调用AB接口，需要请求接口");
            return null;
        } else if (queryTimes < getMaxQueryTimesEveryday()) {
            LogUtils.INSTANCE.i(TAG, "当天请求次数[" + queryTimes + "]未到达上限，需要请求接口");
            return null;
        } else {
            String cache = getAbCache(mid, ab).getValue();
            LogUtils.INSTANCE.i(TAG, "当天请求次数[" + queryTimes + "]到达上限，直接使用缓存 " + cache);
            return (!FeatureConfig.INSTANCE.getEnableAbNewCacheKey() && cache == null) ? ab.getDefault() : cache;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> toOriginKeyAndSaveToCache(Map<String, String> map, String mid) {
        Integer intOrNull;
        Instant now = Clock.System.INSTANCE.now();
        long timeMillis = now.toEpochMilliseconds();
        LogUtils.INSTANCE.i(TAG, "getABData from net success, " + timeMillis + ", " + map);
        Map originKeyMap = new LinkedHashMap();
        Iterable $this$forEach$iv = AppLaunchABConfig.INSTANCE.getAPP_LAUNCH_AB$entrance_debug();
        for (Object element$iv : $this$forEach$iv) {
            AppLaunchAB it = (AppLaunchAB) element$iv;
            String dynamicKey = INSTANCE.getDynamicKey$entrance_debug(it);
            String value = map.get(dynamicKey);
            if (value != null) {
                originKeyMap.put(it.getKey(), value);
                INSTANCE.getAbCache(mid, it).setValue(value);
            }
        }
        getTimeCache(mid).setValue(String.valueOf(timeMillis));
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault());
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        long zeroTime = ((((timeMillis / j) - localDateTime.getSecond()) - (localDateTime.getMinute() * 60)) - (localDateTime.getHour() * 3600)) * j;
        CacheDelegate timeZeroCache = getTimeZeroCache(mid);
        CacheDelegate queryTimesCache = getQueryTimesCache(mid);
        int queryTimes = 0;
        if (Intrinsics.areEqual(timeZeroCache.getValue(), String.valueOf(zeroTime))) {
            String value2 = queryTimesCache.getValue();
            queryTimes = (value2 == null || (intOrNull = StringsKt.toIntOrNull(value2)) == null) ? 0 : intOrNull.intValue();
        } else {
            timeZeroCache.setValue(String.valueOf(zeroTime));
        }
        queryTimesCache.setValue(String.valueOf(queryTimes + 1));
        return originKeyMap;
    }

    private final CacheDelegate getTimeCache(String mid) {
        CacheDelegate cacheDelegate;
        ReentrantLock lock$iv = cacheLock;
        lock$iv.lock();
        try {
            String key = mid + "_key_cache_time";
            Map $this$getOrPut$iv = cacheMap;
            CacheDelegate cacheDelegate2 = $this$getOrPut$iv.get(key);
            if (cacheDelegate2 == null) {
                cacheDelegate = new CacheDelegate(PREF_UPPER_LIMIT_AB, key);
                $this$getOrPut$iv.put(key, cacheDelegate);
            } else {
                cacheDelegate = cacheDelegate2;
            }
            return cacheDelegate;
        } finally {
            lock$iv.unlock();
        }
    }

    private final CacheDelegate getTimeZeroCache(String mid) {
        CacheDelegate cacheDelegate;
        ReentrantLock lock$iv = cacheLock;
        lock$iv.lock();
        try {
            String key = mid + "_key_cache_zero_time";
            Map $this$getOrPut$iv = cacheMap;
            CacheDelegate cacheDelegate2 = $this$getOrPut$iv.get(key);
            if (cacheDelegate2 == null) {
                cacheDelegate = new CacheDelegate(PREF_UPPER_LIMIT_AB, key);
                $this$getOrPut$iv.put(key, cacheDelegate);
            } else {
                cacheDelegate = cacheDelegate2;
            }
            return cacheDelegate;
        } finally {
            lock$iv.unlock();
        }
    }

    private final CacheDelegate getQueryTimesCache(String mid) {
        CacheDelegate cacheDelegate;
        ReentrantLock lock$iv = cacheLock;
        lock$iv.lock();
        try {
            String key = mid + "_key_query_net_times_today";
            Map $this$getOrPut$iv = cacheMap;
            CacheDelegate cacheDelegate2 = $this$getOrPut$iv.get(key);
            if (cacheDelegate2 == null) {
                cacheDelegate = new CacheDelegate(PREF_UPPER_LIMIT_AB, key);
                $this$getOrPut$iv.put(key, cacheDelegate);
            } else {
                cacheDelegate = cacheDelegate2;
            }
            return cacheDelegate;
        } finally {
            lock$iv.unlock();
        }
    }

    private final CacheDelegate getAbCache(String mid, AppLaunchAB ab) {
        CacheDelegate cacheDelegate;
        if (FeatureConfig.INSTANCE.getEnableAbNewCacheKey()) {
            return getAbCacheNew(mid, ab);
        }
        ReentrantLock lock$iv = cacheLock;
        lock$iv.lock();
        try {
            String key = mid + "_" + ab.getKey();
            Map $this$getOrPut$iv = cacheMap;
            CacheDelegate cacheDelegate2 = $this$getOrPut$iv.get(key);
            if (cacheDelegate2 == null) {
                cacheDelegate = new CacheDelegate(PREF_UPPER_LIMIT_AB, key);
                $this$getOrPut$iv.put(key, cacheDelegate);
            } else {
                cacheDelegate = cacheDelegate2;
            }
            return cacheDelegate;
        } finally {
            lock$iv.unlock();
        }
    }

    private final CacheDelegate getAbCacheNew(String mid, AppLaunchAB ab) {
        CacheDelegate cacheDelegate;
        ReentrantLock lock$iv = cacheLock;
        lock$iv.lock();
        try {
            String key = mid + "_" + INSTANCE.getDynamicKey$entrance_debug(ab) + "_" + INSTANCE.getCurrentZeroTime();
            Map $this$getOrPut$iv = cacheMap;
            CacheDelegate cacheDelegate2 = $this$getOrPut$iv.get(key);
            if (cacheDelegate2 == null) {
                cacheDelegate = new CacheDelegate(PREF_UPPER_LIMIT_AB, key);
                $this$getOrPut$iv.put(key, cacheDelegate);
            } else {
                cacheDelegate = cacheDelegate2;
            }
            return cacheDelegate;
        } finally {
            lock$iv.unlock();
        }
    }

    private final Deferred<Map<String, String>> getAllAbFromNet(String mid, String abExtra) {
        long startTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
        List abList = AppLaunchABConfig.INSTANCE.getAPP_LAUNCH_AB$entrance_debug();
        LogUtils.INSTANCE.i(TAG, "getABData from net");
        return BuildersKt.async$default(ioScope, (CoroutineContext) null, (CoroutineStart) null, new AppLaunchABManager$getAllAbFromNet$1(mid, startTime, abList, abExtra, null), 3, (Object) null);
    }

    private final long getCurrentZeroTime() {
        Instant now = Clock.System.INSTANCE.now();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault());
        long epochMilliseconds = now.toEpochMilliseconds();
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        return ((((epochMilliseconds / j) - localDateTime.getSecond()) - (localDateTime.getMinute() * 60)) - (localDateTime.getHour() * 3600)) * j;
    }

    public final String getDynamicKey$entrance_debug(AppLaunchAB $this$getDynamicKey) {
        Intrinsics.checkNotNullParameter($this$getDynamicKey, "<this>");
        String str = getDynamicAbKey().get($this$getDynamicKey.getKey());
        return str == null ? $this$getDynamicKey.getDefaultDynamicKey() : str;
    }

    private final long getCacheValidTime(AppLaunchAB $this$getCacheValidTime) {
        Long l = getCacheValidTime().get($this$getCacheValidTime.getKey());
        return l != null ? l.longValue() : $this$getCacheValidTime.getDefaultCacheValidTime();
    }

    private final long getMinRequestInterval() {
        Long l = getCacheValidTime().get(KEY_REQUEST_MIN_INTERVAL);
        return l != null ? l.longValue() : DEFAULT_REQUEST_MIN_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppLaunchABManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003R/\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkntr/app/upper/entrance/ab/AppLaunchABManager$CacheDelegate;", "", "spName", "", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "delegate", "getDelegate", "()Ljava/lang/String;", "setDelegate", "(Ljava/lang/String;)V", "delegate$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "getValue", "setValue", "", "value", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CacheDelegate {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CacheDelegate.class, "delegate", "getDelegate()Ljava/lang/String;", 0))};
        private final SerializableSharedPreferencesProperty delegate$delegate;

        public CacheDelegate(String spName, String key) {
            Intrinsics.checkNotNullParameter(spName, "spName");
            Intrinsics.checkNotNullParameter(key, "key");
            Function0 initializer$iv = new Function0() { // from class: kntr.app.upper.entrance.ab.AppLaunchABManager$CacheDelegate$$ExternalSyntheticLambda0
                public final Object invoke() {
                    String delegate_delegate$lambda$0;
                    delegate_delegate$lambda$0 = AppLaunchABManager.CacheDelegate.delegate_delegate$lambda$0();
                    return delegate_delegate$lambda$0;
                }
            };
            this.delegate$delegate = new SerializableSharedPreferencesProperty(spName, false, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), key, initializer$iv, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String delegate_delegate$lambda$0() {
            return null;
        }

        private final String getDelegate() {
            return (String) this.delegate$delegate.getValue(this, $$delegatedProperties[0]);
        }

        private final void setDelegate(String str) {
            this.delegate$delegate.setValue(this, $$delegatedProperties[0], str);
        }

        public final String getValue() {
            return getDelegate();
        }

        public final void setValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            setDelegate(value);
        }
    }
}