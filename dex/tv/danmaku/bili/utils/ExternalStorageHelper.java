package tv.danmaku.bili.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.collection.ArrayMap;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.DisplaySizeHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.android.util.DebugLog;
import video.biz.offline.list.logic.tree.VideoFile;

public final class ExternalStorageHelper {
    private static final String MEDIA_EMULATE = "emulate";
    public static final String MEDIA_UNKOWN = "unkown";
    private static final long MIN_SIZE = 536870912;
    private static final String TAG_STORAGE = "storage";
    private static final String TAG_STORAGE_LIST = "StorageList";
    private static Method lstat;
    private static Object os;
    private static ExternalStorageHelper sHelperInstance;
    private static Field st_rdev;
    private Context mContext;
    private StorageVolume mPrimaryStorage;
    private StorageVolume mSecondaryStorage;
    private static final String TAG = ExternalStorageHelper.class.getSimpleName();
    private static String[] sIgnoreMountPointPrefixs = {"/system", "/cache", "/mnt/asec", "/tmp", "/mnt/shell", "/mnt/secure", "/protect", "/persist", "/firmware", "/vendor"};
    private static String[] sKownFileSystems = {"fat", "fuse", "ntfs", "sdcardfs"};
    private static String[] sIgnoreDevices = {"loop"};
    private static Comparator<StorageVolume> sVolumeComparator = new Comparator<StorageVolume>() { // from class: tv.danmaku.bili.utils.ExternalStorageHelper.1
        @Override // java.util.Comparator
        public int compare(StorageVolume lhs, StorageVolume rhs) {
            return lhs.equals(rhs) ? 0 : 1;
        }
    };
    private List<StorageVolume> mVolumes = new ArrayList();
    private Map<String, StorageVolume> mVolumesMap = new ArrayMap();
    private final Object mVolumesLock = new Object();
    private StringWriter mLogger = new StringWriter();

    private ExternalStorageHelper(Context context) {
        this.mContext = context.getApplicationContext();
        loadVolumeList(context);
    }

    public static ExternalStorageHelper getStorageHelper(Context context) {
        if (sHelperInstance == null) {
            synchronized (ExternalStorageHelper.class) {
                if (sHelperInstance == null) {
                    if (context == null) {
                        return null;
                    }
                    sHelperInstance = new ExternalStorageHelper(context);
                }
            }
        }
        return sHelperInstance;
    }

    public List<StorageVolume> getVolumeList() {
        return this.mVolumes;
    }

    public void mountedStorage(Intent intent) {
        Uri point = intent.getData();
        StorageVolume volume = new StorageVolume(new File(point.getPath()), point.getPath(), false, true, false);
        DebugLog.v(TAG, volume.getPath() + " mounted");
        this.mLogger.write("mounted volume:" + volume.getPath() + VideoFile.TREE_END);
        addVolume(volume);
    }

    public void ejectStorage(Intent intent) {
        Uri point = intent.getData();
        StorageVolume volume = new StorageVolume(new File(point.getPath()), point.getPath(), false, true, false);
        DebugLog.v(TAG, volume.getPath() + " eject");
        this.mLogger.write("eject volume:" + volume.getPath() + VideoFile.TREE_END);
        addVolume(volume);
    }

    private void loadVolumeList(Context context) {
        this.mLogger.write("start load volume list..\n");
        this.mVolumes.clear();
        this.mVolumesMap.clear();
        setPrimaryVolume();
        loadStorageWidthMounts();
        if (!isSecondaryExternalReady() && context != null) {
            readStorageList(context.getResources());
        }
        if (!isSecondaryExternalReady()) {
            loadVolumeListByVoldFstab();
        }
    }

    private void setPrimaryVolume() {
        File path = Environment.getExternalStorageDirectory();
        this.mPrimaryStorage = new StorageVolume(path, "Primary storage", true, Environment.isExternalStorageRemovable(), path.toString().contains(MEDIA_EMULATE));
        this.mLogger.write("setPrimaryVolume: " + this.mPrimaryStorage.getPath() + VideoFile.TREE_END);
        this.mVolumes.add(this.mPrimaryStorage);
        this.mVolumesMap.put(this.mPrimaryStorage.getPath(), this.mPrimaryStorage);
    }

