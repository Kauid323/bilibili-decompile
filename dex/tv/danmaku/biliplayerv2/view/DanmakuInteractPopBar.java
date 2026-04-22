package tv.danmaku.biliplayerv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuInteractPopBar.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/view/DanmakuInteractPopBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLikedDrawable", "Lcom/airbnb/lottie/LottieDrawable;", "mBubbleMiddleDrawable", "Landroid/graphics/drawable/Drawable;", "mAnchorPointer", "Landroid/graphics/PointF;", "mBubblePaint", "Landroid/graphics/Paint;", "mBubbleRect", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAnchorPointer", "pX", "", "py", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuInteractPopBar extends View {
    private PointF mAnchorPointer;
    private Drawable mBubbleMiddleDrawable;
    private final Paint mBubblePaint;
    private final Rect mBubbleRect;
    private final LottieDrawable mLikedDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanmakuInteractPopBar(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanmakuInteractPopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmakuInteractPopBar(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLikedDrawable = new LottieDrawable();
        this.mAnchorPointer = new PointF();
        this.mBubblePaint = new Paint();
        this.mBubbleRect = new Rect();
        this.mBubbleMiddleDrawable = ContextCompat.getDrawable(context, R.drawable.bili_player_icon_bubble_middle);
        Drawable drawable = this.mBubbleMiddleDrawable;
        if (drawable != null) {
            Drawable drawable2 = this.mBubbleMiddleDrawable;
            int intrinsicWidth = drawable2 != null ? drawable2.getIntrinsicWidth() : 0;
            Drawable drawable3 = this.mBubbleMiddleDrawable;
            drawable.setBounds(0, 0, intrinsicWidth, drawable3 != null ? drawable3.getIntrinsicHeight() : 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mBubblePaint.setColor(-16777216);
        this.mBubblePaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 100.0f, 100.0f, this.mBubblePaint);
        canvas.save();
        canvas.translate(this.mAnchorPointer.x, this.mAnchorPointer.y);
        Drawable drawable = this.mBubbleMiddleDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        this.mBubblePaint.setColor(-65536);
        canvas.drawRect(200.0f, 200.0f, 230.0f, 230.0f, this.mBubblePaint);
        canvas.restore();
    }

    public final void setAnchorPointer(float pX, float py) {
        this.mAnchorPointer.set(pX, py);
        invalidate();
    }
}