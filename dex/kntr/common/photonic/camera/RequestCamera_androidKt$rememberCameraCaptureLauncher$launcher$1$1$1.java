package kntr.common.photonic.camera;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestCamera.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.camera.RequestCamera_androidKt$rememberCameraCaptureLauncher$launcher$1$1$1", f = "RequestCamera.android.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RequestCamera_androidKt$rememberCameraCaptureLauncher$launcher$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ MutableCameraCaptureLauncher $mutableCameraCaptureLauncher;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestCamera_androidKt$rememberCameraCaptureLauncher$launcher$1$1$1(MutableCameraCaptureLauncher mutableCameraCaptureLauncher, boolean z, Continuation<? super RequestCamera_androidKt$rememberCameraCaptureLauncher$launcher$1$1$1> continuation) {
        super(2, continuation);
        this.$mutableCameraCaptureLauncher = mutableCameraCaptureLauncher;
        this.$isSuccess = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RequestCamera_androidKt$rememberCameraCaptureLauncher$launcher$1$1$1(this.$mutableCameraCaptureLauncher, this.$isSuccess, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$mutableCameraCaptureLauncher.handleResult(this.$isSuccess, (Continuation) this) == coroutine_suspended) {
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