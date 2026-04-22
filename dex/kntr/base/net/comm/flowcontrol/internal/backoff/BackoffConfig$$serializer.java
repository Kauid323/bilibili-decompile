package kntr.base.net.comm.flowcontrol.internal.backoff;

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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BackoffConfig.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class BackoffConfig$$serializer implements GeneratedSerializer<BackoffConfig> {
    public static final BackoffConfig$$serializer INSTANCE = new BackoffConfig$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfig", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("maxTimes", true);
        pluginGeneratedSerialDescriptor.addElement("initialDelay", true);
        pluginGeneratedSerialDescriptor.addElement("maxDelay", true);
        pluginGeneratedSerialDescriptor.addElement("factor", true);
        pluginGeneratedSerialDescriptor.addElement("jitter", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackoffConfig$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, FloatSerializer.INSTANCE, FloatSerializer.INSTANCE};
    }

    public final BackoffConfig deserialize(Decoder decoder) {
        int i;
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            i2 = beginStructure.decodeIntElement(serialDescriptor, 2);
            float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 3);
            i = decodeIntElement;
            i4 = 31;
            f2 = beginStructure.decodeFloatElement(serialDescriptor, 4);
            i3 = decodeIntElement2;
            f = decodeFloatElement;
        } else {
            float f3 = 0.0f;
            float f4 = 0.0f;
            boolean z = true;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        i5 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i8 |= 1;
                        break;
                    case 1:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i8 |= 2;
                        break;
                    case 2:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i8 |= 4;
                        break;
                    case 3:
                        f3 = beginStructure.decodeFloatElement(serialDescriptor, 3);
                        i8 |= 8;
                        break;
                    case 4:
                        f4 = beginStructure.decodeFloatElement(serialDescriptor, 4);
                        i8 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i5;
            f = f3;
            f2 = f4;
            i2 = i6;
            i3 = i7;
            i4 = i8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BackoffConfig(i4, i, i3, i2, f, f2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, BackoffConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BackoffConfig.write$Self$flow_control_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}