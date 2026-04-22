package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

@Deprecated
public class LoadingImageViewWButton extends LoadingImageView {
    Button button;

    public LoadingImageViewWButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingImageViewWButton(Context context) {
        super(context);
    }

    @Override // tv.danmaku.bili.widget.LoadingImageView
    protected void initView(Context context) {
        LayoutInflater.from(context).inflate(com.bilibili.lib.widget.R.layout.bili_widget_layout_loading_view_with_button, this);
        this.mLoadingImageView = findViewById(com.bilibili.lib.widget.R.id.image);
        this.mLoadingProgressBar = (ProgressBar) findViewById(com.bilibili.lib.widget.R.id.progress_bar);
        this.mLoadingTips = (TextView) findViewById(com.bilibili.lib.widget.R.id.text);
        this.button = (Button) findViewById(com.bilibili.lib.widget.R.id.btn);
    }

    public void setButtonBackground(int background) {
        this.button.setBackgroundResource(background);
    }

    public void setButtonText(int strId) {
        this.button.setText(strId);
    }

    public void setButtonVisible(boolean visible) {
        this.button.setVisibility(visible ? 0 : 8);
    }

    public void setButtonClickListener(View.OnClickListener callback) {
        this.button.setOnClickListener(callback);
    }
}