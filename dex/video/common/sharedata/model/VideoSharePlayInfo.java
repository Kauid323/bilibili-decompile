package video.common.sharedata.model;

import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoShareData.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lvideo/common/sharedata/model/VideoSharePlayInfo;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sharedata_debug", "Companion", "$serializer", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VideoSharePlayInfo {
    public static final Companion Companion = new Companion(null);
    private final String url;

    public VideoSharePlayInfo() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoSharePlayInfo copy$default(VideoSharePlayInfo videoSharePlayInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoSharePlayInfo.url;
        }
        return videoSharePlayInfo.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final VideoSharePlayInfo copy(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new VideoSharePlayInfo(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoSharePlayInfo) && Intrinsics.areEqual(this.url, ((VideoSharePlayInfo) obj).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "VideoSharePlayInfo(url=" + this.url + ")";
    }

    public /* synthetic */ VideoSharePlayInfo(int seen0, String url, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.url = "";
        } else {
            this.url = url;
        }
    }

    public VideoSharePlayInfo(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sharedata_debug(VideoSharePlayInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.url, "")) {
            z = false;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 0, self.url);
        }
    }

    public /* synthetic */ VideoSharePlayInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getUrl() {
        return this.url;
    }

    /* compiled from: VideoShareData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000b"}, d2 = {"Lvideo/common/sharedata/model/VideoSharePlayInfo$Companion;", "", "<init>", "()V", "init", "Lvideo/common/sharedata/model/VideoSharePlayInfo;", "fromJson", "jsonString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoSharePlayInfo> serializer() {
            return VideoSharePlayInfo$$serializer.INSTANCE;
        }

        public final VideoSharePlayInfo init() {
            return new VideoSharePlayInfo((String) null, 1, (DefaultConstructorMarker) null);
        }

        public final VideoSharePlayInfo fromJson(String jsonString) {
            Object obj = null;
            if (jsonString != null) {
                try {
                    String decodedString$iv = CodecsKt.decodeURLPart$default(jsonString, 0, 0, (Charset) null, 7, (Object) null);
                    if (decodedString$iv != null && !StringsKt.isBlank(decodedString$iv)) {
                        Json this_$iv$iv = VideoShareDataKt.json;
                        this_$iv$iv.getSerializersModule();
                        obj = this_$iv$iv.decodeFromString(VideoSharePlayInfo.Companion.serializer(), decodedString$iv);
                    }
                } catch (Exception e) {
                }
            }
            return (VideoSharePlayInfo) obj;
        }
    }
}