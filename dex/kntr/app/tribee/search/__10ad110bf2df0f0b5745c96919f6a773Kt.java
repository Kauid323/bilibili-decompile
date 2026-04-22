package kntr.app.tribee.search;

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

/* compiled from: __10ad110bf2df0f0b5745c96919f6a773.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__10ad110bf2df0f0b5745c96919f6a773", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "search_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __10ad110bf2df0f0b5745c96919f6a773Kt {
    public static final RouterTarget __10ad110bf2df0f0b5745c96919f6a773(RouterTargetContext $this$__10ad110bf2df0f0b5745c96919f6a773) {
        Intrinsics.checkNotNullParameter($this$__10ad110bf2df0f0b5745c96919f6a773, "<this>");
        final Ref.ObjectRef tribeeId = new Ref.ObjectRef();
        tribeeId.element = $this$__10ad110bf2df0f0b5745c96919f6a773.getUriParam("tribee_id");
        if (tribeeId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `tribeeId` not provided.");
        }
        final Ref.ObjectRef keyword = new Ref.ObjectRef();
        keyword.element = $this$__10ad110bf2df0f0b5745c96919f6a773.getUriParam("keyword");
        final Ref.ObjectRef hint = new Ref.ObjectRef();
        hint.element = $this$__10ad110bf2df0f0b5745c96919f6a773.getUriParam("hint");
        final Ref.ObjectRef globalSearchUri = new Ref.ObjectRef();
        globalSearchUri.element = $this$__10ad110bf2df0f0b5745c96919f6a773.getUriParam("global_search_uri");
        final Ref.ObjectRef enableHistory = new Ref.ObjectRef();
        enableHistory.element = $this$__10ad110bf2df0f0b5745c96919f6a773.getUriParam("enable_history");
        final Ref.ObjectRef from = new Ref.ObjectRef();
        from.element = $this$__10ad110bf2df0f0b5745c96919f6a773.getUriParam("from");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(-340593036, true, new Function2() { // from class: kntr.app.tribee.search.__10ad110bf2df0f0b5745c96919f6a773Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __10ad110bf2df0f0b5745c96919f6a773$lambda$0;
                __10ad110bf2df0f0b5745c96919f6a773$lambda$0 = __10ad110bf2df0f0b5745c96919f6a773Kt.__10ad110bf2df0f0b5745c96919f6a773$lambda$0(tribeeId, keyword, hint, globalSearchUri, enableHistory, from, (Composer) obj, ((Integer) obj2).intValue());
                return __10ad110bf2df0f0b5745c96919f6a773$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.search", null, "TribeeSearchPage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __10ad110bf2df0f0b5745c96919f6a773$lambda$0(Ref.ObjectRef $tribeeId, Ref.ObjectRef $keyword, Ref.ObjectRef $hint, Ref.ObjectRef $globalSearchUri, Ref.ObjectRef $enableHistory, Ref.ObjectRef $from, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C20@795L191:__10ad110bf2df0f0b5745c96919f6a773.kt#yi4umz");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-340593036, $changed, -1, "kntr.app.tribee.search.__10ad110bf2df0f0b5745c96919f6a773.<anonymous> (__10ad110bf2df0f0b5745c96919f6a773.kt:20)");
            }
            TribeeSearchPageKt.TribeeSearchPage((String) $tribeeId.element, (String) $keyword.element, (String) $hint.element, (String) $globalSearchUri.element, (String) $enableHistory.element, (String) $from.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}