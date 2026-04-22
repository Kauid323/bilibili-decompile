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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: DeprecatedEntryModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/infra/model/DeprecatedEpisodeModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DeprecatedEpisodeModel$$serializer implements GeneratedSerializer<DeprecatedEpisodeModel> {
    public static final int $stable;
    public static final DeprecatedEpisodeModel$$serializer INSTANCE = new DeprecatedEpisodeModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.model.DeprecatedEpisodeModel", INSTANCE, 15);
        pluginGeneratedSerialDescriptor.addElement("av_id", true);
        pluginGeneratedSerialDescriptor.addElement("page", true);
        pluginGeneratedSerialDescriptor.addElement("danmaku", true);
        pluginGeneratedSerialDescriptor.addElement(RankRouter.BundleKey.VIDEO_DETAIL_COVER, true);
        pluginGeneratedSerialDescriptor.addElement("episode_id", true);
        pluginGeneratedSerialDescriptor.addElement("index", true);
        pluginGeneratedSerialDescriptor.addElement("index_title", true);
        pluginGeneratedSerialDescriptor.addElement("from", true);
        pluginGeneratedSerialDescriptor.addElement(MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("rotate", true);
        pluginGeneratedSerialDescriptor.addElement("link", true);
        pluginGeneratedSerialDescriptor.addElement("bvid", true);
        pluginGeneratedSerialDescriptor.addElement("sort_index", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private DeprecatedEpisodeModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    public final DeprecatedEpisodeModel deserialize(Decoder decoder) {
        int i;
        int i2;
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        long j2;
        long j3;
        long j4;
        long j5;
        String str5;
        String str6;
        long j6;
        long j7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i4 = 2;
        boolean z = true;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 2);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 3);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 4);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 7);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 8);
            long decodeLongElement4 = beginStructure.decodeLongElement(serialDescriptor, 9);
            long decodeLongElement5 = beginStructure.decodeLongElement(serialDescriptor, 10);
            long decodeLongElement6 = beginStructure.decodeLongElement(serialDescriptor, 11);
            str6 = beginStructure.decodeStringElement(serialDescriptor, 12);
            str3 = decodeStringElement3;
            str5 = beginStructure.decodeStringElement(serialDescriptor, 13);
            j5 = beginStructure.decodeLongElement(serialDescriptor, 14);
            i2 = decodeIntElement;
            str4 = decodeStringElement2;
            j7 = decodeLongElement6;
            j6 = decodeLongElement5;
            i = 32767;
            str = decodeStringElement;
            j4 = decodeLongElement3;
            j2 = decodeLongElement4;
            str2 = decodeStringElement4;
            i3 = decodeIntElement2;
            j3 = decodeLongElement;
            j = decodeLongElement2;
        } else {
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            boolean z2 = true;
            int i5 = 0;
            int i6 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            long j13 = 0;
            long j14 = 0;
            int i7 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        i4 = 2;
                        z = true;
                    case 0:
                        j10 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i5 |= 1;
                        i4 = 2;
                        z = true;
                    case 1:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i5 |= 2;
                        z = true;
                        i4 = 2;
                    case 2:
                        j14 = beginStructure.decodeLongElement(serialDescriptor, i4);
                        i5 |= 4;
                        z = true;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i5 |= 8;
                        z = true;
                    case 4:
                        j11 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i5 |= 16;
                        z = true;
                    case 5:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i5 |= 32;
                        z = true;
                    case 6:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i5 |= 64;
                        z = true;
                    case 7:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i5 |= 128;
                        z = true;
                    case 8:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i5 |= IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                        z = true;
                    case 9:
                        j9 = beginStructure.decodeLongElement(serialDescriptor, 9);
                        i5 |= 512;
                        z = true;
                    case 10:
                        j8 = beginStructure.decodeLongElement(serialDescriptor, 10);
                        i5 |= 1024;
                        z = true;
                    case 11:
                        j12 = beginStructure.decodeLongElement(serialDescriptor, 11);
                        i5 |= IjkMediaMeta.FF_PROFILE_H264_INTRA;
                        z = true;
                    case 12:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i5 |= 4096;
                        z = true;
                    case 13:
                        i5 |= 8192;
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 13);
                    case 14:
                        j13 = beginStructure.decodeLongElement(serialDescriptor, 14);
                        i5 |= IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i5;
            i2 = i7;
            j = j14;
            str = str8;
            str2 = str10;
            str3 = str11;
            str4 = str12;
            i3 = i6;
            j2 = j9;
            j3 = j10;
            j4 = j11;
            j5 = j13;
            str5 = str7;
            str6 = str9;
            j6 = j8;
            j7 = j12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeprecatedEpisodeModel(i, j3, i2, j, str, j4, str4, str3, str2, i3, j2, j6, j7, str6, str5, j5, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DeprecatedEpisodeModel value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeprecatedEpisodeModel.write$Self$infra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}