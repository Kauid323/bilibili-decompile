package c.t.m.g;

import android.content.Context;
import android.os.Process;
import android.util.Log;

/* compiled from: TML */
public class a7 {
    public static volatile boolean a = false;
    public static i6 b;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements d2 {
        @Override // c.t.m.g.d2
        public void a(int i, String str, String str2, Throwable th) {
            a7.c(str, str2 + ",exp:" + w3.a(th));
        }
    }

    public static void a(Context context) {
        if (a) {
            b = new i6(context, context.getExternalFilesDir("t_log"));
            b2.a(new a());
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            a(str, 6, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            a(str, 4, str2);
        }
    }

    public static void a(String str, String str2) {
        if (a) {
            a(str, 3, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            a(str, 6, str2 + " exception: " + Log.getStackTraceString(th));
        }
    }

    public static void a(String str) {
        a("#", 4, str);
    }

    public static void a(String str, int i, String str2) {
        i6 i6Var;
        if (!a || str2 == null || (i6Var = b) == null) {
            return;
        }
        i6Var.a(str, i, "[" + Process.myPid() + "][" + Thread.currentThread().getName() + "]," + str2);
    }
}