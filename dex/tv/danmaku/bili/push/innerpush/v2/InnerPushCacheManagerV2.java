package tv.danmaku.bili.push.innerpush.v2;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import android.content.SharedPreferences;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.module.main.innerpush.InnerPush;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.PushUpFilterType;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.model.InnerPushConfig;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: InnerPushCacheManagerV2.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ*\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0012H\u0086@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017JR\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00172$\u0010\u001e\u001a \u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0017\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u001fH\u0086@¢\u0006\u0002\u0010!J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010%J2\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0'2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010)J.\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0082@¢\u0006\u0002\u0010+J,\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002J\u0016\u0010-\u001a\u00020\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070#H\u0002J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070#J\u0016\u00100\u001a\u00020\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070#H\u0003J\u0016\u00102\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070#H\u0002J\b\u00104\u001a\u00020\u0005H\u0002J4\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001d2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0;H\u0002J\b\u0010<\u001a\u00020\tH\u0002J\u0016\u0010=\u001a\u00020\r2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002¨\u0006@"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushCacheManagerV2;", "", "<init>", "()V", "add", "", "innerPush", "Lcom/bilibili/module/main/innerpush/InnerPush;", "remove", "", "job", "", "removeReason", "", "serverFilterReason", "trimBizPush", "type", "predicate", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastJob", "removed", "preShowJobs", "", "findInnerPush", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "pvId", "typeList", "", "onFind", "Lkotlin/Function3;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterProcess", "", "valid", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBizInnerPush", "Lkotlin/Pair;", "bid", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findValidInnerPush", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryCanShowList", "trimToSize", "localCache", "loadPushFromDisk", "savePushToDisk", "pushList", "sort", "memoryCache", "isNowCanShowInnerPush", "isExposeLimit", "item", "config", "Ltv/danmaku/bili/push/innerpush/model/InnerPushConfig;", "todayCommonExposeCount", "businessExposeCountMap", "", "handleLogout", "toSimpleItemString", "Companion", "InnPushSimpleItem", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushCacheManagerV2 {
    public static final int $stable = 0;
    private static final String TAG = "[InnerPush]InnerPushCacheManagerV2";
    public static final Companion Companion = new Companion(null);
    private static final Lazy<SharedPreferences> pref$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$$ExternalSyntheticLambda2
        public final Object invoke() {
            SharedPreferences pref_delegate$lambda$0;
            pref_delegate$lambda$0 = InnerPushCacheManagerV2.pref_delegate$lambda$0();
            return pref_delegate$lambda$0;
        }
    });
    private static final Lazy<InnerPushCacheManagerV2> instance$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$$ExternalSyntheticLambda3
        public final Object invoke() {
            InnerPushCacheManagerV2 instance_delegate$lambda$0;
            instance_delegate$lambda$0 = InnerPushCacheManagerV2.instance_delegate$lambda$0();
            return instance_delegate$lambda$0;
        }
    });

    public InnerPushCacheManagerV2() {
        BiliAccounts.get(BiliContext.application()).subscribe(Topic.SIGN_OUT, new PassportObserver() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$$ExternalSyntheticLambda5
            public final void onChange(Topic topic) {
                InnerPushCacheManagerV2._init_$lambda$0(InnerPushCacheManagerV2.this, topic);
            }
        });
    }

    public static final void _init_$lambda$0(InnerPushCacheManagerV2 this$0, Topic it) {
        if (it == Topic.SIGN_OUT) {
            this$0.handleLogout();
        }
    }

    public final synchronized boolean add(InnerPush innerPush) {
        Object obj;
        InnerPush it;
        Intrinsics.checkNotNullParameter(innerPush, "innerPush");
        BLog.i(TAG, "add, add push ad to cache, pushTaskId = " + innerPush.getTaskId());
        innerPush.setReceiveTime(System.currentTimeMillis());
        List localCache = loadPushFromDisk();
        Iterator<T> it2 = localCache.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            InnerPush it3 = (InnerPush) obj;
            if (it3.getJob() == innerPush.getJob()) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        boolean exist = obj != null;
        if (exist) {
            BLog.i(TAG, "add, push ad already exist in cache");
            return false;
        }
        localCache.add(innerPush);
        sort(localCache);
        trimToSize(localCache);
        savePushToDisk(localCache);
        BLog.i(TAG, "add, local list = " + toSimpleItemString(localCache));
        return true;
    }

    public static /* synthetic */ void remove$default(InnerPushCacheManagerV2 innerPushCacheManagerV2, long j, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        innerPushCacheManagerV2.remove(j, str, str2);
    }

    public final synchronized void remove(long job, String removeReason, String serverFilterReason) {
        Object obj;
        boolean z;
        BLog.i(TAG, "add, remove push from cache, pushJobId = " + job + ", removeReason = " + (removeReason == null ? "show success" : removeReason));
        List localCache = loadPushFromDisk();
        Iterator<T> it = localCache.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            InnerPush it2 = (InnerPush) obj;
            if (it2.getJob() == job) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        InnerPush push = (InnerPush) obj;
        if (push == null) {
            return;
        }
        localCache.remove(push);
        savePushToDisk(localCache);
        BLog.i(TAG, "remove, local list = " + toSimpleItemString(localCache));
        if (removeReason == null) {
            return;
        }
        InnerPushExtensionKt.reportDiscardPush(push, removeReason, serverFilterReason);
    }

    public final Object trimBizPush(String type, Function1<? super InnerPush, Boolean> function1, Continuation<? super Unit> continuation) {
        List emptyList;
        List localCache = loadPushFromDisk();
        if (localCache.isEmpty()) {
            return Unit.INSTANCE;
        }
        List preCache = new ArrayList();
        preCache.addAll(localCache);
        long lastShowJob = InnerPushLocalStorage.INSTANCE.getBizInnerPushShowLastJob(type);
        boolean lastJobRemoved = false;
        List $this$filter$iv = localCache;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            InnerPush it = (InnerPush) element$iv$iv;
            if (Intrinsics.areEqual(String.valueOf(it.getType()), type)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            final InnerPush push = (InnerPush) element$iv;
            boolean remove = ((Boolean) function1.invoke(push)).booleanValue();
            if (remove) {
                remove$default(this, push.getJob(), null, null, 6, null);
                if (push.getJob() == lastShowJob) {
                    lastJobRemoved = true;
                } else {
                    final Function1 function12 = new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            boolean trimBizPush$lambda$1$0;
                            trimBizPush$lambda$1$0 = InnerPushCacheManagerV2.trimBizPush$lambda$1$0(push, (InnerPush) obj);
                            return Boolean.valueOf(trimBizPush$lambda$1$0);
                        }
                    };
                    Boxing.boxBoolean(Collection.-EL.removeIf(preCache, new Predicate() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$$ExternalSyntheticLambda1
                        @Override // java.util.function.Predicate
                        public /* synthetic */ Predicate and(Predicate predicate) {
                            return Predicate.-CC.$default$and(this, predicate);
                        }

                        @Override // java.util.function.Predicate
                        public /* synthetic */ java.util.function.Predicate negate() {
                            return Predicate.-CC.$default$negate(this);
                        }

                        @Override // java.util.function.Predicate
                        public /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
                            return Predicate.-CC.$default$or(this, predicate);
                        }

                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            boolean trimBizPush$lambda$1$1;
                            trimBizPush$lambda$1$1 = InnerPushCacheManagerV2.trimBizPush$lambda$1$1(function12, obj);
                            return trimBizPush$lambda$1$1;
                        }
                    }));
                }
            }
        }
        if (!lastJobRemoved) {
            emptyList = CollectionsKt.emptyList();
        } else {
            int index$iv = 0;
            Iterator it2 = preCache.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object item$iv = it2.next();
                    InnerPush it3 = (InnerPush) item$iv;
                    if (it3.getJob() == lastShowJob) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            int lastShowIndex = index$iv;
            if (lastShowIndex == -1) {
                emptyList = CollectionsKt.emptyList();
            } else {
                Iterable $this$map$iv = CollectionsKt.take(localCache, lastShowIndex);
                java.util.Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    InnerPush it4 = (InnerPush) item$iv$iv;
                    destination$iv$iv2.add(Boxing.boxLong(it4.getJob()));
                }
                emptyList = (List) destination$iv$iv2;
            }
        }
        List preShowJobs = emptyList;
        updateLastJob(type, lastJobRemoved, preShowJobs);
        return Unit.INSTANCE;
    }

    public static final boolean trimBizPush$lambda$1$0(InnerPush $push, InnerPush it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getJob() == $push.getJob();
    }

    public static final boolean trimBizPush$lambda$1$1(Function1 $tmp0, Object p0) {
        return ((Boolean) $tmp0.invoke(p0)).booleanValue();
    }

    public final void updateLastJob(String type, boolean removed, List<Long> list) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(list, "preShowJobs");
        List latest = loadPushFromDisk();
        if (latest.isEmpty()) {
            InnerPushLocalStorage.INSTANCE.setBizInnerPushShowLastJob(type, 0L);
        } else if (removed && !list.isEmpty()) {
            InnerPushLocalStorage.INSTANCE.setBizInnerPushShowLastJob(type, ((Number) CollectionsKt.last(list)).longValue());
        }
    }

    public final Object findInnerPush(Activity activity, String pvId, List<Integer> list, Function3<? super InnerPushType, ? super List<InnerPush>, ? super String, Unit> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new InnerPushCacheManagerV2$findInnerPush$2(this, function3, list, activity, pvId, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object filterProcess(List<InnerPush> list, Continuation<? super List<InnerPush>> continuation) {
        if (list == null) {
            return new ArrayList();
        }
        String currentProcess = AppInnerPushManagerV2.Companion.getInstance().currentProcessName();
        Map processMap = InnerPushLocalStorage.INSTANCE.getBizPushRegisterProcessMap();
        List<InnerPush> $this$filter$iv = list;
        java.util.Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            InnerPush it = (InnerPush) element$iv$iv;
            String process = processMap.get(String.valueOf(it.getType()));
            if (process == null || Intrinsics.areEqual(process, currentProcess)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List result = CollectionsKt.toMutableList((List) destination$iv$iv);
        return result;
    }

    public final Object findBizInnerPush(String pvId, int type, int bid, Continuation<? super Pair<Boolean, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new InnerPushCacheManagerV2$findBizInnerPush$2(bid, pvId, type, null), continuation);
    }

    public final Object findValidInnerPush(Activity activity, String pvId, List<InnerPush> list, Continuation<? super InnerPush> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new InnerPushCacheManagerV2$findValidInnerPush$2(this, activity, pvId, list, null), continuation);
    }

    public final List<InnerPush> queryCanShowList(Activity activity, String pvId, List<InnerPush> list) {
        List localCache = CollectionsKt.toMutableList(list);
        BLog.i(TAG, "queryCanShowList, local list = " + toSimpleItemString(localCache));
        if (localCache.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List $this$filter$iv = localCache;
        java.util.Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            InnerPush it = (InnerPush) element$iv$iv;
            if (InnerPushExtensionKt.isHighLevel(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List highLevelList = (List) destination$iv$iv;
        boolean isNowCanShowLowLevelList = isNowCanShowInnerPush();
        if (highLevelList.isEmpty() && !isNowCanShowLowLevelList) {
            BLog.i(TAG, "queryCanShowList, can't show，prevent by show interval limit");
            return CollectionsKt.emptyList();
        }
        InnerPushConfig config = InnerPushLocalStorage.INSTANCE.loadInnerPushConfig();
        int todayCommonExposeCount = InnerPushLocalStorage.INSTANCE.getInnerPushCommonExposeCount();
        Map businessExposeCountMap = InnerPushLocalStorage.INSTANCE.getInnerPushBusinessExposeMap();
        int originSize = localCache.size();
        Iterator iterator = localCache.iterator();
        List canShowList = new ArrayList();
        while (iterator.hasNext()) {
            InnerPush item = iterator.next();
            if (InnerPushExtensionKt.isPushExpire(item)) {
                InnerPushExtensionKt.reportDiscardPush(item, PushUpFilterType.Expire);
                iterator.remove();
            } else if (InnerPushExtensionKt.isInBlackList(item, activity)) {
                if (item.getReserve() == 0) {
                    iterator.remove();
                    InnerPushExtensionKt.reportDiscardPush(item, PushUpFilterType.RESOURCE_DISCARD);
                }
            } else if (InnerPushExtensionKt.isInPageViewBlackList(item, activity, pvId)) {
                if (item.getReserve() == 0) {
                    iterator.remove();
                    InnerPushExtensionKt.reportDiscardPush(item, PushUpFilterType.BlacklistDiscard);
                }
            } else if (InnerPushExtensionKt.isHighLevel(item)) {
                canShowList.add(item);
            } else if (!isExposeLimit(item, config, todayCommonExposeCount, businessExposeCountMap)) {
                canShowList.add(item);
            }
        }
        if (originSize != localCache.size()) {
            savePushToDisk(localCache);
        }
        return canShowList;
    }

    private final void trimToSize(List<InnerPush> list) {
        Iterator iterator;
        ArrayList arrayList;
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            InnerPush push = iterator2.next();
            if (InnerPushExtensionKt.getExpireMs(push) < System.currentTimeMillis()) {
                iterator2.remove();
                InnerPushExtensionKt.reportDiscardPush(push, PushUpFilterType.Expire);
            }
        }
        InnerPushConfig config = InnerPushLocalStorage.INSTANCE.loadInnerPushConfig();
        int discardStrategy = InnerPushLocalStorage.INSTANCE.loadInnerPushConfig().getCacheStrategy();
        List<InnerPush> $this$filter$iv = list;
        java.util.Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            InnerPush it = (InnerPush) element$iv$iv;
            if (!InnerPushExtensionKt.isHighLevel(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable lowLevelList = CollectionsKt.toMutableList((List) destination$iv$iv);
        List bizTypeList = AppInnerPushManagerV2.Companion.getInstance().currentRegisterBizType$core_apinkDebug();
        Iterable $this$filter$iv2 = lowLevelList;
        java.util.Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            InnerPush it2 = (InnerPush) element$iv$iv2;
            if (bizTypeList.contains(String.valueOf(it2.getType()))) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        Iterable $this$groupBy$iv = (List) destination$iv$iv2;
        Map destination$iv$iv3 = new LinkedHashMap();
        for (Object element$iv$iv3 : $this$groupBy$iv) {
            InnerPush it3 = (InnerPush) element$iv$iv3;
            String valueOf = String.valueOf(it3.getType());
            Object value$iv$iv$iv = destination$iv$iv3.get(valueOf);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                iterator = iterator2;
                destination$iv$iv3.put(valueOf, arrayList);
            } else {
                iterator = iterator2;
                arrayList = value$iv$iv$iv;
            }
            List list$iv$iv = (List) arrayList;
            list$iv$iv.add(element$iv$iv3);
            iterator2 = iterator;
        }
        Iterable $this$filterNot$iv = lowLevelList;
        java.util.Collection destination$iv$iv4 = new ArrayList();
        for (Object element$iv$iv4 : $this$filterNot$iv) {
            InnerPush it4 = (InnerPush) element$iv$iv4;
            if (!bizTypeList.contains(String.valueOf(it4.getType()))) {
                destination$iv$iv4.add(element$iv$iv4);
            }
        }
        List innerItems = CollectionsKt.toMutableList((List) destination$iv$iv4);
        if (innerItems.size() > config.getMaxCacheCount()) {
            int toDeleteSize = innerItems.size() - config.getMaxCacheCount();
            for (int i = 0; i < toDeleteSize; i++) {
                int index = discardStrategy == 1 ? innerItems.size() - 1 : 0;
                InnerPush push2 = (InnerPush) innerItems.remove(index);
                list.remove(push2);
                InnerPushExtensionKt.reportDiscardPush(push2, PushUpFilterType.OverLoad);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$loadPushFromDisk$list$localList$1] */
    public final List<InnerPush> loadPushFromDisk() {
        List localList;
        SharedPreferences pref = Companion.getPref();
        String string = pref != null ? pref.getString(InnerPushCacheManagerV2Kt.SP_INNER_PUSH_CACHE_KEY_V2, "") : null;
        String it = string;
        String str = it;
        boolean z = false;
        if (!(str == null || StringsKt.isBlank(str)) && !Intrinsics.areEqual(it, "[]")) {
            z = true;
        }
        String str2 = z ? string : null;
        if (str2 != null) {
            String str3 = str2;
            try {
                localList = (List) new Gson().fromJson(str3, new TypeToken<List<? extends InnerPush>>() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$loadPushFromDisk$list$localList$1
                }.getType());
                if (localList == null) {
                    localList = CollectionsKt.emptyList();
                }
            } catch (Exception e) {
                BLog.i(TAG, "loadPushFromDisk, exception");
                localList = CollectionsKt.emptyList();
            }
            return CollectionsKt.toMutableList(localList);
        }
        return new ArrayList();
    }

    public final void savePushToDisk(List<InnerPush> list) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        SharedPreferences pref = Companion.getPref();
        if (pref != null && (edit = pref.edit()) != null && (putString = edit.putString(InnerPushCacheManagerV2Kt.SP_INNER_PUSH_CACHE_KEY_V2, new Gson().toJson(list))) != null) {
            putString.commit();
        }
    }

    private final void sort(List<InnerPush> list) {
        Collections.sort(list, new Comparator() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$$ExternalSyntheticLambda4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int sort$lambda$0;
                sort$lambda$0 = InnerPushCacheManagerV2.sort$lambda$0((InnerPush) obj, (InnerPush) obj2);
                return sort$lambda$0;
            }
        });
    }

    public static final int sort$lambda$0(InnerPush item1, InnerPush item2) {
        if (item1.getLevel() != item2.getLevel()) {
            return Intrinsics.compare(item2.getLevel(), item1.getLevel());
        }
        if (item1.getReceiveTime() != item2.getReceiveTime()) {
            return Intrinsics.compare(item1.getReceiveTime(), item2.getReceiveTime());
        }
        return 0;
    }

    private final boolean isNowCanShowInnerPush() {
        long now = System.currentTimeMillis();
        long lastShowTime = InnerPushLocalStorage.INSTANCE.getInnerPushLastShowTime();
        if (now < lastShowTime) {
            BLog.e(TAG, "isNowCanShowInnerPush, time error, user has adjust local time");
        }
        return now > (InnerPushLocalStorage.INSTANCE.loadInnerPushConfig().getDisplayInterval() * ((long) 1000)) + lastShowTime;
    }

    private final boolean isExposeLimit(InnerPush item, InnerPushConfig config, int todayCommonExposeCount, Map<String, Integer> map) {
        String key = String.valueOf(item.getBid());
        if (config.getMaxExposure() == -1 || todayCommonExposeCount < config.getMaxExposure()) {
            Integer num = map.get(key);
            int todayBusinessExposeCount = num != null ? num.intValue() : 0;
            Integer num2 = config.getMaxBusinessExposure().get(key);
            int serverLimitBusinessExposeCount = num2 != null ? num2.intValue() : -1;
            return config.getMaxBusinessExposure().containsKey(key) && serverLimitBusinessExposeCount != -1 && todayBusinessExposeCount >= serverLimitBusinessExposeCount;
        }
        return true;
    }

    private final synchronized void handleLogout() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        Iterable memoryCache = loadPushFromDisk();
        Iterable $this$forEach$iv = memoryCache;
        for (Object element$iv : $this$forEach$iv) {
            InnerPush push = (InnerPush) element$iv;
            InnerPushExtensionKt.reportDiscardPush(push, PushUpFilterType.Logout);
        }
        SharedPreferences pref = Companion.getPref();
        if (pref != null && (edit = pref.edit()) != null && (remove = edit.remove(InnerPushCacheManagerV2Kt.SP_INNER_PUSH_CACHE_KEY_V2)) != null) {
            remove.apply();
        }
    }

    /* compiled from: InnerPushCacheManagerV2.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushCacheManagerV2$Companion;", "", "<init>", "()V", "TAG", "", "pref", "Landroid/content/SharedPreferences;", "getPref", "()Landroid/content/SharedPreferences;", "pref$delegate", "Lkotlin/Lazy;", "instance", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushCacheManagerV2;", "getInstance", "()Ltv/danmaku/bili/push/innerpush/v2/InnerPushCacheManagerV2;", "instance$delegate", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedPreferences getPref() {
            return (SharedPreferences) InnerPushCacheManagerV2.pref$delegate.getValue();
        }

        public final InnerPushCacheManagerV2 getInstance() {
            return (InnerPushCacheManagerV2) InnerPushCacheManagerV2.instance$delegate.getValue();
        }
    }

    public static final SharedPreferences pref_delegate$lambda$0() {
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference();
    }

    public static final InnerPushCacheManagerV2 instance_delegate$lambda$0() {
        return new InnerPushCacheManagerV2();
    }

    public final String toSimpleItemString(List<InnerPush> list) {
        Gson gson = new Gson();
        List<InnerPush> $this$map$iv = list;
        java.util.Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            InnerPush it = (InnerPush) item$iv$iv;
            destination$iv$iv.add(new InnPushSimpleItem(it.getJob(), it.getBid(), it.getLevel(), it.getReceiveTime(), InnerPushExtensionKt.getExpireMs(it), it.getDisplayType()));
            $this$map$iv = $this$map$iv;
        }
        String json = gson.toJson((List) destination$iv$iv);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* compiled from: InnerPushCacheManagerV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006)"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushCacheManagerV2$InnPushSimpleItem;", "", "job", "", "bid", "", "level", "receiveTime", "expireTime", "displayType", "<init>", "(JIIJJI)V", "getJob", "()J", "setJob", "(J)V", "getBid", "()I", "setBid", "(I)V", "getLevel", "setLevel", "getReceiveTime", "setReceiveTime", "getExpireTime", "setExpireTime", "getDisplayType", "setDisplayType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InnPushSimpleItem {
        private int bid;
        private int displayType;
        private long expireTime;
        private long job;
        private int level;
        private long receiveTime;

        public InnPushSimpleItem() {
            this(0L, 0, 0, 0L, 0L, 0, 63, null);
        }

        public final long component1() {
            return this.job;
        }

        public final int component2() {
            return this.bid;
        }

        public final int component3() {
            return this.level;
        }

        public final long component4() {
            return this.receiveTime;
        }

        public final long component5() {
            return this.expireTime;
        }

        public final int component6() {
            return this.displayType;
        }

        public final InnPushSimpleItem copy(long j, int i, int i2, long j2, long j3, int i3) {
            return new InnPushSimpleItem(j, i, i2, j2, j3, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InnPushSimpleItem) {
                InnPushSimpleItem innPushSimpleItem = (InnPushSimpleItem) obj;
                return this.job == innPushSimpleItem.job && this.bid == innPushSimpleItem.bid && this.level == innPushSimpleItem.level && this.receiveTime == innPushSimpleItem.receiveTime && this.expireTime == innPushSimpleItem.expireTime && this.displayType == innPushSimpleItem.displayType;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.job) * 31) + this.bid) * 31) + this.level) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.receiveTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.expireTime)) * 31) + this.displayType;
        }

        public String toString() {
            long j = this.job;
            int i = this.bid;
            int i2 = this.level;
            long j2 = this.receiveTime;
            long j3 = this.expireTime;
            return "InnPushSimpleItem(job=" + j + ", bid=" + i + ", level=" + i2 + ", receiveTime=" + j2 + ", expireTime=" + j3 + ", displayType=" + this.displayType + ")";
        }

        public InnPushSimpleItem(long job, int bid, int level, long receiveTime, long expireTime, int displayType) {
            this.job = job;
            this.bid = bid;
            this.level = level;
            this.receiveTime = receiveTime;
            this.expireTime = expireTime;
            this.displayType = displayType;
        }

        public /* synthetic */ InnPushSimpleItem(long j, int i, int i2, long j2, long j3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? -1 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0L : j2, (i4 & 16) == 0 ? j3 : 0L, (i4 & 32) == 0 ? i3 : 0);
        }

        public final long getJob() {
            return this.job;
        }

        public final void setJob(long j) {
            this.job = j;
        }

        public final int getBid() {
            return this.bid;
        }

        public final void setBid(int i) {
            this.bid = i;
        }

        public final int getLevel() {
            return this.level;
        }

        public final void setLevel(int i) {
            this.level = i;
        }

        public final long getReceiveTime() {
            return this.receiveTime;
        }

        public final void setReceiveTime(long j) {
            this.receiveTime = j;
        }

        public final long getExpireTime() {
            return this.expireTime;
        }

        public final void setExpireTime(long j) {
            this.expireTime = j;
        }

        public final int getDisplayType() {
            return this.displayType;
        }

        public final void setDisplayType(int i) {
            this.displayType = i;
        }
    }
}