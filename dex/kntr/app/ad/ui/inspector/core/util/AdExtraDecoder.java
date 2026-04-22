package kntr.app.ad.ui.inspector.core.util;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AdExtraDecoder.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdExtraDecoder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "IV_STRING", RoomRecommendViewModel.EMPTY_CURSOR, "CHARSET", "HEX", "decryptAES", "key", "content", "toBinary", RoomRecommendViewModel.EMPTY_CURSOR, "hexString", "processAdextra", "adextra", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraDecoder {
    public static final int $stable = 0;
    private static final String CHARSET = "UTF-8";
    private static final String HEX = "0123456789ABCDEF";
    public static final AdExtraDecoder INSTANCE = new AdExtraDecoder();
    private static final String IV_STRING = "16-Bytes--String";

    private AdExtraDecoder() {
    }

    public final String decryptAES(String key, String content) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(content, "content");
        Charset forName = Charset.forName(CHARSET);
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        byte[] keyBytes = key.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(keyBytes, "getBytes(...)");
        byte[] encryptedBytes = toBinary(content);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Charset forName2 = Charset.forName(CHARSET);
        Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
        byte[] initParam = IV_STRING.getBytes(forName2);
        Intrinsics.checkNotNullExpressionValue(initParam, "getBytes(...)");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        Intrinsics.checkNotNull(decryptedBytes);
        Charset forName3 = Charset.forName(CHARSET);
        Intrinsics.checkNotNullExpressionValue(forName3, "forName(...)");
        return new String(decryptedBytes, forName3);
    }

    public final byte[] toBinary(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            byte high = (byte) (StringsKt.indexOf$default(HEX, hexString.charAt(i * 2), 0, false, 6, (Object) null) << 4);
            byte low = (byte) StringsKt.indexOf$default(HEX, hexString.charAt((i * 2) + 1), 0, false, 6, (Object) null);
            bytes[i] = (byte) (high | low);
        }
        return bytes;
    }

    public static /* synthetic */ String processAdextra$default(AdExtraDecoder adExtraDecoder, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "e08be2d68aaaaf27";
        }
        return adExtraDecoder.processAdextra(str, str2);
    }

    public final String processAdextra(String adextra, String key) {
        Intrinsics.checkNotNullParameter(adextra, "adextra");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return decryptAES(key, adextra);
        } catch (Exception e) {
            return adextra;
        }
    }
}