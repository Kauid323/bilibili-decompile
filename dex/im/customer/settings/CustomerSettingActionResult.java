package im.customer.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: CustomerSettingAction.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB@\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0007\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lim/customer/settings/CustomerSettingActionResult;", "", "newState", "Lim/customer/settings/CustomerSettingState;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "Lim/customer/settings/ICustomerSettingAction;", "<init>", "(Lim/customer/settings/CustomerSettingState;Lkotlinx/coroutines/flow/Flow;)V", "flowCollector", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lim/customer/settings/CustomerSettingState;Lkotlin/jvm/functions/Function2;)V", "getNewState", "()Lim/customer/settings/CustomerSettingState;", "getSideEffect$annotations", "()V", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingActionResult {
    private final CustomerSettingState newState;
    private final Flow<ICustomerSettingAction> sideEffect;

    public static /* synthetic */ void getSideEffect$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerSettingActionResult(CustomerSettingState newState, Flow<? extends ICustomerSettingAction> flow) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(flow, "sideEffect");
        this.newState = newState;
        this.sideEffect = flow;
    }

    public /* synthetic */ CustomerSettingActionResult(CustomerSettingState customerSettingState, Flow flow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(customerSettingState, (i2 & 2) != 0 ? FlowKt.emptyFlow() : flow);
    }

    public final CustomerSettingState getNewState() {
        return this.newState;
    }

    public final Flow<ICustomerSettingAction> getSideEffect() {
        return this.sideEffect;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerSettingActionResult(CustomerSettingState newState, Function2<? super FlowCollector<? super ICustomerSettingAction>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this(newState, FlowKt.flow(function2));
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(function2, "flowCollector");
    }
}