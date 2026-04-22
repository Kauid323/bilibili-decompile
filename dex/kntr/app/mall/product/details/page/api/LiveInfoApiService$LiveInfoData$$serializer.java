package kntr.app.mall.product.details.page.api;

import kntr.app.mall.product.details.page.api.LiveInfoApiService;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LiveInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/LiveInfoApiService.LiveInfoData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LiveInfoApiService$LiveInfoData$$serializer implements GeneratedSerializer<LiveInfoApiService.LiveInfoData> {
    public static final int $stable;
    public static final LiveInfoApiService$LiveInfoData$$serializer INSTANCE = new LiveInfoApiService$LiveInfoData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoData", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        pluginGeneratedSerialDescriptor.addElement("lotteryDash", true);
        pluginGeneratedSerialDescriptor.addElement("promotionAtmosphereInfo", true);
        pluginGeneratedSerialDescriptor.addElement("subTitle", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LiveInfoApiService$LiveInfoData$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LiveInfoApiService$LiveInfoData$LotteryDash$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final LiveInfoApiService.LiveInfoData deserialize(Decoder decoder) {
        int i;
        String str;
        LiveInfoApiService.LiveInfoData.LotteryDash lotteryDash;
        LiveInfoApiService.LiveInfoData.PromotionAtmosphereInfo promotionAtmosphereInfo;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            promotionAtmosphereInfo = (LiveInfoApiService.LiveInfoData.PromotionAtmosphereInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo$$serializer.INSTANCE, (Object) null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i = 31;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            lotteryDash = (LiveInfoApiService.LiveInfoData.LotteryDash) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LiveInfoApiService$LiveInfoData$LotteryDash$$serializer.INSTANCE, (Object) null);
            str2 = str5;
        } else {
            boolean z = true;
            i = 0;
            LiveInfoApiService.LiveInfoData.LotteryDash lotteryDash2 = null;
            LiveInfoApiService.LiveInfoData.PromotionAtmosphereInfo promotionAtmosphereInfo2 = null;
            String str6 = null;
            String str7 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i |= 1;
                        break;
                    case 1:
                        lotteryDash2 = (LiveInfoApiService.LiveInfoData.LotteryDash) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LiveInfoApiService$LiveInfoData$LotteryDash$$serializer.INSTANCE, lotteryDash2);
                        i |= 2;
                        break;
                    case 2:
                        promotionAtmosphereInfo2 = (LiveInfoApiService.LiveInfoData.PromotionAtmosphereInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LiveInfoApiService$LiveInfoData$PromotionAtmosphereInfo$$serializer.INSTANCE, promotionAtmosphereInfo2);
                        i |= 4;
                        break;
                    case 3:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str6);
                        i |= 8;
                        break;
                    case 4:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str7);
                        i |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str4;
            lotteryDash = lotteryDash2;
            promotionAtmosphereInfo = promotionAtmosphereInfo2;
            str2 = str6;
            str3 = str7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new LiveInfoApiService.LiveInfoData(i, str, lotteryDash, promotionAtmosphereInfo, str2, str3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, LiveInfoApiService.LiveInfoData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        LiveInfoApiService.LiveInfoData.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}