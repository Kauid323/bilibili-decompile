package home.sidecenter.recent;

import BottomSheetItemData$;
import com.bapis.bilibili.app.home.v1.KBadge;
import com.bapis.bilibili.app.home.v1.KFavInfo;
import com.bapis.bilibili.app.home.v1.KRecentRecommendMetaInfo;
import home.sidecenter.recent.RecentContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0001H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lhome/sidecenter/recent/RecentFavContent;", "Lhome/sidecenter/recent/RecentContent;", "kFav", "Lcom/bapis/bilibili/app/home/v1/KFavInfo;", "fromCache", "", "deleted", "<init>", "(Lcom/bapis/bilibili/app/home/v1/KFavInfo;ZZ)V", "getFromCache", "()Z", "getDeleted", "recMeta", "Lcom/bapis/bilibili/app/home/v1/KRecentRecommendMetaInfo;", "getRecMeta", "()Lcom/bapis/bilibili/app/home/v1/KRecentRecommendMetaInfo;", "markDeleted", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentFavContent implements RecentContent {
    public static final int $stable = 8;
    private final boolean deleted;
    private final boolean fromCache;
    private final KFavInfo kFav;

    private final KFavInfo component1() {
        return this.kFav;
    }

    public static /* synthetic */ RecentFavContent copy$default(RecentFavContent recentFavContent, KFavInfo kFavInfo, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kFavInfo = recentFavContent.kFav;
        }
        if ((i2 & 2) != 0) {
            z = recentFavContent.fromCache;
        }
        if ((i2 & 4) != 0) {
            z2 = recentFavContent.deleted;
        }
        return recentFavContent.copy(kFavInfo, z, z2);
    }

    public final boolean component2() {
        return this.fromCache;
    }

    public final boolean component3() {
        return this.deleted;
    }

    public final RecentFavContent copy(KFavInfo kFavInfo, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(kFavInfo, "kFav");
        return new RecentFavContent(kFavInfo, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentFavContent) {
            RecentFavContent recentFavContent = (RecentFavContent) obj;
            return Intrinsics.areEqual(this.kFav, recentFavContent.kFav) && this.fromCache == recentFavContent.fromCache && this.deleted == recentFavContent.deleted;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kFav.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromCache)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.deleted);
    }

    public String toString() {
        KFavInfo kFavInfo = this.kFav;
        boolean z = this.fromCache;
        return "RecentFavContent(kFav=" + kFavInfo + ", fromCache=" + z + ", deleted=" + this.deleted + ")";
    }

    public RecentFavContent(KFavInfo kFav, boolean fromCache, boolean deleted) {
        Intrinsics.checkNotNullParameter(kFav, "kFav");
        this.kFav = kFav;
        this.fromCache = fromCache;
        this.deleted = deleted;
    }

    public /* synthetic */ RecentFavContent(KFavInfo kFavInfo, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kFavInfo, z, (i2 & 4) != 0 ? false : z2);
    }

    @Override // home.sidecenter.recent.RecentContent
    public /* bridge */ String getAddTime() {
        return RecentContent.CC.$default$getAddTime(this);
    }

    @Override // home.sidecenter.recent.RecentContent
    public /* bridge */ KBadge getBadge() {
        return RecentContent.CC.$default$getBadge(this);
    }

    @Override // home.sidecenter.recent.RecentContent
    public /* bridge */ String getCover() {
        return RecentContent.CC.$default$getCover(this);
    }

    @Override // home.sidecenter.recent.RecentContent
    public /* bridge */ String getSubTitle() {
        return RecentContent.CC.$default$getSubTitle(this);
    }

    @Override // home.sidecenter.recent.RecentContent
    public /* bridge */ String getTitle() {
        return RecentContent.CC.$default$getTitle(this);
    }

    @Override // home.sidecenter.recent.RecentContent
    public /* bridge */ String getUrl() {
        return RecentContent.CC.$default$getUrl(this);
    }

    @Override // home.sidecenter.recent.RecentContent
    public boolean getFromCache() {
        return this.fromCache;
    }

    @Override // home.sidecenter.recent.RecentContent
    public boolean getDeleted() {
        return this.deleted;
    }

    @Override // home.sidecenter.recent.RecentContent
    public KRecentRecommendMetaInfo getRecMeta() {
        return this.kFav.getRecMeta();
    }

    @Override // home.sidecenter.recent.RecentContent
    public RecentContent markDeleted() {
        return copy$default(this, null, false, true, 3, null);
    }
}