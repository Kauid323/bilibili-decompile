package video.biz.offline.base.model.model;

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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: ResolveModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/model/model/ResolveParam.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/model/model/ResolveParam;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ResolveParam$$serializer implements GeneratedSerializer<ResolveParam> {
    public static final int $stable;
    public static final ResolveParam$$serializer INSTANCE = new ResolveParam$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.model.model.ResolveParam", INSTANCE, 2);
        pluginGeneratedSerialDescriptor.addElement("videoInfo", false);
        pluginGeneratedSerialDescriptor.addElement("playerInfo", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ResolveParam$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{VideoInfo$$serializer.INSTANCE, PlayerInfo$$serializer.INSTANCE};
    }

    public final ResolveParam deserialize(Decoder decoder) {
        VideoInfo videoInfo;
        PlayerInfo playerInfo;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            videoInfo = (VideoInfo) beginStructure.decodeSerializableElement(serialDescriptor, 0, VideoInfo$$serializer.INSTANCE, (Object) null);
            playerInfo = (PlayerInfo) beginStructure.decodeSerializableElement(serialDescriptor, 1, PlayerInfo$$serializer.INSTANCE, (Object) null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            videoInfo = null;
            PlayerInfo playerInfo2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        videoInfo = (VideoInfo) beginStructure.decodeSerializableElement(serialDescriptor, 0, VideoInfo$$serializer.INSTANCE, videoInfo);
                        i2 |= 1;
                        break;
                    case 1:
                        playerInfo2 = (PlayerInfo) beginStructure.decodeSerializableElement(serialDescriptor, 1, PlayerInfo$$serializer.INSTANCE, playerInfo2);
                        i2 |= 2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            playerInfo = playerInfo2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ResolveParam(i, videoInfo, playerInfo, null);
    }

    public final void serialize(Encoder encoder, ResolveParam value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ResolveParam.write$Self$model_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}