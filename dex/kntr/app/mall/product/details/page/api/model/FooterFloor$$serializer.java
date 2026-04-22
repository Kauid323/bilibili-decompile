package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FooterFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/FooterFloor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class FooterFloor$$serializer implements GeneratedSerializer<FooterFloor> {
    public static final int $stable;
    public static final FooterFloor$$serializer INSTANCE = new FooterFloor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.FooterFloor", INSTANCE, 9);
        pluginGeneratedSerialDescriptor.addElement("floorKey", true);
        pluginGeneratedSerialDescriptor.addElement("floorIcon", true);
        pluginGeneratedSerialDescriptor.addElement("bgImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("purchaseButton", true);
        pluginGeneratedSerialDescriptor.addElement("footer", true);
        pluginGeneratedSerialDescriptor.addElement("actionInfoVO", true);
        pluginGeneratedSerialDescriptor.addElement("addCartButton", true);
        pluginGeneratedSerialDescriptor.addElement("couponPackageInfoVO", true);
        pluginGeneratedSerialDescriptor.addElement("couponPackageInfos", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private FooterFloor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = FooterFloor.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FooterFloor$PurchaseButton$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable(FooterFloor$ActionInfoVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FooterFloor$AddCartButton$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CouponPackageInfoModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue())};
    }

    public final FooterFloor deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        String str;
        FooterFloor.ActionInfoVO actionInfoVO;
        String str2;
        FooterFloor.AddCartButton addCartButton;
        FooterFloor.PurchaseButton purchaseButton;
        List list2;
        String str3;
        CouponPackageInfoModel couponPackageInfoModel;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = FooterFloor.$childSerializers;
        int i2 = 8;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), (Object) null);
            couponPackageInfoModel = (CouponPackageInfoModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, CouponPackageInfoModel$$serializer.INSTANCE, (Object) null);
            addCartButton = (FooterFloor.AddCartButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FooterFloor$AddCartButton$$serializer.INSTANCE, (Object) null);
            actionInfoVO = (FooterFloor.ActionInfoVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, FooterFloor$ActionInfoVO$$serializer.INSTANCE, (Object) null);
            i = 511;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            purchaseButton = (FooterFloor.PurchaseButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FooterFloor$PurchaseButton$$serializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i3 = 0;
            List list3 = null;
            CouponPackageInfoModel couponPackageInfoModel2 = null;
            FooterFloor.ActionInfoVO actionInfoVO2 = null;
            List list4 = null;
            FooterFloor.AddCartButton addCartButton2 = null;
            FooterFloor.PurchaseButton purchaseButton2 = null;
            String str5 = null;
            String str6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 8;
                        continue;
                    case 0:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i3 |= 1;
                        break;
                    case 1:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i3 |= 2;
                        break;
                    case 2:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str5);
                        i3 |= 4;
                        break;
                    case 3:
                        purchaseButton2 = (FooterFloor.PurchaseButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FooterFloor$PurchaseButton$$serializer.INSTANCE, purchaseButton2);
                        i3 |= 8;
                        break;
                    case 4:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list4);
                        i3 |= 16;
                        break;
                    case 5:
                        actionInfoVO2 = (FooterFloor.ActionInfoVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, FooterFloor$ActionInfoVO$$serializer.INSTANCE, actionInfoVO2);
                        i3 |= 32;
                        break;
                    case 6:
                        addCartButton2 = (FooterFloor.AddCartButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FooterFloor$AddCartButton$$serializer.INSTANCE, addCartButton2);
                        i3 |= 64;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        couponPackageInfoModel2 = (CouponPackageInfoModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, CouponPackageInfoModel$$serializer.INSTANCE, couponPackageInfoModel2);
                        i3 |= 128;
                        break;
                    case 8:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, (DeserializationStrategy) lazyArr[i2].getValue(), list3);
                        i3 |= 256;
                        continue;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                i2 = 8;
            }
            list = list3;
            str = str5;
            actionInfoVO = actionInfoVO2;
            str2 = str4;
            addCartButton = addCartButton2;
            purchaseButton = purchaseButton2;
            list2 = list4;
            str3 = str6;
            couponPackageInfoModel = couponPackageInfoModel2;
            i = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new FooterFloor(i, str2, str3, str, purchaseButton, list2, actionInfoVO, addCartButton, couponPackageInfoModel, list, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, FooterFloor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        FooterFloor.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}