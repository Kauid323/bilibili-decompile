package c.t.m.g;

import android.content.SharedPreferences;

/* compiled from: TML */
public class h4 {
    public static volatile SharedPreferences a;

    public static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (h4.class) {
            if (a == null) {
                a = b3.a().getSharedPreferences("LocationSDK", 0);
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static void b(String str, String str2, Object obj) {
        b(a(str), str2, obj);
    }

    public static void b(SharedPreferences sharedPreferences, String str, Object obj) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        edit.apply();
    }

    public static SharedPreferences a(String str) {
        if ("LocationSDK".equals(str)) {
            return a();
        }
        return b3.a().getSharedPreferences(str, "com.tencent.mobileqq".equals(b3.a().getPackageName()) ? 4 : 0);
    }

    public static Object a(String str, String str2, Object obj) {
        return a(a(str), str2, obj);
    }

    public static Object a(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void b(SharedPreferences sharedPreferences, String str, String str2) {
        b(sharedPreferences, str, (Object) h3.b(str2));
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        String str3 = (String) a(sharedPreferences, str, (Object) "");
        if (d4.a(str3)) {
            return str2;
        }
        String a2 = h3.a(str3);
        if (d4.a(a2)) {
            b(sharedPreferences, str, (Object) "");
        }
        return d4.a(a2) ? str2 : a2;
    }
}