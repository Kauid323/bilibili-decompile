package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
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

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActivityInfoFloor.ActivityInfoVO.CouponModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer implements GeneratedSerializer<ActivityInfoFloor.ActivityInfoVO.CouponModel> {
    public static final int $stable;
    public static final ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer INSTANCE = new ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActivityInfoFloor.ActivityInfoVO.CouponModel", INSTANCE, 19);
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

    private ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final ActivityInfoFloor.ActivityInfoVO.CouponModel deserialize(Decoder decoder) {
        Byte b;
        String str;
        String str2;
        Boolean bool;
        Double d;
        String str3;
        String str4;
        String str5;
        String str6;
        Byte b2;
        String str7;
        String str8;
        String str9;
        Integer num;
        Integer num2;
        Byte b3;
        int i;
        String str10;
        Integer num3;
        String str11;
        String str12;
        int i2;
        String str13;
        String str14;
        String str15;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, (Object) null);
            Byte b4 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, ByteSerializer.INSTANCE, (Object) null);
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, IntSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            num2 = num5;
            b3 = b4;
            num3 = num4;
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ByteSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, BooleanSerializer.INSTANCE, (Object) null);
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            i = 524287;
            str8 = str19;
            str2 = str16;
            str9 = str18;
            str = str17;
        } else {
            boolean z = true;
            String str20 = null;
            String str21 = null;
            Integer num6 = null;
            Byte b5 = null;
            String str22 = null;
            Integer num7 = null;
            Byte b6 = null;
            String str23 = null;
            String str24 = null;
            Boolean bool2 = null;
            Double d2 = null;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            Byte b7 = null;
            int i3 = 0;
            Integer num8 = null;
            while (z) {
                String str31 = str22;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        z = false;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 0:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str26);
                        i3 |= 1;
                        str27 = str27;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 1:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str27);
                        i3 |= 2;
                        str28 = str28;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 2:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str28);
                        i3 |= 4;
                        str29 = str29;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 3:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str29);
                        i3 |= 8;
                        str30 = str30;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 4:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str30);
                        i3 |= 16;
                        b7 = b7;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 5:
                        str13 = str20;
                        str14 = str21;
                        str15 = str31;
                        b7 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, b7);
                        i3 |= 32;
                        str22 = str15;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case 6:
                        str13 = str20;
                        str14 = str21;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str31);
                        i3 |= 64;
                        str21 = str14;
                        str20 = str13;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str25);
                        i3 |= 128;
                        str20 = str20;
                        str22 = str31;
                        break;
                    case 8:
                        str12 = str25;
                        d2 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, d2);
                        i3 |= 256;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str12 = str25;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, BooleanSerializer.INSTANCE, bool2);
                        i3 |= 512;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 10:
                        str12 = str25;
                        b5 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ByteSerializer.INSTANCE, b5);
                        i3 |= 1024;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str12 = str25;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str24);
                        i3 |= 2048;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 12:
                        str12 = str25;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str23);
                        i3 |= 4096;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 13:
                        str12 = str25;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str20);
                        i3 |= 8192;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str12 = str25;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str21);
                        i3 |= 16384;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 15:
                        str12 = str25;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, num8);
                        i2 = 32768;
                        i3 |= i2;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 16:
                        str12 = str25;
                        b6 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, ByteSerializer.INSTANCE, b6);
                        i2 = 65536;
                        i3 |= i2;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 17:
                        str12 = str25;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, IntSerializer.INSTANCE, num7);
                        i2 = 131072;
                        i3 |= i2;
                        str22 = str31;
                        str25 = str12;
                        break;
                    case 18:
                        str12 = str25;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, IntSerializer.INSTANCE, num6);
                        i2 = 262144;
                        i3 |= i2;
                        str22 = str31;
                        str25 = str12;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            b = b5;
            str = str23;
            str2 = str24;
            bool = bool2;
            d = d2;
            str3 = str25;
            str4 = str28;
            str5 = str29;
            str6 = str30;
            b2 = b7;
            str7 = str22;
            str8 = str21;
            str9 = str20;
            num = num6;
            num2 = num7;
            b3 = b6;
            i = i3;
            str10 = str27;
            num3 = num8;
            str11 = str26;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityInfoFloor.ActivityInfoVO.CouponModel(i, str11, str10, str4, str5, str6, b2, str7, str3, d, bool, b, str2, str, str9, str8, num3, b3, num2, num, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActivityInfoFloor.ActivityInfoVO.CouponModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityInfoFloor.ActivityInfoVO.CouponModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}