package video.biz.offline.base.facade.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.facade.model.OfflinePlayListModel;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.AuthCode;
import video.biz.offline.base.model.model.AuthCodeKt;

/* compiled from: OfflinePlayListViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@¢\u0006\u0002\u0010\u0007J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/base/facade/viewmodel/OfflinePlayListViewModel;", "", "<init>", "()V", "getDownloadedVideos", "", "Lvideo/biz/offline/base/facade/model/OfflinePlayListModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadingVideos", "resolvePLModel", "downloading", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayTitle", "", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePlayListViewModel {
    public static final int $stable = 0;

    /* compiled from: OfflinePlayListViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.BizType.values().length];
            try {
                iArr[OfflineVideoEntity.BizType.OGV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Object getDownloadedVideos(Continuation<? super List<OfflinePlayListModel>> continuation) {
        return resolvePLModel(false, continuation);
    }

    public final Object getDownloadingVideos(Continuation<? super List<OfflinePlayListModel>> continuation) {
        return resolvePLModel(true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolvePLModel(boolean downloading, Continuation<? super List<OfflinePlayListModel>> continuation) {
        Continuation<? super List<OfflineVideoEntity>> offlinePlayListViewModel$resolvePLModel$1;
        Object downloadedVideos;
        Object unDownloadVideos;
        List destination$iv$iv;
        boolean downloading2;
        Iterable $this$onEach$iv;
        OfflinePlayListViewModel$resolvePLModel$1 offlinePlayListViewModel$resolvePLModel$12;
        Object $result;
        List videos;
        int $i$f$onEach;
        boolean z;
        boolean z2;
        Object $result2;
        ArrayList arrayList;
        Iterable $this$groupBy$iv;
        ArrayList arrayList2;
        final boolean downloading3 = downloading;
        if (continuation instanceof OfflinePlayListViewModel$resolvePLModel$1) {
            offlinePlayListViewModel$resolvePLModel$1 = (OfflinePlayListViewModel$resolvePLModel$1) continuation;
            if ((offlinePlayListViewModel$resolvePLModel$1.label & Integer.MIN_VALUE) != 0) {
                offlinePlayListViewModel$resolvePLModel$1.label -= Integer.MIN_VALUE;
                Object $result3 = offlinePlayListViewModel$resolvePLModel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlinePlayListViewModel$resolvePLModel$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        if (!downloading3) {
                            IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            offlinePlayListViewModel$resolvePLModel$1.Z$0 = downloading3;
                            offlinePlayListViewModel$resolvePLModel$1.label = 2;
                            downloadedVideos = offlineFacadeImpl.getDownloadedVideos(offlinePlayListViewModel$resolvePLModel$1);
                            if (downloadedVideos == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            destination$iv$iv = (List) downloadedVideos;
                            List videos2 = destination$iv$iv;
                            List result = new ArrayList();
                            List $this$filterNot$iv = videos2;
                            Collection destination$iv$iv2 = new ArrayList();
                            while (r13.hasNext()) {
                            }
                            Iterable $this$groupBy$iv2 = (List) destination$iv$iv2;
                            Map destination$iv$iv3 = new LinkedHashMap();
                            while (r11.hasNext()) {
                            }
                            Iterable $this$sortedBy$iv = CollectionsKt.toList(destination$iv$iv3.values());
                            Iterable $this$onEach$iv2 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$$inlined$sortedBy$1
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    long updateTime;
                                    long updateTime2;
                                    List group = (List) t;
                                    if (downloading3) {
                                        Iterator<T> it = group.iterator();
                                        if (!it.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        OfflineVideoEntity it2 = (OfflineVideoEntity) it.next();
                                        updateTime = it2.getCreateTime();
                                        while (it.hasNext()) {
                                            OfflineVideoEntity it3 = (OfflineVideoEntity) it.next();
                                            long createTime = it3.getCreateTime();
                                            if (updateTime < createTime) {
                                                updateTime = createTime;
                                            }
                                        }
                                    } else {
                                        Iterator<T> it4 = group.iterator();
                                        if (!it4.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        OfflineVideoEntity it5 = (OfflineVideoEntity) it4.next();
                                        updateTime = it5.getUpdateTime();
                                        while (it4.hasNext()) {
                                            OfflineVideoEntity it6 = (OfflineVideoEntity) it4.next();
                                            long updateTime3 = it6.getUpdateTime();
                                            if (updateTime < updateTime3) {
                                                updateTime = updateTime3;
                                            }
                                        }
                                    }
                                    Long valueOf = Long.valueOf(-updateTime);
                                    List group2 = (List) t2;
                                    if (downloading3) {
                                        Iterator<T> it7 = group2.iterator();
                                        if (!it7.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        OfflineVideoEntity it8 = (OfflineVideoEntity) it7.next();
                                        updateTime2 = it8.getCreateTime();
                                        while (it7.hasNext()) {
                                            OfflineVideoEntity it9 = (OfflineVideoEntity) it7.next();
                                            long createTime2 = it9.getCreateTime();
                                            if (updateTime2 < createTime2) {
                                                updateTime2 = createTime2;
                                            }
                                        }
                                    } else {
                                        Iterator<T> it10 = group2.iterator();
                                        if (!it10.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        OfflineVideoEntity it11 = (OfflineVideoEntity) it10.next();
                                        updateTime2 = it11.getUpdateTime();
                                        while (it10.hasNext()) {
                                            OfflineVideoEntity it12 = (OfflineVideoEntity) it10.next();
                                            long updateTime4 = it12.getUpdateTime();
                                            if (updateTime2 < updateTime4) {
                                                updateTime2 = updateTime4;
                                            }
                                        }
                                    }
                                    return ComparisonsKt.compareValues(valueOf, Long.valueOf(-updateTime2));
                                }
                            });
                            int $i$f$onEach2 = 0;
                            while (r10.hasNext()) {
                            }
                            return result;
                        }
                        IOfflineFacade offlineFacadeImpl2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                        offlinePlayListViewModel$resolvePLModel$1.Z$0 = downloading3;
                        offlinePlayListViewModel$resolvePLModel$1.label = 1;
                        unDownloadVideos = offlineFacadeImpl2.getUnDownloadVideos(true, true, offlinePlayListViewModel$resolvePLModel$1);
                        if (unDownloadVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Iterable $this$filter$iv = (Iterable) unDownloadVideos;
                        Collection destination$iv$iv4 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            if (((OfflineVideoEntity) element$iv$iv).getCanPlay()) {
                                destination$iv$iv4.add(element$iv$iv);
                            }
                        }
                        destination$iv$iv = (List) destination$iv$iv4;
                        List videos22 = destination$iv$iv;
                        List result2 = new ArrayList();
                        List $this$filterNot$iv2 = videos22;
                        Collection destination$iv$iv22 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filterNot$iv2) {
                            if (!ArraysKt.contains(AuthCodeKt.getForbiddenAuthCodeArray(), AuthCodeKt.toAuthCode(((OfflineVideoEntity) element$iv$iv2).getAuthCode()))) {
                                destination$iv$iv22.add(element$iv$iv2);
                            }
                        }
                        Iterable $this$groupBy$iv22 = (List) destination$iv$iv22;
                        Map destination$iv$iv32 = new LinkedHashMap();
                        for (Object element$iv$iv3 : $this$groupBy$iv22) {
                            Long boxLong = Boxing.boxLong(((OfflineVideoEntity) element$iv$iv3).getGroupId());
                            Object value$iv$iv$iv = destination$iv$iv32.get(boxLong);
                            if (value$iv$iv$iv == null) {
                                $this$groupBy$iv = $this$groupBy$iv22;
                                arrayList2 = new ArrayList();
                                destination$iv$iv32.put(boxLong, arrayList2);
                            } else {
                                $this$groupBy$iv = $this$groupBy$iv22;
                                arrayList2 = value$iv$iv$iv;
                            }
                            List list$iv$iv = (List) arrayList2;
                            list$iv$iv.add(element$iv$iv3);
                            $this$groupBy$iv22 = $this$groupBy$iv;
                        }
                        Iterable $this$sortedBy$iv2 = CollectionsKt.toList(destination$iv$iv32.values());
                        Iterable $this$onEach$iv22 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                long updateTime;
                                long updateTime2;
                                List group = (List) t;
                                if (downloading3) {
                                    Iterator<T> it = group.iterator();
                                    if (!it.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it2 = (OfflineVideoEntity) it.next();
                                    updateTime = it2.getCreateTime();
                                    while (it.hasNext()) {
                                        OfflineVideoEntity it3 = (OfflineVideoEntity) it.next();
                                        long createTime = it3.getCreateTime();
                                        if (updateTime < createTime) {
                                            updateTime = createTime;
                                        }
                                    }
                                } else {
                                    Iterator<T> it4 = group.iterator();
                                    if (!it4.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it5 = (OfflineVideoEntity) it4.next();
                                    updateTime = it5.getUpdateTime();
                                    while (it4.hasNext()) {
                                        OfflineVideoEntity it6 = (OfflineVideoEntity) it4.next();
                                        long updateTime3 = it6.getUpdateTime();
                                        if (updateTime < updateTime3) {
                                            updateTime = updateTime3;
                                        }
                                    }
                                }
                                Long valueOf = Long.valueOf(-updateTime);
                                List group2 = (List) t2;
                                if (downloading3) {
                                    Iterator<T> it7 = group2.iterator();
                                    if (!it7.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it8 = (OfflineVideoEntity) it7.next();
                                    updateTime2 = it8.getCreateTime();
                                    while (it7.hasNext()) {
                                        OfflineVideoEntity it9 = (OfflineVideoEntity) it7.next();
                                        long createTime2 = it9.getCreateTime();
                                        if (updateTime2 < createTime2) {
                                            updateTime2 = createTime2;
                                        }
                                    }
                                } else {
                                    Iterator<T> it10 = group2.iterator();
                                    if (!it10.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it11 = (OfflineVideoEntity) it10.next();
                                    updateTime2 = it11.getUpdateTime();
                                    while (it10.hasNext()) {
                                        OfflineVideoEntity it12 = (OfflineVideoEntity) it10.next();
                                        long updateTime4 = it12.getUpdateTime();
                                        if (updateTime2 < updateTime4) {
                                            updateTime2 = updateTime4;
                                        }
                                    }
                                }
                                return ComparisonsKt.compareValues(valueOf, Long.valueOf(-updateTime2));
                            }
                        });
                        int $i$f$onEach22 = 0;
                        for (Object element$iv : $this$onEach$iv22) {
                            List<OfflineVideoEntity> group = (List) element$iv;
                            if (group.size() > 1) {
                                Map destination$iv$iv5 = new LinkedHashMap();
                                for (Object element$iv$iv4 : group) {
                                    boolean downloading4 = downloading3;
                                    Long boxLong2 = Boxing.boxLong(((OfflineVideoEntity) element$iv$iv4).getVideoId());
                                    Iterable $this$onEach$iv3 = $this$onEach$iv22;
                                    OfflinePlayListViewModel$resolvePLModel$1 offlinePlayListViewModel$resolvePLModel$13 = offlinePlayListViewModel$resolvePLModel$1;
                                    Object value$iv$iv$iv2 = destination$iv$iv5.get(boxLong2);
                                    if (value$iv$iv$iv2 == null) {
                                        arrayList = new ArrayList();
                                        $result2 = $result3;
                                        destination$iv$iv5.put(boxLong2, arrayList);
                                    } else {
                                        $result2 = $result3;
                                        arrayList = value$iv$iv$iv2;
                                    }
                                    Object key$iv$iv$iv = arrayList;
                                    List list$iv$iv2 = (List) key$iv$iv$iv;
                                    list$iv$iv2.add(element$iv$iv4);
                                    downloading3 = downloading4;
                                    offlinePlayListViewModel$resolvePLModel$1 = offlinePlayListViewModel$resolvePLModel$13;
                                    $this$onEach$iv22 = $this$onEach$iv3;
                                    $result3 = $result2;
                                }
                                downloading2 = downloading3;
                                $this$onEach$iv = $this$onEach$iv22;
                                offlinePlayListViewModel$resolvePLModel$12 = offlinePlayListViewModel$resolvePLModel$1;
                                $result = $result3;
                                Iterable $this$sortedBy$iv3 = CollectionsKt.toList(destination$iv$iv5.values());
                                List videoGroup = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$lambda$4$$inlined$sortedBy$1
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        List it = (List) t;
                                        List it2 = (List) t2;
                                        return ComparisonsKt.compareValues(Long.valueOf(((OfflineVideoEntity) CollectionsKt.first(it)).getVideoIndex()), Long.valueOf(((OfflineVideoEntity) CollectionsKt.first(it2)).getVideoIndex()));
                                    }
                                });
                                List $this$all$iv = videoGroup;
                                boolean z3 = false;
                                if (($this$all$iv instanceof Collection) && $this$all$iv.isEmpty()) {
                                    z = true;
                                } else {
                                    Iterator it = $this$all$iv.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            Object element$iv2 = it.next();
                                            Iterable $this$all$iv2 = $this$all$iv;
                                            boolean z4 = z3;
                                            if ((((List) element$iv2).size() == 1 ? 1 : null) == null) {
                                                z = false;
                                            } else {
                                                $this$all$iv = $this$all$iv2;
                                                z3 = z4;
                                            }
                                        } else {
                                            z = true;
                                        }
                                    }
                                }
                                if (z) {
                                    Iterator it2 = group.iterator();
                                    if (!it2.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    long pubTime = ((OfflineVideoEntity) it2.next()).getUpdateTime();
                                    while (it2.hasNext()) {
                                        long updateTime = ((OfflineVideoEntity) it2.next()).getUpdateTime();
                                        if (pubTime < updateTime) {
                                            pubTime = updateTime;
                                        }
                                    }
                                    List $this$sortedBy$iv4 = group;
                                    Iterable $this$onEach$iv4 = CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$lambda$4$$inlined$sortedBy$2
                                        @Override // java.util.Comparator
                                        public final int compare(T t, T t2) {
                                            OfflineVideoEntity it3 = (OfflineVideoEntity) t;
                                            OfflineVideoEntity it4 = (OfflineVideoEntity) t2;
                                            return ComparisonsKt.compareValues(Long.valueOf(it3.getVideoIndex()), Long.valueOf(it4.getVideoIndex()));
                                        }
                                    });
                                    boolean z5 = false;
                                    for (Object element$iv3 : $this$onEach$iv4) {
                                        OfflineVideoEntity it3 = (OfflineVideoEntity) element$iv3;
                                        boolean z6 = z5;
                                        List videos3 = videos22;
                                        OfflinePlayListModel drama = new OfflinePlayListModel(it3.getVideoAttr(), it3.getBizType(), 0, it3.getVideoId(), it3.getBvid(), getDisplayTitle(it3), "", it3.getCover(), Duration.toInt-impl(it3.m2773getDurationUwyO8pc(), DurationUnit.MILLISECONDS), it3.getAuthor(), it3.getLinkStr(), it3.isVip(), AuthCodeKt.toAuthCode(it3.getAuthCode()) == AuthCode.Pass, it3.getSeasonType(), pubTime, it3.getTotalSize(), CollectionsKt.listOf(it3), 4, null);
                                        result2.add(drama);
                                        videos22 = videos3;
                                        z5 = z6;
                                        $i$f$onEach22 = $i$f$onEach22;
                                    }
                                    videos = videos22;
                                    $i$f$onEach = $i$f$onEach22;
                                    List list = (List) $this$onEach$iv4;
                                } else {
                                    videos = videos22;
                                    $i$f$onEach = $i$f$onEach22;
                                    boolean z7 = false;
                                    Iterable $this$onEach_u24lambda_u240$iv = videoGroup;
                                    boolean z8 = false;
                                    for (Object element$iv4 : $this$onEach_u24lambda_u240$iv) {
                                        List videos4 = (List) element$iv4;
                                        Iterator it4 = videos4.iterator();
                                        if (!it4.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        long pubTime2 = ((OfflineVideoEntity) it4.next()).getUpdateTime();
                                        while (it4.hasNext()) {
                                            long updateTime2 = ((OfflineVideoEntity) it4.next()).getUpdateTime();
                                            if (pubTime2 < updateTime2) {
                                                pubTime2 = updateTime2;
                                            }
                                        }
                                        int duration = 0;
                                        for (OfflineVideoEntity it5 : group) {
                                            duration += Duration.toInt-impl(it5.m2773getDurationUwyO8pc(), DurationUnit.MILLISECONDS);
                                            z7 = z7;
                                            $this$onEach_u24lambda_u240$iv = $this$onEach_u24lambda_u240$iv;
                                            videoGroup = videoGroup;
                                        }
                                        List videoGroup2 = videoGroup;
                                        boolean z9 = z7;
                                        Iterable $this$onEach_u24lambda_u240$iv2 = $this$onEach_u24lambda_u240$iv;
                                        long volume = 0;
                                        for (OfflineVideoEntity it6 : group) {
                                            volume += it6.getTotalSize();
                                        }
                                        List $this$sortedBy$iv5 = videos4;
                                        List pages = CollectionsKt.sortedWith($this$sortedBy$iv5, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$lambda$4$6$$inlined$sortedBy$1
                                            @Override // java.util.Comparator
                                            public final int compare(T t, T t2) {
                                                OfflineVideoEntity it7 = (OfflineVideoEntity) t;
                                                OfflineVideoEntity it8 = (OfflineVideoEntity) t2;
                                                return ComparisonsKt.compareValues(Long.valueOf(it7.getPageIndex()), Long.valueOf(it8.getPageIndex()));
                                            }
                                        });
                                        OfflineVideoEntity it7 = (OfflineVideoEntity) CollectionsKt.firstOrNull(videos4);
                                        if (it7 != null) {
                                            z2 = z8;
                                            OfflinePlayListModel mulPage = new OfflinePlayListModel(it7.getVideoAttr(), it7.getBizType(), 0, it7.getVideoId(), it7.getBvid(), getDisplayTitle(it7), "", it7.getCover(), duration, it7.getAuthor(), it7.getLinkStr(), it7.isVip(), AuthCodeKt.toAuthCode(it7.getAuthCode()) == AuthCode.Pass, it7.getSeasonType(), pubTime2, volume, pages, 4, null);
                                            result2.add(mulPage);
                                            Unit unit = Unit.INSTANCE;
                                        } else {
                                            z2 = z8;
                                        }
                                        z8 = z2;
                                        z7 = z9;
                                        $this$onEach_u24lambda_u240$iv = $this$onEach_u24lambda_u240$iv2;
                                        videoGroup = videoGroup2;
                                    }
                                }
                            } else {
                                downloading2 = downloading3;
                                $this$onEach$iv = $this$onEach$iv22;
                                offlinePlayListViewModel$resolvePLModel$12 = offlinePlayListViewModel$resolvePLModel$1;
                                $result = $result3;
                                videos = videos22;
                                $i$f$onEach = $i$f$onEach22;
                                OfflineVideoEntity it8 = (OfflineVideoEntity) CollectionsKt.firstOrNull(group);
                                if (it8 != null) {
                                    OfflinePlayListModel item = new OfflinePlayListModel(it8.getVideoAttr(), it8.getBizType(), 0, it8.getVideoId(), it8.getBvid(), getDisplayTitle(it8), "", it8.getCover(), Duration.toInt-impl(it8.m2773getDurationUwyO8pc(), DurationUnit.MILLISECONDS), it8.getAuthor(), it8.getLinkStr(), it8.isVip(), AuthCodeKt.toAuthCode(it8.getAuthCode()) == AuthCode.Pass, it8.getSeasonType(), it8.getUpdateTime(), it8.getTotalSize(), CollectionsKt.listOf(it8), 4, null);
                                    result2.add(item);
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                            videos22 = videos;
                            downloading3 = downloading2;
                            offlinePlayListViewModel$resolvePLModel$1 = offlinePlayListViewModel$resolvePLModel$12;
                            $i$f$onEach22 = $i$f$onEach;
                            $this$onEach$iv22 = $this$onEach$iv;
                            $result3 = $result;
                        }
                        return result2;
                    case 1:
                        downloading3 = offlinePlayListViewModel$resolvePLModel$1.Z$0;
                        ResultKt.throwOnFailure($result3);
                        unDownloadVideos = $result3;
                        Iterable $this$filter$iv2 = (Iterable) unDownloadVideos;
                        Collection destination$iv$iv42 = new ArrayList();
                        while (r11.hasNext()) {
                        }
                        destination$iv$iv = (List) destination$iv$iv42;
                        List videos222 = destination$iv$iv;
                        List result22 = new ArrayList();
                        List $this$filterNot$iv22 = videos222;
                        Collection destination$iv$iv222 = new ArrayList();
                        while (r13.hasNext()) {
                        }
                        Iterable $this$groupBy$iv222 = (List) destination$iv$iv222;
                        Map destination$iv$iv322 = new LinkedHashMap();
                        while (r11.hasNext()) {
                        }
                        Iterable $this$sortedBy$iv22 = CollectionsKt.toList(destination$iv$iv322.values());
                        Iterable $this$onEach$iv222 = CollectionsKt.sortedWith($this$sortedBy$iv22, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                long updateTime3;
                                long updateTime22;
                                List group2 = (List) t;
                                if (downloading3) {
                                    Iterator<T> it9 = group2.iterator();
                                    if (!it9.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it22 = (OfflineVideoEntity) it9.next();
                                    updateTime3 = it22.getCreateTime();
                                    while (it9.hasNext()) {
                                        OfflineVideoEntity it32 = (OfflineVideoEntity) it9.next();
                                        long createTime = it32.getCreateTime();
                                        if (updateTime3 < createTime) {
                                            updateTime3 = createTime;
                                        }
                                    }
                                } else {
                                    Iterator<T> it42 = group2.iterator();
                                    if (!it42.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it52 = (OfflineVideoEntity) it42.next();
                                    updateTime3 = it52.getUpdateTime();
                                    while (it42.hasNext()) {
                                        OfflineVideoEntity it62 = (OfflineVideoEntity) it42.next();
                                        long updateTime32 = it62.getUpdateTime();
                                        if (updateTime3 < updateTime32) {
                                            updateTime3 = updateTime32;
                                        }
                                    }
                                }
                                Long valueOf = Long.valueOf(-updateTime3);
                                List group22 = (List) t2;
                                if (downloading3) {
                                    Iterator<T> it72 = group22.iterator();
                                    if (!it72.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it82 = (OfflineVideoEntity) it72.next();
                                    updateTime22 = it82.getCreateTime();
                                    while (it72.hasNext()) {
                                        OfflineVideoEntity it92 = (OfflineVideoEntity) it72.next();
                                        long createTime2 = it92.getCreateTime();
                                        if (updateTime22 < createTime2) {
                                            updateTime22 = createTime2;
                                        }
                                    }
                                } else {
                                    Iterator<T> it10 = group22.iterator();
                                    if (!it10.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it11 = (OfflineVideoEntity) it10.next();
                                    updateTime22 = it11.getUpdateTime();
                                    while (it10.hasNext()) {
                                        OfflineVideoEntity it12 = (OfflineVideoEntity) it10.next();
                                        long updateTime4 = it12.getUpdateTime();
                                        if (updateTime22 < updateTime4) {
                                            updateTime22 = updateTime4;
                                        }
                                    }
                                }
                                return ComparisonsKt.compareValues(valueOf, Long.valueOf(-updateTime22));
                            }
                        });
                        int $i$f$onEach222 = 0;
                        while (r10.hasNext()) {
                        }
                        return result22;
                    case 2:
                        downloading3 = offlinePlayListViewModel$resolvePLModel$1.Z$0;
                        ResultKt.throwOnFailure($result3);
                        downloadedVideos = $result3;
                        destination$iv$iv = (List) downloadedVideos;
                        List videos2222 = destination$iv$iv;
                        List result222 = new ArrayList();
                        List $this$filterNot$iv222 = videos2222;
                        Collection destination$iv$iv2222 = new ArrayList();
                        while (r13.hasNext()) {
                        }
                        Iterable $this$groupBy$iv2222 = (List) destination$iv$iv2222;
                        Map destination$iv$iv3222 = new LinkedHashMap();
                        while (r11.hasNext()) {
                        }
                        Iterable $this$sortedBy$iv222 = CollectionsKt.toList(destination$iv$iv3222.values());
                        Iterable $this$onEach$iv2222 = CollectionsKt.sortedWith($this$sortedBy$iv222, new Comparator() { // from class: video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel$resolvePLModel$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                long updateTime3;
                                long updateTime22;
                                List group2 = (List) t;
                                if (downloading3) {
                                    Iterator<T> it9 = group2.iterator();
                                    if (!it9.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it22 = (OfflineVideoEntity) it9.next();
                                    updateTime3 = it22.getCreateTime();
                                    while (it9.hasNext()) {
                                        OfflineVideoEntity it32 = (OfflineVideoEntity) it9.next();
                                        long createTime = it32.getCreateTime();
                                        if (updateTime3 < createTime) {
                                            updateTime3 = createTime;
                                        }
                                    }
                                } else {
                                    Iterator<T> it42 = group2.iterator();
                                    if (!it42.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it52 = (OfflineVideoEntity) it42.next();
                                    updateTime3 = it52.getUpdateTime();
                                    while (it42.hasNext()) {
                                        OfflineVideoEntity it62 = (OfflineVideoEntity) it42.next();
                                        long updateTime32 = it62.getUpdateTime();
                                        if (updateTime3 < updateTime32) {
                                            updateTime3 = updateTime32;
                                        }
                                    }
                                }
                                Long valueOf = Long.valueOf(-updateTime3);
                                List group22 = (List) t2;
                                if (downloading3) {
                                    Iterator<T> it72 = group22.iterator();
                                    if (!it72.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it82 = (OfflineVideoEntity) it72.next();
                                    updateTime22 = it82.getCreateTime();
                                    while (it72.hasNext()) {
                                        OfflineVideoEntity it92 = (OfflineVideoEntity) it72.next();
                                        long createTime2 = it92.getCreateTime();
                                        if (updateTime22 < createTime2) {
                                            updateTime22 = createTime2;
                                        }
                                    }
                                } else {
                                    Iterator<T> it10 = group22.iterator();
                                    if (!it10.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    OfflineVideoEntity it11 = (OfflineVideoEntity) it10.next();
                                    updateTime22 = it11.getUpdateTime();
                                    while (it10.hasNext()) {
                                        OfflineVideoEntity it12 = (OfflineVideoEntity) it10.next();
                                        long updateTime4 = it12.getUpdateTime();
                                        if (updateTime22 < updateTime4) {
                                            updateTime22 = updateTime4;
                                        }
                                    }
                                }
                                return ComparisonsKt.compareValues(valueOf, Long.valueOf(-updateTime22));
                            }
                        });
                        int $i$f$onEach2222 = 0;
                        while (r10.hasNext()) {
                        }
                        return result222;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlinePlayListViewModel$resolvePLModel$1 = new OfflinePlayListViewModel$resolvePLModel$1(this, continuation);
        Object $result32 = offlinePlayListViewModel$resolvePLModel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlinePlayListViewModel$resolvePLModel$1.label) {
        }
    }

    private final String getDisplayTitle(OfflineVideoEntity entity) {
        return WhenMappings.$EnumSwitchMapping$0[entity.getBizType().ordinal()] == 1 ? entity.getGroupTitle() : entity.getVideoTitle();
    }
}