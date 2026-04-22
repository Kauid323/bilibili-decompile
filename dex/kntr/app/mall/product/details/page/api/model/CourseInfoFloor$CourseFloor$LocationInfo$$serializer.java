package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.model.CourseInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
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

/* compiled from: CourseInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CourseInfoFloor.CourseFloor.LocationInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CourseInfoFloor$CourseFloor$LocationInfo$$serializer implements GeneratedSerializer<CourseInfoFloor.CourseFloor.LocationInfo> {
    public static final int $stable;
    public static final CourseInfoFloor$CourseFloor$LocationInfo$$serializer INSTANCE = new CourseInfoFloor$CourseFloor$LocationInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CourseInfoFloor.CourseFloor.LocationInfo", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("chapterId", true);
        pluginGeneratedSerialDescriptor.addElement("couldPreview", true);
        pluginGeneratedSerialDescriptor.addElement("courseId", true);
        pluginGeneratedSerialDescriptor.addElement("hasWatchRight", true);
        pluginGeneratedSerialDescriptor.addElement("itemId", true);
        pluginGeneratedSerialDescriptor.addElement("lastWatchTime", true);
        pluginGeneratedSerialDescriptor.addElement("lessonId", true);
        pluginGeneratedSerialDescriptor.addElement("sectionId", true);
        pluginGeneratedSerialDescriptor.addElement("videoUrl", true);
        pluginGeneratedSerialDescriptor.addElement("watchProcess", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CourseInfoFloor$CourseFloor$LocationInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    public final CourseInfoFloor.CourseFloor.LocationInfo deserialize(Decoder decoder) {
        Long l;
        String str;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        int i;
        Boolean bool;
        Long l6;
        Long l7;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 9;
        Long l8 = null;
        if (beginStructure.decodeSequentially()) {
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, LongSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, (Object) null);
            l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
            l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, (Object) null);
            i = 1023;
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, (Object) null);
            l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i3 = 0;
            Long l9 = null;
            String str2 = null;
            Long l10 = null;
            Long l11 = null;
            Long l12 = null;
            Long l13 = null;
            Boolean bool3 = null;
            Long l14 = null;
            Boolean bool4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        break;
                    case 0:
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l8);
                        i3 |= 1;
                        i2 = 9;
                        break;
                    case 1:
                        bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 2;
                        i2 = 9;
                        break;
                    case 2:
                        l14 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l14);
                        i3 |= 4;
                        i2 = 9;
                        break;
                    case 3:
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool3);
                        i3 |= 8;
                        i2 = 9;
                        break;
                    case 4:
                        l13 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l13);
                        i3 |= 16;
                        i2 = 9;
                        break;
                    case 5:
                        l11 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l11);
                        i3 |= 32;
                        i2 = 9;
                        break;
                    case 6:
                        l12 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l12);
                        i3 |= 64;
                        i2 = 9;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        l10 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, l10);
                        i3 |= 128;
                        i2 = 9;
                        break;
                    case 8:
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str2);
                        i3 |= 256;
                        i2 = 9;
                        continue;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, LongSerializer.INSTANCE, l9);
                        i3 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            l = l9;
            str = str2;
            l2 = l10;
            l3 = l11;
            l4 = l12;
            l5 = l13;
            i = i3;
            Boolean bool5 = bool4;
            bool = bool3;
            l6 = l8;
            l7 = l14;
            bool2 = bool5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CourseInfoFloor.CourseFloor.LocationInfo(i, l6, bool2, l7, bool, l5, l3, l4, l2, str, l, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CourseInfoFloor.CourseFloor.LocationInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CourseInfoFloor.CourseFloor.LocationInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}