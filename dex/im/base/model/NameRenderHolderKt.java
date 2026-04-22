package im.base.model;

import com.bapis.bilibili.account.service.v1.KNameRender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: NameRenderHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"deserializeNameRender", "Lcom/bapis/bilibili/account/service/v1/KNameRender;", "bytes", "", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NameRenderHolderKt {
    public static final KNameRender deserializeNameRender(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
        $this$decodeFromByteArray$iv.getSerializersModule();
        return (KNameRender) $this$decodeFromByteArray$iv.decodeFromByteArray(KNameRender.Companion.serializer(), bytes);
    }
}