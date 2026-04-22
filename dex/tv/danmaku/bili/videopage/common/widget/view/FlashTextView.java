package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FlashTextView.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ$\u0010\u001f\u001a\u00020 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020 H\u0014J\b\u0010(\u001a\u00020 H\u0014J\u0010\u0010)\u001a\u00020 2\b\b\u0001\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\rJ\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u001eJ\u000e\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u0019J\u0006\u00101\u001a\u00020 J\u0010\u00102\u001a\u00020 2\u0006\u00100\u001a\u00020\u0019H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/FlashTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SLIDE_SPEED", "", "mPath", "Landroid/graphics/Path;", "mPaint", "Landroid/graphics/Paint;", "mFlashColor", "mFlashWidth", "mSlideDistance", "mShowFlash", "", "mStopped", "mDelayTime", "", "mPostTime", "mDelayFlashRunnable", "Ljava/lang/Runnable;", "mPlayListener", "Ltv/danmaku/bili/videopage/common/widget/view/FlashTextView$OnFlashPlayListener;", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onDetachedFromWindow", "setFlashColor", "color", "setFlashWidth", "size", "setOnFlashPlayListener", "listener", "playFlashDelay", "delayTime", "stopPlayFlash", "sendRenderMsg", "OnFlashPlayListener", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FlashTextView extends AppCompatTextView {
    private final float SLIDE_SPEED;
    private Runnable mDelayFlashRunnable;
    private long mDelayTime;
    private int mFlashColor;
    private float mFlashWidth;
    private Paint mPaint;
    private Path mPath;
    private OnFlashPlayListener mPlayListener;
    private long mPostTime;
    private boolean mShowFlash;
    private float mSlideDistance;
    private boolean mStopped;

    /* compiled from: FlashTextView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/FlashTextView$OnFlashPlayListener;", "", "onStart", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnFlashPlayListener {
        void onStart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlashTextView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlashTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashTextView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.SLIDE_SPEED = DisplayUtils.dp2Px(2);
        init(context, attributeSet, defStyle);
    }

    private final void init(Context context, AttributeSet attributeSet, int defStyle) {
        if (context == null) {
            return;
        }
        this.mPaint = new Paint();
        if (attributeSet != null) {
        }
        this.mPaint = new Paint();
        Paint paint = this.mPaint;
        Paint paint2 = null;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaint");
            paint = null;
        }
        paint.setColor(this.mFlashColor);
        Paint paint3 = this.mPaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaint");
            paint3 = null;
        }
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = this.mPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        } else {
            paint2 = paint4;
        }
        paint2.setAntiAlias(true);
        this.mPath = new Path();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Path path = this.mPath;
        Path path2 = null;
        if (path == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
            path = null;
        }
        path.reset();
        Path path3 = this.mPath;
        if (path3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
            path3 = null;
        }
        path3.moveTo(-this.mFlashWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Path path4 = this.mPath;
        if (path4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
            path4 = null;
        }
        path4.lineTo(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Path path5 = this.mPath;
        if (path5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
            path5 = null;
        }
        path5.lineTo(-this.mFlashWidth, getMeasuredHeight());
        Path path6 = this.mPath;
        if (path6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
        } else {
            path2 = path6;
        }
        path2.lineTo((-this.mFlashWidth) * 2, getMeasuredHeight());
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.mShowFlash) {
            return;
        }
        Path path = null;
        if (this.mSlideDistance < getWidth() + (this.mFlashWidth * 3)) {
            Path path2 = this.mPath;
            if (path2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPath");
                path2 = null;
            }
            Paint paint = this.mPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaint");
                paint = null;
            }
            canvas.drawPath(path2, paint);
            Path path3 = this.mPath;
            if (path3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPath");
            } else {
                path = path3;
            }
            path.offset(this.SLIDE_SPEED, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            this.mSlideDistance += this.SLIDE_SPEED;
            invalidate();
            return;
        }
        Path path4 = this.mPath;
        if (path4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
            path4 = null;
        }
        path4.offset(-this.mSlideDistance, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mDelayFlashRunnable = null;
        this.mSlideDistance = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mShowFlash = false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mStopped) {
            return;
        }
        long time = SystemClock.uptimeMillis() - this.mPostTime;
        if (time > this.mDelayTime) {
            return;
        }
        sendRenderMsg(this.mDelayTime);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mShowFlash = false;
        removeCallbacks(this.mDelayFlashRunnable);
        this.mDelayFlashRunnable = null;
    }

    public final void setFlashColor(int color) {
        this.mFlashColor = color;
        Paint paint = this.mPaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaint");
            paint = null;
        }
        paint.setColor(this.mFlashColor);
    }

    public final void setFlashWidth(float size) {
        this.mFlashWidth = size;
    }

    public final void setOnFlashPlayListener(OnFlashPlayListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPlayListener = listener;
    }

    public final void playFlashDelay(long delayTime) {
        this.mStopped = false;
        this.mDelayTime = delayTime;
        sendRenderMsg(this.mDelayTime);
    }

    public final void stopPlayFlash() {
        removeCallbacks(this.mDelayFlashRunnable);
        this.mDelayFlashRunnable = null;
        this.mShowFlash = false;
        this.mStopped = true;
    }

    private final void sendRenderMsg(long delayTime) {
        removeCallbacks(this.mDelayFlashRunnable);
        this.mDelayFlashRunnable = new Runnable() { // from class: tv.danmaku.bili.videopage.common.widget.view.FlashTextView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlashTextView.sendRenderMsg$lambda$0(FlashTextView.this);
            }
        };
        postDelayed(this.mDelayFlashRunnable, delayTime);
        this.mPostTime = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendRenderMsg$lambda$0(FlashTextView this$0) {
        OnFlashPlayListener onFlashPlayListener = this$0.mPlayListener;
        if (onFlashPlayListener != null) {
            onFlashPlayListener.onStart();
        }
        this$0.mShowFlash = true;
        this$0.invalidate();
    }
}