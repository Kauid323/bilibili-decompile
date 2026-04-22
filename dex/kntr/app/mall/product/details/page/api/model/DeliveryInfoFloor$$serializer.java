package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.DeliveryInfoFloor;
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

/* compiled from: DeliveryInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/DeliveryInfoFloor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DeliveryInfoFloor$$serializer implements GeneratedSerializer<DeliveryInfoFloor> {
    public static final int $stable;
    public static final DeliveryInfoFloor$$serializer INSTANCE = new DeliveryInfoFloor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.DeliveryInfoFloor", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement("floorKey", true);
        pluginGeneratedSerialDescriptor.addElement("floorIcon", true);
        pluginGeneratedSerialDescriptor.addElement("bgImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("addrText", true);
        pluginGeneratedSerialDescriptor.addElement("addressModuleData", true);
        pluginGeneratedSerialDescriptor.addElement("canOpenAddr", true);
        pluginGeneratedSerialDescriptor.addElement("itemsDeliveryInfo", true);
        pluginGeneratedSerialDescriptor.addElement("userDefAddrVO", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private DeliveryInfoFloor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DeliveryInfoFloor$AddressModuleData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DeliveryInfoFloor$ItemsDeliveryInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DeliveryInfoFloor$UserDefAddrVO$$serializer.INSTANCE)};
    }

    public final DeliveryInfoFloor deserialize(Decoder decoder) {
        DeliveryInfoFloor.UserDefAddrVO userDefAddrVO;
        DeliveryInfoFloor.ItemsDeliveryInfo itemsDeliveryInfo;
        Boolean bool;
        int i;
        DeliveryInfoFloor.AddressModuleData addressModuleData;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            userDefAddrVO = (DeliveryInfoFloor.UserDefAddrVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, DeliveryInfoFloor$UserDefAddrVO$$serializer.INSTANCE, (Object) null);
            itemsDeliveryInfo = (DeliveryInfoFloor.ItemsDeliveryInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DeliveryInfoFloor$ItemsDeliveryInfo$$serializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            addressModuleData = (DeliveryInfoFloor.AddressModuleData) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DeliveryInfoFloor$AddressModuleData$$serializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            i = 255;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i3 = 0;
            DeliveryInfoFloor.UserDefAddrVO userDefAddrVO2 = null;
            DeliveryInfoFloor.ItemsDeliveryInfo itemsDeliveryInfo2 = null;
            Boolean bool2 = null;
            DeliveryInfoFloor.AddressModuleData addressModuleData2 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str5);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str8);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        addressModuleData2 = (DeliveryInfoFloor.AddressModuleData) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DeliveryInfoFloor$AddressModuleData$$serializer.INSTANCE, addressModuleData2);
                        i3 |= 16;
                        i2 = 7;
                        continue;
                    case 5:
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, bool2);
                        i3 |= 32;
                        break;
                    case 6:
                        itemsDeliveryInfo2 = (DeliveryInfoFloor.ItemsDeliveryInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DeliveryInfoFloor$ItemsDeliveryInfo$$serializer.INSTANCE, itemsDeliveryInfo2);
                        i3 |= 64;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        userDefAddrVO2 = (DeliveryInfoFloor.UserDefAddrVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, DeliveryInfoFloor$UserDefAddrVO$$serializer.INSTANCE, userDefAddrVO2);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            userDefAddrVO = userDefAddrVO2;
            itemsDeliveryInfo = itemsDeliveryInfo2;
            bool = bool2;
            i = i3;
            String str9 = str8;
            addressModuleData = addressModuleData2;
            str = str5;
            str2 = str6;
            str3 = str7;
            str4 = str9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeliveryInfoFloor(i, str, str2, str3, str4, addressModuleData, bool, itemsDeliveryInfo, userDefAddrVO, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DeliveryInfoFloor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeliveryInfoFloor.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}