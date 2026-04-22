package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.UpMeasureFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UpMeasureFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/UpMeasureFloor.ContentVO.ContentDetailVO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$ContentDetailVO;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class UpMeasureFloor$ContentVO$ContentDetailVO$$serializer implements GeneratedSerializer<UpMeasureFloor.ContentVO.ContentDetailVO> {
    public static final int $stable;
    public static final UpMeasureFloor$ContentVO$ContentDetailVO$$serializer INSTANCE = new UpMeasureFloor$ContentVO$ContentDetailVO$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.UpMeasureFloor.ContentVO.ContentDetailVO", INSTANCE, 19);
        pluginGeneratedSerialDescriptor.addElement("bvId", true);
        pluginGeneratedSerialDescriptor.addElement("contentType", true);
        pluginGeneratedSerialDescriptor.addElement("ctime", true);
        pluginGeneratedSerialDescriptor.addElement("ctimeStr", true);
        pluginGeneratedSerialDescriptor.addElement(AppKey.UID, true);
        pluginGeneratedSerialDescriptor.addElement("upIcon", true);
        pluginGeneratedSerialDescriptor.addElement("upName", true);
        pluginGeneratedSerialDescriptor.addElement("upPic", true);
        pluginGeneratedSerialDescriptor.addElement("upRole", true);
        pluginGeneratedSerialDescriptor.addElement("upRoleTitle", true);
        pluginGeneratedSerialDescriptor.addElement("upRoleType", true);
        pluginGeneratedSerialDescriptor.addElement("videoDuration", true);
        pluginGeneratedSerialDescriptor.addElement("videoDurationStr", true);
        pluginGeneratedSerialDescriptor.addElement("videoImg", true);
        pluginGeneratedSerialDescriptor.addElement("videoTitle", true);
        pluginGeneratedSerialDescriptor.addElement("videoUrl", true);
        pluginGeneratedSerialDescriptor.addElement("videoView", true);
        pluginGeneratedSerialDescriptor.addElement("videoViewIcon", true);
        pluginGeneratedSerialDescriptor.addElement("videoViewStr", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private UpMeasureFloor$ContentVO$ContentDetailVO$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final UpMeasureFloor.ContentVO.ContentDetailVO deserialize(Decoder decoder) {
        Integer num;
        String str;
        Long l;
        String str2;
        Integer num2;
        String str3;
        String str4;
        String str5;
        Long l2;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Integer num3;
        int i;
        Integer num4;
        String str12;
        String str13;
        String str14;
        int i2;
        String str15;
        String str16;
        String str17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            Long l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, LongSerializer.INSTANCE, (Object) null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str11 = str22;
            num3 = num5;
            str12 = str21;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, (Object) null);
            i = 524287;
            str8 = str20;
            l = l3;
            str9 = str19;
            str = str18;
        } else {
            boolean z = true;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            Integer num6 = null;
            String str26 = null;
            String str27 = null;
            Integer num7 = null;
            String str28 = null;
            Long l4 = null;
            String str29 = null;
            Integer num8 = null;
            String str30 = null;
            String str31 = null;
            Integer num9 = null;
            String str32 = null;
            String str33 = null;
            Long l5 = null;
            String str34 = null;
            int i3 = 0;
            String str35 = null;
            while (z) {
                String str36 = str26;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        z = false;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 0:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str31);
                        i3 |= 1;
                        num9 = num9;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 1:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num9);
                        i3 |= 2;
                        str32 = str32;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 2:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str32);
                        i3 |= 4;
                        str33 = str33;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 3:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str33);
                        i3 |= 8;
                        l5 = l5;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 4:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l5);
                        i3 |= 16;
                        str34 = str34;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 5:
                        str15 = str23;
                        str16 = str24;
                        str17 = str36;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str34);
                        i3 |= 32;
                        str26 = str17;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case 6:
                        str15 = str23;
                        str16 = str24;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str36);
                        i3 |= 64;
                        str24 = str16;
                        str23 = str15;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str30);
                        i3 |= 128;
                        str23 = str23;
                        str26 = str36;
                        break;
                    case 8:
                        str14 = str30;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num8);
                        i3 |= 256;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str14 = str30;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str29);
                        i3 |= 512;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 10:
                        str14 = str30;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num6);
                        i3 |= 1024;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str14 = str30;
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, LongSerializer.INSTANCE, l4);
                        i3 |= 2048;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 12:
                        str14 = str30;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str28);
                        i3 |= 4096;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 13:
                        str14 = str30;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str23);
                        i3 |= 8192;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str14 = str30;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str24);
                        i3 |= 16384;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 15:
                        str14 = str30;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str35);
                        i2 = 32768;
                        i3 |= i2;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 16:
                        str14 = str30;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, num7);
                        i2 = 65536;
                        i3 |= i2;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 17:
                        str14 = str30;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str27);
                        i2 = 131072;
                        i3 |= i2;
                        str26 = str36;
                        str30 = str14;
                        break;
                    case 18:
                        str14 = str30;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str25);
                        i2 = 262144;
                        i3 |= i2;
                        str26 = str36;
                        str30 = str14;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num6;
            str = str28;
            l = l4;
            str2 = str29;
            num2 = num8;
            str3 = str30;
            str4 = str32;
            str5 = str33;
            l2 = l5;
            str6 = str34;
            str7 = str26;
            str8 = str24;
            str9 = str23;
            str10 = str25;
            str11 = str27;
            num3 = num7;
            i = i3;
            num4 = num9;
            str12 = str35;
            str13 = str31;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UpMeasureFloor.ContentVO.ContentDetailVO(i, str13, num4, str4, str5, l2, str6, str7, str3, num2, str2, num, l, str, str9, str8, str12, num3, str11, str10, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, UpMeasureFloor.ContentVO.ContentDetailVO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UpMeasureFloor.ContentVO.ContentDetailVO.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}