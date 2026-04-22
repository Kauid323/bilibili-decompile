package tv.danmaku.ijk.media.player.ffmpeg;

import java.io.File;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IjkJNILibManager;
import tv.danmaku.ijk.media.player.IjkLibLoader;

public class FFmpegApi {
    private static boolean sLibLoaded = false;
    private static IjkLibLoader sLibLoder = null;
    private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.ffmpeg.FFmpegApi.1
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(String libName) throws UnsatisfiedLinkError, SecurityException {
            System.loadLibrary(libName);
        }

        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public File findLibrary(String libName) {
            return null;
        }
    };

    private static native String _av_base64_encode(byte[] bArr);

    public static String av_base64_encode(byte[] in) {
        if (!sLibLoaded) {
            loadLibrary();
        }
        return _av_base64_encode(in);
    }

    @Deprecated
    public static int exec(String[] argv) {
        if (!sLibLoaded) {
            loadLibrary();
        }
        BLog.e("ffmpeg exec not support !");
        return -1;
    }

    private static void loadLibrary() {
        try {
            synchronized (FFmpegApi.class) {
                if (sLibLoaded) {
                    return;
                }
                String[] libNames = IjkJNILibManager.getInstance().getLoadLibs();
                String libPath = IjkJNILibManager.getInstance().getLibDir().getAbsolutePath();
                boolean isEnableFFmpegV2 = IjkJNILibManager.getInstance().isEnableFFmpegV2();
                for (int i = 0; i < libNames.length; i++) {
                    if (sLibLoder != null) {
                        BLog.i("FFmpegApi", "Load library " + libNames[i] + " for System .");
                        String libName = libNames[i];
                        if (libPath != null && isEnableFFmpegV2) {
                            libName = libPath + "/lib" + libName + ".so";
                            BLog.i("FFmpegApi", "Load library from path: " + libName);
                        }
                        System.load(libName);
                    } else {
                        BLog.i("FFmpegApi", "Load library " + libNames[i] + " for LocalLibLoader .");
                        sLocalLibLoader.loadLibrary(libNames[i]);
                    }
                }
                sLibLoaded = true;
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}