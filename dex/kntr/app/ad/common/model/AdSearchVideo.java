package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.protocol.report.SubmitType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdSearchVideo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\u0085\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u000fHÖ\u0001J\t\u00104\u001a\u00020\u0006HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006?"}, d2 = {"Lkntr/app/ad/common/model/AdSearchVideo;", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.AID, RoomRecommendViewModel.EMPTY_CURSOR, SubmitType.MMA_KEY_PLAY, "author", RoomRecommendViewModel.EMPTY_CURSOR, "title", "uri", "cover", "danmaku", "duration", "desc2", "viewContent", "iconType", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAid", "()J", "getPlay", "getAuthor", "()Ljava/lang/String;", "getTitle", "getUri", "getCover", "getDanmaku", "getDuration", "getDesc2", "getViewContent", "getIconType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdSearchVideo {
    public static final Companion Companion = new Companion(null);
    private final long aid;
    private final String author;
    private final String cover;
    private final long danmaku;
    private final String desc2;
    private final String duration;
    private final int iconType;
    private final long play;
    private final String title;
    private final String uri;
    private final String viewContent;

    public AdSearchVideo() {
        this(0L, 0L, (String) null, (String) null, (String) null, (String) null, 0L, (String) null, (String) null, (String) null, 0, 2047, (DefaultConstructorMarker) null);
    }

    public final long component1() {
        return this.aid;
    }

    public final String component10() {
        return this.viewContent;
    }

    public final int component11() {
        return this.iconType;
    }

    public final long component2() {
        return this.play;
    }

    public final String component3() {
        return this.author;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.uri;
    }

    public final String component6() {
        return this.cover;
    }

    public final long component7() {
        return this.danmaku;
    }

    public final String component8() {
        return this.duration;
    }

    public final String component9() {
        return this.desc2;
    }

    public final AdSearchVideo copy(long j2, long j3, String str, String str2, String str3, String str4, long j4, String str5, String str6, String str7, int i) {
        return new AdSearchVideo(j2, j3, str, str2, str3, str4, j4, str5, str6, str7, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSearchVideo) {
            AdSearchVideo adSearchVideo = (AdSearchVideo) obj;
            return this.aid == adSearchVideo.aid && this.play == adSearchVideo.play && Intrinsics.areEqual(this.author, adSearchVideo.author) && Intrinsics.areEqual(this.title, adSearchVideo.title) && Intrinsics.areEqual(this.uri, adSearchVideo.uri) && Intrinsics.areEqual(this.cover, adSearchVideo.cover) && this.danmaku == adSearchVideo.danmaku && Intrinsics.areEqual(this.duration, adSearchVideo.duration) && Intrinsics.areEqual(this.desc2, adSearchVideo.desc2) && Intrinsics.areEqual(this.viewContent, adSearchVideo.viewContent) && this.iconType == adSearchVideo.iconType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.play)) * 31) + (this.author == null ? 0 : this.author.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.uri == null ? 0 : this.uri.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.danmaku)) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.desc2 == null ? 0 : this.desc2.hashCode())) * 31) + (this.viewContent != null ? this.viewContent.hashCode() : 0)) * 31) + this.iconType;
    }

    public String toString() {
        long j2 = this.aid;
        long j3 = this.play;
        String str = this.author;
        String str2 = this.title;
        String str3 = this.uri;
        String str4 = this.cover;
        long j4 = this.danmaku;
        String str5 = this.duration;
        String str6 = this.desc2;
        String str7 = this.viewContent;
        return "AdSearchVideo(aid=" + j2 + ", play=" + j3 + ", author=" + str + ", title=" + str2 + ", uri=" + str3 + ", cover=" + str4 + ", danmaku=" + j4 + ", duration=" + str5 + ", desc2=" + str6 + ", viewContent=" + str7 + ", iconType=" + this.iconType + ")";
    }

    /* compiled from: AdSearchVideo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdSearchVideo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdSearchVideo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdSearchVideo> serializer() {
            return AdSearchVideo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdSearchVideo(int seen0, long aid, long play, String author, String title, String uri, String cover, long danmaku, String duration, String desc2, String viewContent, int iconType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.aid = 0L;
        } else {
            this.aid = aid;
        }
        if ((seen0 & 2) == 0) {
            this.play = 0L;
        } else {
            this.play = play;
        }
        if ((seen0 & 4) == 0) {
            this.author = null;
        } else {
            this.author = author;
        }
        if ((seen0 & 8) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 16) == 0) {
            this.uri = null;
        } else {
            this.uri = uri;
        }
        if ((seen0 & 32) == 0) {
            this.cover = null;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 64) == 0) {
            this.danmaku = 0L;
        } else {
            this.danmaku = danmaku;
        }
        if ((seen0 & 128) == 0) {
            this.duration = null;
        } else {
            this.duration = duration;
        }
        if ((seen0 & 256) == 0) {
            this.desc2 = null;
        } else {
            this.desc2 = desc2;
        }
        if ((seen0 & 512) == 0) {
            this.viewContent = null;
        } else {
            this.viewContent = viewContent;
        }
        if ((seen0 & 1024) == 0) {
            this.iconType = 0;
        } else {
            this.iconType = iconType;
        }
    }

    public AdSearchVideo(long aid, long play, String author, String title, String uri, String cover, long danmaku, String duration, String desc2, String viewContent, int iconType) {
        this.aid = aid;
        this.play = play;
        this.author = author;
        this.title = title;
        this.uri = uri;
        this.cover = cover;
        this.danmaku = danmaku;
        this.duration = duration;
        this.desc2 = desc2;
        this.viewContent = viewContent;
        this.iconType = iconType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdSearchVideo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.aid != 0) {
            output.encodeLongElement(serialDesc, 0, self.aid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.play != 0) {
            output.encodeLongElement(serialDesc, 1, self.play);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.author != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.author);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.uri != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.uri);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.cover != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.danmaku != 0) {
            output.encodeLongElement(serialDesc, 6, self.danmaku);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.duration != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.desc2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.desc2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.viewContent != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.viewContent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.iconType != 0) {
            output.encodeIntElement(serialDesc, 10, self.iconType);
        }
    }

    public /* synthetic */ AdSearchVideo(long j2, long j3, String str, String str2, String str3, String str4, long j4, String str5, String str6, String str7, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? 0L : j3, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) == 0 ? j4 : 0L, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) == 0 ? str7 : null, (i2 & 1024) != 0 ? 0 : i);
    }

    public final long getAid() {
        return this.aid;
    }

    public final long getPlay() {
        return this.play;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getDanmaku() {
        return this.danmaku;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getDesc2() {
        return this.desc2;
    }

    public final String getViewContent() {
        return this.viewContent;
    }

    public final int getIconType() {
        return this.iconType;
    }
}