package tv.danmaku.bili.ui.webview;

import com.bilibili.app.comm.rubick.api.ContainerStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CompatJsbV3.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bilibili/app/comm/rubick/api/ContainerStatus;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3", f = "CompatJsbV3.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3 extends SuspendLambda implements Function3<FlowCollector<? super ContainerStatus>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3(Continuation<? super CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super ContainerStatus> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3 compatJsbV3$compat$commonContainer$1$observeContainerStatus$3 = new CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3(continuation);
        compatJsbV3$compat$commonContainer$1$observeContainerStatus$3.L$0 = flowCollector;
        compatJsbV3$compat$commonContainer$1$observeContainerStatus$3.L$1 = th;
        return compatJsbV3$compat$commonContainer$1$observeContainerStatus$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$catch = (FlowCollector) this.L$0;
                Throwable it = (Throwable) this.L$1;
                str = CompatJsbV3.TAG;
                String message = it.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
                BLog.e(str, "observeContainerStatus " + message, it);
                this.L$0 = null;
                this.label = 1;
                if ($this$catch.emit(ContainerStatus.UNKNOWN, (Continuation) this) == coroutine_suspended) {
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