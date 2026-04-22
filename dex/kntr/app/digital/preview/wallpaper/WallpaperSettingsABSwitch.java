package kntr.app.digital.preview.wallpaper;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;

/* compiled from: WallpaperSettingsABSwitch.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperSettingsABSwitch;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "wallpaperEnabledSwitch", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WallpaperSettingsABSwitch {
    public static final int $stable = 0;
    public static final WallpaperSettingsABSwitch INSTANCE = new WallpaperSettingsABSwitch();

    private WallpaperSettingsABSwitch() {
    }

    public final boolean wallpaperEnabledSwitch() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "ff_digital_usage_wallpaper", false, 2, (Object) null);
    }
}