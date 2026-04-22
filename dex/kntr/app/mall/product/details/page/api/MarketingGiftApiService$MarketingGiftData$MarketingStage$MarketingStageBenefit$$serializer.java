package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.MarketingGiftApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MarketingGiftApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$$serializer implements GeneratedSerializer<MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit> {
    public static final int $stable;
    public static final MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$$serializer INSTANCE = new MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement("benefitStockStatus", true);
        pluginGeneratedSerialDescriptor.addElement("itemsDetailUrl", true);
        pluginGeneratedSerialDescriptor.addElement("itemsId", true);
        pluginGeneratedSerialDescriptor.addElement("quantity", true);
        pluginGeneratedSerialDescriptor.addElement("showImg", true);
        pluginGeneratedSerialDescriptor.addElement("showName", true);
        pluginGeneratedSerialDescriptor.addElement("skuId", true);
        pluginGeneratedSerialDescriptor.addElement("subShowName", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private MarketingGiftApiService$MarketingGiftData$MarketingStage$MarketingStageBenefit$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit deserialize(Decoder decoder) {
        String str;
        Long l;
        String str2;
        int i;
        String str3;
        Integer num;
        String str4;
        Long l2;
        Integer num2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        Integer num3 = null;
        if (beginStructure.decodeSequentially()) {
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            i = 255;
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i3 = 0;
            String str5 = null;
            Long l3 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            Long l4 = null;
            Integer num4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num3);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str8);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l4);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num4);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str7);
                        i3 |= 16;
                        i2 = 7;
                        continue;
                    case 5:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str6);
                        i3 |= 32;
                        break;
                    case 6:
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l3);
                        i3 |= 64;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str5);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str5;
            l = l3;
            str2 = str6;
            i = i3;
            Integer num5 = num4;
            str3 = str7;
            num = num3;
            str4 = str8;
            l2 = l4;
            num2 = num5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit(i, num, str4, l2, num2, str3, str2, l, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}