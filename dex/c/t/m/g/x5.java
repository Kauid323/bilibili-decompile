package c.t.m.g;

import android.location.Location;

/* compiled from: TML */
public class x5 extends p1 {
    public final Location a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f120c;
    public final int d;
    public final int e;
    public final a f;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum a {
        NONE,
        GPS,
        PDR,
        VDR
    }

    public x5(x5 x5Var) {
        this.a = x5Var.a == null ? null : new Location(x5Var.a);
        this.b = x5Var.b;
        this.f120c = x5Var.f120c;
        this.d = x5Var.d;
        this.e = x5Var.e;
        this.f = x5Var.f;
    }

    @Override // c.t.m.g.p1
    public int a() {
        return 10002;
    }

    public String toString() {
        return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.f120c + ", usedSatelliteNum=" + this.d + ", gpsStatus=" + this.e + "]";
    }

    public x5(Location location, long j, int i, int i2, int i3, a aVar) {
        this.a = location;
        this.b = j;
        this.f120c = i;
        this.d = i2;
        this.e = i3;
        this.f = aVar;
    }
}