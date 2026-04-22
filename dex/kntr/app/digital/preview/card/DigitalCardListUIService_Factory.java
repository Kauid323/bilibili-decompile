package kntr.app.digital.preview.card;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.video.VideoUIService;
import kntr.app.digital.preview.card.web.WebCardUIService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalCardListUIService_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardListUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/DigitalCardListUIService;", "cardStateServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "videoPlayServiceProvider", "Lkntr/app/digital/preview/card/video/VideoUIService;", "webCardUIServiceProvider", "Lkntr/app/digital/preview/card/web/WebCardUIService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalCardListUIService_Factory implements Factory<DigitalCardListUIService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<VideoUIService> videoPlayServiceProvider;
    private final Provider<WebCardUIService> webCardUIServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalCardListUIService_Factory(Provider<DigitalCardStateService> provider, Provider<VideoUIService> provider2, Provider<WebCardUIService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "videoPlayServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "webCardUIServiceProvider");
        this.cardStateServiceProvider = provider;
        this.videoPlayServiceProvider = provider2;
        this.webCardUIServiceProvider = provider3;
    }

    public DigitalCardListUIService get() {
        Companion companion = Companion;
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        VideoUIService videoUIService = this.videoPlayServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(videoUIService, "get(...)");
        WebCardUIService webCardUIService = this.webCardUIServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(webCardUIService, "get(...)");
        return companion.newInstance(digitalCardStateService, videoUIService, webCardUIService);
    }

    /* compiled from: DigitalCardListUIService_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardListUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/DigitalCardListUIService_Factory;", "cardStateServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "videoPlayServiceProvider", "Lkntr/app/digital/preview/card/video/VideoUIService;", "webCardUIServiceProvider", "Lkntr/app/digital/preview/card/web/WebCardUIService;", "newInstance", "Lkntr/app/digital/preview/card/DigitalCardListUIService;", "cardStateService", "videoPlayService", "webCardUIService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalCardListUIService_Factory create(Provider<DigitalCardStateService> provider, Provider<VideoUIService> provider2, Provider<WebCardUIService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "videoPlayServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "webCardUIServiceProvider");
            return new DigitalCardListUIService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final DigitalCardListUIService newInstance(DigitalCardStateService cardStateService, VideoUIService videoPlayService, WebCardUIService webCardUIService) {
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(videoPlayService, "videoPlayService");
            Intrinsics.checkNotNullParameter(webCardUIService, "webCardUIService");
            return new DigitalCardListUIService(cardStateService, videoPlayService, webCardUIService);
        }
    }

    @JvmStatic
    public static final DigitalCardListUIService_Factory create(Provider<DigitalCardStateService> provider, Provider<VideoUIService> provider2, Provider<WebCardUIService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final DigitalCardListUIService newInstance(DigitalCardStateService cardStateService, VideoUIService videoPlayService, WebCardUIService webCardUIService) {
        return Companion.newInstance(cardStateService, videoPlayService, webCardUIService);
    }
}