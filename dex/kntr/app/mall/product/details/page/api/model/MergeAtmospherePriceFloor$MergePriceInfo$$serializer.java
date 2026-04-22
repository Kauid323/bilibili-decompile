package kntr.app.mall.product.details.page.api.model;

import kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MergeAtmospherePriceFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor.MergePriceInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MergeAtmospherePriceFloor$MergePriceInfo$$serializer implements GeneratedSerializer<MergeAtmospherePriceFloor.MergePriceInfo> {
    public static final int $stable;
    public static final MergeAtmospherePriceFloor$MergePriceInfo$$serializer INSTANCE = new MergeAtmospherePriceFloor$MergePriceInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor.MergePriceInfo", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("bottomVO", true);
        pluginGeneratedSerialDescriptor.addElement("leftVO", true);
        pluginGeneratedSerialDescriptor.addElement("rightVO", true);
        pluginGeneratedSerialDescriptor.addElement("fontColor", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private MergeAtmospherePriceFloor$MergePriceInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(MergeAtmospherePriceFloor$MergePriceInfo$RightVO$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final MergeAtmospherePriceFloor.MergePriceInfo deserialize(Decoder decoder) {
        int i;
        MergeAtmospherePriceFloor.MergePriceInfo.BottomVO bottomVO;
        MergeAtmospherePriceFloor.MergePriceInfo.LeftVO leftVO;
        MergeAtmospherePriceFloor.MergePriceInfo.RightVO rightVO;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        MergeAtmospherePriceFloor.MergePriceInfo.BottomVO bottomVO2 = null;
        if (beginStructure.decodeSequentially()) {
            MergeAtmospherePriceFloor.MergePriceInfo.LeftVO leftVO2 = (MergeAtmospherePriceFloor.MergePriceInfo.LeftVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$$serializer.INSTANCE, (Object) null);
            String str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            bottomVO = (MergeAtmospherePriceFloor.MergePriceInfo.BottomVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$$serializer.INSTANCE, (Object) null);
            i = 15;
            str = str2;
            rightVO = (MergeAtmospherePriceFloor.MergePriceInfo.RightVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MergeAtmospherePriceFloor$MergePriceInfo$RightVO$$serializer.INSTANCE, (Object) null);
            leftVO = leftVO2;
        } else {
            boolean z = true;
            i = 0;
            MergeAtmospherePriceFloor.MergePriceInfo.LeftVO leftVO3 = null;
            MergeAtmospherePriceFloor.MergePriceInfo.RightVO rightVO2 = null;
            String str3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        bottomVO2 = (MergeAtmospherePriceFloor.MergePriceInfo.BottomVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$$serializer.INSTANCE, bottomVO2);
                        i |= 1;
                        break;
                    case 1:
                        leftVO3 = (MergeAtmospherePriceFloor.MergePriceInfo.LeftVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$$serializer.INSTANCE, leftVO3);
                        i |= 2;
                        break;
                    case 2:
                        rightVO2 = (MergeAtmospherePriceFloor.MergePriceInfo.RightVO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MergeAtmospherePriceFloor$MergePriceInfo$RightVO$$serializer.INSTANCE, rightVO2);
                        i |= 4;
                        break;
                    case 3:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
                        i |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bottomVO = bottomVO2;
            leftVO = leftVO3;
            rightVO = rightVO2;
            str = str3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MergeAtmospherePriceFloor.MergePriceInfo(i, bottomVO, leftVO, rightVO, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, MergeAtmospherePriceFloor.MergePriceInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MergeAtmospherePriceFloor.MergePriceInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}