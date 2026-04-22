package video.biz.offline.list.logic.statemachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineVideoEntityWithTag;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$storeMachine$1$2$1$1$1", f = "OfflineDiagnosePageStore.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {83, IjkCpuInfo.CPU_IMPL_MARVELL}, m = "invokeSuspend", n = {"videoEntities", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "entity", "$i$f$map", "$i$f$mapTo", "$i$a$-map-OfflineDiagnosePageStore$storeMachine$1$2$1$1$1$taggedVideoEntities$1"}, s = {"L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
public final class OfflineDiagnosePageStore$storeMachine$1$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends OfflineVideoEntityWithTag>>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ OfflineDiagnosePageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnosePageStore$storeMachine$1$2$1$1$1(OfflineDiagnosePageStore offlineDiagnosePageStore, Continuation<? super OfflineDiagnosePageStore$storeMachine$1$2$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = offlineDiagnosePageStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineDiagnosePageStore$storeMachine$1$2$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<OfflineVideoEntityWithTag>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00d1 -> B:18:0x00e0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object allVideos;
        List videoEntities;
        Iterable $this$mapTo$iv$iv;
        OfflineDiagnosePageStore offlineDiagnosePageStore;
        int $i$f$mapTo;
        Collection destination$iv$iv;
        Iterable item$iv$iv;
        int $i$f$mapTo2;
        Iterator it;
        OfflineDiagnosePageStore$storeMachine$1$2$1$1$1 offlineDiagnosePageStore$storeMachine$1$2$1$1$1;
        Object obj;
        Object resolvedTagBy;
        List videoEntities2;
        OfflineDiagnosePageStore offlineDiagnosePageStore2;
        Iterator it2;
        OfflineDiagnosePageStore$storeMachine$1$2$1$1$1 offlineDiagnosePageStore$storeMachine$1$2$1$1$12;
        Collection collection;
        int $i$f$map;
        int $i$f$map2;
        Object obj2;
        Iterable $this$map$iv;
        Iterable $this$map$iv2;
        OfflineVideoEntity entity;
        Collection destination$iv$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                allVideos = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().getAllVideos((Continuation) this);
                if (allVideos == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List videoEntities3 = (List) allVideos;
                List $this$map$iv3 = videoEntities3;
                OfflineDiagnosePageStore offlineDiagnosePageStore3 = this.this$0;
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                Iterator it3 = $this$map$iv3.iterator();
                videoEntities = videoEntities3;
                $this$mapTo$iv$iv = $this$map$iv3;
                offlineDiagnosePageStore = offlineDiagnosePageStore3;
                $i$f$mapTo = 0;
                destination$iv$iv = destination$iv$iv3;
                item$iv$iv = $this$map$iv3;
                $i$f$mapTo2 = 0;
                it = it3;
                offlineDiagnosePageStore$storeMachine$1$2$1$1$1 = this;
                obj = coroutine_suspended;
                if (!it.hasNext()) {
                    Object item$iv$iv2 = it.next();
                    OfflineVideoEntity entity2 = (OfflineVideoEntity) item$iv$iv2;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntities);
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$1 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$2 = offlineDiagnosePageStore;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$3 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$4 = destination$iv$iv;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$5 = it;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$6 = SpillingKt.nullOutSpilledVariable(item$iv$iv2);
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$7 = entity2;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.L$8 = destination$iv$iv;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.I$0 = $i$f$mapTo;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.I$1 = $i$f$mapTo2;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.I$2 = 0;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1.label = 2;
                    resolvedTagBy = offlineDiagnosePageStore.getResolvedTagBy(entity2, offlineDiagnosePageStore$storeMachine$1$2$1$1$1);
                    if (resolvedTagBy == obj) {
                        return obj;
                    }
                    videoEntities2 = videoEntities;
                    offlineDiagnosePageStore2 = offlineDiagnosePageStore;
                    it2 = it;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$12 = offlineDiagnosePageStore$storeMachine$1$2$1$1$1;
                    collection = destination$iv$iv;
                    $i$f$map = $i$f$mapTo;
                    $i$f$map2 = $i$f$mapTo2;
                    obj2 = obj;
                    $this$map$iv = $this$mapTo$iv$iv;
                    $this$map$iv2 = item$iv$iv;
                    entity = entity2;
                    destination$iv$iv2 = collection;
                    Tag tag = (Tag) resolvedTagBy;
                    collection.add(new OfflineVideoEntityWithTag(entity, tag));
                    obj = obj2;
                    $i$f$mapTo2 = $i$f$map2;
                    $i$f$mapTo = $i$f$map;
                    offlineDiagnosePageStore$storeMachine$1$2$1$1$1 = offlineDiagnosePageStore$storeMachine$1$2$1$1$12;
                    destination$iv$iv = destination$iv$iv2;
                    it = it2;
                    item$iv$iv = $this$map$iv2;
                    offlineDiagnosePageStore = offlineDiagnosePageStore2;
                    $this$mapTo$iv$iv = $this$map$iv;
                    videoEntities = videoEntities2;
                    if (!it.hasNext()) {
                        List taggedVideoEntities = (List) destination$iv$iv;
                        return taggedVideoEntities;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                allVideos = $result;
                List videoEntities32 = (List) allVideos;
                List $this$map$iv32 = videoEntities32;
                OfflineDiagnosePageStore offlineDiagnosePageStore32 = this.this$0;
                Collection destination$iv$iv32 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv32, 10));
                Iterator it32 = $this$map$iv32.iterator();
                videoEntities = videoEntities32;
                $this$mapTo$iv$iv = $this$map$iv32;
                offlineDiagnosePageStore = offlineDiagnosePageStore32;
                $i$f$mapTo = 0;
                destination$iv$iv = destination$iv$iv32;
                item$iv$iv = $this$map$iv32;
                $i$f$mapTo2 = 0;
                it = it32;
                offlineDiagnosePageStore$storeMachine$1$2$1$1$1 = this;
                obj = coroutine_suspended;
                if (!it.hasNext()) {
                }
                break;
            case 2:
                int i = this.I$2;
                int $i$f$mapTo3 = this.I$1;
                int $i$f$map3 = this.I$0;
                Object obj3 = this.L$6;
                Iterable $this$mapTo$iv$iv2 = (Iterable) this.L$3;
                ResultKt.throwOnFailure($result);
                resolvedTagBy = $result;
                $this$map$iv = (Iterable) this.L$1;
                videoEntities2 = (List) this.L$0;
                $this$map$iv2 = $this$mapTo$iv$iv2;
                offlineDiagnosePageStore2 = (OfflineDiagnosePageStore) this.L$2;
                it2 = (Iterator) this.L$5;
                offlineDiagnosePageStore$storeMachine$1$2$1$1$12 = this;
                entity = (OfflineVideoEntity) this.L$7;
                collection = (Collection) this.L$8;
                $i$f$map = $i$f$map3;
                $i$f$map2 = $i$f$mapTo3;
                obj2 = coroutine_suspended;
                destination$iv$iv2 = (Collection) this.L$4;
                Tag tag2 = (Tag) resolvedTagBy;
                collection.add(new OfflineVideoEntityWithTag(entity, tag2));
                obj = obj2;
                $i$f$mapTo2 = $i$f$map2;
                $i$f$mapTo = $i$f$map;
                offlineDiagnosePageStore$storeMachine$1$2$1$1$1 = offlineDiagnosePageStore$storeMachine$1$2$1$1$12;
                destination$iv$iv = destination$iv$iv2;
                it = it2;
                item$iv$iv = $this$map$iv2;
                offlineDiagnosePageStore = offlineDiagnosePageStore2;
                $this$mapTo$iv$iv = $this$map$iv;
                videoEntities = videoEntities2;
                if (!it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}