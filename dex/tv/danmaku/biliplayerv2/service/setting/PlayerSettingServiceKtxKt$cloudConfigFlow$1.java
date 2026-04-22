package tv.danmaku.biliplayerv2.service.setting;

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
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerSettingServiceKtx.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$cloudConfigFlow$1", f = "PlayerSettingServiceKtx.kt", i = {0}, l = {72, 79}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"}, v = 1)
final class PlayerSettingServiceKtxKt$cloudConfigFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super PlayerCloudConfig>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IPlayerSettingService $this_cloudConfigFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerSettingServiceKtxKt$cloudConfigFlow$1(IPlayerSettingService iPlayerSettingService, Continuation<? super PlayerSettingServiceKtxKt$cloudConfigFlow$1> continuation) {
        super(2, continuation);
        this.$this_cloudConfigFlow = iPlayerSettingService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> playerSettingServiceKtxKt$cloudConfigFlow$1 = new PlayerSettingServiceKtxKt$cloudConfigFlow$1(this.$this_cloudConfigFlow, continuation);
        playerSettingServiceKtxKt$cloudConfigFlow$1.L$0 = obj;
        return playerSettingServiceKtxKt$cloudConfigFlow$1;
    }

    public final Object invoke(ProducerScope<? super PlayerCloudConfig> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v3, types: [tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$cloudConfigFlow$1$cloudConfigObserver$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        final ProducerScope $this$callbackFlow;
        final ?? r2;
        final IPlayerSettingService iPlayerSettingService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$callbackFlow = (ProducerScope) this.L$0;
                this.L$0 = $this$callbackFlow;
                this.label = 1;
                if ($this$callbackFlow.send(this.$this_cloudConfigFlow.getCloudConfig(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                final IPlayerSettingService iPlayerSettingService2 = this.$this_cloudConfigFlow;
                r2 = new ICloudConfigObserver() { // from class: tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$cloudConfigFlow$1$cloudConfigObserver$1
                    @Override // tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver
                    public void onCloudConfigChanged() {
                        $this$callbackFlow.trySend-JP2dKIU(iPlayerSettingService2.getCloudConfig());
                    }
                };
                this.$this_cloudConfigFlow.addCloudConfigObserver((ICloudConfigObserver) r2);
                iPlayerSettingService = this.$this_cloudConfigFlow;
                this.L$0 = null;
                this.label = 2;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$cloudConfigFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PlayerSettingServiceKtxKt$cloudConfigFlow$1.invokeSuspend$lambda$0(IPlayerSettingService.this, r2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                $this$callbackFlow = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                final IPlayerSettingService iPlayerSettingService22 = this.$this_cloudConfigFlow;
                r2 = new ICloudConfigObserver() { // from class: tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$cloudConfigFlow$1$cloudConfigObserver$1
                    @Override // tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver
                    public void onCloudConfigChanged() {
                        $this$callbackFlow.trySend-JP2dKIU(iPlayerSettingService22.getCloudConfig());
                    }
                };
                this.$this_cloudConfigFlow.addCloudConfigObserver((ICloudConfigObserver) r2);
                iPlayerSettingService = this.$this_cloudConfigFlow;
                this.L$0 = null;
                this.label = 2;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$cloudConfigFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PlayerSettingServiceKtxKt$cloudConfigFlow$1.invokeSuspend$lambda$0(IPlayerSettingService.this, r2);
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
    public static final Unit invokeSuspend$lambda$0(IPlayerSettingService $this_cloudConfigFlow, PlayerSettingServiceKtxKt$cloudConfigFlow$1$cloudConfigObserver$1 $cloudConfigObserver) {
        $this_cloudConfigFlow.removeCloudConfigObserver($cloudConfigObserver);
        return Unit.INSTANCE;
    }
}