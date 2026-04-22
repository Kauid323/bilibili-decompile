package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CourseInfoFloor;
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

/* compiled from: CourseInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CourseInfoFloor.CourseFloor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CourseInfoFloor$CourseFloor$$serializer implements GeneratedSerializer<CourseInfoFloor.CourseFloor> {
    public static final int $stable;
    public static final CourseInfoFloor$CourseFloor$$serializer INSTANCE = new CourseInfoFloor$CourseFloor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CourseInfoFloor.CourseFloor", INSTANCE, 14);
        pluginGeneratedSerialDescriptor.addElement("banPageDesc", true);
        pluginGeneratedSerialDescriptor.addElement("courseId", true);
        pluginGeneratedSerialDescriptor.addElement("courseList", true);
        pluginGeneratedSerialDescriptor.addElement("courseName", true);
        pluginGeneratedSerialDescriptor.addElement("courseStatus", true);
        pluginGeneratedSerialDescriptor.addElement("customerServiceLink", true);
        pluginGeneratedSerialDescriptor.addElement("hasBought", true);
        pluginGeneratedSerialDescriptor.addElement("itemId", true);
        pluginGeneratedSerialDescriptor.addElement("learnedSectionCount", true);
        pluginGeneratedSerialDescriptor.addElement("lessonId", true);
        pluginGeneratedSerialDescriptor.addElement("locationInfo", true);
        pluginGeneratedSerialDescriptor.addElement("mid", true);
        pluginGeneratedSerialDescriptor.addElement("previewSectionIds", true);
        pluginGeneratedSerialDescriptor.addElement("sectionCount", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CourseInfoFloor$CourseFloor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CourseInfoFloor.CourseFloor.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CourseInfoFloor$CourseFloor$LocationInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[12].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    public final CourseInfoFloor.CourseFloor deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Long l;
        Long l2;
        Integer num;
        CourseInfoFloor.CourseFloor.LocationInfo locationInfo;
        Long l3;
        Integer num2;
        String str;
        Integer num3;
        int i;
        Boolean bool;
        String str2;
        String str3;
        List list;
        Long l4;
        List list2;
        List list3;
        String str4;
        Integer num4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CourseInfoFloor.CourseFloor.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            locationInfo = (CourseInfoFloor.CourseFloor.LocationInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, CourseInfoFloor$CourseFloor$LocationInfo$$serializer.INSTANCE, (Object) null);
            Long l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, LongSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, (Object) null);
            l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, (Object) null);
            l = l5;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, (Object) null);
            i = 16383;
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
        } else {
            List list4 = null;
            Integer num5 = null;
            Integer num6 = null;
            Long l6 = null;
            Long l7 = null;
            Integer num7 = null;
            Long l8 = null;
            String str6 = null;
            CourseInfoFloor.CourseFloor.LocationInfo locationInfo2 = null;
            Boolean bool2 = null;
            String str7 = null;
            Long l9 = null;
            boolean z = true;
            int i2 = 0;
            List list5 = null;
            String str8 = null;
            while (z) {
                List list6 = list5;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        list5 = list6;
                        z = false;
                        list4 = list4;
                        lazyArr = lazyArr;
                        str8 = str8;
                        break;
                    case 0:
                        num4 = num5;
                        str5 = str8;
                        list5 = list6;
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str7);
                        i2 |= 1;
                        list4 = list4;
                        lazyArr = lazyArr;
                        str8 = str5;
                        num5 = num4;
                        break;
                    case 1:
                        num4 = num5;
                        list5 = list6;
                        str5 = str8;
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l9);
                        i2 |= 2;
                        list4 = list4;
                        str8 = str5;
                        num5 = num4;
                        break;
                    case 2:
                        num4 = num5;
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list6);
                        i2 |= 4;
                        str8 = str8;
                        list4 = list4;
                        num5 = num4;
                        break;
                    case 3:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str8);
                        i2 |= 8;
                        list4 = list4;
                        num5 = num5;
                        list5 = list6;
                        break;
                    case 4:
                        list3 = list4;
                        str4 = str8;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num6);
                        i2 |= 16;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case 5:
                        list3 = list4;
                        str4 = str8;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str6);
                        i2 |= 32;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case 6:
                        list3 = list4;
                        str4 = str8;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, bool2);
                        i2 |= 64;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        list3 = list4;
                        str4 = str8;
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, l8);
                        i2 |= 128;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case 8:
                        list3 = list4;
                        str4 = str8;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num7);
                        i2 |= 256;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        list3 = list4;
                        str4 = str8;
                        l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, l7);
                        i2 |= 512;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case 10:
                        list3 = list4;
                        str4 = str8;
                        locationInfo2 = (CourseInfoFloor.CourseFloor.LocationInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, CourseInfoFloor$CourseFloor$LocationInfo$$serializer.INSTANCE, locationInfo2);
                        i2 |= 1024;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str4 = str8;
                        list3 = list4;
                        l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, LongSerializer.INSTANCE, l6);
                        i2 |= 2048;
                        list4 = list3;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case 12:
                        str4 = str8;
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), list4);
                        i2 |= 4096;
                        list5 = list6;
                        str8 = str4;
                        break;
                    case 13:
                        str4 = str8;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, num5);
                        i2 |= 8192;
                        list5 = list6;
                        str8 = str4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str9 = str8;
            l = l6;
            l2 = l7;
            num = num7;
            locationInfo = locationInfo2;
            l3 = l9;
            num2 = num5;
            str = str7;
            num3 = num6;
            i = i2;
            bool = bool2;
            str2 = str6;
            str3 = str9;
            list = list4;
            l4 = l8;
            list2 = list5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CourseInfoFloor.CourseFloor(i, str, l3, list2, str3, num3, str2, bool, l4, num, l2, locationInfo, l, list, num2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CourseInfoFloor.CourseFloor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CourseInfoFloor.CourseFloor.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}