package tv.danmaku.bili.report;

import android.util.Base64;
import com.bilibili.homepage.AesEncryptService;
import com.bilibili.lib.blrouter.BLRouter;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: InfoEyesCryptor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0003J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/InfoEyesCryptor;", "", "<init>", "()V", "TAG", "", "AES_ENCRYPTER", "Ljavax/crypto/Cipher;", "getAES_ENCRYPTER", "()Ljavax/crypto/Cipher;", "AES_ENCRYPTER$delegate", "Lkotlin/Lazy;", "getAESEncryptCipher", "aesEncrypt", "input", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InfoEyesCryptor {
    public static final String TAG = "InfoEyesCryptor";
    public static final InfoEyesCryptor INSTANCE = new InfoEyesCryptor();
    private static final Lazy AES_ENCRYPTER$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.report.InfoEyesCryptor$$ExternalSyntheticLambda0
        public final Object invoke() {
            Cipher AES_ENCRYPTER_delegate$lambda$0;
            AES_ENCRYPTER_delegate$lambda$0 = InfoEyesCryptor.AES_ENCRYPTER_delegate$lambda$0();
            return AES_ENCRYPTER_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private InfoEyesCryptor() {
    }

    private final Cipher getAES_ENCRYPTER() {
        return (Cipher) AES_ENCRYPTER$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cipher AES_ENCRYPTER_delegate$lambda$0() {
        return getAESEncryptCipher();
    }

    @JvmStatic
    private static final Cipher getAESEncryptCipher() {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            AesEncryptService aesEncryptService = (AesEncryptService) BLRouter.INSTANCE.get(AesEncryptService.class, "AesEncryptService");
            String key = aesEncryptService != null ? aesEncryptService.getKey() : null;
            if (key != null) {
                if (!(key.length() > 0)) {
                    return null;
                }
                byte[] bytes = key.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SecretKey aesKey = new SecretKeySpec(bytes, "AES");
                cipher.init(1, aesKey);
                return cipher;
            }
            return null;
        } catch (Exception e) {
            BLog.e(TAG, e);
            return null;
        }
    }

    @JvmStatic
    public static final String aesEncrypt(byte[] input) throws Exception {
        if (INSTANCE.getAES_ENCRYPTER() == null) {
            return "";
        }
        try {
            Cipher aes_encrypter = INSTANCE.getAES_ENCRYPTER();
            Intrinsics.checkNotNull(aes_encrypter);
            String encodeToString = Base64.encodeToString(aes_encrypter.doFinal(input), 2);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        } catch (Exception e) {
            BLog.e(TAG, e);
            return "";
        }
    }
}