package tv.danmaku.biliplayerv2.service.interact.biz.share;

import android.app.Application;
import android.content.Context;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosShareManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J$\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\f\u001a6\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e \u000f*\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/share/ChronosShareManager;", "", "<init>", "()V", "TAG", "", "CHRONOS_SHARE_DIR", "CHRONOS_SHARE_SUB_DIR", "", "[Ljava/lang/String;", "mIsOperating", "", "CREATE_CHRONOS_SHARE_DIR", "Lbolts/Task;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "getChronosShareDir", "createChronosShareDirIfNeeded", "subDir", "createChronosShareSubDirIfNeeded", "directoryPath", "createDir", "config", "", "chronosCore", "Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;", "update", "clear", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosShareManager {
    private static final String CHRONOS_SHARE_DIR = "chronos_share_files";
    private static final String TAG = "ChronosShareManager";
    private static boolean mIsOperating;
    public static final ChronosShareManager INSTANCE = new ChronosShareManager();
    private static final String[] CHRONOS_SHARE_SUB_DIR = {"chronos_fonts"};
    private static final Task<Pair<String, Boolean>> CREATE_CHRONOS_SHARE_DIR = Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.share.ChronosShareManager$$ExternalSyntheticLambda1
        @Override // java.util.concurrent.Callable
        public final Object call() {
            Pair CREATE_CHRONOS_SHARE_DIR$lambda$0;
            CREATE_CHRONOS_SHARE_DIR$lambda$0 = ChronosShareManager.CREATE_CHRONOS_SHARE_DIR$lambda$0();
            return CREATE_CHRONOS_SHARE_DIR$lambda$0;
        }
    });

    private ChronosShareManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair CREATE_CHRONOS_SHARE_DIR$lambda$0() {
        return createChronosShareDirIfNeeded$default(INSTANCE, null, 1, null);
    }

    public final String getChronosShareDir() {
        Context it;
        Application application = BiliContext.application();
        if (application == null || (it = application.getApplicationContext()) == null) {
            return null;
        }
        return it.getCacheDir().getPath() + File.separator + CHRONOS_SHARE_DIR;
    }

    public static /* synthetic */ Pair createChronosShareDirIfNeeded$default(ChronosShareManager chronosShareManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return chronosShareManager.createChronosShareDirIfNeeded(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: all -> 0x009b, Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:10:0x001a, B:12:0x0046, B:15:0x004d, B:22:0x0065, B:24:0x008b, B:23:0x0086, B:16:0x0054, B:18:0x005a), top: B:36:0x001a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[Catch: all -> 0x009b, Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:10:0x001a, B:12:0x0046, B:15:0x004d, B:22:0x0065, B:24:0x008b, B:23:0x0086, B:16:0x0054, B:18:0x005a), top: B:36:0x001a, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<String, Boolean> createChronosShareDirIfNeeded(String subDir) {
        Context it;
        boolean result;
        if (mIsOperating) {
            return null;
        }
        mIsOperating = true;
        Application application = BiliContext.application();
        if (application != null && (it = application.getApplicationContext()) != null) {
            try {
                try {
                    String cacheDir = it.getCacheDir().getPath();
                    String separator = File.separator;
                    String chronosDir = cacheDir + separator + CHRONOS_SHARE_DIR;
                    File dirFile = new File(chronosDir);
                    if (dirFile.exists() && dirFile.isDirectory()) {
                        result = INSTANCE.createChronosShareSubDirIfNeeded(chronosDir, subDir);
                        if (result) {
                            BLog.i(TAG, "create chronos share dir failed");
                        } else {
                            BLog.i(TAG, "create chronos dir succeed, path: " + chronosDir + ", sub " + subDir);
                        }
                        Pair<String, Boolean> pair = new Pair<>(chronosDir, Boolean.valueOf(result));
                        mIsOperating = false;
                        return pair;
                    }
                    result = dirFile.mkdirs() ? INSTANCE.createChronosShareSubDirIfNeeded(chronosDir, subDir) : false;
                    if (result) {
                    }
                    Pair<String, Boolean> pair2 = new Pair<>(chronosDir, Boolean.valueOf(result));
                    mIsOperating = false;
                    return pair2;
                } catch (Exception e) {
                    BLog.e(TAG, "create chronos share dir failed, cause " + e);
                    mIsOperating = false;
                }
            } catch (Throwable th) {
                mIsOperating = false;
                throw th;
            }
        }
        return null;
    }

    static /* synthetic */ boolean createChronosShareSubDirIfNeeded$default(ChronosShareManager chronosShareManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return chronosShareManager.createChronosShareSubDirIfNeeded(str, str2);
    }

    private final boolean createChronosShareSubDirIfNeeded(String directoryPath, String subDir) {
        boolean result = true;
        String[] strArr = CHRONOS_SHARE_SUB_DIR;
        int length = strArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                break;
            }
            String path = strArr[i];
            if (!result || !createDir(directoryPath, path)) {
                z2 = false;
            }
            result = z2;
            i++;
        }
        if (subDir != null) {
            if (result && createDir(directoryPath, subDir)) {
                z = true;
            }
            boolean result2 = z;
            return result2;
        }
        return result;
    }

    private final boolean createDir(String directoryPath, String subDir) {
        File file = new File(directoryPath, subDir);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        if (!file.exists()) {
            boolean result = file.mkdirs();
            return result;
        } else if (!file.isFile()) {
            return true;
        } else {
            file.delete();
            boolean result2 = file.mkdirs();
            return result2;
        }
    }

    public final void config(EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner) {
        Context applicationContext;
        File cacheDir;
        String it;
        Intrinsics.checkNotNullParameter(enhancedChronosPackageRunner, "chronosCore");
        Application application = BiliContext.application();
        if (application != null && (applicationContext = application.getApplicationContext()) != null && (cacheDir = applicationContext.getCacheDir()) != null && (it = cacheDir.getPath()) != null) {
            final String chronosShareDir = it + File.separator + CHRONOS_SHARE_DIR;
            Application application2 = BiliContext.application();
            Intrinsics.checkNotNull(application2);
            String modResourceCachePath = new File(application2.getDir("mod_resource", 0), "cache").getPath();
            String[] resourceSearchPath = enhancedChronosPackageRunner.getResourceSearchPath();
            String[] strArr = null;
            Collection searchPaths = resourceSearchPath != null ? ArraysKt.toMutableList(resourceSearchPath) : null;
            if (searchPaths != null) {
                List paths = searchPaths;
                if (!paths.contains(modResourceCachePath)) {
                    Intrinsics.checkNotNull(modResourceCachePath);
                    paths.add(modResourceCachePath);
                }
                if (!paths.contains(chronosShareDir)) {
                    paths.add(chronosShareDir);
                }
            }
            if (searchPaths != null) {
                Collection $this$toTypedArray$iv = searchPaths;
                strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            }
            enhancedChronosPackageRunner.setResourceSearchPath(strArr);
            BLog.d(TAG, "chronos view set resourceSearchPath succeed : " + enhancedChronosPackageRunner + ".resourceSearchPath");
            Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.share.ChronosShareManager$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Unit config$lambda$0$1;
                    config$lambda$0$1 = ChronosShareManager.config$lambda$0$1(chronosShareDir);
                    return config$lambda$0$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit config$lambda$0$1(String $chronosShareDir) {
        CREATE_CHRONOS_SHARE_DIR.waitForCompletion();
        ChronosFontModManager chronosFontModManager = ChronosFontModManager.INSTANCE;
        String str = File.separator;
        chronosFontModManager.init($chronosShareDir + str + CHRONOS_SHARE_SUB_DIR[0]);
        INSTANCE.update();
        return Unit.INSTANCE;
    }

    public final void update() {
        ChronosFontModManager.INSTANCE.update();
    }

    public final void clear() {
    }
}