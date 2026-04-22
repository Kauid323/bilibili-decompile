package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.IPFeedRecommendApiService;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$$serializer implements GeneratedSerializer<IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel> {
    public static final int $stable;
    public static final IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$$serializer INSTANCE = new IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel", INSTANCE, 15);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("itemsType", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("overseasPreShippingTime", true);
        pluginGeneratedSerialDescriptor.addElement("presaleDeliveryTimeStr", true);
        pluginGeneratedSerialDescriptor.addElement("saleStatus", true);
        pluginGeneratedSerialDescriptor.addElement("skuSpec", true);
        pluginGeneratedSerialDescriptor.addElement("sliceNum", true);
        pluginGeneratedSerialDescriptor.addElement("subSkuId", true);
        pluginGeneratedSerialDescriptor.addElement("subSkuItemsId", true);
        pluginGeneratedSerialDescriptor.addElement("subSkuPrice", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("whiteListSku", true);
        pluginGeneratedSerialDescriptor.addElement("wishedSku", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SubSkuModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    public final IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel deserialize(Decoder decoder) {
        String str;
        Long l;
        Long l2;
        Integer num;
        String str2;
        Byte b;
        String str3;
        String str4;
        String str5;
        Integer num2;
        Integer num3;
        String str6;
        String str7;
        int i;
        Boolean bool;
        Boolean bool2;
        String str8;
        Boolean bool3;
        Boolean bool4;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, (Object) null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, BooleanSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            bool2 = bool5;
            str5 = str10;
            num2 = num4;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ByteSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i = 32767;
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            Boolean bool6 = null;
            Boolean bool7 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            Integer num5 = null;
            Long l3 = null;
            Long l4 = null;
            Integer num6 = null;
            Integer num7 = null;
            String str14 = null;
            str = null;
            String str15 = null;
            Byte b2 = null;
            int i2 = 0;
            String str16 = null;
            while (z) {
                String str17 = str16;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        bool3 = bool6;
                        bool4 = bool7;
                        str9 = str17;
                        z = false;
                        str16 = str9;
                        bool7 = bool4;
                        bool6 = bool3;
                        break;
                    case 0:
                        bool3 = bool6;
                        bool4 = bool7;
                        str9 = str17;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str15);
                        i2 |= 1;
                        b2 = b2;
                        str16 = str9;
                        bool7 = bool4;
                        bool6 = bool3;
                        break;
                    case 1:
                        bool3 = bool6;
                        bool4 = bool7;
                        str9 = str17;
                        b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ByteSerializer.INSTANCE, b2);
                        i2 |= 2;
                        str16 = str9;
                        bool7 = bool4;
                        bool6 = bool3;
                        break;
                    case 2:
                        bool3 = bool6;
                        bool4 = bool7;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str17);
                        i2 |= 4;
                        bool7 = bool4;
                        bool6 = bool3;
                        break;
                    case 3:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str12);
                        i2 |= 8;
                        bool6 = bool6;
                        str16 = str17;
                        break;
                    case 4:
                        str8 = str12;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str11);
                        i2 |= 16;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case 5:
                        str8 = str12;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num7);
                        i2 |= 32;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case 6:
                        str8 = str12;
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str);
                        i2 |= 64;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str8 = str12;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, num6);
                        i2 |= 128;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case 8:
                        str8 = str12;
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, l4);
                        i2 |= 256;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str8 = str12;
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, l3);
                        i2 |= 512;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case 10:
                        str8 = str12;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str14);
                        i2 |= 1024;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str8 = str12;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num5);
                        i2 |= 2048;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case 12:
                        str8 = str12;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str13);
                        i2 |= 4096;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case 13:
                        str8 = str12;
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, bool6);
                        i2 |= 8192;
                        str16 = str17;
                        str12 = str8;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str8 = str12;
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, BooleanSerializer.INSTANCE, bool7);
                        i2 |= 16384;
                        str16 = str17;
                        str12 = str8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            l = l3;
            l2 = l4;
            num = num6;
            str2 = str14;
            b = b2;
            str3 = str16;
            str4 = str12;
            str5 = str13;
            num2 = num5;
            num3 = num7;
            str6 = str15;
            str7 = str11;
            i = i2;
            bool = bool7;
            bool2 = bool6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel(i, str6, b, str3, str4, str7, num3, str, num, l2, l, str2, num2, str5, bool2, bool, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SubSkuModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}