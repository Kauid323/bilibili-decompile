package tv.danmaku.bili.quick.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.accountsui.quick.QuickLoginPresenter;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.utils.reporter.BottomSheetStyleLoginQuickReporter;
import tv.danmaku.bili.utils.reporter.ILoginQuickReporter;

/* compiled from: LoginQuickBottomSheetActivity.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/quick/ui/LoginQuickBottomSheetActivity;", "Ltv/danmaku/bili/quick/ui/LoginQuickActivityV2;", "<init>", "()V", "adjustWindow", "", "getLayoutRes", "", "adjustEnterPendingTransition", "getPvEventId", "", "changeToAnswerMode", "resId", "finish", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getViewStyle", "getReporter", "Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;", "getLoginSpmid", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginQuickBottomSheetActivity extends LoginQuickActivityV2 {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    protected void adjustWindow() {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(80);
        window.setLayout(-1, -2);
        View mContainerLogin = getMContainerLogin();
        if (mContainerLogin != null) {
            mContainerLogin.setBackgroundColor(ContextCompat.getColor((Context) this, R.color.Ga0_s));
        }
        if (getMIsLoginGuide()) {
            View mContainerLogin2 = getMContainerLogin();
            if (mContainerLogin2 != null && (layoutParams = mContainerLogin2.getLayoutParams()) != null) {
                layoutParams.height = LoginQuickActivityV2.Companion.dp2Px(BR.hasBadge);
            }
            TextView mTitle = getMTitle();
            if (mTitle != null) {
                mTitle.setText(getString(bili.resource.account.R.string.account_global_string_120));
            }
        }
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    public int getLayoutRes() {
        if (getMIsLoginGuide()) {
            return com.bilibili.app.accountui.R.layout.bili_app_dialog_quick_login_guide;
        }
        return com.bilibili.app.accountui.R.layout.bili_app_dialog_quick_login;
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    protected void adjustEnterPendingTransition() {
        ViewGroup.LayoutParams layoutParams;
        View mContainerLogin = getMContainerLogin();
        if (mContainerLogin == null || (layoutParams = mContainerLogin.getLayoutParams()) == null) {
            return;
        }
        int height = layoutParams.height;
        View view = getMContainerLogin();
        if (view == null) {
            return;
        }
        overridePendingTransition(0, 0);
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "Y", height, 0.0f);
        anim.setDuration(300L);
        anim.start();
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    public String getPvEventId() {
        return LoginReporterV2.PV.APP_ONEPASS_LOGIN_PV_V2;
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    public void changeToAnswerMode(final int resId) {
        final int answerOffsetBottom;
        if (getMIsLoginGuide()) {
            answerOffsetBottom = 50;
        } else {
            answerOffsetBottom = 72;
        }
        View view = getMContainerLogin();
        if (view == null) {
            return;
        }
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "Y", view.getY(), view.getY() + LoginQuickActivityV2.Companion.dp2Px(answerOffsetBottom));
        anim.setDuration(200L);
        hideLoginContent();
        anim.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.quick.ui.LoginQuickBottomSheetActivity$changeToAnswerMode$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                View mContainerLogin = LoginQuickBottomSheetActivity.this.getMContainerLogin();
                if (mContainerLogin != null) {
                    mContainerLogin.setVisibility(4);
                }
                ViewGroup mContainer = LoginQuickBottomSheetActivity.this.getMContainer();
                View containerAnswer = mContainer != null ? mContainer.findViewById(com.bilibili.app.accountui.R.id.layout_answer) : null;
                if (containerAnswer != null) {
                    int i = answerOffsetBottom;
                    LoginQuickBottomSheetActivity loginQuickBottomSheetActivity = LoginQuickBottomSheetActivity.this;
                    int i2 = resId;
                    View $this$onAnimationEnd_u24lambda_u240 = containerAnswer;
                    $this$onAnimationEnd_u24lambda_u240.setBackgroundColor($this$onAnimationEnd_u24lambda_u240.getResources().getColor(R.color.Wh0));
                    $this$onAnimationEnd_u24lambda_u240.setY($this$onAnimationEnd_u24lambda_u240.getY() + LoginQuickActivityV2.Companion.dp2Px(i));
                    $this$onAnimationEnd_u24lambda_u240.setVisibility(0);
                    loginQuickBottomSheetActivity.alphaAnimAttachClick($this$onAnimationEnd_u24lambda_u240, i2);
                }
            }
        });
        anim.start();
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Rect bounds = new Rect();
        getWindow().getDecorView().getHitRect(bounds);
        if (!bounds.contains((int) ev.getX(), (int) ev.getY()) && ev.getAction() == 1) {
            ILoginQuickReporter mReporter = getMReporter();
            if (mReporter != null) {
                QuickLoginPresenter mLoginQuickPresenter = getMLoginQuickPresenter();
                mReporter.reportCloseClick(mLoginQuickPresenter != null ? ispReportFlag(mLoginQuickPresenter) : null);
            }
            if (!getMIsLoginGuide()) {
                finish();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    protected int getViewStyle() {
        return 2;
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    protected ILoginQuickReporter getReporter() {
        return new BottomSheetStyleLoginQuickReporter(getMPromptScene());
    }

    @Override // tv.danmaku.bili.quick.ui.LoginQuickActivityV2
    public String getLoginSpmid() {
        return LoginReporterV2.PV.APP_ONEPASS_LOGIN_V2;
    }
}