package kntr.app.im.chat.ui.utils;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatClickable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.utils.ChatClickableKt$detectTapGesturesInChat$2", f = "ChatClickable.kt", i = {0, 1, 1, 1}, l = {26, 35}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "longPressTimeout"}, s = {"L$0", "L$0", "L$1", "J$0"}, v = 1)
public final class ChatClickableKt$detectTapGesturesInChat$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PointerEventPass $detectTapPass;
    final /* synthetic */ Function1<Offset, Boolean> $onLongPress;
    final /* synthetic */ Function1<Offset, Boolean> $onTap;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatClickableKt$detectTapGesturesInChat$2(Function1<? super Offset, Boolean> function1, Function1<? super Offset, Boolean> function12, PointerEventPass pointerEventPass, Continuation<? super ChatClickableKt$detectTapGesturesInChat$2> continuation) {
        super(2, continuation);
        this.$onTap = function1;
        this.$onLongPress = function12;
        this.$detectTapPass = pointerEventPass;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatClickableKt$detectTapGesturesInChat$2 = new ChatClickableKt$detectTapGesturesInChat$2(this.$onTap, this.$onLongPress, this.$detectTapPass, continuation);
        chatClickableKt$detectTapGesturesInChat$2.L$0 = obj;
        return chatClickableKt$detectTapGesturesInChat$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|2|39|40|41|(1:43)(6:44|10|11|(0)|22|23)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[Catch: PointerEventTimeoutCancellationException -> 0x009a, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x009a, blocks: (B:20:0x0071, B:22:0x0076, B:24:0x007a, B:29:0x0093), top: B:48:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object awaitFirstDown;
        PointerInputChange down;
        Object obj;
        PointerInputChange down2;
        PointerInputChange upOrCancel;
        AwaitPointerEventScope $this$awaitEachGesture = (AwaitPointerEventScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$awaitEachGesture;
                this.label = 1;
                awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitEachGesture, false, PointerEventPass.Initial, (Continuation) this);
                if (awaitFirstDown == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                awaitFirstDown = $result;
                break;
            case 2:
                long j2 = this.J$0;
                down = (PointerInputChange) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    down2 = down;
                    obj = $result;
                    try {
                        upOrCancel = (PointerInputChange) obj;
                        if (upOrCancel != null) {
                            Function1<Offset, Boolean> function1 = this.$onTap;
                            if (function1 != null && ((Boolean) function1.invoke(Offset.box-impl(upOrCancel.getPosition-F1C5BW0()))).booleanValue()) {
                                down2.consume();
                                upOrCancel.consume();
                            }
                        }
                    } catch (PointerEventTimeoutCancellationException e) {
                        down = down2;
                        if (!down.isConsumed()) {
                            Function1<Offset, Boolean> function12 = this.$onLongPress;
                            if (function12 == null || !((Boolean) function12.invoke(Offset.box-impl(down.getPosition-F1C5BW0()))).booleanValue()) {
                                z = false;
                            }
                            if (z) {
                                down.consume();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } catch (PointerEventTimeoutCancellationException e2) {
                    if (!down.isConsumed()) {
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        down = (PointerInputChange) awaitFirstDown;
        long longPressTimeout = $this$awaitEachGesture.getViewConfiguration().getLongPressTimeoutMillis();
        this.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitEachGesture);
        this.L$1 = down;
        this.J$0 = longPressTimeout;
        this.label = 2;
        Object withTimeout = $this$awaitEachGesture.withTimeout(longPressTimeout, new ChatClickableKt$detectTapGesturesInChat$2$upOrCancel$1(this.$detectTapPass, null), (Continuation) this);
        if (withTimeout == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj = withTimeout;
        down2 = down;
        upOrCancel = (PointerInputChange) obj;
        if (upOrCancel != null) {
        }
        return Unit.INSTANCE;
    }
}