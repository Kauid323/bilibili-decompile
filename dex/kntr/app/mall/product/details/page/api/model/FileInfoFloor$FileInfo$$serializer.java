package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
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

/* compiled from: FileInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/FileInfoFloor.FileInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class FileInfoFloor$FileInfo$$serializer implements GeneratedSerializer<FileInfoFloor.FileInfo> {
    public static final int $stable;
    public static final FileInfoFloor$FileInfo$$serializer INSTANCE = new FileInfoFloor$FileInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.FileInfoFloor.FileInfo", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("endRow", true);
        pluginGeneratedSerialDescriptor.addElement("hasNextPage", true);
        pluginGeneratedSerialDescriptor.addElement("hasPreviousPage", true);
        pluginGeneratedSerialDescriptor.addElement("isFirstPage", true);
        pluginGeneratedSerialDescriptor.addElement("isLastPage", true);
        pluginGeneratedSerialDescriptor.addElement("list", true);
        pluginGeneratedSerialDescriptor.addElement("navigateFirstPage", true);
        pluginGeneratedSerialDescriptor.addElement("navigateLastPage", true);
        pluginGeneratedSerialDescriptor.addElement("navigatePages", true);
        pluginGeneratedSerialDescriptor.addElement("navigatepageNums", true);
        pluginGeneratedSerialDescriptor.addElement("nextPage", true);
        pluginGeneratedSerialDescriptor.addElement("pageNum", true);
        pluginGeneratedSerialDescriptor.addElement("pageSize", true);
        pluginGeneratedSerialDescriptor.addElement("pages", true);
        pluginGeneratedSerialDescriptor.addElement("prePage", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("startRow", true);
        pluginGeneratedSerialDescriptor.addElement("total", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private FileInfoFloor$FileInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = FileInfoFloor.FileInfo.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    public final FileInfoFloor.FileInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Integer num;
        Long l;
        Integer num2;
        Long l2;
        Integer num3;
        Boolean bool;
        Integer num4;
        Integer num5;
        int i;
        Long l3;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Integer num6;
        Integer num7;
        List list;
        Integer num8;
        Integer num9;
        List list2;
        Integer num10;
        int i2;
        Lazy[] lazyArr2;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = FileInfoFloor.FileInfo.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Integer num16 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, (Object) null);
            Integer num17 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, (Object) null);
            Integer num18 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, (Object) null);
            Integer num19 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, (Object) null);
            Integer num20 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, (Object) null);
            Long l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, LongSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, LongSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), (Object) null);
            num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, (Object) null);
            num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, (Object) null);
            l2 = l4;
            num4 = num20;
            num5 = num19;
            num = num18;
            num9 = num17;
            num3 = num16;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, (Object) null);
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, (Object) null);
            bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, (Object) null);
            i = 262143;
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            Integer num21 = null;
            Integer num22 = null;
            Integer num23 = null;
            Long l5 = null;
            Integer num24 = null;
            Integer num25 = null;
            Integer num26 = null;
            List list3 = null;
            Integer num27 = null;
            Long l6 = null;
            Integer num28 = null;
            Long l7 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            Boolean bool7 = null;
            Boolean bool8 = null;
            List list4 = null;
            int i3 = 0;
            Integer num29 = null;
            while (z) {
                Integer num30 = num28;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        lazyArr2 = lazyArr;
                        num11 = num22;
                        num12 = num25;
                        num13 = num30;
                        z = false;
                        num28 = num13;
                        lazyArr = lazyArr2;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case 0:
                        lazyArr2 = lazyArr;
                        num11 = num22;
                        num12 = num25;
                        num13 = num30;
                        l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l7);
                        i3 |= 1;
                        num21 = num21;
                        bool5 = bool5;
                        num28 = num13;
                        lazyArr = lazyArr2;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case 1:
                        lazyArr2 = lazyArr;
                        num11 = num22;
                        num12 = num25;
                        num13 = num30;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 2;
                        num21 = num21;
                        bool6 = bool6;
                        num28 = num13;
                        lazyArr = lazyArr2;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case 2:
                        lazyArr2 = lazyArr;
                        num11 = num22;
                        num12 = num25;
                        num13 = num30;
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 4;
                        num21 = num21;
                        bool7 = bool7;
                        num28 = num13;
                        lazyArr = lazyArr2;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case 3:
                        lazyArr2 = lazyArr;
                        num11 = num22;
                        num12 = num25;
                        num13 = num30;
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool7);
                        i3 |= 8;
                        num21 = num21;
                        num28 = num13;
                        lazyArr = lazyArr2;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case 4:
                        num11 = num22;
                        bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, bool8);
                        i3 |= 16;
                        num21 = num21;
                        lazyArr = lazyArr;
                        num25 = num25;
                        num28 = num30;
                        num22 = num11;
                        break;
                    case 5:
                        num14 = num21;
                        num11 = num22;
                        num12 = num25;
                        num15 = num30;
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list4);
                        i3 |= 32;
                        num28 = num15;
                        num21 = num14;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case 6:
                        num14 = num21;
                        num11 = num22;
                        num12 = num25;
                        num15 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num30);
                        i3 |= 64;
                        num28 = num15;
                        num21 = num14;
                        num25 = num12;
                        num22 = num11;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        num25 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, num25);
                        i3 |= 128;
                        num21 = num21;
                        num22 = num22;
                        num28 = num30;
                        break;
                    case 8:
                        num10 = num25;
                        num27 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num27);
                        i3 |= 256;
                        num21 = num21;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        num10 = num25;
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list3);
                        i3 |= 512;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case 10:
                        num10 = num25;
                        num23 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num23);
                        i3 |= 1024;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        num10 = num25;
                        num24 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num24);
                        i3 |= 2048;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case 12:
                        num10 = num25;
                        num21 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, num21);
                        i3 |= 4096;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case 13:
                        num10 = num25;
                        num22 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, num22);
                        i3 |= 8192;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        num10 = num25;
                        num29 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, num29);
                        i3 |= 16384;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case 15:
                        num10 = num25;
                        num26 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, num26);
                        i2 = 32768;
                        i3 |= i2;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case 16:
                        num10 = num25;
                        l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, LongSerializer.INSTANCE, l5);
                        i2 = 65536;
                        i3 |= i2;
                        num28 = num30;
                        num25 = num10;
                        break;
                    case 17:
                        num10 = num25;
                        l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, LongSerializer.INSTANCE, l6);
                        i2 = 131072;
                        i3 |= i2;
                        num28 = num30;
                        num25 = num10;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num22;
            Boolean bool9 = bool5;
            l = l7;
            num2 = num23;
            l2 = l5;
            num3 = num24;
            bool = bool8;
            num4 = num26;
            num5 = num29;
            i = i3;
            l3 = l6;
            bool2 = bool9;
            bool3 = bool6;
            bool4 = bool7;
            num6 = num28;
            num7 = num25;
            list = list3;
            num8 = num27;
            num9 = num21;
            list2 = list4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new FileInfoFloor.FileInfo(i, l, bool2, bool3, bool4, bool, list2, num6, num7, num8, list, num2, num3, num9, num, num5, num4, l2, l3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, FileInfoFloor.FileInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        FileInfoFloor.FileInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}