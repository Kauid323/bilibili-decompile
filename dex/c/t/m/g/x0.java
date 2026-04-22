package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.t.m.g.v0;

/* compiled from: TML */
public class x0 {
    public Context a;
    public i1 b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f116c = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x0.this.b = new h1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public x0(Context context) {
        this.a = context;
    }

    public void a(v0.b bVar) {
        i1 i1Var;
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.a.bindService(intent, this.f116c, 1) || (i1Var = this.b) == null) {
            return;
        }
        String b = i1Var.b();
        boolean d = this.b.d();
        if (bVar != null) {
            bVar.a(b, d);
        }
    }
}