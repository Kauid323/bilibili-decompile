package kntr.app.mall.product.details.page.api;

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

/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$serializer implements GeneratedSerializer<IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel> {
    public static final int $stable;
    public static final IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$serializer INSTANCE = new IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("bizTagList", true);
        pluginGeneratedSerialDescriptor.addElement("cateTagList", true);
        pluginGeneratedSerialDescriptor.addElement("finishOrderCnt", true);
        pluginGeneratedSerialDescriptor.addElement("finishOrderCount", true);
        pluginGeneratedSerialDescriptor.addElement("saleNum", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$TagsModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        String str2;
        List list;
        Integer num;
        int i;
        List list2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel.$childSerializers;
        int i2 = 3;
        List list3 = null;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, (Object) null);
            i = 31;
        } else {
            boolean z = true;
            int i3 = 0;
            List list4 = null;
            Integer num2 = null;
            String str3 = null;
            String str4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 3;
                    case 0:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list3);
                        i3 |= 1;
                        i2 = 3;
                    case 1:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list4);
                        i3 |= 2;
                    case 2:
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num2);
                        i3 |= 4;
                    case 3:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str3);
                        i3 |= 8;
                    case 4:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str4);
                        i3 |= 16;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str3;
            str2 = str4;
            list = list4;
            num = num2;
            i = i3;
            list2 = list3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel(i, list2, list, num, str, str2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.TagsModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}