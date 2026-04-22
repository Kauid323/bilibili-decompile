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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerSettingServiceKtx.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$settingChangeStringFlow$1", f = "PlayerSettingServiceKtx.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PlayerSettingServiceKtxKt$settingChangeStringFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ IPlayerSettingService $this_settingChangeStringFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerSettingServiceKtxKt$settingChangeStringFlow$1(IPlayerSettingService iPlayerSettingService, String str, Continuation<? super PlayerSettingServiceKtxKt$settingChangeStringFlow$1> continuation) {
        super(2, continuation);
        this.$this_settingChangeStringFlow = iPlayerSettingService;
        this.$key = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> playerSettingServiceKtxKt$settingChangeStringFlow$1 = new PlayerSettingServiceKtxKt$settingChangeStringFlow$1(this.$this_settingChangeStringFlow, this.$key, continuation);
        playerSettingServiceKtxKt$settingChangeStringFlow$1.L$0 = obj;
        return playerSettingServiceKtxKt$settingChangeStringFlow$1;
    }

    public final Object invoke(ProducerScope<? super String> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$settingChangeStringFlow$1$observer$1] */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                $this$callbackFlow.trySend-JP2dKIU(this.$this_settingChangeStringFlow.getString(this.$key, ""));
                final IPlayerSettingService iPlayerSettingService = this.$this_settingChangeStringFlow;
                final ?? r2 = new PlayerSettingChangeObserver() { // from class: tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$settingChangeStringFlow$1$observer$1
                    @Override // tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver
                    public void onChange(String key) {
                        Intrinsics.checkNotNullParameter(key, "key");
                        $this$callbackFlow.trySend-JP2dKIU(iPlayerSettingService.getString(key, ""));
                    }
                };
                this.$this_settingChangeStringFlow.addPlayerSettingChangeObserver((PlayerSettingChangeObserver) r2, this.$key);
                final IPlayerSettingService iPlayerSettingService2 = this.$this_settingChangeStringFlow;
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.biliplayerv2.service.setting.PlayerSettingServiceKtxKt$settingChangeStringFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PlayerSettingServiceKtxKt$settingChangeStringFlow$1.invokeSuspend$lambda$0(IPlayerSettingService.this, r2);
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
    public static final Unit invokeSuspend$lambda$0(IPlayerSettingService $this_settingChangeStringFlow, PlayerSettingServiceKtxKt$settingChangeStringFlow$1$observer$1 $observer) {
        $this_settingChangeStringFlow.removePlayerSettingChangeObserver($observer);
        return Unit.INSTANCE;
    }
}