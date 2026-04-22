package kntr.app.im.chat.ui.frame;

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
/* compiled from: ChatBubbleFrame.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$awaitSecondDown$2", f = "ChatBubbleFrame.kt", i = {0, 0, 0}, l = {515}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "change", "minUptime"}, s = {"L$0", "L$1", "J$0"}, v = 1)
public final class ChatBubbleFrameKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
    final /* synthetic */ PointerInputChange $firstUp;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBubbleFrameKt$awaitSecondDown$2(PointerInputChange pointerInputChange, Continuation<? super ChatBubbleFrameKt$awaitSecondDown$2> continuation) {
        super(2, continuation);
        this.$firstUp = pointerInputChange;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatBubbleFrameKt$awaitSecondDown$2 = new ChatBubbleFrameKt$awaitSecondDown$2(this.$firstUp, continuation);
        chatBubbleFrameKt$awaitSecondDown$2.L$0 = obj;
        return chatBubbleFrameKt$awaitSecondDown$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0058 -> B:12:0x005c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChatBubbleFrameKt$awaitSecondDown$2 chatBubbleFrameKt$awaitSecondDown$2;
        AwaitPointerEventScope $this$withTimeoutOrNull;
        Object obj;
        long minUptime;
        PointerInputChange change;
        Object $result2;
        AwaitPointerEventScope $this$withTimeoutOrNull2 = (AwaitPointerEventScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long minUptime2 = this.$firstUp.getUptimeMillis() + $this$withTimeoutOrNull2.getViewConfiguration().getDoubleTapMinTimeMillis();
                chatBubbleFrameKt$awaitSecondDown$2 = this;
                $this$withTimeoutOrNull = $this$withTimeoutOrNull2;
                obj = coroutine_suspended;
                minUptime = minUptime2;
                change = null;
                chatBubbleFrameKt$awaitSecondDown$2.L$0 = $this$withTimeoutOrNull;
                chatBubbleFrameKt$awaitSecondDown$2.L$1 = SpillingKt.nullOutSpilledVariable(change);
                chatBubbleFrameKt$awaitSecondDown$2.J$0 = minUptime;
                chatBubbleFrameKt$awaitSecondDown$2.label = 1;
                Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$withTimeoutOrNull, false, (PointerEventPass) null, (Continuation) chatBubbleFrameKt$awaitSecondDown$2, 3, (Object) null);
                if (awaitFirstDown$default != obj) {
                    return obj;
                }
                $result2 = $result;
                $result = awaitFirstDown$default;
                change = (PointerInputChange) $result;
                if (change.getUptimeMillis() >= minUptime) {
                    $result = $result2;
                    chatBubbleFrameKt$awaitSecondDown$2.L$0 = $this$withTimeoutOrNull;
                    chatBubbleFrameKt$awaitSecondDown$2.L$1 = SpillingKt.nullOutSpilledVariable(change);
                    chatBubbleFrameKt$awaitSecondDown$2.J$0 = minUptime;
                    chatBubbleFrameKt$awaitSecondDown$2.label = 1;
                    Object awaitFirstDown$default2 = TapGestureDetectorKt.awaitFirstDown$default($this$withTimeoutOrNull, false, (PointerEventPass) null, (Continuation) chatBubbleFrameKt$awaitSecondDown$2, 3, (Object) null);
                    if (awaitFirstDown$default2 != obj) {
                    }
                } else {
                    return change;
                }
            case 1:
                long minUptime3 = this.J$0;
                PointerInputChange pointerInputChange = (PointerInputChange) this.L$1;
                ResultKt.throwOnFailure($result);
                chatBubbleFrameKt$awaitSecondDown$2 = this;
                $this$withTimeoutOrNull = $this$withTimeoutOrNull2;
                obj = coroutine_suspended;
                minUptime = minUptime3;
                $result2 = $result;
                change = (PointerInputChange) $result;
                if (change.getUptimeMillis() >= minUptime) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}