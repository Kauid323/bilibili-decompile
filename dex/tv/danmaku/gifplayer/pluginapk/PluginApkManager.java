package tv.danmaku.gifplayer.pluginapk;

import android.content.Context;
import com.bilibili.droid.BuildHelper;
import java.io.File;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.CpuUtils;

public class PluginApkManager {
    public static final String ASSET_ARM = "plugins/arm.properties";
    public static final String TAG = PluginApkManager.class.getName();

    public static PluginApk getSuitablePackage(Context context) {
        boolean archIsX86 = false;
        try {
            if (!BuildHelper.supportX86()) {
                boolean isX86 = CpuUtils.isX86(context);
                archIsX86 = isX86;
                if (!isX86) {
                    if (BuildHelper.supportARMv7a()) {
                        return PluginApkCpuArmv7a.create(context);
                    }
                    return PluginApkCpuArm.create(context);
                }
            }
            if (archIsX86) {
                return PluginApkCpuX86Arm.create(context);
            }
            return PluginApkCpuX86.create(context);
        } catch (Exception e) {
            return PluginApkCpuArmv7a.create(context);
        }
    }

    public static void loadLibrary(Context context, String libName) {
        PluginApk pluginApk = getSuitablePackage(context);
        BLog.i(TAG, "loadLibrary " + libName);
        pluginApk.loadLibrary(libName);
    }

    public static File findLibrary(Context context, String libName) {
        PluginApk pluginApk = getSuitablePackage(context);
        BLog.i(TAG, "findLibrary " + libName);
        return pluginApk.findLibrary(libName);
    }
}