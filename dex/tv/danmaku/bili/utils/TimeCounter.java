package tv.danmaku.bili.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import bili.resource.account.R;
import java.lang.ref.WeakReference;

public class TimeCounter extends CountDownTimer {
    private long leftSeconds;
    private WeakReference<TextView> mBnt;
    private WeakReference<TimeCounterCallback> mCallback;
    private WeakReference<Context> mContext;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface TimeCounterCallback {
        void onCountDown(TextView textView, long j);

        void onCountDownFinish(TextView textView);
    }

    public TimeCounter(Context context, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.leftSeconds = 0L;
        this.mContext = new WeakReference<>(context);
    }

    public void setCallback(TimeCounterCallback callback) {
        this.mCallback = new WeakReference<>(callback);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.leftSeconds = 0L;
        onFinishShow();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long arg0) {
        this.leftSeconds = arg0 / 1000;
        onTickShow();
    }

    public void cancelWithFinish() {
        cancel();
        onFinish();
    }

    public void attachTv(TextView textView) {
        this.mBnt = new WeakReference<>(textView);
        if (this.leftSeconds != 0) {
            onTickShow();
        }
    }

    private void onFinishShow() {
        Context context = this.mContext != null ? this.mContext.get() : null;
        TextView textView = this.mBnt != null ? this.mBnt.get() : null;
        TimeCounterCallback callback = this.mCallback != null ? this.mCallback.get() : null;
        if (textView != null && callback != null) {
            callback.onCountDownFinish(textView);
        } else if (textView != null && context != null) {
            textView.setClickable(true);
            textView.setText(context.getString(R.string.account_global_string_30));
            textView.setTextColor(context.getResources().getColor(com.bilibili.app.comm.baseres.R.color.daynight_color_theme_pink));
        }
    }

    private void onTickShow() {
        Context context = this.mContext != null ? this.mContext.get() : null;
        TextView textView = this.mBnt != null ? this.mBnt.get() : null;
        TimeCounterCallback callback = this.mCallback != null ? this.mCallback.get() : null;
        if (textView != null && callback != null) {
            callback.onCountDown(textView, this.leftSeconds);
        } else if (textView != null && context != null) {
            textView.setClickable(false);
            textView.setText(context.getResources().getQuantityString(R.plurals.account_global_string_418, (int) this.leftSeconds, String.valueOf(this.leftSeconds)));
            textView.setTextColor(context.getResources().getColor(com.bilibili.lib.theme.R.color.Ga4));
        }
    }
}