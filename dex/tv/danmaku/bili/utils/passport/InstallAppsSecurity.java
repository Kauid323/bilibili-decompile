package tv.danmaku.bili.utils.passport;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InstallAppsSecurity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\rJ\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0003J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/utils/passport/InstallAppsSecurity;", "", "<init>", "()V", "TAG", "", "CIPHER_MODE", "LETTER", "encrypt", "Ltv/danmaku/bili/utils/passport/Encrypted;", "plain", "", "pem", "encrypt$core_apinkDebug", "aesEncrypt", "content", "key", "createAesKey", "length", "", "rsaEncrypt", "encodedPEM", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InstallAppsSecurity {
    public static final int $stable = 0;
    private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
    public static final InstallAppsSecurity INSTANCE = new InstallAppsSecurity();
    private static final String LETTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String TAG = "InstallAppsSecurity";

    private InstallAppsSecurity() {
    }

    @JvmStatic
    public static final Encrypted encrypt$core_apinkDebug(byte[] plain, String pem) {
        byte[] encryptPlain;
        Intrinsics.checkNotNullParameter(plain, "plain");
        Intrinsics.checkNotNullParameter(pem, "pem");
        String publicPem = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(pem, "-----BEGIN PUBLIC KEY-----\n", "", false, 4, (Object) null), "\n-----END PUBLIC KEY-----\n", "", false, 4, (Object) null), "-----BEGIN rsa public key-----\n", "", false, 4, (Object) null), "\n-----END rsa public key-----", "", false, 4, (Object) null);
        byte[] originAesKey = createAesKey(16).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(originAesKey, "getBytes(...)");
        byte[] encryptAesKey = rsaEncrypt(originAesKey, publicPem);
        if (encryptAesKey == null || (encryptPlain = aesEncrypt(plain, originAesKey)) == null) {
            return null;
        }
        return new Encrypted(encryptPlain, encryptAesKey);
    }

    @JvmStatic
    private static final byte[] aesEncrypt(byte[] content, byte[] key) {
        if (content == null) {
            return null;
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(key);
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(1, new SecretKeySpec(key, "AES"), ivParameterSpec);
            return cipher.doFinal(content);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    @JvmStatic
    private static final String createAesKey(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(61);
            sb.append(LETTER.charAt(number));
        }
        String stringBuffer = sb.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "toString(...)");
        return stringBuffer;
    }

    @JvmStatic
    private static final byte[] rsaEncrypt(byte[] plain, String encodedPEM) {
        try {
            byte[] bytes = encodedPEM.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] encodedKey = Base64.decode(bytes, 0);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(encodedKey));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(1, publicKey);
            return cipher.doFinal(plain);
        } catch (Throwable th) {
            return null;
        }
    }
}