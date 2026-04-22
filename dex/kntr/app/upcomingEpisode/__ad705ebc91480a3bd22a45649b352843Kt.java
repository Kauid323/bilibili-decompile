package kntr.app.upcomingEpisode;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: __ad705ebc91480a3bd22a45649b352843.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__ad705ebc91480a3bd22a45649b352843", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __ad705ebc91480a3bd22a45649b352843Kt {
    public static final RouterTarget __ad705ebc91480a3bd22a45649b352843(RouterTargetContext $this$__ad705ebc91480a3bd22a45649b352843) {
        Intrinsics.checkNotNullParameter($this$__ad705ebc91480a3bd22a45649b352843, "<this>");
        final Ref.ObjectRef landingAnchorTime = new Ref.ObjectRef();
        landingAnchorTime.element = $this$__ad705ebc91480a3bd22a45649b352843.getUriParam("landing_anchor_time");
        final Ref.ObjectRef landingAnchorBizId = new Ref.ObjectRef();
        landingAnchorBizId.element = $this$__ad705ebc91480a3bd22a45649b352843.getUriParam("landing_anchor_bizid");
        final Ref.ObjectRef landingAnchorBizType = new Ref.ObjectRef();
        landingAnchorBizType.element = $this$__ad705ebc91480a3bd22a45649b352843.getUriParam("landing_anchor_biztype");
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(707628619, true, new Function3() { // from class: kntr.app.upcomingEpisode.__ad705ebc91480a3bd22a45649b352843Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __ad705ebc91480a3bd22a45649b352843$lambda$0;
                __ad705ebc91480a3bd22a45649b352843$lambda$0 = __ad705ebc91480a3bd22a45649b352843Kt.__ad705ebc91480a3bd22a45649b352843$lambda$0(landingAnchorTime, landingAnchorBizId, landingAnchorBizType, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __ad705ebc91480a3bd22a45649b352843$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.upcomingEpisode", null, "UpcomingEpisodePage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __ad705ebc91480a3bd22a45649b352843$lambda$0(Ref.ObjectRef $landingAnchorTime, Ref.ObjectRef $landingAnchorBizId, Ref.ObjectRef $landingAnchorBizType, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)14@625L196:__ad705ebc91480a3bd22a45649b352843.kt#jbu1nf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(707628619, $dirty, -1, "kntr.app.upcomingEpisode.__ad705ebc91480a3bd22a45649b352843.<anonymous> (__ad705ebc91480a3bd22a45649b352843.kt:14)");
            }
            UpcomingEpisodePageKt.UpcomingEpisodePage(modifier, (String) $landingAnchorTime.element, (String) $landingAnchorBizId.element, (String) $landingAnchorBizType.element, $composer, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}