package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.common.upper.trace.config.AppKey;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: CommentInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer implements GeneratedSerializer<CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel> {
    public static final int $stable;
    public static final CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer INSTANCE = new CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel", INSTANCE, 9);
        pluginGeneratedSerialDescriptor.addElement("applyCount", true);
        pluginGeneratedSerialDescriptor.addElement(RedirectImpKt.REDIRECT_KV_CONFIG, true);
        pluginGeneratedSerialDescriptor.addElement("finishCount", true);
        pluginGeneratedSerialDescriptor.addElement("merchantId", true);
        pluginGeneratedSerialDescriptor.addElement("merchantName", true);
        pluginGeneratedSerialDescriptor.addElement("merchantShopFace", true);
        pluginGeneratedSerialDescriptor.addElement("merchantShopName", true);
        pluginGeneratedSerialDescriptor.addElement("positiveRatio", true);
        pluginGeneratedSerialDescriptor.addElement(AppKey.UID, true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    public final CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel deserialize(Decoder decoder) {
        Long l;
        Integer num;
        String str;
        Integer num2;
        JsonElement jsonElement;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.Config config;
        String str2;
        int i;
        String str3;
        Integer num3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        Integer num4 = null;
        if (beginStructure.decodeSequentially()) {
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.Config config2 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.Config) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config$$serializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, (Object) null);
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, JsonElementSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            i = 511;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            config = config2;
        } else {
            boolean z = true;
            int i3 = 0;
            Long l2 = null;
            String str4 = null;
            JsonElement jsonElement2 = null;
            String str5 = null;
            String str6 = null;
            Integer num5 = null;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.Config config3 = null;
            Integer num6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num4);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        config3 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.Config) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, CommentInfoApiService$CommentInfoResponse$CommentInfoData$MerchantInfoModel$Config$$serializer.INSTANCE, config3);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num6);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num5);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                        i3 |= 16;
                        i2 = 7;
                        break;
                    case 5:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str5);
                        i3 |= 32;
                        i2 = 7;
                        break;
                    case 6:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str4);
                        i3 |= 64;
                        i2 = 7;
                        continue;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, JsonElementSerializer.INSTANCE, jsonElement2);
                        i3 |= 128;
                        break;
                    case 8:
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, l2);
                        i3 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            l = l2;
            num = num4;
            str = str5;
            num2 = num6;
            jsonElement = jsonElement2;
            config = config3;
            str2 = str4;
            i = i3;
            Integer num7 = num5;
            str3 = str6;
            num3 = num7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel(i, num, config, num2, num3, str3, str, str2, jsonElement, l, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.MerchantInfoModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}