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

/* compiled from: __fd566678ab6bcd24589717652fe7b8b4.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__fd566678ab6bcd24589717652fe7b8b4", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __fd566678ab6bcd24589717652fe7b8b4Kt {
    public static final RouterTarget __fd566678ab6bcd24589717652fe7b8b4(RouterTargetContext $this$__fd566678ab6bcd24589717652fe7b8b4) {
        Intrinsics.checkNotNullParameter($this$__fd566678ab6bcd24589717652fe7b8b4, "<this>");
        final Ref.ObjectRef tribeeIdStr = new Ref.ObjectRef();
        tribeeIdStr.element = $this$__fd566678ab6bcd24589717652fe7b8b4.getUriParam("tribee_id");
        if (tribeeIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeIdStr` not provided.");
        }
        final Ref.ObjectRef tribeeName = new Ref.ObjectRef();
        tribeeName.element = $this$__fd566678ab6bcd24589717652fe7b8b4.getUriParam("tribee_name");
        if (tribeeName.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeName` not provided.");
        }
        final Ref.ObjectRef resultKey = new Ref.ObjectRef();
        resultKey.element = $this$__fd566678ab6bcd24589717652fe7b8b4.getUriParam("result_key");
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__fd566678ab6bcd24589717652fe7b8b4.getUriParam("from_spmid");
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(-1906338208, true, new Function3() { // from class: kntr.app.tribee.publish.__fd566678ab6bcd24589717652fe7b8b4Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __fd566678ab6bcd24589717652fe7b8b4$lambda$0;
                __fd566678ab6bcd24589717652fe7b8b4$lambda$0 = __fd566678ab6bcd24589717652fe7b8b4Kt.__fd566678ab6bcd24589717652fe7b8b4$lambda$0(tribeeIdStr, tribeeName, resultKey, fromSpmid, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __fd566678ab6bcd24589717652fe7b8b4$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.publish", null, "TribeePublishCreate", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __fd566678ab6bcd24589717652fe7b8b4$lambda$0(Ref.ObjectRef $tribeeIdStr, Ref.ObjectRef $tribeeName, Ref.ObjectRef $resultKey, Ref.ObjectRef $fromSpmid, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)22@898L175:__fd566678ab6bcd24589717652fe7b8b4.kt#ufloxe");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1906338208, $dirty2, -1, "kntr.app.tribee.publish.__fd566678ab6bcd24589717652fe7b8b4.<anonymous> (__fd566678ab6bcd24589717652fe7b8b4.kt:22)");
            }
            TribeePublishCreateKt.TribeePublishCreate((String) $tribeeIdStr.element, (String) $tribeeName.element, modifier, (String) $resultKey.element, (String) $fromSpmid.element, $composer, ($dirty2 << 6) & 896, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}