package kntr.app.mall.mallDynamicPage.component.business.bean;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/mallDynamicPage/component/business/bean/MallRecommendItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/MallRecommendItem;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MallRecommendItem$$serializer implements GeneratedSerializer<MallRecommendItem> {
    public static final int $stable;
    public static final MallRecommendItem$$serializer INSTANCE = new MallRecommendItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.mallDynamicPage.component.business.bean.MallRecommendItem", INSTANCE, 14);
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
        pluginGeneratedSerialDescriptor.addElement("teamBLind", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private MallRecommendItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ItemTags$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FeedTag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PriceInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ReportInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    public final MallRecommendItem deserialize(Decoder decoder) {
        ReportInfo reportInfo;
        String str;
        String str2;
        String str3;
        Boolean bool;
        String str4;
        int i;
        String str5;
        String str6;
        FeedTag feedTag;
        Long l;
        PriceInfo priceInfo;
        ItemTags itemTags;
        String str7;
        String str8;
        String str9;
        Boolean bool2;
        String str10;
        String str11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            PriceInfo priceInfo2 = (PriceInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, PriceInfo$$serializer.INSTANCE, (Object) null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            ReportInfo reportInfo2 = (ReportInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ReportInfo$$serializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            i = 16383;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            feedTag = (FeedTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FeedTag$$serializer.INSTANCE, (Object) null);
            itemTags = (ItemTags) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ItemTags$$serializer.INSTANCE, (Object) null);
            priceInfo = priceInfo2;
            reportInfo = reportInfo2;
            str = str12;
        } else {
            boolean z = true;
            Boolean bool3 = null;
            String str13 = null;
            String str14 = null;
            ReportInfo reportInfo3 = null;
            String str15 = null;
            String str16 = null;
            PriceInfo priceInfo3 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            FeedTag feedTag2 = null;
            ItemTags itemTags2 = null;
            Long l2 = null;
            int i2 = 0;
            String str20 = null;
            while (z) {
                String str21 = str13;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        bool2 = bool3;
                        str10 = str14;
                        str11 = str21;
                        z = false;
                        str13 = str11;
                        str14 = str10;
                        bool3 = bool2;
                        break;
                    case 0:
                        bool2 = bool3;
                        str10 = str14;
                        str11 = str21;
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l2);
                        i2 |= 1;
                        str13 = str11;
                        str14 = str10;
                        bool3 = bool2;
                        break;
                    case 1:
                        bool2 = bool3;
                        str10 = str14;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str21);
                        i2 |= 2;
                        str14 = str10;
                        bool3 = bool2;
                        break;
                    case 2:
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str20);
                        i2 |= 4;
                        bool3 = bool3;
                        str13 = str21;
                        break;
                    case 3:
                        str9 = str20;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str14);
                        i2 |= 8;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 4:
                        str9 = str20;
                        itemTags2 = (ItemTags) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ItemTags$$serializer.INSTANCE, itemTags2);
                        i2 |= 16;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 5:
                        str9 = str20;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str18);
                        i2 |= 32;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 6:
                        str9 = str20;
                        feedTag2 = (FeedTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FeedTag$$serializer.INSTANCE, feedTag2);
                        i2 |= 64;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 7:
                        str9 = str20;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str17);
                        i2 |= 128;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 8:
                        str9 = str20;
                        priceInfo3 = (PriceInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, PriceInfo$$serializer.INSTANCE, priceInfo3);
                        i2 |= 256;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 9:
                        str9 = str20;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str16);
                        i2 |= 512;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case 10:
                        str9 = str20;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str19);
                        i2 |= 1024;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str9 = str20;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str15);
                        i2 |= 2048;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        str9 = str20;
                        reportInfo3 = (ReportInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ReportInfo$$serializer.INSTANCE, reportInfo3);
                        i2 |= 4096;
                        str13 = str21;
                        str20 = str9;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str9 = str20;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 8192;
                        str13 = str21;
                        str20 = str9;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            reportInfo = reportInfo3;
            str = str15;
            str2 = str19;
            str3 = str13;
            bool = bool3;
            str4 = str20;
            i = i2;
            str5 = str17;
            str6 = str18;
            feedTag = feedTag2;
            l = l2;
            priceInfo = priceInfo3;
            itemTags = itemTags2;
            str7 = str16;
            str8 = str14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MallRecommendItem(i, l, str3, str4, str8, itemTags, str6, feedTag, str5, priceInfo, str7, str2, str, reportInfo, bool, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, MallRecommendItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MallRecommendItem.write$Self$mallDynamicPage_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}