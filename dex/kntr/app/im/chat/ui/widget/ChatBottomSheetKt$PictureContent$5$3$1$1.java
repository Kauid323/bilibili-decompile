package kntr.app.im.chat.ui.widget;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import kntr.app.im.chat.stateMachine.builder.DispatchAphroAction;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
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
/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$PictureContent$5$3$1$1", f = "ChatBottomSheet.kt", i = {1}, l = {367, 381}, m = "invokeSuspend", n = {"intercepted"}, s = {"I$0"}, v = 1)
public final class ChatBottomSheetKt$PictureContent$5$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AphroAction $action;
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ AphroState $aphroState;
    final /* synthetic */ ChatMediaSelectBottomSheetState $state;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$PictureContent$5$3$1$1(AphroAction aphroAction, AphroState aphroState, ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState, ChatActionHandler chatActionHandler, Continuation<? super ChatBottomSheetKt$PictureContent$5$3$1$1> continuation) {
        super(2, continuation);
        this.$action = aphroAction;
        this.$aphroState = aphroState;
        this.$state = chatMediaSelectBottomSheetState;
        this.$actionHandler = chatActionHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$PictureContent$5$3$1$1(this.$action, this.$aphroState, this.$state, this.$actionHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$action instanceof AphroAction.ConfirmSelection) {
                    if (!this.$aphroState.getOption().getDismissOnConfirm()) {
                        this.label = 1;
                        if (AnchoredDraggableKt.animateTo$default(this.$state.getAnchoredDraggableState$ui_debug(), ChatMediaSelectSheetState.PartiallyExpanded, (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        i2 = 0;
                        break;
                    }
                } else {
                    i2 = 0;
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                i = this.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = i2;
        if (i3 == 0) {
            this.I$0 = i3;
            this.label = 2;
            if (this.$actionHandler.invoke(new DispatchAphroAction(this.$action), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i3;
        }
        return Unit.INSTANCE;
    }
}