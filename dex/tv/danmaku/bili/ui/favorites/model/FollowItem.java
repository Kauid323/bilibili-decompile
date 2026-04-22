package tv.danmaku.bili.ui.favorites.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J£\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0013\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\t\u0010C\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001aR\u0011\u0010)\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b)\u0010\u001cR\u0011\u0010*\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0011\u0010+\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b,\u0010\u001cR\u0011\u0010-\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b.\u0010\u001cR\u0011\u0010/\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u0010\u001c¨\u0006D"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FollowItem;", "Ltv/danmaku/bili/ui/favorites/model/BaseFavItem;", "oid", "", "otype", "", "tagName", "", "tagType", ReportUtilKt.POS_TITLE, ReportUtilKt.POS_COVER, "progressDesc", "historyDesc", "jumpLink", "lastView", "", "redDot", "share", "Ltv/danmaku/bili/ui/favorites/model/Share;", "userState", "isFinish", "<init>", "(JILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLtv/danmaku/bili/ui/favorites/model/Share;II)V", "getOid", "()J", "getOtype", "()I", "getTagName", "()Ljava/lang/String;", "getTagType", "getTitle", "getCover", "getProgressDesc", "getHistoryDesc", "getJumpLink", "getLastView", "()Z", "getRedDot", "getShare", "()Ltv/danmaku/bili/ui/favorites/model/Share;", "getUserState", "isLastSeen", "isRenewal", "resources", "getResources", "userStateStr", "getUserStateStr", "isEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowItem extends BaseFavItem {
    public static final int $stable = 8;
    @SerializedName(ReportUtilKt.POS_COVER)
    private final String cover;
    @SerializedName("history_desc")
    private final String historyDesc;
    @SerializedName("is_finish")
    private final int isFinish;
    @SerializedName("jump_link")
    private final String jumpLink;
    @SerializedName("last_view")
    private final boolean lastView;
    @SerializedName("oid")
    private final long oid;
    @SerializedName("otype")
    private final int otype;
    @SerializedName("progress_desc")
    private final String progressDesc;
    @SerializedName("red_dot")
    private final boolean redDot;
    @SerializedName("share")
    private final Share share;
    @SerializedName("tag_name")
    private final String tagName;
    @SerializedName("tag_type")
    private final int tagType;
    @SerializedName(ReportUtilKt.POS_TITLE)
    private final String title;
    @SerializedName(FavoritesConstsKt.USER_STATE)
    private final int userState;

    public FollowItem() {
        this(0L, 0, null, 0, null, null, null, null, null, false, false, null, 0, 0, 16383, null);
    }

    public final long component1() {
        return this.oid;
    }

    public final boolean component10() {
        return this.lastView;
    }

    public final boolean component11() {
        return this.redDot;
    }

    public final Share component12() {
        return this.share;
    }

    public final int component13() {
        return this.userState;
    }

    public final int component14() {
        return this.isFinish;
    }

    public final int component2() {
        return this.otype;
    }

    public final String component3() {
        return this.tagName;
    }

    public final int component4() {
        return this.tagType;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.cover;
    }

    public final String component7() {
        return this.progressDesc;
    }

    public final String component8() {
        return this.historyDesc;
    }

    public final String component9() {
        return this.jumpLink;
    }

    public final FollowItem copy(long j, int i, String str, int i2, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, Share share, int i3, int i4) {
        return new FollowItem(j, i, str, i2, str2, str3, str4, str5, str6, z, z2, share, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FollowItem) {
            FollowItem followItem = (FollowItem) obj;
            return this.oid == followItem.oid && this.otype == followItem.otype && Intrinsics.areEqual(this.tagName, followItem.tagName) && this.tagType == followItem.tagType && Intrinsics.areEqual(this.title, followItem.title) && Intrinsics.areEqual(this.cover, followItem.cover) && Intrinsics.areEqual(this.progressDesc, followItem.progressDesc) && Intrinsics.areEqual(this.historyDesc, followItem.historyDesc) && Intrinsics.areEqual(this.jumpLink, followItem.jumpLink) && this.lastView == followItem.lastView && this.redDot == followItem.redDot && Intrinsics.areEqual(this.share, followItem.share) && this.userState == followItem.userState && this.isFinish == followItem.isFinish;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.oid) * 31) + this.otype) * 31) + (this.tagName == null ? 0 : this.tagName.hashCode())) * 31) + this.tagType) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.progressDesc == null ? 0 : this.progressDesc.hashCode())) * 31) + (this.historyDesc == null ? 0 : this.historyDesc.hashCode())) * 31) + (this.jumpLink == null ? 0 : this.jumpLink.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.lastView)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.redDot)) * 31) + (this.share != null ? this.share.hashCode() : 0)) * 31) + this.userState) * 31) + this.isFinish;
    }

    public String toString() {
        long j = this.oid;
        int i = this.otype;
        String str = this.tagName;
        int i2 = this.tagType;
        String str2 = this.title;
        String str3 = this.cover;
        String str4 = this.progressDesc;
        String str5 = this.historyDesc;
        String str6 = this.jumpLink;
        boolean z = this.lastView;
        boolean z2 = this.redDot;
        Share share = this.share;
        int i3 = this.userState;
        return "FollowItem(oid=" + j + ", otype=" + i + ", tagName=" + str + ", tagType=" + i2 + ", title=" + str2 + ", cover=" + str3 + ", progressDesc=" + str4 + ", historyDesc=" + str5 + ", jumpLink=" + str6 + ", lastView=" + z + ", redDot=" + z2 + ", share=" + share + ", userState=" + i3 + ", isFinish=" + this.isFinish + ")";
    }

    public FollowItem(long oid, int otype, String tagName, int tagType, String title, String cover, String progressDesc, String historyDesc, String jumpLink, boolean lastView, boolean redDot, Share share, int userState, int isFinish) {
        super(false, 1, null);
        this.oid = oid;
        this.otype = otype;
        this.tagName = tagName;
        this.tagType = tagType;
        this.title = title;
        this.cover = cover;
        this.progressDesc = progressDesc;
        this.historyDesc = historyDesc;
        this.jumpLink = jumpLink;
        this.lastView = lastView;
        this.redDot = redDot;
        this.share = share;
        this.userState = userState;
        this.isFinish = isFinish;
    }

    public /* synthetic */ FollowItem(long j, int i, String str, int i2, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, Share share, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0L : j, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? null : str, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? null : str2, (i5 & 32) != 0 ? null : str3, (i5 & 64) != 0 ? null : str4, (i5 & BR.cover) != 0 ? null : str5, (i5 & BR.hallEnterHotText) != 0 ? null : str6, (i5 & BR.roleType) != 0 ? false : z, (i5 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? false : z2, (i5 & 2048) == 0 ? share : null, (i5 & 4096) != 0 ? 0 : i3, (i5 & 8192) == 0 ? i4 : 0);
    }

    public final long getOid() {
        return this.oid;
    }

    public final int getOtype() {
        return this.otype;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final int getTagType() {
        return this.tagType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getProgressDesc() {
        return this.progressDesc;
    }

    public final String getHistoryDesc() {
        return this.historyDesc;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    public final boolean getLastView() {
        return this.lastView;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    public final Share getShare() {
        return this.share;
    }

    public final int getUserState() {
        return this.userState;
    }

    public final int isFinish() {
        return this.isFinish;
    }

    public final String isLastSeen() {
        return String.valueOf(this.lastView ? 1 : 0);
    }

    public final String isRenewal() {
        return String.valueOf(this.redDot ? 1 : 0);
    }

    public final String getResources() {
        long j = this.oid;
        return j + ":" + this.otype;
    }

    public final String getUserStateStr() {
        return this.userState == 1 ? "finished" : this.userState == 2 ? "watching" : "";
    }

    public final String isEnd() {
        return this.isFinish == 1 ? "end" : this.isFinish == 2 ? "not end" : "";
    }
}