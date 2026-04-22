package tv.danmaku.bili.ui.main2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class BottomBubbleWindow {
    private static final int CONTENT_VIEW_PADDING_16 = 16;
    private static final int CONTENT_VIEW_PADDING_3 = 3;
    private static final int EXPAND_DURATION = 250;
    private static final int IMAGE_ICON_SIZE = 30;
    private static final int TEXT_VIEW_LEFT_MARGIN = 8;
    private static final int UP_DURATION = 300;
    private View anchorView;
    private LinearLayout contentLayout;
    private View contentView;
    private int contentWidth;
    private int destinationY;
    private boolean hasShow;
    private MainResourceManager.TabBubbleItem item;
    private Context mContext;
    private int minMarginToEdge;
    private int offsetX;
    private int offsetY;
    private int popupWidth;
    private PopupWindow popupWindow;
    private int tabPosition;
    private TextView textView;
    private TintImageView triangle;
    private int windowWidth;
    private boolean beginExpand = false;
    private Runnable dismissRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.2
        @Override // java.lang.Runnable
        public void run() {
            BottomBubbleHelper.dismissWindow(true);
        }
    };
    private ValueAnimator.AnimatorUpdateListener windowUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.7
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            BottomBubbleWindow.this.popupWindow.update(BottomBubbleWindow.this.anchorView, BottomBubbleWindow.this.offsetX, ((Integer) animation.getAnimatedValue()).intValue(), -1, -1);
        }
    };
    private ValueAnimator.AnimatorUpdateListener updateWidthListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.8
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            BottomBubbleWindow.this.contentLayout.getLayoutParams().width = ((Integer) animation.getAnimatedValue()).intValue();
            BottomBubbleWindow.this.contentLayout.requestLayout();
        }
    };
    private ValueAnimator.AnimatorUpdateListener marginUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.9
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            ((ViewGroup.MarginLayoutParams) BottomBubbleWindow.this.textView.getLayoutParams()).leftMargin = ((Integer) animation.getAnimatedValue()).intValue();
            BottomBubbleWindow.this.textView.requestLayout();
        }
    };
    private ValueAnimator.AnimatorUpdateListener paddingUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.10
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            BottomBubbleWindow.this.contentLayout.setPadding(((Integer) animation.getAnimatedValue()).intValue(), BottomBubbleWindow.this.contentLayout.getPaddingTop(), ((Integer) animation.getAnimatedValue()).intValue(), BottomBubbleWindow.this.contentLayout.getPaddingBottom());
        }
    };

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
        Intrinsics.checkNotNullParameter(popup, "popup");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((PopupWindow) popup).dismiss();
    }

    public BottomBubbleWindow(Context context, final TabHost tabHost, final MainResourceManager.TabBubbleItem item, final int position) {
        int tabHeight;
        this.tabPosition = -1;
        if (TextUtils.isEmpty(item.title) && TextUtils.isEmpty(item.cover)) {
            return;
        }
        this.tabPosition = position;
        this.mContext = context;
        this.item = item;
        LinearLayout view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.bili_app_dialog_bottom_nav_pop, (ViewGroup) null);
        this.contentLayout = (LinearLayout) view.findViewById(R.id.content_layout);
        this.textView = (TextView) view.findViewById(R.id.text);
        this.triangle = view.findViewById(R.id.triangle);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(DisplayUtils.dp2Px(18));
        Garb garb = GarbManager.getGarbWithNightMode(context);
        int bgColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
        if (!garb.isPure() && !garb.isPrimaryOnly()) {
            bgColor = garb.getSecondaryPageColor();
            this.textView.setTextColor(garb.getFontColor());
        } else if (MultipleThemeUtils.isNightTheme(context)) {
            bgColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.daynight_color_theme_pink);
        }
        gradientDrawable.setColor(bgColor);
        ImageViewCompat.setImageTintList(this.triangle, ColorStateList.valueOf(bgColor));
        this.contentLayout.setBackground(gradientDrawable);
        if (!TextUtils.isEmpty(item.title)) {
            this.textView.setText(item.title);
        } else {
            this.textView.setVisibility(8);
        }
        this.windowWidth = calculateContentWidth(item.title);
        ViewGroup.MarginLayoutParams triangleParams = (ViewGroup.MarginLayoutParams) this.triangle.getLayoutParams();
        this.popupWindow = new PopupWindow(view, this.windowWidth, DisplayUtils.dp2Px(44));
        view.measure(makeDropDownMeasureSpec(this.popupWindow.getWidth()), makeDropDownMeasureSpec(this.popupWindow.getHeight()));
        this.contentView = this.popupWindow.getContentView();
        this.windowWidth = this.popupWindow.getContentView().getMeasuredWidth();
        this.popupWindow.setWidth(this.windowWidth);
        this.contentWidth = this.contentLayout.getMeasuredWidth();
        this.anchorView = tabHost.getItemView(position);
        this.minMarginToEdge = DisplayUtils.dp2Px(10);
        this.popupWidth = calculatePopupWidth();
        this.contentLayout.getLayoutParams().width = this.popupWidth;
        int triangleWidth = this.triangle.getMeasuredWidth();
        int tabWidth = this.anchorView.getWidth();
        if (!garb.isPure()) {
            tabHeight = context.getResources().getDimensionPixelSize(com.bilibili.lib.homepage.R.dimen.bottom_navigation_height_with_bg);
        } else {
            tabHeight = context.getResources().getDimensionPixelSize(com.bilibili.lib.homepage.R.dimen.bottom_navigation_height);
        }
        this.destinationY = -((this.popupWindow.getContentView().getMeasuredHeight() + tabHeight) - DisplayUtils.dp2Px(4));
        this.offsetY = -((this.popupWindow.getContentView().getMeasuredHeight() / 2) + tabHeight);
        this.offsetX = (tabWidth - this.popupWidth) / 2;
        if (TextUtils.isEmpty(item.title)) {
            this.offsetX = (tabWidth - this.popupWidth) / 2;
            triangleParams.leftMargin = (this.popupWidth - triangleWidth) / 2;
        } else if (position == 0 && this.windowWidth + this.minMarginToEdge > tabWidth) {
            this.offsetX = this.minMarginToEdge;
            triangleParams.leftMargin = ((tabWidth - triangleWidth) / 2) - this.minMarginToEdge;
            ((ViewGroup.MarginLayoutParams) this.contentLayout.getLayoutParams()).leftMargin = ((tabWidth - this.popupWidth) / 2) - this.minMarginToEdge;
        } else if (position == tabHost.getItemCount() - 1 && this.windowWidth + this.minMarginToEdge > tabWidth) {
            this.offsetX = tabWidth - (this.windowWidth + this.minMarginToEdge);
            int contentMarginLeft = Math.abs(this.offsetX) + ((tabWidth - this.popupWidth) / 2);
            ((ViewGroup.MarginLayoutParams) this.contentLayout.getLayoutParams()).leftMargin = contentMarginLeft;
            triangleParams.leftMargin = Math.abs(this.offsetX) + ((tabWidth - triangleWidth) / 2);
        } else {
            this.offsetX = (tabWidth - this.windowWidth) / 2;
            ((ViewGroup.MarginLayoutParams) this.contentLayout.getLayoutParams()).leftMargin = (this.windowWidth / 2) - (this.popupWidth / 2);
            triangleParams.leftMargin = (this.windowWidth / 2) - (triangleWidth / 2);
        }
        this.contentLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BottomBubbleHelper.dismissWindow(true);
                BottomBubbleHelper.reportBubbleClick(String.valueOf(item.id));
                tabHost.resetBubbleStatus(position);
                IntentHelper.intentTo(BottomBubbleWindow.this.mContext, Uri.parse(item.uri));
            }
        });
    }

    private int calculateContentWidth(CharSequence text) {
        int textSize = (int) this.textView.getPaint().measureText(text.toString());
        int calculateSize = DisplayUtils.dp2Px(32) + textSize;
        return Math.min(calculateSize, DisplayUtils.dp2Px((int) BR.danmakuNumIcon));
    }

    private int calculatePopupWidth() {
        return DisplayUtils.dp2Px(36);
    }

    private static int makeDropDownMeasureSpec(int measureSpec) {
        int mode;
        if (measureSpec == -2) {
            mode = 0;
        } else {
            mode = 1073741824;
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode);
    }

    public int getPosition() {
        return this.tabPosition;
    }

    public void startExitAnimation() {
        if (TextUtils.isEmpty(this.item.title)) {
            startDownAnimation();
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        ValueAnimator widthAnimator = ValueAnimator.ofInt(this.windowWidth, this.popupWidth).setDuration(250L);
        widthAnimator.addUpdateListener(this.updateWidthListener);
        widthAnimator.setInterpolator(new LinearInterpolator());
        ValueAnimator paddingAnimator = ValueAnimator.ofInt(DisplayUtils.dp2Px(16), DisplayUtils.dp2Px(3));
        paddingAnimator.addUpdateListener(this.paddingUpdateListener);
        ObjectAnimator leftTranslate = ObjectAnimator.ofFloat(this.contentLayout, View.TRANSLATION_X, -((ViewGroup.MarginLayoutParams) this.contentLayout.getLayoutParams()).leftMargin, 0.0f).setDuration(250L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                BottomBubbleWindow.this.startDownAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.playTogether(widthAnimator, paddingAnimator, leftTranslate);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownAnimation() {
        ValueAnimator windowAnimator = ValueAnimator.ofInt(this.destinationY, this.offsetY).setDuration(300L);
        windowAnimator.addUpdateListener(this.windowUpdateListener);
        windowAnimator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        this.contentView.startAnimation(alphaAnimation);
        windowAnimator.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.4
            private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
                Intrinsics.checkNotNullParameter(popup, "popup");
                if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                    Thread thread = Thread.currentThread();
                    if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                        IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                        BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                        Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                        if (BuildConfig.DEBUG) {
                            throw exp;
                        }
                    }
                }
                ((PopupWindow) popup).dismiss();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(BottomBubbleWindow.this.popupWindow);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    private void startEnterAnimation(final View contentView) {
        ValueAnimator windowAnimator = ValueAnimator.ofInt(this.offsetY, this.destinationY).setDuration(300L);
        windowAnimator.setStartDelay(400L);
        windowAnimator.addUpdateListener(this.windowUpdateListener);
        windowAnimator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setStartOffset(400L);
        contentView.startAnimation(alphaAnimation);
        final long skipTime = OnlineParamsHelper.getConfigInt("app_main_bottom_bubble_time", 8) * 1000;
        windowAnimator.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                contentView.postDelayed(BottomBubbleWindow.this.dismissRunnable, skipTime);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        windowAnimator.setInterpolator(new TimeInterpolator() { // from class: tv.danmaku.bili.ui.main2.BottomBubbleWindow.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float input) {
                if (!BottomBubbleWindow.this.beginExpand && input >= 0.9d && !TextUtils.isEmpty(BottomBubbleWindow.this.item.title)) {
                    BottomBubbleWindow.this.beginExpand = true;
                    BottomBubbleWindow.this.startLeftExpandAnimation();
                }
                return input;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLeftExpandAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        ValueAnimator widthAnimator = ValueAnimator.ofInt(this.contentLayout.getMeasuredWidth(), this.windowWidth).setDuration(250L);
        widthAnimator.addUpdateListener(this.updateWidthListener);
        widthAnimator.setInterpolator(new LinearInterpolator());
        ValueAnimator paddingAnimator = ValueAnimator.ofInt(this.contentLayout.getPaddingLeft(), DisplayUtils.dp2Px(16));
        paddingAnimator.addUpdateListener(this.paddingUpdateListener);
        ObjectAnimator leftTranslate = ObjectAnimator.ofFloat(this.contentLayout, View.TRANSLATION_X, 0.0f, -((ViewGroup.MarginLayoutParams) this.contentLayout.getLayoutParams()).leftMargin).setDuration(250L);
        animatorSet.playTogether(widthAnimator, paddingAnimator, leftTranslate);
        animatorSet.start();
    }

    public BottomBubbleWindow show() {
        if (this.hasShow) {
            return this;
        }
        this.hasShow = true;
        if (this.contentView == null) {
            return null;
        }
        PopupWindowCompat.showAsDropDown(this.popupWindow, this.anchorView, this.offsetX, this.offsetY, 8388611);
        startEnterAnimation(this.contentView);
        return this;
    }

    public void dismissWithAnimation() {
        if (this.popupWindow == null) {
            return;
        }
        if (this.contentView != null) {
            this.contentView.removeCallbacks(this.dismissRunnable);
        }
        startExitAnimation();
    }

    public void dismiss() {
        if (this.popupWindow == null) {
            return;
        }
        if (this.contentView != null) {
            this.contentView.removeCallbacks(this.dismissRunnable);
        }
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(this.popupWindow);
    }
}