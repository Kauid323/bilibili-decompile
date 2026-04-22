package kntr.common.router;

import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Router.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalRouter", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkntr/base/router/Router;", "getLocalRouter", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "router_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RouterKt {
    private static final ProvidableCompositionLocal<Router> LocalRouter = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new Function1() { // from class: kntr.common.router.RouterKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Router LocalRouter$lambda$0;
            LocalRouter$lambda$0 = RouterKt.LocalRouter$lambda$0((CompositionLocalAccessorScope) obj);
            return LocalRouter$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Router LocalRouter$lambda$0(CompositionLocalAccessorScope $this$compositionLocalWithComputedDefaultOf) {
        Intrinsics.checkNotNullParameter($this$compositionLocalWithComputedDefaultOf, "$this$compositionLocalWithComputedDefaultOf");
        return Router_androidKt.defaultRouter($this$compositionLocalWithComputedDefaultOf);
    }

    public static final ProvidableCompositionLocal<Router> getLocalRouter() {
        return LocalRouter;
    }
}