package kntr.app.deepsearch.history.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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

/* compiled from: __b064976b35b1b0aff02cc0d00699ba25.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__b064976b35b1b0aff02cc0d00699ba25", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "history-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __b064976b35b1b0aff02cc0d00699ba25Kt {
    public static final RouterTarget __b064976b35b1b0aff02cc0d00699ba25(RouterTargetContext $this$__b064976b35b1b0aff02cc0d00699ba25) {
        Intrinsics.checkNotNullParameter($this$__b064976b35b1b0aff02cc0d00699ba25, "<this>");
        final Ref.ObjectRef sessionId = new Ref.ObjectRef();
        sessionId.element = $this$__b064976b35b1b0aff02cc0d00699ba25.getUriParam("session_id");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(721821643, true, new Function2() { // from class: kntr.app.deepsearch.history.ui.__b064976b35b1b0aff02cc0d00699ba25Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __b064976b35b1b0aff02cc0d00699ba25$lambda$0;
                __b064976b35b1b0aff02cc0d00699ba25$lambda$0 = __b064976b35b1b0aff02cc0d00699ba25Kt.__b064976b35b1b0aff02cc0d00699ba25$lambda$0(sessionId, (Composer) obj, ((Integer) obj2).intValue());
                return __b064976b35b1b0aff02cc0d00699ba25$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.deepsearch.history.ui", (KClass) null, "HistoryPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __b064976b35b1b0aff02cc0d00699ba25$lambda$0(Ref.ObjectRef $sessionId, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C11@426L47:__b064976b35b1b0aff02cc0d00699ba25.kt#a2kngy");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(721821643, $changed, -1, "kntr.app.deepsearch.history.ui.__b064976b35b1b0aff02cc0d00699ba25.<anonymous> (__b064976b35b1b0aff02cc0d00699ba25.kt:11)");
            }
            HistoryPageKt.HistoryPage((String) $sessionId.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}