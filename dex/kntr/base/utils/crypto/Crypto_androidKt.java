package kntr.base.utils.crypto;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: Crypto.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"encryptRsa", "", "content", "key", "hash", "crypto_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Crypto_androidKt {
    public static final String encryptRsa(String content, String key, String hash) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(hash, "hash");
        KLog_androidKt.getKLog().i("EncryptUtil", "encryptRsa content: " + content + ", key: " + key + ", hash: " + hash);
        String newContent = hash + content;
        String encodedPEM = StringsKt.replace$default(StringsKt.replace$default(key, "-----BEGIN PUBLIC KEY-----\n", "", false, 4, (Object) null), "-----END PUBLIC KEY-----", "", false, 4, (Object) null);
        KLog_androidKt.getKLog().i("EncryptUtil", "newContent: " + newContent + ", encodedPEM: " + encodedPEM);
        try {
            byte[] bytes = encodedPEM.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] encodedKey = Base64.decode(bytes, 0);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(encodedKey));
            Cipher chipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            chipher.init(1, publicKey);
            byte[] bytes2 = newContent.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] encrypted = chipher.doFinal(bytes2);
            String encodeToString = Base64.encodeToString(encrypted, 0);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
            return encodeToString;
        } catch (Exception e) {
            return "";
        }
    }
}