    public StorageVolume getPrimary() {
        if (this.mPrimaryStorage == null) {
            synchronized (this.mVolumesLock) {
                if (this.mPrimaryStorage == null) {
                    setPrimaryVolume();
                }
            }
        }
        return this.mPrimaryStorage;
    }

    public StorageVolume getSecondary() {
        if (this.mSecondaryStorage == null) {
            synchronized (this.mVolumesLock) {
                if (this.mVolumes.isEmpty()) {
                    return null;
                }
                if (this.mSecondaryStorage == null) {
                    StorageVolume primary = getPrimary();
                    for (StorageVolume volume : this.mVolumes) {
                        if (!volume.equals(primary) && volume.getTotalSpace() >= 536870912 && (volume.mDevPath == null || !isDeviceIgnored(volume.mDevPath))) {
                            if (this.mSecondaryStorage == null) {
                                this.mSecondaryStorage = volume;
                            } else if (volume.getTotalSpace() > this.mSecondaryStorage.getTotalSpace()) {
                                this.mSecondaryStorage = volume;
                            }
                        }
                    }
                }
            }
        }
        return this.mSecondaryStorage;
    }

    public boolean isSecondaryExternalReady() {
        StorageVolume secondary = getSecondary();
        return secondary != null && "mounted".equals(getStorageState(secondary));
    }

    public boolean isPrimaryExternalReady() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public String getStorageState(StorageVolume volume) {
        if (volume == null) {
            return MEDIA_UNKOWN;
        }
        try {
            if (Environment.getExternalStorageDirectory().getCanonicalPath().startsWith(volume.getPath())) {
                return Environment.getExternalStorageState();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StorageManager sManager = (StorageManager) this.mContext.getSystemService(TAG_STORAGE);
        try {
            Method getState = StorageManager.class.getDeclaredMethod("getVolumeState", String.class);
            return (String) getState.invoke(sManager, volume.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                volume.checkStatFs();
                File file = volume.getPathFile();
                if (!file.canRead()) {
                    return volume.isRemovable() ? "removed" : MEDIA_UNKOWN;
                } else if (file.canWrite()) {
                    return "mounted";
                } else {
                    return "mounted_ro";
                }
            } catch (IllegalStorageException e3) {
                return MEDIA_UNKOWN;
            }
        }
    }

    private void loadVolumeListByVoldFstab() {
        String[] fields;
        int sysfsPathIndex;
        boolean removable;
        boolean primary;
        File file = new File("/etc/vold.fstab");
        if (!file.exists() || !file.canRead()) {
            return;
        }
        BufferedReader br = null;
        File primaryPath = Environment.getExternalStorageDirectory();
        this.mLogger.write("\n----start loadVolumeListByVoldFstab--\n");
        try {
            try {
                br = new BufferedReader(new FileReader(file));
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    } else if (line.length() != 0 && line.charAt(0) == 'd' && (fields = line.split("\\s+")) != null && fields.length > 3 && "dev_mount".equals(fields[0])) {
                        this.mLogger.write(line + VideoFile.TREE_END);
                        String label = fields[1];
                        String moutPoint = fields[2];
                        int i = 3;
                        while (true) {
                            if (i >= fields.length) {
                                sysfsPathIndex = 4;
                                break;
                            } else if (fields[i].charAt(0) != '/') {
                                i++;
                            } else {
                                int sysfsPathIndex2 = i;
                                sysfsPathIndex = sysfsPathIndex2;
                                break;
                            }
                        }
                        String part = fields[sysfsPathIndex - 1];
                        if ("auto".equals(part)) {
                            removable = true;
                        } else if (!TextUtils.isDigitsOnly(part) && !part.endsWith("@fat")) {
                            removable = false;
                        } else {
                            removable = false;
                        }
                        try {
                            boolean primary2 = primaryPath.getCanonicalPath().startsWith(moutPoint);
                            primary = primary2;
                        } catch (IOException e) {
                            primary = false;
                        }
                        StorageVolume volume = new StorageVolume(new File(moutPoint), label, primary, removable, false);
                        addVolume(volume);
                    }
                }
            } catch (FileNotFoundException e2) {
                this.mLogger.write("\nFileNotFoundException:" + e2.getMessage());
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.mLogger.write("\n---end loadVolumeListByVoldFstab\n");
        } finally {
            IOUtils.closeQuietly(br);
        }
    }

    static {
        init();
    }

    private void readStorageList(Resources resources) {
        this.mLogger.write("\n---start readStorageList--\n");
        try {
            Field field = Class.forName("com.android.internal.R$xml").getDeclaredField("storage_list");
            int id = field.getInt(null);
            readList(resources, id);
        } catch (Exception e) {
            this.mLogger.write("\nException:" + e.getMessage());
        }
        this.mLogger.write("\n---end readStorageList--\n");
    }

    private static final void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException {
        int type;
        do {
            type = parser.next();
            if (type == 2) {
                break;
            }
        } while (type != 1);
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!parser.getName().equals(firstElementName)) {
            throw new XmlPullParserException("Unexpected start tag: found " + parser.getName() + ", expected " + firstElementName);
        }
    }

