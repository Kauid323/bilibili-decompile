package im.setting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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

/* compiled from: __28ea9a7ab5abd79ce6c6034af1df0d29.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__28ea9a7ab5abd79ce6c6034af1df0d29", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __28ea9a7ab5abd79ce6c6034af1df0d29Kt {
    public static final RouterTarget __28ea9a7ab5abd79ce6c6034af1df0d29(RouterTargetContext $this$__28ea9a7ab5abd79ce6c6034af1df0d29) {
        Intrinsics.checkNotNullParameter($this$__28ea9a7ab5abd79ce6c6034af1df0d29, "<this>");
        final Ref.ObjectRef assistantType = new Ref.ObjectRef();
        assistantType.element = $this$__28ea9a7ab5abd79ce6c6034af1df0d29.getUriParam("assistantType");
        if (assistantType.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `assistantType` not provided.");
        }
        final Ref.ObjectRef assistId = new Ref.ObjectRef();
        assistId.element = $this$__28ea9a7ab5abd79ce6c6034af1df0d29.getUriParam("assistId");
        if (assistId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `assistId` not provided.");
        }
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(-1665311286, true, new Function3() { // from class: im.setting.__28ea9a7ab5abd79ce6c6034af1df0d29Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __28ea9a7ab5abd79ce6c6034af1df0d29$lambda$0;
                __28ea9a7ab5abd79ce6c6034af1df0d29$lambda$0 = __28ea9a7ab5abd79ce6c6034af1df0d29Kt.__28ea9a7ab5abd79ce6c6034af1df0d29$lambda$0(assistantType, assistId, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __28ea9a7ab5abd79ce6c6034af1df0d29$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.setting", (KClass) null, "AssistantChatSettingPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __28ea9a7ab5abd79ce6c6034af1df0d29$lambda$0(Ref.ObjectRef $assistantType, Ref.ObjectRef $assistId, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)20@798L122:__28ea9a7ab5abd79ce6c6034af1df0d29.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1665311286, $dirty, -1, "im.setting.__28ea9a7ab5abd79ce6c6034af1df0d29.<anonymous> (__28ea9a7ab5abd79ce6c6034af1df0d29.kt:20)");
            }
            IMSettingPageKt.AssistantChatSettingPage((String) $assistantType.element, (String) $assistId.element, modifier, $composer, ($dirty << 6) & 896, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}