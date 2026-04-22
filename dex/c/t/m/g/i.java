package c.t.m.g;

import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.a4;
import c.t.m.g.u2;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TML */
public class i extends m2 {
    public final File f;
    public volatile long n;
    public volatile int o;
    public volatile int p;
    public volatile int q;
    public volatile int r;
    public volatile float s;
    public volatile float t;
    public final StringBuilder e = new StringBuilder();
    public volatile long g = 0;
    public volatile long h = 0;
    public final long[] i = new long[2];
    public final int[] j = new int[2];
    public ArrayList<Float> k = new ArrayList<>();
    public ArrayList<Float> l = new ArrayList<>();
    public HashSet<Integer> m = new HashSet<>();
    public AtomicBoolean u = new AtomicBoolean(false);

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.u.get()) {
                return;
            }
            i.this.u.set(true);
            try {
                i.this.l();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b implements y1 {
        public final /* synthetic */ File a;
        public final /* synthetic */ boolean[] b;

        public b(i iVar, File file, boolean[] zArr) {
            this.a = file;
            this.b = zArr;
        }

        @Override // c.t.m.g.y1
        public void a(String str) {
            this.b[0] = true;
        }

        @Override // c.t.m.g.y1
        public void b(String str) {
            if (w3.a()) {
                w3.a("UserTrackPro", "upload succeed:" + str);
            }
            this.a.delete();
        }
    }

    public i(File file) {
        this.f = file;
    }

    @Override // c.t.m.g.p2
    public String a() {
        return "UserTrackPro";
    }

    public void a(long j, int i, double d, double d2, double d3) {
    }

    @Override // c.t.m.g.p2
    public void c() {
        a(IptcConstants.IMAGE_RESOURCE_BLOCK_XML_DATA, 0L);
        this.k.clear();
        this.l.clear();
        this.m.clear();
    }

    public final void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g < 60000) {
            if (w3.a()) {
                w3.a("UserTrackPro", "last upload time: < 1min");
                return;
            }
            return;
        }
        this.g = currentTimeMillis;
        a4.a b2 = a4.b();
        boolean z = true;
        if (!l.i) {
            if (b2 == a4.a.NETWORK_NONE) {
                z = false;
            } else if (b2 == a4.a.NETWORK_MOBILE) {
                boolean z2 = l.h;
                if (!z2 && l.j) {
                    long longValue = ((Long) h4.a("LocationSDK", "log_utr_up_in_m", Long.valueOf(currentTimeMillis))).longValue();
                    if (currentTimeMillis - longValue > 86400000) {
                        h4.b("LocationSDK", "log_utr_up_in_m", Long.valueOf(currentTimeMillis));
                        if (w3.a()) {
                            w3.a("UserTrackPro", "upload in mobile once today. lastUpT=" + longValue + ",curT=" + currentTimeMillis);
                        }
                    }
                }
                z = z2;
            }
        }
        if (z) {
            n3.a("th_loc_task_t_consume", new a());
        }
    }

    public final String i() {
        String str;
        String str2 = i4.c().replaceAll("[| _,]", "") + "_" + i4.d() + "_" + i4.e();
        String str3 = ((String) c4.a(Build.MANUFACTURER, "")).replaceAll("[| _,]", "") + "_" + ((String) c4.a(i4.g(), "")).replaceAll("[| _,]", "");
        String a2 = i4.a();
        if (d4.a(a2) || "0123456789ABCDEF".equals(a2)) {
            a2 = i4.k();
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (d4.a(l.b)) {
                str = i4.m();
            } else {
                str = l.b;
            }
        } catch (Exception e) {
            str = "";
        }
        sb.append("SYSTEM,").append(System.currentTimeMillis()).append(',').append(a2).append(',').append(l.l == null ? "" : l.l.a()).append(',').append(str2).append(',').append(str3).append(',').append(Build.VERSION.SDK_INT).append(',').append(str).append(',').append(l.a).append(',').append(o.c().replaceAll(":", "").toLowerCase()).append(',').append(o.d());
        return sb.toString();
    }

    public final String j() {
        String str = l.k ? "https://testdatalbs.sparta.html5.qq.com/tr?utr" : g3.d + "?utr";
        return !l.g ? str.replace("https:", "http:") : str;
    }

    public final void k() {
        this.h = System.currentTimeMillis();
        this.e.setLength(0);
        Arrays.fill(this.j, 0);
        Arrays.fill(this.i, 0L);
    }

    public final void l() {
        if (u2.a() == u2.a.BACKGROUND) {
            return;
        }
        File file = this.f;
        File[] listFiles = (file == null || !file.exists()) ? null : this.f.listFiles();
        if (d4.c(listFiles)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a4.a b2 = a4.b();
        String a2 = f3.a("yyyyMMdd");
        int i = 0;
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (file2.exists() && file2.isFile() && name.startsWith("utr_") && !name.contains(a2)) {
                if (currentTimeMillis - file2.lastModified() > 1296000000) {
                    if (w3.a()) {
                        w3.a("UserTrackPro", "del file:" + file2.getName());
                    }
                    file2.delete();
                } else {
                    byte[] a3 = m3.a(file2);
                    i += a3.length;
                    if (w3.a()) {
                        w3.a("UserTrackPro", "upload file:" + file2.getName() + ",len=" + a3.length + ",sum=" + i + ",netType=" + b2);
                    }
                    if (a3.length == 0) {
                        file2.delete();
                    } else {
                        boolean[] zArr = {false};
                        l.n.a(j(), a3, new b(this, file2, zArr));
                        if (zArr[0] || b2 == a4.a.NETWORK_MOBILE || i >= 512000) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // c.t.m.g.m2
    public void a(Message message) throws Exception {
        switch (message.what) {
            case IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO /* 1001 */:
                k();
                this.g = System.currentTimeMillis() - 40000;
                a(1004, 300000L);
                return;
            case IptcConstants.IMAGE_RESOURCE_BLOCK_XML_DATA /* 1002 */:
                p3.b(d());
                int[] iArr = this.j;
                if (iArr[0] + iArr[1] >= 3) {
                    b(this.e.toString());
                }
                k();
                h();
                return;
            case IptcConstants.IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE /* 1003 */:
                a((String) message.obj);
                return;
            case 1004:
                a(1004, 1800000L);
                h();
                return;
            default:
                return;
        }
    }

    public final void b(String str) {
        if (d4.a(str)) {
            return;
        }
        try {
            byte[] bytes = str.getBytes(com.alipay.sdk.m.o.a.z);
            byte[] a2 = n.a(bytes, 3);
            if (w3.a()) {
                w3.a("UserTrackPro", "srcBytes.len=" + bytes.length + ",encBytes.len=" + a2.length);
            }
            File file = new File(this.f, "utr_" + z3.a(g.class.getName(), "SHA-256").substring(0, 8) + "_" + f3.a("yyyyMMdd"));
            m3.a(file, a2, true);
            if (file.length() > 51200) {
                file.renameTo(new File(file.getParent(), file.getName() + "_" + f3.a("HHmmss")));
            }
        } catch (Throwable th) {
            if (w3.a()) {
                w3.a("UserTrackPro", "writeStrToFile error.", th);
            }
        }
    }

    public void c(long j) {
        if (j < 0) {
            j = 0;
        }
        a(1004, j);
    }

    @Override // c.t.m.g.p2
    public int a(Looper looper) {
        this.n = 0L;
        this.q = -1;
        this.p = -1;
        a(IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO, 0L);
        return 0;
    }

    public void a(int i, Location location) {
        String format;
        synchronized (this.b) {
            if (b()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.i[0] < 900) {
                    return;
                }
                this.i[0] = currentTimeMillis;
                int[] iArr = this.j;
                iArr[0] = iArr[0] + 1;
                if (location != null) {
                    if ("gps".equals(location.getProvider())) {
                        if (l.k || !location.isFromMockProvider()) {
                            if (currentTimeMillis - this.n > 2000) {
                                format = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,-1,-1,0,-1,0", Long.valueOf(currentTimeMillis), Long.valueOf(location.getTime()), Integer.valueOf(i), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getBearing()));
                            } else {
                                format = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%d,%d,%.2f,%d,%.2f,%d", Long.valueOf(currentTimeMillis), Long.valueOf(location.getTime()), Integer.valueOf(i), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getBearing()), Integer.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.s), Integer.valueOf(this.q), Float.valueOf(this.t), Integer.valueOf(this.r));
                            }
                            p3.b(d(), IptcConstants.IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE, 0, 0, format);
                        }
                    }
                }
            }
        }
    }

    public void a(int i, long j, Object obj) {
        e eVar;
        if (obj == null) {
            return;
        }
        synchronized (this.b) {
            this.k.clear();
            this.l.clear();
            this.m.clear();
            this.r = i;
            int i2 = 0;
            if (i == 1) {
                Iterable<GpsSatellite> satellites = ((GpsStatus) obj).getSatellites();
                Iterator<GpsSatellite> it = satellites == null ? null : satellites.iterator();
                while (it != null && it.hasNext()) {
                    GpsSatellite next = it.next();
                    float snr = next.getSnr();
                    if (next.usedInFix()) {
                        this.l.add(Float.valueOf(snr));
                    }
                    i2++;
                    if (!b4.a(snr, 0.0f)) {
                        this.k.add(Float.valueOf(snr));
                    }
                }
            } else if (i == 2 && Build.VERSION.SDK_INT >= 24) {
                GnssStatus gnssStatus = (GnssStatus) obj;
                int i3 = 0;
                while (i2 < gnssStatus.getSatelliteCount()) {
                    try {
                        int svid = gnssStatus.getSvid(i2) + (gnssStatus.getConstellationType(i2) * 1000);
                        if (!this.m.contains(Integer.valueOf(svid))) {
                            this.m.add(Integer.valueOf(svid));
                            float cn0DbHz = gnssStatus.getCn0DbHz(i2);
                            if (gnssStatus.usedInFix(i2)) {
                                this.l.add(Float.valueOf(cn0DbHz));
                            }
                            i3++;
                            if (!b4.a(cn0DbHz, 0.0f)) {
                                this.k.add(Float.valueOf(cn0DbHz));
                            }
                        }
                        i2++;
                    } catch (Throwable th) {
                        i2 = i3;
                    }
                }
                i2 = i3;
            } else if (i == 3 && (eVar = (e) obj) != null && eVar.a != null) {
                List<f> list = eVar.a;
                int i4 = 0;
                while (i2 < list.size()) {
                    f fVar = list.get(i2);
                    if (fVar != null) {
                        if (fVar.b) {
                            this.l.add(Float.valueOf(fVar.a));
                        }
                        i4++;
                        if (!b4.a(fVar.a, 0.0f)) {
                            this.k.add(Float.valueOf(fVar.a));
                        }
                    }
                    i2++;
                }
                i2 = i4;
            }
            Collections.sort(this.k);
            Collections.sort(this.l);
            this.n = j;
            this.o = i2;
            this.p = this.k.size();
            this.q = this.l.size();
            this.s = a(this.k);
            this.t = a(this.l);
        }
    }

    public final float a(List<Float> list) {
        int size = list.size();
        if (size == 0) {
            return 0.0f;
        }
        if (size % 2 == 0) {
            int i = size / 2;
            return (list.get(i - 1).floatValue() + list.get(i).floatValue()) / 2.0f;
        }
        return list.get((size - 1) / 2).floatValue();
    }

    public final void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.e.length() == 0) {
            this.e.append(i());
            this.h = currentTimeMillis;
        }
        this.e.append('$').append(str);
        if (this.e.length() >= 15360 || (this.h != 0 && currentTimeMillis - this.h >= 600000)) {
            int[] iArr = this.j;
            if (iArr[0] + iArr[1] >= 3) {
                b(this.e.toString());
            }
            this.e.setLength(0);
            Arrays.fill(this.j, 0);
        }
    }
}