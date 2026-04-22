package tv.danmaku.bili.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class TickerTvLoadingDialog extends Dialog {
    ImageView image;
    TextView messageView;

    public TickerTvLoadingDialog(Context context, CharSequence message, boolean cancelable) {
        super(context);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.requestFeature(1);
        View view2 = LayoutInflater.from(context).inflate(com.bilibili.lib.widget.R.layout.bili_app_layout_ticker_tv_loading_dialog, (ViewGroup) null);
        window.setContentView(view2, new WindowManager.LayoutParams(-2, -2));
        this.image = (ImageView) view2.findViewById(com.bilibili.lib.widget.R.id.icon);
        this.messageView = (TextView) view2.findViewById(com.bilibili.lib.widget.R.id.message);
        this.messageView.setText(message);
        setCancelable(cancelable);
        setCanceledOnTouchOutside(false);
    }

    public static TickerTvLoadingDialog show(Activity context, CharSequence message, boolean cancelable) {
        TickerTvLoadingDialog dialog = new TickerTvLoadingDialog(context, message, cancelable);
        dialog.show();
        return dialog;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Drawable drawable = this.image.getDrawable();
        if (drawable != null && (drawable instanceof AnimationDrawable)) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        Drawable drawable = this.image.getDrawable();
        if (drawable != null && (drawable instanceof AnimationDrawable)) {
            ((AnimationDrawable) drawable).stop();
        }
    }
}