package kntr.app.live.room.combo.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntervalCountDownTimer.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/flow/FlowCollector;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.utils.IntervalCountDownTimer$createFlow$1", f = "IntervalCountDownTimer.kt", i = {0, 1, 2, 3, 4}, l = {51, 54, 56, 62, 66}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "$this$flow", "$this$flow"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"}, v = 1)
public final class IntervalCountDownTimer$createFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IntervalCountDownTimer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntervalCountDownTimer$createFlow$1(IntervalCountDownTimer intervalCountDownTimer, Continuation<? super IntervalCountDownTimer$createFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = intervalCountDownTimer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> intervalCountDownTimer$createFlow$1 = new IntervalCountDownTimer$createFlow$1(this.this$0, continuation);
        intervalCountDownTimer$createFlow$1.L$0 = obj;
        return intervalCountDownTimer$createFlow$1;
    }

    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0139 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00c7 -> B:20:0x0061). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00db -> B:20:0x0061). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        long j2;
        long j3;
        int i2;
        IntervalCountDownTimer$createFlow$1 intervalCountDownTimer$createFlow$1;
        long j4;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        long j5;
        long j6;
        int i7;
        long j7;
        int i8;
        long j8;
        int i9;
        int i10;
        int i11;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                i = this.this$0.step;
                if (i < 0) {
                    j2 = this.this$0.totalMilliseconds;
                    j3 = this.this$0.intervalMilliseconds;
                    throw new IllegalArgumentException("Interval error:total:" + j2 + ",interval:" + j3);
                }
                i2 = this.this$0.step;
                if (i2 == 0) {
                    j4 = this.this$0.totalMilliseconds;
                    this.L$0 = $this$flow;
                    this.label = 1;
                    if (DelayKt.delay(j4, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intervalCountDownTimer$createFlow$1 = this;
                    i3 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                    if (i3 != 0) {
                        f = 0.0f;
                    } else {
                        i4 = intervalCountDownTimer$createFlow$1.this$0.step;
                        i5 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                        f = i4 / i5;
                    }
                    intervalCountDownTimer$createFlow$1.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    intervalCountDownTimer$createFlow$1.label = 5;
                    if ($this$flow.emit(Boxing.boxFloat(f), (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                intervalCountDownTimer$createFlow$1 = this;
                i9 = intervalCountDownTimer$createFlow$1.this$0.step;
                if (i9 > 0 && JobKt.isActive(intervalCountDownTimer$createFlow$1.getContext())) {
                    i10 = intervalCountDownTimer$createFlow$1.this$0.step;
                    i11 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                    intervalCountDownTimer$createFlow$1.L$0 = $this$flow;
                    intervalCountDownTimer$createFlow$1.label = 2;
                    if ($this$flow.emit(Boxing.boxFloat(i10 / i11), (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i8 = intervalCountDownTimer$createFlow$1.this$0.step;
                    intervalCountDownTimer$createFlow$1.this$0.step = i8 - 1;
                    j8 = intervalCountDownTimer$createFlow$1.this$0.intervalMilliseconds;
                    intervalCountDownTimer$createFlow$1.L$0 = $this$flow;
                    intervalCountDownTimer$createFlow$1.label = 3;
                    if (DelayKt.delay(j8, (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i6 = intervalCountDownTimer$createFlow$1.this$0.step;
                    if (i6 < 0) {
                        i7 = intervalCountDownTimer$createFlow$1.this$0.step;
                        if (i7 == 0) {
                            j7 = intervalCountDownTimer$createFlow$1.this$0.totalMilliseconds;
                            intervalCountDownTimer$createFlow$1.L$0 = $this$flow;
                            intervalCountDownTimer$createFlow$1.label = 4;
                            if (DelayKt.delay(j7, (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        i9 = intervalCountDownTimer$createFlow$1.this$0.step;
                        if (i9 > 0) {
                            i10 = intervalCountDownTimer$createFlow$1.this$0.step;
                            i11 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                            intervalCountDownTimer$createFlow$1.L$0 = $this$flow;
                            intervalCountDownTimer$createFlow$1.label = 2;
                            if ($this$flow.emit(Boxing.boxFloat(i10 / i11), (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                            }
                            i8 = intervalCountDownTimer$createFlow$1.this$0.step;
                            intervalCountDownTimer$createFlow$1.this$0.step = i8 - 1;
                            j8 = intervalCountDownTimer$createFlow$1.this$0.intervalMilliseconds;
                            intervalCountDownTimer$createFlow$1.L$0 = $this$flow;
                            intervalCountDownTimer$createFlow$1.label = 3;
                            if (DelayKt.delay(j8, (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                            }
                            i6 = intervalCountDownTimer$createFlow$1.this$0.step;
                            if (i6 < 0) {
                                j5 = intervalCountDownTimer$createFlow$1.this$0.totalMilliseconds;
                                j6 = intervalCountDownTimer$createFlow$1.this$0.intervalMilliseconds;
                                throw new IllegalArgumentException("Interval error:total:" + j5 + ",interval:" + j6);
                            }
                        }
                    }
                }
                i3 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                if (i3 != 0) {
                }
                intervalCountDownTimer$createFlow$1.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                intervalCountDownTimer$createFlow$1.label = 5;
                if ($this$flow.emit(Boxing.boxFloat(f), (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                intervalCountDownTimer$createFlow$1 = this;
                i3 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                if (i3 != 0) {
                }
                intervalCountDownTimer$createFlow$1.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                intervalCountDownTimer$createFlow$1.label = 5;
                if ($this$flow.emit(Boxing.boxFloat(f), (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                intervalCountDownTimer$createFlow$1 = this;
                i8 = intervalCountDownTimer$createFlow$1.this$0.step;
                intervalCountDownTimer$createFlow$1.this$0.step = i8 - 1;
                j8 = intervalCountDownTimer$createFlow$1.this$0.intervalMilliseconds;
                intervalCountDownTimer$createFlow$1.L$0 = $this$flow;
                intervalCountDownTimer$createFlow$1.label = 3;
                if (DelayKt.delay(j8, (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                }
                i6 = intervalCountDownTimer$createFlow$1.this$0.step;
                if (i6 < 0) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                intervalCountDownTimer$createFlow$1 = this;
                i6 = intervalCountDownTimer$createFlow$1.this$0.step;
                if (i6 < 0) {
                }
                break;
            case 4:
                ResultKt.throwOnFailure($result);
                intervalCountDownTimer$createFlow$1 = this;
                i9 = intervalCountDownTimer$createFlow$1.this$0.step;
                if (i9 > 0) {
                }
                i3 = intervalCountDownTimer$createFlow$1.this$0.totalStep;
                if (i3 != 0) {
                }
                intervalCountDownTimer$createFlow$1.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                intervalCountDownTimer$createFlow$1.label = 5;
                if ($this$flow.emit(Boxing.boxFloat(f), (Continuation) intervalCountDownTimer$createFlow$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}