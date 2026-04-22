package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroDrawableMark.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/common/ouro/core/model/mark/OuroDrawableMark.Size.ScaledByFontSize.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$ScaledByFontSize;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class OuroDrawableMark$Size$ScaledByFontSize$$serializer implements GeneratedSerializer<OuroDrawableMark.Size.ScaledByFontSize> {
    public static final OuroDrawableMark$Size$ScaledByFontSize$$serializer INSTANCE = new OuroDrawableMark$Size$ScaledByFontSize$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.ouro.core.model.mark.OuroDrawableMark.Size.ScaledByFontSize", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("widthScale", false);
        pluginGeneratedSerialDescriptor.addElement("heightScale", false);
        pluginGeneratedSerialDescriptor.addElement("widthModifier", true);
        pluginGeneratedSerialDescriptor.addElement("heightModifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OuroDrawableMark$Size$ScaledByFontSize$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, FloatSerializer.INSTANCE};
    }

    public final OuroDrawableMark.Size.ScaledByFontSize deserialize(Decoder decoder) {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 0);
            float decodeFloatElement2 = beginStructure.decodeFloatElement(serialDescriptor, 1);
            float decodeFloatElement3 = beginStructure.decodeFloatElement(serialDescriptor, 2);
            f = decodeFloatElement;
            i = 15;
            f2 = beginStructure.decodeFloatElement(serialDescriptor, 3);
            f3 = decodeFloatElement3;
            f4 = decodeFloatElement2;
        } else {
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            boolean z = true;
            int i2 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        f5 = beginStructure.decodeFloatElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        f8 = beginStructure.decodeFloatElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        f7 = beginStructure.decodeFloatElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        f6 = beginStructure.decodeFloatElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            f = f5;
            f2 = f6;
            f3 = f7;
            f4 = f8;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OuroDrawableMark.Size.ScaledByFontSize(i, f, f4, f3, f2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, OuroDrawableMark.Size.ScaledByFontSize value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OuroDrawableMark.Size.ScaledByFontSize.write$Self$core_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}