package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraStoryFeedQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "natureAd", RoomRecommendViewModel.EMPTY_CURSOR, "creativeId", "trackId", "requestId", "caid", "fromSpmid", "adStoryExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNatureAd", "()Ljava/lang/String;", "getCreativeId", "getTrackId", "getRequestId", "getCaid", "getFromSpmid", "getAdStoryExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraStoryFeedQuery implements IAdExtraQuery {
    private final String adStoryExtra;
    private final String caid;
    private final String creativeId;
    private final String fromSpmid;
    private final String natureAd;
    private final String requestId;
    private final String trackId;

    public AdExtraStoryFeedQuery() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AdExtraStoryFeedQuery copy$default(AdExtraStoryFeedQuery adExtraStoryFeedQuery, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adExtraStoryFeedQuery.natureAd;
        }
        if ((i & 2) != 0) {
            str2 = adExtraStoryFeedQuery.creativeId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = adExtraStoryFeedQuery.trackId;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = adExtraStoryFeedQuery.requestId;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = adExtraStoryFeedQuery.caid;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = adExtraStoryFeedQuery.fromSpmid;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = adExtraStoryFeedQuery.adStoryExtra;
        }
        return adExtraStoryFeedQuery.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.natureAd;
    }

    public final String component2() {
        return this.creativeId;
    }

    public final String component3() {
        return this.trackId;
    }

    public final String component4() {
        return this.requestId;
    }

    public final String component5() {
        return this.caid;
    }

    public final String component6() {
        return this.fromSpmid;
    }

    public final String component7() {
        return this.adStoryExtra;
    }

    public final AdExtraStoryFeedQuery copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new AdExtraStoryFeedQuery(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraStoryFeedQuery) {
            AdExtraStoryFeedQuery adExtraStoryFeedQuery = (AdExtraStoryFeedQuery) obj;
            return Intrinsics.areEqual(this.natureAd, adExtraStoryFeedQuery.natureAd) && Intrinsics.areEqual(this.creativeId, adExtraStoryFeedQuery.creativeId) && Intrinsics.areEqual(this.trackId, adExtraStoryFeedQuery.trackId) && Intrinsics.areEqual(this.requestId, adExtraStoryFeedQuery.requestId) && Intrinsics.areEqual(this.caid, adExtraStoryFeedQuery.caid) && Intrinsics.areEqual(this.fromSpmid, adExtraStoryFeedQuery.fromSpmid) && Intrinsics.areEqual(this.adStoryExtra, adExtraStoryFeedQuery.adStoryExtra);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.natureAd == null ? 0 : this.natureAd.hashCode()) * 31) + (this.creativeId == null ? 0 : this.creativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.caid == null ? 0 : this.caid.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.adStoryExtra != null ? this.adStoryExtra.hashCode() : 0);
    }

    public String toString() {
        String str = this.natureAd;
        String str2 = this.creativeId;
        String str3 = this.trackId;
        String str4 = this.requestId;
        String str5 = this.caid;
        String str6 = this.fromSpmid;
        return "AdExtraStoryFeedQuery(natureAd=" + str + ", creativeId=" + str2 + ", trackId=" + str3 + ", requestId=" + str4 + ", caid=" + str5 + ", fromSpmid=" + str6 + ", adStoryExtra=" + this.adStoryExtra + ")";
    }

    public AdExtraStoryFeedQuery(String natureAd, String creativeId, String trackId, String requestId, String caid, String fromSpmid, String adStoryExtra) {
        this.natureAd = natureAd;
        this.creativeId = creativeId;
        this.trackId = trackId;
        this.requestId = requestId;
        this.caid = caid;
        this.fromSpmid = fromSpmid;
        this.adStoryExtra = adStoryExtra;
    }

    public /* synthetic */ AdExtraStoryFeedQuery(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getNatureAd() {
        return this.natureAd;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getCaid() {
        return this.caid;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final String getAdStoryExtra() {
        return this.adStoryExtra;
    }
}