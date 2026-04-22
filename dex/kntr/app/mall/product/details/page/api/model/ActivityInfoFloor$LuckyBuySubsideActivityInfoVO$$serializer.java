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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActivityInfoFloor.LuckyBuySubsideActivityInfoVO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer implements GeneratedSerializer<ActivityInfoFloor.LuckyBuySubsideActivityInfoVO> {
    public static final int $stable;
    public static final ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer INSTANCE = new ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActivityInfoFloor.LuckyBuySubsideActivityInfoVO", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("activityId", true);
        pluginGeneratedSerialDescriptor.addElement("activitySkus", true);
        pluginGeneratedSerialDescriptor.addElement("countdownTime", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("marketingId", true);
        pluginGeneratedSerialDescriptor.addElement("publishTime", true);
        pluginGeneratedSerialDescriptor.addElement("serverTime", true);
        pluginGeneratedSerialDescriptor.addElement("showLabel", true);
        pluginGeneratedSerialDescriptor.addElement("showSummary", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("subProcess", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("warmUpTime", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ActivityInfoFloor.LuckyBuySubsideActivityInfoVO.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final ActivityInfoFloor.LuckyBuySubsideActivityInfoVO deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Integer num;
        Byte b;
        Integer num2;
        String str;
        Long l;
        List list;
        Integer num3;
        Integer num4;
        int i;
        String str2;
        String str3;
        Integer num5;
        String str4;
        Integer num6;
        Integer num7;
        Lazy[] lazyArr2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ActivityInfoFloor.LuckyBuySubsideActivityInfoVO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            Byte b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, ByteSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            b = b2;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            i = 8191;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            str3 = str5;
        } else {
            boolean z = true;
            Integer num8 = null;
            List list2 = null;
            Integer num9 = null;
            Byte b3 = null;
            Integer num10 = null;
            String str6 = null;
            String str7 = null;
            num = null;
            String str8 = null;
            Long l2 = null;
            String str9 = null;
            Integer num11 = null;
            int i2 = 0;
            Integer num12 = null;
            while (z) {
                List list3 = list2;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        list2 = list3;
                        num8 = num8;
                        break;
                    case 0:
                        num7 = num8;
                        lazyArr2 = lazyArr;
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num11);
                        i2 |= 1;
                        list2 = list3;
                        num8 = num7;
                        lazyArr = lazyArr2;
                        break;
                    case 1:
                        lazyArr2 = lazyArr;
                        num7 = num8;
                        i2 |= 2;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr2[1].getValue(), list3);
                        num8 = num7;
                        lazyArr = lazyArr2;
                        break;
                    case 2:
                        lazyArr2 = lazyArr;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num12);
                        i2 |= 4;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 3:
                        lazyArr2 = lazyArr;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num9);
                        i2 |= 8;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 4:
                        lazyArr2 = lazyArr;
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str9);
                        i2 |= 16;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 5:
                        lazyArr2 = lazyArr;
                        num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num);
                        i2 |= 32;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 6:
                        lazyArr2 = lazyArr;
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l2);
                        i2 |= 64;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        lazyArr2 = lazyArr;
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str7);
                        i2 |= 128;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 8:
                        lazyArr2 = lazyArr;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str6);
                        i2 |= 256;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        lazyArr2 = lazyArr;
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, num10);
                        i2 |= 512;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 10:
                        lazyArr2 = lazyArr;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str8);
                        i2 |= 1024;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        lazyArr2 = lazyArr;
                        b3 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, ByteSerializer.INSTANCE, b3);
                        i2 |= 2048;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    case 12:
                        lazyArr2 = lazyArr;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, num8);
                        i2 |= 4096;
                        list2 = list3;
                        lazyArr = lazyArr2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            b = b3;
            num2 = num10;
            str = str8;
            l = l2;
            list = list2;
            num3 = num8;
            num4 = num12;
            i = i2;
            str2 = str7;
            str3 = str9;
            num5 = num11;
            str4 = str6;
            num6 = num9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityInfoFloor.LuckyBuySubsideActivityInfoVO(i, num5, list, num4, num6, str3, num, l, str2, str4, num2, str, b, num3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActivityInfoFloor.LuckyBuySubsideActivityInfoVO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityInfoFloor.LuckyBuySubsideActivityInfoVO.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}