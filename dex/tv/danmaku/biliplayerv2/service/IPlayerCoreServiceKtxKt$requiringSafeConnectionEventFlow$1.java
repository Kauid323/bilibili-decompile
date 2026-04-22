package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreServiceKtx.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1", f = "IPlayerCoreServiceKtx.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IPlayerCoreService $this_requiringSafeConnectionEventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1(IPlayerCoreService iPlayerCoreService, Continuation<? super IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1> continuation) {
        super(2, continuation);
        this.$this_requiringSafeConnectionEventFlow = iPlayerCoreService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1 = new IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1(this.$this_requiringSafeConnectionEventFlow, continuation);
        iPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1.L$0 = obj;
        return iPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1;
    }

    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1$observer$1] */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                final ?? r2 = new IAssetUpdateObserver() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1$observer$1
                    @Override // tv.danmaku.biliplayerv2.service.IAssetUpdateObserver
                    public void onHttpResponseInvalid() {
                        ChannelsKt.trySendBlocking($this$callbackFlow, Unit.INSTANCE);
                    }
                };
                this.$this_requiringSafeConnectionEventFlow.addAssetUpdateObserver((IAssetUpdateObserver) r2);
                final IPlayerCoreService iPlayerCoreService = this.$this_requiringSafeConnectionEventFlow;
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1.invokeSuspend$lambda$0(IPlayerCoreService.this, r2);
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
    public static final Unit invokeSuspend$lambda$0(IPlayerCoreService $this_requiringSafeConnectionEventFlow, IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1$observer$1 $observer) {
        $this_requiringSafeConnectionEventFlow.removeAssetUpdateObserver($observer);
        return Unit.INSTANCE;
    }
}