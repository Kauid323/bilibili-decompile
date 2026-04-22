package tv.danmaku.bili.videopage.common.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DescSpecialTagSpan.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004JR\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0016J4\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J<\u0010,\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u000e\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001aJ\u0006\u00101\u001a\u00020\u001cJ\u0010\u00102\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\u000e\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u0006J\u0010\u00107\u001a\u00020\u001c2\b\b\u0001\u00108\u001a\u00020\u0006J\u000e\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0016J\u0010\u0010;\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010\u0016J\u0010\u0010<\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010\u0016J\u001e\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010B\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006J\u0010\u0010C\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010D\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/DescSpecialTagSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/text/style/LineHeightSpan;", "<init>", "()V", "height", "", "maxWidth", "paddingLeft", "paddingRight", "paddingIcon", "marginLeft", "marginRight", "marginTop", "marginBottom", "textSize", "", "textColor", "textString", "", "textStringToDraw", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "leftIconDrawable", "rightIconDrawable", "clickableListener", "Ltv/danmaku/bili/videopage/common/widget/span/DescSpecialTagSpan$ClickableListener;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "chooseHeight", "spanstartv", "lineHeight", "setClickableListener", "listener", "onClick", "setText", "setTextSize", "size", "setMaxWidth", "width", "setTextColor", "color", "setBackgroundDrawable", "drawable", "setDrawableLeft", "setDrawableRight", "setPadding", "left", "right", "icon", "setHeight", "setMargin", "getItemWidth", "getMargin", "ClickableListener", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DescSpecialTagSpan extends ReplacementSpan implements LineHeightSpan {
    private Drawable backgroundDrawable;
    private ClickableListener clickableListener;
    private int height;
    private Drawable leftIconDrawable;
    private int maxWidth;
    private Drawable rightIconDrawable;
    private int textColor;
    private float textSize;
    private String textStringToDraw;
    private int paddingLeft = 10;
    private int paddingRight = 10;
    private int paddingIcon = 10;
    private int marginLeft = 10;
    private int marginRight = 10;
    private int marginTop = 10;
    private int marginBottom = 10;
    private String textString = "";

    /* compiled from: DescSpecialTagSpan.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/DescSpecialTagSpan$ClickableListener;", "", "onClick", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ClickableListener {
        void onClick();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        int contentHeight = ((bottom - top) - this.marginTop) - this.marginBottom;
        Drawable background = this.backgroundDrawable;
        if (background == null) {
            return;
        }
        background.setBounds(0, 0, getItemWidth(paint), contentHeight);
        canvas.translate(x + this.marginLeft, top + this.marginTop);
        background.draw(canvas);
        Drawable drawableLeft = this.leftIconDrawable;
        if (drawableLeft == null) {
            canvas.translate(this.paddingLeft, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        } else {
            int drawableLeftTransY = (contentHeight / 2) - (drawableLeft.getBounds().height() / 2);
            canvas.translate(this.paddingLeft, drawableLeftTransY);
            drawableLeft.draw(canvas);
            canvas.translate(drawableLeft.getBounds().width() + this.paddingIcon, -drawableLeftTransY);
        }
        String textString = this.textStringToDraw;
        if (textString == null) {
            textString = "";
        }
        if (this.textSize > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            paint.setTextSize(this.textSize);
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float distance = ((fontMetrics.bottom - fontMetrics.top) / 2) - fontMetrics.bottom;
        float baseline = background.getBounds().centerY() + distance;
        int paintColor = paint.getColor();
        paint.setColor(this.textColor);
        canvas.drawText(textString, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, baseline, paint);
        paint.setColor(paintColor);
        float textWidth = paint.measureText(textString);
        canvas.translate(textWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Drawable drawableRight = this.rightIconDrawable;
        if (drawableRight != null) {
            int drawableRightTransY = (contentHeight / 2) - (drawableRight.getBounds().height() / 2);
            canvas.translate(this.paddingIcon, drawableRightTransY);
            drawableRight.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return getItemWidth(paint) + getMargin();
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        int height = this.height;
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
        this.clickableListener = listener;
    }

    public final void onClick() {
        ClickableListener clickableListener = this.clickableListener;
        if (clickableListener != null) {
            clickableListener.onClick();
        }
    }

    public final void setText(String text) {
        this.textString = text == null ? "" : text;
        this.textStringToDraw = null;
    }

    public final void setTextSize(int size) {
        this.textSize = size;
    }

    public final void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    public final void setTextColor(int color) {
        this.textColor = color;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.backgroundDrawable = drawable;
    }

    public final void setDrawableLeft(Drawable drawable) {
        this.leftIconDrawable = drawable;
    }

    public final void setDrawableRight(Drawable drawable) {
        this.rightIconDrawable = drawable;
    }

    public final void setPadding(int left, int right, int icon) {
        this.paddingLeft = left;
        this.paddingRight = right;
        this.paddingIcon = icon;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public final void setMargin(int left, int top, int right, int bottom) {
        this.marginLeft = left;
        this.marginTop = top;
        this.marginRight = right;
        this.marginBottom = bottom;
    }

    private final int getItemWidth(Paint paint) {
        int i;
        int i2;
        String subText;
        int left;
        Drawable drawableLeft = this.leftIconDrawable;
        if (drawableLeft != null) {
            i = drawableLeft.getBounds().width() + this.paddingIcon;
        } else {
            i = 0;
        }
        int drawableLeftWidth = i;
        Drawable drawableRight = this.rightIconDrawable;
        if (drawableRight != null) {
            i2 = drawableRight.getBounds().width() + this.paddingIcon;
        } else {
            i2 = 0;
        }
        int drawableRightWidth = i2;
        String textStringToDraw = this.textStringToDraw;
        if (textStringToDraw != null) {
            left = (int) paint.measureText(textStringToDraw);
        } else {
            float[] measures = new float[1];
            int width = (((this.maxWidth - drawableLeftWidth) - drawableRightWidth) - this.paddingLeft) - this.paddingRight;
            int left2 = paint.breakText(this.textString, 0, this.textString.length(), true, width, measures);
            if (left2 < this.textString.length() && left2 > 1) {
                subText = ((Object) this.textString.subSequence(0, (int) Math.min(this.textString.length(), left2 - 1))) + "...";
            } else {
                subText = this.textString;
            }
            this.textStringToDraw = subText;
            left = (int) paint.measureText(subText);
        }
        return left + drawableLeftWidth + drawableRightWidth + this.paddingLeft + this.paddingRight;
    }

    private final int getMargin() {
        return this.marginLeft + this.marginRight;
    }
}