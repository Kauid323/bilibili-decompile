package kntr.app.im.chat.ui.utils;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatClickable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.utils.ChatClickableKt$detectTapGesturesInChat$2$upOrCancel$1", f = "ChatClickable.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"$this$withTimeout"}, s = {"L$0"}, v = 1)
public final class ChatClickableKt$detectTapGesturesInChat$2$upOrCancel$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
    final /* synthetic */ PointerEventPass $detectTapPass;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatClickableKt$detectTapGesturesInChat$2$upOrCancel$1(PointerEventPass pointerEventPass, Continuation<? super ChatClickableKt$detectTapGesturesInChat$2$upOrCancel$1> continuation) {
        super(2, continuation);
        this.$detectTapPass = pointerEventPass;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatClickableKt$detectTapGesturesInChat$2$upOrCancel$1 = new ChatClickableKt$detectTapGesturesInChat$2$upOrCancel$1(this.$detectTapPass, continuation);
        chatClickableKt$detectTapGesturesInChat$2$upOrCancel$1.L$0 = obj;
        return chatClickableKt$detectTapGesturesInChat$2$upOrCancel$1;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$withTimeout);
                this.label = 1;
                Object waitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$withTimeout, this.$detectTapPass, (Continuation) this);
                if (waitForUpOrCancellation == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return waitForUpOrCancellation;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}