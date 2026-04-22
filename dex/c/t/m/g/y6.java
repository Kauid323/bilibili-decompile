package c.t.m.g;

import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: TML */
public class y6 {
    public static int a(int i) {
        if (i <= 32) {
            return 1;
        }
        if (i <= 64) {
            return 2;
        }
        if (i <= 96) {
            return 3;
        }
        if (i < 193 || i > 195) {
            return (i < 201 || i > 235) ? -1 : 5;
        }
        return 4;
    }

    public static u5 a(Object obj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        u5 u5Var = new u5();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        int i12 = 0;
        try {
            GpsStatus gpsStatus = (GpsStatus) obj;
            Iterator<GpsSatellite> it = gpsStatus == null ? null : gpsStatus.getSatellites().iterator();
            if (it != null) {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                while (it.hasNext()) {
                    try {
                        GpsSatellite next = it.next();
                        int prn = next.getPrn();
                        boolean usedInFix = next.usedInFix();
                        Iterator<GpsSatellite> it2 = it;
                        int a = a(prn);
                        if (a != 1) {
                            if (a != 3) {
                                if (a != 5) {
                                    if (a != 6) {
                                        i4++;
                                        if (usedInFix) {
                                            i9++;
                                        }
                                        it = it2;
                                    } else if (hashSet4.contains(Integer.valueOf(prn))) {
                                        it = it2;
                                    } else {
                                        hashSet4.add(Integer.valueOf(prn));
                                        i2++;
                                        if (usedInFix) {
                                            i7++;
                                        }
                                        it = it2;
                                    }
                                } else if (hashSet3.contains(Integer.valueOf(prn))) {
                                    it = it2;
                                } else {
                                    hashSet3.add(Integer.valueOf(prn));
                                    i3++;
                                    if (usedInFix) {
                                        i8++;
                                    }
                                    it = it2;
                                }
                            } else if (hashSet2.contains(Integer.valueOf(prn))) {
                                it = it2;
                            } else {
                                hashSet2.add(Integer.valueOf(prn));
                                i++;
                                if (usedInFix) {
                                    i6++;
                                }
                                it = it2;
                            }
                        } else if (hashSet.contains(Integer.valueOf(prn))) {
                            it = it2;
                        } else {
                            hashSet.add(Integer.valueOf(prn));
                            i12++;
                            if (usedInFix) {
                                i5++;
                            }
                            it = it2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        w3.a("GnssStatusAnalysis", "processNmeaData exception: ", th);
                        i10 = i12;
                        i12 = i5;
                        i11 = i8;
                        u5Var.d(obj);
                        u5Var.l(i10);
                        u5Var.k(i);
                        u5Var.q(i2);
                        u5Var.j(i3);
                        u5Var.p(i10 + i + i2 + i3 + i4);
                        u5Var.e(i12);
                        u5Var.d(i6);
                        u5Var.c(i7);
                        u5Var.b(i11);
                        u5Var.i(i12 + i6 + i7 + i11 + i9);
                        w3.c("GnssStatusAnalysis", "processGnssStatus, " + u5Var.toString());
                        return u5Var;
                    }
                }
                i10 = i12;
                i12 = i5;
                i11 = i8;
            } else {
                i11 = 0;
                i10 = 0;
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i6 = 0;
                i7 = 0;
                i9 = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
        }
        u5Var.d(obj);
        u5Var.l(i10);
        u5Var.k(i);
        u5Var.q(i2);
        u5Var.j(i3);
        u5Var.p(i10 + i + i2 + i3 + i4);
        u5Var.e(i12);
        u5Var.d(i6);
        u5Var.c(i7);
        u5Var.b(i11);
        u5Var.i(i12 + i6 + i7 + i11 + i9);
        w3.c("GnssStatusAnalysis", "processGnssStatus, " + u5Var.toString());
        return u5Var;
    }

    public static u5 b(Object obj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        String str;
        int i24;
        int i25;
        int constellationType;
        int svid;
        boolean usedInFix;
        u5 u5Var = new u5();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        int i26 = 0;
        try {
            GnssStatus gnssStatus = (GnssStatus) obj;
            if (gnssStatus != null) {
                i14 = 0;
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                i10 = 0;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                while (i26 < gnssStatus.getSatelliteCount()) {
                    try {
                        try {
                            constellationType = gnssStatus.getConstellationType(i26);
                            svid = gnssStatus.getSvid(i26);
                            usedInFix = gnssStatus.usedInFix(i26);
                        } catch (Throwable th) {
                        }
                        switch (constellationType) {
                            case 1:
                                if (hashSet.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet.add(Integer.valueOf(svid));
                                    i14++;
                                    if (usedInFix) {
                                        i7++;
                                    }
                                }
                                i26++;
                            case 2:
                                if (hashSet2.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet2.add(Integer.valueOf(svid));
                                    i4++;
                                    if (usedInFix) {
                                        i11++;
                                    }
                                }
                                i26++;
                            case 3:
                                if (hashSet3.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet3.add(Integer.valueOf(svid));
                                    i++;
                                    if (usedInFix) {
                                        i8++;
                                    }
                                }
                                i26++;
                            case 4:
                                if (hashSet4.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet4.add(Integer.valueOf(svid));
                                    i5++;
                                    if (usedInFix) {
                                        i12++;
                                    }
                                }
                                i26++;
                            case 5:
                                if (hashSet5.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet5.add(Integer.valueOf(svid));
                                    i3++;
                                    if (usedInFix) {
                                        i10++;
                                    }
                                }
                                i26++;
                            case 6:
                                if (hashSet6.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet6.add(Integer.valueOf(svid));
                                    i2++;
                                    if (usedInFix) {
                                        i9++;
                                    }
                                }
                                i26++;
                            case 7:
                                if (hashSet7.contains(Integer.valueOf(svid))) {
                                    continue;
                                } else {
                                    hashSet7.add(Integer.valueOf(svid));
                                    i6++;
                                    if (usedInFix) {
                                        i13++;
                                    }
                                }
                                i26++;
                            default:
                                continue;
                                i26++;
                        }
                        i26++;
                    } catch (Throwable th2) {
                        th = th2;
                        i26 = i14;
                        w3.a("GnssStatusAnalysis", "processNmeaData exception: ", th);
                        i14 = i26;
                        i15 = i4;
                        i16 = i5;
                        i17 = i6;
                        i26 = i7;
                        i18 = i8;
                        i19 = i9;
                        i20 = i10;
                        i21 = i11;
                        i22 = i12;
                        i23 = i13;
                        int i27 = i3;
                        str = "GnssStatusAnalysis";
                        i24 = i2;
                        i25 = i27;
                        u5Var.d(obj);
                        u5Var.l(i14);
                        u5Var.k(i);
                        u5Var.q(i24);
                        u5Var.j(i25);
                        u5Var.n(i16);
                        u5Var.o(i15);
                        u5Var.m(i17);
                        u5Var.p(i14 + i + i24 + i25 + i16 + i15 + i17);
                        u5Var.e(i26);
                        u5Var.d(i18);
                        u5Var.c(i19);
                        u5Var.b(i20);
                        u5Var.g(i22);
                        u5Var.h(i21);
                        u5Var.f(i23);
                        u5Var.i(i26 + i18 + i19 + i20 + i22 + i21 + i23);
                        w3.c(str, "processGnssStatus, " + u5Var.toString());
                        return u5Var;
                    }
                }
                i15 = i4;
                i16 = i5;
                i17 = i6;
                i26 = i7;
                i18 = i8;
                i19 = i9;
                i20 = i10;
                i21 = i11;
                i22 = i12;
                i23 = i13;
                int i28 = i3;
                str = "GnssStatusAnalysis";
                i24 = i2;
                i25 = i28;
            } else {
                str = "GnssStatusAnalysis";
                i18 = 0;
                i24 = 0;
                i23 = 0;
                i21 = 0;
                i22 = 0;
                i20 = 0;
                i19 = 0;
                i17 = 0;
                i15 = 0;
                i16 = 0;
                i14 = 0;
                i = 0;
                i25 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        u5Var.d(obj);
        u5Var.l(i14);
        u5Var.k(i);
        u5Var.q(i24);
        u5Var.j(i25);
        u5Var.n(i16);
        u5Var.o(i15);
        u5Var.m(i17);
        u5Var.p(i14 + i + i24 + i25 + i16 + i15 + i17);
        u5Var.e(i26);
        u5Var.d(i18);
        u5Var.c(i19);
        u5Var.b(i20);
        u5Var.g(i22);
        u5Var.h(i21);
        u5Var.f(i23);
        u5Var.i(i26 + i18 + i19 + i20 + i22 + i21 + i23);
        w3.c(str, "processGnssStatus, " + u5Var.toString());
        return u5Var;
    }

    public static u5 c(Object obj) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b(obj);
        }
        return a(obj);
    }
}