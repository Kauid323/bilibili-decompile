package kntr.app.live.room.combo.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: TotalCountDownTimer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/live/room/combo/utils/TotalCountDownTimer;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "innerFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "createFlow", "restart", "duration", RoomRecommendViewModel.EMPTY_CURSOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TotalCountDownTimer {
    private final MutableSharedFlow<Flow<Unit>> innerFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);

    public final Flow<Unit> createFlow() {
        Flow $this$flatMapLatest$iv = this.innerFlow;
        return FlowKt.transformLatest($this$flatMapLatest$iv, new TotalCountDownTimer$createFlow$$inlined$flatMapLatest$1(null));
    }

    public final Object restart(long duration, Continuation<? super Unit> continuation) {
        Object emit = this.innerFlow.emit(FlowKt.flow(new TotalCountDownTimer$restart$2(duration, null)), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}