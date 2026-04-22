package im.base.loading;

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

/* compiled from: __8b45085db97f0ceb7444b53cf357ee09.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__8b45085db97f0ceb7444b53cf357ee09", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __8b45085db97f0ceb7444b53cf357ee09Kt {
    public static final RouterTarget __8b45085db97f0ceb7444b53cf357ee09(RouterTargetContext $this$__8b45085db97f0ceb7444b53cf357ee09) {
        Intrinsics.checkNotNullParameter($this$__8b45085db97f0ceb7444b53cf357ee09, "<this>");
        Function2 __f__ = ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt.INSTANCE.m3112getLambda$985780536$base_ui_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.base.loading", (KClass) null, "LoadingPreview", (String) null);
    }
}