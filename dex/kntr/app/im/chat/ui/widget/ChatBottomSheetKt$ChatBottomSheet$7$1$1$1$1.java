package kntr.app.im.chat.ui.widget;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$ChatBottomSheet$7$1$1$1$1", f = "ChatBottomSheet.kt", i = {}, l = {139, 143}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatBottomSheetKt$ChatBottomSheet$7$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatMediaSelectBottomSheetState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$ChatBottomSheet$7$1$1$1$1(ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState, Continuation<? super ChatBottomSheetKt$ChatBottomSheet$7$1$1$1$1> continuation) {
        super(2, continuation);
        this.$state = chatMediaSelectBottomSheetState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$ChatBottomSheet$7$1$1$1$1(this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$state.getAnchoredDraggableState$ui_debug().getCurrentValue() == ChatMediaSelectSheetState.PartiallyExpanded && this.$state.isEnableExpand()) {
                    this.label = 1;
                    if (AnchoredDraggableKt.animateTo$default(this.$state.getAnchoredDraggableState$ui_debug(), ChatMediaSelectSheetState.Expanded, (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    if (AnchoredDraggableKt.animateTo$default(this.$state.getAnchoredDraggableState$ui_debug(), ChatMediaSelectSheetState.PartiallyExpanded, (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}