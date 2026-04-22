package tv.danmaku.biliplayerv2.service.interact.biz;

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
import tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractLayerServiceKtx.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuVisibleChangeParams;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1", f = "InteractLayerServiceKtx.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super DanmakuVisibleChangeParams>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IInteractLayerService $this_danmakuVisibleChangeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1(IInteractLayerService iInteractLayerService, Continuation<? super InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1> continuation) {
        super(2, continuation);
        this.$this_danmakuVisibleChangeFlow = iInteractLayerService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> interactLayerServiceKtxKt$danmakuVisibleChangeFlow$1 = new InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1(this.$this_danmakuVisibleChangeFlow, continuation);
        interactLayerServiceKtxKt$danmakuVisibleChangeFlow$1.L$0 = obj;
        return interactLayerServiceKtxKt$danmakuVisibleChangeFlow$1;
    }

    public final Object invoke(ProducerScope<? super DanmakuVisibleChangeParams> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1$observer$1] */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                final ?? r2 = new DanmakuVisibleObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1$observer$1
                    @Override // tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver
                    public void onDanmakuVisibleChanged(boolean visible, boolean fromUser) {
                        $this$callbackFlow.trySend-JP2dKIU(new DanmakuVisibleChangeParams(visible, fromUser));
                    }
                };
                this.$this_danmakuVisibleChangeFlow.registerDanmakuVisibleObserver((DanmakuVisibleObserver) r2);
                final IInteractLayerService iInteractLayerService = this.$this_danmakuVisibleChangeFlow;
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1.invokeSuspend$lambda$0(IInteractLayerService.this, r2);
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
    public static final Unit invokeSuspend$lambda$0(IInteractLayerService $this_danmakuVisibleChangeFlow, InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1$observer$1 $observer) {
        $this_danmakuVisibleChangeFlow.unregisterDanmakuVisibleObserver($observer);
        return Unit.INSTANCE;
    }
}