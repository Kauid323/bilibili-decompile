package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CouponInfoFloor.CouponInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CouponInfoFloor$CouponInfo$$serializer implements GeneratedSerializer<CouponInfoFloor.CouponInfo> {
    public static final int $stable;
    public static final CouponInfoFloor$CouponInfo$$serializer INSTANCE = new CouponInfoFloor$CouponInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CouponInfoFloor.CouponInfo", INSTANCE, 20);
        pluginGeneratedSerialDescriptor.addElement("couponId", true);
        pluginGeneratedSerialDescriptor.addElement("couponName", true);
        pluginGeneratedSerialDescriptor.addElement("couponStatus", true);
        pluginGeneratedSerialDescriptor.addElement("couponStatusMsg", true);
        pluginGeneratedSerialDescriptor.addElement("couponTag", true);
        pluginGeneratedSerialDescriptor.addElement("couponType", true);
        pluginGeneratedSerialDescriptor.addElement("couponTypeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("discount", true);
        pluginGeneratedSerialDescriptor.addElement("discountY", true);
        pluginGeneratedSerialDescriptor.addElement("isExclusive", true);
        pluginGeneratedSerialDescriptor.addElement("newUserLimit", true);
        pluginGeneratedSerialDescriptor.addElement("sceneInfoList", true);
        pluginGeneratedSerialDescriptor.addElement("shopLabel", true);
        pluginGeneratedSerialDescriptor.addElement("showName", true);
        pluginGeneratedSerialDescriptor.addElement("sourceAuthorityId", true);
        pluginGeneratedSerialDescriptor.addElement("sourceId", true);
        pluginGeneratedSerialDescriptor.addElement("useEffectDays", true);
        pluginGeneratedSerialDescriptor.addElement("useEffectUnit", true);
        pluginGeneratedSerialDescriptor.addElement("useEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("useStartTime", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CouponInfoFloor$CouponInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CouponInfoFloor.CouponInfo.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[11].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final CouponInfoFloor.CouponInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        String str2;
        Integer num;
        Byte b;
        Integer num2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Double d;
        Boolean bool;
        String str8;
        Byte b2;
        Integer num3;
        String str9;
        String str10;
        List list;
        String str11;
        Byte b3;
        Boolean bool2;
        int i2;
        Lazy[] lazyArr2;
        String str12;
        Boolean bool3;
        Double d2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CouponInfoFloor.CouponInfo.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Byte b4 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ByteSerializer.INSTANCE, (Object) null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, (Object) null);
            Byte b5 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, ByteSerializer.INSTANCE, (Object) null);
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, IntSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, IntSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), (Object) null);
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, BooleanSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            num2 = num5;
            b = b5;
            num3 = num4;
            str10 = str16;
            str9 = str15;
            str8 = str14;
            str11 = str13;
            b2 = b4;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            b3 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            i = 1048575;
        } else {
            boolean z = true;
            String str17 = null;
            String str18 = null;
            Integer num6 = null;
            Byte b6 = null;
            Byte b7 = null;
            Integer num7 = null;
            Integer num8 = null;
            String str19 = null;
            List list2 = null;
            Boolean bool4 = null;
            Double d3 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            Byte b8 = null;
            String str25 = null;
            String str26 = null;
            int i3 = 0;
            String str27 = null;
            while (z) {
                Double d4 = d3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        lazyArr2 = lazyArr;
                        z = false;
                        str17 = str17;
                        d3 = d4;
                        lazyArr = lazyArr2;
                        break;
                    case 0:
                        str12 = str17;
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str20);
                        i3 |= 1;
                        str17 = str12;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 1:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str21);
                        i3 |= 2;
                        str17 = str17;
                        str22 = str22;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 2:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str22);
                        i3 |= 4;
                        str17 = str17;
                        str23 = str23;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 3:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str23);
                        i3 |= 8;
                        str17 = str17;
                        str24 = str24;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 4:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str24);
                        i3 |= 16;
                        str17 = str17;
                        b8 = b8;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 5:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        b8 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, b8);
                        i3 |= 32;
                        str17 = str17;
                        str25 = str25;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 6:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str25);
                        i3 |= 64;
                        str17 = str17;
                        str26 = str26;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str12 = str17;
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        d2 = d4;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str26);
                        i3 |= 128;
                        str17 = str12;
                        d3 = d2;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case 8:
                        lazyArr2 = lazyArr;
                        bool3 = bool4;
                        i3 |= 256;
                        d3 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, d4);
                        str17 = str17;
                        bool4 = bool3;
                        lazyArr = lazyArr2;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 512;
                        str17 = str17;
                        lazyArr = lazyArr;
                        d3 = d4;
                        break;
                    case 10:
                        bool2 = bool4;
                        b7 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ByteSerializer.INSTANCE, b7);
                        i3 |= 1024;
                        str17 = str17;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        bool2 = bool4;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), list2);
                        i3 |= 2048;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 12:
                        bool2 = bool4;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str17);
                        i3 |= 4096;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 13:
                        bool2 = bool4;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str18);
                        i3 |= 8192;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        bool2 = bool4;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str27);
                        i3 |= 16384;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 15:
                        bool2 = bool4;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str19);
                        i2 = 32768;
                        i3 |= i2;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 16:
                        bool2 = bool4;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, num8);
                        i2 = 65536;
                        i3 |= i2;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 17:
                        bool2 = bool4;
                        b6 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, ByteSerializer.INSTANCE, b6);
                        i2 = 131072;
                        i3 |= i2;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 18:
                        bool2 = bool4;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, IntSerializer.INSTANCE, num7);
                        i2 = 262144;
                        i3 |= i2;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    case 19:
                        bool2 = bool4;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, IntSerializer.INSTANCE, num6);
                        i2 = 524288;
                        i3 |= i2;
                        d3 = d4;
                        bool4 = bool2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str21;
            str2 = str20;
            num = num6;
            b = b6;
            num2 = num7;
            i = i3;
            str3 = str22;
            str4 = str23;
            str5 = str24;
            str6 = str25;
            str7 = str26;
            d = d3;
            bool = bool4;
            str8 = str18;
            b2 = b7;
            num3 = num8;
            str9 = str27;
            str10 = str19;
            list = list2;
            str11 = str17;
            b3 = b8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CouponInfoFloor.CouponInfo(i, str2, str, str3, str4, str5, b3, str6, str7, d, bool, b2, list, str11, str8, str9, str10, num3, b, num2, num, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CouponInfoFloor.CouponInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CouponInfoFloor.CouponInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}