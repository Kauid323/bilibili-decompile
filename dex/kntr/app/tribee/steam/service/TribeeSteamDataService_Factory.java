package kntr.app.tribee.steam.service;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.qrcode.QrCodeProvider;
import kntr.common.screenshot.ScreenshotProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamDataService_Factory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010BQ\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/steam/service/TribeeSteamDataService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/steam/service/TribeeSteamDataService;", "hostIdProvider", "Ljavax/inject/Provider;", "", "selectedGameIdProvider", "", "signatureProvider", "qrCodeProvider", "Lkntr/common/paragraph/qrcode/QrCodeProvider;", "screenshotProvider", "Lkntr/common/screenshot/ScreenshotProvider;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamDataService_Factory implements Factory<TribeeSteamDataService> {
    private final Provider<Long> hostIdProvider;
    private final Provider<QrCodeProvider> qrCodeProvider;
    private final Provider<ScreenshotProvider> screenshotProvider;
    private final Provider<String> selectedGameIdProvider;
    private final Provider<String> signatureProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeSteamDataService_Factory(Provider<Long> provider, Provider<String> provider2, Provider<String> provider3, Provider<QrCodeProvider> provider4, Provider<ScreenshotProvider> provider5) {
        Intrinsics.checkNotNullParameter(provider, "hostIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "selectedGameIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "signatureProvider");
        Intrinsics.checkNotNullParameter(provider4, "qrCodeProvider");
        Intrinsics.checkNotNullParameter(provider5, "screenshotProvider");
        this.hostIdProvider = provider;
        this.selectedGameIdProvider = provider2;
        this.signatureProvider = provider3;
        this.qrCodeProvider = provider4;
        this.screenshotProvider = provider5;
    }

    public TribeeSteamDataService get() {
        Companion companion = Companion;
        Object obj = this.hostIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        long longValue = ((Number) obj).longValue();
        String str = (String) this.selectedGameIdProvider.get();
        String str2 = (String) this.signatureProvider.get();
        Object obj2 = this.qrCodeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        QrCodeProvider qrCodeProvider = (QrCodeProvider) obj2;
        Object obj3 = this.screenshotProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance(longValue, str, str2, qrCodeProvider, (ScreenshotProvider) obj3);
    }

    /* compiled from: TribeeSteamDataService_Factory.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0007J4\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/steam/service/TribeeSteamDataService_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/steam/service/TribeeSteamDataService_Factory;", "hostIdProvider", "Ljavax/inject/Provider;", "", "selectedGameIdProvider", "", "signatureProvider", "qrCodeProvider", "Lkntr/common/paragraph/qrcode/QrCodeProvider;", "screenshotProvider", "Lkntr/common/screenshot/ScreenshotProvider;", "newInstance", "Lkntr/app/tribee/steam/service/TribeeSteamDataService;", "hostId", "selectedGameId", "signature", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeSteamDataService_Factory create(Provider<Long> provider, Provider<String> provider2, Provider<String> provider3, Provider<QrCodeProvider> provider4, Provider<ScreenshotProvider> provider5) {
            Intrinsics.checkNotNullParameter(provider, "hostIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "selectedGameIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "signatureProvider");
            Intrinsics.checkNotNullParameter(provider4, "qrCodeProvider");
            Intrinsics.checkNotNullParameter(provider5, "screenshotProvider");
            return new TribeeSteamDataService_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final TribeeSteamDataService newInstance(long hostId, String selectedGameId, String signature, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider) {
            Intrinsics.checkNotNullParameter(qrCodeProvider, "qrCodeProvider");
            Intrinsics.checkNotNullParameter(screenshotProvider, "screenshotProvider");
            return new TribeeSteamDataService(hostId, selectedGameId, signature, qrCodeProvider, screenshotProvider);
        }
    }

    @JvmStatic
    public static final TribeeSteamDataService_Factory create(Provider<Long> provider, Provider<String> provider2, Provider<String> provider3, Provider<QrCodeProvider> provider4, Provider<ScreenshotProvider> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final TribeeSteamDataService newInstance(long hostId, String selectedGameId, String signature, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider) {
        return Companion.newInstance(hostId, selectedGameId, signature, qrCodeProvider, screenshotProvider);
    }
}