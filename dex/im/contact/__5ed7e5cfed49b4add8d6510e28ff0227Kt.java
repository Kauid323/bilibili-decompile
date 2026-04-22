package im.contact;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: __5ed7e5cfed49b4add8d6510e28ff0227.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__5ed7e5cfed49b4add8d6510e28ff0227", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "contact-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __5ed7e5cfed49b4add8d6510e28ff0227Kt {
    public static final RouterTarget __5ed7e5cfed49b4add8d6510e28ff0227(RouterTargetContext $this$__5ed7e5cfed49b4add8d6510e28ff0227) {
        Intrinsics.checkNotNullParameter($this$__5ed7e5cfed49b4add8d6510e28ff0227, "<this>");
        Function3 __f__ = ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt.INSTANCE.m3123getLambda$1266692422$contact_ui_debug();
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.contact", (KClass) null, "IMContactPage", (String) null);
    }
}