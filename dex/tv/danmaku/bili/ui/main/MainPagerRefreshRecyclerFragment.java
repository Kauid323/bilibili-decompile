package tv.danmaku.bili.ui.main;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.LoadingImageView;

public abstract class MainPagerRefreshRecyclerFragment extends MainPagerFragment implements SwipeRefreshLayout.OnRefreshListener {
    private long mLastRefreshStartTime;
    protected LoadingImageView mLoadingView;
    private RecyclerView mRecyclerView;
    Runnable mRefreshAction = new Runnable() { // from class: tv.danmaku.bili.ui.main.MainPagerRefreshRecyclerFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (MainPagerRefreshRecyclerFragment.this.mSwipeRefreshLayout != null) {
                MainPagerRefreshRecyclerFragment.this.mSwipeRefreshLayout.setRefreshing(true);
            }
            MainPagerRefreshRecyclerFragment.this.mLastRefreshStartTime = SystemClock.elapsedRealtime();
        }
    };
    Runnable mRefreshCompletedAction = new Runnable() { // from class: tv.danmaku.bili.ui.main.MainPagerRefreshRecyclerFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (MainPagerRefreshRecyclerFragment.this.mSwipeRefreshLayout != null) {
                MainPagerRefreshRecyclerFragment.this.mSwipeRefreshLayout.setRefreshing(false);
            }
        }
    };
    protected View mRootView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    protected Toolbar toolbar;

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return this.mSwipeRefreshLayout;
    }

    public void onRefresh() {
        this.mLastRefreshStartTime = SystemClock.elapsedRealtime();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bili_app_fragment_main_swiperefresh_recycler, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mLoadingView = view.findViewById(R.id.loading);
        this.mSwipeRefreshLayout = view.findViewById(R.id.swipe_layout);
        this.mSwipeRefreshLayout.setColorSchemeResources(new int[]{com.bilibili.app.comm.baseres.R.color.theme_color_secondary});
        this.mSwipeRefreshLayout.setOnRefreshListener(this);
        this.mRecyclerView = view.findViewById(R.id.recycler);
        this.toolbar = view.findViewById(R.id.nav_top_bar);
        this.mRootView = view.findViewById(R.id.root_container);
        onViewCreated(this.mRecyclerView, savedInstanceState);
    }

    public void onViewCreated(RecyclerView view, Bundle savedInstanceState) {
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.main.MainPagerFragment
    public Toolbar getBar() {
        return this.toolbar;
    }

    public final void setRefreshCompleted() {
        int delta = (int) (SystemClock.elapsedRealtime() - this.mLastRefreshStartTime);
        if (delta >= 0 && delta < 500) {
            this.mSwipeRefreshLayout.postDelayed(this.mRefreshCompletedAction, 500 - delta);
        } else {
            this.mSwipeRefreshLayout.post(this.mRefreshCompletedAction);
        }
    }

    public final void setRefreshStart() {
        this.mSwipeRefreshLayout.post(this.mRefreshAction);
    }

    public void onPause() {
        super.onPause();
        if (this.mSwipeRefreshLayout != null) {
            this.mSwipeRefreshLayout.setRefreshing(false);
            this.mSwipeRefreshLayout.destroyDrawingCache();
            this.mSwipeRefreshLayout.clearAnimation();
        }
    }

    protected void hideSwipeRefreshLayout() {
        if (this.mSwipeRefreshLayout != null) {
            this.mSwipeRefreshLayout.setEnabled(false);
        }
    }

    public final RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public void showLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.setRefreshing();
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setRefreshComplete();
            this.mLoadingView.setVisibility(8);
        }
    }

    public void showErrorTips() {
        if (this.mLoadingView != null) {
            if (!this.mLoadingView.isShown()) {
                this.mLoadingView.setVisibility(0);
            }
            this.mLoadingView.setRefreshError();
        }
    }

    public void hideErrorTips() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(8);
            this.mLoadingView.hideRefreshError();
        }
    }
}