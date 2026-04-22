package kntr.common.ouro.core.model.node.renderable;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: OuroLocalImage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/common/ouro/core/model/node/renderable/UploadTaskState.Success.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Success;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class UploadTaskState$Success$$serializer implements GeneratedSerializer<UploadTaskState.Success> {
    public static final UploadTaskState$Success$$serializer INSTANCE = new UploadTaskState$Success$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.ouro.core.model.node.renderable.UploadTaskState.Success", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("identifier", false);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("imageWidth", false);
        pluginGeneratedSerialDescriptor.addElement("imageHeight", false);
        pluginGeneratedSerialDescriptor.addElement("imageSize", false);
        pluginGeneratedSerialDescriptor.addElement("AIGenMark", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UploadTaskState$Success$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, DoubleSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final UploadTaskState.Success deserialize(Decoder decoder) {
        int i;
        int i2;
        String str;
        String str2;
        long j;
        long j2;
        double d;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 3);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 4);
            i2 = beginStructure.decodeIntElement(serialDescriptor, 5);
            d = decodeDoubleElement;
            str2 = decodeStringElement2;
            j = decodeLongElement;
            j2 = decodeLongElement2;
            str = decodeStringElement;
            i = 63;
        } else {
            String str3 = null;
            double d2 = 0.0d;
            String str4 = null;
            boolean z = true;
            long j3 = 0;
            long j4 = 0;
            int i3 = 0;
            i = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i |= 1;
                        continue;
                    case 1:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i |= 2;
                        break;
                    case 2:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i |= 4;
                        break;
                    case 3:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i |= 8;
                        break;
                    case 4:
                        d2 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i |= 16;
                        break;
                    case 5:
                        i3 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i2 = i3;
            double d3 = d2;
            str = str3;
            str2 = str4;
            j = j3;
            j2 = j4;
            d = d3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UploadTaskState.Success(i, str, str2, j, j2, d, i2, null);
    }

    public final void serialize(Encoder encoder, UploadTaskState.Success value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UploadTaskState.Success.write$Self$core_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}