package tv.danmaku.bili.ui.clipboard;

import android.text.TextUtils;
import android.util.Base64;
import com.bilibili.lib.biliid.api.BuvidHelper;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.bili.BR;

/* compiled from: ClipboardEncryptUtil.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardEncryptUtil;", "", "<init>", "()V", "IV_LENGTH", "", "KEY_LENGTH", "encrypt", "", "content", "getKey", "getIvParameter", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClipboardEncryptUtil {
    public static final int $stable = 0;
    public static final ClipboardEncryptUtil INSTANCE = new ClipboardEncryptUtil();
    private static final int IV_LENGTH = 16;
    private static final int KEY_LENGTH = 32;

    private ClipboardEncryptUtil() {
    }

    public final String encrypt(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            String key = getKey();
            if (TextUtils.isEmpty(key)) {
                return "";
            }
            byte[] data = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(data, "getBytes(...)");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = getIvParameter().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            cipher.init(1, new SecretKeySpec(bytes, "AES"), new IvParameterSpec(bytes2));
            byte[] encryptedData = cipher.doFinal(data);
            return Base64.encodeToString(encryptedData, 0);
        } catch (Exception e) {
            return "";
        }
    }

    private final String getKey() {
        String buvid = BuvidHelper.getBuvid();
        if (buvid != null) {
            if (!(!TextUtils.isEmpty(buvid) && buvid.length() >= 32)) {
                buvid = null;
            }
            if (buvid == null) {
                return "";
            }
            String substring = buvid.substring(0, 32);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return "";
    }

    private final String getIvParameter() {
        String key = getKey();
        if (!(key.length() >= 16)) {
            key = null;
        }
        if (key == null) {
            return "";
        }
        String substring = key.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}