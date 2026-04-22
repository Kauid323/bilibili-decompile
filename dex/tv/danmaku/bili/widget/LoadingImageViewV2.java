package tv.danmaku.bili.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;

public class LoadingImageViewV2 extends RelativeLayout {
    protected BiliImageView mLoadingImageView;
    protected ProgressBar mLoadingProgressBar;
    protected TextView mLoadingTips;

    public LoadingImageViewV2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingImageViewV2(Context context) {
        super(context);
        initView(context);
    }

    protected void initView(Context context) {
        LayoutInflater.from(context).inflate(com.bilibili.lib.widget.R.layout.bili_widget_layout_loading_view_v2, this);
        this.mLoadingImageView = findViewById(com.bilibili.lib.widget.R.id.image);
        this.mLoadingProgressBar = (ProgressBar) findViewById(com.bilibili.lib.widget.R.id.progress_bar);
        this.mLoadingTips = (TextView) findViewById(com.bilibili.lib.widget.R.id.text);
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

    public void setRefreshError() {
        setRefreshComplete();
        this.mLoadingImageView.setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_error_style2);
        this.mLoadingImageView.setVisibility(0);
        showEmptyTips(com.bilibili.app.comm.baseres.R.string.br_prompt_load_error_try_later);
    }

    public void setRefreshError(String error) {
        setRefreshComplete();
        this.mLoadingImageView.setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_error_style2);
        this.mLoadingImageView.setVisibility(0);
        showEmptyTips(error);
    }

    public void hideRefreshError() {
        setRefreshComplete();
        this.mLoadingImageView.setVisibility(8);
        this.mLoadingTips.setVisibility(8);
    }

    public void setImageResource(int res) {
        this.mLoadingImageView.setImageResource(res);
        this.mLoadingImageView.setVisibility(0);
    }

    public void setImageResource(String imageUrl) {
        if (TextUtils.isEmpty(imageUrl)) {
            return;
        }
        BiliImageLoader.INSTANCE.with(this.mLoadingImageView.getContext()).url(imageUrl).into(this.mLoadingImageView);
        this.mLoadingImageView.setVisibility(0);
    }

    public void setImageResource(String imageUrl, int id) {
        if (TextUtils.isEmpty(imageUrl)) {
            return;
        }
        BiliImageLoader.INSTANCE.with(this.mLoadingImageView.getContext()).url(imageUrl).into(this.mLoadingImageView);
        this.mLoadingImageView.setVisibility(0);
        this.mLoadingTips.setText(id);
        this.mLoadingTips.setVisibility(0);
    }

    public void setImageResource(int imgRes, int id) {
        this.mLoadingImageView.setImageResource(imgRes);
        this.mLoadingImageView.setVisibility(0);
        this.mLoadingTips.setText(id);
        this.mLoadingTips.setVisibility(0);
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

    public void showEmptyTips(String tips) {
        this.mLoadingImageView.setVisibility(0);
        this.mLoadingTips.setText(tips);
        this.mLoadingTips.setVisibility(0);
    }

    public void hideErrorImage() {
        this.mLoadingImageView.setVisibility(8);
    }

    public void hideErrorText() {
        this.mLoadingTips.setVisibility(8);
    }

    public static LoadingImageViewV2 attachTo(FrameLayout root) {
        LoadingImageViewV2 view2 = new LoadingImageViewV2(root.getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 1;
        params.topMargin = (int) TypedValue.applyDimension(1, 30.0f, root.getResources().getDisplayMetrics());
        view2.setLayoutParams(params);
        root.addView(view2);
        return view2;
    }

    public TextView getLoadingTips() {
        return this.mLoadingTips;
    }
}