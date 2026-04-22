package video.biz.offline.list.logic.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.VBNumberExtKt;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineCacheCardModel.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0087@¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0087@¢\u0006\u0002\u0010\u000b\u001a<\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0087@¢\u0006\u0002\u0010\u000f\u001a4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0087@¢\u0006\u0002\u0010\u000b\u001a\u0012\u0010\u0011\u001a\u00020\n*\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0003¨\u0006\u0019"}, d2 = {"downloadingCards", "", "Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completedGroups", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "historyCache", "", "", "Lkotlin/time/Duration;", "(Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completedCards", "groupPage", "", "(Ljava/util/List;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchResult", "getHistoryProgress", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatPlayTime", "", "formatPlayTime-LRDsOJo", "(J)Ljava/lang/String;", "getCardTag", "Lvideo/biz/offline/list/logic/model/CardTag;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCacheCardModelKt {

    /* compiled from: OfflineCacheCardModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.SeasonType.values().length];
            try {
                iArr[OfflineVideoEntity.SeasonType.BANGUMI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.MOVIE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.DOCUMENTARY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.CN_BANGUMI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.TV_SERIES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.VARIETY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x010b -> B:40:0x019c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0154 -> B:34:0x0167). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0193 -> B:40:0x019c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object downloadingCards(List<OfflineVideoEntity> list, Continuation<? super List<OfflineDownloadingCardModel>> continuation) {
        OfflineCacheCardModelKt$downloadingCards$1 offlineCacheCardModelKt$downloadingCards$1;
        Iterable $this$map$iv;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        Iterator it;
        List $this$map$iv2;
        int $i$f$mapTo2;
        Collection destination$iv$iv;
        Object $result;
        Object $result2;
        OfflineCacheCardModelKt$downloadingCards$1 offlineCacheCardModelKt$downloadingCards$12;
        Continuation $continuation;
        OfflineVideoEntity it2;
        String title;
        Iterable $this$map$iv3;
        String subTitle;
        Collection destination$iv$iv2;
        Object obj;
        Iterable $this$mapTo$iv$iv2;
        Iterable $this$map$iv4;
        List $this$downloadingCards;
        Iterator it3;
        Continuation $completion;
        Object item$iv$iv;
        OfflineVideoEntity it4;
        Collection collection;
        int $i$f$map;
        int $i$f$map2;
        int $i$f$mapTo3;
        Object obj2;
        Object $result3;
        if (continuation instanceof OfflineCacheCardModelKt$downloadingCards$1) {
            offlineCacheCardModelKt$downloadingCards$1 = (OfflineCacheCardModelKt$downloadingCards$1) continuation;
            if ((offlineCacheCardModelKt$downloadingCards$1.label & Integer.MIN_VALUE) != 0) {
                offlineCacheCardModelKt$downloadingCards$1.label -= Integer.MIN_VALUE;
                Object $result4 = offlineCacheCardModelKt$downloadingCards$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineCacheCardModelKt$downloadingCards$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result4);
                        List<OfflineVideoEntity> $this$filter$iv = list;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            if (!Intrinsics.areEqual(((OfflineVideoEntity) element$iv$iv).getState(), OfflineVideoEntity.State.COMPLETED.INSTANCE)) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                        }
                        Iterable $this$sortedBy$iv = (List) destination$iv$iv3;
                        Iterable $this$map$iv5 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: video.biz.offline.list.logic.model.OfflineCacheCardModelKt$downloadingCards$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                OfflineVideoEntity it5 = (OfflineVideoEntity) t;
                                OfflineVideoEntity it6 = (OfflineVideoEntity) t2;
                                return ComparisonsKt.compareValues(Long.valueOf(it5.getCreateTime()), Long.valueOf(it6.getCreateTime()));
                            }
                        });
                        $this$map$iv = $this$map$iv5;
                        $this$mapTo$iv$iv = $this$map$iv5;
                        $i$f$mapTo = 0;
                        it = $this$map$iv5.iterator();
                        $this$map$iv2 = list;
                        $i$f$mapTo2 = 0;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        $result = coroutine_suspended;
                        $result2 = $result4;
                        offlineCacheCardModelKt$downloadingCards$12 = offlineCacheCardModelKt$downloadingCards$1;
                        $continuation = continuation;
                        break;
                    case 1:
                        boolean z = offlineCacheCardModelKt$downloadingCards$1.Z$0;
                        int i = offlineCacheCardModelKt$downloadingCards$1.I$2;
                        int $i$f$mapTo4 = offlineCacheCardModelKt$downloadingCards$1.I$1;
                        int $i$f$map3 = offlineCacheCardModelKt$downloadingCards$1.I$0;
                        OfflineVideoEntity it5 = (OfflineVideoEntity) offlineCacheCardModelKt$downloadingCards$1.L$6;
                        Object item$iv$iv2 = offlineCacheCardModelKt$downloadingCards$1.L$5;
                        Iterable $this$mapTo$iv$iv3 = (Iterable) offlineCacheCardModelKt$downloadingCards$1.L$2;
                        List $this$downloadingCards2 = (List) offlineCacheCardModelKt$downloadingCards$1.L$0;
                        ResultKt.throwOnFailure($result4);
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                        $this$map$iv4 = (Iterable) offlineCacheCardModelKt$downloadingCards$1.L$1;
                        it3 = (Iterator) offlineCacheCardModelKt$downloadingCards$1.L$4;
                        destination$iv$iv2 = (Collection) offlineCacheCardModelKt$downloadingCards$1.L$3;
                        title = (String) offlineCacheCardModelKt$downloadingCards$1.L$7;
                        item$iv$iv = item$iv$iv2;
                        it4 = it5;
                        $result3 = $result4;
                        collection = (Collection) offlineCacheCardModelKt$downloadingCards$1.L$8;
                        $i$f$map = $i$f$map3;
                        $i$f$map2 = $i$f$mapTo4;
                        $i$f$mapTo3 = i;
                        obj2 = coroutine_suspended;
                        offlineCacheCardModelKt$downloadingCards$12 = offlineCacheCardModelKt$downloadingCards$1;
                        obj = $result3;
                        $this$downloadingCards = $this$downloadingCards2;
                        $completion = continuation;
                        subTitle = (String) obj;
                        $result2 = $result3;
                        $result = obj2;
                        $i$f$mapTo = $i$f$map2;
                        $i$f$mapTo2 = $i$f$map;
                        destination$iv$iv = collection;
                        it2 = it4;
                        it = it3;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $this$map$iv3 = $this$map$iv4;
                        List list2 = $this$downloadingCards;
                        $continuation = $completion;
                        $this$map$iv2 = list2;
                        List $this$downloadingCards3 = $this$map$iv2;
                        destination$iv$iv.add(new OfflineDownloadingCardModel(it2.getKey(), it2.getCover(), getCardTag(it2), title, subTitle, it2.getState(), it2.getErrorCode(), it2.getTotalSize(), it2.getDownloadedSize(), false, it2.getBizType(), it2.getCanPlay(), 512, null));
                        $this$map$iv2 = $this$downloadingCards3;
                        destination$iv$iv = destination$iv$iv2;
                        $this$map$iv = $this$map$iv3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object item$iv$iv3 = it.next();
                    it2 = (OfflineVideoEntity) item$iv$iv3;
                    boolean isDrama = it2.hitAttr(OfflineVideoEntity.VideoAttr.DramaVideo);
                    title = it2.getGroupTitle();
                    if (isDrama) {
                        String pageTitle = it2.getPageTitle();
                        if (StringsKt.isBlank(pageTitle)) {
                            pageTitle = it2.getVideoTitle();
                        }
                        $this$map$iv3 = $this$map$iv;
                        subTitle = pageTitle;
                        destination$iv$iv2 = destination$iv$iv;
                    } else {
                        Continuation $completion2 = $continuation;
                        Object $result5 = $result2;
                        if (it2.getBizType() == OfflineVideoEntity.BizType.OGV) {
                            offlineCacheCardModelKt$downloadingCards$12.L$0 = SpillingKt.nullOutSpilledVariable($this$map$iv2);
                            offlineCacheCardModelKt$downloadingCards$12.L$1 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                            offlineCacheCardModelKt$downloadingCards$12.L$2 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                            offlineCacheCardModelKt$downloadingCards$12.L$3 = destination$iv$iv;
                            offlineCacheCardModelKt$downloadingCards$12.L$4 = it;
                            offlineCacheCardModelKt$downloadingCards$12.L$5 = SpillingKt.nullOutSpilledVariable(item$iv$iv3);
                            offlineCacheCardModelKt$downloadingCards$12.L$6 = it2;
                            offlineCacheCardModelKt$downloadingCards$12.L$7 = title;
                            offlineCacheCardModelKt$downloadingCards$12.L$8 = destination$iv$iv;
                            offlineCacheCardModelKt$downloadingCards$12.I$0 = $i$f$mapTo2;
                            offlineCacheCardModelKt$downloadingCards$12.I$1 = $i$f$mapTo;
                            offlineCacheCardModelKt$downloadingCards$12.I$2 = 0;
                            offlineCacheCardModelKt$downloadingCards$12.Z$0 = isDrama;
                            offlineCacheCardModelKt$downloadingCards$12.label = 1;
                            Object displaySubtitle = it2.getDisplaySubtitle(offlineCacheCardModelKt$downloadingCards$12);
                            if (displaySubtitle == $result) {
                                return $result;
                            }
                            obj = displaySubtitle;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                            $this$map$iv4 = $this$map$iv;
                            $this$downloadingCards = $this$map$iv2;
                            destination$iv$iv2 = destination$iv$iv;
                            it3 = it;
                            $completion = $completion2;
                            item$iv$iv = item$iv$iv3;
                            it4 = it2;
                            collection = destination$iv$iv2;
                            $i$f$map = $i$f$mapTo2;
                            $i$f$map2 = $i$f$mapTo;
                            $i$f$mapTo3 = 0;
                            obj2 = $result;
                            $result3 = $result5;
                            subTitle = (String) obj;
                            $result2 = $result3;
                            $result = obj2;
                            $i$f$mapTo = $i$f$map2;
                            $i$f$mapTo2 = $i$f$map;
                            destination$iv$iv = collection;
                            it2 = it4;
                            it = it3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                            $this$map$iv3 = $this$map$iv4;
                            List list22 = $this$downloadingCards;
                            $continuation = $completion;
                            $this$map$iv2 = list22;
                        } else {
                            $continuation = $completion2;
                            $result2 = $result5;
                            $this$map$iv3 = $this$map$iv;
                            subTitle = Intrinsics.areEqual(it2.getGroupTitle(), it2.getPageTitle()) ? null : it2.getPageTitle();
                            destination$iv$iv2 = destination$iv$iv;
                        }
                    }
                    List $this$downloadingCards32 = $this$map$iv2;
                    destination$iv$iv.add(new OfflineDownloadingCardModel(it2.getKey(), it2.getCover(), getCardTag(it2), title, subTitle, it2.getState(), it2.getErrorCode(), it2.getTotalSize(), it2.getDownloadedSize(), false, it2.getBizType(), it2.getCanPlay(), 512, null));
                    $this$map$iv2 = $this$downloadingCards32;
                    destination$iv$iv = destination$iv$iv2;
                    $this$map$iv = $this$map$iv3;
                    if (it.hasNext()) {
                        return (List) destination$iv$iv;
                    }
                }
            }
        }
        offlineCacheCardModelKt$downloadingCards$1 = new OfflineCacheCardModelKt$downloadingCards$1(continuation);
        Object $result42 = offlineCacheCardModelKt$downloadingCards$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineCacheCardModelKt$downloadingCards$1.label) {
        }
        if (it.hasNext()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x035b A[LOOP:0: B:89:0x0355->B:91:0x035b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0374  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x021b -> B:73:0x02f3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x028d -> B:71:0x02a5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x02ca -> B:73:0x02f3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object completedGroups(List<OfflineVideoEntity> list, Map<Long, Duration> map, Continuation<? super List<OfflineCachedCardModel>> continuation) {
        OfflineCacheCardModelKt$completedGroups$1 offlineCacheCardModelKt$completedGroups$1;
        Iterable $this$mapTo$iv$iv;
        Iterator it;
        int $i$f$map;
        Collection destination$iv$iv;
        int $i$f$mapTo;
        OfflineCacheCardModelKt$completedGroups$1 offlineCacheCardModelKt$completedGroups$12;
        Object $result;
        Object $result2;
        Map historyCache;
        Continuation $result3;
        Iterable $this$map$iv;
        List $this$map$iv2;
        ArrayList arrayList;
        Object item$iv$iv;
        OfflineVideoEntity first;
        Object obj;
        int i;
        String groupTitle;
        String title;
        int i2;
        List<OfflineVideoEntity> group;
        long totalSize;
        String subTitle;
        Object $result4;
        Collection collection;
        Collection destination$iv$iv2;
        int $i$f$mapTo2;
        int $i$f$map2;
        Object obj2;
        Iterator it2;
        Iterable $this$mapTo$iv$iv2;
        String id;
        OfflineCacheCardModelKt$completedGroups$1 offlineCacheCardModelKt$completedGroups$13;
        Iterable $result5;
        Continuation $completion;
        int i3;
        List $this$completedGroups;
        Map historyCache2;
        String id2;
        Iterator it3;
        List group2;
        Object item$iv$iv2;
        int i4;
        String title2;
        Object $result6;
        OfflineVideoEntity first2;
        Continuation $completion2;
        Iterable $this$mapTo$iv$iv3;
        Collection destination$iv$iv3;
        long totalSize2;
        Duration duration;
        Collection destination$iv$iv4;
        if (continuation instanceof OfflineCacheCardModelKt$completedGroups$1) {
            offlineCacheCardModelKt$completedGroups$1 = (OfflineCacheCardModelKt$completedGroups$1) continuation;
            if ((offlineCacheCardModelKt$completedGroups$1.label & Integer.MIN_VALUE) != 0) {
                offlineCacheCardModelKt$completedGroups$1.label -= Integer.MIN_VALUE;
                Object $result7 = offlineCacheCardModelKt$completedGroups$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineCacheCardModelKt$completedGroups$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result7);
                        List<OfflineVideoEntity> $this$filter$iv = list;
                        Collection destination$iv$iv5 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            OfflineVideoEntity it4 = (OfflineVideoEntity) element$iv$iv;
                            if (Intrinsics.areEqual(it4.getState(), OfflineVideoEntity.State.COMPLETED.INSTANCE)) {
                                destination$iv$iv5.add(element$iv$iv);
                            }
                        }
                        Iterable $this$groupBy$iv = (List) destination$iv$iv5;
                        Map destination$iv$iv6 = new LinkedHashMap();
                        for (Object element$iv$iv2 : $this$groupBy$iv) {
                            OfflineVideoEntity it5 = (OfflineVideoEntity) element$iv$iv2;
                            Long boxLong = Boxing.boxLong(it5.getGroupId());
                            Object value$iv$iv$iv = destination$iv$iv6.get(boxLong);
                            if (value$iv$iv$iv == null) {
                                arrayList = new ArrayList();
                                destination$iv$iv6.put(boxLong, arrayList);
                            } else {
                                arrayList = value$iv$iv$iv;
                            }
                            Object key$iv$iv$iv = arrayList;
                            List list$iv$iv = (List) key$iv$iv$iv;
                            list$iv$iv.add(element$iv$iv2);
                        }
                        Iterable $this$groupBy$iv2 = destination$iv$iv6.values();
                        Iterable $this$sortedBy$iv = CollectionsKt.toList($this$groupBy$iv2);
                        Iterable $this$map$iv3 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: video.biz.offline.list.logic.model.OfflineCacheCardModelKt$completedGroups$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                List group3 = (List) t;
                                Iterator<T> it6 = group3.iterator();
                                if (it6.hasNext()) {
                                    OfflineVideoEntity it7 = (OfflineVideoEntity) it6.next();
                                    long updateTime = it7.getUpdateTime();
                                    while (it6.hasNext()) {
                                        OfflineVideoEntity it8 = (OfflineVideoEntity) it6.next();
                                        long updateTime2 = it8.getUpdateTime();
                                        if (updateTime < updateTime2) {
                                            updateTime = updateTime2;
                                        }
                                    }
                                    Long valueOf = Long.valueOf(-updateTime);
                                    List group4 = (List) t2;
                                    Iterator<T> it9 = group4.iterator();
                                    if (it9.hasNext()) {
                                        OfflineVideoEntity it10 = (OfflineVideoEntity) it9.next();
                                        long updateTime3 = it10.getUpdateTime();
                                        while (it9.hasNext()) {
                                            OfflineVideoEntity it11 = (OfflineVideoEntity) it9.next();
                                            long updateTime4 = it11.getUpdateTime();
                                            if (updateTime3 < updateTime4) {
                                                updateTime3 = updateTime4;
                                            }
                                        }
                                        return ComparisonsKt.compareValues(valueOf, Long.valueOf(-updateTime3));
                                    }
                                    throw new NoSuchElementException();
                                }
                                throw new NoSuchElementException();
                            }
                        });
                        $this$mapTo$iv$iv = $this$map$iv3;
                        it = $this$mapTo$iv$iv.iterator();
                        $i$f$map = 0;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $i$f$mapTo = 0;
                        offlineCacheCardModelKt$completedGroups$12 = offlineCacheCardModelKt$completedGroups$1;
                        $result = $result7;
                        $result2 = coroutine_suspended;
                        historyCache = map;
                        $result3 = continuation;
                        $this$map$iv = $this$map$iv3;
                        $this$map$iv2 = list;
                        break;
                    case 1:
                        totalSize2 = offlineCacheCardModelKt$completedGroups$1.J$0;
                        int i5 = offlineCacheCardModelKt$completedGroups$1.I$3;
                        i4 = offlineCacheCardModelKt$completedGroups$1.I$2;
                        $i$f$mapTo = offlineCacheCardModelKt$completedGroups$1.I$1;
                        $i$f$map = offlineCacheCardModelKt$completedGroups$1.I$0;
                        Object item$iv$iv3 = offlineCacheCardModelKt$completedGroups$1.L$6;
                        it3 = (Iterator) offlineCacheCardModelKt$completedGroups$1.L$5;
                        destination$iv$iv3 = (Collection) offlineCacheCardModelKt$completedGroups$1.L$4;
                        $this$mapTo$iv$iv3 = (Iterable) offlineCacheCardModelKt$completedGroups$1.L$3;
                        Iterable $this$map$iv4 = (Iterable) offlineCacheCardModelKt$completedGroups$1.L$2;
                        Map historyCache3 = (Map) offlineCacheCardModelKt$completedGroups$1.L$1;
                        List $this$completedGroups2 = (List) offlineCacheCardModelKt$completedGroups$1.L$0;
                        ResultKt.throwOnFailure($result7);
                        historyCache2 = historyCache3;
                        $this$completedGroups = $this$completedGroups2;
                        group2 = (List) offlineCacheCardModelKt$completedGroups$1.L$7;
                        $completion2 = continuation;
                        title2 = (String) offlineCacheCardModelKt$completedGroups$1.L$9;
                        first2 = (OfflineVideoEntity) offlineCacheCardModelKt$completedGroups$1.L$10;
                        item$iv$iv = item$iv$iv3;
                        item$iv$iv2 = coroutine_suspended;
                        $this$map$iv = $this$map$iv4;
                        id2 = (String) offlineCacheCardModelKt$completedGroups$1.L$8;
                        i3 = i5;
                        $result6 = $result7;
                        destination$iv$iv4 = (Collection) offlineCacheCardModelKt$completedGroups$1.L$11;
                        subTitle = (String) $result7;
                        totalSize = totalSize2;
                        first = first2;
                        i2 = i3;
                        title = title2;
                        destination$iv$iv2 = destination$iv$iv3;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                        id = id2;
                        group = group2;
                        $result4 = $result6;
                        collection = destination$iv$iv4;
                        $result5 = $this$map$iv;
                        $i$f$mapTo2 = $i$f$mapTo;
                        $i$f$map2 = $i$f$map;
                        it2 = it3;
                        $completion = $completion2;
                        obj2 = item$iv$iv2;
                        $this$map$iv2 = $this$completedGroups;
                        offlineCacheCardModelKt$completedGroups$13 = offlineCacheCardModelKt$completedGroups$1;
                        historyCache = historyCache2;
                        String cover = first.getCover();
                        List $this$completedGroups3 = $this$map$iv2;
                        String filePath = DiskFileImpl_androidKt.filePath(first, FileType.Cover.INSTANCE);
                        CardTag cardTag = getCardTag(first);
                        long j = i2 == 0 ? Duration.Companion.getZERO-UwyO8pc() : first.m2773getDurationUwyO8pc();
                        long j2 = (i2 == 0 && (duration = historyCache.get(Boxing.boxLong(first.getCid()))) != null) ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                        String fileSize = VBNumberExtKt.toFileSize(totalSize);
                        String author = i2 != 0 ? "" : first.getAuthor();
                        int i6 = 0;
                        for (OfflineVideoEntity it6 : group) {
                            i6 += it6.getDanmakuCount();
                        }
                        collection.add(new OfflineCachedCardModel(id, cover, filePath, cardTag, title, subTitle, j, j2, fileSize, author, i6, first.getLinkStr(), i2 != 0 ? false : first.isVip(), first.getBizType(), group, null));
                        $this$map$iv2 = $this$completedGroups3;
                        $result3 = $completion;
                        $this$map$iv = $result5;
                        offlineCacheCardModelKt$completedGroups$12 = offlineCacheCardModelKt$completedGroups$13;
                        $result = $result4;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $result2 = obj2;
                        it = it2;
                        $i$f$mapTo = $i$f$mapTo2;
                        $i$f$map = $i$f$map2;
                        destination$iv$iv = destination$iv$iv2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!it.hasNext()) {
                    item$iv$iv = it.next();
                    List<OfflineVideoEntity> group3 = (List) item$iv$iv;
                    Continuation $completion3 = $result3;
                    int i7 = group3.size() > 1 ? 1 : 0;
                    List $this$minBy$iv = group3;
                    Iterator iterator$iv = $this$minBy$iv.iterator();
                    if (!iterator$iv.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object minElem$iv = iterator$iv.next();
                    if (iterator$iv.hasNext()) {
                        OfflineVideoEntity it7 = (OfflineVideoEntity) minElem$iv;
                        long minValue$iv = it7.getVideoIndex();
                        while (true) {
                            Object e$iv = iterator$iv.next();
                            OfflineVideoEntity it8 = (OfflineVideoEntity) e$iv;
                            long v$iv = it8.getVideoIndex();
                            if (minValue$iv > v$iv) {
                                minElem$iv = e$iv;
                                minValue$iv = v$iv;
                            }
                            if (iterator$iv.hasNext()) {
                                List $this$completedGroups4 = $this$map$iv2;
                                $this$map$iv2 = $this$completedGroups4;
                                $result2 = $result2;
                                historyCache = historyCache;
                            }
                        }
                    }
                    first = (OfflineVideoEntity) minElem$iv;
                    Object $result8 = $result;
                    String id3 = String.valueOf(first.getGroupId());
                    long j3 = 0;
                    for (OfflineVideoEntity it9 : group3) {
                        j3 += it9.getTotalSize();
                    }
                    long totalSize3 = j3;
                    if (i7 != 0) {
                        groupTitle = first.getGroupTitle();
                        obj = $result2;
                        i = 0;
                    } else {
                        obj = $result2;
                        i = 0;
                        if (first.getBizType() == OfflineVideoEntity.BizType.OGV) {
                            groupTitle = first.getGroupTitle();
                        } else if (first.hitAttr(OfflineVideoEntity.VideoAttr.DramaVideo)) {
                            String videoTitle = first.getVideoTitle();
                            if (StringsKt.isBlank(videoTitle)) {
                                videoTitle = first.getGroupTitle();
                            }
                            groupTitle = videoTitle;
                        } else {
                            groupTitle = first.getGroupTitle();
                        }
                    }
                    String title3 = groupTitle;
                    if (i7 != 0) {
                        $result4 = $result8;
                        title = title3;
                        i2 = i7;
                        group = group3;
                        totalSize = totalSize3;
                        collection = destination$iv$iv;
                        destination$iv$iv2 = collection;
                        $i$f$mapTo2 = $i$f$mapTo;
                        $i$f$map2 = $i$f$map;
                        obj2 = obj;
                        subTitle = null;
                        it2 = it;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                        id = id3;
                        offlineCacheCardModelKt$completedGroups$13 = offlineCacheCardModelKt$completedGroups$12;
                        $result5 = $this$map$iv;
                        $completion = $completion3;
                    } else {
                        int i8 = i7;
                        if (first.getBizType() == OfflineVideoEntity.BizType.OGV) {
                            offlineCacheCardModelKt$completedGroups$12.L$0 = SpillingKt.nullOutSpilledVariable($this$map$iv2);
                            offlineCacheCardModelKt$completedGroups$12.L$1 = historyCache;
                            offlineCacheCardModelKt$completedGroups$12.L$2 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                            offlineCacheCardModelKt$completedGroups$12.L$3 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                            offlineCacheCardModelKt$completedGroups$12.L$4 = destination$iv$iv;
                            offlineCacheCardModelKt$completedGroups$12.L$5 = it;
                            offlineCacheCardModelKt$completedGroups$12.L$6 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                            offlineCacheCardModelKt$completedGroups$12.L$7 = group3;
                            offlineCacheCardModelKt$completedGroups$12.L$8 = id3;
                            offlineCacheCardModelKt$completedGroups$12.L$9 = title3;
                            offlineCacheCardModelKt$completedGroups$12.L$10 = first;
                            offlineCacheCardModelKt$completedGroups$12.L$11 = destination$iv$iv;
                            offlineCacheCardModelKt$completedGroups$12.I$0 = $i$f$map;
                            offlineCacheCardModelKt$completedGroups$12.I$1 = $i$f$mapTo;
                            int i9 = i;
                            offlineCacheCardModelKt$completedGroups$12.I$2 = i9;
                            i3 = i8;
                            offlineCacheCardModelKt$completedGroups$12.I$3 = i3;
                            $this$completedGroups = $this$map$iv2;
                            historyCache2 = historyCache;
                            offlineCacheCardModelKt$completedGroups$12.J$0 = totalSize3;
                            offlineCacheCardModelKt$completedGroups$12.label = 1;
                            Object displaySubtitle = first.getDisplaySubtitle(offlineCacheCardModelKt$completedGroups$12);
                            Object obj3 = obj;
                            if (displaySubtitle == obj3) {
                                return obj3;
                            }
                            id2 = id3;
                            it3 = it;
                            group2 = group3;
                            item$iv$iv2 = obj3;
                            offlineCacheCardModelKt$completedGroups$1 = offlineCacheCardModelKt$completedGroups$12;
                            i4 = i9;
                            title2 = title3;
                            $result6 = $result8;
                            first2 = first;
                            $result7 = displaySubtitle;
                            $completion2 = $completion3;
                            $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            destination$iv$iv3 = destination$iv$iv;
                            totalSize2 = totalSize3;
                            destination$iv$iv4 = destination$iv$iv;
                            subTitle = (String) $result7;
                            totalSize = totalSize2;
                            first = first2;
                            i2 = i3;
                            title = title2;
                            destination$iv$iv2 = destination$iv$iv3;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                            id = id2;
                            group = group2;
                            $result4 = $result6;
                            collection = destination$iv$iv4;
                            $result5 = $this$map$iv;
                            $i$f$mapTo2 = $i$f$mapTo;
                            $i$f$map2 = $i$f$map;
                            it2 = it3;
                            $completion = $completion2;
                            obj2 = item$iv$iv2;
                            $this$map$iv2 = $this$completedGroups;
                            offlineCacheCardModelKt$completedGroups$13 = offlineCacheCardModelKt$completedGroups$1;
                            historyCache = historyCache2;
                        } else {
                            Map historyCache4 = historyCache;
                            Object obj4 = obj;
                            title = title3;
                            i2 = i8;
                            group = group3;
                            totalSize = totalSize3;
                            subTitle = null;
                            $result4 = $result8;
                            collection = destination$iv$iv;
                            destination$iv$iv2 = collection;
                            $i$f$mapTo2 = $i$f$mapTo;
                            $i$f$map2 = $i$f$map;
                            obj2 = obj4;
                            it2 = it;
                            historyCache = historyCache4;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                            id = id3;
                            offlineCacheCardModelKt$completedGroups$13 = offlineCacheCardModelKt$completedGroups$12;
                            $result5 = $this$map$iv;
                            $completion = $completion3;
                        }
                    }
                    String cover2 = first.getCover();
                    List $this$completedGroups32 = $this$map$iv2;
                    String filePath2 = DiskFileImpl_androidKt.filePath(first, FileType.Cover.INSTANCE);
                    CardTag cardTag2 = getCardTag(first);
                    long j4 = i2 == 0 ? Duration.Companion.getZERO-UwyO8pc() : first.m2773getDurationUwyO8pc();
                    if (i2 == 0) {
                        long j22 = (i2 == 0 && (duration = historyCache.get(Boxing.boxLong(first.getCid()))) != null) ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                        String fileSize2 = VBNumberExtKt.toFileSize(totalSize);
                        String author2 = i2 != 0 ? "" : first.getAuthor();
                        int i62 = 0;
                        while (r0.hasNext()) {
                        }
                        collection.add(new OfflineCachedCardModel(id, cover2, filePath2, cardTag2, title, subTitle, j4, j22, fileSize2, author2, i62, first.getLinkStr(), i2 != 0 ? false : first.isVip(), first.getBizType(), group, null));
                        $this$map$iv2 = $this$completedGroups32;
                        $result3 = $completion;
                        $this$map$iv = $result5;
                        offlineCacheCardModelKt$completedGroups$12 = offlineCacheCardModelKt$completedGroups$13;
                        $result = $result4;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $result2 = obj2;
                        it = it2;
                        $i$f$mapTo = $i$f$mapTo2;
                        $i$f$map = $i$f$map2;
                        destination$iv$iv = destination$iv$iv2;
                        if (!it.hasNext()) {
                            return (List) destination$iv$iv;
                        }
                    }
                    long j222 = (i2 == 0 && (duration = historyCache.get(Boxing.boxLong(first.getCid()))) != null) ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                    String fileSize22 = VBNumberExtKt.toFileSize(totalSize);
                    String author22 = i2 != 0 ? "" : first.getAuthor();
                    int i622 = 0;
                    while (r0.hasNext()) {
                    }
                    collection.add(new OfflineCachedCardModel(id, cover2, filePath2, cardTag2, title, subTitle, j4, j222, fileSize22, author22, i622, first.getLinkStr(), i2 != 0 ? false : first.isVip(), first.getBizType(), group, null));
                    $this$map$iv2 = $this$completedGroups32;
                    $result3 = $completion;
                    $this$map$iv = $result5;
                    offlineCacheCardModelKt$completedGroups$12 = offlineCacheCardModelKt$completedGroups$13;
                    $result = $result4;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $result2 = obj2;
                    it = it2;
                    $i$f$mapTo = $i$f$mapTo2;
                    $i$f$map = $i$f$map2;
                    destination$iv$iv = destination$iv$iv2;
                    if (!it.hasNext()) {
                    }
                }
            }
        }
        offlineCacheCardModelKt$completedGroups$1 = new OfflineCacheCardModelKt$completedGroups$1(continuation);
        Object $result72 = offlineCacheCardModelKt$completedGroups$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineCacheCardModelKt$completedGroups$1.label) {
        }
        if (!it.hasNext()) {
        }
    }

    public static /* synthetic */ Object completedGroups$default(List list, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return completedGroups(list, map, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x032f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x02a7 -> B:48:0x02cd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object completedCards(List<OfflineVideoEntity> list, boolean groupPage, Map<Long, Duration> map, Continuation<? super List<OfflineCachedCardModel>> continuation) {
        Continuation<? super String> continuation2;
        long j;
        List<OfflineVideoEntity> videos;
        OfflineVideoEntity first;
        Iterable $this$map$iv;
        Iterable $this$mapTo$iv$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        int $i$f$mapTo;
        Iterator it;
        List grouped;
        Continuation<? super String> continuation3;
        Object $result;
        Object obj;
        List $this$completedCards;
        boolean groupPage2;
        Map map2;
        Continuation $completion;
        ArrayList arrayList;
        List videos2;
        String str;
        String str2;
        String str3;
        CardTag cardTag;
        Collection destination$iv$iv2;
        Continuation $completion2;
        OfflineVideoEntity page;
        Map historyCache;
        Iterable $this$mapTo$iv$iv2;
        Collection collection;
        int $i$f$map2;
        Iterable $this$map$iv2;
        if (continuation instanceof OfflineCacheCardModelKt$completedCards$1) {
            OfflineCacheCardModelKt$completedCards$1 offlineCacheCardModelKt$completedCards$1 = (OfflineCacheCardModelKt$completedCards$1) continuation;
            if ((offlineCacheCardModelKt$completedCards$1.label & Integer.MIN_VALUE) != 0) {
                offlineCacheCardModelKt$completedCards$1.label -= Integer.MIN_VALUE;
                continuation2 = offlineCacheCardModelKt$completedCards$1;
                Object $result2 = continuation2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (continuation2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        List<OfflineVideoEntity> $this$filter$iv = list;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            OfflineVideoEntity it2 = (OfflineVideoEntity) element$iv$iv;
                            if (Intrinsics.areEqual(it2.getState(), OfflineVideoEntity.State.COMPLETED.INSTANCE)) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                        }
                        Iterable $this$groupBy$iv = (List) destination$iv$iv3;
                        Map destination$iv$iv4 = new LinkedHashMap();
                        for (Object element$iv$iv2 : $this$groupBy$iv) {
                            OfflineVideoEntity it3 = (OfflineVideoEntity) element$iv$iv2;
                            Long boxLong = Boxing.boxLong(it3.getVideoId());
                            Object value$iv$iv$iv = destination$iv$iv4.get(boxLong);
                            if (value$iv$iv$iv == null) {
                                arrayList = new ArrayList();
                                destination$iv$iv4.put(boxLong, arrayList);
                            } else {
                                arrayList = value$iv$iv$iv;
                            }
                            Object key$iv$iv$iv = arrayList;
                            List list$iv$iv = (List) key$iv$iv$iv;
                            list$iv$iv.add(element$iv$iv2);
                        }
                        Iterable $this$groupBy$iv2 = destination$iv$iv4.values();
                        List grouped2 = CollectionsKt.toList($this$groupBy$iv2);
                        if (grouped2.size() == 1) {
                            videos = (List) CollectionsKt.first(grouped2);
                            first = (OfflineVideoEntity) CollectionsKt.firstOrNull(videos);
                            if (first == null) {
                                return CollectionsKt.emptyList();
                            }
                            if (first.hitAttr(OfflineVideoEntity.VideoAttr.DramaVideo) && groupPage) {
                                long totalSize = 0;
                                for (OfflineVideoEntity it4 : videos) {
                                    totalSize += it4.getTotalSize();
                                }
                                OfflineCachedCardModel videoItem = new OfflineCachedCardModel(String.valueOf(first.getVideoId()), first.getCover(), DiskFileImpl_androidKt.filePath(first, FileType.Cover.INSTANCE), null, first.getVideoTitle(), null, Duration.Companion.getZERO-UwyO8pc(), Duration.Companion.getZERO-UwyO8pc(), VBNumberExtKt.toFileSize(totalSize), "", 0, first.getLinkStr(), false, first.getBizType(), videos, 5160, null);
                                return CollectionsKt.listOf(videoItem);
                            }
                            List $this$sortedBy$iv = videos;
                            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: video.biz.offline.list.logic.model.OfflineCacheCardModelKt$completedCards$$inlined$sortedBy$1
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    OfflineVideoEntity it5 = (OfflineVideoEntity) t;
                                    OfflineVideoEntity it6 = (OfflineVideoEntity) t2;
                                    return ComparisonsKt.compareValues(Long.valueOf(it5.getPageIndex()), Long.valueOf(it6.getPageIndex()));
                                }
                            });
                            $this$mapTo$iv$iv = $this$map$iv;
                            $i$f$map = 0;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            $i$f$mapTo = 0;
                            it = $this$mapTo$iv$iv.iterator();
                            grouped = grouped2;
                            continuation3 = continuation2;
                            $result = $result2;
                            obj = coroutine_suspended;
                            $this$completedCards = list;
                            groupPage2 = groupPage;
                            map2 = map;
                            $completion = continuation;
                            break;
                        } else {
                            List $this$sortedBy$iv2 = grouped2;
                            Iterable<List> $this$map$iv3 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: video.biz.offline.list.logic.model.OfflineCacheCardModelKt$completedCards$$inlined$sortedBy$2
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    List it5 = (List) t;
                                    List it6 = (List) t2;
                                    return ComparisonsKt.compareValues(Long.valueOf(((OfflineVideoEntity) CollectionsKt.first(it5)).getVideoIndex()), Long.valueOf(((OfflineVideoEntity) CollectionsKt.first(it6)).getVideoIndex()));
                                }
                            });
                            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                            for (List<OfflineVideoEntity> videos3 : $this$map$iv3) {
                                boolean isMulPage = videos3.size() > 1;
                                OfflineVideoEntity first2 = (OfflineVideoEntity) CollectionsKt.first(videos3);
                                long j2 = 0;
                                for (OfflineVideoEntity it5 : videos3) {
                                    j2 += it5.getTotalSize();
                                }
                                long totalSize2 = j2;
                                String valueOf = String.valueOf(first2.getVideoId());
                                String cover = first2.getCover();
                                String filePath = DiskFileImpl_androidKt.filePath(first2, FileType.Cover.INSTANCE);
                                String videoTitle = first2.getVideoTitle();
                                long j3 = isMulPage ? Duration.Companion.getZERO-UwyO8pc() : first2.m2773getDurationUwyO8pc();
                                if (isMulPage) {
                                    j = Duration.Companion.getZERO-UwyO8pc();
                                } else {
                                    Duration duration = map.get(Boxing.boxLong(first2.getCid()));
                                    j = duration != null ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                                }
                                String fileSize = VBNumberExtKt.toFileSize(totalSize2);
                                String author = first2.getAuthor();
                                int i = 0;
                                for (OfflineVideoEntity it6 : videos3) {
                                    i += it6.getDanmakuCount();
                                }
                                destination$iv$iv5.add(new OfflineCachedCardModel(valueOf, cover, filePath, null, videoTitle, null, j3, j, fileSize, author, i, first2.getLinkStr(), isMulPage ? false : first2.isVip(), first2.getBizType(), videos3, 8, null));
                            }
                            return (List) destination$iv$iv5;
                        }
                    case 1:
                        int i2 = continuation2.I$2;
                        int $i$f$mapTo2 = continuation2.I$1;
                        int $i$f$map3 = continuation2.I$0;
                        boolean groupPage3 = continuation2.Z$0;
                        collection = (Collection) continuation2.L$15;
                        page = (OfflineVideoEntity) continuation2.L$10;
                        Object obj2 = continuation2.L$9;
                        Collection destination$iv$iv6 = (Collection) continuation2.L$7;
                        $this$mapTo$iv$iv2 = (Iterable) continuation2.L$6;
                        $this$map$iv2 = (Iterable) continuation2.L$5;
                        OfflineVideoEntity first3 = (OfflineVideoEntity) continuation2.L$4;
                        videos2 = (List) continuation2.L$3;
                        List grouped3 = (List) continuation2.L$2;
                        Map historyCache2 = (Map) continuation2.L$1;
                        $this$completedCards = (List) continuation2.L$0;
                        ResultKt.throwOnFailure($result2);
                        destination$iv$iv2 = destination$iv$iv6;
                        str2 = (String) continuation2.L$14;
                        str = (String) continuation2.L$13;
                        str3 = (String) continuation2.L$12;
                        cardTag = (CardTag) continuation2.L$11;
                        $result = $result2;
                        obj = coroutine_suspended;
                        it = (Iterator) continuation2.L$8;
                        $i$f$mapTo = $i$f$mapTo2;
                        grouped = grouped3;
                        historyCache = historyCache2;
                        $completion2 = continuation;
                        continuation3 = continuation2;
                        groupPage2 = groupPage3;
                        first = first3;
                        $i$f$map2 = $i$f$map3;
                        String str4 = (String) $result2;
                        long m2773getDurationUwyO8pc = page.m2773getDurationUwyO8pc();
                        Duration duration2 = historyCache.get(Boxing.boxLong(page.getCid()));
                        collection.add(new OfflineCachedCardModel(str2, str, str3, cardTag, str4, null, m2773getDurationUwyO8pc, duration2 == null ? duration2.unbox-impl() : Duration.Companion.getZERO-UwyO8pc(), VBNumberExtKt.toFileSize(page.getTotalSize()), page.getAuthor(), page.getDanmakuCount(), page.getLinkStr(), page.isVip(), page.getBizType(), CollectionsKt.listOf(page), 32, null));
                        map2 = historyCache;
                        $completion = $completion2;
                        $i$f$map = $i$f$map2;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $this$map$iv = $this$map$iv2;
                        videos = videos2;
                        destination$iv$iv = destination$iv$iv2;
                        continuation3 = continuation3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object item$iv$iv = it.next();
                    Continuation $completion3 = $completion;
                    OfflineVideoEntity page2 = (OfflineVideoEntity) item$iv$iv;
                    Object $result3 = $result;
                    Object obj3 = obj;
                    String valueOf2 = String.valueOf(page2.getPageId());
                    String cover2 = page2.getCover();
                    int $i$f$mapTo3 = $i$f$mapTo;
                    String filePath2 = DiskFileImpl_androidKt.filePath(page2, FileType.Cover.INSTANCE);
                    int $i$f$map4 = $i$f$map;
                    CardTag cardTag2 = getCardTag(page2);
                    boolean groupPage4 = groupPage2;
                    continuation3.L$0 = SpillingKt.nullOutSpilledVariable($this$completedCards);
                    continuation3.L$1 = map2;
                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(grouped);
                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(videos);
                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(first);
                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                    continuation3.L$7 = destination$iv$iv;
                    continuation3.L$8 = it;
                    continuation3.L$9 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                    continuation3.L$10 = page2;
                    continuation3.L$11 = cardTag2;
                    continuation3.L$12 = filePath2;
                    continuation3.L$13 = cover2;
                    continuation3.L$14 = valueOf2;
                    continuation3.L$15 = destination$iv$iv;
                    continuation3.Z$0 = groupPage4;
                    List $this$completedCards2 = $this$completedCards;
                    continuation3.I$0 = $i$f$map4;
                    continuation3.I$1 = $i$f$mapTo3;
                    continuation3.I$2 = 0;
                    continuation3.label = 1;
                    Object displaySubtitle = page2.getDisplaySubtitle(continuation3);
                    if (displaySubtitle == obj3) {
                        return obj3;
                    }
                    videos2 = videos;
                    str = cover2;
                    str2 = valueOf2;
                    str3 = filePath2;
                    cardTag = cardTag2;
                    destination$iv$iv2 = destination$iv$iv;
                    $i$f$mapTo = $i$f$mapTo3;
                    $completion2 = $completion3;
                    $result = $result3;
                    obj = obj3;
                    page = page2;
                    groupPage2 = groupPage4;
                    historyCache = map2;
                    $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    collection = destination$iv$iv2;
                    $i$f$map2 = $i$f$map4;
                    $result2 = displaySubtitle;
                    $this$map$iv2 = $this$map$iv;
                    $this$completedCards = $this$completedCards2;
                    String str42 = (String) $result2;
                    long m2773getDurationUwyO8pc2 = page.m2773getDurationUwyO8pc();
                    Duration duration22 = historyCache.get(Boxing.boxLong(page.getCid()));
                    collection.add(new OfflineCachedCardModel(str2, str, str3, cardTag, str42, null, m2773getDurationUwyO8pc2, duration22 == null ? duration22.unbox-impl() : Duration.Companion.getZERO-UwyO8pc(), VBNumberExtKt.toFileSize(page.getTotalSize()), page.getAuthor(), page.getDanmakuCount(), page.getLinkStr(), page.isVip(), page.getBizType(), CollectionsKt.listOf(page), 32, null));
                    map2 = historyCache;
                    $completion = $completion2;
                    $i$f$map = $i$f$map2;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $this$map$iv = $this$map$iv2;
                    videos = videos2;
                    destination$iv$iv = destination$iv$iv2;
                    continuation3 = continuation3;
                    if (it.hasNext()) {
                        return (List) destination$iv$iv;
                    }
                }
            }
        }
        continuation2 = new OfflineCacheCardModelKt$completedCards$1(continuation);
        Object $result22 = continuation2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (continuation2.label) {
        }
        if (it.hasNext()) {
        }
    }

    public static /* synthetic */ Object completedCards$default(List list, boolean z, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return completedCards(list, z, map, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0362 A[LOOP:0: B:89:0x035c->B:91:0x0362, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x037b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x021b -> B:73:0x02fa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x028e -> B:71:0x02a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x02cb -> B:73:0x02fa). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object searchResult(List<OfflineVideoEntity> list, Map<Long, Duration> map, Continuation<? super List<OfflineCachedCardModel>> continuation) {
        OfflineCacheCardModelKt$searchResult$1 offlineCacheCardModelKt$searchResult$1;
        Iterable $this$mapTo$iv$iv;
        Iterator it;
        int $i$f$map;
        Collection destination$iv$iv;
        int $i$f$mapTo;
        OfflineCacheCardModelKt$searchResult$1 offlineCacheCardModelKt$searchResult$12;
        Object $result;
        Object $result2;
        Map historyCache;
        Continuation $result3;
        Iterable $this$map$iv;
        List $this$map$iv2;
        ArrayList arrayList;
        Object item$iv$iv;
        OfflineVideoEntity first;
        Object obj;
        int i;
        String groupTitle;
        String subTitle;
        String title;
        int i2;
        List<OfflineVideoEntity> group;
        long totalSize;
        Object $result4;
        Collection collection;
        Collection destination$iv$iv2;
        int $i$f$mapTo2;
        int $i$f$map2;
        Object obj2;
        Iterator it2;
        Iterable $this$mapTo$iv$iv2;
        String id;
        OfflineCacheCardModelKt$searchResult$1 offlineCacheCardModelKt$searchResult$13;
        Iterable $result5;
        Continuation $completion;
        int i3;
        List $this$searchResult;
        Map historyCache2;
        String id2;
        Iterable $this$mapTo$iv$iv3;
        List group2;
        Object item$iv$iv2;
        String title2;
        Object $result6;
        OfflineVideoEntity first2;
        Continuation $completion2;
        int i4;
        long totalSize2;
        Iterator it3;
        Collection destination$iv$iv3;
        Duration duration;
        Collection destination$iv$iv4;
        if (continuation instanceof OfflineCacheCardModelKt$searchResult$1) {
            offlineCacheCardModelKt$searchResult$1 = (OfflineCacheCardModelKt$searchResult$1) continuation;
            if ((offlineCacheCardModelKt$searchResult$1.label & Integer.MIN_VALUE) != 0) {
                offlineCacheCardModelKt$searchResult$1.label -= Integer.MIN_VALUE;
                Object $result7 = offlineCacheCardModelKt$searchResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineCacheCardModelKt$searchResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result7);
                        List<OfflineVideoEntity> $this$filter$iv = list;
                        Collection destination$iv$iv5 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            OfflineVideoEntity it4 = (OfflineVideoEntity) element$iv$iv;
                            if (Intrinsics.areEqual(it4.getState(), OfflineVideoEntity.State.COMPLETED.INSTANCE)) {
                                destination$iv$iv5.add(element$iv$iv);
                            }
                        }
                        Iterable $this$groupBy$iv = (List) destination$iv$iv5;
                        Map destination$iv$iv6 = new LinkedHashMap();
                        for (Object element$iv$iv2 : $this$groupBy$iv) {
                            OfflineVideoEntity it5 = (OfflineVideoEntity) element$iv$iv2;
                            Long boxLong = Boxing.boxLong(it5.getGroupId());
                            Object value$iv$iv$iv = destination$iv$iv6.get(boxLong);
                            if (value$iv$iv$iv == null) {
                                arrayList = new ArrayList();
                                destination$iv$iv6.put(boxLong, arrayList);
                            } else {
                                arrayList = value$iv$iv$iv;
                            }
                            Object key$iv$iv$iv = arrayList;
                            List list$iv$iv = (List) key$iv$iv$iv;
                            list$iv$iv.add(element$iv$iv2);
                        }
                        Iterable $this$groupBy$iv2 = destination$iv$iv6.values();
                        Iterable $this$sortedBy$iv = CollectionsKt.toList($this$groupBy$iv2);
                        Iterable $this$map$iv3 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: video.biz.offline.list.logic.model.OfflineCacheCardModelKt$searchResult$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                List group3 = (List) t;
                                Iterator<T> it6 = group3.iterator();
                                if (it6.hasNext()) {
                                    OfflineVideoEntity it7 = (OfflineVideoEntity) it6.next();
                                    long updateTime = it7.getUpdateTime();
                                    while (it6.hasNext()) {
                                        OfflineVideoEntity it8 = (OfflineVideoEntity) it6.next();
                                        long updateTime2 = it8.getUpdateTime();
                                        if (updateTime < updateTime2) {
                                            updateTime = updateTime2;
                                        }
                                    }
                                    Long valueOf = Long.valueOf(-updateTime);
                                    List group4 = (List) t2;
                                    Iterator<T> it9 = group4.iterator();
                                    if (it9.hasNext()) {
                                        OfflineVideoEntity it10 = (OfflineVideoEntity) it9.next();
                                        long updateTime3 = it10.getUpdateTime();
                                        while (it9.hasNext()) {
                                            OfflineVideoEntity it11 = (OfflineVideoEntity) it9.next();
                                            long updateTime4 = it11.getUpdateTime();
                                            if (updateTime3 < updateTime4) {
                                                updateTime3 = updateTime4;
                                            }
                                        }
                                        return ComparisonsKt.compareValues(valueOf, Long.valueOf(-updateTime3));
                                    }
                                    throw new NoSuchElementException();
                                }
                                throw new NoSuchElementException();
                            }
                        });
                        $this$mapTo$iv$iv = $this$map$iv3;
                        it = $this$mapTo$iv$iv.iterator();
                        $i$f$map = 0;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $i$f$mapTo = 0;
                        offlineCacheCardModelKt$searchResult$12 = offlineCacheCardModelKt$searchResult$1;
                        $result = $result7;
                        $result2 = coroutine_suspended;
                        historyCache = map;
                        $result3 = continuation;
                        $this$map$iv = $this$map$iv3;
                        $this$map$iv2 = list;
                        break;
                    case 1:
                        totalSize2 = offlineCacheCardModelKt$searchResult$1.J$0;
                        int i5 = offlineCacheCardModelKt$searchResult$1.I$3;
                        i4 = offlineCacheCardModelKt$searchResult$1.I$2;
                        $i$f$mapTo = offlineCacheCardModelKt$searchResult$1.I$1;
                        $i$f$map = offlineCacheCardModelKt$searchResult$1.I$0;
                        Object item$iv$iv3 = offlineCacheCardModelKt$searchResult$1.L$6;
                        it3 = (Iterator) offlineCacheCardModelKt$searchResult$1.L$5;
                        destination$iv$iv3 = (Collection) offlineCacheCardModelKt$searchResult$1.L$4;
                        $this$mapTo$iv$iv3 = (Iterable) offlineCacheCardModelKt$searchResult$1.L$3;
                        Iterable $this$map$iv4 = (Iterable) offlineCacheCardModelKt$searchResult$1.L$2;
                        Map historyCache3 = (Map) offlineCacheCardModelKt$searchResult$1.L$1;
                        List $this$searchResult2 = (List) offlineCacheCardModelKt$searchResult$1.L$0;
                        ResultKt.throwOnFailure($result7);
                        historyCache2 = historyCache3;
                        $this$searchResult = $this$searchResult2;
                        group2 = (List) offlineCacheCardModelKt$searchResult$1.L$7;
                        $completion2 = continuation;
                        title2 = (String) offlineCacheCardModelKt$searchResult$1.L$9;
                        first2 = (OfflineVideoEntity) offlineCacheCardModelKt$searchResult$1.L$10;
                        item$iv$iv = item$iv$iv3;
                        item$iv$iv2 = coroutine_suspended;
                        $this$map$iv = $this$map$iv4;
                        id2 = (String) offlineCacheCardModelKt$searchResult$1.L$8;
                        i3 = i5;
                        $result6 = $result7;
                        destination$iv$iv4 = (Collection) offlineCacheCardModelKt$searchResult$1.L$11;
                        subTitle = (String) $result7;
                        totalSize = totalSize2;
                        first = first2;
                        i2 = i3;
                        title = title2;
                        destination$iv$iv2 = destination$iv$iv3;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                        id = id2;
                        group = group2;
                        $result4 = $result6;
                        collection = destination$iv$iv4;
                        $result5 = $this$map$iv;
                        $i$f$mapTo2 = $i$f$mapTo;
                        $i$f$map2 = $i$f$map;
                        it2 = it3;
                        $completion = $completion2;
                        obj2 = item$iv$iv2;
                        $this$map$iv2 = $this$searchResult;
                        offlineCacheCardModelKt$searchResult$13 = offlineCacheCardModelKt$searchResult$1;
                        historyCache = historyCache2;
                        String cover = first.getCover();
                        List $this$searchResult3 = $this$map$iv2;
                        String filePath = DiskFileImpl_androidKt.filePath(first, FileType.Cover.INSTANCE);
                        CardTag cardTag = getCardTag(first);
                        long j = i2 == 0 ? Duration.Companion.getZERO-UwyO8pc() : first.m2773getDurationUwyO8pc();
                        long j2 = (i2 == 0 && (duration = historyCache.get(Boxing.boxLong(first.getCid()))) != null) ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                        String fileSize = VBNumberExtKt.toFileSize(totalSize);
                        String author = i2 != 0 ? "" : first.getAuthor();
                        int i6 = 0;
                        for (OfflineVideoEntity it6 : group) {
                            i6 += it6.getDanmakuCount();
                        }
                        collection.add(new OfflineCachedCardModel(id, cover, filePath, cardTag, title, subTitle, j, j2, fileSize, author, i6, first.getLinkStr(), i2 != 0 ? false : first.isVip(), first.getBizType(), group, null));
                        $this$map$iv2 = $this$searchResult3;
                        $result3 = $completion;
                        $this$map$iv = $result5;
                        offlineCacheCardModelKt$searchResult$12 = offlineCacheCardModelKt$searchResult$13;
                        $result = $result4;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $result2 = obj2;
                        it = it2;
                        $i$f$mapTo = $i$f$mapTo2;
                        $i$f$map = $i$f$map2;
                        destination$iv$iv = destination$iv$iv2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!it.hasNext()) {
                    item$iv$iv = it.next();
                    List<OfflineVideoEntity> group3 = (List) item$iv$iv;
                    Continuation $completion3 = $result3;
                    int i7 = group3.size() > 1 ? 1 : 0;
                    List $this$minBy$iv = group3;
                    Iterator iterator$iv = $this$minBy$iv.iterator();
                    if (!iterator$iv.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object minElem$iv = iterator$iv.next();
                    if (iterator$iv.hasNext()) {
                        OfflineVideoEntity it7 = (OfflineVideoEntity) minElem$iv;
                        long minValue$iv = it7.getVideoIndex();
                        while (true) {
                            Object e$iv = iterator$iv.next();
                            OfflineVideoEntity it8 = (OfflineVideoEntity) e$iv;
                            long v$iv = it8.getVideoIndex();
                            if (minValue$iv > v$iv) {
                                minElem$iv = e$iv;
                                minValue$iv = v$iv;
                            }
                            if (iterator$iv.hasNext()) {
                                List $this$searchResult4 = $this$map$iv2;
                                $this$map$iv2 = $this$searchResult4;
                                $result2 = $result2;
                                historyCache = historyCache;
                            }
                        }
                    }
                    first = (OfflineVideoEntity) minElem$iv;
                    Object $result8 = $result;
                    String id3 = String.valueOf(first.getGroupId());
                    long j3 = 0;
                    for (OfflineVideoEntity it9 : group3) {
                        j3 += it9.getTotalSize();
                    }
                    long totalSize3 = j3;
                    if (i7 != 0) {
                        groupTitle = first.getGroupTitle();
                        obj = $result2;
                        i = 0;
                    } else {
                        obj = $result2;
                        i = 0;
                        if (first.getBizType() == OfflineVideoEntity.BizType.OGV) {
                            groupTitle = first.getGroupTitle();
                        } else if (first.hitAttr(OfflineVideoEntity.VideoAttr.DramaVideo)) {
                            String videoTitle = first.getVideoTitle();
                            if (StringsKt.isBlank(videoTitle)) {
                                videoTitle = first.getGroupTitle();
                            }
                            groupTitle = videoTitle;
                        } else {
                            groupTitle = first.getGroupTitle();
                        }
                    }
                    String title3 = groupTitle;
                    if (i7 != 0) {
                        title = title3;
                        i2 = i7;
                        group = group3;
                        totalSize = totalSize3;
                        collection = destination$iv$iv;
                        destination$iv$iv2 = collection;
                        $i$f$mapTo2 = $i$f$mapTo;
                        $i$f$map2 = $i$f$map;
                        obj2 = obj;
                        subTitle = null;
                        it2 = it;
                        $result4 = $result8;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                        id = id3;
                        offlineCacheCardModelKt$searchResult$13 = offlineCacheCardModelKt$searchResult$12;
                        $result5 = $this$map$iv;
                        $completion = $completion3;
                    } else {
                        int i8 = i7;
                        if (first.getBizType() == OfflineVideoEntity.BizType.OGV) {
                            offlineCacheCardModelKt$searchResult$12.L$0 = SpillingKt.nullOutSpilledVariable($this$map$iv2);
                            offlineCacheCardModelKt$searchResult$12.L$1 = historyCache;
                            offlineCacheCardModelKt$searchResult$12.L$2 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                            offlineCacheCardModelKt$searchResult$12.L$3 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                            offlineCacheCardModelKt$searchResult$12.L$4 = destination$iv$iv;
                            offlineCacheCardModelKt$searchResult$12.L$5 = it;
                            offlineCacheCardModelKt$searchResult$12.L$6 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                            offlineCacheCardModelKt$searchResult$12.L$7 = group3;
                            offlineCacheCardModelKt$searchResult$12.L$8 = id3;
                            offlineCacheCardModelKt$searchResult$12.L$9 = title3;
                            offlineCacheCardModelKt$searchResult$12.L$10 = first;
                            offlineCacheCardModelKt$searchResult$12.L$11 = destination$iv$iv;
                            offlineCacheCardModelKt$searchResult$12.I$0 = $i$f$map;
                            offlineCacheCardModelKt$searchResult$12.I$1 = $i$f$mapTo;
                            int i9 = i;
                            offlineCacheCardModelKt$searchResult$12.I$2 = i9;
                            i3 = i8;
                            offlineCacheCardModelKt$searchResult$12.I$3 = i3;
                            $this$searchResult = $this$map$iv2;
                            historyCache2 = historyCache;
                            offlineCacheCardModelKt$searchResult$12.J$0 = totalSize3;
                            offlineCacheCardModelKt$searchResult$12.label = 1;
                            Object displaySubtitle = first.getDisplaySubtitle(offlineCacheCardModelKt$searchResult$12);
                            Object obj3 = obj;
                            if (displaySubtitle == obj3) {
                                return obj3;
                            }
                            id2 = id3;
                            $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            group2 = group3;
                            item$iv$iv2 = obj3;
                            offlineCacheCardModelKt$searchResult$1 = offlineCacheCardModelKt$searchResult$12;
                            title2 = title3;
                            $result6 = $result8;
                            first2 = first;
                            $result7 = displaySubtitle;
                            $completion2 = $completion3;
                            Iterator it10 = it;
                            i4 = i9;
                            totalSize2 = totalSize3;
                            it3 = it10;
                            destination$iv$iv3 = destination$iv$iv;
                            destination$iv$iv4 = destination$iv$iv;
                            subTitle = (String) $result7;
                            totalSize = totalSize2;
                            first = first2;
                            i2 = i3;
                            title = title2;
                            destination$iv$iv2 = destination$iv$iv3;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                            id = id2;
                            group = group2;
                            $result4 = $result6;
                            collection = destination$iv$iv4;
                            $result5 = $this$map$iv;
                            $i$f$mapTo2 = $i$f$mapTo;
                            $i$f$map2 = $i$f$map;
                            it2 = it3;
                            $completion = $completion2;
                            obj2 = item$iv$iv2;
                            $this$map$iv2 = $this$searchResult;
                            offlineCacheCardModelKt$searchResult$13 = offlineCacheCardModelKt$searchResult$1;
                            historyCache = historyCache2;
                        } else {
                            List $this$searchResult5 = $this$map$iv2;
                            Map historyCache4 = historyCache;
                            Object obj4 = obj;
                            subTitle = first.getPageTitle();
                            title = title3;
                            i2 = i8;
                            group = group3;
                            totalSize = totalSize3;
                            $this$map$iv2 = $this$searchResult5;
                            $result4 = $result8;
                            collection = destination$iv$iv;
                            destination$iv$iv2 = collection;
                            $i$f$mapTo2 = $i$f$mapTo;
                            $i$f$map2 = $i$f$map;
                            obj2 = obj4;
                            it2 = it;
                            historyCache = historyCache4;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                            id = id3;
                            offlineCacheCardModelKt$searchResult$13 = offlineCacheCardModelKt$searchResult$12;
                            $result5 = $this$map$iv;
                            $completion = $completion3;
                        }
                    }
                    String cover2 = first.getCover();
                    List $this$searchResult32 = $this$map$iv2;
                    String filePath2 = DiskFileImpl_androidKt.filePath(first, FileType.Cover.INSTANCE);
                    CardTag cardTag2 = getCardTag(first);
                    long j4 = i2 == 0 ? Duration.Companion.getZERO-UwyO8pc() : first.m2773getDurationUwyO8pc();
                    if (i2 == 0) {
                        long j22 = (i2 == 0 && (duration = historyCache.get(Boxing.boxLong(first.getCid()))) != null) ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                        String fileSize2 = VBNumberExtKt.toFileSize(totalSize);
                        String author2 = i2 != 0 ? "" : first.getAuthor();
                        int i62 = 0;
                        while (r0.hasNext()) {
                        }
                        collection.add(new OfflineCachedCardModel(id, cover2, filePath2, cardTag2, title, subTitle, j4, j22, fileSize2, author2, i62, first.getLinkStr(), i2 != 0 ? false : first.isVip(), first.getBizType(), group, null));
                        $this$map$iv2 = $this$searchResult32;
                        $result3 = $completion;
                        $this$map$iv = $result5;
                        offlineCacheCardModelKt$searchResult$12 = offlineCacheCardModelKt$searchResult$13;
                        $result = $result4;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $result2 = obj2;
                        it = it2;
                        $i$f$mapTo = $i$f$mapTo2;
                        $i$f$map = $i$f$map2;
                        destination$iv$iv = destination$iv$iv2;
                        if (!it.hasNext()) {
                            return (List) destination$iv$iv;
                        }
                    }
                    long j222 = (i2 == 0 && (duration = historyCache.get(Boxing.boxLong(first.getCid()))) != null) ? duration.unbox-impl() : Duration.Companion.getZERO-UwyO8pc();
                    String fileSize22 = VBNumberExtKt.toFileSize(totalSize);
                    String author22 = i2 != 0 ? "" : first.getAuthor();
                    int i622 = 0;
                    while (r0.hasNext()) {
                    }
                    collection.add(new OfflineCachedCardModel(id, cover2, filePath2, cardTag2, title, subTitle, j4, j222, fileSize22, author22, i622, first.getLinkStr(), i2 != 0 ? false : first.isVip(), first.getBizType(), group, null));
                    $this$map$iv2 = $this$searchResult32;
                    $result3 = $completion;
                    $this$map$iv = $result5;
                    offlineCacheCardModelKt$searchResult$12 = offlineCacheCardModelKt$searchResult$13;
                    $result = $result4;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $result2 = obj2;
                    it = it2;
                    $i$f$mapTo = $i$f$mapTo2;
                    $i$f$map = $i$f$map2;
                    destination$iv$iv = destination$iv$iv2;
                    if (!it.hasNext()) {
                    }
                }
            }
        }
        offlineCacheCardModelKt$searchResult$1 = new OfflineCacheCardModelKt$searchResult$1(continuation);
        Object $result72 = offlineCacheCardModelKt$searchResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineCacheCardModelKt$searchResult$1.label) {
        }
        if (!it.hasNext()) {
        }
    }

    public static /* synthetic */ Object searchResult$default(List list, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return searchResult(list, map, continuation);
    }

    public static final Object getHistoryProgress(OfflineVideoEntity $this$getHistoryProgress, Continuation<? super Duration> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new OfflineCacheCardModelKt$getHistoryProgress$2($this$getHistoryProgress, null), continuation);
    }

    /* renamed from: formatPlayTime-LRDsOJo  reason: not valid java name */
    public static final String m2788formatPlayTimeLRDsOJo(long j) {
        return VBNumberExtKt.formatPlayTime$default(Duration.getInWholeMilliseconds-impl(j), false, false, false, 7, null);
    }

    public static final CardTag getCardTag(OfflineVideoEntity $this$getCardTag) {
        Intrinsics.checkNotNullParameter($this$getCardTag, "<this>");
        if ($this$getCardTag.hitAttr(OfflineVideoEntity.VideoAttr.ChargingPay)) {
            return CardTag.CHARGE;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$getCardTag.getSeasonType().ordinal()]) {
            case 1:
                return CardTag.BANGUMI;
            case 2:
                return CardTag.MOVIE;
            case 3:
                return CardTag.DOCUMENTARY;
            case 4:
                return CardTag.CN_BANGUMI;
            case 5:
                return CardTag.TV_SERIES;
            case 6:
                return CardTag.VARIETY;
            default:
                return CardTag.NONE;
        }
    }
}