package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.ShopItem;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShopInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ShopItem.ActivityDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ShopItem$ActivityDTO$$serializer implements GeneratedSerializer<ShopItem.ActivityDTO> {
    public static final int $stable;
    public static final ShopItem$ActivityDTO$$serializer INSTANCE = new ShopItem$ActivityDTO$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ShopItem.ActivityDTO", INSTANCE, 12);
        pluginGeneratedSerialDescriptor.addElement("activityType", true);
        pluginGeneratedSerialDescriptor.addElement("advanceCountdownTime", true);
        pluginGeneratedSerialDescriptor.addElement("advancePublishTime", true);
        pluginGeneratedSerialDescriptor.addElement("discountDto", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("process", true);
        pluginGeneratedSerialDescriptor.addElement("showLabel", true);
        pluginGeneratedSerialDescriptor.addElement("soldOut", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("activityId", true);
        pluginGeneratedSerialDescriptor.addElement("activityName", true);
        pluginGeneratedSerialDescriptor.addElement("activityDesc", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ShopItem$ActivityDTO$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ShopItem$ActivityDTO$Discount$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final ShopItem.ActivityDTO deserialize(Decoder decoder) {
        String str;
        Integer num;
        String str2;
        ShopItem.ActivityDTO.Discount discount;
        Byte b;
        String str3;
        Integer num2;
        Byte b2;
        Integer num3;
        Boolean bool;
        Integer num4;
        Long l;
        int i;
        Integer num5;
        Byte b3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            i = 4095;
            discount = (ShopItem.ActivityDTO.Discount) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ShopItem$ActivityDTO$Discount$$serializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, (Object) null);
            b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ByteSerializer.INSTANCE, (Object) null);
        } else {
            Byte b4 = null;
            Integer num6 = null;
            String str4 = null;
            Long l2 = null;
            Integer num7 = null;
            Boolean bool2 = null;
            Byte b5 = null;
            String str5 = null;
            String str6 = null;
            Integer num8 = null;
            boolean z = true;
            ShopItem.ActivityDTO.Discount discount2 = null;
            int i2 = 0;
            Integer num9 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        num5 = num6;
                        z = false;
                        num6 = num5;
                        break;
                    case 0:
                        num5 = num6;
                        b4 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ByteSerializer.INSTANCE, b4);
                        i2 |= 1;
                        num6 = num5;
                        break;
                    case 1:
                        b3 = b4;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num6);
                        i2 |= 2;
                        b4 = b3;
                        break;
                    case 2:
                        b3 = b4;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num9);
                        i2 |= 4;
                        b4 = b3;
                        break;
                    case 3:
                        b3 = b4;
                        discount2 = (ShopItem.ActivityDTO.Discount) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ShopItem$ActivityDTO$Discount$$serializer.INSTANCE, discount2);
                        i2 |= 8;
                        b4 = b3;
                        break;
                    case 4:
                        b3 = b4;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num8);
                        i2 |= 16;
                        b4 = b3;
                        break;
                    case 5:
                        b3 = b4;
                        b5 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ByteSerializer.INSTANCE, b5);
                        i2 |= 32;
                        b4 = b3;
                        break;
                    case 6:
                        b3 = b4;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str6);
                        i2 |= 64;
                        b4 = b3;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        b3 = b4;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, bool2);
                        i2 |= 128;
                        b4 = b3;
                        break;
                    case 8:
                        b3 = b4;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num7);
                        i2 |= 256;
                        b4 = b3;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        b3 = b4;
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, l2);
                        i2 |= 512;
                        b4 = b3;
                        break;
                    case 10:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str5);
                        i2 |= 1024;
                        b4 = b4;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        b3 = b4;
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str4);
                        i2 |= 2048;
                        b4 = b3;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str4;
            num = num7;
            str2 = str5;
            discount = discount2;
            b = b4;
            str3 = str6;
            num2 = num8;
            b2 = b5;
            num3 = num9;
            bool = bool2;
            num4 = num6;
            l = l2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ShopItem.ActivityDTO(i, b, num4, num3, discount, num2, b2, str3, bool, num, l, str2, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ShopItem.ActivityDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ShopItem.ActivityDTO.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}