package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TML */
public class e6 extends p1 {
    public static final e6 d = new e6(Collections.emptyList(), 0, 0);
    public final List<ScanResult> a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28c;

    public e6(List<ScanResult> list, long j, int i) {
        this.b = j;
        this.f28c = i;
        this.a = new ArrayList(list);
    }

    @Override // c.t.m.g.p1
    public int a() {
        return 10004;
    }

    public boolean a(long j, long j2) {
        boolean z = j - this.b < j2;
        a7.c("BaseBusData", "wifi info isFresh: " + j + "," + this.b + "," + j2 + ",res=" + z);
        return z;
    }

    public List<ScanResult> b() {
        return Collections.unmodifiableList(this.a);
    }

    public long c() {
        return this.b;
    }

    public int d() {
        return this.f28c;
    }

    public String toString() {
        return "mTime: " + this.b + ", mWifiStatus: " + this.f28c + ", mScanResultList size: " + this.a.size();
    }

    public boolean a(e6 e6Var) {
        if (e6Var == null) {
            return false;
        }
        List<ScanResult> list = e6Var.a;
        List<ScanResult> list2 = this.a;
        if (list == null || list2 == null || list.size() == 0 || list2.size() == 0) {
            return false;
        }
        return !r5.a(list, list2);
    }
}