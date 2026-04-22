package tv.danmaku.bili.ui.topic;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.section.adapter.HeaderFooterAdapter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicFragments.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\r\u0010\u0010\u001a\u00020\u0005H ¢\u0006\u0002\b\u0011J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/topic/BaseTopicCenterFragment;", "Ltv/danmaku/bili/ui/topic/BaseLoadPageSwipeRecyclerViewFragment;", "<init>", "()V", "adapter", "Ltv/danmaku/bili/ui/topic/TopicListAdapter;", "viewModel", "Ltv/danmaku/bili/ui/topic/TopicViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "createAdapter", "createAdapter$topic_debug", "onViewCreated", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onActivityCreated", "onLoadNextPage", "canLoadNextPage", "", "hasNextPage", "onRefresh", "onDestroy", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class BaseTopicCenterFragment extends BaseLoadPageSwipeRecyclerViewFragment {
    private TopicListAdapter adapter;
    private TopicViewModel viewModel;

    public abstract TopicListAdapter createAdapter$topic_debug();

    public abstract ViewModelProvider.Factory factory(Application application);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = createAdapter$topic_debug();
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (TopicViewModel) ViewModelProviders.of((Fragment) this, factory(application)).get(TopicViewModel.class);
    }

    @Override // tv.danmaku.bili.ui.topic.BaseLoadPageSwipeRecyclerViewFragment
    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onViewCreated(recyclerView, savedInstanceState);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        TopicListAdapter topicListAdapter = this.adapter;
        Intrinsics.checkNotNull(topicListAdapter);
        HeaderFooterAdapter $this$onViewCreated_u24lambda_u240 = new HeaderFooterAdapter(topicListAdapter);
        $this$onViewCreated_u24lambda_u240.addFooterView(getFooterView());
        recyclerView.setAdapter($this$onViewCreated_u24lambda_u240);
        TopicViewModel topicViewModel = this.viewModel;
        if (topicViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            topicViewModel = null;
        }
        topicViewModel.getViewState().observe(getViewLifecycleOwner(), new Observer() { // from class: tv.danmaku.bili.ui.topic.BaseTopicCenterFragment$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                BaseTopicCenterFragment.onViewCreated$lambda$1(BaseTopicCenterFragment.this, (ViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BaseTopicCenterFragment this$0, ViewState it) {
        if (it != null) {
            if (it.isLoading()) {
                if (it.isFirstPage()) {
                    this$0.setRefreshStart();
                    this$0.hideFooter();
                    return;
                }
                this$0.showFooterLoading();
                this$0.hideSwipeRefreshLayout();
            } else if (it.getError() != null) {
                if (it.getError() instanceof NoMoreData) {
                    this$0.showFooterNoData();
                } else if (it.getData().isEmpty()) {
                    this$0.showErrorTips();
                } else {
                    this$0.showFooterLoadError();
                }
                this$0.showSwipeRefreshLayout();
            } else {
                if (it.isFirstPage()) {
                    TopicListAdapter topicListAdapter = this$0.adapter;
                    if (topicListAdapter != null) {
                        topicListAdapter.submitList(null);
                    }
                    this$0.setRefreshCompleted();
                } else {
                    this$0.hideFooter();
                }
                TopicListAdapter topicListAdapter2 = this$0.adapter;
                if (topicListAdapter2 != null) {
                    topicListAdapter2.submitList(it.getData());
                }
                this$0.showSwipeRefreshLayout();
            }
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TopicViewModel topicViewModel = this.viewModel;
        if (topicViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            topicViewModel = null;
        }
        topicViewModel.refresh();
    }

    @Override // tv.danmaku.bili.ui.topic.BaseLoadPageSwipeRecyclerViewFragment
    protected void onLoadNextPage() {
        TopicViewModel topicViewModel = this.viewModel;
        if (topicViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            topicViewModel = null;
        }
        topicViewModel.nextPage();
    }

    @Override // tv.danmaku.bili.ui.topic.BaseLoadPageSwipeRecyclerViewFragment
    protected boolean canLoadNextPage() {
        TopicViewModel topicViewModel = this.viewModel;
        if (topicViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            topicViewModel = null;
        }
        ViewState viewState = (ViewState) topicViewModel.getViewState().getValue();
        return (viewState == null || viewState.isLoading()) ? false : true;
    }

    @Override // tv.danmaku.bili.ui.topic.BaseLoadPageSwipeRecyclerViewFragment
    protected boolean hasNextPage() {
        ViewState viewState;
        TopicViewModel topicViewModel = this.viewModel;
        if (topicViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            topicViewModel = null;
        }
        return !((((ViewState) topicViewModel.getViewState().getValue()) != null ? viewState.getError() : null) instanceof NoMoreData);
    }

    public void onRefresh() {
        super.onRefresh();
        TopicViewModel topicViewModel = this.viewModel;
        if (topicViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            topicViewModel = null;
        }
        topicViewModel.refresh();
    }

    public void onDestroy() {
        super.onDestroy();
        TopicListAdapter topicListAdapter = this.adapter;
        if (topicListAdapter != null) {
            topicListAdapter.submitList(null);
        }
        this.adapter = null;
    }
}