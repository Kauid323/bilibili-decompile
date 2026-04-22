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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CommonGoodsTagBean.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CommonGoodsTagBean.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CommonGoodsTagBean$$serializer implements GeneratedSerializer<CommonGoodsTagBean> {
    public static final int $stable;
    public static final CommonGoodsTagBean$$serializer INSTANCE = new CommonGoodsTagBean$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CommonGoodsTagBean", INSTANCE, 23);
        pluginGeneratedSerialDescriptor.addElement("tagVersion", true);
        pluginGeneratedSerialDescriptor.addElement("backImgUrlDay", true);
        pluginGeneratedSerialDescriptor.addElement("backImgUrlNight", true);
        pluginGeneratedSerialDescriptor.addElement("tagType", true);
        pluginGeneratedSerialDescriptor.addElement("backImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("backNightImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("backImgWidth", true);
        pluginGeneratedSerialDescriptor.addElement("backImgHeight", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("cornerRadius", true);
        pluginGeneratedSerialDescriptor.addElement("useBoard", true);
        pluginGeneratedSerialDescriptor.addElement("boardDayColor1", true);
        pluginGeneratedSerialDescriptor.addElement("boardDayColor2", true);
        pluginGeneratedSerialDescriptor.addElement("boardNightColor1", true);
        pluginGeneratedSerialDescriptor.addElement("boardNightColor2", true);
        pluginGeneratedSerialDescriptor.addElement("backDayColor1", true);
        pluginGeneratedSerialDescriptor.addElement("backDayColor2", true);
        pluginGeneratedSerialDescriptor.addElement("backNightColor1", true);
        pluginGeneratedSerialDescriptor.addElement("backNightColor2", true);
        pluginGeneratedSerialDescriptor.addElement("titleDayColor1", true);
        pluginGeneratedSerialDescriptor.addElement("titleDayColor2", true);
        pluginGeneratedSerialDescriptor.addElement("titleNightColor1", true);
        pluginGeneratedSerialDescriptor.addElement("titleNightColor2", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CommonGoodsTagBean$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final CommonGoodsTagBean deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        Integer num;
        String str4;
        Double d;
        Double d2;
        String str5;
        Double d3;
        Integer num2;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Integer num3;
        String str16;
        int i;
        String str17;
        String str18;
        int i2;
        String str19;
        String str20;
        Integer num4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            String str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            String str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            String str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, (Object) null);
            String str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, (Object) null);
            String str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, (Object) null);
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, (Object) null);
            str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str14 = str29;
            str9 = str28;
            str8 = str27;
            str16 = str26;
            str7 = str30;
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DoubleSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            d2 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, DoubleSerializer.INSTANCE, (Object) null);
            d3 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, DoubleSerializer.INSTANCE, (Object) null);
            str15 = str25;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            i = 8388607;
            str10 = str24;
            str2 = str21;
            str6 = str23;
            str = str22;
        } else {
            boolean z = true;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            Integer num5 = null;
            String str36 = null;
            String str37 = null;
            String str38 = null;
            String str39 = null;
            String str40 = null;
            String str41 = null;
            Integer num6 = null;
            String str42 = null;
            String str43 = null;
            Integer num7 = null;
            String str44 = null;
            String str45 = null;
            Double d4 = null;
            Double d5 = null;
            String str46 = null;
            Double d6 = null;
            int i3 = 0;
            String str47 = null;
            while (z) {
                Integer num8 = num5;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str19 = str31;
                        str20 = str32;
                        num4 = num8;
                        z = false;
                        str31 = str19;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 0:
                        str20 = str32;
                        num4 = num8;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num6);
                        i3 |= 1;
                        str31 = str31;
                        str42 = str42;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 1:
                        str20 = str32;
                        num4 = num8;
                        str42 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str42);
                        i3 |= 2;
                        str31 = str31;
                        str43 = str43;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 2:
                        str20 = str32;
                        num4 = num8;
                        str43 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str43);
                        i3 |= 4;
                        str31 = str31;
                        num7 = num7;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 3:
                        str20 = str32;
                        num4 = num8;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num7);
                        i3 |= 8;
                        str31 = str31;
                        str44 = str44;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 4:
                        str20 = str32;
                        num4 = num8;
                        str44 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str44);
                        i3 |= 16;
                        str31 = str31;
                        str45 = str45;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 5:
                        str20 = str32;
                        num4 = num8;
                        str45 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str45);
                        i3 |= 32;
                        str31 = str31;
                        d4 = d4;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 6:
                        str20 = str32;
                        num4 = num8;
                        d4 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DoubleSerializer.INSTANCE, d4);
                        i3 |= 64;
                        str31 = str31;
                        d5 = d5;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str20 = str32;
                        num4 = num8;
                        d5 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, DoubleSerializer.INSTANCE, d5);
                        i3 |= 128;
                        str31 = str31;
                        str46 = str46;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 8:
                        str20 = str32;
                        num4 = num8;
                        str46 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str46);
                        i3 |= 256;
                        str31 = str31;
                        d6 = d6;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str19 = str31;
                        str20 = str32;
                        num4 = num8;
                        d6 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, DoubleSerializer.INSTANCE, d6);
                        i3 |= 512;
                        str31 = str19;
                        num5 = num4;
                        str32 = str20;
                        break;
                    case 10:
                        str20 = str32;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num8);
                        i3 |= 1024;
                        str31 = str31;
                        str32 = str20;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str40 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str40);
                        i3 |= 2048;
                        str31 = str31;
                        num5 = num8;
                        break;
                    case 12:
                        str18 = str40;
                        str39 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str39);
                        i3 |= 4096;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 13:
                        str18 = str40;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str31);
                        i3 |= 8192;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str18 = str40;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str32);
                        i3 |= 16384;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 15:
                        str18 = str40;
                        str47 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str47);
                        i2 = 32768;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 16:
                        str18 = str40;
                        str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str38);
                        i2 = 65536;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 17:
                        str18 = str40;
                        str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str37);
                        i2 = 131072;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 18:
                        str18 = str40;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str35);
                        i2 = 262144;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 19:
                        str18 = str40;
                        str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str36);
                        i2 = 524288;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 20:
                        str18 = str40;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str34);
                        i2 = 1048576;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 21:
                        str18 = str40;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str33);
                        i2 = 2097152;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    case 22:
                        str18 = str40;
                        str41 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, str41);
                        i2 = 4194304;
                        i3 |= i2;
                        num5 = num8;
                        str40 = str18;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str39;
            str2 = str40;
            str3 = str31;
            num = num7;
            str4 = str44;
            d = d4;
            d2 = d5;
            str5 = str46;
            d3 = d6;
            num2 = num5;
            str6 = str32;
            str7 = str33;
            str8 = str35;
            str9 = str36;
            str10 = str47;
            str11 = str41;
            str12 = str42;
            str13 = str45;
            str14 = str34;
            str15 = str38;
            num3 = num6;
            str16 = str37;
            i = i3;
            str17 = str43;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CommonGoodsTagBean(i, num3, str12, str17, num, str4, str13, d, d2, str5, d3, num2, str2, str, str3, str6, str10, str15, str16, str8, str9, str14, str7, str11, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CommonGoodsTagBean value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CommonGoodsTagBean.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}