package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import tv.danmaku.bili.R;

class OfflineHomeLoadingView extends TintLinearLayout {
    protected ImageView mLoadingImageView;
    protected ProgressBar mLoadingProgressBar;
    protected TextView mLoadingTips;

    public OfflineHomeLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public OfflineHomeLoadingView(Context context) {
        super(context);
        initView(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bili_app_view_offline_loading_view, (ViewGroup) this);
        setOrientation(1);
        setGravity(17);
        this.mLoadingProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.mLoadingImageView = (ImageView) findViewById(R.id.image);
        this.mLoadingTips = (TextView) findViewById(R.id.text);
    }

    public void setRefreshing() {
        this.mLoadingImageView.setVisibility(8);
        this.mLoadingProgressBar.setVisibility(0);
        this.mLoadingTips.setVisibility(8);
    }

    public void setRefreshComplete() {
        this.mLoadingImageView.setVisibility(8);
        this.mLoadingProgressBar.setVisibility(8);
        this.mLoadingTips.setVisibility(8);
    }

    public void setImageResource(int res) {
        this.mLoadingImageView.setImageResource(res);
        this.mLoadingImageView.setVisibility(0);
    }

    public void showEmptyTips() {
        this.mLoadingImageView.setVisibility(0);
        this.mLoadingTips.setVisibility(0);
    }

    public void showEmptyTips(int id) {
        this.mLoadingImageView.setVisibility(0);
        this.mLoadingTips.setText(id);
        this.mLoadingTips.setVisibility(0);
    }
}