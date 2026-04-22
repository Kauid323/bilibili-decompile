package tv.danmaku.android.util;

import android.util.Log;
import tv.danmaku.android.log.BLog;

@Deprecated
public class DebugLog {
    public static int LOG_LV = 6;
    public static final int LOG_LV_MAX = 6;
    public static final int LOG_LV_MIN = 3;

    public static int e(String tag, String msg) {
        if (msg != null && LOG_LV <= 6) {
            BLog.e(tag, msg);
        }
        return 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (LOG_LV <= 6) {
            BLog.e(tag, msg, tr);
            return 0;
        }
        return 0;
    }

    public static int efmt(String tag, String fmt, Object... args) {
        if (LOG_LV <= 6) {
            BLog.efmt(tag, fmt, args);
            return 0;
        }
        return 0;
    }

    public static int i(String tag, String msg) {
        if (msg != null && LOG_LV <= 4) {
            BLog.i(tag, msg);
        }
        return 0;
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (LOG_LV <= 4) {
            BLog.i(tag, msg, tr);
            return 0;
        }
        return 0;
    }

    public static int ifmt(String tag, String fmt, Object... args) {
        if (LOG_LV <= 4) {
            BLog.ifmt(tag, fmt, args);
            return 0;
        }
        return 0;
    }

    public static int w(String tag, String msg) {
        if (msg != null && LOG_LV <= 5) {
            BLog.w(tag, msg);
        }
        return 0;
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (LOG_LV <= 5) {
            BLog.w(tag, msg, tr);
            return 0;
        }
        return 0;
    }

    public static int wfmt(String tag, String fmt, Object... args) {
        if (LOG_LV <= 5) {
            BLog.wfmt(tag, fmt, args);
            return 0;
        }
        return 0;
    }

    public static int d(String tag, String msg) {
        if (msg != null && LOG_LV <= 3) {
            BLog.d(tag, msg);
        }
        return 0;
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (LOG_LV <= 3) {
            BLog.d(tag, msg, tr);
            return 0;
        }
        return 0;
    }

    public static int dfmt(String tag, String fmt, Object... args) {
        if (LOG_LV <= 3) {
            BLog.dfmt(tag, fmt, args);
            return 0;
        }
        return 0;
    }

    public static int v(String tag, String msg) {
        if (msg != null && LOG_LV <= 2) {
            BLog.v(tag, msg);
        }
        return 0;
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (LOG_LV <= 2) {
            BLog.v(tag, msg, tr);
            return 0;
        }
        return 0;
    }

    public static int vfmt(String tag, String fmt, Object... args) {
        if (LOG_LV <= 2) {
            BLog.vfmt(tag, fmt, args);
            return 0;
        }
        return 0;
    }

    public static void printStackTrace(Throwable e) {
        if (LOG_LV <= 5) {
            e.printStackTrace();
        }
    }

    public static void printCause(Throwable e) {
        if (LOG_LV <= 5) {
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            printStackTrace(e);
        }
    }

    public static void println(int level, String tag, String message) {
        if (LOG_LV <= level) {
            Log.println(level, tag, message);
        }
    }
}