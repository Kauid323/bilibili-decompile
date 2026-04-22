package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

/* compiled from: TML */
public class q5 {
    public int a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<a> f87c;
    public c5 d;

    public q5(int i, int i2) {
        if (i < i2) {
            throw new IllegalArgumentException("maxSize should >= coreSize");
        }
        if (i2 >= 3) {
            this.f87c = new LinkedList<>();
            this.a = i;
            this.b = i2;
            this.d = new c5();
            return;
        }
        throw new IllegalArgumentException("coreSize should >= 3");
    }

    public synchronized void a(TencentLocation tencentLocation) {
        this.f87c.add(a.a(tencentLocation));
        if (this.f87c.size() > this.a) {
            this.f87c.removeFirst();
        }
    }

    public synchronized void b() {
        this.f87c.clear();
        this.d.c();
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class a {
        public double a;
        public double b;

        /* renamed from: c  reason: collision with root package name */
        public long f88c;
        public int d;

        public boolean a(a aVar) {
            return g7.a(this.a, this.b, aVar.a, aVar.b) / (((double) (Math.abs(this.f88c - aVar.f88c) + 1)) / 1000.0d) <= 100.0d;
        }

        public String toString() {
            return "[" + this.a + "," + this.b + "]";
        }

        public static a a(TencentLocation tencentLocation) {
            a aVar = new a();
            aVar.a = tencentLocation.getLatitude();
            aVar.b = tencentLocation.getLongitude();
            aVar.f88c = tencentLocation.getTime();
            tencentLocation.getSpeed();
            if (TencentLocationUtils.isFromGps(tencentLocation)) {
                aVar.d = tencentLocation.getAccuracy() < 100.0f ? 3 : 2;
            } else {
                aVar.d = tencentLocation.getAccuracy() >= 500.0f ? 1 : 2;
            }
            return aVar;
        }
    }

    public synchronized void a(p6 p6Var) {
        if (!p6Var.getProvider().equalsIgnoreCase("gps") || Boolean.parseBoolean(f7.a().get("gps_kalman"))) {
            if (this.f87c.size() == 0) {
                return;
            }
            this.d.a(p6Var.getLatitude(), p6Var.getLongitude(), p6Var.getAccuracy(), p6Var.getTime());
            p6Var.a(this.d.a(), this.d.b());
        }
    }

    public boolean a(TencentLocation tencentLocation, m4 m4Var, boolean z) {
        return a(a.a(tencentLocation), m4Var, z);
    }

    public final synchronized boolean a(a aVar, m4 m4Var, boolean z) {
        if (m4Var != null) {
            LinkedList<a> linkedList = this.f87c;
            if (linkedList != null && linkedList.size() != 0) {
                int i = aVar.d;
                if (i == 3) {
                    return true;
                }
                if (i == 1 && !j7.b(m4Var) && !j7.c(m4Var) && !z) {
                    return true;
                }
                if (aVar.f88c - this.f87c.getLast().f88c > 120000) {
                    this.f87c.clear();
                    return true;
                } else if (a()) {
                    LinkedList<a> linkedList2 = this.f87c;
                    ListIterator<a> listIterator = linkedList2.listIterator(linkedList2.size());
                    int i2 = 0;
                    int i3 = 0;
                    while (listIterator.hasPrevious()) {
                        if (!listIterator.previous().a(aVar)) {
                            i2++;
                        }
                        i3++;
                        if (i3 > this.b) {
                            break;
                        }
                    }
                    if (i2 > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean a() {
        return this.f87c.size() >= this.b;
    }
}