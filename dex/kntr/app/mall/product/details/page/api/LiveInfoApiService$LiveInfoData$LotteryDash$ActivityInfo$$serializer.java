package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LiveInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer implements GeneratedSerializer<LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo> {
    public static final int $stable;
    public static final LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer INSTANCE = new LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo", INSTANCE, 15);
        pluginGeneratedSerialDescriptor.addElement("activityTimeText", true);
        pluginGeneratedSerialDescriptor.addElement("buyTimeText", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("isSubmitted", true);
        pluginGeneratedSerialDescriptor.addElement("joinCnt", true);
        pluginGeneratedSerialDescriptor.addElement("joinList", true);
        pluginGeneratedSerialDescriptor.addElement("maxBuyTime", true);
        pluginGeneratedSerialDescriptor.addElement("publishTime", true);
        pluginGeneratedSerialDescriptor.addElement("publishTimeText", true);
        pluginGeneratedSerialDescriptor.addElement("ruleUrl", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("taskId", true);
        pluginGeneratedSerialDescriptor.addElement("taskStatus", true);
        pluginGeneratedSerialDescriptor.addElement("totalWinnerCount", true);
        pluginGeneratedSerialDescriptor.addElement("winnerCount", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        Integer num;
        Integer num2;
        String str;
        String str2;
        Integer num3;
        Integer num4;
        String str3;
        Integer num5;
        String str4;
        Integer num6;
        String str5;
        List list;
        Boolean bool;
        String str6;
        Integer num7;
        Integer num8;
        String str7;
        Lazy[] lazyArr2;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, (Object) null);
            i = 32767;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            num7 = num9;
            str4 = str9;
            str5 = str8;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            String str10 = null;
            Integer num10 = null;
            Integer num11 = null;
            Integer num12 = null;
            Boolean bool3 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            List list2 = null;
            Integer num13 = null;
            Integer num14 = null;
            String str14 = null;
            String str15 = null;
            Integer num15 = null;
            i = 0;
            Integer num16 = null;
            while (z) {
                Boolean bool4 = bool3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str7 = str10;
                        lazyArr2 = lazyArr;
                        bool2 = bool4;
                        z = false;
                        bool3 = bool2;
                        lazyArr = lazyArr2;
                        str10 = str7;
                        break;
                    case 0:
                        str7 = str10;
                        lazyArr2 = lazyArr;
                        bool2 = bool4;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str14);
                        i |= 1;
                        num11 = num11;
                        str15 = str15;
                        bool3 = bool2;
                        lazyArr = lazyArr2;
                        str10 = str7;
                        break;
                    case 1:
                        str7 = str10;
                        lazyArr2 = lazyArr;
                        bool2 = bool4;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str15);
                        i |= 2;
                        num11 = num11;
                        num15 = num15;
                        bool3 = bool2;
                        lazyArr = lazyArr2;
                        str10 = str7;
                        break;
                    case 2:
                        str7 = str10;
                        lazyArr2 = lazyArr;
                        bool2 = bool4;
                        num15 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num15);
                        i |= 4;
                        num11 = num11;
                        bool3 = bool2;
                        lazyArr = lazyArr2;
                        str10 = str7;
                        break;
                    case 3:
                        str7 = str10;
                        i |= 8;
                        num11 = num11;
                        lazyArr = lazyArr;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool4);
                        str10 = str7;
                        break;
                    case 4:
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num11);
                        i |= 16;
                        str10 = str10;
                        bool3 = bool4;
                        break;
                    case 5:
                        num8 = num11;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list2);
                        i |= 32;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case 6:
                        num8 = num11;
                        num14 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num14);
                        i |= 64;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        num8 = num11;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, num12);
                        i |= 128;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case 8:
                        num8 = num11;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str13);
                        i |= 256;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        num8 = num11;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str12);
                        i |= 512;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case 10:
                        num8 = num11;
                        num13 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num13);
                        i |= 1024;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        num8 = num11;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str11);
                        i |= 2048;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case 12:
                        num8 = num11;
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str10);
                        i |= 4096;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case 13:
                        num8 = num11;
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, num10);
                        i |= 8192;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        num8 = num11;
                        num16 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, num16);
                        i |= 16384;
                        bool3 = bool4;
                        num11 = num8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num12;
            num2 = num16;
            str = str12;
            str2 = str13;
            num3 = num13;
            num4 = num14;
            str3 = str15;
            num5 = num15;
            str4 = str10;
            num6 = num11;
            str5 = str11;
            list = list2;
            bool = bool3;
            str6 = str14;
            num7 = num10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo(i, str6, str3, num5, bool, num6, list, num4, num, str2, str, num3, str5, str4, num7, num2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}