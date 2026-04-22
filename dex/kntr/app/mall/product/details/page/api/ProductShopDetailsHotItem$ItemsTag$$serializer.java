package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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

/* compiled from: ProductShopApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/ProductShopDetailsHotItem.ItemsTag.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ProductShopDetailsHotItem$ItemsTag$$serializer implements GeneratedSerializer<ProductShopDetailsHotItem.ItemsTag> {
    public static final int $stable;
    public static final ProductShopDetailsHotItem$ItemsTag$$serializer INSTANCE = new ProductShopDetailsHotItem$ItemsTag$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem.ItemsTag", INSTANCE, 22);
        pluginGeneratedSerialDescriptor.addElement("actThereMaterial", true);
        pluginGeneratedSerialDescriptor.addElement("actionTags", true);
        pluginGeneratedSerialDescriptor.addElement("adTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("attributeTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("blindBoxCommendTags", true);
        pluginGeneratedSerialDescriptor.addElement("blindBoxEuroNames", true);
        pluginGeneratedSerialDescriptor.addElement("blindBoxHasWishNames", true);
        pluginGeneratedSerialDescriptor.addElement("blindBoxHideTypeNames", true);
        pluginGeneratedSerialDescriptor.addElement("drainageTags", true);
        pluginGeneratedSerialDescriptor.addElement("exclusiveSalePoints", true);
        pluginGeneratedSerialDescriptor.addElement("feedBoardTag", true);
        pluginGeneratedSerialDescriptor.addElement("godlikeTag", true);
        pluginGeneratedSerialDescriptor.addElement("itemTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("marketingTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("otherSalePoints", true);
        pluginGeneratedSerialDescriptor.addElement("promotionTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("recommendTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("saleTypeTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("serviceTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("tagsSort", true);
        pluginGeneratedSerialDescriptor.addElement("titleTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("typeAndLimitTagName", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ProductShopDetailsHotItem$ItemsTag$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ProductShopDetailsHotItem.ItemsTag.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), BuiltinSerializersKt.getNullable(ProductShopDetailsHotItem$ItemsTag$FeedBoardTag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ProductShopDetailsHotItem$ItemsTag$GodlikeTag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[12].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[13].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[14].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[15].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[16].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[17].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[18].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[19].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[20].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final ProductShopDetailsHotItem.ItemsTag deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        List list8;
        ProductShopDetailsHotItem.ItemsTag.FeedBoardTag feedBoardTag;
        List list9;
        String str;
        List list10;
        List list11;
        List list12;
        List list13;
        List list14;
        List list15;
        int i;
        ProductShopDetailsHotItem.ItemsTag.ActThereMaterial actThereMaterial;
        ProductShopDetailsHotItem.ItemsTag.GodlikeTag godlikeTag;
        List list16;
        List list17;
        List list18;
        ProductShopDetailsHotItem.ItemsTag.GodlikeTag godlikeTag2;
        int i2;
        int i3;
        ProductShopDetailsHotItem.ItemsTag.FeedBoardTag feedBoardTag2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ProductShopDetailsHotItem.ItemsTag.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            ProductShopDetailsHotItem.ItemsTag.FeedBoardTag feedBoardTag3 = (ProductShopDetailsHotItem.ItemsTag.FeedBoardTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ProductShopDetailsHotItem$ItemsTag$FeedBoardTag$$serializer.INSTANCE, (Object) null);
            godlikeTag = (ProductShopDetailsHotItem.ItemsTag.GodlikeTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, ProductShopDetailsHotItem$ItemsTag$GodlikeTag$$serializer.INSTANCE, (Object) null);
            List list19 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), (Object) null);
            List list20 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), (Object) null);
            List list21 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), (Object) null);
            List list22 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), (Object) null);
            List list23 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), (Object) null);
            List list24 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, (DeserializationStrategy) lazyArr[17].getValue(), (Object) null);
            List list25 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, (DeserializationStrategy) lazyArr[18].getValue(), (Object) null);
            List list26 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, (DeserializationStrategy) lazyArr[19].getValue(), (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, (Object) null);
            list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, (DeserializationStrategy) lazyArr[20].getValue(), (Object) null);
            list16 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            list11 = list26;
            list13 = list25;
            list12 = list24;
            list14 = list23;
            list15 = list22;
            list9 = list21;
            list17 = list20;
            list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), (Object) null);
            list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            list7 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), (Object) null);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), (Object) null);
            actThereMaterial = (ProductShopDetailsHotItem.ItemsTag.ActThereMaterial) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$$serializer.INSTANCE, (Object) null);
            i = 4194303;
            list18 = list19;
            feedBoardTag = feedBoardTag3;
        } else {
            List list27 = null;
            List list28 = null;
            String str2 = null;
            List list29 = null;
            List list30 = null;
            List list31 = null;
            ProductShopDetailsHotItem.ItemsTag.FeedBoardTag feedBoardTag4 = null;
            List list32 = null;
            List list33 = null;
            ProductShopDetailsHotItem.ItemsTag.GodlikeTag godlikeTag3 = null;
            ProductShopDetailsHotItem.ItemsTag.ActThereMaterial actThereMaterial2 = null;
            List list34 = null;
            List list35 = null;
            List list36 = null;
            List list37 = null;
            List list38 = null;
            List list39 = null;
            List list40 = null;
            List list41 = null;
            List list42 = null;
            boolean z = true;
            int i4 = 0;
            List list43 = null;
            List list44 = null;
            while (z) {
                ProductShopDetailsHotItem.ItemsTag.FeedBoardTag feedBoardTag5 = feedBoardTag4;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        feedBoardTag2 = feedBoardTag5;
                        z = false;
                        list27 = list27;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 0:
                        feedBoardTag2 = feedBoardTag5;
                        actThereMaterial2 = (ProductShopDetailsHotItem.ItemsTag.ActThereMaterial) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$$serializer.INSTANCE, actThereMaterial2);
                        i4 |= 1;
                        list27 = list27;
                        list28 = list28;
                        list34 = list34;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 1:
                        feedBoardTag2 = feedBoardTag5;
                        list34 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list34);
                        i4 |= 2;
                        list27 = list27;
                        list28 = list28;
                        list35 = list35;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 2:
                        feedBoardTag2 = feedBoardTag5;
                        list35 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list35);
                        i4 |= 4;
                        list27 = list27;
                        list28 = list28;
                        list36 = list36;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 3:
                        feedBoardTag2 = feedBoardTag5;
                        list36 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list36);
                        i4 |= 8;
                        list27 = list27;
                        list28 = list28;
                        list37 = list37;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 4:
                        feedBoardTag2 = feedBoardTag5;
                        list37 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list37);
                        i4 |= 16;
                        list27 = list27;
                        list28 = list28;
                        list38 = list38;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 5:
                        feedBoardTag2 = feedBoardTag5;
                        list38 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list38);
                        i4 |= 32;
                        list27 = list27;
                        list28 = list28;
                        list39 = list39;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 6:
                        feedBoardTag2 = feedBoardTag5;
                        list39 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list39);
                        i4 |= 64;
                        list27 = list27;
                        list28 = list28;
                        list40 = list40;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        feedBoardTag2 = feedBoardTag5;
                        list40 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list40);
                        i4 |= 128;
                        list27 = list27;
                        list28 = list28;
                        list41 = list41;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 8:
                        feedBoardTag2 = feedBoardTag5;
                        list41 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), list41);
                        i4 |= 256;
                        list27 = list27;
                        list28 = list28;
                        list42 = list42;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        feedBoardTag2 = feedBoardTag5;
                        list42 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list42);
                        i4 |= 512;
                        list27 = list27;
                        list28 = list28;
                        feedBoardTag4 = feedBoardTag2;
                        break;
                    case 10:
                        feedBoardTag4 = (ProductShopDetailsHotItem.ItemsTag.FeedBoardTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, ProductShopDetailsHotItem$ItemsTag$FeedBoardTag$$serializer.INSTANCE, feedBoardTag5);
                        i4 |= 1024;
                        list27 = list27;
                        list28 = list28;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        godlikeTag3 = (ProductShopDetailsHotItem.ItemsTag.GodlikeTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, ProductShopDetailsHotItem$ItemsTag$GodlikeTag$$serializer.INSTANCE, godlikeTag3);
                        i4 |= 2048;
                        list27 = list27;
                        feedBoardTag4 = feedBoardTag5;
                        break;
                    case 12:
                        godlikeTag2 = godlikeTag3;
                        list27 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), list27);
                        i4 |= 4096;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 13:
                        godlikeTag2 = godlikeTag3;
                        list28 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), list28);
                        i4 |= 8192;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        godlikeTag2 = godlikeTag3;
                        list43 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), list43);
                        i4 |= 16384;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 15:
                        godlikeTag2 = godlikeTag3;
                        list44 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), list44);
                        i2 = 32768;
                        i4 |= i2;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 16:
                        godlikeTag2 = godlikeTag3;
                        list33 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), list33);
                        i3 = 65536;
                        i4 |= i3;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 17:
                        godlikeTag2 = godlikeTag3;
                        list31 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, (DeserializationStrategy) lazyArr[17].getValue(), list31);
                        i2 = 131072;
                        i4 |= i2;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 18:
                        godlikeTag2 = godlikeTag3;
                        list32 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, (DeserializationStrategy) lazyArr[18].getValue(), list32);
                        i3 = 262144;
                        i4 |= i3;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 19:
                        godlikeTag2 = godlikeTag3;
                        list30 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, (DeserializationStrategy) lazyArr[19].getValue(), list30);
                        i2 = 524288;
                        i4 |= i2;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 20:
                        godlikeTag2 = godlikeTag3;
                        list29 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, (DeserializationStrategy) lazyArr[20].getValue(), list29);
                        i3 = 1048576;
                        i4 |= i3;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    case 21:
                        godlikeTag2 = godlikeTag3;
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str2);
                        i3 = 2097152;
                        i4 |= i3;
                        feedBoardTag4 = feedBoardTag5;
                        godlikeTag3 = godlikeTag2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list35;
            list2 = list36;
            list3 = list37;
            list4 = list38;
            list5 = list39;
            list6 = list40;
            list7 = list41;
            list8 = list42;
            feedBoardTag = feedBoardTag4;
            list9 = list43;
            str = str2;
            list10 = list29;
            list11 = list30;
            list12 = list31;
            list13 = list32;
            list14 = list33;
            list15 = list44;
            i = i4;
            actThereMaterial = actThereMaterial2;
            godlikeTag = godlikeTag3;
            list16 = list34;
            list17 = list28;
            list18 = list27;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ProductShopDetailsHotItem.ItemsTag(i, actThereMaterial, list16, list, list2, list3, list4, list5, list6, list7, list8, feedBoardTag, godlikeTag, list18, list17, list9, list15, list14, list12, list13, list11, list10, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ProductShopDetailsHotItem.ItemsTag value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ProductShopDetailsHotItem.ItemsTag.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}