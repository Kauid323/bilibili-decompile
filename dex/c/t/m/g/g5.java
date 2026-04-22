package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

/* compiled from: TML */
public class g5 {
    public static g5 e = new g5();
    public LinkedList<x5> a;
    public LinkedList<a> b;

    /* renamed from: c  reason: collision with root package name */
    public int f36c;
    public double[] d;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a {
        public long a;
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum b {
        UNKNOW,
        MOVE,
        STATIC
    }

    public g5() {
        b bVar = b.UNKNOW;
        this.a = new LinkedList<>();
        this.b = new LinkedList<>();
        this.f36c = -1;
        this.d = new double[]{0.0d, 0.0d};
    }

    public static g5 b() {
        return e;
    }

    public final boolean a(x5 x5Var) {
        while (this.a.size() > 9) {
            this.a.remove(0);
        }
        while (this.a.size() > 0) {
            x5 first = this.a.getFirst();
            long j = x5Var.b - first.b;
            double a2 = g7.a(first.a.getLatitude(), first.a.getLongitude(), x5Var.a.getLatitude(), x5Var.a.getLongitude());
            if (j <= 180000 || a2 <= 500.0d) {
                break;
            }
            this.a.remove(0);
        }
        int size = this.a.size();
        if (size >= 5) {
            int i = 0;
            for (int i2 = size - 2; i2 >= 0; i2--) {
                if (!a(x5Var.a, this.a.get(i2).a)) {
                    i++;
                }
            }
            if (i < 4 || x5Var.a.getAccuracy() >= 20.0f) {
                return true;
            }
            a7.b("TxGpsMotionStat", "4 times same! fake");
            return false;
        }
        return true;
    }

    public final boolean c() {
        if (this.b.isEmpty()) {
            return true;
        }
        double[] a2 = a();
        return System.currentTimeMillis() - this.b.getLast().a >= 5000 || this.f36c != 1 || (a2[0] <= 5.0d && a2[1] <= 5.0d);
    }

    public synchronized int b(x5 x5Var) {
        if (x5Var != null) {
            x5 x5Var2 = new x5(x5Var);
            this.a.add(x5Var2);
            if (!a(x5Var2)) {
                return -1;
            }
            if (!c()) {
                return -2;
            }
        }
        return this.a.size();
    }

    public final boolean a(Location location, Location location2) {
        if (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) {
            return false;
        }
        return Math.abs(location.getLatitude() - location2.getLatitude()) >= 1.0E-7d || Math.abs(location.getLongitude() - location2.getLongitude()) >= 1.0E-7d;
    }

    public double[] a() {
        double[] dArr = this.d;
        double d = 0.0d;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        if (this.a.size() < 2) {
            return this.d;
        }
        int size = this.a.size();
        double d2 = 0.0d;
        long j = 0;
        for (int i = 1; i < size; i++) {
            x5 x5Var = this.a.get(i);
            x5 x5Var2 = this.a.get(i - 1);
            d2 += g7.a(x5Var2.a.getLatitude(), x5Var2.a.getLongitude(), x5Var.a.getLatitude(), x5Var.a.getLongitude());
            j += x5Var.b - x5Var2.b;
            d += x5Var2.a.getSpeed();
        }
        double speed = d + this.a.getLast().a.getSpeed();
        if (j > 0) {
            double[] dArr2 = this.d;
            dArr2[0] = speed / size;
            dArr2[1] = (d2 / j) * 1000.0d;
        }
        return this.d;
    }
}