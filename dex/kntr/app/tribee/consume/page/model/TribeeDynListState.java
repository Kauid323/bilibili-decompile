package kntr.app.tribee.consume.page.model;

import androidx.compose.foundation.lazy.LazyListState;
import com.bapis.bilibili.app.dynamic.v2.KTribeeContent;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortInfo;
import com.bapis.bilibili.pagination.KPaginationReply;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TribeeDynListState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lkntr/app/tribee/consume/page/model/TribeeDynListState;", "", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeContent;", "tribeeSortInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortInfo;", "<init>", "(Landroidx/compose/foundation/lazy/LazyListState;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeContent;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortInfo;)V", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeContent;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortInfo;)V", "getLazyListState", "()Landroidx/compose/foundation/lazy/LazyListState;", "getContent", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeContent;", "getTribeeSortInfo", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortInfo;", "hasMore", "", "nextPage", "Lcom/bapis/bilibili/pagination/KPaginationReply;", "items", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDynListState {
    public static final int $stable = 0;
    private final KTribeeContent content;
    private final LazyListState lazyListState;
    private final KTribeeSortInfo tribeeSortInfo;

    public static /* synthetic */ TribeeDynListState copy$default(TribeeDynListState tribeeDynListState, LazyListState lazyListState, KTribeeContent kTribeeContent, KTribeeSortInfo kTribeeSortInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            lazyListState = tribeeDynListState.lazyListState;
        }
        if ((i & 2) != 0) {
            kTribeeContent = tribeeDynListState.content;
        }
        if ((i & 4) != 0) {
            kTribeeSortInfo = tribeeDynListState.tribeeSortInfo;
        }
        return tribeeDynListState.copy(lazyListState, kTribeeContent, kTribeeSortInfo);
    }

    public final LazyListState component1() {
        return this.lazyListState;
    }

    public final KTribeeContent component2() {
        return this.content;
    }

    public final KTribeeSortInfo component3() {
        return this.tribeeSortInfo;
    }

    public final TribeeDynListState copy(LazyListState lazyListState, KTribeeContent kTribeeContent, KTribeeSortInfo kTribeeSortInfo) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        return new TribeeDynListState(lazyListState, kTribeeContent, kTribeeSortInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeDynListState) {
            TribeeDynListState tribeeDynListState = (TribeeDynListState) obj;
            return Intrinsics.areEqual(this.lazyListState, tribeeDynListState.lazyListState) && Intrinsics.areEqual(this.content, tribeeDynListState.content) && Intrinsics.areEqual(this.tribeeSortInfo, tribeeDynListState.tribeeSortInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((this.lazyListState.hashCode() * 31) + (this.content == null ? 0 : this.content.hashCode())) * 31) + (this.tribeeSortInfo != null ? this.tribeeSortInfo.hashCode() : 0);
    }

    public String toString() {
        LazyListState lazyListState = this.lazyListState;
        KTribeeContent kTribeeContent = this.content;
        return "TribeeDynListState(lazyListState=" + lazyListState + ", content=" + kTribeeContent + ", tribeeSortInfo=" + this.tribeeSortInfo + ")";
    }

    public TribeeDynListState(LazyListState lazyListState, KTribeeContent content, KTribeeSortInfo tribeeSortInfo) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        this.lazyListState = lazyListState;
        this.content = content;
        this.tribeeSortInfo = tribeeSortInfo;
    }

    public final LazyListState getLazyListState() {
        return this.lazyListState;
    }

    public final KTribeeContent getContent() {
        return this.content;
    }

    public final KTribeeSortInfo getTribeeSortInfo() {
        return this.tribeeSortInfo;
    }

    public TribeeDynListState(KTribeeContent content, KTribeeSortInfo tribeeSortInfo) {
        this(new LazyListState(0, 0, 3, (DefaultConstructorMarker) null), content, tribeeSortInfo);
    }

    public final boolean hasMore() {
        KPaginationReply nextPage;
        String next;
        KTribeeContent kTribeeContent = this.content;
        return (kTribeeContent == null || (nextPage = kTribeeContent.getNextPage()) == null || (next = nextPage.getNext()) == null || !(StringsKt.isBlank(next) ^ true)) ? false : true;
    }

    public final KPaginationReply nextPage() {
        KTribeeContent kTribeeContent = this.content;
        if (kTribeeContent != null) {
            return kTribeeContent.getNextPage();
        }
        return null;
    }

    public final List<KTribeeDyn> items() {
        List<KTribeeDyn> dynList;
        KTribeeContent kTribeeContent = this.content;
        return (kTribeeContent == null || (dynList = kTribeeContent.getDynList()) == null) ? CollectionsKt.emptyList() : dynList;
    }
}