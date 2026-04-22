package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
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

/* compiled from: AdLiveBookInfo.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lkntr/app/ad/common/model/AdLiveBookInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "liveBookingId", RoomRecommendViewModel.EMPTY_CURSOR, "calenderInfo", "Lkntr/app/ad/common/model/AdCalendarInfo;", "livePageType", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLkntr/app/ad/common/model/AdCalendarInfo;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLkntr/app/ad/common/model/AdCalendarInfo;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLiveBookingId", "()J", "getCalenderInfo", "()Lkntr/app/ad/common/model/AdCalendarInfo;", "getLivePageType", "()I", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdLiveBookInfo {
    public static final Companion Companion = new Companion(null);
    private final AdCalendarInfo calenderInfo;
    private final long liveBookingId;
    private final int livePageType;

    public AdLiveBookInfo() {
        this(0L, (AdCalendarInfo) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdLiveBookInfo copy$default(AdLiveBookInfo adLiveBookInfo, long j2, AdCalendarInfo adCalendarInfo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = adLiveBookInfo.liveBookingId;
        }
        if ((i2 & 2) != 0) {
            adCalendarInfo = adLiveBookInfo.calenderInfo;
        }
        if ((i2 & 4) != 0) {
            i = adLiveBookInfo.livePageType;
        }
        return adLiveBookInfo.copy(j2, adCalendarInfo, i);
    }

    public final long component1() {
        return this.liveBookingId;
    }

    public final AdCalendarInfo component2() {
        return this.calenderInfo;
    }

    public final int component3() {
        return this.livePageType;
    }

    public final AdLiveBookInfo copy(long j2, AdCalendarInfo adCalendarInfo, int i) {
        return new AdLiveBookInfo(j2, adCalendarInfo, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdLiveBookInfo) {
            AdLiveBookInfo adLiveBookInfo = (AdLiveBookInfo) obj;
            return this.liveBookingId == adLiveBookInfo.liveBookingId && Intrinsics.areEqual(this.calenderInfo, adLiveBookInfo.calenderInfo) && this.livePageType == adLiveBookInfo.livePageType;
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.liveBookingId) * 31) + (this.calenderInfo == null ? 0 : this.calenderInfo.hashCode())) * 31) + this.livePageType;
    }

    public String toString() {
        long j2 = this.liveBookingId;
        AdCalendarInfo adCalendarInfo = this.calenderInfo;
        return "AdLiveBookInfo(liveBookingId=" + j2 + ", calenderInfo=" + adCalendarInfo + ", livePageType=" + this.livePageType + ")";
    }

    /* compiled from: AdLiveBookInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdLiveBookInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdLiveBookInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdLiveBookInfo> serializer() {
            return AdLiveBookInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdLiveBookInfo(int seen0, long liveBookingId, AdCalendarInfo calenderInfo, int livePageType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.liveBookingId = 0L;
        } else {
            this.liveBookingId = liveBookingId;
        }
        if ((seen0 & 2) == 0) {
            this.calenderInfo = null;
        } else {
            this.calenderInfo = calenderInfo;
        }
        if ((seen0 & 4) == 0) {
            this.livePageType = 0;
        } else {
            this.livePageType = livePageType;
        }
    }

    public AdLiveBookInfo(long liveBookingId, AdCalendarInfo calenderInfo, int livePageType) {
        this.liveBookingId = liveBookingId;
        this.calenderInfo = calenderInfo;
        this.livePageType = livePageType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdLiveBookInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.liveBookingId != 0) {
            output.encodeLongElement(serialDesc, 0, self.liveBookingId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.calenderInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, AdCalendarInfo$$serializer.INSTANCE, self.calenderInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.livePageType != 0) {
            output.encodeIntElement(serialDesc, 2, self.livePageType);
        }
    }

    public /* synthetic */ AdLiveBookInfo(long j2, AdCalendarInfo adCalendarInfo, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? null : adCalendarInfo, (i2 & 4) != 0 ? 0 : i);
    }

    public final long getLiveBookingId() {
        return this.liveBookingId;
    }

    public final AdCalendarInfo getCalenderInfo() {
        return this.calenderInfo;
    }

    public final int getLivePageType() {
        return this.livePageType;
    }
}