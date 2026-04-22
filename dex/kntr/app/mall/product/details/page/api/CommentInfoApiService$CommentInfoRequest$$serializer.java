package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CommentInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/CommentInfoApiService.CommentInfoRequest.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoRequest;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CommentInfoApiService$CommentInfoRequest$$serializer implements GeneratedSerializer<CommentInfoApiService.CommentInfoRequest> {
    public static final int $stable;
    public static final CommentInfoApiService$CommentInfoRequest$$serializer INSTANCE = new CommentInfoApiService$CommentInfoRequest$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoRequest", INSTANCE, 16);
        pluginGeneratedSerialDescriptor.addElement("mid", true);
        pluginGeneratedSerialDescriptor.addElement("autoEssence", true);
        pluginGeneratedSerialDescriptor.addElement("ignoreEssenceIds", true);
        pluginGeneratedSerialDescriptor.addElement("ignoreHotIds", true);
        pluginGeneratedSerialDescriptor.addElement("loginStatue", true);
        pluginGeneratedSerialDescriptor.addElement("pageNum", true);
        pluginGeneratedSerialDescriptor.addElement("pageSize", true);
        pluginGeneratedSerialDescriptor.addElement("rateFactor", true);
        pluginGeneratedSerialDescriptor.addElement("scene", true);
        pluginGeneratedSerialDescriptor.addElement("subPageSize", true);
        pluginGeneratedSerialDescriptor.addElement("subTagId", true);
        pluginGeneratedSerialDescriptor.addElement("subjectId", false);
        pluginGeneratedSerialDescriptor.addElement("subjectType", true);
        pluginGeneratedSerialDescriptor.addElement("tagId", true);
        pluginGeneratedSerialDescriptor.addElement("topicId", true);
        pluginGeneratedSerialDescriptor.addElement("ugcId", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CommentInfoApiService$CommentInfoRequest$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CommentInfoApiService.CommentInfoRequest.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), lazyArr[2].getValue(), lazyArr[3].getValue(), ByteSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    public final CommentInfoApiService.CommentInfoRequest deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        String str;
        List list;
        List list2;
        int i2;
        Long l;
        Long l2;
        int i3;
        String str2;
        int i4;
        int i5;
        long j;
        Long l3;
        Long l4;
        Long l5;
        byte b;
        Integer num;
        byte b2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CommentInfoApiService.CommentInfoRequest.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            byte decodeByteElement = beginStructure.decodeByteElement(serialDescriptor, 4);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 5);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 6);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 8);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 9);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 11);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 12);
            Long l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, LongSerializer.INSTANCE, (Object) null);
            Long l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, LongSerializer.INSTANCE, (Object) null);
            l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, LongSerializer.INSTANCE, (Object) null);
            b = decodeByteElement;
            i2 = decodeIntElement;
            i3 = decodeIntElement2;
            i4 = decodeIntElement3;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str2 = decodeStringElement;
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, LongSerializer.INSTANCE, (Object) null);
            i5 = decodeIntElement4;
            l5 = l7;
            l2 = l6;
            j = decodeLongElement;
            i = 65535;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            list = list3;
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i6 = 0;
            byte b3 = 0;
            int i7 = 0;
            int i8 = 0;
            Long l8 = null;
            String str3 = null;
            List list4 = null;
            List list5 = null;
            Long l9 = null;
            Long l10 = null;
            Long l11 = null;
            Long l12 = null;
            String str4 = null;
            long j2 = 0;
            int i9 = 0;
            Integer num2 = null;
            int i10 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        b2 = b3;
                        l12 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l12);
                        i6 |= 1;
                        b3 = b2;
                        break;
                    case 1:
                        b2 = b3;
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num2);
                        i6 |= 2;
                        b3 = b2;
                        break;
                    case 2:
                        b2 = b3;
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list5);
                        i6 |= 4;
                        b3 = b2;
                        break;
                    case 3:
                        b2 = b3;
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list4);
                        i6 |= 8;
                        b3 = b2;
                        break;
                    case 4:
                        b2 = beginStructure.decodeByteElement(serialDescriptor, 4);
                        i6 |= 16;
                        b3 = b2;
                        break;
                    case 5:
                        i6 |= 32;
                        b3 = b3;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        break;
                    case 6:
                        b2 = b3;
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i6 |= 64;
                        b3 = b2;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        b2 = b3;
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str3);
                        i6 |= 128;
                        b3 = b2;
                        break;
                    case 8:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i6 |= 256;
                        b3 = b3;
                        continue;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 9);
                        i6 |= 512;
                        b3 = b3;
                        break;
                    case 10:
                        b2 = b3;
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, LongSerializer.INSTANCE, l8);
                        i6 |= 1024;
                        b3 = b2;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 11);
                        i6 |= 2048;
                        break;
                    case 12:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i6 |= 4096;
                        break;
                    case 13:
                        l11 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, LongSerializer.INSTANCE, l11);
                        i6 |= 8192;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        l10 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, LongSerializer.INSTANCE, l10);
                        i6 |= 16384;
                        break;
                    case 15:
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, LongSerializer.INSTANCE, l9);
                        i6 |= 32768;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i6;
            str = str3;
            list = list4;
            list2 = list5;
            i2 = i10;
            l = l12;
            l2 = l11;
            i3 = i9;
            str2 = str4;
            i4 = i7;
            i5 = i8;
            j = j2;
            l3 = l8;
            l4 = l9;
            l5 = l10;
            b = b3;
            num = num2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CommentInfoApiService.CommentInfoRequest(i, l, num, list2, list, b, i2, i3, str, str2, i4, l3, j, i5, l2, l5, l4, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CommentInfoApiService.CommentInfoRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CommentInfoApiService.CommentInfoRequest.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}