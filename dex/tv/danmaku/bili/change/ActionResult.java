package tv.danmaku.bili.change;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: Actions.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB@\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0007\u0010\u000fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/change/ActionResult;", "", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/change/AccountSwitchPage;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "Ltv/danmaku/bili/change/ISwitchAction;", "<init>", "(Ltv/danmaku/bili/change/AccountSwitchPage;Lkotlinx/coroutines/flow/Flow;)V", "effectCollector", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ltv/danmaku/bili/change/AccountSwitchPage;Lkotlin/jvm/functions/Function2;)V", "getState", "()Ltv/danmaku/bili/change/AccountSwitchPage;", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActionResult {
    public static final int $stable = 8;
    private final Flow<ISwitchAction> sideEffect;
    private final AccountSwitchPage state;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionResult copy$default(ActionResult actionResult, AccountSwitchPage accountSwitchPage, Flow flow, int i, Object obj) {
        if ((i & 1) != 0) {
            accountSwitchPage = actionResult.state;
        }
        if ((i & 2) != 0) {
            flow = actionResult.sideEffect;
        }
        return actionResult.copy(accountSwitchPage, flow);
    }

    public final AccountSwitchPage component1() {
        return this.state;
    }

    public final Flow<ISwitchAction> component2() {
        return this.sideEffect;
    }

    public final ActionResult copy(AccountSwitchPage accountSwitchPage, Flow<? extends ISwitchAction> flow) {
        Intrinsics.checkNotNullParameter(accountSwitchPage, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(flow, "sideEffect");
        return new ActionResult(accountSwitchPage, flow);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionResult) {
            ActionResult actionResult = (ActionResult) obj;
            return Intrinsics.areEqual(this.state, actionResult.state) && Intrinsics.areEqual(this.sideEffect, actionResult.sideEffect);
        }
        return false;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + this.sideEffect.hashCode();
    }

    public String toString() {
        AccountSwitchPage accountSwitchPage = this.state;
        return "ActionResult(state=" + accountSwitchPage + ", sideEffect=" + this.sideEffect + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionResult(AccountSwitchPage state, Flow<? extends ISwitchAction> flow) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(flow, "sideEffect");
        this.state = state;
        this.sideEffect = flow;
    }

    public /* synthetic */ ActionResult(AccountSwitchPage accountSwitchPage, Flow flow, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(accountSwitchPage, (i & 2) != 0 ? FlowKt.emptyFlow() : flow);
    }

    public final AccountSwitchPage getState() {
        return this.state;
    }

    public final Flow<ISwitchAction> getSideEffect() {
        return this.sideEffect;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionResult(AccountSwitchPage state, final Function2<? super FlowCollector<? super ISwitchAction>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this(state, new Flow<ISwitchAction>() { // from class: tv.danmaku.bili.change.ActionResult.1
            public Object collect(FlowCollector<? super ISwitchAction> flowCollector, Continuation<? super Unit> continuation) {
                Object invoke = function2.invoke(flowCollector, continuation);
                return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
            }
        });
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(function2, "effectCollector");
    }
}