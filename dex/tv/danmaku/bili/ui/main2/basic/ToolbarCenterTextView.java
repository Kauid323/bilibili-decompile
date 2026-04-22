package tv.danmaku.bili.ui.main2.basic;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;

public class ToolbarCenterTextView extends AppCompatTextView implements Tintable {
    private Context mContext;
    private int mCurrentOrientation;
    private Paint mPaint;
    private int mScreenWidth;

    public ToolbarCenterTextView(Context context) {
        this(context, null);
    }

    public ToolbarCenterTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToolbarCenterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        this.mCurrentOrientation = getResources().getConfiguration().orientation;
        this.mPaint = getPaint();
        this.mPaint.setColor(ThemeUtils.getColorById(this.mContext, R.color.theme_color_primary_tr_title));
    }

    protected void onDraw(Canvas canvas) {
        if (this.mScreenWidth <= 0) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        String text = getText().toString();
        float x = x(text);
        float y = y();
        canvas.drawText(text, x, y, this.mPaint);
        canvas.restore();
    }

    private float x(String text) {
        int width = getMeasuredWidth();
        float textWidth = this.mPaint.measureText(text);
        if (width <= textWidth) {
            return 0.0f;
        }
        float lx = getX();
        float rx = width + lx;
        float cx = (width / 2) + lx;
        float scx = this.mScreenWidth / 2;
        if (Math.abs(lx - scx) > Math.abs(rx - scx)) {
            float xdiff = Math.min(scx - cx, (rx - cx) - (textWidth / 2.0f));
            return ((width / 2) + xdiff) - (textWidth / 2.0f);
        }
        float xdiff2 = cx - scx;
        return ((width / 2) - Math.min(xdiff2, (cx - (textWidth / 2.0f)) - lx)) - (textWidth / 2.0f);
    }

    private float y() {
        int height = getMeasuredHeight();
        return ((height - (this.mPaint.descent() - this.mPaint.ascent())) / 2.0f) - this.mPaint.ascent();
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;
        if (this.mCurrentOrientation != orientation) {
            this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
            this.mCurrentOrientation = orientation;
            invalidate();
        }
    }

    public void tint() {
        this.mPaint.setColor(ThemeUtils.getColorById(this.mContext, R.color.theme_color_primary_tr_title));
        invalidate();
    }

    public void setTextColor(int color) {
        super.setTextColor(color);
        this.mPaint.setColor(color);
        invalidate();
    }
}