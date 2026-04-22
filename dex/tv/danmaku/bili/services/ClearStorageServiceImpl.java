package tv.danmaku.bili.services;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.moduleservice.preference.ClearStorageService;
import com.bilibili.videodownloader.utils.DBUtilsKt;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Singleton;
import kntr.app.im.chat.db.clean.ChatDatabaseCleaner;
import kntr.app.im.chat.db.clean.ChatDatabaseCleanerKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;

/* compiled from: ClearStorageServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/services/ClearStorageServiceImpl;", "Lcom/bilibili/moduleservice/preference/ClearStorageService;", "<init>", "()V", "cacheDir", "", "fileCacheDir", "externalCacheDir", "externalFileCacheDir", "dataDir", "TAG", "imDbCleaner", "Lkntr/app/im/chat/db/clean/ChatDatabaseCleaner;", "getVideoOfflinePath", "", "()[Ljava/lang/String;", "getVideoOfflineInnerPath", "getVideoOfflineExternalPath", "getApiCachePath", "getImageCacheFilePath", "getImCacheFilePath", "getAccountCacheFilePath", "getAppBaseFilePath", "getWhiteFilePath", "getWholeFilePath", "clearDownloadCache", "", "getWebViewDownloadFilePath", "getFilePath", "parent", ChannelRoutes.CHANNEL_NAME, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClearStorageServiceImpl implements ClearStorageService {
    public static final int $stable = 8;
    private final String TAG;
    private final String cacheDir;
    private final String dataDir;
    private final String externalCacheDir;
    private final String externalFileCacheDir;
    private final String fileCacheDir;
    private final ChatDatabaseCleaner imDbCleaner;

    public ClearStorageServiceImpl() {
        String absolutePath;
        File externalFilesDir;
        File externalCacheDir;
        File filesDir;
        File cacheDir;
        Application application = BiliContext.application();
        String str = "";
        this.cacheDir = (application == null || (cacheDir = application.getCacheDir()) == null || (r0 = cacheDir.getAbsolutePath()) == null) ? "" : "";
        Application application2 = BiliContext.application();
        this.fileCacheDir = (application2 == null || (filesDir = application2.getFilesDir()) == null || (r0 = filesDir.getAbsolutePath()) == null) ? "" : "";
        Application application3 = BiliContext.application();
        this.externalCacheDir = (application3 == null || (externalCacheDir = application3.getExternalCacheDir()) == null || (r0 = externalCacheDir.getAbsolutePath()) == null) ? "" : "";
        Application application4 = BiliContext.application();
        this.externalFileCacheDir = (application4 == null || (externalFilesDir = application4.getExternalFilesDir(null)) == null || (r0 = externalFilesDir.getAbsolutePath()) == null) ? "" : "";
        Application application5 = BiliContext.application();
        Intrinsics.checkNotNull(application5);
        File dataDir = ContextCompat.getDataDir(application5);
        if (dataDir != null && (absolutePath = dataDir.getAbsolutePath()) != null) {
            str = absolutePath;
        }
        this.dataDir = str;
        this.TAG = "ClearStorageServiceImpl";
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), Reflection.getOrCreateKotlinClass(ChatDatabaseCleaner.class), (String) null, 2, (Object) null);
        this.imDbCleaner = suspendProducer != null ? (ChatDatabaseCleaner) suspendProducer.get() : null;
    }

    public String[] getVideoOfflinePath() {
        return (String[]) ArraysKt.plus(getVideoOfflineInnerPath(), getVideoOfflineExternalPath());
    }

    private final String[] getVideoOfflineInnerPath() {
        String[] databaseList;
        File databasePath;
        String $this$getVideoOfflineInnerPath_u24lambda_u240_u240_u240;
        ArrayList offlineDBFiles = new ArrayList();
        Application $this$getVideoOfflineInnerPath_u24lambda_u240 = BiliContext.application();
        if ($this$getVideoOfflineInnerPath_u24lambda_u240 != null && (databaseList = $this$getVideoOfflineInnerPath_u24lambda_u240.databaseList()) != null) {
            for (String str : databaseList) {
                Intrinsics.checkNotNull(str);
                if (StringsKt.contains$default(str, "downloader.video_download_database", false, 2, (Object) null) && (databasePath = $this$getVideoOfflineInnerPath_u24lambda_u240.getDatabasePath(str)) != null && ($this$getVideoOfflineInnerPath_u24lambda_u240_u240_u240 = databasePath.getAbsolutePath()) != null) {
                    offlineDBFiles.add($this$getVideoOfflineInnerPath_u24lambda_u240_u240_u240);
                }
            }
        }
        ArrayList $this$toTypedArray$iv = offlineDBFiles;
        return (String[]) $this$toTypedArray$iv.toArray(new String[0]);
    }

    private final String[] getVideoOfflineExternalPath() {
        File secondaryDirectoryFile;
        String str;
        File primaryDirectoryFile = VideoDownloadStorageStrategy.getPrimaryDirectoryFile(BiliContext.application());
        if (primaryDirectoryFile == null || (str = primaryDirectoryFile.getAbsolutePath()) == null) {
            str = (VideoDownloadStorageStrategy.getSecondaryDirectoryFile(BiliContext.application()) != null ? secondaryDirectoryFile.getAbsolutePath() : null);
            if (str == null) {
                str = "";
            }
        }
        return new String[]{str};
    }

    private final String[] getApiCachePath() {
        return new String[]{getFilePath(this.cacheDir, "list_fallback_cache")};
    }

    public String[] getImageCacheFilePath() {
        return new String[]{getFilePath(this.cacheDir, "ImagePipeLine"), getFilePath(this.cacheDir, "SmallImagePipeLine"), getFilePath(this.externalCacheDir, "ImagePipeLine"), getFilePath(this.externalCacheDir, "SmallImagePipeLine"), getFilePath(this.cacheDir, "live_video")};
    }

    public String[] getImCacheFilePath() {
        File dataDir;
        Iterable listDBFilePaths;
        File cacheDir;
        ArrayList imDbList = new ArrayList();
        Application $this$getImCacheFilePath_u24lambda_u240 = BiliContext.application();
        if ($this$getImCacheFilePath_u24lambda_u240 != null) {
            boolean z = false;
            String[] databaseList = $this$getImCacheFilePath_u24lambda_u240.databaseList();
            if (databaseList != null) {
                for (String str : databaseList) {
                    Intrinsics.checkNotNull(str);
                    if (StringsKt.startsWith$default(str, "IMv3_", false, 2, (Object) null)) {
                        File databasePath = $this$getImCacheFilePath_u24lambda_u240.getDatabasePath(str);
                        String path = databasePath != null ? databasePath.getAbsolutePath() : null;
                        if (path != null) {
                            String $this$getImCacheFilePath_u24lambda_u240_u240_u240 = path;
                            imDbList.add($this$getImCacheFilePath_u24lambda_u240_u240_u240);
                        }
                    }
                }
            }
            File[] listFiles = $this$getImCacheFilePath_u24lambda_u240.getDir("blkv", 0).listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    boolean z2 = z;
                    if (StringsKt.startsWith$default(name, "im_cache_", false, 2, (Object) null)) {
                        imDbList.add(file.getAbsolutePath());
                    }
                    i++;
                    z = z2;
                }
            }
            Intrinsics.checkNotNull(ContextCompat.getDataDir($this$getImCacheFilePath_u24lambda_u240));
            File[] listFiles2 = new File(dataDir.getAbsolutePath() + File.separator + "shared_prefs").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    String name2 = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (StringsKt.startsWith$default(name2, "IMFieldsCache", false, 2, (Object) null)) {
                        imDbList.add(file2.getAbsolutePath());
                    }
                }
            }
            Application application = BiliContext.application();
            String cacheDir2 = (application == null || (cacheDir = application.getCacheDir()) == null || (cacheDir2 = cacheDir.getAbsolutePath()) == null) ? "" : "";
            File[] listFiles3 = new File(getFilePath(cacheDir2, "im_filecache")).listFiles();
            if (listFiles3 != null) {
                for (File file3 : listFiles3) {
                    imDbList.add(file3.getAbsolutePath());
                }
            }
            ChatDatabaseCleaner chatDatabaseCleaner = this.imDbCleaner;
            if (chatDatabaseCleaner != null && (listDBFilePaths = ChatDatabaseCleanerKt.listDBFilePaths(chatDatabaseCleaner)) != null) {
                Iterable $this$forEach$iv = listDBFilePaths;
                for (Object element$iv : $this$forEach$iv) {
                    String it = (String) element$iv;
                    imDbList.add(it);
                }
            }
        }
        ArrayList $this$toTypedArray$iv = imDbList;
        return (String[]) $this$toTypedArray$iv.toArray(new String[0]);
    }

    public String[] getAccountCacheFilePath() {
        File dir;
        Application application = BiliContext.application();
        String newAccountDir = (application == null || (dir = application.getDir("account", 0)) == null || (newAccountDir = dir.getAbsolutePath()) == null) ? "" : "";
        return new String[]{getFilePath(this.fileCacheDir, "bili.passport.storage"), getFilePath(this.fileCacheDir, "bili.account.storage"), getFilePath(newAccountDir, "controller.blkv")};
    }

    public String[] getAppBaseFilePath() {
        File dir;
        Application application = BiliContext.application();
        return new String[]{(application == null || (dir = application.getDir("mod_resource", 0)) == null || (r0 = dir.getAbsolutePath()) == null) ? "" : ""};
    }

    public String[] getWhiteFilePath() {
        return (String[]) ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(getVideoOfflinePath(), getImageCacheFilePath()), getAppBaseFilePath()), getAccountCacheFilePath());
    }

    public String[] getWholeFilePath() {
        ArrayList dataList = new ArrayList();
        File[] listFiles = new File(this.dataDir).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory() && !Intrinsics.areEqual(file.getName(), "lib")) {
                    dataList.add(file.getAbsolutePath());
                }
            }
        }
        ArrayList $this$toTypedArray$iv = dataList;
        return (String[]) ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(new String[]{this.externalCacheDir, this.externalFileCacheDir}, $this$toTypedArray$iv.toArray(new String[0])), getVideoOfflineExternalPath()), getApiCachePath());
    }

    public void clearDownloadCache() {
        Application $this$clearDownloadCache_u24lambda_u240 = BiliContext.application();
        if ($this$clearDownloadCache_u24lambda_u240 != null) {
            DBUtilsKt.clearDownloadDatabase($this$clearDownloadCache_u24lambda_u240);
            BLog.i(this.TAG, "all database entries downloaded has been cleared.");
            ProcessUtils.killDownloadProcess($this$clearDownloadCache_u24lambda_u240);
        }
    }

    public String[] getWebViewDownloadFilePath() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        File dir = application.getDir("h5", 0);
        return new String[]{(dir == null || (r0 = dir.getAbsolutePath()) == null) ? "" : ""};
    }

    private final String getFilePath(String parent, String name) {
        if (TextUtils.isEmpty(parent)) {
            return "";
        }
        return parent + File.separator + name;
    }
}