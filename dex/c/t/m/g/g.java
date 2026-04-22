package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import c.t.m.g.a4;
import com.ashampoo.xmp.internal.XMPRDFWriter;
import com.bilibili.datacenter.hakase.protobuf.AndroidDeviceInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* compiled from: TML */
public class g extends n2 {
    public static final String z = l.b() + z3.a(g.class.getName(), "SHA-256").substring(0, 8);

    /* renamed from: c  reason: collision with root package name */
    public Context f30c;
    public final File d;
    public boolean e;
    public volatile Handler f;
    public long g;
    public long h;
    public int i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public volatile List<d> s;
    public volatile List<ScanResult> t;
    public volatile Location u;
    public j v;
    public i w;
    public h x;
    public BroadcastReceiver y;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            try {
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                if (w3.a()) {
                    w3.a("DC_Pro", "intent:" + intent + ",");
                }
                if (booleanExtra) {
                    return;
                }
                p3.a(g.this.f, 107, 2000L);
                if (g.this.w != null) {
                    g.this.w.c(2000L);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;

        /* compiled from: TML */
        /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
        public class a implements y1 {
            public a() {
            }

            @Override // c.t.m.g.y1
            public void a(String str) {
            }

            @Override // c.t.m.g.y1
            public void b(String str) {
                b.this.a.delete();
                if (w3.a()) {
                    w3.a("DC_Pro", "upload " + b.this.a.getName() + " succeed, then delete.");
                }
            }
        }

        public b(g gVar, File file, String str) {
            this.a = file;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] a2 = m3.a(this.a);
                if (d4.a(a2)) {
                    this.a.delete();
                    if (w3.a()) {
                        w3.a("DC_Pro", "file " + this.a.getName() + " is empty, then delete.");
                        return;
                    }
                    return;
                }
                l.n.a(this.b, a2, new a());
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("DC_Pro", "upload error,url=" + this.b, th);
                }
            }
        }
    }

    public g(Context context, String str) {
        this(context, new File(str + "/f_c"));
    }

    @Override // c.t.m.g.o2
    public String a() {
        return "DC_Pro";
    }

    public g(Context context, File file) {
        this.f30c = null;
        this.g = 102400L;
        this.h = 3600000L;
        this.i = 1;
        this.j = 25600;
        this.k = 104857600L;
        this.l = 10485760L;
        this.m = 259200000L;
        this.n = 2592000000L;
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = 0L;
        this.y = new a();
        this.f30c = context;
        this.d = file;
        this.e = false;
    }

    @Override // c.t.m.g.n2
    public int b(Looper looper) {
        h();
        File file = this.d;
        this.e = file != null && (file.exists() || this.d.mkdirs());
        if (w3.a()) {
            w3.a("DC_Pro", "startup! prepared:" + this.e);
        }
        if (this.e) {
            this.f = new c(looper);
            this.r = System.currentTimeMillis() - 40000;
            p3.a(this.f, 107, 300000L);
            try {
                __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(this.f30c, this.y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("DC_Pro", "listenNetworkState: failed", th);
                }
            }
        }
        if (this.e && this.o) {
            j jVar = new j(this.d);
            this.v = jVar;
            jVar.b(looper);
        }
        if (this.p) {
            i iVar = new i(this.d);
            this.w = iVar;
            iVar.b(looper);
        }
        if (this.q) {
            h hVar = new h();
            this.x = hVar;
            hVar.b(looper);
        }
        w3.d("FC", "systemInfo," + i4.a() + "," + i4.k());
        w3.d("FC", "start," + b4.a(this.o) + "," + b4.a(this.p) + "," + b4.a(this.q));
        return 0;
    }

    @Override // c.t.m.g.o2
    public void d() {
        try {
            this.f30c.unregisterReceiver(this.y);
        } catch (Throwable th) {
        }
        j jVar = this.v;
        if (jVar != null) {
            jVar.a(100L);
            this.v = null;
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(100L);
            this.w = null;
        }
        h hVar = this.x;
        if (hVar != null) {
            hVar.f();
            this.x = null;
        }
        if (f()) {
            p3.b(this.f, 104);
            p3.b(this.f, AndroidDeviceInfo.DeviceInfo.USB_CONNECTED_FIELD_NUMBER);
            this.r = 0L;
            p3.b(this.f, 107);
            p3.a(this.f, (int) AndroidDeviceInfo.DeviceInfo.VOICE_SERVICE_STATE_FIELD_NUMBER, 200L);
            this.f = null;
        }
    }

    public final boolean f() {
        return this.e;
    }

    public final void h() {
        this.s = null;
        this.t = null;
        this.u = null;
        this.r = 0L;
    }

    public void a(String str, String str2) {
        if ("D_UP_INTERVAL".equals(str)) {
            this.h = Math.max(900000L, Long.parseLong(str2));
        } else if ("D_UP_USE_HTTPS".equals(str)) {
            l.g = Boolean.parseBoolean(str2);
        } else if ("D_MAX_1F_SIZE".equals(str)) {
            this.g = a(Long.parseLong(str2), 10240L, 512000L);
        } else if ("D_NUM_UP".equals(str)) {
            this.i = (int) a(Long.parseLong(str2), 1L, 5L);
        } else if ("D_MAX_BUF_WF".equals(str)) {
            this.j = (int) a(Long.parseLong(str2), 5120L, 51200L);
        } else if ("D_MAX_FOLDER_SIZE".equals(str)) {
            this.k = a(Long.parseLong(str2), 10485760L, 209715200L);
        } else if ("D_MAX_SIZE_UP_1DAY".equals(str)) {
            this.l = Math.max(Long.parseLong(str2), 0L);
        } else if ("D_MAX_DAY_RENAME".equals(str)) {
            this.m = a(Long.parseLong(str2), 1L, 5L) * 24 * 60 * 60 * 1000;
        } else if ("D_MAX_DAY_DELETE".equals(str)) {
            this.n = a(Long.parseLong(str2), 1L, 30L) * 24 * 60 * 60 * 1000;
        } else if ("D_UP_WF_INFO".equals(str)) {
            this.o = Boolean.parseBoolean(str2);
        } else if ("D_UP_U_TRACK_INFO".equals(str)) {
            this.p = Boolean.parseBoolean(str2);
        } else if ("D_UP_GPS_FOR_NAVI".equals(str)) {
            this.q = Boolean.parseBoolean(str2);
        }
    }

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter);
    }

    public final long a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public void a(int i, Location location) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(i, location);
        }
        h hVar = this.x;
        if (hVar != null) {
            hVar.a(i, location);
        }
    }

    public void a(long j, int i, double d, double d2, double d3) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(j, i, d, d2, d3);
        }
    }

    public void a(List<ScanResult> list) {
        j jVar = this.v;
        if (jVar != null) {
            jVar.a(list);
        }
    }

    public void a(int i, long j, Object obj) {
        h hVar;
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4 && (hVar = this.x) != null && (obj instanceof Integer)) {
                hVar.a(((Integer) obj).intValue());
                return;
            }
            return;
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(i, j, obj);
        }
    }

    public final void a(Handler handler) {
        boolean z2;
        w3.a("DC_Pro", "check upload.");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r < 60000) {
            w3.a("DC_Pro", "last upload time: < 1min");
            return;
        }
        p3.b(handler, AndroidDeviceInfo.DeviceInfo.USB_CONNECTED_FIELD_NUMBER);
        try {
            a4.a b2 = a4.b();
            if (b2 == a4.a.NETWORK_NONE) {
                z2 = false;
            } else if (b2 != a4.a.NETWORK_MOBILE) {
                z2 = true;
            } else {
                boolean z3 = l.h;
                if (!l.h && l.j) {
                    long longValue = ((Long) h4.a("LocationSDK", "log_fc_up_in_m", Long.valueOf(currentTimeMillis))).longValue();
                    if (currentTimeMillis - longValue > 86400000) {
                        h4.b("LocationSDK", "log_fc_up_in_m", Long.valueOf(currentTimeMillis));
                        if (w3.a()) {
                            w3.a("DC_Pro", "upload in mobile once today. lastUpT=" + longValue + ",curT=" + currentTimeMillis);
                        }
                        z2 = true;
                    }
                }
                z2 = z3;
            }
            if (w3.a()) {
                w3.a("DC_Pro", "network status:" + b2 + ",isUpload:" + z2);
            }
            if (z2 && f()) {
                p3.b(handler, 103);
                this.r = currentTimeMillis;
                if (w3.a()) {
                    w3.a("DC_Pro", "send upload msg, last upload time:" + this.r);
                }
            }
        } catch (Throwable th) {
            w3.a("DC_Pro", "", th);
        }
    }

    public synchronized void a(Location location, List<ScanResult> list, List<d> list2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (location != null && currentTimeMillis - location.getTime() <= 10000) {
            this.u = location;
            this.t = list;
            this.s = list2;
            if (f()) {
                if (list == null) {
                    if (!d4.a((Collection) list2)) {
                        p3.b(this.f, 102);
                    }
                } else if (!d4.a((Collection) list)) {
                    p3.b(this.f, 101);
                }
            }
        }
    }

    public final void a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n3.a("th_loc_task_t_consume", new b(this, file, str));
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class c extends Handler {
        public File a;
        public BufferedOutputStream b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f31c;
        public String d;
        public long e;

        public c(Looper looper) {
            super(looper);
            this.d = "";
            this.e = 0L;
        }

        public final void a(Message message) {
            File file;
            int i = message.what;
            switch (i) {
                case 101:
                case 102:
                    try {
                        a(i);
                        return;
                    } catch (Throwable th) {
                        w3.a("DC_Pro", "write data error!", th);
                        return;
                    }
                case 103:
                    w3.a("DC_Pro", "upload msg");
                    if (g.this.f()) {
                        String absolutePath = g.this.d.getAbsolutePath();
                        if (a(absolutePath)) {
                            return;
                        }
                        a(absolutePath.replaceAll("f_c", "d_c"));
                        return;
                    }
                    return;
                case 104:
                    b();
                    return;
                case AndroidDeviceInfo.DeviceInfo.VOICE_SERVICE_STATE_FIELD_NUMBER /* 105 */:
                    try {
                        f();
                        if (this.f31c != null) {
                            this.f31c.setLength(0);
                        }
                    } catch (Throwable th2) {
                    }
                    this.a = null;
                    m3.a(this.b);
                    a(g.this.n, g.this.k);
                    removeCallbacksAndMessages(null);
                    return;
                case AndroidDeviceInfo.DeviceInfo.USB_CONNECTED_FIELD_NUMBER /* 106 */:
                    a();
                    if (g.this.d == null || (file = this.a) == null || !file.exists()) {
                        return;
                    }
                    f();
                    long longValue = ((Long) h4.a("LocationSDK", "log_fc_create", (Object) 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (w3.a()) {
                        w3.a("DC_Pro", "desFileLen=" + this.a.length() + ",maxFileSize=" + c() + ",curT=" + currentTimeMillis + ",createT=" + longValue + ",maxTimeRename:" + g.this.m);
                    }
                    if (this.a.length() > c() || currentTimeMillis - longValue > g.this.m) {
                        w3.a("DC_Pro", "start rename file.");
                        e();
                        a(g.this.n, g.this.k);
                        if (l.h) {
                            sendEmptyMessage(107);
                            return;
                        }
                        return;
                    }
                    return;
                case 107:
                    removeMessages(107);
                    g gVar = g.this;
                    gVar.a(gVar.f);
                    p3.a(g.this.f, 107, g.this.h);
                    return;
                default:
                    return;
            }
        }

        public final void b() {
            try {
                if (this.b != null) {
                    this.b.flush();
                }
            } catch (Throwable th) {
                this.a = null;
                m3.a(this.b);
            }
        }

        public final long c() {
            long j = l.h ? 51200L : 512000L;
            return g.this.g > j ? j : g.this.g;
        }

        public final File d() {
            File file = g.this.d;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, g.z);
        }

        public final void e() {
            b();
            File file = this.a;
            if (file == null || file.length() < 1024) {
                return;
            }
            m3.a(this.b);
            this.b = null;
            a(4, this.a);
            this.a = null;
            h4.b("LocationSDK", "log_fc_create", (Object) 0L);
        }

        public final void f() {
            StringBuffer stringBuffer = this.f31c;
            if (stringBuffer == null || stringBuffer.length() == 0 || this.b == null) {
                return;
            }
            byte[] a = n.a(this.f31c.toString());
            if (w3.a()) {
                w3.a("DC_Pro", "write buf to file:buf:" + this.f31c.length() + ",enc:" + (a == null ? 0 : a.length));
            }
            this.f31c.setLength(0);
            if (a != null && a.length != 0) {
                try {
                    this.b.write(a);
                    this.b.write(36);
                    this.b.flush();
                    return;
                } catch (Throwable th) {
                    w3.a("DC_Pro", "write file failed.", th);
                    this.a = null;
                    m3.a(this.b);
                    return;
                }
            }
            w3.a("DC_Pro", "enc result is null or len = 0");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (w3.a()) {
                    w3.a("DC_Pro", "handleMessage:" + message.what);
                }
                a(message);
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("DC_Pro", "handler msg error!", th);
                }
            }
        }

        public final boolean a(String str) {
            boolean z;
            File[] fileArr = null;
            File file = TextUtils.isEmpty(str) ? null : new File(str);
            if (file != null && file.exists() && file.isDirectory()) {
                fileArr = file.listFiles();
            }
            if (fileArr != null && fileArr.length != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = g.this.i;
                for (int i2 = 0; i2 < fileArr.length && i > 0; i2++) {
                    File file2 = fileArr[i2];
                    String name = (file2 != null && file2.exists() && file2.isFile()) ? file2.getName() : "";
                    if (name.startsWith("dc") || name.startsWith("fc")) {
                        if (str.endsWith("d_c") && (file2.length() == 0 || currentTimeMillis - file2.lastModified() > g.this.n)) {
                            file2.delete();
                        } else {
                            boolean z2 = (name.startsWith(l.b()) && name.endsWith(".enc")) || (name.startsWith("fc2") || name.startsWith("fc3"));
                            if (z2) {
                                z = z2;
                            } else {
                                if (w3.a()) {
                                    w3.a("DC_Pro", str + ",has no " + l.b() + "***.enc files!!!");
                                }
                                z = name.startsWith("dc") && System.currentTimeMillis() - file2.lastModified() > 172800000;
                            }
                            if (z && a(file2.length())) {
                                if (w3.a()) {
                                    w3.a("DC_Pro", "upload:" + file2.getName() + ",len=" + file2.length());
                                }
                                int a = l.a(name);
                                if (a > 0) {
                                    String a2 = l.a(a);
                                    if (!TextUtils.isEmpty(a2)) {
                                        if (!l.g) {
                                            a2 = a2.replace("https:", "http:");
                                        }
                                        g.this.a(file2, a2);
                                        i--;
                                    }
                                }
                            }
                        }
                    }
                }
                return i != g.this.i;
            }
            if (fileArr != null && str.endsWith("d_c")) {
                file.delete();
            }
            return false;
        }

        public final void a(int i) {
            String str;
            File file;
            a();
            if (!d4.a((Collection) g.this.s)) {
                long j = ((d) g.this.s.get(0)).e;
                r1 = this.e != j;
                this.e = j;
            }
            if (i == 102) {
                str = m.a(l.l, g.this.u, null, g.this.s, r1);
            } else {
                if (i == 101) {
                    List list = g.this.t;
                    if (!d4.a((Collection) list)) {
                        str = m.a(l.l, g.this.u, list, g.this.s, r1);
                    }
                }
                str = "";
            }
            if (this.b == null || TextUtils.isEmpty(str) || str.length() < 25) {
                return;
            }
            String a = z3.a(str.substring(22).getBytes(), "SHA-256");
            if (this.d.equals(a)) {
                return;
            }
            this.d = a;
            if (this.f31c == null) {
                this.f31c = new StringBuffer(g.this.j);
            }
            this.f31c.append(str).append(XMPRDFWriter.XMP_DEFAULT_NEWLINE);
            if (this.f31c.length() > g.this.j || ((file = this.a) != null && file.length() == 0)) {
                f();
                if (this.a.length() > c()) {
                    p3.b(g.this.f, AndroidDeviceInfo.DeviceInfo.USB_CONNECTED_FIELD_NUMBER);
                }
            }
            if (w3.a()) {
                w3.a("DC_Pro", "write:" + str.substring(0, 60) + "***,len=" + str.length());
            }
        }

        public final void a() {
            File file = this.a;
            if (file == null || !file.exists() || this.b == null || !g.z.equals(this.a.getName())) {
                File d = d();
                this.a = d;
                try {
                    boolean exists = d.exists();
                    this.b = new BufferedOutputStream(new FileOutputStream(this.a, true), 1024);
                    if (exists) {
                        return;
                    }
                    h4.b("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
                } catch (Throwable th) {
                    w3.a("DC_Pro", "open file error", th);
                }
            }
        }

        public final boolean a(long j) {
            try {
                SharedPreferences a = h4.a("LocationSDK");
                SharedPreferences.Editor edit = a.edit();
                String string = a.getString("log_up_fc_date", "");
                long j2 = a.getLong("log_up_fc_size", 0L);
                String format = f3.b("yyyyMMdd").format(new Date());
                if (format.equals(string)) {
                    if (j2 > g.this.l) {
                        return false;
                    }
                    edit.putLong("log_up_fc_size", j + j2);
                } else {
                    edit.putString("log_up_fc_date", format);
                    edit.putLong("log_up_fc_size", j);
                }
                edit.apply();
                return true;
            } catch (Throwable th) {
                return true;
            }
        }

        public final void a(int i, File file) {
            try {
                if (file.isFile()) {
                    File file2 = new File(file.getAbsolutePath() + "." + System.currentTimeMillis() + ".enc");
                    if (i == 4) {
                        byte[] a = m3.a(file);
                        if (!d4.a(a)) {
                            byte[] a2 = c3.a(a);
                            if (!d4.a(a2)) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                                fileOutputStream.write(a2);
                                fileOutputStream.close();
                                file.delete();
                            }
                        }
                    } else {
                        file.renameTo(file2);
                    }
                    if (w3.a()) {
                        w3.a("DC_Pro", "rename:" + file.getName() + " to " + file2.getName());
                    }
                }
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("DC_Pro", "rename:" + file.getName() + " error.", th);
                }
            }
        }

        public final void a(long j, long j2) {
            File file = null;
            File[] listFiles = g.this.d == null ? null : g.this.d.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = 0;
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isFile() && !g.z.equals(file2.getName())) {
                    if (currentTimeMillis - file2.lastModified() <= j && file2.length() != 0) {
                        String name = file2.getName();
                        if (currentTimeMillis - file2.lastModified() > 172800000 && !name.endsWith(".enc") && name.startsWith(l.b())) {
                            a(l.a(name), file2);
                        } else {
                            j3 += file2.length();
                            if (file == null || file.lastModified() > file2.lastModified()) {
                                file = file2;
                            }
                        }
                    } else {
                        if (w3.a()) {
                            w3.a("DC_Pro", "delete expired file:" + file2.getName() + ",len:" + file2.length());
                        }
                        file2.delete();
                    }
                }
            }
            if (j3 < j2 || file == null) {
                return;
            }
            if (w3.a()) {
                w3.a("DC_Pro", "too big folder size:" + j3 + ", delete " + file.getName() + ",size:" + file.length());
            }
            file.delete();
        }
    }
}