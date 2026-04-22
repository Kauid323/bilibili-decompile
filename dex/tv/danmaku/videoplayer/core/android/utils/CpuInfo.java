package tv.danmaku.videoplayer.core.android.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;
import tv.danmaku.android.log.BLog;

public class CpuInfo {
    public static final int CPU_IMPL_QUALCOMM = 81;
    public static final int CPU_PART_CORTEX_A5 = 3077;
    public static final int CPU_PART_CORTEX_A8 = 3080;
    public static final int CPU_PART_SNAPDRAGON_S1 = 15;
    private static final String TAG = "CpuInfo";
    private static CpuInfo sInstance;
    public int mCpuImplementer;
    public int mCpuPart;
    private String mProcess;
    public String mRawCpuInfo = "";
    public TreeMap<String, String> mRawInfoMap = new TreeMap<>();
    public TreeSet<String> mFeatureSet = new TreeSet<>();

    public static CpuInfo parseCpuInfo() {
        StringBuilder sb;
        if (sInstance != null) {
            return sInstance;
        }
        try {
            FileInputStream inputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader reader = new InputStreamReader(inputStream, Charset.defaultCharset());
            BufferedReader buffReader = new BufferedReader(reader);
            CpuInfo cpuInfo = new CpuInfo();
            try {
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
                    cpuInfo = null;
                    try {
                        buffReader.close();
                        reader.close();
                        inputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        BLog.d(TAG, sb.append("parse cpu info:").append(e.getMessage()).toString());
                        sInstance = cpuInfo;
                        return cpuInfo;
                    }
                }
                try {
                    buffReader.close();
                    reader.close();
                    inputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    sb = new StringBuilder();
                    BLog.d(TAG, sb.append("parse cpu info:").append(e.getMessage()).toString());
                    sInstance = cpuInfo;
                    return cpuInfo;
                }
                sInstance = cpuInfo;
                return cpuInfo;
            } catch (Throwable th) {
                try {
                    buffReader.close();
                    reader.close();
                    inputStream.close();
                } catch (Exception e4) {
                    BLog.d(TAG, "parse cpu info:" + e4.getMessage());
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            BLog.d(TAG, "parse cpu info:" + e5.getMessage());
            return null;
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
        } else if (key2.equals("cpu part")) {
            String value3 = value2.toLowerCase(Locale.US);
            int pos = value3.toLowerCase(Locale.US).indexOf(120);
            if (-1 == pos) {
                this.mCpuPart = intValueOf(value3);
            } else {
                this.mCpuPart = intValueOf(value3.substring(pos + 1), 16);
            }
        } else if (key2.equals("cpu implementer")) {
            String value4 = value2.toLowerCase(Locale.US);
            int pos2 = value4.toLowerCase(Locale.US).indexOf(120);
            if (-1 == pos2) {
                this.mCpuImplementer = intValueOf(value4);
            } else {
                this.mCpuImplementer = intValueOf(value4.substring(pos2 + 1), 16);
            }
        } else if (key2.equals("features")) {
            String[] features = value2.toLowerCase(Locale.US).split(" ");
            for (String featureItem : features) {
                this.mFeatureSet.add(featureItem.trim());
            }
        }
    }

    public boolean isCortexA5() {
        return 3077 == this.mCpuPart;
    }

    public boolean isCortexA8() {
        return 3080 == this.mCpuPart;
    }

    public boolean isSnapdragon_S1() {
        return this.mCpuImplementer == 81 && 15 == this.mCpuPart;
    }

    public boolean supportNeon() {
        return this.mFeatureSet.contains("neon");
    }
}