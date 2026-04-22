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

/* compiled from: __c1bed3004bdc4ae5d67c3fba37af5075.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__c1bed3004bdc4ae5d67c3fba37af5075", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __c1bed3004bdc4ae5d67c3fba37af5075Kt {
    public static final RouterTarget __c1bed3004bdc4ae5d67c3fba37af5075(RouterTargetContext $this$__c1bed3004bdc4ae5d67c3fba37af5075) {
        Intrinsics.checkNotNullParameter($this$__c1bed3004bdc4ae5d67c3fba37af5075, "<this>");
        final Ref.ObjectRef page = new Ref.ObjectRef();
        page.element = $this$__c1bed3004bdc4ae5d67c3fba37af5075.getUriParam("page");
        if (page.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `page` not provided.");
        }
        final Ref.ObjectRef data = new Ref.ObjectRef();
        data.element = $this$__c1bed3004bdc4ae5d67c3fba37af5075.getUriParam(UtilsKt.DATA_KEY);
        Function3 __f__ = ComposableLambdaKt.composableLambdaInstance(-1909792534, true, new Function3() { // from class: im.setting.__c1bed3004bdc4ae5d67c3fba37af5075Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit __c1bed3004bdc4ae5d67c3fba37af5075$lambda$0;
                __c1bed3004bdc4ae5d67c3fba37af5075$lambda$0 = __c1bed3004bdc4ae5d67c3fba37af5075Kt.__c1bed3004bdc4ae5d67c3fba37af5075$lambda$0(page, data, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return __c1bed3004bdc4ae5d67c3fba37af5075$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "im.setting", (KClass) null, "IMSettingPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __c1bed3004bdc4ae5d67c3fba37af5075$lambda$0(Ref.ObjectRef $page, Ref.ObjectRef $data, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)17@645L89:__c1bed3004bdc4ae5d67c3fba37af5075.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1909792534, $dirty, -1, "im.setting.__c1bed3004bdc4ae5d67c3fba37af5075.<anonymous> (__c1bed3004bdc4ae5d67c3fba37af5075.kt:17)");
            }
            IMSettingPageKt.IMSettingPage((String) $page.element, modifier, (String) $data.element, $composer, ($dirty << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}