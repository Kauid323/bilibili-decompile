package video.biz.offline.base.infra.model;

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
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: DeprecatedDramaModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/infra/model/DeprecatedDramaItemModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedDramaItemModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DeprecatedDramaItemModel$$serializer implements GeneratedSerializer<DeprecatedDramaItemModel> {
    public static final int $stable;
    public static final DeprecatedDramaItemModel$$serializer INSTANCE = new DeprecatedDramaItemModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.model.DeprecatedDramaItemModel", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("avid", false);
        pluginGeneratedSerialDescriptor.addElement("position", false);
        pluginGeneratedSerialDescriptor.addElement("section", false);
        pluginGeneratedSerialDescriptor.addElement(RankRouter.BundleKey.ACTION_PARAM_TITLE, false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private DeprecatedDramaItemModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    public final DeprecatedDramaItemModel deserialize(Decoder decoder) {
        String str;
        int i;
        long j;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 1);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 2);
            str = beginStructure.decodeStringElement(serialDescriptor, 3);
            j3 = decodeLongElement3;
            j2 = decodeLongElement2;
            i = 15;
            j = decodeLongElement;
        } else {
            String str2 = null;
            boolean z = true;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            int i2 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str2;
            long j7 = j6;
            i = i2;
            j = j4;
            j2 = j5;
            j3 = j7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeprecatedDramaItemModel(i, j, j2, j3, str, null);
    }

    public final void serialize(Encoder encoder, DeprecatedDramaItemModel value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeprecatedDramaItemModel.write$Self$infra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}