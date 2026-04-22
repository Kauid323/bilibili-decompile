package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import video.biz.offline.base.infra.utils.EntryScannerKt;

public class IjkCacheManager {
    private static final String IJK_CDN_CACHE_DIR = "cdn_cache";
    private static final String IJK_DASH_CACHE_DIR = "dash_cache";
    private static final String IJK_VIDEO_CACHE_DIR = "ijkvideo";
    private static final String TAG = "IjkCacheManager";
    private String mCdnCachePath;
    private String mDashCachePath;
    private String mVideoCachePath;
    private static long sDashCacheDirIndex = 0;
    private static long sVideoCacheDirIndex = 0;
    private static HashMap<String, String> sAllDashCacheDirMap = new HashMap<>();
    private static HashMap<String, String> sAllVideoCacheDirMap = new HashMap<>();
    private static IjkCacheManager sIjkCacheManager = null;
    private final String USED = "1";
    private final String UNUSED = "0";
    private long mCacheSpace = 0;

    private IjkCacheManager(Context context) {
        this.mDashCachePath = null;
        this.mVideoCachePath = null;
        this.mCdnCachePath = null;
        this.mDashCachePath = getCacheDirector(context, IJK_DASH_CACHE_DIR);
        this.mVideoCachePath = getCacheDirector(context, IJK_VIDEO_CACHE_DIR);
        this.mCdnCachePath = getCacheDirector(context, IJK_CDN_CACHE_DIR);
        scanPath(this.mDashCachePath);
        scanPath(this.mVideoCachePath);
    }

    private String getCacheDirector(Context context, String dir) {
        String path = context.getCacheDir().getAbsolutePath() + EntryScannerKt.PATH_SEPARATOR + dir;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        } else if (file.isFile()) {
            file.delete();
            file.mkdir();
        }
        return path;
    }

    private void scanPath(String path) {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                String p = path + EntryScannerKt.PATH_SEPARATOR + children[i];
                File child = new File(p);
                if (child.isDirectory()) {
                    deleteDir(p);
                } else {
                    child.delete();
                }
            }
        }
    }

    public static void deleteDir(String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                String p = path + EntryScannerKt.PATH_SEPARATOR + children[i];
                File child = new File(p);
                if (child.isFile()) {
                    child.delete();
                } else {
                    deleteDir(p);
                }
            }
            dir.delete();
        }
    }

    public static synchronized IjkCacheManager getInstance(Context context) {
        IjkCacheManager ijkCacheManager;
        synchronized (IjkCacheManager.class) {
            if (sIjkCacheManager == null) {
                if (context.getMainLooper().getThread() == Thread.currentThread()) {
                    Log.w(TAG, " can't call IjkCacheManager  at main thread");
                }
                sIjkCacheManager = new IjkCacheManager(context);
            }
            ijkCacheManager = sIjkCacheManager;
        }
        return ijkCacheManager;
    }

    public synchronized String acquireDashCache() {
        if (!evaluateDiskSpace(this.mDashCachePath)) {
            return "";
        }
        do {
            sDashCacheDirIndex++;
        } while (sAllDashCacheDirMap.containsKey(String.valueOf(sDashCacheDirIndex)));
        sAllDashCacheDirMap.put(String.valueOf(sDashCacheDirIndex), "1");
        String path = this.mDashCachePath + EntryScannerKt.PATH_SEPARATOR + String.valueOf(sDashCacheDirIndex);
        File file = new File(path);
        file.mkdir();
        return path;
    }

    public synchronized String acquireVideoCache() {
        if (!evaluateDiskSpace(this.mVideoCachePath)) {
            return "";
        }
        do {
            sVideoCacheDirIndex++;
        } while (sAllVideoCacheDirMap.containsKey(String.valueOf(sVideoCacheDirIndex)));
        sAllVideoCacheDirMap.put(String.valueOf(sVideoCacheDirIndex), "1");
        String path = this.mVideoCachePath + EntryScannerKt.PATH_SEPARATOR + String.valueOf(sVideoCacheDirIndex);
        File file = new File(path);
        file.mkdir();
        return path;
    }

    public synchronized String acquireCdnCache(int type) {
        if (!evaluateDiskSpace(this.mCdnCachePath)) {
            return "";
        }
        String path = this.mCdnCachePath + File.separator + type;
        return path;
    }

    public synchronized long getCacheSpace() {
        evaluateDiskSpace(this.mVideoCachePath);
        return this.mCacheSpace;
    }

    private boolean evaluateDiskSpace(String path) {
        if (!TextUtils.isEmpty(path)) {
            try {
                StatFs stat = new StatFs(path);
                long blockSize = stat.getBlockSizeLong();
                long availableBlocks = stat.getAvailableBlocksLong();
                long available = (blockSize * availableBlocks) / 2;
                if (available > 104857600) {
                    if (available > IjkMediaMeta.AV_CH_STEREO_LEFT) {
                        this.mCacheSpace = IjkMediaMeta.AV_CH_STEREO_LEFT;
                        return true;
                    }
                    this.mCacheSpace = available;
                    return true;
                }
            } catch (RuntimeException e) {
                return false;
            }
        }
        return false;
    }
}