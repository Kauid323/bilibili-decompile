package tv.danmaku.bili.fullscreen;

import android.content.Context;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.normal.ui.RouteUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullscreenLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginActivity$registerInterceptedAction$1", f = "FullscreenLoginActivity.kt", i = {}, l = {BR.flContainerVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginActivity$registerInterceptedAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FullscreenLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginActivity$registerInterceptedAction$1(FullscreenLoginActivity fullscreenLoginActivity, Continuation<? super FullscreenLoginActivity$registerInterceptedAction$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenLoginActivity$registerInterceptedAction$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow<IFullscreenLoginAction> interceptedActionFlow = this.this$0.getViewModel().getInterceptedActionFlow();
                final FullscreenLoginActivity fullscreenLoginActivity = this.this$0;
                this.label = 1;
                if (interceptedActionFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginActivity$registerInterceptedAction$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IFullscreenLoginAction) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IFullscreenLoginAction interceptedAction, Continuation<? super Unit> continuation) {
                        if (interceptedAction instanceof IFullscreenLoginAction.RouterToSmsB1ExpLogin) {
                            RouteUtilKt.routeToLoginOriginActivityV2$default((Context) FullscreenLoginActivity.this, Boxing.boxBoolean(true), Boxing.boxBoolean(true), null, null, null, null, null, true, BR.guestPureEnjoyMsgList, null);
                            super/*tv.danmaku.bili.fullscreen.Hilt_FullscreenLoginActivity*/.finish();
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