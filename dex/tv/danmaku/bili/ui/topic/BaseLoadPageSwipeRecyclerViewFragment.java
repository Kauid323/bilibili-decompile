package tv.danmaku.bili.ui.topic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.ui.swiperefresh.BaseSwipeRecyclerToolbarFragment;
import com.bilibili.lib.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BaseLoadPageSwipeRecyclerViewFragment.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH$J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\u0016H$J\b\u0010\u0017\u001a\u00020\u0016H$R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/topic/BaseLoadPageSwipeRecyclerViewFragment;", "Lcom/bilibili/lib/ui/swiperefresh/BaseSwipeRecyclerToolbarFragment;", "<init>", "()V", "footerView", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "setFooterView", "(Landroid/view/View;)V", "onLoadNextPage", "", "onViewCreated", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "savedInstanceState", "Landroid/os/Bundle;", "hideFooter", "showFooterLoading", "showFooterNoData", "showFooterLoadError", "canLoadNextPage", "", "hasNextPage", "ScrollListener", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class BaseLoadPageSwipeRecyclerViewFragment extends BaseSwipeRecyclerToolbarFragment {
    private View footerView;

    protected abstract boolean canLoadNextPage();

    protected abstract boolean hasNextPage();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onLoadNextPage();

    /* JADX INFO: Access modifiers changed from: protected */
    public final View getFooterView() {
        return this.footerView;
    }

    protected final void setFooterView(View view2) {
        this.footerView = view2;
    }

    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onViewCreated(recyclerView, savedInstanceState);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = R.layout.bili_app_layout_loading_view;
        View view2 = getView();
        this.footerView = from.inflate(i, view2 instanceof ViewGroup ? (ViewGroup) view2 : null, false);
        recyclerView.addOnScrollListener(new ScrollListener());
    }

    public final void hideFooter() {
        View view2 = this.footerView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void showFooterLoading() {
        View $this$showFooterLoading_u24lambda_u240 = this.footerView;
        if ($this$showFooterLoading_u24lambda_u240 != null) {
            $this$showFooterLoading_u24lambda_u240.setOnClickListener(null);
            $this$showFooterLoading_u24lambda_u240.setVisibility(0);
            $this$showFooterLoading_u24lambda_u240.findViewById(R.id.loading).setVisibility(0);
            View findViewById = $this$showFooterLoading_u24lambda_u240.findViewById(R.id.text1);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(bili.resource.common.R.string.common_global_string_306);
        }
    }

    public final void showFooterNoData() {
        View $this$showFooterNoData_u24lambda_u240 = this.footerView;
        if ($this$showFooterNoData_u24lambda_u240 != null) {
            $this$showFooterNoData_u24lambda_u240.setOnClickListener(null);
            $this$showFooterNoData_u24lambda_u240.setVisibility(0);
            $this$showFooterNoData_u24lambda_u240.findViewById(R.id.loading).setVisibility(8);
            View findViewById = $this$showFooterNoData_u24lambda_u240.findViewById(R.id.text1);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(bili.resource.common.R.string.common_global_string_92);
        }
    }

    public final void showFooterLoadError() {
        View $this$showFooterLoadError_u24lambda_u240 = this.footerView;
        if ($this$showFooterLoadError_u24lambda_u240 != null) {
            $this$showFooterLoadError_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.topic.BaseLoadPageSwipeRecyclerViewFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseLoadPageSwipeRecyclerViewFragment.this.onLoadNextPage();
                }
            });
            $this$showFooterLoadError_u24lambda_u240.setVisibility(0);
            $this$showFooterLoadError_u24lambda_u240.findViewById(R.id.loading).setVisibility(8);
            View findViewById = $this$showFooterLoadError_u24lambda_u240.findViewById(R.id.text1);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(bili.resource.common.R.string.common_global_string_136);
        }
    }

    /* compiled from: BaseLoadPageSwipeRecyclerViewFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/topic/BaseLoadPageSwipeRecyclerViewFragment$ScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Ltv/danmaku/bili/ui/topic/BaseLoadPageSwipeRecyclerViewFragment;)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class ScrollListener extends RecyclerView.OnScrollListener {
        public ScrollListener() {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int childCount = recyclerView.getChildCount();
            if (childCount > 0 && BaseLoadPageSwipeRecyclerViewFragment.this.hasNextPage() && BaseLoadPageSwipeRecyclerViewFragment.this.canLoadNextPage()) {
                View lastChild = recyclerView.getChildAt(childCount - 1);
                RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
                int lastVisible = recyclerView.getChildAdapterPosition(lastChild);
                Intrinsics.checkNotNull(outerAdapter);
                if (lastVisible == outerAdapter.getItemCount() - 1) {
                    BaseLoadPageSwipeRecyclerViewFragment.this.onLoadNextPage();
                }
            }
        }
    }
}