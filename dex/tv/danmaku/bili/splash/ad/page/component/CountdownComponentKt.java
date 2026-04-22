package tv.danmaku.bili.splash.ad.page.component;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.moduleservice.splash.SplashCoreService;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.state.actions.SplashSkipClickEvent;

/* compiled from: CountdownComponent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "showSkipButton", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "startCountDown", "doStopCountdown", "updateCountdownText", "leftTimeSecond", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CountdownComponentKt {
    private static final String TAG = "[Splash]CountdownComponent";

    public static final void showSkipButton(final BaseSplash $this$showSkipButton) {
        float scale;
        float countdownTextSize;
        Intrinsics.checkNotNullParameter($this$showSkipButton, "<this>");
        Context context = $this$showSkipButton.getContext();
        if (context == null) {
            return;
        }
        if ($this$showSkipButton.getSplash$adsplash_debug().getSkip() != 1) {
            ExperimentViewComponentKt.getCountdownView($this$showSkipButton).setVisibility(8);
            return;
        }
        ExperimentViewComponentKt.getCountdownView($this$showSkipButton).setVisibility(0);
        if (ExtSplashOrderKt.isSkipDefault($this$showSkipButton.getSplash$adsplash_debug())) {
            scale = ExperimentViewComponentKt.getBottomLogoHeight($this$showSkipButton) * (ExtSplashOrderKt.isFullScreen($this$showSkipButton.getSplash$adsplash_debug()) ? 0.446f : 0.43f);
        } else {
            float scale2 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast($this$showSkipButton.getSplash$adsplash_debug().getSkipButtonHeightRatio(), 0.035f), 0.056f);
            scale = $this$showSkipButton.getResources().getDisplayMetrics().heightPixels * scale2;
        }
        TextView countdownView = ExperimentViewComponentKt.getCountdownView($this$showSkipButton);
        ViewGroup.LayoutParams $this$showSkipButton_u24lambda_u240 = ExperimentViewComponentKt.getCountdownView($this$showSkipButton).getLayoutParams();
        if ($this$showSkipButton_u24lambda_u240 != null) {
            $this$showSkipButton_u24lambda_u240.height = (int) scale;
            float f = 2;
            $this$showSkipButton_u24lambda_u240.width = (int) (scale * f);
            countdownView.setLayoutParams($this$showSkipButton_u24lambda_u240);
            Drawable drawable = ContextCompat.getDrawable(context, ExperimentViewComponentKt.getSkipButtonBg($this$showSkipButton));
            GradientDrawable gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
            Drawable mutate = gradientDrawable != null ? gradientDrawable.mutate() : null;
            GradientDrawable gradientDrawable2 = mutate instanceof GradientDrawable ? mutate : null;
            if (gradientDrawable2 != null) {
                GradientDrawable $this$showSkipButton_u24lambda_u241 = gradientDrawable2;
                $this$showSkipButton_u24lambda_u241.setCornerRadius(scale / f);
                ExperimentViewComponentKt.getCountdownView($this$showSkipButton).setBackground($this$showSkipButton_u24lambda_u241);
            }
            if (ExtSplashOrderKt.isSkipDefault($this$showSkipButton.getSplash$adsplash_debug())) {
                countdownTextSize = (ExtSplashOrderKt.isFullScreen($this$showSkipButton.getSplash$adsplash_debug()) ? 0.35f : 0.4f) * scale;
            } else {
                countdownTextSize = 0.43f * scale;
            }
            ExperimentViewComponentKt.getCountdownView($this$showSkipButton).setTextSize(0, countdownTextSize);
            if (ExtSplashOrderKt.isSkipDefault($this$showSkipButton.getSplash$adsplash_debug())) {
                final View $this$doOnPreDraw$iv = ExperimentViewComponentKt.getCountdownView($this$showSkipButton);
                OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.CountdownComponentKt$showSkipButton$$inlined$doOnPreDraw$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        View v = $this$doOnPreDraw$iv;
                        int leftRight = ListExtentionsKt.toPx(12);
                        int topBottom = ListExtentionsKt.toPx($this$showSkipButton.getResources().getDimension(R.dimen.splash_skip_click_top_bottom));
                        Rect rect = new Rect(v.getLeft() - leftRight, v.getTop() - topBottom, v.getRight() + leftRight, v.getBottom() + topBottom);
                        ViewParent parent = ExperimentViewComponentKt.getCountdownView($this$showSkipButton).getParent();
                        View view = parent instanceof View ? (View) parent : null;
                        if (view != null) {
                            view.setTouchDelegate(new TouchDelegate(rect, v));
                        }
                    }
                });
            }
            final Ref.BooleanRef skipButtonClicked = new Ref.BooleanRef();
            ExperimentViewComponentKt.getCountdownView($this$showSkipButton).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.component.CountdownComponentKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CountdownComponentKt.showSkipButton$lambda$3(skipButtonClicked, $this$showSkipButton, view);
                }
            });
            ForegroundColorSpan skipTextColorSpan = new ForegroundColorSpan(ExperimentViewComponentKt.getSkipTextColor($this$showSkipButton));
            SpannableString skipSS = new SpannableString($this$showSkipButton.getResources().getString(bili.resource.common.R.string.common_global_string_144));
            skipSS.setSpan(skipTextColorSpan, 0, skipSS.length(), 33);
            $this$showSkipButton.getComponentHolder$adsplash_debug().setSkipSS(skipSS);
            ForegroundColorSpan countdownTextColorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, ExperimentViewComponentKt.getSkipNumberColorRes($this$showSkipButton)));
            $this$showSkipButton.getComponentHolder$adsplash_debug().setCountdownTextColorSpan(countdownTextColorSpan);
            SpannableString countdownSS = new SpannableString(String.valueOf($this$showSkipButton.getSplash$adsplash_debug().getDuration()));
            $this$showSkipButton.getComponentHolder$adsplash_debug().setCountdownSS(countdownSS);
            countdownSS.setSpan(countdownTextColorSpan, 0, countdownSS.length(), 33);
            SpannableStringBuilder content = new SpannableStringBuilder();
            content.append((CharSequence) skipSS).append((CharSequence) " ").append((CharSequence) countdownSS);
            ExperimentViewComponentKt.getCountdownView($this$showSkipButton).setText(content);
            BLog.i(TAG, "count down text = " + ((Object) content));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSkipButton$lambda$3(Ref.BooleanRef $skipButtonClicked, BaseSplash $this_showSkipButton, View it) {
        if ($skipButtonClicked.element) {
            return;
        }
        $skipButtonClicked.element = true;
        $this_showSkipButton.getViewModel$adsplash_debug().update(new SplashSkipClickEvent(null, 1, null));
        BLog.i(TAG, "showSkipButton, skip clicked");
        SplashCoreService splashCoreService = $this_showSkipButton.getComponentHolder$adsplash_debug().getSplashCoreService();
        if (splashCoreService != null) {
            splashCoreService.setSplashDurationSession(StatisticComponentKt.calculateSplashRealDuration($this_showSkipButton));
        }
        SplashCustomReporterKt.reportSkipClick($this_showSkipButton.getSplash$adsplash_debug());
        SplashAdHelper.INSTANCE.adSplashSkip$adsplash_debug($this_showSkipButton.getSplash$adsplash_debug(), StatisticComponentKt.calculateExposeTimeWhenSkip($this_showSkipButton));
        if (ExtSplashOrderKt.isSearchLinkage($this_showSkipButton.getSplash$adsplash_debug())) {
            SplashAdHelper.INSTANCE.reportSplashDefaultWordExpose$adsplash_debug($this_showSkipButton.getSplash$adsplash_debug(), 3);
        }
        $this_showSkipButton.onSkipClick();
    }

    public static final void startCountDown(BaseSplash $this$startCountDown) {
        Intrinsics.checkNotNullParameter($this$startCountDown, "<this>");
        $this$startCountDown.getComponentHolder$adsplash_debug().setCountDownJob(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$startCountDown), Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new CountdownComponentKt$startCountDown$1($this$startCountDown, null), 2, (Object) null));
    }

    public static final void doStopCountdown(BaseSplash $this$doStopCountdown) {
        Job countDownJob;
        Intrinsics.checkNotNullParameter($this$doStopCountdown, "<this>");
        Job countDownJob2 = $this$doStopCountdown.getComponentHolder$adsplash_debug().getCountDownJob();
        boolean z = false;
        if (countDownJob2 != null && countDownJob2.isActive()) {
            z = true;
        }
        if (z && (countDownJob = $this$doStopCountdown.getComponentHolder$adsplash_debug().getCountDownJob()) != null) {
            Job.DefaultImpls.cancel$default(countDownJob, (CancellationException) null, 1, (Object) null);
        }
        $this$doStopCountdown.getComponentHolder$adsplash_debug().setCountDownJob(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCountdownText(BaseSplash $this$updateCountdownText, int leftTimeSecond) {
        SpannableString skipSS;
        ForegroundColorSpan countdownTextColorSpan;
        if ($this$updateCountdownText.getSplash$adsplash_debug().getSkip() != 1 || (skipSS = $this$updateCountdownText.getComponentHolder$adsplash_debug().getSkipSS()) == null || (countdownTextColorSpan = $this$updateCountdownText.getComponentHolder$adsplash_debug().getCountdownTextColorSpan()) == null) {
            return;
        }
        SpannableString countdownSS = new SpannableString(String.valueOf(leftTimeSecond));
        $this$updateCountdownText.getComponentHolder$adsplash_debug().setCountdownSS(countdownSS);
        SpannableString countdownSS2 = $this$updateCountdownText.getComponentHolder$adsplash_debug().getCountdownSS();
        if (countdownSS2 != null) {
            countdownSS2.setSpan(countdownTextColorSpan, 0, countdownSS.length(), 33);
        }
        SpannableStringBuilder content = new SpannableStringBuilder().append((CharSequence) skipSS).append((CharSequence) " ").append((CharSequence) countdownSS);
        ExperimentViewComponentKt.getCountdownView($this$updateCountdownText).setText(content);
    }
}