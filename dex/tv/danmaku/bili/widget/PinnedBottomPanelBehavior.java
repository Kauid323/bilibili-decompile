package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class PinnedBottomPanelBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    View HandleView;
    View childContainer;
    int mActivePointerId;
    private BottomSheetCallback mCallback;
    private final ViewDragHelper.Callback mDragCallback;
    boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastNestedScrollDy;
    int mMaxOffset;
    private float mMaximumVelocity;
    int mMinOffset;
    private boolean mNestedScrolled;
    WeakReference<View> mNestedScrollingChildRef;
    int mParentHeight;
    private int mPeekHeight;
    private boolean mPeekHeightAuto;
    private int mPeekHeightMin;
    private boolean mSkipCollapsed;
    int mState;
    boolean mTouchingScrollingChild;
    private VelocityTracker mVelocityTracker;
    ViewDragHelper mViewDragHelper;
    WeakReference<V> mViewRef;
    View parent;
    Rect tempRect1;
    Rect tempRect2;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view2, float f);

        public abstract void onStateChanged(View view2, int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface CanScrollListener {
        boolean preScroll();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface State {
    }

    public PinnedBottomPanelBehavior() {
        this.mState = 4;
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.mDragCallback = new ViewDragHelper.Callback() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelBehavior.2
            public boolean tryCaptureView(View child, int pointerId) {
                if (PinnedBottomPanelBehavior.this.mState == 1 || PinnedBottomPanelBehavior.this.mTouchingScrollingChild) {
                    return false;
                }
                return ((PinnedBottomPanelBehavior.this.mState == 3 && PinnedBottomPanelBehavior.this.mActivePointerId == pointerId && child != null && child.canScrollVertically(-1)) || PinnedBottomPanelBehavior.this.mViewRef == null || PinnedBottomPanelBehavior.this.mViewRef.get() != child) ? false : true;
            }

            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                PinnedBottomPanelBehavior.this.dispatchOnSlide(top);
            }

            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    PinnedBottomPanelBehavior.this.setStateInternal(1);
                }
            }

            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                int top;
                int targetState;
                if (yvel < DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    top = PinnedBottomPanelBehavior.this.mMinOffset;
                    targetState = 3;
                } else {
                    int top2 = (yvel > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 1 : (yvel == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 0 : -1));
                    if (top2 == 0) {
                        int currentTop = releasedChild.getTop();
                        if (Math.abs(currentTop - PinnedBottomPanelBehavior.this.mMinOffset) < Math.abs(currentTop - PinnedBottomPanelBehavior.this.mMaxOffset)) {
                            int top3 = PinnedBottomPanelBehavior.this.mMinOffset;
                            top = top3;
                            targetState = 3;
                        } else {
                            int top4 = PinnedBottomPanelBehavior.this.mMaxOffset;
                            top = top4;
                            targetState = 4;
                        }
                    } else {
                        top = PinnedBottomPanelBehavior.this.mMaxOffset;
                        targetState = 4;
                    }
                }
                if (PinnedBottomPanelBehavior.this.mViewDragHelper != null && PinnedBottomPanelBehavior.this.mViewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), top)) {
                    PinnedBottomPanelBehavior.this.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new SettleRunnable(releasedChild, targetState));
                    return;
                }
                PinnedBottomPanelBehavior.this.setStateInternal(targetState);
            }

            public int clampViewPositionVertical(View child, int top, int dy) {
                return MathUtils.clamp(top, PinnedBottomPanelBehavior.this.mMinOffset, PinnedBottomPanelBehavior.this.mMaxOffset);
            }

            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return child.getLeft();
            }

            public int getViewVerticalDragRange(View child) {
                if (PinnedBottomPanelBehavior.this.mHideable) {
                    return PinnedBottomPanelBehavior.this.mParentHeight - PinnedBottomPanelBehavior.this.mMinOffset;
                }
                return PinnedBottomPanelBehavior.this.mMaxOffset - PinnedBottomPanelBehavior.this.mMinOffset;
            }
        };
    }

    public PinnedBottomPanelBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mState = 4;
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.mDragCallback = new ViewDragHelper.Callback() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelBehavior.2
            public boolean tryCaptureView(View child, int pointerId) {
                if (PinnedBottomPanelBehavior.this.mState == 1 || PinnedBottomPanelBehavior.this.mTouchingScrollingChild) {
                    return false;
                }
                return ((PinnedBottomPanelBehavior.this.mState == 3 && PinnedBottomPanelBehavior.this.mActivePointerId == pointerId && child != null && child.canScrollVertically(-1)) || PinnedBottomPanelBehavior.this.mViewRef == null || PinnedBottomPanelBehavior.this.mViewRef.get() != child) ? false : true;
            }

            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                PinnedBottomPanelBehavior.this.dispatchOnSlide(top);
            }

            public void onViewDragStateChanged(int state) {
                if (state == 1) {
                    PinnedBottomPanelBehavior.this.setStateInternal(1);
                }
            }

            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                int top;
                int targetState;
                if (yvel < DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    top = PinnedBottomPanelBehavior.this.mMinOffset;
                    targetState = 3;
                } else {
                    int top2 = (yvel > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 1 : (yvel == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? 0 : -1));
                    if (top2 == 0) {
                        int currentTop = releasedChild.getTop();
                        if (Math.abs(currentTop - PinnedBottomPanelBehavior.this.mMinOffset) < Math.abs(currentTop - PinnedBottomPanelBehavior.this.mMaxOffset)) {
                            int top3 = PinnedBottomPanelBehavior.this.mMinOffset;
                            top = top3;
                            targetState = 3;
                        } else {
                            int top4 = PinnedBottomPanelBehavior.this.mMaxOffset;
                            top = top4;
                            targetState = 4;
                        }
                    } else {
                        top = PinnedBottomPanelBehavior.this.mMaxOffset;
                        targetState = 4;
                    }
                }
                if (PinnedBottomPanelBehavior.this.mViewDragHelper != null && PinnedBottomPanelBehavior.this.mViewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), top)) {
                    PinnedBottomPanelBehavior.this.setStateInternal(2);
                    ViewCompat.postOnAnimation(releasedChild, new SettleRunnable(releasedChild, targetState));
                    return;
                }
                PinnedBottomPanelBehavior.this.setStateInternal(targetState);
            }

            public int clampViewPositionVertical(View child, int top, int dy) {
                return MathUtils.clamp(top, PinnedBottomPanelBehavior.this.mMinOffset, PinnedBottomPanelBehavior.this.mMaxOffset);
            }

            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return child.getLeft();
            }

            public int getViewVerticalDragRange(View child) {
                if (PinnedBottomPanelBehavior.this.mHideable) {
                    return PinnedBottomPanelBehavior.this.mParentHeight - PinnedBottomPanelBehavior.this.mMinOffset;
                }
                return PinnedBottomPanelBehavior.this.mMaxOffset - PinnedBottomPanelBehavior.this.mMinOffset;
            }
        };
        TypedArray a = context.obtainStyledAttributes(attrs, com.google.android.material.R.styleable.BottomSheetBehavior_Layout);
        TypedValue value = a.peekValue(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (value == null || value.data != -1) {
            setPeekHeight(a.getDimensionPixelSize(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(value.data);
        }
        setHideable(a.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setSkipCollapsed(a.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        a.recycle();
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout parent, V child) {
        return new SavedState(super.onSaveInstanceState(parent, child), this.mState);
    }

    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(parent, child, ss.getSuperState());
        if (ss.state == 1 || ss.state == 2) {
            this.mState = 4;
        } else {
            this.mState = ss.state;
        }
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        int peekHeight;
        if (ViewCompat.getFitsSystemWindows(parent) && !ViewCompat.getFitsSystemWindows(child)) {
            ViewCompat.setFitsSystemWindows(child, true);
        }
        int savedTop = child.getTop();
        parent.onLayoutChild(child, layoutDirection);
        this.mParentHeight = parent.getHeight();
        if (this.mPeekHeightAuto) {
            if (this.mPeekHeightMin == 0) {
                this.mPeekHeightMin = parent.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_sheet_peek_height_min);
            }
            peekHeight = Math.max(this.mPeekHeightMin, this.mParentHeight - ((parent.getWidth() * 9) / 16));
        } else {
            peekHeight = this.mPeekHeight;
        }
        this.mMinOffset = Math.max(0, this.mParentHeight - child.getHeight());
        this.mMaxOffset = Math.max(this.mParentHeight - peekHeight, this.mMinOffset);
        if (this.mState == 3) {
            ViewCompat.offsetTopAndBottom(child, this.mMinOffset);
        } else if (this.mHideable && this.mState == 5) {
            ViewCompat.offsetTopAndBottom(child, this.mParentHeight);
        } else if (this.mState == 4) {
            ViewCompat.offsetTopAndBottom(child, this.mMaxOffset);
        } else if (this.mState == 1 || this.mState == 2) {
            ViewCompat.offsetTopAndBottom(child, savedTop - child.getTop());
        }
        if (this.mViewDragHelper == null) {
            this.mViewDragHelper = ViewDragHelper.create(parent, this.mDragCallback);
        }
        this.mViewRef = new WeakReference<>(child);
        this.mNestedScrollingChildRef = new WeakReference<>(findContainerChild(child));
        return true;
    }

    public void updateSrcollChild(View view2) {
        this.mNestedScrollingChildRef = new WeakReference<>(view2);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            this.mIgnoreEvents = true;
            return false;
        }
        int action = event.getActionMasked();
        if (action == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        switch (action) {
            case 0:
                int initialX = (int) event.getX();
                this.mInitialY = (int) event.getY();
                if (this.mNestedScrollingChildRef != null && this.mNestedScrollingChildRef.get() != null && parent.isPointInChildBounds(this.mNestedScrollingChildRef.get(), initialX, this.mInitialY)) {
                    this.mActivePointerId = event.getPointerId(event.getActionIndex());
                    this.mTouchingScrollingChild = true;
                }
                this.mIgnoreEvents = this.mActivePointerId == -1 && !parent.isPointInChildBounds(child, initialX, this.mInitialY);
                break;
            case 1:
            case 3:
                this.mTouchingScrollingChild = false;
                this.mActivePointerId = -1;
                if (this.mIgnoreEvents) {
                    this.mIgnoreEvents = false;
                    return false;
                }
                break;
        }
        if (this.mIgnoreEvents || this.mViewDragHelper == null || !this.mViewDragHelper.shouldInterceptTouchEvent(event)) {
            View scroll = null;
            if (this.mNestedScrollingChildRef != null) {
                View scroll2 = this.mNestedScrollingChildRef.get();
                scroll = scroll2;
            }
            return (action != 2 || scroll == null || this.mIgnoreEvents || this.mState == 1 || this.mTouchingScrollingChild || this.mViewDragHelper == null || Math.abs(((float) this.mInitialY) - event.getY()) <= ((float) this.mViewDragHelper.getTouchSlop())) ? false : true;
        }
        return true;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int action = event.getActionMasked();
        if (this.mState == 1 && action == 0) {
            return true;
        }
        if (this.mViewDragHelper != null) {
            this.mViewDragHelper.processTouchEvent(event);
        }
        if (action == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        if (action == 2 && !this.mIgnoreEvents && this.mViewDragHelper != null && Math.abs(this.mInitialY - event.getY()) > this.mViewDragHelper.getTouchSlop()) {
            this.mViewDragHelper.captureChildView(child, event.getPointerId(event.getActionIndex()));
        }
        return !this.mIgnoreEvents;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int nestedScrollAxes) {
        this.mLastNestedScrollDy = 0;
        this.mNestedScrolled = false;
        return (nestedScrollAxes & 2) != 0;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed) {
        if (this.mNestedScrollingChildRef == null) {
            return;
        }
        View scrollingChild = this.mNestedScrollingChildRef.get();
        target.getGlobalVisibleRect(this.tempRect1);
        scrollingChild.getGlobalVisibleRect(this.tempRect2);
        if (!this.tempRect2.contains(this.tempRect1)) {
            return;
        }
        int currentTop = child.getTop();
        int newTop = currentTop - dy;
        if (dy > 0) {
            if (currentTop < this.mMaxOffset && newTop > this.mMinOffset) {
                consumed[1] = dy;
                ViewCompat.offsetTopAndBottom(child, -dy);
                setStateInternal(1);
            }
        } else if (dy < 0 && !target.canScrollVertically(-1)) {
            if (currentTop >= this.mMaxOffset || newTop >= this.mMaxOffset || !this.mHideable) {
                consumed[1] = currentTop - this.mMaxOffset;
                ViewCompat.offsetTopAndBottom(child, -consumed[1]);
                setStateInternal(4);
            } else {
                consumed[1] = dy;
                ViewCompat.offsetTopAndBottom(child, -dy);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(child.getTop());
        this.mLastNestedScrollDy = dy;
        this.mNestedScrolled = true;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target) {
        int top;
        int targetState;
        if (child.getTop() == this.mMinOffset) {
            setStateInternal(3);
        } else if (child.getTop() == this.mMaxOffset) {
            setStateInternal(4);
        } else if (!this.mNestedScrolled) {
        } else {
            if (this.mLastNestedScrollDy > 0) {
                top = this.mMinOffset;
                targetState = 3;
            } else {
                int top2 = this.mLastNestedScrollDy;
                if (top2 == 0) {
                    int currentTop = child.getTop();
                    if (Math.abs(currentTop - this.mMinOffset) < Math.abs(currentTop - this.mMaxOffset)) {
                        int top3 = this.mMinOffset;
                        top = top3;
                        targetState = 3;
                    } else {
                        int top4 = this.mMaxOffset;
                        top = top4;
                        targetState = 4;
                    }
                } else {
                    top = this.mMaxOffset;
                    targetState = 4;
                }
            }
            if (this.mViewDragHelper != null && this.mViewDragHelper.smoothSlideViewTo(child, child.getLeft(), top)) {
                setStateInternal(2);
                ViewCompat.postOnAnimation(child, new SettleRunnable(child, targetState));
            } else {
                setStateInternal(targetState);
            }
            this.mNestedScrolled = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        View scrollingChild;
        if (this.mNestedScrollingChildRef == null || (scrollingChild = this.mNestedScrollingChildRef.get()) == null || target.getTop() >= scrollingChild.getTop()) {
            return false;
        }
        return !(this.mState == 3 || this.mState == 4) || super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    public final void setPeekHeight(int peekHeight) {
        V view2;
        boolean layout = false;
        if (peekHeight == -1) {
            if (!this.mPeekHeightAuto) {
                this.mPeekHeightAuto = true;
                layout = true;
            }
        } else if (this.mPeekHeightAuto || this.mPeekHeight != peekHeight) {
            this.mPeekHeightAuto = false;
            this.mPeekHeight = Math.max(0, peekHeight);
            this.mMaxOffset = this.mParentHeight - peekHeight;
            layout = true;
        }
        if (layout && this.mState == 4 && this.mViewRef != null && (view2 = this.mViewRef.get()) != null) {
            view2.requestLayout();
        }
    }

    public final int getPeekHeight() {
        if (this.mPeekHeightAuto) {
            return -1;
        }
        return this.mPeekHeight;
    }

    public void setHideable(boolean hideable) {
        this.mHideable = hideable;
    }

    public boolean isHideable() {
        return this.mHideable;
    }

    public void setSkipCollapsed(boolean skipCollapsed) {
        this.mSkipCollapsed = skipCollapsed;
    }

    public boolean getSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    public void setBottomSheetCallback(BottomSheetCallback callback) {
        this.mCallback = callback;
    }

    public final void setState(final int state) {
        if (state == this.mState) {
            return;
        }
        if (this.mViewRef == null) {
            if (state == 4 || state == 3 || (this.mHideable && state == 5)) {
                this.mState = state;
                return;
            }
            return;
        }
        final V child = this.mViewRef.get();
        if (child == null) {
            return;
        }
        ViewParent parent = child.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(child)) {
            child.post(new Runnable() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    PinnedBottomPanelBehavior.this.startSettlingAnimation(child, state);
                }
            });
        } else {
            startSettlingAnimation(child, state);
        }
    }

    public final int getState() {
        return this.mState;
    }

    void setStateInternal(int state) {
        if (this.mState == state) {
            return;
        }
        this.mState = state;
        View bottomSheet = this.mViewRef.get();
        if (bottomSheet != null && this.mCallback != null) {
            this.mCallback.onStateChanged(bottomSheet, state);
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    boolean shouldHide(View child, float yvel) {
        if (this.mSkipCollapsed) {
            return true;
        }
        if (child.getTop() < this.mMaxOffset) {
            return false;
        }
        float newTop = child.getTop() + (HIDE_FRICTION * yvel);
        return Math.abs(newTop - ((float) this.mMaxOffset)) / ((float) this.mPeekHeight) > 0.5f;
    }

    View findContainerChild(View view2) {
        if (view2 instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view2;
            int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                View scrollingChild = group.getChildAt(i);
                if ((scrollingChild instanceof ViewGroup) && scrollingChild == this.childContainer) {
                    return scrollingChild;
                }
            }
            return view2;
        }
        return null;
    }

    public void setContainerChild(View scrollChild) {
        this.childContainer = scrollChild;
    }

    private float getYVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(IjkMediaCodecInfo.RANK_MAX, this.mMaximumVelocity);
        return this.mVelocityTracker.getYVelocity(this.mActivePointerId);
    }

    void startSettlingAnimation(View child, int state) {
        int top;
        if (state == 4) {
            top = this.mMaxOffset;
        } else if (state == 3) {
            top = this.mMinOffset;
        } else if (this.mHideable && state == 5) {
            top = this.mParentHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + state);
        }
        if (this.mViewDragHelper != null && this.mViewDragHelper.smoothSlideViewTo(child, child.getLeft(), top)) {
            setStateInternal(2);
            ViewCompat.postOnAnimation(child, new SettleRunnable(child, state));
            return;
        }
        setStateInternal(state);
    }

    void dispatchOnSlide(int top) {
        View bottomSheet = this.mViewRef.get();
        if (bottomSheet != null && this.mCallback != null) {
            if (top > this.mMaxOffset) {
                this.mCallback.onSlide(bottomSheet, (this.mMaxOffset - top) / (this.mParentHeight - this.mMaxOffset));
            } else {
                this.mCallback.onSlide(bottomSheet, (this.mMaxOffset - top) / (this.mMaxOffset - this.mMinOffset));
            }
        }
    }

    int getPeekHeightMin() {
        return this.mPeekHeightMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class SettleRunnable implements Runnable {
        private final int mTargetState;
        private final View mView;

        SettleRunnable(View view2, int targetState) {
            this.mView = view2;
            this.mTargetState = targetState;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PinnedBottomPanelBehavior.this.mViewDragHelper != null && PinnedBottomPanelBehavior.this.mViewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
            } else {
                PinnedBottomPanelBehavior.this.setStateInternal(this.mTargetState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelBehavior.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        final int state;

        public SavedState(Parcel source) {
            this(source, (ClassLoader) null);
        }

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.state = source.readInt();
        }

        public SavedState(Parcelable superState, int state) {
            super(superState);
            this.state = state;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.state);
        }
    }

    public static <V extends View> PinnedBottomPanelBehavior<V> from(V view2) {
        CoordinatorLayout.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if (!(behavior instanceof PinnedBottomPanelBehavior)) {
            throw new IllegalArgumentException("The view is not associated with PublishHalfBehavior");
        }
        return (PinnedBottomPanelBehavior) behavior;
    }
}