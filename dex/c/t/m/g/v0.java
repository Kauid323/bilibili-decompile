package c.t.m.g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: TML */
public class v0 {
    public b a;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;

        public a(String str, Context context) {
            this.a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("ASUS".equals(this.a)) {
                    new u0(this.b).a(v0.this.a);
                } else if ("HUAWEI".equals(this.a)) {
                    new w0(this.b).a(v0.this.a);
                } else if ("OPPO".equals(this.a)) {
                    new b1(this.b).a(v0.this.a);
                } else if ("ONEPLUS".equals(this.a)) {
                    new a1(this.b).a(v0.this.a);
                } else if ("ZTE".equals(this.a)) {
                    new e1(this.b).a(v0.this.a);
                } else if ("FERRMEOS".equals(this.a) || v0.this.b()) {
                    new e1(this.b).a(v0.this.a);
                } else if ("SSUI".equals(this.a) || v0.this.c()) {
                    new e1(this.b).a(v0.this.a);
                }
            } catch (Exception e) {
                w3.b("DevicesIDsHelper", "getIDFromNewThead error: " + e);
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface b {
        void a(String str, boolean z);
    }

    public v0(b bVar) {
        this.a = bVar;
    }

    public boolean b() {
        String a2 = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS");
    }

    public boolean c() {
        String a2 = a("ro.ssui.product");
        return (TextUtils.isEmpty(a2) || a2.equalsIgnoreCase("unknown")) ? false : true;
    }

    public final void d() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(null, false);
        }
    }

    public final String a() {
        return Build.MANUFACTURER.toUpperCase();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context) {
        String a2;
        b bVar;
        w3.a("OAID_TOOL", "getManufacturer ===> " + a());
        String upperCase = a().toUpperCase();
        if ("ASUS".equals(upperCase)) {
            a(context, upperCase);
        } else if ("HUAWEI".equals(upperCase)) {
            a(context, upperCase);
        } else if ("LENOVO".equals(upperCase)) {
            new x0(context).a(this.a);
        } else if ("MOTOLORA".equals(upperCase)) {
            new x0(context).a(this.a);
        } else if ("MEIZU".equals(upperCase)) {
            new y0(context).a(this.a);
        } else {
            if ("NUBIA".equals(upperCase)) {
                a2 = new z0(context).a();
            } else if ("OPPO".equals(upperCase)) {
                a(context, upperCase);
            } else if ("SAMSUNG".equals(upperCase)) {
                d();
            } else if ("VIVO".equals(upperCase)) {
                a2 = new c1(context).a();
            } else if ("XIAOMI".equals(upperCase)) {
                a2 = new d1(context).a();
            } else if ("BLACKSHARK".equals(upperCase)) {
                a2 = new d1(context).a();
            } else if ("ONEPLUS".equals(upperCase)) {
                a(context, upperCase);
            } else if ("ZTE".equals(upperCase)) {
                a(context, upperCase);
            } else if (!"FERRMEOS".equals(upperCase) && !b()) {
                if ("SSUI".equals(upperCase) || c()) {
                    a(context, upperCase);
                }
            } else {
                a(context, upperCase);
            }
            boolean z = a2 == null;
            bVar = this.a;
            if (bVar == null) {
                bVar.a(a2, z);
                return;
            }
            return;
        }
        a2 = null;
        if (a2 == null) {
        }
        bVar = this.a;
        if (bVar == null) {
        }
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            return null;
        }
    }

    public final void a(Context context, String str) {
        new Thread(new a(str, context)).start();
    }
}