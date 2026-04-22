package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: CommentInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/CommentInfoApiService.CommentInfoResponse.CommentInfoData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CommentInfoApiService$CommentInfoResponse$CommentInfoData$$serializer implements GeneratedSerializer<CommentInfoApiService.CommentInfoResponse.CommentInfoData> {
    public static final int $stable;
    public static final CommentInfoApiService$CommentInfoResponse$CommentInfoData$$serializer INSTANCE = new CommentInfoApiService$CommentInfoResponse$CommentInfoData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse.CommentInfoData", INSTANCE, 23);
        pluginGeneratedSerialDescriptor.addElement("activityItemsDTO", true);
        pluginGeneratedSerialDescriptor.addElement("commonCount", true);
        pluginGeneratedSerialDescriptor.addElement("commonList", true);
        pluginGeneratedSerialDescriptor.addElement("essenceCount", true);
        pluginGeneratedSerialDescriptor.addElement("essenceIncludeSubCount", true);
        pluginGeneratedSerialDescriptor.addElement("essenceList", true);
        pluginGeneratedSerialDescriptor.addElement("hasNextPage", true);
        pluginGeneratedSerialDescriptor.addElement("hotCount", true);
        pluginGeneratedSerialDescriptor.addElement("hotIncludeSubCount", true);
        pluginGeneratedSerialDescriptor.addElement("hotList", true);
        pluginGeneratedSerialDescriptor.addElement("merchantFlag", true);
        pluginGeneratedSerialDescriptor.addElement("merchantInfo", true);
        pluginGeneratedSerialDescriptor.addElement("relatedComment", true);
        pluginGeneratedSerialDescriptor.addElement("remainTotal", true);
        pluginGeneratedSerialDescriptor.addElement("selfCount", true);
        pluginGeneratedSerialDescriptor.addElement("selfList", true);
        pluginGeneratedSerialDescriptor.addElement("serverTime", true);
        pluginGeneratedSerialDescriptor.addElement("subjectId", true);
        pluginGeneratedSerialDescriptor.addElement("subjectType", true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement("total", true);
        pluginGeneratedSerialDescriptor.addElement("totalCount", true);
        pluginGeneratedSerialDescriptor.addElement("upList", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CommentInfoApiService$CommentInfoResponse$CommentInfoData$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CommentInfoApiService.CommentInfoResponse.CommentInfoData.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[15].getValue()), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[19].getValue()), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)};
    }

    public final CommentInfoApiService.CommentInfoResponse.CommentInfoData deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel;
        List list;
        Long l;
        List list2;
        Long l2;
        Long l3;
        List list3;
        Long l4;
        Long l5;
        List list4;
        Boolean bool;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.ActivityItems activityItems;
        Long l6;
        Long l7;
        Long l8;
        Long l9;
        List list5;
        Boolean bool2;
        Long l10;
        Byte b;
        int i;
        Long l11;
        JsonElement jsonElement;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel merchantInfoModel;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel2;
        JsonElement jsonElement2;
        int i2;
        int i3;
        Lazy[] lazyArr2;
        Long l12;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel merchantInfoModel2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CommentInfoApiService.CommentInfoResponse.CommentInfoData.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Long l13 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, (Object) null);
            l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, (Object) null);
            Boolean bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, BooleanSerializer.INSTANCE, (Object) null);
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel merchantInfoModel3 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer.INSTANCE, (Object) null);
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel3 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE, (Object) null);
            Long l14 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, LongSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, LongSerializer.INSTANCE, (Object) null);
            List list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), (Object) null);
            Long l15 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, LongSerializer.INSTANCE, (Object) null);
            Long l16 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, LongSerializer.INSTANCE, (Object) null);
            Byte b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, ByteSerializer.INSTANCE, (Object) null);
            Long l17 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, LongSerializer.INSTANCE, (Object) null);
            Long l18 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, LongSerializer.INSTANCE, (Object) null);
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, JsonElementSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, (DeserializationStrategy) lazyArr[19].getValue(), (Object) null);
            l10 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, (Object) null);
            l8 = l17;
            l7 = l18;
            commentModel = commentModel3;
            l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, (Object) null);
            list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            l = l15;
            merchantInfoModel = merchantInfoModel3;
            activityItems = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.ActivityItems) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems$$serializer.INSTANCE, (Object) null);
            l9 = l16;
            bool = bool3;
            b = b2;
            list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), (Object) null);
            l11 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
            i = 8388607;
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            l6 = l13;
            list2 = list6;
            l3 = l14;
        } else {
            boolean z = true;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel4 = null;
            Long l19 = null;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel merchantInfoModel4 = null;
            JsonElement jsonElement3 = null;
            Byte b3 = null;
            List list7 = null;
            Long l20 = null;
            List list8 = null;
            Long l21 = null;
            Long l22 = null;
            Long l23 = null;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.ActivityItems activityItems2 = null;
            Long l24 = null;
            List list9 = null;
            Long l25 = null;
            Long l26 = null;
            List list10 = null;
            Boolean bool4 = null;
            Long l27 = null;
            Long l28 = null;
            List list11 = null;
            Boolean bool5 = null;
            int i4 = 0;
            Long l29 = null;
            while (z) {
                CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel merchantInfoModel5 = merchantInfoModel4;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        lazyArr2 = lazyArr;
                        l12 = l19;
                        merchantInfoModel2 = merchantInfoModel5;
                        z = false;
                        commentModel4 = commentModel4;
                        break;
                    case 0:
                        l12 = l19;
                        merchantInfoModel2 = merchantInfoModel5;
                        lazyArr2 = lazyArr;
                        activityItems2 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.ActivityItems) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CommentInfoApiService$CommentInfoResponse$CommentInfoData$ActivityItems$$serializer.INSTANCE, activityItems2);
                        i4 |= 1;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        break;
                    case 1:
                        l24 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l24);
                        i4 |= 2;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        list9 = list9;
                        continue;
                    case 2:
                        list9 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list9);
                        i4 |= 4;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        l25 = l25;
                        continue;
                    case 3:
                        l25 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, l25);
                        i4 |= 8;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        l26 = l26;
                        continue;
                    case 4:
                        l26 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l26);
                        i4 |= 16;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        list10 = list10;
                        continue;
                    case 5:
                        list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list10);
                        i4 |= 32;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        bool4 = bool4;
                        continue;
                    case 6:
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, bool4);
                        i4 |= 64;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        l27 = l27;
                        continue;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        l27 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, l27);
                        i4 |= 128;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        l28 = l28;
                        continue;
                    case 8:
                        l28 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, l28);
                        i4 |= 256;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        list11 = list11;
                        continue;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        list11 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list11);
                        i4 |= 512;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        bool5 = bool5;
                        continue;
                    case 10:
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, BooleanSerializer.INSTANCE, bool5);
                        i4 |= 1024;
                        commentModel4 = commentModel4;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = merchantInfoModel5;
                        continue;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        i4 |= 2048;
                        jsonElement3 = jsonElement3;
                        l19 = l19;
                        merchantInfoModel4 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer.INSTANCE, merchantInfoModel5);
                        commentModel4 = commentModel4;
                        continue;
                    case 12:
                        commentModel4 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$$serializer.INSTANCE, commentModel4);
                        i4 |= 4096;
                        jsonElement3 = jsonElement3;
                        merchantInfoModel4 = merchantInfoModel5;
                        continue;
                    case 13:
                        commentModel2 = commentModel4;
                        jsonElement2 = jsonElement3;
                        l19 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, LongSerializer.INSTANCE, l19);
                        i4 |= 8192;
                        jsonElement3 = jsonElement2;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        commentModel2 = commentModel4;
                        jsonElement2 = jsonElement3;
                        l29 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, LongSerializer.INSTANCE, l29);
                        i4 |= 16384;
                        jsonElement3 = jsonElement2;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 15:
                        commentModel2 = commentModel4;
                        list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), list8);
                        i2 = 32768;
                        i4 |= i2;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 16:
                        commentModel2 = commentModel4;
                        l20 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, LongSerializer.INSTANCE, l20);
                        i3 = 65536;
                        i4 |= i3;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 17:
                        commentModel2 = commentModel4;
                        l23 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, LongSerializer.INSTANCE, l23);
                        i3 = 131072;
                        i4 |= i3;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 18:
                        commentModel2 = commentModel4;
                        b3 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, ByteSerializer.INSTANCE, b3);
                        i3 = 262144;
                        i4 |= i3;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 19:
                        commentModel2 = commentModel4;
                        list7 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, (DeserializationStrategy) lazyArr[19].getValue(), list7);
                        i3 = 524288;
                        i4 |= i3;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 20:
                        commentModel2 = commentModel4;
                        l22 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, LongSerializer.INSTANCE, l22);
                        i2 = 1048576;
                        i4 |= i2;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 21:
                        commentModel2 = commentModel4;
                        l21 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, LongSerializer.INSTANCE, l21);
                        i2 = 2097152;
                        i4 |= i2;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    case 22:
                        commentModel2 = commentModel4;
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, JsonElementSerializer.INSTANCE, jsonElement3);
                        i2 = 4194304;
                        i4 |= i2;
                        merchantInfoModel4 = merchantInfoModel5;
                        commentModel4 = commentModel2;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                l19 = l12;
                merchantInfoModel4 = merchantInfoModel2;
                lazyArr = lazyArr2;
            }
            commentModel = commentModel4;
            list = list7;
            l = l20;
            list2 = list8;
            l2 = l29;
            l3 = l19;
            list3 = list9;
            l4 = l25;
            l5 = l28;
            list4 = list11;
            bool = bool5;
            activityItems = activityItems2;
            l6 = l24;
            l7 = l21;
            l8 = l22;
            l9 = l23;
            list5 = list10;
            bool2 = bool4;
            l10 = l27;
            b = b3;
            i = i4;
            l11 = l26;
            jsonElement = jsonElement3;
            merchantInfoModel = merchantInfoModel4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CommentInfoApiService.CommentInfoResponse.CommentInfoData(i, activityItems, l6, list3, l4, l11, list5, bool2, l10, l5, list4, bool, merchantInfoModel, commentModel, l3, l2, list2, l, l9, b, list, l8, l7, jsonElement, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CommentInfoApiService.CommentInfoResponse.CommentInfoData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}