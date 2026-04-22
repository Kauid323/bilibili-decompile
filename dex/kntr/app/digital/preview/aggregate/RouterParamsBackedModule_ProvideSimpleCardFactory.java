package kntr.app.digital.preview.aggregate;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.RouterParams;
import kntr.app.digital.preview.SimpleCard;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterParamsBackedModule_ProvideSimpleCardFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule_ProvideSimpleCardFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/SimpleCard;", "routerParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/RouterParams;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RouterParamsBackedModule_ProvideSimpleCardFactory implements Factory<SimpleCard> {
    private final Provider<RouterParams> routerParamsProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public RouterParamsBackedModule_ProvideSimpleCardFactory(Provider<RouterParams> provider) {
        Intrinsics.checkNotNullParameter(provider, "routerParamsProvider");
        this.routerParamsProvider = provider;
    }

    public SimpleCard get() {
        Companion companion = Companion;
        RouterParams routerParams = this.routerParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(routerParams, "get(...)");
        return companion.provideSimpleCard(routerParams);
    }

    /* compiled from: RouterParamsBackedModule_ProvideSimpleCardFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule_ProvideSimpleCardFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule_ProvideSimpleCardFactory;", "routerParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/RouterParams;", "provideSimpleCard", "Lkntr/app/digital/preview/SimpleCard;", "routerParams", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RouterParamsBackedModule_ProvideSimpleCardFactory create(Provider<RouterParams> provider) {
            Intrinsics.checkNotNullParameter(provider, "routerParamsProvider");
            return new RouterParamsBackedModule_ProvideSimpleCardFactory(provider);
        }

        @JvmStatic
        public final SimpleCard provideSimpleCard(RouterParams routerParams) {
            Intrinsics.checkNotNullParameter(routerParams, "routerParams");
            return RouterParamsBackedModule.INSTANCE.provideSimpleCard(routerParams);
        }
    }

    @JvmStatic
    public static final RouterParamsBackedModule_ProvideSimpleCardFactory create(Provider<RouterParams> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final SimpleCard provideSimpleCard(RouterParams routerParams) {
        return Companion.provideSimpleCard(routerParams);
    }
}