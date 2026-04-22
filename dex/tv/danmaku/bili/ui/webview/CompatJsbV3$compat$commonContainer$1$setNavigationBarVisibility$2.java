package tv.danmaku.bili.ui.webview;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CompatJsbV3.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$setNavigationBarVisibility$2", f = "CompatJsbV3.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CompatJsbV3$compat$commonContainer$1$setNavigationBarVisibility$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MWebActivity $host;
    final /* synthetic */ boolean $show;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompatJsbV3$compat$commonContainer$1$setNavigationBarVisibility$2(MWebActivity mWebActivity, boolean z, Continuation<? super CompatJsbV3$compat$commonContainer$1$setNavigationBarVisibility$2> continuation) {
        super(2, continuation);
        this.$host = mWebActivity;
        this.$show = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CompatJsbV3$compat$commonContainer$1$setNavigationBarVisibility$2(this.$host, this.$show, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.$host.setNavigationBarVisibility(this.$show);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}