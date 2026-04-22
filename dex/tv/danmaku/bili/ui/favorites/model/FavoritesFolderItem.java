package tv.danmaku.bili.ui.favorites.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J\u008d\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0011HÆ\u0001J\u0013\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0006HÖ\u0001J\t\u0010:\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0011\u0010'\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0011\u0010(\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b(\u0010#¨\u0006;"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "Ltv/danmaku/bili/ui/favorites/model/BaseFavItem;", "fid", "", "mid", "type", "", "attr", "attrDesc", "", ReportUtilKt.POS_TITLE, "jumpLink", "mediaCount", "recentFav", "", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "isTop", "", ReportUtilKt.POS_COVER, "showGuide", "<init>", "(JJIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ZLjava/lang/String;Z)V", "getFid", "()J", "getMid", "getType", "()I", "getAttr", "getAttrDesc", "()Ljava/lang/String;", "getTitle", "getJumpLink", "getMediaCount", "getRecentFav", "()Ljava/util/List;", "()Z", "getCover", "getShowGuide", "isAddFolder", "isPrivate", "isDefault", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFolderItem extends BaseFavItem {
    public static final int $stable = 8;
    @SerializedName("attr")
    private final int attr;
    @SerializedName("attr_desc")
    private final String attrDesc;
    @SerializedName(ReportUtilKt.POS_COVER)
    private final String cover;
    @SerializedName("fid")
    private final long fid;
    @SerializedName("is_top")
    private final boolean isTop;
    @SerializedName("link")
    private final String jumpLink;
    @SerializedName("media_count")
    private final int mediaCount;
    @SerializedName("mid")
    private final long mid;
    @SerializedName("recent_fav")
    private final List<FavoritesMediasItem> recentFav;
    private final boolean showGuide;
    @SerializedName(ReportUtilKt.POS_TITLE)
    private final String title;
    @SerializedName("type")
    private final int type;

    public FavoritesFolderItem() {
        this(0L, 0L, 0, 0, null, null, null, 0, null, false, null, false, 4095, null);
    }

    public final long component1() {
        return this.fid;
    }

    public final boolean component10() {
        return this.isTop;
    }

    public final String component11() {
        return this.cover;
    }

    public final boolean component12() {
        return this.showGuide;
    }

    public final long component2() {
        return this.mid;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.attr;
    }

    public final String component5() {
        return this.attrDesc;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.jumpLink;
    }

    public final int component8() {
        return this.mediaCount;
    }

    public final List<FavoritesMediasItem> component9() {
        return this.recentFav;
    }

    public final FavoritesFolderItem copy(long j, long j2, int i, int i2, String str, String str2, String str3, int i3, List<FavoritesMediasItem> list, boolean z, String str4, boolean z2) {
        Intrinsics.checkNotNullParameter(str2, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(str3, "jumpLink");
        return new FavoritesFolderItem(j, j2, i, i2, str, str2, str3, i3, list, z, str4, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoritesFolderItem) {
            FavoritesFolderItem favoritesFolderItem = (FavoritesFolderItem) obj;
            return this.fid == favoritesFolderItem.fid && this.mid == favoritesFolderItem.mid && this.type == favoritesFolderItem.type && this.attr == favoritesFolderItem.attr && Intrinsics.areEqual(this.attrDesc, favoritesFolderItem.attrDesc) && Intrinsics.areEqual(this.title, favoritesFolderItem.title) && Intrinsics.areEqual(this.jumpLink, favoritesFolderItem.jumpLink) && this.mediaCount == favoritesFolderItem.mediaCount && Intrinsics.areEqual(this.recentFav, favoritesFolderItem.recentFav) && this.isTop == favoritesFolderItem.isTop && Intrinsics.areEqual(this.cover, favoritesFolderItem.cover) && this.showGuide == favoritesFolderItem.showGuide;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.type) * 31) + this.attr) * 31) + (this.attrDesc == null ? 0 : this.attrDesc.hashCode())) * 31) + this.title.hashCode()) * 31) + this.jumpLink.hashCode()) * 31) + this.mediaCount) * 31) + (this.recentFav == null ? 0 : this.recentFav.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isTop)) * 31) + (this.cover != null ? this.cover.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showGuide);
    }

    public String toString() {
        long j = this.fid;
        long j2 = this.mid;
        int i = this.type;
        int i2 = this.attr;
        String str = this.attrDesc;
        String str2 = this.title;
        String str3 = this.jumpLink;
        int i3 = this.mediaCount;
        List<FavoritesMediasItem> list = this.recentFav;
        boolean z = this.isTop;
        String str4 = this.cover;
        return "FavoritesFolderItem(fid=" + j + ", mid=" + j2 + ", type=" + i + ", attr=" + i2 + ", attrDesc=" + str + ", title=" + str2 + ", jumpLink=" + str3 + ", mediaCount=" + i3 + ", recentFav=" + list + ", isTop=" + z + ", cover=" + str4 + ", showGuide=" + this.showGuide + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFolderItem(long fid, long mid, int type, int attr, String attrDesc, String title, String jumpLink, int mediaCount, List<FavoritesMediasItem> list, boolean isTop, String cover, boolean showGuide) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        this.fid = fid;
        this.mid = mid;
        this.type = type;
        this.attr = attr;
        this.attrDesc = attrDesc;
        this.title = title;
        this.jumpLink = jumpLink;
        this.mediaCount = mediaCount;
        this.recentFav = list;
        this.isTop = isTop;
        this.cover = cover;
        this.showGuide = showGuide;
    }

    public /* synthetic */ FavoritesFolderItem(long j, long j2, int i, int i2, String str, String str2, String str3, int i3, List list, boolean z, String str4, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) == 0 ? j2 : 0L, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? null : str, (i4 & 32) != 0 ? "" : str2, (i4 & 64) == 0 ? str3 : "", (i4 & BR.cover) != 0 ? 0 : i3, (i4 & BR.hallEnterHotText) != 0 ? CollectionsKt.emptyList() : list, (i4 & BR.roleType) != 0 ? false : z, (i4 & MisakaHelper.MAX_REPORT_SIZE) == 0 ? str4 : null, (i4 & 2048) == 0 ? z2 : false);
    }

    public final long getFid() {
        return this.fid;
    }

    public final long getMid() {
        return this.mid;
    }

    public final int getType() {
        return this.type;
    }

    public final int getAttr() {
        return this.attr;
    }

    public final String getAttrDesc() {
        return this.attrDesc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    public final int getMediaCount() {
        return this.mediaCount;
    }

    public final List<FavoritesMediasItem> getRecentFav() {
        return this.recentFav;
    }

    public final boolean isTop() {
        return this.isTop;
    }

    public final String getCover() {
        return this.cover;
    }

    public final boolean getShowGuide() {
        return this.showGuide;
    }

    public final boolean isAddFolder() {
        return this.viewType == 1;
    }

    public final boolean isPrivate() {
        return (this.attr & 1) == 1;
    }

    public final boolean isDefault() {
        return ((this.attr >> 1) & 1) == 0;
    }
}