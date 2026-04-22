package tv.danmaku.videoplayer.core.pluginapk;

import android.content.Context;
import com.bilibili.droid.SoLoaderShim;
import java.io.File;

public class PluginApkCpuX86 extends PluginApk {
    private static PluginApkCpuX86 mInstance;

    public static PluginApkCpuX86 create(Context context) {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new PluginApkCpuX86(context);
        return mInstance;
    }

    private PluginApkCpuX86(Context context) {
        super(context);
    }

    @Override // tv.danmaku.videoplayer.core.pluginapk.PluginApk
    public void loadLibrary(String libName) {
        SoLoaderShim.loadLibrary(libName);
    }

    @Override // tv.danmaku.videoplayer.core.pluginapk.PluginApk
    public File findLibrary(String libName) {
        return SoLoaderShim.findLibrary(libName);
    }
}