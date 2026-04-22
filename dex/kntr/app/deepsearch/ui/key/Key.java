package kntr.app.deepsearch.ui.key;

import android.os.Parcel;
import android.os.Parcelable;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Key.android.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lkntr/app/deepsearch/ui/key/Key;", "Landroid/os/Parcelable;", "position", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;)V", "getPosition", "()I", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "writeToParcel", RoomRecommendViewModel.EMPTY_CURSOR, "dest", "Landroid/os/Parcel;", "flags", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Key implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<Key> CREATOR = new Creator();
    private final String id;
    private final int position;

    /* compiled from: Key.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Creator implements Parcelable.Creator<Key> {
        @Override // android.os.Parcelable.Creator
        public final Key createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Key(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Key[] newArray(int i) {
            return new Key[i];
        }
    }

    public static /* synthetic */ Key copy$default(Key key, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = key.position;
        }
        if ((i2 & 2) != 0) {
            str = key.id;
        }
        return key.copy(i, str);
    }

    public final int component1() {
        return this.position;
    }

    public final String component2() {
        return this.id;
    }

    public final Key copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        return new Key(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Key) {
            Key key = (Key) obj;
            return this.position == key.position && Intrinsics.areEqual(this.id, key.id);
        }
        return false;
    }

    public int hashCode() {
        return (this.position * 31) + this.id.hashCode();
    }

    public String toString() {
        int i = this.position;
        return "Key(position=" + i + ", id=" + this.id + ")";
    }

    public Key(int position, String id) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        this.position = position;
        this.id = id;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.position);
        dest.writeString(this.id);
    }
}