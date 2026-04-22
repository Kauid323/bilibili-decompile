package kntr.app.digital.backpack;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.ParameterInvalidTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: __dc1ae79b2337552b6722ae3bc2a56764.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__dc1ae79b2337552b6722ae3bc2a56764", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "backpack_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __dc1ae79b2337552b6722ae3bc2a56764Kt {
    public static final RouterTarget __dc1ae79b2337552b6722ae3bc2a56764(RouterTargetContext $this$__dc1ae79b2337552b6722ae3bc2a56764) {
        Intrinsics.checkNotNullParameter($this$__dc1ae79b2337552b6722ae3bc2a56764, "<this>");
        final Ref.ObjectRef act_id = new Ref.ObjectRef();
        act_id.element = $this$__dc1ae79b2337552b6722ae3bc2a56764.getUriParam("act_id");
        if (act_id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `act_id` not provided.");
        }
        final Ref.ObjectRef mid = new Ref.ObjectRef();
        mid.element = $this$__dc1ae79b2337552b6722ae3bc2a56764.getUriParam(ReportBuildInParam.MID);
        final Ref.ObjectRef page_from = new Ref.ObjectRef();
        page_from.element = $this$__dc1ae79b2337552b6722ae3bc2a56764.getUriParam("page_from");
        final Ref.ObjectRef from = new Ref.ObjectRef();
        from.element = $this$__dc1ae79b2337552b6722ae3bc2a56764.getUriParam("from");
        final Ref.ObjectRef from_id = new Ref.ObjectRef();
        from_id.element = $this$__dc1ae79b2337552b6722ae3bc2a56764.getUriParam("from_id");
        final Ref.ObjectRef f_source = new Ref.ObjectRef();
        f_source.element = $this$__dc1ae79b2337552b6722ae3bc2a56764.getUriParam("f_source");
        Function0 __f__ = new Function0() { // from class: kntr.app.digital.backpack.__dc1ae79b2337552b6722ae3bc2a56764Kt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __dc1ae79b2337552b6722ae3bc2a56764$lambda$0;
                __dc1ae79b2337552b6722ae3bc2a56764$lambda$0 = __dc1ae79b2337552b6722ae3bc2a56764Kt.__dc1ae79b2337552b6722ae3bc2a56764$lambda$0(act_id, mid, page_from, from, from_id, f_source);
                return __dc1ae79b2337552b6722ae3bc2a56764$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.digital.backpack", (KClass) null, "pageEntrance", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __dc1ae79b2337552b6722ae3bc2a56764$lambda$0(Ref.ObjectRef $act_id, Ref.ObjectRef $mid, Ref.ObjectRef $page_from, Ref.ObjectRef $from, Ref.ObjectRef $from_id, Ref.ObjectRef $f_source) {
        return BackpackKt.pageEntrance((String) $act_id.element, (String) $mid.element, (String) $page_from.element, (String) $from.element, (String) $from_id.element, (String) $f_source.element);
    }
}