package tv.danmaku.ijk.media.player;

import java.io.BufferedReader;
import java.io.FileReader;
import tv.danmaku.android.log.BLog;

public class IjkMemInfo {
    private static final String TAG = "MemInfo";
    private static IjkMemInfo sInstance;
    private int mMemTotal;

    public static synchronized IjkMemInfo parseMemInfo() {
        synchronized (IjkMemInfo.class) {
            if (sInstance == null) {
                sInstance = new IjkMemInfo();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("/proc/meminfo"));
                    while (true) {
                        try {
                            String line = reader.readLine();
                            if (line == null) {
                                break;
                            } else if (line.startsWith("MemTotal:")) {
                                String[] parts = line.split("\\s+");
                                if (parts.length >= 2) {
                                    sInstance.mMemTotal = Integer.parseInt(parts[1]);
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                reader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    reader.close();
                } catch (Exception e) {
                    BLog.d(TAG, "parse mem info:" + e.getMessage());
                }
                return sInstance;
            }
            return sInstance;
        }
    }

    public static int getMemTotal() {
        IjkMemInfo memInfo = parseMemInfo();
        return memInfo.mMemTotal;
    }
}