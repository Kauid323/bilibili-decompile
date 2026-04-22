package im.session.secondary;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: __5d9a10e68f7c53c8a52a91d57f34760f.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__5d9a10e68f7c53c8a52a91d57f34760f", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __5d9a10e68f7c53c8a52a91d57f34760fKt {
    public static final RouterTarget __5d9a10e68f7c53c8a52a91d57f34760f(RouterTargetContext $this$__5d9a10e68f7c53c8a52a91d57f34760f) {
        Intrinsics.checkNotNullParameter($this$__5d9a10e68f7c53c8a52a91d57f34760f, "<this>");
        final Ref.ObjectRef type = new Ref.ObjectRef();
        type.element = $this$__5d9a10e68f7c53c8a52a91d57f34760f.getUriParam("type");
        if (type.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `type` not provided.");
        }
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(1980621319, true, new Function2() { // from class: im.session.secondary.__5d9a10e68f7c53c8a52a91d57f34760fKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __5d9a10e68f7c53c8a52a91d57f34760f$lambda$0;
                __5d9a10e68f7c53c8a52a91d57f34760f$lambda$0 = __5d9a10e68f7c53c8a52a91d57f34760fKt.__5d9a10e68f7c53c8a52a91d57f34760f$lambda$0(type, (Composer) obj, ((Integer) obj2).intValue());
                return __5d9a10e68f7c53c8a52a91d57f34760f$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.session.secondary", (KClass) null, "IMSessionSecondaryPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __5d9a10e68f7c53c8a52a91d57f34760f$lambda$0(Ref.ObjectRef $type, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C15@562L48:__5d9a10e68f7c53c8a52a91d57f34760f.kt#e8iotq");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1980621319, $changed, -1, "im.session.secondary.__5d9a10e68f7c53c8a52a91d57f34760f.<anonymous> (__5d9a10e68f7c53c8a52a91d57f34760f.kt:15)");
            }
            IMSessionSecondaryPageKt.IMSessionSecondaryPage((String) $type.element, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}