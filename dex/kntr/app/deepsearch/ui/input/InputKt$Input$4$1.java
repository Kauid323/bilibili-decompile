package kntr.app.deepsearch.ui.input;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.runtime.MutableLongState;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.input.InputKt$Input$4$1", f = "Input.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InputKt$Input$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InputState $inputState;
    final /* synthetic */ MutableLongState $inputVersion$delegate;
    final /* synthetic */ TextFieldState $textState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputKt$Input$4$1(InputState inputState, TextFieldState textFieldState, MutableLongState mutableLongState, Continuation<? super InputKt$Input$4$1> continuation) {
        super(2, continuation);
        this.$inputState = inputState;
        this.$textState = textFieldState;
        this.$inputVersion$delegate = mutableLongState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputKt$Input$4$1(this.$inputState, this.$textState, this.$inputVersion$delegate, continuation);
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
                if (!Intrinsics.areEqual(this.$inputState.getInput(), this.$textState.getText().toString())) {
                    long version = this.$inputState.getInputHolder().getVersion();
                    Input$lambda$1 = InputKt.Input$lambda$1(this.$inputVersion$delegate);
                    if (version >= Input$lambda$1 - 1) {
                        TextFieldStateKt.setTextAndPlaceCursorAtEnd(this.$textState, this.$inputState.getInput());
                        long version2 = this.$inputState.getInputHolder().getVersion();
                        Input$lambda$12 = InputKt.Input$lambda$1(this.$inputVersion$delegate);
                        if (version2 > Input$lambda$12) {
                            this.$inputVersion$delegate.setLongValue(this.$inputState.getInputHolder().getVersion());
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}