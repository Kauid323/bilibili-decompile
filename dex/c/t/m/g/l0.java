package c.t.m.g;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TML */
public class l0 {
    public static boolean a = false;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f58c = "xiaowei";

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements d2 {
        @Override // c.t.m.g.d2
        public void a(int i, String str, String str2, Throwable th) {
            if (l0.a) {
                l0.a(str, str2);
            }
        }
    }

    public static void a(String str, String str2) {
        a(str, 4, str2);
    }

    public static void a(String str, int i, String str2) {
        if (a) {
            String name = Thread.currentThread().getName();
            Log.e(str, "t:" + name + "," + str2);
            String str3 = str2 + "," + System.currentTimeMillis() + ",线程:" + name;
            k0 b2 = k0.b();
            if (b2 != null) {
                b2.a(str, i, str3);
            }
        }
    }

    public static void a(Context context) {
        if (!a || b) {
            return;
        }
        b = true;
        new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        k0.a(context, new File(a(context, "module_log")));
        b2.a(new a());
    }

    public static String a(Context context, String str) {
        File file;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                file = new File(m3.a(context, com.alipay.sdk.m.l.e.m).getAbsolutePath(), f58c + File.separator + str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), f58c + File.separator + str);
            }
        } catch (Exception e) {
            Log.e("ModuleLog", "getLogPath", e);
            file = new File(context.getFilesDir().getAbsolutePath(), f58c + File.separator + str);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        Log.e("ModuleLog", "ModuleLog path:" + absolutePath);
        return absolutePath;
    }
}