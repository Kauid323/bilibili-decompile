package tv.danmaku.bili.utils.storage.fetcher;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import androidx.core.os.EnvironmentCompat;
import java.io.File;
import java.lang.reflect.Method;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class StoragePathFetcherImpl {
    private static final StoragePathFetcher IMPL = new KitkatFetcher();

    public static String getPrimaryPath(Context context) {
        String path = IMPL.getPrimaryPath(context);
        return assureValidPath(context, path);
    }

    public static String getSecondaryPath(Context context) {
        String path = IMPL.getSecondaryPath(context);
        return assureValidPath(context, path);
    }

    private static String assureValidPath(Context context, String path) {
        String state = getStorageState(context, path);
        if (state.equals("mounted")) {
            return path;
        }
        return null;
    }

    public static String getStorageState(Context context, String path) {
        if (path == null) {
            return IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
        }
        File file = new File(path);
        String status = EnvironmentCompat.getStorageState(file);
        BLog.i("StoragePathFetcherImpl", "getStorageState > " + status);
        StorageManager sManager = (StorageManager) context.getSystemService("storage");
        try {
            Method getState = StorageManager.class.getDeclaredMethod("getVolumeState", String.class);
            return (String) getState.invoke(sManager, path);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (Environment.getExternalStorageDirectory().getCanonicalPath().startsWith(path)) {
                    return Environment.getExternalStorageState();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (!file.canRead()) {
                    return "unmounted";
                }
                if (file.canWrite()) {
                    return "mounted";
                }
                return "mounted_ro";
            } catch (IllegalStateException e3) {
                return "unmounted";
            }
        }
    }
}