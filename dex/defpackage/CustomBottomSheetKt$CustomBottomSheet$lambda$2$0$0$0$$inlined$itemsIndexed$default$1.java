package defpackage;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyDsl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$1  reason: default package */
public final class CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$1 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $key;

    public CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$1(Function2 function2, List list) {
        this.$key = function2;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Object invoke(int index) {
        return this.$key.invoke(Integer.valueOf(index), this.$items.get(index));
    }
}