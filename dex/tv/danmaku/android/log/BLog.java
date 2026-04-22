package tv.danmaku.android.log;

import android.content.Context;
import java.io.File;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import tv.danmaku.android.log.LogSetting;
import tv.danmaku.android.log.adapters.AndroidLogAdapter;
import tv.danmaku.android.log.adapters.BLogController;
import tv.danmaku.android.log.adapters.DiskLogAdapter;
import tv.danmaku.android.log.adapters.JvmDiskController;
import tv.danmaku.android.log.adapters.MemoryLogAdapter;
import tv.danmaku.android.log.cache.DayExpiredCache;
import tv.danmaku.android.log.internal.ILogger;
import tv.danmaku.android.log.internal.JvmLogger;
import tv.danmaku.android.log.internal.NativeLogger;
import tv.danmaku.android.log.internal.UtilKt;

public class BLog {
    private static ILogger sLogger = new JvmLogger();
    private static BLogController compatController = null;

    private BLog() {
    }

    @Deprecated
    public static void addAdapter(LogAdapter adapter) {
        ILogger s = sLogger;
        if (s instanceof JvmLogger) {
            ((JvmLogger) s).addAdapter(adapter);
        }
    }

    public static void initialize(Context context) {
        if (context == null) {
            return;
        }
        initialize(new LogSetting.Builder(context).build());
    }

    @Deprecated
    public static void setInvoker(Function3<Integer, String, Function0<Integer>, Unit> invoker) {
        ILogger s = sLogger;
        if (s instanceof JvmLogger) {
            ((JvmLogger) s).setLogInvoker(invoker);
        }
    }

    public static synchronized void initialize(LogSetting setting) {
        synchronized (BLog.class) {
            if (setting == null) {
                return;
            }
            if (setting.useMemoryCacheSize() <= 0 && !setting.isDisableNativeLogger()) {
                sLogger = new NativeLogger(setting);
                compatController = new JvmDiskController(setting.getLogDir(), setting.getCacheDir(), setting.getExpiredDay(), setting.getContext());
                return;
            }
            addAdapter(new AndroidLogAdapter(setting.getLogcatPriority(), setting.getDefaultTag()));
            int cacheSize = setting.useMemoryCacheSize();
            if (cacheSize > 0) {
                compatController = new MemoryLogAdapter(setting.getLogfilePriority(), UtilKt.find2Power(cacheSize), setting.maxLogSize(), setting.getDefaultTag(), setting.getContext(), setting.getLogDir());
            } else {
                compatController = new DiskLogAdapter(setting.getLogfilePriority(), setting.getDefaultTag(), setting.getContext(), setting.getLogDir(), setting.getCacheDir(), new DayExpiredCache(setting.getLogDir(), setting.getCacheDir(), setting.getContext(), setting.maxLogSize(), setting.getExpiredDay(), setting.getAutoFlushMillis(), setting.useLollipopAPI(), setting.getBlockAmount(), setting.getPageAmountInBlock(), setting.getCompressionCoreSize()));
            }
            addAdapter((LogAdapter) compatController);
        }
    }

    public static void v(String message) {
        sLogger.log(2, null, null, message);
    }

    public static void v(String tag, String message) {
        sLogger.log(2, tag, null, message);
    }

    public static void v(String message, Throwable throwable) {
        sLogger.log(2, null, throwable, message);
    }

    public static void v(String tag, String message, Throwable throwable) {
        sLogger.log(2, tag, throwable, message);
    }

    public static void v(String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(2, tag, null, lazyMsg);
    }

    public static void v(String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(2, tag, null, lazyMsg);
    }

    public static void vfmt(String tag, String fmt, Object... args) {
        sLogger.logFormat(2, tag, fmt, args);
    }

    public static void d(String message) {
        sLogger.log(3, null, null, message);
    }

    public static void d(String tag, String message) {
        sLogger.log(3, tag, null, message);
    }

    public static void d(String message, Throwable throwable) {
        sLogger.log(3, null, throwable, message);
    }

    public static void d(String tag, String message, Throwable throwable) {
        sLogger.log(3, tag, throwable, message);
    }

    public static void d(String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(3, tag, null, lazyMsg);
    }

    public static void d(String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(3, tag, null, lazyMsg);
    }

    public static void dfmt(String tag, String fmt, Object... args) {
        sLogger.logFormat(3, tag, fmt, args);
    }

    public static void i(String message) {
        sLogger.log(4, null, null, message);
    }

    public static void i(String tag, String message) {
        sLogger.log(4, tag, null, message);
    }

