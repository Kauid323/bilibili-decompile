package tv.danmaku.bili.ui.main2.mine.fansachievement;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.content.ContextCompat;
import com.bapis.bilibili.app.mine.v1.DisplayPos;
import com.bapis.bilibili.app.mine.v1.DisplayReportReq;
import com.bapis.bilibili.app.mine.v1.MineMoss;
import com.bapis.bilibili.app.mine.v1.MineMossKtxKt;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.net.URL;
import kntr.base.localization.NumberFormat_androidKt;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: FansAchievementHelper.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00017BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u00100\u001a\u000201J\u0018\u00102\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u00103\u001a\u00020%H\u0002J\u0016\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u00103\u001a\u00020%J\u0006\u00105\u001a\u00020+J\u0006\u00106\u001a\u00020+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020!X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/fansachievement/FansAchievementHelper;", "", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "tvFans", "Landroid/widget/TextView;", "button", "Landroid/widget/LinearLayout;", "buttonText", "buttonImage", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "badgeView", "Landroid/view/View;", "fansLayout", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Landroid/widget/TextView;Landroid/widget/LinearLayout;Landroid/widget/TextView;Lcom/bilibili/magicasakura/widgets/TintImageView;Landroid/view/View;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getTvFans", "()Landroid/widget/TextView;", "getButton", "()Landroid/widget/LinearLayout;", "getButtonText", "getButtonImage", "()Lcom/bilibili/magicasakura/widgets/TintImageView;", "getBadgeView", "()Landroid/view/View;", "getFansLayout", AppConfig.HOST_TAG, "", "getTag", "()Ljava/lang/String;", "showedAchieveType", "", "animator", "Landroid/animation/AnimatorSet;", "svgaPopupWindow", "Landroid/widget/PopupWindow;", "reportDisplay", "", "fansEffect", "Ltv/danmaku/bili/ui/main2/api/AccountMine$FansEffect;", "(Ltv/danmaku/bili/ui/main2/api/AccountMine$FansEffect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showButton", "alphaAnimation", "", "playAnimation", "fansCount", "showAchievementAnimationAsPopup", "showBadge", "dismiss", "StepInterpolator", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FansAchievementHelper {
    public static final int $stable = 8;
    private AnimatorSet animator;
    private final View badgeView;
    private final LinearLayout button;
    private final TintImageView buttonImage;
    private final TextView buttonText;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final View fansLayout;
    private int showedAchieveType;
    private PopupWindow svgaPopupWindow;
    private final String tag;
    private final TextView tvFans;

    public FansAchievementHelper(Context context, CoroutineScope coroutineScope, TextView tvFans, LinearLayout button, TextView buttonText, TintImageView buttonImage, View badgeView, View fansLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.context = context;
        this.coroutineScope = coroutineScope;
        this.tvFans = tvFans;
        this.button = button;
        this.buttonText = buttonText;
        this.buttonImage = buttonImage;
        this.badgeView = badgeView;
        this.fansLayout = fansLayout;
        this.tag = "UserCenterFransAchievementHelper";
    }

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

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final TextView getTvFans() {
        return this.tvFans;
    }

    public final LinearLayout getButton() {
        return this.button;
    }

    public final TextView getButtonText() {
        return this.buttonText;
    }

    public final TintImageView getButtonImage() {
        return this.buttonImage;
    }

    public final View getBadgeView() {
        return this.badgeView;
    }

    public final View getFansLayout() {
        return this.fansLayout;
    }

    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|13|14|15))|22|6|7|8|13|14|15) */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002c A[Catch: Exception -> 0x0030, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:38:0x002c, B:43:0x0036), top: B:50:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reportDisplay(AccountMine.FansEffect fansEffect, Continuation<? super Unit> continuation) {
        FansAchievementHelper$reportDisplay$1 fansAchievementHelper$reportDisplay$1;
        if (continuation instanceof FansAchievementHelper$reportDisplay$1) {
            fansAchievementHelper$reportDisplay$1 = (FansAchievementHelper$reportDisplay$1) continuation;
            if ((fansAchievementHelper$reportDisplay$1.label & Integer.MIN_VALUE) != 0) {
                fansAchievementHelper$reportDisplay$1.label -= Integer.MIN_VALUE;
                Object $result = fansAchievementHelper$reportDisplay$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fansAchievementHelper$reportDisplay$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DisplayReportReq req = DisplayReportReq.newBuilder().addContent(DisplayReportReq.ReportContent.newBuilder().setTimes(1L).setPos(DisplayPos.FANS_EFFECT).setExtra(fansEffect.reportInfo).build()).build();
                        MineMoss mineMoss = new MineMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                        Intrinsics.checkNotNull(req);
                        fansAchievementHelper$reportDisplay$1.label = 1;
                        if (MineMossKtxKt.suspendDisplayReport(mineMoss, req, fansAchievementHelper$reportDisplay$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        fansAchievementHelper$reportDisplay$1 = new FansAchievementHelper$reportDisplay$1(this, continuation);
        Object $result2 = fansAchievementHelper$reportDisplay$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fansAchievementHelper$reportDisplay$1.label) {
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showButton$default(FansAchievementHelper fansAchievementHelper, AccountMine.FansEffect fansEffect, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fansAchievementHelper.showButton(fansEffect, z);
    }

    public final void showButton(final AccountMine.FansEffect fansEffect, boolean alphaAnimation) {
        int textColor;
        int backgroundColor;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        int color;
        int color2;
        int color3;
        int color4;
        Intrinsics.checkNotNullParameter(fansEffect, "fansEffect");
        dismiss();
        final AccountMine.FansEffectButton it = fansEffect.button;
        if (it != null) {
            Garb garb = GarbManager.getGarbWithNightMode(this.context);
            if (garb.isPure()) {
                if (garb.isWhite()) {
                    String $this$toColorInt$iv = it.textColor;
                    if ($this$toColorInt$iv == null) {
                        color3 = ContextCompat.getColor(this.context, R.color.Wh0_u);
                    } else {
                        color3 = Color.parseColor($this$toColorInt$iv);
                    }
                    textColor = color3;
                    String $this$toColorInt$iv2 = it.bgColor;
                    if ($this$toColorInt$iv2 == null) {
                        color4 = ContextCompat.getColor(this.context, R.color.Pi5);
                    } else {
                        color4 = Color.parseColor($this$toColorInt$iv2);
                    }
                    backgroundColor = color4;
                } else if (garb.isNight()) {
                    String $this$toColorInt$iv3 = it.textNightColor;
                    if ($this$toColorInt$iv3 == null) {
                        color = ContextCompat.getColor(this.context, R.color.Wh0_u);
                    } else {
                        color = Color.parseColor($this$toColorInt$iv3);
                    }
                    textColor = color;
                    String $this$toColorInt$iv4 = it.bgNightColor;
                    if ($this$toColorInt$iv4 == null) {
                        color2 = ContextCompat.getColor(this.context, R.color.Pi5);
                    } else {
                        color2 = Color.parseColor($this$toColorInt$iv4);
                    }
                    backgroundColor = color2;
                } else {
                    textColor = ThemeUtils.getColorById(this.context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
                    backgroundColor = ContextCompat.getColor(this.context, R.color.Wh0_u);
                }
            } else if (garb.isDarkMode()) {
                textColor = ContextCompat.getColor(this.context, R.color.Wh0_u);
                backgroundColor = ContextCompat.getColor(this.context, R.color.Pi5);
            } else {
                textColor = ContextCompat.getColor(this.context, R.color.Pi5);
                backgroundColor = ContextCompat.getColor(this.context, R.color.Wh0_u);
            }
            LinearLayout linearLayout = this.button;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            MineReporter.INSTANCE.reportShow(MineReporter.MINE_FANS_ACHIEVEMENT_BUTTON_SHOW, MapsKt.mapOf(TuplesKt.to("jump_level", String.valueOf(fansEffect.achieveType))));
            LinearLayout linearLayout2 = this.button;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FansAchievementHelper.showButton$lambda$0$0(AccountMine.FansEffectButton.this, fansEffect, view);
                    }
                });
            }
            if (alphaAnimation) {
                LinearLayout linearLayout3 = this.button;
                if (linearLayout3 != null) {
                    linearLayout3.setAlpha(0.0f);
                }
                LinearLayout linearLayout4 = this.button;
                if (linearLayout4 != null && (animate = linearLayout4.animate()) != null && (alpha = animate.alpha(1.0f)) != null && (duration = alpha.setDuration(300L)) != null) {
                    duration.start();
                }
            }
            TextView textView = this.buttonText;
            if (textView != null) {
                textView.setTextColor(textColor);
            }
            TextView textView2 = this.buttonText;
            if (textView2 != null) {
                textView2.setText(it.text);
            }
            TintImageView tintImageView = this.buttonImage;
            if (tintImageView != null) {
                tintImageView.setColorFilter(textColor);
            }
            LinearLayout linearLayout5 = this.button;
            Drawable background = linearLayout5 != null ? linearLayout5.getBackground() : null;
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            Drawable mutate = gradientDrawable.mutate();
            Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable1 = (GradientDrawable) mutate;
            gradientDrawable1.setColor(backgroundColor);
            this.button.setBackground(gradientDrawable1);
        }
    }

    public static final void showButton$lambda$0$0(AccountMine.FansEffectButton $it, AccountMine.FansEffect $fansEffect, View i) {
        String uri = $it.uri;
        if (uri != null) {
            BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(uri), (Context) null, 2, (Object) null);
            MineReporter.INSTANCE.reportClick(MineReporter.MINE_FANS_ACHIEVEMENT_BUTTON_CLICK, MapsKt.mapOf(TuplesKt.to("jump_level", String.valueOf($fansEffect.achieveType))));
        }
    }

    public final void playAnimation(AccountMine.FansEffect fansEffect, int fansCount) {
        int mAnimationStartFanCount;
        switch (fansEffect.achieveType) {
            case 1:
                mAnimationStartFanCount = 9990000;
                break;
            case 2:
                mAnimationStartFanCount = 990000;
                break;
            case 3:
                mAnimationStartFanCount = 90000;
                break;
            case 4:
                mAnimationStartFanCount = 9000;
                break;
            default:
                mAnimationStartFanCount = 0;
                break;
        }
        final String originText = NumberFormat_androidKt.formatNumber$default(fansCount, "-", 0, 4, (Object) null);
        ValueAnimator scaleAnimation = ValueAnimator.ofFloat(1.0f, 1.3f);
        scaleAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FansAchievementHelper.playAnimation$lambda$0$0(FansAchievementHelper.this, valueAnimator);
            }
        });
        scaleAnimation.setDuration(1000L);
        ValueAnimator countAnimation = ValueAnimator.ofInt(mAnimationStartFanCount, fansCount);
        countAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FansAchievementHelper.playAnimation$lambda$1$0(FansAchievementHelper.this, valueAnimator);
            }
        });
        countAnimation.setInterpolator(new StepInterpolator(30));
        countAnimation.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$playAnimation$countAnimation$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                TextView tvFans = FansAchievementHelper.this.getTvFans();
                if (tvFans != null) {
                    tvFans.setText(originText);
                }
            }
        });
        countAnimation.setDuration(1000L);
        ValueAnimator reduceAnimation = ValueAnimator.ofFloat(1.3f, 1.0f);
        reduceAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FansAchievementHelper.playAnimation$lambda$2$0(FansAchievementHelper.this, valueAnimator);
            }
        });
        reduceAnimation.setStartDelay(1100L);
        reduceAnimation.setDuration(300L);
        this.animator = new AnimatorSet();
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.playTogether(scaleAnimation, countAnimation, reduceAnimation);
        }
        AnimatorSet animatorSet2 = this.animator;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public static final void playAnimation$lambda$0$0(FansAchievementHelper this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f != null) {
            float v = f.floatValue();
            TextView textView = this$0.tvFans;
            if (textView != null) {
                textView.setScaleY(v);
            }
            TextView textView2 = this$0.tvFans;
            if (textView2 != null) {
                textView2.setScaleX(v);
            }
        }
    }

    public static final void playAnimation$lambda$1$0(FansAchievementHelper this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int v = num.intValue();
            TextView textView = this$0.tvFans;
            if (textView != null) {
                textView.setText(NumberFormat_androidKt.formatNumber$default(v, (String) null, 0, 6, (Object) null));
            }
        }
    }

    public static final void playAnimation$lambda$2$0(FansAchievementHelper this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f != null) {
            float v = f.floatValue();
            TextView textView = this$0.tvFans;
            if (textView != null) {
                textView.setScaleX(v);
            }
            TextView textView2 = this$0.tvFans;
            if (textView2 != null) {
                textView2.setScaleY(v);
            }
        }
    }

    public final void showAchievementAnimationAsPopup(final AccountMine.FansEffect fansEffect, final int fansCount) {
        Intrinsics.checkNotNullParameter(fansEffect, "fansEffect");
        if (this.fansLayout == null || this.showedAchieveType == fansEffect.achieveType) {
            return;
        }
        View view = this.badgeView;
        if (view != null) {
            view.setVisibility(8);
        }
        try {
            final int svgaWidth = DimenUtilsKt.dpToPx((int) BR.desc);
            final View sVGAImageView = new SVGAImageView(this.context);
            sVGAImageView.setLayoutParams(new ViewGroup.LayoutParams(svgaWidth, svgaWidth));
            sVGAImageView.setLoops(1);
            PopupWindow $this$showAchievementAnimationAsPopup_u24lambda_u241 = new PopupWindow(sVGAImageView, svgaWidth, svgaWidth, false);
            $this$showAchievementAnimationAsPopup_u24lambda_u241.setElevation(20.0f);
            $this$showAchievementAnimationAsPopup_u24lambda_u241.setClippingEnabled(false);
            this.svgaPopupWindow = $this$showAchievementAnimationAsPopup_u24lambda_u241;
            Garb garb = GarbManager.getGarbWithNightMode(this.context);
            new SVGAParser(this.context).parse(new URL(garb.isNight() ? fansEffect.nightResourceUrl : fansEffect.resourceUrl), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$showAchievementAnimationAsPopup$2
                public void onComplete(SVGAVideoEntity videoItem) {
                    PopupWindow popupWindow;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    MineReporter.INSTANCE.reportShow(MineReporter.MINE_FANS_ACHIEVEMENT_SVGA_SHOW, MapsKt.mapOf(TuplesKt.to("jump_level", String.valueOf(AccountMine.FansEffect.this.achieveType))));
                    BuildersKt.launch$default(this.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$1(this, AccountMine.FansEffect.this, null), 3, (Object) null);
                    SVGAImageView sVGAImageView2 = sVGAImageView;
                    final SVGAImageView sVGAImageView3 = sVGAImageView;
                    final FansAchievementHelper fansAchievementHelper = this;
                    final AccountMine.FansEffect fansEffect2 = AccountMine.FansEffect.this;
                    sVGAImageView2.setCallback(new SVGACallback() { // from class: tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$2
                        public /* synthetic */ void onPause() {
                            SVGACallback.-CC.$default$onPause(this);
                        }

                        public /* synthetic */ void onRepeat() {
                            SVGACallback.-CC.$default$onRepeat(this);
                        }

                        public /* synthetic */ void onStep(int i, double d) {
                            SVGACallback.-CC.$default$onStep(this, i, d);
                        }

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

                        public void onFinished() {
                            PopupWindow popupWindow2;
                            SVGACallback.-CC.$default$onFinished(this);
                            sVGAImageView3.stopAnimation();
                            popupWindow2 = fansAchievementHelper.svgaPopupWindow;
                            if (popupWindow2 != null) {
                                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow2);
                            }
                            fansAchievementHelper.svgaPopupWindow = null;
                            fansAchievementHelper.showButton(fansEffect2, true);
                        }

                        public void onPreStart() {
                            SVGACallback.-CC.$default$onPreStart(this);
                            fansAchievementHelper.showedAchieveType = fansEffect2.achieveType;
                            LinearLayout button = fansAchievementHelper.getButton();
                            if (button != null) {
                                button.setVisibility(8);
                            }
                            View badgeView = fansAchievementHelper.getBadgeView();
                            if (badgeView != null) {
                                badgeView.setVisibility(8);
                            }
                        }
                    });
                    sVGAImageView.setVideoItem(videoItem);
                    int[] location = new int[2];
                    this.getFansLayout().getLocationInWindow(location);
                    int offset = DimenUtilsKt.dpToPx(AccountMine.FansEffect.this.achieveType == 2 ? 5 : -5);
                    popupWindow = this.svgaPopupWindow;
                    if (popupWindow != null) {
                        popupWindow.showAtLocation(this.getFansLayout(), 0, location[0] + ((this.getFansLayout().getWidth() - svgaWidth) / 2), ((location[1] + (this.getFansLayout().getHeight() / 2)) - svgaWidth) + offset);
                    }
                    sVGAImageView.startAnimation();
                    this.playAnimation(AccountMine.FansEffect.this, fansCount);
                }

                public void onError() {
                    FansAchievementHelper.showButton$default(this, AccountMine.FansEffect.this, false, 2, null);
                }

                public void onCacheExist() {
                }
            });
        } catch (Exception e) {
            showButton$default(this, fansEffect, false, 2, null);
        }
    }

    public final void showBadge() {
        dismiss();
        View view = this.badgeView;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = this.button;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void dismiss() {
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.end();
        }
        AnimatorSet animatorSet2 = this.animator;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        this.animator = null;
        PopupWindow popupWindow = this.svgaPopupWindow;
        if (popupWindow != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow);
        }
        this.svgaPopupWindow = null;
    }

    /* compiled from: FansAchievementHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/fansachievement/FansAchievementHelper$StepInterpolator;", "Landroid/animation/TimeInterpolator;", "steps", "", "<init>", "(I)V", "getInterpolation", "", "input", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StepInterpolator implements TimeInterpolator {
        private final int steps;

        public StepInterpolator(int steps) {
            this.steps = steps;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return ((int) (this.steps * input)) / this.steps;
        }
    }
}