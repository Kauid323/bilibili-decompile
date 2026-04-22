package tv.danmaku.videoplayer.core.pluginapk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bilibili.droid.PackageManagerHelper;
import com.bilibili.lib.foundation.Foundation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import tv.danmaku.android.log.BLog;
import tv.danmaku.videoplayer.core.android.utils.PropertiesHelper;
import tv.danmaku.videoplayer.core.android.utils.ZipHelper;
import video.biz.offline.base.infra.utils.EntryScannerKt;

public abstract class PluginApk {
    public static final String PROP_DOWNLOAD_URL = "download_url";
    public static final String PROP_LATEST_VERSION_CODE = "latest_version_code";
    public static final String PROP_LATEST_VERSION_NAME = "latest_version_name";
    public static final String PROP_MARKET_URL = "market_url";
    public static final String PROP_MIN_VERSION_CODE = "min_version_code";
    public static final String PROP_NAME = "name";
    public static final String PROP_PACKAGE_NAME = "package_name";
    public static final String PROP_URL1 = "url1";
    public static final String PROP_URL1_TYPE = "url1_type";
    public static final String PROP_URL2 = "url2";
    public static final String PROP_URL2_TYPE = "url2_type";
    public static final String TAG = PluginApk.class.getName();
    public static final String VALUE_URL_TYPE__APK = "apk";
    public static final String VALUE_URL_TYPE__WEB = "web";
    protected String mApkMetaClassName;
    protected Context mContext;
    protected String mDownloadUrl;
    protected int mLatestVersionCode;
    protected String mLatestVersionName;
    protected String mMarketUrl;
    protected int mMinVersionCode;
    protected String mName;
    protected String mPackageName;
    protected String mPropFile;
    protected String mUrl1;
    protected String mUrl1Type;
    protected String mUrl2;
    protected String mUrl2Type;

    public PluginApk(Context context) {
        this.mContext = context;
    }

    public PluginApk(Context context, String propFile) {
        this.mPropFile = propFile;
        try {
            Properties prop = PropertiesHelper.createFromAsset(context, this.mPropFile);
            this.mName = PropertiesHelper.getString(prop, "name");
            this.mPackageName = PropertiesHelper.getString(prop, "package_name");
            this.mMinVersionCode = PropertiesHelper.getInt(prop, "min_version_code", -1);
            this.mLatestVersionCode = PropertiesHelper.getInt(prop, "latest_version_code", -1);
            this.mLatestVersionName = PropertiesHelper.getString(prop, "latest_version_name");
            this.mUrl1 = PropertiesHelper.getString(prop, "url1");
            this.mUrl1Type = PropertiesHelper.getString(prop, "url1_type");
            this.mUrl2 = PropertiesHelper.getString(prop, "url2");
            this.mUrl2Type = PropertiesHelper.getString(prop, "url2_type");
            this.mDownloadUrl = PropertiesHelper.getString(prop, "download_url");
            this.mMarketUrl = PropertiesHelper.getString(prop, "market_url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mContext = context;
    }

    public void loadLibrary(String libName) {
        String absLibPath = getLibrayAbsPath(libName);
        BLog.d(TAG, "loadLibrary " + absLibPath);
        System.load(absLibPath);
    }

    public File findLibrary(String libName) {
        return null;
    }

    public void loadLibraryFromAPK(String abi, String libName) throws Exception {
        String libPath = getLibraryAbsPathFromAPK(abi, libName);
        if (libPath != null) {
            BLog.d(TAG, "loadLibrary " + libPath);
            System.load(libPath);
            return;
        }
        throw new FileNotFoundException(libName + "." + abi);
    }

    public String getLibrayAbsPath(String libName) {
        String mapLibraryName = System.mapLibraryName(libName);
        String dataDir = getInstalledPluginDataDir();
        if (dataDir == null) {
            dataDir = String.format("/data/data/%s", getPackageName());
        }
        File libDir = new File(dataDir, "lib");
        File libPath = new File(libDir, mapLibraryName);
        return libPath.getAbsolutePath();
    }

    public String getLibraryAbsPathFromAPK(String abi, String libName) {
        String zipFilePath = this.mContext.getPackageCodePath();
        String mappedLibName = System.mapLibraryName(libName);
        String zipEntry = "lib/" + abi + EntryScannerKt.PATH_SEPARATOR + mappedLibName;
        File filesDir = this.mContext.getFilesDir();
        int versionCode = Foundation.instance().getApps().getVersionCode();
        String destPath = String.format("%s/%d/lib/%s", filesDir.getAbsolutePath(), Integer.valueOf(versionCode), mappedLibName);
        if (ZipHelper.unzipEntry(zipFilePath, zipEntry, destPath)) {
            return destPath;
        }
        return null;
    }

    public String getInstalledPluginDataDir() {
        PackageInfo packageInfo = getInstalledPackageInfo();
        if (packageInfo == null) {
            return null;
        }
        String dataDir = packageInfo.applicationInfo.dataDir;
        if (TextUtils.isEmpty(dataDir)) {
            return null;
        }
        return dataDir;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getUrl1() {
        return this.mUrl1;
    }

    public String getUrl2() {
        return this.mUrl2;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public PackageInfo getInstalledPackageInfo() {
        if (this.mContext == null || TextUtils.isEmpty(this.mPackageName)) {
            return null;
        }
        return PackageManagerHelper.getPackageInfo(this.mContext, this.mPackageName, 128);
    }
}