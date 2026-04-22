package tv.danmaku.bili.ui.watchlater.data;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import bili.resource.common.R;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.NumberFormat;
import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0010HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J×\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0007HÆ\u0001J\u0006\u0010J\u001a\u00020\u0003J\u0013\u0010K\u001a\u00020\u00102\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\t\u0010O\u001a\u00020\u0007HÖ\u0001J\u0016\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010*R\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u00103\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b3\u0010*R\u0013\u00104\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b5\u0010!¨\u0006U"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WatchLaterItem;", "Landroid/os/Parcelable;", "cardType", "", "aid", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "intro", "pic", "duration", "progress", "uri", "arcState", "pgcLabel", "showUp", "", "forbidFav", "owner", "Ltv/danmaku/bili/ui/watchlater/data/Owner;", "leftIconType", "leftText", "rightIconType", "rightText", "isChecked", "itemId", "<init>", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ILjava/lang/String;ZZLtv/danmaku/bili/ui/watchlater/data/Owner;ILjava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "getCardType", "()I", "getAid", "()J", "getTitle", "()Ljava/lang/String;", "getIntro", "getPic", "getDuration", "getProgress", "getUri", "getArcState", "getPgcLabel", "getShowUp", "()Z", "getForbidFav", "getOwner", "()Ltv/danmaku/bili/ui/watchlater/data/Owner;", "getLeftIconType", "getLeftText", "getRightIconType", "getRightText", "getItemId", "isInvalid", "coverText", "getCoverText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterItem implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<WatchLaterItem> CREATOR = new Creator();
    @SerializedName("aid")
    private final long aid;
    @SerializedName("arc_state")
    private final int arcState;
    @SerializedName("card_type")
    private final int cardType;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("forbid_fav")
    private final boolean forbidFav;
    @SerializedName("intro")
    private final String intro;
    private final boolean isChecked;
    private final String itemId;
    @SerializedName("left_icon_type")
    private final int leftIconType;
    @SerializedName("left_text")
    private final String leftText;
    @SerializedName("owner")
    private final Owner owner;
    @SerializedName("pgc_label")
    private final String pgcLabel;
    @SerializedName("pic")
    private final String pic;
    @SerializedName("progress")
    private final long progress;
    @SerializedName("right_icon_type")
    private final int rightIconType;
    @SerializedName("right_text")
    private final String rightText;
    @SerializedName("show_up")
    private final boolean showUp;
    @SerializedName(RankRouter.BundleKey.ACTION_PARAM_TITLE)
    private final String title;
    @SerializedName("uri")
    private final String uri;

    /* compiled from: WatchLaterResponse.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Creator implements Parcelable.Creator<WatchLaterItem> {
        @Override // android.os.Parcelable.Creator
        public final WatchLaterItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WatchLaterItem(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Owner.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final WatchLaterItem[] newArray(int i) {
            return new WatchLaterItem[i];
        }
    }

    public WatchLaterItem() {
        this(0, 0L, null, null, null, 0L, 0L, null, 0, null, false, false, null, 0, null, 0, null, false, null, 524287, null);
    }

    public final int component1() {
        return this.cardType;
    }

    public final String component10() {
        return this.pgcLabel;
    }

    public final boolean component11() {
        return this.showUp;
    }

    public final boolean component12() {
        return this.forbidFav;
    }

    public final Owner component13() {
        return this.owner;
    }

    public final int component14() {
        return this.leftIconType;
    }

    public final String component15() {
        return this.leftText;
    }

    public final int component16() {
        return this.rightIconType;
    }

    public final String component17() {
        return this.rightText;
    }

    public final boolean component18() {
        return this.isChecked;
    }

    public final String component19() {
        return this.itemId;
    }

    public final long component2() {
        return this.aid;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.intro;
    }

    public final String component5() {
        return this.pic;
    }

    public final long component6() {
        return this.duration;
    }

    public final long component7() {
        return this.progress;
    }

    public final String component8() {
        return this.uri;
    }

    public final int component9() {
        return this.arcState;
    }

    public final WatchLaterItem copy(int i, long j, String str, String str2, String str3, long j2, long j3, String str4, int i2, String str5, boolean z, boolean z2, Owner owner, int i3, String str6, int i4, String str7, boolean z3, String str8) {
        Intrinsics.checkNotNullParameter(str8, "itemId");
        return new WatchLaterItem(i, j, str, str2, str3, j2, j3, str4, i2, str5, z, z2, owner, i3, str6, i4, str7, z3, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterItem) {
            WatchLaterItem watchLaterItem = (WatchLaterItem) obj;
            return this.cardType == watchLaterItem.cardType && this.aid == watchLaterItem.aid && Intrinsics.areEqual(this.title, watchLaterItem.title) && Intrinsics.areEqual(this.intro, watchLaterItem.intro) && Intrinsics.areEqual(this.pic, watchLaterItem.pic) && this.duration == watchLaterItem.duration && this.progress == watchLaterItem.progress && Intrinsics.areEqual(this.uri, watchLaterItem.uri) && this.arcState == watchLaterItem.arcState && Intrinsics.areEqual(this.pgcLabel, watchLaterItem.pgcLabel) && this.showUp == watchLaterItem.showUp && this.forbidFav == watchLaterItem.forbidFav && Intrinsics.areEqual(this.owner, watchLaterItem.owner) && this.leftIconType == watchLaterItem.leftIconType && Intrinsics.areEqual(this.leftText, watchLaterItem.leftText) && this.rightIconType == watchLaterItem.rightIconType && Intrinsics.areEqual(this.rightText, watchLaterItem.rightText) && this.isChecked == watchLaterItem.isChecked && Intrinsics.areEqual(this.itemId, watchLaterItem.itemId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.cardType * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid)) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.intro == null ? 0 : this.intro.hashCode())) * 31) + (this.pic == null ? 0 : this.pic.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.progress)) * 31) + (this.uri == null ? 0 : this.uri.hashCode())) * 31) + this.arcState) * 31) + (this.pgcLabel == null ? 0 : this.pgcLabel.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showUp)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forbidFav)) * 31) + (this.owner == null ? 0 : this.owner.hashCode())) * 31) + this.leftIconType) * 31) + (this.leftText == null ? 0 : this.leftText.hashCode())) * 31) + this.rightIconType) * 31) + (this.rightText != null ? this.rightText.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked)) * 31) + this.itemId.hashCode();
    }

    public String toString() {
        int i = this.cardType;
        long j = this.aid;
        String str = this.title;
        String str2 = this.intro;
        String str3 = this.pic;
        long j2 = this.duration;
        long j3 = this.progress;
        String str4 = this.uri;
        int i2 = this.arcState;
        String str5 = this.pgcLabel;
        boolean z = this.showUp;
        boolean z2 = this.forbidFav;
        Owner owner = this.owner;
        int i3 = this.leftIconType;
        String str6 = this.leftText;
        int i4 = this.rightIconType;
        String str7 = this.rightText;
        boolean z3 = this.isChecked;
        return "WatchLaterItem(cardType=" + i + ", aid=" + j + ", title=" + str + ", intro=" + str2 + ", pic=" + str3 + ", duration=" + j2 + ", progress=" + j3 + ", uri=" + str4 + ", arcState=" + i2 + ", pgcLabel=" + str5 + ", showUp=" + z + ", forbidFav=" + z2 + ", owner=" + owner + ", leftIconType=" + i3 + ", leftText=" + str6 + ", rightIconType=" + i4 + ", rightText=" + str7 + ", isChecked=" + z3 + ", itemId=" + this.itemId + ")";
    }

    public WatchLaterItem(int cardType, long aid, String title, String intro, String pic, long duration, long progress, String uri, int arcState, String pgcLabel, boolean showUp, boolean forbidFav, Owner owner, int leftIconType, String leftText, int rightIconType, String rightText, boolean isChecked, String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.cardType = cardType;
        this.aid = aid;
        this.title = title;
        this.intro = intro;
        this.pic = pic;
        this.duration = duration;
        this.progress = progress;
        this.uri = uri;
        this.arcState = arcState;
        this.pgcLabel = pgcLabel;
        this.showUp = showUp;
        this.forbidFav = forbidFav;
        this.owner = owner;
        this.leftIconType = leftIconType;
        this.leftText = leftText;
        this.rightIconType = rightIconType;
        this.rightText = rightText;
        this.isChecked = isChecked;
        this.itemId = itemId;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ WatchLaterItem(int i, long j, String str, String str2, String str3, long j2, long j3, String str4, int i2, String str5, boolean z, boolean z2, Owner owner, int i3, String str6, int i4, String str7, boolean z3, String str8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r6, r3, r8, r10, r11, r4, r13, r48, r22, r2, r16, r17, r18, r23, r19, r20, r21, r0);
        String str9;
        int i6;
        String str10;
        String str11;
        int i7 = (i5 & 1) != 0 ? 0 : i;
        long j4 = (i5 & 2) != 0 ? 0L : j;
        String str12 = (i5 & 4) != 0 ? "" : str;
        String str13 = (i5 & 8) != 0 ? null : str2;
        String str14 = (i5 & 16) != 0 ? null : str3;
        long j5 = (i5 & 32) != 0 ? 0L : j2;
        long j6 = (i5 & 64) == 0 ? j3 : 0L;
        String str15 = (i5 & 128) != 0 ? null : str4;
        int i8 = (i5 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i2;
        String str16 = (i5 & 512) != 0 ? null : str5;
        boolean z4 = (i5 & 1024) != 0 ? true : z;
        boolean z5 = (i5 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? false : z2;
        Owner owner2 = (i5 & 4096) != 0 ? null : owner;
        int i9 = (i5 & 8192) != 0 ? 0 : i3;
        String str17 = (i5 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? null : str6;
        int i10 = (i5 & 32768) != 0 ? 0 : i4;
        String str18 = (i5 & 65536) != 0 ? null : str7;
        boolean z6 = (i5 & 131072) != 0 ? false : z3;
        if ((i5 & 262144) != 0) {
            i6 = i8;
            str10 = str16;
            str9 = str17;
            str11 = UUID.randomUUID().toString() + System.currentTimeMillis();
        } else {
            str9 = str17;
            i6 = i8;
            str10 = str16;
            str11 = str8;
        }
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final long getAid() {
        return this.aid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final String getPic() {
        return this.pic;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getArcState() {
        return this.arcState;
    }

    public final String getPgcLabel() {
        return this.pgcLabel;
    }

    public final boolean getShowUp() {
        return this.showUp;
    }

    public final boolean getForbidFav() {
        return this.forbidFav;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final int getLeftIconType() {
        return this.leftIconType;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final int getRightIconType() {
        return this.rightIconType;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final boolean isInvalid() {
        return this.arcState < 0;
    }

    public final String getCoverText() {
        if (isInvalid()) {
            Application application = BiliContext.application();
            if (application != null) {
                return application.getString(R.string.common_global_string_26);
            }
            return null;
        }
        long j = this.progress;
        if (j == 0) {
            return NumberFormat.formatPlayTime(this.duration * ((long) IjkMediaCodecInfo.RANK_MAX));
        }
        if (j == -1) {
            Application application2 = BiliContext.application();
            if (application2 != null) {
                return application2.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_626);
            }
            return null;
        }
        long j2 = this.progress;
        long j3 = (long) IjkMediaCodecInfo.RANK_MAX;
        String formatPlayTime = NumberFormat.formatPlayTime(j2 * j3);
        return formatPlayTime + " / " + NumberFormat.formatPlayTime(this.duration * j3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.cardType);
        dest.writeLong(this.aid);
        dest.writeString(this.title);
        dest.writeString(this.intro);
        dest.writeString(this.pic);
        dest.writeLong(this.duration);
        dest.writeLong(this.progress);
        dest.writeString(this.uri);
        dest.writeInt(this.arcState);
        dest.writeString(this.pgcLabel);
        dest.writeInt(this.showUp ? 1 : 0);
        dest.writeInt(this.forbidFav ? 1 : 0);
        Owner owner = this.owner;
        if (owner == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            owner.writeToParcel(dest, flags);
        }
        dest.writeInt(this.leftIconType);
        dest.writeString(this.leftText);
        dest.writeInt(this.rightIconType);
        dest.writeString(this.rightText);
        dest.writeInt(this.isChecked ? 1 : 0);
        dest.writeString(this.itemId);
    }
}