package kntr.base.neuron.internal.model.pb;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/base/neuron/internal/model/pb/KAppPageViewInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class KAppPageViewInfo$$serializer implements GeneratedSerializer<KAppPageViewInfo> {
    public static final KAppPageViewInfo$$serializer INSTANCE = new KAppPageViewInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.neuron.internal.model.pb.KAppPageViewInfo", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("eventIdFrom", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(1));
        pluginGeneratedSerialDescriptor.addElement("loadType", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(4));
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(5));
        pluginGeneratedSerialDescriptor.addElement("pvstart", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(6));
        pluginGeneratedSerialDescriptor.addElement("pvend", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(7));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private KAppPageViewInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    public final KAppPageViewInfo deserialize(Decoder decoder) {
        int i;
        long j;
        long j2;
        long j3;
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 3);
            j3 = beginStructure.decodeLongElement(serialDescriptor, 4);
            i = decodeIntElement;
            j = decodeLongElement;
            j2 = decodeLongElement2;
            str = decodeStringElement;
            i2 = 31;
        } else {
            String str2 = null;
            long j4 = 0;
            boolean z = true;
            int i3 = 0;
            i = 0;
            j = 0;
            j2 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        continue;
                    case 1:
                        i = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i3 |= 2;
                        break;
                    case 2:
                        j = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i3 |= 8;
                        break;
                    case 4:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i3 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            j3 = j4;
            i2 = i3;
            str = str2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new KAppPageViewInfo(i2, str, i, j, j2, j3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, KAppPageViewInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        KAppPageViewInfo.write$Self$neuron_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}