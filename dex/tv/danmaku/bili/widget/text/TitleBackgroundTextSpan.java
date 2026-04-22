package tv.danmaku.bili.widget.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class TitleBackgroundTextSpan extends ReplacementSpan {
    public static final String TAG = TitleBackgroundTextSpan.class.getName();
    private Bitmap mCacheBmp;
    private CornerPathEffect mCornerPathEffect;
    protected LayoutParams mParams;

    public TitleBackgroundTextSpan(LayoutParams params) {
        this.mParams = params;
        this.mCornerPathEffect = new CornerPathEffect(this.mParams.mCorner);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(final Canvas canvas, final CharSequence text, final int start, final int end, final float x, final int top, final int y, final int bottom, final Paint paint) {
        if (this.mParams == null) {
            throw new IllegalStateException("You must set LayoutParams in the constructor");
        }
        doWithCustomTextSizeMeasure(paint, new Runnable() { // from class: tv.danmaku.bili.widget.text.TitleBackgroundTextSpan.1
            @Override // java.lang.Runnable
            public void run() {
                float paintHeight = (paint.descent() - paint.ascent()) + TitleBackgroundTextSpan.this.mParams.mPaddingTop + TitleBackgroundTextSpan.this.mParams.mPaddingBottom;
                float givenHeight = bottom - top;
                float offset = Math.max((givenHeight - paintHeight) / 2.0f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                float redressTop = top + offset;
                float redressBottom = bottom - offset;
                if (TitleBackgroundTextSpan.this.mCacheBmp != null && !TitleBackgroundTextSpan.this.mCacheBmp.isRecycled()) {
                    canvas.drawBitmap(TitleBackgroundTextSpan.this.mCacheBmp, x, redressTop, paint);
                    return;
                }
                float contentHeight = redressBottom - redressTop;
                float relativeY = (y - offset) - TitleBackgroundTextSpan.this.mParams.mTextPaddingBottom;
                RectF rect = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, TitleBackgroundTextSpan.this.measureText(paint, text, start, end), contentHeight);
                TitleBackgroundTextSpan.this.mCacheBmp = Bitmap.createBitmap((int) (rect.right - rect.left), (int) (rect.bottom - rect.top), Bitmap.Config.ARGB_8888);
                Canvas cacheCanvas = new Canvas(TitleBackgroundTextSpan.this.mCacheBmp);
                TitleBackgroundTextSpan.this.drawBackground(cacheCanvas, rect, paint);
                TitleBackgroundTextSpan.this.drawText(cacheCanvas, text, start, end, TitleBackgroundTextSpan.this.mParams.mPaddingLeft, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, relativeY, contentHeight, paint);
                canvas.drawBitmap(TitleBackgroundTextSpan.this.mCacheBmp, x, redressTop, paint);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawBackground(Canvas canvas, RectF rect, Paint paint) {
        Path areaPath = new Path();
        int offset = this.mParams.mBorder / 2;
        areaPath.moveTo(rect.left + offset, rect.top + offset);
        areaPath.lineTo(rect.right - offset, rect.top + offset);
        areaPath.lineTo(rect.right - offset, rect.bottom - offset);
        areaPath.lineTo(rect.left + offset, rect.bottom - offset);
        areaPath.close();
        paint.setColor(this.mParams.mBackgroundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.mParams.mBorder);
        paint.setPathEffect(this.mCornerPathEffect);
        canvas.drawPath(areaPath, paint);
    }

    protected void drawText(Canvas canvas, CharSequence text, int start, int end, float textOffsetX, float top, float textOffsetY, float bottom, Paint paint) {
        paint.setPathEffect(null);
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.mParams.mTextColor);
        canvas.drawText(text, start, end, textOffsetX, textOffsetY, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(final Paint paint, final CharSequence text, final int start, final int end, final Paint.FontMetricsInt fm) {
        if (this.mParams == null) {
            throw new IllegalStateException("You must set LayoutParams in the constructor");
        }
        final int[] size = new int[1];
        doWithCustomTextSizeMeasure(paint, new Runnable() { // from class: tv.danmaku.bili.widget.text.TitleBackgroundTextSpan.2
            @Override // java.lang.Runnable
            public void run() {
                if (fm != null) {
                    Paint.FontMetricsInt fmi = paint.getFontMetricsInt();
                    fm.top = fmi.ascent - TitleBackgroundTextSpan.this.mParams.mPaddingTop;
                    fm.bottom = fmi.descent + TitleBackgroundTextSpan.this.mParams.mPaddingBottom;
                }
                size[0] = (int) TitleBackgroundTextSpan.this.measureText(paint, text, start, end);
            }
        });
        return size[0];
    }

    protected float measureText(Paint paint, CharSequence text, int start, int end) {
        return Math.round(paint.measureText(text, start, end) + this.mParams.mPaddingLeft + this.mParams.mPaddingRight);
    }

    private void doWithCustomTextSizeMeasure(Paint paint, Runnable mainTask) {
        if (this.mParams.mTextSize <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            mainTask.run();
            return;
        }
        float originalTextSize = paint.getTextSize();
        paint.setTextSize(this.mParams.mTextSize);
        mainTask.run();
        paint.setTextSize(originalTextSize);
    }

    public void setLayoutParams(LayoutParams params) {
        this.mParams = params;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class LayoutParams {
        public static final int CORNER_DEFAULT = 8;
        public static final int LINE_WIDTH = 3;
        public int mBackgroundColor;
        public int mBorder;
        public int mCorner;
        public int mPaddingBottom;
        public int mPaddingLeft;
        public int mPaddingRight;
        public int mPaddingTop;
        public int mTextColor;
        public int mTextPaddingBottom;
        public float mTextSize;

        public LayoutParams(int backgroundColor, int textColor) {
            this(backgroundColor, textColor, 8);
        }

        public LayoutParams(int backgroundColor, int textColor, int corner) {
            this.mBorder = 3;
            this.mCorner = 8;
            this.mBackgroundColor = 0;
            this.mTextSize = -1.0f;
            this.mBackgroundColor = backgroundColor;
            this.mTextColor = textColor;
            this.mCorner = corner;
        }

        public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
            this.mPaddingLeft = paddingLeft;
            this.mPaddingTop = paddingTop;
            this.mPaddingRight = paddingRight;
            this.mPaddingBottom = paddingBottom;
        }
    }
}