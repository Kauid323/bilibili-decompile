package tv.danmaku.bili.ui.favorites.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: InterceptRecyclerView.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/favorites/widget/InterceptRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "startX", "", "startY", "inVP", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getViewPager", "Landroid/view/ViewParent;", "view", "Landroid/view/View;", "onAttachedToWindow", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InterceptRecyclerView extends RecyclerView {
    public static final int $stable = 8;
    private boolean inVP;
    private float startX;
    private float startY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.inVP) {
            return super.dispatchTouchEvent(ev);
        }
        switch (ev.getAction()) {
            case 0:
                this.startX = ev.getX();
                this.startY = ev.getY();
                break;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                float endX = ev.getX();
                float endY = ev.getY();
                float disX = Math.abs(endX - this.startX);
                float disY = Math.abs(endY - this.startY);
                BLog.d("recycler", "scroll disX = " + disX + "  scroll disY = " + disY);
                if (disX < disY) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    ViewPager2 viewPager = getViewPager((View) this);
                    ViewPager2 viewPager2 = viewPager instanceof ViewPager2 ? viewPager : null;
                    if (viewPager2 != null) {
                        viewPager2.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private final ViewParent getViewPager(View view) {
        ViewParent viewParent = view.getParent();
        while (viewParent != null && !(viewParent instanceof ViewPager2)) {
            viewParent = viewParent.getParent();
            if (viewParent instanceof ViewPager2) {
                break;
            }
        }
        return viewParent;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.inVP = getViewPager((View) this) != null;
    }
}