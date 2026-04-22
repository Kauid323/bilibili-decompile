package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.State;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$PictureContent$1$1", f = "ChatBottomSheet.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatBottomSheetKt$PictureContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ AphroState $aphroState;
    final /* synthetic */ State<Function0<Unit>> $onDismissRequestEffect;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$PictureContent$1$1(AphroState aphroState, State<? extends Function0<Unit>> state, ChatActionHandler chatActionHandler, Continuation<? super ChatBottomSheetKt$PictureContent$1$1> continuation) {
        super(2, continuation);
        this.$aphroState = aphroState;
        this.$onDismissRequestEffect = state;
        this.$actionHandler = chatActionHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$PictureContent$1$1(this.$aphroState, this.$onDismissRequestEffect, this.$actionHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$aphroState.getConfirmed() && this.$aphroState.getOption().getDismissOnConfirm()) {
                    ((Function0) this.$onDismissRequestEffect.getValue()).invoke();
                    this.label = 1;
                    if (this.$actionHandler.invoke(new DispatchAphroAction(AphroAction.ConsumeConfirm.INSTANCE), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}