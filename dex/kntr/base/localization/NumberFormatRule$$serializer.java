package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/base/localization/NumberFormatRule.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/base/localization/NumberFormatRule;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class NumberFormatRule$$serializer implements GeneratedSerializer<NumberFormatRule> {
    public static final int $stable;
    public static final NumberFormatRule$$serializer INSTANCE = new NumberFormatRule$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.localization.NumberFormatRule", INSTANCE, 3);
        pluginGeneratedSerialDescriptor.addElement("threshold", false);
        pluginGeneratedSerialDescriptor.addElement("rounding", false);
        pluginGeneratedSerialDescriptor.addElement("carry", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private NumberFormatRule$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ThresholdRule$$serializer.INSTANCE, RoundingRule$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(CarryRule$$serializer.INSTANCE)};
    }

    public final NumberFormatRule deserialize(Decoder decoder) {
        int i;
        ThresholdRule thresholdRule;
        RoundingRule roundingRule;
        CarryRule carryRule;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        ThresholdRule thresholdRule2 = null;
        if (beginStructure.decodeSequentially()) {
            roundingRule = (RoundingRule) beginStructure.decodeSerializableElement(serialDescriptor, 1, RoundingRule$$serializer.INSTANCE, (Object) null);
            CarryRule carryRule2 = (CarryRule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, CarryRule$$serializer.INSTANCE, (Object) null);
            thresholdRule = (ThresholdRule) beginStructure.decodeSerializableElement(serialDescriptor, 0, ThresholdRule$$serializer.INSTANCE, (Object) null);
            i = 7;
            carryRule = carryRule2;
        } else {
            boolean z = true;
            i = 0;
            RoundingRule roundingRule2 = null;
            CarryRule carryRule3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        thresholdRule2 = (ThresholdRule) beginStructure.decodeSerializableElement(serialDescriptor, 0, ThresholdRule$$serializer.INSTANCE, thresholdRule2);
                        i |= 1;
                        break;
                    case 1:
                        roundingRule2 = (RoundingRule) beginStructure.decodeSerializableElement(serialDescriptor, 1, RoundingRule$$serializer.INSTANCE, roundingRule2);
                        i |= 2;
                        break;
                    case 2:
                        carryRule3 = (CarryRule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, CarryRule$$serializer.INSTANCE, carryRule3);
                        i |= 4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            thresholdRule = thresholdRule2;
            roundingRule = roundingRule2;
            carryRule = carryRule3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new NumberFormatRule(i, thresholdRule, roundingRule, carryRule, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, NumberFormatRule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        NumberFormatRule.write$Self$localization_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}