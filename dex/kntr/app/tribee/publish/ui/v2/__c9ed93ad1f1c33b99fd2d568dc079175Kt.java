package kntr.app.tribee.publish.ui.v2;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.ParameterInvalidTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: __c9ed93ad1f1c33b99fd2d568dc079175.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__c9ed93ad1f1c33b99fd2d568dc079175", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __c9ed93ad1f1c33b99fd2d568dc079175Kt {
    public static final RouterTarget __c9ed93ad1f1c33b99fd2d568dc079175(RouterTargetContext $this$__c9ed93ad1f1c33b99fd2d568dc079175) {
        Intrinsics.checkNotNullParameter($this$__c9ed93ad1f1c33b99fd2d568dc079175, "<this>");
        final Ref.ObjectRef id = new Ref.ObjectRef();
        id.element = $this$__c9ed93ad1f1c33b99fd2d568dc079175.getUriParam("content_id");
        if (id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `id` not provided.");
        }
        final Ref.ObjectRef tribeeIdStr = new Ref.ObjectRef();
        tribeeIdStr.element = $this$__c9ed93ad1f1c33b99fd2d568dc079175.getUriParam("tribee_id");
        if (tribeeIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeIdStr` not provided.");
        }
        final Ref.ObjectRef tribeeName = new Ref.ObjectRef();
        tribeeName.element = $this$__c9ed93ad1f1c33b99fd2d568dc079175.getUriParam("tribee_name");
        if (tribeeName.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeName` not provided.");
        }
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__c9ed93ad1f1c33b99fd2d568dc079175.getUriParam("from_spmid");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(-557927645, true, new Function2() { // from class: kntr.app.tribee.publish.ui.v2.__c9ed93ad1f1c33b99fd2d568dc079175Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __c9ed93ad1f1c33b99fd2d568dc079175$lambda$0;
                __c9ed93ad1f1c33b99fd2d568dc079175$lambda$0 = __c9ed93ad1f1c33b99fd2d568dc079175Kt.__c9ed93ad1f1c33b99fd2d568dc079175$lambda$0(id, tribeeIdStr, tribeeName, fromSpmid, (Composer) obj, ((Integer) obj2).intValue());
                return __c9ed93ad1f1c33b99fd2d568dc079175$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.publish.ui.v2", null, "PreviewTribeePublishEdit", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __c9ed93ad1f1c33b99fd2d568dc079175$lambda$0(Ref.ObjectRef $id, Ref.ObjectRef $tribeeIdStr, Ref.ObjectRef $tribeeName, Ref.ObjectRef $fromSpmid, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C24@938L139:__c9ed93ad1f1c33b99fd2d568dc079175.kt#oim1ra");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-557927645, $changed, -1, "kntr.app.tribee.publish.ui.v2.__c9ed93ad1f1c33b99fd2d568dc079175.<anonymous> (__c9ed93ad1f1c33b99fd2d568dc079175.kt:24)");
            }
            TribeePublishEditPageKt.PreviewTribeePublishEdit((String) $id.element, (String) $tribeeIdStr.element, (String) $tribeeName.element, (String) $fromSpmid.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}