package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraStoryFlyCartQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "ocpxTargetType", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "disableComponentClickUrl", "natureAd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOcpxTargetType", "()Ljava/lang/String;", "getTrackId", "getDisableComponentClickUrl", "getNatureAd", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraStoryFlyCartQuery implements IAdExtraQuery {
    private final String disableComponentClickUrl;
    private final String natureAd;
    private final String ocpxTargetType;
    private final String trackId;

    public AdExtraStoryFlyCartQuery() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AdExtraStoryFlyCartQuery copy$default(AdExtraStoryFlyCartQuery adExtraStoryFlyCartQuery, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adExtraStoryFlyCartQuery.ocpxTargetType;
        }
        if ((i & 2) != 0) {
            str2 = adExtraStoryFlyCartQuery.trackId;
        }
        if ((i & 4) != 0) {
            str3 = adExtraStoryFlyCartQuery.disableComponentClickUrl;
        }
        if ((i & 8) != 0) {
            str4 = adExtraStoryFlyCartQuery.natureAd;
        }
        return adExtraStoryFlyCartQuery.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.ocpxTargetType;
    }

    public final String component2() {
        return this.trackId;
    }

    public final String component3() {
        return this.disableComponentClickUrl;
    }

    public final String component4() {
        return this.natureAd;
    }

    public final AdExtraStoryFlyCartQuery copy(String str, String str2, String str3, String str4) {
        return new AdExtraStoryFlyCartQuery(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraStoryFlyCartQuery) {
            AdExtraStoryFlyCartQuery adExtraStoryFlyCartQuery = (AdExtraStoryFlyCartQuery) obj;
            return Intrinsics.areEqual(this.ocpxTargetType, adExtraStoryFlyCartQuery.ocpxTargetType) && Intrinsics.areEqual(this.trackId, adExtraStoryFlyCartQuery.trackId) && Intrinsics.areEqual(this.disableComponentClickUrl, adExtraStoryFlyCartQuery.disableComponentClickUrl) && Intrinsics.areEqual(this.natureAd, adExtraStoryFlyCartQuery.natureAd);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode()) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.disableComponentClickUrl == null ? 0 : this.disableComponentClickUrl.hashCode())) * 31) + (this.natureAd != null ? this.natureAd.hashCode() : 0);
    }

    public String toString() {
        String str = this.ocpxTargetType;
        String str2 = this.trackId;
        String str3 = this.disableComponentClickUrl;
        return "AdExtraStoryFlyCartQuery(ocpxTargetType=" + str + ", trackId=" + str2 + ", disableComponentClickUrl=" + str3 + ", natureAd=" + this.natureAd + ")";
    }

    public AdExtraStoryFlyCartQuery(String ocpxTargetType, String trackId, String disableComponentClickUrl, String natureAd) {
        this.ocpxTargetType = ocpxTargetType;
        this.trackId = trackId;
        this.disableComponentClickUrl = disableComponentClickUrl;
        this.natureAd = natureAd;
    }

    public /* synthetic */ AdExtraStoryFlyCartQuery(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getOcpxTargetType() {
        return this.ocpxTargetType;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getDisableComponentClickUrl() {
        return this.disableComponentClickUrl;
    }

    public final String getNatureAd() {
        return this.natureAd;
    }
}