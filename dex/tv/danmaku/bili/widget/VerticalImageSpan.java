package tv.danmaku.bili.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class VerticalImageSpan extends ImageSpan {
    float lineExtra;

    public VerticalImageSpan(Context arg0, int arg1) {
        super(arg0, arg1);
    }

    public VerticalImageSpan(Drawable drawable, float lineExtra) {
        super(drawable);
        this.lineExtra = lineExtra;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Drawable d = getDrawable();
        Rect rect = d.getBounds();
        if (fm != null) {
            Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
            int fontHeight = fmPaint.bottom - fmPaint.top;
            int drHeight = rect.bottom - rect.top;
            int top = (drHeight / 2) - (fontHeight / 4);
            int bottom = (drHeight / 2) + (fontHeight / 4);
            fm.ascent = -bottom;
            fm.top = -bottom;
            fm.bottom = top;
            fm.descent = top;
        }
        return rect.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Drawable b = getDrawable();
        if (b instanceof BitmapDrawable) {
            BitmapDrawable bmpD = (BitmapDrawable) b;
            if (bmpD.getBitmap() == null || bmpD.getBitmap().isRecycled()) {
                return;
            }
        }
        canvas.save();
        int transY = Math.round((((top + bottom) - b.getBounds().bottom) - this.lineExtra) / 2.0f);
        canvas.translate(x, transY);
        b.draw(canvas);
        canvas.restore();
    }
}