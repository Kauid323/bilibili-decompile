package tv.danmaku.bili.utils.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import com.bilibili.app.preferences.Settings;
import com.bilibili.offline.StorageInfo;
import com.bilibili.offline.StorageProviderConstants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.DebugLog;
import tv.danmaku.bili.provider.ProviderHelper;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.infra.utils.StorageHelperKt;

public class StorageHelper {
    public static final String TAG = "StorageHelper";
    private static Method lstat;
    private static Object os;
    private static Field st_dev;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum StorageType {
        NONE,
        PRIMARY,
        SECONDARY,
        CUSTOM
    }

    public static Storage getPrimaryStorage(Context context) {
        String primaryPath = getPrimaryPath(context);
        return buildStorage(primaryPath);
    }

    public static Storage getSecondaryStorage(Context context) {
        return buildStorage(getSecondaryPath(context));
    }

    private static StatFs getStatFs(String path) {
        try {
            return new StatFs(path);
        } catch (Exception e) {
            return null;
        }
    }

    private static Storage buildStorage(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        Storage storage = new Storage();
        StatFs fs = getStatFs(path);
        storage.path = path;
        storage.totalByte = getTotalByte(fs);
        storage.availableByte = getAvailableByte(fs);
        return storage;
    }

    public static boolean isPrimary(Context context, String path) {
        String primary;
        if (TextUtils.isEmpty(path) || (primary = getPrimaryPath(context)) == null) {
            return false;
        }
        try {
            path = new File(path).getCanonicalPath();
        } catch (IOException e) {
        }
        if (path.startsWith(primary)) {
            return true;
        }
        long primaryDevid = getDeviceID(primary);
        if (primaryDevid == -1) {
            return false;
        }
        long pathDevid = getDeviceID(path);
        return primaryDevid == pathDevid;
    }

    public static String getPrimaryPath(Context context) {
        String path = getPathInternal(context, StorageHelperKt.PRIMARY);
        if (path == null) {
            BLog.wtf(TAG, "wtf! path of primary storage is null!");
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return path;
    }

    public static String getSecondaryPath(Context context) {
        return getPathInternal(context, StorageHelperKt.SECONDARY);
    }

    private static String getPathInternal(Context context, String type) {
        Cursor cursor = ProviderHelper.query(context, buildUri(context, type), new String[]{"value"}, (String) null, (String[]) null, (String) null);
        if (cursor != null) {
            try {
                try {
                    if (cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception e) {
                    BLog.wfmt(TAG, "Cannot get path of type %s from storage-provider!\n %s", new Object[]{type, e.toString()});
                }
                return null;
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public static String getPersistableUri(Context context) {
        Cursor cursor = ProviderHelper.query(context, buildUri(context, "storage_persistable_uri"), new String[]{"value"}, (String) null, (String[]) null, (String) null);
        if (cursor != null) {
            try {
                try {
                    if (cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception e) {
                    BLog.wfmt(TAG, "Cannot get path of type %s from storage-provider!\n %s", new Object[]{"storage_persistable_uri", e.toString()});
                }
                return null;
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public static void updatePersistableUri(Context context, String uri) {
        ContentValues values = new ContentValues();
        values.put("storage_persistable_uri_key", uri);
        context.getContentResolver().update(buildUri(context, "storage_persistable_uri"), values, null, null);
    }

    private static Uri buildUri(Context context, String query) {
        return Uri.parse("content://" + StorageProviderConstants.authority(context) + EntryScannerKt.PATH_SEPARATOR + query);
    }

    public static long getTotalByte(StatFs fs) {
        if (fs == null) {
            return 0L;
        }
        return fs.getTotalBytes();
    }

    public static long getAvailableByte(StatFs fs) {
        if (fs == null) {
            return 0L;
        }
        return fs.getAvailableBytes();
    }

    public static Storage getCurrentDownloadStorage(Context context) {
        int downloadStorage = Settings.Download.getDownloadStorage(context);
        switch (downloadStorage) {
            case 1:
                Storage volume = getPrimaryStorage(context);
                return volume;
            case 2:
                Storage volume2 = getSecondaryStorage(context);
                return volume2;
            case 3:
                String path = Settings.Download.getDownloadCustomStoragePath(context);
                if (TextUtils.isEmpty(path)) {
                    return null;
                }
                return Storage.fromFile(new File(path));
            default:
                return null;
        }
    }

    public static StorageInfo[] getDownloadVideoStorage(Context context) {
        StorageInfo primaryStorage = new StorageInfo();
        File primaryPath = VideoDownloadStorageStrategy.getPrimaryDirectoryFile(context);
        if (primaryPath != null) {
            primaryStorage.path = primaryPath.getAbsolutePath();
            primaryStorage.offlineUsedBytes = dirSize(primaryPath);
            Storage storage = getPrimaryStorage(context);
            if (storage != null) {
                primaryStorage.diskTotalBytes = storage.getTotalByte();
                primaryStorage.diskAvailableBytes = storage.getAvailableByte();
            }
        }
        StorageInfo secondaryStorage = new StorageInfo();
        File secondaryPath = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(context);
        if (secondaryPath != null) {
            secondaryStorage.path = secondaryPath.getAbsolutePath();
            secondaryStorage.offlineUsedBytes = dirSize(secondaryPath);
            Storage storage2 = getSecondaryStorage(context);
            if (storage2 != null) {
                secondaryStorage.diskTotalBytes = storage2.getTotalByte();
                secondaryStorage.diskAvailableBytes = storage2.getAvailableByte();
            }
        }
        File customPath = VideoDownloadStorageStrategy.getCustomDirectory(context, Settings.Download.getDownloadCustomStoragePath(context));
        if (customPath != null) {
            long customPathByte = dirSize(customPath);
            if (isPrimary(context, customPath.getAbsolutePath())) {
                primaryStorage.offlineUsedBytes += customPathByte;
            } else {
                secondaryStorage.offlineUsedBytes += customPathByte;
            }
        }
        StorageInfo[] info = {primaryStorage, secondaryStorage};
        return info;
    }

    private static long dirSize(File dir) {
        long length;
        if (dir == null || !dir.exists()) {
            return 0L;
        }
        if (dir.isFile()) {
            return dir.length();
        }
        long result = 0;
        File[] fileList = dir.listFiles();
        if (fileList == null) {
            return 0L;
        }
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                length = dirSize(fileList[i]);
            } else {
                length = fileList[i].length();
            }
            result += length;
        }
        return result;
    }

    public static long getDeviceID(String devPath) {
        if (TextUtils.isEmpty(devPath)) {
            return -1L;
        }
        try {
            devPath = new File(devPath).getCanonicalPath();
        } catch (IOException e) {
        }
        try {
            StructStat stat = Os.lstat(devPath);
            return stat.st_dev;
        } catch (Throwable t) {
            DebugLog.wfmt(TAG, "get device id failed: %s path=%s", new Object[]{t.getMessage(), devPath});
            return devPath.hashCode();
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Storage {
        long availableByte;
        String path;
        long totalByte;

        public Storage() {
        }

        public Storage(long availableByte, long totalByte, String path) {
            this.availableByte = availableByte;
            this.totalByte = totalByte;
            this.path = path;
        }

        public static Storage fromFile(File file) {
            return new Storage(file.getFreeSpace(), file.getTotalSpace(), file.getPath());
        }

        public long getAvailableByte() {
            return this.availableByte;
        }

        public long getTotalByte() {
            return this.totalByte;
        }

        public String getPath() {
            return this.path;
        }

        public String toString() {
            return this.path;
        }
    }
}