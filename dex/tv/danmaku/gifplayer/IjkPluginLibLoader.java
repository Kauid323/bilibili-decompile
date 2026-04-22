package tv.danmaku.gifplayer;

import android.content.Context;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkLibLoader;

public class IjkPluginLibLoader implements IjkLibLoader {
    private static IjkPluginLibLoader sInstance;
    private Context mAppContext;

    public static synchronized IjkPluginLibLoader getInstance(Context context) {
        IjkPluginLibLoader ijkPluginLibLoader;
        synchronized (IjkPluginLibLoader.class) {
            if (sInstance == null && context != null) {
                sInstance = new IjkPluginLibLoader(context);
            }
            ijkPluginLibLoader = sInstance;
        }
        return ijkPluginLibLoader;
    }

    private IjkPluginLibLoader(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    @Override // tv.danmaku.ijk.media.player.IjkLibLoader
    public void loadLibrary(String libName) throws UnsatisfiedLinkError, SecurityException {
        PluginApkManager.loadLibrary(this.mAppContext, libName);
    }

    @Override // tv.danmaku.ijk.media.player.IjkLibLoader
    public File findLibrary(String s) {
        return PluginApkManager.findLibrary(this.mAppContext, s);
    }
}