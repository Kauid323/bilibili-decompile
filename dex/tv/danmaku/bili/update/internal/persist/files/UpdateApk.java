package tv.danmaku.bili.update.internal.persist.files;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bilibili.app.updater.BuildConfig;
import com.bilibili.avatar.Avatar;
import com.bilibili.avatar.WalleChannelImpl;
import com.google.archivepatcher.applier.FileByFileV1DeltaApplier;
import com.meituan.android.walle.ChannelWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.config.OnlineParams;
import tv.danmaku.bili.update.internal.exception.Errors;
import tv.danmaku.bili.update.internal.exception.UpdateError;
import tv.danmaku.bili.update.internal.json.JsonParserKt;
import tv.danmaku.bili.update.internal.network.download.UpdatePatchHelper;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.model.Patch;
import tv.danmaku.bili.update.utils.FileUtils;
import tv.danmaku.bili.update.utils.IOUtils;
import tv.danmaku.bili.update.utils.PackageUtilsKt;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.bili.update.utils.StringsKt;

public class UpdateApk {
    public static final int ANDROID_R = 30;
    private static final String APK_SUFFIX = ".apk";
    private static final int ERROR_CHANNEL_EXISTING = 3001;
    private static final String INFO_SUFFIX = ".infofawkes";
    private static final String PATCH_SUFFIX = ".patch";
    private static final String PROVIDER_AUTHORITIES_SUFFIX = ".updater.fileprovider";
    private static final String TAG = "fawkes.update.apk";
    private static final String UPDATE_DIR = "update";
    public static final boolean DEBUG = BuildConfig.DEBUG;
    private static final String NO_ID = "KAE";
    private static String sOldId = NO_ID;

    public static void cleanApkDir(Context context, boolean all) {
        if (isNeedAdaptAndroidR()) {
            cleanDownloadDir(getDownloadDirOnAndroidR(context), all);
        }
        cleanDownloadDir(getDownloadDir(context), all);
    }

    private static void cleanDownloadDir(File dir, boolean all) {
        String version;
        if (dir == null) {
            return;
        }
        if (all) {
            try {
                FileUtils.cleanDirectory(dir);
                return;
            } catch (Exception e) {
                return;
            }
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            try {
                String fname = file.getName();
                version = fname.split("\\.")[0];
            } catch (Exception e2) {
            }
            if (Integer.parseInt(version) > RuntimeHelper.versionCode()) {
                continue;
            } else {
                FileUtils.deleteQuietly(file);
                return;
            }
        }
    }

    public static boolean isNeedAdaptAndroidR() {
        return isAndroidRAndAbove() && OnlineParams.getAdapterAndroidR();
    }

    public static boolean isAndroidRAndAbove() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static File getApkDir(Context context) {
        File downloadDir;
        if (isNeedAdaptAndroidR()) {
            downloadDir = getDownloadDirOnAndroidR(context);
        } else {
            downloadDir = getDownloadDir(context);
        }
        if (downloadDir == null) {
            return null;
        }
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        return downloadDir;
    }

    private static File getDownloadDirOnAndroidR(Context context) {
        return new File(context.getFilesDir(), UPDATE_DIR);
    }

    private static File getDownloadDir(Context context) {
        return context.getExternalFilesDir(UPDATE_DIR);
    }

