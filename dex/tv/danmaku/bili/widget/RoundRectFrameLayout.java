package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class RoundRectFrameLayout extends FrameLayout {
    private Rect mBoundsI;
    private float mRadius;
    private Path mRoundRectPath;

    public RoundRectFrameLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public RoundRectFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RoundRectFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public RoundRectFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.RoundRectFrameLayout, defStyleAttr, 0);
        float radius = a.getDimension(com.bilibili.lib.widget.R.styleable.RoundRectFrameLayout_cornerRadius, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        a.recycle();
        setRadius(radius);
        this.mBoundsI = new Rect();
    }

    private void onSetRadius() {
        boolean needClip = this.mRadius > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        setWillNotDraw(!needClip);
        int i = Build.VERSION.SDK_INT;
        if (needClip) {
            setClipToOutline(true);
            setOutlineProvider(newViewOutlineProvider());
            return;
        }
        setClipToOutline(false);
    }

    public void setRadius(float radius) {
        if (this.mRadius != radius) {
            this.mRadius = radius;
            onSetRadius();
        }
    }

    private ViewOutlineProvider newViewOutlineProvider() {
        return new ViewOutlineProvider() { // from class: tv.danmaku.bili.widget.RoundRectFrameLayout.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), RoundRectFrameLayout.this.mRadius);
            }
        };
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mRoundRectPath = null;
    }
}