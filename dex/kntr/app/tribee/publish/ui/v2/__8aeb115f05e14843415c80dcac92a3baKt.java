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

/* compiled from: __8aeb115f05e14843415c80dcac92a3ba.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__8aeb115f05e14843415c80dcac92a3ba", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __8aeb115f05e14843415c80dcac92a3baKt {
    public static final RouterTarget __8aeb115f05e14843415c80dcac92a3ba(RouterTargetContext $this$__8aeb115f05e14843415c80dcac92a3ba) {
        Intrinsics.checkNotNullParameter($this$__8aeb115f05e14843415c80dcac92a3ba, "<this>");
        final Ref.ObjectRef id = new Ref.ObjectRef();
        id.element = $this$__8aeb115f05e14843415c80dcac92a3ba.getUriParam("content_id");
        if (id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `id` not provided.");
        }
        final Ref.ObjectRef tribeeIdStr = new Ref.ObjectRef();
        tribeeIdStr.element = $this$__8aeb115f05e14843415c80dcac92a3ba.getUriParam("tribee_id");
        if (tribeeIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeIdStr` not provided.");
        }
        final Ref.ObjectRef tribeeName = new Ref.ObjectRef();
        tribeeName.element = $this$__8aeb115f05e14843415c80dcac92a3ba.getUriParam("tribee_name");
        if (tribeeName.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeName` not provided.");
        }
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__8aeb115f05e14843415c80dcac92a3ba.getUriParam("from_spmid");
        Function0 __f__ = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.__8aeb115f05e14843415c80dcac92a3baKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __8aeb115f05e14843415c80dcac92a3ba$lambda$0;
                __8aeb115f05e14843415c80dcac92a3ba$lambda$0 = __8aeb115f05e14843415c80dcac92a3baKt.__8aeb115f05e14843415c80dcac92a3ba$lambda$0(id, tribeeIdStr, tribeeName, fromSpmid);
                return __8aeb115f05e14843415c80dcac92a3ba$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.tribee.publish.ui.v2", null, "TribeePublishEdit", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __8aeb115f05e14843415c80dcac92a3ba$lambda$0(Ref.ObjectRef $id, Ref.ObjectRef $tribeeIdStr, Ref.ObjectRef $tribeeName, Ref.ObjectRef $fromSpmid) {
        return TribeePublishEditPageKt.TribeePublishEdit((String) $id.element, (String) $tribeeIdStr.element, (String) $tribeeName.element, (String) $fromSpmid.element);
    }
}