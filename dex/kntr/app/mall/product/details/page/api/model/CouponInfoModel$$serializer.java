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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FooterFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CouponInfoModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CouponInfoModel$$serializer implements GeneratedSerializer<CouponInfoModel> {
    public static final int $stable;
    public static final CouponInfoModel$$serializer INSTANCE = new CouponInfoModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CouponInfoModel", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("couponAvailable", true);
        pluginGeneratedSerialDescriptor.addElement("status", true);
        pluginGeneratedSerialDescriptor.addElement("stockStatus", true);
        pluginGeneratedSerialDescriptor.addElement("showName", true);
        pluginGeneratedSerialDescriptor.addElement("couponUseEndTimeStr", true);
        pluginGeneratedSerialDescriptor.addElement("couponUseEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("couponUseStartTimeStr", true);
        pluginGeneratedSerialDescriptor.addElement("couponUseStartTime", true);
        pluginGeneratedSerialDescriptor.addElement("couponDesc", true);
        pluginGeneratedSerialDescriptor.addElement("couponTypeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("couponShowTypeName", true);
        pluginGeneratedSerialDescriptor.addElement("discountY", true);
        pluginGeneratedSerialDescriptor.addElement("discountYPrefix", true);
        pluginGeneratedSerialDescriptor.addElement("discountYSuffix", true);
        pluginGeneratedSerialDescriptor.addElement("sourceAuthorityId", true);
        pluginGeneratedSerialDescriptor.addElement("sourceId", true);
        pluginGeneratedSerialDescriptor.addElement("sourceActivityId", true);
        pluginGeneratedSerialDescriptor.addElement("needDeviceCheck", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CouponInfoModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    public final CouponInfoModel deserialize(Decoder decoder) {
        Boolean bool;
        Boolean bool2;
        String str;
        String str2;
        int i;
        String str3;
        Byte b;
        Byte b2;
        String str4;
        String str5;
        Long l;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        int i2;
        String str15;
        String str16;
        Long l2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, BooleanSerializer.INSTANCE, (Object) null);
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            str = str22;
            str2 = str21;
            str6 = str20;
            str7 = str19;
            str3 = str18;
            str10 = str17;
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ByteSerializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ByteSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            i = 262143;
        } else {
            boolean z = true;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            Boolean bool3 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            Long l3 = null;
            Boolean bool4 = null;
            Byte b3 = null;
            Byte b4 = null;
            String str33 = null;
            String str34 = null;
            int i3 = 0;
            String str35 = null;
            while (z) {
                Long l4 = l3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str15 = str23;
                        str16 = str24;
                        l2 = l4;
                        z = false;
                        l3 = l2;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 0:
                        str15 = str23;
                        str16 = str24;
                        l2 = l4;
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 1;
                        b3 = b3;
                        l3 = l2;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 1:
                        str15 = str23;
                        str16 = str24;
                        l2 = l4;
                        b3 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ByteSerializer.INSTANCE, b3);
                        i3 |= 2;
                        b4 = b4;
                        l3 = l2;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 2:
                        str15 = str23;
                        str16 = str24;
                        l2 = l4;
                        b4 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ByteSerializer.INSTANCE, b4);
                        i3 |= 4;
                        str33 = str33;
                        l3 = l2;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 3:
                        str15 = str23;
                        str16 = str24;
                        l2 = l4;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str33);
                        i3 |= 8;
                        str34 = str34;
                        l3 = l2;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 4:
                        str15 = str23;
                        str16 = str24;
                        l2 = l4;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str34);
                        i3 |= 16;
                        l3 = l2;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 5:
                        str15 = str23;
                        str16 = str24;
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l4);
                        i3 |= 32;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 6:
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str26);
                        i3 |= 64;
                        str23 = str23;
                        l3 = l4;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str14 = str26;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str32);
                        i3 |= 128;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 8:
                        str14 = str26;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str31);
                        i3 |= 256;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str14 = str26;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str30);
                        i3 |= 512;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 10:
                        str14 = str26;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str25);
                        i3 |= 1024;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str14 = str26;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str29);
                        i3 |= 2048;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 12:
                        str14 = str26;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str28);
                        i3 |= 4096;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 13:
                        str14 = str26;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str23);
                        i3 |= 8192;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str14 = str26;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str24);
                        i3 |= 16384;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 15:
                        str14 = str26;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str35);
                        i2 = 32768;
                        i3 |= i2;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 16:
                        str14 = str26;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str27);
                        i2 = 65536;
                        i3 |= i2;
                        l3 = l4;
                        str26 = str14;
                        break;
                    case 17:
                        str14 = str26;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, BooleanSerializer.INSTANCE, bool3);
                        i2 = 131072;
                        i3 |= i2;
                        l3 = l4;
                        str26 = str14;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Byte b5 = b3;
            bool = bool4;
            bool2 = bool3;
            str = str27;
            str2 = str35;
            i = i3;
            str3 = str28;
            b = b5;
            b2 = b4;
            str4 = str33;
            str5 = str34;
            l = l3;
            str6 = str24;
            str7 = str23;
            str8 = str25;
            str9 = str26;
            str10 = str29;
            str11 = str30;
            str12 = str31;
            str13 = str32;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CouponInfoModel(i, bool, b, b2, str4, str5, l, str9, str13, str12, str11, str8, str10, str3, str7, str6, str2, str, bool2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CouponInfoModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CouponInfoModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}