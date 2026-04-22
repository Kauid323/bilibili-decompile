package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
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

/* compiled from: CrowdfundingStairsFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CrowdfundingStairsFloor$$serializer implements GeneratedSerializer<CrowdfundingStairsFloor> {
    public static final int $stable;
    public static final CrowdfundingStairsFloor$$serializer INSTANCE = new CrowdfundingStairsFloor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor", INSTANCE, 16);
        pluginGeneratedSerialDescriptor.addElement("floorKey", true);
        pluginGeneratedSerialDescriptor.addElement("floorIcon", true);
        pluginGeneratedSerialDescriptor.addElement("bgImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("achieveAmount", true);
        pluginGeneratedSerialDescriptor.addElement("achieveAmountPrefix", true);
        pluginGeneratedSerialDescriptor.addElement("achieveAmountStr", true);
        pluginGeneratedSerialDescriptor.addElement("crowdFundingActivityInfoVO", true);
        pluginGeneratedSerialDescriptor.addElement("crowdFundingSuperposition", true);
        pluginGeneratedSerialDescriptor.addElement("levelList", true);
        pluginGeneratedSerialDescriptor.addElement("outShowLevelList", true);
        pluginGeneratedSerialDescriptor.addElement("percentage", true);
        pluginGeneratedSerialDescriptor.addElement("showMore", true);
        pluginGeneratedSerialDescriptor.addElement("statusIcon", true);
        pluginGeneratedSerialDescriptor.addElement("targetAmount", true);
        pluginGeneratedSerialDescriptor.addElement("targetAmountDesc", true);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CrowdfundingStairsFloor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CrowdfundingStairsFloor.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CrowdfundingStairsFloor$ActivityInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final CrowdfundingStairsFloor deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        Boolean bool;
        Integer num;
        int i;
        List list;
        List list2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Byte b;
        String str10;
        CrowdfundingStairsFloor.ActivityInfo activityInfo;
        String str11;
        String str12;
        Lazy[] lazyArr2;
        String str13;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CrowdfundingStairsFloor.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            Boolean bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BooleanSerializer.INSTANCE, (Object) null);
            String str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), (Object) null);
            i = 65535;
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, ByteSerializer.INSTANCE, (Object) null);
            str8 = str17;
            str = str16;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            activityInfo = (CrowdfundingStairsFloor.ActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, CrowdfundingStairsFloor$ActivityInfo$$serializer.INSTANCE, (Object) null);
            str4 = str14;
            str5 = str15;
            bool = bool2;
        } else {
            boolean z = true;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            Boolean bool3 = null;
            Integer num2 = null;
            String str21 = null;
            List list3 = null;
            List list4 = null;
            Byte b2 = null;
            String str22 = null;
            CrowdfundingStairsFloor.ActivityInfo activityInfo2 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            int i2 = 0;
            String str27 = null;
            while (z) {
                String str28 = str20;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str12 = str18;
                        lazyArr2 = lazyArr;
                        str13 = str28;
                        z = false;
                        str20 = str13;
                        lazyArr = lazyArr2;
                        str18 = str12;
                        break;
                    case 0:
                        str12 = str18;
                        lazyArr2 = lazyArr;
                        str13 = str28;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str23);
                        i2 |= 1;
                        str24 = str24;
                        str20 = str13;
                        lazyArr = lazyArr2;
                        str18 = str12;
                        break;
                    case 1:
                        str12 = str18;
                        lazyArr2 = lazyArr;
                        str13 = str28;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str24);
                        i2 |= 2;
                        str25 = str25;
                        str20 = str13;
                        lazyArr = lazyArr2;
                        str18 = str12;
                        break;
                    case 2:
                        str12 = str18;
                        lazyArr2 = lazyArr;
                        str13 = str28;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str25);
                        i2 |= 4;
                        str26 = str26;
                        str20 = str13;
                        lazyArr = lazyArr2;
                        str18 = str12;
                        break;
                    case 3:
                        str12 = str18;
                        lazyArr2 = lazyArr;
                        str13 = str28;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str26);
                        i2 |= 8;
                        str20 = str13;
                        lazyArr = lazyArr2;
                        str18 = str12;
                        break;
                    case 4:
                        str12 = str18;
                        lazyArr2 = lazyArr;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str28);
                        i2 |= 16;
                        lazyArr = lazyArr2;
                        str18 = str12;
                        break;
                    case 5:
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str22);
                        i2 |= 32;
                        str18 = str18;
                        str20 = str28;
                        break;
                    case 6:
                        str11 = str22;
                        activityInfo2 = (CrowdfundingStairsFloor.ActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, CrowdfundingStairsFloor$ActivityInfo$$serializer.INSTANCE, activityInfo2);
                        i2 |= 64;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str11 = str22;
                        b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, ByteSerializer.INSTANCE, b2);
                        i2 |= 128;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case 8:
                        str11 = str22;
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), list4);
                        i2 |= 256;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str11 = str22;
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list3);
                        i2 |= 512;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case 10:
                        str11 = str22;
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num2);
                        i2 |= 1024;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str11 = str22;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 2048;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case 12:
                        str11 = str22;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str18);
                        i2 |= 4096;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case 13:
                        str11 = str22;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str19);
                        i2 |= 8192;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str11 = str22;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str27);
                        i2 |= 16384;
                        str20 = str28;
                        str22 = str11;
                        break;
                    case 15:
                        str11 = str22;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str21);
                        i2 |= 32768;
                        str20 = str28;
                        str22 = str11;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str19;
            bool = bool3;
            num = num2;
            i = i2;
            list = list3;
            list2 = list4;
            str2 = str25;
            str3 = str26;
            str4 = str20;
            str5 = str18;
            str6 = str21;
            str7 = str23;
            str8 = str27;
            str9 = str24;
            CrowdfundingStairsFloor.ActivityInfo activityInfo3 = activityInfo2;
            b = b2;
            str10 = str22;
            activityInfo = activityInfo3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CrowdfundingStairsFloor(i, str7, str9, str2, str3, str4, str10, activityInfo, b, list2, list, num, bool, str5, str, str8, str6, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CrowdfundingStairsFloor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CrowdfundingStairsFloor.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}