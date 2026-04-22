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

/* compiled from: MergeAtmospherePriceFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor.MergeAtmosphere.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MergeAtmospherePriceFloor$MergeAtmosphere$$serializer implements GeneratedSerializer<MergeAtmospherePriceFloor.MergeAtmosphere> {
    public static final int $stable;
    public static final MergeAtmospherePriceFloor$MergeAtmosphere$$serializer INSTANCE = new MergeAtmospherePriceFloor$MergeAtmosphere$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor.MergeAtmosphere", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("backImg", true);
        pluginGeneratedSerialDescriptor.addElement("frontImg", true);
        pluginGeneratedSerialDescriptor.addElement("backImgNight", true);
        pluginGeneratedSerialDescriptor.addElement("frontImgNight", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private MergeAtmospherePriceFloor$MergeAtmosphere$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ImageColorModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ImageColorModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ImageColorModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ImageColorModel$$serializer.INSTANCE)};
    }

    public final MergeAtmospherePriceFloor.MergeAtmosphere deserialize(Decoder decoder) {
        int i;
        ImageColorModel imageColorModel;
        ImageColorModel imageColorModel2;
        ImageColorModel imageColorModel3;
        ImageColorModel imageColorModel4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        ImageColorModel imageColorModel5 = null;
        if (beginStructure.decodeSequentially()) {
            ImageColorModel imageColorModel6 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ImageColorModel$$serializer.INSTANCE, (Object) null);
            ImageColorModel imageColorModel7 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ImageColorModel$$serializer.INSTANCE, (Object) null);
            imageColorModel = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ImageColorModel$$serializer.INSTANCE, (Object) null);
            i = 15;
            imageColorModel4 = imageColorModel7;
            imageColorModel3 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ImageColorModel$$serializer.INSTANCE, (Object) null);
            imageColorModel2 = imageColorModel6;
        } else {
            boolean z = true;
            i = 0;
            ImageColorModel imageColorModel8 = null;
            ImageColorModel imageColorModel9 = null;
            ImageColorModel imageColorModel10 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        imageColorModel5 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ImageColorModel$$serializer.INSTANCE, imageColorModel5);
                        i |= 1;
                        break;
                    case 1:
                        imageColorModel8 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ImageColorModel$$serializer.INSTANCE, imageColorModel8);
                        i |= 2;
                        break;
                    case 2:
                        imageColorModel9 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ImageColorModel$$serializer.INSTANCE, imageColorModel9);
                        i |= 4;
                        break;
                    case 3:
                        imageColorModel10 = (ImageColorModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ImageColorModel$$serializer.INSTANCE, imageColorModel10);
                        i |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            imageColorModel = imageColorModel5;
            imageColorModel2 = imageColorModel8;
            imageColorModel3 = imageColorModel9;
            imageColorModel4 = imageColorModel10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MergeAtmospherePriceFloor.MergeAtmosphere(i, imageColorModel, imageColorModel2, imageColorModel3, imageColorModel4, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, MergeAtmospherePriceFloor.MergeAtmosphere value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MergeAtmospherePriceFloor.MergeAtmosphere.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}