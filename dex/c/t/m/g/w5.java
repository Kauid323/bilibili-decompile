package c.t.m.g;

import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class w5 extends p1 {
    public int o;
    public boolean p;
    public List<w5> s;
    public a a = a.NONE;
    public int b = 460;

    /* renamed from: c  reason: collision with root package name */
    public int f114c = 0;
    public int d = 0;
    public int e = 0;
    public long f = 0;
    public int g = 0;
    public int h = -88;
    public int i = -88;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public long[] v = {65535, 268435455, 2147483647L, 50594049, 8, 10, 33, 0};
    public boolean r = false;
    public long q = System.currentTimeMillis();
    public Set<String> t = new HashSet();
    public Set<String> u = new HashSet();

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

    public static int a(int i) {
        if (i < -40 || i > 40) {
            return -1;
        }
        return i;
    }

    @Override // c.t.m.g.p1
    public int a() {
        return 10003;
    }

    public boolean a(long j) {
        return System.currentTimeMillis() - this.q < j;
    }

    public boolean b(w5 w5Var) {
        if (w5Var == null) {
            return false;
        }
        return b().equals(w5Var.b());
    }

    public String c() {
        return "" + this.b + this.f114c + this.d + this.f;
    }

    public List<w5> d() {
        if (this.s == null) {
            this.s = new ArrayList();
        }
        return this.s;
    }

    public long e() {
        return this.q;
    }

    public boolean f() {
        int i;
        int i2;
        for (long j : this.v) {
            if (this.f == j) {
                return false;
            }
        }
        int i3 = this.b;
        return i3 >= 0 && (i = this.f114c) >= 0 && i3 != 535 && i != 535 && (i2 = this.d) >= 0 && i2 != Integer.MAX_VALUE && i2 != 25840 && this.f > 0;
    }

    public boolean g() {
        int i;
        int i2;
        if (this.a != a.CDMA) {
            return f();
        }
        int i3 = this.b;
        if (i3 >= 0 && (i = this.f114c) >= 0 && i3 != 535 && i != 535 && (i2 = this.d) >= 0 && i2 != 65535) {
            long j = this.f;
            if (j != 65535 && j > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.r;
    }

    public String i() {
        return this.b + "," + this.f114c + "," + this.d + "," + this.f + "," + this.e;
    }

    public String j() {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(c(this));
            for (w5 w5Var : d()) {
                jSONArray.put(c(w5Var));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tr", ((int) (System.currentTimeMillis() - this.q)) / 1000);
            jSONObject.put("cells", jSONArray);
            return jSONObject.toString();
        } catch (Throwable th) {
            w3.b("TxCellInfo", th.toString());
            return "";
        }
    }

    public String toString() {
        return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.f114c + ", LAC=" + this.d + ", CID=" + this.f + ", RSSI=" + this.e + ", LAT=" + this.m + ", LNG=" + this.n + ", mTime=" + this.q + "]";
    }

    public static w5 a(w5 w5Var) {
        if (w5Var != null) {
            w5 w5Var2 = new w5();
            w5Var2.a = w5Var.a;
            w5Var2.b = w5Var.b;
            w5Var2.f114c = w5Var.f114c;
            w5Var2.d = w5Var.d;
            w5Var2.f = w5Var.f;
            w5Var2.e = w5Var.e;
            w5Var2.m = w5Var.m;
            w5Var2.n = w5Var.n;
            w5Var2.o = w5Var.o;
            w5Var2.q = w5Var.q;
            w5Var2.r = w5Var.r;
            w5Var2.j = w5Var.j;
            w5Var2.h = w5Var.h;
            w5Var2.i = w5Var.i;
            w5Var2.k = w5Var.k;
            w5Var2.g = w5Var.g;
            w5Var2.l = w5Var.l;
            w5Var2.s = w5Var.s;
            w5Var2.t = w5Var.t;
            w5Var2.u = w5Var.u;
            w5Var2.p = w5Var.p;
            return w5Var2;
        }
        throw new IllegalArgumentException("cell info is null");
    }

    public static w5 b(m4 m4Var, b6 b6Var) {
        if (m4Var.l() && b6Var != null) {
            d6 d6Var = (d6) b6Var;
            if (!d6Var.f12c && d6Var.a()) {
                d6Var.f = u6.b(m4Var);
                d6Var.b = System.currentTimeMillis();
            }
            if (d6Var.b()) {
                return d6Var.d;
            }
            CellLocation cellLocation = d6Var.f;
            SignalStrength signalStrength = d6Var.g;
            if (cellLocation == null) {
                return new w5();
            }
            TelephonyManager g = m4Var.g();
            w5 w5Var = new w5();
            try {
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    w5Var.a = a.CDMA;
                    w5Var.a(g, a.CDMA);
                    w5Var.f114c = cdmaCellLocation.getSystemId();
                    w5Var.d = cdmaCellLocation.getNetworkId();
                    w5Var.f = cdmaCellLocation.getBaseStationId();
                    w5Var.m = cdmaCellLocation.getBaseStationLatitude();
                    w5Var.n = cdmaCellLocation.getBaseStationLongitude();
                    if (signalStrength == null) {
                        w5Var.e = -1;
                    } else {
                        w5Var.e = signalStrength.getCdmaDbm();
                    }
                } else {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    w5Var.a = a.GSM;
                    w5Var.a(g, a.GSM);
                    w5Var.d = gsmCellLocation.getLac();
                    w5Var.f = gsmCellLocation.getCid();
                    if (signalStrength == null) {
                        w5Var.e = -1;
                    } else {
                        w5Var.e = (signalStrength.getGsmSignalStrength() * 2) - 113;
                    }
                }
            } catch (Throwable th) {
                w3.a("TxCellInfo", "", th);
            }
            if (w5Var.g()) {
                w5Var.r = true;
            }
            if (!u3.a().d(m4Var.a)) {
                w5Var.a = a.NOSIM;
            }
            w5Var.t.add(w5Var.b());
            w5Var.u.add(w5Var.c());
            w5Var.o = 1;
            u6.a("pref_cell_loc", w5Var);
            d6Var.d = w5Var;
            d6Var.e = System.currentTimeMillis();
            return w5Var;
        }
        return new w5();
    }

    public final JSONObject c(w5 w5Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mcc", w5Var.b);
        jSONObject.put("mnc", w5Var.f114c);
        jSONObject.put("lac", w5Var.d);
        jSONObject.put("cellid", w5Var.f);
        jSONObject.put("rss", w5Var.e);
        jSONObject.put("pci", w5Var.j);
        jSONObject.put("csirsrp", w5Var.i);
        jSONObject.put("ssrsrp", w5Var.h);
        jSONObject.put("csisinr", w5Var.g);
        jSONObject.put("earfcn", w5Var.k);
        jSONObject.put("rsrq", w5Var.l);
        jSONObject.put("networktype", w5Var.a.ordinal());
        jSONObject.put("src", w5Var.o);
        jSONObject.put("ts", ((int) (System.currentTimeMillis() - w5Var.q)) / 1000);
        return jSONObject;
    }

    public static w5 a(m4 m4Var, CellInfo cellInfo) {
        if (d4.a(cellInfo, m4Var)) {
            return new w5();
        }
        TelephonyManager g = m4Var.g();
        w5 w5Var = new w5();
        try {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                w5Var.a = a.CDMA;
                w5Var.a(g, a.CDMA);
                w5Var.f114c = cellIdentity.getSystemId();
                w5Var.d = cellIdentity.getNetworkId();
                w5Var.f = cellIdentity.getBasestationId();
                w5Var.m = cellIdentity.getLatitude();
                w5Var.n = cellIdentity.getLongitude();
                w5Var.e = a(a.CDMA, cellInfoCdma.getCellSignalStrength().getDbm());
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                w5Var.a = a.GSM;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                w5Var.d = cellIdentity2.getLac();
                w5Var.f = cellIdentity2.getCid();
                w5Var.b = cellIdentity2.getMcc();
                w5Var.f114c = cellIdentity2.getMnc();
                w5Var.e = a(a.GSM, cellInfoGsm.getCellSignalStrength().getDbm());
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                w5Var.a = a.WCDMA;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                w5Var.d = cellIdentity3.getLac();
                w5Var.f = cellIdentity3.getCid();
                w5Var.b = cellIdentity3.getMcc();
                w5Var.f114c = cellIdentity3.getMnc();
                w5Var.e = a(a.WCDMA, cellInfoWcdma.getCellSignalStrength().getDbm());
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                w5Var.a = a.LTE;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                w5Var.j = cellIdentity4.getPci();
                if (Build.VERSION.SDK_INT >= 24) {
                    w5Var.k = cellIdentity4.getEarfcn();
                }
                w5Var.d = cellIdentity4.getTac();
                w5Var.f = cellIdentity4.getCi();
                w5Var.b = cellIdentity4.getMcc();
                w5Var.f114c = cellIdentity4.getMnc();
                w5Var.e = a(a.LTE, cellInfoLte.getCellSignalStrength().getDbm());
                if (Build.VERSION.SDK_INT >= 26) {
                    w5Var.h = a(a.LTE, cellInfoLte.getCellSignalStrength().getRsrp());
                    w5Var.g = a(cellInfoLte.getCellSignalStrength().getRssnr());
                    w5Var.l = cellInfoLte.getCellSignalStrength().getRsrq();
                }
            } else if (cellInfo instanceof CellInfoNr) {
                CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
                w5Var.a = a.NR;
                CellIdentityNr cellIdentityNr = (CellIdentityNr) cellInfoNr.getCellIdentity();
                w5Var.f114c = Integer.parseInt(cellIdentityNr.getMncString());
                w5Var.b = Integer.parseInt(cellIdentityNr.getMccString());
                w5Var.d = a(cellIdentityNr);
                w5Var.f = cellIdentityNr.getNci();
                w5Var.j = cellIdentityNr.getPci();
                w5Var.k = cellIdentityNr.getNrarfcn();
                CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellInfoNr.getCellSignalStrength();
                w5Var.e = a(a.NR, cellSignalStrengthNr.getDbm());
                w5Var.h = a(a.NR, cellSignalStrengthNr.getSsRsrp());
                w5Var.g = a(cellSignalStrengthNr.getCsiSinr());
                w5Var.i = a(a.NR, cellSignalStrengthNr.getCsiRsrp());
                w5Var.l = cellSignalStrengthNr.getSsRsrq();
            }
        } catch (Throwable th) {
            w3.a("TxCellInfo", "", th);
        }
        if (!u3.a().d(m4Var.a)) {
            w5Var.a = a.NOSIM;
        }
        if (w5Var.g()) {
            w5Var.r = true;
        }
        w5Var.t.add(w5Var.b());
        w5Var.u.add(w5Var.c());
        w5Var.o = 0;
        return w5Var;
    }

    public void b(long j) {
        this.q = j;
    }

    public String b() {
        return "" + this.b + this.f114c + this.d + this.f + this.e;
    }

    public static int a(CellIdentityNr cellIdentityNr) {
        Integer num;
        if (cellIdentityNr == null) {
            return Integer.MAX_VALUE;
        }
        int tac = cellIdentityNr.getTac();
        if (tac < 0 || tac == Integer.MAX_VALUE) {
            try {
                Method method = cellIdentityNr.getClass().getMethod("getHwTac", new Class[0]);
                if (method == null || (num = (Integer) method.invoke(cellIdentityNr, new Object[0])) == null) {
                    return tac;
                }
                tac = num.intValue();
                w3.c("TxCellInfo", "getHwTac " + tac);
                return tac;
            } catch (Throwable th) {
                w3.c("TxCellInfo", "getHwTac failed");
                return tac;
            }
        }
        return tac;
    }

    public static int a(a aVar, int i) {
        if (aVar == a.NR) {
            if (i < -156 || i > -44) {
                return -1;
            }
            return i;
        } else if (i < -140 || i > -40) {
            return -1;
        } else {
            return i;
        }
    }

    public static w5 a(m4 m4Var, b6 b6Var) {
        if (m4Var != null && b6Var != null) {
            c6 c6Var = (c6) b6Var;
            if (!c6Var.f12c && c6Var.a()) {
                c6Var.f = u6.a(m4Var);
                c6Var.b = System.currentTimeMillis();
            }
            if (c6Var.b()) {
                return c6Var.d;
            }
            List<CellInfo> list = c6Var.f;
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                w5 w5Var = new w5();
                boolean z = true;
                for (CellInfo cellInfo : list) {
                    if (cellInfo != null && cellInfo.isRegistered()) {
                        w5 a2 = a(m4Var, cellInfo);
                        u6.a("pref_cell_info", a2);
                        if (a2.g()) {
                            w5Var.r = true;
                            if (z) {
                                w5Var = a2;
                                z = false;
                            } else if (!w5Var.t.contains(a2.b())) {
                                w5Var.t.add(a2.b());
                                w5Var.u.add(a2.c());
                                arrayList.add(a2);
                            }
                        } else {
                            w3.d("Cells", "invalid!" + a2.i());
                        }
                    }
                }
                w5Var.s = arrayList;
                w5Var.o = 0;
                c6Var.d = w5Var;
                c6Var.e = System.currentTimeMillis();
                return w5Var;
            }
            return new w5();
        }
        return new w5();
    }

    public final void a(TelephonyManager telephonyManager, a aVar) {
        int i;
        String networkOperator = telephonyManager.getNetworkOperator();
        w3.a("TxCellInfo", "MCCMNC:" + networkOperator);
        int i2 = 460;
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                int parseInt = Integer.parseInt(networkOperator.substring(0, 3));
                try {
                    int parseInt2 = Integer.parseInt(networkOperator.substring(3, 5));
                    boolean z = parseInt == 460 && parseInt2 == 3;
                    if (z) {
                        try {
                            if (aVar != a.CDMA && networkOperator.length() == 11) {
                                parseInt2 = Integer.parseInt(networkOperator.substring(9, 11));
                            }
                        } catch (Throwable th) {
                            th = th;
                            r2 = i;
                            i2 = parseInt;
                            w3.a("TxCellInfo", networkOperator + th.toString());
                            if (i2 > 0) {
                                return;
                            }
                            return;
                        }
                    }
                    r2 = z ? 0 : parseInt2;
                    i2 = parseInt;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (i2 > 0 || r2 < 0) {
            return;
        }
        this.b = i2;
        this.f114c = r2;
    }
}