package kntr.app.mall.product.details.page.ui.screen;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullScreenPreview.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FullScreenPreviewKt$FullScreenImagePreview$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onDismiss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullScreenPreviewKt$FullScreenImagePreview$1$1(Function0<Unit> function0) {
        this.$onDismiss = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function0 $onDismiss, Offset it) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final Function0<Unit> function0 = this.$onDismiss;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenPreviewKt$FullScreenImagePreview$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = FullScreenPreviewKt$FullScreenImagePreview$1$1.invoke$lambda$0(function0, (Offset) obj);
                return invoke$lambda$0;
            }
        }, continuation, 7, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }
}