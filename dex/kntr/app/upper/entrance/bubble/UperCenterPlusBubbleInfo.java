package kntr.app.upper.entrance.bubble;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UperCenterPlusBubbleInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003J\u008b\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0012HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00069"}, d2 = {"Lkntr/app/upper/entrance/bubble/UperCenterPlusBubbleInfo;", "", "id", "", "title", "titleId", "subtitle", "url", "routeUrl", "strategyId", "resourceId", "fans", "", "interestScore", "", "hotScore", "resourceType", "force", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JFFLjava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getTitle", "getTitleId", "getSubtitle", "getUrl", "getRouteUrl", "getStrategyId", "getResourceId", "getFans", "()J", "getInterestScore", "()F", "getHotScore", "getResourceType", "getForce", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UperCenterPlusBubbleInfo {
    private final long fans;
    private final int force;
    private final float hotScore;
    private final String id;
    private final float interestScore;
    private final String resourceId;
    private final String resourceType;
    private final String routeUrl;
    private final String strategyId;
    private final String subtitle;
    private final String title;
    private final String titleId;
    private final String url;

    public final String component1() {
        return this.id;
    }

    public final float component10() {
        return this.interestScore;
    }

    public final float component11() {
        return this.hotScore;
    }

    public final String component12() {
        return this.resourceType;
    }

    public final int component13() {
        return this.force;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.titleId;
    }

    public final String component4() {
        return this.subtitle;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.routeUrl;
    }

    public final String component7() {
        return this.strategyId;
    }

    public final String component8() {
        return this.resourceId;
    }

    public final long component9() {
        return this.fans;
    }

    public final UperCenterPlusBubbleInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j, float f, float f2, String str9, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "titleId");
        Intrinsics.checkNotNullParameter(str4, "subtitle");
        Intrinsics.checkNotNullParameter(str5, "url");
        Intrinsics.checkNotNullParameter(str6, "routeUrl");
        Intrinsics.checkNotNullParameter(str7, "strategyId");
        Intrinsics.checkNotNullParameter(str8, "resourceId");
        Intrinsics.checkNotNullParameter(str9, "resourceType");
        return new UperCenterPlusBubbleInfo(str, str2, str3, str4, str5, str6, str7, str8, j, f, f2, str9, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UperCenterPlusBubbleInfo) {
            UperCenterPlusBubbleInfo uperCenterPlusBubbleInfo = (UperCenterPlusBubbleInfo) obj;
            return Intrinsics.areEqual(this.id, uperCenterPlusBubbleInfo.id) && Intrinsics.areEqual(this.title, uperCenterPlusBubbleInfo.title) && Intrinsics.areEqual(this.titleId, uperCenterPlusBubbleInfo.titleId) && Intrinsics.areEqual(this.subtitle, uperCenterPlusBubbleInfo.subtitle) && Intrinsics.areEqual(this.url, uperCenterPlusBubbleInfo.url) && Intrinsics.areEqual(this.routeUrl, uperCenterPlusBubbleInfo.routeUrl) && Intrinsics.areEqual(this.strategyId, uperCenterPlusBubbleInfo.strategyId) && Intrinsics.areEqual(this.resourceId, uperCenterPlusBubbleInfo.resourceId) && this.fans == uperCenterPlusBubbleInfo.fans && Float.compare(this.interestScore, uperCenterPlusBubbleInfo.interestScore) == 0 && Float.compare(this.hotScore, uperCenterPlusBubbleInfo.hotScore) == 0 && Intrinsics.areEqual(this.resourceType, uperCenterPlusBubbleInfo.resourceType) && this.force == uperCenterPlusBubbleInfo.force;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.titleId.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.url.hashCode()) * 31) + this.routeUrl.hashCode()) * 31) + this.strategyId.hashCode()) * 31) + this.resourceId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fans)) * 31) + Float.floatToIntBits(this.interestScore)) * 31) + Float.floatToIntBits(this.hotScore)) * 31) + this.resourceType.hashCode()) * 31) + this.force;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.title;
        String str3 = this.titleId;
        String str4 = this.subtitle;
        String str5 = this.url;
        String str6 = this.routeUrl;
        String str7 = this.strategyId;
        String str8 = this.resourceId;
        long j = this.fans;
        float f = this.interestScore;
        float f2 = this.hotScore;
        String str9 = this.resourceType;
        return "UperCenterPlusBubbleInfo(id=" + str + ", title=" + str2 + ", titleId=" + str3 + ", subtitle=" + str4 + ", url=" + str5 + ", routeUrl=" + str6 + ", strategyId=" + str7 + ", resourceId=" + str8 + ", fans=" + j + ", interestScore=" + f + ", hotScore=" + f2 + ", resourceType=" + str9 + ", force=" + this.force + ")";
    }

    public UperCenterPlusBubbleInfo(String id, String title, String titleId, String subtitle, String url, String routeUrl, String strategyId, String resourceId, long fans, float interestScore, float hotScore, String resourceType, int force) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(titleId, "titleId");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(routeUrl, "routeUrl");
        Intrinsics.checkNotNullParameter(strategyId, "strategyId");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(resourceType, "resourceType");
        this.id = id;
        this.title = title;
        this.titleId = titleId;
        this.subtitle = subtitle;
        this.url = url;
        this.routeUrl = routeUrl;
        this.strategyId = strategyId;
        this.resourceId = resourceId;
        this.fans = fans;
        this.interestScore = interestScore;
        this.hotScore = hotScore;
        this.resourceType = resourceType;
        this.force = force;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleId() {
        return this.titleId;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getRouteUrl() {
        return this.routeUrl;
    }

    public final String getStrategyId() {
        return this.strategyId;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final long getFans() {
        return this.fans;
    }

    public final float getInterestScore() {
        return this.interestScore;
    }

    public final float getHotScore() {
        return this.hotScore;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final int getForce() {
        return this.force;
    }
}