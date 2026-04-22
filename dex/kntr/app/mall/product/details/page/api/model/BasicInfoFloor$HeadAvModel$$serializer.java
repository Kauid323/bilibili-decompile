package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BasicInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/BasicInfoFloor.HeadAvModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class BasicInfoFloor$HeadAvModel$$serializer implements GeneratedSerializer<BasicInfoFloor.HeadAvModel> {
    public static final int $stable;
    public static final BasicInfoFloor$HeadAvModel$$serializer INSTANCE = new BasicInfoFloor$HeadAvModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.BasicInfoFloor.HeadAvModel", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("longVideoIds", true);
        pluginGeneratedSerialDescriptor.addElement("videoIds", true);
        pluginGeneratedSerialDescriptor.addElement("videoType", true);
        pluginGeneratedSerialDescriptor.addElement("videoUrls", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private BasicInfoFloor$HeadAvModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = BasicInfoFloor.HeadAvModel.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(ByteSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue())};
    }

    public final BasicInfoFloor.HeadAvModel deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        List list;
        List list2;
        Byte b;
        List list3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = BasicInfoFloor.HeadAvModel.$childSerializers;
        List list4 = null;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            List list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            i = 15;
            b = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ByteSerializer.INSTANCE, (Object) null);
            list2 = list5;
        } else {
            boolean z = true;
            int i2 = 0;
            List list6 = null;
            Byte b2 = null;
            List list7 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list4);
                        i2 |= 1;
                        break;
                    case 1:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list6);
                        i2 |= 2;
                        break;
                    case 2:
                        b2 = (Byte) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ByteSerializer.INSTANCE, b2);
                        i2 |= 4;
                        break;
                    case 3:
                        list7 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list7);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            list = list4;
            list2 = list6;
            b = b2;
            list3 = list7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BasicInfoFloor.HeadAvModel(i, list, list2, b, list3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, BasicInfoFloor.HeadAvModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BasicInfoFloor.HeadAvModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}