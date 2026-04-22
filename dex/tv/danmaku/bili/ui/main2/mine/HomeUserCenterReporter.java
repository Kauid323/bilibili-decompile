package tv.danmaku.bili.ui.main2.mine;

import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.scroll.ScrollListenerHelperKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.main2.mine.holder.ReportableHolder;

/* compiled from: HomeUserCenterReporter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0015R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterReporter;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "value", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "notifyDataChanged", "", "notifyPageVisibilityChanged", "visible", "", "onScrolled", "dx", "", "dy", "tryToReport", "()Lkotlin/Unit;", "onCardShown", FavoritesConstsKt.POS, "onBindList", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterReporter extends RecyclerView.OnScrollListener {
    public static final int $stable = 8;
    private RecyclerView recyclerView;

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView value) {
        this.recyclerView = value;
        onBindList();
    }

    public final void notifyDataChanged() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterReporter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HomeUserCenterReporter.this.tryToReport();
                }
            });
        }
    }

    public final void notifyPageVisibilityChanged(boolean visible) {
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        Pair visibleItem = ScrollListenerHelperKt.getVisibleItem(recyclerView);
        int firstPosition = ((Number) visibleItem.component1()).intValue();
        int lastPosition = ((Number) visibleItem.component2()).intValue();
        int pos = firstPosition;
        if (pos > lastPosition) {
            return;
        }
        while (true) {
            onCardShown(pos);
            if (pos == lastPosition) {
                return;
            }
            pos++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit tryToReport() {
        RecyclerView $this$tryToReport_u24lambda_u240 = this.recyclerView;
        if ($this$tryToReport_u24lambda_u240 != null) {
            Pair visibleItem = ScrollListenerHelperKt.getVisibleItem($this$tryToReport_u24lambda_u240);
            int firstPosition = ((Number) visibleItem.component1()).intValue();
            int lastPosition = ((Number) visibleItem.component2()).intValue();
            int pos = firstPosition;
            if (pos <= lastPosition) {
                while (true) {
                    onCardShown(pos);
                    if (pos == lastPosition) {
                        break;
                    }
                    pos++;
                }
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void onCardShown(int pos) {
        Object $this$runAs$iv;
        RecyclerView list = this.recyclerView;
        if (list == null || ($this$runAs$iv = list.findViewHolderForLayoutPosition(pos)) == null) {
            return;
        }
        Object $this$asTo$iv$iv = $this$runAs$iv;
        if (!($this$asTo$iv$iv instanceof ReportableHolder)) {
            $this$asTo$iv$iv = null;
        }
        if ($this$asTo$iv$iv != null) {
            ReportableHolder $this$onCardShown_u24lambda_u240 = (ReportableHolder) $this$asTo$iv$iv;
            $this$onCardShown_u24lambda_u240.onScrollToVisible();
        }
    }

    private final Unit onBindList() {
        RecyclerView $this$onBindList_u24lambda_u240 = this.recyclerView;
        if ($this$onBindList_u24lambda_u240 != null) {
            $this$onBindList_u24lambda_u240.removeOnScrollListener(this);
            $this$onBindList_u24lambda_u240.addOnScrollListener(this);
            return Unit.INSTANCE;
        }
        return null;
    }
}