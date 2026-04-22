package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer implements GeneratedSerializer<ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice> {
    public static final int $stable;
    public static final ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer INSTANCE = new ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("couponList", true);
        pluginGeneratedSerialDescriptor.addElement("reducedPrice", true);
        pluginGeneratedSerialDescriptor.addElement("reducedPriceUsedCoupon", true);
        pluginGeneratedSerialDescriptor.addElement("reducedYPrice", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE)};
    }

    public final ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        List list;
        Integer num;
        ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.Coupon coupon;
        Double d;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.$childSerializers;
        List list2 = null;
        if (beginStructure.decodeSequentially()) {
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, (Object) null);
            coupon = (ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.Coupon) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$$serializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            i = 15;
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DoubleSerializer.INSTANCE, (Object) null);
            num = num2;
        } else {
            boolean z = true;
            int i2 = 0;
            Integer num3 = null;
            ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.Coupon coupon2 = null;
            Double d2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                        i2 |= 1;
                        break;
                    case 1:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num3);
                        i2 |= 2;
                        break;
                    case 2:
                        coupon2 = (ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.Coupon) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$$serializer.INSTANCE, coupon2);
                        i2 |= 4;
                        break;
                    case 3:
                        d2 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DoubleSerializer.INSTANCE, d2);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            list = list2;
            num = num3;
            coupon = coupon2;
            d = d2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice(i, list, num, coupon, d, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}