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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: ResolveModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/model/model/PlayerInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/model/model/PlayerInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class PlayerInfo$$serializer implements GeneratedSerializer<PlayerInfo> {
    public static final int $stable;
    public static final PlayerInfo$$serializer INSTANCE = new PlayerInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.model.model.PlayerInfo", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, false);
        pluginGeneratedSerialDescriptor.addElement("fnver", false);
        pluginGeneratedSerialDescriptor.addElement("fnval", false);
        pluginGeneratedSerialDescriptor.addElement("fourk", false);
        pluginGeneratedSerialDescriptor.addElement("codecType", false);
        pluginGeneratedSerialDescriptor.addElement("voiceBalance", false);
        pluginGeneratedSerialDescriptor.addElement("needTrial", true);
        pluginGeneratedSerialDescriptor.addElement("audioType", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private PlayerInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final PlayerInfo deserialize(Decoder decoder) {
        long j;
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 2);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 4);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 5);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
            i3 = decodeIntElement;
            i = beginStructure.decodeIntElement(serialDescriptor, 7);
            z = decodeBooleanElement2;
            i2 = 255;
            z2 = decodeBooleanElement;
            i5 = decodeIntElement4;
            i6 = decodeIntElement3;
            i4 = decodeIntElement2;
            j = decodeLongElement;
        } else {
            boolean z3 = true;
            int i7 = 0;
            int i8 = 0;
            boolean z4 = false;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            j = 0;
            int i12 = 0;
            boolean z5 = false;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        continue;
                    case 0:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i8 |= 1;
                        continue;
                    case 1:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i8 |= 2;
                        break;
                    case 2:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i8 |= 4;
                        break;
                    case 3:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i8 |= 8;
                        break;
                    case 4:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i8 |= 16;
                        break;
                    case 5:
                        j = beginStructure.decodeLongElement(serialDescriptor, 5);
                        i8 |= 32;
                        break;
                    case 6:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i8 |= 64;
                        break;
                    case 7:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i8 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i12;
            z = z5;
            i2 = i8;
            i3 = i7;
            int i13 = i10;
            z2 = z4;
            i4 = i11;
            i5 = i9;
            i6 = i13;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PlayerInfo(i2, i3, i4, i6, z2, i5, j, z, i, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, PlayerInfo value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PlayerInfo.write$Self$model_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}