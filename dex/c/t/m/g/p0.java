package c.t.m.g;

import com.bilibili.datacenter.hakase.protobuf.AndroidDeviceInfo;

/* compiled from: TML */
public class p0 {
    public static final int[] d = {31, AndroidDeviceInfo.DeviceInfo.BATTERY_TECHNOLOGY_FIELD_NUMBER, 239, 397, 439, 557, 619, 773, 853, 977};
    public byte[] a = new byte[0];
    public a[] b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f79c;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a(String str) {
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i = str.charAt(i2) + (this.b * i);
            }
            return (this.a - 1) & i;
        }
    }

    public p0(int i, int i2) {
        int i3 = 0;
        this.b = new a[Math.min(Math.max(1, i2), d.length)];
        while (true) {
            a[] aVarArr = this.b;
            if (i3 < aVarArr.length) {
                aVarArr[i3] = new a(i * 8, d[i3]);
                i3++;
            } else {
                this.f79c = new byte[i];
                return;
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this.a) {
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.f79c, 0, Math.min(bArr.length, this.f79c.length));
            }
        }
    }

    public boolean b(String str) {
        synchronized (this.a) {
            if (str == null) {
                return false;
            }
            for (a aVar : this.b) {
                if (!x2.a(this.f79c, aVar.a(str))) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte[] a() {
        byte[] bArr;
        synchronized (this.a) {
            bArr = this.f79c;
        }
        return bArr;
    }

    public void a(String str) {
        synchronized (this.a) {
            for (a aVar : this.b) {
                x2.a(this.f79c, aVar.a(str), true);
            }
        }
    }
}