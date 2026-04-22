package tv.danmaku.bili.ui.login;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import tv.danmaku.android.log.BLog;

public class TView extends View {
    public TView(Context context) {
        super(context);
    }

    public TView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        super.setBackground(background);
        int color = ((ColorDrawable) background).getColor();
        BLog.d("divider", String.format("setBackground color = %x", Integer.valueOf(color)));
    }
}