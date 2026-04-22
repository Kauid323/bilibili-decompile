package kntr.app.digital.preview.wallpaper;

import com.bilibili.lib.foundation.FoundationAlias;
import dagger.hilt.EntryPoints;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: WallpaperSetting.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"setWallpaper", "Lkntr/app/digital/preview/wallpaper/SetWallpaper;", "getSetWallpaper", "()Lkntr/app/digital/preview/wallpaper/SetWallpaper;", "hasWallpaperDialog", RoomRecommendViewModel.EMPTY_CURSOR, "getHasWallpaperDialog", "()Z", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WallpaperSetting_androidKt {
    private static final SetWallpaper setWallpaper = ((SetWallpaperEntryPoint) EntryPoints.get(FoundationAlias.getFapp(), SetWallpaperEntryPoint.class)).getWallpaperSetting();
    private static final boolean hasWallpaperDialog = true;

    public static final SetWallpaper getSetWallpaper() {
        return setWallpaper;
    }

    public static final boolean getHasWallpaperDialog() {
        return hasWallpaperDialog;
    }
}