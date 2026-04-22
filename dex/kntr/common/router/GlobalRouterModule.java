package kntr.common.router;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.Multibinds;
import java.util.Set;
import javax.inject.Singleton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalRouter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0013\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/common/router/GlobalRouterModule;", "", "bindGlobalInterceptor", "", "Lkntr/base/router/Interceptor;", "Lkotlin/jvm/JvmSuppressWildcards;", "Companion", "router_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public interface GlobalRouterModule {
    public static final Companion Companion = Companion.$$INSTANCE;

    @GlobalInterceptor
    @Multibinds
    Set<Interceptor> bindGlobalInterceptor();

    /* compiled from: GlobalRouter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0013\b\u0001\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/common/router/GlobalRouterModule$Companion;", "", "<init>", "()V", "provideGlobalRouter", "Lkntr/base/router/Router;", "globalInterceptors", "", "Lkntr/base/router/Interceptor;", "Lkotlin/jvm/JvmSuppressWildcards;", "router_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Provides
        @Singleton
        @GlobalRouterQualifier
        public final Router provideGlobalRouter(@GlobalInterceptor Set<Interceptor> set) {
            Intrinsics.checkNotNullParameter(set, "globalInterceptors");
            Router.Builder builder = new Router.Builder();
            Set<Interceptor> $this$forEach$iv = set;
            for (Object element$iv : $this$forEach$iv) {
                Interceptor it = (Interceptor) element$iv;
                builder = builder.addInterceptor(it);
            }
            return builder.build();
        }
    }
}