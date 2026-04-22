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
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: VideoPlayInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/model/model/VideoPlayInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class VideoPlayInfo$$serializer implements GeneratedSerializer<VideoPlayInfo> {
    public static final int $stable;
    public static final VideoPlayInfo$$serializer INSTANCE = new VideoPlayInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.model.model.VideoPlayInfo", INSTANCE, 19);
        pluginGeneratedSerialDescriptor.addElement("videoId", true);
        pluginGeneratedSerialDescriptor.addElement("audioId", true);
        pluginGeneratedSerialDescriptor.addElement("videoMd5", true);
        pluginGeneratedSerialDescriptor.addElement("audioMd5", true);
        pluginGeneratedSerialDescriptor.addElement("videoCodecid", true);
        pluginGeneratedSerialDescriptor.addElement("audioCodecid", true);
        pluginGeneratedSerialDescriptor.addElement("dashDrmType", true);
        pluginGeneratedSerialDescriptor.addElement("biliDrmUri", true);
        pluginGeneratedSerialDescriptor.addElement("preferredAudioQuality", true);
        pluginGeneratedSerialDescriptor.addElement("realAudioQuality", true);
        pluginGeneratedSerialDescriptor.addElement("audioType", true);
        pluginGeneratedSerialDescriptor.addElement(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, true);
        pluginGeneratedSerialDescriptor.addElement("fnver", true);
        pluginGeneratedSerialDescriptor.addElement("fnval", true);
        pluginGeneratedSerialDescriptor.addElement("fourk", true);
        pluginGeneratedSerialDescriptor.addElement("codecType", true);
        pluginGeneratedSerialDescriptor.addElement("voiceBalance", true);
        pluginGeneratedSerialDescriptor.addElement("needTrial", true);
        pluginGeneratedSerialDescriptor.addElement("attribute", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private VideoPlayInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    public final VideoPlayInfo deserialize(Decoder decoder) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        String str2;
        int i5;
        int i6;
        int i7;
        int i8;
        String str3;
        int i9;
        long j;
        long j2;
        boolean z;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i14 = 3;
        boolean z3 = true;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 5);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 6);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 7);
            int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 8);
            int decodeIntElement7 = beginStructure.decodeIntElement(serialDescriptor, 9);
            int decodeIntElement8 = beginStructure.decodeIntElement(serialDescriptor, 10);
            int decodeIntElement9 = beginStructure.decodeIntElement(serialDescriptor, 11);
            int decodeIntElement10 = beginStructure.decodeIntElement(serialDescriptor, 12);
            int decodeIntElement11 = beginStructure.decodeIntElement(serialDescriptor, 13);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 14);
            int decodeIntElement12 = beginStructure.decodeIntElement(serialDescriptor, 15);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 16);
            i4 = decodeIntElement3;
            i9 = decodeIntElement5;
            z2 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
            i10 = decodeIntElement12;
            z = decodeBooleanElement;
            j = decodeLongElement;
            j2 = beginStructure.decodeLongElement(serialDescriptor, 18);
            i3 = decodeIntElement6;
            str2 = decodeStringElement;
            i6 = decodeIntElement4;
            i11 = decodeIntElement9;
            i7 = decodeIntElement8;
            str3 = decodeStringElement3;
            i12 = decodeIntElement10;
            i13 = decodeIntElement11;
            i = 524287;
            str = decodeStringElement2;
            i5 = decodeIntElement2;
            i8 = decodeIntElement7;
            i2 = decodeIntElement;
        } else {
            String str4 = null;
            String str5 = null;
            String str6 = null;
            boolean z4 = true;
            int i15 = 0;
            int i16 = 0;
            boolean z5 = false;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            long j3 = 0;
            long j4 = 0;
            boolean z6 = false;
            int i27 = 0;
            while (z4) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z4 = false;
                        i14 = 3;
                        z3 = true;
                    case 0:
                        i17 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i15 |= 1;
                        i14 = 3;
                        z3 = true;
                    case 1:
                        i20 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i15 |= 2;
                        z3 = true;
                        i14 = 3;
                    case 2:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i15 |= 4;
                        z3 = true;
                    case 3:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, i14);
                        i15 |= 8;
                        z3 = true;
                    case 4:
                        i19 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i15 |= 16;
                        z3 = true;
                    case 5:
                        i21 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i15 |= 32;
                        z3 = true;
                    case 6:
                        i25 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i15 |= 64;
                        z3 = true;
                    case 7:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i15 |= 128;
                        z3 = true;
                    case 8:
                        i18 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i15 |= IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                        z3 = true;
                    case 9:
                        i24 = beginStructure.decodeIntElement(serialDescriptor, 9);
                        i15 |= 512;
                        z3 = true;
                    case 10:
                        i23 = beginStructure.decodeIntElement(serialDescriptor, 10);
                        i15 |= 1024;
                        z3 = true;
                    case 11:
                        i22 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i15 |= IjkMediaMeta.FF_PROFILE_H264_INTRA;
                        z3 = true;
                    case 12:
                        i26 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i15 |= 4096;
                        z3 = true;
                    case 13:
                        i15 |= 8192;
                        i16 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        z3 = true;
                    case 14:
                        z6 = beginStructure.decodeBooleanElement(serialDescriptor, 14);
                        i15 |= IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID;
                        z3 = true;
                    case 15:
                        i27 = beginStructure.decodeIntElement(serialDescriptor, 15);
                        i15 |= 32768;
                        z3 = true;
                    case 16:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 16);
                        i15 |= 65536;
                        z3 = true;
                    case 17:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
                        i15 |= 131072;
                        z3 = true;
                    case 18:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 18);
                        i15 |= 262144;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i15;
            i2 = i17;
            str = str4;
            i3 = i18;
            i4 = i19;
            str2 = str5;
            i5 = i20;
            i6 = i21;
            i7 = i23;
            i8 = i24;
            str3 = str6;
            i9 = i25;
            j = j3;
            j2 = j4;
            z = z6;
            i10 = i27;
            z2 = z5;
            i11 = i22;
            i12 = i26;
            i13 = i16;
        }
        beginStructure.endStructure(serialDescriptor);
        return new VideoPlayInfo(i, i2, i5, str2, str, i4, i6, i9, str3, i3, i8, i7, i11, i12, i13, z, i10, j, z2, j2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, VideoPlayInfo value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        VideoPlayInfo.write$Self$model_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}