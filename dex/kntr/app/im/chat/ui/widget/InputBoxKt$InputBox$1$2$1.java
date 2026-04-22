package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.utils.ChatClickableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputBox.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class InputBoxKt$InputBox$1$2$1 implements PointerInputEventHandler {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputBoxKt$InputBox$1$2$1(CoroutineScope coroutineScope, ChatActionHandler chatActionHandler) {
        this.$scope = coroutineScope;
        this.$actionHandler = chatActionHandler;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        PointerEventPass pointerEventPass = PointerEventPass.Initial;
        final CoroutineScope coroutineScope = this.$scope;
        final ChatActionHandler chatActionHandler = this.$actionHandler;
        Object detectTapGesturesInChat$default = ChatClickableKt.detectTapGesturesInChat$default($this$pointerInput, pointerEventPass, null, new Function1() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$InputBox$1$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = InputBoxKt$InputBox$1$2$1.invoke$lambda$0(coroutineScope, chatActionHandler, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$0);
            }
        }, continuation, 2, null);
        return detectTapGesturesInChat$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGesturesInChat$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(CoroutineScope $scope, ChatActionHandler $actionHandler, Offset it) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InputBoxKt$InputBox$1$2$1$1$1($actionHandler, null), 3, (Object) null);
        return false;
    }
}