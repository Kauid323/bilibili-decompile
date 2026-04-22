package tv.danmaku.ijk.media.player;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;
import tv.danmaku.android.log.BLog;

public class IjkCpuInfo {
    public static final String CPU_ARCHITECTURE_5TE = "5TE";
    public static final String CPU_ARCHITECTURE_6TEJ = "6TEJ";
    public static final String CPU_ARCHITECTURE_7 = "7";
    public static final int CPU_IMPL_ARM_LIMITED = 65;
    public static final int CPU_IMPL_DEC = 68;
    public static final int CPU_IMPL_INTEL = 105;
    public static final int CPU_IMPL_MARVELL = 86;
    public static final int CPU_IMPL_MOTO = 77;
    public static final int CPU_IMPL_QUALCOMM = 81;
    public static final int CPU_PART_ARM1026 = 2598;
    public static final int CPU_PART_ARM1136 = 2870;
    public static final int CPU_PART_ARM1156 = 2902;
    public static final int CPU_PART_ARM1176 = 2934;
    public static final int CPU_PART_ARM11_MPCORE = 2818;
    public static final int CPU_PART_ARM920 = 2336;
    public static final int CPU_PART_ARM926 = 2342;
    public static final int CPU_PART_ARM946 = 2374;
    public static final int CPU_PART_CORTEX_A15 = 3087;
    public static final int CPU_PART_CORTEX_A5 = 3077;
    public static final int CPU_PART_CORTEX_A7 = 3079;
    public static final int CPU_PART_CORTEX_A8 = 3080;
    public static final int CPU_PART_CORTEX_A9 = 3081;
    public static final int CPU_PART_CORTEX_M0 = 3104;
    public static final int CPU_PART_CORTEX_M1 = 3105;
    public static final int CPU_PART_CORTEX_M3 = 3107;
    public static final int CPU_PART_CORTEX_M4 = 15;
    public static final int CPU_PART_CORTEX_R4 = 3092;
    public static final int CPU_PART_CORTEX_R5 = 3093;
    public static final int CPU_PART_PXA910 = 2112;
    public static final int CPU_PART_SNAPDRAGON_S1 = 15;
    public static final int CPU_PART_SNAPDRAGON_S3 = 45;
    public static final int CPU_PART_SNAPDRAGON_S4_PLUS = 77;
    public static final int CPU_PART_SNAPDRAGON_S4_PRO = 111;
    private static final String TAG = "CpuInfo";
    private static IjkCpuInfo sInstance;
    private int mCpuCoreCount;
    public int mCpuImplementer;
    private int mCpuMaxFreq;
    private String mCpuName;
    public int mCpuPart;
    private boolean mHasARMv5;
    private boolean mHasARMv6;
    private boolean mHasARMv7;
    private String mProcess;
    private boolean mUpdatedCoreCountAndMaxFreq = false;
    public String mRawCpuInfo = new String();
    public TreeMap<String, String> mRawInfoMap = new TreeMap<>();
    public TreeSet<String> mFeatureSet = new TreeSet<>();

