package kntr.app.digital.preview.card.web;

import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WebCard.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/preview/card/web/Feature.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/preview/card/web/Feature;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class Feature$$serializer implements GeneratedSerializer<Feature> {
    public static final int $stable;
    public static final Feature$$serializer INSTANCE = new Feature$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.card.web.Feature", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("sealed", true);
        pluginGeneratedSerialDescriptor.addElement("property_icon", true);
        pluginGeneratedSerialDescriptor.addElement("property_name", true);
        pluginGeneratedSerialDescriptor.addElement("property_value", true);
        pluginGeneratedSerialDescriptor.addElement("property_level_icon", true);
        pluginGeneratedSerialDescriptor.addElement("property_desc", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private Feature$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanAsIntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    public final Feature deserialize(Decoder decoder) {
        String str;
        String str2;
        boolean z;
        String str3;
        int i;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 5;
        if (beginStructure.decodeSequentially()) {
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 0, BooleanAsIntSerializer.INSTANCE, false)).booleanValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 4);
            z = booleanValue;
            str = beginStructure.decodeStringElement(serialDescriptor, 5);
            str3 = decodeStringElement3;
            str2 = decodeStringElement4;
            str4 = decodeStringElement2;
            str5 = decodeStringElement;
            i = 63;
        } else {
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            boolean z2 = true;
            boolean z3 = false;
            int i3 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z2 = false;
                        i2 = 5;
                    case 0:
                        z3 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 0, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(z3))).booleanValue();
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                    case 2:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i3 |= 4;
                    case 3:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i3 |= 8;
                    case 4:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i3 |= 16;
                    case 5:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, i2);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str6;
            str2 = str8;
            z = z3;
            int i4 = i3;
            str3 = str7;
            i = i4;
            String str11 = str10;
            str4 = str9;
            str5 = str11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Feature(i, z, str5, str4, str3, str2, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, Feature value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Feature.write$Self$preview_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}