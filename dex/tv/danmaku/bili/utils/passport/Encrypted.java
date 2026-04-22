package tv.danmaku.bili.utils.passport;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InstallAppsSecurity.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/utils/passport/Encrypted;", "", "encryptedContent", "", "encryptedKey", "<init>", "([B[B)V", "getEncryptedContent", "()[B", "getEncryptedKey", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Encrypted {
    public static final int $stable = 8;
    private final byte[] encryptedContent;
    private final byte[] encryptedKey;

    public Encrypted(byte[] encryptedContent, byte[] encryptedKey) {
        Intrinsics.checkNotNullParameter(encryptedContent, "encryptedContent");
        Intrinsics.checkNotNullParameter(encryptedKey, "encryptedKey");
        this.encryptedContent = encryptedContent;
        this.encryptedKey = encryptedKey;
    }

    public final byte[] getEncryptedContent() {
        return this.encryptedContent;
    }

    public final byte[] getEncryptedKey() {
        return this.encryptedKey;
    }
}