package tv.danmaku.player.plugin.mod;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.SoLoaderShim;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.plugin.extension.model.behavior.SoLibBehavior;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.CpuUtils;

public class IjkX86Helper {
    private static final String TAG = "plugin.ijkx86helper";
    public static SoLibBehavior sIjkX86;
    private static Boolean sIsX86Device;
    private static SoLoaderShim.DefaultHandler sSoLoader;

    public static void setSoLoader() {
        if (sSoLoader != null) {
            return;
        }
        if (DeviceDecision.INSTANCE.getBoolean("player.disable_x86_sdk2", true)) {
            BLog.i("disable x86 sdk, FINGERPRINT:${Build.FINGERPRINT} MODEL:${Build.MODEL} BRAND:${Build.BRAND} MANUFACTURER:${Build.MANUFACTURER}");
            return;
        }
        sSoLoader = new SoLoaderShim.DefaultHandler() { // from class: tv.danmaku.player.plugin.mod.IjkX86Helper.1
            public void loadLibrary(String libName) {
                if (libName.equals("ijkffmpeg") || libName.equals("ijkplayer") || libName.equals("ijksdl") || libName.equals("xp2p")) {
                    if (IjkX86Helper.sIjkX86 != null) {
                        IjkX86Helper.load(IjkX86Helper.sIjkX86, libName);
                        return;
                    }
                    BLog.e(IjkX86Helper.TAG, "Can not load " + libName + ", boom!");
                }
                super.loadLibrary(libName);
            }

            public File findLibrary(String libName) {
                if (libName.equals("ijkffmpeg") || libName.equals("ijkplayer") || libName.equals("ijksdl") || libName.equals("xp2p")) {
                    if (IjkX86Helper.sIjkX86 != null) {
                        return IjkX86Helper.find(IjkX86Helper.sIjkX86, libName);
                    }
                    BLog.e(IjkX86Helper.TAG, "Can not find " + libName + ", boom!");
                }
                return super.findLibrary(libName);
            }
        };
        SoLoaderShim.setHandler(sSoLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void load(SoLibBehavior mBehavior, String name) {
        Set<File> files = mBehavior.getLibrary();
        for (File so : files) {
            if (so.getName().contains(name)) {
                System.load(so.getAbsolutePath());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File find(SoLibBehavior mBehavior, String name) {
        Set<File> files = mBehavior.getLibrary();
        for (File so : files) {
            if (so.getName().contains(name)) {
                return so;
            }
        }
        return null;
    }

    public static boolean isX86Device() {
        if (sIsX86Device != null) {
            return sIsX86Device.booleanValue();
        }
        sIsX86Device = Boolean.valueOf(CpuUtils.isX86(BiliContext.application()));
        return sIsX86Device.booleanValue();
    }

    private static List<String> getCapableAbis(Context context) {
        ApplicationInfo appInfo = context.getApplicationInfo();
        Set<String> apkAbis = new HashSet<>();
        List<String> buildAbis = new ArrayList<>();
        if (appInfo != null) {
            String apkPath = appInfo.sourceDir;
            ZipFile zipFile = null;
            try {
                try {
                    try {
                        String startSymbol = "lib" + File.separator;
                        String endSymbol = String.valueOf(File.separator);
                        zipFile = new ZipFile(apkPath);
                        Enumeration entries = zipFile.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry zipEntry = entries.nextElement();
                            String path = zipEntry.getName();
                            if (path != null && !path.contains("../") && path.startsWith(startSymbol)) {
                                int start = path.indexOf(startSymbol) + startSymbol.length();
                                int end = path.indexOf(endSymbol, startSymbol.length());
                                if (end <= start || end >= path.length()) {
                                    BLog.w(TAG, "Substring bounded, length = " + path.length() + ", start = " + start + ", end = " + end);
                                } else {
                                    apkAbis.add(path.substring(start, end));
                                }
                            }
                        }
                        zipFile.close();
                    } catch (IOException e) {
                        BLog.w(TAG, e);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                    }
                } catch (Throwable th) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e2) {
                            BLog.w(TAG, e2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                BLog.w(TAG, e3);
            }
        }
        String[] abis = Build.SUPPORTED_ABIS;
        if (abis == null) {
            BLog.w(TAG, "Cpu abis is null.");
        } else {
            Collections.addAll(buildAbis, abis);
        }
        if (CpuUtils.isX86(BiliContext.application())) {
            buildAbis.add(0, "x86");
        }
        BLog.d(TAG, "Build cpu abis = " + buildAbis);
        BLog.d(TAG, "Apk cpu abis = " + apkAbis);
        if (apkAbis.size() > 0) {
            Iterator<String> iterator = buildAbis.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (!apkAbis.contains(next)) {
                    iterator.remove();
                }
            }
        }
        BLog.d(TAG, "Capable cpu abis = " + buildAbis);
        return buildAbis;
    }
}