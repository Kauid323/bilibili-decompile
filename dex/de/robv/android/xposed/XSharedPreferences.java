package de.robv.android.xposed;

import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import de.robv.android.xposed.services.FileResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public final class XSharedPreferences implements SharedPreferences {
    private static final String TAG = "XSharedPreferences";
    private static File sPackageBaseDirectory;
    private final File mFile;
    private long mFileSize;
    private final String mFilename;
    private long mLastModified;
    private boolean mLoaded;
    private Map<String, Object> mMap;

    static {
        sPackageBaseDirectory = null;
        if (System.getProperty("vxp") != null) {
            sPackageBaseDirectory = new File(System.getProperty("vxp_user_dir"));
        }
    }

    public static void setPackageBaseDirectory(File file) {
        if (sPackageBaseDirectory != null && !sPackageBaseDirectory.equals(file)) {
            throw new IllegalStateException("you can only set package base dir once, p: " + sPackageBaseDirectory + " n:" + file);
        }
        sPackageBaseDirectory = file;
    }

    public XSharedPreferences(File prefFile) {
        this.mLoaded = false;
        this.mFile = prefFile;
        this.mFilename = this.mFile.getAbsolutePath();
        startLoadFromDisk();
    }

    public XSharedPreferences(String packageName) {
        this(packageName, packageName + "_preferences");
    }

    public XSharedPreferences(String packageName, String prefFileName) {
        this.mLoaded = false;
        if (sPackageBaseDirectory == null) {
            this.mFile = new File(Environment.getDataDirectory(), "data/" + packageName + "/shared_prefs/" + prefFileName + ".xml");
        } else {
            this.mFile = new File(sPackageBaseDirectory, packageName + "/shared_prefs/" + prefFileName + ".xml");
        }
        this.mFilename = this.mFile.getAbsolutePath();
        startLoadFromDisk();
    }

    public boolean makeWorldReadable() {
        if (SELinuxHelper.getAppDataFileService().hasDirectFileAccess() && this.mFile.exists()) {
            return this.mFile.setReadable(true, false);
        }
        return false;
    }

    public File getFile() {
        return this.mFile;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [de.robv.android.xposed.XSharedPreferences$1] */
    private void startLoadFromDisk() {
        synchronized (this) {
            this.mLoaded = false;
        }
        new Thread("XSharedPreferences-load") { // from class: de.robv.android.xposed.XSharedPreferences.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (XSharedPreferences.this) {
                    XSharedPreferences.this.loadFromDiskLocked();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (this.mLoaded) {
            return;
        }
        Map map = null;
        FileResult result = null;
        try {
            try {
                try {
                    result = SELinuxHelper.getAppDataFileService().getFileInputStream(this.mFilename, this.mFileSize, this.mLastModified);
                    if (result.stream != null) {
                        map = XmlUtils.readMapXml(result.stream);
                        result.stream.close();
                    } else {
                        map = this.mMap;
                    }
                } catch (Exception e2) {
                }
            } catch (FileNotFoundException e3) {
                if (0 != 0 && result.stream != null) {
                    try {
                        result.stream.close();
                    } catch (RuntimeException rethrown) {
                        throw rethrown;
                    }
                }
            } catch (IOException e4) {
                Log.w(TAG, "getSharedPreferences", e4);
                if (0 != 0 && result.stream != null) {
                    try {
                        result.stream.close();
                    } catch (RuntimeException rethrown2) {
                        throw rethrown2;
                    }
                }
            } catch (XmlPullParserException e5) {
                Log.w(TAG, "getSharedPreferences", e5);
                if (0 != 0 && result.stream != null) {
                    try {
                        result.stream.close();
                    } catch (RuntimeException rethrown3) {
                        throw rethrown3;
                    }
                }
            }
            if (result != null && result.stream != null) {
                try {
                    result.stream.close();
                } catch (RuntimeException rethrown4) {
                    throw rethrown4;
                }
            }
            this.mLoaded = true;
            if (map != null) {
                this.mMap = map;
                this.mLastModified = result.mtime;
                this.mFileSize = result.size;
            } else {
                this.mMap = new HashMap();
            }
            notifyAll();
        } catch (Throwable rethrown5) {
            if (0 != 0 && result.stream != null) {
                try {
                    result.stream.close();
                } catch (RuntimeException rethrown6) {
                    throw rethrown6;
                } catch (Exception e6) {
                }
            }
            throw rethrown5;
        }
    }

    public synchronized void reload() {
        if (hasFileChanged()) {
            startLoadFromDisk();
        }
    }

    public synchronized boolean hasFileChanged() {
        boolean z;
        z = true;
        try {
            FileResult result = SELinuxHelper.getAppDataFileService().statFile(this.mFilename);
            if (this.mLastModified == result.mtime) {
                if (this.mFileSize == result.size) {
                    z = false;
                }
            }
        } catch (FileNotFoundException e2) {
            return true;
        } catch (IOException e3) {
            Log.w(TAG, "hasFileChanged", e3);
            return true;
        }
        return z;
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                wait();
            } catch (InterruptedException e2) {
            }
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        synchronized (this) {
            awaitLoadedLocked();
            hashMap = new HashMap(this.mMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public String getString(String key, String defValue) {
        String str;
        synchronized (this) {
            awaitLoadedLocked();
            String v = (String) this.mMap.get(key);
            str = v != null ? v : defValue;
        }
        return str;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String key, Set<String> defValues) {
        Set<String> set;
        synchronized (this) {
            awaitLoadedLocked();
            Set<String> v = (Set) this.mMap.get(key);
            set = v != null ? v : defValues;
        }
        return set;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defValue) {
        int intValue;
        synchronized (this) {
            awaitLoadedLocked();
            Integer v = (Integer) this.mMap.get(key);
            intValue = v != null ? v.intValue() : defValue;
        }
        return intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defValue) {
        long longValue;
        synchronized (this) {
            awaitLoadedLocked();
            Long v = (Long) this.mMap.get(key);
            longValue = v != null ? v.longValue() : defValue;
        }
        return longValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defValue) {
        float floatValue;
        synchronized (this) {
            awaitLoadedLocked();
            Float v = (Float) this.mMap.get(key);
            floatValue = v != null ? v.floatValue() : defValue;
        }
        return floatValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defValue) {
        boolean booleanValue;
        synchronized (this) {
            awaitLoadedLocked();
            Boolean v = (Boolean) this.mMap.get(key);
            booleanValue = v != null ? v.booleanValue() : defValue;
        }
        return booleanValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        boolean containsKey;
        synchronized (this) {
            awaitLoadedLocked();
            containsKey = this.mMap.containsKey(key);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public SharedPreferences.Editor edit() {
        throw new UnsupportedOperationException("read-only implementation");
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }
}