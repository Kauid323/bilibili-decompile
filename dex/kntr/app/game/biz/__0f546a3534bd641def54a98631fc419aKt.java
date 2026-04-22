package kntr.app.game.biz;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.base.router.target.FunctionTarget;
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

/* compiled from: __0f546a3534bd641def54a98631fc419a.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__0f546a3534bd641def54a98631fc419a", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __0f546a3534bd641def54a98631fc419aKt {
    public static final RouterTarget __0f546a3534bd641def54a98631fc419a(RouterTargetContext $this$__0f546a3534bd641def54a98631fc419a) {
        Intrinsics.checkNotNullParameter($this$__0f546a3534bd641def54a98631fc419a, "<this>");
        final Ref.ObjectRef type = new Ref.ObjectRef();
        type.element = $this$__0f546a3534bd641def54a98631fc419a.getUriParam("type");
        final Ref.ObjectRef sourceFrom = new Ref.ObjectRef();
        sourceFrom.element = $this$__0f546a3534bd641def54a98631fc419a.getUriParam(RouterHelperKt.PARAM_SOURCE_FROM);
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(536192968, true, new Function2() { // from class: kntr.app.game.biz.__0f546a3534bd641def54a98631fc419aKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __0f546a3534bd641def54a98631fc419a$lambda$0;
                __0f546a3534bd641def54a98631fc419a$lambda$0 = __0f546a3534bd641def54a98631fc419aKt.__0f546a3534bd641def54a98631fc419a$lambda$0(type, sourceFrom, (Composer) obj, ((Integer) obj2).intValue());
                return __0f546a3534bd641def54a98631fc419a$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.game.biz", (KClass) null, "DownloaderTestComposable", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __0f546a3534bd641def54a98631fc419a$lambda$0(Ref.ObjectRef $type, Ref.ObjectRef $sourceFrom, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C12@447L81:__0f546a3534bd641def54a98631fc419a.kt#351edr");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(536192968, $changed, -1, "kntr.app.game.biz.__0f546a3534bd641def54a98631fc419a.<anonymous> (__0f546a3534bd641def54a98631fc419a.kt:12)");
            }
            DownloaderTestKt.DownloaderTestComposable((String) $type.element, (String) $sourceFrom.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}