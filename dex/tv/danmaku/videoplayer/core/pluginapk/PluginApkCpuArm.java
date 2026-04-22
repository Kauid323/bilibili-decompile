package tv.danmaku.videoplayer.core.pluginapk;

import android.content.Context;

public class PluginApkCpuArm extends PluginApk {
    private static PluginApkCpuArm mInstance;

    public static PluginApkCpuArm create(Context context) {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new PluginApkCpuArm(context);
        return mInstance;
    }

    private PluginApkCpuArm(Context context) {
        super(context, "plugins/arm.properties");
    }
}