package tv.danmaku.bili.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;

public class LoadingImageView extends RelativeLayout {
    protected StaticImageView2 mLoadingImageView;
    protected ProgressBar mLoadingProgressBar;
    protected TextView mLoadingTips;

    public LoadingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingImageView(Context context) {
        super(context);
        initView(context);
    }

    protected void initView(Context context) {
        LayoutInflater.from(context).inflate(com.bilibili.lib.widget.R.layout.bili_widget_layout_loading_view, this);
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
        showEmptyTips(bili.resource.common.R.string.common_global_string_400);
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
        BiliImageLoader.INSTANCE.with(getContext()).url(imageUrl).into(this.mLoadingImageView);
        this.mLoadingImageView.setVisibility(0);
    }

    public void setImageResource(String imageUrl, int id) {
        if (TextUtils.isEmpty(imageUrl)) {
            return;
        }
        BiliImageLoader.INSTANCE.with(getContext()).url(imageUrl).into(this.mLoadingImageView);
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

    public void setImageResource(int imgRes, String message) {
        this.mLoadingImageView.setImageResource(imgRes);
        this.mLoadingImageView.setVisibility(0);
        this.mLoadingTips.setText(message);
        this.mLoadingTips.setVisibility(0);
    }

    public void showEmptyTips(String imageUrl, String text, String clickableText, final View.OnClickListener listener) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            BiliImageLoader.INSTANCE.with(getContext()).url(imageUrl).into(this.mLoadingImageView);
            this.mLoadingImageView.setVisibility(0);
        } else {
            this.mLoadingImageView.setVisibility(4);
        }
        String loadingTipsText = "";
        if (text != null && !text.isEmpty()) {
            loadingTipsText = text;
        }
        if (clickableText != null && !clickableText.isEmpty()) {
            int front = loadingTipsText.length();
            String loadingTipsText2 = loadingTipsText + clickableText;
            int rear = loadingTipsText2.length();
            SpannableString atText = new SpannableString(loadingTipsText2);
            atText.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.widget.LoadingImageView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    listener.onClick(widget);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    ds.setColor(LoadingImageView.this.getContext().getResources().getColor(com.bilibili.lib.theme.R.color.Text_link));
                }
            }, front, rear, 33);
            SpannableStringBuilder sbDesc = new SpannableStringBuilder();
            sbDesc.append((CharSequence) atText);
            this.mLoadingTips.setText(sbDesc);
        } else {
            this.mLoadingTips.setText(loadingTipsText);
        }
        this.mLoadingTips.setVisibility(0);
        this.mLoadingTips.setMovementMethod(LinkMovementMethod.getInstance());
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

    public static LoadingImageView attachTo(FrameLayout root) {
        LoadingImageView view2 = new LoadingImageView(root.getContext());
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

    public StaticImageView2 getLoadingImageView() {
        return this.mLoadingImageView;
    }
}