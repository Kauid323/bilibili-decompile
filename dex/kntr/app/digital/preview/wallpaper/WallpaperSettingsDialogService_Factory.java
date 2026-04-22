package kntr.app.digital.preview.wallpaper;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.DialogService;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WallpaperSettingsDialogService_Factory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012BS\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", "komponentScopeProvider", "Ljavax/inject/Provider;", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "reportServiceProvider", "Lkntr/app/digital/preview/report/ReportService;", "setHomeWallpaperProvider", "Lkntr/app/digital/preview/wallpaper/SetHomeWallpaper;", "setLockscreenWallpaperProvider", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WallpaperSettingsDialogService_Factory implements Factory<WallpaperSettingsDialogService> {
    private final Provider<DialogService> dialogServiceProvider;
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    private final Provider<ReportService> reportServiceProvider;
    private final Provider<SetHomeWallpaper> setHomeWallpaperProvider;
    private final Provider<SetLockscreenWallpaper> setLockscreenWallpaperProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public WallpaperSettingsDialogService_Factory(Provider<KomponentScope<Unit>> provider, Provider<ReportService> provider2, Provider<SetHomeWallpaper> provider3, Provider<SetLockscreenWallpaper> provider4, Provider<DialogService> provider5) {
        Intrinsics.checkNotNullParameter(provider, "komponentScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "reportServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "setHomeWallpaperProvider");
        Intrinsics.checkNotNullParameter(provider4, "setLockscreenWallpaperProvider");
        Intrinsics.checkNotNullParameter(provider5, "dialogServiceProvider");
        this.komponentScopeProvider = provider;
        this.reportServiceProvider = provider2;
        this.setHomeWallpaperProvider = provider3;
        this.setLockscreenWallpaperProvider = provider4;
        this.dialogServiceProvider = provider5;
    }

    public WallpaperSettingsDialogService get() {
        Companion companion = Companion;
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        ReportService reportService = this.reportServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(reportService, "get(...)");
        SetHomeWallpaper setHomeWallpaper = this.setHomeWallpaperProvider.get();
        Intrinsics.checkNotNullExpressionValue(setHomeWallpaper, "get(...)");
        SetLockscreenWallpaper setLockscreenWallpaper = this.setLockscreenWallpaperProvider.get();
        Intrinsics.checkNotNullExpressionValue(setLockscreenWallpaper, "get(...)");
        DialogService dialogService = this.dialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(dialogService, "get(...)");
        return companion.newInstance(komponentScope, reportService, setHomeWallpaper, setLockscreenWallpaper, dialogService);
    }

    /* compiled from: WallpaperSettingsDialogService_Factory.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0007J6\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0011H\u0007¨\u0006\u0019"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService_Factory;", "komponentScopeProvider", "Ljavax/inject/Provider;", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "reportServiceProvider", "Lkntr/app/digital/preview/report/ReportService;", "setHomeWallpaperProvider", "Lkntr/app/digital/preview/wallpaper/SetHomeWallpaper;", "setLockscreenWallpaperProvider", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "newInstance", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", "komponentScope", "reportService", "setHomeWallpaper", "setLockscreenWallpaper", "dialogService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WallpaperSettingsDialogService_Factory create(Provider<KomponentScope<Unit>> provider, Provider<ReportService> provider2, Provider<SetHomeWallpaper> provider3, Provider<SetLockscreenWallpaper> provider4, Provider<DialogService> provider5) {
            Intrinsics.checkNotNullParameter(provider, "komponentScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "reportServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "setHomeWallpaperProvider");
            Intrinsics.checkNotNullParameter(provider4, "setLockscreenWallpaperProvider");
            Intrinsics.checkNotNullParameter(provider5, "dialogServiceProvider");
            return new WallpaperSettingsDialogService_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final WallpaperSettingsDialogService newInstance(KomponentScope<? super Unit> komponentScope, ReportService reportService, SetHomeWallpaper setHomeWallpaper, SetLockscreenWallpaper setLockscreenWallpaper, DialogService dialogService) {
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            Intrinsics.checkNotNullParameter(reportService, "reportService");
            Intrinsics.checkNotNullParameter(setHomeWallpaper, "setHomeWallpaper");
            Intrinsics.checkNotNullParameter(setLockscreenWallpaper, "setLockscreenWallpaper");
            Intrinsics.checkNotNullParameter(dialogService, "dialogService");
            return new WallpaperSettingsDialogService(komponentScope, reportService, setHomeWallpaper, setLockscreenWallpaper, dialogService);
        }
    }

    @JvmStatic
    public static final WallpaperSettingsDialogService_Factory create(Provider<KomponentScope<Unit>> provider, Provider<ReportService> provider2, Provider<SetHomeWallpaper> provider3, Provider<SetLockscreenWallpaper> provider4, Provider<DialogService> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final WallpaperSettingsDialogService newInstance(KomponentScope<? super Unit> komponentScope, ReportService reportService, SetHomeWallpaper setHomeWallpaper, SetLockscreenWallpaper setLockscreenWallpaper, DialogService dialogService) {
        return Companion.newInstance(komponentScope, reportService, setHomeWallpaper, setLockscreenWallpaper, dialogService);
    }
}