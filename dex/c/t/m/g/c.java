package c.t.m.g;

import android.os.Build;

/* compiled from: TML */
public class c {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f13c;

    public c(String str, String str2, String str3) {
        this.a = str2;
        this.b = str;
        this.f13c = str3;
    }

    public String a() {
        return a(this.f13c);
    }

    public final String a(String str) {
        return str == null ? "" : str;
    }

    public String b() {
        return a(this.b);
    }

    public String c() {
        return a(this.a);
    }

    public String d() {
        return a(Build.MANUFACTURER);
    }

    public String e() {
        return a(i4.f());
    }

    public String f() {
        return "1.7.6";
    }
}