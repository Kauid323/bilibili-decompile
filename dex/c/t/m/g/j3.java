package c.t.m.g;

import com.ashampoo.xmp.internal.XMPRDFWriter;
import com.bilibili.datacenter.hakase.protobuf.AndroidDeviceInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/* compiled from: TML */
public class j3 {
    public byte[] a = new byte[0];
    public PublicKey b;

    public static String a(String str) {
        if (str.contains("-----")) {
            str = str.split("-----")[2];
        }
        return str.replaceAll(XMPRDFWriter.XMP_DEFAULT_NEWLINE, "");
    }

    public void a(byte[] bArr) {
        synchronized (this.a) {
            try {
                this.b = KeyFactory.getInstance(com.alipay.sdk.m.j.d.a).generatePublic(new X509EncodedKeySpec(bArr));
            }
        }
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        a(byteArrayOutputStream, bArr, 0, bArr.length);
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, int i, int i2) {
        synchronized (this.a) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, this.b);
                a(byteArrayOutputStream, cipher, bArr, i, i2, AndroidDeviceInfo.DeviceInfo.BATTERY_HEALTH_FIELD_NUMBER);
            }
        }
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream, Cipher cipher, byte[] bArr, int i, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException, IOException {
        synchronized (this.a) {
            while (i2 > 0) {
                int min = Math.min(i2, i3);
                byteArrayOutputStream.write(cipher.doFinal(bArr, i, min));
                i += min;
                i2 -= min;
            }
        }
    }
}