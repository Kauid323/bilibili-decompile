package c.t.m.g;

import android.os.Bundle;
import c.t.m.g.q3;

/* compiled from: TML */
public class a2 implements z1 {

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements q3.c {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ y1 b;

        public a(a2 a2Var, Bundle bundle, y1 y1Var) {
            this.a = bundle;
            this.b = y1Var;
        }

        @Override // c.t.m.g.q3.c
        public void a(String str) {
            this.a.putString("msg_fail", str);
            y1 y1Var = this.b;
            if (y1Var != null) {
                y1Var.a(str);
            }
        }

        @Override // c.t.m.g.q3.c
        public void b(String str) {
            this.a.putString("msg_suc", str);
            y1 y1Var = this.b;
            if (y1Var != null) {
                y1Var.b(str);
            }
        }
    }

    @Override // c.t.m.g.z1
    public Bundle a(String str, byte[] bArr, y1 y1Var) {
        Bundle bundle = new Bundle();
        q3.a(str, bArr, new a(this, bundle, y1Var));
        return bundle;
    }
}