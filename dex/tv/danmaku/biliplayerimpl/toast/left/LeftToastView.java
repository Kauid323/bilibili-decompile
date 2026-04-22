package tv.danmaku.biliplayerimpl.toast.left;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.toast.AbsScaleableToastView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LeftToastView.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0011J&\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/LeftToastView;", "Ltv/danmaku/biliplayerimpl/toast/AbsScaleableToastView;", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/os/Handler;)V", "mRecyclerView", "Ltv/danmaku/biliplayerimpl/toast/left/LeftToastRecyclerView;", "mAdapter", "Ltv/danmaku/biliplayerimpl/toast/left/ToastRecyclerViewAdapter;", "mContextRef", "Ljava/lang/ref/WeakReference;", "addToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "removeToast", "removeAll", "setMargin", "leftMargin", "", "topMargin", "rightMargin", "bottomMargin", "scaleRootView", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LeftToastView extends AbsScaleableToastView {
    private ToastRecyclerViewAdapter mAdapter;
    private WeakReference<Context> mContextRef;
    private LeftToastRecyclerView mRecyclerView;

    public LeftToastView(Context context, ViewGroup rootView, Handler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.mRecyclerView == null) {
            this.mContextRef = new WeakReference<>(context);
            this.mRecyclerView = new LeftToastRecyclerView(context);
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setStackFromEnd(true);
            LeftToastRecyclerView leftToastRecyclerView = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView);
            leftToastRecyclerView.setFocusable(false);
            LeftToastRecyclerView leftToastRecyclerView2 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView2);
            leftToastRecyclerView2.setFocusableInTouchMode(false);
            LeftToastRecyclerView leftToastRecyclerView3 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView3);
            leftToastRecyclerView3.setLayoutManager(linearLayoutManager);
            LeftToastRecyclerView leftToastRecyclerView4 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView4);
            leftToastRecyclerView4.setItemAnimator((RecyclerView.ItemAnimator) new ToastItemAnimator());
            LeftToastRecyclerView leftToastRecyclerView5 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView5);
            leftToastRecyclerView5.setOverScrollMode(2);
            LeftToastRecyclerView leftToastRecyclerView6 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView6);
            leftToastRecyclerView6.setHorizontalScrollBarEnabled(false);
            LeftToastRecyclerView leftToastRecyclerView7 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView7);
            leftToastRecyclerView7.setVerticalScrollBarEnabled(false);
            final int dp4 = (int) DpUtils.dp2px(context, 4.0f);
            LeftToastRecyclerView leftToastRecyclerView8 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView8);
            leftToastRecyclerView8.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: tv.danmaku.biliplayerimpl.toast.left.LeftToastView.1
                public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    outRect.set(0, dp4, 0, dp4);
                }
            });
        }
        LeftToastRecyclerView leftToastRecyclerView9 = this.mRecyclerView;
        Intrinsics.checkNotNull(leftToastRecyclerView9);
        if (leftToastRecyclerView9.getParent() == null) {
            int dp160 = (int) DpUtils.dp2px(context, 160.0f);
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, dp160, 8388691);
            rootView.addView((View) this.mRecyclerView, lp);
        }
        if (this.mAdapter != null) {
            return;
        }
        this.mAdapter = new ToastRecyclerViewAdapter(handler);
        LeftToastRecyclerView leftToastRecyclerView10 = this.mRecyclerView;
        Intrinsics.checkNotNull(leftToastRecyclerView10);
        leftToastRecyclerView10.setAdapter(this.mAdapter);
    }

    public final void addToast(PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (this.mAdapter != null) {
            ToastRecyclerViewAdapter toastRecyclerViewAdapter = this.mAdapter;
            Intrinsics.checkNotNull(toastRecyclerViewAdapter);
            toastRecyclerViewAdapter.addToast(toast);
        }
        LeftToastRecyclerView leftToastRecyclerView = this.mRecyclerView;
        Intrinsics.checkNotNull(leftToastRecyclerView);
        ViewParent parent = leftToastRecyclerView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup parent2 = (ViewGroup) parent;
        if (this.mRecyclerView != null && parent2.indexOfChild((View) this.mRecyclerView) < parent2.getChildCount() - 1) {
            LeftToastRecyclerView leftToastRecyclerView2 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView2);
            leftToastRecyclerView2.bringToFront();
        }
    }

    public final void removeToast(PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (this.mAdapter != null) {
            ToastRecyclerViewAdapter toastRecyclerViewAdapter = this.mAdapter;
            Intrinsics.checkNotNull(toastRecyclerViewAdapter);
            AbsToastListAdapter.removeToast$default(toastRecyclerViewAdapter, toast, false, 2, null);
        }
    }

    public final void removeAll() {
        if (this.mAdapter != null) {
            ToastRecyclerViewAdapter toastRecyclerViewAdapter = this.mAdapter;
            Intrinsics.checkNotNull(toastRecyclerViewAdapter);
            toastRecyclerViewAdapter.removeAll();
        }
    }

    public final void setMargin(int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        if (this.mRecyclerView == null) {
            return;
        }
        LeftToastRecyclerView leftToastRecyclerView = this.mRecyclerView;
        Intrinsics.checkNotNull(leftToastRecyclerView);
        ViewGroup.LayoutParams layoutParams = leftToastRecyclerView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int oldLeftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int oldTopMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int oldRightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int oldBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (oldLeftMargin != leftMargin || oldTopMargin != topMargin || oldRightMargin != rightMargin || oldBottomMargin != bottomMargin) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
                LeftToastRecyclerView leftToastRecyclerView2 = this.mRecyclerView;
                Intrinsics.checkNotNull(leftToastRecyclerView2);
                leftToastRecyclerView2.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.AbsScaleableToastView
    public void scaleRootView() {
        if (this.mRecyclerView != null) {
            LeftToastRecyclerView leftToastRecyclerView = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView);
            leftToastRecyclerView.setPivotX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            LeftToastRecyclerView leftToastRecyclerView2 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView2);
            leftToastRecyclerView2.setPivotY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            LeftToastRecyclerView leftToastRecyclerView3 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView3);
            leftToastRecyclerView3.setScaleX(getMScaleFactor());
            LeftToastRecyclerView leftToastRecyclerView4 = this.mRecyclerView;
            Intrinsics.checkNotNull(leftToastRecyclerView4);
            leftToastRecyclerView4.setScaleY(getMScaleFactor());
        }
    }
}