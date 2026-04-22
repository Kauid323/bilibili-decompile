package tv.danmaku.bili.ui.favorites.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/Ugc;", "", "firstCid", "", "<init>", "(J)V", "getFirstCid", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Ugc {
    public static final int $stable = 0;
    @SerializedName("first_cid")
    private final long firstCid;

    public Ugc() {
        this(0L, 1, null);
    }

    public static /* synthetic */ Ugc copy$default(Ugc ugc, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ugc.firstCid;
        }
        return ugc.copy(j);
    }

    public final long component1() {
        return this.firstCid;
    }

    public final Ugc copy(long j) {
        return new Ugc(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Ugc) && this.firstCid == ((Ugc) obj).firstCid;
    }

    public int hashCode() {
        return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.firstCid);
    }

    public String toString() {
        return "Ugc(firstCid=" + this.firstCid + ")";
    }

    public Ugc(long firstCid) {
        this.firstCid = firstCid;
    }

    public /* synthetic */ Ugc(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j);
    }

    public final long getFirstCid() {
        return this.firstCid;
    }
}