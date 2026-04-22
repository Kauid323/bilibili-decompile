package c.t.m.g;

import c.t.m.g.r0;

/* compiled from: TML */
public class j2 implements l2 {
    public r0 a;
    public h2 b;

    /* renamed from: c  reason: collision with root package name */
    public k2 f48c;
    public final g4 d;

    public j2(k2 k2Var) {
        w3.a("CommEncryptRsaAes", "CommEncryptRsaAes init," + k2Var.toString());
        this.f48c = k2Var;
        this.d = new g4(k2Var.g(), this.f48c.e());
        r0 r0Var = new r0(this.f48c.a(), new a());
        this.a = r0Var;
        r0Var.a(this.f48c.b(), this.f48c.c(), this.f48c.d());
        this.a.a(this.f48c.f());
    }

    public void a(byte[] bArr, String str) {
        w3.a("CommEncryptRsaAes", "setPubKey version " + str);
        this.d.a(bArr, str);
    }

    @Override // c.t.m.g.l2
    public byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return this.d.a(bArr, bArr2, z);
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements r0.c {
        public a() {
        }

        @Override // c.t.m.g.r0.c
        public void a(byte[] bArr, String str) {
            w3.a("CommEncryptRsaAes", "onPublicKeyChanged");
            j2.this.a(bArr, str);
            h2 h2Var = j2.this.b;
            if (h2Var != null) {
                h2Var.a();
            }
        }

        @Override // c.t.m.g.r0.c
        public void a() {
            w3.c("CommEncryptRsaAes", "onPublicKeyUpdateFailed");
        }
    }
}