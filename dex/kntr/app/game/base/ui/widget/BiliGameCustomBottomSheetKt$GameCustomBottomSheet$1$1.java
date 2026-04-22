package kntr.app.game.base.ui.widget;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliGameCustomBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class BiliGameCustomBottomSheetKt$GameCustomBottomSheet$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ MutableState<Rect> $sheetBounds$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliGameCustomBottomSheetKt$GameCustomBottomSheet$1$1(MutableState<Rect> mutableState, Function0<Unit> function0) {
        this.$sheetBounds$delegate = mutableState;
        this.$onDismiss = function0;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final MutableState<Rect> mutableState = this.$sheetBounds$delegate;
        final Function0<Unit> function0 = this.$onDismiss;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$GameCustomBottomSheet$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = BiliGameCustomBottomSheetKt$GameCustomBottomSheet$1$1.invoke$lambda$0(mutableState, function0, (Offset) obj);
                return invoke$lambda$0;
            }
        }, continuation, 7, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(MutableState $sheetBounds$delegate, Function0 $onDismiss, Offset offset) {
        Rect bounds;
        bounds = BiliGameCustomBottomSheetKt.GameCustomBottomSheet$lambda$3($sheetBounds$delegate);
        if (bounds != null && !bounds.contains-k-4lQ0M(offset.unbox-impl())) {
            $onDismiss.invoke();
        }
        return Unit.INSTANCE;
    }
}