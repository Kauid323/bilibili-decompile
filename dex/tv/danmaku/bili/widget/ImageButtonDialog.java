package tv.danmaku.bili.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;

public class ImageButtonDialog extends BaseDialog<ImageButtonDialog> implements View.OnClickListener {
    private TextView cancelTv;
    private TextView confirmTv;
    private TextView contentTv;
    private StaticImageView2 imageView;
    private Params params;
    private TextView titleTv;

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    protected ImageButtonDialog(Params params) {
        super(params.context);
        this.params = params;
        setCancelable(params.cancelable);
        setCanceledOnTouchOutside(params.cancel);
    }

    @Override // tv.danmaku.bili.widget.BaseDialog
    public View onCreateView() {
        return LayoutInflater.from(this.mContext).inflate(com.bilibili.lib.widget.R.layout.bili_app_diaglog_common_img_two_button, (ViewGroup) null);
    }

    @Override // tv.danmaku.bili.widget.BaseDialog
    public void onViewCreated(View inflate) {
        this.titleTv = (TextView) inflate.findViewById(com.bilibili.lib.widget.R.id.title);
        this.contentTv = (TextView) inflate.findViewById(com.bilibili.lib.widget.R.id.content);
        this.confirmTv = (TextView) inflate.findViewById(com.bilibili.lib.widget.R.id.confirm);
        this.cancelTv = (TextView) inflate.findViewById(com.bilibili.lib.widget.R.id.cancel);
        this.imageView = inflate.findViewById(com.bilibili.lib.widget.R.id.image);
        this.confirmTv.setOnClickListener(this);
        this.cancelTv.setOnClickListener(this);
        this.titleTv.setText(this.params.title);
        if (TextUtils.isEmpty(this.params.content)) {
            this.contentTv.setVisibility(8);
        } else {
            this.contentTv.setText(this.params.content);
            this.contentTv.setVisibility(0);
        }
        this.confirmTv.setText(this.params.confirmText);
        if (!TextUtils.isEmpty(this.params.cancelText)) {
            this.cancelTv.setText(this.params.cancelText);
        }
        if (this.params.imgResId > 0) {
            this.imageView.setImageResource(this.params.imgResId);
        } else if (!TextUtils.isEmpty(this.params.imgUrl)) {
            BiliImageLoader.INSTANCE.with(inflate.getContext()).url(this.params.imgUrl).into(this.imageView);
        }
    }

    @Override // tv.danmaku.bili.widget.BaseDialog
    public void setUiBeforeShow() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == com.bilibili.lib.widget.R.id.cancel) {
            dismiss();
            if (this.params.cancelOnClick != null) {
                this.params.cancelOnClick.onClick(v);
            }
        } else if (id == com.bilibili.lib.widget.R.id.confirm) {
            dismiss();
            if (this.params.confirmOnClick != null) {
                this.params.confirmOnClick.onClick(v);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Builder {
        private Params params;

        public Builder(Context context) {
            this.params = new Params(context);
        }

        public Builder title(String title) {
            this.params.title = title;
            return this;
        }

        public Builder content(String content) {
            this.params.content = content;
            return this;
        }

        public Builder confirmText(String confirmText) {
            this.params.confirmText = confirmText;
            return this;
        }

        public Builder cancelText(String cancelText) {
            this.params.cancelText = cancelText;
            return this;
        }

        public Builder imgUrl(String url) {
            this.params.imgUrl = url;
            return this;
        }

        public Builder imgResId(int id) {
            this.params.imgResId = id;
            return this;
        }

        public Builder confirmOnClickListener(View.OnClickListener onclick) {
            this.params.confirmOnClick = onclick;
            return this;
        }

        public Builder cancelOnClickListener(View.OnClickListener onClickListener) {
            this.params.cancelOnClick = onClickListener;
            return this;
        }

        public Builder cancelable(boolean cancelable) {
            this.params.cancelable = cancelable;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean cancel) {
            this.params.cancel = cancel;
            return this;
        }

        public ImageButtonDialog build() {
            return new ImageButtonDialog(this.params);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class Params {
        private boolean cancel;
        private View.OnClickListener cancelOnClick;
        private String cancelText;
        private boolean cancelable;
        private View.OnClickListener confirmOnClick;
        private String confirmText;
        private String content;
        private Context context;
        private int imgResId;
        private String imgUrl;
        private String title;

        public Params(Context context) {
            this.context = context;
        }
    }
}