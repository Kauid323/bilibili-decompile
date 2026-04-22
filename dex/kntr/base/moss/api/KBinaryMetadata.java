package kntr.base.moss.api;

import java.util.Arrays;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMetadata.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/base/moss/api/KBinaryMetadata;", "", "key", "", "value", "", "<init>", "(Ljava/lang/String;[B)V", "getKey", "()Ljava/lang/String;", "getValue", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KBinaryMetadata {
    private final String key;
    private final byte[] value;

    public static /* synthetic */ KBinaryMetadata copy$default(KBinaryMetadata kBinaryMetadata, String str, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kBinaryMetadata.key;
        }
        if ((i & 2) != 0) {
            bArr = kBinaryMetadata.value;
        }
        return kBinaryMetadata.copy(str, bArr);
    }

    public final String component1() {
        return this.key;
    }

    public final byte[] component2() {
        return this.value;
    }

    public final KBinaryMetadata copy(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(bArr, "value");
        return new KBinaryMetadata(str, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBinaryMetadata) {
            KBinaryMetadata kBinaryMetadata = (KBinaryMetadata) obj;
            return Intrinsics.areEqual(this.key, kBinaryMetadata.key) && Intrinsics.areEqual(this.value, kBinaryMetadata.value);
        }
        return false;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + Arrays.hashCode(this.value);
    }

    public String toString() {
        String str = this.key;
        return "KBinaryMetadata(key=" + str + ", value=" + Arrays.toString(this.value) + ")";
    }

    public KBinaryMetadata(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = key;
        this.value = value;
    }

    public final String getKey() {
        return this.key;
    }

    public final byte[] getValue() {
        return this.value;
    }
}