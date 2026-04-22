package tv.danmaku.bili.ui.favorites.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.MainTransaction;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0003J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/SubTab;", "Landroid/os/Parcelable;", "tabId", "", "tabName", "", AudioIntentHelper.ARGS_URI, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getTabId", "()I", "getTabName", "()Ljava/lang/String;", "getUri", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SubTab implements Parcelable {
    @SerializedName(MainTransaction.ARGS_ANCHOR_TAB_ID)
    private final int tabId;
    @SerializedName("tab_name")
    private final String tabName;
    @SerializedName(AudioIntentHelper.ARGS_URI)
    private final String uri;
    public static final Parcelable.Creator<SubTab> CREATOR = new Creator();
    public static final int $stable = 8;

    /* compiled from: FavoritesResponse.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<SubTab> {
        @Override // android.os.Parcelable.Creator
        public final SubTab createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubTab(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SubTab[] newArray(int i) {
            return new SubTab[i];
        }
    }

    public SubTab() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ SubTab copy$default(SubTab subTab, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subTab.tabId;
        }
        if ((i2 & 2) != 0) {
            str = subTab.tabName;
        }
        if ((i2 & 4) != 0) {
            str2 = subTab.uri;
        }
        return subTab.copy(i, str, str2);
    }

    public final int component1() {
        return this.tabId;
    }

    public final String component2() {
        return this.tabName;
    }

    public final String component3() {
        return this.uri;
    }

    public final SubTab copy(int i, String str, String str2) {
        return new SubTab(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubTab) {
            SubTab subTab = (SubTab) obj;
            return this.tabId == subTab.tabId && Intrinsics.areEqual(this.tabName, subTab.tabName) && Intrinsics.areEqual(this.uri, subTab.uri);
        }
        return false;
    }

    public int hashCode() {
        return (((this.tabId * 31) + (this.tabName == null ? 0 : this.tabName.hashCode())) * 31) + (this.uri != null ? this.uri.hashCode() : 0);
    }

    public String toString() {
        int i = this.tabId;
        String str = this.tabName;
        return "SubTab(tabId=" + i + ", tabName=" + str + ", uri=" + this.uri + ")";
    }

    public SubTab(int tabId, String tabName, String uri) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.uri = uri;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ SubTab(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.tabId);
        dest.writeString(this.tabName);
        dest.writeString(this.uri);
    }
}