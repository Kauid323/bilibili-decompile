package c.t.m.g;

import java.util.Arrays;

/* compiled from: TML */
public class t2 {
    public int a;
    public int[] b;

    /* renamed from: c  reason: collision with root package name */
    public int f99c;
    public int d;
    public int e;

    public t2(int i) {
        if (i > 0) {
            this.a = i;
            this.b = new int[i];
            a();
            return;
        }
        throw new IllegalArgumentException("cacheSize max > 0.");
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f99c = 0;
        Arrays.fill(this.b, 0);
    }

    public int b() {
        return this.a;
    }

    public int c() {
        int i = this.e;
        int i2 = this.a;
        return i < i2 ? i : i2;
    }

    public final int b(int i) {
        int i2 = this.e;
        int i3 = this.a;
        return i2 < i3 ? i : ((this.d + i) + i3) % i3;
    }

    public int c(int i) {
        if (i >= 0 && i < c()) {
            return this.b[b(i)];
        }
        throw new ArrayIndexOutOfBoundsException("cache max size is " + this.a + ",current size is " + c() + ",index is " + i);
    }

    public void a(int i) {
        int i2 = this.f99c;
        int[] iArr = this.b;
        int i3 = this.d;
        int i4 = i2 - iArr[i3];
        this.f99c = i4;
        this.f99c = i4 + i;
        iArr[i3] = i;
        int i5 = i3 + 1;
        this.d = i5;
        if (i5 == this.a) {
            this.d = 0;
        }
        int i6 = this.e;
        if (i6 < Integer.MAX_VALUE) {
            this.e = i6 + 1;
        }
    }
}