package tv.danmaku.ijk.media.player;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import tv.danmaku.android.log.BLog;

public class IjkJNILibManager {
    private static IjkJNILibManager sInstance = null;
    private boolean mEnableFFmpegV2;
    private final HashMap<String, String> mLoadedLibraries = new HashMap<>();
    private boolean mIsInit = false;
    private File mLibDir = null;

    private IjkJNILibManager() {
        this.mEnableFFmpegV2 = false;
        this.mLoadedLibraries.clear();
        this.mLoadedLibraries.put("ijkffmpeg", "ijkffmpeg_v2");
        this.mLoadedLibraries.put("ijkplayer", "ijkplayer_v2");
        this.mLoadedLibraries.put("ijksdl", "ijksdl_v2");
        this.mEnableFFmpegV2 = false;
    }

    public static IjkJNILibManager getInstance() {
        if (sInstance == null) {
            synchronized (IjkJNILibManager.class) {
                if (sInstance == null) {
                    sInstance = new IjkJNILibManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isEnableFFmpegV2() {
        BLog.i("IjkJNILibManager", "isEnableFFmpegV2: mEnableFFmpegV2 = " + this.mEnableFFmpegV2);
        return this.mEnableFFmpegV2;
    }

    public void init(boolean enableNewFFmpeg) {
        BLog.i("IjkJNILibManager", "init: enable_new_ffmpeg = " + enableNewFFmpeg);
        if (this.mIsInit) {
            BLog.w("IjkJNILibManager", "lib already init, ignore");
            return;
        }
        this.mEnableFFmpegV2 = enableNewFFmpeg;
        BLog.i("IjkJNILibManager", "init: mEnableFFmpegV2 = " + this.mEnableFFmpegV2 + " end");
    }

    public void init(boolean enableNewFFmpeg, File libDir) {
        BLog.i("IjkJNILibManager", "init: enable_new_ffmpeg = " + enableNewFFmpeg);
        if (this.mIsInit) {
            BLog.w("IjkJNILibManager", "lib already init, ignore");
            return;
        }
        this.mEnableFFmpegV2 = enableNewFFmpeg;
        this.mLibDir = libDir;
        BLog.i("IjkJNILibManager", "init: mLibDir = " + this.mLibDir + " end");
    }

    public String[] getLoadLibs() {
        this.mIsInit = true;
        if (this.mEnableFFmpegV2) {
            String[] libs = {"ijkffmpeg_v2", "ijksdl_v2", "ijkffext_v2", "ijkplayer_v2"};
            BLog.i("IjkJNILibManager", "getLoadLibs: " + Arrays.toString(libs));
            return libs;
        }
        String[] libs2 = {"ijkffmpeg", "ijksdl", "ijkffext", "ijkplayer"};
        BLog.i("IjkJNILibManager", "getLoadLibs: " + Arrays.toString(libs2));
        return libs2;
    }

    public String getLibName(String libName) {
        if (this.mEnableFFmpegV2) {
            return this.mLoadedLibraries.get(libName);
        }
        return libName;
    }

    public File getLibDir() {
        return this.mLibDir;
    }
}