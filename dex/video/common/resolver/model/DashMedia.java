package video.common.resolver.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: DashMedia.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0002OPB\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016B\u009d\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\u009b\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0013\u0010C\u001a\u00020\u000f2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001J%\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0001¢\u0006\u0002\bNR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010-R\u001c\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 ¨\u0006Q"}, d2 = {"Lvideo/common/resolver/model/DashMedia;", "", "id", "", "baseUrl", "", "backupUrl", "", "bandwidth", "codecid", "md5", "size", "", "audioId", "noRexcode", "", "frameRate", "width", "height", "widevinePssh", "bilidrmUri", "<init>", "(ILjava/lang/String;Ljava/util/List;IILjava/lang/String;JIZLjava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/util/List;IILjava/lang/String;JIZLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getBaseUrl$annotations", "()V", "getBaseUrl", "()Ljava/lang/String;", "getBackupUrl$annotations", "getBackupUrl", "()Ljava/util/List;", "getBandwidth", "getCodecid", "getMd5", "getSize", "()J", "getAudioId$annotations", "getAudioId", "getNoRexcode$annotations", "getNoRexcode", "()Z", "getFrameRate$annotations", "getFrameRate", "getWidth", "getHeight", "getWidevinePssh", "getBilidrmUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$resolver_debug", "$serializer", "Companion", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DashMedia {
    private final int audioId;
    private final List<String> backupUrl;
    private final int bandwidth;
    private final String baseUrl;
    private final String bilidrmUri;
    private final int codecid;
    private final String frameRate;
    private final int height;
    private final int id;
    private final String md5;
    private final boolean noRexcode;
    private final long size;
    private final String widevinePssh;
    private final int width;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.common.resolver.model.DashMedia$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DashMedia._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, null, null};

    public DashMedia() {
        this(0, (String) null, (List) null, 0, 0, (String) null, 0L, 0, false, (String) null, 0, 0, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    @SerialName("audio_id")
    public static /* synthetic */ void getAudioId$annotations() {
    }

    @SerialName("backup_url")
    public static /* synthetic */ void getBackupUrl$annotations() {
    }

    @SerialName(IjkMediaMeta.IJKM_ASSET_KEY_BASE_URL)
    public static /* synthetic */ void getBaseUrl$annotations() {
    }

    @SerialName("frame_rate")
    public static /* synthetic */ void getFrameRate$annotations() {
    }

    @SerialName("no_rexcode")
    public static /* synthetic */ void getNoRexcode$annotations() {
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.frameRate;
    }

    public final int component11() {
        return this.width;
    }

    public final int component12() {
        return this.height;
    }

    public final String component13() {
        return this.widevinePssh;
    }

    public final String component14() {
        return this.bilidrmUri;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final List<String> component3() {
        return this.backupUrl;
    }

    public final int component4() {
        return this.bandwidth;
    }

    public final int component5() {
        return this.codecid;
    }

    public final String component6() {
        return this.md5;
    }

    public final long component7() {
        return this.size;
    }

    public final int component8() {
        return this.audioId;
    }

    public final boolean component9() {
        return this.noRexcode;
    }

    public final DashMedia copy(int i, String str, List<String> list, int i2, int i3, String str2, long j, int i4, boolean z, String str3, int i5, int i6, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(list, "backupUrl");
        Intrinsics.checkNotNullParameter(str2, "md5");
        Intrinsics.checkNotNullParameter(str3, "frameRate");
        Intrinsics.checkNotNullParameter(str4, "widevinePssh");
        Intrinsics.checkNotNullParameter(str5, "bilidrmUri");
        return new DashMedia(i, str, list, i2, i3, str2, j, i4, z, str3, i5, i6, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DashMedia) {
            DashMedia dashMedia = (DashMedia) obj;
            return this.id == dashMedia.id && Intrinsics.areEqual(this.baseUrl, dashMedia.baseUrl) && Intrinsics.areEqual(this.backupUrl, dashMedia.backupUrl) && this.bandwidth == dashMedia.bandwidth && this.codecid == dashMedia.codecid && Intrinsics.areEqual(this.md5, dashMedia.md5) && this.size == dashMedia.size && this.audioId == dashMedia.audioId && this.noRexcode == dashMedia.noRexcode && Intrinsics.areEqual(this.frameRate, dashMedia.frameRate) && this.width == dashMedia.width && this.height == dashMedia.height && Intrinsics.areEqual(this.widevinePssh, dashMedia.widevinePssh) && Intrinsics.areEqual(this.bilidrmUri, dashMedia.bilidrmUri);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.id * 31) + this.baseUrl.hashCode()) * 31) + this.backupUrl.hashCode()) * 31) + this.bandwidth) * 31) + this.codecid) * 31) + this.md5.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.size)) * 31) + this.audioId) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.noRexcode)) * 31) + this.frameRate.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.widevinePssh.hashCode()) * 31) + this.bilidrmUri.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.baseUrl;
        List<String> list = this.backupUrl;
        int i2 = this.bandwidth;
        int i3 = this.codecid;
        String str2 = this.md5;
        long j = this.size;
        int i4 = this.audioId;
        boolean z = this.noRexcode;
        String str3 = this.frameRate;
        int i5 = this.width;
        int i6 = this.height;
        String str4 = this.widevinePssh;
        return "DashMedia(id=" + i + ", baseUrl=" + str + ", backupUrl=" + list + ", bandwidth=" + i2 + ", codecid=" + i3 + ", md5=" + str2 + ", size=" + j + ", audioId=" + i4 + ", noRexcode=" + z + ", frameRate=" + str3 + ", width=" + i5 + ", height=" + i6 + ", widevinePssh=" + str4 + ", bilidrmUri=" + this.bilidrmUri + ")";
    }

    /* compiled from: DashMedia.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/common/resolver/model/DashMedia$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/common/resolver/model/DashMedia;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DashMedia> serializer() {
            return DashMedia$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DashMedia(int seen0, int id, String baseUrl, List backupUrl, int bandwidth, int codecid, String md5, long size, int audioId, boolean noRexcode, String frameRate, int width, int height, String widevinePssh, String bilidrmUri, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.id = 0;
        } else {
            this.id = id;
        }
        if ((seen0 & 2) == 0) {
            this.baseUrl = "";
        } else {
            this.baseUrl = baseUrl;
        }
        if ((seen0 & 4) == 0) {
            this.backupUrl = CollectionsKt.emptyList();
        } else {
            this.backupUrl = backupUrl;
        }
        if ((seen0 & 8) == 0) {
            this.bandwidth = 0;
        } else {
            this.bandwidth = bandwidth;
        }
        if ((seen0 & 16) == 0) {
            this.codecid = 0;
        } else {
            this.codecid = codecid;
        }
        if ((seen0 & 32) == 0) {
            this.md5 = "";
        } else {
            this.md5 = md5;
        }
        if ((seen0 & 64) == 0) {
            this.size = 0L;
        } else {
            this.size = size;
        }
        if ((seen0 & 128) == 0) {
            this.audioId = 0;
        } else {
            this.audioId = audioId;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.noRexcode = false;
        } else {
            this.noRexcode = noRexcode;
        }
        if ((seen0 & 512) == 0) {
            this.frameRate = "";
        } else {
            this.frameRate = frameRate;
        }
        if ((seen0 & 1024) == 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
        if ((seen0 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
        if ((seen0 & 4096) == 0) {
            this.widevinePssh = "";
        } else {
            this.widevinePssh = widevinePssh;
        }
        if ((seen0 & 8192) == 0) {
            this.bilidrmUri = "";
        } else {
            this.bilidrmUri = bilidrmUri;
        }
    }

    public DashMedia(int id, String baseUrl, List<String> list, int bandwidth, int codecid, String md5, long size, int audioId, boolean noRexcode, String frameRate, int width, int height, String widevinePssh, String bilidrmUri) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(list, "backupUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(frameRate, "frameRate");
        Intrinsics.checkNotNullParameter(widevinePssh, "widevinePssh");
        Intrinsics.checkNotNullParameter(bilidrmUri, "bilidrmUri");
        this.id = id;
        this.baseUrl = baseUrl;
        this.backupUrl = list;
        this.bandwidth = bandwidth;
        this.codecid = codecid;
        this.md5 = md5;
        this.size = size;
        this.audioId = audioId;
        this.noRexcode = noRexcode;
        this.frameRate = frameRate;
        this.width = width;
        this.height = height;
        this.widevinePssh = widevinePssh;
        this.bilidrmUri = bilidrmUri;
    }

    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$resolver_debug(DashMedia self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeIntElement(serialDesc, 0, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.baseUrl, "")) {
            output.encodeStringElement(serialDesc, 1, self.baseUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.backupUrl, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.backupUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bandwidth != 0) {
            output.encodeIntElement(serialDesc, 3, self.bandwidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.codecid != 0) {
            output.encodeIntElement(serialDesc, 4, self.codecid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.md5, "")) {
            output.encodeStringElement(serialDesc, 5, self.md5);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.size != 0) {
            output.encodeLongElement(serialDesc, 6, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.audioId != 0) {
            output.encodeIntElement(serialDesc, 7, self.audioId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.noRexcode) {
            output.encodeBooleanElement(serialDesc, 8, self.noRexcode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.frameRate, "")) {
            output.encodeStringElement(serialDesc, 9, self.frameRate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.width != 0) {
            output.encodeIntElement(serialDesc, 10, self.width);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.height != 0) {
            output.encodeIntElement(serialDesc, 11, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.widevinePssh, "")) {
            output.encodeStringElement(serialDesc, 12, self.widevinePssh);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.bilidrmUri, "")) {
            output.encodeStringElement(serialDesc, 13, self.bilidrmUri);
        }
    }

    public /* synthetic */ DashMedia(int i, String str, List list, int i2, int i3, String str2, long j, int i4, boolean z, String str3, int i5, int i6, String str4, String str5, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? "" : str, (i7 & 4) != 0 ? CollectionsKt.emptyList() : list, (i7 & 8) != 0 ? 0 : i2, (i7 & 16) != 0 ? 0 : i3, (i7 & 32) != 0 ? "" : str2, (i7 & 64) != 0 ? 0L : j, (i7 & 128) != 0 ? 0 : i4, (i7 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? false : z, (i7 & 512) != 0 ? "" : str3, (i7 & 1024) != 0 ? 0 : i5, (i7 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0 ? i6 : 0, (i7 & 4096) != 0 ? "" : str4, (i7 & 8192) == 0 ? str5 : "");
    }

    public final int getId() {
        return this.id;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final List<String> getBackupUrl() {
        return this.backupUrl;
    }

    public final int getBandwidth() {
        return this.bandwidth;
    }

    public final int getCodecid() {
        return this.codecid;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getAudioId() {
        return this.audioId;
    }

    public final boolean getNoRexcode() {
        return this.noRexcode;
    }

    public final String getFrameRate() {
        return this.frameRate;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getWidevinePssh() {
        return this.widevinePssh;
    }

    public final String getBilidrmUri() {
        return this.bilidrmUri;
    }
}