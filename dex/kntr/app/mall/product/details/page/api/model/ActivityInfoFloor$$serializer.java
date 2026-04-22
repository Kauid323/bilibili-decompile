package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActivityInfoFloor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActivityInfoFloor$$serializer implements GeneratedSerializer<ActivityInfoFloor> {
    public static final int $stable;
    public static final ActivityInfoFloor$$serializer INSTANCE = new ActivityInfoFloor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActivityInfoFloor", INSTANCE, 15);
        pluginGeneratedSerialDescriptor.addElement("floorKey", true);
        pluginGeneratedSerialDescriptor.addElement("floorIcon", true);
        pluginGeneratedSerialDescriptor.addElement("bgImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("activityExtInfo", true);
        pluginGeneratedSerialDescriptor.addElement("activityInfoList", true);
        pluginGeneratedSerialDescriptor.addElement("activityInfoVO", true);
        pluginGeneratedSerialDescriptor.addElement("activityPanelVOs", true);
        pluginGeneratedSerialDescriptor.addElement("atmosVOList", true);
        pluginGeneratedSerialDescriptor.addElement("detailNetPriceInfo", true);
        pluginGeneratedSerialDescriptor.addElement("fansPriceActivityVO", true);
        pluginGeneratedSerialDescriptor.addElement("giftActivityVO", true);
        pluginGeneratedSerialDescriptor.addElement("hasNewCoupon", true);
        pluginGeneratedSerialDescriptor.addElement("instantDiscountActivity", true);
        pluginGeneratedSerialDescriptor.addElement("luckyBuySubsideActivityInfoVO", true);
        pluginGeneratedSerialDescriptor.addElement("progressActivityInfoVO", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActivityInfoFloor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ActivityInfoFloor.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityExtInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityInfoVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable(CouponInfoFloor$DetailNetPriceInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$FansPriceActivityVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$GiftActivityVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$InstantDiscountActivityInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[14].getValue())};
    }

    public final ActivityInfoFloor deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        int i;
        Boolean bool;
        ActivityInfoFloor.GiftActivityVO giftActivityVO;
        CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo;
        ActivityInfoFloor.FansPriceActivityVO fansPriceActivityVO;
        List list2;
        String str;
        List list3;
        ActivityInfoFloor.ActivityExtInfo activityExtInfo;
        List list4;
        ActivityInfoFloor.ActivityInfoVO activityInfoVO;
        String str2;
        String str3;
        ActivityInfoFloor.InstantDiscountActivityInfo instantDiscountActivityInfo;
        ActivityInfoFloor.LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO;
        List list5;
        List list6;
        ActivityInfoFloor.InstantDiscountActivityInfo instantDiscountActivityInfo2;
        Lazy[] lazyArr2;
        List list7;
        ActivityInfoFloor.ActivityExtInfo activityExtInfo2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ActivityInfoFloor.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            ActivityInfoFloor.GiftActivityVO giftActivityVO2 = (ActivityInfoFloor.GiftActivityVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ActivityInfoFloor$GiftActivityVO$$serializer.INSTANCE, (Object) null);
            Boolean bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BooleanSerializer.INSTANCE, (Object) null);
            ActivityInfoFloor.InstantDiscountActivityInfo instantDiscountActivityInfo3 = (ActivityInfoFloor.InstantDiscountActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ActivityInfoFloor$InstantDiscountActivityInfo$$serializer.INSTANCE, (Object) null);
            i = 32767;
            luckyBuySubsideActivityInfoVO = (ActivityInfoFloor.LuckyBuySubsideActivityInfoVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), (Object) null);
            detailNetPriceInfo = (CouponInfoFloor.DetailNetPriceInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, CouponInfoFloor$DetailNetPriceInfo$$serializer.INSTANCE, (Object) null);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), (Object) null);
            instantDiscountActivityInfo = instantDiscountActivityInfo3;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            fansPriceActivityVO = (ActivityInfoFloor.FansPriceActivityVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ActivityInfoFloor$FansPriceActivityVO$$serializer.INSTANCE, (Object) null);
            activityInfoVO = (ActivityInfoFloor.ActivityInfoVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ActivityInfoFloor$ActivityInfoVO$$serializer.INSTANCE, (Object) null);
            activityExtInfo = (ActivityInfoFloor.ActivityExtInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ActivityInfoFloor$ActivityExtInfo$$serializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            bool = bool2;
            giftActivityVO = giftActivityVO2;
        } else {
            boolean z = true;
            ActivityInfoFloor.InstantDiscountActivityInfo instantDiscountActivityInfo4 = null;
            ActivityInfoFloor.LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO2 = null;
            List list8 = null;
            ActivityInfoFloor.ActivityExtInfo activityExtInfo3 = null;
            Boolean bool3 = null;
            List list9 = null;
            ActivityInfoFloor.ActivityInfoVO activityInfoVO2 = null;
            ActivityInfoFloor.GiftActivityVO giftActivityVO3 = null;
            list = null;
            CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo2 = null;
            ActivityInfoFloor.FansPriceActivityVO fansPriceActivityVO2 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            i = 0;
            List list10 = null;
            while (z) {
                ActivityInfoFloor.ActivityExtInfo activityExtInfo4 = activityExtInfo3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        instantDiscountActivityInfo2 = instantDiscountActivityInfo4;
                        lazyArr2 = lazyArr;
                        list7 = list10;
                        activityExtInfo2 = activityExtInfo4;
                        z = false;
                        activityExtInfo3 = activityExtInfo2;
                        list10 = list7;
                        lazyArr = lazyArr2;
                        instantDiscountActivityInfo4 = instantDiscountActivityInfo2;
                        break;
                    case 0:
                        instantDiscountActivityInfo2 = instantDiscountActivityInfo4;
                        lazyArr2 = lazyArr;
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i |= 1;
                        activityExtInfo3 = activityExtInfo4;
                        list10 = list10;
                        str5 = str5;
                        lazyArr = lazyArr2;
                        instantDiscountActivityInfo4 = instantDiscountActivityInfo2;
                        break;
                    case 1:
                        instantDiscountActivityInfo2 = instantDiscountActivityInfo4;
                        lazyArr2 = lazyArr;
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
                        i |= 2;
                        activityExtInfo3 = activityExtInfo4;
                        list10 = list10;
                        str6 = str6;
                        lazyArr = lazyArr2;
                        instantDiscountActivityInfo4 = instantDiscountActivityInfo2;
                        break;
                    case 2:
                        instantDiscountActivityInfo2 = instantDiscountActivityInfo4;
                        list7 = list10;
                        activityExtInfo2 = activityExtInfo4;
                        lazyArr2 = lazyArr;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str6);
                        i |= 4;
                        activityExtInfo3 = activityExtInfo2;
                        list10 = list7;
                        lazyArr = lazyArr2;
                        instantDiscountActivityInfo4 = instantDiscountActivityInfo2;
                        break;
                    case 3:
                        instantDiscountActivityInfo2 = instantDiscountActivityInfo4;
                        activityExtInfo3 = (ActivityInfoFloor.ActivityExtInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ActivityInfoFloor$ActivityExtInfo$$serializer.INSTANCE, activityExtInfo4);
                        i |= 8;
                        list10 = list10;
                        instantDiscountActivityInfo4 = instantDiscountActivityInfo2;
                        break;
                    case 4:
                        list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list);
                        i |= 16;
                        list10 = list10;
                        activityExtInfo3 = activityExtInfo4;
                        break;
                    case 5:
                        list5 = list10;
                        list6 = list;
                        activityInfoVO2 = (ActivityInfoFloor.ActivityInfoVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ActivityInfoFloor$ActivityInfoVO$$serializer.INSTANCE, activityInfoVO2);
                        i |= 32;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case 6:
                        list5 = list10;
                        list6 = list;
                        list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list8);
                        i |= 64;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        list5 = list10;
                        list6 = list;
                        list9 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list9);
                        i |= 128;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case 8:
                        list5 = list10;
                        list6 = list;
                        detailNetPriceInfo2 = (CouponInfoFloor.DetailNetPriceInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, CouponInfoFloor$DetailNetPriceInfo$$serializer.INSTANCE, detailNetPriceInfo2);
                        i |= 256;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        list5 = list10;
                        list6 = list;
                        fansPriceActivityVO2 = (ActivityInfoFloor.FansPriceActivityVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ActivityInfoFloor$FansPriceActivityVO$$serializer.INSTANCE, fansPriceActivityVO2);
                        i |= 512;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case 10:
                        list5 = list10;
                        list6 = list;
                        giftActivityVO3 = (ActivityInfoFloor.GiftActivityVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ActivityInfoFloor$GiftActivityVO$$serializer.INSTANCE, giftActivityVO3);
                        i |= 1024;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        list5 = list10;
                        list6 = list;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BooleanSerializer.INSTANCE, bool3);
                        i |= 2048;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case 12:
                        list5 = list10;
                        list6 = list;
                        instantDiscountActivityInfo4 = (ActivityInfoFloor.InstantDiscountActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ActivityInfoFloor$InstantDiscountActivityInfo$$serializer.INSTANCE, instantDiscountActivityInfo4);
                        i |= 4096;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case 13:
                        list6 = list;
                        list5 = list10;
                        luckyBuySubsideActivityInfoVO2 = (ActivityInfoFloor.LuckyBuySubsideActivityInfoVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer.INSTANCE, luckyBuySubsideActivityInfoVO2);
                        i |= 8192;
                        list10 = list5;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        list6 = list;
                        list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), list10);
                        i |= 16384;
                        activityExtInfo3 = activityExtInfo4;
                        list = list6;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bool = bool3;
            giftActivityVO = giftActivityVO3;
            detailNetPriceInfo = detailNetPriceInfo2;
            fansPriceActivityVO = fansPriceActivityVO2;
            list2 = list10;
            str = str4;
            list3 = list8;
            activityExtInfo = activityExtInfo3;
            list4 = list9;
            activityInfoVO = activityInfoVO2;
            str2 = str5;
            str3 = str6;
            instantDiscountActivityInfo = instantDiscountActivityInfo4;
            luckyBuySubsideActivityInfoVO = luckyBuySubsideActivityInfoVO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityInfoFloor(i, str, str2, str3, activityExtInfo, list, activityInfoVO, list3, list4, detailNetPriceInfo, fansPriceActivityVO, giftActivityVO, bool, instantDiscountActivityInfo, luckyBuySubsideActivityInfoVO, list2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActivityInfoFloor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityInfoFloor.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}