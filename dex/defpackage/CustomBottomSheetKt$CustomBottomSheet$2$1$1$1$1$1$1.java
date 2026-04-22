package defpackage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: CustomBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: CustomBottomSheetKt$CustomBottomSheet$2$1$1$1$1$1$1  reason: default package */
final class CustomBottomSheetKt$CustomBottomSheet$2$1$1$1$1$1$1 implements Function0<Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ BottomSheetItemData $item;
    final /* synthetic */ Function0<Unit> $onDismissRequest;

    CustomBottomSheetKt$CustomBottomSheet$2$1$1$1$1$1$1(BottomSheetItemData bottomSheetItemData, int i, Function0<Unit> function0) {
        this.$item = bottomSheetItemData;
        this.$index = i;
        this.$onDismissRequest = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m0invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m0invoke() {
        this.$item.getOnClick().invoke(Integer.valueOf(this.$index));
        this.$onDismissRequest.invoke();
    }
}