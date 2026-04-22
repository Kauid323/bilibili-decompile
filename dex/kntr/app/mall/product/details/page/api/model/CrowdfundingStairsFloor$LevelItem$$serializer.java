package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CrowdfundingStairsFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor.LevelItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CrowdfundingStairsFloor$LevelItem$$serializer implements GeneratedSerializer<CrowdfundingStairsFloor.LevelItem> {
    public static final int $stable;
    public static final CrowdfundingStairsFloor$LevelItem$$serializer INSTANCE = new CrowdfundingStairsFloor$LevelItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor.LevelItem", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("activityTitle", true);
        pluginGeneratedSerialDescriptor.addElement("activityUrl", true);
        pluginGeneratedSerialDescriptor.addElement("crowdFundingLevelGiftList", true);
        pluginGeneratedSerialDescriptor.addElement("rewardGap", true);
        pluginGeneratedSerialDescriptor.addElement("rewardGapDesc", true);
        pluginGeneratedSerialDescriptor.addElement("rewardStatus", true);
        pluginGeneratedSerialDescriptor.addElement("rewardStatusIcon", true);
        pluginGeneratedSerialDescriptor.addElement("skuId2GiftMap", true);
        pluginGeneratedSerialDescriptor.addElement("targetAmount", true);
        pluginGeneratedSerialDescriptor.addElement("targetAmountDesc", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CrowdfundingStairsFloor$LevelItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CrowdfundingStairsFloor.LevelItem.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(TextColorModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(TextColorModel$$serializer.INSTANCE)};
    }

    public final CrowdfundingStairsFloor.LevelItem deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Long l;
        TextColorModel textColorModel;
        List list;
        Integer num;
        Integer num2;
        TextColorModel textColorModel2;
        String str;
        String str2;
        String str3;
        CrowdfundingStairsFloor.LevelItem.SkuIdToGiftMap skuIdToGiftMap;
        int i;
        Lazy[] lazyArr2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CrowdfundingStairsFloor.LevelItem.$childSerializers;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            textColorModel = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, TextColorModel$$serializer.INSTANCE, (Object) null);
            skuIdToGiftMap = (CrowdfundingStairsFloor.LevelItem.SkuIdToGiftMap) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$$serializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, (Object) null);
            i = 1023;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            textColorModel2 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, TextColorModel$$serializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i2 = 0;
            Long l2 = null;
            CrowdfundingStairsFloor.LevelItem.SkuIdToGiftMap skuIdToGiftMap2 = null;
            String str5 = null;
            TextColorModel textColorModel3 = null;
            TextColorModel textColorModel4 = null;
            Integer num3 = null;
            Integer num4 = null;
            List list2 = null;
            String str6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        lazyArr2 = lazyArr;
                        z = false;
                        lazyArr = lazyArr2;
                        break;
                    case 0:
                        lazyArr2 = lazyArr;
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i2 |= 1;
                        lazyArr = lazyArr2;
                        break;
                    case 1:
                        lazyArr2 = lazyArr;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i2 |= 2;
                        lazyArr = lazyArr2;
                        break;
                    case 2:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                        i2 |= 4;
                        break;
                    case 3:
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num4);
                        i2 |= 8;
                        break;
                    case 4:
                        textColorModel3 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, TextColorModel$$serializer.INSTANCE, textColorModel3);
                        i2 |= 16;
                        break;
                    case 5:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num3);
                        i2 |= 32;
                        break;
                    case 6:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str5);
                        i2 |= 64;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        skuIdToGiftMap2 = (CrowdfundingStairsFloor.LevelItem.SkuIdToGiftMap) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$$serializer.INSTANCE, skuIdToGiftMap2);
                        i2 |= 128;
                        break;
                    case 8:
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, l2);
                        i2 |= 256;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        textColorModel4 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, TextColorModel$$serializer.INSTANCE, textColorModel4);
                        i2 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            l = l2;
            textColorModel = textColorModel4;
            list = list2;
            num = num3;
            num2 = num4;
            textColorModel2 = textColorModel3;
            str = str6;
            str2 = str5;
            str3 = str4;
            skuIdToGiftMap = skuIdToGiftMap2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CrowdfundingStairsFloor.LevelItem(i, str3, str, list, num2, textColorModel2, num, str2, skuIdToGiftMap, l, textColorModel, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CrowdfundingStairsFloor.LevelItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CrowdfundingStairsFloor.LevelItem.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}