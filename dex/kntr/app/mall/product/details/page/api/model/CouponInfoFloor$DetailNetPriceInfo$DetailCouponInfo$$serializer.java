package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CouponInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer implements GeneratedSerializer<CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo> {
    public static final int $stable;
    public static final CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer INSTANCE = new CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo", INSTANCE, 25);
        pluginGeneratedSerialDescriptor.addElement("addNetPrice", true);
        pluginGeneratedSerialDescriptor.addElement("couponName", true);
        pluginGeneratedSerialDescriptor.addElement("couponStatus", true);
        pluginGeneratedSerialDescriptor.addElement("couponStatusMsg", true);
        pluginGeneratedSerialDescriptor.addElement("couponTag", true);
        pluginGeneratedSerialDescriptor.addElement("couponType", true);
        pluginGeneratedSerialDescriptor.addElement("couponTypeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("couponTypeName", true);
        pluginGeneratedSerialDescriptor.addElement("discountConditionY", true);
        pluginGeneratedSerialDescriptor.addElement("discountLayer", true);
        pluginGeneratedSerialDescriptor.addElement("discountLimit", true);
        pluginGeneratedSerialDescriptor.addElement("discountLimitDesc", true);
        pluginGeneratedSerialDescriptor.addElement("discountY", true);
        pluginGeneratedSerialDescriptor.addElement("isReceived", true);
        pluginGeneratedSerialDescriptor.addElement("landingPageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("owners", true);
        pluginGeneratedSerialDescriptor.addElement("ownersName", true);
        pluginGeneratedSerialDescriptor.addElement("receiveStatus", true);
        pluginGeneratedSerialDescriptor.addElement("reductionMoney", true);
        pluginGeneratedSerialDescriptor.addElement("showName", true);
        pluginGeneratedSerialDescriptor.addElement("sourceAuthorityId", true);
        pluginGeneratedSerialDescriptor.addElement("sourceId", true);
        pluginGeneratedSerialDescriptor.addElement("useEffectDays", true);
        pluginGeneratedSerialDescriptor.addElement("useEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("useStartTime", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo deserialize(Decoder decoder) {
        String str;
        Integer num;
        Integer num2;
        Integer num3;
        String str2;
        String str3;
        String str4;
        String str5;
        Byte b;
        String str6;
        Integer num4;
        String str7;
        Boolean bool;
        String str8;
        String str9;
        String str10;
        int i;
        String str11;
        Boolean bool2;
        Double d;
        String str12;
        Double d2;
        Integer num5;
        Integer num6;
        String str13;
        String str14;
        Boolean bool3;
        String str15;
        int i2;
        int i3;
        Double d3;
        Boolean bool4;
        String str16;
        String str17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            Double d4 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DoubleSerializer.INSTANCE, (Object) null);
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            Integer num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, IntSerializer.INSTANCE, (Object) null);
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, (Object) null);
            String str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, (Object) null);
            String str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, (Object) null);
            Integer num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, IntSerializer.INSTANCE, (Object) null);
            Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, IntSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, IntSerializer.INSTANCE, (Object) null);
            i = 33554431;
            str8 = str24;
            str9 = str23;
            num6 = num7;
            str13 = str22;
            str14 = str21;
            str10 = str20;
            str11 = str19;
            bool2 = bool5;
            str2 = str25;
            num3 = num8;
            num = num9;
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            d = d4;
            str7 = str18;
            d2 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, (Object) null);
            num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            Boolean bool6 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            Integer num10 = null;
            Integer num11 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            Double d5 = null;
            Integer num12 = null;
            Integer num13 = null;
            Boolean bool7 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            Byte b2 = null;
            String str36 = null;
            String str37 = null;
            Double d6 = null;
            Integer num14 = null;
            Integer num15 = null;
            String str38 = null;
            int i4 = 0;
            String str39 = null;
            while (z) {
                Double d7 = d5;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        d3 = d7;
                        z = false;
                        str27 = str27;
                        str26 = str26;
                        break;
                    case 0:
                        bool4 = bool6;
                        str16 = str26;
                        str17 = str27;
                        d3 = d7;
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, bool7);
                        i4 |= 1;
                        str27 = str17;
                        str26 = str16;
                        bool6 = bool4;
                        break;
                    case 1:
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str32);
                        i4 |= 2;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        str33 = str33;
                        continue;
                    case 2:
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str33);
                        i4 |= 4;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        str34 = str34;
                        continue;
                    case 3:
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str34);
                        i4 |= 8;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        str35 = str35;
                        continue;
                    case 4:
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str35);
                        i4 |= 16;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        b2 = b2;
                        continue;
                    case 5:
                        b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, b2);
                        i4 |= 32;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        str36 = str36;
                        continue;
                    case 6:
                        str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str36);
                        i4 |= 64;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        str37 = str37;
                        continue;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str37);
                        i4 |= 128;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        d6 = d6;
                        continue;
                    case 8:
                        d6 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, d6);
                        i4 |= 256;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        num14 = num14;
                        continue;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        num14 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, num14);
                        i4 |= 512;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        num15 = num15;
                        continue;
                    case 10:
                        num15 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num15);
                        i4 |= 1024;
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        d5 = d7;
                        str38 = str38;
                        continue;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        bool4 = bool6;
                        str16 = str26;
                        str17 = str27;
                        d3 = d7;
                        str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str38);
                        i4 |= 2048;
                        str27 = str17;
                        str26 = str16;
                        bool6 = bool4;
                        break;
                    case 12:
                        i4 |= 4096;
                        d5 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DoubleSerializer.INSTANCE, d7);
                        str27 = str27;
                        str26 = str26;
                        bool6 = bool6;
                        continue;
                    case 13:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, bool6);
                        i4 |= 8192;
                        str27 = str27;
                        str26 = str26;
                        d5 = d7;
                        continue;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        bool3 = bool6;
                        str15 = str27;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str26);
                        i4 |= 16384;
                        str27 = str15;
                        d5 = d7;
                        bool6 = bool3;
                    case 15:
                        bool3 = bool6;
                        str15 = str27;
                        str39 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str39);
                        i2 = 32768;
                        i4 |= i2;
                        str27 = str15;
                        d5 = d7;
                        bool6 = bool3;
                    case 16:
                        bool3 = bool6;
                        str15 = str27;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str31);
                        i2 = 65536;
                        i4 |= i2;
                        str27 = str15;
                        d5 = d7;
                        bool6 = bool3;
                    case 17:
                        bool3 = bool6;
                        str15 = str27;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str30);
                        i2 = 131072;
                        i4 |= i2;
                        str27 = str15;
                        d5 = d7;
                        bool6 = bool3;
                    case 18:
                        bool3 = bool6;
                        str15 = str27;
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, IntSerializer.INSTANCE, num10);
                        i2 = 262144;
                        i4 |= i2;
                        str27 = str15;
                        d5 = d7;
                        bool6 = bool3;
                    case 19:
                        bool3 = bool6;
                        str15 = str27;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str29);
                        i2 = 524288;
                        i4 |= i2;
                        str27 = str15;
                        d5 = d7;
                        bool6 = bool3;
                    case 20:
                        bool3 = bool6;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str28);
                        i3 = 1048576;
                        i4 |= i3;
                        d5 = d7;
                        bool6 = bool3;
                    case 21:
                        bool3 = bool6;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str27);
                        i3 = 2097152;
                        i4 |= i3;
                        d5 = d7;
                        bool6 = bool3;
                    case 22:
                        bool3 = bool6;
                        num13 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, IntSerializer.INSTANCE, num13);
                        i3 = 4194304;
                        i4 |= i3;
                        d5 = d7;
                        bool6 = bool3;
                    case 23:
                        bool3 = bool6;
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, IntSerializer.INSTANCE, num11);
                        i3 = 8388608;
                        i4 |= i3;
                        d5 = d7;
                        bool6 = bool3;
                    case 24:
                        bool3 = bool6;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, IntSerializer.INSTANCE, num12);
                        i3 = 16777216;
                        i4 |= i3;
                        d5 = d7;
                        bool6 = bool3;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                d5 = d3;
            }
            String str40 = str26;
            Boolean bool8 = bool7;
            String str41 = str33;
            String str42 = str34;
            str = str32;
            num = num11;
            num2 = num12;
            num3 = num13;
            str2 = str27;
            str3 = str41;
            str4 = str42;
            str5 = str35;
            b = b2;
            str6 = str36;
            num4 = num15;
            str7 = str38;
            bool = bool8;
            str8 = str28;
            str9 = str29;
            str10 = str39;
            i = i4;
            str11 = str40;
            bool2 = bool6;
            d = d5;
            str12 = str37;
            d2 = d6;
            num5 = num14;
            num6 = num10;
            str13 = str30;
            str14 = str31;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo(i, bool, str, str3, str4, str5, b, str6, str12, d2, num5, num4, str7, d, bool2, str11, str10, str14, str13, num6, str9, str8, str2, num3, num, num2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}