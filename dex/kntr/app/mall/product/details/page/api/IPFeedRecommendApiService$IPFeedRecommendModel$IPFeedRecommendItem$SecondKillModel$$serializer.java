package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.IPFeedRecommendApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$$serializer implements GeneratedSerializer<IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel> {
    public static final int $stable;
    public static final IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$$serializer INSTANCE = new IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel", INSTANCE, 12);
        pluginGeneratedSerialDescriptor.addElement("advanceCountdownTime", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("itemsId", true);
        pluginGeneratedSerialDescriptor.addElement("lowerDiscountDepositPrice", true);
        pluginGeneratedSerialDescriptor.addElement("lowerDiscountPrice", true);
        pluginGeneratedSerialDescriptor.addElement("process", true);
        pluginGeneratedSerialDescriptor.addElement("serverTime", true);
        pluginGeneratedSerialDescriptor.addElement("soldOut", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("upperDiscountDepositPrice", true);
        pluginGeneratedSerialDescriptor.addElement("upperDiscountPrice", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private IPFeedRecommendApiService$IPFeedRecommendModel$IPFeedRecommendItem$SecondKillModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE)};
    }

    public final IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel deserialize(Decoder decoder) {
        Double d;
        Long l;
        Double d2;
        Double d3;
        Long l2;
        Long l3;
        Double d4;
        Byte b;
        Long l4;
        Boolean bool;
        Long l5;
        Byte b2;
        int i;
        Long l6;
        Long l7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            d4 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, (Object) null);
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, DoubleSerializer.INSTANCE, (Object) null);
            d2 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DoubleSerializer.INSTANCE, (Object) null);
            b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ByteSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, (Object) null);
            i = 4095;
            d3 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DoubleSerializer.INSTANCE, (Object) null);
            l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, (Object) null);
            l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
        } else {
            Long l8 = null;
            Long l9 = null;
            Double d5 = null;
            Byte b3 = null;
            Long l10 = null;
            Boolean bool2 = null;
            Byte b4 = null;
            Double d6 = null;
            Long l11 = null;
            Double d7 = null;
            boolean z = true;
            Double d8 = null;
            int i2 = 0;
            Long l12 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        l6 = l9;
                        z = false;
                        l9 = l6;
                        break;
                    case 0:
                        l6 = l9;
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l8);
                        i2 |= 1;
                        l9 = l6;
                        break;
                    case 1:
                        l7 = l8;
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l9);
                        i2 |= 2;
                        l8 = l7;
                        break;
                    case 2:
                        l7 = l8;
                        l12 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l12);
                        i2 |= 4;
                        l8 = l7;
                        break;
                    case 3:
                        l7 = l8;
                        d8 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DoubleSerializer.INSTANCE, d8);
                        i2 |= 8;
                        l8 = l7;
                        break;
                    case 4:
                        l7 = l8;
                        d7 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, d7);
                        i2 |= 16;
                        l8 = l7;
                        break;
                    case 5:
                        l7 = l8;
                        b4 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, b4);
                        i2 |= 32;
                        l8 = l7;
                        break;
                    case 6:
                        l7 = l8;
                        l11 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l11);
                        i2 |= 64;
                        l8 = l7;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        l7 = l8;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, bool2);
                        i2 |= 128;
                        l8 = l7;
                        break;
                    case 8:
                        l7 = l8;
                        l10 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LongSerializer.INSTANCE, l10);
                        i2 |= 256;
                        l8 = l7;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        l7 = l8;
                        b3 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ByteSerializer.INSTANCE, b3);
                        i2 |= 512;
                        l8 = l7;
                        break;
                    case 10:
                        d6 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DoubleSerializer.INSTANCE, d6);
                        i2 |= 1024;
                        l8 = l8;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        l7 = l8;
                        d5 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, DoubleSerializer.INSTANCE, d5);
                        i2 |= 2048;
                        l8 = l7;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            d = d5;
            l = l10;
            d2 = d6;
            d3 = d8;
            l2 = l8;
            l3 = l11;
            d4 = d7;
            b = b4;
            l4 = l12;
            bool = bool2;
            l5 = l9;
            b2 = b3;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel(i, l2, l5, l4, d3, d4, b, l3, bool, l, b2, d2, d, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IPFeedRecommendApiService.IPFeedRecommendModel.IPFeedRecommendItem.SecondKillModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}