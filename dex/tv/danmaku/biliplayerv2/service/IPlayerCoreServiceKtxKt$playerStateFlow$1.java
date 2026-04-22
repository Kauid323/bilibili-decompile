package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreServiceKtx.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$playerStateFlow$1", f = "IPlayerCoreServiceKtx.kt", i = {0}, l = {50, 70}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"}, v = 1)
final class IPlayerCoreServiceKtxKt$playerStateFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IPlayerCoreService $this_playerStateFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPlayerCoreServiceKtxKt$playerStateFlow$1(IPlayerCoreService iPlayerCoreService, Continuation<? super IPlayerCoreServiceKtxKt$playerStateFlow$1> continuation) {
        super(2, continuation);
        this.$this_playerStateFlow = iPlayerCoreService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iPlayerCoreServiceKtxKt$playerStateFlow$1 = new IPlayerCoreServiceKtxKt$playerStateFlow$1(this.$this_playerStateFlow, continuation);
        iPlayerCoreServiceKtxKt$playerStateFlow$1.L$0 = obj;
        return iPlayerCoreServiceKtxKt$playerStateFlow$1;
    }

    public final Object invoke(ProducerScope<? super Integer> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007b A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v4, types: [tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$playerStateFlow$1$observer$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        final ProducerScope $this$callbackFlow;
        final ?? r2;
        final IPlayerCoreService iPlayerCoreService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$callbackFlow = (ProducerScope) this.L$0;
                this.L$0 = $this$callbackFlow;
                this.label = 1;
                if ($this$callbackFlow.send(Boxing.boxInt(this.$this_playerStateFlow.getState()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r2 = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$playerStateFlow$1$observer$1
                    @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
                    public void onPlayerStateChanged(int state) {
                        ChannelsKt.trySendBlocking($this$callbackFlow, Integer.valueOf(state));
                    }
                };
                this.$this_playerStateFlow.registerState((PlayerStateObserver) r2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                iPlayerCoreService = this.$this_playerStateFlow;
                this.L$0 = null;
                this.label = 2;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$playerStateFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IPlayerCoreServiceKtxKt$playerStateFlow$1.invokeSuspend$lambda$0(IPlayerCoreService.this, r2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                $this$callbackFlow = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                r2 = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$playerStateFlow$1$observer$1
                    @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
                    public void onPlayerStateChanged(int state) {
                        ChannelsKt.trySendBlocking($this$callbackFlow, Integer.valueOf(state));
                    }
                };
                this.$this_playerStateFlow.registerState((PlayerStateObserver) r2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                iPlayerCoreService = this.$this_playerStateFlow;
                this.L$0 = null;
                this.label = 2;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$playerStateFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IPlayerCoreServiceKtxKt$playerStateFlow$1.invokeSuspend$lambda$0(IPlayerCoreService.this, r2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(IPlayerCoreService $this_playerStateFlow, IPlayerCoreServiceKtxKt$playerStateFlow$1$observer$1 $observer) {
        $this_playerStateFlow.unregisterState($observer);
        return Unit.INSTANCE;
    }
}