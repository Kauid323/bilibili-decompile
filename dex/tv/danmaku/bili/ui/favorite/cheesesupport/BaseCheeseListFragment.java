package tv.danmaku.bili.ui.favorite.cheesesupport;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.ui.swiperefresh.BaseSwipeRecyclerViewFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.widget.section.adapter.HeaderFooterAdapter;

/* compiled from: BaseCheeseListFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0004J\b\u0010\u001d\u001a\u00020\u0007H$J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\rH&R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/BaseCheeseListFragment;", "Lcom/bilibili/lib/ui/swiperefresh/BaseSwipeRecyclerViewFragment;", "<init>", "()V", "mFooterLoadingView", "Landroid/view/ViewGroup;", "mCheeseAdapter", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter;", "getMCheeseAdapter", "()Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter;", "setMCheeseAdapter", "(Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter;)V", "viewModel", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVM;", "mCheeseListObserver", "Landroidx/lifecycle/Observer;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseList;", "onRefresh", "", "onViewCreated", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "savedInstanceState", "Landroid/os/Bundle;", "setUpRecyclerView", "setupLoadMoreListener", "setAdapterAppendFootView", "adapter", "createAdapter", "emptyPage", "", "data", "showLoading", "hideFooter", "showFooterLoading", "showFooterNoData", "showFooterError", "initViewModel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseCheeseListFragment extends BaseSwipeRecyclerViewFragment {
    public static final int $stable = 8;
    private CheeseListAdapter mCheeseAdapter;
    private Observer<Resource<CheeseList>> mCheeseListObserver = new Observer() { // from class: tv.danmaku.bili.ui.favorite.cheesesupport.BaseCheeseListFragment$$ExternalSyntheticLambda0
        public final void onChanged(Object obj) {
            BaseCheeseListFragment.mCheeseListObserver$lambda$0(BaseCheeseListFragment.this, (Resource) obj);
        }
    };
    private ViewGroup mFooterLoadingView;
    private CheeseListVM viewModel;

    /* compiled from: BaseCheeseListFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected abstract CheeseListAdapter createAdapter();

    public abstract CheeseListVM initViewModel();

    protected final CheeseListAdapter getMCheeseAdapter() {
        return this.mCheeseAdapter;
    }

    protected final void setMCheeseAdapter(CheeseListAdapter cheeseListAdapter) {
        this.mCheeseAdapter = cheeseListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCheeseListObserver$lambda$0(BaseCheeseListFragment this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()]) {
            case 1:
                this$0.hideLoading();
                this$0.setRefreshCompleted();
                CheeseListVM cheeseListVM = this$0.viewModel;
                if ((cheeseListVM != null && cheeseListVM.isFirstPage()) && this$0.emptyPage((CheeseList) resource.getData())) {
                    this$0.showEmptyTips();
                    RecyclerView recyclerView = this$0.getRecyclerView();
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView2 = this$0.getRecyclerView();
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
                CheeseListVM cheeseListVM2 = this$0.viewModel;
                if (cheeseListVM2 != null && cheeseListVM2.isFirstPage()) {
                    RecyclerView recyclerView3 = this$0.getRecyclerView();
                    if (recyclerView3 != null) {
                        recyclerView3.scrollToPosition(0);
                    }
                    CheeseListAdapter cheeseListAdapter = this$0.mCheeseAdapter;
                    if (cheeseListAdapter != null) {
                        CheeseList cheeseList = (CheeseList) resource.getData();
                        cheeseListAdapter.setData(cheeseList != null ? cheeseList.items : null);
                    }
                } else {
                    CheeseListAdapter cheeseListAdapter2 = this$0.mCheeseAdapter;
                    if (cheeseListAdapter2 != null) {
                        CheeseList cheeseList2 = (CheeseList) resource.getData();
                        cheeseListAdapter2.appendData(cheeseList2 != null ? cheeseList2.items : null);
                    }
                }
                CheeseListVM cheeseListVM3 = this$0.viewModel;
                if (cheeseListVM3 == null || cheeseListVM3.hasMoreData()) {
                    z = false;
                }
                if (z) {
                    this$0.showFooterNoData();
                    return;
                }
                return;
            case 2:
                this$0.hideLoading();
                CheeseListVM cheeseListVM4 = this$0.viewModel;
                if (cheeseListVM4 == null || !cheeseListVM4.isFirstPage()) {
                    z = false;
                }
                if (z) {
                    this$0.showLoading();
                    return;
                } else {
                    this$0.showFooterLoading();
                    return;
                }
            case 3:
                this$0.setRefreshCompleted();
                CheeseListVM cheeseListVM5 = this$0.viewModel;
                if (cheeseListVM5 == null || !cheeseListVM5.isFirstPage()) {
                    z = false;
                }
                if (z) {
                    RecyclerView recyclerView4 = this$0.getRecyclerView();
                    if (recyclerView4 != null) {
                        recyclerView4.setVisibility(8);
                    }
                    this$0.showErrorTips();
                    return;
                }
                this$0.showFooterError();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public void onRefresh() {
        super.onRefresh();
        CheeseListVM cheeseListVM = this.viewModel;
        if (cheeseListVM != null) {
            cheeseListVM.resetRequestParam();
        }
        CheeseListVM cheeseListVM2 = this.viewModel;
        if (cheeseListVM2 != null) {
            cheeseListVM2.loadNextPage();
        }
    }

    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        MutableLiveData<Resource<CheeseList>> itemList;
        super.onViewCreated(recyclerView, savedInstanceState);
        this.viewModel = initViewModel();
        CheeseListVM cheeseListVM = this.viewModel;
        if (cheeseListVM != null && (itemList = cheeseListVM.getItemList()) != null) {
            itemList.observe(getViewLifecycleOwner(), this.mCheeseListObserver);
        }
        setUpRecyclerView();
        setupLoadMoreListener();
        hideFooter();
        onRefresh();
    }

    protected void setUpRecyclerView() {
        RecyclerView $this$setUpRecyclerView_u24lambda_u240 = getRecyclerView();
        if ($this$setUpRecyclerView_u24lambda_u240 != null) {
            int dividerColor = R.color.Ga2;
            int dividerHeight = (int) TypedValue.applyDimension(1, 0.5f, $this$setUpRecyclerView_u24lambda_u240.getResources().getDisplayMetrics());
            int dividerLeftSpace = (int) TypedValue.applyDimension(1, 12.0f, $this$setUpRecyclerView_u24lambda_u240.getResources().getDisplayMetrics());
            $this$setUpRecyclerView_u24lambda_u240.addItemDecoration(new CheeseListDividerLine(dividerColor, dividerHeight, dividerLeftSpace, 0));
            $this$setUpRecyclerView_u24lambda_u240.setLayoutManager(new LinearLayoutManager($this$setUpRecyclerView_u24lambda_u240.getContext()));
            setAdapterAppendFootView(createAdapter());
        }
    }

    private final void setupLoadMoreListener() {
        RecyclerView $this$setupLoadMoreListener_u24lambda_u240 = getRecyclerView();
        if ($this$setupLoadMoreListener_u24lambda_u240 != null) {
            $this$setupLoadMoreListener_u24lambda_u240.addOnScrollListener(new LoadMoreScrollListener() { // from class: tv.danmaku.bili.ui.favorite.cheesesupport.BaseCheeseListFragment$setupLoadMoreListener$1$1
                @Override // tv.danmaku.bili.ui.favorite.cheesesupport.LoadMoreScrollListener
                protected void onLastItemVisible() {
                    CheeseListVM cheeseListVM;
                    cheeseListVM = BaseCheeseListFragment.this.viewModel;
                    if (cheeseListVM != null) {
                        cheeseListVM.loadNextPage();
                    }
                }
            });
        }
    }

    protected final void setAdapterAppendFootView(CheeseListAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        RecyclerView $this$setAdapterAppendFootView_u24lambda_u240 = getRecyclerView();
        if ($this$setAdapterAppendFootView_u24lambda_u240 != null) {
            View inflate = LayoutInflater.from($this$setAdapterAppendFootView_u24lambda_u240.getContext()).inflate(com.bilibili.lib.widget.R.layout.bili_app_layout_loading_view, (ViewGroup) getRecyclerView(), false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.mFooterLoadingView = (ViewGroup) inflate;
            RecyclerView.Adapter headerFooterAdapter = new HeaderFooterAdapter((RecyclerView.Adapter) adapter);
            headerFooterAdapter.addFooterView(this.mFooterLoadingView);
            $this$setAdapterAppendFootView_u24lambda_u240.setAdapter(headerFooterAdapter);
            this.mCheeseAdapter = adapter;
        }
    }

    private final boolean emptyPage(CheeseList data) {
        List<CheeseItem> list;
        return (data == null || (list = data.items) == null || !list.isEmpty()) ? false : true;
    }

    public void showLoading() {
        setRefreshStart();
    }

    private final void hideFooter() {
        ViewGroup viewGroup = this.mFooterLoadingView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private final void showFooterLoading() {
        View findViewById;
        ViewGroup viewGroup = this.mFooterLoadingView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(null);
        }
        ViewGroup viewGroup2 = this.mFooterLoadingView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        ViewGroup viewGroup3 = this.mFooterLoadingView;
        if (viewGroup3 != null && (findViewById = viewGroup3.findViewById(tv.danmaku.bili.R.id.loading)) != null) {
            findViewById.setVisibility(0);
        }
        ViewGroup viewGroup4 = this.mFooterLoadingView;
        View findViewById2 = viewGroup4 != null ? viewGroup4.findViewById(com.bilibili.lib.widget.R.id.text1) : null;
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setText(bili.resource.common.R.string.common_global_string_306);
    }

    private final void showFooterNoData() {
        View findViewById;
        ViewGroup viewGroup = this.mFooterLoadingView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(null);
        }
        ViewGroup viewGroup2 = this.mFooterLoadingView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        ViewGroup viewGroup3 = this.mFooterLoadingView;
        if (viewGroup3 != null && (findViewById = viewGroup3.findViewById(tv.danmaku.bili.R.id.loading)) != null) {
            findViewById.setVisibility(8);
        }
        ViewGroup viewGroup4 = this.mFooterLoadingView;
        View findViewById2 = viewGroup4 != null ? viewGroup4.findViewById(com.bilibili.lib.widget.R.id.text1) : null;
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setText(bili.resource.common.R.string.common_global_string_92);
    }

    private final void showFooterError() {
        View findViewById;
        ViewGroup viewGroup = this.mFooterLoadingView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.cheesesupport.BaseCheeseListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseCheeseListFragment.showFooterError$lambda$0(BaseCheeseListFragment.this, view);
                }
            });
        }
        ViewGroup viewGroup2 = this.mFooterLoadingView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        ViewGroup viewGroup3 = this.mFooterLoadingView;
        if (viewGroup3 != null && (findViewById = viewGroup3.findViewById(tv.danmaku.bili.R.id.loading)) != null) {
            findViewById.setVisibility(8);
        }
        ViewGroup viewGroup4 = this.mFooterLoadingView;
        View findViewById2 = viewGroup4 != null ? viewGroup4.findViewById(com.bilibili.lib.widget.R.id.text1) : null;
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setText(bili.resource.common.R.string.common_global_string_118);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFooterError$lambda$0(BaseCheeseListFragment this$0, View it) {
        CheeseListVM cheeseListVM = this$0.viewModel;
        if (cheeseListVM != null) {
            cheeseListVM.loadNextPage();
        }
    }
}