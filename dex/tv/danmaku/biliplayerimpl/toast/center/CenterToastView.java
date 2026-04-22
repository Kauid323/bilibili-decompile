package tv.danmaku.biliplayerimpl.toast.center;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.R;
import tv.danmaku.biliplayerimpl.toast.AbsScaleableToastView;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CenterToastView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/center/CenterToastView;", "Ltv/danmaku/biliplayerimpl/toast/AbsScaleableToastView;", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mViewRoot", "Landroid/view/View;", "mTipTextView", "Landroid/widget/TextView;", "mParentView", "Landroid/widget/FrameLayout;", "centerLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "centerTopLayoutParams", "mToastDismissRunnable", "Ljava/lang/Runnable;", "showToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "location", "", "dismiss", "release", "scaleRootView", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CenterToastView extends AbsScaleableToastView {
    private final FrameLayout.LayoutParams centerLayoutParams;
    private final FrameLayout.LayoutParams centerTopLayoutParams;
    private final FrameLayout mParentView;
    private final TextView mTipTextView;
    private final Runnable mToastDismissRunnable;
    private final View mViewRoot;

    public CenterToastView(Context context, ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mParentView = (FrameLayout) rootView;
        this.centerLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        FrameLayout.LayoutParams $this$centerTopLayoutParams_u24lambda_u240 = new FrameLayout.LayoutParams(-2, -2, 49);
        $this$centerTopLayoutParams_u24lambda_u240.topMargin = (int) DpUtils.dp2px(context, 16.0f);
        this.centerTopLayoutParams = $this$centerTopLayoutParams_u24lambda_u240;
        this.mToastDismissRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.center.CenterToastView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CenterToastView.this.dismiss();
            }
        };
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        this.mViewRoot = layoutInflater.inflate(R.layout.bili_app_player_toast, (ViewGroup) this.mParentView, false);
        this.mParentView.addView(this.mViewRoot);
        View view2 = this.mViewRoot;
        Intrinsics.checkNotNull(view2);
        view2.setVisibility(4);
        this.mTipTextView = (TextView) this.mViewRoot.findViewById(tv.danmaku.biliplayerv2.R.id.message);
    }

    public final void showToast(PlayerToast toast, int location) {
        if (toast == null || this.mViewRoot == null || this.mTipTextView == null) {
            return;
        }
        String text = PlayerToastConfig.getTitle(toast);
        if (TextUtils.isEmpty(text)) {
            return;
        }
        this.mTipTextView.setText(text);
        int titleSize = toast.getExtraIntValue(PlayerToastConfig.EXTRA_TITLE_SIZE);
        if (titleSize > 0) {
            this.mTipTextView.setTextSize(titleSize);
        } else {
            this.mTipTextView.setTextSize(14.0f);
        }
        TextPaint tp = this.mTipTextView.getPaint();
        tp.setFakeBoldText(PlayerToastConfig.getTitleBold(toast, false));
        int bgResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_BG_DRAWABLE_RES_ID);
        if (bgResId > 0) {
            this.mViewRoot.setBackgroundResource(bgResId);
        } else {
            this.mViewRoot.setBackgroundResource(tv.danmaku.biliplayer.baseres.R.drawable.shape_roundrect_player_black);
        }
        switch (location) {
            case 33:
                this.mViewRoot.setLayoutParams(this.centerLayoutParams);
                break;
            case 34:
                this.mViewRoot.setLayoutParams(this.centerTopLayoutParams);
                break;
        }
        HandlerThreads.remove(0, this.mToastDismissRunnable);
        if (toast.getDuration() != PlayerToastConfig.DURATION_FOREVER) {
            HandlerThreads.postDelayed(0, this.mToastDismissRunnable, toast.getDuration());
        }
        scaleRootView();
        this.mViewRoot.setVisibility(0);
    }

    public final void dismiss() {
        if (this.mViewRoot == null || this.mTipTextView == null) {
            return;
        }
        this.mViewRoot.setVisibility(4);
    }

    public final void release() {
        HandlerThreads.remove(0, this.mToastDismissRunnable);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.AbsScaleableToastView
    public void scaleRootView() {
        if (this.mViewRoot != null) {
            ViewCompat.setScaleX(this.mViewRoot, getMScaleFactor());
            ViewCompat.setScaleY(this.mViewRoot, getMScaleFactor());
        }
    }
}