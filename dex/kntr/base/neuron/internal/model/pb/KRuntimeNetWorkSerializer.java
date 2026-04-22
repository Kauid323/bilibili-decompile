package kntr.base.neuron.internal.model.pb;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWorkSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KRuntimeNetWorkSerializer implements KSerializer<KRuntimeNetWork> {
    public static final KRuntimeNetWorkSerializer INSTANCE = new KRuntimeNetWorkSerializer();
    private static final Lazy descriptor$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWorkSerializer$$ExternalSyntheticLambda0
        public final Object invoke() {
            SerialDescriptor descriptor_delegate$lambda$0;
            descriptor_delegate$lambda$0 = KRuntimeNetWorkSerializer.descriptor_delegate$lambda$0();
            return descriptor_delegate$lambda$0;
        }
    });

    private KRuntimeNetWorkSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor descriptor_delegate$lambda$0() {
        return SerialDescriptorsKt.PrimitiveSerialDescriptor("KRuntimeNetWork", PrimitiveKind.INT.INSTANCE);
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) descriptor$delegate.getValue();
    }

    public void serialize(Encoder encoder, KRuntimeNetWork value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeInt(value.getValue());
    }

    public KRuntimeNetWork deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return KRuntimeNetWork.Companion.fromValue(decoder.decodeInt());
    }
}