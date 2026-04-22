package kntr.base.account.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: UserInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lkntr/base/account/model/Vip;", "", "status", "", "type", "endTimestamp", "", "<init>", "(IIJ)V", "getStatus", "()I", "getType", "getEndTimestamp", "()J", "toString", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Vip {
    private final long endTimestamp;
    private final int status;
    private final int type;

    public static /* synthetic */ Vip copy$default(Vip vip, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = vip.status;
        }
        if ((i3 & 2) != 0) {
            i2 = vip.type;
        }
        if ((i3 & 4) != 0) {
            j = vip.endTimestamp;
        }
        return vip.copy(i, i2, j);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.type;
    }

    public final long component3() {
        return this.endTimestamp;
    }

    public final Vip copy(int i, int i2, long j) {
        return new Vip(i, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vip) {
            Vip vip = (Vip) obj;
            return this.status == vip.status && this.type == vip.type && this.endTimestamp == vip.endTimestamp;
        }
        return false;
    }

    public int hashCode() {
        return (((this.status * 31) + this.type) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.endTimestamp);
    }

    public Vip(int status, int type, long endTimestamp) {
        this.status = status;
        this.type = type;
        this.endTimestamp = endTimestamp;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public String toString() {
        int i = this.status;
        int i2 = this.type;
        return "Vip(status=" + i + ", type=" + i2 + ", endTimestamp=" + this.endTimestamp + ")";
    }
}