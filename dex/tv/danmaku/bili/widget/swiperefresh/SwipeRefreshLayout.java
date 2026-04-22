package tv.danmaku.bili.widget.swiperefresh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.widget.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import java.io.File;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class SwipeRefreshLayout extends FrameLayout implements NestedScrollingParent, NestedScrollingChild, Tintable {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 0;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    public static final int EQUIP = 1;
    private static final int INVALID_POINTER = -1;
    static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private boolean isStyleChanged;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    protected CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCurrentStyle;
    int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private boolean mEnableLegacyRequestDisallowInterceptTouch;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    OnRefreshListener mListener;
    private BroadcastReceiver mLoadEquipChangeReceiver;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private Animation.AnimationListener mStopAnimationListener;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;
    private int[] schemeColorResIds;
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] LAYOUT_ATTRS = {16842766};

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface Style {
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mCircleView.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(MAX_ALPHA);
        if (this.mScale) {
            setAnimationProgress(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            reset();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ContextCompat.registerReceiver(getContext().getApplicationContext(), this.mLoadEquipChangeReceiver, new IntentFilter(getContext().getPackageName() + ".garb.LOAD_EQUIP_CHANGE"), 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
        getContext().getApplicationContext().unregisterReceiver(this.mLoadEquipChangeReceiver);
    }

    private void setColorViewAlpha(int targetAlpha) {
        if (this.mCircleView.getBackground() != null) {
            this.mCircleView.getBackground().setAlpha(targetAlpha);
        }
        this.mCircleView.setProgressAlpha(targetAlpha);
    }

    @Deprecated
    public void setProgressViewOffset(boolean scale, int start, int end) {
        setProgressViewOffset(start, end);
    }

    public void setProgressViewOffset(int start, int end) {
        this.mScale = false;
        this.mOriginalOffsetTop = start;
        this.mSpinnerOffsetEnd = end;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public void setProgressViewEndTarget(boolean scale, int end) {
        this.mSpinnerOffsetEnd = end;
        this.mScale = scale;
        this.mCircleView.invalidate();
    }

    public void setSize(int size) {
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mCurrentStyle = 0;
        this.isStyleChanged = true;
        this.mLoadEquipChangeReceiver = new BroadcastReceiver() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                SwipeRefreshLayout.this.isStyleChanged = true;
            }
        };
        this.mRefreshListener = new Animation.AnimationListener() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.mRefreshing) {
                    SwipeRefreshLayout.this.mCircleView.setProgressAlpha(SwipeRefreshLayout.MAX_ALPHA);
                    SwipeRefreshLayout.this.mCircleView.start();
                    if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                        SwipeRefreshLayout.this.mListener.onRefresh();
                    }
                    SwipeRefreshLayout.this.mCurrentTargetOffsetTop = SwipeRefreshLayout.this.mCircleView.getTop();
                    return;
                }
                SwipeRefreshLayout.this.reset();
            }
        };
        this.mStopAnimationListener = new Animation.AnimationListener() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout.this.mCircleView.stop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mEnableLegacyRequestDisallowInterceptTouch = true;
        this.mAnimateToCorrectPosition = new Animation() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                int endTarget;
                if (!SwipeRefreshLayout.this.mUsingCustomStart) {
                    endTarget = SwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop);
                } else {
                    endTarget = SwipeRefreshLayout.this.mSpinnerOffsetEnd;
                }
                int targetTop = SwipeRefreshLayout.this.mFrom + ((int) ((endTarget - SwipeRefreshLayout.this.mFrom) * interpolatedTime));
                int offset = targetTop - SwipeRefreshLayout.this.mCircleView.getTop();
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(offset);
                SwipeRefreshLayout.this.mCircleView.onAnimateToCorrectPosition(interpolatedTime);
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.9
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                SwipeRefreshLayout.this.moveToStart(interpolatedTime);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mSpinnerOffsetEnd = (int) (metrics.density * 64.0f);
        this.mTotalDragDistance = this.mSpinnerOffsetEnd;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
        setEnabled(a.getBoolean(0, true));
        a.recycle();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EquipSwipeRefreshLayout);
        int style = typedArray.getInt(R.styleable.EquipSwipeRefreshLayout_refreshStyle, 0);
        typedArray.recycle();
        setStyle(style);
        this.mCircleDiameter = (int) (metrics.density * (this.mCircleView.getStyle() == 0 ? 40.0f : 56.0f));
        this.mCurrentTargetOffsetTop = -this.mCircleDiameter;
        moveToStart(1.0f);
    }

    public void setStyle(int style) {
        this.mCurrentStyle = style;
        updateStyle(true);
    }

    private void updateStyle(boolean force) {
        File file;
        if (this.isStyleChanged || force) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            if (this.mCurrentStyle == 0 || (file = GarbManager.getLoadEquipFile()) == null) {
                this.mCircleView.setDefaultStyle();
                this.mCircleDiameter = (int) (metrics.density * 40.0f);
            } else {
                this.mCircleView.setCustomImageStyle(Uri.fromFile(file).toString());
                this.mCircleDiameter = (int) (metrics.density * 56.0f);
            }
            this.mOriginalOffsetTop = -this.mCircleDiameter;
            this.isStyleChanged = false;
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int childCount, int i) {
        if (this.mCircleViewIndex < 0) {
            return i;
        }
        if (i == childCount - 1) {
            return this.mCircleViewIndex;
        }
        if (i >= this.mCircleViewIndex) {
            return i + 1;
        }
        return i;
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext());
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mListener = listener;
    }

    public void setRefreshing(boolean refreshing) {
        int endTarget;
        if (refreshing && this.mRefreshing != refreshing) {
            updateStyle(false);
            this.mRefreshing = refreshing;
            if (!this.mUsingCustomStart) {
                endTarget = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
            } else {
                endTarget = this.mSpinnerOffsetEnd;
            }
            int endTarget2 = this.mCurrentTargetOffsetTop;
            setTargetOffsetTopAndBottom(endTarget - endTarget2);
            this.mNotify = false;
            startScaleUpAnimation(this.mRefreshListener);
            return;
        }
        setRefreshing(refreshing, false);
    }

    private void startScaleUpAnimation(Animation.AnimationListener listener) {
        this.mCircleView.setVisibility(0);
        this.mCircleView.setProgressAlpha(MAX_ALPHA);
        this.mScaleAnimation = new Animation() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                SwipeRefreshLayout.this.setAnimationProgress(interpolatedTime);
            }
        };
        this.mScaleAnimation.setDuration(this.mMediumAnimationDuration);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    void setAnimationProgress(float progress) {
        this.mCircleView.setScaleX(progress);
        this.mCircleView.setScaleY(progress);
    }

    private void setRefreshing(boolean refreshing, boolean notify) {
        if (this.mRefreshing != refreshing) {
            this.mNotify = notify;
            ensureTarget();
            this.mRefreshing = refreshing;
            if (this.mRefreshing) {
                updateStyle(false);
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
                return;
            }
            startScaleDownAnimation(this.mRefreshListener);
        }
    }

    void startScaleDownAnimation(Animation.AnimationListener listener) {
        this.mScaleDownAnimation = new Animation() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.5
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - interpolatedTime);
            }
        };
        this.mScaleDownAnimation.setDuration(150L);
        this.mCircleView.setAnimationListener(listener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mCircleView.getProgressAlpha(), STARTING_PROGRESS_ALPHA);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mCircleView.getProgressAlpha(), MAX_ALPHA);
    }

    private Animation startAlphaAnimation(final int startingAlpha, final int endingAlpha) {
        Animation alpha = new Animation() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                SwipeRefreshLayout.this.mCircleView.setProgressAlpha((int) (startingAlpha + ((endingAlpha - startingAlpha) * interpolatedTime)));
            }
        };
        alpha.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(alpha);
        return alpha;
    }

    @Deprecated
    public void setProgressBackgroundColor(int colorRes) {
        setProgressBackgroundColorSchemeResource(colorRes);
    }

    public void setProgressBackgroundColorSchemeResource(int colorRes) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), colorRes));
    }

    public void setProgressBackgroundColorSchemeColor(int color) {
        this.mCircleView.setBackgroundColor(color);
        this.mCircleView.setBackgroundColor(color);
    }

    @Deprecated
    public void setColorScheme(int... colors) {
        setColorSchemeResources(colors);
    }

    public void setColorSchemeResources(int... colorResIds) {
        this.schemeColorResIds = colorResIds;
        int[] colorRes = new int[colorResIds.length];
        for (int i = 0; i < colorResIds.length; i++) {
            colorRes[i] = ThemeUtils.getColorById(getContext(), colorResIds[i]);
        }
        setColorSchemeColors(colorRes);
    }

    public void setColorSchemeColors(int... colors) {
        ensureTarget();
        this.mCircleView.setColorSchemeColors(colors);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (!child.equals(this.mCircleView)) {
                    this.mTarget = child;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int distance) {
        this.mTotalDragDistance = distance;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget == null) {
            return;
        }
        View child = this.mTarget;
        int childLeft = getPaddingLeft();
        int childTop = getPaddingTop();
        int childWidth = (width - getPaddingLeft()) - getPaddingRight();
        int childHeight = (height - getPaddingTop()) - getPaddingBottom();
        child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
        int circleWidth = this.mCircleView.getMeasuredWidth();
        int circleHeight = this.mCircleView.getMeasuredHeight();
        this.mCircleView.layout((width / 2) - (circleWidth / 2), this.mCurrentTargetOffsetTop, (width / 2) + (circleWidth / 2), this.mCurrentTargetOffsetTop + circleHeight);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget == null) {
            return;
        }
        this.mTarget.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleViewIndex = -1;
        for (int index = 0; index < getChildCount(); index++) {
            if (getChildAt(index) == this.mCircleView) {
                this.mCircleViewIndex = index;
                return;
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public boolean canChildScrollUp() {
        if (this.mChildScrollUpCallback != null) {
            return this.mChildScrollUpCallback.canChildScrollUp(this, this.mTarget);
        }
        if (this.mTarget instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) this.mTarget, -1);
        }
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback callback) {
        this.mChildScrollUpCallback = callback;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            updateStyle(false);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ensureTarget();
        int action = ev.getActionMasked();
        if (this.mReturningToStart && action == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        switch (action) {
            case 0:
                setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
                this.mActivePointerId = ev.getPointerId(0);
                this.mIsBeingDragged = false;
                int pointerIndex = ev.findPointerIndex(this.mActivePointerId);
                if (pointerIndex >= 0) {
                    this.mInitialDownY = ev.getY(pointerIndex);
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId == -1) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                int pointerIndex2 = ev.findPointerIndex(this.mActivePointerId);
                if (pointerIndex2 >= 0) {
                    float y = ev.getY(pointerIndex2);
                    startDragging(y);
                    break;
                } else {
                    return false;
                }
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        return this.mIsBeingDragged;
    }

    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean enabled) {
        this.mEnableLegacyRequestDisallowInterceptTouch = enabled;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean b) {
        if (!this.mEnableLegacyRequestDisallowInterceptTouch || this.mTarget == null || ViewCompat.isNestedScrollingEnabled(this.mTarget)) {
            super.requestDisallowInterceptTouchEvent(b);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        updateStyle(false);
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (nestedScrollAxes & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View child, View target, int axes) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
        startNestedScroll(axes & 2);
        this.mTotalUnconsumed = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        if (dy > 0 && this.mTotalUnconsumed > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            if (dy > this.mTotalUnconsumed) {
                consumed[1] = dy - ((int) this.mTotalUnconsumed);
                this.mTotalUnconsumed = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            } else {
                this.mTotalUnconsumed -= dy;
                consumed[1] = dy;
            }
            moveSpinner(this.mTotalUnconsumed);
        }
        if (this.mUsingCustomStart && dy > 0 && this.mTotalUnconsumed == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && Math.abs(dy - consumed[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] parentConsumed = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(dx - consumed[0], dy - consumed[1], parentConsumed, null)) {
            consumed[0] = consumed[0] + parentConsumed[0];
            consumed[1] = consumed[1] + parentConsumed[1];
        }
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View target) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(target);
        this.mNestedScrollInProgress = false;
        if (this.mTotalUnconsumed > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            finishSpinner(this.mTotalUnconsumed);
            this.mTotalUnconsumed = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, this.mParentOffsetInWindow);
        int dy = this.mParentOffsetInWindow[1] + dyUnconsumed;
        if (dy < 0 && !canChildScrollUp()) {
            this.mTotalUnconsumed += Math.abs(dy);
            moveSpinner(this.mTotalUnconsumed);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean enabled) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(enabled);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int axes) {
        return this.mNestedScrollingChildHelper.startNestedScroll(axes);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void moveSpinner(float overscrollTop) {
        float slingshotDist;
        if (this.mCurrentStyle == 1 && BiliImageLoader.INSTANCE.isPaused()) {
            BiliImageLoader.INSTANCE.resume();
        }
        this.mCircleView.onSpinnerMove();
        float originalDragPercent = overscrollTop / this.mTotalDragDistance;
        float dragPercent = Math.min(1.0f, Math.abs(originalDragPercent));
        float adjustedPercent = (((float) Math.max(dragPercent - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float extraOS = Math.abs(overscrollTop) - this.mTotalDragDistance;
        if (this.mUsingCustomStart) {
            slingshotDist = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
        } else {
            slingshotDist = this.mSpinnerOffsetEnd;
        }
        float tensionSlingshotPercent = Math.max((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Math.min(extraOS, slingshotDist * 2.0f) / slingshotDist);
        float tensionPercent = ((float) ((tensionSlingshotPercent / 4.0f) - Math.pow(tensionSlingshotPercent / 4.0f, 2.0d))) * 2.0f;
        float extraMove = slingshotDist * tensionPercent * 2.0f;
        int targetY = this.mOriginalOffsetTop + ((int) ((slingshotDist * dragPercent) + extraMove));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, overscrollTop / this.mTotalDragDistance));
        }
        if (overscrollTop < this.mTotalDragDistance) {
            if (this.mCircleView.getProgressAlpha() > STARTING_PROGRESS_ALPHA && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mCircleView.getProgressAlpha() < MAX_ALPHA && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mCircleView.onDragPercentChange(adjustedPercent, tensionPercent);
        setTargetOffsetTopAndBottom(targetY - this.mCurrentTargetOffsetTop);
    }

    private void finishSpinner(float overscrollTop) {
        if (overscrollTop > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mCircleView.onRefreshCancel();
        Animation.AnimationListener listener = null;
        if (!this.mScale) {
            listener = new Animation.AnimationListener() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.7
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.mScale) {
                        SwipeRefreshLayout.this.startScaleDownAnimation(SwipeRefreshLayout.this.mStopAnimationListener);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            };
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, listener);
        this.mCircleView.onFinishSpinner();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (this.mReturningToStart && action == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        switch (action) {
            case 0:
                updateStyle(false);
                this.mActivePointerId = ev.getPointerId(0);
                this.mIsBeingDragged = false;
                return true;
            case 1:
                int pointerIndex = ev.findPointerIndex(this.mActivePointerId);
                if (pointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsBeingDragged) {
                    this.mIsBeingDragged = false;
                    finishSpinner((ev.getY(pointerIndex) - this.mInitialMotionY) * 0.5f);
                }
                this.mActivePointerId = -1;
                return false;
            case 2:
                int pointerIndex2 = ev.findPointerIndex(this.mActivePointerId);
                if (pointerIndex2 < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y = ev.getY(pointerIndex2);
                startDragging(y);
                if (this.mIsBeingDragged) {
                    float overscrollTop = (y - this.mInitialMotionY) * 0.5f;
                    if (overscrollTop > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                        moveSpinner(overscrollTop);
                        return true;
                    }
                    return false;
                }
                return true;
            case 3:
                return false;
            case 4:
            default:
                return true;
            case 5:
                int pointerIndex3 = ev.getActionIndex();
                if (pointerIndex3 < 0) {
                    Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.mActivePointerId = ev.getPointerId(pointerIndex3);
                return true;
            case 6:
                onSecondaryPointerUp(ev);
                return true;
        }
    }

    private void startDragging(float y) {
        float yDiff = y - this.mInitialDownY;
        if (yDiff > this.mTouchSlop && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
            this.mIsBeingDragged = true;
            this.mCircleView.setProgressAlpha(STARTING_PROGRESS_ALPHA);
        }
    }

    private void animateOffsetToCorrectPosition(int from, Animation.AnimationListener listener) {
        this.mFrom = from;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int from, Animation.AnimationListener listener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(from, listener);
            return;
        }
        this.mFrom = from;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    void moveToStart(float interpolatedTime) {
        int targetTop = this.mFrom + ((int) ((this.mOriginalOffsetTop - this.mFrom) * interpolatedTime));
        int offset = targetTop - this.mCircleView.getTop();
        setTargetOffsetTopAndBottom(offset);
    }

    private void startScaleDownReturnToStartAnimation(int from, Animation.AnimationListener listener) {
        this.mFrom = from;
        this.mStartingScale = this.mCircleView.getScaleX();
        this.mScaleDownToStartAnimation = new Animation() { // from class: tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout.10
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                float targetScale = SwipeRefreshLayout.this.mStartingScale + ((-SwipeRefreshLayout.this.mStartingScale) * interpolatedTime);
                SwipeRefreshLayout.this.setAnimationProgress(targetScale);
                SwipeRefreshLayout.this.moveToStart(interpolatedTime);
            }
        };
        this.mScaleDownToStartAnimation.setDuration(150L);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    void setTargetOffsetTopAndBottom(int offset) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, offset);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = ev.getActionIndex();
        int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mActivePointerId = ev.getPointerId(newPointerIndex);
        }
    }

    public void tint() {
        if (this.schemeColorResIds == null || this.schemeColorResIds.length == 0) {
            return;
        }
        int[] colors = new int[this.schemeColorResIds.length];
        for (int i = 0; i < this.schemeColorResIds.length; i++) {
            colors[i] = ThemeUtils.getColorById(getContext(), this.schemeColorResIds[i]);
        }
        setColorSchemeColors(colors);
    }
}