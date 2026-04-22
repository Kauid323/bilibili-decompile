package kntr.app.digital.preview.wallpaper;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SetLockscreenWallpaper_Factory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", "toasterProvider", "Ljavax/inject/Provider;", "Lkntr/common/trio/toast/Toaster;", "dismissRequestProvider", "Lkntr/app/digital/preview/closing/DismissRequest;", "wallpaperDownloadingDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperDownloadingDialogService;", "wallpaperUnavailableDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperUnavailableDialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetLockscreenWallpaper_Factory implements Factory<SetLockscreenWallpaper> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DismissRequest> dismissRequestProvider;
    private final Provider<Toaster> toasterProvider;
    private final Provider<WallpaperDownloadingDialogService> wallpaperDownloadingDialogServiceProvider;
    private final Provider<WallpaperUnavailableDialogService> wallpaperUnavailableDialogServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SetLockscreenWallpaper_Factory(Provider<Toaster> provider, Provider<DismissRequest> provider2, Provider<WallpaperDownloadingDialogService> provider3, Provider<WallpaperUnavailableDialogService> provider4, Provider<CoroutineScope> provider5) {
        Intrinsics.checkNotNullParameter(provider, "toasterProvider");
        Intrinsics.checkNotNullParameter(provider2, "dismissRequestProvider");
        Intrinsics.checkNotNullParameter(provider3, "wallpaperDownloadingDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "wallpaperUnavailableDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "coroutineScopeProvider");
        this.toasterProvider = provider;
        this.dismissRequestProvider = provider2;
        this.wallpaperDownloadingDialogServiceProvider = provider3;
        this.wallpaperUnavailableDialogServiceProvider = provider4;
        this.coroutineScopeProvider = provider5;
    }

    public SetLockscreenWallpaper get() {
        Companion companion = Companion;
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        DismissRequest dismissRequest = this.dismissRequestProvider.get();
        Intrinsics.checkNotNullExpressionValue(dismissRequest, "get(...)");
        WallpaperDownloadingDialogService wallpaperDownloadingDialogService = this.wallpaperDownloadingDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(wallpaperDownloadingDialogService, "get(...)");
        WallpaperUnavailableDialogService wallpaperUnavailableDialogService = this.wallpaperUnavailableDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(wallpaperUnavailableDialogService, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        return companion.newInstance(toaster, dismissRequest, wallpaperDownloadingDialogService, wallpaperUnavailableDialogService, coroutineScope);
    }

    /* compiled from: SetLockscreenWallpaper_Factory.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper_Factory;", "toasterProvider", "Ljavax/inject/Provider;", "Lkntr/common/trio/toast/Toaster;", "dismissRequestProvider", "Lkntr/app/digital/preview/closing/DismissRequest;", "wallpaperDownloadingDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperDownloadingDialogService;", "wallpaperUnavailableDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperUnavailableDialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "newInstance", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", "toaster", "dismissRequest", "wallpaperDownloadingDialogService", "wallpaperUnavailableDialogService", "coroutineScope", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SetLockscreenWallpaper_Factory create(Provider<Toaster> provider, Provider<DismissRequest> provider2, Provider<WallpaperDownloadingDialogService> provider3, Provider<WallpaperUnavailableDialogService> provider4, Provider<CoroutineScope> provider5) {
            Intrinsics.checkNotNullParameter(provider, "toasterProvider");
            Intrinsics.checkNotNullParameter(provider2, "dismissRequestProvider");
            Intrinsics.checkNotNullParameter(provider3, "wallpaperDownloadingDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "wallpaperUnavailableDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "coroutineScopeProvider");
            return new SetLockscreenWallpaper_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final SetLockscreenWallpaper newInstance(Toaster toaster, DismissRequest dismissRequest, WallpaperDownloadingDialogService wallpaperDownloadingDialogService, WallpaperUnavailableDialogService wallpaperUnavailableDialogService, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            Intrinsics.checkNotNullParameter(wallpaperDownloadingDialogService, "wallpaperDownloadingDialogService");
            Intrinsics.checkNotNullParameter(wallpaperUnavailableDialogService, "wallpaperUnavailableDialogService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            return new SetLockscreenWallpaper(toaster, dismissRequest, wallpaperDownloadingDialogService, wallpaperUnavailableDialogService, coroutineScope);
        }
    }

    @JvmStatic
    public static final SetLockscreenWallpaper_Factory create(Provider<Toaster> provider, Provider<DismissRequest> provider2, Provider<WallpaperDownloadingDialogService> provider3, Provider<WallpaperUnavailableDialogService> provider4, Provider<CoroutineScope> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final SetLockscreenWallpaper newInstance(Toaster toaster, DismissRequest dismissRequest, WallpaperDownloadingDialogService wallpaperDownloadingDialogService, WallpaperUnavailableDialogService wallpaperUnavailableDialogService, CoroutineScope coroutineScope) {
        return Companion.newInstance(toaster, dismissRequest, wallpaperDownloadingDialogService, wallpaperUnavailableDialogService, coroutineScope);
    }
}