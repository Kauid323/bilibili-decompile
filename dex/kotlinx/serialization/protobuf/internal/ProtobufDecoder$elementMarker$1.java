package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProtobufDecoding.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class ProtobufDecoder$elementMarker$1 extends FunctionReferenceImpl implements Function2<SerialDescriptor, Integer, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDecoder$elementMarker$1(Object obj) {
        super(2, obj, ProtobufDecoder.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(SerialDescriptor p0, int p1) {
        boolean readIfAbsent;
        Intrinsics.checkNotNullParameter(p0, "p0");
        readIfAbsent = ((ProtobufDecoder) this.receiver).readIfAbsent(p0, p1);
        return Boolean.valueOf(readIfAbsent);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(SerialDescriptor serialDescriptor, Integer num) {
        return invoke(serialDescriptor, num.intValue());
    }
}