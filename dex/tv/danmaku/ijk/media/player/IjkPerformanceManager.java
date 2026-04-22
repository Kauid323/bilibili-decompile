package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tv.danmaku.android.log.BLog;

public class IjkPerformanceManager {
    private static final String TAG = "IjkPerformanceManager";
    private static IjkPerformanceManager sIjkPerformanceManager = null;
    private static long sJiffyMillis = 10;
    private Context mAppContext;
    private HashMap<String, ProcessState> mProcs = new HashMap<>();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SampleValue {
        public double cpu;
        public int curBatteryLevel;
        public boolean isCharging;
        public long memory;
        public long thread;
        public Bundle threadRecord = new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class ProcessState {
        public RandomAccessFile mAppMemFile;
        public RandomAccessFile mAppStatFile;
        public boolean mHasSampledFirstCpu;
        public Long mLastAppCpuTime;
        public Long mLastCpuTime;
        public Long mLastSampleTime;
        SampleValue sampleValue;

        private ProcessState() {
            this.mHasSampledFirstCpu = false;
            this.sampleValue = new SampleValue();
        }
    }

    private IjkPerformanceManager(Context context) {
        this.mAppContext = null;
        if (context != null) {
            this.mAppContext = context.getApplicationContext();
        }
        this.mProcs.put(String.valueOf(Process.myPid()), new ProcessState());
    }

    public static synchronized IjkPerformanceManager getInstance(Context context) {
        IjkPerformanceManager ijkPerformanceManager;
        synchronized (IjkPerformanceManager.class) {
            if (sIjkPerformanceManager == null) {
                sIjkPerformanceManager = new IjkPerformanceManager(context);
            }
            ijkPerformanceManager = sIjkPerformanceManager;
        }
        return ijkPerformanceManager;
    }

    private synchronized void sampleBatteryInfo(SampleValue sValue) {
        boolean z;
        BatteryManager batteryManager = (BatteryManager) this.mAppContext.getSystemService("batterymanager");
        sValue.curBatteryLevel = batteryManager.getIntProperty(4);
        if (Build.VERSION.SDK_INT >= 26) {
            int status = batteryManager.getIntProperty(6);
            if (status != 2 && status != 5) {
                z = false;
                sValue.isCharging = z;
            }
            z = true;
            sValue.isCharging = z;
        }
    }

    private synchronized void sampleCpuAndThread(ProcessState stat, int pid) {
        try {
            if (stat.mAppStatFile == null) {
                stat.mAppStatFile = new RandomAccessFile("/proc/" + pid + "/stat", "r");
            }
            RandomAccessFile appStatFile = stat.mAppStatFile;
            appStatFile.seek(0L);
            String appStatString = appStatFile.readLine();
            String[] appStats = appStatString.split(" ");
            long cpuTime = SystemClock.uptimeMillis();
            double cpu = 0.0d;
            long appTime = Long.parseLong(appStats[13]) + Long.parseLong(appStats[14]);
            if (stat.mLastCpuTime != null && stat.mLastAppCpuTime != null) {
                cpu = (((appTime - stat.mLastAppCpuTime.longValue()) * sJiffyMillis) / (cpuTime - stat.mLastCpuTime.longValue())) * 100.0d;
                stat.mHasSampledFirstCpu = true;
            }
            stat.mLastCpuTime = Long.valueOf(cpuTime);
            stat.mLastAppCpuTime = Long.valueOf(appTime);
            stat.sampleValue.cpu = cpu >= 0.0d ? cpu : 0.0d;
            stat.sampleValue.thread = Long.parseLong(appStats[19]);
        } catch (Exception e) {
            BLog.w(TAG, e);
        }
    }

    private synchronized void sampleThreadRecord(Bundle threadRecord, int pid) {
        Throwable th;
        File directory = new File("/proc/" + pid + "/task");
        File[] files = directory.listFiles();
        if (threadRecord != null && files != null) {
            threadRecord.clear();
            for (File file : files) {
                if (file.isDirectory()) {
                    String tid = file.getName();
                    try {
                        RandomAccessFile nameFile = new RandomAccessFile("/proc/" + pid + "/task/" + tid + "/comm", "r");
                        try {
                            nameFile.seek(0L);
                            String threadName = nameFile.readLine();
                            String[] parts = threadName.split("_");
                            if (parts.length > 1) {
                                try {
                                    if (!parts[0].equals("ijk") && !parts[0].equals("ig")) {
                                        if (parts[0].toLowerCase().contains("binder")) {
                                            threadRecord.putInt("binder", threadRecord.getInt("binder", 0) + 1);
                                        }
                                    }
                                    String ijk_module = parts[0] + "_" + parts[1];
                                    threadRecord.putInt(ijk_module, threadRecord.getInt(ijk_module, 0) + 1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        nameFile.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th;
                                    break;
                                }
                            }
                            nameFile.close();
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (IOException e) {
                        BLog.w(TAG, e);
                    }
                }
            }
        }
    }

    private synchronized void sampleMemory(ProcessState stat, int pid) {
        try {
            if (stat.mAppMemFile == null) {
                stat.mAppMemFile = new RandomAccessFile("/proc/" + pid + "/statm", "r");
            }
            RandomAccessFile appMemFile = stat.mAppMemFile;
            appMemFile.seek(0L);
            String line = appMemFile.readLine();
            String[] parts = line.split("\\s+");
            long uss = 0;
            if (parts.length > 6) {
                uss = Long.parseLong(parts[1].trim()) - Long.parseLong(parts[2].trim());
            }
            stat.sampleValue.memory = 4 * uss * 1024;
        } catch (Exception e) {
            BLog.w(TAG, e);
        }
    }

    public synchronized SampleValue sampleState(int pid) {
        ProcessState stat;
        stat = this.mProcs.get(String.valueOf(pid));
        if (stat == null) {
            this.mProcs.put(String.valueOf(pid), new ProcessState());
            stat = this.mProcs.get(String.valueOf(pid));
        }
        if (stat.mLastSampleTime == null || !stat.mHasSampledFirstCpu || SystemClock.elapsedRealtime() - stat.mLastSampleTime.longValue() >= 30000) {
            sampleBatteryInfo(stat.sampleValue);
            sampleCpuAndThread(stat, pid);
            sampleMemory(stat, pid);
            sampleThreadRecord(stat.sampleValue.threadRecord, pid);
            stat.mLastSampleTime = Long.valueOf(SystemClock.elapsedRealtime());
        }
        return stat.sampleValue;
    }

    public synchronized void reset() {
        try {
            for (String key : this.mProcs.keySet()) {
                ProcessState state = this.mProcs.get(key);
                if (state != null) {
                    if (state.mAppStatFile != null) {
                        state.mAppStatFile.close();
                    }
                    if (state.mAppMemFile != null) {
                        state.mAppMemFile.close();
                    }
                }
            }
        } catch (Exception e) {
        }
        this.mProcs.clear();
    }
}