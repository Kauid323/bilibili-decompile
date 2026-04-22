package tv.danmaku.bili.ui.rank.model;

import com.bilibili.routeui.PageInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankUiState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/rank/model/RankUiState;", "", "status", "Ltv/danmaku/bili/ui/rank/model/RankStatus;", "pageList", "", "Lcom/bilibili/routeui/PageInfo;", "<init>", "(Ltv/danmaku/bili/ui/rank/model/RankStatus;Ljava/util/List;)V", "getStatus", "()Ltv/danmaku/bili/ui/rank/model/RankStatus;", "getPageList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankUiState {
    public static final int $stable = 8;
    private final List<PageInfo> pageList;
    private final RankStatus status;

    public RankUiState() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RankUiState copy$default(RankUiState rankUiState, RankStatus rankStatus, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            rankStatus = rankUiState.status;
        }
        if ((i & 2) != 0) {
            list = rankUiState.pageList;
        }
        return rankUiState.copy(rankStatus, list);
    }

    public final RankStatus component1() {
        return this.status;
    }

    public final List<PageInfo> component2() {
        return this.pageList;
    }

    public final RankUiState copy(RankStatus rankStatus, List<PageInfo> list) {
        Intrinsics.checkNotNullParameter(rankStatus, "status");
        Intrinsics.checkNotNullParameter(list, "pageList");
        return new RankUiState(rankStatus, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RankUiState) {
            RankUiState rankUiState = (RankUiState) obj;
            return this.status == rankUiState.status && Intrinsics.areEqual(this.pageList, rankUiState.pageList);
        }
        return false;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.pageList.hashCode();
    }

    public String toString() {
        RankStatus rankStatus = this.status;
        return "RankUiState(status=" + rankStatus + ", pageList=" + this.pageList + ")";
    }

    public RankUiState(RankStatus status, List<PageInfo> list) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(list, "pageList");
        this.status = status;
        this.pageList = list;
    }

    public /* synthetic */ RankUiState(RankStatus rankStatus, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RankStatus.IDLE : rankStatus, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final RankStatus getStatus() {
        return this.status;
    }

    public final List<PageInfo> getPageList() {
        return this.pageList;
    }
}