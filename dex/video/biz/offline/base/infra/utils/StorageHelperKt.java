package video.biz.offline.base.infra.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.base.model.model.StorageType;

/* compiled from: StorageHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002\u001a\b\u0010\r\u001a\u0004\u0018\u00010\n\u001a\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"getPreferredDirectoryFile", "Ljava/io/File;", "getPrimaryDirectoryFile", "context", "Landroid/content/Context;", "getPrimaryStorage", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "getSecondaryDirectoryFile", "getSecondaryStorage", "getVideoDownloadPreName", "", "buildStorage", "path", "getPrimaryPath", "getSecondaryPath", "dirSize", "", "dir", "PRIMARY", "SECONDARY", "DOWNLOAD_STORAGE_PRIMARY_EXTERNAL", "DOWNLOAD_STORAGE_SECONDARY_EXTERNAL", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StorageHelperKt {
    public static final String DOWNLOAD_STORAGE_PRIMARY_EXTERNAL = "1";
    public static final String DOWNLOAD_STORAGE_SECONDARY_EXTERNAL = "2";
    public static final String PRIMARY = "primary";
    public static final String SECONDARY = "secondary";

    /* compiled from: StorageHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StorageType.values().length];
            try {
                iArr[StorageType.SECONDARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final File getPreferredDirectoryFile() {
        if (WhenMappings.$EnumSwitchMapping$0[DownloadStoragePreference.INSTANCE.getPreferredStorageType().ordinal()] == 1) {
            File secondary = getSecondaryDirectoryFile(FoundationAlias.getFapp());
            if (secondary == null) {
                new DataLog().info("Preferred secondary dir is null, use primary for default.");
                return getPrimaryDirectoryFile(FoundationAlias.getFapp());
            }
            return secondary;
        }
        return getPrimaryDirectoryFile(FoundationAlias.getFapp());
    }

    public static final File getPrimaryDirectoryFile(Context context) {
        File downloadDir;
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(null);
        File externalPackageDir = externalFilesDir != null ? externalFilesDir.getParentFile() : null;
        if (externalPackageDir == null) {
            new DataLog().error("external package dir is null, use fixed external storage path.");
            String primaryPath = getPrimaryPath();
            String str = primaryPath;
            if (str == null || str.length() == 0) {
                new DataLog().error("getPrimaryDirectoryFile failed, primaryPath is null or empty!");
                OfflineNeuron.Companion.dataErrorTrackT(DataErrorType.STORAGE_PATH_ERROR);
                return null;
            }
            downloadDir = new File(primaryPath, getVideoDownloadPreName(context));
        } else {
            downloadDir = new File(externalPackageDir, "download");
        }
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        return downloadDir;
    }

    public static final StorageInfoModel getPrimaryStorage() {
        return buildStorage(getPrimaryPath());
    }

    public static final File getSecondaryDirectoryFile(Context context) {
        File file;
        Intrinsics.checkNotNullParameter(context, "context");
        File[] externalFilesDirs = context.getExternalFilesDirs(null);
        File externalPackageDir = (externalFilesDirs == null || (file = (File) ArraysKt.getOrNull(externalFilesDirs, 1)) == null) ? null : file.getParentFile();
        if (externalPackageDir == null) {
            new DataLog().info("getSecondaryDirectoryFile failed, externalPackageDir is null!");
            return null;
        }
        File downloadDir = new File(externalPackageDir, "download");
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        return downloadDir;
    }

    public static final StorageInfoModel getSecondaryStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildStorage(getSecondaryPath(context));
    }

    private static final String getVideoDownloadPreName(Context context) {
        return "Android/data/" + context.getPackageName() + "/download";
    }

    private static final StorageInfoModel buildStorage(String path) {
        String str = path;
        StatFs statFs = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            statFs = new StatFs(path);
        } catch (Exception e) {
        }
        StatFs fs = statFs;
        return new StorageInfoModel(null, path, fs != null ? fs.getTotalBytes() : 0L, fs != null ? fs.getAvailableBytes() : 0L, 0L, 17, null);
    }

    public static final String getPrimaryPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static final String getSecondaryPath(Context context) {
        File parentFile;
        Intrinsics.checkNotNullParameter(context, "context");
        File[] externalFilesDirs = context.getExternalFilesDirs(null);
        Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "getExternalFilesDirs(...)");
        File secondaryDir = (File) ArraysKt.getOrNull(externalFilesDirs, 1);
        if (secondaryDir == null) {
            new DataLog().warn("getSecondaryPath failed, secondaryDir is null!");
            return null;
        }
        File parent = secondaryDir.getParentFile();
        while (parent != null && !Intrinsics.areEqual(parent.getName(), "Android")) {
            parent = parent.getParentFile();
        }
        if (parent == null || (parentFile = parent.getParentFile()) == null) {
            return null;
        }
        return parentFile.getAbsolutePath();
    }

    public static final long dirSize(File dir) {
        long length;
        if (dir == null || !dir.exists()) {
            return 0L;
        }
        if (dir.isFile()) {
            return dir.length();
        }
        File[] fileList = dir.listFiles();
        if (fileList == null) {
            return 0L;
        }
        long result = 0;
        for (File file : fileList) {
            if (file.isDirectory()) {
                length = dirSize(file);
            } else {
                length = file.length();
            }
            result += length;
        }
        return result;
    }
}