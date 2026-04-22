package kntr.app.mall.product.details.page.api.model;

import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: AdvStateFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/AdvStateFloor.AdvState.StateInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdvStateFloor$AdvState$StateInfo$$serializer implements GeneratedSerializer<AdvStateFloor.AdvState.StateInfo> {
    public static final int $stable;
    public static final AdvStateFloor$AdvState$StateInfo$$serializer INSTANCE = new AdvStateFloor$AdvState$StateInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.AdvStateFloor.AdvState.StateInfo", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("timeNode", true);
        pluginGeneratedSerialDescriptor.addElement("process", true);
        pluginGeneratedSerialDescriptor.addElement("active", true);
        pluginGeneratedSerialDescriptor.addElement("timeNodeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("underlineProcess", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private AdvStateFloor$AdvState$StateInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(AdvStateFloor$AdvState$StateInfo$TimeNode$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)};
    }

    public final AdvStateFloor.AdvState.StateInfo deserialize(Decoder decoder) {
        int i;
        AdvStateFloor.AdvState.StateInfo.TimeNode timeNode;
        String str;
        Boolean bool;
        String str2;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        AdvStateFloor.AdvState.StateInfo.TimeNode timeNode2 = null;
        if (beginStructure.decodeSequentially()) {
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, (Object) null);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            timeNode = (AdvStateFloor.AdvState.StateInfo.TimeNode) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AdvStateFloor$AdvState$StateInfo$TimeNode$$serializer.INSTANCE, (Object) null);
            i = 31;
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, JsonElementSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str2 = str3;
        } else {
            boolean z = true;
            i = 0;
            String str4 = null;
            Boolean bool2 = null;
            String str5 = null;
            JsonElement jsonElement2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        timeNode2 = (AdvStateFloor.AdvState.StateInfo.TimeNode) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AdvStateFloor$AdvState$StateInfo$TimeNode$$serializer.INSTANCE, timeNode2);
                        i |= 1;
                        break;
                    case 1:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str4);
                        i |= 2;
                        break;
                    case 2:
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool2);
                        i |= 4;
                        break;
                    case 3:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str5);
                        i |= 8;
                        break;
                    case 4:
                        jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, JsonElementSerializer.INSTANCE, jsonElement2);
                        i |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            timeNode = timeNode2;
            str = str4;
            bool = bool2;
            str2 = str5;
            jsonElement = jsonElement2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdvStateFloor.AdvState.StateInfo(i, timeNode, str, bool, str2, jsonElement, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdvStateFloor.AdvState.StateInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdvStateFloor.AdvState.StateInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}