package video.common.sharedata.model;

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
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoShareData.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000245BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003JO\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000eHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u00066"}, d2 = {"Lvideo/common/sharedata/model/VideoShareArcInfo;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "viewContent", "like", "", "reply", "coin", "favorite", "share", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getViewContent$annotations", "()V", "getViewContent", "getLike", "()J", "getReply", "getCoin", "setCoin", "(J)V", "getFavorite", "getShare", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sharedata_debug", "Companion", "$serializer", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VideoShareArcInfo {
    public static final Companion Companion = new Companion(null);
    private long coin;
    private final long favorite;
    private final long like;
    private final long reply;
    private final long share;
    private final String title;
    private final String viewContent;

    public VideoShareArcInfo() {
        this((String) null, (String) null, 0L, 0L, 0L, 0L, 0L, 127, (DefaultConstructorMarker) null);
    }

    @SerialName("view_content")
    public static /* synthetic */ void getViewContent$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.viewContent;
    }

    public final long component3() {
        return this.like;
    }

    public final long component4() {
        return this.reply;
    }

    public final long component5() {
        return this.coin;
    }

    public final long component6() {
        return this.favorite;
    }

    public final long component7() {
        return this.share;
    }

    public final VideoShareArcInfo copy(String str, String str2, long j, long j2, long j3, long j4, long j5) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(str2, "viewContent");
        return new VideoShareArcInfo(str, str2, j, j2, j3, j4, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoShareArcInfo) {
            VideoShareArcInfo videoShareArcInfo = (VideoShareArcInfo) obj;
            return Intrinsics.areEqual(this.title, videoShareArcInfo.title) && Intrinsics.areEqual(this.viewContent, videoShareArcInfo.viewContent) && this.like == videoShareArcInfo.like && this.reply == videoShareArcInfo.reply && this.coin == videoShareArcInfo.coin && this.favorite == videoShareArcInfo.favorite && this.share == videoShareArcInfo.share;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.title.hashCode() * 31) + this.viewContent.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.like)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.reply)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.coin)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.favorite)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.share);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.viewContent;
        long j = this.like;
        long j2 = this.reply;
        long j3 = this.coin;
        long j4 = this.favorite;
        return "VideoShareArcInfo(title=" + str + ", viewContent=" + str2 + ", like=" + j + ", reply=" + j2 + ", coin=" + j3 + ", favorite=" + j4 + ", share=" + this.share + ")";
    }

    public /* synthetic */ VideoShareArcInfo(int seen0, String title, String viewContent, long like, long reply, long coin, long favorite, long share, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.title = "";
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.viewContent = "";
        } else {
            this.viewContent = viewContent;
        }
        if ((seen0 & 4) == 0) {
            this.like = 0L;
        } else {
            this.like = like;
        }
        if ((seen0 & 8) == 0) {
            this.reply = 0L;
        } else {
            this.reply = reply;
        }
        if ((seen0 & 16) == 0) {
            this.coin = 0L;
        } else {
            this.coin = coin;
        }
        if ((seen0 & 32) == 0) {
            this.favorite = 0L;
        } else {
            this.favorite = favorite;
        }
        if ((seen0 & 64) == 0) {
            this.share = 0L;
        } else {
            this.share = share;
        }
    }

    public VideoShareArcInfo(String title, String viewContent, long like, long reply, long coin, long favorite, long share) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(viewContent, "viewContent");
        this.title = title;
        this.viewContent = viewContent;
        this.like = like;
        this.reply = reply;
        this.coin = coin;
        this.favorite = favorite;
        this.share = share;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sharedata_debug(VideoShareArcInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.title, "")) {
            output.encodeStringElement(serialDesc, 0, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.viewContent, "")) {
            output.encodeStringElement(serialDesc, 1, self.viewContent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.like != 0) {
            output.encodeLongElement(serialDesc, 2, self.like);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.reply != 0) {
            output.encodeLongElement(serialDesc, 3, self.reply);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.coin != 0) {
            output.encodeLongElement(serialDesc, 4, self.coin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.favorite != 0) {
            output.encodeLongElement(serialDesc, 5, self.favorite);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.share != 0) {
            output.encodeLongElement(serialDesc, 6, self.share);
        }
    }

    public /* synthetic */ VideoShareArcInfo(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? 0L : j2, (i & 16) != 0 ? 0L : j3, (i & 32) != 0 ? 0L : j4, (i & 64) == 0 ? j5 : 0L);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getViewContent() {
        return this.viewContent;
    }

    public final long getLike() {
        return this.like;
    }

    public final long getReply() {
        return this.reply;
    }

    public final long getCoin() {
        return this.coin;
    }

    public final void setCoin(long j) {
        this.coin = j;
    }

    public final long getFavorite() {
        return this.favorite;
    }

    public final long getShare() {
        return this.share;
    }

    /* compiled from: VideoShareData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000b"}, d2 = {"Lvideo/common/sharedata/model/VideoShareArcInfo$Companion;", "", "<init>", "()V", "init", "Lvideo/common/sharedata/model/VideoShareArcInfo;", "fromJson", "jsonString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoShareArcInfo> serializer() {
            return VideoShareArcInfo$$serializer.INSTANCE;
        }

        public final VideoShareArcInfo init() {
            return new VideoShareArcInfo((String) null, (String) null, 0L, 0L, 0L, 0L, 0L, 127, (DefaultConstructorMarker) null);
        }

        public final VideoShareArcInfo fromJson(String jsonString) {
            Object obj = null;
            if (jsonString != null) {
                try {
                    String decodedString$iv = CodecsKt.decodeURLPart$default(jsonString, 0, 0, (Charset) null, 7, (Object) null);
                    if (decodedString$iv != null && !StringsKt.isBlank(decodedString$iv)) {
                        Json this_$iv$iv = VideoShareDataKt.json;
                        this_$iv$iv.getSerializersModule();
                        obj = this_$iv$iv.decodeFromString(VideoShareArcInfo.Companion.serializer(), decodedString$iv);
                    }
                } catch (Exception e) {
                }
            }
            return (VideoShareArcInfo) obj;
        }
    }
}