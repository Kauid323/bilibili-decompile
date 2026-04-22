package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class RoundCardFrameLayout extends TintFrameLayout {
    private TintTextView mCover;
    private int mRoundMargin;

    public RoundCardFrameLayout(Context context) {
        this(context, null);
    }

    public RoundCardFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoundCardFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array;
        ViewCompat.setElevation(this, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mCover = new TintTextView(context);
        int drawableRes = -1;
        int roundMargin = -1;
        if (attrs != null && (array = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.RoundCardFrameLayout)) != null) {
            drawableRes = array.getResourceId(com.bilibili.lib.widget.R.styleable.RoundCardFrameLayout_round_drawable, -1);
            roundMargin = array.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.RoundCardFrameLayout_round_radius, getRoundMargin(context));
            array.recycle();
        }
        this.mCover.setBackgroundResource(drawableRes == -1 ? com.bilibili.app.comm.baseres.R.drawable.ic_card_border : drawableRes);
        this.mRoundMargin = roundMargin;
    }

    public static int getRoundMargin(Context context) {
        return (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.mCover.getParent() == null) {
            addViewInLayout(this.mCover, -1, generateDefaultLayoutParams());
        }
        super.onLayout(changed, left, top, right, bottom);
        this.mCover.layout(0, 0, getWidth(), getHeight());
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        FrameLayout.LayoutParams lp;
        super.addView(child, index, params);
        if (getChildCount() > 2) {
            throw new IllegalStateException("can not has more than one child!!");
        }
        for (int i = 0; i < getChildCount(); i++) {
            TintTextView childAt = getChildAt(i);
            if (childAt != this.mCover && (lp = (FrameLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                lp.setMargins(this.mRoundMargin, this.mRoundMargin, this.mRoundMargin, this.mRoundMargin);
                child.requestLayout();
            }
        }
    }

    public void setRoundDrawableRes(int drawableRes) {
        this.mCover.setBackgroundResource(drawableRes);
    }
}