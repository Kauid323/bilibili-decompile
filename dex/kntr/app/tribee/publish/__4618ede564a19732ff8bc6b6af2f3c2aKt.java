package kntr.app.tribee.publish;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.ParameterInvalidTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: __4618ede564a19732ff8bc6b6af2f3c2a.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__4618ede564a19732ff8bc6b6af2f3c2a", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __4618ede564a19732ff8bc6b6af2f3c2aKt {
    public static final RouterTarget __4618ede564a19732ff8bc6b6af2f3c2a(RouterTargetContext $this$__4618ede564a19732ff8bc6b6af2f3c2a) {
        Intrinsics.checkNotNullParameter($this$__4618ede564a19732ff8bc6b6af2f3c2a, "<this>");
        final Ref.ObjectRef id = new Ref.ObjectRef();
        id.element = $this$__4618ede564a19732ff8bc6b6af2f3c2a.getUriParam("content_id");
        if (id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `id` not provided.");
        }
        final Ref.ObjectRef tribeeIdStr = new Ref.ObjectRef();
        tribeeIdStr.element = $this$__4618ede564a19732ff8bc6b6af2f3c2a.getUriParam("tribee_id");
        if (tribeeIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeIdStr` not provided.");
        }
        final Ref.ObjectRef tribeeName = new Ref.ObjectRef();
        tribeeName.element = $this$__4618ede564a19732ff8bc6b6af2f3c2a.getUriParam("tribee_name");
        if (tribeeName.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeName` not provided.");
        }
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__4618ede564a19732ff8bc6b6af2f3c2a.getUriParam("from_spmid");
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(-1721645616, true, new Function3() { // from class: kntr.app.tribee.publish.__4618ede564a19732ff8bc6b6af2f3c2aKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __4618ede564a19732ff8bc6b6af2f3c2a$lambda$0;
                __4618ede564a19732ff8bc6b6af2f3c2a$lambda$0 = __4618ede564a19732ff8bc6b6af2f3c2aKt.__4618ede564a19732ff8bc6b6af2f3c2a$lambda$0(id, tribeeIdStr, tribeeName, fromSpmid, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __4618ede564a19732ff8bc6b6af2f3c2a$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.publish", null, "TribeePublishEdit", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __4618ede564a19732ff8bc6b6af2f3c2a$lambda$0(Ref.ObjectRef $id, Ref.ObjectRef $tribeeIdStr, Ref.ObjectRef $tribeeName, Ref.ObjectRef $fromSpmid, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)25@990L159:__4618ede564a19732ff8bc6b6af2f3c2a.kt#ufloxe");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1721645616, $dirty2, -1, "kntr.app.tribee.publish.__4618ede564a19732ff8bc6b6af2f3c2a.<anonymous> (__4618ede564a19732ff8bc6b6af2f3c2a.kt:25)");
            }
            TribeePublishEditKt.TribeePublishEdit((String) $id.element, (String) $tribeeIdStr.element, (String) $tribeeName.element, modifier, (String) $fromSpmid.element, $composer, ($dirty2 << 9) & 7168, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}