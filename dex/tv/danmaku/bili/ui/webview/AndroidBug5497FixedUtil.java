package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AndroidBug5497FixedUtil.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/webview/AndroidBug5497FixedUtil;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mListener", "Ltv/danmaku/bili/ui/webview/AndroidBug5497FixedUtil$KeyBoardChangeListener;", "getMListener", "()Ltv/danmaku/bili/ui/webview/AndroidBug5497FixedUtil$KeyBoardChangeListener;", "setMListener", "(Ltv/danmaku/bili/ui/webview/AndroidBug5497FixedUtil$KeyBoardChangeListener;)V", "mKeyBoardShow", "", "mChildOfContent", "Landroid/view/View;", "mUsableHeightPrevious", "", "mFrameLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "statusBarHeight", "setKeyBoardChangeListener", "", "listener", "possiblyResizeChildOfContent", "content", "Landroid/widget/FrameLayout;", "computeUsableHeight", "KeyBoardChangeListener", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AndroidBug5497FixedUtil {
    public static final int $stable = 8;
    private final View mChildOfContent;
    private FrameLayout.LayoutParams mFrameLayoutParams;
    private boolean mKeyBoardShow;
    private KeyBoardChangeListener mListener;
    private int mUsableHeightPrevious;
    private final int statusBarHeight;

    /* compiled from: AndroidBug5497FixedUtil.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/webview/AndroidBug5497FixedUtil$KeyBoardChangeListener;", "", "onKeyBoardShow", "", "onKeyBoardHide", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface KeyBoardChangeListener {
        void onKeyBoardHide();

        void onKeyBoardShow();
    }

    public AndroidBug5497FixedUtil(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        final FrameLayout content = (FrameLayout) findViewById;
        this.mChildOfContent = content.getChildAt(0);
        if (this.mChildOfContent != null && this.mChildOfContent.getViewTreeObserver().isAlive()) {
            this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.ui.webview.AndroidBug5497FixedUtil$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    AndroidBug5497FixedUtil.this.possiblyResizeChildOfContent(content);
                }
            });
            ViewGroup.LayoutParams layoutParams = this.mChildOfContent.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            this.mFrameLayoutParams = (FrameLayout.LayoutParams) layoutParams;
        }
        this.statusBarHeight = StatusBarCompat.getStatusBarHeight(activity);
    }

    public final KeyBoardChangeListener getMListener() {
        return this.mListener;
    }

    public final void setMListener(KeyBoardChangeListener keyBoardChangeListener) {
        this.mListener = keyBoardChangeListener;
    }

    public final void setKeyBoardChangeListener(KeyBoardChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void possiblyResizeChildOfContent(final FrameLayout content) {
        int mUsableHeightNow = computeUsableHeight();
        if (mUsableHeightNow != this.mUsableHeightPrevious) {
            View view2 = this.mChildOfContent;
            Intrinsics.checkNotNull(view2);
            int screenHeight = view2.getRootView().getHeight();
            int heightDifference = screenHeight - mUsableHeightNow;
            if (heightDifference > screenHeight / 4) {
                Object obj = ConfigManager.Companion.ab().get("webview_fix_statusbar_height", true);
                Intrinsics.checkNotNull(obj);
                if (((Boolean) obj).booleanValue()) {
                    heightDifference -= this.statusBarHeight;
                }
                FrameLayout.LayoutParams layoutParams = this.mFrameLayoutParams;
                if (layoutParams != null) {
                    layoutParams.height = screenHeight - heightDifference;
                }
                if (!this.mKeyBoardShow) {
                    this.mKeyBoardShow = true;
                    KeyBoardChangeListener keyBoardChangeListener = this.mListener;
                    if (keyBoardChangeListener != null) {
                        keyBoardChangeListener.onKeyBoardShow();
                    }
                }
                if (content.isInLayout() || !content.isLayoutRequested()) {
                    content.post(new Runnable() { // from class: tv.danmaku.bili.ui.webview.AndroidBug5497FixedUtil$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            content.requestLayout();
                        }
                    });
                } else {
                    content.requestLayout();
                }
            } else if (this.mKeyBoardShow) {
                this.mKeyBoardShow = false;
                KeyBoardChangeListener keyBoardChangeListener2 = this.mListener;
                if (keyBoardChangeListener2 != null) {
                    keyBoardChangeListener2.onKeyBoardHide();
                }
            }
            this.mUsableHeightPrevious = mUsableHeightNow;
        }
    }

    private final int computeUsableHeight() {
        Rect r = new Rect();
        View view2 = this.mChildOfContent;
        Intrinsics.checkNotNull(view2);
        view2.getWindowVisibleDisplayFrame(r);
        return r.bottom - r.top;
    }
}