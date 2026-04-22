package kntr.app.tribee.publish.internal;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeyboardAnimationState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.internal.KeyboardAnimationStateKt$rememberKeyboardAnimationState$1$1", f = "KeyboardAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KeyboardAnimationStateKt$rememberKeyboardAnimationState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<KeyboardAnimationState> $animationState$delegate;
    final /* synthetic */ int $imeHeight;
    final /* synthetic */ MutableIntState $previousHeight$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardAnimationStateKt$rememberKeyboardAnimationState$1$1(int i, MutableIntState mutableIntState, MutableState<KeyboardAnimationState> mutableState, Continuation<? super KeyboardAnimationStateKt$rememberKeyboardAnimationState$1$1> continuation) {
        super(2, continuation);
        this.$imeHeight = i;
        this.$previousHeight$delegate = mutableIntState;
        this.$animationState$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KeyboardAnimationStateKt$rememberKeyboardAnimationState$1$1(this.$imeHeight, this.$previousHeight$delegate, this.$animationState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int rememberKeyboardAnimationState$lambda$4;
        int rememberKeyboardAnimationState$lambda$42;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int currentHeight = this.$imeHeight;
                rememberKeyboardAnimationState$lambda$4 = KeyboardAnimationStateKt.rememberKeyboardAnimationState$lambda$4(this.$previousHeight$delegate);
                if (currentHeight <= rememberKeyboardAnimationState$lambda$4) {
                    rememberKeyboardAnimationState$lambda$42 = KeyboardAnimationStateKt.rememberKeyboardAnimationState$lambda$4(this.$previousHeight$delegate);
                    if (currentHeight < rememberKeyboardAnimationState$lambda$42) {
                        this.$animationState$delegate.setValue(KeyboardAnimationState.Closing);
                    }
                } else {
                    this.$animationState$delegate.setValue(KeyboardAnimationState.Opening);
                }
                this.$previousHeight$delegate.setIntValue(currentHeight);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}