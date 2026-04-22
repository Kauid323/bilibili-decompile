package kntr.app.ad.ui.inspector.core.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: AdTrackIdDecoder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdTrackIdDecoder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "KEY", RoomRecommendViewModel.EMPTY_CURSOR, "IV_PARAM", "ALGORITHM_CBC", "decryptTrackId", "Lkntr/app/ad/ui/inspector/core/util/AdTrackId;", "trackId", "parseTrackIdByPbaes", "decodeUrlSafeBase64", RoomRecommendViewModel.EMPTY_CURSOR, "input", "cbcDecrypt", "data", "key", "ivParameter", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdTrackIdDecoder {
    public static final int $stable = 0;
    private static final String ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
    public static final AdTrackIdDecoder INSTANCE = new AdTrackIdDecoder();
    private static final String IV_PARAM = "kijw7f6sdd5kko08";
    private static final String KEY = "h3yf6egdja5yq6dg";

    private AdTrackIdDecoder() {
    }

    public final AdTrackId decryptTrackId(String trackId) {
        String encodedTrackId;
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        if (StringsKt.isBlank(trackId)) {
            return null;
        }
        try {
            if (StringsKt.startsWith$default(trackId, "pbaes.", false, 2, (Object) null)) {
                encodedTrackId = trackId.substring("pbaes.".length());
                Intrinsics.checkNotNullExpressionValue(encodedTrackId, "substring(...)");
            } else {
                encodedTrackId = trackId;
            }
            return parseTrackIdByPbaes(encodedTrackId);
        } catch (Exception e) {
            return null;
        }
    }

    @ExperimentalSerializationApi
    private final AdTrackId parseTrackIdByPbaes(String trackId) {
        try {
            byte[] base64UrlCode = decodeUrlSafeBase64(trackId);
            byte[] decrypted = cbcDecrypt(base64UrlCode, KEY, IV_PARAM);
            if (decrypted == null) {
                return null;
            }
            return (AdTrackId) ProtoBuf.Default.decodeFromByteArray(AdTrackId.Companion.serializer(), decrypted);
        } catch (Exception e) {
            return null;
        }
    }

    private final byte[] decodeUrlSafeBase64(String input) {
        String padding;
        String base64 = StringsKt.replace$default(StringsKt.replace$default(input, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        switch (base64.length() % 4) {
            case 1:
                padding = "===";
                break;
            case 2:
                padding = "==";
                break;
            case 3:
                padding = "=";
                break;
            default:
                padding = RoomRecommendViewModel.EMPTY_CURSOR;
                break;
        }
        return Base64.decode$default(Base64.Default, base64 + padding, 0, 0, 6, (Object) null);
    }

    private final byte[] cbcDecrypt(byte[] data, String key, String ivParameter) {
        try {
            return AesCbcCrypto.INSTANCE.decrypt(data, StringsKt.encodeToByteArray(key), StringsKt.encodeToByteArray(ivParameter));
        } catch (Exception e) {
            return null;
        }
    }
}