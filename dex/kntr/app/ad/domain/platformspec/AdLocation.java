package kntr.app.ad.domain.platformspec;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdPlatformSpecProvider.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/domain/platformspec/AdLocation;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.LAT, RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.LNG, "ts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLat", "()Ljava/lang/String;", "getLng", "getTs", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "platformspec_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdLocation {
    private final String lat;
    private final String lng;
    private final String ts;

    public static /* synthetic */ AdLocation copy$default(AdLocation adLocation, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adLocation.lat;
        }
        if ((i & 2) != 0) {
            str2 = adLocation.lng;
        }
        if ((i & 4) != 0) {
            str3 = adLocation.ts;
        }
        return adLocation.copy(str, str2, str3);
    }

    public final String component1() {
        return this.lat;
    }

    public final String component2() {
        return this.lng;
    }

    public final String component3() {
        return this.ts;
    }

    public final AdLocation copy(String str, String str2, String str3) {
        return new AdLocation(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdLocation) {
            AdLocation adLocation = (AdLocation) obj;
            return Intrinsics.areEqual(this.lat, adLocation.lat) && Intrinsics.areEqual(this.lng, adLocation.lng) && Intrinsics.areEqual(this.ts, adLocation.ts);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.lat == null ? 0 : this.lat.hashCode()) * 31) + (this.lng == null ? 0 : this.lng.hashCode())) * 31) + (this.ts != null ? this.ts.hashCode() : 0);
    }

    public String toString() {
        String str = this.lat;
        String str2 = this.lng;
        return "AdLocation(lat=" + str + ", lng=" + str2 + ", ts=" + this.ts + ")";
    }

    public AdLocation(String lat, String lng, String ts) {
        this.lat = lat;
        this.lng = lng;
        this.ts = ts;
    }

    public final String getLat() {
        return this.lat;
    }

    public final String getLng() {
        return this.lng;
    }

    public final String getTs() {
        return this.ts;
    }
}