package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActivityInfoFloor.ActivityInfoVO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActivityInfoFloor$ActivityInfoVO$$serializer implements GeneratedSerializer<ActivityInfoFloor.ActivityInfoVO> {
    public static final int $stable;
    public static final ActivityInfoFloor$ActivityInfoVO$$serializer INSTANCE = new ActivityInfoFloor$ActivityInfoVO$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActivityInfoFloor.ActivityInfoVO", INSTANCE, 19);
        pluginGeneratedSerialDescriptor.addElement("activityId", true);
        pluginGeneratedSerialDescriptor.addElement("activitySaleStatus", true);
        pluginGeneratedSerialDescriptor.addElement("activityStatus", true);
        pluginGeneratedSerialDescriptor.addElement("countdownTime", true);
        pluginGeneratedSerialDescriptor.addElement("couponList", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("isAllSku", true);
        pluginGeneratedSerialDescriptor.addElement("isInWhiteList", true);
        pluginGeneratedSerialDescriptor.addElement("newCustomer", true);
        pluginGeneratedSerialDescriptor.addElement("preType", true);
        pluginGeneratedSerialDescriptor.addElement("publishTime", true);
        pluginGeneratedSerialDescriptor.addElement("reducedPrice", true);
        pluginGeneratedSerialDescriptor.addElement("reducedPriceUsedCoupon", true);
        pluginGeneratedSerialDescriptor.addElement("serverTime", true);
        pluginGeneratedSerialDescriptor.addElement("showLabel", true);
        pluginGeneratedSerialDescriptor.addElement("showLabelText", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("whiteBindInfo", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActivityInfoFloor$ActivityInfoVO$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ActivityInfoFloor.ActivityInfoVO.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityInfoVO$BindInfo$$serializer.INSTANCE)};
    }

    public final ActivityInfoFloor.ActivityInfoVO deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Boolean bool;
        Integer num;
        String str;
        Byte b;
        Boolean bool2;
        Integer num2;
        Byte b2;
        Integer num3;
        List list;
        Integer num4;
        Byte b3;
        Byte b4;
        ActivityInfoFloor.ActivityInfoVO.CouponModel couponModel;
        ActivityInfoFloor.ActivityInfoVO.BindInfo bindInfo;
        Integer num5;
        Integer num6;
        String str2;
        String str3;
        int i;
        Integer num7;
        Boolean bool3;
        int i2;
        ActivityInfoFloor.ActivityInfoVO.CouponModel couponModel2;
        Byte b5;
        Integer num8;
        Byte b6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ActivityInfoFloor.ActivityInfoVO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            ActivityInfoFloor.ActivityInfoVO.CouponModel couponModel3 = (ActivityInfoFloor.ActivityInfoVO.CouponModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer.INSTANCE, (Object) null);
            Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, (Object) null);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            Integer num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, (Object) null);
            Byte b7 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, ByteSerializer.INSTANCE, (Object) null);
            bindInfo = (ActivityInfoFloor.ActivityInfoVO.BindInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, ActivityInfoFloor$ActivityInfoVO$BindInfo$$serializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            b4 = b7;
            str2 = str5;
            num5 = num10;
            str3 = str4;
            num3 = num9;
            couponModel = couponModel3;
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, (Object) null);
            b3 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ByteSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, (Object) null);
            i = 524287;
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ByteSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
            b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ByteSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            ActivityInfoFloor.ActivityInfoVO.CouponModel couponModel4 = null;
            Byte b8 = null;
            Integer num11 = null;
            Boolean bool4 = null;
            ActivityInfoFloor.ActivityInfoVO.BindInfo bindInfo2 = null;
            Integer num12 = null;
            Integer num13 = null;
            Byte b9 = null;
            String str6 = null;
            String str7 = null;
            Byte b10 = null;
            Boolean bool5 = null;
            Integer num14 = null;
            Integer num15 = null;
            Byte b11 = null;
            Integer num16 = null;
            List list2 = null;
            Integer num17 = null;
            int i3 = 0;
            String str8 = null;
            while (z) {
                Byte b12 = b9;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        num11 = num11;
                        b9 = b12;
                        b8 = b8;
                        break;
                    case 0:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        num8 = num11;
                        b6 = b12;
                        num14 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num14);
                        i3 |= 1;
                        num15 = num15;
                        num11 = num8;
                        b9 = b6;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case 1:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        num8 = num11;
                        b6 = b12;
                        num15 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num15);
                        i3 |= 2;
                        b11 = b11;
                        num11 = num8;
                        b9 = b6;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case 2:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        b6 = b12;
                        num8 = num11;
                        b11 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ByteSerializer.INSTANCE, b11);
                        i3 |= 4;
                        num11 = num8;
                        b9 = b6;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case 3:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        b6 = b12;
                        num16 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num16);
                        i3 |= 8;
                        list2 = list2;
                        b9 = b6;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case 4:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        b6 = b12;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list2);
                        i3 |= 16;
                        num17 = num17;
                        b9 = b6;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case 5:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        b6 = b12;
                        num17 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num17);
                        i3 |= 32;
                        b9 = b6;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case 6:
                        couponModel2 = couponModel4;
                        b5 = b8;
                        b9 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ByteSerializer.INSTANCE, b12);
                        i3 |= 64;
                        b8 = b5;
                        couponModel4 = couponModel2;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 128;
                        couponModel4 = couponModel4;
                        b9 = b12;
                        break;
                    case 8:
                        bool3 = bool4;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 256;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        bool3 = bool4;
                        b10 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ByteSerializer.INSTANCE, b10);
                        i3 |= 512;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 10:
                        bool3 = bool4;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num12);
                        i3 |= 1024;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        bool3 = bool4;
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str7);
                        i3 |= 2048;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 12:
                        bool3 = bool4;
                        couponModel4 = (ActivityInfoFloor.ActivityInfoVO.CouponModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer.INSTANCE, couponModel4);
                        i3 |= 4096;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 13:
                        bool3 = bool4;
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, num11);
                        i3 |= 8192;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        bool3 = bool4;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str8);
                        i3 |= 16384;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 15:
                        bool3 = bool4;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str6);
                        i2 = 32768;
                        i3 |= i2;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 16:
                        bool3 = bool4;
                        num13 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, num13);
                        i2 = 65536;
                        i3 |= i2;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 17:
                        bool3 = bool4;
                        b8 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, ByteSerializer.INSTANCE, b8);
                        i2 = 131072;
                        i3 |= i2;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    case 18:
                        bool3 = bool4;
                        bindInfo2 = (ActivityInfoFloor.ActivityInfoVO.BindInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, ActivityInfoFloor$ActivityInfoVO$BindInfo$$serializer.INSTANCE, bindInfo2);
                        i2 = 262144;
                        i3 |= i2;
                        b9 = b12;
                        bool4 = bool3;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bool = bool4;
            num = num12;
            str = str7;
            b = b10;
            bool2 = bool5;
            num2 = num15;
            b2 = b11;
            num3 = num11;
            list = list2;
            num4 = num17;
            b3 = b9;
            b4 = b8;
            couponModel = couponModel4;
            bindInfo = bindInfo2;
            num5 = num13;
            num6 = num16;
            str2 = str6;
            str3 = str8;
            i = i3;
            num7 = num14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityInfoFloor.ActivityInfoVO(i, num7, num2, b2, num6, list, num4, b3, bool, bool2, b, num, str, couponModel, num3, str3, str2, num5, b4, bindInfo, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActivityInfoFloor.ActivityInfoVO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityInfoFloor.ActivityInfoVO.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}