package kntr.app.im.chat.ui.frame;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrame;
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
/* compiled from: ChatBubbleFrame.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ChatBubbleFrameKt$ChatBubble$1$1 implements PointerInputEventHandler {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ ChatBubbleFrame $chatBubble;
    final /* synthetic */ LifecycleOwner $lifecycle;
    final /* synthetic */ EntityMessage $message;
    final /* synthetic */ PopupState $popupState;
    final /* synthetic */ ChatReporter $reporter;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatBubbleFrameKt$ChatBubble$1$1(ChatBubbleFrame chatBubbleFrame, LifecycleOwner lifecycleOwner, PopupState popupState, CoroutineScope coroutineScope, ChatActionHandler chatActionHandler, ChatReporter chatReporter, EntityMessage entityMessage) {
        this.$chatBubble = chatBubbleFrame;
        this.$lifecycle = lifecycleOwner;
        this.$popupState = popupState;
        this.$scope = coroutineScope;
        this.$actionHandler = chatActionHandler;
        this.$reporter = chatReporter;
        this.$message = entityMessage;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final ChatBubbleFrame chatBubbleFrame = this.$chatBubble;
        final LifecycleOwner lifecycleOwner = this.$lifecycle;
        final PopupState popupState = this.$popupState;
        Function1 function1 = new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = ChatBubbleFrameKt$ChatBubble$1$1.invoke$lambda$0(ChatBubbleFrame.this, lifecycleOwner, popupState, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$0);
            }
        };
        final CoroutineScope coroutineScope = this.$scope;
        final ChatBubbleFrame chatBubbleFrame2 = this.$chatBubble;
        final ChatActionHandler chatActionHandler = this.$actionHandler;
        final ChatReporter chatReporter = this.$reporter;
        final EntityMessage entityMessage = this.$message;
        Object detectTapGesturesInChat$default = ChatClickableKt.detectTapGesturesInChat$default($this$pointerInput, null, function1, new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble$1$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean invoke$lambda$1;
                invoke$lambda$1 = ChatBubbleFrameKt$ChatBubble$1$1.invoke$lambda$1(coroutineScope, chatBubbleFrame2, chatActionHandler, chatReporter, entityMessage, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$1);
            }
        }, continuation, 1, null);
        return detectTapGesturesInChat$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGesturesInChat$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1(CoroutineScope $scope, ChatBubbleFrame $chatBubble, ChatActionHandler $actionHandler, ChatReporter $reporter, EntityMessage $message, Offset it) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBubbleFrameKt$ChatBubble$1$1$2$1($actionHandler, $chatBubble, $reporter, $message, null), 3, (Object) null);
        return $chatBubble.getValue().getUrl().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(ChatBubbleFrame $chatBubble, LifecycleOwner $lifecycle, PopupState $popupState, Offset it) {
        if (!$chatBubble.getValue().getMenuItems().isEmpty() && $lifecycle.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            $popupState.setVisible(true);
        }
        return true;
    }
}