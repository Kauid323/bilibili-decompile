package kntr.app.upcomingEpisode.list.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: VideoUploadCalendar.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0001HÆ\u0003Jg\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0001HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000eHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u001c\u0010\n\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$¨\u0006="}, d2 = {"Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;", "", "cover", "", "title", "upIcon", "upName", "updateTime", "url", "videoDuration", "randomKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCover$annotations", "()V", "getCover", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "getUpIcon$annotations", "getUpIcon", "getUpName$annotations", "getUpName", "getUpdateTime$annotations", "getUpdateTime", "getUrl$annotations", "getUrl", "getVideoDuration$annotations", "getVideoDuration", "getRandomKey$annotations", "getRandomKey", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$main_debug", "$serializer", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class UnwatchedVideo {
    private final String cover;
    private final Object randomKey;
    private final String title;
    private final String upIcon;
    private final String upName;
    private final String updateTime;
    private final String url;
    private final String videoDuration;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UnwatchedVideo() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @Transient
    public static /* synthetic */ void getRandomKey$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("up_icon")
    public static /* synthetic */ void getUpIcon$annotations() {
    }

    @SerialName("up_name")
    public static /* synthetic */ void getUpName$annotations() {
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("video_duration")
    public static /* synthetic */ void getVideoDuration$annotations() {
    }

    public final String component1() {
        return this.cover;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.upIcon;
    }

    public final String component4() {
        return this.upName;
    }

    public final String component5() {
        return this.updateTime;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.videoDuration;
    }

    public final Object component8() {
        return this.randomKey;
    }

    public final UnwatchedVideo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "randomKey");
        return new UnwatchedVideo(str, str2, str3, str4, str5, str6, str7, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnwatchedVideo) {
            UnwatchedVideo unwatchedVideo = (UnwatchedVideo) obj;
            return Intrinsics.areEqual(this.cover, unwatchedVideo.cover) && Intrinsics.areEqual(this.title, unwatchedVideo.title) && Intrinsics.areEqual(this.upIcon, unwatchedVideo.upIcon) && Intrinsics.areEqual(this.upName, unwatchedVideo.upName) && Intrinsics.areEqual(this.updateTime, unwatchedVideo.updateTime) && Intrinsics.areEqual(this.url, unwatchedVideo.url) && Intrinsics.areEqual(this.videoDuration, unwatchedVideo.videoDuration) && Intrinsics.areEqual(this.randomKey, unwatchedVideo.randomKey);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.cover == null ? 0 : this.cover.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.upIcon == null ? 0 : this.upIcon.hashCode())) * 31) + (this.upName == null ? 0 : this.upName.hashCode())) * 31) + (this.updateTime == null ? 0 : this.updateTime.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.videoDuration != null ? this.videoDuration.hashCode() : 0)) * 31) + this.randomKey.hashCode();
    }

    public String toString() {
        String str = this.cover;
        String str2 = this.title;
        String str3 = this.upIcon;
        String str4 = this.upName;
        String str5 = this.updateTime;
        String str6 = this.url;
        String str7 = this.videoDuration;
        return "UnwatchedVideo(cover=" + str + ", title=" + str2 + ", upIcon=" + str3 + ", upName=" + str4 + ", updateTime=" + str5 + ", url=" + str6 + ", videoDuration=" + str7 + ", randomKey=" + this.randomKey + ")";
    }

    /* compiled from: VideoUploadCalendar.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UnwatchedVideo> serializer() {
            return UnwatchedVideo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UnwatchedVideo(int seen0, String cover, String title, String upIcon, String upName, String updateTime, String url, String videoDuration, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.cover = null;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 2) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 4) == 0) {
            this.upIcon = null;
        } else {
            this.upIcon = upIcon;
        }
        if ((seen0 & 8) == 0) {
            this.upName = null;
        } else {
            this.upName = upName;
        }
        if ((seen0 & 16) == 0) {
            this.updateTime = null;
        } else {
            this.updateTime = updateTime;
        }
        if ((seen0 & 32) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 64) == 0) {
            this.videoDuration = null;
        } else {
            this.videoDuration = videoDuration;
        }
        this.randomKey = "";
    }

    public UnwatchedVideo(String cover, String title, String upIcon, String upName, String updateTime, String url, String videoDuration, Object randomKey) {
        Intrinsics.checkNotNullParameter(randomKey, "randomKey");
        this.cover = cover;
        this.title = title;
        this.upIcon = upIcon;
        this.upName = upName;
        this.updateTime = updateTime;
        this.url = url;
        this.videoDuration = videoDuration;
        this.randomKey = randomKey;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$main_debug(UnwatchedVideo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.cover != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.upIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.upIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.upName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.upName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.updateTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.updateTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.videoDuration != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.videoDuration);
        }
    }

    public /* synthetic */ UnwatchedVideo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) == 0 ? str7 : null, (i & 128) != 0 ? "" : obj);
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUpIcon() {
        return this.upIcon;
    }

    public final String getUpName() {
        return this.upName;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVideoDuration() {
        return this.videoDuration;
    }

    public final Object getRandomKey() {
        return this.randomKey;
    }
}