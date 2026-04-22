package home.sidecenter.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: SideCenterSettingsAction.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB@\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0007\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingsActionResult;", "", "newState", "Lhome/sidecenter/settings/SideCenterSettingsState;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "<init>", "(Lhome/sidecenter/settings/SideCenterSettingsState;Lkotlinx/coroutines/flow/Flow;)V", "flowCollector", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lhome/sidecenter/settings/SideCenterSettingsState;Lkotlin/jvm/functions/Function2;)V", "getNewState", "()Lhome/sidecenter/settings/SideCenterSettingsState;", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSettingsActionResult {
    public static final int $stable = 8;
    private final SideCenterSettingsState newState;
    private final Flow<ISideCenterSettingsAction> sideEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public SideCenterSettingsActionResult(SideCenterSettingsState newState, Flow<? extends ISideCenterSettingsAction> flow) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(flow, "sideEffect");
        this.newState = newState;
        this.sideEffect = flow;
    }

    public /* synthetic */ SideCenterSettingsActionResult(SideCenterSettingsState sideCenterSettingsState, Flow flow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sideCenterSettingsState, (i2 & 2) != 0 ? FlowKt.emptyFlow() : flow);
    }

    public final SideCenterSettingsState getNewState() {
        return this.newState;
    }

    public final Flow<ISideCenterSettingsAction> getSideEffect() {
        return this.sideEffect;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SideCenterSettingsActionResult(SideCenterSettingsState newState, Function2<? super FlowCollector<? super ISideCenterSettingsAction>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this(newState, FlowKt.flow(function2));
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(function2, "flowCollector");
    }
}