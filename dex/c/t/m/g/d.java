package c.t.m.g;

/* compiled from: TML */
public class d {
    public final int a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17c;
    public final int d;
    public final long e;
    public final int f;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum a {
        NONE,
        GSM,
        CDMA,
        WCDMA,
        LTE,
        NR,
        TEMP6,
        TEMP7,
        NOSIM
    }

    public d(int i, int i2, int i3, long j, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.f17c = i3;
        this.e = j;
        this.d = i4;
        this.f = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && this.f17c == dVar.f17c && this.e == dVar.e;
    }

    public String toString() {
        return "CellCoreInfo{MCC=" + this.a + ", MNC=" + this.b + ", LAC=" + this.f17c + ", RSSI=" + this.d + ", CID=" + this.e + ", PhoneType=" + this.f + '}';
    }
}