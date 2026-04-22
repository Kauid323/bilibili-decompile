package c.t.m.g;

import android.content.Context;
import android.text.TextUtils;
import c.t.m.g.v0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: TML */
public class t0 implements v0.b {
    public static volatile String d = "";
    public static volatile boolean e = false;
    public Context a = b3.a();
    public v0 b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f98c;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {

        /* compiled from: TML */
        /* renamed from: c.t.m.g.t0$a$a  reason: collision with other inner class name */
        /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
        public class C0002a implements s0 {
            public C0002a(a aVar) {
            }

            @Override // c.t.m.g.s0
            public void a(String str) {
                if (d4.a(str)) {
                    return;
                }
                if (!t0.d.equals(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    w3.d("LOG", "update oaid," + t0.d + "," + str + "," + currentTimeMillis);
                    h4.b(h4.a(), "loc_id_oaid", str);
                    h4.b(h4.a(), "loc_id_oaid_time", Long.valueOf(currentTimeMillis));
                    String unused = t0.d = str;
                }
                w3.a("OaidTool", "getOaid, " + t0.d + ", " + str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new t0(new C0002a(this));
            } catch (Throwable th) {
                w3.a("OaidTool", "getOaid error.", th);
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Future<?> submit = newSingleThreadExecutor.submit(this.a);
            w3.a("OaidTool", "run submit.");
            try {
                newSingleThreadExecutor.shutdown();
                if (newSingleThreadExecutor.awaitTermination(15L, TimeUnit.SECONDS)) {
                    w3.a("OaidTool", "run finished.");
                } else {
                    w3.d("LOG", "get oaid terminated.");
                    if (!submit.isDone()) {
                        submit.cancel(true);
                    }
                }
            } catch (Throwable th) {
                w3.a("OaidTool", "", th);
            }
            w3.a("OaidTool", "run submit finish.");
        }
    }

    public t0(s0 s0Var) {
        this.f98c = s0Var;
        w3.a("OaidTool", "OaidTool in.");
        v0 v0Var = new v0(this);
        this.b = v0Var;
        v0Var.a(this.a);
    }

    public static synchronized String b() {
        String a2;
        synchronized (t0.class) {
            if (TextUtils.isEmpty(d)) {
                d = h4.a(h4.a(), "loc_id_oaid", "");
            }
            if (!e) {
                e = true;
                b bVar = new b(new a());
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = ((Long) h4.a(h4.a(), "loc_id_oaid_time", (Object) 0L)).longValue();
                if (!i4.q() && Math.abs(currentTimeMillis - longValue) >= 432000000) {
                    n3.a("th_loc_oaid", bVar);
                }
            }
            a2 = i4.a(d);
        }
        return a2;
    }

    @Override // c.t.m.g.v0.b
    public void a(String str, boolean z) {
        w3.a("OaidTool", "OnIdsAvalid====> " + str);
        s0 s0Var = this.f98c;
        if (s0Var != null) {
            if (!z) {
                str = null;
            }
            s0Var.a(str);
            return;
        }
        w3.b("OaidTool", "OnIdsAvalid====> listener null");
    }
}