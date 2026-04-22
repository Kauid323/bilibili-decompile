package tv.danmaku.bili.ui.widget.wheel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WheelView.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.widget.wheel.WheelView$smoothScrollTimerFlow$1", f = "WheelView.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {290, 293, 296}, m = "invokeSuspend", n = {"$this$flow", "realTotalOffset", "realOffset", "$this$flow", "realTotalOffset", "consuming", "realOffset", "$this$flow", "realTotalOffset", "consuming", "realOffset"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "I$2", "L$0", "I$0", "I$1", "I$2"}, v = 1)
public final class WheelView$smoothScrollTimerFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $offset;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WheelView<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView$smoothScrollTimerFlow$1(int i, WheelView<T> wheelView, Continuation<? super WheelView$smoothScrollTimerFlow$1> continuation) {
        super(2, continuation);
        this.$offset = i;
        this.this$0 = wheelView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> wheelView$smoothScrollTimerFlow$1 = new WheelView$smoothScrollTimerFlow$1(this.$offset, this.this$0, continuation);
        wheelView$smoothScrollTimerFlow$1.L$0 = obj;
        return wheelView$smoothScrollTimerFlow$1;
    }

    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c0 -> B:42:0x0108). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00e2 -> B:42:0x0108). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0101 -> B:42:0x0108). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$flow;
        WheelView$smoothScrollTimerFlow$1 wheelView$smoothScrollTimerFlow$1;
        int realTotalOffset;
        int realTotalOffset2;
        int realOffset;
        WheelView$smoothScrollTimerFlow$1 wheelView$smoothScrollTimerFlow$12;
        FlowCollector $this$flow2;
        int realTotalOffset3;
        int realTotalOffset4;
        float f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$flow3 = (FlowCollector) this.L$0;
                int realTotalOffset5 = this.$offset;
                $this$flow = $this$flow3;
                wheelView$smoothScrollTimerFlow$1 = this;
                realTotalOffset = realTotalOffset5;
                realTotalOffset2 = 1;
                break;
            case 1:
                realOffset = this.I$1;
                int realTotalOffset6 = this.I$0;
                FlowCollector $this$flow4 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$flow = $this$flow4;
                realTotalOffset = realTotalOffset6;
                wheelView$smoothScrollTimerFlow$12 = this;
                FlowCollector flowCollector = $this$flow;
                realTotalOffset3 = realTotalOffset;
                realTotalOffset4 = 0;
                $this$flow2 = flowCollector;
                int realOffset2 = realTotalOffset3 - realOffset;
                $this$flow = $this$flow2;
                int i = realTotalOffset4;
                realTotalOffset = realOffset2;
                wheelView$smoothScrollTimerFlow$1 = wheelView$smoothScrollTimerFlow$12;
                realTotalOffset2 = i;
                break;
            case 2:
                realOffset = this.I$2;
                int i2 = this.I$1;
                int realTotalOffset7 = this.I$0;
                FlowCollector $this$flow5 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$flow2 = $this$flow5;
                realTotalOffset3 = realTotalOffset7;
                realTotalOffset4 = i2;
                wheelView$smoothScrollTimerFlow$12 = this;
                int realOffset22 = realTotalOffset3 - realOffset;
                $this$flow = $this$flow2;
                int i3 = realTotalOffset4;
                realTotalOffset = realOffset22;
                wheelView$smoothScrollTimerFlow$1 = wheelView$smoothScrollTimerFlow$12;
                realTotalOffset2 = i3;
                break;
            case 3:
                realOffset = this.I$2;
                int i4 = this.I$1;
                int realTotalOffset8 = this.I$0;
                FlowCollector $this$flow6 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$flow2 = $this$flow6;
                realTotalOffset3 = realTotalOffset8;
                realTotalOffset4 = i4;
                wheelView$smoothScrollTimerFlow$12 = this;
                int realOffset222 = realTotalOffset3 - realOffset;
                $this$flow = $this$flow2;
                int i32 = realTotalOffset4;
                realTotalOffset = realOffset222;
                wheelView$smoothScrollTimerFlow$1 = wheelView$smoothScrollTimerFlow$12;
                realTotalOffset2 = i32;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (realTotalOffset2 != 0) {
            int realOffset3 = (int) (realTotalOffset * 0.1f);
            if (realOffset3 == 0) {
                realOffset3 = realTotalOffset < 0 ? -1 : 1;
            }
            if (Math.abs(realTotalOffset) <= 1) {
                realTotalOffset2 = 0;
            } else {
                f = ((WheelView) wheelView$smoothScrollTimerFlow$1.this$0).totalScrollY;
                float scrollY = f + realOffset3;
                if (wheelView$smoothScrollTimerFlow$1.this$0.isLoop()) {
                    wheelView$smoothScrollTimerFlow$1.L$0 = $this$flow;
                    wheelView$smoothScrollTimerFlow$1.I$0 = realTotalOffset;
                    wheelView$smoothScrollTimerFlow$1.I$1 = realTotalOffset2;
                    wheelView$smoothScrollTimerFlow$1.I$2 = realOffset3;
                    wheelView$smoothScrollTimerFlow$1.label = 3;
                    if ($this$flow.emit(Boxing.boxFloat(scrollY), (Continuation) wheelView$smoothScrollTimerFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i5 = realTotalOffset2;
                    wheelView$smoothScrollTimerFlow$12 = wheelView$smoothScrollTimerFlow$1;
                    realOffset = realOffset3;
                    $this$flow2 = $this$flow;
                    realTotalOffset3 = realTotalOffset;
                    realTotalOffset4 = i5;
                } else {
                    float itemHeight = wheelView$smoothScrollTimerFlow$1.this$0.getItemHeight();
                    float top = (-wheelView$smoothScrollTimerFlow$1.this$0.getInitPosition()) * itemHeight;
                    float bottom = ((wheelView$smoothScrollTimerFlow$1.this$0.itemsCount() - 1) - wheelView$smoothScrollTimerFlow$1.this$0.getInitPosition()) * itemHeight;
                    if (scrollY <= top || scrollY >= bottom) {
                        wheelView$smoothScrollTimerFlow$1.L$0 = $this$flow;
                        wheelView$smoothScrollTimerFlow$1.I$0 = realTotalOffset;
                        wheelView$smoothScrollTimerFlow$1.I$1 = realOffset3;
                        wheelView$smoothScrollTimerFlow$1.label = 1;
                        if ($this$flow.emit(Boxing.boxFloat(scrollY - realOffset3), (Continuation) wheelView$smoothScrollTimerFlow$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        wheelView$smoothScrollTimerFlow$12 = wheelView$smoothScrollTimerFlow$1;
                        realOffset = realOffset3;
                        FlowCollector flowCollector2 = $this$flow;
                        realTotalOffset3 = realTotalOffset;
                        realTotalOffset4 = 0;
                        $this$flow2 = flowCollector2;
                    } else {
                        wheelView$smoothScrollTimerFlow$1.L$0 = $this$flow;
                        wheelView$smoothScrollTimerFlow$1.I$0 = realTotalOffset;
                        wheelView$smoothScrollTimerFlow$1.I$1 = realTotalOffset2;
                        wheelView$smoothScrollTimerFlow$1.I$2 = realOffset3;
                        wheelView$smoothScrollTimerFlow$1.label = 2;
                        if ($this$flow.emit(Boxing.boxFloat(scrollY), (Continuation) wheelView$smoothScrollTimerFlow$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i6 = realTotalOffset2;
                        wheelView$smoothScrollTimerFlow$12 = wheelView$smoothScrollTimerFlow$1;
                        realOffset = realOffset3;
                        $this$flow2 = $this$flow;
                        realTotalOffset3 = realTotalOffset;
                        realTotalOffset4 = i6;
                    }
                }
                int realOffset2222 = realTotalOffset3 - realOffset;
                $this$flow = $this$flow2;
                int i322 = realTotalOffset4;
                realTotalOffset = realOffset2222;
                wheelView$smoothScrollTimerFlow$1 = wheelView$smoothScrollTimerFlow$12;
                realTotalOffset2 = i322;
                while (realTotalOffset2 != 0) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}