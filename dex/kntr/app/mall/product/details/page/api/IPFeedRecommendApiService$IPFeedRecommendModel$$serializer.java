package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.IPFeedRecommendApiService;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/IPFeedRecommendApiService.IPFeedRecommendModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IPFeedRecommendApiService$IPFeedRecommendModel$$serializer implements GeneratedSerializer<IPFeedRecommendApiService.IPFeedRecommendModel> {
    public static final int $stable;
    public static final IPFeedRecommendApiService$IPFeedRecommendModel$$serializer INSTANCE = new IPFeedRecommendApiService$IPFeedRecommendModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.IPFeedRecommendModel", INSTANCE, 11);
        pluginGeneratedSerialDescriptor.addElement("blindBoxWords", true);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        pluginGeneratedSerialDescriptor.addElement("fixHotWords", true);
        pluginGeneratedSerialDescriptor.addElement("guideIndexUrl", true);
        pluginGeneratedSerialDescriptor.addElement("guideSearch", true);
        pluginGeneratedSerialDescriptor.addElement("ipFeedSortFilters", true);
        pluginGeneratedSerialDescriptor.addElement("numResults", true);
        pluginGeneratedSerialDescriptor.addElement("querySearch", true);
        pluginGeneratedSerialDescriptor.addElement("searchFilter", true);
        pluginGeneratedSerialDescriptor.addElement("seid", true);
        pluginGeneratedSerialDescriptor.addElement("selectPrices", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private IPFeedRecommendApiService$IPFeedRecommendModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IPFeedRecommendApiService.IPFeedRecommendModel.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[10].getValue())};
    }

    public final IPFeedRecommendApiService.IPFeedRecommendModel deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        List list2;
        Integer num;
        int i;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        JsonElement jsonElement;
        String str;
        String str2;
        List list8;
        List list9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IPFeedRecommendApiService.IPFeedRecommendModel.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            List list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            list7 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), (Object) null);
            i = 2047;
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), (Object) null);
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, JsonElementSerializer.INSTANCE, (Object) null);
            list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            list4 = list10;
        } else {
            list = null;
            List list11 = null;
            List list12 = null;
            JsonElement jsonElement2 = null;
            list2 = null;
            num = null;
            String str3 = null;
            List list13 = null;
            String str4 = null;
            boolean z = true;
            List list14 = null;
            int i2 = 0;
            List list15 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        list11 = list11;
                        continue;
                    case 0:
                        list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list);
                        i2 |= 1;
                        list11 = list11;
                        continue;
                    case 1:
                        list8 = list;
                        list9 = list11;
                        list15 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list15);
                        i2 |= 2;
                        list11 = list9;
                        break;
                    case 2:
                        list8 = list;
                        list9 = list11;
                        list14 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list14);
                        i2 |= 4;
                        list11 = list9;
                        break;
                    case 3:
                        list8 = list;
                        list9 = list11;
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str4);
                        i2 |= 8;
                        list11 = list9;
                        break;
                    case 4:
                        list8 = list;
                        list9 = list11;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list2);
                        i2 |= 16;
                        list11 = list9;
                        break;
                    case 5:
                        list8 = list;
                        list9 = list11;
                        list13 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list13);
                        i2 |= 32;
                        list11 = list9;
                        break;
                    case 6:
                        list8 = list;
                        list9 = list11;
                        num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num);
                        i2 |= 64;
                        list11 = list9;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        list8 = list;
                        list9 = list11;
                        jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, JsonElementSerializer.INSTANCE, jsonElement2);
                        i2 |= 128;
                        list11 = list9;
                        break;
                    case 8:
                        list8 = list;
                        list9 = list11;
                        list12 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), list12);
                        i2 |= 256;
                        list11 = list9;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        list8 = list;
                        list9 = list11;
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str3);
                        i2 |= 512;
                        list11 = list9;
                        break;
                    case 10:
                        list8 = list;
                        list11 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), list11);
                        i2 |= 1024;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                list = list8;
            }
            List list16 = list11;
            i = i2;
            list3 = list13;
            list4 = list15;
            list5 = list12;
            list6 = list14;
            list7 = list16;
            String str5 = str3;
            jsonElement = jsonElement2;
            str = str4;
            str2 = str5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IPFeedRecommendApiService.IPFeedRecommendModel(i, list, list4, list6, str, list2, list3, num, jsonElement, list5, str2, list7, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IPFeedRecommendApiService.IPFeedRecommendModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IPFeedRecommendApiService.IPFeedRecommendModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}