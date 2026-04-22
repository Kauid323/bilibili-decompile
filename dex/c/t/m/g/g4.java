package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* compiled from: TML */
public class g4 {
    public j3 a = new j3();
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f35c = false;
    public String d;
    public String e;

    public g4(String str, String str2) {
        this.d = "";
        this.e = "";
        this.d = str;
        this.e = str2;
        a();
    }

    public void a() {
        a(w2.a(this.e), this.d);
    }

    public void a(byte[] bArr, String str) {
        w3.a("RsaAes", "setPublicKey:" + bArr.length + "," + str + ", ignored:" + this.f35c);
        w3.a("RsaAes", "setPublicKey:" + Arrays.toString(bArr));
        if (str.length() == 4 && !d4.a(bArr)) {
            this.b = str;
            this.a.a(bArr);
            return;
        }
        a();
    }

    public byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        if (z) {
            bArr = c3.a(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(byteArrayOutputStream, bArr, bArr2);
        return byteArrayOutputStream.toByteArray();
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, byte[] bArr2) {
        if (bArr2.length <= 64) {
            try {
                byteArrayOutputStream.write(this.b.getBytes(com.alipay.sdk.m.o.a.z));
                this.a.a(byteArrayOutputStream, bArr2);
                byteArrayOutputStream.write(h3.b(bArr, bArr2, bArr2));
                return;
            } catch (Throwable th) {
                w3.a("RsaAes", "encrypt error.", th);
                return;
            }
        }
        throw new IllegalArgumentException("pwdAesBytes only support length [16/32/64].");
    }
}