package tv.danmaku.videoplayer.core.pluginapk;

import android.content.Context;
import com.bilibili.droid.SoLoaderShim;

public class PluginApkCpuX86Arm extends PluginApk {
    private static PluginApkCpuX86Arm mInstance;

    public static PluginApkCpuX86Arm create(Context context) {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new PluginApkCpuX86Arm(context);
        return mInstance;
    }

    private PluginApkCpuX86Arm(Context context) {
        super(context);
    }

    @Override // tv.danmaku.videoplayer.core.pluginapk.PluginApk
    public String getLibrayAbsPath(String libName) {
        return getLibraryAbsPathFromAPK("x86", libName);
    }

    @Override // tv.danmaku.videoplayer.core.pluginapk.PluginApk
    public void loadLibrary(String libName) {
        try {
            loadLibraryFromAPK("x86", libName);
        } catch (Exception e) {
            SoLoaderShim.loadLibrary(libName);
        }
    }
}