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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$serializer implements GeneratedSerializer<IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel> {
    public static final int $stable;
    public static final IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$serializer INSTANCE = new IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("itemsLabel", true);
        pluginGeneratedSerialDescriptor.addElement("itemsTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("marketingLabel", true);
        pluginGeneratedSerialDescriptor.addElement("marketingTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("recommendLabel", true);
        pluginGeneratedSerialDescriptor.addElement("recommendTagNames", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$ItemsLabel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue())};
    }

    public final IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        String str;
        List list2;
        String str2;
        List list3;
        String str3;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel.$childSerializers;
        int i2 = 4;
        int i3 = 2;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            i = 63;
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
        } else {
            boolean z = true;
            int i4 = 0;
            List list4 = null;
            List list5 = null;
            String str5 = null;
            List list6 = null;
            String str6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 4;
                        i3 = 2;
                        break;
                    case 0:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i4 |= 1;
                        i2 = 4;
                        i3 = 2;
                        break;
                    case 1:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list5);
                        i4 |= 2;
                        i2 = 4;
                        break;
                    case 2:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str5);
                        i4 |= 4;
                        break;
                    case 3:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list6);
                        i4 |= 8;
                        break;
                    case 4:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str6);
                        i4 |= 16;
                        break;
                    case 5:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list4);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list4;
            str = str6;
            list2 = list6;
            str2 = str5;
            list3 = list5;
            str3 = str4;
            i = i4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel(i, str3, list3, str2, list2, str, list, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.ItemsLabel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}