package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoDetailAncestorLayout.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J0\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000eR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VideoDetailAncestorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mVideoDetailRootViewSizeChangedListeners", "Ljava/util/LinkedList;", "Ltv/danmaku/bili/videopage/common/widget/view/VideoDetailRootViewSizeChangedListener;", "mMeasureWidth", "mMeasureHeight", "mShouldCheckRequestLayout", "", "mCheckRequestLayoutRunnable", "Ljava/lang/Runnable;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onLayout", "", "changed", "l", "t", "r", "b", "checkRequestLayout", "view", "Landroid/view/View;", "forceRequestLayout", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "addVideoDetailRootViewSizeChangedListener", "listener", "removeVideoDetailRootViewSizeChangedListener", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class VideoDetailAncestorLayout extends CoordinatorLayout {
    private final Runnable mCheckRequestLayoutRunnable;
    private int mMeasureHeight;
    private int mMeasureWidth;
    private boolean mShouldCheckRequestLayout;
    private final LinkedList<VideoDetailRootViewSizeChangedListener> mVideoDetailRootViewSizeChangedListeners;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCheckRequestLayoutRunnable$lambda$0(VideoDetailAncestorLayout this$0) {
        this$0.mShouldCheckRequestLayout = false;
        boolean isRequested = this$0.checkRequestLayout((View) this$0);
        if (isRequested) {
            this$0.forceRequestLayout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoDetailAncestorLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoDetailAncestorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailAncestorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mVideoDetailRootViewSizeChangedListeners = new LinkedList<>();
        this.mMeasureWidth = -1;
        this.mMeasureHeight = -1;
        this.mCheckRequestLayoutRunnable = new Runnable() { // from class: tv.danmaku.bili.videopage.common.widget.view.VideoDetailAncestorLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VideoDetailAncestorLayout.mCheckRequestLayoutRunnable$lambda$0(VideoDetailAncestorLayout.this);
            }
        };
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        this.mShouldCheckRequestLayout = true;
        WindowInsets dispatchApplyWindowInsets = super.dispatchApplyWindowInsets(insets);
        Intrinsics.checkNotNullExpressionValue(dispatchApplyWindowInsets, "dispatchApplyWindowInsets(...)");
        return dispatchApplyWindowInsets;
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.mShouldCheckRequestLayout) {
            removeCallbacks(this.mCheckRequestLayoutRunnable);
            post(this.mCheckRequestLayoutRunnable);
        }
        super.onLayout(changed, l, t, r, b);
    }

    private final boolean checkRequestLayout(View view2) {
        boolean z;
        boolean isRequested = false;
        boolean z2 = false;
        if (view2 instanceof ViewGroup) {
            int childCount = ((ViewGroup) view2).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = ((ViewGroup) view2).getChildAt(i);
                if (!isRequested) {
                    Intrinsics.checkNotNull(child);
                    if (!checkRequestLayout(child)) {
                        z = false;
                        isRequested = z;
                    }
                }
                z = true;
                isRequested = z;
            }
        }
        boolean isRequested2 = (isRequested || view2.isLayoutRequested()) ? true : true;
        if (isRequested2) {
            view2.forceLayout();
        }
        return isRequested2;
    }

    private final void forceRequestLayout() {
        for (ViewParent view2 = (ViewParent) this; view2 != null; view2 = view2.getParent()) {
            if (view2 instanceof View) {
                ((View) view2).forceLayout();
            } else {
                view2.requestLayout();
            }
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (this.mMeasureHeight != height || this.mMeasureWidth != width) {
            boolean remeasure = false;
            Iterable $this$forEach$iv = this.mVideoDetailRootViewSizeChangedListeners;
            for (Object element$iv : $this$forEach$iv) {
                VideoDetailRootViewSizeChangedListener it = (VideoDetailRootViewSizeChangedListener) element$iv;
                remeasure = it.onChanged(width, height) || remeasure;
            }
            if (remeasure) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
        this.mMeasureWidth = width;
        this.mMeasureHeight = height;
    }

    public final void addVideoDetailRootViewSizeChangedListener(VideoDetailRootViewSizeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoDetailRootViewSizeChangedListeners.add(listener);
    }

    public final void removeVideoDetailRootViewSizeChangedListener(VideoDetailRootViewSizeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoDetailRootViewSizeChangedListeners.remove(listener);
    }
}