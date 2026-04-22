package tv.danmaku.gifplayer.pluginapk;

import android.content.Context;
import com.bilibili.droid.SoLoaderShim;

public class PluginApkCpuArmv7a extends PluginApk {
    private static PluginApkCpuArmv7a mInstance;

    public static PluginApkCpuArmv7a create(Context context) {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new PluginApkCpuArmv7a(context);
        return mInstance;
    }

    private PluginApkCpuArmv7a(Context context) {
        super(context);
    }

    @Override // tv.danmaku.gifplayer.pluginapk.PluginApk
    public void loadLibrary(String libName) {
        SoLoaderShim.loadLibrary(libName);
    }
}