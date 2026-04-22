package home.sidecenter.settings;

import home.sidecenter.settings.ISideCenterSettingsAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$dispatchAction$2", f = "SideCenterSettingsHolder.kt", i = {0, 1}, l = {97, 99}, m = "invokeSuspend", n = {"$this$SideCenterSettingsActionResult", "$this$SideCenterSettingsActionResult"}, s = {"L$0", "L$0"}, v = 1)
final class SideCenterSettingsHolder$dispatchAction$2 extends SuspendLambda implements Function2<FlowCollector<? super ISideCenterSettingsAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISideCenterSettingsAction $action;
    final /* synthetic */ boolean $showSettingToast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterSettingsHolder$dispatchAction$2(boolean z, ISideCenterSettingsAction iSideCenterSettingsAction, Continuation<? super SideCenterSettingsHolder$dispatchAction$2> continuation) {
        super(2, continuation);
        this.$showSettingToast = z;
        this.$action = iSideCenterSettingsAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sideCenterSettingsHolder$dispatchAction$2 = new SideCenterSettingsHolder$dispatchAction$2(this.$showSettingToast, this.$action, continuation);
        sideCenterSettingsHolder$dispatchAction$2.L$0 = obj;
        return sideCenterSettingsHolder$dispatchAction$2;
    }

    public final Object invoke(FlowCollector<? super ISideCenterSettingsAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$SideCenterSettingsActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$showSettingToast) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$SideCenterSettingsActionResult);
                    this.label = 1;
                    if ($this$SideCenterSettingsActionResult.emit(ISideCenterSettingsAction.CheckedMineTabToastShow.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (((ISideCenterSettingsAction.SettingItemSwitchSuccess) this.$action).getItem().getTab() == SideCenterSettingType.Recent) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$SideCenterSettingsActionResult);
                    this.label = 2;
                    if ($this$SideCenterSettingsActionResult.emit(ISideCenterSettingsAction.CheckedMineTabToastDismiss.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}