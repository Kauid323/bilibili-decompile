package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraStoryGoodsQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "trackId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getTrackId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraStoryGoodsQuery implements IAdExtraQuery {
    private final String trackId;

    public AdExtraStoryGoodsQuery() {
        this(null, 1, null);
    }

    public static /* synthetic */ AdExtraStoryGoodsQuery copy$default(AdExtraStoryGoodsQuery adExtraStoryGoodsQuery, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adExtraStoryGoodsQuery.trackId;
        }
        return adExtraStoryGoodsQuery.copy(str);
    }

    public final String component1() {
        return this.trackId;
    }

    public final AdExtraStoryGoodsQuery copy(String str) {
        return new AdExtraStoryGoodsQuery(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdExtraStoryGoodsQuery) && Intrinsics.areEqual(this.trackId, ((AdExtraStoryGoodsQuery) obj).trackId);
    }

    public int hashCode() {
        if (this.trackId == null) {
            return 0;
        }
        return this.trackId.hashCode();
    }

    public String toString() {
        return "AdExtraStoryGoodsQuery(trackId=" + this.trackId + ")";
    }

    public AdExtraStoryGoodsQuery(String trackId) {
        this.trackId = trackId;
    }

    public /* synthetic */ AdExtraStoryGoodsQuery(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getTrackId() {
        return this.trackId;
    }
}