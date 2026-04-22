package tv.danmaku.bili.widget.section.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bilibili.lib.widget.R;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;

public class LoadMoreHolder extends BaseViewHolder {
    public static final int LOAD_MORE_STATUS_ERROR = 2;
    public static final int LOAD_MORE_STATUS_GONE = 3;
    public static final int LOAD_MORE_STATUS_LOADING = 0;
    public static final int LOAD_MORE_STATUS_NO_MORE = 1;
    ProgressBar mFooterProgressBar;
    TextView mFooterTextView;

    public LoadMoreHolder(View itemView, BaseAdapter adapter) {
        super(itemView, adapter);
        itemView.setVisibility(8);
        this.mFooterProgressBar = (ProgressBar) itemView.findViewById(R.id.loading);
        this.mFooterTextView = (TextView) itemView.findViewById(R.id.text1);
    }

    public static LoadMoreHolder create(ViewGroup parent, BaseAdapter adapter) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_loading_view, parent, false);
        return new LoadMoreHolder(inflate, adapter);
    }

    public void setupView(int loadMoreStatus) {
        if (getAdapter() != null) {
            if (loadMoreStatus == 1) {
                showFooterNoMore();
            } else if (loadMoreStatus == 0) {
                showFooterLoading();
            } else if (loadMoreStatus == 2) {
                showFooterError();
            } else {
                this.itemView.setVisibility(8);
            }
        }
    }

    public void showFooterLoading() {
        this.itemView.setVisibility(0);
        this.mFooterProgressBar.setVisibility(0);
        this.mFooterTextView.setText(bili.resource.common.R.string.common_global_string_306);
        this.itemView.setClickable(false);
    }

    public void showFooterError() {
        this.itemView.setVisibility(0);
        this.mFooterProgressBar.setVisibility(8);
        this.mFooterTextView.setText(bili.resource.common.R.string.common_global_string_136);
        this.itemView.setClickable(true);
    }

    public void showFooterNoMore() {
        this.itemView.setVisibility(0);
        this.mFooterProgressBar.setVisibility(8);
        this.mFooterTextView.setText(bili.resource.common.R.string.common_global_string_127);
        this.itemView.setClickable(false);
    }
}