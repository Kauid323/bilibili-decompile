package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.IFDLog;
import com.bilibili.lib.crashreport.CrashReporter;
import tv.danmaku.android.log.BLog;

public class FreeDataLogImpl implements IFDLog {
    private static FreeDataLogImpl INSTANCE = new FreeDataLogImpl();

    private FreeDataLogImpl() {
    }

    public static FreeDataLogImpl getInstance() {
        return INSTANCE;
    }

    public void i(String tag, String message) {
        BLog.i(tag, message);
    }

    public void d(String tag, String message) {
        BLog.d(tag, message);
    }

    public void dfmt(String tag, String fmt, Object... args) {
        BLog.dfmt(tag, fmt, args);
    }

    public void w(String tag, String message) {
        BLog.w(tag, message);
    }

    public void e(String tag, String message) {
        BLog.e(tag, message);
    }

    public void e(String tag, String message, Throwable throwable) {
        BLog.e(tag, message, throwable);
        if (throwable != null) {
            CrashReporter.INSTANCE.postCaughtException(throwable);
        }
    }

    public void event(String tag, String message) {
        BLog.event(tag, message);
    }
}