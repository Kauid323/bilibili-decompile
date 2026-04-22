package kntr.app.deepsearch.ui.bottomSheet;

import androidx.compose.ui.focus.FocusRequester;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomSheetDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$DSBottomSheetDialog$1$1", f = "BottomSheetDialog.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BottomSheetDialogKt$DSBottomSheetDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ boolean $visible;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialogKt$DSBottomSheetDialog$1$1(boolean z, FocusRequester focusRequester, Continuation<? super BottomSheetDialogKt$DSBottomSheetDialog$1$1> continuation) {
        super(2, continuation);
        this.$visible = z;
        this.$focusRequester = focusRequester;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetDialogKt$DSBottomSheetDialog$1$1(this.$visible, this.$focusRequester, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$visible) {
                    this.label = 1;
                    if (DelayKt.delay(10L, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    FocusRequester.requestFocus-3ESFkO8$default(this.$focusRequester, 0, 1, (Object) null);
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                FocusRequester.requestFocus-3ESFkO8$default(this.$focusRequester, 0, 1, (Object) null);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}