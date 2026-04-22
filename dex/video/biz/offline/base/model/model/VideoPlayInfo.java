package video.biz.offline.base.model.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: VideoPlayInfo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 n2\u00020\u0001:\u0002mnBÅ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aB¹\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001eJ\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0006HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0013HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0016HÆ\u0003J\t\u0010^\u001a\u00020\u0013HÆ\u0003J\t\u0010_\u001a\u00020\u0016HÆ\u0003JÇ\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0016HÆ\u0001J\u0013\u0010a\u001a\u00020\u00132\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u0003HÖ\u0001J\t\u0010d\u001a\u00020\u0006HÖ\u0001J%\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH\u0001¢\u0006\u0002\blR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010@\"\u0004\bJ\u0010BR\u001a\u0010\u0018\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010F\"\u0004\bL\u0010H¨\u0006o"}, d2 = {"Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "", "videoId", "", "audioId", "videoMd5", "", "audioMd5", "videoCodecid", "audioCodecid", "dashDrmType", "biliDrmUri", "preferredAudioQuality", "realAudioQuality", "audioType", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "fnver", "fnval", "fourk", "", "codecType", "voiceBalance", "", "needTrial", "attribute", "<init>", "(IILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;IIIIIIZIJZJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;IIIIIIZIJZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoId", "()I", "setVideoId", "(I)V", "getAudioId", "setAudioId", "getVideoMd5", "()Ljava/lang/String;", "setVideoMd5", "(Ljava/lang/String;)V", "getAudioMd5", "setAudioMd5", "getVideoCodecid", "setVideoCodecid", "getAudioCodecid", "setAudioCodecid", "getDashDrmType", "setDashDrmType", "getBiliDrmUri", "setBiliDrmUri", "getPreferredAudioQuality", "setPreferredAudioQuality", "getRealAudioQuality", "setRealAudioQuality", "getAudioType", "setAudioType", "getQn", "setQn", "getFnver", "setFnver", "getFnval", "setFnval", "getFourk", "()Z", "setFourk", "(Z)V", "getCodecType", "setCodecType", "getVoiceBalance", "()J", "setVoiceBalance", "(J)V", "getNeedTrial", "setNeedTrial", "getAttribute", "setAttribute", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$model_debug", "$serializer", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VideoPlayInfo {
    private long attribute;
    private int audioCodecid;
    private int audioId;
    private String audioMd5;
    private int audioType;
    private String biliDrmUri;
    private int codecType;
    private int dashDrmType;
    private int fnval;
    private int fnver;
    private boolean fourk;
    private boolean needTrial;
    private int preferredAudioQuality;
    private int qn;
    private int realAudioQuality;
    private int videoCodecid;
    private int videoId;
    private String videoMd5;
    private long voiceBalance;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public VideoPlayInfo() {
        this(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.videoId;
    }

    public final int component10() {
        return this.realAudioQuality;
    }

    public final int component11() {
        return this.audioType;
    }

    public final int component12() {
        return this.qn;
    }

    public final int component13() {
        return this.fnver;
    }

    public final int component14() {
        return this.fnval;
    }

    public final boolean component15() {
        return this.fourk;
    }

    public final int component16() {
        return this.codecType;
    }

    public final long component17() {
        return this.voiceBalance;
    }

    public final boolean component18() {
        return this.needTrial;
    }

    public final long component19() {
        return this.attribute;
    }

    public final int component2() {
        return this.audioId;
    }

    public final String component3() {
        return this.videoMd5;
    }

    public final String component4() {
        return this.audioMd5;
    }

    public final int component5() {
        return this.videoCodecid;
    }

    public final int component6() {
        return this.audioCodecid;
    }

    public final int component7() {
        return this.dashDrmType;
    }

    public final String component8() {
        return this.biliDrmUri;
    }

    public final int component9() {
        return this.preferredAudioQuality;
    }

    public final VideoPlayInfo copy(int i, int i2, String str, String str2, int i3, int i4, int i5, String str3, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12, long j, boolean z2, long j2) {
        Intrinsics.checkNotNullParameter(str, "videoMd5");
        Intrinsics.checkNotNullParameter(str2, "audioMd5");
        Intrinsics.checkNotNullParameter(str3, "biliDrmUri");
        return new VideoPlayInfo(i, i2, str, str2, i3, i4, i5, str3, i6, i7, i8, i9, i10, i11, z, i12, j, z2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoPlayInfo) {
            VideoPlayInfo videoPlayInfo = (VideoPlayInfo) obj;
            return this.videoId == videoPlayInfo.videoId && this.audioId == videoPlayInfo.audioId && Intrinsics.areEqual(this.videoMd5, videoPlayInfo.videoMd5) && Intrinsics.areEqual(this.audioMd5, videoPlayInfo.audioMd5) && this.videoCodecid == videoPlayInfo.videoCodecid && this.audioCodecid == videoPlayInfo.audioCodecid && this.dashDrmType == videoPlayInfo.dashDrmType && Intrinsics.areEqual(this.biliDrmUri, videoPlayInfo.biliDrmUri) && this.preferredAudioQuality == videoPlayInfo.preferredAudioQuality && this.realAudioQuality == videoPlayInfo.realAudioQuality && this.audioType == videoPlayInfo.audioType && this.qn == videoPlayInfo.qn && this.fnver == videoPlayInfo.fnver && this.fnval == videoPlayInfo.fnval && this.fourk == videoPlayInfo.fourk && this.codecType == videoPlayInfo.codecType && this.voiceBalance == videoPlayInfo.voiceBalance && this.needTrial == videoPlayInfo.needTrial && this.attribute == videoPlayInfo.attribute;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.videoId * 31) + this.audioId) * 31) + this.videoMd5.hashCode()) * 31) + this.audioMd5.hashCode()) * 31) + this.videoCodecid) * 31) + this.audioCodecid) * 31) + this.dashDrmType) * 31) + this.biliDrmUri.hashCode()) * 31) + this.preferredAudioQuality) * 31) + this.realAudioQuality) * 31) + this.audioType) * 31) + this.qn) * 31) + this.fnver) * 31) + this.fnval) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fourk)) * 31) + this.codecType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.voiceBalance)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needTrial)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.attribute);
    }

    public String toString() {
        int i = this.videoId;
        int i2 = this.audioId;
        String str = this.videoMd5;
        String str2 = this.audioMd5;
        int i3 = this.videoCodecid;
        int i4 = this.audioCodecid;
        int i5 = this.dashDrmType;
        String str3 = this.biliDrmUri;
        int i6 = this.preferredAudioQuality;
        int i7 = this.realAudioQuality;
        int i8 = this.audioType;
        int i9 = this.qn;
        int i10 = this.fnver;
        int i11 = this.fnval;
        boolean z = this.fourk;
        int i12 = this.codecType;
        long j = this.voiceBalance;
        boolean z2 = this.needTrial;
        return "VideoPlayInfo(videoId=" + i + ", audioId=" + i2 + ", videoMd5=" + str + ", audioMd5=" + str2 + ", videoCodecid=" + i3 + ", audioCodecid=" + i4 + ", dashDrmType=" + i5 + ", biliDrmUri=" + str3 + ", preferredAudioQuality=" + i6 + ", realAudioQuality=" + i7 + ", audioType=" + i8 + ", qn=" + i9 + ", fnver=" + i10 + ", fnval=" + i11 + ", fourk=" + z + ", codecType=" + i12 + ", voiceBalance=" + j + ", needTrial=" + z2 + ", attribute=" + this.attribute + ")";
    }

    /* compiled from: VideoPlayInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/model/model/VideoPlayInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoPlayInfo> serializer() {
            return VideoPlayInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ VideoPlayInfo(int seen0, int videoId, int audioId, String videoMd5, String audioMd5, int videoCodecid, int audioCodecid, int dashDrmType, String biliDrmUri, int preferredAudioQuality, int realAudioQuality, int audioType, int qn, int fnver, int fnval, boolean fourk, int codecType, long voiceBalance, boolean needTrial, long attribute, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.videoId = 0;
        } else {
            this.videoId = videoId;
        }
        if ((seen0 & 2) == 0) {
            this.audioId = 0;
        } else {
            this.audioId = audioId;
        }
        if ((seen0 & 4) == 0) {
            this.videoMd5 = "";
        } else {
            this.videoMd5 = videoMd5;
        }
        if ((seen0 & 8) == 0) {
            this.audioMd5 = "";
        } else {
            this.audioMd5 = audioMd5;
        }
        if ((seen0 & 16) == 0) {
            this.videoCodecid = 0;
        } else {
            this.videoCodecid = videoCodecid;
        }
        if ((seen0 & 32) == 0) {
            this.audioCodecid = 0;
        } else {
            this.audioCodecid = audioCodecid;
        }
        if ((seen0 & 64) == 0) {
            this.dashDrmType = 0;
        } else {
            this.dashDrmType = dashDrmType;
        }
        if ((seen0 & 128) == 0) {
            this.biliDrmUri = "";
        } else {
            this.biliDrmUri = biliDrmUri;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.preferredAudioQuality = 0;
        } else {
            this.preferredAudioQuality = preferredAudioQuality;
        }
        if ((seen0 & 512) == 0) {
            this.realAudioQuality = 0;
        } else {
            this.realAudioQuality = realAudioQuality;
        }
        if ((seen0 & 1024) == 0) {
            this.audioType = 0;
        } else {
            this.audioType = audioType;
        }
        if ((seen0 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
            this.qn = 0;
        } else {
            this.qn = qn;
        }
        if ((seen0 & 4096) == 0) {
            this.fnver = 0;
        } else {
            this.fnver = fnver;
        }
        if ((seen0 & 8192) == 0) {
            this.fnval = 0;
        } else {
            this.fnval = fnval;
        }
        if ((seen0 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) == 0) {
            this.fourk = false;
        } else {
            this.fourk = fourk;
        }
        if ((seen0 & 32768) == 0) {
            this.codecType = 0;
        } else {
            this.codecType = codecType;
        }
        if ((seen0 & 65536) == 0) {
            this.voiceBalance = 0L;
        } else {
            this.voiceBalance = voiceBalance;
        }
        if ((seen0 & 131072) == 0) {
            this.needTrial = false;
        } else {
            this.needTrial = needTrial;
        }
        if ((262144 & seen0) == 0) {
            this.attribute = 0L;
        } else {
            this.attribute = attribute;
        }
    }

    public VideoPlayInfo(int videoId, int audioId, String videoMd5, String audioMd5, int videoCodecid, int audioCodecid, int dashDrmType, String biliDrmUri, int preferredAudioQuality, int realAudioQuality, int audioType, int qn, int fnver, int fnval, boolean fourk, int codecType, long voiceBalance, boolean needTrial, long attribute) {
        Intrinsics.checkNotNullParameter(videoMd5, "videoMd5");
        Intrinsics.checkNotNullParameter(audioMd5, "audioMd5");
        Intrinsics.checkNotNullParameter(biliDrmUri, "biliDrmUri");
        this.videoId = videoId;
        this.audioId = audioId;
        this.videoMd5 = videoMd5;
        this.audioMd5 = audioMd5;
        this.videoCodecid = videoCodecid;
        this.audioCodecid = audioCodecid;
        this.dashDrmType = dashDrmType;
        this.biliDrmUri = biliDrmUri;
        this.preferredAudioQuality = preferredAudioQuality;
        this.realAudioQuality = realAudioQuality;
        this.audioType = audioType;
        this.qn = qn;
        this.fnver = fnver;
        this.fnval = fnval;
        this.fourk = fourk;
        this.codecType = codecType;
        this.voiceBalance = voiceBalance;
        this.needTrial = needTrial;
        this.attribute = attribute;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$model_debug(VideoPlayInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.videoId != 0) {
            output.encodeIntElement(serialDesc, 0, self.videoId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.audioId != 0) {
            output.encodeIntElement(serialDesc, 1, self.audioId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.videoMd5, "")) {
            output.encodeStringElement(serialDesc, 2, self.videoMd5);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.audioMd5, "")) {
            output.encodeStringElement(serialDesc, 3, self.audioMd5);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.videoCodecid != 0) {
            output.encodeIntElement(serialDesc, 4, self.videoCodecid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.audioCodecid != 0) {
            output.encodeIntElement(serialDesc, 5, self.audioCodecid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.dashDrmType != 0) {
            output.encodeIntElement(serialDesc, 6, self.dashDrmType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.biliDrmUri, "")) {
            output.encodeStringElement(serialDesc, 7, self.biliDrmUri);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.preferredAudioQuality != 0) {
            output.encodeIntElement(serialDesc, 8, self.preferredAudioQuality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.realAudioQuality != 0) {
            output.encodeIntElement(serialDesc, 9, self.realAudioQuality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.audioType != 0) {
            output.encodeIntElement(serialDesc, 10, self.audioType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.qn != 0) {
            output.encodeIntElement(serialDesc, 11, self.qn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.fnver != 0) {
            output.encodeIntElement(serialDesc, 12, self.fnver);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.fnval != 0) {
            output.encodeIntElement(serialDesc, 13, self.fnval);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.fourk) {
            output.encodeBooleanElement(serialDesc, 14, self.fourk);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.codecType != 0) {
            output.encodeIntElement(serialDesc, 15, self.codecType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.voiceBalance != 0) {
            output.encodeLongElement(serialDesc, 16, self.voiceBalance);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.needTrial) {
            output.encodeBooleanElement(serialDesc, 17, self.needTrial);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.attribute != 0) {
            output.encodeLongElement(serialDesc, 18, self.attribute);
        }
    }

    public /* synthetic */ VideoPlayInfo(int i, int i2, String str, String str2, int i3, int i4, int i5, String str3, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12, long j, boolean z2, long j2, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i, (i13 & 2) != 0 ? 0 : i2, (i13 & 4) != 0 ? "" : str, (i13 & 8) != 0 ? "" : str2, (i13 & 16) != 0 ? 0 : i3, (i13 & 32) != 0 ? 0 : i4, (i13 & 64) != 0 ? 0 : i5, (i13 & 128) == 0 ? str3 : "", (i13 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i6, (i13 & 512) != 0 ? 0 : i7, (i13 & 1024) != 0 ? 0 : i8, (i13 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? 0 : i9, (i13 & 4096) != 0 ? 0 : i10, (i13 & 8192) != 0 ? 0 : i11, (i13 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? false : z, (i13 & 32768) != 0 ? 0 : i12, (i13 & 65536) != 0 ? 0L : j, (i13 & 131072) != 0 ? false : z2, (i13 & 262144) == 0 ? j2 : 0L);
    }

    public final int getVideoId() {
        return this.videoId;
    }

    public final void setVideoId(int i) {
        this.videoId = i;
    }

    public final int getAudioId() {
        return this.audioId;
    }

    public final void setAudioId(int i) {
        this.audioId = i;
    }

    public final String getVideoMd5() {
        return this.videoMd5;
    }

    public final void setVideoMd5(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoMd5 = str;
    }

    public final String getAudioMd5() {
        return this.audioMd5;
    }

    public final void setAudioMd5(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.audioMd5 = str;
    }

    public final int getVideoCodecid() {
        return this.videoCodecid;
    }

    public final void setVideoCodecid(int i) {
        this.videoCodecid = i;
    }

    public final int getAudioCodecid() {
        return this.audioCodecid;
    }

    public final void setAudioCodecid(int i) {
        this.audioCodecid = i;
    }

    public final int getDashDrmType() {
        return this.dashDrmType;
    }

    public final void setDashDrmType(int i) {
        this.dashDrmType = i;
    }

    public final String getBiliDrmUri() {
        return this.biliDrmUri;
    }

    public final void setBiliDrmUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.biliDrmUri = str;
    }

    public final int getPreferredAudioQuality() {
        return this.preferredAudioQuality;
    }

    public final void setPreferredAudioQuality(int i) {
        this.preferredAudioQuality = i;
    }

    public final int getRealAudioQuality() {
        return this.realAudioQuality;
    }

    public final void setRealAudioQuality(int i) {
        this.realAudioQuality = i;
    }

    public final int getAudioType() {
        return this.audioType;
    }

    public final void setAudioType(int i) {
        this.audioType = i;
    }

    public final int getQn() {
        return this.qn;
    }

    public final void setQn(int i) {
        this.qn = i;
    }

    public final int getFnver() {
        return this.fnver;
    }

    public final void setFnver(int i) {
        this.fnver = i;
    }

    public final int getFnval() {
        return this.fnval;
    }

    public final void setFnval(int i) {
        this.fnval = i;
    }

    public final boolean getFourk() {
        return this.fourk;
    }

    public final void setFourk(boolean z) {
        this.fourk = z;
    }

    public final int getCodecType() {
        return this.codecType;
    }

    public final void setCodecType(int i) {
        this.codecType = i;
    }

    public final long getVoiceBalance() {
        return this.voiceBalance;
    }

    public final void setVoiceBalance(long j) {
        this.voiceBalance = j;
    }

    public final boolean getNeedTrial() {
        return this.needTrial;
    }

    public final void setNeedTrial(boolean z) {
        this.needTrial = z;
    }

    public final long getAttribute() {
        return this.attribute;
    }

    public final void setAttribute(long j) {
        this.attribute = j;
    }
}