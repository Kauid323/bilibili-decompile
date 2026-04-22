package kntr.app.im.chat.sticker.manage;

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

/* compiled from: __dca04c69acf9ea5bbe8a3c30bd48699e.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__dca04c69acf9ea5bbe8a3c30bd48699e", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "sticker_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __dca04c69acf9ea5bbe8a3c30bd48699eKt {
    public static final RouterTarget __dca04c69acf9ea5bbe8a3c30bd48699e(RouterTargetContext $this$__dca04c69acf9ea5bbe8a3c30bd48699e) {
        Intrinsics.checkNotNullParameter($this$__dca04c69acf9ea5bbe8a3c30bd48699e, "<this>");
        Function3 __f__ = ComposableSingletons$__dca04c69acf9ea5bbe8a3c30bd48699eKt.INSTANCE.getLambda$937036902$sticker_debug();
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.im.chat.sticker.manage", (KClass) null, "StickerManagerPage", (String) null);
    }
}