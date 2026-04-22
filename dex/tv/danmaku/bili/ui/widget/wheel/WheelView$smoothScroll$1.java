package tv.danmaku.bili.ui.widget.wheel;

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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WheelView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.widget.wheel.WheelView$smoothScroll$1", f = "WheelView.kt", i = {}, l = {IjkMediaPlayer.FFP_BUFFERING_END_REASON_COMPLETED}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WheelView$smoothScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WheelView<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView$smoothScroll$1(WheelView<T> wheelView, Continuation<? super WheelView$smoothScroll$1> continuation) {
        super(2, continuation);
        this.this$0 = wheelView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WheelView$smoothScroll$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        Flow smoothScrollTimerFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WheelView<T> wheelView = this.this$0;
                i = ((WheelView) this.this$0).mOffset;
                smoothScrollTimerFlow = wheelView.smoothScrollTimerFlow(i);
                final WheelView<T> wheelView2 = this.this$0;
                this.label = 1;
                if (smoothScrollTimerFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.widget.wheel.WheelView$smoothScroll$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).floatValue(), $completion);
                    }

                    public final Object emit(float it, Continuation<? super Unit> continuation) {
                        ((WheelView) wheelView2).totalScrollY = it;
                        wheelView2.invalidate();
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