package tv.danmaku.bili.ui.favorites.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/Upper;", "", ChannelRoutes.CHANNEL_NAME, "", "jumpLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getJumpLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Upper {
    public static final int $stable = 0;
    @SerializedName("jump_link")
    private final String jumpLink;
    @SerializedName(ChannelRoutes.CHANNEL_NAME)
    private final String name;

    public Upper() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ Upper copy$default(Upper upper, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upper.name;
        }
        if ((i & 2) != 0) {
            str2 = upper.jumpLink;
        }
        return upper.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.jumpLink;
    }

    public final Upper copy(String str, String str2) {
        return new Upper(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Upper) {
            Upper upper = (Upper) obj;
            return Intrinsics.areEqual(this.name, upper.name) && Intrinsics.areEqual(this.jumpLink, upper.jumpLink);
        }
        return false;
    }

    public int hashCode() {
        return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.jumpLink != null ? this.jumpLink.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        return "Upper(name=" + str + ", jumpLink=" + this.jumpLink + ")";
    }

    public Upper(String name, String jumpLink) {
        this.name = name;
        this.jumpLink = jumpLink;
    }

    public /* synthetic */ Upper(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }
}