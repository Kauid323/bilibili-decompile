package im.base.model;

import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: AvatarHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"deserializeAvatar", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KAvatarItem;", "bytes", "", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AvatarHolderKt {
    public static final KAvatarItem deserializeAvatar(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
        $this$decodeFromByteArray$iv.getSerializersModule();
        return (KAvatarItem) $this$decodeFromByteArray$iv.decodeFromByteArray(KAvatarItem.Companion.serializer(), bytes);
    }
}