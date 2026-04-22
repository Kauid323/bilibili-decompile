package tv.danmaku.bili.fullscreen;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullscreenLoginViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$checkAndNetCodeAuth$1", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.coverThumbWidth, BR.coverTip, BR.coverUrl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginViewModel$checkAndNetCodeAuth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FullscreenLoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginViewModel$checkAndNetCodeAuth$1(FullscreenLoginViewModel fullscreenLoginViewModel, Continuation<? super FullscreenLoginViewModel$checkAndNetCodeAuth$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenLoginViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenLoginViewModel$checkAndNetCodeAuth$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Setting agreement checked true and go on auth netcode");
                this.label = 1;
                if (this.this$0.getStateMachine().dispatch(new IFullscreenLoginAction.DismissEulaAction(true), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (this.this$0.getStateMachine().dispatch(new IFullscreenLoginAction.AgreementCheckedAction(true), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 3;
                if (this.this$0.getStateMachine().dispatch(new IFullscreenLoginAction.NetCodeAuth(false), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (this.this$0.getStateMachine().dispatch(new IFullscreenLoginAction.AgreementCheckedAction(true), (Continuation) this) == coroutine_suspended) {
                }
                this.label = 3;
                if (this.this$0.getStateMachine().dispatch(new IFullscreenLoginAction.NetCodeAuth(false), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                this.label = 3;
                if (this.this$0.getStateMachine().dispatch(new IFullscreenLoginAction.NetCodeAuth(false), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}