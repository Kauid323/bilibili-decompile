package kntr.app.digital.preview.aggregate;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.digital.preview.RouterParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterParamsBackedModule_ProvideFromParamsFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule_ProvideFromParamsFactory;", "Ldagger/internal/Factory;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "routerParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/RouterParams;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RouterParamsBackedModule_ProvideFromParamsFactory implements Factory<Map<String, ? extends String>> {
    private final Provider<RouterParams> routerParamsProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public RouterParamsBackedModule_ProvideFromParamsFactory(Provider<RouterParams> provider) {
        Intrinsics.checkNotNullParameter(provider, "routerParamsProvider");
        this.routerParamsProvider = provider;
    }

    public Map<String, String> get() {
        Companion companion = Companion;
        RouterParams routerParams = this.routerParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(routerParams, "get(...)");
        return companion.provideFromParams(routerParams);
    }

    /* compiled from: RouterParamsBackedModule_ProvideFromParamsFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule_ProvideFromParamsFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule_ProvideFromParamsFactory;", "routerParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/RouterParams;", "provideFromParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "routerParams", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RouterParamsBackedModule_ProvideFromParamsFactory create(Provider<RouterParams> provider) {
            Intrinsics.checkNotNullParameter(provider, "routerParamsProvider");
            return new RouterParamsBackedModule_ProvideFromParamsFactory(provider);
        }

        @JvmStatic
        public final Map<String, String> provideFromParams(RouterParams routerParams) {
            Intrinsics.checkNotNullParameter(routerParams, "routerParams");
            return RouterParamsBackedModule.INSTANCE.provideFromParams(routerParams);
        }
    }

    @JvmStatic
    public static final RouterParamsBackedModule_ProvideFromParamsFactory create(Provider<RouterParams> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final Map<String, String> provideFromParams(RouterParams routerParams) {
        return Companion.provideFromParams(routerParams);
    }
}