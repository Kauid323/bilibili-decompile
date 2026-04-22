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

/* compiled from: __5f6b37624178996022fdb5b1b59fe60c.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__5f6b37624178996022fdb5b1b59fe60c", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __5f6b37624178996022fdb5b1b59fe60cKt {
    public static final RouterTarget __5f6b37624178996022fdb5b1b59fe60c(RouterTargetContext $this$__5f6b37624178996022fdb5b1b59fe60c) {
        Intrinsics.checkNotNullParameter($this$__5f6b37624178996022fdb5b1b59fe60c, "<this>");
        final Ref.ObjectRef steamId = new Ref.ObjectRef();
        steamId.element = $this$__5f6b37624178996022fdb5b1b59fe60c.getUriParam("steamId");
        if (steamId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `steamId` not provided.");
        }
        final Ref.ObjectRef appId = new Ref.ObjectRef();
        appId.element = $this$__5f6b37624178996022fdb5b1b59fe60c.getUriParam("appId");
        if (appId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `appId` not provided.");
        }
        final Ref.ObjectRef sourceFrom = new Ref.ObjectRef();
        sourceFrom.element = $this$__5f6b37624178996022fdb5b1b59fe60c.getUriParam(RouterHelperKt.PARAM_SOURCE_FROM);
        if (sourceFrom.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `sourceFrom` not provided.");
        }
        final Ref.ObjectRef steamGameName = new Ref.ObjectRef();
        steamGameName.element = $this$__5f6b37624178996022fdb5b1b59fe60c.getUriParam("steamGameName");
        final Ref.ObjectRef defaultShowRareOnly = new Ref.ObjectRef();
        defaultShowRareOnly.element = $this$__5f6b37624178996022fdb5b1b59fe60c.getUriParam("defaultShowRareOnly");
        if (defaultShowRareOnly.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `defaultShowRareOnly` not provided.");
        }
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(545301242, true, new Function3() { // from class: kntr.app.game.steam.__5f6b37624178996022fdb5b1b59fe60cKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __5f6b37624178996022fdb5b1b59fe60c$lambda$0;
                __5f6b37624178996022fdb5b1b59fe60c$lambda$0 = __5f6b37624178996022fdb5b1b59fe60cKt.__5f6b37624178996022fdb5b1b59fe60c$lambda$0(steamId, appId, sourceFrom, steamGameName, defaultShowRareOnly, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __5f6b37624178996022fdb5b1b59fe60c$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.game.steam", (KClass) null, "SteamGameAchievementPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __5f6b37624178996022fdb5b1b59fe60c$lambda$0(Ref.ObjectRef $steamId, Ref.ObjectRef $appId, Ref.ObjectRef $sourceFrom, Ref.ObjectRef $steamGameName, Ref.ObjectRef $defaultShowRareOnly, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)29@1178L221:__5f6b37624178996022fdb5b1b59fe60c.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(545301242, $dirty2, -1, "kntr.app.game.steam.__5f6b37624178996022fdb5b1b59fe60c.<anonymous> (__5f6b37624178996022fdb5b1b59fe60c.kt:29)");
            }
            SteamGameAchievementPageKt.SteamGameAchievementPage((String) $steamId.element, (String) $appId.element, (String) $sourceFrom.element, modifier, (String) $steamGameName.element, (String) $defaultShowRareOnly.element, $composer, ($dirty2 << 9) & 7168, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}