package kntr.app.im.chat.ui.widget;

import androidx.compose.foundation.lazy.LazyListState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopupBubbleMenu.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$2$1$1$1", f = "PopupBubbleMenu.kt", i = {0}, l = {705}, m = "invokeSuspend", n = {"targetIndex"}, s = {"I$0"}, v = 1)
public final class PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $arrowButtonWidth;
    final /* synthetic */ LazyListState $lazyListState;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$2$1$1$1(LazyListState lazyListState, int i, Continuation<? super PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$2$1$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$arrowButtonWidth = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$2$1$1$1(this.$lazyListState, this.$arrowButtonWidth, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int targetIndex = RangesKt.coerceAtMost(this.$lazyListState.getFirstVisibleItemIndex() + ((this.$lazyListState.getLayoutInfo().getVisibleItemsInfo().size() * 2) / 3), this.$lazyListState.getLayoutInfo().getTotalItemsCount() - 1);
                this.I$0 = targetIndex;
                this.label = 1;
                if (this.$lazyListState.animateScrollToItem(targetIndex, -this.$arrowButtonWidth, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                int i = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}