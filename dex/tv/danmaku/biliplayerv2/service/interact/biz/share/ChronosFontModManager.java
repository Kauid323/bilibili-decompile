package tv.danmaku.biliplayerv2.service.interact.biz.share;

import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosFontModManager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/share/ChronosFontModManager;", "", "<init>", "()V", "TAG", "", "POOL_NAME", "MOD_NAME", "FILE_NAME", "mEnableUseChronosDrawDm", "", "mEnableUseRecommendFont", "mIsFirstStart", "mFontPath", "mFontFilePath", "mIsChecking", "init", "", "chronosFontsDir", "update", "useRecommendFont", "checkFontFile", "copyFileToCacheDir", "srcPath", "destPath", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosFontModManager {
    private static final String FILE_NAME = "SourceHanSansCN-Regular.otf";
    public static final ChronosFontModManager INSTANCE = new ChronosFontModManager();
    private static final String MOD_NAME = "font";
    private static final String POOL_NAME = "danmaku";
    private static final String TAG = "ChronosFontModManager";
    private static final boolean mEnableUseChronosDrawDm;
    private static final boolean mEnableUseRecommendFont;
    private static String mFontFilePath;
    private static String mFontPath;
    private static volatile boolean mIsChecking;
    private static final boolean mIsFirstStart;

    private ChronosFontModManager() {
    }

    static {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("chronos_enable_dfm_v3", false);
        mEnableUseChronosDrawDm = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = (Boolean) ConfigManager.Companion.ab().get("danmaku_setting_use_recommend_font", false);
        mEnableUseRecommendFont = bool2 != null ? bool2.booleanValue() : false;
        mIsFirstStart = EnvironmentManager.getInstance().isFirstStart();
    }

    public final void init(String chronosFontsDir) {
        if (chronosFontsDir != null) {
            mFontPath = chronosFontsDir;
            mFontFilePath = chronosFontsDir + File.separator + FILE_NAME;
        }
    }

    public final void update() {
        checkFontFile();
    }

    private final boolean useRecommendFont() {
        return mEnableUseChronosDrawDm && mEnableUseRecommendFont && mIsFirstStart;
    }

    private final void checkFontFile() {
        boolean z = mEnableUseChronosDrawDm;
        boolean z2 = mEnableUseRecommendFont;
        BLog.i(TAG, "check font file, ffkey useChronosDrawDm: " + z + ", useNewFont: " + z2 + ", isFirstStart " + mIsFirstStart);
        if (mIsChecking || !useRecommendFont()) {
            boolean useRecommendFont = useRecommendFont();
            BLog.i(TAG, "check font file failed, not satisfy useRecommendFont: " + useRecommendFont + " or is checking: " + mIsChecking);
            return;
        }
        mIsChecking = true;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.share.ChronosFontModManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ChronosFontModManager.checkFontFile$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkFontFile$lambda$0() {
        ModResource fontMod = ModResourceClient.getInstance().get(BiliContext.application(), POOL_NAME, MOD_NAME);
        Intrinsics.checkNotNullExpressionValue(fontMod, "get(...)");
        if (fontMod.isAvailable()) {
            File fontFile = fontMod.retrieveFile(FILE_NAME);
            if (fontFile != null) {
                BLog.i(TAG, "check font file succeed " + fontFile.getPath());
                INSTANCE.copyFileToCacheDir(fontFile.getPath(), mFontFilePath);
                return;
            }
            BLog.i(TAG, "check font file failed, couldn't find file");
            mIsChecking = false;
            return;
        }
        BLog.i(TAG, "check font file failed, mod not available");
        mIsChecking = false;
    }

    private final void copyFileToCacheDir(final String srcPath, final String destPath) {
        String str = srcPath;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            String str2 = destPath;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (!z) {
                final File scrFile = new File(srcPath);
                if (!scrFile.exists() || !scrFile.isFile()) {
                    BLog.i(TAG, "copyFileToCacheDir failed, cause source file not exists!");
                    mIsChecking = false;
                    return;
                }
                HandlerThreads.runOn(3, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.share.ChronosFontModManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChronosFontModManager.copyFileToCacheDir$lambda$0(destPath, scrFile, srcPath);
                    }
                });
                return;
            }
        }
        BLog.i(TAG, "copyFileToCacheDir failed, srcPath (" + srcPath + ") or destPath (" + destPath + ") is null or empty");
        mIsChecking = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyFileToCacheDir$lambda$0(String $destPath, File $scrFile, String $srcPath) {
        File destFile;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            try {
                destFile = new File($destPath);
            } catch (Exception e) {
                BLog.e(TAG, "copy file to cache dir failed, cause " + e);
            }
            if (destFile.exists() && destFile.isFile()) {
                BLog.i(TAG, "copyFileToCacheDir succeed, target file already exists");
                mIsChecking = false;
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                mIsChecking = false;
                return;
            }
            long startTime = System.currentTimeMillis();
            fis = new FileInputStream($scrFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int it = fis.read(buffer);
                if (it == -1) {
                    break;
                }
                fos.write(buffer, 0, it);
            }
            fos.flush();
            fos.close();
            fis.close();
            BLog.i(TAG, "coy file succeed, cost time " + (System.currentTimeMillis() - startTime) + " ms, from " + $srcPath + " to " + $destPath);
            IOUtils.closeQuietly(fis);
            IOUtils.closeQuietly(fos);
            mIsChecking = false;
        } catch (Throwable th) {
            IOUtils.closeQuietly((InputStream) null);
            IOUtils.closeQuietly((OutputStream) null);
            mIsChecking = false;
            throw th;
        }
    }
}