package video.biz.offline.base.infra.storage.diskfile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModelKt;
import video.biz.offline.base.infra.storage.diskfile.model.DramaItemModel;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: FileDataStorage.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u0013H\u0087@¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0083@¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0083@¢\u0006\u0002\u0010\u0014J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001bH\u0007J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0007J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!J$\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0007J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!J\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001b2\u0006\u0010'\u001a\u00020\u000bH\u0007J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010'\u001a\u00020\u000bJ\u0010\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020!J\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020!0\u0005J&\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020\u0013J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010 \u001a\u00020!J\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020!0\u0005J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0016\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0005H\u0007J\u0016\u0010<\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileDataStorage;", "", "<init>", "()V", "cachedVideos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getCachedVideos", "()Ljava/util/List;", "cachedDramas", "", "", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "getCachedDramas", "()Ljava/util/Map;", "dataContentFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileDataContent;", "loadLocalVideos", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDramaMap", "resolveDramas", "videos", "loadLocalEntitiesWithTrack", "loadLocalDramasWithTrack", "addVideos", "Lkotlinx/coroutines/flow/Flow;", "getAllVideosFlow", "getAllVideos", "getVideosFlowByGroupId", "groupId", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "getVideosByGroupId", "getVideosFlowByVideoId", "videoId", "getVideosByVideoId", "getVideosFlowByPageId", "pageId", "getVideosByPageId", "getVideoByKey", "key", "getVideosByKeys", "keys", "getUnDownloadVideos", "includePause", "", "includeError", "limit", "getDownloadedVideos", "getDownloadingVideos", "search", "removeVideo", "ids", "removeDramas", "updateAuthCode", "", "list", "Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "updateVideo", "updates", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FileDataStorage {
    public static final int $stable = 8;
    private final MutableStateFlow<FileDataContent> dataContentFlow = StateFlowKt.MutableStateFlow(new FileDataContent(null, null, null, 7, null));

    private final List<OfflineVideoEntity> getCachedVideos() {
        return ((FileDataContent) this.dataContentFlow.getValue()).getVideos();
    }

    private final Map<Long, DramaGroupModel> getCachedDramas() {
        return ((FileDataContent) this.dataContentFlow.getValue()).getDramas();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadLocalVideos(Continuation<? super Integer> continuation) {
        FileDataStorage$loadLocalVideos$1 fileDataStorage$loadLocalVideos$1;
        Object loadLocalEntitiesWithTrack;
        Object loadLocalDramasWithTrack;
        List entities;
        Map dramas;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        Object nextValue$iv;
        if (continuation instanceof FileDataStorage$loadLocalVideos$1) {
            fileDataStorage$loadLocalVideos$1 = (FileDataStorage$loadLocalVideos$1) continuation;
            if ((fileDataStorage$loadLocalVideos$1.label & Integer.MIN_VALUE) != 0) {
                fileDataStorage$loadLocalVideos$1.label -= Integer.MIN_VALUE;
                Object $result = fileDataStorage$loadLocalVideos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fileDataStorage$loadLocalVideos$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        fileDataStorage$loadLocalVideos$1.label = 1;
                        loadLocalEntitiesWithTrack = loadLocalEntitiesWithTrack(fileDataStorage$loadLocalVideos$1);
                        if (loadLocalEntitiesWithTrack == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List entities2 = (List) loadLocalEntitiesWithTrack;
                        fileDataStorage$loadLocalVideos$1.L$0 = entities2;
                        fileDataStorage$loadLocalVideos$1.label = 2;
                        loadLocalDramasWithTrack = loadLocalDramasWithTrack(fileDataStorage$loadLocalVideos$1);
                        if (loadLocalDramasWithTrack != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        entities = entities2;
                        dramas = (Map) loadLocalDramasWithTrack;
                        $this$update$iv = this.dataContentFlow;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                            FileDataContent fileDataContent = (FileDataContent) prevValue$iv;
                            nextValue$iv = new FileDataContent(entities, dramas, null, 4, null);
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                        return Boxing.boxInt(getCachedVideos().size());
                    case 1:
                        ResultKt.throwOnFailure($result);
                        loadLocalEntitiesWithTrack = $result;
                        List entities22 = (List) loadLocalEntitiesWithTrack;
                        fileDataStorage$loadLocalVideos$1.L$0 = entities22;
                        fileDataStorage$loadLocalVideos$1.label = 2;
                        loadLocalDramasWithTrack = loadLocalDramasWithTrack(fileDataStorage$loadLocalVideos$1);
                        if (loadLocalDramasWithTrack != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        entities = (List) fileDataStorage$loadLocalVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        loadLocalDramasWithTrack = $result;
                        dramas = (Map) loadLocalDramasWithTrack;
                        $this$update$iv = this.dataContentFlow;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                            FileDataContent fileDataContent2 = (FileDataContent) prevValue$iv;
                            nextValue$iv = new FileDataContent(entities, dramas, null, 4, null);
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                        return Boxing.boxInt(getCachedVideos().size());
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileDataStorage$loadLocalVideos$1 = new FileDataStorage$loadLocalVideos$1(this, continuation);
        Object $result2 = fileDataStorage$loadLocalVideos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fileDataStorage$loadLocalVideos$1.label) {
        }
    }

    public final Map<Long, DramaGroupModel> getDramaMap() {
        return getCachedDramas();
    }

    private final Map<Long, DramaGroupModel> resolveDramas(List<OfflineVideoEntity> list) {
        Map newDramas = MapsKt.toMutableMap(getCachedDramas());
        List<OfflineVideoEntity> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            OfflineVideoEntity video2 = (OfflineVideoEntity) element$iv;
            if (video2.hitAttr(OfflineVideoEntity.VideoAttr.DramaVideo)) {
                DramaGroupModel drama = newDramas.get(Long.valueOf(video2.getGroupId()));
                if (drama != null) {
                    drama.getItems().add(DramaGroupModelKt.convert2DramaItem(video2));
                } else {
                    DramaGroupModel newDrama = new DramaGroupModel(video2.getGroupId(), video2.getGroupTitle(), video2.getCover(), CollectionsKt.mutableListOf(new DramaItemModel[]{DramaGroupModelKt.convert2DramaItem(video2)}));
                    newDramas.put(Long.valueOf(video2.getGroupId()), newDrama);
                }
            }
        }
        return newDramas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadLocalEntitiesWithTrack(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return BuildersKt.withContext(OfflineScopeKt.getStorageDispatcher(), new FileDataStorage$loadLocalEntitiesWithTrack$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadLocalDramasWithTrack(Continuation<? super Map<Long, DramaGroupModel>> continuation) {
        return BuildersKt.withContext(OfflineScopeKt.getStorageDispatcher(), new FileDataStorage$loadLocalDramasWithTrack$2(null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flow<List<OfflineVideoEntity>> addVideos(List<OfflineVideoEntity> list) {
        Object prevValue$iv;
        Object nextValue$iv;
        Intrinsics.checkNotNullParameter(list, "videos");
        List<OfflineVideoEntity> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (!getCachedVideos().contains(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List newVideos = CollectionsKt.plus((List) destination$iv$iv, getCachedVideos());
        Map dramas = resolveDramas(newVideos);
        MutableStateFlow $this$update$iv = this.dataContentFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            FileDataContent fileDataContent = (FileDataContent) prevValue$iv;
            nextValue$iv = new FileDataContent(newVideos, dramas, null, 4, null);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
        new DataLog().debug("FileStorage addVideos: " + list);
        new DataLog().debug("FileStorage addDramas: " + dramas);
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new FileDataStorage$addVideos$2(list, dramas, null), 3, (Object) null);
        final Flow $this$map$iv = this.dataContentFlow;
        return new Flow<List<? extends OfflineVideoEntity>>() { // from class: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$addVideos$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$addVideos$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$addVideos$$inlined$map$1$2", f = "FileDataStorage.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$addVideos$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    FileDataContent it = (FileDataContent) value;
                                    List<OfflineVideoEntity> videos = it.getVideos();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(videos, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flow<List<OfflineVideoEntity>> getAllVideosFlow() {
        final Flow $this$map$iv = this.dataContentFlow;
        return new Flow<List<? extends OfflineVideoEntity>>() { // from class: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getAllVideosFlow$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getAllVideosFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getAllVideosFlow$$inlined$map$1$2", f = "FileDataStorage.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getAllVideosFlow$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    FileDataContent it = (FileDataContent) value;
                                    List<OfflineVideoEntity> videos = it.getVideos();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(videos, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    public final List<OfflineVideoEntity> getAllVideos() {
        return getCachedVideos();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flow<List<OfflineVideoEntity>> getVideosFlowByGroupId(final long groupId, final String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        new DataLog().debug("FileStorage getVideoStatesByGroupId: " + groupId);
        final Flow $this$map$iv = this.dataContentFlow;
        return new Flow<List<? extends OfflineVideoEntity>>() { // from class: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByGroupId$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, groupId, keyword), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByGroupId$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ long $groupId$inlined;
                final /* synthetic */ String $keyword$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByGroupId$$inlined$map$1$2", f = "FileDataStorage.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByGroupId$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, long j, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$groupId$inlined = j;
                    this.$keyword$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    Object $result;
                    boolean z;
                    Iterable $this$filter$iv;
                    boolean z2;
                    boolean z3;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result2);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    Continuation $completion2 = $continuation;
                                    FileDataContent content = (FileDataContent) value;
                                    boolean z4 = false;
                                    Iterable $this$filter$iv2 = content.getVideos();
                                    Collection destination$iv$iv = new ArrayList();
                                    for (T t : $this$filter$iv2) {
                                        OfflineVideoEntity it = (OfflineVideoEntity) t;
                                        Continuation $completion3 = $completion2;
                                        FileDataContent content2 = content;
                                        if (it.getGroupId() != this.$groupId$inlined) {
                                            $result = $result2;
                                            z = z4;
                                            $this$filter$iv = $this$filter$iv2;
                                            z2 = false;
                                        } else {
                                            $result = $result2;
                                            z = z4;
                                            $this$filter$iv = $this$filter$iv2;
                                            z2 = false;
                                            if (StringsKt.contains$default(it.getGroupTitle(), this.$keyword$inlined, false, 2, (Object) null) || StringsKt.contains$default(it.getVideoTitle(), this.$keyword$inlined, false, 2, (Object) null) || StringsKt.contains$default(it.getPageTitle(), this.$keyword$inlined, false, 2, (Object) null) || StringsKt.isBlank(this.$keyword$inlined)) {
                                                z3 = true;
                                                if (!z3) {
                                                    destination$iv$iv.add(t);
                                                }
                                                $result2 = $result;
                                                $completion2 = $completion3;
                                                content = content2;
                                                z4 = z;
                                                $this$filter$iv2 = $this$filter$iv;
                                            }
                                        }
                                        z3 = z2;
                                        if (!z3) {
                                        }
                                        $result2 = $result;
                                        $completion2 = $completion3;
                                        content = content2;
                                        z4 = z;
                                        $this$filter$iv2 = $this$filter$iv;
                                    }
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit((List) destination$iv$iv, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result2);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result22 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    public final List<OfflineVideoEntity> getVideosByGroupId(long groupId, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            boolean z = false;
            if (it.getGroupId() == groupId && (StringsKt.contains$default(it.getGroupTitle(), keyword, false, 2, (Object) null) || StringsKt.contains$default(it.getVideoTitle(), keyword, false, 2, (Object) null) || StringsKt.contains$default(it.getPageTitle(), keyword, false, 2, (Object) null) || StringsKt.isBlank(keyword))) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flow<List<OfflineVideoEntity>> getVideosFlowByVideoId(final long videoId, final String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        final Flow $this$map$iv = this.dataContentFlow;
        return new Flow<List<? extends OfflineVideoEntity>>() { // from class: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByVideoId$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, videoId, keyword), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByVideoId$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $keyword$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ long $videoId$inlined;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByVideoId$$inlined$map$1$2", f = "FileDataStorage.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByVideoId$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, long j, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$videoId$inlined = j;
                    this.$keyword$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    Object $result;
                    boolean z;
                    Iterable $this$filter$iv;
                    boolean z2;
                    boolean z3;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result2);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    Continuation $completion2 = $continuation;
                                    FileDataContent content = (FileDataContent) value;
                                    boolean z4 = false;
                                    Iterable $this$filter$iv2 = content.getVideos();
                                    Collection destination$iv$iv = new ArrayList();
                                    for (T t : $this$filter$iv2) {
                                        OfflineVideoEntity it = (OfflineVideoEntity) t;
                                        Continuation $completion3 = $completion2;
                                        FileDataContent content2 = content;
                                        if (it.getVideoId() != this.$videoId$inlined) {
                                            $result = $result2;
                                            z = z4;
                                            $this$filter$iv = $this$filter$iv2;
                                            z2 = false;
                                        } else {
                                            $result = $result2;
                                            z = z4;
                                            $this$filter$iv = $this$filter$iv2;
                                            z2 = false;
                                            if (StringsKt.contains$default(it.getGroupTitle(), this.$keyword$inlined, false, 2, (Object) null) || StringsKt.contains$default(it.getVideoTitle(), this.$keyword$inlined, false, 2, (Object) null) || StringsKt.contains$default(it.getPageTitle(), this.$keyword$inlined, false, 2, (Object) null) || StringsKt.isBlank(this.$keyword$inlined)) {
                                                z3 = true;
                                                if (!z3) {
                                                    destination$iv$iv.add(t);
                                                }
                                                $result2 = $result;
                                                $completion2 = $completion3;
                                                content = content2;
                                                z4 = z;
                                                $this$filter$iv2 = $this$filter$iv;
                                            }
                                        }
                                        z3 = z2;
                                        if (!z3) {
                                        }
                                        $result2 = $result;
                                        $completion2 = $completion3;
                                        content = content2;
                                        z4 = z;
                                        $this$filter$iv2 = $this$filter$iv;
                                    }
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit((List) destination$iv$iv, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result2);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result22 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    public final List<OfflineVideoEntity> getVideosByVideoId(long videoId, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            boolean z = false;
            if (it.getVideoId() == videoId && (StringsKt.contains$default(it.getGroupTitle(), keyword, false, 2, (Object) null) || StringsKt.contains$default(it.getVideoTitle(), keyword, false, 2, (Object) null) || StringsKt.contains$default(it.getPageTitle(), keyword, false, 2, (Object) null) || StringsKt.isBlank(keyword))) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flow<List<OfflineVideoEntity>> getVideosFlowByPageId(final long pageId) {
        final Flow $this$map$iv = this.dataContentFlow;
        return new Flow<List<? extends OfflineVideoEntity>>() { // from class: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByPageId$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, pageId), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByPageId$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ long $pageId$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByPageId$$inlined$map$1$2", f = "FileDataStorage.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$getVideosFlowByPageId$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$pageId$inlined = j;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    Continuation $completion2 = $continuation;
                                    FileDataContent content = (FileDataContent) value;
                                    Iterable $this$filter$iv = content.getVideos();
                                    Collection destination$iv$iv = new ArrayList();
                                    for (T t : $this$filter$iv) {
                                        OfflineVideoEntity it = (OfflineVideoEntity) t;
                                        Continuation $completion3 = $completion2;
                                        FileDataContent content2 = content;
                                        if (it.getPageId() == this.$pageId$inlined) {
                                            destination$iv$iv.add(t);
                                        }
                                        $completion2 = $completion3;
                                        content = content2;
                                    }
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit((List) destination$iv$iv, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    public final List<OfflineVideoEntity> getVideosByPageId(long pageId) {
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (it.getPageId() == pageId) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final OfflineVideoEntity getVideoByKey(String key) {
        OfflineVideoEntity offlineVideoEntity;
        Intrinsics.checkNotNullParameter(key, "key");
        List<OfflineVideoEntity> cachedVideos = getCachedVideos();
        ListIterator<OfflineVideoEntity> listIterator = cachedVideos.listIterator(cachedVideos.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                offlineVideoEntity = null;
                break;
            }
            offlineVideoEntity = listIterator.previous();
            OfflineVideoEntity it = offlineVideoEntity;
            if (Intrinsics.areEqual(it.getKey(), key)) {
                break;
            }
        }
        return offlineVideoEntity;
    }

    public final List<OfflineVideoEntity> getVideosByKeys(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "keys");
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (list.contains(it.getKey())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static /* synthetic */ List getUnDownloadVideos$default(FileDataStorage fileDataStorage, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return fileDataStorage.getUnDownloadVideos(z, z2, i);
    }

    public final List<OfflineVideoEntity> getUnDownloadVideos(boolean includePause, boolean includeError, int limit) {
        List filterState = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(OfflineVideoEntity.State.COMPLETED.INSTANCE.getStateValue())});
        if (!includePause) {
            filterState.add(Integer.valueOf(new OfflineVideoEntity.State.PAUSED(0L, 0L).getStateValue()));
        }
        if (!includeError) {
            filterState.add(Integer.valueOf(new OfflineVideoEntity.State.ERROR(0).getStateValue()));
        }
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (!filterState.contains(Integer.valueOf(it.getStateValue()))) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List videos = (List) destination$iv$iv;
        if (limit > 0) {
            return CollectionsKt.take(videos, limit);
        }
        return videos;
    }

    public final List<OfflineVideoEntity> getDownloadedVideos() {
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (it.getDownloaded()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final List<OfflineVideoEntity> getDownloadingVideos() {
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (it.isDownloading()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final List<OfflineVideoEntity> search(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            boolean z = false;
            if (it.getDownloaded() && (StringsKt.contains$default(it.getGroupTitle(), keyword, false, 2, (Object) null) || StringsKt.contains$default(it.getVideoTitle(), keyword, false, 2, (Object) null) || StringsKt.contains$default(it.getPageTitle(), keyword, false, 2, (Object) null))) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final List<OfflineVideoEntity> removeVideo(List<String> list) {
        Object prevValue$iv;
        Object nextValue$iv;
        Intrinsics.checkNotNullParameter(list, "ids");
        Iterable $this$filter$iv = getCachedVideos();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            if (list.contains(it.getKey())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List toRemove = (List) destination$iv$iv;
        Iterable $this$filter$iv2 = getCachedVideos();
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            OfflineVideoEntity it2 = (OfflineVideoEntity) element$iv$iv2;
            if (!list.contains(it2.getKey())) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        List newVideos = (List) destination$iv$iv2;
        MutableStateFlow $this$update$iv = this.dataContentFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            FileDataContent fileDataContent = (FileDataContent) prevValue$iv;
            nextValue$iv = new FileDataContent(newVideos, getCachedDramas(), null, 4, null);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
        return toRemove;
    }

    public final List<DramaGroupModel> removeDramas(List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "videos");
        Map changedDramas = new LinkedHashMap();
        List<OfflineVideoEntity> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            final OfflineVideoEntity video2 = (OfflineVideoEntity) element$iv;
            DramaGroupModel it = getCachedDramas().get(Long.valueOf(video2.getGroupId()));
            if (it != null) {
                CollectionsKt.removeAll(it.getItems(), new Function1() { // from class: video.biz.offline.base.infra.storage.diskfile.FileDataStorage$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        boolean removeDramas$lambda$0$0$0;
                        removeDramas$lambda$0$0$0 = FileDataStorage.removeDramas$lambda$0$0$0(OfflineVideoEntity.this, (DramaItemModel) obj);
                        return Boolean.valueOf(removeDramas$lambda$0$0$0);
                    }
                });
                changedDramas.put(Long.valueOf(it.getId()), it);
            }
        }
        LogKt.getVBLog().debug("changedDramas: " + changedDramas.values());
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new FileDataStorage$removeDramas$2(changedDramas, null), 3, (Object) null);
        Iterable $this$filter$iv = getCachedDramas().values();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((DramaGroupModel) element$iv$iv).getItems().isEmpty()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeDramas$lambda$0$0$0(OfflineVideoEntity $video, DramaItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getAid() == $video.getAid();
    }

    public final void updateAuthCode(List<OfflineAuthUpdate> list) {
        Object obj;
        OfflineVideoEntity offlineVideoEntity;
        List<OfflineAuthUpdate> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "list");
        MutableStateFlow $this$update$iv = this.dataContentFlow;
        while (true) {
            Object prevValue$iv = $this$update$iv.getValue();
            FileDataContent content = (FileDataContent) prevValue$iv;
            Iterable $this$map$iv = content.getVideos();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OfflineVideoEntity video2 = (OfflineVideoEntity) item$iv$iv;
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(video2.getKey(), ((OfflineAuthUpdate) obj).getKey())) {
                        break;
                    }
                }
                OfflineAuthUpdate it2 = (OfflineAuthUpdate) obj;
                if (it2 == null || (offlineVideoEntity = OfflineVideoEntity.m2770copyQZD5vYk$default(video2, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, 0L, null, 0L, null, null, null, 0L, null, 0L, 0L, 0L, 0L, 0, 0, 0, null, null, null, null, null, 0, 0, 0L, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, null, it2.getCode(), null, null, null, null, -1, 31743, null)) == null) {
                    offlineVideoEntity = video2;
                }
                destination$iv$iv.add(offlineVideoEntity);
                list2 = list;
            }
            List videos = (List) destination$iv$iv;
            Object nextValue$iv = new FileDataContent(videos, getCachedDramas(), null, 4, null);
            if ($this$update$iv.compareAndSet(prevValue$iv, nextValue$iv)) {
                return;
            }
            list2 = list;
        }
    }

    public final void updateVideo(List<OfflineVideoEntity> list) {
        Object obj;
        List<OfflineVideoEntity> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "updates");
        if (list.isEmpty()) {
            return;
        }
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new FileDataStorage$updateVideo$1(list2, null), 3, (Object) null);
        MutableStateFlow $this$update$iv = this.dataContentFlow;
        while (true) {
            Object prevValue$iv = $this$update$iv.getValue();
            FileDataContent content = (FileDataContent) prevValue$iv;
            Iterable $this$map$iv = content.getVideos();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OfflineVideoEntity video2 = (OfflineVideoEntity) item$iv$iv;
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    OfflineVideoEntity it2 = (OfflineVideoEntity) obj;
                    if (Intrinsics.areEqual(it2.getKey(), video2.getKey())) {
                        break;
                    }
                }
                OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) obj;
                if (offlineVideoEntity != null) {
                    video2 = offlineVideoEntity;
                }
                destination$iv$iv.add(video2);
                list2 = list;
            }
            List result = (List) destination$iv$iv;
            Object nextValue$iv = new FileDataContent(result, getCachedDramas(), null, 4, null);
            if ($this$update$iv.compareAndSet(prevValue$iv, nextValue$iv)) {
                return;
            }
            list2 = list;
        }
    }
}