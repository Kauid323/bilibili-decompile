package tv.danmaku.bili.videopage.common.widget.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DescTagSpan.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u00012\u00020\u0002:\u0001WB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0005\u0010\u000eB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u000fJR\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u000204H\u0016J4\u00105\u001a\u00020\b2\u0006\u00103\u001a\u0002042\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u0004H\u0016J<\u00109\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u000e\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020&J\u0006\u0010>\u001a\u00020(J\u0006\u0010?\u001a\u00020(J\u000e\u0010@\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010B\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010 J\u000e\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u0015J\u0010\u0010E\u001a\u00020(2\b\b\u0001\u0010F\u001a\u00020\bJ\u0010\u0010G\u001a\u00020(2\b\b\u0001\u0010F\u001a\u00020\bJ\u000e\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\u001bJ\u000e\u0010J\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020(2\u0006\u0010'\u001a\u00020\u001bJ\u001e\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bJ\u000e\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020\bJ&\u0010S\u001a\u00020(2\u0006\u0010N\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u0010\u0010T\u001a\u00020\b2\u0006\u00103\u001a\u000204H\u0002J\n\u0010U\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010V\u001a\u00020\bH\u0002R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/DescTagSpan;", "Landroid/text/style/ImageSpan;", "Landroid/text/style/LineHeightSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "(Landroid/content/Context;Landroid/graphics/Bitmap;I)V", "mHeight", "mPaddingLeft", "mPaddingRight", "mPaddingIcon", "mTextSize", "", "mMarginLeft", "mMarginRight", "mMarginTop", "mMarginBottom", "mDrawIcon", "", "mHasSelected", "mTextColor", "mTextSelectedColor", "mTextString", "", "mDrawable", "mSelectedDrawable", "mDrawableLeft", "mSelectedDrawableLeft", "mClickableListener", "Ltv/danmaku/bili/videopage/common/widget/span/DescTagSpan$ClickableListener;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getDrawable", "chooseHeight", "spanstartv", "lineHeight", "setClickableListener", "listener", "onClick", "onLongClick", "setDrawableLeft", "setSelectedDrawableLeft", "setText", "setTextSize", "size", "setTextColor", "color", "setSelectedTextColor", "setSelected", "selected", "setDrawable", "setSelectedDrawable", "setDrawIcon", "setPadding", "left", "right", "icon", "setHeight", "height", "setMargin", "getItemWidth", "getDrawableLeft", "getMargin", "ClickableListener", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DescTagSpan extends ImageSpan implements LineHeightSpan {
    private ClickableListener mClickableListener;
    private boolean mDrawIcon;
    private Drawable mDrawable;
    private Drawable mDrawableLeft;
    private boolean mHasSelected;
    private int mHeight;
    private int mMarginBottom;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMarginTop;
    private int mPaddingIcon;
    private int mPaddingLeft;
    private int mPaddingRight;
    private Drawable mSelectedDrawable;
    private Drawable mSelectedDrawableLeft;
    private int mTextColor;
    private int mTextSelectedColor;
    private float mTextSize;
    private String mTextString;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DescTagSpan(Drawable drawable) {
        this(drawable, 0);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescTagSpan(Drawable drawable, int verticalAlignment) {
        super(drawable, verticalAlignment);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mPaddingLeft = 10;
        this.mPaddingRight = 10;
        this.mPaddingIcon = 10;
        this.mMarginLeft = 10;
        this.mMarginRight = 10;
        this.mMarginTop = 10;
        this.mMarginBottom = 10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DescTagSpan(Context context, Bitmap bitmap) {
        this(context, bitmap, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescTagSpan(Context context, Bitmap bitmap, int verticalAlignment) {
        super(context, bitmap, verticalAlignment);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.mPaddingLeft = 10;
        this.mPaddingRight = 10;
        this.mPaddingIcon = 10;
        this.mMarginLeft = 10;
        this.mMarginRight = 10;
        this.mMarginTop = 10;
        this.mMarginBottom = 10;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        int contentHeight = ((bottom - top) - this.mMarginTop) - this.mMarginBottom;
        Drawable drawable = getDrawable();
        drawable.setBounds(0, 0, getItemWidth(paint), contentHeight);
        canvas.translate(x + this.mMarginLeft, top + this.mMarginTop);
        drawable.draw(canvas);
        Drawable drawableLeft = getDrawableLeft();
        if (this.mDrawIcon && drawableLeft != null) {
            int drawableLeftTransY = (contentHeight / 2) - (drawableLeft.getBounds().height() / 2);
            canvas.translate(this.mPaddingLeft, drawableLeftTransY);
            drawableLeft.draw(canvas);
            canvas.translate(drawableLeft.getBounds().width() + this.mPaddingIcon, -drawableLeftTransY);
        } else {
            canvas.translate(this.mPaddingLeft, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        String textString = this.mTextString;
        if (textString == null) {
            textString = "";
        }
        if (this.mTextSize > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            paint.setTextSize(this.mTextSize);
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float distance = ((fontMetrics.bottom - fontMetrics.top) / 2) - fontMetrics.bottom;
        float baseline = drawable.getBounds().centerY() + distance;
        int paintColor = paint.getColor();
        paint.setColor(this.mHasSelected ? this.mTextSelectedColor : this.mTextColor);
        canvas.drawText(textString, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, baseline, paint);
        paint.setColor(paintColor);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return getItemWidth(paint) + getMargin();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = this.mHasSelected ? this.mSelectedDrawable : this.mDrawable;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = super.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
        return drawable2;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        int height = this.mHeight;
        if (height > 0) {
            int h = height / 2;
            if (fm != null) {
                fm.top = -h;
            }
            if (fm != null) {
                fm.ascent = -h;
            }
            if (fm != null) {
                fm.descent = h;
            }
            if (fm != null) {
                fm.bottom = h;
            }
        }
    }

    public final void setClickableListener(ClickableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mClickableListener = listener;
    }

    public final void onClick() {
        ClickableListener clickableListener = this.mClickableListener;
        if (clickableListener != null) {
            clickableListener.onClick();
        }
    }

    public final void onLongClick() {
        ClickableListener clickableListener = this.mClickableListener;
        if (clickableListener != null) {
            clickableListener.onLongClick();
        }
    }

    public final void setDrawableLeft(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mDrawableLeft = drawable;
    }

    public final void setSelectedDrawableLeft(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mSelectedDrawableLeft = drawable;
    }

    public final void setText(String text) {
        this.mTextString = text;
    }

    public final void setTextSize(float size) {
        this.mTextSize = size;
    }

    public final void setTextColor(int color) {
        this.mTextColor = color;
    }

    public final void setSelectedTextColor(int color) {
        this.mTextSelectedColor = color;
    }

    public final void setSelected(boolean selected) {
        this.mHasSelected = selected;
    }

    public final void setDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mDrawable = drawable;
    }

    public final void setSelectedDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mSelectedDrawable = drawable;
    }

    public final void setDrawIcon(boolean draw) {
        this.mDrawIcon = draw;
    }

    public final void setPadding(int left, int right, int icon) {
        this.mPaddingLeft = left;
        this.mPaddingRight = right;
        this.mPaddingIcon = icon;
    }

    public final void setHeight(int height) {
        this.mHeight = height;
    }

    public final void setMargin(int left, int top, int right, int bottom) {
        this.mMarginLeft = left;
        this.mMarginTop = top;
        this.mMarginRight = right;
        this.mMarginBottom = bottom;
    }

    private final int getItemWidth(Paint paint) {
        Rect bounds;
        float textWidth = paint.measureText(this.mTextString);
        if (this.mDrawIcon) {
            Drawable drawableLeft = getDrawableLeft();
            int iconWith = (drawableLeft == null || (bounds = drawableLeft.getBounds()) == null) ? 0 : bounds.width();
            return (int) (iconWith + textWidth + this.mPaddingLeft + this.mPaddingRight + this.mPaddingIcon);
        }
        return (int) (this.mPaddingLeft + textWidth + this.mPaddingRight);
    }

    private final Drawable getDrawableLeft() {
        return this.mHasSelected ? this.mSelectedDrawableLeft : this.mDrawableLeft;
    }

    private final int getMargin() {
        return this.mMarginLeft + this.mMarginRight;
    }

    /* compiled from: DescTagSpan.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/DescTagSpan$ClickableListener;", "", "onClick", "", "onLongClick", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ClickableListener {
        void onClick();

        void onLongClick();

        /* compiled from: DescTagSpan.kt */
        /* renamed from: tv.danmaku.bili.videopage.common.widget.span.DescTagSpan$ClickableListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static void $default$onLongClick(ClickableListener _this) {
            }
        }
    }
}