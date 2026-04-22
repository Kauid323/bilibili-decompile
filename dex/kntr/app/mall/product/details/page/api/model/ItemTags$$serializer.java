package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
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

/* compiled from: FeedsModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ItemTags.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ItemTags;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ItemTags$$serializer implements GeneratedSerializer<ItemTags> {
    public static final int $stable;
    public static final ItemTags$$serializer INSTANCE = new ItemTags$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ItemTags", INSTANCE, 19);
        pluginGeneratedSerialDescriptor.addElement("promotionTagV2", true);
        pluginGeneratedSerialDescriptor.addElement("promotionTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("marketingTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("saleTypeTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("typeAndLimitTagName", true);
        pluginGeneratedSerialDescriptor.addElement("itemTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("recommendTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("attributeTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("rankAndSellPointTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("blindBoxHideTypeNames", true);
        pluginGeneratedSerialDescriptor.addElement("titleTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("ticketTag", true);
        pluginGeneratedSerialDescriptor.addElement("starBoxSalePoints", true);
        pluginGeneratedSerialDescriptor.addElement("exclusiveSalePoints", true);
        pluginGeneratedSerialDescriptor.addElement("otherSalePoints", true);
        pluginGeneratedSerialDescriptor.addElement("serviceTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("tagsSort", true);
        pluginGeneratedSerialDescriptor.addElement("adTagNames", true);
        pluginGeneratedSerialDescriptor.addElement("serviceRightsTags", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ItemTags$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ItemTags.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[10].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[12].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[14].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[15].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[16].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[17].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[18].getValue())};
    }

    public final ItemTags deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        String str;
        String str2;
        String str3;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        String str4;
        List list7;
        List list8;
        List list9;
        List list10;
        List list11;
        String str5;
        int i;
        String str6;
        List list12;
        List list13;
        List list14;
        String str7;
        int i2;
        int i3;
        Lazy[] lazyArr2;
        String str8;
        List list15;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ItemTags.$childSerializers;
        List list16 = null;
        if (beginStructure.decodeSequentially()) {
            List list17 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), (Object) null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            List list18 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), (Object) null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            List list19 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), (Object) null);
            List list20 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), (Object) null);
            List list21 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), (Object) null);
            i = 524287;
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, (DeserializationStrategy) lazyArr[17].getValue(), (Object) null);
            list13 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, (DeserializationStrategy) lazyArr[18].getValue(), (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            list9 = list21;
            list11 = list19;
            str5 = str11;
            list7 = list20;
            list8 = list18;
            str = str10;
            list12 = list17;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), (Object) null);
            list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
        } else {
            int i4 = 0;
            boolean z = true;
            String str12 = null;
            List list22 = null;
            List list23 = null;
            String str13 = null;
            List list24 = null;
            List list25 = null;
            String str14 = null;
            String str15 = null;
            List list26 = null;
            List list27 = null;
            List list28 = null;
            String str16 = null;
            List list29 = null;
            List list30 = null;
            List list31 = null;
            String str17 = null;
            List list32 = null;
            List list33 = null;
            while (z) {
                List list34 = list26;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        lazyArr2 = lazyArr;
                        str8 = str12;
                        list15 = list23;
                        str9 = str15;
                        list26 = list34;
                        z = false;
                        lazyArr = lazyArr2;
                        list23 = list15;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 0:
                        lazyArr2 = lazyArr;
                        str8 = str12;
                        list15 = list23;
                        str9 = str15;
                        list26 = list34;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str16);
                        i4 |= 1;
                        list22 = list22;
                        list29 = list29;
                        lazyArr = lazyArr2;
                        list23 = list15;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 1:
                        str8 = str12;
                        list15 = list23;
                        str9 = str15;
                        list26 = list34;
                        lazyArr2 = lazyArr;
                        list29 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list29);
                        i4 |= 2;
                        list22 = list22;
                        lazyArr = lazyArr2;
                        list23 = list15;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 2:
                        str8 = str12;
                        list15 = list23;
                        str9 = str15;
                        list26 = list34;
                        list30 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list30);
                        i4 |= 4;
                        list22 = list22;
                        list31 = list31;
                        list23 = list15;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 3:
                        str8 = str12;
                        str9 = str15;
                        list26 = list34;
                        list15 = list23;
                        list31 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list31);
                        i4 |= 8;
                        list22 = list22;
                        list23 = list15;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 4:
                        str8 = str12;
                        str9 = str15;
                        list26 = list34;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str17);
                        i4 |= 16;
                        list22 = list22;
                        list32 = list32;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 5:
                        str8 = str12;
                        str9 = str15;
                        list26 = list34;
                        list32 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list32);
                        i4 |= 32;
                        list22 = list22;
                        list33 = list33;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case 6:
                        str8 = str12;
                        List list35 = list22;
                        list26 = list34;
                        str9 = str15;
                        list33 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list33);
                        i4 |= 64;
                        list22 = list35;
                        str15 = str9;
                        str12 = str8;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str8 = str12;
                        list26 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list34);
                        i4 |= 128;
                        str15 = str15;
                        list22 = list22;
                        str12 = str8;
                        break;
                    case 8:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str15);
                        i4 |= 256;
                        list22 = list22;
                        str12 = str12;
                        list26 = list34;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        list14 = list22;
                        str7 = str15;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str14);
                        i4 |= 512;
                        list22 = list14;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 10:
                        list14 = list22;
                        str7 = str15;
                        list24 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), list24);
                        i4 |= 1024;
                        list22 = list14;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        list14 = list22;
                        str7 = str15;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str13);
                        i4 |= 2048;
                        list22 = list14;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 12:
                        list14 = list22;
                        str7 = str15;
                        list16 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), list16);
                        i4 |= 4096;
                        list22 = list14;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 13:
                        str7 = str15;
                        list14 = list22;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str12);
                        i4 |= 8192;
                        list22 = list14;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str7 = str15;
                        list23 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), list23);
                        i4 |= 16384;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 15:
                        str7 = str15;
                        list28 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), list28);
                        i2 = 32768;
                        i4 |= i2;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 16:
                        str7 = str15;
                        list22 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), list22);
                        i3 = 65536;
                        i4 |= i3;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 17:
                        str7 = str15;
                        list27 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, (DeserializationStrategy) lazyArr[17].getValue(), list27);
                        i2 = 131072;
                        i4 |= i2;
                        list26 = list34;
                        str15 = str7;
                        break;
                    case 18:
                        str7 = str15;
                        list25 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, (DeserializationStrategy) lazyArr[18].getValue(), list25);
                        i3 = 262144;
                        i4 |= i3;
                        list26 = list34;
                        str15 = str7;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list30;
            str = str13;
            str2 = str14;
            str3 = str17;
            list2 = list26;
            list3 = list27;
            list4 = list31;
            list5 = list32;
            list6 = list33;
            str4 = str15;
            list7 = list28;
            list8 = list16;
            list9 = list22;
            list10 = list29;
            list11 = list23;
            str5 = str12;
            i = i4;
            str6 = str16;
            list12 = list24;
            list13 = list25;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ItemTags(i, str6, list10, list, list4, str3, list5, list6, list2, str4, str2, list12, str, list8, str5, list11, list7, list9, list3, list13, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ItemTags value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ItemTags.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}