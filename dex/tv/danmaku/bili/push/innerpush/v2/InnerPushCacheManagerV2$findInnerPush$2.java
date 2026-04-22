package tv.danmaku.bili.push.innerpush.v2;

import android.app.Activity;
import com.bilibili.module.main.innerpush.InnerPush;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerPushCacheManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$findInnerPush$2", f = "InnerPushCacheManagerV2.kt", i = {0, 1, 2, 2, 2}, l = {BR.descTipText, BR.descVo, 177}, m = "invokeSuspend", n = {"resultMap", "resultMap", "resultMap", "bizList", "key"}, s = {"L$0", "L$0", "L$0", "L$6", "I$0"}, v = 1)
public final class InnerPushCacheManagerV2$findInnerPush$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function3<InnerPushType, List<InnerPush>, String, Unit> $onFind;
    final /* synthetic */ String $pvId;
    final /* synthetic */ List<Integer> $typeList;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ InnerPushCacheManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InnerPushCacheManagerV2$findInnerPush$2(InnerPushCacheManagerV2 innerPushCacheManagerV2, Function3<? super InnerPushType, ? super List<InnerPush>, ? super String, Unit> function3, List<Integer> list, Activity activity, String str, Continuation<? super InnerPushCacheManagerV2$findInnerPush$2> continuation) {
        super(2, continuation);
        this.this$0 = innerPushCacheManagerV2;
        this.$onFind = function3;
        this.$typeList = list;
        this.$activity = activity;
        this.$pvId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerPushCacheManagerV2$findInnerPush$2(this.this$0, this.$onFind, this.$typeList, this.$activity, this.$pvId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03cd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x025d -> B:101:0x03dc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x02b3 -> B:101:0x03dc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x02fa -> B:100:0x03da). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0324 -> B:101:0x03dc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x034e -> B:92:0x0351). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object $result;
        String simpleItemString;
        Map resultMap;
        InnerPushCacheManagerV2 innerPushCacheManagerV2;
        Activity activity;
        String str;
        int $i$f$forEach;
        Iterator it;
        InnerPushCacheManagerV2$findInnerPush$2 innerPushCacheManagerV2$findInnerPush$2;
        Function3<InnerPushType, List<InnerPush>, String, Unit> function3;
        Object $result2;
        int $i$f$forEach2;
        Iterator it2;
        String str2;
        Activity activity2;
        InnerPushCacheManagerV2 innerPushCacheManagerV22;
        Object $result3;
        Map resultMap2;
        Object $result4;
        Function3<InnerPushType, List<InnerPush>, String, Unit> function32;
        InnerPushCacheManagerV2 innerPushCacheManagerV23;
        Activity activity3;
        String str3;
        InnerPushCacheManagerV2$findInnerPush$2 innerPushCacheManagerV2$findInnerPush$22;
        InnerPush filterItem;
        Object obj2;
        int key;
        Object $result5;
        Object $result6;
        boolean z;
        List bizList;
        Object filterProcess;
        Pair result;
        InnerPushCacheManagerV2$findInnerPush$2 innerPushCacheManagerV2$findInnerPush$23;
        Object obj3;
        InnerPushCacheManagerV2$findInnerPush$2 innerPushCacheManagerV2$findInnerPush$24 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = -1;
        switch (innerPushCacheManagerV2$findInnerPush$24.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                $result = obj;
                List localCache = innerPushCacheManagerV2$findInnerPush$24.this$0.loadPushFromDisk();
                simpleItemString = innerPushCacheManagerV2$findInnerPush$24.this$0.toSimpleItemString(localCache);
                BLog.i("[InnerPush]InnerPushCacheManagerV2", "queryCanShowList, local list = " + simpleItemString);
                if (localCache.isEmpty()) {
                    innerPushCacheManagerV2$findInnerPush$24.$onFind.invoke(InnerPushType.Empty.INSTANCE, CollectionsKt.emptyList(), "");
                    return Unit.INSTANCE;
                }
                int originSize = localCache.size();
                List $this$filterTo$iv$iv = localCache;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    InnerPush it3 = (InnerPush) element$iv$iv;
                    if (!InnerPushExtensionKt.isPushExpire(it3)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List validList = (List) destination$iv$iv;
                BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush local push, validList.size = " + validList.size());
                if (originSize != validList.size()) {
                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "remove expired push from cache");
                    innerPushCacheManagerV2$findInnerPush$24.this$0.savePushToDisk(CollectionsKt.toMutableList(validList));
                }
                List $this$groupByTo$iv$iv = validList;
                Map destination$iv$iv2 = new LinkedHashMap();
                for (Object element$iv$iv2 : $this$groupByTo$iv$iv) {
                    InnerPush it4 = (InnerPush) element$iv$iv2;
                    Integer boxInt = Boxing.boxInt(it4.getType());
                    Object answer$iv$iv$iv = destination$iv$iv2.get(boxInt);
                    if (answer$iv$iv$iv == null) {
                        answer$iv$iv$iv = new ArrayList();
                        destination$iv$iv2.put(boxInt, answer$iv$iv$iv);
                    }
                    List list$iv$iv = (List) answer$iv$iv$iv;
                    list$iv$iv.add(element$iv$iv2);
                }
                Iterable $this$associateWith$iv = innerPushCacheManagerV2$findInnerPush$24.$typeList;
                Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                Map destination$iv$iv3 = result$iv;
                for (Object element$iv$iv3 : $this$associateWith$iv) {
                    int type = ((Number) element$iv$iv3).intValue();
                    List list = (List) destination$iv$iv2.get(Boxing.boxInt(type));
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    destination$iv$iv3.put(element$iv$iv3, list);
                }
                resultMap = MapsKt.toMutableMap(destination$iv$iv3);
                List $this$filterNotTo$iv$iv = validList;
                List<Integer> list2 = innerPushCacheManagerV2$findInnerPush$24.$typeList;
                Collection destination$iv$iv4 = new ArrayList();
                for (Object element$iv$iv4 : $this$filterNotTo$iv$iv) {
                    InnerPush it5 = (InnerPush) element$iv$iv4;
                    if (!list2.contains(Boxing.boxInt(it5.getType()))) {
                        destination$iv$iv4.add(element$iv$iv4);
                    }
                }
                ArrayList arrayList = (List) destination$iv$iv4;
                if (!arrayList.isEmpty()) {
                    resultMap.put(Boxing.boxInt(-1), arrayList);
                }
                Iterable $this$forEach$iv = resultMap.keySet();
                InnerPushCacheManagerV2 innerPushCacheManagerV24 = innerPushCacheManagerV2$findInnerPush$24.this$0;
                Activity activity4 = innerPushCacheManagerV2$findInnerPush$24.$activity;
                String str4 = innerPushCacheManagerV2$findInnerPush$24.$pvId;
                Function3<InnerPushType, List<InnerPush>, String, Unit> function33 = innerPushCacheManagerV2$findInnerPush$24.$onFind;
                Iterator it6 = $this$forEach$iv.iterator();
                innerPushCacheManagerV2 = innerPushCacheManagerV24;
                activity = activity4;
                str = str4;
                $i$f$forEach = 0;
                it = it6;
                innerPushCacheManagerV2$findInnerPush$2 = innerPushCacheManagerV2$findInnerPush$24;
                function3 = function33;
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    key = ((Number) element$iv).intValue();
                    if (key == i) {
                        List innerData = (List) resultMap.get(Boxing.boxInt(key));
                        List list3 = innerData;
                        if (list3 == null || list3.isEmpty()) {
                            BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush default push, innerData is empty");
                        } else {
                            innerPushCacheManagerV2$findInnerPush$2.L$0 = resultMap;
                            innerPushCacheManagerV2$findInnerPush$2.L$1 = innerPushCacheManagerV2;
                            innerPushCacheManagerV2$findInnerPush$2.L$2 = activity;
                            innerPushCacheManagerV2$findInnerPush$2.L$3 = str;
                            innerPushCacheManagerV2$findInnerPush$2.L$4 = function3;
                            innerPushCacheManagerV2$findInnerPush$2.L$5 = it;
                            innerPushCacheManagerV2$findInnerPush$2.L$6 = null;
                            innerPushCacheManagerV2$findInnerPush$2.label = 1;
                            filterProcess = innerPushCacheManagerV2.filterProcess(innerData, innerPushCacheManagerV2$findInnerPush$2);
                            if (filterProcess == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str2 = str;
                            resultMap2 = resultMap;
                            activity2 = activity;
                            $result3 = $result;
                            $result2 = filterProcess;
                            Iterator it7 = it;
                            innerPushCacheManagerV22 = innerPushCacheManagerV2;
                            $i$f$forEach2 = $i$f$forEach;
                            it2 = it7;
                            List filteredData = (List) $result2;
                            innerPushCacheManagerV2$findInnerPush$2.L$0 = resultMap2;
                            innerPushCacheManagerV2$findInnerPush$2.L$1 = innerPushCacheManagerV22;
                            innerPushCacheManagerV2$findInnerPush$2.L$2 = activity2;
                            innerPushCacheManagerV2$findInnerPush$2.L$3 = str2;
                            innerPushCacheManagerV2$findInnerPush$2.L$4 = function3;
                            innerPushCacheManagerV2$findInnerPush$2.L$5 = it2;
                            innerPushCacheManagerV2$findInnerPush$2.label = 2;
                            $result4 = innerPushCacheManagerV22.findValidInnerPush(activity2, str2, filteredData, innerPushCacheManagerV2$findInnerPush$2);
                            if ($result4 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String str5 = str2;
                            innerPushCacheManagerV2$findInnerPush$22 = innerPushCacheManagerV2$findInnerPush$2;
                            function32 = function3;
                            innerPushCacheManagerV23 = innerPushCacheManagerV22;
                            activity3 = activity2;
                            str3 = str5;
                            filterItem = (InnerPush) $result4;
                            if (filterItem != null) {
                                if (InnerPushExtensionKt.isHighLevel(filterItem)) {
                                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush default push, filterItem is high level, onFind invoke");
                                    obj2 = coroutine_suspended;
                                    function32.invoke(InnerPushType.HighLevel.INSTANCE, CollectionsKt.arrayListOf(new InnerPush[]{filterItem}), "");
                                } else {
                                    obj2 = coroutine_suspended;
                                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush default push, filterItem is normal level, onFind invoke");
                                    function32.invoke(InnerPushType.Normal.INSTANCE, CollectionsKt.arrayListOf(new InnerPush[]{filterItem}), "");
                                }
                                coroutine_suspended = obj2;
                                $result = $result3;
                                activity = activity3;
                                it = it2;
                                $i$f$forEach = $i$f$forEach2;
                                innerPushCacheManagerV2 = innerPushCacheManagerV23;
                                function3 = function32;
                                innerPushCacheManagerV2$findInnerPush$2 = innerPushCacheManagerV2$findInnerPush$22;
                                resultMap = resultMap2;
                                str = str3;
                            } else {
                                BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush default push, filterItem is empty");
                                $result = $result3;
                                activity = activity3;
                                resultMap = resultMap2;
                                it = it2;
                                str = str3;
                                $i$f$forEach = $i$f$forEach2;
                                innerPushCacheManagerV2 = innerPushCacheManagerV23;
                                function3 = function32;
                                innerPushCacheManagerV2$findInnerPush$2 = innerPushCacheManagerV2$findInnerPush$22;
                            }
                        }
                    } else {
                        List bizList2 = (List) resultMap.get(Boxing.boxInt(key));
                        List list4 = bizList2;
                        if (!(list4 == null || list4.isEmpty())) {
                            int bid = ((InnerPush) CollectionsKt.first(bizList2)).getBid();
                            innerPushCacheManagerV2$findInnerPush$2.L$0 = resultMap;
                            innerPushCacheManagerV2$findInnerPush$2.L$1 = innerPushCacheManagerV2;
                            innerPushCacheManagerV2$findInnerPush$2.L$2 = activity;
                            innerPushCacheManagerV2$findInnerPush$2.L$3 = str;
                            innerPushCacheManagerV2$findInnerPush$2.L$4 = function3;
                            innerPushCacheManagerV2$findInnerPush$2.L$5 = it;
                            innerPushCacheManagerV2$findInnerPush$2.L$6 = bizList2;
                            innerPushCacheManagerV2$findInnerPush$2.I$0 = key;
                            $result5 = $result;
                            innerPushCacheManagerV2$findInnerPush$2.label = 3;
                            $result6 = innerPushCacheManagerV2.findBizInnerPush(str, key, bid, innerPushCacheManagerV2$findInnerPush$2);
                            if ($result6 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            innerPushCacheManagerV2$findInnerPush$24 = innerPushCacheManagerV2$findInnerPush$2;
                            z = false;
                            bizList = bizList2;
                            result = (Pair) $result6;
                            if (((Boolean) result.getFirst()).booleanValue()) {
                                innerPushCacheManagerV2$findInnerPush$23 = innerPushCacheManagerV2$findInnerPush$24;
                                obj3 = coroutine_suspended;
                            } else {
                                innerPushCacheManagerV2$findInnerPush$23 = innerPushCacheManagerV2$findInnerPush$24;
                                long lastShowJob = InnerPushLocalStorage.INSTANCE.getBizInnerPushShowLastJob(String.valueOf(key));
                                if (((InnerPush) CollectionsKt.last(bizList)).getJob() == lastShowJob) {
                                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush type = " + key + ", list last push is last show job");
                                    obj3 = coroutine_suspended;
                                } else {
                                    obj3 = coroutine_suspended;
                                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findInnerPush type = " + key + ", onFind showList.size = " + bizList.size());
                                    function3.invoke(new InnerPushType.BizType(String.valueOf(key)), bizList, result.getSecond());
                                }
                            }
                            str3 = str;
                            $result = $result5;
                            coroutine_suspended = obj3;
                            resultMap2 = resultMap;
                            innerPushCacheManagerV2$findInnerPush$2 = innerPushCacheManagerV2$findInnerPush$23;
                            resultMap = resultMap2;
                            str = str3;
                        }
                    }
                    i = -1;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
                break;
            case 1:
                $result2 = obj;
                $i$f$forEach2 = 0;
                it2 = (Iterator) innerPushCacheManagerV2$findInnerPush$24.L$5;
                str2 = (String) innerPushCacheManagerV2$findInnerPush$24.L$3;
                activity2 = (Activity) innerPushCacheManagerV2$findInnerPush$24.L$2;
                innerPushCacheManagerV22 = (InnerPushCacheManagerV2) innerPushCacheManagerV2$findInnerPush$24.L$1;
                ResultKt.throwOnFailure($result2);
                $result3 = $result2;
                resultMap2 = (Map) innerPushCacheManagerV2$findInnerPush$24.L$0;
                function3 = (Function3) innerPushCacheManagerV2$findInnerPush$24.L$4;
                innerPushCacheManagerV2$findInnerPush$2 = innerPushCacheManagerV2$findInnerPush$24;
                List filteredData2 = (List) $result2;
                innerPushCacheManagerV2$findInnerPush$2.L$0 = resultMap2;
                innerPushCacheManagerV2$findInnerPush$2.L$1 = innerPushCacheManagerV22;
                innerPushCacheManagerV2$findInnerPush$2.L$2 = activity2;
                innerPushCacheManagerV2$findInnerPush$2.L$3 = str2;
                innerPushCacheManagerV2$findInnerPush$2.L$4 = function3;
                innerPushCacheManagerV2$findInnerPush$2.L$5 = it2;
                innerPushCacheManagerV2$findInnerPush$2.label = 2;
                $result4 = innerPushCacheManagerV22.findValidInnerPush(activity2, str2, filteredData2, innerPushCacheManagerV2$findInnerPush$2);
                if ($result4 != coroutine_suspended) {
                }
                break;
            case 2:
                $result4 = obj;
                $i$f$forEach2 = 0;
                it2 = (Iterator) innerPushCacheManagerV2$findInnerPush$24.L$5;
                function32 = (Function3) innerPushCacheManagerV2$findInnerPush$24.L$4;
                ResultKt.throwOnFailure($result4);
                $result3 = $result4;
                resultMap2 = (Map) innerPushCacheManagerV2$findInnerPush$24.L$0;
                innerPushCacheManagerV23 = (InnerPushCacheManagerV2) innerPushCacheManagerV2$findInnerPush$24.L$1;
                activity3 = (Activity) innerPushCacheManagerV2$findInnerPush$24.L$2;
                str3 = (String) innerPushCacheManagerV2$findInnerPush$24.L$3;
                innerPushCacheManagerV2$findInnerPush$22 = innerPushCacheManagerV2$findInnerPush$24;
                filterItem = (InnerPush) $result4;
                if (filterItem != null) {
                }
                break;
            case 3:
                $result6 = obj;
                $i$f$forEach = 0;
                z = false;
                key = innerPushCacheManagerV2$findInnerPush$24.I$0;
                bizList = (List) innerPushCacheManagerV2$findInnerPush$24.L$6;
                it = (Iterator) innerPushCacheManagerV2$findInnerPush$24.L$5;
                function3 = (Function3) innerPushCacheManagerV2$findInnerPush$24.L$4;
                str = (String) innerPushCacheManagerV2$findInnerPush$24.L$3;
                activity = (Activity) innerPushCacheManagerV2$findInnerPush$24.L$2;
                innerPushCacheManagerV2 = (InnerPushCacheManagerV2) innerPushCacheManagerV2$findInnerPush$24.L$1;
                resultMap = (Map) innerPushCacheManagerV2$findInnerPush$24.L$0;
                ResultKt.throwOnFailure($result6);
                $result5 = $result6;
                result = (Pair) $result6;
                if (((Boolean) result.getFirst()).booleanValue()) {
                }
                str3 = str;
                $result = $result5;
                coroutine_suspended = obj3;
                resultMap2 = resultMap;
                innerPushCacheManagerV2$findInnerPush$2 = innerPushCacheManagerV2$findInnerPush$23;
                resultMap = resultMap2;
                str = str3;
                i = -1;
                if (it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}