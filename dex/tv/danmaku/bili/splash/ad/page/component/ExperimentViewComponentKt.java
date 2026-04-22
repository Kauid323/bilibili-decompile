package tv.danmaku.bili.splash.ad.page.component;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;

/* compiled from: ExperimentViewComponent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\"\u0018\u0010\r\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n\"\u0018\u0010\u000f\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n\"\u0018\u0010\u0011\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"countdownView", "Landroid/widget/TextView;", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "getCountdownView", "(Ltv/danmaku/bili/splash/ad/page/BaseSplash;)Landroid/widget/TextView;", "adLabelView", "getAdLabelView", "bottomLogoHeight", "", "getBottomLogoHeight", "(Ltv/danmaku/bili/splash/ad/page/BaseSplash;)I", "skipButtonBg", "getSkipButtonBg", "skipTextColor", "getSkipTextColor", "skipNumberColorRes", "getSkipNumberColorRes", "logoLayoutBgColor", "getLogoLayoutBgColor", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ExperimentViewComponentKt {
    public static final TextView getCountdownView(BaseSplash $this$countdownView) {
        Intrinsics.checkNotNullParameter($this$countdownView, "<this>");
        if (ExtSplashOrderKt.isSkipDefault($this$countdownView.getSplash$adsplash_debug()) || ExtSplashOrderKt.isSkipSizeExp($this$countdownView.getSplash$adsplash_debug())) {
            TextView textView = $this$countdownView.getBinding$adsplash_debug().countDown;
            Intrinsics.checkNotNull(textView);
            return textView;
        }
        TextView textView2 = $this$countdownView.getBinding$adsplash_debug().countDown2;
        Intrinsics.checkNotNull(textView2);
        return textView2;
    }

    public static final TextView getAdLabelView(BaseSplash $this$adLabelView) {
        Intrinsics.checkNotNullParameter($this$adLabelView, "<this>");
        if (ExtSplashOrderKt.isSkipDefault($this$adLabelView.getSplash$adsplash_debug()) || ExtSplashOrderKt.isSkipSizeExp($this$adLabelView.getSplash$adsplash_debug())) {
            LinearLayout linearLayout = $this$adLabelView.getBinding$adsplash_debug().labelLayout;
            ViewGroup.LayoutParams layoutParams = $this$adLabelView.getBinding$adsplash_debug().labelLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams2 != null) {
                ViewGroup.MarginLayoutParams $this$_get_adLabelView__u24lambda_u240 = marginLayoutParams2;
                $this$_get_adLabelView__u24lambda_u240.topMargin = StatusBarCompat.getStatusBarHeight($this$adLabelView.getBinding$adsplash_debug().getRoot().getContext()) + ListExtentionsKt.toPx(ExtSplashOrderKt.isSkipDefault($this$adLabelView.getSplash$adsplash_debug()) ? 12 : 16);
                marginLayoutParams = marginLayoutParams2;
            }
            linearLayout.setLayoutParams(marginLayoutParams);
            TextView textView = $this$adLabelView.getBinding$adsplash_debug().labelAd;
            Intrinsics.checkNotNull(textView);
            return textView;
        } else if (!ExtSplashOrderKt.isFullScreen($this$adLabelView.getSplash$adsplash_debug())) {
            TextView textView2 = $this$adLabelView.getBinding$adsplash_debug().labelAd2;
            Intrinsics.checkNotNullExpressionValue(textView2, "labelAd2");
            return textView2;
        } else {
            TextView textView3 = $this$adLabelView.getBinding$adsplash_debug().labelAd3;
            Intrinsics.checkNotNullExpressionValue(textView3, "labelAd3");
            return textView3;
        }
    }

    public static final int getBottomLogoHeight(BaseSplash $this$bottomLogoHeight) {
        Intrinsics.checkNotNullParameter($this$bottomLogoHeight, "<this>");
        return $this$bottomLogoHeight.getResources().getDisplayMetrics().heightPixels / 8;
    }

    public static final int getSkipButtonBg(BaseSplash $this$skipButtonBg) {
        Intrinsics.checkNotNullParameter($this$skipButtonBg, "<this>");
        return (ExtSplashOrderKt.isFullScreen($this$skipButtonBg.getSplash$adsplash_debug()) || $this$skipButtonBg.getSplash$adsplash_debug().getMarkWithSkipStyle() == 2) ? R.drawable.bili_app_list_splash_shape_roundrect_black40_r20 : R.drawable.bili_app_list_splash_shape_roundrect_r20_grayborder;
    }

    public static final int getSkipTextColor(BaseSplash $this$skipTextColor) {
        Intrinsics.checkNotNullParameter($this$skipTextColor, "<this>");
        return (ExtSplashOrderKt.isFullScreen($this$skipTextColor.getSplash$adsplash_debug()) || $this$skipTextColor.getSplash$adsplash_debug().getMarkWithSkipStyle() == 2) ? -1 : -6710887;
    }

    public static final int getSkipNumberColorRes(BaseSplash $this$skipNumberColorRes) {
        Intrinsics.checkNotNullParameter($this$skipNumberColorRes, "<this>");
        if (ExtSplashOrderKt.isFullScreen($this$skipNumberColorRes.getSplash$adsplash_debug()) || $this$skipNumberColorRes.getSplash$adsplash_debug().getMarkWithSkipStyle() == 2) {
            return 17170443;
        }
        return com.bilibili.app.comm.baseres.R.color.gray_dark;
    }

    public static final int getLogoLayoutBgColor(BaseSplash $this$logoLayoutBgColor) {
        Intrinsics.checkNotNullParameter($this$logoLayoutBgColor, "<this>");
        return ExtSplashOrderKt.isFullScreen($this$logoLayoutBgColor.getSplash$adsplash_debug()) ? 0 : -1;
    }
}