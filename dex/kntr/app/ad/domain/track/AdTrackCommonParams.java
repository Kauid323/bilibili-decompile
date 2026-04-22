package kntr.app.ad.domain.track;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdTrackCommonParams.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BA\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\b\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\b\u0015\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u0017\u001a\u0004\b\u0016\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u0019\u001a\u0004\b\u0018\u0010\r¨\u0006)"}, d2 = {"Lkntr/app/ad/domain/track/AdTrackCommonParams;", "Lkntr/app/ad/domain/track/IAdTrackCommonParams;", "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "resourceId", RoomRecommendViewModel.EMPTY_CURSOR, "srcId", "creativeId", "cardType", "extra", "<init>", "(Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "requestId$1", "getResourceId", "()J", "resourceId$1", "getSrcId", "srcId$1", "getCreativeId", "creativeId$1", "getCardType", "cardType$1", "getExtra", "extra$1", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Empty", "track_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdTrackCommonParams implements IAdTrackCommonParams {
    private static final String cardType = null;
    private static final String extra = null;
    private static final String requestId = null;
    private static final String srcId = null;
    private final String cardType$1;
    private final long creativeId$1;
    private final String extra$1;
    private final String requestId$1;
    private final long resourceId$1;
    private final String srcId$1;
    public static final Empty Empty = new Empty(null);
    private static final long resourceId = -1;
    private static final long creativeId = -1;

    public final String component1() {
        return this.requestId$1;
    }

    public final long component2() {
        return this.resourceId$1;
    }

    public final String component3() {
        return this.srcId$1;
    }

    public final long component4() {
        return this.creativeId$1;
    }

    public final String component5() {
        return this.cardType$1;
    }

    public final String component6() {
        return this.extra$1;
    }

    public final AdTrackCommonParams copy(String str, long j2, String str2, long j3, String str3, String str4) {
        return new AdTrackCommonParams(str, j2, str2, j3, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTrackCommonParams) {
            AdTrackCommonParams adTrackCommonParams = (AdTrackCommonParams) obj;
            return Intrinsics.areEqual(this.requestId$1, adTrackCommonParams.requestId$1) && this.resourceId$1 == adTrackCommonParams.resourceId$1 && Intrinsics.areEqual(this.srcId$1, adTrackCommonParams.srcId$1) && this.creativeId$1 == adTrackCommonParams.creativeId$1 && Intrinsics.areEqual(this.cardType$1, adTrackCommonParams.cardType$1) && Intrinsics.areEqual(this.extra$1, adTrackCommonParams.extra$1);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.requestId$1 == null ? 0 : this.requestId$1.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.resourceId$1)) * 31) + (this.srcId$1 == null ? 0 : this.srcId$1.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeId$1)) * 31) + (this.cardType$1 == null ? 0 : this.cardType$1.hashCode())) * 31) + (this.extra$1 != null ? this.extra$1.hashCode() : 0);
    }

    public String toString() {
        String str = this.requestId$1;
        long j2 = this.resourceId$1;
        String str2 = this.srcId$1;
        long j3 = this.creativeId$1;
        String str3 = this.cardType$1;
        return "AdTrackCommonParams(requestId=" + str + ", resourceId=" + j2 + ", srcId=" + str2 + ", creativeId=" + j3 + ", cardType=" + str3 + ", extra=" + this.extra$1 + ")";
    }

    public AdTrackCommonParams(String requestId2, long resourceId2, String srcId2, long creativeId2, String cardType2, String extra2) {
        this.requestId$1 = requestId2;
        this.resourceId$1 = resourceId2;
        this.srcId$1 = srcId2;
        this.creativeId$1 = creativeId2;
        this.cardType$1 = cardType2;
        this.extra$1 = extra2;
    }

    @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
    public String getRequestId() {
        return this.requestId$1;
    }

    @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
    public long getResourceId() {
        return this.resourceId$1;
    }

    @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
    public String getSrcId() {
        return this.srcId$1;
    }

    @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
    public long getCreativeId() {
        return this.creativeId$1;
    }

    @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
    public String getCardType() {
        return this.cardType$1;
    }

    @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
    public String getExtra() {
        return this.extra$1;
    }

    /* compiled from: IAdTrackCommonParams.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/domain/track/AdTrackCommonParams$Empty;", "Lkntr/app/ad/domain/track/IAdTrackCommonParams;", "<init>", "()V", "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "getRequestId", "()Ljava/lang/String;", "resourceId", RoomRecommendViewModel.EMPTY_CURSOR, "getResourceId", "()J", "creativeId", "getCreativeId", "srcId", "getSrcId", "cardType", "getCardType", "extra", "getExtra", "track_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Empty implements IAdTrackCommonParams {
        public /* synthetic */ Empty(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Empty() {
        }

        @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
        public String getRequestId() {
            return AdTrackCommonParams.requestId;
        }

        @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
        public long getResourceId() {
            return AdTrackCommonParams.resourceId;
        }

        @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
        public long getCreativeId() {
            return AdTrackCommonParams.creativeId;
        }

        @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
        public String getSrcId() {
            return AdTrackCommonParams.srcId;
        }

        @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
        public String getCardType() {
            return AdTrackCommonParams.cardType;
        }

        @Override // kntr.app.ad.domain.track.IAdTrackCommonParams
        public String getExtra() {
            return AdTrackCommonParams.extra;
        }
    }
}