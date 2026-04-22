package tv.danmaku.bili.services.videodownload.strategy;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.app.preferences.Settings;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.utils.strategy.IDownloadStorageStrategy;
import java.io.File;
import java.util.ArrayList;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper;

public class VideoDownloadStorageStrategy implements IDownloadStorageStrategy {
    private static final String TAG = "VideoDownloadStorageStrategy";

    public VideoFile getCurrentDownloadDirectory(Context context) {
        int downloadStorage = Settings.Download.getDownloadStorage(context);
        switch (downloadStorage) {
            case 2:
                VideoFile downloadDir = getSecondaryDirectory(context);
                if (downloadDir == null) {
                    return getPrimaryDirectory(context);
                }
                return downloadDir;
            case 3:
                return getCustomDirectory(context);
            default:
                return getPrimaryDirectory(context);
        }
    }

    public VideoFile[] getCurrentSortedDownloadDirectories(Context context) {
        return getCurrentSortedDownloadDirs(context);
    }

    public VideoFile getRootDownloadDirectory(Context context, String path) {
        return getDownloadDirectory(context, path);
    }

    public long getStorageFreeSpace(Context context, VideoFile videoFile) {
        StorageHelper.Storage storage;
        if (StorageHelper.isPrimary(context, videoFile.getUri().getPath())) {
            storage = StorageHelper.getPrimaryStorage(context);
        } else {
            storage = StorageHelper.getSecondaryStorage(context);
        }
        if (storage == null) {
            return 0L;
        }
        return storage.getAvailableByte();
    }

    public boolean isPrimaryFileAbsolutePath(Context context, String filePath) {
        return StorageHelper.isPrimary(context, filePath);
    }

    public static VideoFile[] getCurrentSortedDownloadDirs(Context context) {
        int downloadStorage = Settings.Download.getDownloadStorage(context);
        BLog.i(TAG, "download storage setting:" + downloadStorage);
        VideoFile downloadDirP = getPrimaryDirectory(context);
        VideoFile downloadDirS = getSecondaryDirectory(context);
        VideoFile downloadDirC = getCustomDirectory(context);
        BLog.i(TAG, String.format("CurrentSortedDownloadDirs ==> PrimaryDirectory:%s , SecondaryDirectory:%s , CustomDirectory:%s", downloadDirP != null ? downloadDirP.getAbsolutePath() : "null", downloadDirS != null ? downloadDirS.getAbsolutePath() : "null", downloadDirC != null ? downloadDirC.getAbsolutePath() : "null"));
        ArrayList<VideoFile> envArray = new ArrayList<>(3);
        switch (downloadStorage) {
            case 2:
                if (downloadDirS != null) {
                    envArray.add(downloadDirS);
                }
                if (downloadDirP != null) {
                    envArray.add(downloadDirP);
                }
                if (downloadDirC != null) {
                    envArray.add(downloadDirC);
                    break;
                }
                break;
            case 3:
                if (downloadDirC != null) {
                    envArray.add(downloadDirC);
                }
                if (downloadDirP != null) {
                    envArray.add(downloadDirP);
                }
                if (downloadDirS != null) {
                    envArray.add(downloadDirS);
                    break;
                }
                break;
            default:
                if (downloadDirP != null) {
                    envArray.add(downloadDirP);
                }
                if (downloadDirS != null) {
                    envArray.add(downloadDirS);
                }
                if (downloadDirC != null) {
                    envArray.add(downloadDirC);
                    break;
                }
                break;
        }
        if (envArray.isEmpty()) {
            return null;
        }
        return (VideoFile[]) envArray.toArray(new VideoFile[envArray.size()]);
    }

    public static File getPrimaryDirectoryFile(Context context) {
        String primary = StorageHelper.getPrimaryPath(context);
        if (!TextUtils.isEmpty(primary)) {
            return new File(primary, getVideoDownloadPreName(context));
        }
        return null;
    }

    public static File getSecondaryDirectoryFile(Context context) {
        String secondaryPath = StorageHelper.getSecondaryPath(context);
        if (!TextUtils.isEmpty(secondaryPath)) {
            return new File(secondaryPath, getVideoDownloadPreName(context));
        }
        return null;
    }

    private static String getVideoDownloadPreName(Context context) {
        return "Android/data/" + context.getPackageName() + "/download";
    }

    public static File getCustomDirectory(Context context, String value) {
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        File downloadDir = new File(value);
        String rootDir = context.getPackageName();
        String dirDownload = getVideoDownloadDir(context);
        String absolutePath = new File(value).getAbsolutePath();
        if (absolutePath.endsWith(rootDir)) {
            File downloadDir2 = new File(value, "download");
            return downloadDir2;
        } else if (absolutePath.endsWith(dirDownload)) {
            return downloadDir;
        } else {
            File downloadDir3 = new File(value, dirDownload);
            return downloadDir3;
        }
    }

    private static VideoFile getPrimaryDirectory(Context context) {
        File file = getPrimaryDirectoryFile(context);
        if (file == null) {
            return null;
        }
        return VideoFile.fromFile(file);
    }

    private static VideoFile getSecondaryDirectory(Context context) {
        File secondaryFile = getSecondaryDirectoryFile(context);
        if (secondaryFile != null) {
            return DocumentProviderCompatHelper.getVideoFileFromFile(context, secondaryFile);
        }
        return null;
    }

    private static VideoFile getCustomDirectory(Context context) {
        File file = getCustomDirectory(context, Settings.Download.getDownloadCustomStoragePath(context));
        return DocumentProviderCompatHelper.getVideoFileFromFile(context, file);
    }

    public static String getDownloadPath(Context context, VideoDownloadEntry entry) {
        VideoFile file;
        return (TextUtils.isEmpty(entry.mStoragePath) || (file = getDownloadDirectory(context, entry.mStoragePath)) == null) ? "" : file.getAbsolutePath();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static VideoFile getDownloadDirectory(Context context, String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String videoDownloadDir = getVideoDownloadDir(context);
        VideoFile videoFile = VideoFile.fromPath(context, path);
        VideoFile root = videoFile.isDirectory() ? videoFile : videoFile.getParentFile();
        while (root != null && root.isDirectory() && !root.getAbsolutePath().endsWith(Uri.encode(videoDownloadDir)) && !root.getAbsolutePath().endsWith(videoDownloadDir)) {
            root = root.getParentFile();
        }
        return videoFile;
    }

    private static String getVideoDownloadDir(Context context) {
        return context.getPackageName() + "/download";
    }

    public static String getDirBiliRoot(Context context) {
        return context.getPackageName();
    }
}