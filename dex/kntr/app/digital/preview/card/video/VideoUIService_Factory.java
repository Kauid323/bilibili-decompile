package kntr.app.digital.preview.card.video;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoUIService_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/video/VideoUIService;", "videoPlayServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "routerProvider", "Lkntr/base/router/Router;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoUIService_Factory implements Factory<VideoUIService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<Router> routerProvider;
    private final Provider<DigitalVideoPlayService> videoPlayServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public VideoUIService_Factory(Provider<DigitalVideoPlayService> provider, Provider<DigitalCardStateService> provider2, Provider<Router> provider3) {
        Intrinsics.checkNotNullParameter(provider, "videoPlayServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "routerProvider");
        this.videoPlayServiceProvider = provider;
        this.cardStateServiceProvider = provider2;
        this.routerProvider = provider3;
    }

    public VideoUIService get() {
        Companion companion = Companion;
        DigitalVideoPlayService digitalVideoPlayService = this.videoPlayServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalVideoPlayService, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        return companion.newInstance(digitalVideoPlayService, digitalCardStateService, router);
    }

    /* compiled from: VideoUIService_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/video/VideoUIService_Factory;", "videoPlayServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "routerProvider", "Lkntr/base/router/Router;", "newInstance", "Lkntr/app/digital/preview/card/video/VideoUIService;", "videoPlayService", "cardStateService", "router", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VideoUIService_Factory create(Provider<DigitalVideoPlayService> provider, Provider<DigitalCardStateService> provider2, Provider<Router> provider3) {
            Intrinsics.checkNotNullParameter(provider, "videoPlayServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "routerProvider");
            return new VideoUIService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final VideoUIService newInstance(DigitalVideoPlayService videoPlayService, DigitalCardStateService cardStateService, Router router) {
            Intrinsics.checkNotNullParameter(videoPlayService, "videoPlayService");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(router, "router");
            return new VideoUIService(videoPlayService, cardStateService, router);
        }
    }

    @JvmStatic
    public static final VideoUIService_Factory create(Provider<DigitalVideoPlayService> provider, Provider<DigitalCardStateService> provider2, Provider<Router> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final VideoUIService newInstance(DigitalVideoPlayService videoPlayService, DigitalCardStateService cardStateService, Router router) {
        return Companion.newInstance(videoPlayService, cardStateService, router);
    }
}