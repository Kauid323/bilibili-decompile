package kntr.app.deepsearch.ui.ae;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentList;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
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
/* compiled from: KeepBottomEffect.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$1$1", f = "KeepBottomEffect.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KeepBottomEffectKt$keepBottom$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Integer> $layoutCount$delegate;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ DeepSearchContentList $list;
    final /* synthetic */ MutableState<Boolean> $shouldAutoScroll$delegate;
    final /* synthetic */ LazyListState $this_keepBottom;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeepBottomEffectKt$keepBottom$1$1(LazyListState lazyListState, DeepSearchContentList deepSearchContentList, Lifecycle lifecycle, MutableState<Boolean> mutableState, State<Integer> state, Continuation<? super KeepBottomEffectKt$keepBottom$1$1> continuation) {
        super(2, continuation);
        this.$this_keepBottom = lazyListState;
        this.$list = deepSearchContentList;
        this.$lifecycle = lifecycle;
        this.$shouldAutoScroll$delegate = mutableState;
        this.$layoutCount$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KeepBottomEffectKt$keepBottom$1$1(this.$this_keepBottom, this.$list, this.$lifecycle, this.$shouldAutoScroll$delegate, this.$layoutCount$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean keepBottom$lambda$1;
        boolean keepBottom$lambda$12;
        int keepBottom$lambda$8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$this_keepBottom.getCanScrollForward() && !this.$this_keepBottom.isScrollInProgress()) {
                    KeepBottomEffectKt.keepBottom$lambda$2(this.$shouldAutoScroll$delegate, true);
                }
                ILogger kLog = KLog_androidKt.getKLog();
                int size = this.$list.getList().size();
                Lifecycle.State currentState = this.$lifecycle.getCurrentState();
                keepBottom$lambda$1 = KeepBottomEffectKt.keepBottom$lambda$1(this.$shouldAutoScroll$delegate);
                kLog.i("keep_bottom", "list.size=" + size + ", life=" + currentState + "， should_auto_scroll=" + keepBottom$lambda$1 + ", isScrollInProgress=" + this.$this_keepBottom.isScrollInProgress() + ", ");
                if (!this.$this_keepBottom.isScrollInProgress()) {
                    keepBottom$lambda$12 = KeepBottomEffectKt.keepBottom$lambda$1(this.$shouldAutoScroll$delegate);
                    if (keepBottom$lambda$12) {
                        keepBottom$lambda$8 = KeepBottomEffectKt.keepBottom$lambda$8(this.$layoutCount$delegate);
                        if (keepBottom$lambda$8 > 0) {
                            this.label = 1;
                            if (this.$this_keepBottom.scrollToItem(this.$this_keepBottom.getLayoutInfo().getTotalItemsCount() - 1, Integer.MAX_VALUE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
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