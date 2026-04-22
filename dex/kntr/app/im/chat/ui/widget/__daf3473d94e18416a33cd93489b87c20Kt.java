package kntr.app.im.chat.ui.widget;

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

/* compiled from: __daf3473d94e18416a33cd93489b87c20.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__daf3473d94e18416a33cd93489b87c20", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __daf3473d94e18416a33cd93489b87c20Kt {
    public static final RouterTarget __daf3473d94e18416a33cd93489b87c20(RouterTargetContext $this$__daf3473d94e18416a33cd93489b87c20) {
        Intrinsics.checkNotNullParameter($this$__daf3473d94e18416a33cd93489b87c20, "<this>");
        Function2 __f__ = ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt.INSTANCE.getLambda$1213819105$ui_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.im.chat.ui.widget", (KClass) null, "PopUpBubbleMenuPreview", (String) null);
    }
}