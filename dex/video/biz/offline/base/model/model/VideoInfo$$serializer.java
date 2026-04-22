package video.biz.offline.base.model.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: ResolveModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/model/model/VideoInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/model/model/VideoInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class VideoInfo$$serializer implements GeneratedSerializer<VideoInfo> {
    public static final int $stable;
    public static final VideoInfo$$serializer INSTANCE = new VideoInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.model.model.VideoInfo", INSTANCE, 21);
        pluginGeneratedSerialDescriptor.addElement("videoAttr", false);
        pluginGeneratedSerialDescriptor.addElement("groupId", false);
        pluginGeneratedSerialDescriptor.addElement("aid", false);
        pluginGeneratedSerialDescriptor.addElement("cid", false);
        pluginGeneratedSerialDescriptor.addElement("seasonId", false);
        pluginGeneratedSerialDescriptor.addElement("episodeId", false);
        pluginGeneratedSerialDescriptor.addElement("bvId", false);
        pluginGeneratedSerialDescriptor.addElement("groupTitle", false);
        pluginGeneratedSerialDescriptor.addElement("videoTitle", false);
        pluginGeneratedSerialDescriptor.addElement("pageTitle", false);
        pluginGeneratedSerialDescriptor.addElement("author", false);
        pluginGeneratedSerialDescriptor.addElement("authorMid", false);
        pluginGeneratedSerialDescriptor.addElement(RankRouter.BundleKey.VIDEO_DETAIL_COVER, false);
        pluginGeneratedSerialDescriptor.addElement("biz", false);
        pluginGeneratedSerialDescriptor.addElement("videoIndex", false);
        pluginGeneratedSerialDescriptor.addElement("pageIndex", false);
        pluginGeneratedSerialDescriptor.addElement("seasonType", false);
        pluginGeneratedSerialDescriptor.addElement("fromScene", false);
        pluginGeneratedSerialDescriptor.addElement("extended", false);
        pluginGeneratedSerialDescriptor.addElement("epSortedIds", false);
        pluginGeneratedSerialDescriptor.addElement("epStatus", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private VideoInfo$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = VideoInfo.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[13].getValue(), LongSerializer.INSTANCE, LongSerializer.INSTANCE, lazyArr[16].getValue(), StringSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[19].getValue(), IntSerializer.INSTANCE};
    }

    public final VideoInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        int i2;
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        OfflineVideoEntity.SeasonType seasonType;
        OfflineVideoEntity.BizType bizType;
        List list;
        int i3;
        long j7;
        long j8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = VideoInfo.$childSerializers;
        int i4 = 8;
        char c = 4;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 3);
            long decodeLongElement4 = beginStructure.decodeLongElement(serialDescriptor, 4);
            long decodeLongElement5 = beginStructure.decodeLongElement(serialDescriptor, 5);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 9);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 10);
            j2 = beginStructure.decodeLongElement(serialDescriptor, 11);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 12);
            OfflineVideoEntity.BizType bizType2 = (OfflineVideoEntity.BizType) beginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), (Object) null);
            long decodeLongElement6 = beginStructure.decodeLongElement(serialDescriptor, 14);
            long decodeLongElement7 = beginStructure.decodeLongElement(serialDescriptor, 15);
            String decodeStringElement7 = beginStructure.decodeStringElement(serialDescriptor, 17);
            String decodeStringElement8 = beginStructure.decodeStringElement(serialDescriptor, 18);
            str3 = decodeStringElement3;
            str4 = decodeStringElement4;
            str5 = decodeStringElement5;
            seasonType = (OfflineVideoEntity.SeasonType) beginStructure.decodeSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), (Object) null);
            j5 = decodeLongElement5;
            j6 = decodeLongElement7;
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 19, (DeserializationStrategy) lazyArr[19].getValue(), (Object) null);
            i = beginStructure.decodeIntElement(serialDescriptor, 20);
            i3 = decodeIntElement;
            i2 = 2097151;
            str = decodeStringElement;
            str2 = decodeStringElement2;
            j4 = decodeLongElement3;
            j8 = decodeLongElement6;
            str8 = decodeStringElement8;
            str7 = decodeStringElement7;
            j3 = decodeLongElement2;
            j7 = decodeLongElement;
            str6 = decodeStringElement6;
            bizType = bizType2;
            j = decodeLongElement4;
        } else {
            boolean z = true;
            OfflineVideoEntity.SeasonType seasonType2 = null;
            List list2 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            long j13 = 0;
            long j14 = 0;
            long j15 = 0;
            long j16 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            OfflineVideoEntity.BizType bizType3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 8;
                        c = 4;
                        break;
                    case 0:
                        i6 |= 1;
                        i5 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i4 = 8;
                        c = 4;
                        break;
                    case 1:
                        j10 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i6 |= 2;
                        i4 = 8;
                        c = 4;
                        break;
                    case 2:
                        j13 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i6 |= 4;
                        i4 = 8;
                        c = 4;
                        break;
                    case 3:
                        j14 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i6 |= 8;
                        i4 = 8;
                        c = 4;
                        break;
                    case 4:
                        j9 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i6 |= 16;
                        c = 4;
                        i4 = 8;
                        break;
                    case 5:
                        j15 = beginStructure.decodeLongElement(serialDescriptor, 5);
                        i6 |= 32;
                        c = 4;
                        break;
                    case 6:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i6 |= 64;
                        c = 4;
                        break;
                    case 7:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i6 |= 128;
                        c = 4;
                        break;
                    case 8:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, i4);
                        i6 |= IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                        c = 4;
                        break;
                    case 9:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i6 |= 512;
                        c = 4;
                        break;
                    case 10:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 10);
                        i6 |= 1024;
                        c = 4;
                        break;
                    case 11:
                        j12 = beginStructure.decodeLongElement(serialDescriptor, 11);
                        i6 |= IjkMediaMeta.FF_PROFILE_H264_INTRA;
                        c = 4;
                        break;
                    case 12:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i6 |= 4096;
                        c = 4;
                        break;
                    case 13:
                        bizType3 = (OfflineVideoEntity.BizType) beginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), bizType3);
                        i6 |= 8192;
                        c = 4;
                        break;
                    case 14:
                        j11 = beginStructure.decodeLongElement(serialDescriptor, 14);
                        i6 |= IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID;
                        c = 4;
                        break;
                    case 15:
                        j16 = beginStructure.decodeLongElement(serialDescriptor, 15);
                        i6 |= 32768;
                        c = 4;
                        break;
                    case 16:
                        seasonType2 = (OfflineVideoEntity.SeasonType) beginStructure.decodeSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), seasonType2);
                        i6 |= 65536;
                        c = 4;
                        break;
                    case 17:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 17);
                        i6 |= 131072;
                        c = 4;
                        break;
                    case 18:
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 18);
                        i6 |= 262144;
                        c = 4;
                        break;
                    case 19:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 19, (DeserializationStrategy) lazyArr[19].getValue(), list2);
                        i6 |= 524288;
                        c = 4;
                        break;
                    case 20:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 20);
                        i6 |= 1048576;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i7;
            i2 = i6;
            j = j9;
            str = str9;
            str2 = str10;
            str3 = str11;
            str4 = str12;
            str5 = str13;
            str6 = str14;
            str7 = str15;
            str8 = str16;
            j2 = j12;
            j3 = j13;
            j4 = j14;
            j5 = j15;
            j6 = j16;
            seasonType = seasonType2;
            bizType = bizType3;
            list = list2;
            i3 = i5;
            j7 = j10;
            j8 = j11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new VideoInfo(i2, i3, j7, j3, j4, j, j5, str, str2, str3, str4, str5, j2, str6, bizType, j8, j6, seasonType, str7, str8, list, i, null);
    }

    public final void serialize(Encoder encoder, VideoInfo value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        VideoInfo.write$Self$model_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}