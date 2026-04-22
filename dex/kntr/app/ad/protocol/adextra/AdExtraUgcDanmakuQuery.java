package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraUgcDanmakuQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "ocpxTargetType", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOcpxTargetType", "()Ljava/lang/String;", "getTrackId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraUgcDanmakuQuery implements IAdExtraQuery {
    private final String ocpxTargetType;
    private final String trackId;

    public AdExtraUgcDanmakuQuery() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ AdExtraUgcDanmakuQuery copy$default(AdExtraUgcDanmakuQuery adExtraUgcDanmakuQuery, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adExtraUgcDanmakuQuery.ocpxTargetType;
        }
        if ((i & 2) != 0) {
            str2 = adExtraUgcDanmakuQuery.trackId;
        }
        return adExtraUgcDanmakuQuery.copy(str, str2);
    }

    public final String component1() {
        return this.ocpxTargetType;
    }

    public final String component2() {
        return this.trackId;
    }

    public final AdExtraUgcDanmakuQuery copy(String str, String str2) {
        return new AdExtraUgcDanmakuQuery(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraUgcDanmakuQuery) {
            AdExtraUgcDanmakuQuery adExtraUgcDanmakuQuery = (AdExtraUgcDanmakuQuery) obj;
            return Intrinsics.areEqual(this.ocpxTargetType, adExtraUgcDanmakuQuery.ocpxTargetType) && Intrinsics.areEqual(this.trackId, adExtraUgcDanmakuQuery.trackId);
        }
        return false;
    }

    public int hashCode() {
        return ((this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode()) * 31) + (this.trackId != null ? this.trackId.hashCode() : 0);
    }

    public String toString() {
        String str = this.ocpxTargetType;
        return "AdExtraUgcDanmakuQuery(ocpxTargetType=" + str + ", trackId=" + this.trackId + ")";
    }

    public AdExtraUgcDanmakuQuery(String ocpxTargetType, String trackId) {
        this.ocpxTargetType = ocpxTargetType;
        this.trackId = trackId;
    }

    public /* synthetic */ AdExtraUgcDanmakuQuery(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getOcpxTargetType() {
        return this.ocpxTargetType;
    }

    public final String getTrackId() {
        return this.trackId;
    }
}