    public static void i(String message, Throwable throwable) {
        sLogger.log(4, null, throwable, message);
    }

    public static void i(String tag, String message, Throwable throwable) {
        sLogger.log(4, tag, throwable, message);
    }

    public static void i(String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(4, tag, null, lazyMsg);
    }

    public static void i(String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(4, tag, null, lazyMsg);
    }

    public static void ifmt(String tag, String fmt, Object... args) {
        sLogger.logFormat(4, tag, fmt, args);
    }

    public static void w(String message) {
        sLogger.log(5, null, null, message);
    }

    public static void w(String tag, String message) {
        sLogger.log(5, tag, null, message);
    }

    public static void w(String message, Throwable throwable) {
        sLogger.log(5, null, throwable, message);
    }

    public static void w(String tag, String message, Throwable throwable) {
        sLogger.log(5, tag, throwable, message);
    }

    public static void w(String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(5, tag, null, lazyMsg);
    }

    public static void w(String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(5, tag, null, lazyMsg);
    }

    public static void wfmt(String tag, String fmt, Object... args) {
        sLogger.logFormat(5, tag, fmt, args);
    }

    public static void e(String message) {
        sLogger.log(6, null, null, message);
    }

    public static void e(String tag, String message) {
        sLogger.log(6, tag, null, message);
    }

    public static void e(String message, Throwable throwable) {
        sLogger.log(6, null, throwable, message);
    }

    public static void e(String tag, String message, Throwable throwable) {
        sLogger.log(6, tag, throwable, message);
    }

    public static void e(String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(6, tag, null, lazyMsg);
    }

    public static void e(String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(6, tag, null, lazyMsg);
    }

    public static void efmt(String tag, String fmt, Object... args) {
        sLogger.logFormat(6, tag, fmt, args);
    }

    public static void wtf(String message) {
        sLogger.log(7, null, null, message);
    }

    public static void wtf(String tag, String message) {
        sLogger.log(7, tag, null, message);
    }

    public static void wtf(String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(7, tag, null, lazyMsg);
    }

    public static void wtf(String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(7, tag, t, lazyMsg);
    }

    public static void wtffmt(String tag, String fmt, Object... args) {
        sLogger.logFormat(7, tag, fmt, args);
    }

    public static void event(String message) {
        sLogger.event(null, message);
    }

    public static void event(String tag, String message) {
        sLogger.event(tag, message);
    }

    public static void log(int priority, String tag, String message) {
        sLogger.log(priority, tag, null, message);
    }

    public static void log(int priority, String tag, Throwable t, String message) {
        sLogger.log(priority, tag, t, message);
    }

    public static void log(int priority, String tag, Function0<Object> lazyMsg) {
        sLogger.logLazy(priority, tag, null, lazyMsg);
    }

    public static void log(int priority, String tag, Throwable t, Function0<Object> lazyMsg) {
        sLogger.logLazy(priority, tag, t, lazyMsg);
    }

    public static void syncLog(int priority, String message) {
        sLogger.log(priority, null, null, message);
        flush();
    }

    public static void syncLog(int priority, String tag, String message) {
        sLogger.log(priority, tag, null, message);
        flush();
    }

    public static File[] getLogFiles(int mode) {
        if (compatController != null) {
            return compatController.queryLogFiles(null);
        }
        return null;
    }

    public static File[] getLogFilesByDate(int mode, Date date) {
        if (compatController != null) {
            return compatController.queryLogFiles(date != null ? Long.valueOf(date.getTime()) : null);
        }
        return null;
    }

    public static File zippingLogFiles(int mode, List<File> attaches) {
        if (compatController != null) {
            return compatController.zippingLogFiles(null, attaches);
        }
        return null;
    }

    public static File zippingLogFilesByDate(int mode, Date date, List<File> attaches) {
        if (compatController != null) {
            if (date == null) {
                date = new Date();
            }
            return compatController.zippingLogFiles(Long.valueOf(date.getTime()), attaches);
        }
        return null;
    }

    public static File getLogDir() {
        if (compatController != null) {
            return compatController.getCurLogDir();
        }
        return null;
    }

    public static void addExtraDirForZip(File dir) {
        if (compatController != null) {
            compatController.addExtraDir(dir);
        }
    }

    public static void deleteLogs() {
        if (compatController != null) {
            compatController.clear();
        }
    }

    public static void cleanExpiredFiles() {
        if (compatController != null) {
            compatController.cleanExpiredFiles();
        }
    }

    public static ILogger getLogger() {
        return sLogger;
    }

    public static void flush() {
        sLogger.flush();
    }
}