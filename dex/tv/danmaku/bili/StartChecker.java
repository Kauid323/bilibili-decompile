package tv.danmaku.bili;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bilibili.gripper.GripperExecute;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.performance.UtilsKt;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.report.startup.StartupApm;
import tv.danmaku.bili.report.startup.v2.BootTagHolder;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.report.startup.v2.StartUpUtilsKt;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;

public final class StartChecker {
    private static final String TRACE_TAG = "MainActivity";
    private static long sStart;
    private static Boolean CFLAG = null;
    private static boolean isFirst = true;

    private StartChecker() {
        throw new RuntimeException("should not be instantiated!");
    }

    private static boolean checkFirstStartInThisVersion(Context context) {
        if (CFLAG != null) {
            return CFLAG.booleanValue();
        }
        if (context == null) {
            return false;
        }
        try {
            CFLAG = false;
            File file = context.getFileStreamPath("last.run");
            int lastCode = -1;
            String lastName = "";
            if (file.exists()) {
                FileInputStream f = new FileInputStream(file);
                DataInputStream data = new DataInputStream(f);
                try {
                    lastCode = data.readInt();
                    lastName = data.readUTF();
                    data.close();
                    f.close();
                } catch (Throwable th) {
                    try {
                        data.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (lastCode == Foundation.instance().getApps().getVersionCode() && TextUtils.equals(Foundation.instance().getApps().getVersionName(), lastName)) {
                if (BuildConfig.DEBUG) {
                    Log.i("StartChecker", "run in same version");
                }
                return false;
            }
            ByteArrayOutputStream buf = new ByteArrayOutputStream(MisakaHelper.MAX_REPORT_SIZE);
            DataOutputStream data2 = new DataOutputStream(buf);
            data2.writeInt(Foundation.instance().getApps().getVersionCode());
            data2.writeUTF(Foundation.instance().getApps().getVersionName());
            byte[] bytes = buf.toByteArray();
            FileOutputStream f2 = new FileOutputStream(file);
            f2.write(bytes);
            f2.close();
            if (BuildConfig.DEBUG) {
                Log.i("StartChecker", "run in new version");
            }
            CFLAG = true;
            return true;
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                Log.w("StartChecker", e);
            }
            return false;
        }
    }

    public static boolean isFirstStartInThisVersion(Application app) {
        return checkFirstStartInThisVersion(app);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mainActivityRan() {
        if (isFirst) {
            BootTracer.beginSession(BootTagHolder.TAG_MAIN_INIT);
            BootTracer.beginSession(BootTagHolder.TAG_MAIN_FRAME_INIT);
            sStart = SystemClock.elapsedRealtime();
        }
    }

    public static void postMainActivityRan(final View view) {
        if (!isFirst) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: tv.danmaku.bili.StartChecker.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                StartUpUtilsKt.startUpTrace("onPreDraw");
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                StartupApm.setLayoutTime(SystemClock.elapsedRealtime() - StartChecker.sStart);
                BootTracer.endSession(BootTagHolder.TAG_MAIN_INIT);
                BootTracer.end();
                BootTracerV2.INSTANCE.recordTime(BootTracerV2.BOOT_END);
                BootTracerV2.INSTANCE.report();
                UtilsKt.bootOpt(new Function1<String, Unit>() { // from class: tv.danmaku.bili.StartChecker.1.1
                    public Unit invoke(String s) {
                        GripperExecute.Companion.of().trigger(s);
                        return Unit.INSTANCE;
                    }
                });
                return true;
            }
        });
        isFirst = false;
    }
}