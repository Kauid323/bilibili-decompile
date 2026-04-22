package im.customer.settings;

import com.bapis.bilibili.im.customer.interfaces.KCustomerInterfaceMoss;
import com.bapis.bilibili.im.customer.interfaces.KGetUserSettingsReq;
import com.bapis.bilibili.im.customer.interfaces.KGetUserSettingsRsp;
import com.tencent.smtt.sdk.TbsListener;
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
@DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$loadAction$2", f = "CustomerSettingStateHolder.kt", i = {0, 1, 1, 2, 2}, l = {115, 118, TbsListener.ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR}, m = "invokeSuspend", n = {"$this$CustomerSettingActionResult", "$this$CustomerSettingActionResult", "result", "$this$CustomerSettingActionResult", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class CustomerSettingStateHolder$loadAction$2 extends SuspendLambda implements Function2<FlowCollector<? super ICustomerSettingAction>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CustomerSettingStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerSettingStateHolder$loadAction$2(CustomerSettingStateHolder customerSettingStateHolder, Continuation<? super CustomerSettingStateHolder$loadAction$2> continuation) {
        super(2, continuation);
        this.this$0 = customerSettingStateHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> customerSettingStateHolder$loadAction$2 = new CustomerSettingStateHolder$loadAction$2(this.this$0, continuation);
        customerSettingStateHolder$loadAction$2.L$0 = obj;
        return customerSettingStateHolder$loadAction$2;
    }

    public final Object invoke(FlowCollector<? super ICustomerSettingAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CustomerShopId customerShopId;
        CustomerShopId customerShopId2;
        CustomerShopId customerShopId3;
        CustomerShopId customerShopId4;
        Object userSettings;
        KGetUserSettingsRsp result;
        CustomerShopId customerShopId5;
        FlowCollector $this$CustomerSettingActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            ILogger kLog = KLog_androidKt.getKLog();
            customerShopId = this.this$0.id;
            kLog.e("CustomerSettingStateHolder", "Fail to load settings of shop " + customerShopId + ", " + e2);
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$CustomerSettingActionResult);
            this.L$1 = SpillingKt.nullOutSpilledVariable(e2);
            this.label = 3;
            if ($this$CustomerSettingActionResult.emit(new ICustomerSettingAction.LoadSettingFailed(e2), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ILogger kLog2 = KLog_androidKt.getKLog();
                customerShopId2 = this.this$0.id;
                kLog2.i("CustomerSettingStateHolder", "Start load settings of " + customerShopId2);
                KCustomerInterfaceMoss kCustomerInterfaceMoss = new KCustomerInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                customerShopId3 = this.this$0.id;
                long shopFatherId = customerShopId3.getShopFatherId();
                customerShopId4 = this.this$0.id;
                this.L$0 = $this$CustomerSettingActionResult;
                this.label = 1;
                userSettings = kCustomerInterfaceMoss.getUserSettings(new KGetUserSettingsReq(shopFatherId, customerShopId4.getShopId()), (Continuation) this);
                if (userSettings == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (KGetUserSettingsRsp) userSettings;
                customerShopId5 = this.this$0.id;
                this.L$0 = $this$CustomerSettingActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$CustomerSettingActionResult.emit(new ICustomerSettingAction.LoadSettingSuccess(new CustomerSettingState(result, customerShopId5)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                userSettings = $result;
                result = (KGetUserSettingsRsp) userSettings;
                customerShopId5 = this.this$0.id;
                this.L$0 = $this$CustomerSettingActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$CustomerSettingActionResult.emit(new ICustomerSettingAction.LoadSettingSuccess(new CustomerSettingState(result, customerShopId5)), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                KGetUserSettingsRsp kGetUserSettingsRsp = (KGetUserSettingsRsp) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}