package im.direct.notification.interactive;

import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB@\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0007\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lim/direct/notification/interactive/INActionResult;", "", LinkHeader.Rel.Next, "Lim/direct/notification/interactive/INState;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "Lim/direct/notification/interactive/INAction;", "<init>", "(Lim/direct/notification/interactive/INState;Lkotlinx/coroutines/flow/Flow;)V", "flowCollector", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lim/direct/notification/interactive/INState;Lkotlin/jvm/functions/Function2;)V", "getNext", "()Lim/direct/notification/interactive/INState;", "getSideEffect$annotations", "()V", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INActionResult {
    private final INState next;
    private final Flow<INAction> sideEffect;

    public static /* synthetic */ void getSideEffect$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public INActionResult(INState next, Flow<? extends INAction> flow) {
        Intrinsics.checkNotNullParameter(next, LinkHeader.Rel.Next);
        Intrinsics.checkNotNullParameter(flow, "sideEffect");
        this.next = next;
        this.sideEffect = flow;
    }

    public /* synthetic */ INActionResult(INState iNState, Flow flow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iNState, (i2 & 2) != 0 ? FlowKt.emptyFlow() : flow);
    }

    public final INState getNext() {
        return this.next;
    }

    public final Flow<INAction> getSideEffect() {
        return this.sideEffect;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public INActionResult(INState next, Function2<? super FlowCollector<? super INAction>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this(next, FlowKt.flow(function2));
        Intrinsics.checkNotNullParameter(next, LinkHeader.Rel.Next);
        Intrinsics.checkNotNullParameter(function2, "flowCollector");
    }
}