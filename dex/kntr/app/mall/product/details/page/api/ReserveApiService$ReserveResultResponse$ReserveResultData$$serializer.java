package kntr.app.mall.product.details.page.api;

import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.ReserveApiService;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ReserveApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/ReserveApiService.ReserveResultResponse.ReserveResultData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ReserveApiService$ReserveResultResponse$ReserveResultData$$serializer implements GeneratedSerializer<ReserveApiService.ReserveResultResponse.ReserveResultData> {
    public static final int $stable;
    public static final ReserveApiService$ReserveResultResponse$ReserveResultData$$serializer INSTANCE = new ReserveApiService$ReserveResultResponse$ReserveResultData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ReserveApiService.ReserveResultResponse.ReserveResultData", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("couponInfoDTO", true);
        pluginGeneratedSerialDescriptor.addElement("finished", true);
        pluginGeneratedSerialDescriptor.addElement("receiveCouponSuccess", true);
        pluginGeneratedSerialDescriptor.addElement("reserveSuccess", true);
        pluginGeneratedSerialDescriptor.addElement("resultText", true);
        pluginGeneratedSerialDescriptor.addElement("toast", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ReserveApiService$ReserveResultResponse$ReserveResultData$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(CouponListResponse$CouponListItem$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final ReserveApiService.ReserveResultResponse.ReserveResultData deserialize(Decoder decoder) {
        String str;
        String str2;
        Boolean bool;
        Boolean bool2;
        CouponListResponse.CouponListItem couponListItem;
        Boolean bool3;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 5;
        CouponListResponse.CouponListItem couponListItem2 = null;
        if (beginStructure.decodeSequentially()) {
            couponListItem = (CouponListResponse.CouponListItem) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CouponListResponse$CouponListItem$$serializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, (Object) null);
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, (Object) null);
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            Boolean bool4 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            String str3 = null;
            String str4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        couponListItem2 = (CouponListResponse.CouponListItem) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CouponListResponse$CouponListItem$$serializer.INSTANCE, couponListItem2);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 2;
                    case 2:
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 4;
                    case 3:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 8;
                    case 4:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str3);
                        i3 |= 16;
                    case 5:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str4);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str3;
            str2 = str4;
            bool = bool5;
            bool2 = bool6;
            couponListItem = couponListItem2;
            bool3 = bool4;
            i = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ReserveApiService.ReserveResultResponse.ReserveResultData(i, couponListItem, bool3, bool, bool2, str, str2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ReserveApiService.ReserveResultResponse.ReserveResultData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ReserveApiService.ReserveResultResponse.ReserveResultData.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}