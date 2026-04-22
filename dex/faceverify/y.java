package faceverify;

import com.dtf.toyger.base.blob.RSAEncrypt;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java2jni_do_not_delete_this.java2jni_do_not_delete_this_library_zkfv_1tj;

public class y {
    public byte[] a;
    public byte[] b;
    public RSAPublicKey c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1968d;

    static {
        java2jni_do_not_delete_this_library_zkfv_1tj.loadLibrary();
    }

    public y(String str, boolean z) {
        this.f1968d = true;
        try {
            this.c = RSAEncrypt.loadPublicKeyByStr(str);
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            this.a = bArr;
            this.b = RSAEncrypt.encrypt(this.c, this.a);
            this.f1968d = z;
        } catch (Exception e2) {
            throw new IllegalArgumentException("fail to init crypto manager");
        }
    }

    public static native String b(byte[] bArr);

    public native byte[] a(byte[] bArr);
}