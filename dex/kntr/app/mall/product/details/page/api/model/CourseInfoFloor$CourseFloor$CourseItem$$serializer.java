package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.CourseInfoFloor;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CourseInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CourseInfoFloor.CourseFloor.CourseItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$CourseItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CourseInfoFloor$CourseFloor$CourseItem$$serializer implements GeneratedSerializer<CourseInfoFloor.CourseFloor.CourseItem> {
    public static final int $stable;
    public static final CourseInfoFloor$CourseFloor$CourseItem$$serializer INSTANCE = new CourseInfoFloor$CourseFloor$CourseItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CourseInfoFloor.CourseFloor.CourseItem", INSTANCE, 16);
        pluginGeneratedSerialDescriptor.addElement("chapterId", true);
        pluginGeneratedSerialDescriptor.addElement("couldPreview", true);
        pluginGeneratedSerialDescriptor.addElement("hasWatchRight", true);
        pluginGeneratedSerialDescriptor.addElement("itemUrl", true);
        pluginGeneratedSerialDescriptor.addElement("lastWatchTime", true);
        pluginGeneratedSerialDescriptor.addElement("lastWatchTimeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("lessonId", true);
        pluginGeneratedSerialDescriptor.addElement("needReport", true);
        pluginGeneratedSerialDescriptor.addElement("previewDesc", true);
        pluginGeneratedSerialDescriptor.addElement("sectionId", true);
        pluginGeneratedSerialDescriptor.addElement("sectionIndex", true);
        pluginGeneratedSerialDescriptor.addElement("sectionName", true);
        pluginGeneratedSerialDescriptor.addElement("videoTime", true);
        pluginGeneratedSerialDescriptor.addElement("videoTimeDesc", true);
        pluginGeneratedSerialDescriptor.addElement("videoUrl", true);
        pluginGeneratedSerialDescriptor.addElement("watchStatus", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CourseInfoFloor$CourseFloor$CourseItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final CourseInfoFloor.CourseFloor.CourseItem deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        Long l;
        String str3;
        Boolean bool;
        Integer num;
        Boolean bool2;
        Boolean bool3;
        String str4;
        String str5;
        String str6;
        Long l2;
        Long l3;
        Integer num2;
        Long l4;
        Long l5;
        Long l6;
        String str7;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            Long l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, LongSerializer.INSTANCE, (Object) null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            i = 65535;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, (Object) null);
            str5 = str11;
            str6 = str10;
            l4 = l7;
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            String str12 = null;
            String str13 = null;
            Long l8 = null;
            Long l9 = null;
            String str14 = null;
            Long l10 = null;
            String str15 = null;
            Long l11 = null;
            String str16 = null;
            Boolean bool4 = null;
            str = null;
            Integer num3 = null;
            Long l12 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            i = 0;
            Integer num4 = null;
            while (z) {
                String str17 = str14;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str7 = str12;
                        str8 = str13;
                        str9 = str17;
                        z = false;
                        str14 = str9;
                        str13 = str8;
                        str12 = str7;
                        break;
                    case 0:
                        str7 = str12;
                        str8 = str13;
                        str9 = str17;
                        l12 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l12);
                        i |= 1;
                        bool5 = bool5;
                        str14 = str9;
                        str13 = str8;
                        str12 = str7;
                        break;
                    case 1:
                        str7 = str12;
                        str8 = str13;
                        str9 = str17;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool5);
                        i |= 2;
                        bool6 = bool6;
                        str14 = str9;
                        str13 = str8;
                        str12 = str7;
                        break;
                    case 2:
                        str7 = str12;
                        str8 = str13;
                        str9 = str17;
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool6);
                        i |= 4;
                        str14 = str9;
                        str13 = str8;
                        str12 = str7;
                        break;
                    case 3:
                        str7 = str12;
                        str8 = str13;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str17);
                        i |= 8;
                        str13 = str8;
                        str12 = str7;
                        break;
                    case 4:
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l9);
                        i |= 16;
                        str12 = str12;
                        str14 = str17;
                        break;
                    case 5:
                        l6 = l9;
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str);
                        i |= 32;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case 6:
                        l6 = l9;
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l8);
                        i |= 64;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        l6 = l9;
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, bool4);
                        i |= 128;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case 8:
                        l6 = l9;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str16);
                        i |= 256;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        l6 = l9;
                        l11 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, l11);
                        i |= 512;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case 10:
                        l6 = l9;
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num3);
                        i |= 1024;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        l6 = l9;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str15);
                        i |= 2048;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case 12:
                        l6 = l9;
                        l10 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, LongSerializer.INSTANCE, l10);
                        i |= 4096;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case 13:
                        l6 = l9;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str12);
                        i |= 8192;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        l6 = l9;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str13);
                        i |= 16384;
                        str14 = str17;
                        l9 = l6;
                        break;
                    case 15:
                        l6 = l9;
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, num4);
                        i |= 32768;
                        str14 = str17;
                        l9 = l6;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str2 = str15;
            l = l11;
            str3 = str16;
            bool = bool4;
            num = num3;
            bool2 = bool5;
            bool3 = bool6;
            str4 = str14;
            str5 = str13;
            str6 = str12;
            l2 = l8;
            l3 = l9;
            num2 = num4;
            l4 = l10;
            l5 = l12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CourseInfoFloor.CourseFloor.CourseItem(i, l5, bool2, bool3, str4, l3, str, l2, bool, str3, l, num, str2, l4, str6, str5, num2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CourseInfoFloor.CourseFloor.CourseItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CourseInfoFloor.CourseFloor.CourseItem.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}