package tv.danmaku.bili.ui.favorites.util;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: FavoritesFolderUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\b\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\b\u0010\b\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FAVORITES_FOLDER_SP_FILE_NAME", "", "FAVORITES_FOLDER_COMPACT_KEY", "getLayoutIcon", "", "layoutType", "compactLayoutType", "", "switchLayoutType", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFolderUtilsKt {
    private static final String FAVORITES_FOLDER_COMPACT_KEY = "favorites_folder_compact";
    private static final String FAVORITES_FOLDER_SP_FILE_NAME = "favorites_folder_sp_file";

    public static final int getLayoutIcon() {
        if (compactLayoutType()) {
            return R.drawable.bili_app_list_row_layout_line;
        }
        return R.drawable.bili_app_list_gallery_view_line;
    }

    public static final int layoutType() {
        return compactLayoutType() ? 1 : 2;
    }

    public static final boolean compactLayoutType() {
        RawKV kvs$default;
        Application application = BiliContext.application();
        boolean z = false;
        if (application != null && (kvs$default = BLKV.getKvs$default(application, FAVORITES_FOLDER_SP_FILE_NAME, false, 0, 6, (Object) null)) != null) {
            z = ((Boolean) kvs$default.get(FAVORITES_FOLDER_COMPACT_KEY, false)).booleanValue();
        }
        boolean compact = z;
        return compact;
    }

    public static final boolean switchLayoutType() {
        Application application = BiliContext.application();
        RawKV blkv = application != null ? BLKV.getKvs$default(application, FAVORITES_FOLDER_SP_FILE_NAME, false, 0, 6, (Object) null) : null;
        if (blkv == null) {
            return false;
        }
        boolean compact = ((Boolean) blkv.get(FAVORITES_FOLDER_COMPACT_KEY, false)).booleanValue();
        blkv.putBoolean(FAVORITES_FOLDER_COMPACT_KEY, !compact);
        return true;
    }
}