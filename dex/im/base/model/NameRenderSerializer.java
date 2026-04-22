package im.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: NameRenderHolder.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lim/base/model/NameRenderSerializer;", "Lkotlinx/serialization/KSerializer;", "Lim/base/model/NameRenderHolder;", "<init>", "()V", "delegate", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NameRenderSerializer implements KSerializer<NameRenderHolder> {
    public static final NameRenderSerializer INSTANCE = new NameRenderSerializer();
    private static final KSerializer<byte[]> delegate = BuiltinSerializersKt.ByteArraySerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.SerialDescriptor("NameRenderHolder", delegate.getDescriptor());

    private NameRenderSerializer() {
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* renamed from: deserialize */
    public NameRenderHolder m3118deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        byte[] bytes = (byte[]) decoder.decodeSerializableValue(delegate);
        return NameRenderHolder_androidKt.buildNameRender(bytes);
    }

    public void serialize(Encoder encoder, NameRenderHolder value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeSerializableValue(delegate, value.getByteArray());
    }
}