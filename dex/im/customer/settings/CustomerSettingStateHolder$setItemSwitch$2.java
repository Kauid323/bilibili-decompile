package im.customer.settings;

import com.bapis.bilibili.im.customer.interfaces.KCustomerInterfaceMoss;
import com.bapis.bilibili.im.customer.interfaces.KSetUserSettingsReq;
import com.bapis.bilibili.im.customer.interfaces.KSetUserSettingsRsp;
import im.customer.settings.ICustomerSettingAction;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomerSettingStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/customer/settings/ICustomerSettingAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$setItemSwitch$2", f = "CustomerSettingStateHolder.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {162, 163, 169}, m = "invokeSuspend", n = {"$this$CustomerSettingActionResult", "req", "$this$CustomerSettingActionResult", "req", "resp", "$this$CustomerSettingActionResult", "req", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class CustomerSettingStateHolder$setItemSwitch$2 extends SuspendLambda implements Function2<FlowCollector<? super ICustomerSettingAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ICustomerSettingAction.ClickSettingItem $action;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CustomerSettingStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerSettingStateHolder$setItemSwitch$2(CustomerSettingStateHolder customerSettingStateHolder, ICustomerSettingAction.ClickSettingItem clickSettingItem, Continuation<? super CustomerSettingStateHolder$setItemSwitch$2> continuation) {
        super(2, continuation);
        this.this$0 = customerSettingStateHolder;
        this.$action = clickSettingItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> customerSettingStateHolder$setItemSwitch$2 = new CustomerSettingStateHolder$setItemSwitch$2(this.this$0, this.$action, continuation);
        customerSettingStateHolder$setItemSwitch$2.L$0 = obj;
        return customerSettingStateHolder$setItemSwitch$2;
    }

    public final Object invoke(FlowCollector<? super ICustomerSettingAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0154: INVOKE  (r7 I:java.lang.Object) = (r5 I:java.lang.Object A[D('req' com.bapis.bilibili.im.customer.interfaces.KSetUserSettingsReq)]) type: STATIC call: kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(java.lang.Object):java.lang.Object, block:B:46:0x0112 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CustomerShopId customerShopId;
        Object nullOutSpilledVariable;
        Object obj;
        CustomerShopId customerShopId2;
        CustomerShopId customerShopId3;
        CustomerSettingState currentState;
        CustomerSettingState currentState2;
        KSetUserSettingsReq req;
        Object userSettings;
        KSetUserSettingsRsp resp;
        FlowCollector $this$CustomerSettingActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            ILogger kLog = KLog_androidKt.getKLog();
            customerShopId = this.this$0.id;
            kLog.e("CustomerSettingStateHolder", "Fail to load settings of shop " + customerShopId + ", " + e2);
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$CustomerSettingActionResult);
            this.L$1 = SpillingKt.nullOutSpilledVariable(nullOutSpilledVariable);
            this.L$2 = SpillingKt.nullOutSpilledVariable(e2);
            this.label = 3;
            if ($this$CustomerSettingActionResult.emit(new ICustomerSettingAction.SettingItemSwitchFailed(this.$action.getItem(), e2), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = nullOutSpilledVariable;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                customerShopId2 = this.this$0.id;
                long shopFatherId = customerShopId2.getShopFatherId();
                customerShopId3 = this.this$0.id;
                long shopId = customerShopId3.getShopId();
                currentState = this.this$0.getCurrentState();
                CustomerSettingItem findSetting = currentState.findSetting(CustomerSettingType.AcceptMsg);
                ICustomerSettingButton button = findSetting != null ? findSetting.getButton() : null;
                CustomerSettingSwitchButton customerSettingSwitchButton = button instanceof CustomerSettingSwitchButton ? (CustomerSettingSwitchButton) button : null;
                boolean currentEnabled = customerSettingSwitchButton != null ? customerSettingSwitchButton.getCurrentEnabled() : true;
                currentState2 = this.this$0.getCurrentState();
                CustomerSettingItem findSetting2 = currentState2.findSetting(CustomerSettingType.Dnd);
                ICustomerSettingButton button2 = findSetting2 != null ? findSetting2.getButton() : null;
                CustomerSettingSwitchButton customerSettingSwitchButton2 = button2 instanceof CustomerSettingSwitchButton ? (CustomerSettingSwitchButton) button2 : null;
                req = new KSetUserSettingsReq(shopFatherId, shopId, currentEnabled, customerSettingSwitchButton2 != null ? customerSettingSwitchButton2.getCurrentEnabled() : false);
                KLog_androidKt.getKLog().i("CustomerSettingStateHolder", "Set switch request " + req);
                this.L$0 = $this$CustomerSettingActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.label = 1;
                userSettings = new KCustomerInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).setUserSettings(req, (Continuation) this);
                if (userSettings == coroutine_suspended) {
                    return coroutine_suspended;
                }
                resp = (KSetUserSettingsRsp) userSettings;
                this.L$0 = $this$CustomerSettingActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.L$2 = SpillingKt.nullOutSpilledVariable(resp);
                this.label = 2;
                if ($this$CustomerSettingActionResult.emit(new ICustomerSettingAction.SettingItemSwitchSuccess(this.$action.getItem(), resp.getMsg()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                req = (KSetUserSettingsReq) this.L$1;
                ResultKt.throwOnFailure($result);
                userSettings = $result;
                resp = (KSetUserSettingsRsp) userSettings;
                this.L$0 = $this$CustomerSettingActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.L$2 = SpillingKt.nullOutSpilledVariable(resp);
                this.label = 2;
                if ($this$CustomerSettingActionResult.emit(new ICustomerSettingAction.SettingItemSwitchSuccess(this.$action.getItem(), resp.getMsg()), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                KSetUserSettingsRsp kSetUserSettingsRsp = (KSetUserSettingsRsp) this.L$2;
                KSetUserSettingsReq kSetUserSettingsReq = (KSetUserSettingsReq) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$2;
                obj = (KSetUserSettingsReq) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}