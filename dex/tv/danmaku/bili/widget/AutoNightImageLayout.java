package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bilibili.magicasakura.widgets.Tintable;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;

@Deprecated
public class AutoNightImageLayout extends SimpleDraweeView implements Tintable {
    public AutoNightImageLayout(Context context) {
        super(context);
        init();
    }

    public AutoNightImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoNightImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setColorFilter(getResources().getColor(com.bilibili.lib.widget.R.color.auto_night_shade));
    }

    public GenericDraweeView getImageView() {
        return this;
    }

    public void tint() {
        setColorFilter(getResources().getColor(com.bilibili.lib.widget.R.color.auto_night_shade));
    }
}