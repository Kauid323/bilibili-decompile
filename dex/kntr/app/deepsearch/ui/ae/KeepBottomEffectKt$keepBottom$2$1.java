package kntr.app.deepsearch.ui.ae;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeepBottomEffect.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$2$1", f = "KeepBottomEffect.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KeepBottomEffectKt$keepBottom$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isAtBottom$delegate;
    final /* synthetic */ LazyListState $this_keepBottom;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeepBottomEffectKt$keepBottom$2$1(LazyListState lazyListState, MutableState<Boolean> mutableState, Continuation<? super KeepBottomEffectKt$keepBottom$2$1> continuation) {
        super(2, continuation);
        this.$this_keepBottom = lazyListState;
        this.$isAtBottom$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KeepBottomEffectKt$keepBottom$2$1(this.$this_keepBottom, this.$isAtBottom$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyListState lazyListState = this.$this_keepBottom;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean canScrollForward;
                        canScrollForward = lazyListState.getCanScrollForward();
                        return Boolean.valueOf(canScrollForward);
                    }
                });
                final MutableState<Boolean> mutableState = this.$isAtBottom$delegate;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                        KeepBottomEffectKt.keepBottom$lambda$6(mutableState, !it);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
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