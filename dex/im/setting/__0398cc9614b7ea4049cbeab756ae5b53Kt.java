package im.setting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.tencent.smtt.sdk.TbsListener;
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

/* compiled from: __0398cc9614b7ea4049cbeab756ae5b53.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__0398cc9614b7ea4049cbeab756ae5b53", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __0398cc9614b7ea4049cbeab756ae5b53Kt {
    public static final RouterTarget __0398cc9614b7ea4049cbeab756ae5b53(RouterTargetContext $this$__0398cc9614b7ea4049cbeab756ae5b53) {
        Intrinsics.checkNotNullParameter($this$__0398cc9614b7ea4049cbeab756ae5b53, "<this>");
        final Ref.ObjectRef uid = new Ref.ObjectRef();
        uid.element = $this$__0398cc9614b7ea4049cbeab756ae5b53.getUriParam("uid");
        if (uid.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `uid` not provided.");
        }
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(-1481744918, true, new Function3() { // from class: im.setting.__0398cc9614b7ea4049cbeab756ae5b53Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __0398cc9614b7ea4049cbeab756ae5b53$lambda$0;
                __0398cc9614b7ea4049cbeab756ae5b53$lambda$0 = __0398cc9614b7ea4049cbeab756ae5b53Kt.__0398cc9614b7ea4049cbeab756ae5b53$lambda$0(uid, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __0398cc9614b7ea4049cbeab756ae5b53$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.setting", (KClass) null, "PersonalChatSettingPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __0398cc9614b7ea4049cbeab756ae5b53$lambda$0(Ref.ObjectRef $uid, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)16@606L74:__0398cc9614b7ea4049cbeab756ae5b53.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1481744918, $dirty, -1, "im.setting.__0398cc9614b7ea4049cbeab756ae5b53.<anonymous> (__0398cc9614b7ea4049cbeab756ae5b53.kt:16)");
            }
            IMSettingPageKt.PersonalChatSettingPage((String) $uid.element, modifier, $composer, ($dirty << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}