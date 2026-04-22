package c.t.m.g;

import android.content.Context;
import com.tencent.tencentmap.lbssdk.service.ar;

/* compiled from: TML */
public class r {

    /* renamed from: c  reason: collision with root package name */
    public static volatile r f89c;
    public byte[] a = new byte[0];
    public f0 b;

    public r(Context context) {
        this.b = null;
        b3.a(context);
        l0.a(context);
        this.b = new f0();
    }

    public static r a(Context context) {
        if (f89c == null) {
            synchronized (r.class) {
                if (f89c == null) {
                    Context applicationContext = context == null ? null : context.getApplicationContext();
                    if (applicationContext != null) {
                        f89c = new r(applicationContext);
                    } else {
                        throw new NullPointerException("context is null." + a());
                    }
                }
            }
        }
        return f89c;
    }

    public void b() {
        synchronized (this.a) {
            this.b.a(200L);
        }
    }

    public int c() {
        int g;
        synchronized (this.a) {
            g = this.b.g();
        }
        return g;
    }

    public void b(s sVar) {
        synchronized (this.a) {
            this.b.b(sVar);
        }
    }

    public void a(s sVar) {
        if (sVar != null) {
            synchronized (this.a) {
                this.b.a(sVar);
            }
            return;
        }
        throw new NullPointerException("listener cannot be null.");
    }

    public boolean a(String str, String str2) {
        boolean a;
        synchronized (this.a) {
            a = this.b.a(str, str2);
        }
        return a;
    }

    public static String a(int i) {
        return j0.a(i);
    }

    public static String a() {
        String str;
        if (m0.a) {
            str = ar.h();
            return "1.0.3_" + str;
        }
        str = "";
        return "1.0.3_" + str;
    }
}