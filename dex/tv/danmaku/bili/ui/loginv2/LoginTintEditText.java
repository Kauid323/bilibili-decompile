package tv.danmaku.bili.ui.loginv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.bilibili.magicasakura.widgets.TintEditText;
import tv.danmaku.android.log.BLog;

public class LoginTintEditText extends TintEditText {
    private static final String TAG = "LoginTintEditText";

    public LoginTintEditText(Context context) {
        super(context);
    }

    public LoginTintEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginTintEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        try {
            return super.onKeyUp(keyCode, event);
        } catch (Exception e) {
            BLog.w(TAG, "onKeyUp Exception = " + e.getMessage());
            return false;
        }
    }
}