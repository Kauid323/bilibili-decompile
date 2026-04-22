package tv.danmaku.bili.ui.widget.wheel;

import android.util.Log;
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
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WheelView.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.widget.wheel.WheelView$inertiaTimerFlow$1", f = "WheelView.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3}, l = {345, 349, 353, 357}, m = "invokeSuspend", n = {"$this$flow", "consuming", "$this$flow", "consuming", "$this$flow", "mCurrentVelocityY", "consuming", "$this$flow", "mCurrentVelocityY", "consuming"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "F$0", "I$0", "L$0", "F$0", "I$0"}, v = 1)
public final class WheelView$inertiaTimerFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $mFirstVelocityY;
    float F$0;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WheelView<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView$inertiaTimerFlow$1(float f, WheelView<T> wheelView, Continuation<? super WheelView$inertiaTimerFlow$1> continuation) {
        super(2, continuation);
        this.$mFirstVelocityY = f;
        this.this$0 = wheelView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> wheelView$inertiaTimerFlow$1 = new WheelView$inertiaTimerFlow$1(this.$mFirstVelocityY, this.this$0, continuation);
        wheelView$inertiaTimerFlow$1.L$0 = obj;
        return wheelView$inertiaTimerFlow$1;
    }

    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x010d -> B:58:0x01c1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0146 -> B:58:0x01c1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0180 -> B:58:0x01c1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01b6 -> B:57:0x01bb). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$flow;
        float mCurrentVelocityY;
        int i;
        WheelView$inertiaTimerFlow$1 wheelView$inertiaTimerFlow$1;
        int i2;
        FlowCollector $this$flow2;
        int i3;
        FlowCollector $this$flow3;
        int i4;
        FlowCollector $this$flow4;
        float mCurrentVelocityY2;
        float f;
        FlowCollector $this$flow5;
        int i5;
        float f2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        float mCurrentVelocityY3 = 20.0f;
        float f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        switch (i6) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$flow = (FlowCollector) this.L$0;
                float f4 = 2000.0f;
                if (Math.abs(this.$mFirstVelocityY) <= 2000.0f) {
                    f4 = this.$mFirstVelocityY;
                } else if (this.$mFirstVelocityY <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    f4 = -2000.0f;
                }
                mCurrentVelocityY = f4;
                i = 1;
                wheelView$inertiaTimerFlow$1 = this;
                break;
            case 1:
                i2 = this.I$0;
                $this$flow2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                wheelView$inertiaTimerFlow$1 = this;
                mCurrentVelocityY2 = 40.0f;
                i = i2;
                $this$flow = $this$flow2;
                f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    f2 = 20.0f;
                    mCurrentVelocityY = mCurrentVelocityY2 + 20.0f;
                } else {
                    f2 = 20.0f;
                    mCurrentVelocityY = mCurrentVelocityY2 - 20.0f;
                }
                mCurrentVelocityY3 = f2;
                break;
            case 2:
                i3 = this.I$0;
                $this$flow3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                wheelView$inertiaTimerFlow$1 = this;
                mCurrentVelocityY2 = -40.0f;
                i = i3;
                $this$flow = $this$flow3;
                f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                }
                mCurrentVelocityY3 = f2;
                break;
            case 3:
                i4 = this.I$0;
                mCurrentVelocityY = this.F$0;
                $this$flow4 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                wheelView$inertiaTimerFlow$1 = this;
                mCurrentVelocityY2 = mCurrentVelocityY;
                FlowCollector flowCollector = $this$flow4;
                i = i4;
                $this$flow = flowCollector;
                f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                }
                mCurrentVelocityY3 = f2;
                break;
            case 4:
                i5 = this.I$0;
                mCurrentVelocityY = this.F$0;
                $this$flow5 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                wheelView$inertiaTimerFlow$1 = this;
                mCurrentVelocityY2 = mCurrentVelocityY;
                FlowCollector flowCollector2 = $this$flow5;
                i = i5;
                $this$flow = flowCollector2;
                f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                }
                mCurrentVelocityY3 = f2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (i != 0) {
            float abs = Math.abs(mCurrentVelocityY);
            boolean z = false;
            if (f3 <= abs && abs <= mCurrentVelocityY3) {
                z = true;
            }
            if (z) {
                i = 0;
            }
            int dy = (int) (mCurrentVelocityY / 100.0f);
            f = ((WheelView) wheelView$inertiaTimerFlow$1.this$0).totalScrollY;
            float scrollY = f - dy;
            if (wheelView$inertiaTimerFlow$1.this$0.isLoop()) {
                Log.d("inertiaTimerFlow", "emit(" + scrollY + ")");
                wheelView$inertiaTimerFlow$1.L$0 = $this$flow;
                wheelView$inertiaTimerFlow$1.F$0 = mCurrentVelocityY;
                wheelView$inertiaTimerFlow$1.I$0 = i;
                wheelView$inertiaTimerFlow$1.label = 4;
                if ($this$flow.emit(Boxing.boxFloat(scrollY), (Continuation) wheelView$inertiaTimerFlow$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                int i7 = i;
                $this$flow5 = $this$flow;
                i5 = i7;
                mCurrentVelocityY2 = mCurrentVelocityY;
                FlowCollector flowCollector22 = $this$flow5;
                i = i5;
                $this$flow = flowCollector22;
                f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                }
                mCurrentVelocityY3 = f2;
                if (i != 0) {
                }
            } else {
                float itemHeight = wheelView$inertiaTimerFlow$1.this$0.getItemHeight();
                float top = (-wheelView$inertiaTimerFlow$1.this$0.getInitPosition()) * itemHeight;
                float bottom = ((wheelView$inertiaTimerFlow$1.this$0.itemsCount() - 1) - wheelView$inertiaTimerFlow$1.this$0.getInitPosition()) * itemHeight;
                if (scrollY - (itemHeight * DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) < top) {
                    top = dy + scrollY;
                } else if (scrollY + (itemHeight * DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) > bottom) {
                    bottom = dy + scrollY;
                }
                if (scrollY <= top) {
                    Log.d("inertiaTimerFlow", "emit(" + top + ")");
                    wheelView$inertiaTimerFlow$1.L$0 = $this$flow;
                    wheelView$inertiaTimerFlow$1.I$0 = i;
                    wheelView$inertiaTimerFlow$1.label = 1;
                    if ($this$flow.emit(Boxing.boxFloat(top), (Continuation) wheelView$inertiaTimerFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$flow2 = $this$flow;
                    i2 = i;
                    mCurrentVelocityY2 = 40.0f;
                    i = i2;
                    $this$flow = $this$flow2;
                    f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                    if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    }
                    mCurrentVelocityY3 = f2;
                    if (i != 0) {
                    }
                } else if (scrollY >= bottom) {
                    Log.d("inertiaTimerFlow", "emit(" + bottom + ")");
                    wheelView$inertiaTimerFlow$1.L$0 = $this$flow;
                    wheelView$inertiaTimerFlow$1.I$0 = i;
                    wheelView$inertiaTimerFlow$1.label = 2;
                    if ($this$flow.emit(Boxing.boxFloat(bottom), (Continuation) wheelView$inertiaTimerFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$flow3 = $this$flow;
                    i3 = i;
                    mCurrentVelocityY2 = -40.0f;
                    i = i3;
                    $this$flow = $this$flow3;
                    f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                    if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    }
                    mCurrentVelocityY3 = f2;
                    if (i != 0) {
                        return Unit.INSTANCE;
                    }
                } else {
                    Log.d("inertiaTimerFlow", "emit(" + scrollY + ")");
                    wheelView$inertiaTimerFlow$1.L$0 = $this$flow;
                    wheelView$inertiaTimerFlow$1.F$0 = mCurrentVelocityY;
                    wheelView$inertiaTimerFlow$1.I$0 = i;
                    wheelView$inertiaTimerFlow$1.label = 3;
                    if ($this$flow.emit(Boxing.boxFloat(scrollY), (Continuation) wheelView$inertiaTimerFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i8 = i;
                    $this$flow4 = $this$flow;
                    i4 = i8;
                    mCurrentVelocityY2 = mCurrentVelocityY;
                    FlowCollector flowCollector3 = $this$flow4;
                    i = i4;
                    $this$flow = flowCollector3;
                    f3 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                    if (mCurrentVelocityY2 >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    }
                    mCurrentVelocityY3 = f2;
                    if (i != 0) {
                    }
                }
            }
        }
    }
}