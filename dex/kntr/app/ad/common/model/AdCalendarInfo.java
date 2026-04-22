package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdCalendarInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rB_\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J`\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00065"}, d2 = {"Lkntr/app/ad/common/model/AdCalendarInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", RoomRecommendViewModel.EMPTY_CURSOR, "endTime", "calendarId", RoomRecommendViewModel.EMPTY_CURSOR, "comment", "url", "calendarIdStr", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getCalendarId", "()I", "getComment", "getUrl", "getCalendarIdStr", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/common/model/AdCalendarInfo;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdCalendarInfo {
    public static final Companion Companion = new Companion(null);
    private final int calendarId;
    private final String calendarIdStr;
    private final String comment;
    private final Long endTime;
    private final Long startTime;
    private final String title;
    private final String url;

    public AdCalendarInfo() {
        this((String) null, (Long) null, (Long) null, 0, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdCalendarInfo copy$default(AdCalendarInfo adCalendarInfo, String str, Long l, Long l2, int i, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adCalendarInfo.title;
        }
        if ((i2 & 2) != 0) {
            l = adCalendarInfo.startTime;
        }
        Long l3 = l;
        if ((i2 & 4) != 0) {
            l2 = adCalendarInfo.endTime;
        }
        Long l4 = l2;
        if ((i2 & 8) != 0) {
            i = adCalendarInfo.calendarId;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str2 = adCalendarInfo.comment;
        }
        String str5 = str2;
        if ((i2 & 32) != 0) {
            str3 = adCalendarInfo.url;
        }
        String str6 = str3;
        if ((i2 & 64) != 0) {
            str4 = adCalendarInfo.calendarIdStr;
        }
        return adCalendarInfo.copy(str, l3, l4, i3, str5, str6, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final Long component2() {
        return this.startTime;
    }

    public final Long component3() {
        return this.endTime;
    }

    public final int component4() {
        return this.calendarId;
    }

    public final String component5() {
        return this.comment;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.calendarIdStr;
    }

    public final AdCalendarInfo copy(String str, Long l, Long l2, int i, String str2, String str3, String str4) {
        return new AdCalendarInfo(str, l, l2, i, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdCalendarInfo) {
            AdCalendarInfo adCalendarInfo = (AdCalendarInfo) obj;
            return Intrinsics.areEqual(this.title, adCalendarInfo.title) && Intrinsics.areEqual(this.startTime, adCalendarInfo.startTime) && Intrinsics.areEqual(this.endTime, adCalendarInfo.endTime) && this.calendarId == adCalendarInfo.calendarId && Intrinsics.areEqual(this.comment, adCalendarInfo.comment) && Intrinsics.areEqual(this.url, adCalendarInfo.url) && Intrinsics.areEqual(this.calendarIdStr, adCalendarInfo.calendarIdStr);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + this.calendarId) * 31) + (this.comment == null ? 0 : this.comment.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.calendarIdStr != null ? this.calendarIdStr.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        Long l = this.startTime;
        Long l2 = this.endTime;
        int i = this.calendarId;
        String str2 = this.comment;
        String str3 = this.url;
        return "AdCalendarInfo(title=" + str + ", startTime=" + l + ", endTime=" + l2 + ", calendarId=" + i + ", comment=" + str2 + ", url=" + str3 + ", calendarIdStr=" + this.calendarIdStr + ")";
    }

    /* compiled from: AdCalendarInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdCalendarInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdCalendarInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdCalendarInfo> serializer() {
            return AdCalendarInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdCalendarInfo(int seen0, String title, Long startTime, Long endTime, int calendarId, String comment, String url, String calendarIdStr, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.startTime = null;
        } else {
            this.startTime = startTime;
        }
        if ((seen0 & 4) == 0) {
            this.endTime = null;
        } else {
            this.endTime = endTime;
        }
        if ((seen0 & 8) == 0) {
            this.calendarId = 0;
        } else {
            this.calendarId = calendarId;
        }
        if ((seen0 & 16) == 0) {
            this.comment = null;
        } else {
            this.comment = comment;
        }
        if ((seen0 & 32) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 64) == 0) {
            this.calendarIdStr = null;
        } else {
            this.calendarIdStr = calendarIdStr;
        }
    }

    public AdCalendarInfo(String title, Long startTime, Long endTime, int calendarId, String comment, String url, String calendarIdStr) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.calendarId = calendarId;
        this.comment = comment;
        this.url = url;
        this.calendarIdStr = calendarIdStr;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdCalendarInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.startTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.startTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.endTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.endTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.calendarId != 0) {
            output.encodeIntElement(serialDesc, 3, self.calendarId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.comment != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.comment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.calendarIdStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.calendarIdStr);
        }
    }

    public /* synthetic */ AdCalendarInfo(String str, Long l, Long l2, int i, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? null : l2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4);
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final int getCalendarId() {
        return this.calendarId;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getCalendarIdStr() {
        return this.calendarIdStr;
    }
}