package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CrowdfundingStairsFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor.ActivityInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CrowdfundingStairsFloor$ActivityInfo$$serializer implements GeneratedSerializer<CrowdfundingStairsFloor.ActivityInfo> {
    public static final int $stable;
    public static final CrowdfundingStairsFloor$ActivityInfo$$serializer INSTANCE = new CrowdfundingStairsFloor$ActivityInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor.ActivityInfo", INSTANCE, 12);
        pluginGeneratedSerialDescriptor.addElement("activityUrl", true);
        pluginGeneratedSerialDescriptor.addElement("hasActivity", true);
        pluginGeneratedSerialDescriptor.addElement("isJoined", true);
        pluginGeneratedSerialDescriptor.addElement("preheatTime", true);
        pluginGeneratedSerialDescriptor.addElement("prizeImg", true);
        pluginGeneratedSerialDescriptor.addElement("publishTime", true);
        pluginGeneratedSerialDescriptor.addElement("publishTimeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("status", true);
        pluginGeneratedSerialDescriptor.addElement("taskId", true);
        pluginGeneratedSerialDescriptor.addElement("waitLotteryNums", true);
        pluginGeneratedSerialDescriptor.addElement("waitLotteryRoundNums", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CrowdfundingStairsFloor$ActivityInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final CrowdfundingStairsFloor.ActivityInfo deserialize(Decoder decoder) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        String str;
        String str2;
        String str3;
        Integer num5;
        Boolean bool;
        Integer num6;
        Boolean bool2;
        String str4;
        int i;
        Boolean bool3;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            i = 4095;
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, (Object) null);
            num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
        } else {
            String str6 = null;
            Boolean bool4 = null;
            Integer num7 = null;
            String str7 = null;
            Integer num8 = null;
            Integer num9 = null;
            Integer num10 = null;
            Integer num11 = null;
            String str8 = null;
            String str9 = null;
            boolean z = true;
            Integer num12 = null;
            int i2 = 0;
            Boolean bool5 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        bool3 = bool4;
                        z = false;
                        bool4 = bool3;
                        break;
                    case 0:
                        bool3 = bool4;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str6);
                        i2 |= 1;
                        bool4 = bool3;
                        break;
                    case 1:
                        str5 = str6;
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool4);
                        i2 |= 2;
                        str6 = str5;
                        break;
                    case 2:
                        str5 = str6;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool5);
                        i2 |= 4;
                        str6 = str5;
                        break;
                    case 3:
                        str5 = str6;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num12);
                        i2 |= 8;
                        str6 = str5;
                        break;
                    case 4:
                        str5 = str6;
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str9);
                        i2 |= 16;
                        str6 = str5;
                        break;
                    case 5:
                        str5 = str6;
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num10);
                        i2 |= 32;
                        str6 = str5;
                        break;
                    case 6:
                        str5 = str6;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str8);
                        i2 |= 64;
                        str6 = str5;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str5 = str6;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, num9);
                        i2 |= 128;
                        str6 = str5;
                        break;
                    case 8:
                        str5 = str6;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num8);
                        i2 |= 256;
                        str6 = str5;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str5 = str6;
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str7);
                        i2 |= 512;
                        str6 = str5;
                        break;
                    case 10:
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num11);
                        i2 |= 1024;
                        str6 = str6;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str5 = str6;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num7);
                        i2 |= 2048;
                        str6 = str5;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num7;
            num2 = num8;
            num3 = num11;
            num4 = num12;
            str = str6;
            str2 = str8;
            str3 = str9;
            num5 = num10;
            bool = bool5;
            num6 = num9;
            bool2 = bool4;
            str4 = str7;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CrowdfundingStairsFloor.ActivityInfo(i, str, bool2, bool, num4, str3, num5, str2, num6, num2, str4, num3, num, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CrowdfundingStairsFloor.ActivityInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CrowdfundingStairsFloor.ActivityInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}