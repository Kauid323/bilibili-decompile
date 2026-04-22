package kntr.app.mall.product.details.page.api.model;

import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActivityInfoFloor.ActivityExtInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActivityInfoFloor$ActivityExtInfo$$serializer implements GeneratedSerializer<ActivityInfoFloor.ActivityExtInfo> {
    public static final int $stable;
    public static final ActivityInfoFloor$ActivityExtInfo$$serializer INSTANCE = new ActivityInfoFloor$ActivityExtInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActivityInfoFloor.ActivityExtInfo", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("forbidStatus", true);
        pluginGeneratedSerialDescriptor.addElement("hasStockSkuCount", true);
        pluginGeneratedSerialDescriptor.addElement("lowestSkuReducedPrice", true);
        pluginGeneratedSerialDescriptor.addElement("newUserCouponDTO", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActivityInfoFloor$ActivityExtInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityExtInfo$NewUserCoupon$$serializer.INSTANCE)};
    }

    public final ActivityInfoFloor.ActivityExtInfo deserialize(Decoder decoder) {
        int i;
        Byte b;
        Integer num;
        ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice lowestSkuReducedPrice;
        ActivityInfoFloor.ActivityExtInfo.NewUserCoupon newUserCoupon;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        Byte b2 = null;
        if (beginStructure.decodeSequentially()) {
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, (Object) null);
            ActivityInfoFloor.ActivityExtInfo.NewUserCoupon newUserCoupon2 = (ActivityInfoFloor.ActivityExtInfo.NewUserCoupon) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ActivityInfoFloor$ActivityExtInfo$NewUserCoupon$$serializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ByteSerializer.INSTANCE, (Object) null);
            i = 15;
            newUserCoupon = newUserCoupon2;
            lowestSkuReducedPrice = (ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer.INSTANCE, (Object) null);
            num = num2;
        } else {
            boolean z = true;
            i = 0;
            Integer num3 = null;
            ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice lowestSkuReducedPrice2 = null;
            ActivityInfoFloor.ActivityExtInfo.NewUserCoupon newUserCoupon3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ByteSerializer.INSTANCE, b2);
                        i |= 1;
                        break;
                    case 1:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num3);
                        i |= 2;
                        break;
                    case 2:
                        lowestSkuReducedPrice2 = (ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer.INSTANCE, lowestSkuReducedPrice2);
                        i |= 4;
                        break;
                    case 3:
                        newUserCoupon3 = (ActivityInfoFloor.ActivityExtInfo.NewUserCoupon) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ActivityInfoFloor$ActivityExtInfo$NewUserCoupon$$serializer.INSTANCE, newUserCoupon3);
                        i |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            b = b2;
            num = num3;
            lowestSkuReducedPrice = lowestSkuReducedPrice2;
            newUserCoupon = newUserCoupon3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityInfoFloor.ActivityExtInfo(i, b, num, lowestSkuReducedPrice, newUserCoupon, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActivityInfoFloor.ActivityExtInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityInfoFloor.ActivityExtInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}