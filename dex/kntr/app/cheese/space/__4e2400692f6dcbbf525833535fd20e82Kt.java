package kntr.app.cheese.space;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.base.router.target.FunctionTarget;
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

/* compiled from: __4e2400692f6dcbbf525833535fd20e82.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__4e2400692f6dcbbf525833535fd20e82", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "space_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __4e2400692f6dcbbf525833535fd20e82Kt {
    public static final RouterTarget __4e2400692f6dcbbf525833535fd20e82(RouterTargetContext $this$__4e2400692f6dcbbf525833535fd20e82) {
        Intrinsics.checkNotNullParameter($this$__4e2400692f6dcbbf525833535fd20e82, "<this>");
        final Ref.ObjectRef mid = new Ref.ObjectRef();
        mid.element = $this$__4e2400692f6dcbbf525833535fd20e82.getUriParam(ReportBuildInParam.MID);
        if (mid.element == null) {
            mid.element = "2042179637";
        }
        Function0 __f__ = new Function0() { // from class: kntr.app.cheese.space.__4e2400692f6dcbbf525833535fd20e82Kt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __4e2400692f6dcbbf525833535fd20e82$lambda$0;
                __4e2400692f6dcbbf525833535fd20e82$lambda$0 = __4e2400692f6dcbbf525833535fd20e82Kt.__4e2400692f6dcbbf525833535fd20e82$lambda$0(mid);
                return __4e2400692f6dcbbf525833535fd20e82$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.cheese.space", (KClass) null, "spaceCheesePageView", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __4e2400692f6dcbbf525833535fd20e82$lambda$0(Ref.ObjectRef $mid) {
        return SpaceCheesePageViewKt.spaceCheesePageView((String) $mid.element);
    }
}