package kntr.common.legacy.router;

import android.app.Application;
import androidx.activity.contextaware.ContextAware;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.Response;
import kntr.common.router.GlobalInterceptor;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: legacyRouter.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/common/legacy/router/AndroidLegacyRouterModule;", "", "<init>", "()V", "provide", "Lkntr/base/router/Interceptor;", CommonProjectType.APP, "Landroid/app/Application;", "legacy-router_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module
public final class AndroidLegacyRouterModule {
    public static final AndroidLegacyRouterModule INSTANCE = new AndroidLegacyRouterModule();

    private AndroidLegacyRouterModule() {
    }

    @Provides
    @GlobalInterceptor
    @IntoSet
    public final Interceptor provide(final Application app) {
        Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
        return new Interceptor() { // from class: kntr.common.legacy.router.AndroidLegacyRouterModule$provide$1
            @Override // kntr.base.router.Interceptor
            public Response intercept(Interceptor.Chain chain) {
                Application context;
                Intrinsics.checkNotNullParameter(chain, "chain");
                Response downstream = Interceptor.Chain.CC.proceed$default(chain, null, null, 3, null);
                if (chain.getUri().isOpaque()) {
                    return downstream;
                }
                if ((downstream instanceof Response.NotIntercepted) && !LegacyRouterKt.tripping(chain.getUri())) {
                    RouteRequest legacyRequest = new RouteRequest.Builder(LegacyRouterKt.markTripping(chain.getUri()).toString()).build();
                    Object contextUnsafe = chain.contextUnsafe(Reflection.typeOf(ContextAware.class));
                    ContextAware contextAware = contextUnsafe instanceof ContextAware ? contextUnsafe : null;
                    if (contextAware == null || (context = contextAware.peekAvailableContext()) == null) {
                        context = app;
                    }
                    RouteResponse legacyResponse = BLRouter.routeTo(legacyRequest, context);
                    if (legacyResponse.getCode() == RouteResponse.Code.OK) {
                        return Response.Done.INSTANCE;
                    }
                }
                return downstream;
            }
        };
    }
}