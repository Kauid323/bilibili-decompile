package tv.danmaku.bili.splash.ad.model;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.baseres.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;

/* compiled from: ExtSplashGuideButton.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b?\n\u0002\u0010\"\n\u0002\b\u0003\u001a\u001e\u0010\u000e\u001a\u00020\t*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\tH\u0000\u001a\u0016\u0010\u001c\u001a\u00020\t*\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\tH\u0000\u001a\u001a\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a\u0014\u0010+\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u0014\u00101\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u0014\u00104\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u0014\u0010=\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u0014\u0010@\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u0014\u0010E\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u0014\u0010F\u001a\u00020\u0003*\u00020\u00042\u0006\u0010,\u001a\u00020\u0003H\u0000\u001a\u000e\u0010Q\u001a\u00020\u0003*\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\f\u001a\u00020\t*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0016\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0018\u0010\u0018\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0018\u0010\u001a\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0018\u0010\u001d\u001a\u00020\t*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b\"\u0018\u0010\u001f\u001a\u00020\t*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000b\"\u0018\u0010!\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015\"\u0018\u0010#\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0015\"\u0018\u0010'\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005\"\u0018\u0010)\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0005\"\u0018\u0010-\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0005\"\u0018\u0010/\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0005\"\u0018\u00102\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0005\"\u0018\u00105\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0005\"\u0018\u00107\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0005\"\u0018\u00109\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0005\"\u0018\u0010;\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0005\"\u0018\u0010>\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0005\"\u0018\u0010A\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0005\"\u0018\u0010C\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0005\"\u0018\u0010G\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0005\"\u0018\u0010I\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\"\u0018\u0010K\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0005\"\u0018\u0010M\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0005\"\u0018\u0010E\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0005\"\u0018\u0010F\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0005\" \u0010R\u001a\b\u0012\u0004\u0012\u00020\u00010S*\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006V"}, d2 = {"TAG", "", "isCountDownValid", "", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "(Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;)Z", "disableOtherInteractWhenDowngrade", "getDisableOtherInteractWhenDowngrade", "getTextColor", "", "getGetTextColor", "(Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;)I", "getSubTextColor", "getGetSubTextColor", "getBgColor", "ctx", "Landroid/content/Context;", "def", "getXPercent", "", "getGetXPercent", "(Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;)F", "getYPercent", "getGetYPercent", "getWidthPercent", "getGetWidthPercent", "getHeightPercent", "getGetHeightPercent", "getBorderColor", "getSlideHoleBgColor", "getGetSlideHoleBgColor", "getSlideHoleBorderColor", "getGetSlideHoleBorderColor", "getThresholdPercent", "getGetThresholdPercent", "getExpandRatioPercent", "getGetExpandRatioPercent", "parseColorOrDefault", GarbJsBridgeCallHandlerKt.PURE_THEME, "hitSlideStyle", "getHitSlideStyle", "hitSlideCheckStyleOnly", "getHitSlideCheckStyleOnly", "hitImageStyle", "jumpThird", "hitImageCheckStyleOnly", "getHitImageCheckStyleOnly", "hitTextViewStyle", "getHitTextViewStyle", "hitShakeStyle", "hitShakeCheckStyleOnly", "getHitShakeCheckStyleOnly", "hitTwistStyle", "hitTwistStyleOnly", "getHitTwistStyleOnly", "hitShakeNormalCheckStyleOnly", "getHitShakeNormalCheckStyleOnly", "hitShakeClickCheckStyleOnly", "getHitShakeClickCheckStyleOnly", "hitNoInteractViewCheckStyleOnly", "getHitNoInteractViewCheckStyleOnly", "hitNoInteractLottieView", "hitCountDownStyleCheckStyleOnly", "getHitCountDownStyleCheckStyleOnly", "hitCountDownStyle", "hitRunningBallStyle", "getHitRunningBallStyle", "hitRunningBallStyleOnly", "getHitRunningBallStyleOnly", "hitWebpTwistStyle", "hitWebpSlideStyle", "hitBrandRotateCardStyle", "getHitBrandRotateCardStyle", "hitShopCardClickStyle", "getHitShopCardClickStyle", "hitShopCardTwistStyle", "getHitShopCardTwistStyle", "hitCountdownStyleV2", "getHitCountdownStyleV2", "getHitWebpTwistStyle", "getHitWebpSlideStyle", "isValidSecondPageButtonType", "allResHashSet", "", "getAllResHashSet", "(Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;)Ljava/util/Set;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ExtSplashGuideButtonKt {
    private static final String TAG = "[Splash]SplashGuideButton";

    public static final boolean isCountDownValid(SplashGuideButton $this$isCountDownValid) {
        Intrinsics.checkNotNullParameter($this$isCountDownValid, "<this>");
        if ($this$isCountDownValid.getActivityTime() <= 0 || $this$isCountDownValid.getActivityTime() - (System.currentTimeMillis() / 1000) <= 0) {
            return false;
        }
        int timeShowType = $this$isCountDownValid.getTimeShowType();
        return timeShowType >= 0 && timeShowType < 4;
    }

    public static final boolean getDisableOtherInteractWhenDowngrade(SplashGuideButton $this$disableOtherInteractWhenDowngrade) {
        Intrinsics.checkNotNullParameter($this$disableOtherInteractWhenDowngrade, "<this>");
        return $this$disableOtherInteractWhenDowngrade.getDegradeType() == 1;
    }

    public static final int getGetTextColor(SplashGuideButton $this$getTextColor) {
        Intrinsics.checkNotNullParameter($this$getTextColor, "<this>");
        return parseColorOrDefault($this$getTextColor.getTextColor(), -1);
    }

    public static final int getGetSubTextColor(SplashGuideButton $this$getSubTextColor) {
        Intrinsics.checkNotNullParameter($this$getSubTextColor, "<this>");
        return parseColorOrDefault($this$getSubTextColor.getSecondaryTextColor(), -1);
    }

    public static /* synthetic */ int getBgColor$default(SplashGuideButton splashGuideButton, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ContextCompat.getColor(context, R.color.black_alpha50);
        }
        return getBgColor(splashGuideButton, context, i);
    }

    public static final int getBgColor(SplashGuideButton $this$getBgColor, Context ctx, int def) {
        Intrinsics.checkNotNullParameter($this$getBgColor, "<this>");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return parseColorOrDefault($this$getBgColor.getBgColor(), def);
    }

    public static final float getGetXPercent(SplashGuideButton $this$getXPercent) {
        Intrinsics.checkNotNullParameter($this$getXPercent, "<this>");
        return $this$getXPercent.getX() / 100.0f;
    }

    public static final float getGetYPercent(SplashGuideButton $this$getYPercent) {
        Intrinsics.checkNotNullParameter($this$getYPercent, "<this>");
        return $this$getYPercent.getY() / 100.0f;
    }

    public static final float getGetWidthPercent(SplashGuideButton $this$getWidthPercent) {
        Intrinsics.checkNotNullParameter($this$getWidthPercent, "<this>");
        return $this$getWidthPercent.getWidth() / 100.0f;
    }

    public static final float getGetHeightPercent(SplashGuideButton $this$getHeightPercent) {
        Intrinsics.checkNotNullParameter($this$getHeightPercent, "<this>");
        return $this$getHeightPercent.getHeight() / 100.0f;
    }

    public static final int getBorderColor(SplashGuideButton $this$getBorderColor, int def) {
        Intrinsics.checkNotNullParameter($this$getBorderColor, "<this>");
        return parseColorOrDefault($this$getBorderColor.getSideBorderColor(), def);
    }

    public static /* synthetic */ int getBorderColor$default(SplashGuideButton splashGuideButton, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Color.parseColor("#4DFFFFFF");
        }
        return getBorderColor(splashGuideButton, i);
    }

    public static final int getGetSlideHoleBgColor(SplashGuideButton $this$getSlideHoleBgColor) {
        Intrinsics.checkNotNullParameter($this$getSlideHoleBgColor, "<this>");
        return parseColorOrDefault($this$getSlideHoleBgColor.getSideHoleBgColor(), 0);
    }

    public static final int getGetSlideHoleBorderColor(SplashGuideButton $this$getSlideHoleBorderColor) {
        Intrinsics.checkNotNullParameter($this$getSlideHoleBorderColor, "<this>");
        return parseColorOrDefault($this$getSlideHoleBorderColor.getSideHoleBorderColor(), Color.parseColor("#66FFFFFF"));
    }

    public static final float getGetThresholdPercent(SplashGuideButton $this$getThresholdPercent) {
        Intrinsics.checkNotNullParameter($this$getThresholdPercent, "<this>");
        return $this$getThresholdPercent.getSlideThreshold() / 100.0f;
    }

    public static final float getGetExpandRatioPercent(SplashGuideButton $this$getExpandRatioPercent) {
        Intrinsics.checkNotNullParameter($this$getExpandRatioPercent, "<this>");
        return $this$getExpandRatioPercent.getExpandRatio() / 100.0f;
    }

    private static final int parseColorOrDefault(String color, int def) {
        if (color == null) {
            return def;
        }
        try {
            return Color.parseColor(color);
        } catch (Throwable th) {
            return def;
        }
    }

    public static final boolean getHitSlideStyle(SplashGuideButton $this$hitSlideStyle) {
        Intrinsics.checkNotNullParameter($this$hitSlideStyle, "<this>");
        return ($this$hitSlideStyle.getInteractStyle() == 1 || $this$hitSlideStyle.getInteractStyle() == 2) && BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitSlideStyle.getLogoImageMD5());
    }

    public static final boolean getHitSlideCheckStyleOnly(SplashGuideButton $this$hitSlideCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitSlideCheckStyleOnly, "<this>");
        return $this$hitSlideCheckStyleOnly.getInteractStyle() == 1 || $this$hitSlideCheckStyleOnly.getInteractStyle() == 2;
    }

    public static final boolean hitImageStyle(SplashGuideButton $this$hitImageStyle, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitImageStyle, "<this>");
        if ($this$hitImageStyle.getInteractStyle() != 0) {
            return false;
        }
        $this$hitImageStyle.setActualUsedImageUrl(jumpThird ? $this$hitImageStyle.getSchemaImageUrl() : $this$hitImageStyle.getJumpImageUrl());
        $this$hitImageStyle.setActualUsedImageHash(jumpThird ? $this$hitImageStyle.getSchemaImageMD5() : $this$hitImageStyle.getJumpImageMD5());
        BLog.d(TAG, "hitImageStyle jumpThird = " + jumpThird + ", actualImage = " + $this$hitImageStyle.getActualUsedImageUrl());
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitImageStyle.getActualUsedImageHash());
    }

    public static final boolean getHitImageCheckStyleOnly(SplashGuideButton $this$hitImageCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitImageCheckStyleOnly, "<this>");
        return $this$hitImageCheckStyleOnly.getInteractStyle() == 0;
    }

    public static final boolean getHitTextViewStyle(SplashGuideButton $this$hitTextViewStyle) {
        Intrinsics.checkNotNullParameter($this$hitTextViewStyle, "<this>");
        return $this$hitTextViewStyle.getInteractStyle() == 3;
    }

    public static final boolean hitShakeStyle(SplashGuideButton $this$hitShakeStyle, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitShakeStyle, "<this>");
        if ($this$hitShakeStyle.getInteractStyle() != 4 && $this$hitShakeStyle.getInteractStyle() != 5) {
            return false;
        }
        $this$hitShakeStyle.setActualUsedImageUrl(jumpThird ? $this$hitShakeStyle.getSchemaImageUrl() : $this$hitShakeStyle.getJumpImageUrl());
        $this$hitShakeStyle.setActualUsedImageHash(jumpThird ? $this$hitShakeStyle.getSchemaImageMD5() : $this$hitShakeStyle.getJumpImageMD5());
        BLog.d(TAG, "hitShakeStyle jumpThird = " + jumpThird + ", actualImage = " + $this$hitShakeStyle.getActualUsedImageUrl());
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitShakeStyle.getActualUsedImageHash());
    }

    public static final boolean getHitShakeCheckStyleOnly(SplashGuideButton $this$hitShakeCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitShakeCheckStyleOnly, "<this>");
        return getHitShakeNormalCheckStyleOnly($this$hitShakeCheckStyleOnly) || getHitShakeClickCheckStyleOnly($this$hitShakeCheckStyleOnly);
    }

    public static final boolean hitTwistStyle(SplashGuideButton $this$hitTwistStyle, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitTwistStyle, "<this>");
        if ($this$hitTwistStyle.getInteractStyle() != 7) {
            return false;
        }
        $this$hitTwistStyle.setActualUsedImageUrl(jumpThird ? $this$hitTwistStyle.getSchemaImageUrl() : $this$hitTwistStyle.getJumpImageUrl());
        $this$hitTwistStyle.setActualUsedImageHash(jumpThird ? $this$hitTwistStyle.getSchemaImageMD5() : $this$hitTwistStyle.getJumpImageMD5());
        BLog.d(TAG, "hitTwistStyle jumpThird = " + jumpThird + ",imageurl = " + $this$hitTwistStyle.getActualUsedImageUrl());
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitTwistStyle.getActualUsedImageHash());
    }

    public static final boolean getHitTwistStyleOnly(SplashGuideButton $this$hitTwistStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitTwistStyleOnly, "<this>");
        return $this$hitTwistStyleOnly.getInteractStyle() == 7;
    }

    public static final boolean getHitShakeNormalCheckStyleOnly(SplashGuideButton $this$hitShakeNormalCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitShakeNormalCheckStyleOnly, "<this>");
        return $this$hitShakeNormalCheckStyleOnly.getInteractStyle() == 4;
    }

    public static final boolean getHitShakeClickCheckStyleOnly(SplashGuideButton $this$hitShakeClickCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitShakeClickCheckStyleOnly, "<this>");
        return $this$hitShakeClickCheckStyleOnly.getInteractStyle() == 5;
    }

    public static final boolean getHitNoInteractViewCheckStyleOnly(SplashGuideButton $this$hitNoInteractViewCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitNoInteractViewCheckStyleOnly, "<this>");
        return $this$hitNoInteractViewCheckStyleOnly.getInteractStyle() == 6;
    }

    public static final boolean hitNoInteractLottieView(SplashGuideButton $this$hitNoInteractLottieView, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitNoInteractLottieView, "<this>");
        $this$hitNoInteractLottieView.setActualUsedImageUrl(jumpThird ? $this$hitNoInteractLottieView.getSchemaImageUrl() : $this$hitNoInteractLottieView.getJumpImageUrl());
        $this$hitNoInteractLottieView.setActualUsedImageHash(jumpThird ? $this$hitNoInteractLottieView.getSchemaImageMD5() : $this$hitNoInteractLottieView.getJumpImageMD5());
        return $this$hitNoInteractLottieView.getInteractStyle() == 6 && BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitNoInteractLottieView.getActualUsedImageHash());
    }

    public static final boolean getHitCountDownStyleCheckStyleOnly(SplashGuideButton $this$hitCountDownStyleCheckStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitCountDownStyleCheckStyleOnly, "<this>");
        return $this$hitCountDownStyleCheckStyleOnly.getInteractStyle() == 9;
    }

    public static final boolean hitCountDownStyle(SplashGuideButton $this$hitCountDownStyle, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitCountDownStyle, "<this>");
        $this$hitCountDownStyle.setActualUsedImageUrl(jumpThird ? $this$hitCountDownStyle.getSchemaImageUrl() : $this$hitCountDownStyle.getJumpImageUrl());
        $this$hitCountDownStyle.setActualUsedImageHash(jumpThird ? $this$hitCountDownStyle.getSchemaImageMD5() : $this$hitCountDownStyle.getJumpImageMD5());
        return $this$hitCountDownStyle.getInteractStyle() == 9;
    }

    public static final boolean getHitRunningBallStyle(SplashGuideButton $this$hitRunningBallStyle) {
        Intrinsics.checkNotNullParameter($this$hitRunningBallStyle, "<this>");
        if ($this$hitRunningBallStyle.getInteractStyle() != 10) {
            return false;
        }
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitRunningBallStyle.getLogoImageMD5());
    }

    public static final boolean getHitRunningBallStyleOnly(SplashGuideButton $this$hitRunningBallStyleOnly) {
        Intrinsics.checkNotNullParameter($this$hitRunningBallStyleOnly, "<this>");
        return $this$hitRunningBallStyleOnly.getInteractStyle() == 10;
    }

    public static final boolean hitWebpTwistStyle(SplashGuideButton $this$hitWebpTwistStyle, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitWebpTwistStyle, "<this>");
        if ($this$hitWebpTwistStyle.getInteractStyle() != 17) {
            return false;
        }
        $this$hitWebpTwistStyle.setActualUsedImageUrl(jumpThird ? $this$hitWebpTwistStyle.getSchemaImageUrl() : $this$hitWebpTwistStyle.getJumpImageUrl());
        $this$hitWebpTwistStyle.setActualUsedImageHash(jumpThird ? $this$hitWebpTwistStyle.getSchemaImageMD5() : $this$hitWebpTwistStyle.getJumpImageMD5());
        BLog.d(TAG, "hitWebpTwistStyle jumpThird = " + jumpThird + ",imageurl = " + $this$hitWebpTwistStyle.getActualUsedImageUrl());
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitWebpTwistStyle.getActualUsedImageHash());
    }

    public static final boolean hitWebpSlideStyle(SplashGuideButton $this$hitWebpSlideStyle, boolean jumpThird) {
        Intrinsics.checkNotNullParameter($this$hitWebpSlideStyle, "<this>");
        if ($this$hitWebpSlideStyle.getInteractStyle() != 18) {
            return false;
        }
        $this$hitWebpSlideStyle.setActualUsedImageUrl(jumpThird ? $this$hitWebpSlideStyle.getSchemaImageUrl() : $this$hitWebpSlideStyle.getJumpImageUrl());
        $this$hitWebpSlideStyle.setActualUsedImageHash(jumpThird ? $this$hitWebpSlideStyle.getSchemaImageMD5() : $this$hitWebpSlideStyle.getJumpImageMD5());
        BLog.d(TAG, "hitWebpSlideStyle jumpThird = " + jumpThird + ",imageurl = " + $this$hitWebpSlideStyle.getActualUsedImageUrl());
        return BusinessSplashResHelper.INSTANCE.isResourceExistByHash($this$hitWebpSlideStyle.getActualUsedImageHash());
    }

    public static final boolean getHitBrandRotateCardStyle(SplashGuideButton $this$hitBrandRotateCardStyle) {
        Intrinsics.checkNotNullParameter($this$hitBrandRotateCardStyle, "<this>");
        return $this$hitBrandRotateCardStyle.getInteractStyle() == 12 || $this$hitBrandRotateCardStyle.getInteractStyle() == 13;
    }

    public static final boolean getHitShopCardClickStyle(SplashGuideButton $this$hitShopCardClickStyle) {
        List cardList;
        Iterable $this$any$iv;
        SplashShopCard it;
        Intrinsics.checkNotNullParameter($this$hitShopCardClickStyle, "<this>");
        if ($this$hitShopCardClickStyle.getInteractStyle() == 22 && (cardList = $this$hitShopCardClickStyle.getShopCards()) != null) {
            if (cardList.size() == 2 || cardList.size() == 3) {
                List $this$any$iv2 = cardList;
                if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
                    Iterator<T> it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv = it2.next();
                            SplashShopCard it3 = (SplashShopCard) element$iv;
                            if (BusinessSplashResHelperKt.getMd5ToFile(it3.getImageHash()) == null) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                $this$any$iv = 1;
                                break;
                            }
                        } else {
                            $this$any$iv = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                return $this$any$iv == null;
            }
            return false;
        }
        return false;
    }

    public static final boolean getHitShopCardTwistStyle(SplashGuideButton $this$hitShopCardTwistStyle) {
        List cardList;
        Iterable $this$any$iv;
        SplashShopCard it;
        Intrinsics.checkNotNullParameter($this$hitShopCardTwistStyle, "<this>");
        if ($this$hitShopCardTwistStyle.getInteractStyle() == 21 && (cardList = $this$hitShopCardTwistStyle.getShopCards()) != null) {
            if (cardList.size() == 2 || cardList.size() == 3) {
                List $this$any$iv2 = cardList;
                if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
                    Iterator<T> it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv = it2.next();
                            SplashShopCard it3 = (SplashShopCard) element$iv;
                            if (BusinessSplashResHelperKt.getMd5ToFile(it3.getImageHash()) == null) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                $this$any$iv = 1;
                                break;
                            }
                        } else {
                            $this$any$iv = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                return $this$any$iv == null;
            }
            return false;
        }
        return false;
    }

    public static final boolean getHitCountdownStyleV2(SplashGuideButton $this$hitCountdownStyleV2) {
        Intrinsics.checkNotNullParameter($this$hitCountdownStyleV2, "<this>");
        return $this$hitCountdownStyleV2.getInteractStyle() == 14;
    }

    public static final boolean getHitWebpTwistStyle(SplashGuideButton $this$hitWebpTwistStyle) {
        Intrinsics.checkNotNullParameter($this$hitWebpTwistStyle, "<this>");
        return $this$hitWebpTwistStyle.getInteractStyle() == 17;
    }

    public static final boolean getHitWebpSlideStyle(SplashGuideButton $this$hitWebpSlideStyle) {
        Intrinsics.checkNotNullParameter($this$hitWebpSlideStyle, "<this>");
        return $this$hitWebpSlideStyle.getInteractStyle() == 18;
    }

    public static final boolean isValidSecondPageButtonType(SplashGuideButton $this$isValidSecondPageButtonType) {
        if ($this$isValidSecondPageButtonType == null) {
            return false;
        }
        return $this$isValidSecondPageButtonType.getInteractStyle() == 6 || $this$isValidSecondPageButtonType.getInteractStyle() == 3;
    }

    public static final Set<String> getAllResHashSet(SplashGuideButton $this$allResHashSet) {
        Set sets = new LinkedHashSet();
        if ($this$allResHashSet == null) {
            return SetsKt.emptySet();
        }
        String it = $this$allResHashSet.getLogoImageMD5();
        String str = it;
        if (str == null || StringsKt.isBlank(str)) {
            it = null;
        }
        if (it != null) {
            sets.add(it);
        }
        String it2 = $this$allResHashSet.getGuideImageMD5();
        String str2 = it2;
        if (str2 == null || StringsKt.isBlank(str2)) {
            it2 = null;
        }
        if (it2 != null) {
            sets.add(it2);
        }
        String it3 = $this$allResHashSet.getJumpImageMD5();
        String str3 = it3;
        if (str3 == null || StringsKt.isBlank(str3)) {
            it3 = null;
        }
        if (it3 != null) {
            sets.add(it3);
        }
        String it4 = $this$allResHashSet.getSchemaImageMD5();
        String str4 = it4;
        String it5 = str4 == null || StringsKt.isBlank(str4) ? null : it4;
        if (it5 != null) {
            sets.add(it5);
        }
        List $this$fastForEach$iv = $this$allResHashSet.getShopCards();
        if ($this$fastForEach$iv != null) {
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                SplashShopCard card = (SplashShopCard) item$iv;
                String imageHash = card.getImageHash();
                if (!(imageHash == null || StringsKt.isBlank(imageHash))) {
                    sets.add(card.getImageHash());
                }
            }
        }
        return sets;
    }
}