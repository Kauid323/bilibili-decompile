package kntr.app.game.steam;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.game.base.router.RouterHelperKt;
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
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: __5fef108a04e09d3757e02dbc4a5b1e9b.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__5fef108a04e09d3757e02dbc4a5b1e9b", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __5fef108a04e09d3757e02dbc4a5b1e9bKt {
    public static final RouterTarget __5fef108a04e09d3757e02dbc4a5b1e9b(RouterTargetContext $this$__5fef108a04e09d3757e02dbc4a5b1e9b) {
        Intrinsics.checkNotNullParameter($this$__5fef108a04e09d3757e02dbc4a5b1e9b, "<this>");
        final Ref.ObjectRef sourceFrom = new Ref.ObjectRef();
        sourceFrom.element = $this$__5fef108a04e09d3757e02dbc4a5b1e9b.getUriParam(RouterHelperKt.PARAM_SOURCE_FROM);
        if (sourceFrom.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `sourceFrom` not provided.");
        }
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(2032263054, true, new Function3() { // from class: kntr.app.game.steam.__5fef108a04e09d3757e02dbc4a5b1e9bKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __5fef108a04e09d3757e02dbc4a5b1e9b$lambda$0;
                __5fef108a04e09d3757e02dbc4a5b1e9b$lambda$0 = __5fef108a04e09d3757e02dbc4a5b1e9bKt.__5fef108a04e09d3757e02dbc4a5b1e9b$lambda$0(sourceFrom, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __5fef108a04e09d3757e02dbc4a5b1e9b$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.game.steam", (KClass) null, "SteamDetailPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __5fef108a04e09d3757e02dbc4a5b1e9b$lambda$0(Ref.ObjectRef $sourceFrom, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)16@643L80:__5fef108a04e09d3757e02dbc4a5b1e9b.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2032263054, $dirty, -1, "kntr.app.game.steam.__5fef108a04e09d3757e02dbc4a5b1e9b.<anonymous> (__5fef108a04e09d3757e02dbc4a5b1e9b.kt:16)");
            }
            SteamDetailPageKt.SteamDetailPage((String) $sourceFrom.element, modifier, $composer, ($dirty << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}