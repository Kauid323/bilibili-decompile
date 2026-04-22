package kntr.app.tribee.publish.ui.v2;

import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlin.reflect.KTypeProjection;

/* compiled from: __e6eacfdb6dadef5f64fe32d1a07d1f01.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__e6eacfdb6dadef5f64fe32d1a07d1f01", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __e6eacfdb6dadef5f64fe32d1a07d1f01Kt {
    public static final RouterTarget __e6eacfdb6dadef5f64fe32d1a07d1f01(RouterTargetContext $this$__e6eacfdb6dadef5f64fe32d1a07d1f01) {
        Intrinsics.checkNotNullParameter($this$__e6eacfdb6dadef5f64fe32d1a07d1f01, "<this>");
        final Ref.ObjectRef tribeeIdStr = new Ref.ObjectRef();
        tribeeIdStr.element = $this$__e6eacfdb6dadef5f64fe32d1a07d1f01.getUriParam("tribee_id");
        if (tribeeIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeIdStr` not provided.");
        }
        final Ref.ObjectRef tribeeName = new Ref.ObjectRef();
        tribeeName.element = $this$__e6eacfdb6dadef5f64fe32d1a07d1f01.getUriParam("tribee_name");
        if (tribeeName.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeName` not provided.");
        }
        final Ref.ObjectRef resultKey = new Ref.ObjectRef();
        resultKey.element = $this$__e6eacfdb6dadef5f64fe32d1a07d1f01.getUriParam("result_key");
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__e6eacfdb6dadef5f64fe32d1a07d1f01.getUriParam("from_spmid");
        Function0 __f__ = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.__e6eacfdb6dadef5f64fe32d1a07d1f01Kt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __e6eacfdb6dadef5f64fe32d1a07d1f01$lambda$0;
                __e6eacfdb6dadef5f64fe32d1a07d1f01$lambda$0 = __e6eacfdb6dadef5f64fe32d1a07d1f01Kt.__e6eacfdb6dadef5f64fe32d1a07d1f01$lambda$0(tribeeIdStr, tribeeName, resultKey, fromSpmid);
                return __e6eacfdb6dadef5f64fe32d1a07d1f01$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.tribee.publish.ui.v2", null, "TribeePublishCreatePage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __e6eacfdb6dadef5f64fe32d1a07d1f01$lambda$0(Ref.ObjectRef $tribeeIdStr, Ref.ObjectRef $tribeeName, Ref.ObjectRef $resultKey, Ref.ObjectRef $fromSpmid) {
        return TribeePublishCreatePageKt.TribeePublishCreatePage((String) $tribeeIdStr.element, (String) $tribeeName.element, (String) $resultKey.element, (String) $fromSpmid.element);
    }
}