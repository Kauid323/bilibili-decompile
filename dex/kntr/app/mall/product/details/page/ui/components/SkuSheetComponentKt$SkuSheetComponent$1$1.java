package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SkuSheetComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$SkuSheetComponent$1$1", f = "SkuSheetComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SkuSheetComponentKt$SkuSheetComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $currentImageUrl;
    final /* synthetic */ MutableState<String> $currentPrice;
    final /* synthetic */ MutableState<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> $currentSelectedSku;
    final /* synthetic */ List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> $itemsSkuList;
    final /* synthetic */ SnapshotStateMap<Integer, Integer> $selectedSpecIndices;
    final /* synthetic */ List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem> $specInfoList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkuSheetComponentKt$SkuSheetComponent$1$1(List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem> list, SnapshotStateMap<Integer, Integer> snapshotStateMap, List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> list2, MutableState<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, Continuation<? super SkuSheetComponentKt$SkuSheetComponent$1$1> continuation) {
        super(2, continuation);
        this.$specInfoList = list;
        this.$selectedSpecIndices = snapshotStateMap;
        this.$itemsSkuList = list2;
        this.$currentSelectedSku = mutableState;
        this.$currentPrice = mutableState2;
        this.$currentImageUrl = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SkuSheetComponentKt$SkuSheetComponent$1$1(this.$specInfoList, this.$selectedSpecIndices, this.$itemsSkuList, this.$currentSelectedSku, this.$currentPrice, this.$currentImageUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean SkuSheetComponent$isSpecValueSelectable;
        Iterable $this$forEachIndexed$iv;
        SnapshotStateMap<Integer, Integer> snapshotStateMap;
        List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$forEachIndexed$iv2 = this.$specInfoList;
                Map map = this.$selectedSpecIndices;
                List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> list2 = this.$itemsSkuList;
                List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem> list3 = this.$specInfoList;
                int specIndex = 0;
                for (Object item$iv : $this$forEachIndexed$iv2) {
                    int index$iv = specIndex + 1;
                    if (specIndex < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoItem = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) item$iv;
                    Iterable $this$forEachIndexed$iv3 = specInfoItem.getSpecValueVOList();
                    if ($this$forEachIndexed$iv3 != null) {
                        int valueIndex = 0;
                        for (Object item$iv2 : $this$forEachIndexed$iv3) {
                            int index$iv2 = valueIndex + 1;
                            if (valueIndex < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) item$iv2;
                            SkuSheetComponent$isSpecValueSelectable = SkuSheetComponentKt.SkuSheetComponent$isSpecValueSelectable(map, list2, list3, specIndex, valueIndex);
                            if (SkuSheetComponent$isSpecValueSelectable) {
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                snapshotStateMap = map;
                                list = list2;
                                map.put(Boxing.boxInt(specIndex), Boxing.boxInt(valueIndex));
                            } else {
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                snapshotStateMap = map;
                                list = list2;
                            }
                            valueIndex = index$iv2;
                            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                            map = snapshotStateMap;
                            list2 = list;
                        }
                    }
                    specIndex = index$iv;
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv2;
                    map = map;
                    list2 = list2;
                }
                SkuSheetComponentKt.SkuSheetComponent$updateSelectedSku(this.$selectedSpecIndices, this.$specInfoList, this.$itemsSkuList, this.$currentSelectedSku, this.$currentPrice, this.$currentImageUrl);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}