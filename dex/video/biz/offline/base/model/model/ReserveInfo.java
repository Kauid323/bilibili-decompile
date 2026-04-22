package video.biz.offline.base.model.model;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ReserveInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/model/model/ReserveInfo;", "", "hasReserve", "", "routeUrl", "", "<init>", "(ZLjava/lang/String;)V", "getHasReserve", "()Z", "getRouteUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReserveInfo {
    public static final int $stable = 0;
    private final boolean hasReserve;
    private final String routeUrl;

    public static /* synthetic */ ReserveInfo copy$default(ReserveInfo reserveInfo, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = reserveInfo.hasReserve;
        }
        if ((i & 2) != 0) {
            str = reserveInfo.routeUrl;
        }
        return reserveInfo.copy(z, str);
    }

    public final boolean component1() {
        return this.hasReserve;
    }

    public final String component2() {
        return this.routeUrl;
    }

    public final ReserveInfo copy(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "routeUrl");
        return new ReserveInfo(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReserveInfo) {
            ReserveInfo reserveInfo = (ReserveInfo) obj;
            return this.hasReserve == reserveInfo.hasReserve && Intrinsics.areEqual(this.routeUrl, reserveInfo.routeUrl);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasReserve) * 31) + this.routeUrl.hashCode();
    }

    public String toString() {
        boolean z = this.hasReserve;
        return "ReserveInfo(hasReserve=" + z + ", routeUrl=" + this.routeUrl + ")";
    }

    public ReserveInfo(boolean hasReserve, String routeUrl) {
        Intrinsics.checkNotNullParameter(routeUrl, "routeUrl");
        this.hasReserve = hasReserve;
        this.routeUrl = routeUrl;
    }

    public final boolean getHasReserve() {
        return this.hasReserve;
    }

    public final String getRouteUrl() {
        return this.routeUrl;
    }
}