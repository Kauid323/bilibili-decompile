package tv.danmaku.bili.ui.watchlater.data;

import ComposableSingletons$CustomBottomSheetKt$;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/Owner;", "Landroid/os/Parcelable;", RankRouter.BundleKey.AUTHOR_SPACE_MID, "", "name", "", "face", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getMid", "()J", "getName", "()Ljava/lang/String;", "getFace", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Owner implements Parcelable {
    private final String face;
    private final long mid;
    private final String name;
    public static final Parcelable.Creator<Owner> CREATOR = new Creator();
    public static final int $stable = 8;

    /* compiled from: WatchLaterResponse.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Creator implements Parcelable.Creator<Owner> {
        @Override // android.os.Parcelable.Creator
        public final Owner createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Owner(parcel.readLong(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Owner[] newArray(int i) {
            return new Owner[i];
        }
    }

    public Owner() {
        this(0L, null, null, 7, null);
    }

    public static /* synthetic */ Owner copy$default(Owner owner, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = owner.mid;
        }
        if ((i & 2) != 0) {
            str = owner.name;
        }
        if ((i & 4) != 0) {
            str2 = owner.face;
        }
        return owner.copy(j, str, str2);
    }

    public final long component1() {
        return this.mid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.face;
    }

    public final Owner copy(long j, String str, String str2) {
        return new Owner(j, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Owner) {
            Owner owner = (Owner) obj;
            return this.mid == owner.mid && Intrinsics.areEqual(this.name, owner.name) && Intrinsics.areEqual(this.face, owner.face);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.face != null ? this.face.hashCode() : 0);
    }

    public String toString() {
        long j = this.mid;
        String str = this.name;
        return "Owner(mid=" + j + ", name=" + str + ", face=" + this.face + ")";
    }

    public Owner(long mid, String name, String face) {
        this.mid = mid;
        this.name = name;
        this.face = face;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ Owner(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final long getMid() {
        return this.mid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFace() {
        return this.face;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.mid);
        dest.writeString(this.name);
        dest.writeString(this.face);
    }
}