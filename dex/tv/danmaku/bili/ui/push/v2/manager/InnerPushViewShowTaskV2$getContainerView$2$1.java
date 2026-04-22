package tv.danmaku.bili.ui.push.v2.manager;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InnerPushViewShowTaskV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2$getContainerView$2$1", f = "InnerPushViewShowTaskV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InnerPushViewShowTaskV2$getContainerView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ CancellableContinuation<View> $continuation;
    int label;
    final /* synthetic */ InnerPushViewShowTaskV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InnerPushViewShowTaskV2$getContainerView$2$1(InnerPushViewShowTaskV2 innerPushViewShowTaskV2, AppCompatActivity appCompatActivity, CancellableContinuation<? super View> cancellableContinuation, Continuation<? super InnerPushViewShowTaskV2$getContainerView$2$1> continuation) {
        super(2, continuation);
        this.this$0 = innerPushViewShowTaskV2;
        this.$activity = appCompatActivity;
        this.$continuation = cancellableContinuation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerPushViewShowTaskV2$getContainerView$2$1(this.this$0, this.$activity, this.$continuation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.this$0.setupContainer(this.$activity, this.$continuation);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}