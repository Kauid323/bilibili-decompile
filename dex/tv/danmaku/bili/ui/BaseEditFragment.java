package tv.danmaku.bili.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.ui.swiperefresh.BaseSwipeRecyclerViewFragment;
import com.bilibili.lib.widget.R;

@Deprecated
public abstract class BaseEditFragment extends BaseSwipeRecyclerViewFragment {
    protected View footerView;

    public abstract boolean onAttachLoader(FragmentManager fragmentManager);

    public abstract void onClickReloadNextPage();

    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        super.onViewCreated(recyclerView, savedInstanceState);
        this.footerView = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_layout_loading_view, (ViewGroup) getView(), false);
        this.footerView.setVisibility(8);
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(8);
        }
    }

    public void hideFooter() {
        if (this.footerView != null && this.footerView.isShown()) {
            this.footerView.setVisibility(8);
        }
    }

    public void showFooterLoading() {
        if (this.footerView != null) {
            this.footerView.setOnClickListener(null);
            this.footerView.setVisibility(0);
            this.footerView.findViewById(tv.danmaku.bili.R.id.loading).setVisibility(0);
            ((TextView) this.footerView.findViewById(tv.danmaku.bili.R.id.text1)).setText(bili.resource.share.R.string.share_global_string_2);
        }
    }

    public void showFooterNoData() {
        if (this.footerView != null) {
            this.footerView.setOnClickListener(null);
            this.footerView.setVisibility(0);
            this.footerView.findViewById(tv.danmaku.bili.R.id.loading).setVisibility(8);
            ((TextView) this.footerView.findViewById(tv.danmaku.bili.R.id.text1)).setText(bili.resource.common.R.string.common_global_string_92);
        }
    }

    public void showFooterLoadError() {
        if (this.footerView != null) {
            this.footerView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.BaseEditFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    BaseEditFragment.this.onClickReloadNextPage();
                }
            });
            this.footerView.setVisibility(0);
            this.footerView.findViewById(tv.danmaku.bili.R.id.loading).setVisibility(8);
            ((TextView) this.footerView.findViewById(tv.danmaku.bili.R.id.text1)).setText(bili.resource.common.R.string.common_global_string_136);
        }
    }

    public void showLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(8);
        }
        if (getSwipeRefreshLayout() != null) {
            getSwipeRefreshLayout().setRefreshing(true);
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(8);
        }
        if (getSwipeRefreshLayout() != null) {
            getSwipeRefreshLayout().setRefreshing(false);
        }
    }
}