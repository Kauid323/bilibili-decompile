package tv.danmaku.bili.ui.loginv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.bilibili.magicasakura.widgets.TintAutoCompleteTextView;
import tv.danmaku.android.log.BLog;

public class LoginTintAutoCompleteTextView extends TintAutoCompleteTextView {
    private static final String TAG = "LoginTintAutoCompleteTe";

    public LoginTintAutoCompleteTextView(Context context) {
        super(context);
    }

    public LoginTintAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginTintAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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