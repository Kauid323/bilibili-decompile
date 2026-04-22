package home.sidecenter.recent;

import BottomSheetItemData$;
import com.bapis.bilibili.app.home.v1.KArcInfo;
import com.bapis.bilibili.app.home.v1.KBadge;
import com.bapis.bilibili.app.home.v1.KRecentRecommendMetaInfo;
import com.yalantis.ucrop.view.CropImageView;
import home.sidecenter.recent.RecentContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001d\u001a\u00020\u0001H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J'\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0016HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lhome/sidecenter/recent/RecentVideoContent;", "Lhome/sidecenter/recent/RecentContent;", "kContent", "Lcom/bapis/bilibili/app/home/v1/KArcInfo;", "fromCache", "", "deleted", "<init>", "(Lcom/bapis/bilibili/app/home/v1/KArcInfo;ZZ)V", "getFromCache", "()Z", "getDeleted", "recMeta", "Lcom/bapis/bilibili/app/home/v1/KRecentRecommendMetaInfo;", "getRecMeta", "()Lcom/bapis/bilibili/app/home/v1/KRecentRecommendMetaInfo;", "duration", "Lkotlin/time/Duration;", "getDuration-UwyO8pc", "()J", "J", "durationDisplay", "", "getDurationDisplay", "()Ljava/lang/String;", "progressPercent", "", "getProgressPercent", "()F", "markDeleted", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentVideoContent implements RecentContent {
    public static final int $stable = 8;
    private final boolean deleted;
    private final long duration;
    private final String durationDisplay;
    private final boolean fromCache;
    private final KArcInfo kContent;
    private final float progressPercent;

    private final KArcInfo component1() {
        return this.kContent;
    }

    public static /* synthetic */ RecentVideoContent copy$default(RecentVideoContent recentVideoContent, KArcInfo kArcInfo, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kArcInfo = recentVideoContent.kContent;
        }
        if ((i2 & 2) != 0) {
            z = recentVideoContent.fromCache;
        }
        if ((i2 & 4) != 0) {
            z2 = recentVideoContent.deleted;
        }
        return recentVideoContent.copy(kArcInfo, z, z2);
    }

    public final boolean component2() {
        return this.fromCache;
    }

    public final boolean component3() {
        return this.deleted;
    }

    public final RecentVideoContent copy(KArcInfo kArcInfo, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(kArcInfo, "kContent");
        return new RecentVideoContent(kArcInfo, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentVideoContent) {
            RecentVideoContent recentVideoContent = (RecentVideoContent) obj;
            return Intrinsics.areEqual(this.kContent, recentVideoContent.kContent) && this.fromCache == recentVideoContent.fromCache && this.deleted == recentVideoContent.deleted;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kContent.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromCache)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.deleted);
    }

    public String toString() {
        KArcInfo kArcInfo = this.kContent;
        boolean z = this.fromCache;
        return "RecentVideoContent(kContent=" + kArcInfo + ", fromCache=" + z + ", deleted=" + this.deleted + ")";
    }

    public RecentVideoContent(KArcInfo kContent, boolean fromCache, boolean deleted) {
        float f2;
        Intrinsics.checkNotNullParameter(kContent, "kContent");
        this.kContent = kContent;
        this.fromCache = fromCache;
        this.deleted = deleted;
        Duration.Companion companion = Duration.Companion;
        this.duration = DurationKt.toDuration(this.kContent.getDurationSec(), DurationUnit.SECONDS);
        this.durationDisplay = ContentKt.m3058toDisplayStringLRDsOJo(this.duration);
        if (this.kContent.getDurationSec() > 0) {
            f2 = ((float) this.kContent.getProgressSec()) / ((float) this.kContent.getDurationSec());
        } else {
            f2 = 0.0f;
        }
        this.progressPercent = RangesKt.coerceIn(f2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
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

    public /* synthetic */ RecentVideoContent(KArcInfo kArcInfo, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kArcInfo, z, (i2 & 4) != 0 ? false : z2);
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
        return this.kContent.getRecMeta();
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m3059getDurationUwyO8pc() {
        return this.duration;
    }

    public final String getDurationDisplay() {
        return this.durationDisplay;
    }

    public final float getProgressPercent() {
        return this.progressPercent;
    }

    @Override // home.sidecenter.recent.RecentContent
    public RecentContent markDeleted() {
        return copy$default(this, null, false, true, 3, null);
    }
}