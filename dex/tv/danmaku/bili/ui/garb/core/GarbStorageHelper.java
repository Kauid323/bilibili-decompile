package tv.danmaku.bili.ui.garb.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.ui.garb.Garb;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.garb.GarbManagerDelegateKt;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;

/* compiled from: GarbStorageHelper.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002LMB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010$2\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010$2\u0006\u0010\u0019\u001a\u00020\u0011J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J\u001a\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020(J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011J\u0010\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u00100\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u00101\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u000102J\u0018\u00103\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u00104\u001a\u00020(J\u001a\u00105\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u00104\u001a\u00020(H\u0002J\u0018\u00106\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u00107\u001a\u00020(J\u0016\u00108\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0011J\u0012\u00109\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001aJ\u0016\u0010<\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\u0016\u0010@\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001aJ\u0016\u0010A\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020>J\u000e\u0010C\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010D\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011J\u000e\u0010E\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010G\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010H\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010I\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010J\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Ltv/danmaku/bili/ui/garb/core/GarbStorageHelper;", "", "<init>", "()V", "DIR_NAME", "", "CONF_NAME", "LAST_CONF_NAME", "OP_GARB_DIR_NAME", "PREF_GARB_SHOW_DIALOG_ID", "PREF_GARB_LAST_OP_GARB_ID", "PREF_GARB_HAS_CHANGED", "PREF_TARGET_GARB_THEME_ID", "PREF_TARGET_GARB_CHANGEABLE", "PREF_TARGET_GARB_TYPE", "PREF_GARB_INITIALIZED", "mLastGarb", "Lcom/bilibili/lib/ui/garb/Garb;", "getMLastGarb", "()Lcom/bilibili/lib/ui/garb/Garb;", "setMLastGarb", "(Lcom/bilibili/lib/ui/garb/Garb;)V", "mBaseDirPath", "download", "", GarbStorageHelper.DIR_NAME, "Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "listener", "Ltv/danmaku/bili/ui/garb/core/GarbStorageHelper$Listener;", "buildGarbDirName", "context", "Landroid/content/Context;", "buildZipDirName", "buildDirName", "getBaseDir", "listAssetFilePath", "", "convertToFileUir", "absolutePath", "unzip", "", "source", "Ljava/io/File;", "destDir", "saveGarb", "isOp", "saveLastGarb", "readLastGarbWrapper", "readLastGarb", "clearLastGarb", "Ltv/danmaku/bili/ui/garb/core/GarbStorageHelper$IClearLastGarbListener;", "readGarbWrapper", "skipOp", "readGarb", "clearOpGarb", "currentIsNight", "clearGarbRes", "readOpGarb", "isResValid", "garbDetail", "setShowDialogGarbId", "garbId", "", "getShowDialogGarbId", "cleanOldAsset", "saveLastOpGarb", "id", "getLastOpGarb", "saveGarbChanged", "isGarbChanged", "getTargetGarbThemeId", "getTargetGarbChangeable", "getTargetGarbType", "isGarbInitialized", "saveGarbInitialized", "status", "Listener", "IClearLastGarbListener", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbStorageHelper {
    private static final String CONF_NAME = "garb.conf";
    private static final String DIR_NAME = "garb";
    private static final String LAST_CONF_NAME = "last.garb.conf";
    private static final String OP_GARB_DIR_NAME = "op";
    private static final String PREF_GARB_HAS_CHANGED = "pref_key_garb_has_changed";
    private static final String PREF_GARB_INITIALIZED = "pref_key_garb_initialized";
    private static final String PREF_GARB_LAST_OP_GARB_ID = "pref_key_garb_last_op_garb_id";
    private static final String PREF_GARB_SHOW_DIALOG_ID = "pref_key_garb_show_dialog_id";
    private static final String PREF_TARGET_GARB_CHANGEABLE = "pref_key_target_garb_changeable";
    private static final String PREF_TARGET_GARB_THEME_ID = "pref_key_target_garb_theme_id";
    private static final String PREF_TARGET_GARB_TYPE = "pref_key_target_garb_type";
    private static Garb mLastGarb;
    public static final GarbStorageHelper INSTANCE = new GarbStorageHelper();
    private static volatile String mBaseDirPath = "";

    /* compiled from: GarbStorageHelper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/core/GarbStorageHelper$IClearLastGarbListener;", "", "onClear", "", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IClearLastGarbListener {
        void onClear();
    }

    /* compiled from: GarbStorageHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/core/GarbStorageHelper$Listener;", "", "onDownloadError", "", "errMsg", "", "onDownloadSuccess", "isCanceled", "", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Listener {
        boolean isCanceled();

        void onDownloadError(String str);

        void onDownloadSuccess();
    }

    private GarbStorageHelper() {
    }

    public final Garb getMLastGarb() {
        return mLastGarb;
    }

    public final void setMLastGarb(Garb garb) {
        mLastGarb = garb;
    }

    public final void download(GarbData.GarbDetail garb, Listener listener) {
        Application context;
        Intrinsics.checkNotNullParameter(garb, DIR_NAME);
        if (TextUtils.isEmpty(garb.getPkgUrl()) || (context = BiliContext.application()) == null) {
            return;
        }
        File dir = new File(buildGarbDirName(context, garb));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = String.valueOf(garb.getId());
        File destFile = new File(dir, fileName);
        if (destFile.exists()) {
            destFile.delete();
        }
        BLog.i(GarbManagerDelegateKt.TAG, "download garb " + dir.getAbsolutePath());
        String pkgUrl = garb.getPkgUrl();
        String pkgMd5 = garb.getPkgMd5();
        String absolutePath = dir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        GarbResourceDownloaderKt.download(context, pkgUrl, pkgMd5, absolutePath, fileName, new GarbStorageHelper$download$1(context, garb, listener));
    }

    private final String buildGarbDirName(Context context, GarbData.GarbDetail garb) {
        String buildDirName = buildDirName(context);
        return buildDirName + "/" + garb.getId();
    }

    public final String buildZipDirName(Context context, GarbData.GarbDetail garb) {
        String buildGarbDirName = buildGarbDirName(context, garb);
        return buildGarbDirName + "/" + garb.getVer();
    }

    private final String buildZipDirName(Context context, Garb garb) {
        String buildGarbDirName = buildGarbDirName(context, garb);
        return buildGarbDirName + "/" + garb.getVer();
    }

    public final String buildDirName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String baseDir = getBaseDir(context);
        return baseDir + "/garb/" + BiliAccounts.get(context).mid();
    }

    private final String buildGarbDirName(Context context, Garb garb) {
        String buildDirName = buildDirName(context);
        return buildDirName + "/" + garb.getId();
    }

    private final String getBaseDir(Context context) {
        if (TextUtils.isEmpty(mBaseDirPath)) {
            mBaseDirPath = context.getFilesDir().getAbsolutePath();
            String str = mBaseDirPath;
            Intrinsics.checkNotNull(str);
            return str;
        }
        String str2 = mBaseDirPath;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public final Map<String, String> listAssetFilePath(GarbData.GarbDetail garb) {
        Intrinsics.checkNotNullParameter(garb, DIR_NAME);
        Map map = new HashMap();
        Application context = BiliContext.application();
        if (context == null) {
            return map;
        }
        File garbDir = new File(buildZipDirName(context, garb));
        if (!garbDir.exists()) {
            return map;
        }
        File[] assets = garbDir.listFiles();
        if (assets != null) {
            if (!(assets.length == 0)) {
                for (File asset : assets) {
                    if (asset.exists()) {
                        Intrinsics.checkNotNull(asset);
                        String nameWithoutExtension = FilesKt.getNameWithoutExtension(asset);
                        String absolutePath = asset.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        map.put(nameWithoutExtension, convertToFileUir(absolutePath));
                    }
                }
                return map;
            }
        }
        return map;
    }

    public final Map<String, String> listAssetFilePath(Garb garb) {
        Intrinsics.checkNotNullParameter(garb, DIR_NAME);
        Map map = new HashMap();
        Application context = BiliContext.application();
        if (context == null) {
            return map;
        }
        File garbDir = new File(buildZipDirName(context, garb));
        if (!garbDir.exists()) {
            return map;
        }
        File[] assets = garbDir.listFiles();
        if (assets != null) {
            if (!(assets.length == 0)) {
                for (File asset : assets) {
                    if (asset.exists()) {
                        Intrinsics.checkNotNull(asset);
                        String nameWithoutExtension = FilesKt.getNameWithoutExtension(asset);
                        String absolutePath = asset.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        map.put(nameWithoutExtension, convertToFileUir(absolutePath));
                    }
                }
                return map;
            }
        }
        return map;
    }

    private final String convertToFileUir(String absolutePath) {
        return BusinessSplashDefine.FILE_URI_PREFIX + absolutePath;
    }

    public final boolean unzip(File source, File destDir) {
        boolean z = false;
        if (source != null && source.exists()) {
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
                try {
                    BufferedInputStream it = bufferedInputStream;
                    ZipInputStream zipInputStream = new ZipInputStream(it);
                    try {
                        ZipInputStream zipInput = zipInputStream;
                        while (true) {
                            ZipEntry item = zipInput.getNextEntry();
                            Throwable th = null;
                            if (item == null) {
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(bufferedInputStream, (Throwable) null);
                                return true;
                            }
                            String name = item.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            if (!StringsKt.contains$default(name, "../", z, 2, (Object) null)) {
                                try {
                                    File file = new File(destDir, item.getName());
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    FileOutputStream outStream = fileOutputStream;
                                    byte[] buffer = new byte[2048];
                                    while (true) {
                                        int readBytes = zipInput.read(buffer);
                                        if (readBytes <= 0) {
                                            break;
                                        }
                                        outStream.write(buffer, 0, readBytes);
                                        th = null;
                                    }
                                    Unit unit3 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, th);
                                    zipInput.closeEntry();
                                    z = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    Throwable th3 = th;
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        try {
                                            CloseableKt.closeFinally(zipInputStream, th3);
                                            throw th4;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            Throwable th6 = th;
                                            try {
                                                throw th6;
                                            } catch (Throwable th7) {
                                                try {
                                                    CloseableKt.closeFinally(bufferedInputStream, th6);
                                                    throw th7;
                                                } catch (Throwable th8) {
                                                    e = th8;
                                                    BLog.e(GarbManagerDelegateKt.TAG, "Unzip garb assets error!", e);
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th9) {
                        th = th9;
                    }
                } catch (Throwable th10) {
                    th = th10;
                }
            } catch (Throwable th11) {
                e = th11;
            }
        }
        return false;
    }

    public static /* synthetic */ void saveGarb$default(GarbStorageHelper garbStorageHelper, Garb garb, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        garbStorageHelper.saveGarb(garb, z);
    }

    public final void saveGarb(final Garb garb, boolean isOp) {
        Intrinsics.checkNotNullParameter(garb, DIR_NAME);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit saveGarb$lambda$0;
                saveGarb$lambda$0 = GarbStorageHelper.saveGarb$lambda$0(garb);
                return saveGarb$lambda$0;
            }
        });
    }

    public static final Unit saveGarb$lambda$0(Garb $garb) {
        Application context = BiliContext.application();
        if (context == null) {
            return Unit.INSTANCE;
        }
        File dir = new File(INSTANCE.buildDirName(context));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File confFile = new File(dir, CONF_NAME);
        try {
            FileUtils.writeStringToFile(confFile, JSON.toJSONString($garb));
            BLog.i(GarbManagerDelegateKt.TAG, "Save garb success " + $garb.getId());
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "Save garb config error!", e);
        }
        return Unit.INSTANCE;
    }

    public final void saveLastGarb(Garb garb) {
        Intrinsics.checkNotNullParameter(garb, DIR_NAME);
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        File dir = new File(buildDirName(context));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File lastConfFile = new File(dir, LAST_CONF_NAME);
        try {
            String garbString = JSON.toJSONString(garb);
            FileUtils.writeStringToFile(lastConfFile, garbString);
            GarbManagerDelegate.clearMemoryLastGarb();
            BLog.i(GarbManagerDelegateKt.TAG, "Save last garb success " + garb.getId());
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "Save last garb config error!", e);
            FileUtils.deleteQuietly(lastConfFile);
        }
    }

    public final Garb readLastGarbWrapper(Context context) {
        Map it;
        Intrinsics.checkNotNullParameter(context, "context");
        if (mLastGarb != null) {
            return mLastGarb;
        }
        Garb lastGarb = readLastGarb(context);
        boolean z = false;
        if (lastGarb != null && !lastGarb.isLoadAllFile()) {
            z = true;
        }
        if (z && !lastGarb.isPure() && (it = listAssetFilePath(lastGarb)) != null) {
            String str = it.get("head_myself_bg");
            if (str == null) {
                str = "";
            }
            lastGarb.setHeadMineBgPath(str);
            List tailIconPath = lastGarb.getTailIconPath();
            String str2 = it.get("tail_icon_myself");
            if (str2 == null) {
                str2 = "";
            }
            tailIconPath.add(str2);
            List tailIconSelectedPath = lastGarb.getTailIconSelectedPath();
            String str3 = it.get("tail_icon_selected_myself");
            tailIconSelectedPath.add(str3 != null ? str3 : "");
            lastGarb.setLoadAllFile(true);
            INSTANCE.saveLastGarb(lastGarb);
        }
        mLastGarb = lastGarb;
        return lastGarb;
    }

    private final Garb readLastGarb(Context context) {
        File lastConfFile = new File(buildDirName(context), LAST_CONF_NAME);
        if (lastConfFile.exists()) {
            try {
                return (Garb) JSON.parseObject(FileUtils.readFileToString(lastConfFile), Garb.class);
            } catch (Exception e) {
                BLog.e(GarbManagerDelegateKt.TAG, "Read last garb config error!", e);
                return null;
            }
        }
        return null;
    }

    public final void clearLastGarb(final Context context, final IClearLastGarbListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        GarbManagerDelegate.clearMemoryLastGarb();
        BLog.i(GarbManagerDelegateKt.TAG, "clearLastGarb");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean clearLastGarb$lambda$0;
                clearLastGarb$lambda$0 = GarbStorageHelper.clearLastGarb$lambda$0(context);
                return clearLastGarb$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Void clearLastGarb$lambda$1;
                clearLastGarb$lambda$1 = GarbStorageHelper.clearLastGarb$lambda$1(GarbStorageHelper.IClearLastGarbListener.this, task);
                return clearLastGarb$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public static final Boolean clearLastGarb$lambda$0(Context $context) {
        File lastGarbConf = new File(INSTANCE.buildDirName($context), LAST_CONF_NAME);
        return Boolean.valueOf(FileUtils.deleteQuietly(lastGarbConf));
    }

    public static final Void clearLastGarb$lambda$1(IClearLastGarbListener $listener, Task it) {
        if ($listener != null) {
            $listener.onClear();
            return null;
        }
        return null;
    }

    public static /* synthetic */ Garb readGarbWrapper$default(GarbStorageHelper garbStorageHelper, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return garbStorageHelper.readGarbWrapper(context, z);
    }

    public final Garb readGarbWrapper(Context context, boolean skipOp) {
        Map it;
        Intrinsics.checkNotNullParameter(context, "context");
        Garb garb = readGarb(context, skipOp);
        if (!garb.isLoadAllFile() && !garb.isPure() && (it = listAssetFilePath(garb)) != null) {
            String str = it.get("head_myself_bg");
            if (str == null) {
                str = "";
            }
            garb.setHeadMineBgPath(str);
            List tailIconPath = garb.getTailIconPath();
            String str2 = it.get("tail_icon_myself");
            if (str2 == null) {
                str2 = "";
            }
            tailIconPath.add(str2);
            List tailIconSelectedPath = garb.getTailIconSelectedPath();
            String str3 = it.get("tail_icon_selected_myself");
            tailIconSelectedPath.add(str3 != null ? str3 : "");
            garb.setLoadAllFile(true);
            saveGarb$default(INSTANCE, garb, false, 2, null);
        }
        BLog.i(GarbManagerDelegateKt.TAG, "Read saved garb " + garb.getId());
        return garb;
    }

    static /* synthetic */ Garb readGarb$default(GarbStorageHelper garbStorageHelper, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return garbStorageHelper.readGarb(context, z);
    }

    private final Garb readGarb(Context context, boolean skipOp) {
        Garb op = readOpGarb(context);
        if (!skipOp && op != null) {
            return op;
        }
        File confFile = new File(buildDirName(context), CONF_NAME);
        if (!confFile.exists()) {
            return GarbManagerDelegate.INSTANCE.obtainDefault();
        }
        try {
            Garb garb = (Garb) JSON.parseObject(FileUtils.readFileToString(confFile), Garb.class);
            if (garb != null) {
                return garb;
            }
            return Garb.Companion.obtainDefault();
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "Read garb config error! Return default Garb", e);
            FileUtils.deleteQuietly(confFile);
            return Garb.Companion.obtainDefault();
        }
    }

    public static /* synthetic */ void clearOpGarb$default(GarbStorageHelper garbStorageHelper, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        garbStorageHelper.clearOpGarb(context, z);
    }

    public final void clearOpGarb(Context context, boolean currentIsNight) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (currentIsNight) {
        }
    }

    public final void clearGarbRes(Context context, Garb garb) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(garb, DIR_NAME);
        FileUtils.deleteQuietly(new File(buildGarbDirName(context, garb)));
    }

    private final Garb readOpGarb(Context context) {
        File confFile = new File(buildDirName(context), CONF_NAME);
        if (confFile.exists()) {
            try {
                return (Garb) JSON.parseObject(FileUtils.readFileToString(confFile), Garb.class);
            } catch (Exception e) {
                BLog.e(GarbManagerDelegateKt.TAG, "Read garb config error! Return default Garb", e);
                return null;
            }
        }
        return null;
    }

    public final boolean isResValid(GarbData.GarbDetail garbDetail) {
        File[] assets;
        Intrinsics.checkNotNullParameter(garbDetail, "garbDetail");
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        File dir = new File(buildZipDirName(context, garbDetail));
        if (dir.exists() && dir.isDirectory() && (assets = dir.listFiles()) != null) {
            if (!(assets.length == 0)) {
                return true;
            }
        }
        return false;
    }

    public final void setShowDialogGarbId(Context context, long garbId) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putLong(PREF_GARB_SHOW_DIALOG_ID, garbId).apply();
    }

    public final long getShowDialogGarbId() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getLong(PREF_GARB_SHOW_DIALOG_ID, 0L);
    }

    public final void cleanOldAsset(final Context context, final GarbData.GarbDetail garbDetail) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(garbDetail, "garbDetail");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit cleanOldAsset$lambda$0;
                cleanOldAsset$lambda$0 = GarbStorageHelper.cleanOldAsset$lambda$0(context, garbDetail);
                return cleanOldAsset$lambda$0;
            }
        });
    }

    public static final Unit cleanOldAsset$lambda$0(Context $context, GarbData.GarbDetail $garbDetail) {
        File garbDir = new File(INSTANCE.buildGarbDirName($context, $garbDetail));
        File[] assetDirs = garbDir.listFiles(new FileFilter() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$$ExternalSyntheticLambda2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                boolean cleanOldAsset$lambda$0$0;
                cleanOldAsset$lambda$0$0 = GarbStorageHelper.cleanOldAsset$lambda$0$0(file);
                return cleanOldAsset$lambda$0$0;
            }
        });
        if (assetDirs != null) {
            if (!(assetDirs.length == 0)) {
                for (File dir : assetDirs) {
                    if (!Intrinsics.areEqual(dir.getName(), String.valueOf($garbDetail.getVer()))) {
                        FileUtils.deleteDirectory(dir);
                    }
                }
                BLog.i(GarbManagerDelegateKt.TAG, "clean old asset success!");
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public static final boolean cleanOldAsset$lambda$0$0(File file) {
        if (file != null) {
            return file.isDirectory();
        }
        return false;
    }

    public final void saveLastOpGarb(Context context, long id) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putLong(PREF_GARB_LAST_OP_GARB_ID, id).apply();
    }

    public final long getLastOpGarb(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getLong(PREF_GARB_LAST_OP_GARB_ID, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0033, code lost:
        if (r5 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void saveGarbChanged(Context context, Garb garb) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor putBoolean = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_GARB_HAS_CHANGED, garb != null);
        String str4 = null;
        if (garb != null) {
            if (garb.isPure()) {
                str = garb.getColorName();
            } else {
                str = String.valueOf(garb.getId());
            }
        }
        str = null;
        SharedPreferences.Editor putString = putBoolean.putString(PREF_TARGET_GARB_THEME_ID, str);
        if (garb == null || (str2 = String.valueOf(true ^ garb.getChangeable())) == null) {
            str2 = null;
        }
        SharedPreferences.Editor putString2 = putString.putString(PREF_TARGET_GARB_CHANGEABLE, str2);
        if (garb != null) {
            if (garb.isPure()) {
                str3 = GarbJsBridgeCallHandlerKt.PURE_THEME;
            } else {
                str3 = GarbJsBridgeCallHandlerKt.GARB_THEME;
            }
            str4 = str3;
        }
        putString2.putString(PREF_TARGET_GARB_TYPE, str4).apply();
    }

    public final boolean isGarbChanged(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_GARB_HAS_CHANGED, false);
    }

    public final String getTargetGarbThemeId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_TARGET_GARB_THEME_ID, null);
    }

    public final String getTargetGarbChangeable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_TARGET_GARB_CHANGEABLE, null);
    }

    public final String getTargetGarbType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_TARGET_GARB_TYPE, null);
    }

    public final boolean isGarbInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean exist = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).contains(PREF_GARB_INITIALIZED);
        BLog.i(GarbManagerDelegateKt.TAG, "garb config exist: " + exist);
        if (exist) {
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_GARB_INITIALIZED, false);
        }
        File confFile = new File(buildDirName(context), CONF_NAME);
        if (!confFile.exists()) {
            return false;
        }
        BLog.i(GarbManagerDelegateKt.TAG, "garb config exist, set initialized true");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_GARB_INITIALIZED, true).apply();
        return true;
    }

    public final void saveGarbInitialized(Context context, boolean status) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_GARB_INITIALIZED, status).apply();
    }
}