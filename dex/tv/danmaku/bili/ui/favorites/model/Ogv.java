package tv.danmaku.bili.ui.favorites.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/Ogv;", "", "seasonId", "", "typeId", "typeName", "", "<init>", "(JJLjava/lang/String;)V", "getSeasonId", "()J", "getTypeId", "getTypeName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Ogv {
    public static final int $stable = 0;
    @SerializedName("season_id")
    private final long seasonId;
    @SerializedName("type_id")
    private final long typeId;
    @SerializedName("type_name")
    private final String typeName;

    public Ogv() {
        this(0L, 0L, null, 7, null);
    }

    public static /* synthetic */ Ogv copy$default(Ogv ogv, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ogv.seasonId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = ogv.typeId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = ogv.typeName;
        }
        return ogv.copy(j3, j4, str);
    }

    public final long component1() {
        return this.seasonId;
    }

    public final long component2() {
        return this.typeId;
    }

    public final String component3() {
        return this.typeName;
    }

    public final Ogv copy(long j, long j2, String str) {
        return new Ogv(j, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ogv) {
            Ogv ogv = (Ogv) obj;
            return this.seasonId == ogv.seasonId && this.typeId == ogv.typeId && Intrinsics.areEqual(this.typeName, ogv.typeName);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.seasonId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.typeId)) * 31) + (this.typeName == null ? 0 : this.typeName.hashCode());
    }

    public String toString() {
        long j = this.seasonId;
        long j2 = this.typeId;
        return "Ogv(seasonId=" + j + ", typeId=" + j2 + ", typeName=" + this.typeName + ")";
    }

    public Ogv(long seasonId, long typeId, String typeName) {
        this.seasonId = seasonId;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public /* synthetic */ Ogv(long j, long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? null : str);
    }

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final long getTypeId() {
        return this.typeId;
    }

    public final String getTypeName() {
        return this.typeName;
    }
}