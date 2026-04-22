package tv.danmaku.bili.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.widget.TripleCustomBubble;
import tv.danmaku.bili.widget.dialog.BaseDialog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public abstract class BaseDialog<T extends BaseDialog> extends Dialog {
    private boolean mAutoDismiss;
    private long mAutoDismissDelay;
    protected boolean mCancel;
    protected Context mContext;
    protected DisplayMetrics mDisplayMetrics;
    private Handler mHandler;
    protected float mHeightScale;
    private boolean mIsPopupStyle;
    protected LinearLayout mLlControlHeight;
    protected LinearLayout mLlTop;
    protected float mMaxHeight;
    protected View mOnCreateView;
    protected String mTag;
    protected float mWidthScale;

    public abstract View onCreateView();

    public abstract void setUiBeforeShow();

    public BaseDialog(Context context) {
        super(context);
        this.mWidthScale = 1.0f;
        this.mAutoDismissDelay = TripleCustomBubble.PRE_ANIM_TIME;
        this.mHandler = new Handler(Looper.getMainLooper());
        setDialogTheme();
        this.mContext = context;
        this.mTag = getClass().getSimpleName();
        setCanceledOnTouchOutside(true);
    }

    public BaseDialog(Context context, boolean isPopupStyle) {
        this(context);
        this.mIsPopupStyle = isPopupStyle;
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(Object popup) {
        Intrinsics.checkNotNullParameter(popup, "popup");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Dialog.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Dialog.dismiss() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new BrowserActionsFallbackMenuDialog$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        super.dismiss();
    }

    private void setDialogTheme() {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().addFlags(2);
    }

    public void onViewCreated(View inflate) {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        this.mDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.mMaxHeight = this.mDisplayMetrics.heightPixels - getHeight(this.mContext);
        this.mLlTop = new LinearLayout(this.mContext);
        this.mLlTop.setGravity(17);
        this.mLlControlHeight = new LinearLayout(this.mContext);
        this.mLlControlHeight.setOrientation(1);
        this.mOnCreateView = onCreateView();
        this.mLlControlHeight.addView(this.mOnCreateView);
        this.mLlTop.addView(this.mLlControlHeight);
        onViewCreated(this.mOnCreateView);
        if (this.mIsPopupStyle) {
            setContentView(this.mLlTop, new ViewGroup.LayoutParams(-2, -2));
        } else {
            setContentView(this.mLlTop, new ViewGroup.LayoutParams(this.mDisplayMetrics.widthPixels, (int) this.mMaxHeight));
        }
        this.mLlTop.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.dialog.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BaseDialog.this.mCancel) {
                    BaseDialog.this.dismiss();
                }
            }
        });
        this.mOnCreateView.setClickable(true);
    }

    public View getCreateView() {
        return this.mOnCreateView;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        int width;
        int height;
        super.onAttachedToWindow();
        setUiBeforeShow();
        if (this.mWidthScale == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            width = -2;
        } else {
            width = (int) (this.mDisplayMetrics.widthPixels * this.mWidthScale);
        }
        if (this.mHeightScale == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            height = -2;
        } else if (this.mHeightScale == 1.0f) {
            height = (int) this.mMaxHeight;
        } else {
            height = (int) (this.mMaxHeight * this.mHeightScale);
        }
        this.mLlControlHeight.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        delayDismiss();
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean cancel) {
        this.mCancel = cancel;
        super.setCanceledOnTouchOutside(cancel);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        superDismiss();
    }

    public void superDismiss() {
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(this);
    }

    public void show(int animStyle) {
        Window window = getWindow();
        window.setWindowAnimations(animStyle);
        show();
    }

    public void showAtLocation(int gravity, int x, int y) {
        if (this.mIsPopupStyle) {
            Window window = getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            window.setGravity(gravity);
            params.x = x;
            params.y = y;
        }
        show();
    }

    public void showAtLocation(int x, int y) {
        showAtLocation(51, x, y);
    }

    public T dimEnabled(boolean isDimEnabled) {
        if (isDimEnabled) {
            getWindow().addFlags(2);
        } else {
            getWindow().clearFlags(2);
        }
        return this;
    }

    public T widthScale(float widthScale) {
        this.mWidthScale = widthScale;
        return this;
    }

    public T heightScale(float heightScale) {
        this.mHeightScale = heightScale;
        return this;
    }

    public T autoDismiss(boolean autoDismiss) {
        this.mAutoDismiss = autoDismiss;
        return this;
    }

    public T autoDismissDelay(long autoDismissDelay) {
        this.mAutoDismissDelay = autoDismissDelay;
        return this;
    }

    private void delayDismiss() {
        if (this.mAutoDismiss && this.mAutoDismissDelay > 0) {
            this.mHandler.postDelayed(new Runnable() { // from class: tv.danmaku.bili.widget.dialog.BaseDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseDialog.this.dismiss();
                }
            }, this.mAutoDismissDelay);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (this.mAutoDismiss) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.mAutoDismiss) {
            return;
        }
        super.onBackPressed();
    }

    protected int dp2px(float dp) {
        float scale = this.mContext.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }

    protected int getHeight(Context context) {
        int statusBarHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        if (isFlymeOs4x()) {
            return statusBarHeight * 2;
        }
        return statusBarHeight;
    }

    protected boolean isFlymeOs4x() {
        String sysVersion = Build.VERSION.RELEASE;
        if ("4.4.4".equals(sysVersion)) {
            String sysIncrement = Build.VERSION.INCREMENTAL;
            String displayId = Build.DISPLAY;
            if (!TextUtils.isEmpty(sysIncrement)) {
                return sysIncrement.contains("Flyme_OS_4");
            }
            return displayId.contains("Flyme OS 4");
        }
        return false;
    }
}