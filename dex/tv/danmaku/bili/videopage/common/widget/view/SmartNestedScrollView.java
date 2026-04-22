package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewParentCompat;
import com.bilibili.playerbizcommon.view.FixNestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.widget.view.SmartChildContainer;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SmartNestedScrollView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J(\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0014J(\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/SmartNestedScrollView;", "Lcom/bilibili/playerbizcommon/view/FixNestedScrollView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnSizeChangeListener", "Ltv/danmaku/bili/videopage/common/widget/view/SmartNestedScrollView$OnSizeChangeListener;", "mScrollFling", "", "onNestedPreScroll", "", "target", "Landroid/view/View;", "dx", "dy", "consumed", "", "type", "onNestedPreFling", "velocityX", "", "velocityY", "onNestedFling", "fling", "computeScroll", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setOnSizeChangeListener", "listener", "OnSizeChangeListener", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SmartNestedScrollView extends FixNestedScrollView {
    private OnSizeChangeListener mOnSizeChangeListener;
    private boolean mScrollFling;

    /* compiled from: SmartNestedScrollView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/SmartNestedScrollView$OnSizeChangeListener;", "", "onSizeChange", "", "w", "", "h", "oldw", "oldh", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnSizeChangeListener {
        void onSizeChange(int i, int i2, int i3, int i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartNestedScrollView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        super.onNestedPreScroll(target, dx, dy, consumed, type);
        int deltaY = dy - consumed[1];
        if (deltaY <= 0) {
            return;
        }
        int scrollConsumed = deltaY;
        int range = getScrollRange();
        int newScrollY = getScrollY() + deltaY;
        if (newScrollY > range) {
            scrollConsumed = range - getScrollY();
            newScrollY = range;
        }
        onOverScrolled(0, newScrollY, false, false);
        consumed[1] = consumed[1] + scrollConsumed;
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.mScrollFling = false;
        if (!(velocityY == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
            View child = getChildAt(0);
            int nestedScrollAxis = 2;
            if (!(velocityX == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
                nestedScrollAxis = 2 | 1;
            }
            ViewParentCompat.onNestedScrollAccepted((ViewParent) this, child, target, nestedScrollAxis, 1);
        }
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (consumed) {
            this.mScrollFling = false;
        }
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    public void fling(int velocityY) {
        super.fling(velocityY);
        this.mScrollFling = true;
    }

    public void computeScroll() {
        if (this.mScrollFling) {
            super.computeScroll();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup container = (ViewGroup) childAt;
            if (container instanceof SmartChildContainer) {
                int scrollRange = 0;
                int childCount = ((SmartChildContainer) container).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = container.getChildAt(i);
                    ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                    if ((layoutParams instanceof SmartChildContainer.LayoutParams) && ((SmartChildContainer.LayoutParams) layoutParams).getCollapsingEnable()) {
                        scrollRange += child.getMeasuredHeight() + ((SmartChildContainer.LayoutParams) layoutParams).topMargin + ((SmartChildContainer.LayoutParams) layoutParams).bottomMargin;
                    }
                }
                if (scrollRange > 0) {
                    int nwidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Integer.MIN_VALUE);
                    int nheightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + scrollRange, Integer.MIN_VALUE);
                    container.measure(nwidthMeasureSpec, nheightMeasureSpec);
                }
            }
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.mOnSizeChangeListener != null) {
            OnSizeChangeListener onSizeChangeListener = this.mOnSizeChangeListener;
            if (onSizeChangeListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOnSizeChangeListener");
                onSizeChangeListener = null;
            }
            onSizeChangeListener.onSizeChange(w, h, oldw, oldh);
        }
    }

    public final void setOnSizeChangeListener(OnSizeChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnSizeChangeListener = listener;
    }
}