package kntr.app.im.chat.sticker;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.model.StickerAssetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sticker.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class StickerState$load$2<T> implements FlowCollector {
    final /* synthetic */ StickerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerState$load$2(StickerState stickerState) {
        this.this$0 = stickerState;
    }

    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((List) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00e4 -> B:20:0x00f7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(List<StickerEntity> list, Continuation<? super Unit> continuation) {
        StickerState$load$2$emit$1 stickerState$load$2$emit$1;
        Iterable $this$map$iv;
        Iterable item$iv$iv;
        Iterator<T> it;
        StickerState$load$2 stickerState$load$2;
        Object obj;
        Collection destination$iv$iv;
        int $i$f$mapTo;
        int $i$f$map;
        MutableState<List<StickerAsset>> mutableState;
        StickerState$load$2$emit$1 stickerState$load$2$emit$12;
        List entities;
        Continuation $continuation;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv2;
        Iterator<T> it2;
        Collection destination$iv$iv2;
        StickerState$load$2 stickerState$load$22;
        MutableState<List<StickerAsset>> mutableState2;
        Collection collection;
        int $i$f$map2;
        int $i$f$map3;
        Object obj2;
        StickerState$load$2$emit$1 stickerState$load$2$emit$13;
        if (continuation instanceof StickerState$load$2$emit$1) {
            stickerState$load$2$emit$1 = (StickerState$load$2$emit$1) continuation;
            if ((stickerState$load$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                stickerState$load$2$emit$1.label -= Integer.MIN_VALUE;
                Object $result = stickerState$load$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerState$load$2$emit$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableState<List<StickerAsset>> stickerHolder = this.this$0.getStickerHolder();
                        List<StickerEntity> $this$map$iv3 = list;
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $this$map$iv = $this$map$iv3;
                        item$iv$iv = $this$map$iv3;
                        it = $this$map$iv3.iterator();
                        stickerState$load$2 = this;
                        obj = coroutine_suspended;
                        destination$iv$iv = destination$iv$iv3;
                        $i$f$mapTo = 0;
                        $i$f$map = 0;
                        mutableState = stickerHolder;
                        stickerState$load$2$emit$12 = stickerState$load$2$emit$1;
                        entities = list;
                        $continuation = continuation;
                        break;
                    case 1:
                        int i = stickerState$load$2$emit$1.I$2;
                        int $i$f$mapTo2 = stickerState$load$2$emit$1.I$1;
                        int $i$f$map4 = stickerState$load$2$emit$1.I$0;
                        StickerEntity stickerEntity = (StickerEntity) stickerState$load$2$emit$1.L$6;
                        Object obj3 = stickerState$load$2$emit$1.L$5;
                        destination$iv$iv2 = (Collection) stickerState$load$2$emit$1.L$3;
                        Iterable $this$mapTo$iv$iv2 = (Iterable) stickerState$load$2$emit$1.L$2;
                        entities = (List) stickerState$load$2$emit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $this$map$iv2 = (Iterable) stickerState$load$2$emit$1.L$1;
                        it2 = (Iterator) stickerState$load$2$emit$1.L$4;
                        stickerState$load$22 = this;
                        stickerState$load$2$emit$13 = stickerState$load$2$emit$1;
                        $continuation = continuation;
                        mutableState2 = (MutableState) stickerState$load$2$emit$1.L$7;
                        collection = (Collection) stickerState$load$2$emit$1.L$8;
                        $i$f$map2 = $i$f$map4;
                        $i$f$map3 = $i$f$mapTo2;
                        obj2 = coroutine_suspended;
                        collection.add((StickerAsset) $result);
                        stickerState$load$2$emit$12 = stickerState$load$2$emit$13;
                        obj = obj2;
                        $i$f$map = $i$f$map3;
                        $i$f$mapTo = $i$f$map2;
                        mutableState = mutableState2;
                        stickerState$load$2 = stickerState$load$22;
                        destination$iv$iv = destination$iv$iv2;
                        it = it2;
                        item$iv$iv = $this$mapTo$iv$iv;
                        $this$map$iv = $this$map$iv2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object item$iv$iv2 = it.next();
                    StickerEntity entity = (StickerEntity) item$iv$iv2;
                    Continuation $completion = $continuation;
                    stickerState$load$2$emit$12.L$0 = SpillingKt.nullOutSpilledVariable(entities);
                    stickerState$load$2$emit$12.L$1 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                    stickerState$load$2$emit$12.L$2 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                    stickerState$load$2$emit$12.L$3 = destination$iv$iv;
                    stickerState$load$2$emit$12.L$4 = it;
                    stickerState$load$2$emit$12.L$5 = SpillingKt.nullOutSpilledVariable(item$iv$iv2);
                    stickerState$load$2$emit$12.L$6 = SpillingKt.nullOutSpilledVariable(entity);
                    stickerState$load$2$emit$12.L$7 = mutableState;
                    stickerState$load$2$emit$12.L$8 = destination$iv$iv;
                    stickerState$load$2$emit$12.I$0 = $i$f$mapTo;
                    stickerState$load$2$emit$12.I$1 = $i$f$map;
                    stickerState$load$2$emit$12.I$2 = 0;
                    stickerState$load$2$emit$12.label = 1;
                    Object asAsset = StickerAssetKt.asAsset(entity, stickerState$load$2$emit$12);
                    if (asAsset == obj) {
                        return obj;
                    }
                    $this$mapTo$iv$iv = item$iv$iv;
                    $this$map$iv2 = $this$map$iv;
                    it2 = it;
                    destination$iv$iv2 = destination$iv$iv;
                    stickerState$load$22 = stickerState$load$2;
                    mutableState2 = mutableState;
                    collection = destination$iv$iv2;
                    $i$f$map2 = $i$f$mapTo;
                    $i$f$map3 = $i$f$map;
                    obj2 = obj;
                    stickerState$load$2$emit$13 = stickerState$load$2$emit$12;
                    $result = asAsset;
                    $continuation = $completion;
                    collection.add((StickerAsset) $result);
                    stickerState$load$2$emit$12 = stickerState$load$2$emit$13;
                    obj = obj2;
                    $i$f$map = $i$f$map3;
                    $i$f$mapTo = $i$f$map2;
                    mutableState = mutableState2;
                    stickerState$load$2 = stickerState$load$22;
                    destination$iv$iv = destination$iv$iv2;
                    it = it2;
                    item$iv$iv = $this$mapTo$iv$iv;
                    $this$map$iv = $this$map$iv2;
                    if (it.hasNext()) {
                        mutableState.setValue((List) destination$iv$iv);
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        stickerState$load$2$emit$1 = new StickerState$load$2$emit$1(this, continuation);
        Object $result2 = stickerState$load$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerState$load$2$emit$1.label) {
        }
        if (it.hasNext()) {
        }
    }
}