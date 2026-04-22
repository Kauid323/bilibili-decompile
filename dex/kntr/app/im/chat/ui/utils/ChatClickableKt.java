package kntr.app.im.chat.ui.utils;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatClickable.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\n\u001a:\u0010\u000b\u001a\u00020\f*\u00020\f2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¨\u0006\r"}, d2 = {"detectTapGesturesInChat", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;", "detectTapPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onLongPress", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", RoomRecommendViewModel.EMPTY_CURSOR, "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chatClickable", "Landroidx/compose/ui/Modifier;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatClickableKt {
    public static /* synthetic */ Object detectTapGesturesInChat$default(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        return detectTapGesturesInChat(pointerInputScope, pointerEventPass, function1, function12, continuation);
    }

    public static final Object detectTapGesturesInChat(PointerInputScope $this$detectTapGesturesInChat, PointerEventPass detectTapPass, Function1<? super Offset, Boolean> function1, Function1<? super Offset, Boolean> function12, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectTapGesturesInChat, new ChatClickableKt$detectTapGesturesInChat$2(function12, function1, detectTapPass, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier chatClickable$default(Modifier modifier, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return chatClickable(modifier, function1, function12);
    }

    public static final Modifier chatClickable(Modifier $this$chatClickable, final Function1<? super Offset, Boolean> function1, final Function1<? super Offset, Boolean> function12) {
        Intrinsics.checkNotNullParameter($this$chatClickable, "<this>");
        return SuspendingPointerInputFilterKt.pointerInput($this$chatClickable, Unit.INSTANCE, new PointerInputEventHandler() { // from class: kntr.app.im.chat.ui.utils.ChatClickableKt$chatClickable$1
            public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                Object detectTapGesturesInChat$default = ChatClickableKt.detectTapGesturesInChat$default($this$pointerInput, null, function1, function12, continuation, 1, null);
                return detectTapGesturesInChat$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGesturesInChat$default : Unit.INSTANCE;
            }
        });
    }
}