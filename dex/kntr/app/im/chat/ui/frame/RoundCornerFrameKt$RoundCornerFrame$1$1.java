package kntr.app.im.chat.ui.frame;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.frame.rounded.RoundedCornerFrame;
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
/* compiled from: RoundCornerFrame.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class RoundCornerFrameKt$RoundCornerFrame$1$1 implements PointerInputEventHandler {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ EntityMessage $message;
    final /* synthetic */ PopupState $popupState;
    final /* synthetic */ ChatReporter $reporter;
    final /* synthetic */ RoundedCornerFrame $roundCorner;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundCornerFrameKt$RoundCornerFrame$1$1(RoundedCornerFrame roundedCornerFrame, PopupState popupState, CoroutineScope coroutineScope, ChatActionHandler chatActionHandler, ChatReporter chatReporter, EntityMessage entityMessage) {
        this.$roundCorner = roundedCornerFrame;
        this.$popupState = popupState;
        this.$scope = coroutineScope;
        this.$actionHandler = chatActionHandler;
        this.$reporter = chatReporter;
        this.$message = entityMessage;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final RoundedCornerFrame roundedCornerFrame = this.$roundCorner;
        final PopupState popupState = this.$popupState;
        Function1 function1 = new Function1() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = RoundCornerFrameKt$RoundCornerFrame$1$1.invoke$lambda$0(RoundedCornerFrame.this, popupState, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$0);
            }
        };
        final CoroutineScope coroutineScope = this.$scope;
        final RoundedCornerFrame roundedCornerFrame2 = this.$roundCorner;
        final ChatActionHandler chatActionHandler = this.$actionHandler;
        final ChatReporter chatReporter = this.$reporter;
        final EntityMessage entityMessage = this.$message;
        Object detectTapGesturesInChat$default = ChatClickableKt.detectTapGesturesInChat$default($this$pointerInput, null, function1, new Function1() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$1$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean invoke$lambda$1;
                invoke$lambda$1 = RoundCornerFrameKt$RoundCornerFrame$1$1.invoke$lambda$1(coroutineScope, roundedCornerFrame2, chatActionHandler, chatReporter, entityMessage, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$1);
            }
        }, continuation, 1, null);
        return detectTapGesturesInChat$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGesturesInChat$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1(CoroutineScope $scope, RoundedCornerFrame $roundCorner, ChatActionHandler $actionHandler, ChatReporter $reporter, EntityMessage $message, Offset it) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoundCornerFrameKt$RoundCornerFrame$1$1$2$1($actionHandler, $roundCorner, $reporter, $message, null), 3, (Object) null);
        return $roundCorner.getValue().getUrl().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(RoundedCornerFrame $roundCorner, PopupState $popupState, Offset it) {
        if (!$roundCorner.getValue().getMenuItems().isEmpty()) {
            $popupState.setVisible(true);
        }
        return true;
    }
}