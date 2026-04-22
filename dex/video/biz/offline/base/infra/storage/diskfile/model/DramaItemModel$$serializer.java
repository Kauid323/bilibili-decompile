package video.biz.offline.base.infra.storage.diskfile.model;

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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: DramaGroupModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/infra/storage/diskfile/model/DramaItemModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DramaItemModel$$serializer implements GeneratedSerializer<DramaItemModel> {
    public static final int $stable;
    public static final DramaItemModel$$serializer INSTANCE = new DramaItemModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.storage.diskfile.model.DramaItemModel", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("aid", false);
        pluginGeneratedSerialDescriptor.addElement("cid", false);
        pluginGeneratedSerialDescriptor.addElement(RankRouter.BundleKey.ACTION_PARAM_TITLE, true);
        pluginGeneratedSerialDescriptor.addElement("section", true);
        pluginGeneratedSerialDescriptor.addElement("idx", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private DramaItemModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    public final DramaItemModel deserialize(Decoder decoder) {
        long j;
        int i;
        String str;
        long j2;
        long j3;
        long j4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 1);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 3);
            str = decodeStringElement;
            j = beginStructure.decodeLongElement(serialDescriptor, 4);
            j2 = decodeLongElement3;
            j4 = decodeLongElement2;
            i = 31;
            j3 = decodeLongElement;
        } else {
            long j5 = 0;
            String str2 = null;
            boolean z = true;
            int i2 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        j7 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        j8 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i2 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            j = j5;
            i = i2;
            long j9 = j8;
            str = str2;
            j2 = j6;
            j3 = j7;
            j4 = j9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DramaItemModel(i, j3, j4, str, j2, j, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DramaItemModel value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DramaItemModel.write$Self$infra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}