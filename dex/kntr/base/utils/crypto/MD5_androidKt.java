package kntr.base.utils.crypto;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* compiled from: MD5.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"encryptMd5", "", "content", "encryptFileMd5", "filePath", "crypto_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MD5_androidKt {
    public static final String encryptMd5(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = md.digest(bytes);
        Intrinsics.checkNotNull(digest);
        String md5 = ArraysKt.joinToString$default(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.utils.crypto.MD5_androidKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence encryptMd5$lambda$0;
                encryptMd5$lambda$0 = MD5_androidKt.encryptMd5$lambda$0(((Byte) obj).byteValue());
                return encryptMd5$lambda$0;
            }
        }, 30, (Object) null);
        String lowerCase = md5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence encryptMd5$lambda$0(byte it) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String encryptFileMd5(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(filePath);
            FileInputStream inputStream = fileInputStream;
            byte[] buffer = new byte[8192];
            while (true) {
                int it = inputStream.read(buffer);
                if (it == -1) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                    byte[] md5Bytes = md.digest();
                    Intrinsics.checkNotNull(md5Bytes);
                    return ArraysKt.joinToString$default(md5Bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.utils.crypto.MD5_androidKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            CharSequence encryptFileMd5$lambda$1;
                            encryptFileMd5$lambda$1 = MD5_androidKt.encryptFileMd5$lambda$1(((Byte) obj).byteValue());
                            return encryptFileMd5$lambda$1;
                        }
                    }, 30, (Object) null);
                }
                md.update(buffer, 0, it);
            }
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("EncryptUtil", "encryptFileMd5 has exception " + e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence encryptFileMd5$lambda$1(byte it) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}