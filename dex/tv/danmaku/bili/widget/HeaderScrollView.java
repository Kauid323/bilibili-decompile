package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import tv.danmaku.android.util.DebugLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class HeaderScrollView extends ViewGroup {
    private Callback mCallback;
    private View[] mChildren;
    private boolean mComputingScroll;
    private int mContentTop;
    private View mContentView;
    private int mCurrentContentTop;
    private boolean mDispatchedFakeDownToContentView;
    private float mDispatchedStartY;
    private boolean mDispatchingEventToContentView;
    private ViewDragHelper.Callback mDragCallback;
    private ViewDragHelper mDragHelper;
    private View mHeaderView;
    private boolean mIsDragging;
    private float mMinVel;
    private boolean mReachedTopEdge;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Callback {
        boolean canScrollUp(View view2);
    }

    public HeaderScrollView(Context context) {
        this(context, null);
    }

    public HeaderScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCurrentContentTop = Integer.MIN_VALUE;
        this.mDragCallback = new ViewDragHelper.Callback() { // from class: tv.danmaku.bili.widget.HeaderScrollView.1
            public boolean tryCaptureView(View child, int pointerId) {
                if (child != HeaderScrollView.this.mHeaderView) {
                    return child == HeaderScrollView.this.mContentView;
                }
                HeaderScrollView.this.mDragHelper.captureChildView(HeaderScrollView.this.mContentView, pointerId);
                return false;
            }

            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                if (HeaderScrollView.this.mContentView == changedView) {
                    HeaderScrollView.this.mHeaderView.offsetTopAndBottom(dy);
                    HeaderScrollView.this.mCurrentContentTop = changedView.getTop();
                    ViewCompat.postInvalidateOnAnimation(HeaderScrollView.this);
                }
                if (HeaderScrollView.this.mDispatchingEventToContentView) {
                    HeaderScrollView.this.leaveOffContentView();
                }
                HeaderScrollView.this.mReachedTopEdge = changedView.getTop() == HeaderScrollView.this.getPaddingTop();
            }

            public int getViewVerticalDragRange(View child) {
                return HeaderScrollView.this.mHeaderView.getMeasuredHeight();
            }

            public int clampViewPositionVertical(View child, int top, int dy) {
                if (child == HeaderScrollView.this.mHeaderView) {
                    int contentTop = Math.min(top, HeaderScrollView.this.getPaddingTop());
                    return contentTop;
                }
                int contentTop2 = Math.min(HeaderScrollView.this.mContentTop, Math.max(top, HeaderScrollView.this.getPaddingTop()));
                return contentTop2;
            }

            public void onViewDragStateChanged(int state) {
                HeaderScrollView.this.mIsDragging = state == 1;
            }

            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                int top;
                if (Math.abs(yvel) > HeaderScrollView.this.mMinVel) {
                    if (yvel > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                        top = HeaderScrollView.this.mContentTop;
                    } else {
                        top = HeaderScrollView.this.getPaddingTop();
                    }
                    HeaderScrollView.this.mComputingScroll = HeaderScrollView.this.mDragHelper.smoothSlideViewTo(releasedChild, releasedChild.getLeft(), top);
                }
                HeaderScrollView.this.invalidate();
            }
        };
        initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        this.mDragHelper = ViewDragHelper.create(this, this.mDragCallback);
        this.mMinVel = this.mDragHelper.getMinVelocity() * 5.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int parentLeft = getPaddingLeft();
        int parentRight = (r - l) - getPaddingRight();
        getPaddingTop();
        int top = this.mCurrentContentTop - this.mHeaderView.getMeasuredHeight();
        int bottom = this.mCurrentContentTop;
        this.mHeaderView.layout(parentLeft, top, parentRight, bottom);
        int bottom2 = this.mCurrentContentTop + this.mContentView.getMeasuredHeight();
        this.mContentView.layout(parentLeft, this.mCurrentContentTop, parentRight, bottom2);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View[] viewArr;
        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;
        measureHeader(widthMeasureSpec, heightMeasureSpec);
        measureContent(widthMeasureSpec, heightMeasureSpec);
        for (View child : this.mChildren) {
            maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
            maxHeight += child.getMeasuredHeight();
            childState |= ViewCompat.getMeasuredState(child);
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(maxWidth + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), widthMeasureSpec, childState), ViewCompat.resolveSizeAndState(Math.max(maxHeight + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), heightMeasureSpec, childState << 16));
        int contentTop = getPaddingTop() + this.mHeaderView.getMeasuredHeight();
        if (this.mContentTop != contentTop) {
            int delta = this.mContentTop - contentTop;
            this.mContentTop = contentTop;
            if (this.mCurrentContentTop > Integer.MIN_VALUE) {
                this.mCurrentContentTop = Math.max(getPaddingTop(), this.mCurrentContentTop - delta);
            }
        }
        int delta2 = this.mCurrentContentTop;
        if (delta2 == Integer.MIN_VALUE) {
            this.mCurrentContentTop = this.mContentTop;
        }
    }

    private void measureContent(int widthMeasureSpec, int heightMeasureSpec) {
        ViewGroup.LayoutParams lp = this.mContentView.getLayoutParams();
        this.mContentView.measure(getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width), getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), lp.height));
    }

    private void measureHeader(int widthMeasureSpec, int heightMeasureSpec) {
        this.mHeaderView.measure(getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), -1), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new IllegalArgumentException("HeaderScrollView must have 2 children.");
        }
        this.mHeaderView = getChildAt(0);
        this.mContentView = getChildAt(1);
        this.mChildren = new View[]{this.mHeaderView, this.mContentView};
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mComputingScroll && this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int actionIndex = MotionEventCompat.getActionIndex(ev);
        int pointerId = MotionEventCompat.getPointerId(ev, actionIndex);
        if (pointerId == -1) {
            return false;
        }
        try {
            if (!isEnabled() || canChildScrollUp(findChild(ev))) {
                return false;
            }
            return this.mDragHelper.shouldInterceptTouchEvent(ev);
        } catch (Exception e) {
            return isEnabled() && !canChildScrollUp(findChild(ev));
        }
    }

    private View findChild(MotionEvent ev) {
        View child = findChildUnder((int) ev.getX(), (int) ev.getY());
        return child == null ? this : child;
    }

    public View findChildUnder(int x, int y) {
        View[] viewArr;
        for (View child : this.mChildren) {
            if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }

    private boolean canChildScrollUp(View child) {
        if (child != this.mContentView) {
            return false;
        }
        boolean result = (this.mCallback != null && this.mCallback.canScrollUp(this.mContentView)) || ViewCompat.canScrollVertically(child, -1);
        return result && this.mReachedTopEdge;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            try {
                tryDispatchEventToContentView(event);
                if (!this.mDispatchingEventToContentView) {
                    this.mDragHelper.processTouchEvent(event);
                }
                return true;
            } catch (IllegalArgumentException e) {
                this.mDragHelper.cancel();
                DebugLog.printStackTrace(e);
                return true;
            }
        }
        return false;
    }

    private void tryDispatchEventToContentView(MotionEvent event) {
        MotionEvent fake = MotionEvent.obtain(event);
        int action = MotionEventCompat.getActionMasked(event);
        if (action == 2 && this.mReachedTopEdge && this.mIsDragging) {
            this.mDispatchingEventToContentView = true;
            if (!this.mDispatchedFakeDownToContentView) {
                this.mDispatchedStartY = event.getY();
                fake.setAction(0);
                this.mDispatchedFakeDownToContentView = true;
            }
            this.mContentView.dispatchTouchEvent(fake);
        }
        if (this.mDispatchingEventToContentView) {
            int fakeAction = MotionEventCompat.getActionMasked(fake);
            if (this.mDispatchedStartY < event.getY() || fakeAction == 1) {
                fake.setAction(3);
                this.mContentView.dispatchTouchEvent(fake);
                leaveOffContentView();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void leaveOffContentView() {
        this.mDispatchingEventToContentView = false;
        this.mDispatchedFakeDownToContentView = false;
        this.mDispatchedStartY = Float.MAX_VALUE;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }
}