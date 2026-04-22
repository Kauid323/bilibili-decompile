package kntr.app.im.chat.sticker.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.model.StickerAssetKt;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: StickerManagerStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "stickerEntityList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$loadStickers$2", f = "StickerManagerStateMachine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {53}, m = "invokeSuspend", n = {"stickerEntityList", "state", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-StickerManagerStateMachine$loadStickers$2$stickerList$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
final class StickerManagerStateMachine$loadStickers$2 extends SuspendLambda implements Function3<List<? extends StickerEntity>, State<StickerManagerData>, Continuation<? super ChangedState<? extends StickerManagerData>>, Object> {
    int I$0;
    int I$1;
    int I$2;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerManagerStateMachine$loadStickers$2(Continuation<? super StickerManagerStateMachine$loadStickers$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<StickerEntity> list, State<StickerManagerData> state, Continuation<? super ChangedState<StickerManagerData>> continuation) {
        StickerManagerStateMachine$loadStickers$2 stickerManagerStateMachine$loadStickers$2 = new StickerManagerStateMachine$loadStickers$2(continuation);
        stickerManagerStateMachine$loadStickers$2.L$0 = list;
        stickerManagerStateMachine$loadStickers$2.L$1 = state;
        return stickerManagerStateMachine$loadStickers$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00ba -> B:14:0x00c7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterable $this$map$iv;
        Iterable item$iv$iv;
        Iterator it;
        Object obj;
        Collection destination$iv$iv;
        State state;
        int $i$f$mapTo;
        int $i$f$map;
        StickerManagerStateMachine$loadStickers$2 stickerManagerStateMachine$loadStickers$2;
        List stickerEntityList;
        Object asAsset;
        Iterable $this$map$iv2;
        Iterator it2;
        StickerManagerStateMachine$loadStickers$2 stickerManagerStateMachine$loadStickers$22;
        Collection collection;
        int $i$f$map2;
        int $i$f$map3;
        Object obj2;
        Iterable $this$mapTo$iv$iv;
        Collection destination$iv$iv2;
        List stickerEntityList2 = (List) this.L$0;
        State state2 = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List $this$map$iv3 = stickerEntityList2;
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                $this$map$iv = $this$map$iv3;
                item$iv$iv = $this$map$iv3;
                it = $this$map$iv3.iterator();
                obj = coroutine_suspended;
                destination$iv$iv = destination$iv$iv3;
                state = state2;
                $i$f$mapTo = 0;
                $i$f$map = 0;
                stickerManagerStateMachine$loadStickers$2 = this;
                stickerEntityList = stickerEntityList2;
                break;
            case 1:
                int i = this.I$2;
                int $i$f$mapTo2 = this.I$1;
                int $i$f$map4 = this.I$0;
                StickerEntity stickerEntity = (StickerEntity) this.L$7;
                Object obj3 = this.L$6;
                Iterable $this$mapTo$iv$iv2 = (Iterable) this.L$3;
                ResultKt.throwOnFailure($result);
                asAsset = $result;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                $this$map$iv2 = (Iterable) this.L$2;
                it2 = (Iterator) this.L$5;
                stickerManagerStateMachine$loadStickers$22 = this;
                collection = (Collection) this.L$8;
                $i$f$map2 = $i$f$map4;
                $i$f$map3 = $i$f$mapTo2;
                obj2 = coroutine_suspended;
                state = state2;
                stickerEntityList = stickerEntityList2;
                destination$iv$iv2 = (Collection) this.L$4;
                collection.add((StickerAsset) asAsset);
                obj = obj2;
                $i$f$map = $i$f$map3;
                $i$f$mapTo = $i$f$map2;
                stickerManagerStateMachine$loadStickers$2 = stickerManagerStateMachine$loadStickers$22;
                destination$iv$iv = destination$iv$iv2;
                it = it2;
                item$iv$iv = $this$mapTo$iv$iv;
                $this$map$iv = $this$map$iv2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object item$iv$iv2 = it.next();
            StickerEntity it3 = (StickerEntity) item$iv$iv2;
            stickerManagerStateMachine$loadStickers$2.L$0 = SpillingKt.nullOutSpilledVariable(stickerEntityList);
            stickerManagerStateMachine$loadStickers$2.L$1 = state;
            stickerManagerStateMachine$loadStickers$2.L$2 = SpillingKt.nullOutSpilledVariable($this$map$iv);
            stickerManagerStateMachine$loadStickers$2.L$3 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
            stickerManagerStateMachine$loadStickers$2.L$4 = destination$iv$iv;
            stickerManagerStateMachine$loadStickers$2.L$5 = it;
            stickerManagerStateMachine$loadStickers$2.L$6 = SpillingKt.nullOutSpilledVariable(item$iv$iv2);
            stickerManagerStateMachine$loadStickers$2.L$7 = SpillingKt.nullOutSpilledVariable(it3);
            stickerManagerStateMachine$loadStickers$2.L$8 = destination$iv$iv;
            stickerManagerStateMachine$loadStickers$2.I$0 = $i$f$mapTo;
            stickerManagerStateMachine$loadStickers$2.I$1 = $i$f$map;
            stickerManagerStateMachine$loadStickers$2.I$2 = 0;
            stickerManagerStateMachine$loadStickers$2.label = 1;
            asAsset = StickerAssetKt.asAsset(it3, stickerManagerStateMachine$loadStickers$2);
            if (asAsset == obj) {
                return obj;
            }
            $this$map$iv2 = $this$map$iv;
            it2 = it;
            stickerManagerStateMachine$loadStickers$22 = stickerManagerStateMachine$loadStickers$2;
            collection = destination$iv$iv;
            $i$f$map2 = $i$f$mapTo;
            $i$f$map3 = $i$f$map;
            obj2 = obj;
            $this$mapTo$iv$iv = item$iv$iv;
            destination$iv$iv2 = collection;
            collection.add((StickerAsset) asAsset);
            obj = obj2;
            $i$f$map = $i$f$map3;
            $i$f$mapTo = $i$f$map2;
            stickerManagerStateMachine$loadStickers$2 = stickerManagerStateMachine$loadStickers$22;
            destination$iv$iv = destination$iv$iv2;
            it = it2;
            item$iv$iv = $this$mapTo$iv$iv;
            $this$map$iv = $this$map$iv2;
            if (!it.hasNext()) {
                final List stickerList = (List) destination$iv$iv;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$loadStickers$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj4) {
                        StickerManagerData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = StickerManagerStateMachine$loadStickers$2.invokeSuspend$lambda$1(stickerList, (StickerManagerData) obj4);
                        return invokeSuspend$lambda$1;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerManagerData invokeSuspend$lambda$1(List $stickerList, StickerManagerData $this$mutate) {
        StickerManagerData copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.mid : 0L, (r20 & 2) != 0 ? $this$mutate.stickerList : $stickerList, (r20 & 4) != 0 ? $this$mutate.selectedStickersToDelete : null, (r20 & 8) != 0 ? $this$mutate.selectedStickersToSave : null, (r20 & 16) != 0 ? $this$mutate.isEditMode : false, (r20 & 32) != 0 ? $this$mutate.toast : null, (r20 & 64) != 0 ? $this$mutate.isShowConfirmDeleteDialog : false, (r20 & 128) != 0 ? $this$mutate.saved : false);
        return copy;
    }
}