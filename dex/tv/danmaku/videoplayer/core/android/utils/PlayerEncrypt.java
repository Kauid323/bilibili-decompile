package tv.danmaku.videoplayer.core.android.utils;

import com.bilibili.commons.Charsets;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.droid.crypto.AES;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerEncrypt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/videoplayer/core/android/utils/PlayerEncrypt;", "", "<init>", "()V", "TAG", "", "secretKey", "iv", "salt", "getReportClickParamsSign", "params", "getReportClickBodyAES", "", "body", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerEncrypt {
    public static final PlayerEncrypt INSTANCE = new PlayerEncrypt();
    private static final String TAG = "PlayerEncrypt";
    private static final String iv;
    private static final String salt;
    private static final String secretKey;

    private PlayerEncrypt() {
    }

    static {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "videodetail.report_click_secret_key", (Object) null, 2, (Object) null);
        if (str == null) {
            str = "fd6b639dbcff0c2a1b03b389ec763c4b";
        }
        secretKey = str;
        String str2 = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "videodetail.report_click_iv", (Object) null, 2, (Object) null);
        if (str2 == null) {
            str2 = "77b07a672d57d64c";
        }
        iv = str2;
        String str3 = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "videodetail.report_click_salt", (Object) null, 2, (Object) null);
        if (str3 == null) {
            str3 = "9cafa6466a028bfb";
        }
        salt = str3;
    }

    public final String getReportClickParamsSign(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
        byte[] bytes = params.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String str = salt;
        Charset charset2 = Charsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(charset2, "UTF_8");
        byte[] bytes2 = str.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        String sha256 = DigestUtils.sha256(bytes, bytes2);
        Intrinsics.checkNotNullExpressionValue(sha256, "sha256(...)");
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = sha256.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final byte[] getReportClickBodyAES(String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            String str = secretKey;
            Charset charset = Charsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String str2 = iv;
            Charset charset2 = Charsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset2, "UTF_8");
            byte[] bytes2 = str2.getBytes(charset2);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Charset charset3 = Charsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset3, "UTF_8");
            byte[] bytes3 = body.getBytes(charset3);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            byte[] encryptToBytes = AES.encryptToBytes(new SecretKeySpec(bytes, "AES"), ivParameterSpec, bytes3);
            Intrinsics.checkNotNull(encryptToBytes);
            return encryptToBytes;
        } catch (Exception e) {
            BLog.e(TAG, e);
            Charset charset4 = Charsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset4, "UTF_8");
            byte[] bytes4 = body.getBytes(charset4);
            Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
            return bytes4;
        }
    }
}