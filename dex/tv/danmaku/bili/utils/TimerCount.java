package tv.danmaku.bili.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import bili.resource.account.R;

public class TimerCount extends CountDownTimer {
    private TextView bnt;
    private Context context;

    public TimerCount(Context context, long millisInFuture, long countDownInterval, TextView bnt) {
        super(millisInFuture, countDownInterval);
        this.bnt = bnt;
        this.context = context;
    }

    public TimerCount(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public void cancelWithFinish() {
        cancel();
        onFinish();
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.bnt != null && this.context != null) {
            this.bnt.setClickable(true);
            this.bnt.setText(this.context.getResources().getString(R.string.account_global_string_30));
            this.bnt.setTextColor(this.context.getResources().getColor(com.bilibili.app.comm.baseres.R.color.daynight_color_theme_pink));
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long arg0) {
        if (this.bnt != null && this.context != null) {
            this.bnt.setClickable(false);
            this.bnt.setText(this.context.getString(R.string.account_global_string_141, String.valueOf(arg0 / 1000)));
            this.bnt.setTextColor(this.context.getResources().getColor(com.bilibili.app.comm.baseres.R.color.daynight_color_text_supplementary_light));
        }
    }
}