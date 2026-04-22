package c.t.m.g;

import android.content.SharedPreferences;
import c.t.m.g.q3;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* compiled from: TML */
public class r0 {
    public c e;
    public String f;
    public String a = "loc_comm_rsa_pub_key_ver";
    public String b = "loc_comm_rsa_pub_key_64";

    /* renamed from: c  reason: collision with root package name */
    public String f90c = "loc_comm_rsa_key_update_time";
    public volatile boolean d = true;
    public boolean g = false;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends TimerTask {
        public final /* synthetic */ Timer a;

        public a(Timer timer) {
            this.a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            n3.a("th_loc_task_t_consume", new b());
            this.a.cancel();
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b implements Runnable {

        /* compiled from: TML */
        /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
        public class a implements q3.c {
            public a() {
            }

            @Override // c.t.m.g.q3.c
            public void a(String str) {
                w3.a("UpdateRsaPublicKey", "onFailed:" + str);
                c cVar = r0.this.e;
                if (cVar == null) {
                    return;
                }
                w3.a("UpdateRsaPublicKey", "public key update from server failed, beacause network error");
                cVar.a();
            }

            @Override // c.t.m.g.q3.c
            public void b(String str) {
                JSONObject jSONObject;
                int i;
                try {
                    jSONObject = new JSONObject(str);
                    i = jSONObject.getInt(com.alipay.sdk.m.h.c.a);
                } catch (Throwable th) {
                    w3.a("UpdateRsaPublicKey", "parse json error : " + str, th);
                }
                if (i != 0) {
                    w3.a("UpdateRsaPublicKey", "parse json status:" + i + ", json=" + str);
                    c cVar = r0.this.e;
                    if (cVar == null) {
                        return;
                    }
                    w3.a("UpdateRsaPublicKey", "public key update from server failed, because parse response failed");
                    cVar.a();
                    return;
                }
                String string = jSONObject.getString("version");
                String a = j3.a(jSONObject.getString("key"));
                c cVar2 = r0.this.e;
                if (cVar2 == null) {
                    return;
                }
                w3.a("UpdateRsaPublicKey", "isCachPubKey to local: " + r0.this.g);
                if (r0.this.g) {
                    SharedPreferences a2 = h4.a();
                    h4.b(a2, r0.this.a, (Object) string);
                    h4.b(a2, r0.this.b, (Object) a);
                    h4.b(a2, r0.this.f90c, Long.valueOf(System.currentTimeMillis()));
                }
                cVar2.a(w2.a(a), string);
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r0.this.d) {
                w3.a("UpdateRsaPublicKey", "rsa url: " + r0.this.f);
                q3.a(r0.this.f, new a());
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface c {
        void a();

        void a(byte[] bArr, String str);
    }

    public r0(String str, c cVar) {
        this.f = "";
        this.e = cVar;
        this.f = str;
    }

    public void a(String str, String str2, String str3) {
        this.g = true;
        this.a = str;
        this.b = str2;
        this.f90c = str3;
    }

    public void a(long j) {
        if (this.g) {
            SharedPreferences a2 = h4.a();
            long longValue = ((Long) h4.a(a2, this.f90c, (Object) 0L)).longValue();
            if (longValue != 0) {
                String str = (String) h4.a(a2, this.a, (Object) "");
                String str2 = (String) h4.a(a2, this.b, (Object) "");
                c cVar = this.e;
                if (cVar != null) {
                    cVar.a(w2.a(str2), str);
                }
            }
            if (Math.abs(System.currentTimeMillis() - longValue) < 259200000) {
                return;
            }
        }
        Timer timer = new Timer();
        timer.schedule(new a(timer), j);
    }
}