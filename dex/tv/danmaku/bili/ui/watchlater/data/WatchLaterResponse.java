package tv.danmaku.bili.ui.watchlater.data;

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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "Landroid/os/Parcelable;", "showCount", "", "hasMore", "", "nextKey", "splitKey", "playUrl", "list", "", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterItem;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getShowCount", "()Ljava/lang/String;", "getHasMore", "()Z", "getNextKey", "getSplitKey", "getPlayUrl", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterResponse implements Parcelable {
    @SerializedName("has_more")
    private final boolean hasMore;
    @SerializedName("list")
    private final List<WatchLaterItem> list;
    @SerializedName("next_key")
    private final String nextKey;
    @SerializedName("play_url")
    private final String playUrl;
    @SerializedName("show_count")
    private final String showCount;
    @SerializedName("split_key")
    private final String splitKey;
    public static final Parcelable.Creator<WatchLaterResponse> CREATOR = new Creator();
    public static final int $stable = 8;

    /* compiled from: WatchLaterResponse.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Creator implements Parcelable.Creator<WatchLaterResponse> {
        @Override // android.os.Parcelable.Creator
        public final WatchLaterResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(WatchLaterItem.CREATOR.createFromParcel(parcel));
            }
            return new WatchLaterResponse(readString, z, readString2, readString3, readString4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final WatchLaterResponse[] newArray(int i) {
            return new WatchLaterResponse[i];
        }
    }

    public WatchLaterResponse() {
        this(null, false, null, null, null, null, 63, null);
    }

    public static /* synthetic */ WatchLaterResponse copy$default(WatchLaterResponse watchLaterResponse, String str, boolean z, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watchLaterResponse.showCount;
        }
        if ((i & 2) != 0) {
            z = watchLaterResponse.hasMore;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = watchLaterResponse.nextKey;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = watchLaterResponse.splitKey;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = watchLaterResponse.playUrl;
        }
        String str7 = str4;
        List<WatchLaterItem> list2 = list;
        if ((i & 32) != 0) {
            list2 = watchLaterResponse.list;
        }
        return watchLaterResponse.copy(str, z2, str5, str6, str7, list2);
    }

    public final String component1() {
        return this.showCount;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final String component3() {
        return this.nextKey;
    }

    public final String component4() {
        return this.splitKey;
    }

    public final String component5() {
        return this.playUrl;
    }

    public final List<WatchLaterItem> component6() {
        return this.list;
    }

    public final WatchLaterResponse copy(String str, boolean z, String str2, String str3, String str4, List<WatchLaterItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new WatchLaterResponse(str, z, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterResponse) {
            WatchLaterResponse watchLaterResponse = (WatchLaterResponse) obj;
            return Intrinsics.areEqual(this.showCount, watchLaterResponse.showCount) && this.hasMore == watchLaterResponse.hasMore && Intrinsics.areEqual(this.nextKey, watchLaterResponse.nextKey) && Intrinsics.areEqual(this.splitKey, watchLaterResponse.splitKey) && Intrinsics.areEqual(this.playUrl, watchLaterResponse.playUrl) && Intrinsics.areEqual(this.list, watchLaterResponse.list);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.showCount == null ? 0 : this.showCount.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + (this.nextKey == null ? 0 : this.nextKey.hashCode())) * 31) + (this.splitKey == null ? 0 : this.splitKey.hashCode())) * 31) + (this.playUrl != null ? this.playUrl.hashCode() : 0)) * 31) + this.list.hashCode();
    }

    public String toString() {
        String str = this.showCount;
        boolean z = this.hasMore;
        String str2 = this.nextKey;
        String str3 = this.splitKey;
        String str4 = this.playUrl;
        return "WatchLaterResponse(showCount=" + str + ", hasMore=" + z + ", nextKey=" + str2 + ", splitKey=" + str3 + ", playUrl=" + str4 + ", list=" + this.list + ")";
    }

    public WatchLaterResponse(String showCount, boolean hasMore, String nextKey, String splitKey, String playUrl, List<WatchLaterItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.showCount = showCount;
        this.hasMore = hasMore;
        this.nextKey = nextKey;
        this.splitKey = splitKey;
        this.playUrl = playUrl;
        this.list = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ WatchLaterResponse(String str, boolean z, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) == 0 ? str4 : null, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getShowCount() {
        return this.showCount;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextKey() {
        return this.nextKey;
    }

    public final String getSplitKey() {
        return this.splitKey;
    }

    public final String getPlayUrl() {
        return this.playUrl;
    }

    public final List<WatchLaterItem> getList() {
        return this.list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.showCount);
        dest.writeInt(this.hasMore ? 1 : 0);
        dest.writeString(this.nextKey);
        dest.writeString(this.splitKey);
        dest.writeString(this.playUrl);
        List<WatchLaterItem> list = this.list;
        dest.writeInt(list.size());
        for (WatchLaterItem watchLaterItem : list) {
            watchLaterItem.writeToParcel(dest, flags);
        }
    }
}