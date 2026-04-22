package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AtmospherePriceFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActAtmosphereVO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActAtmosphereVO$$serializer implements GeneratedSerializer<ActAtmosphereVO> {
    public static final int $stable;
    public static final ActAtmosphereVO$$serializer INSTANCE = new ActAtmosphereVO$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActAtmosphereVO", INSTANCE, 11);
        pluginGeneratedSerialDescriptor.addElement("actLabel", true);
        pluginGeneratedSerialDescriptor.addElement("atmosEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("atmosStartTime", true);
        pluginGeneratedSerialDescriptor.addElement("atmosphereImg", true);
        pluginGeneratedSerialDescriptor.addElement("floorKey", true);
        pluginGeneratedSerialDescriptor.addElement("leftLabel", true);
        pluginGeneratedSerialDescriptor.addElement("rightLabel", true);
        pluginGeneratedSerialDescriptor.addElement("serverTime", true);
        pluginGeneratedSerialDescriptor.addElement("showCountDown", true);
        pluginGeneratedSerialDescriptor.addElement("countDownPrefix", true);
        pluginGeneratedSerialDescriptor.addElement("countDownSuffix", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActAtmosphereVO$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LabelObject$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LabelObject$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final ActAtmosphereVO deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        LabelObject labelObject;
        String str4;
        Long l;
        LabelObject labelObject2;
        Long l2;
        Long l3;
        String str5;
        Boolean bool;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str6 = null;
        if (beginStructure.decodeSequentially()) {
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, (Object) null);
            labelObject = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LabelObject$$serializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, (Object) null);
            labelObject2 = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LabelObject$$serializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, (Object) null);
            i = 2047;
        } else {
            boolean z = true;
            int i2 = 0;
            String str7 = null;
            Boolean bool2 = null;
            Long l4 = null;
            LabelObject labelObject3 = null;
            String str8 = null;
            String str9 = null;
            LabelObject labelObject4 = null;
            String str10 = null;
            Long l5 = null;
            Long l6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str6);
                        i2 |= 1;
                    case 1:
                        l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l6);
                        i2 |= 2;
                    case 2:
                        l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l5);
                        i2 |= 4;
                    case 3:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str10);
                        i2 |= 8;
                    case 4:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i2 |= 16;
                    case 5:
                        labelObject4 = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LabelObject$$serializer.INSTANCE, labelObject4);
                        i2 |= 32;
                    case 6:
                        labelObject3 = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LabelObject$$serializer.INSTANCE, labelObject3);
                        i2 |= 64;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, l4);
                        i2 |= 128;
                    case 8:
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool2);
                        i2 |= 256;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str9);
                        i2 |= 512;
                    case 10:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str7);
                        i2 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str7;
            str2 = str9;
            str3 = str10;
            labelObject = labelObject4;
            str4 = str8;
            l = l5;
            labelObject2 = labelObject3;
            l2 = l6;
            l3 = l4;
            str5 = str6;
            bool = bool2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActAtmosphereVO(i, str5, l2, l, str3, str4, labelObject, labelObject2, l3, bool, str2, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActAtmosphereVO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActAtmosphereVO.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}