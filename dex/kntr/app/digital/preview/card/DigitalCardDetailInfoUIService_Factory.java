package kntr.app.digital.preview.card;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService;
import kntr.app.digital.preview.lock.LockUIService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalCardDetailInfoUIService_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", "cardStateServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "volumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "routerProvider", "Lkntr/base/router/Router;", "lockUiServiceProvider", "Lkntr/app/digital/preview/lock/LockUIService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalCardDetailInfoUIService_Factory implements Factory<DigitalCardDetailInfoUIService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<LockUIService> lockUiServiceProvider;
    private final Provider<Router> routerProvider;
    private final Provider<DigitalVideoCardVolumeService> volumeServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalCardDetailInfoUIService_Factory(Provider<DigitalCardStateService> provider, Provider<DigitalVideoCardVolumeService> provider2, Provider<Router> provider3, Provider<LockUIService> provider4) {
        Intrinsics.checkNotNullParameter(provider, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "volumeServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "routerProvider");
        Intrinsics.checkNotNullParameter(provider4, "lockUiServiceProvider");
        this.cardStateServiceProvider = provider;
        this.volumeServiceProvider = provider2;
        this.routerProvider = provider3;
        this.lockUiServiceProvider = provider4;
    }

    public DigitalCardDetailInfoUIService get() {
        Companion companion = Companion;
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        DigitalVideoCardVolumeService digitalVideoCardVolumeService = this.volumeServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalVideoCardVolumeService, "get(...)");
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        LockUIService lockUIService = this.lockUiServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(lockUIService, "get(...)");
        return companion.newInstance(digitalCardStateService, digitalVideoCardVolumeService, router, lockUIService);
    }

    /* compiled from: DigitalCardDetailInfoUIService_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService_Factory;", "cardStateServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "volumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "routerProvider", "Lkntr/base/router/Router;", "lockUiServiceProvider", "Lkntr/app/digital/preview/lock/LockUIService;", "newInstance", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", "cardStateService", "volumeService", "router", "lockUiService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalCardDetailInfoUIService_Factory create(Provider<DigitalCardStateService> provider, Provider<DigitalVideoCardVolumeService> provider2, Provider<Router> provider3, Provider<LockUIService> provider4) {
            Intrinsics.checkNotNullParameter(provider, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "volumeServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "routerProvider");
            Intrinsics.checkNotNullParameter(provider4, "lockUiServiceProvider");
            return new DigitalCardDetailInfoUIService_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final DigitalCardDetailInfoUIService newInstance(DigitalCardStateService cardStateService, DigitalVideoCardVolumeService volumeService, Router router, LockUIService lockUiService) {
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(volumeService, "volumeService");
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(lockUiService, "lockUiService");
            return new DigitalCardDetailInfoUIService(cardStateService, volumeService, router, lockUiService);
        }
    }

    @JvmStatic
    public static final DigitalCardDetailInfoUIService_Factory create(Provider<DigitalCardStateService> provider, Provider<DigitalVideoCardVolumeService> provider2, Provider<Router> provider3, Provider<LockUIService> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final DigitalCardDetailInfoUIService newInstance(DigitalCardStateService cardStateService, DigitalVideoCardVolumeService volumeService, Router router, LockUIService lockUiService) {
        return Companion.newInstance(cardStateService, volumeService, router, lockUiService);
    }
}