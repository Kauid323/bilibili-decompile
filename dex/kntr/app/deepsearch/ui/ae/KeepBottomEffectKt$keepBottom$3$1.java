package kntr.app.deepsearch.ui.ae;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeepBottomEffect.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$3$1", f = "KeepBottomEffect.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KeepBottomEffectKt$keepBottom$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $pageVisibility;
    final /* synthetic */ MutableState<Boolean> $shouldAutoScroll$delegate;
    final /* synthetic */ LazyListState $this_keepBottom;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeepBottomEffectKt$keepBottom$3$1(State<Boolean> state, LazyListState lazyListState, MutableState<Boolean> mutableState, Continuation<? super KeepBottomEffectKt$keepBottom$3$1> continuation) {
        super(2, continuation);
        this.$pageVisibility = state;
        this.$this_keepBottom = lazyListState;
        this.$shouldAutoScroll$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KeepBottomEffectKt$keepBottom$3$1(this.$pageVisibility, this.$this_keepBottom, this.$shouldAutoScroll$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((Boolean) this.$pageVisibility.getValue()).booleanValue()) {
                    Flow interactions = this.$this_keepBottom.getInteractionSource().getInteractions();
                    final LazyListState lazyListState = this.$this_keepBottom;
                    final MutableState<Boolean> mutableState = this.$shouldAutoScroll$delegate;
                    this.label = 1;
                    if (interactions.collect(new FlowCollector() { // from class: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$3$1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Interaction) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Interaction it, Continuation<? super Unit> continuation) {
                            if ((it instanceof DragInteraction.Start) || (it instanceof PressInteraction.Press)) {
                                KeepBottomEffectKt.keepBottom$lambda$2(mutableState, false);
                            } else if ((it instanceof DragInteraction.Stop) || (it instanceof DragInteraction.Cancel) || (it instanceof PressInteraction.Cancel) || (it instanceof PressInteraction.Release)) {
                                KeepBottomEffectKt.keepBottom$lambda$2(mutableState, !lazyListState.getCanScrollForward());
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
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