package tv.danmaku.biliplayerv2.service.interact.biz;

import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractLayerService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/SharedSubtitle;", "", RankRouter.RankConst.TAB_MAIN, "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "vice", "<init>", "(Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;)V", "getMain", "()Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "getVice", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SharedSubtitle {
    private final SubtitleItem main;
    private final SubtitleItem vice;

    public SharedSubtitle() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ SharedSubtitle copy$default(SharedSubtitle sharedSubtitle, SubtitleItem subtitleItem, SubtitleItem subtitleItem2, int i, Object obj) {
        if ((i & 1) != 0) {
            subtitleItem = sharedSubtitle.main;
        }
        if ((i & 2) != 0) {
            subtitleItem2 = sharedSubtitle.vice;
        }
        return sharedSubtitle.copy(subtitleItem, subtitleItem2);
    }

    public final SubtitleItem component1() {
        return this.main;
    }

    public final SubtitleItem component2() {
        return this.vice;
    }

    public final SharedSubtitle copy(SubtitleItem subtitleItem, SubtitleItem subtitleItem2) {
        return new SharedSubtitle(subtitleItem, subtitleItem2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharedSubtitle) {
            SharedSubtitle sharedSubtitle = (SharedSubtitle) obj;
            return Intrinsics.areEqual(this.main, sharedSubtitle.main) && Intrinsics.areEqual(this.vice, sharedSubtitle.vice);
        }
        return false;
    }

    public int hashCode() {
        return ((this.main == null ? 0 : this.main.hashCode()) * 31) + (this.vice != null ? this.vice.hashCode() : 0);
    }

    public String toString() {
        SubtitleItem subtitleItem = this.main;
        return "SharedSubtitle(main=" + subtitleItem + ", vice=" + this.vice + ")";
    }

    public SharedSubtitle(SubtitleItem main, SubtitleItem vice) {
        this.main = main;
        this.vice = vice;
    }

    public /* synthetic */ SharedSubtitle(SubtitleItem subtitleItem, SubtitleItem subtitleItem2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : subtitleItem, (i & 2) != 0 ? null : subtitleItem2);
    }

    public final SubtitleItem getMain() {
        return this.main;
    }

    public final SubtitleItem getVice() {
        return this.vice;
    }
}