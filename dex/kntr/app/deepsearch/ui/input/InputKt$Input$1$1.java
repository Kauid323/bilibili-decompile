package kntr.app.deepsearch.ui.input;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.MutableLongState;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.input.InputKt$Input$1$1", f = "Input.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InputKt$Input$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DeepSearchAction.InputAction, Unit> $actionHandler;
    final /* synthetic */ MutableLongState $inputVersion$delegate;
    final /* synthetic */ TextFieldState $textState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InputKt$Input$1$1(Function1<? super DeepSearchAction.InputAction, Unit> function1, TextFieldState textFieldState, MutableLongState mutableLongState, Continuation<? super InputKt$Input$1$1> continuation) {
        super(2, continuation);
        this.$actionHandler = function1;
        this.$textState = textFieldState;
        this.$inputVersion$delegate = mutableLongState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputKt$Input$1$1(this.$actionHandler, this.$textState, this.$inputVersion$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long Input$lambda$1;
        long Input$lambda$12;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<DeepSearchAction.InputAction, Unit> function1 = this.$actionHandler;
                String obj = this.$textState.getText().toString();
                Input$lambda$1 = InputKt.Input$lambda$1(this.$inputVersion$delegate);
                function1.invoke(new DeepSearchAction.InputAction.InputChange(obj, Input$lambda$1));
                MutableLongState mutableLongState = this.$inputVersion$delegate;
                Input$lambda$12 = InputKt.Input$lambda$1(this.$inputVersion$delegate);
                mutableLongState.setLongValue(Input$lambda$12 + 1);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}