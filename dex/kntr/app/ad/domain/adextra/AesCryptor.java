package kntr.app.ad.domain.adextra;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kntr.app.ad.domain.config.AdConfigKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AesCryptor.android.kt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkntr/app/ad/domain/adextra/AesCryptor;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Companion", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AesCryptor {
    public static final Companion Companion = new Companion(null);
    private static final String HEX = "0123456789ABCDEF";
    private static final String IV_STRING = "16-Bytes--String";
    private static final String charset = "UTF-8";
    private static final Cipher cipher;

    /* compiled from: AesCryptor.android.kt.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/ad/domain/adextra/AesCryptor$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "IV_STRING", RoomRecommendViewModel.EMPTY_CURSOR, "charset", "HEX", "cipher", "Ljavax/crypto/Cipher;", "encryptAES", "content", "toHex", "buf", RoomRecommendViewModel.EMPTY_CURSOR, "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String encryptAES(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            Charset forName = Charset.forName(AesCryptor.charset);
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            byte[] byteContent = content.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(byteContent, "getBytes(...)");
            Cipher cipher = AesCryptor.cipher;
            byte[] encryptedBytes = cipher != null ? cipher.doFinal(byteContent) : null;
            return toHex(encryptedBytes);
        }

        private final String toHex(byte[] buf) {
            if (buf == null) {
                return RoomRecommendViewModel.EMPTY_CURSOR;
            }
            StringBuilder result = new StringBuilder(buf.length * 2);
            for (byte b : buf) {
                result.append(AesCryptor.HEX.charAt((b >> 4) & 15)).append(AesCryptor.HEX.charAt(b & 15));
            }
            String sb = result.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return sb;
        }
    }

    static {
        Cipher cipher2 = null;
        try {
            Cipher $this$cipher_u24lambda_u240 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            String aesKey = AdConfigKt.getAesKey();
            Charset forName = Charset.forName(charset);
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            byte[] keyBytes = aesKey.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(keyBytes, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Charset forName2 = Charset.forName(charset);
            Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
            byte[] initParam = IV_STRING.getBytes(forName2);
            Intrinsics.checkNotNullExpressionValue(initParam, "getBytes(...)");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            $this$cipher_u24lambda_u240.init(1, secretKeySpec, ivParameterSpec);
            cipher2 = $this$cipher_u24lambda_u240;
        } catch (Exception e) {
        }
        cipher = cipher2;
    }
}