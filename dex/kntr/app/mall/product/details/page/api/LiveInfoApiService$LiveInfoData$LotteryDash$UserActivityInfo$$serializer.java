package kntr.app.mall.product.details.page.api;

import java.util.List;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: LiveInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer implements GeneratedSerializer<LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo> {
    public static final int $stable;
    public static final LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer INSTANCE = new LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo", INSTANCE, 7);
        pluginGeneratedSerialDescriptor.addElement("isCouponReceived", true);
        pluginGeneratedSerialDescriptor.addElement("isFollow", true);
        pluginGeneratedSerialDescriptor.addElement("isJoined", true);
        pluginGeneratedSerialDescriptor.addElement("isSubmitted", true);
        pluginGeneratedSerialDescriptor.addElement("isWinner", true);
        pluginGeneratedSerialDescriptor.addElement("myTicketNos", true);
        pluginGeneratedSerialDescriptor.addElement("ticketNos", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue())};
    }

    public final LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Boolean bool;
        Boolean bool2;
        List list;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        List list2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo.$childSerializers;
        int i2 = 4;
        Boolean bool6 = null;
        if (beginStructure.decodeSequentially()) {
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, (Object) null);
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, (Object) null);
            bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, (Object) null);
            i = 127;
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i3 = 0;
            List list3 = null;
            List list4 = null;
            Boolean bool7 = null;
            Boolean bool8 = null;
            Boolean bool9 = null;
            Boolean bool10 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 4;
                    case 0:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 1;
                        i2 = 4;
                    case 1:
                        bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool8);
                        i3 |= 2;
                        i2 = 4;
                    case 2:
                        bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool9);
                        i3 |= 4;
                        i2 = 4;
                    case 3:
                        bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool10);
                        i3 |= 8;
                        i2 = 4;
                    case 4:
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BooleanSerializer.INSTANCE, bool7);
                        i3 |= 16;
                    case 5:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list4);
                        i3 |= 32;
                    case 6:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list3);
                        i3 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bool = bool6;
            bool2 = bool8;
            list = list4;
            bool3 = bool7;
            bool4 = bool9;
            bool5 = bool10;
            list2 = list3;
            i = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo(i, bool, bool2, bool4, bool5, bool3, list, list2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}