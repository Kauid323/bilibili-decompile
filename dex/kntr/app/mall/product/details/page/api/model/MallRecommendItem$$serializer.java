package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.Map;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FeedsModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/MallRecommendItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MallRecommendItem$$serializer implements GeneratedSerializer<MallRecommendItem> {
    public static final int $stable;
    public static final MallRecommendItem$$serializer INSTANCE = new MallRecommendItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.MallRecommendItem", INSTANCE, 16);
        pluginGeneratedSerialDescriptor.addElement("itemId", true);
        pluginGeneratedSerialDescriptor.addElement("itemType", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("cover", true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement("tag", true);
        pluginGeneratedSerialDescriptor.addElement("feedTag", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("price", true);
        pluginGeneratedSerialDescriptor.addElement("like", true);
        pluginGeneratedSerialDescriptor.addElement("detailInfo", true);
        pluginGeneratedSerialDescriptor.addElement("vvType", true);
        pluginGeneratedSerialDescriptor.addElement("reportInfo", true);
        pluginGeneratedSerialDescriptor.addElement("reportParams", true);
        pluginGeneratedSerialDescriptor.addElement("teamBLind", true);
        pluginGeneratedSerialDescriptor.addElement("pageNum", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private MallRecommendItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = MallRecommendItem.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ItemTags$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FeedTag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PriceInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ReportInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[13].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final MallRecommendItem deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        Map map;
        String str2;
        String str3;
        PriceInfo priceInfo;
        String str4;
        String str5;
        String str6;
        String str7;
        ItemTags itemTags;
        ReportInfo reportInfo;
        String str8;
        FeedTag feedTag;
        Integer num;
        Boolean bool;
        int i;
        Long l;
        Lazy[] lazyArr2;
        String str9;
        ReportInfo reportInfo2;
        Lazy[] lazyArr3;
        String str10;
        ItemTags itemTags2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = MallRecommendItem.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            ReportInfo reportInfo3 = (ReportInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ReportInfo$$serializer.INSTANCE, (Object) null);
            Boolean bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, BooleanSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, (Object) null);
            map = (Map) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            feedTag = (FeedTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FeedTag$$serializer.INSTANCE, (Object) null);
            bool = bool2;
            str5 = str11;
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            i = 65535;
            priceInfo = (PriceInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, PriceInfo$$serializer.INSTANCE, (Object) null);
            reportInfo = reportInfo3;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            itemTags = (ItemTags) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ItemTags$$serializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            ReportInfo reportInfo4 = null;
            Map map2 = null;
            FeedTag feedTag2 = null;
            ItemTags itemTags3 = null;
            Integer num2 = null;
            String str12 = null;
            String str13 = null;
            PriceInfo priceInfo2 = null;
            String str14 = null;
            str = null;
            String str15 = null;
            Long l2 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            int i2 = 0;
            Boolean bool3 = null;
            while (z) {
                ItemTags itemTags4 = itemTags3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        reportInfo2 = reportInfo4;
                        z = false;
                        lazyArr = lazyArr;
                        itemTags3 = itemTags4;
                        reportInfo4 = reportInfo2;
                        break;
                    case 0:
                        reportInfo2 = reportInfo4;
                        lazyArr3 = lazyArr;
                        str10 = str;
                        itemTags2 = itemTags4;
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l2);
                        i2 |= 1;
                        lazyArr = lazyArr3;
                        itemTags3 = itemTags2;
                        str = str10;
                        reportInfo4 = reportInfo2;
                        break;
                    case 1:
                        reportInfo2 = reportInfo4;
                        str10 = str;
                        itemTags2 = itemTags4;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str16);
                        i2 |= 2;
                        lazyArr = lazyArr;
                        str17 = str17;
                        itemTags3 = itemTags2;
                        str = str10;
                        reportInfo4 = reportInfo2;
                        break;
                    case 2:
                        reportInfo2 = reportInfo4;
                        str10 = str;
                        itemTags2 = itemTags4;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str17);
                        i2 |= 4;
                        lazyArr = lazyArr;
                        str18 = str18;
                        itemTags3 = itemTags2;
                        str = str10;
                        reportInfo4 = reportInfo2;
                        break;
                    case 3:
                        reportInfo2 = reportInfo4;
                        lazyArr3 = lazyArr;
                        str10 = str;
                        itemTags2 = itemTags4;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str18);
                        i2 |= 8;
                        lazyArr = lazyArr3;
                        itemTags3 = itemTags2;
                        str = str10;
                        reportInfo4 = reportInfo2;
                        break;
                    case 4:
                        reportInfo2 = reportInfo4;
                        str10 = str;
                        i2 |= 16;
                        itemTags3 = (ItemTags) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ItemTags$$serializer.INSTANCE, itemTags4);
                        lazyArr = lazyArr;
                        str = str10;
                        reportInfo4 = reportInfo2;
                        break;
                    case 5:
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str);
                        i2 |= 32;
                        lazyArr = lazyArr;
                        reportInfo4 = reportInfo4;
                        itemTags3 = itemTags4;
                        break;
                    case 6:
                        lazyArr2 = lazyArr;
                        str9 = str;
                        feedTag2 = (FeedTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FeedTag$$serializer.INSTANCE, feedTag2);
                        i2 |= 64;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        lazyArr2 = lazyArr;
                        str9 = str;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str14);
                        i2 |= 128;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case 8:
                        lazyArr2 = lazyArr;
                        str9 = str;
                        priceInfo2 = (PriceInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, PriceInfo$$serializer.INSTANCE, priceInfo2);
                        i2 |= 256;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        lazyArr2 = lazyArr;
                        str9 = str;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str13);
                        i2 |= 512;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case 10:
                        lazyArr2 = lazyArr;
                        str9 = str;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str15);
                        i2 |= 1024;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        lazyArr2 = lazyArr;
                        str9 = str;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str12);
                        i2 |= 2048;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case 12:
                        str9 = str;
                        lazyArr2 = lazyArr;
                        reportInfo4 = (ReportInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ReportInfo$$serializer.INSTANCE, reportInfo4);
                        i2 |= 4096;
                        lazyArr = lazyArr2;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case 13:
                        str9 = str;
                        map2 = (Map) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), map2);
                        i2 |= 8192;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str9 = str;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 16384;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    case 15:
                        str9 = str;
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, num2);
                        i2 |= 32768;
                        itemTags3 = itemTags4;
                        str = str9;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            map = map2;
            str2 = str12;
            str3 = str13;
            priceInfo = priceInfo2;
            str4 = str14;
            str5 = str15;
            str6 = str17;
            str7 = str18;
            itemTags = itemTags3;
            reportInfo = reportInfo4;
            str8 = str16;
            feedTag = feedTag2;
            num = num2;
            bool = bool3;
            i = i2;
            l = l2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MallRecommendItem(i, l, str8, str6, str7, itemTags, str, feedTag, str4, priceInfo, str3, str5, str2, reportInfo, map, bool, num, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, MallRecommendItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MallRecommendItem.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}