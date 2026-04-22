package kntr.app.digital.backpack.navigation;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.dismiss.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationBarService_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/digital/backpack/navigation/NavigationBarService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/navigation/NavigationBarService;", "navigationModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/navigation/NavigationModel;", "dismissRequestProvider", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarService_Factory implements Factory<NavigationBarService> {
    private final Provider<DismissRequest> dismissRequestProvider;
    private final Provider<NavigationModel> navigationModelProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public NavigationBarService_Factory(Provider<NavigationModel> provider, Provider<DismissRequest> provider2) {
        Intrinsics.checkNotNullParameter(provider, "navigationModelProvider");
        Intrinsics.checkNotNullParameter(provider2, "dismissRequestProvider");
        this.navigationModelProvider = provider;
        this.dismissRequestProvider = provider2;
    }

    public NavigationBarService get() {
        Companion companion = Companion;
        NavigationModel navigationModel = this.navigationModelProvider.get();
        Intrinsics.checkNotNullExpressionValue(navigationModel, "get(...)");
        DismissRequest dismissRequest = this.dismissRequestProvider.get();
        Intrinsics.checkNotNullExpressionValue(dismissRequest, "get(...)");
        return companion.newInstance(navigationModel, dismissRequest);
    }

    /* compiled from: NavigationBarService_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/digital/backpack/navigation/NavigationBarService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/navigation/NavigationBarService_Factory;", "navigationModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/navigation/NavigationModel;", "dismissRequestProvider", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "newInstance", "Lkntr/app/digital/backpack/navigation/NavigationBarService;", "navigationModel", "dismissRequest", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NavigationBarService_Factory create(Provider<NavigationModel> provider, Provider<DismissRequest> provider2) {
            Intrinsics.checkNotNullParameter(provider, "navigationModelProvider");
            Intrinsics.checkNotNullParameter(provider2, "dismissRequestProvider");
            return new NavigationBarService_Factory(provider, provider2);
        }

        @JvmStatic
        public final NavigationBarService newInstance(NavigationModel navigationModel, DismissRequest dismissRequest) {
            Intrinsics.checkNotNullParameter(navigationModel, "navigationModel");
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            return new NavigationBarService(navigationModel, dismissRequest);
        }
    }

    @JvmStatic
    public static final NavigationBarService_Factory create(Provider<NavigationModel> provider, Provider<DismissRequest> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final NavigationBarService newInstance(NavigationModel navigationModel, DismissRequest dismissRequest) {
        return Companion.newInstance(navigationModel, dismissRequest);
    }
}