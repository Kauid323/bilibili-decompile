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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AtmospherePriceFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/PriceModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/PriceModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class PriceModel$$serializer implements GeneratedSerializer<PriceModel> {
    public static final int $stable;
    public static final PriceModel$$serializer INSTANCE = new PriceModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.PriceModel", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("firstPrice", true);
        pluginGeneratedSerialDescriptor.addElement("firstPricePrefix", true);
        pluginGeneratedSerialDescriptor.addElement("firstPriceSuffix", true);
        pluginGeneratedSerialDescriptor.addElement("firstPriceSymbol", true);
        pluginGeneratedSerialDescriptor.addElement("firstPriceType", true);
        pluginGeneratedSerialDescriptor.addElement("netPrice", true);
        pluginGeneratedSerialDescriptor.addElement("netPricePrefix", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceSuffix", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceSymbol", true);
        pluginGeneratedSerialDescriptor.addElement("price", true);
        pluginGeneratedSerialDescriptor.addElement("pricePrefix", true);
        pluginGeneratedSerialDescriptor.addElement("priceSuffix", true);
        pluginGeneratedSerialDescriptor.addElement("priceSymbol", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private PriceModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final PriceModel deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Integer num;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, (Object) null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            str5 = str19;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i = 8191;
            str3 = str16;
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str4 = str17;
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            num = num2;
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str10 = str18;
        } else {
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            Integer num3 = null;
            boolean z = true;
            int i2 = 0;
            String str30 = null;
            String str31 = null;
            while (z) {
                String str32 = str20;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str14 = str21;
                        str15 = str30;
                        z = false;
                        str20 = str32;
                        str21 = str14;
                        str30 = str15;
                        break;
                    case 0:
                        str15 = str30;
                        str14 = str21;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str32);
                        i2 |= 1;
                        str21 = str14;
                        str30 = str15;
                        break;
                    case 1:
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str21);
                        i2 |= 2;
                        str30 = str30;
                        str20 = str32;
                        break;
                    case 2:
                        str13 = str21;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str30);
                        i2 |= 4;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 3:
                        str13 = str21;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str31);
                        i2 |= 8;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 4:
                        str13 = str21;
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num3);
                        i2 |= 16;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 5:
                        str13 = str21;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str27);
                        i2 |= 32;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 6:
                        str13 = str21;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str29);
                        i2 |= 64;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str13 = str21;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str26);
                        i2 |= 128;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 8:
                        str13 = str21;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str25);
                        i2 |= 256;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str13 = str21;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str24);
                        i2 |= 512;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 10:
                        str13 = str21;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str28);
                        i2 |= 1024;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str13 = str21;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str23);
                        i2 |= 2048;
                        str20 = str32;
                        str21 = str13;
                        break;
                    case 12:
                        str13 = str21;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str22);
                        i2 |= 4096;
                        str20 = str32;
                        str21 = str13;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str33 = str21;
            String str34 = str30;
            str = str20;
            i = i2;
            str2 = str22;
            str3 = str33;
            str4 = str34;
            String str35 = str31;
            str5 = str23;
            str6 = str35;
            String str36 = str29;
            str7 = str24;
            num = num3;
            str8 = str28;
            str9 = str25;
            str10 = str27;
            str11 = str26;
            str12 = str36;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PriceModel(i, str, str3, str4, str6, num, str10, str12, str11, str9, str7, str8, str5, str2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, PriceModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PriceModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}