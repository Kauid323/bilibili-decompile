package video.common.sharedata.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoShareData.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002/0B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J;\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0005\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001a¨\u00061"}, d2 = {"Lvideo/common/sharedata/model/VideoShareUPInfo;", "", "upName", "", "upFace", "isAttention", "", "fans", "", "upMid", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUpName$annotations", "()V", "getUpName", "()Ljava/lang/String;", "getUpFace$annotations", "getUpFace", "isAttention$annotations", "()Z", "getFans", "()J", "getUpMid$annotations", "getUpMid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sharedata_debug", "Companion", "$serializer", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VideoShareUPInfo {
    public static final Companion Companion = new Companion(null);
    private final long fans;
    private final boolean isAttention;
    private final String upFace;
    private final long upMid;
    private final String upName;

    public VideoShareUPInfo() {
        this((String) null, (String) null, false, 0L, 0L, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoShareUPInfo copy$default(VideoShareUPInfo videoShareUPInfo, String str, String str2, boolean z, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoShareUPInfo.upName;
        }
        if ((i & 2) != 0) {
            str2 = videoShareUPInfo.upFace;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = videoShareUPInfo.isAttention;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = videoShareUPInfo.fans;
        }
        long j3 = j;
        if ((i & 16) != 0) {
            j2 = videoShareUPInfo.upMid;
        }
        return videoShareUPInfo.copy(str, str3, z2, j3, j2);
    }

    @SerialName("up_face")
    public static /* synthetic */ void getUpFace$annotations() {
    }

    @SerialName("up_id")
    public static /* synthetic */ void getUpMid$annotations() {
    }

    @SerialName("up_name")
    public static /* synthetic */ void getUpName$annotations() {
    }

    @SerialName("is_attention")
    public static /* synthetic */ void isAttention$annotations() {
    }

    public final String component1() {
        return this.upName;
    }

    public final String component2() {
        return this.upFace;
    }

    public final boolean component3() {
        return this.isAttention;
    }

    public final long component4() {
        return this.fans;
    }

    public final long component5() {
        return this.upMid;
    }

    public final VideoShareUPInfo copy(String str, String str2, boolean z, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "upName");
        Intrinsics.checkNotNullParameter(str2, "upFace");
        return new VideoShareUPInfo(str, str2, z, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoShareUPInfo) {
            VideoShareUPInfo videoShareUPInfo = (VideoShareUPInfo) obj;
            return Intrinsics.areEqual(this.upName, videoShareUPInfo.upName) && Intrinsics.areEqual(this.upFace, videoShareUPInfo.upFace) && this.isAttention == videoShareUPInfo.isAttention && this.fans == videoShareUPInfo.fans && this.upMid == videoShareUPInfo.upMid;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.upName.hashCode() * 31) + this.upFace.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAttention)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fans)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.upMid);
    }

    public String toString() {
        String str = this.upName;
        String str2 = this.upFace;
        boolean z = this.isAttention;
        long j = this.fans;
        return "VideoShareUPInfo(upName=" + str + ", upFace=" + str2 + ", isAttention=" + z + ", fans=" + j + ", upMid=" + this.upMid + ")";
    }

    public /* synthetic */ VideoShareUPInfo(int seen0, String upName, String upFace, boolean isAttention, long fans, long upMid, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.upName = "";
        } else {
            this.upName = upName;
        }
        if ((seen0 & 2) == 0) {
            this.upFace = "";
        } else {
            this.upFace = upFace;
        }
        if ((seen0 & 4) == 0) {
            this.isAttention = false;
        } else {
            this.isAttention = isAttention;
        }
        if ((seen0 & 8) == 0) {
            this.fans = 0L;
        } else {
            this.fans = fans;
        }
        if ((seen0 & 16) == 0) {
            this.upMid = 0L;
        } else {
            this.upMid = upMid;
        }
    }

    public VideoShareUPInfo(String upName, String upFace, boolean isAttention, long fans, long upMid) {
        Intrinsics.checkNotNullParameter(upName, "upName");
        Intrinsics.checkNotNullParameter(upFace, "upFace");
        this.upName = upName;
        this.upFace = upFace;
        this.isAttention = isAttention;
        this.fans = fans;
        this.upMid = upMid;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sharedata_debug(VideoShareUPInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.upName, "")) {
            output.encodeStringElement(serialDesc, 0, self.upName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.upFace, "")) {
            output.encodeStringElement(serialDesc, 1, self.upFace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isAttention) {
            output.encodeBooleanElement(serialDesc, 2, self.isAttention);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fans != 0) {
            output.encodeLongElement(serialDesc, 3, self.fans);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.upMid != 0) {
            output.encodeLongElement(serialDesc, 4, self.upMid);
        }
    }

    public /* synthetic */ VideoShareUPInfo(String str, String str2, boolean z, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? false : z, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? 0L : j2);
    }

    public final String getUpName() {
        return this.upName;
    }

    public final String getUpFace() {
        return this.upFace;
    }

    public final boolean isAttention() {
        return this.isAttention;
    }

    public final long getFans() {
        return this.fans;
    }

    public final long getUpMid() {
        return this.upMid;
    }

    /* compiled from: VideoShareData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000b"}, d2 = {"Lvideo/common/sharedata/model/VideoShareUPInfo$Companion;", "", "<init>", "()V", "init", "Lvideo/common/sharedata/model/VideoShareUPInfo;", "fromJson", "jsonString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoShareUPInfo> serializer() {
            return VideoShareUPInfo$$serializer.INSTANCE;
        }

        public final VideoShareUPInfo init() {
            return new VideoShareUPInfo((String) null, (String) null, false, 0L, 0L, 31, (DefaultConstructorMarker) null);
        }

        public final VideoShareUPInfo fromJson(String jsonString) {
            Object obj = null;
            if (jsonString != null) {
                try {
                    String decodedString$iv = CodecsKt.decodeURLPart$default(jsonString, 0, 0, (Charset) null, 7, (Object) null);
                    if (decodedString$iv != null && !StringsKt.isBlank(decodedString$iv)) {
                        Json this_$iv$iv = VideoShareDataKt.json;
                        this_$iv$iv.getSerializersModule();
                        obj = this_$iv$iv.decodeFromString(VideoShareUPInfo.Companion.serializer(), decodedString$iv);
                    }
                } catch (Exception e) {
                }
            }
            return (VideoShareUPInfo) obj;
        }
    }
}