package kntr.app.deepsearch.ui;

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

/* compiled from: __d1ab7e04a18d60f0897345a7fcdc903a.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__d1ab7e04a18d60f0897345a7fcdc903a", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __d1ab7e04a18d60f0897345a7fcdc903aKt {
    public static final RouterTarget __d1ab7e04a18d60f0897345a7fcdc903a(RouterTargetContext $this$__d1ab7e04a18d60f0897345a7fcdc903a) {
        Intrinsics.checkNotNullParameter($this$__d1ab7e04a18d60f0897345a7fcdc903a, "<this>");
        final Ref.ObjectRef sessionQuery = new Ref.ObjectRef();
        sessionQuery.element = $this$__d1ab7e04a18d60f0897345a7fcdc903a.getUriParam("session_query");
        final Ref.ObjectRef sessionId = new Ref.ObjectRef();
        sessionId.element = $this$__d1ab7e04a18d60f0897345a7fcdc903a.getUriParam("session_id");
        final Ref.ObjectRef sessionTitle = new Ref.ObjectRef();
        sessionTitle.element = $this$__d1ab7e04a18d60f0897345a7fcdc903a.getUriParam("session_title");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(562625477, true, new Function2() { // from class: kntr.app.deepsearch.ui.__d1ab7e04a18d60f0897345a7fcdc903aKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __d1ab7e04a18d60f0897345a7fcdc903a$lambda$0;
                __d1ab7e04a18d60f0897345a7fcdc903a$lambda$0 = __d1ab7e04a18d60f0897345a7fcdc903aKt.__d1ab7e04a18d60f0897345a7fcdc903a$lambda$0(sessionQuery, sessionId, sessionTitle, (Composer) obj, ((Integer) obj2).intValue());
                return __d1ab7e04a18d60f0897345a7fcdc903a$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.deepsearch.ui", (KClass) null, "DeepSearch", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __d1ab7e04a18d60f0897345a7fcdc903a$lambda$0(Ref.ObjectRef $sessionQuery, Ref.ObjectRef $sessionId, Ref.ObjectRef $sessionTitle, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C13@518L116:__d1ab7e04a18d60f0897345a7fcdc903a.kt#7uvpm4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(562625477, $changed, -1, "kntr.app.deepsearch.ui.__d1ab7e04a18d60f0897345a7fcdc903a.<anonymous> (__d1ab7e04a18d60f0897345a7fcdc903a.kt:13)");
            }
            DeepSearchKt.DeepSearch((String) $sessionQuery.element, (String) $sessionId.element, (String) $sessionTitle.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}