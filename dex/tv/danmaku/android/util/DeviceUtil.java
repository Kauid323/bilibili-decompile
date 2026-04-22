package tv.danmaku.android.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

public class DeviceUtil {
    private static final String CPU_FILE_PATH_0 = "/sys/devices/system/cpu/";
    private static final String CPU_FILE_PATH_1 = "/sys/devices/system/cpu/possible";
    private static final String CPU_FILE_PATH_2 = "/sys/devices/system/cpu/present";
    private static final String DEVICE_CPU = "cpu_app";
    private static final String DEVICE_CPU_CORES = "cpu_app_cores";
    public static final String DEVICE_MACHINE = "machine";
    private static final String DEVICE_MEMORY = "mem";
    private static final String DEVICE_MEMORY_FREE = "mem_free";
    private static final int INVALID = 0;
    private static final long MB = 1048576;
    private static final String MEMORY_FILE_PATH = "/proc/meminfo";
    private static final String TAG = "DeviceUtil";
    private static LEVEL sLevelCache = null;
    private static long sTotalMemory = 0;
    private static long sLowMemoryThresold = 0;
    private static int sMemoryClass = 0;
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: tv.danmaku.android.util.DeviceUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File pathname) {
            return Pattern.matches("cpu[0-9]", pathname.getName());
        }
    };

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        LEVEL(int val) {
            this.value = val;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Map<String, String> getDeviceInfo(Application context) {
        Map<String, String> ret = new HashMap<>();
        ret.put(DEVICE_MACHINE, getLevel(context) + "");
        ret.put(DEVICE_MEMORY, (getTotalMemory(context) / 1024) + "");
        ret.put(DEVICE_MEMORY_FREE, getMemFree(context) + "");
        ret.put(DEVICE_CPU_CORES, getNumOfCores() + "");
        return ret;
    }

    public static LEVEL getLevel(Context context) {
        if (sLevelCache != null) {
            return sLevelCache;
        }
        long start = System.currentTimeMillis();
        long totalMemory = getTotalMemory(context);
        int coresNum = getNumOfCores();
        BLog.i(TAG, String.format("[getLevel] totalMemory:%s coresNum:%s", Long.valueOf(totalMemory), Integer.valueOf(coresNum)));
        if (totalMemory >= 4294967296L) {
            sLevelCache = LEVEL.BEST;
        } else if (totalMemory >= 3221225472L) {
            sLevelCache = LEVEL.HIGH;
        } else if (totalMemory >= 2147483648L) {
            if (coresNum >= 4) {
                sLevelCache = LEVEL.HIGH;
            } else if (coresNum >= 2) {
                sLevelCache = LEVEL.MIDDLE;
            } else if (coresNum > 0) {
                sLevelCache = LEVEL.LOW;
            }
        } else if (totalMemory >= 1073741824) {
            if (coresNum >= 4) {
                sLevelCache = LEVEL.MIDDLE;
            } else if (coresNum >= 2) {
                sLevelCache = LEVEL.LOW;
            } else if (coresNum > 0) {
                sLevelCache = LEVEL.LOW;
            }
        } else if (0 <= totalMemory && totalMemory < 1073741824) {
            sLevelCache = LEVEL.BAD;
        } else {
            sLevelCache = LEVEL.UN_KNOW;
        }
        BLog.i(TAG, "getLevel, cost:" + (System.currentTimeMillis() - start) + ", level:" + sLevelCache);
        return sLevelCache;
    }

    private static int getAppId() {
        return Process.myPid();
    }

    public static long getLowMemoryThresold(Context context) {
        if (0 != sLowMemoryThresold) {
            return sLowMemoryThresold;
        }
        getTotalMemory(context);
        return sLowMemoryThresold;
    }

    public static int getMemoryClass(Context context) {
        if (sMemoryClass != 0) {
            return sMemoryClass * MisakaHelper.MAX_REPORT_SIZE;
        }
        getTotalMemory(context);
        return sMemoryClass * MisakaHelper.MAX_REPORT_SIZE;
    }

    public static long getTotalMemory(Context context) {
        if (0 != sTotalMemory) {
            return sTotalMemory;
        }
        long start = System.currentTimeMillis();
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        ActivityManager am = (ActivityManager) context.getSystemService(AudioIntentHelper.FROM_ACTIVITY);
        am.getMemoryInfo(memInfo);
        sTotalMemory = memInfo.totalMem;
        sLowMemoryThresold = memInfo.threshold;
        long memClass = Runtime.getRuntime().maxMemory();
        if (memClass == Long.MAX_VALUE) {
            sMemoryClass = am.getMemoryClass();
        } else {
            sMemoryClass = (int) (memClass / MB);
        }
        BLog.i(TAG, "getTotalMemory cost:" + (System.currentTimeMillis() - start) + ", total_mem:" + sTotalMemory + ", LowMemoryThresold:" + sLowMemoryThresold + ", Memory Class:" + sMemoryClass);
        return sTotalMemory;
    }

    public static boolean isLowMemory(Context context) {
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        ActivityManager am = (ActivityManager) context.getSystemService(AudioIntentHelper.FROM_ACTIVITY);
        am.getMemoryInfo(memInfo);
        return memInfo.lowMemory;
    }

    public static long getAvailMemory(Context context) {
        Runtime runtime = Runtime.getRuntime();
        return runtime.freeMemory() / 1024;
    }

    public static long getMemFree(Context context) {
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        ActivityManager am = (ActivityManager) context.getSystemService(AudioIntentHelper.FROM_ACTIVITY);
        am.getMemoryInfo(memInfo);
        return memInfo.availMem / 1024;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double getAppCpuRate() {
        String format;
        long cpuTime;
        Throwable th;
        String format2;
        long start = System.currentTimeMillis();
        long appTime = 0;
        double cpuRate = 0.0d;
        RandomAccessFile procStatFile = null;
        RandomAccessFile appStatFile = null;
        long cpuTime2 = 0;
        try {
            try {
                procStatFile = new RandomAccessFile("/proc/stat", "r");
                String procStatString = procStatFile.readLine();
                String[] procStats = procStatString.split(" ");
                cpuTime2 = Long.parseLong(procStats[2]) + Long.parseLong(procStats[3]) + Long.parseLong(procStats[4]) + Long.parseLong(procStats[5]) + Long.parseLong(procStats[6]) + Long.parseLong(procStats[7]) + Long.parseLong(procStats[8]);
            } catch (Exception e) {
                BLog.i(TAG, String.format("RandomAccessFile(Process Stat) reader fail, error: %s", e.toString()));
                if (procStatFile != null) {
                    try {
                        procStatFile.close();
                    } catch (Exception e2) {
                        format = String.format("close process reader %s", e2.toString());
                        BLog.i(TAG, format);
                        cpuTime = cpuTime2;
                        appStatFile = new RandomAccessFile("/proc/" + getAppId() + "/stat", "r");
                        String appStatString = appStatFile.readLine();
                        String[] appStats = appStatString.split(" ");
                        appTime = Long.parseLong(appStats[13]) + Long.parseLong(appStats[14]);
                        try {
                            appStatFile.close();
                        } catch (Exception e3) {
                            format2 = String.format("close app reader %s", e3.toString());
                            BLog.i(TAG, format2);
                            if (0 != cpuTime) {
                            }
                            BLog.i(TAG, "getAppCpuRate cost:" + (System.currentTimeMillis() - start) + ",rate:" + cpuRate);
                            return cpuRate;
                        }
                        if (0 != cpuTime) {
                        }
                        BLog.i(TAG, "getAppCpuRate cost:" + (System.currentTimeMillis() - start) + ",rate:" + cpuRate);
                        return cpuRate;
                    }
                }
            }
            try {
                procStatFile.close();
            } catch (Exception e4) {
                format = String.format("close process reader %s", e4.toString());
                BLog.i(TAG, format);
                cpuTime = cpuTime2;
                appStatFile = new RandomAccessFile("/proc/" + getAppId() + "/stat", "r");
                String appStatString2 = appStatFile.readLine();
                String[] appStats2 = appStatString2.split(" ");
                appTime = Long.parseLong(appStats2[13]) + Long.parseLong(appStats2[14]);
                appStatFile.close();
                if (0 != cpuTime) {
                }
                BLog.i(TAG, "getAppCpuRate cost:" + (System.currentTimeMillis() - start) + ",rate:" + cpuRate);
                return cpuRate;
            }
            cpuTime = cpuTime2;
            try {
                appStatFile = new RandomAccessFile("/proc/" + getAppId() + "/stat", "r");
                String appStatString22 = appStatFile.readLine();
                String[] appStats22 = appStatString22.split(" ");
                appTime = Long.parseLong(appStats22[13]) + Long.parseLong(appStats22[14]);
                appStatFile.close();
            } catch (Exception e5) {
                try {
                    try {
                        BLog.i(TAG, String.format("RandomAccessFile(App Stat) reader fail, error: %s", e5.toString()));
                        if (appStatFile != null) {
                            try {
                                appStatFile.close();
                            } catch (Exception e6) {
                                format2 = String.format("close app reader %s", e6.toString());
                                BLog.i(TAG, format2);
                                if (0 != cpuTime) {
                                }
                                BLog.i(TAG, "getAppCpuRate cost:" + (System.currentTimeMillis() - start) + ",rate:" + cpuRate);
                                return cpuRate;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (appStatFile != null) {
                            try {
                                appStatFile.close();
                            } catch (Exception e7) {
                                BLog.i(TAG, String.format("close app reader %s", e7.toString()));
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                if (appStatFile != null) {
                }
                throw th;
            }
            if (0 != cpuTime) {
                cpuRate = (appTime / cpuTime) * 100.0d;
            }
            BLog.i(TAG, "getAppCpuRate cost:" + (System.currentTimeMillis() - start) + ",rate:" + cpuRate);
            return cpuRate;
        } catch (Throwable th5) {
            if (procStatFile != null) {
                try {
                    procStatFile.close();
                } catch (Exception e8) {
                    BLog.i(TAG, String.format("close process reader %s", e8.toString()));
                }
            }
            throw th5;
        }
    }

    public static Debug.MemoryInfo getAppMemory(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(AudioIntentHelper.FROM_ACTIVITY);
            Debug.MemoryInfo[] memInfo = activityManager.getProcessMemoryInfo(new int[]{getAppId()});
            if (memInfo.length > 0) {
                return memInfo[0];
            }
            return null;
        } catch (Exception e) {
            BLog.i(TAG, String.format("getProcessMemoryInfo fail, error: %s", e.toString()));
            return null;
        }
    }

    public static int getNumOfCores() {
        int cores;
        try {
            cores = getCoresFromFile(CPU_FILE_PATH_1);
            if (cores == 0) {
                cores = getCoresFromFile(CPU_FILE_PATH_2);
            }
            if (cores == 0) {
                cores = getCoresFromCPUFiles(CPU_FILE_PATH_0);
            }
        } catch (Exception e) {
            cores = 0;
        }
        if (cores == 0) {
            return 1;
        }
        return cores;
    }

    public static int getCPUMaxFreqKHz() {
        int maxFreq = -1;
        int numberOfCores = getNumOfCores();
        for (int i = 0; i < numberOfCores; i++) {
            try {
                String filename = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
                File cpuInfoMaxFreqFile = new File(filename);
                if (cpuInfoMaxFreqFile.exists() && cpuInfoMaxFreqFile.canRead()) {
                    byte[] buffer = new byte[BR.cover];
                    FileInputStream stream = new FileInputStream(cpuInfoMaxFreqFile);
                    try {
                        stream.read(buffer);
                        int endIndex = 0;
                        while (Character.isDigit(buffer[endIndex]) && endIndex < buffer.length) {
                            endIndex++;
                        }
                        String str = new String(buffer, 0, endIndex);
                        Integer freqBound = Integer.valueOf(Integer.parseInt(str));
                        if (freqBound.intValue() > maxFreq) {
                            maxFreq = freqBound.intValue();
                        }
                    } catch (NumberFormatException e) {
                    }
                    stream.close();
                }
            } catch (IOException e2) {
                return -1;
            }
        }
        if (maxFreq == -1) {
            FileInputStream stream2 = new FileInputStream("/proc/cpuinfo");
            int freqBound2 = parseFileForValue("cpu MHz", stream2) * 1000;
            if (freqBound2 > maxFreq) {
                maxFreq = freqBound2;
            }
            stream2.close();
            return maxFreq;
        }
        return maxFreq;
    }

    private static int parseFileForValue(String textToMatch, FileInputStream stream) {
        byte[] buffer = new byte[MisakaHelper.MAX_REPORT_SIZE];
        try {
            int length = stream.read(buffer);
            int i = 0;
            while (i < length) {
                if (buffer[i] == 10 || i == 0) {
                    if (buffer[i] == 10) {
                        i++;
                    }
                    for (int j = i; j < length; j++) {
                        int textIndex = j - i;
                        if (buffer[j] != textToMatch.charAt(textIndex)) {
                            break;
                        } else if (textIndex == textToMatch.length() - 1) {
                            return extractValue(buffer, j);
                        }
                    }
                    continue;
                }
                i++;
            }
            return -1;
        } catch (IOException e) {
            return -1;
        } catch (NumberFormatException e2) {
            return -1;
        }
    }

    private static int extractValue(byte[] buffer, int index) {
        while (index < buffer.length && buffer[index] != 10) {
            if (Character.isDigit(buffer[index])) {
                int start = index;
                while (true) {
                    index++;
                    if (index >= buffer.length || !Character.isDigit(buffer[index])) {
                        break;
                    }
                }
                String str = new String(buffer, 0, start, index - start);
                return Integer.parseInt(str);
            }
            index++;
        }
        return -1;
    }

    private static int getCoresFromCPUFiles(String path) {
        File[] list = new File(path).listFiles(CPU_FILTER);
        if (list == null) {
            return 0;
        }
        return list.length;
    }

    private static int getCoresFromFile(String file) {
        InputStream is = null;
        try {
            try {
                is = new FileInputStream(file);
                BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String fileContents = buf.readLine();
                buf.close();
                if (fileContents != null && fileContents.matches("0-[\\d]+$")) {
                    String num = fileContents.substring(2);
                    int parseInt = Integer.parseInt(num) + 1;
                    try {
                        is.close();
                    } catch (IOException e) {
                        BLog.i(TAG, String.format("[getCoresFromFile] error! %s", e.toString()));
                    }
                    return parseInt;
                }
                try {
                    is.close();
                } catch (IOException e2) {
                    BLog.i(TAG, String.format("[getCoresFromFile] error! %s", e2.toString()));
                }
                return 0;
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e3) {
                        BLog.i(TAG, String.format("[getCoresFromFile] error! %s", e3.toString()));
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            BLog.i(TAG, String.format("[getCoresFromFile] error! %s", e4.toString()));
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e5) {
                    BLog.i(TAG, String.format("[getCoresFromFile] error! %s", e5.toString()));
                }
            }
            return 0;
        }
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static long getVmSize() {
        String status = String.format("/proc/%s/status", Integer.valueOf(getAppId()));
        try {
            String content = getStringFromFile(status).trim();
            String[] args = content.split("\n");
            for (String str : args) {
                if (str.startsWith("VmSize")) {
                    Pattern p = Pattern.compile("\\d+");
                    Matcher matcher = p.matcher(str);
                    if (matcher.find()) {
                        return Long.parseLong(matcher.group());
                    }
                }
            }
            if (args.length > 12) {
                Pattern p2 = Pattern.compile("\\d+");
                Matcher matcher2 = p2.matcher(args[12]);
                if (matcher2.find()) {
                    return Long.parseLong(matcher2.group());
                }
            }
            return -1L;
        } catch (Exception e) {
            return -1L;
        }
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    reader.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            if (reader != null) {
                reader.close();
            }
            throw th;
        }
    }

    public static String getStringFromFile(String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(fl);
            String ret = convertStreamToString(fin);
            fin.close();
            return ret;
        } catch (Throwable th) {
            if (fin != null) {
                fin.close();
            }
            throw th;
        }
    }
}