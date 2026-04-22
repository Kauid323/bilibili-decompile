package tv.danmaku.bili.ui.webview;

import com.bilibili.app.comm.rubick.api.ContainerStatus;
import com.bilibili.lib.jsbridge.common.ContainerStatusWatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CompatJsbV3.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/bilibili/app/comm/rubick/api/ContainerStatus;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2", f = "CompatJsbV3.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2 extends SuspendLambda implements Function2<ProducerScope<? super ContainerStatus>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2(Continuation<? super CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> compatJsbV3$compat$commonContainer$1$observeContainerStatus$2 = new CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2(continuation);
        compatJsbV3$compat$commonContainer$1$observeContainerStatus$2.L$0 = obj;
        return compatJsbV3$compat$commonContainer$1$observeContainerStatus$2;
    }

    public final Object invoke(ProducerScope<? super ContainerStatus> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2$ob$1] */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                final ?? r2 = new ContainerStatusWatcher.Observer() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2$ob$1
                    public void onStatusChange(int status) {
                        ContainerStatus containerStatus;
                        ProducerScope<ContainerStatus> producerScope = $this$callbackFlow;
                        if (status == 1) {
                            containerStatus = ContainerStatus.SHOW;
                        } else {
                            containerStatus = ContainerStatus.HIDE;
                        }
                        producerScope.trySend-JP2dKIU(containerStatus);
                    }
                };
                ContainerStatusWatcher.INSTANCE.subscribe(new ContainerStatusWatcher.Observer() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2.1
                    public void onStatusChange(int status) {
                        ContainerStatus containerStatus;
                        ProducerScope<ContainerStatus> producerScope = $this$callbackFlow;
                        if (status == 1) {
                            containerStatus = ContainerStatus.SHOW;
                        } else {
                            containerStatus = ContainerStatus.HIDE;
                        }
                        producerScope.trySend-JP2dKIU(containerStatus);
                    }
                });
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2.invokeSuspend$lambda$0(CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2$ob$1.this);
                        return invokeSuspend$lambda$0;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2$ob$1 $ob) {
        ContainerStatusWatcher.INSTANCE.unSubscribe($ob);
        return Unit.INSTANCE;
    }
}