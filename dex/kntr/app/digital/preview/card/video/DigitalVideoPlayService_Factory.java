package kntr.app.digital.preview.card.video;

import androidx.lifecycle.Lifecycle;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DigitalVideoPlayService_Factory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/card/video/DigitalVideoPlayService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "lifecycleProvider", "Ljavax/inject/Provider;", "Landroidx/lifecycle/Lifecycle;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "downloadCaptionsProvider", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "volumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalVideoPlayService_Factory implements Factory<DigitalVideoPlayService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DownloadCaptions> downloadCaptionsProvider;
    private final Provider<Lifecycle> lifecycleProvider;
    private final Provider<DigitalVideoCardVolumeService> volumeServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalVideoPlayService_Factory(Provider<Lifecycle> provider, Provider<CoroutineScope> provider2, Provider<DigitalCardStateService> provider3, Provider<DownloadCaptions> provider4, Provider<DigitalVideoCardVolumeService> provider5) {
        Intrinsics.checkNotNullParameter(provider, "lifecycleProvider");
        Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "downloadCaptionsProvider");
        Intrinsics.checkNotNullParameter(provider5, "volumeServiceProvider");
        this.lifecycleProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.cardStateServiceProvider = provider3;
        this.downloadCaptionsProvider = provider4;
        this.volumeServiceProvider = provider5;
    }

    public DigitalVideoPlayService get() {
        Companion companion = Companion;
        Lifecycle lifecycle = this.lifecycleProvider.get();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        DownloadCaptions downloadCaptions = this.downloadCaptionsProvider.get();
        Intrinsics.checkNotNullExpressionValue(downloadCaptions, "get(...)");
        DigitalVideoCardVolumeService digitalVideoCardVolumeService = this.volumeServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalVideoCardVolumeService, "get(...)");
        return companion.newInstance(lifecycle, coroutineScope, digitalCardStateService, downloadCaptions, digitalVideoCardVolumeService);
    }

    /* compiled from: DigitalVideoPlayService_Factory.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/card/video/DigitalVideoPlayService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService_Factory;", "lifecycleProvider", "Ljavax/inject/Provider;", "Landroidx/lifecycle/Lifecycle;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "downloadCaptionsProvider", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "volumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "newInstance", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "lifecycle", "coroutineScope", "cardStateService", "downloadCaptions", "volumeService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalVideoPlayService_Factory create(Provider<Lifecycle> provider, Provider<CoroutineScope> provider2, Provider<DigitalCardStateService> provider3, Provider<DownloadCaptions> provider4, Provider<DigitalVideoCardVolumeService> provider5) {
            Intrinsics.checkNotNullParameter(provider, "lifecycleProvider");
            Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "downloadCaptionsProvider");
            Intrinsics.checkNotNullParameter(provider5, "volumeServiceProvider");
            return new DigitalVideoPlayService_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final DigitalVideoPlayService newInstance(Lifecycle lifecycle, CoroutineScope coroutineScope, DigitalCardStateService cardStateService, DownloadCaptions downloadCaptions, DigitalVideoCardVolumeService volumeService) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(downloadCaptions, "downloadCaptions");
            Intrinsics.checkNotNullParameter(volumeService, "volumeService");
            return new DigitalVideoPlayService(lifecycle, coroutineScope, cardStateService, downloadCaptions, volumeService);
        }
    }

    @JvmStatic
    public static final DigitalVideoPlayService_Factory create(Provider<Lifecycle> provider, Provider<CoroutineScope> provider2, Provider<DigitalCardStateService> provider3, Provider<DownloadCaptions> provider4, Provider<DigitalVideoCardVolumeService> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final DigitalVideoPlayService newInstance(Lifecycle lifecycle, CoroutineScope coroutineScope, DigitalCardStateService cardStateService, DownloadCaptions downloadCaptions, DigitalVideoCardVolumeService volumeService) {
        return Companion.newInstance(lifecycle, coroutineScope, cardStateService, downloadCaptions, volumeService);
    }
}