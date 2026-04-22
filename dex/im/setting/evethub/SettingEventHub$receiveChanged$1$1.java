package im.setting.evethub;

import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingEventHub.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.evethub.SettingEventHub$receiveChanged$1$1", f = "SettingEventHub.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingEventHub$receiveChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingEventHubFlowData $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingEventHub$receiveChanged$1$1(SettingEventHubFlowData settingEventHubFlowData, Continuation<? super SettingEventHub$receiveChanged$1$1> continuation) {
        super(2, continuation);
        this.$it = settingEventHubFlowData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingEventHub$receiveChanged$1$1(this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("IMSetting", "Event hub 发送事件: " + this.$it);
                mutableSharedFlow = SettingEventHub._refreshSettingsFlow;
                this.label = 1;
                if (mutableSharedFlow.emit(this.$it, (Continuation) this) == coroutine_suspended) {
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