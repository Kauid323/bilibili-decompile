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

/* compiled from: LiveInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/LiveInfoApiService.LiveInfoData.LotteryDash.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LiveInfoApiService$LiveInfoData$LotteryDash$$serializer implements GeneratedSerializer<LiveInfoApiService.LiveInfoData.LotteryDash> {
    public static final int $stable;
    public static final LiveInfoApiService$LiveInfoData$LotteryDash$$serializer INSTANCE = new LiveInfoApiService$LiveInfoData$LotteryDash$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoData.LotteryDash", INSTANCE, 2);
        pluginGeneratedSerialDescriptor.addElement("activityInfo", true);
        pluginGeneratedSerialDescriptor.addElement("userActivityInfo", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LiveInfoApiService$LiveInfoData$LotteryDash$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer.INSTANCE)};
    }

    public final LiveInfoApiService.LiveInfoData.LotteryDash deserialize(Decoder decoder) {
        LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo;
        LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            activityInfo = (LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer.INSTANCE, (Object) null);
            userActivityInfo = (LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer.INSTANCE, (Object) null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            activityInfo = null;
            LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        activityInfo = (LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer.INSTANCE, activityInfo);
                        i2 |= 1;
                        break;
                    case 1:
                        userActivityInfo2 = (LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer.INSTANCE, userActivityInfo2);
                        i2 |= 2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            userActivityInfo = userActivityInfo2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new LiveInfoApiService.LiveInfoData.LotteryDash(i, activityInfo, userActivityInfo, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, LiveInfoApiService.LiveInfoData.LotteryDash value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        LiveInfoApiService.LiveInfoData.LotteryDash.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}