package tv.danmaku.bili.utils.storage.fetcher;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import tv.danmaku.android.log.BLog;

class LegacyFetcher implements StoragePathFetcher {
    public static final String TAG = "LegacyFetcher";

    @Override // tv.danmaku.bili.utils.storage.fetcher.StoragePathFetcher
    public String getPrimaryPath(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @Override // tv.danmaku.bili.utils.storage.fetcher.StoragePathFetcher
    public String getSecondaryPath(Context context) {
        StorageManager manager;
        Object[] volumes;
        String primaryPath;
        try {
            manager = (StorageManager) context.getSystemService("storage");
            Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
            method.setAccessible(true);
            volumes = (Object[]) method.invoke(manager, new Object[0]);
            primaryPath = getPrimaryPath(context);
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
        }
        if (volumes != null && volumes.length != 0) {
            Class volumeClz = Class.forName("android.os.storage.StorageVolume");
            Method getPath = volumeClz.getMethod("getPath", new Class[0]);
            for (Object volume : volumes) {
                String candidate = (String) getPath.invoke(volume, new Object[0]);
                if (!TextUtils.isEmpty(candidate) && !TextUtils.isEmpty(primaryPath) && !candidate.startsWith(primaryPath) && isMounted(manager, candidate)) {
                    return candidate;
                }
            }
            return null;
        }
        return null;
    }

    private boolean isMounted(StorageManager manager, String mountPoint) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = StorageManager.class.getMethod("getVolumeState", String.class);
        String state = (String) method.invoke(manager, mountPoint);
        return !TextUtils.isEmpty(state) && state.equals("mounted");
    }
}