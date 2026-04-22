package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroLineHeightStyle;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/common/ouro/core/model/mark/OuroLineHeightStyle.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class OuroLineHeightStyle$$serializer implements GeneratedSerializer<OuroLineHeightStyle> {
    public static final OuroLineHeightStyle$$serializer INSTANCE = new OuroLineHeightStyle$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.ouro.core.model.mark.OuroLineHeightStyle", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("alignment", true);
        pluginGeneratedSerialDescriptor.addElement("trim", true);
        pluginGeneratedSerialDescriptor.addElement("mode", true);
        pluginGeneratedSerialDescriptor.addElement("unit", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OuroLineHeightStyle$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = OuroLineHeightStyle.$childSerializers;
        return new KSerializer[]{OuroLineHeightStyle$Alignment$$serializer.INSTANCE, lazyArr[1].getValue(), lazyArr[2].getValue(), lazyArr[3].getValue()};
    }

    public final OuroLineHeightStyle deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        OuroLineHeightStyle.Alignment alignment;
        OuroLineHeightStyle.Trim trim;
        OuroLineHeightStyle.Mode mode;
        OuroLineHeightStyle.Unit unit;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = OuroLineHeightStyle.$childSerializers;
        OuroLineHeightStyle.Alignment alignment2 = null;
        if (beginStructure.decodeSequentially()) {
            alignment = (OuroLineHeightStyle.Alignment) beginStructure.decodeSerializableElement(serialDescriptor, 0, OuroLineHeightStyle$Alignment$$serializer.INSTANCE, (Object) null);
            OuroLineHeightStyle.Trim trim2 = (OuroLineHeightStyle.Trim) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            mode = (OuroLineHeightStyle.Mode) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            unit = (OuroLineHeightStyle.Unit) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            i = 15;
            trim = trim2;
        } else {
            boolean z = true;
            int i2 = 0;
            OuroLineHeightStyle.Trim trim3 = null;
            OuroLineHeightStyle.Mode mode2 = null;
            OuroLineHeightStyle.Unit unit2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        alignment2 = (OuroLineHeightStyle.Alignment) beginStructure.decodeSerializableElement(serialDescriptor, 0, OuroLineHeightStyle$Alignment$$serializer.INSTANCE, alignment2);
                        i2 |= 1;
                        break;
                    case 1:
                        trim3 = (OuroLineHeightStyle.Trim) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), trim3);
                        i2 |= 2;
                        break;
                    case 2:
                        mode2 = (OuroLineHeightStyle.Mode) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), mode2);
                        i2 |= 4;
                        break;
                    case 3:
                        unit2 = (OuroLineHeightStyle.Unit) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), unit2);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            alignment = alignment2;
            trim = trim3;
            mode = mode2;
            unit = unit2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OuroLineHeightStyle(i, alignment, trim, mode, unit, null, null);
    }

    public final void serialize(Encoder encoder, OuroLineHeightStyle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OuroLineHeightStyle.write$Self$core_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}