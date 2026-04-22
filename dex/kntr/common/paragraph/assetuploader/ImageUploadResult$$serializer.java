package kntr.common.paragraph.assetuploader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.BytesSizeSerializer;
import kntr.common.photonic.ContentSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AssetUploader.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/common/paragraph/assetuploader/ImageUploadResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ImageUploadResult$$serializer implements GeneratedSerializer<ImageUploadResult> {
    public static final ImageUploadResult$$serializer INSTANCE = new ImageUploadResult$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.paragraph.assetuploader.ImageUploadResult", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("image_url", false);
        pluginGeneratedSerialDescriptor.addElement("image_width", false);
        pluginGeneratedSerialDescriptor.addElement("image_height", false);
        pluginGeneratedSerialDescriptor.addElement("img_size", false);
        pluginGeneratedSerialDescriptor.addElement("ai_gen_pic", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImageUploadResult$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BytesSizeSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final ImageUploadResult deserialize(Decoder decoder) {
        long j;
        int i;
        ContentSize contentSize;
        int i2;
        String str;
        long j2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 2);
            contentSize = (ContentSize) beginStructure.decodeSerializableElement(serialDescriptor, 3, BytesSizeSerializer.INSTANCE, (Object) null);
            i = beginStructure.decodeIntElement(serialDescriptor, 4);
            j2 = decodeLongElement;
            j = decodeLongElement2;
            str = decodeStringElement;
            i2 = 31;
        } else {
            long j3 = 0;
            boolean z = true;
            int i3 = 0;
            String str2 = null;
            ContentSize contentSize2 = null;
            j = 0;
            int i4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        j = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        contentSize2 = (ContentSize) beginStructure.decodeSerializableElement(serialDescriptor, 3, BytesSizeSerializer.INSTANCE, contentSize2);
                        i4 |= 8;
                        break;
                    case 4:
                        i3 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i3;
            contentSize = contentSize2;
            long j4 = j3;
            i2 = i4;
            str = str2;
            j2 = j4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ImageUploadResult(i2, str, j2, j, contentSize, i, null, null);
    }

    public final void serialize(Encoder encoder, ImageUploadResult value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ImageUploadResult.write$Self$assetuploader_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}