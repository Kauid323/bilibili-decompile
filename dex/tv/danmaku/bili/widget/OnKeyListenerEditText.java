package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.bilibili.magicasakura.widgets.TintEditText;

public class OnKeyListenerEditText extends TintEditText {
    private KeyPreImeListener keyPreImeListener;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface KeyPreImeListener {
        void onKeyPreImeDown(int i, KeyEvent keyEvent);

        void onKeyPreImeUp(int i, KeyEvent keyEvent);
    }

    public OnKeyListenerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (event.getAction() == 0 && this.keyPreImeListener != null) {
                this.keyPreImeListener.onKeyPreImeDown(keyCode, event);
            }
            if (event.getAction() == 1 && this.keyPreImeListener != null) {
                this.keyPreImeListener.onKeyPreImeUp(keyCode, event);
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }

    public void setKeyPreImeListener(KeyPreImeListener listener) {
        this.keyPreImeListener = listener;
    }
}