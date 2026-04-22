package kntr.common.router;

import android.content.Context;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Router.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"defaultRouter", "Lkntr/base/router/Router;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "immediateContextAware", "Landroidx/activity/contextaware/ContextAware;", "context", "Landroid/content/Context;", "router_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Router_androidKt {
    public static final Router defaultRouter(CompositionLocalAccessorScope $this$defaultRouter) {
        Intrinsics.checkNotNullParameter($this$defaultRouter, "<this>");
        final Context context = (Context) $this$defaultRouter.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext());
        Router.Builder this_$iv = GlobalRouterKt.getGlobalRouter().newBuilder();
        Function0 provider$iv = new Function0() { // from class: kntr.common.router.Router_androidKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Context defaultRouter$lambda$0;
                defaultRouter$lambda$0 = Router_androidKt.defaultRouter$lambda$0(context);
                return defaultRouter$lambda$0;
            }
        };
        this_$iv.addContextProvider(Reflection.typeOf(Context.class), provider$iv);
        Function0 provider$iv2 = new Function0() { // from class: kntr.common.router.Router_androidKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                ContextAware immediateContextAware;
                immediateContextAware = Router_androidKt.immediateContextAware(context);
                return immediateContextAware;
            }
        };
        this_$iv.addContextProvider(Reflection.typeOf(ContextAware.class), provider$iv2);
        return this_$iv.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context defaultRouter$lambda$0(Context $context) {
        return $context;
    }

    public static final ContextAware immediateContextAware(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ContextAware() { // from class: kntr.common.router.Router_androidKt$immediateContextAware$1
            public void addOnContextAvailableListener(OnContextAvailableListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                listener.onContextAvailable(context);
            }

            public Context peekAvailableContext() {
                return context;
            }

            public void removeOnContextAvailableListener(OnContextAvailableListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
            }
        };
    }
}