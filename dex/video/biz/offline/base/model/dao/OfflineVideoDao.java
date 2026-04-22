package video.biz.offline.base.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineVideoDao.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H§@¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fH'J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH'J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0014J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH'J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0019\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f2\u0006\u0010\u0019\u001a\u00020\u0011H'J\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H'J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\nH§@¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0005H§@¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u000eJ\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0012\u001a\u00020\nH§@¢\u0006\u0002\u0010\u001fJ$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H§@¢\u0006\u0002\u0010)J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0011H§@¢\u0006\u0002\u0010)J\u001c\u0010+\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H§@¢\u0006\u0002\u0010\u0007J\u000e\u0010,\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0006H§@¢\u0006\u0002\u0010/J\u001c\u0010-\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u001c\u00101\u001a\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0005H\u0097@¢\u0006\u0002\u0010\u0007¨\u00064À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/model/dao/OfflineVideoDao;", "", "insert", "", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByKeys", "keys", "", "getAllAsFlow", "Lkotlinx/coroutines/flow/Flow;", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoFlowsByGroupId", "groupId", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "getVideosByGroupId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByVideoId", "videoId", "getVideosFlowByVideoId", "getVideosByPageId", "pageId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByPageId", "getVideoFlowsByKeys", "getVideoByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnDownloadFilterVideos", "limit", "", "filterState", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadedVideos", "getDownloadingVideos", "search", "searchWithGroupId", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchWithVideoId", "deleteByKeys", "deleteAll", "update", "item", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "updateVerificationCodeBatch", "updates", "Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineVideoDao {
    Object deleteAll(Continuation<? super Unit> continuation);

    Object deleteByKeys(List<String> list, Continuation<? super Unit> continuation);

    Object getAll(Continuation<? super List<OfflineVideoEntity>> continuation);

    Flow<List<OfflineVideoEntity>> getAllAsFlow();

    Object getDownloadedVideos(Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getDownloadingVideos(Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getUnDownloadFilterVideos(int i, List<Integer> list, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideoByKey(String str, Continuation<? super OfflineVideoEntity> continuation);

    Flow<List<OfflineVideoEntity>> getVideoFlowsByGroupId(long j, String str);

    Flow<List<OfflineVideoEntity>> getVideoFlowsByKeys(List<String> list);

    Object getVideosByGroupId(long j, String str, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideosByKeys(List<String> list, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideosByPageId(long j, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideosByVideoId(long j, String str, Continuation<? super List<OfflineVideoEntity>> continuation);

    Flow<List<OfflineVideoEntity>> getVideosFlowByPageId(long j);

    Flow<List<OfflineVideoEntity>> getVideosFlowByVideoId(long j, String str);

    Object insert(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation);

    Object search(String str, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object searchWithGroupId(String str, long j, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object searchWithVideoId(String str, long j, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object update(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation);

    Object update(OfflineVideoEntity offlineVideoEntity, Continuation<? super Unit> continuation);

    Object updateVerificationCodeBatch(List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation);

    /* compiled from: OfflineVideoDao.kt */
    /* renamed from: video.biz.offline.base.model.dao.OfflineVideoDao$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object getUnDownloadFilterVideos$default(OfflineVideoDao offlineVideoDao, int i, List list, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                return offlineVideoDao.getUnDownloadFilterVideos(i, list, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUnDownloadFilterVideos");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01a6  */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.util.Map] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object updateVerificationCodeBatch$suspendImpl(OfflineVideoDao $this, List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation) {
            OfflineVideoDao$updateVerificationCodeBatch$1 offlineVideoDao$updateVerificationCodeBatch$1;
            LinkedHashMap linkedHashMap;
            Object obj;
            List<OfflineAuthUpdate> list2;
            List updatedVideos;
            OfflineVideoDao $this2 = $this;
            if (continuation instanceof OfflineVideoDao$updateVerificationCodeBatch$1) {
                offlineVideoDao$updateVerificationCodeBatch$1 = (OfflineVideoDao$updateVerificationCodeBatch$1) continuation;
                if ((offlineVideoDao$updateVerificationCodeBatch$1.label & Integer.MIN_VALUE) != 0) {
                    offlineVideoDao$updateVerificationCodeBatch$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineVideoDao$updateVerificationCodeBatch$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineVideoDao$updateVerificationCodeBatch$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            List<OfflineAuthUpdate> $this$associateBy$iv = list;
                            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap(capacity$iv);
                            for (Object element$iv$iv : $this$associateBy$iv) {
                                OfflineAuthUpdate it = (OfflineAuthUpdate) element$iv$iv;
                                linkedHashMap2.put(it.getKey(), element$iv$iv);
                            }
                            offlineVideoDao$updateVerificationCodeBatch$1.L$0 = $this2;
                            offlineVideoDao$updateVerificationCodeBatch$1.L$1 = SpillingKt.nullOutSpilledVariable(list);
                            offlineVideoDao$updateVerificationCodeBatch$1.L$2 = linkedHashMap2;
                            offlineVideoDao$updateVerificationCodeBatch$1.label = 1;
                            Object all = $this2.getAll(offlineVideoDao$updateVerificationCodeBatch$1);
                            if (all == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            linkedHashMap = linkedHashMap2;
                            obj = all;
                            list2 = list;
                            Iterable allVideos = (List) obj;
                            Iterable $this$mapNotNull$iv = allVideos;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                OfflineVideoEntity video2 = (OfflineVideoEntity) element$iv$iv$iv;
                                OfflineAuthUpdate update = (OfflineAuthUpdate) linkedHashMap.get(video2.getKey());
                                OfflineVideoEntity m2770copyQZD5vYk$default = update != null ? OfflineVideoEntity.m2770copyQZD5vYk$default(video2, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, 0L, null, 0L, null, null, null, 0L, null, 0L, 0L, 0L, 0L, 0, 0, 0, null, null, null, null, null, 0, 0, 0L, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, null, update.getCode(), null, null, null, null, -1, 31743, null) : null;
                                if (m2770copyQZD5vYk$default != null) {
                                    destination$iv$iv.add(m2770copyQZD5vYk$default);
                                }
                            }
                            updatedVideos = (List) destination$iv$iv;
                            if (updatedVideos.isEmpty()) {
                                offlineVideoDao$updateVerificationCodeBatch$1.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                                offlineVideoDao$updateVerificationCodeBatch$1.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                                offlineVideoDao$updateVerificationCodeBatch$1.L$2 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                offlineVideoDao$updateVerificationCodeBatch$1.L$3 = SpillingKt.nullOutSpilledVariable(allVideos);
                                offlineVideoDao$updateVerificationCodeBatch$1.L$4 = SpillingKt.nullOutSpilledVariable(updatedVideos);
                                offlineVideoDao$updateVerificationCodeBatch$1.label = 2;
                                return $this2.update((List<OfflineVideoEntity>) updatedVideos, (Continuation<? super Unit>) offlineVideoDao$updateVerificationCodeBatch$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            list2 = (List) offlineVideoDao$updateVerificationCodeBatch$1.L$1;
                            $this2 = (OfflineVideoDao) offlineVideoDao$updateVerificationCodeBatch$1.L$0;
                            ResultKt.throwOnFailure($result);
                            linkedHashMap = (Map) offlineVideoDao$updateVerificationCodeBatch$1.L$2;
                            obj = $result;
                            Iterable allVideos2 = (List) obj;
                            Iterable $this$mapNotNull$iv2 = allVideos2;
                            Collection destination$iv$iv2 = new ArrayList();
                            while (r15.hasNext()) {
                            }
                            updatedVideos = (List) destination$iv$iv2;
                            if (updatedVideos.isEmpty()) {
                            }
                            break;
                        case 2:
                            List list3 = (List) offlineVideoDao$updateVerificationCodeBatch$1.L$4;
                            List list4 = (List) offlineVideoDao$updateVerificationCodeBatch$1.L$3;
                            Map map = (Map) offlineVideoDao$updateVerificationCodeBatch$1.L$2;
                            List list5 = (List) offlineVideoDao$updateVerificationCodeBatch$1.L$1;
                            OfflineVideoDao offlineVideoDao = (OfflineVideoDao) offlineVideoDao$updateVerificationCodeBatch$1.L$0;
                            ResultKt.throwOnFailure($result);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            offlineVideoDao$updateVerificationCodeBatch$1 = new OfflineVideoDao$updateVerificationCodeBatch$1($this2, continuation);
            Object $result2 = offlineVideoDao$updateVerificationCodeBatch$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (offlineVideoDao$updateVerificationCodeBatch$1.label) {
            }
        }
    }

    /* compiled from: OfflineVideoDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object updateVerificationCodeBatch(OfflineVideoDao $this, List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation) {
            return CC.updateVerificationCodeBatch$suspendImpl($this, list, continuation);
        }
    }
}