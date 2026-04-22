package kntr.app.im.chat.ui.widget.sticky;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Confirmdialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.sticky.ConfirmdialogKt$ConfirmDialog$1$2$1", f = "Confirmdialog.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ConfirmdialogKt$ConfirmDialog$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnConfirmDialogAction $onAction;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ ConfirmDialogType $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmdialogKt$ConfirmDialog$1$2$1(OnConfirmDialogAction onConfirmDialogAction, ConfirmDialogType confirmDialogType, Function0<Unit> function0, Continuation<? super ConfirmdialogKt$ConfirmDialog$1$2$1> continuation) {
        super(2, continuation);
        this.$onAction = onConfirmDialogAction;
        this.$type = confirmDialogType;
        this.$onDismiss = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfirmdialogKt$ConfirmDialog$1$2$1(this.$onAction, this.$type, this.$onDismiss, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$onAction.invoke(this.$type.getAction(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$onDismiss.invoke();
        return Unit.INSTANCE;
    }
}