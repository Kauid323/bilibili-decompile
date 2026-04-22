package tv.danmaku.bili.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bilibili.animation.RevealAnimator;
import com.bilibili.animation.SupportAnimator;
import com.bilibili.animation.ViewAnimationUtils;

public class RevealFrameLayout extends FrameLayout implements RevealAnimator {
    private float mRadius;
    private RevealAnimator.RevealInfo mRevealInfo;
    private Path mRevealPath;
    private boolean mRunning;
    private final Rect mTargetBounds;

    public RevealFrameLayout(Context context) {
        this(context, null);
    }

    public RevealFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mTargetBounds = new Rect();
        this.mRevealPath = new Path();
    }

    public void onRevealAnimationStart() {
        this.mRunning = true;
    }

    public void onRevealAnimationEnd() {
        this.mRunning = false;
        invalidate(this.mTargetBounds);
    }

    public void onRevealAnimationCancel() {
        onRevealAnimationEnd();
    }

    public void setRevealRadius(float radius) {
        this.mRadius = radius;
        this.mRevealInfo.getTarget().getHitRect(this.mTargetBounds);
        invalidate(this.mTargetBounds);
    }

    public float getRevealRadius() {
        return this.mRadius;
    }

    public void attachRevealInfo(RevealAnimator.RevealInfo info) {
        this.mRevealInfo = info;
    }

    public SupportAnimator startReverseAnimation() {
        if (this.mRevealInfo != null && this.mRevealInfo.hasTarget() && !this.mRunning) {
            return ViewAnimationUtils.createCircularReveal(this.mRevealInfo.getTarget(), this.mRevealInfo.centerX, this.mRevealInfo.centerY, this.mRevealInfo.endRadius, this.mRevealInfo.startRadius);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (this.mRunning && child == this.mRevealInfo.getTarget()) {
            int state = canvas.save();
            this.mRevealPath.reset();
            this.mRevealPath.addCircle(this.mRevealInfo.centerX, this.mRevealInfo.centerY, this.mRadius, Path.Direction.CW);
            canvas.clipPath(this.mRevealPath);
            boolean isInvalided = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(state);
            return isInvalided;
        }
        return super.drawChild(canvas, child, drawingTime);
    }
}