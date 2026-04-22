package kntr.app.digital.preview.wallpaper;

import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: SetLockscreenWallpaper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", RoomRecommendViewModel.EMPTY_CURSOR, "toaster", "Lkntr/common/trio/toast/Toaster;", "dismissRequest", "Lkntr/app/digital/preview/closing/DismissRequest;", "wallpaperDownloadingDialogService", "Lkntr/app/digital/preview/wallpaper/WallpaperDownloadingDialogService;", "wallpaperUnavailableDialogService", "Lkntr/app/digital/preview/wallpaper/WallpaperUnavailableDialogService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/common/trio/toast/Toaster;Lkntr/app/digital/preview/closing/DismissRequest;Lkntr/app/digital/preview/wallpaper/WallpaperDownloadingDialogService;Lkntr/app/digital/preview/wallpaper/WallpaperUnavailableDialogService;Lkotlinx/coroutines/CoroutineScope;)V", "invoke", RoomRecommendViewModel.EMPTY_CURSOR, "wallpaperUrl", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetLockscreenWallpaper {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final DismissRequest dismissRequest;
    private final Toaster toaster;
    private final WallpaperDownloadingDialogService wallpaperDownloadingDialogService;
    private final WallpaperUnavailableDialogService wallpaperUnavailableDialogService;

    @Inject
    public SetLockscreenWallpaper(Toaster toaster, DismissRequest dismissRequest, WallpaperDownloadingDialogService wallpaperDownloadingDialogService, WallpaperUnavailableDialogService wallpaperUnavailableDialogService, @BusinessCoroutineScope CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(wallpaperDownloadingDialogService, "wallpaperDownloadingDialogService");
        Intrinsics.checkNotNullParameter(wallpaperUnavailableDialogService, "wallpaperUnavailableDialogService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.toaster = toaster;
        this.dismissRequest = dismissRequest;
        this.wallpaperDownloadingDialogService = wallpaperDownloadingDialogService;
        this.wallpaperUnavailableDialogService = wallpaperUnavailableDialogService;
        this.coroutineScope = coroutineScope;
    }

    public final void invoke(String wallpaperUrl) {
        Intrinsics.checkNotNullParameter(wallpaperUrl, "wallpaperUrl");
        if (!WallpaperSettingsABSwitch.INSTANCE.wallpaperEnabledSwitch()) {
            BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SetLockscreenWallpaper$invoke$1(this, null), 3, (Object) null);
            return;
        }
        Job loadingDialogJob = BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SetLockscreenWallpaper$invoke$loadingDialogJob$1(this, null), 3, (Object) null);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SetLockscreenWallpaper$invoke$2(wallpaperUrl, loadingDialogJob, this, null), 3, (Object) null);
    }
}