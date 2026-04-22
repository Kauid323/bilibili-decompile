package tv.danmaku.bili.ui.splash.utils;

import android.app.Application;
import android.text.TextUtils;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashAESUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/SplashAESUtils;", "", "<init>", "()V", "PREF_KEY_SPLASH_ENCRYPT_KEY", "", "TAG", "IV_STRING", "encrypt", "content", "decrypt", "hex2byte", "", "input", "byte2hex", "b", "getKey", "generateKey", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashAESUtils {
    public static final int $stable = 0;
    public static final SplashAESUtils INSTANCE = new SplashAESUtils();
    private static final String IV_STRING = "51572e58c49fd4c9";
    private static final String PREF_KEY_SPLASH_ENCRYPT_KEY = "pref_key_splash_encrypt_key";
    private static final String TAG = "SplashAESUtils";

    private SplashAESUtils() {
    }

    @JvmStatic
    public static final String encrypt(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            BLog.d(TAG, "encrypt start");
            String key = INSTANCE.getKey();
            if (TextUtils.isEmpty(key)) {
                return "";
            }
            byte[] data = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(data, "getBytes(...)");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = IV_STRING.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            cipher.init(1, new SecretKeySpec(INSTANCE.hex2byte(key), "AES"), new IvParameterSpec(bytes));
            byte[] encryptedData = cipher.doFinal(data);
            BLog.d(TAG, "encrypt end");
            return INSTANCE.byte2hex(encryptedData);
        } catch (Exception e) {
            BLog.e(TAG, "splash data encrypt failed", e);
            return "";
        }
    }

    @JvmStatic
    public static final String decrypt(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            BLog.d(TAG, "decrypt start");
            String key = INSTANCE.getKey();
            if (TextUtils.isEmpty(key)) {
                return "";
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = IV_STRING.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            cipher.init(2, new SecretKeySpec(INSTANCE.hex2byte(key), "AES"), new IvParameterSpec(bytes));
            byte[] decryptedData = cipher.doFinal(INSTANCE.hex2byte(content));
            BLog.d(TAG, "decrypt end");
            Intrinsics.checkNotNull(decryptedData);
            return new String(decryptedData, Charsets.UTF_8);
        } catch (Exception e) {
            BLog.e(TAG, "splash data decrypt failed", e);
            return "";
        }
    }

    private final byte[] hex2byte(String input) {
        if (input == null || input.length() < 2) {
            return new byte[0];
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String inputString = input.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(inputString, "toLowerCase(...)");
        int l = inputString.length() / 2;
        byte[] result = new byte[l];
        for (int i = 0; i < l; i++) {
            String tmp = inputString.substring(i * 2, (i * 2) + 2);
            Intrinsics.checkNotNullExpressionValue(tmp, "substring(...)");
            result[i] = (byte) (Integer.parseInt(tmp, 16) & 255);
        }
        return result;
    }

    private final String byte2hex(byte[] b) {
        if (b == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (byte b2 : b) {
            String tmp = Integer.toHexString(b2 & 255);
            Intrinsics.checkNotNullExpressionValue(tmp, "toHexString(...)");
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        String stringBuffer = sb.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "toString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = stringBuffer.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final String getKey() {
        Application context = BiliContext.application();
        if (context == null) {
            return "";
        }
        String key = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_SPLASH_ENCRYPT_KEY, "");
        if (TextUtils.isEmpty(key)) {
            String key2 = generateKey();
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(PREF_KEY_SPLASH_ENCRYPT_KEY, key2).apply();
            return key2;
        }
        return key;
    }

    private final String generateKey() {
        try {
            KeyGenerator gen = KeyGenerator.getInstance("AES");
            gen.init(128);
            return byte2hex(gen.generateKey().getEncoded());
        } catch (Exception e) {
            BLog.d(TAG, "generate key error", e);
            return "";
        }
    }
}