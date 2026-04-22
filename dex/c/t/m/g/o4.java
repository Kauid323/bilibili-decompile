package c.t.m.g;

import android.os.Bundle;

/* compiled from: TML */
public abstract class o4 {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77c = true;

    public o4(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void a() {
    }

    public boolean a(Bundle bundle) {
        if (this.f77c) {
            return b(bundle);
        }
        return false;
    }

    public abstract boolean b(Bundle bundle);

    public String toString() {
        return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.f77c + "]";
    }
}