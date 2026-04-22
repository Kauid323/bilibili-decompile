package kntr.app.deepsearch.ui.bottomSheet;

import androidx.compose.runtime.MutableFloatState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomSheetDialog.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;", "it", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$InnerDialog$6$1", f = "BottomSheetDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BottomSheetDialogKt$InnerDialog$6$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $bottomSheetHeight$delegate;
    final /* synthetic */ MutableFloatState $offsetY$delegate;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialogKt$InnerDialog$6$1(Function0<Unit> function0, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, Continuation<? super BottomSheetDialogKt$InnerDialog$6$1> continuation) {
        super(3, continuation);
        this.$onDismissRequest = function0;
        this.$offsetY$delegate = mutableFloatState;
        this.$bottomSheetHeight$delegate = mutableFloatState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation) obj3);
    }

    public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
        return new BottomSheetDialogKt$InnerDialog$6$1(this.$onDismissRequest, this.$offsetY$delegate, this.$bottomSheetHeight$delegate, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        float InnerDialog$lambda$1;
        float InnerDialog$lambda$5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                InnerDialog$lambda$1 = BottomSheetDialogKt.InnerDialog$lambda$1(this.$offsetY$delegate);
                InnerDialog$lambda$5 = BottomSheetDialogKt.InnerDialog$lambda$5(this.$bottomSheetHeight$delegate);
                if (InnerDialog$lambda$1 > InnerDialog$lambda$5 / 4) {
                    this.$onDismissRequest.invoke();
                } else {
                    this.$offsetY$delegate.setFloatValue(0.0f);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}