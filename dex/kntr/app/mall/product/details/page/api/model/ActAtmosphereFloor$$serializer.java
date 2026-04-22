package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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

/* compiled from: ActAtmosphereFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActAtmosphereFloor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActAtmosphereFloor$$serializer implements GeneratedSerializer<ActAtmosphereFloor> {
    public static final int $stable;
    public static final ActAtmosphereFloor$$serializer INSTANCE = new ActAtmosphereFloor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActAtmosphereFloor", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("floorKey", true);
        pluginGeneratedSerialDescriptor.addElement("floorIcon", true);
        pluginGeneratedSerialDescriptor.addElement("bgImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("actLabel", true);
        pluginGeneratedSerialDescriptor.addElement("atmosEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("atmosStartTime", true);
        pluginGeneratedSerialDescriptor.addElement("atmosphereImg", true);
        pluginGeneratedSerialDescriptor.addElement("countDownPrefix", true);
        pluginGeneratedSerialDescriptor.addElement("countDownSuffix", true);
        pluginGeneratedSerialDescriptor.addElement("leftLabel", true);
        pluginGeneratedSerialDescriptor.addElement("rightLabel", true);
        pluginGeneratedSerialDescriptor.addElement("serverTime", true);
        pluginGeneratedSerialDescriptor.addElement("showCountDown", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActAtmosphereFloor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LabelObject$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LabelObject$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    public final ActAtmosphereFloor deserialize(Decoder decoder) {
        String str;
        int i;
        Boolean bool;
        String str2;
        String str3;
        Long l;
        String str4;
        LabelObject labelObject;
        Long l2;
        LabelObject labelObject2;
        String str5;
        Long l3;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            Long l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
            Long l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            Long l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, LongSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, BooleanSerializer.INSTANCE, (Object) null);
            l = l6;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i = 8191;
            str2 = str11;
            labelObject2 = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, LabelObject$$serializer.INSTANCE, (Object) null);
            str3 = str12;
            labelObject = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LabelObject$$serializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            l2 = l4;
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            l3 = l5;
        } else {
            String str13 = null;
            String str14 = null;
            Boolean bool2 = null;
            Long l7 = null;
            LabelObject labelObject3 = null;
            String str15 = null;
            String str16 = null;
            Long l8 = null;
            LabelObject labelObject4 = null;
            String str17 = null;
            Long l9 = null;
            boolean z = true;
            int i2 = 0;
            String str18 = null;
            String str19 = null;
            while (z) {
                String str20 = str13;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str9 = str14;
                        str10 = str18;
                        z = false;
                        str13 = str20;
                        str14 = str9;
                        str18 = str10;
                        break;
                    case 0:
                        str10 = str18;
                        str9 = str14;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str20);
                        i2 |= 1;
                        str14 = str9;
                        str18 = str10;
                        break;
                    case 1:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str14);
                        i2 |= 2;
                        str18 = str18;
                        str13 = str20;
                        break;
                    case 2:
                        str8 = str14;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str18);
                        i2 |= 4;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 3:
                        str8 = str14;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str19);
                        i2 |= 8;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 4:
                        str8 = str14;
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l9);
                        i2 |= 16;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 5:
                        str8 = str14;
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l8);
                        i2 |= 32;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 6:
                        str8 = str14;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str17);
                        i2 |= 64;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str8 = str14;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str16);
                        i2 |= 128;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 8:
                        str8 = str14;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str15);
                        i2 |= 256;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str8 = str14;
                        labelObject3 = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LabelObject$$serializer.INSTANCE, labelObject3);
                        i2 |= 512;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 10:
                        str8 = str14;
                        labelObject4 = (LabelObject) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, LabelObject$$serializer.INSTANCE, labelObject4);
                        i2 |= 1024;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str8 = str14;
                        l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, LongSerializer.INSTANCE, l7);
                        i2 |= 2048;
                        str13 = str20;
                        str14 = str8;
                        break;
                    case 12:
                        str8 = str14;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, BooleanSerializer.INSTANCE, bool2);
                        i2 |= 4096;
                        str13 = str20;
                        str14 = str8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str21 = str14;
            String str22 = str18;
            str = str13;
            i = i2;
            bool = bool2;
            str2 = str21;
            str3 = str22;
            String str23 = str19;
            l = l7;
            str4 = str23;
            String str24 = str17;
            labelObject = labelObject3;
            l2 = l9;
            labelObject2 = labelObject4;
            str5 = str15;
            l3 = l8;
            str6 = str16;
            str7 = str24;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActAtmosphereFloor(i, str, str2, str3, str4, l2, l3, str7, str6, str5, labelObject, labelObject2, l, bool, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActAtmosphereFloor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActAtmosphereFloor.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}