    public static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    @Deprecated
    public static String getRawCpuInfo() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf A[Catch: all -> 0x01a8, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000b, B:11:0x0013, B:13:0x001c, B:19:0x0048, B:33:0x00b5, B:35:0x00cf, B:37:0x00d5, B:40:0x00de, B:42:0x00ea, B:43:0x00ed, B:45:0x00f3, B:47:0x00fb, B:48:0x00fe, B:50:0x0108, B:53:0x0118, B:55:0x0122, B:58:0x0132, B:59:0x014a, B:63:0x0154, B:65:0x015c, B:22:0x0053, B:23:0x006c, B:29:0x0090, B:32:0x009b, B:74:0x018a, B:14:0x002a, B:15:0x002f, B:17:0x0036, B:18:0x0042, B:28:0x0074), top: B:84:0x0003, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015c A[Catch: all -> 0x01a8, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000b, B:11:0x0013, B:13:0x001c, B:19:0x0048, B:33:0x00b5, B:35:0x00cf, B:37:0x00d5, B:40:0x00de, B:42:0x00ea, B:43:0x00ed, B:45:0x00f3, B:47:0x00fb, B:48:0x00fe, B:50:0x0108, B:53:0x0118, B:55:0x0122, B:58:0x0132, B:59:0x014a, B:63:0x0154, B:65:0x015c, B:22:0x0053, B:23:0x006c, B:29:0x0090, B:32:0x009b, B:74:0x018a, B:14:0x002a, B:15:0x002f, B:17:0x0036, B:18:0x0042, B:28:0x0074), top: B:84:0x0003, inners: #1, #2, #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized IjkCpuInfo parseCpuInfo() {
        String str;
        String str2;
        String cpuName;
        synchronized (IjkCpuInfo.class) {
            if (sInstance != null) {
                return sInstance;
            }
            IjkCpuInfo cpuInfo = new IjkCpuInfo();
            sInstance = cpuInfo;
            try {
                FileInputStream inputStream = new FileInputStream("/proc/cpuinfo");
                InputStreamReader reader = new InputStreamReader(inputStream, Charset.defaultCharset());
                BufferedReader buffReader = new BufferedReader(reader);
                try {
                    StringBuilder infoBuilder = new StringBuilder();
                    while (true) {
                        String line = buffReader.readLine();
                        if (line == null) {
                            break;
                        }
                        cpuInfo.addCpuInfo(line);
                        infoBuilder.append(line);
                        infoBuilder.append('\n');
                    }
                    cpuInfo.mRawCpuInfo = infoBuilder.toString();
                } catch (IOException e) {
                    BLog.d(TAG, "parse cpu info:" + e.getMessage());
                    try {
                        buffReader.close();
                        reader.close();
                        inputStream.close();
                    } catch (Exception e2) {
                        str = TAG;
                        str2 = "parse cpu info:" + e2.getMessage();
                        BLog.d(str, str2);
                        cpuName = cpuInfo.mRawInfoMap.get("hardware");
                        String cpuModel = cpuInfo.mRawInfoMap.get("model name");
                        if (TextUtils.isEmpty(cpuName)) {
                        }
                        cpuInfo.mCpuName = TextUtils.isEmpty(cpuName) ? "Unknown" : cpuName;
                        if (AbrParamsInterface.IsEnableAv1SwCodec()) {
                        }
                        return cpuInfo;
                    }
                }
                try {
                    buffReader.close();
                    reader.close();
                    inputStream.close();
                } catch (Exception e3) {
                    str = TAG;
                    str2 = "parse cpu info:" + e3.getMessage();
                    BLog.d(str, str2);
                    cpuName = cpuInfo.mRawInfoMap.get("hardware");
                    String cpuModel2 = cpuInfo.mRawInfoMap.get("model name");
                    if (TextUtils.isEmpty(cpuName)) {
                    }
                    cpuInfo.mCpuName = TextUtils.isEmpty(cpuName) ? "Unknown" : cpuName;
                    if (AbrParamsInterface.IsEnableAv1SwCodec()) {
                    }
                    return cpuInfo;
                }
                cpuName = cpuInfo.mRawInfoMap.get("hardware");
                String cpuModel22 = cpuInfo.mRawInfoMap.get("model name");
                if (TextUtils.isEmpty(cpuName)) {
                    if (cpuInfo.isX86() && !TextUtils.isEmpty(cpuModel22)) {
                        cpuName = cpuModel22;
                    } else {
                        String hardWare = "";
                        String socModel = "";
                        if (!TextUtils.isEmpty(Build.HARDWARE)) {
                            hardWare = Build.HARDWARE;
                        }
                        if (Build.VERSION.SDK_INT >= 31 && !TextUtils.isEmpty(Build.SOC_MODEL)) {
                            socModel = Build.SOC_MODEL;
                        }
                        if (hardWare.length() >= socModel.length() && hardWare.toLowerCase().contains(socModel.toLowerCase())) {
                            cpuName = hardWare;
                        } else if (hardWare.length() < socModel.length() && socModel.toLowerCase().contains(hardWare.toLowerCase())) {
                            cpuName = socModel;
                        } else {
                            cpuName = hardWare + " " + socModel;
                        }
                    }
                }
                cpuInfo.mCpuName = TextUtils.isEmpty(cpuName) ? "Unknown" : cpuName;
                if (AbrParamsInterface.IsEnableAv1SwCodec()) {
                    cpuInfo.updateCpuCoreCountAndMaxFreq();
                }
                return cpuInfo;
            } catch (FileNotFoundException e4) {
                BLog.d(TAG, "parse cpu info:" + e4.getMessage());
                return cpuInfo;
            }
        }
    }

    public synchronized void updateCpuCoreCountAndMaxFreq() {
        if (this.mUpdatedCoreCountAndMaxFreq) {
            return;
        }
        this.mUpdatedCoreCountAndMaxFreq = true;
        try {
            File cpuDir = new File("/sys/devices/system/cpu/");
            File[] cpuNames = cpuDir.listFiles(new FileFilter() { // from class: tv.danmaku.ijk.media.player.IjkCpuInfo$$ExternalSyntheticLambda0
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean matches;
                    matches = file.getName().matches("cpu[0-9]+");
                    return matches;
                }
            });
            this.mCpuCoreCount = cpuNames.length;
            for (File file : cpuNames) {
                File maxFreqFile = new File(file, "cpufreq/cpuinfo_max_freq");
                BufferedReader maxFreqReader = new BufferedReader(new FileReader(maxFreqFile));
                String line = maxFreqReader.readLine();
                int freq = Integer.parseInt(line.trim());
                if (this.mCpuMaxFreq < freq) {
                    this.mCpuMaxFreq = freq;
                }
            }
        } catch (Exception e) {
            BLog.d(TAG, "parse cpu info:" + e.getMessage());
        }
    }

    public void addCpuInfo(String line) {
        String[] lineInfo = line.split(":", 2);
        if (lineInfo.length >= 2) {
            addCpuInfo(lineInfo[0], lineInfo[1]);
        }
    }

    private static int intValueOf(String value, int radix) {
        try {
            return Integer.valueOf(value, radix).intValue();
        } catch (NumberFormatException e) {
            BLog.d(TAG, "intValueOf:" + e.getMessage());
            return 0;
        }
    }

    private static int intValueOf(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            BLog.d(TAG, "intValueOf:" + e.getMessage());
            return 0;
        }
    }

    public void addCpuInfo(String key, String value) {
        String key2 = key.toLowerCase(Locale.US).trim();
        String value2 = value.trim();
        this.mRawInfoMap.put(key2, value2);
        if (key2.equals("processor") && TextUtils.isEmpty(this.mProcess)) {
            this.mProcess = value2;
            String value3 = value2.toLowerCase(Locale.US);
            if (value3.startsWith("armv7")) {
                this.mHasARMv7 = true;
            } else if (value3.startsWith("armv6")) {
                this.mHasARMv6 = true;
            } else if (value3.startsWith("arm926ej-s")) {
                this.mHasARMv5 = true;
            } else if (value3.startsWith("marvell 88sv331x")) {
                this.mHasARMv5 = true;
            }
        } else if (key2.equals("cpu part")) {
            String value4 = value2.toLowerCase(Locale.US);
            int pos = value4.toLowerCase(Locale.US).indexOf(120);
            if (-1 == pos) {
                this.mCpuPart = intValueOf(value4);
            } else {
                this.mCpuPart = intValueOf(value4.substring(pos + 1), 16);
            }
        } else if (key2.equals("cpu implementer")) {
            String value5 = value2.toLowerCase(Locale.US);
            int pos2 = value5.toLowerCase(Locale.US).indexOf(120);
            if (-1 == pos2) {
                this.mCpuImplementer = intValueOf(value5);
            } else {
                this.mCpuImplementer = intValueOf(value5.substring(pos2 + 1), 16);
            }
        } else if (key2.equals("features")) {
            String[] features = value2.toLowerCase(Locale.US).split(" ");
            for (String featureItem : features) {
                this.mFeatureSet.add(featureItem.trim());
            }
        }
    }

    private String optCpuRawInfoItem(String key) {
        if (TextUtils.isEmpty(key)) {
            return "";
        }
        String value = this.mRawInfoMap.get(key);
        return TextUtils.isEmpty(value) ? "" : value;
    }

    public boolean isCortexA5() {
        return 3077 == this.mCpuPart;
    }

    public boolean isCortexA7() {
        return 3079 == this.mCpuPart;
    }

    public boolean isCortexA8() {
        return 3080 == this.mCpuPart;
    }

    public boolean isCortexA9() {
        return 3081 == this.mCpuPart;
    }

    public boolean isCortexA15() {
        return 3087 == this.mCpuPart;
    }

    public boolean isSnapdragon_S1() {
        return this.mCpuImplementer == 81 && 15 == this.mCpuPart;
    }

    public boolean isSnapdragon_S3() {
        return this.mCpuImplementer == 81 && 45 == this.mCpuPart;
    }

    public boolean isSnapdragon_S4_Plus() {
        return this.mCpuImplementer == 81 && 77 == this.mCpuPart;
    }

    public boolean isSnapdragon_S4_Pro() {
        return this.mCpuImplementer == 81 && 111 == this.mCpuPart;
    }

    public boolean isKnownARMv7aCpuId() {
        switch (this.mCpuPart) {
            case 15:
            case CPU_PART_SNAPDRAGON_S3 /* 45 */:
            case 77:
            case CPU_PART_SNAPDRAGON_S4_PRO /* 111 */:
                return this.mCpuImplementer == 81;
            case 3077:
            case CPU_PART_CORTEX_A7 /* 3079 */:
            case 3080:
            case CPU_PART_CORTEX_A9 /* 3081 */:
            case CPU_PART_CORTEX_A15 /* 3087 */:
                return true;
            default:
                return false;
        }
    }

    public String getCpuArchitecture() {
        return this.mRawInfoMap.get("cpu architecture");
    }

    public boolean hasArmv7() {
        return this.mHasARMv7;
    }

    public boolean hasArmv6() {
        return this.mHasARMv6;
    }

    public boolean hasArmv5() {
        return this.mHasARMv5;
    }

    public boolean supportNeon() {
        return this.mFeatureSet.contains("neon");
    }

    public boolean supportVfpv3D16() {
        return this.mFeatureSet.contains("vfpv3-d16") || this.mFeatureSet.contains("vfpv3d16");
    }

    public boolean supportVfp() {
        return this.mFeatureSet.contains("vfp");
    }

    public boolean isX86() {
        String vender_id = this.mRawInfoMap.get("vendor_id");
        if (!TextUtils.isEmpty(vender_id) && vender_id.equals("GenuineIntel")) {
            return true;
        }
        return false;
    }

    public static String getCpuName() {
        IjkCpuInfo info = parseCpuInfo();
        return info.mCpuName;
    }

    public static int getCpuCoreCount() {
        IjkCpuInfo info = parseCpuInfo();
        return info.mCpuCoreCount;
    }

    public static int getCpuMaxFreq() {
        IjkCpuInfo info = parseCpuInfo();
        return info.mCpuMaxFreq;
    }
}