    public static BiliUpgradeInfo getExistingForceUpdate(Context context) throws Exception {
        File dir = getApkDir(context);
        if (dir == null) {
            throw new FileNotFoundException();
        }
        File[] files = dir.listFiles();
        int length = files.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            File file = files[i];
            String fileName = file.getName();
            if (fileName.endsWith(INFO_SUFFIX)) {
                String version = fileName.split("\\.")[0];
                if (Integer.parseInt(version) > RuntimeHelper.versionCode()) {
                    FileInputStream input = new FileInputStream(file);
                    try {
                        BiliUpgradeInfo info = (BiliUpgradeInfo) JsonParserKt.parseObject(IOUtils.toString(input), BiliUpgradeInfo.class);
                        IOUtils.closeQuietly(input);
                        if (info.forceUpgrade()) {
                            return info;
                        }
                    } catch (Throwable th) {
                        IOUtils.closeQuietly(input);
                        throw th;
                    }
                }
            }
            i++;
        }
        throw new FileNotFoundException();
    }

    public static BiliUpgradeInfo getDownloadedUpdate(Context context) throws Exception {
        BiliUpgradeInfo info = null;
        File dir = getApkDir(context);
        if (dir == null) {
            throw new FileNotFoundException();
        }
        File[] files = dir.listFiles();
        int length = files.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            File file = files[i];
            String fname = file.getName();
            if (file.getName().endsWith(INFO_SUFFIX)) {
                String version = fname.split("\\.")[0];
                if (Integer.parseInt(version) > RuntimeHelper.versionCode()) {
                    FileInputStream input = new FileInputStream(file);
                    try {
                        info = (BiliUpgradeInfo) JsonParserKt.parseObject(IOUtils.toString(input), BiliUpgradeInfo.class);
                        break;
                    } finally {
                        IOUtils.closeQuietly(input);
                    }
                }
            }
            i++;
        }
        if (info == null || info.versionCode() <= RuntimeHelper.versionCode()) {
            try {
                FileUtils.cleanDirectory(dir);
            } catch (Exception e) {
            }
            throw new FileNotFoundException("No downloaded apk!");
        }
        File destFile = new File(dir, getFname(info));
        if (destFile.exists()) {
            PackageInfo archiveInfo = PackageUtilsKt.getPackageArchiveInfo(context, destFile.getAbsolutePath(), 0);
            if (archiveInfo.versionCode >= info.versionCode()) {
                info.setApkPath(destFile);
                return info;
            }
            destFile.delete();
            BLog.w(TAG, "clean wrong version apk! expect " + info.versionCode() + ", but " + archiveInfo.versionCode);
        }
        throw new FileNotFoundException("Cannot find matched downloaded apk!");
    }

    public static boolean enableIncremental(Context context) {
        if (context == null) {
            return false;
        }
        return true;
    }

    public static File getDestFile(Context context, BiliUpgradeInfo info) {
        File dir = getApkDir(context);
        if (dir == null) {
            return null;
        }
        return new File(dir, getFname(info));
    }

    public static File getOldApkFile(Context context) {
        File dir = getApkDir(context);
        if (dir == null) {
            return null;
        }
        return new File(dir, RuntimeHelper.versionCode() + ".origin.apk");
    }

    @Deprecated
    public static String getOldApkManifestId(Context context) {
        if (NO_ID.equals(sOldId)) {
            synchronized (UpdateApk.class) {
                if (NO_ID.equals(sOldId)) {
                    sOldId = getApkManifestId(new File(context.getApplicationInfo().sourceDir));
                }
            }
        }
        return sOldId;
    }

    public static String getApkManifestId(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String md5 = null;
        Reader in = null;
        try {
            ZipFile apk = new ZipFile(file);
            ZipEntry certEntry = apk.getEntry("META-INF/CERT.SF");
            if (certEntry == null) {
                Enumeration<? extends ZipEntry> entries = apk.entries();
                while (true) {
                    if (!entries.hasMoreElements()) {
                        break;
                    }
                    ZipEntry entry = entries.nextElement();
                    if (!entry.isDirectory()) {
                        String name = entry.getName();
                        if (name != null && name.startsWith("META-INF/") && name.endsWith(".SF")) {
                            certEntry = entry;
                            break;
                        }
                    }
                }
            }
            if (certEntry != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(apk.getInputStream(certEntry)));
                in = reader;
                while (true) {
                    String line = reader.readLine();
                    if (line != null) {
                        if (line != null && line.contains("Digest-Manifest:")) {
                            md5 = StringsKt.substringAfter(line, "Digest-Manifest:", line).trim();
                            BLog.v(TAG, "Digest Manifest = " + md5);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            IOUtils.closeQuietly(in);
            apk.close();
        } catch (Exception e) {
        }
        return md5;
    }

    public static File getPatchFile(Context context, BiliUpgradeInfo info) {
        File dir;
        if (info.getPatch() == null || (dir = getApkDir(context)) == null) {
            return null;
        }
        return new File(dir, info.versionCode() + "." + info.getPatch().getMd5() + PATCH_SUFFIX);
    }

    public static File getPreferPatchFile(Context context, BiliUpgradeInfo info) {
        Patch patchInfo;
        File dir;
        if (info.getPatch_map().size() == 0 || (patchInfo = UpdatePatchHelper.getPreferPatch(info)) == null || (dir = getApkDir(context)) == null) {
            return null;
        }
        return new File(dir, info.versionCode() + "." + patchInfo.getMd5() + UpdatePatchHelper.getPreferPatchSuffix());
    }

    public static File getPatchItemPath(Context context, BiliUpgradeInfo info, Patch patchInfo, String suffix) {
        File dir = getApkDir(context);
        if (dir == null) {
            return null;
        }
        return new File(dir, info.versionCode() + "." + patchInfo.getMd5() + "." + suffix);
    }

    public static List<File> getPatchFileList(Context context, BiliUpgradeInfo info) {
        File dir;
        if (info.getPatch_map().size() == 0 || (dir = getApkDir(context)) == null) {
            return null;
        }
        List<File> result = new ArrayList<>();
        Map<String, Patch> patchMap = info.getPatch_map();
        for (String key : patchMap.keySet()) {
            Patch patch = patchMap.get(key);
            if (patch != null) {
                File item = new File(dir, info.versionCode() + "." + patch.getMd5() + "." + key);
                result.add(item);
            }
        }
        return result;
    }

    public static File prepareOldApkFile(Context context) throws UpdateError {
        File file = getOldApkFile(context);
        if (file == null) {
            throw new UpdateError("Dir is null?", 2011);
        }
        FileUtils.deleteQuietly(file);
        return createOldApkFile(context, file);
    }

    private static File createOldApkFile(Context context, File file) throws UpdateError {
        ApplicationInfo info = context.getApplicationInfo();
        File apk = new File(info.sourceDir);
        File tmp = new File(file.getAbsolutePath() + ".tmp");
        try {
            try {
                FileUtils.copyFile(apk, tmp);
                removeChannelInfo(tmp);
                FileUtils.moveFile(tmp, file);
                return file;
            } finally {
                FileUtils.deleteQuietly(tmp);
            }
        } catch (IOException | Avatar.AvatarError e) {
            BLog.w(TAG, "Prepare old apk fail", e);
            FileUtils.deleteQuietly(file);
            throw new UpdateError(e.getMessage(), 2011);
        }
    }

    public static void writeInfo(Context context, BiliUpgradeInfo info) {
        File dir = getApkDir(context);
        if (dir == null) {
            return;
        }
        File infoFile = new File(dir, getFname(info) + INFO_SUFFIX);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(infoFile);
            String data = JsonParserKt.toJSONString(info);
            if (data != null) {
                fos.write(data.getBytes());
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            IOUtils.closeQuietly(fos);
            throw th;
        }
        IOUtils.closeQuietly(fos);
    }

    private static String getFname(BiliUpgradeInfo info) {
        return info.versionCode() + APK_SUFFIX;
    }

    public static boolean checkValidity(Context context, BiliUpgradeInfo info, File file) {
        if (!file.exists() || info == null) {
            BLog.e(TAG, "Fail, file not exist");
            return false;
        } else if (file.length() != info.getSize()) {
            BLog.e(TAG, "Fail, file length invalid, length = " + file.length());
            return false;
        } else if (!file.getName().equals(getFname(info))) {
            BLog.e(TAG, "Fail, file name invalid: " + file.getName());
            return false;
        } else {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 64);
            if (packageInfo == null) {
                BLog.e(TAG, "fail, can not get file package info");
                return false;
            }
            String sign = FileUtils.md5(file);
            if (TextUtils.isEmpty(sign) || !sign.equalsIgnoreCase(info.getMd5())) {
                BLog.e(TAG, "fail, file sign invalid, sign = " + sign);
                return false;
            } else if (!TextUtils.equals(packageInfo.packageName, context.getPackageName())) {
                BLog.e(TAG, "fail, file package name invalid, name = " + String.valueOf(packageInfo.packageName));
                return false;
            } else {
                return true;
            }
        }
    }

    public static void archivePatch(File oldFile, File newFile, File patchFile) throws UpdateError {
        InputStream in = null;
        OutputStream out = null;
        Inflater uncompressor = new Inflater(true);
        try {
            try {
                FileInputStream compressedPatchIn = new FileInputStream(patchFile);
                in = new InflaterInputStream(compressedPatchIn, uncompressor, 10240);
                out = new BufferedOutputStream(new FileOutputStream(newFile));
                new FileByFileV1DeltaApplier().applyDelta(oldFile, in, out);
            } catch (IOException e) {
                throw new UpdateError("Apply patch error.", e, Errors.ERROR_PATCH_FAIL);
            }
        } finally {
            uncompressor.end();
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }

    public static void attachChannelInfo(File apkFile, boolean isGray) {
        try {
            writeChannelInfo(apkFile, RuntimeHelper.channel(), Boolean.valueOf(isGray));
        } catch (Exception e) {
            BLog.w("Write channel info error.", e);
        }
    }

    static void writeChannelInfo(File apkFile, String newChannel, Boolean isGray) throws Exception {
        Map<String, String> extra = new HashMap<>();
        extra.put("is_gray", String.valueOf(isGray));
        ChannelWriter.put(apkFile, newChannel, extra);
    }

    static void removeChannelInfo(File apkFile) throws Avatar.AvatarError {
        Avatar.with(WalleChannelImpl.class).removeChannel(apkFile);
    }

    public static void installApk(Context context, File path) {
        PrefsHelperKt.setInternalUpdate(context);
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + PROVIDER_AUTHORITIES_SUFFIX, path);
                intent.setDataAndType(uri, "application/vnd.android.package-archive");
                intent.addFlags(1);
                intent.addFlags(268435456);
                context.startActivity(intent);
                forceRestart();
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.fromFile(path));
            intent2.addFlags(268435456);
            intent2.addFlags(1);
            intent2.setClassName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity");
            context.startActivity(intent2);
        } catch (Exception e) {
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setDataAndType(Uri.fromFile(path), "application/vnd.android.package-archive");
            intent3.addFlags(268435456);
            intent3.addFlags(1);
            context.startActivity(intent3);
        }
    }

    private static void forceRestart() {
        if (OnlineParams.getForceRestart()) {
            Process.killProcess(Process.myPid());
        }
    }
}