package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TML */
public class q2 {
    public static q2 e = new q2();
    public static final Comparator<byte[]> f = new a();
    public final List<byte[]> a = new ArrayList(32);
    public final List<byte[]> b = new ArrayList(32);

    /* renamed from: c  reason: collision with root package name */
    public int f85c = 0;
    public int d = 10240;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public static q2 a() {
        return e;
    }

    public final synchronized void b() {
        while (this.f85c > this.d) {
            byte[] remove = this.a.remove(0);
            this.b.remove(remove);
            this.f85c -= remove.length;
        }
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            byte[] bArr = this.b.get(i2);
            if (bArr.length == i) {
                this.f85c -= bArr.length;
                this.b.remove(i2);
                this.a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                Arrays.fill(bArr, (byte) 0);
                this.a.add(bArr);
                int binarySearch = Collections.binarySearch(this.b, bArr, f);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, bArr);
                this.f85c += bArr.length;
                b();
            }
        }
    }
}