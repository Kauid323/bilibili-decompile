package c.t.m.g;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TML */
public class t7 {
    public static boolean a = false;
    public static u7 b;

    public static void a(u7 u7Var) {
        b = u7Var;
    }

    public static void a(String str, String str2) {
        a(str, 4, str2);
    }

    public static void a(String str, int i, String str2) {
        if (a) {
            String name = Thread.currentThread().getName();
            Log.e(str, "t:" + name + "," + str2);
            String str3 = System.currentTimeMillis() + ",t:" + name + "," + str2;
            if (b != null) {
                new SimpleDateFormat("HH:mm:ss").format(new Date());
                b.a(str, str2);
            }
            s7 a2 = s7.a();
            if (a2 != null) {
                a2.a(str, i, str3);
            }
        }
    }

    public static void a(Context context, File file) {
        if (a) {
            s7.a(context, file);
        }
    }
}