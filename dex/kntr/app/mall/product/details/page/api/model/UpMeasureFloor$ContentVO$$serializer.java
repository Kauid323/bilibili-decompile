package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.UpMeasureFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UpMeasureFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/UpMeasureFloor.ContentVO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class UpMeasureFloor$ContentVO$$serializer implements GeneratedSerializer<UpMeasureFloor.ContentVO> {
    public static final int $stable;
    public static final UpMeasureFloor$ContentVO$$serializer INSTANCE = new UpMeasureFloor$ContentVO$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.UpMeasureFloor.ContentVO", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("contentDetailVOList", true);
        pluginGeneratedSerialDescriptor.addElement("desc", true);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        pluginGeneratedSerialDescriptor.addElement("subTitle", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private UpMeasureFloor$ContentVO$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = UpMeasureFloor.ContentVO.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable(TextColorModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(TextColorModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(TextColorModel$$serializer.INSTANCE)};
    }

    public final UpMeasureFloor.ContentVO deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        TextColorModel textColorModel;
        TextColorModel textColorModel2;
        TextColorModel textColorModel3;
        String str;
        int i;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = UpMeasureFloor.ContentVO.$childSerializers;
        int i2 = 3;
        List list2 = null;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            textColorModel3 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, TextColorModel$$serializer.INSTANCE, (Object) null);
            textColorModel = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, TextColorModel$$serializer.INSTANCE, (Object) null);
            textColorModel2 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, TextColorModel$$serializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            i = 31;
        } else {
            boolean z = true;
            int i3 = 0;
            TextColorModel textColorModel4 = null;
            String str2 = null;
            TextColorModel textColorModel5 = null;
            TextColorModel textColorModel6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 3;
                    case 0:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                        i3 |= 1;
                        i2 = 3;
                    case 1:
                        textColorModel4 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, TextColorModel$$serializer.INSTANCE, textColorModel4);
                        i3 |= 2;
                    case 2:
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str2);
                        i3 |= 4;
                    case 3:
                        textColorModel5 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, TextColorModel$$serializer.INSTANCE, textColorModel5);
                        i3 |= 8;
                    case 4:
                        textColorModel6 = (TextColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, TextColorModel$$serializer.INSTANCE, textColorModel6);
                        i3 |= 16;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            textColorModel = textColorModel5;
            textColorModel2 = textColorModel6;
            textColorModel3 = textColorModel4;
            str = str2;
            i = i3;
            list = list2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UpMeasureFloor.ContentVO(i, list, textColorModel3, str, textColorModel, textColorModel2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, UpMeasureFloor.ContentVO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UpMeasureFloor.ContentVO.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}