package tv.danmaku.bili.ui.favorites.model;

import BottomSheetItemData$;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.main2.MainTransaction;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0003J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/Tab;", "Landroid/os/Parcelable;", "tabId", "", "tabName", "", AudioIntentHelper.ARGS_URI, "redDot", "", "subTabs", "", "Ltv/danmaku/bili/ui/favorites/model/SubTab;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getTabId", "()I", "getTabName", "()Ljava/lang/String;", "getUri", "getRedDot", "()Z", "getSubTabs", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Tab implements Parcelable {
    @SerializedName("red_dot")
    private final boolean redDot;
    @SerializedName(FavoritesConstsKt.KEY_SUB_TABS)
    private final List<SubTab> subTabs;
    @SerializedName(MainTransaction.ARGS_ANCHOR_TAB_ID)
    private final int tabId;
    @SerializedName("tab_name")
    private final String tabName;
    @SerializedName(AudioIntentHelper.ARGS_URI)
    private final String uri;
    public static final Parcelable.Creator<Tab> CREATOR = new Creator();
    public static final int $stable = 8;

    /* compiled from: FavoritesResponse.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<Tab> {
        @Override // android.os.Parcelable.Creator
        public final Tab createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList2.add(SubTab.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new Tab(readInt, readString, readString2, z, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final Tab[] newArray(int i) {
            return new Tab[i];
        }
    }

    public Tab() {
        this(0, null, null, false, null, 31, null);
    }

    public static /* synthetic */ Tab copy$default(Tab tab, int i, String str, String str2, boolean z, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tab.tabId;
        }
        if ((i2 & 2) != 0) {
            str = tab.tabName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = tab.uri;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            z = tab.redDot;
        }
        boolean z2 = z;
        List<SubTab> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = tab.subTabs;
        }
        return tab.copy(i, str3, str4, z2, list2);
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

    public final boolean component4() {
        return this.redDot;
    }

    public final List<SubTab> component5() {
        return this.subTabs;
    }

    public final Tab copy(int i, String str, String str2, boolean z, List<SubTab> list) {
        return new Tab(i, str, str2, z, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tab) {
            Tab tab = (Tab) obj;
            return this.tabId == tab.tabId && Intrinsics.areEqual(this.tabName, tab.tabName) && Intrinsics.areEqual(this.uri, tab.uri) && this.redDot == tab.redDot && Intrinsics.areEqual(this.subTabs, tab.subTabs);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.tabId * 31) + (this.tabName == null ? 0 : this.tabName.hashCode())) * 31) + (this.uri == null ? 0 : this.uri.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.redDot)) * 31) + (this.subTabs != null ? this.subTabs.hashCode() : 0);
    }

    public String toString() {
        int i = this.tabId;
        String str = this.tabName;
        String str2 = this.uri;
        boolean z = this.redDot;
        return "Tab(tabId=" + i + ", tabName=" + str + ", uri=" + str2 + ", redDot=" + z + ", subTabs=" + this.subTabs + ")";
    }

    public Tab(int tabId, String tabName, String uri, boolean redDot, List<SubTab> list) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.uri = uri;
        this.redDot = redDot;
        this.subTabs = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ Tab(int i, String str, String str2, boolean z, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) == 0 ? str2 : null, (i2 & 8) == 0 ? z : false, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list);
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

    public final boolean getRedDot() {
        return this.redDot;
    }

    public final List<SubTab> getSubTabs() {
        return this.subTabs;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.tabId);
        dest.writeString(this.tabName);
        dest.writeString(this.uri);
        dest.writeInt(this.redDot ? 1 : 0);
        List<SubTab> list = this.subTabs;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list.size());
        for (SubTab subTab : list) {
            subTab.writeToParcel(dest, flags);
        }
    }
}