    private static final void nextElement(XmlPullParser parser) throws XmlPullParserException, IOException {
        int type;
        do {
            type = parser.next();
            if (type == 2) {
                return;
            }
        } while (type != 1);
    }

    private void readList(Resources resources, int id) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        XmlResourceParser parser = resources.getXml(id);
        AttributeSet attrs = Xml.asAttributeSet(parser);
        try {
            try {
                beginDocument(parser, TAG_STORAGE_LIST);
                while (true) {
                    nextElement(parser);
                    String element = parser.getName();
                    if (element != null) {
                        if (TAG_STORAGE.equals(element)) {
                            Class<?> styleable = Class.forName("com.android.internal.R$styleable");
                            int[] storages = (int[]) styleable.getDeclaredField("Storage").get(null);
                            try {
                                TypedArray a = resources.obtainAttributes(attrs, storages);
                                CharSequence path = a.getText(getInt(styleable, "Storage_mountPoint"));
                                CharSequence description = a.getText(getInt(styleable, "Storage_storageDescription"));
                                boolean primary = a.getBoolean(getInt(styleable, "Storage_primary"), false);
                                boolean removable = a.getBoolean(getInt(styleable, "Storage_removable"), false);
                                boolean emulated = a.getBoolean(getInt(styleable, "Storage_emulated"), false);
                                this.mLogger.write("got volume: " + ((Object) path) + ", " + ((Object) description) + ", " + primary + VideoFile.TREE_END);
                                if (path != null && description != null) {
                                    StorageVolume volume = new StorageVolume(new File(path.toString()), description.toString(), primary, removable, emulated);
                                    addVolume(volume);
                                    a.recycle();
                                }
                                DebugLog.e(TAG, "path or description is null in readStorageList");
                                a.recycle();
                            } catch (IOException e) {
                                e = e;
                                throw new RuntimeException(e);
                            } catch (XmlPullParserException e2) {
                                e = e2;
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        parser.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                e = th;
                parser.close();
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (XmlPullParserException e4) {
            e = e4;
        } catch (Throwable th2) {
            e = th2;
            parser.close();
            throw e;
        }
    }

    private void addVolume(StorageVolume volume) {
        StorageVolume preOne = this.mVolumesMap.put(volume.getPath(), volume);
        this.mLogger.write("\taddVolume: " + volume.getPath() + VideoFile.TREE_END);
        if (preOne != null) {
            this.mLogger.write("\t--- already map in volumes list\n");
        } else if (getPrimary().isEmulated() && volume.isEmulated()) {
            this.mLogger.write("\t--- emulated volume mapped\n");
        } else {
            this.mVolumes.add(volume);
        }
    }

    private int getInt(Class<?> clazz, String fieldName) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        return clazz.getDeclaredField(fieldName).getInt(null);
    }

    public File getSecondaryStorageDirectory() {
        StorageVolume secondary = getSecondary();
        if (secondary == null) {
            return null;
        }
        return secondary.getPathFile();
    }

    private static boolean isMountPointIgnored(String mountPoint) {
        String[] strArr;
        if (mountPoint.contains("obb") || mountPoint.contains("secure")) {
            return true;
        }
        for (String prefix : sIgnoreMountPointPrefixs) {
            if (mountPoint.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isKownFS(String fs) {
        String[] strArr;
        for (String kfs : sKownFileSystems) {
            if (fs.contains(kfs)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDeviceIgnored(String dev) {
        String[] strArr;
        for (String path : sIgnoreDevices) {
            if (dev.contains(path) || new File(dev).getCanonicalPath().contains(path)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0135 A[LOOP:1: B:37:0x012f->B:39:0x0135, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadStorageWidthMounts() {
        Iterator<StorageVolume> it;
        TreeSet<StorageVolume> volumes = new TreeSet<>(sVolumeComparator);
        this.mLogger.write("\n---start loadStorageWidthMounts--\n");
        BufferedReader br = null;
        try {
            br = getMountsBufferReader();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } else if (!TextUtils.isEmpty(line) && line.charAt(0) == '/') {
                    String[] fields = line.split("\\s+");
                    if (fields.length >= 3) {
                        String device = fields[0];
                        String mountPoint = fields[1];
                        String fileSystem = fields[2];
                        this.mLogger.write(device + ", " + mountPoint + ", " + fileSystem + VideoFile.TREE_END);
                        if (mountPoint.equals("/system")) {
                            addSystemDevIgnored(device);
                        }
                        if (isKownFS(fileSystem) && !isMountPointIgnored(mountPoint) && !isDeviceIgnored(device)) {
                            File path = new File(mountPoint);
                            if (!path.canRead()) {
                                this.mLogger.write("\t--can't read\n");
                            } else {
                                this.mLogger.write("got it: " + mountPoint + VideoFile.TREE_END);
                                DebugLog.d(TAG, "got volume:" + device + "," + mountPoint + "," + fileSystem);
                                StorageVolume volume = new StorageVolume(path, device);
                                volumes.add(volume);
                            }
                        }
                        this.mLogger.write("\t--ignored\n");
                    }
                }
            }
        } finally {
            try {
                this.mLogger.write("--add mount volume to list\n");
                it = volumes.iterator();
                while (it.hasNext()) {
                }
                this.mLogger.write("--end loadStorageWidthMounts--\n");
            } finally {
            }
        }
        this.mLogger.write("--add mount volume to list\n");
        it = volumes.iterator();
        while (it.hasNext()) {
            StorageVolume volume2 = it.next();
            addVolume(volume2);
        }
        this.mLogger.write("--end loadStorageWidthMounts--\n");
    }

    private void addSystemDevIgnored(String device) {
        try {
            String canonicalPath = new File(device).getCanonicalPath();
            int indexOf = canonicalPath.indexOf("mmcblk");
            if (indexOf > 0) {
                String devblk = canonicalPath.substring(indexOf, "mmcblk".length() + indexOf + 1);
                if (Arrays.binarySearch(sIgnoreDevices, devblk) < 0) {
                    int length = sIgnoreDevices.length;
                    sIgnoreDevices = (String[]) Arrays.copyOf(sIgnoreDevices, length + 1);
                    sIgnoreDevices[length] = devblk;
                    this.mLogger.write("\tadd system dev blk: " + devblk + VideoFile.TREE_END);
                }
            }
        } catch (Exception e) {
        }
    }

    private BufferedReader getMountsBufferReader() throws IOException {
        Reader reader = null;
        File file = new File("/proc/mounts");
        if (file.exists() && file.canRead()) {
            try {
                reader = new FileReader(file);
            } catch (IOException e) {
                reader = null;
            }
        }
        if (reader == null) {
            reader = new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream());
        }
        return new BufferedReader(reader);
    }

    private static void init() {
    }

    public static long getDeviceID(String devPath) {
        try {
            StructStat stat = Os.lstat(devPath);
            return stat.st_rdev;
        } catch (Exception e) {
            DebugLog.wfmt(TAG, "get device id failed: %s path=%s", new Object[]{e.getMessage(), devPath});
            return devPath.hashCode();
        }
    }

    public String dump() {
        return this.mLogger.toString();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IllegalStorageException extends IllegalArgumentException {
        private static final long serialVersionUID = -63918562462521L;

        public IllegalStorageException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class StorageVolume {
        private final String mDescription;
        private String mDevPath;
        private final boolean mEmulated;
        private final File mPath;
        private final boolean mPrimary;
        private final boolean mRemovable;
        private StatFs mStatFs;

        public StorageVolume(File path, String desc, boolean primary, boolean removable, boolean emulated) {
            this.mPath = path;
            this.mDescription = desc;
            this.mPrimary = primary;
            this.mRemovable = removable;
            this.mEmulated = emulated;
        }

        public StorageVolume(File path, String devPath) {
            this.mPath = path;
            this.mDescription = path.getName();
            this.mDevPath = devPath;
            this.mRemovable = false;
            this.mEmulated = false;
            this.mPrimary = false;
        }

        public static StorageVolume fromTemplate(StorageVolume template, File path) {
            return new StorageVolume(path, template.mDescription, template.mPrimary, template.mRemovable, template.mEmulated);
        }

        public String getPath() {
            try {
                return this.mPath.getCanonicalPath();
            } catch (IOException e) {
                return this.mPath.toString();
            }
        }

        public File getPathFile() {
            return this.mPath;
        }

        public long getAvailableBytes() throws IllegalStorageException {
            checkStatFs();
            return this.mStatFs.getAvailableBytes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkStatFs() throws IllegalStorageException {
            try {
                if (this.mStatFs == null) {
                    this.mStatFs = new StatFs(getPath());
                } else {
                    this.mStatFs.restat(getPath());
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalStorageException("Invalid path while dostat:" + getPath(), e);
            }
        }

        public long getTotalBytes() throws IllegalStorageException {
            checkStatFs();
            return this.mStatFs.getTotalBytes();
        }

        public String getDescription() {
            return this.mDescription;
        }

        public boolean isPrimary() {
            return this.mPrimary;
        }

        public boolean isRemovable() {
            return this.mRemovable;
        }

        public boolean isEmulated() {
            return this.mEmulated || getPath().contains(ExternalStorageHelper.MEDIA_EMULATE);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof StorageVolume) || this.mPath == null) {
                return false;
            }
            StorageVolume volume = (StorageVolume) obj;
            return this.mPath.equals(volume.mPath) || getID() == volume.getID();
        }

        public long getID() {
            if (this.mDevPath == null) {
                return hashCode() + getTotalSpace();
            }
            return ExternalStorageHelper.getDeviceID(this.mDevPath);
        }

        public int hashCode() {
            return this.mPath.hashCode();
        }

        public String getDisplaySize() {
            return DisplaySizeHelper.byteCountToDisplaySize(getAvailSpace()) + " / " + DisplaySizeHelper.byteCountToDisplaySize(getTotalSpace());
        }

        public String getDisplayTotalSize() {
            return DisplaySizeHelper.byteCountToDisplaySize(getTotalSpace());
        }

        public String getDisplayAvailableSize() {
            return DisplaySizeHelper.byteCountToDisplaySize(getAvailSpace());
        }

        public long getAvailSpace() {
            try {
                if (!this.mPath.canRead()) {
                    return 0L;
                }
                long availBytes = getAvailableBytes();
                return availBytes;
            } catch (Exception e) {
                return 0L;
            }
        }

        public long getTotalSpace() {
            try {
                if (!this.mPath.canRead()) {
                    return 0L;
                }
                long totalBytes = getTotalBytes();
                return totalBytes;
            } catch (Exception e) {
                return 0L;
            }
        }
    }

    public void reloadVolumeList() {
        loadVolumeList(this.mContext);
    }

    public boolean isPrimary(String path) {
        StorageVolume primary = getPrimary();
        String primaryPath = primary.getPath();
        try {
            path = new File(path).getCanonicalPath();
        } catch (IOException e) {
        }
        if (primary.isEmulated() && path.contains(MEDIA_EMULATE)) {
            return true;
        }
        return path.startsWith(primaryPath);
    }
}