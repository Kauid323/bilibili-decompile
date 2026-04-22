package im.base.model;

import java.util.Arrays;
import kntr.compose.avatar.model.AvatarItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: AvatarHolder.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/base/model/AvatarHolder;", "", "avatar", "Lkntr/compose/avatar/model/AvatarItem;", "byteArray", "", "<init>", "(Lkntr/compose/avatar/model/AvatarItem;[B)V", "getAvatar", "()Lkntr/compose/avatar/model/AvatarItem;", "getByteArray", "()[B", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "toString", "", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable(with = AvatarSerializer.class)
public final class AvatarHolder {
    public static final Companion Companion = new Companion(null);
    private final AvatarItem avatar;
    private final byte[] byteArray;

    public static /* synthetic */ AvatarHolder copy$default(AvatarHolder avatarHolder, AvatarItem avatarItem, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            avatarItem = avatarHolder.avatar;
        }
        if ((i2 & 2) != 0) {
            bArr = avatarHolder.byteArray;
        }
        return avatarHolder.copy(avatarItem, bArr);
    }

    public final AvatarItem component1() {
        return this.avatar;
    }

    public final byte[] component2() {
        return this.byteArray;
    }

    public final AvatarHolder copy(AvatarItem avatarItem, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        return new AvatarHolder(avatarItem, bArr);
    }

    public String toString() {
        AvatarItem avatarItem = this.avatar;
        return "AvatarHolder(avatar=" + avatarItem + ", byteArray=" + Arrays.toString(this.byteArray) + ")";
    }

    /* compiled from: AvatarHolder.android.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/base/model/AvatarHolder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/base/model/AvatarHolder;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AvatarHolder> serializer() {
            return new AvatarSerializer();
        }
    }

    public AvatarHolder(AvatarItem avatar, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        this.avatar = avatar;
        this.byteArray = byteArray;
    }

    public final AvatarItem getAvatar() {
        return this.avatar;
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type im.base.model.AvatarHolder");
            AvatarHolder avatarHolder = (AvatarHolder) other;
            return Intrinsics.areEqual(this.avatar, ((AvatarHolder) other).avatar) && Arrays.equals(this.byteArray, ((AvatarHolder) other).byteArray);
        }
        return false;
    }

    public int hashCode() {
        AvatarItem avatarItem = this.avatar;
        int result = avatarItem != null ? avatarItem.hashCode() : 0;
        return (result * 31) + Arrays.hashCode(this.byteArray);
    }
}