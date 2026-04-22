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

/* compiled from: __4fd5866a38f70afe7106a559508ac8d6.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__4fd5866a38f70afe7106a559508ac8d6", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __4fd5866a38f70afe7106a559508ac8d6Kt {
    public static final RouterTarget __4fd5866a38f70afe7106a559508ac8d6(RouterTargetContext $this$__4fd5866a38f70afe7106a559508ac8d6) {
        Intrinsics.checkNotNullParameter($this$__4fd5866a38f70afe7106a559508ac8d6, "<this>");
        final Ref.ObjectRef steamId = new Ref.ObjectRef();
        steamId.element = $this$__4fd5866a38f70afe7106a559508ac8d6.getUriParam("steamId");
        if (steamId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `steamId` not provided.");
        }
        final Ref.ObjectRef appId = new Ref.ObjectRef();
        appId.element = $this$__4fd5866a38f70afe7106a559508ac8d6.getUriParam("appId");
        if (appId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `appId` not provided.");
        }
        final Ref.ObjectRef sourceFrom = new Ref.ObjectRef();
        sourceFrom.element = $this$__4fd5866a38f70afe7106a559508ac8d6.getUriParam(RouterHelperKt.PARAM_SOURCE_FROM);
        if (sourceFrom.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `sourceFrom` not provided.");
        }
        final Ref.ObjectRef steamGameName = new Ref.ObjectRef();
        steamGameName.element = $this$__4fd5866a38f70afe7106a559508ac8d6.getUriParam("steamGameName");
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(1550875074, true, new Function3() { // from class: kntr.app.game.steam.__4fd5866a38f70afe7106a559508ac8d6Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __4fd5866a38f70afe7106a559508ac8d6$lambda$0;
                __4fd5866a38f70afe7106a559508ac8d6$lambda$0 = __4fd5866a38f70afe7106a559508ac8d6Kt.__4fd5866a38f70afe7106a559508ac8d6$lambda$0(steamId, appId, sourceFrom, steamGameName, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __4fd5866a38f70afe7106a559508ac8d6$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.game.steam", (KClass) null, "SteamGameDLCPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __4fd5866a38f70afe7106a559508ac8d6$lambda$0(Ref.ObjectRef $steamId, Ref.ObjectRef $appId, Ref.ObjectRef $sourceFrom, Ref.ObjectRef $steamGameName, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)25@982L164:__4fd5866a38f70afe7106a559508ac8d6.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1550875074, $dirty2, -1, "kntr.app.game.steam.__4fd5866a38f70afe7106a559508ac8d6.<anonymous> (__4fd5866a38f70afe7106a559508ac8d6.kt:25)");
            }
            SteamGameDLCPageKt.SteamGameDLCPage((String) $steamId.element, (String) $appId.element, (String) $sourceFrom.element, modifier, (String) $steamGameName.element, $composer, ($dirty2 << 9) & 7168, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}