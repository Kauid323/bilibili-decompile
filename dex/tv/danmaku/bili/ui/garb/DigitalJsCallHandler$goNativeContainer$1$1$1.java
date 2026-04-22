package tv.danmaku.bili.ui.garb;

import com.bilibili.digital.card.DigitalPageFragment;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DigitalJsCallHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.DigitalJsCallHandler$goNativeContainer$1$1$1", f = "DigitalJsCallHandler.kt", i = {}, l = {BR.downloadable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DigitalJsCallHandler$goNativeContainer$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DigitalJsCallHandler $digitalJsbHandler;
    final /* synthetic */ DigitalPageFragment $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalJsCallHandler$goNativeContainer$1$1$1(DigitalPageFragment digitalPageFragment, DigitalJsCallHandler digitalJsCallHandler, Continuation<? super DigitalJsCallHandler$goNativeContainer$1$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = digitalPageFragment;
        this.$digitalJsbHandler = digitalJsCallHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DigitalJsCallHandler$goNativeContainer$1$1$1(this.$this_apply, this.$digitalJsbHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow dismissRequestFlow = this.$this_apply.getDismissRequestFlow();
                final DigitalJsCallHandler digitalJsCallHandler = this.$digitalJsbHandler;
                this.label = 1;
                if (dismissRequestFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.garb.DigitalJsCallHandler$goNativeContainer$1$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Unit) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Unit it, Continuation<? super Unit> continuation) {
                        DigitalJsCallHandler digitalJsCallHandler2 = DigitalJsCallHandler.this;
                        if (digitalJsCallHandler2 != null) {
                            digitalJsCallHandler2.toDismiss();
                        }
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
        throw new KotlinNothingValueException();
    }
}