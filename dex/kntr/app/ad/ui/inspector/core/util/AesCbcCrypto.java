package kntr.app.ad.ui.inspector.core.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AesCbcCrypto.android.kt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J \u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AesCbcCrypto;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "ALGORITHM_CBC", RoomRecommendViewModel.EMPTY_CURSOR, "decrypt", RoomRecommendViewModel.EMPTY_CURSOR, "data", "key", "iv", "encrypt", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AesCbcCrypto {
    public static final int $stable = 0;
    private static final String ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
    public static final AesCbcCrypto INSTANCE = new AesCbcCrypto();

    private AesCbcCrypto() {
    }

    public final byte[] decrypt(byte[] data, byte[] key, byte[] iv) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM_CBC);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(2, skeySpec, ivSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }

    public final byte[] encrypt(byte[] data, byte[] key, byte[] iv) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM_CBC);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(1, skeySpec, ivSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }
}