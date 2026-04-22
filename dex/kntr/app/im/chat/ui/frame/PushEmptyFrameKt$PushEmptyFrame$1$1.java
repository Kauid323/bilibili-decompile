package kntr.app.im.chat.ui.frame;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.frame.push.PushEmptyFrame;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.utils.ChatClickableKt;
import kntr.app.im.chat.ui.widget.PopupState;
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
/* compiled from: PushEmptyFrame.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class PushEmptyFrameKt$PushEmptyFrame$1$1 implements PointerInputEventHandler {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ PushEmptyFrame $empty;
    final /* synthetic */ EntityMessage $message;
    final /* synthetic */ PopupState $popupState;
    final /* synthetic */ ChatReporter $reporter;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushEmptyFrameKt$PushEmptyFrame$1$1(PushEmptyFrame pushEmptyFrame, PopupState popupState, CoroutineScope coroutineScope, ChatActionHandler chatActionHandler, ChatReporter chatReporter, EntityMessage entityMessage) {
        this.$empty = pushEmptyFrame;
        this.$popupState = popupState;
        this.$scope = coroutineScope;
        this.$actionHandler = chatActionHandler;
        this.$reporter = chatReporter;
        this.$message = entityMessage;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        PointerEventPass pointerEventPass = PointerEventPass.Initial;
        final PushEmptyFrame pushEmptyFrame = this.$empty;
        final PopupState popupState = this.$popupState;
        Function1 function1 = new Function1() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = PushEmptyFrameKt$PushEmptyFrame$1$1.invoke$lambda$0(PushEmptyFrame.this, popupState, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$0);
            }
        };
        final CoroutineScope coroutineScope = this.$scope;
        final PushEmptyFrame pushEmptyFrame2 = this.$empty;
        final ChatActionHandler chatActionHandler = this.$actionHandler;
        final ChatReporter chatReporter = this.$reporter;
        final EntityMessage entityMessage = this.$message;
        Object detectTapGesturesInChat = ChatClickableKt.detectTapGesturesInChat($this$pointerInput, pointerEventPass, function1, new Function1() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$1$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean invoke$lambda$1;
                invoke$lambda$1 = PushEmptyFrameKt$PushEmptyFrame$1$1.invoke$lambda$1(coroutineScope, pushEmptyFrame2, chatActionHandler, chatReporter, entityMessage, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$1);
            }
        }, continuation);
        return detectTapGesturesInChat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGesturesInChat : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1(CoroutineScope $scope, PushEmptyFrame $empty, ChatActionHandler $actionHandler, ChatReporter $reporter, EntityMessage $message, Offset it) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PushEmptyFrameKt$PushEmptyFrame$1$1$2$1($actionHandler, $empty, $reporter, $message, null), 3, (Object) null);
        return $empty.getValue().getUrl().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(PushEmptyFrame $empty, PopupState $popupState, Offset it) {
        if (!$empty.getValue().getMenuItems().isEmpty()) {
            $popupState.setVisible(true);
        }
        return true;
    }
}