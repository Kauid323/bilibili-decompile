package kntr.app.digital.preview.card.web;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DigitalWebCardService_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/preview/card/web/DigitalWebCardService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/web/DigitalWebCardService;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "volumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalWebCardService_Factory implements Factory<DigitalWebCardService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DigitalVideoCardVolumeService> volumeServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalWebCardService_Factory(Provider<CoroutineScope> provider, Provider<DigitalCardStateService> provider2, Provider<DigitalVideoCardVolumeService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "volumeServiceProvider");
        this.coroutineScopeProvider = provider;
        this.cardStateServiceProvider = provider2;
        this.volumeServiceProvider = provider3;
    }

    public DigitalWebCardService get() {
        Companion companion = Companion;
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        DigitalVideoCardVolumeService digitalVideoCardVolumeService = this.volumeServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalVideoCardVolumeService, "get(...)");
        return companion.newInstance(coroutineScope, digitalCardStateService, digitalVideoCardVolumeService);
    }

    /* compiled from: DigitalWebCardService_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/card/web/DigitalWebCardService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/web/DigitalWebCardService_Factory;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "volumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "newInstance", "Lkntr/app/digital/preview/card/web/DigitalWebCardService;", "coroutineScope", "cardStateService", "volumeService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalWebCardService_Factory create(Provider<CoroutineScope> provider, Provider<DigitalCardStateService> provider2, Provider<DigitalVideoCardVolumeService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "volumeServiceProvider");
            return new DigitalWebCardService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final DigitalWebCardService newInstance(CoroutineScope coroutineScope, DigitalCardStateService cardStateService, DigitalVideoCardVolumeService volumeService) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(volumeService, "volumeService");
            return new DigitalWebCardService(coroutineScope, cardStateService, volumeService);
        }
    }

    @JvmStatic
    public static final DigitalWebCardService_Factory create(Provider<CoroutineScope> provider, Provider<DigitalCardStateService> provider2, Provider<DigitalVideoCardVolumeService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final DigitalWebCardService newInstance(CoroutineScope coroutineScope, DigitalCardStateService cardStateService, DigitalVideoCardVolumeService volumeService) {
        return Companion.newInstance(coroutineScope, cardStateService, volumeService);
    }
}