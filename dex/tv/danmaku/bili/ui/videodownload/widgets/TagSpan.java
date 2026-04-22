package tv.danmaku.bili.ui.videodownload.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.magicasakura.utils.ThemeUtils;

public class TagSpan extends ReplacementSpan {
    private static final float FONT_SCALE = 0.71428573f;
    private static final float HEIGHT_SCALE = 0.9f;
    private int mColorId;
    private Context mContext;
    private int mMarginRight;
    private int mRectRadius;
    private int mWidthPadding;

    public TagSpan(Context context) {
        this(context, 4, 4, R.color.theme_color_secondary);
    }

    public TagSpan(Context context, int colorId) {
        this(context, 4, 8, colorId);
    }

    public TagSpan(Context context, int marginRight, int colorId) {
        this(context, 4, marginRight, colorId);
    }

    public TagSpan(Context context, int widthPadding, int marginRight, int colorId) {
        this.mRectRadius = 6;
        this.mColorId = R.color.theme_color_secondary;
        this.mContext = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mWidthPadding = (int) TypedValue.applyDimension(1, widthPadding, displayMetrics);
        this.mMarginRight = (int) TypedValue.applyDimension(1, marginRight, displayMetrics);
        this.mColorId = colorId;
        this.mRectRadius = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Rect bounds = new Rect();
        paint.getTextBounds(text.toString(), start, end, bounds);
        return ((int) ((bounds.right * FONT_SCALE) + (this.mWidthPadding * 2))) + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Paint.FontMetrics originFontMetrics = paint.getFontMetrics();
        int originColor = paint.getColor();
        int realEnd = getRealEnd(text, end);
        int right = getSize(paint, text, start, end, null) - this.mMarginRight;
        float originSize = paint.getTextSize();
        float topRect = y + originFontMetrics.ascent;
        float bottomRect = y + originFontMetrics.descent;
        float transY = ((bottomRect - topRect) / 2.0f) * 0.100000024f;
        paint.setColor(ThemeUtils.getColorById(this.mContext, this.mColorId));
        RectF rectF = new RectF(x, topRect + transY, right, bottomRect - transY);
        canvas.drawRoundRect(rectF, this.mRectRadius, this.mRectRadius, paint);
        paint.setColor(-1);
        paint.setTextSize(FONT_SCALE * originSize);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float baseY = (((bottomRect - topRect) / 2.0f) - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f)) + topRect;
        float baseX = ((right - x) / 2.0f) - (paint.measureText(text, start, realEnd) / 2.0f);
        canvas.drawText(text, start, realEnd, baseX, baseY, paint);
        paint.setTextSize(originSize);
        paint.setColor(originColor);
    }

    private int getRealEnd(CharSequence text, int oldEnd) {
        int realEnd = oldEnd;
        if (text instanceof Spanned) {
            for (int i = oldEnd - 1; i >= 0; i--) {
                char c = text.charAt(i);
                if (c != ' ' && c != 160) {
                    break;
                }
                realEnd--;
            }
        }
        return realEnd;
    }
}