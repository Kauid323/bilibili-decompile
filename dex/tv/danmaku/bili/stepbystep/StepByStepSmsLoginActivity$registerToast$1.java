package tv.danmaku.bili.stepbystep;

import android.content.Context;
import com.bilibili.droid.ToastHelper;
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
import kotlinx.coroutines.flow.SharedFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerToast$1", f = "StepByStepSmsLoginActivity.kt", i = {}, l = {BR.pageId}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginActivity$registerToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StepByStepSmsLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginActivity$registerToast$1(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, Continuation<? super StepByStepSmsLoginActivity$registerToast$1> continuation) {
        super(2, continuation);
        this.this$0 = stepByStepSmsLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StepByStepSmsLoginActivity$registerToast$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<ToastInfo> toast = this.this$0.getViewModel().getToast();
                final StepByStepSmsLoginActivity stepByStepSmsLoginActivity = this.this$0;
                this.label = 1;
                if (toast.collect(new FlowCollector() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerToast$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ToastInfo) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(ToastInfo it, Continuation<? super Unit> continuation) {
                        ToastHelper.showToastShort((Context) StepByStepSmsLoginActivity.this, it.getToast());
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