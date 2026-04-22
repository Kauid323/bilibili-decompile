package c.t.m.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bilibili.datacenter.hakase.protobuf.AndroidDeviceInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TML */
public class x3 extends n2 {
    public static volatile x3 f;
    public static String g = "";
    public static volatile String h = "";
    public static volatile String i = "";
    public static boolean j = false;
    public a d;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f117c = f3.b("HHmmss");
    public HashSet<String> e = new HashSet<>();

    static {
        String str = g3.d + "?mllc";
        new AtomicBoolean(false);
    }

    public static void c(String str) {
        h = str;
    }

    public static x3 f() {
        if (f == null) {
            synchronized (x3.class) {
                if (f == null) {
                    f = new x3();
                }
            }
        }
        return f;
    }

    public static String g() {
        StringBuilder sb = new StringBuilder();
        sb.append(f3.b("yyyyMMdd-HHmmss").format(new Date())).append(',').append("").append(',').append(i4.j()).append(',').append("").append(',').append(i4.k()).append(',').append(d4.a(h) ? "" : h).append(',').append(d4.a(i) ? "" : i).append(',').append(i4.i()).append(',').append(i4.a()).append(',').append("").append(',').append("");
        w3.c("MllcPro", "LogCoreHeader: " + ((Object) sb));
        return sb.toString();
    }

    public static String h() {
        return i4.b() + ',' + g + ',' + i4.h() + ",," + Build.VERSION.SDK_INT + ',' + a4.a() + ',' + i4.n() + "," + i4.a();
    }

    @Override // c.t.m.g.o2
    public String a() {
        return "MllcPro";
    }

    public final void a(String str, boolean z) {
    }

    @Override // c.t.m.g.o2
    public void d() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
            this.d = null;
            n3.a("th_loc_extra");
        }
    }

    public final void b(String str, String str2) {
        w3.a("MllcPro", str + "@" + str2);
        if (b()) {
            p3.b(this.d, 103, 0, 0, this.f117c.format(new Date()) + "," + str + "," + str2);
        }
    }

    public static void a(String str) {
        g = str;
    }

    public static void a(String str, String str2) {
        f().b(str, str2);
    }

    public void a(boolean z) {
        j = z;
    }

    @Override // c.t.m.g.n2
    public int b(Looper looper) {
        w3.a("MllcPro", "startup:isUp->" + j);
        if (j) {
            a aVar = new a(n3.b("th_loc_extra").getLooper());
            this.d = aVar;
            p3.b(aVar, 101);
        }
        this.e.clear();
        return 0;
    }

    public void a(long j2) {
        a aVar;
        if (!b() || (aVar = this.d) == null) {
            return;
        }
        p3.a(aVar, (int) AndroidDeviceInfo.DeviceInfo.VOICE_SERVICE_STATE_FIELD_NUMBER, j2);
    }

    public static void b(String str) {
        i = str;
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends Handler {
        public StringBuffer a;
        public long b;

        public a(Looper looper) {
            super(looper);
            this.a = new StringBuffer(18432);
        }

        public final void a(Message message) {
            switch (message.what) {
                case 101:
                    removeMessages(101);
                    this.b = System.currentTimeMillis();
                    String stringBuffer = this.a.toString();
                    this.a.setLength(0);
                    this.a.append("LOC_CORE").append(',').append(x3.g());
                    if (!d4.a(stringBuffer)) {
                        this.a.append(stringBuffer);
                    }
                    x3.this.b("SYSTEM", x3.h());
                    removeMessages(102);
                    p3.a(x3.this.d, 102, 120000L);
                    x3.this.b("PERMISSION", u3.a().c(b3.a()));
                    return;
                case 102:
                    removeMessages(102);
                    p3.a(x3.this.d, 102, 120000L);
                    x3.this.b("PERMISSION", u3.a().c(b3.a()));
                    return;
                case 103:
                    this.a.append('$').append((String) message.obj);
                    if (this.a.length() < 18432 && System.currentTimeMillis() - this.b < 180000) {
                        return;
                    }
                    x3.this.a(this.a.toString(), false);
                    this.a.setLength(0);
                    p3.b(x3.this.d, 101);
                    return;
                case 104:
                    x3.this.a("", true);
                    return;
                case AndroidDeviceInfo.DeviceInfo.VOICE_SERVICE_STATE_FIELD_NUMBER /* 105 */:
                    x3.this.a(this.a.toString(), false);
                    this.a.setLength(0);
                    p3.b(x3.this.d, 101);
                    return;
                case AndroidDeviceInfo.DeviceInfo.USB_CONNECTED_FIELD_NUMBER /* 106 */:
                    removeMessages(AndroidDeviceInfo.DeviceInfo.USB_CONNECTED_FIELD_NUMBER);
                    String str = (String) message.obj;
                    this.a.insert(0, str);
                    w3.a("MllcPro", str);
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Throwable th) {
                w3.a("MllcPro", "handler message error.", th);
            }
        }

        public void a() {
            this.a.append('$').append(x3.this.f117c.format(new Date()) + ",LOC,shutdown");
            String stringBuffer = this.a.toString();
            this.a.setLength(0);
            x3.this.a(stringBuffer, true);
            p3.b(x3.this.d);
        }
    }
}