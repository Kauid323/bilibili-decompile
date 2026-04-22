package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: TML */
public class e7 {
    public static Context a;

    public static void a(Context context) {
        a = context;
    }

    public static void b(String str, String str2, int i) {
        SharedPreferences.Editor edit = a.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        edit.apply();
    }

    public static int a(String str, String str2, int i) {
        Context context = a;
        return context == null ? i : context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static void b(String str, String str2, long j) {
        SharedPreferences.Editor edit = a.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j);
        edit.apply();
    }

    public static long a(String str, String str2, long j) {
        Context context = a;
        return context == null ? j : context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static void b(String str, String str2, String str3) {
        SharedPreferences.Editor edit = a.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static String a(String str, String str2, String str3) {
        Context context = a;
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }
}