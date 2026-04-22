package im.session.home;

import androidx.compose.runtime.Composer;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: __f0e1517fc0b0c0049a6d8dc182051933.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__f0e1517fc0b0c0049a6d8dc182051933", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __f0e1517fc0b0c0049a6d8dc182051933Kt {
    public static final RouterTarget __f0e1517fc0b0c0049a6d8dc182051933(RouterTargetContext $this$__f0e1517fc0b0c0049a6d8dc182051933) {
        Intrinsics.checkNotNullParameter($this$__f0e1517fc0b0c0049a6d8dc182051933, "<this>");
        Function2 __f__ = ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt.INSTANCE.getLambda$263879560$session_ui_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.session.home", (KClass) null, "IMSessionHomePage", (String) null);
    }
}