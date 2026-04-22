package c.t.m.g;

import com.ashampoo.kim.format.gif.GifConstants;
import com.ashampoo.kim.format.jpeg.JpegMetadataExtractor;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: TML */
@Deprecated
public class i3 {
    public static byte[] a;
    public static HashMap<String, String> b;

    static {
        a();
    }

    public static Cipher a(String str, int i) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(com.alipay.sdk.m.o.a.z), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, new IvParameterSpec(a));
        return cipher;
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str, int i3) {
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0 && i >= 0 && i2 != 0) {
            try {
                Cipher a2 = a(str, i3);
                if (a2 == null) {
                    return v2.a;
                }
                return a2.doFinal(bArr, i, i2);
            } catch (Throwable th) {
                return v2.a;
            }
        }
        return v2.a;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, 0, bArr.length, str);
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        return a(bArr, i, i2, str, 1);
    }

    public static final synchronized void a() {
        synchronized (i3.class) {
            try {
                b = new HashMap<>();
                for (String str : new String(h3.a(new byte[]{8, 16, 116, 91, -113, -11, 70, -62, -45, -36, 8, 119, -121, 51, 54, -122, 72, 12, -109, -53, 78, 13, -80, -118, -43, -111, 85, -110, 87, 62, 10, 92, -46, 53, -86, -78, 75, -122, 108, -53, 30, 123, -122, -114, 65, 78, 27, -15, 63, -58, -22, 26, -19, -87, -65, -34, -76, 3, -26, -75, 53, 115, -22, -113, 102, 43, -52, 74, 39, -117, 39, -63, -116, 4, -99, 109, 1, 53, -127, -75, 74, 12, -88, 77, -37, 53, 1, 89, 73, -95, -103, -33, -91, 1, -22, 66, 105, 3, 12, 111, -83, 85, -57, -89, -43, -94, 99, -117, 2, -81, 67, -2, 111, Byte.MIN_VALUE, -124, 79, -111, 86, -83, -106, 92, -87, 17, -85, 119, -15, -116, -68, 121, 1, 6, 92, 40, -12, -22, 60, 31, -73, -6, 31, -28, -8, -14, -125, -63, -33, -85, -12, 7, 23, 109, 122, -110, 113, -103, 15, -101, 64, 67, 115, 3, -85, 73, 102, GifConstants.GIF_TERMINATOR, -61, -16, 112, 53, 123, 118, -19, -61, 63, -102, 101, -40, -118, 49, -127, 14, -109, -30, -123, 41, -117, -14, GifConstants.GIF_TERMINATOR, 10, -56, 78, 121, -77, 55, -84, -40, -34, -69, -94, 52, 53, 94, -49, 48, -10, 82, 18, -7, 56, -126, -70, -94, GifConstants.GIF_TERMINATOR, 118, 25, 0, -11, -26, 7, -126, 72, -93, -66, -6, 62, 124, 74, 109, 18, 61, -57, 98, 67, 95, 25, -53, -25, 65, Byte.MAX_VALUE, -5, -74, 30, -99, -1, 87, -104, 54, -61, 37, 107, 12, 106, 67, 21, 17, -100, 113, -35, -43, -62, -11, -52, -116, -97, -44, -125, 28, -67, 67, 72, -45, -84, -82, 102, -118, 80, -9, -87, 6, 30, -100, 36, -122, 6, 71, -91, 21, 96, -53, -79, -82, 76, 91, -101, 84, -4, 87, -15, -48, JpegMetadataExtractor.SEGMENT_START_OF_SCAN, -81, 10, 42, -11, 17, 117, JpegMetadataExtractor.MARKER_END_OF_IMAGE, -119, 90, -51, 67, -87, 55, -69, 48, -92, 116, 34, 118, -56, 4, 95, -106, -3, 23, -9, 81, -69, -58, -57, 26, -87, 119, 62, -87, 69, -8, -58, -77, -57, 8, -89, 15, 77, 64, -15, -110, 80, -13, 70, 96, -41, 73, -2, -66, 43, 107, 103, GifConstants.IMAGE_SEPARATOR, -81, -17, -41, -48, -91, 60, 25, -76, -109}), com.alipay.sdk.m.o.a.z).split(com.alipay.sdk.m.q.h.b)) {
                    String[] split = str.split(",");
                    if (split.length == 2) {
                        b.put(split[0], split[1]);
                    }
                }
                a = b.get("enc_iv").getBytes(com.alipay.sdk.m.o.a.z);
            } finally {
            }
        }
    }

    public static final synchronized String a(String str) {
        String str2;
        synchronized (i3.class) {
            str2 = b.get(str);
            if (d4.a(str2)) {
                str2 = "";
            }
        }
        return str2;
    }
}