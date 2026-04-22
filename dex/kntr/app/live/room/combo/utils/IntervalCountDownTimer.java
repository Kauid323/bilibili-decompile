package kntr.app.live.room.combo.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: IntervalCountDownTimer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/live/room/combo/utils/IntervalCountDownTimer;", RoomRecommendViewModel.EMPTY_CURSOR, "totalMilliseconds", RoomRecommendViewModel.EMPTY_CURSOR, "intervalMilliseconds", "<init>", "(JJ)V", "_step", RoomRecommendViewModel.EMPTY_CURSOR, "get_step", "()I", "step", "totalStep", "createFlow", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "reset", RoomRecommendViewModel.EMPTY_CURSOR, "update", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntervalCountDownTimer {
    private long intervalMilliseconds;
    private long totalMilliseconds;
    private int step = get_step();
    private int totalStep = this.step;

    public IntervalCountDownTimer(long totalMilliseconds, long intervalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;
        this.intervalMilliseconds = intervalMilliseconds;
    }

    private final int get_step() {
        if (this.totalMilliseconds == 0 && this.intervalMilliseconds == 0) {
            return -1;
        }
        if (this.totalMilliseconds == 0) {
            return Integer.MAX_VALUE;
        }
        return (int) ((((float) (this.totalMilliseconds / this.intervalMilliseconds)) * 1.0f) + 0.5f);
    }

    public final Flow<Float> createFlow() {
        return FlowKt.flow(new IntervalCountDownTimer$createFlow$1(this, null));
    }

    public final void reset() {
        this.step = get_step();
        this.totalStep = this.step;
    }

    public final void update(long totalMilliseconds, long intervalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;
        this.intervalMilliseconds = intervalMilliseconds;
        this.step = get_step();
        this.totalStep = this.step;
    }
}