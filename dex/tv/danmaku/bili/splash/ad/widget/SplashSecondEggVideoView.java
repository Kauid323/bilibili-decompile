package tv.danmaku.bili.splash.ad.widget;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.FeedExtra;
import com.bilibili.adcommon.utils.AdRouters;
import com.bilibili.adcommon.utils.Base64Util;
import com.bilibili.adcommon.utils.ext.JSONObjectCreator;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdReport;
import com.bilibili.gripper.api.ad.core.report.ReportPresetKt;
import com.bilibili.gripper.api.ad.core.web.IWebPreload;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashGuideButtonKt;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashSecondEggVideoView.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0001\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0007J\u0014\u0010#\u001a\u00020\u0007*\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashSecondEggVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eggPlayer", "Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;", "viewMask", "Landroid/view/View;", "completeListener", "Lkotlin/Function0;", "", "getCompleteListener", "()Lkotlin/jvm/functions/Function0;", "setCompleteListener", "(Lkotlin/jvm/functions/Function0;)V", "addViewMask", "setSplashSecondPageEggVideoPlayer", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "secondEggVideoView", "onFirstFrameStartRender", "startViewMaskAnim", "preloadAdWeb", "setButtons", "buttons", "", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "width", "height", "withAlpha", "alphaPercentage", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSecondEggVideoView extends FrameLayout {
    public static final int $stable = 8;
    private Function0<Unit> completeListener;
    private SplashAlphaPlayer eggPlayer;
    private View viewMask;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashSecondEggVideoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashSecondEggVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashSecondEggVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.completeListener = new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        addViewMask();
        setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashSecondEggVideoView._init_$lambda$0(view);
            }
        });
    }

    public /* synthetic */ SplashSecondEggVideoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final Function0<Unit> getCompleteListener() {
        return this.completeListener;
    }

    public final void setCompleteListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.completeListener = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View it) {
    }

    private final void addViewMask() {
        this.viewMask = new View(getContext());
        View view = this.viewMask;
        if (view != null) {
            view.setLayoutParams(SplashLayoutUtilsKt.createMatchParentLayoutParams(this));
        }
        View view2 = this.viewMask;
        if (view2 != null) {
            view2.setBackgroundColor(-16777216);
        }
        View view3 = this.viewMask;
        if (view3 != null) {
            view3.setAlpha(0.0f);
        }
        addView(this.viewMask, 0);
    }

    public final void setSplashSecondPageEggVideoPlayer(final SplashOrder splash, SplashAlphaPlayer secondEggVideoView) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        if (secondEggVideoView == null) {
            this.completeListener.invoke();
        }
        this.eggPlayer = secondEggVideoView;
        SplashAlphaPlayer $this$setSplashSecondPageEggVideoPlayer_u24lambda_u240 = this.eggPlayer;
        if ($this$setSplashSecondPageEggVideoPlayer_u24lambda_u240 != null) {
            $this$setSplashSecondPageEggVideoPlayer_u24lambda_u240.setLayoutParams(SplashLayoutUtilsKt.createMatchParentLayoutParams(this));
            $this$setSplashSecondPageEggVideoPlayer_u24lambda_u240.setOnCompletionListener(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit splashSecondPageEggVideoPlayer$lambda$0$0;
                    splashSecondPageEggVideoPlayer$lambda$0$0 = SplashSecondEggVideoView.setSplashSecondPageEggVideoPlayer$lambda$0$0(SplashSecondEggVideoView.this);
                    return splashSecondPageEggVideoPlayer$lambda$0$0;
                }
            });
            $this$setSplashSecondPageEggVideoPlayer_u24lambda_u240.setOnSurfaceTextureDestroyedListener(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit splashSecondPageEggVideoPlayer$lambda$0$1;
                    splashSecondPageEggVideoPlayer$lambda$0$1 = SplashSecondEggVideoView.setSplashSecondPageEggVideoPlayer$lambda$0$1(SplashSecondEggVideoView.this, splash);
                    return splashSecondPageEggVideoPlayer$lambda$0$1;
                }
            });
            $this$setSplashSecondPageEggVideoPlayer_u24lambda_u240.setOnError(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit splashSecondPageEggVideoPlayer$lambda$0$2;
                    splashSecondPageEggVideoPlayer$lambda$0$2 = SplashSecondEggVideoView.setSplashSecondPageEggVideoPlayer$lambda$0$2(SplashOrder.this, this);
                    return splashSecondPageEggVideoPlayer$lambda$0$2;
                }
            });
        }
        boolean z = true;
        addView((View) this.eggPlayer, 1);
        SplashAlphaPlayer splashAlphaPlayer = this.eggPlayer;
        if (splashAlphaPlayer == null || !splashAlphaPlayer.getFirstFrameHasRender()) {
            z = false;
        }
        if (z) {
            onFirstFrameStartRender(splash);
            return;
        }
        SplashAlphaPlayer splashAlphaPlayer2 = this.eggPlayer;
        if (splashAlphaPlayer2 != null) {
            splashAlphaPlayer2.setOnFirstFrameRenderingStart(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit splashSecondPageEggVideoPlayer$lambda$1;
                    splashSecondPageEggVideoPlayer$lambda$1 = SplashSecondEggVideoView.setSplashSecondPageEggVideoPlayer$lambda$1(SplashSecondEggVideoView.this, splash);
                    return splashSecondPageEggVideoPlayer$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSplashSecondPageEggVideoPlayer$lambda$0$0(SplashSecondEggVideoView this$0) {
        this$0.completeListener.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSplashSecondPageEggVideoPlayer$lambda$0$1(SplashSecondEggVideoView this$0, SplashOrder $splash) {
        Number number;
        SplashAlphaPlayer splashAlphaPlayer = this$0.eggPlayer;
        Number $this$orZero$iv = splashAlphaPlayer != null ? Long.valueOf(splashAlphaPlayer.getCurrentPlayTime()) : null;
        if ($this$orZero$iv != null) {
            number = $this$orZero$iv;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                number = (Long) (byte) 0;
            }
        }
        final long showTime = number.longValue();
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo($splash);
        gAdReport.uiEvent("splash_click_egg_close", ReportPresetKt.toReportPreset(adInfo != null ? adInfo.getReportInfo() : null), new Function1() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit splashSecondPageEggVideoPlayer$lambda$0$1$0;
                splashSecondPageEggVideoPlayer$lambda$0$1$0 = SplashSecondEggVideoView.setSplashSecondPageEggVideoPlayer$lambda$0$1$0(showTime, (JSONObjectCreator) obj);
                return splashSecondPageEggVideoPlayer$lambda$0$1$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSplashSecondPageEggVideoPlayer$lambda$0$1$0(long $showTime, JSONObjectCreator $this$uiEvent) {
        Intrinsics.checkNotNullParameter($this$uiEvent, "$this$uiEvent");
        $this$uiEvent.to("show_time", Long.valueOf($showTime));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSplashSecondPageEggVideoPlayer$lambda$0$2(SplashOrder $splash, SplashSecondEggVideoView this$0) {
        SplashAdHelper.INSTANCE.reportSplashSecondPageEggShowFail($splash, 3);
        this$0.completeListener.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSplashSecondPageEggVideoPlayer$lambda$1(SplashSecondEggVideoView this$0, SplashOrder $splash) {
        this$0.onFirstFrameStartRender($splash);
        return Unit.INSTANCE;
    }

    private final void onFirstFrameStartRender(SplashOrder splash) {
        preloadAdWeb(splash);
        SplashAlphaPlayer splashAlphaPlayer = this.eggPlayer;
        if (splashAlphaPlayer != null) {
            splashAlphaPlayer.play();
        }
        startViewMaskAnim();
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        gAdReport.uiEvent("splash_click_egg_show", ReportPresetKt.toReportPreset(adInfo != null ? adInfo.getReportInfo() : null));
    }

    private final void startViewMaskAnim() {
        View view = this.viewMask;
        ViewPropertyAnimator animator = view != null ? view.animate() : null;
        if (animator != null) {
            animator.alpha(0.7f);
        }
        if (animator != null) {
            animator.setDuration(1000L);
        }
        if (animator != null) {
            animator.start();
        }
    }

    private final void preloadAdWeb(SplashOrder splash) {
        String url;
        IClickInfo clickInfo;
        String realUrl;
        IAdReportInfo reportInfo;
        IClickInfo clickInfo2;
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        String jumpUrl = (adInfo == null || (clickInfo2 = adInfo.getClickInfo()) == null) ? null : clickInfo2.jumpUrl();
        if (jumpUrl == null || StringsKt.isBlank(jumpUrl)) {
            url = splash.getJumpUrl();
        } else {
            IAdInfo adInfo2 = ExtSplashOrderKt.adInfo(splash);
            url = (adInfo2 == null || (clickInfo = adInfo2.getClickInfo()) == null) ? null : clickInfo.jumpUrl();
        }
        if (url == null) {
            url = "";
        }
        if (AdRouters.INSTANCE.isRedirectUrl(url)) {
            String $this$toUri$iv = url;
            String it = Uri.parse($this$toUri$iv).getQueryParameter("jump_url");
            realUrl = it != null ? Base64Util.INSTANCE.base64Decode(it) : null;
        } else {
            realUrl = url;
        }
        IWebPreload gAdWeb = GAdCoreKt.getGAdWeb();
        Context context = getContext();
        IAdInfo adInfo3 = ExtSplashOrderKt.adInfo(splash);
        FeedExtra extra = (adInfo3 == null || (reportInfo = adInfo3.getReportInfo()) == null) ? null : reportInfo.getExtra();
        IAdInfo adInfo4 = ExtSplashOrderKt.adInfo(splash);
        IWebPreload.-CC.adWebPreloadForUrl$default(gAdWeb, context, extra, realUrl, adInfo4 != null ? adInfo4.getReportInfo() : null, (Function0) null, 16, (Object) null);
    }

    public final void setButtons(List<SplashGuideButton> list, int width, int height) {
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Intrinsics.checkNotNullParameter(list, "buttons");
        List<SplashGuideButton> $this$forEach$iv2 = list;
        int $i$f$forEach2 = 0;
        for (Object element$iv : $this$forEach$iv2) {
            SplashGuideButton button = (SplashGuideButton) element$iv;
            switch (button.getInteractStyle()) {
                case 19:
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    AccountInfo accountInfoFromCache = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
                    String userName = (accountInfoFromCache == null || (userName = accountInfoFromCache.getUserName()) == null) ? "" : "";
                    if (userName.length() == 0) {
                        break;
                    } else {
                        TextView userNameTv = new TextView(getContext());
                        userNameTv.setText("@" + userName);
                        userNameTv.setGravity(17);
                        userNameTv.setTextColor(ExtSplashGuideButtonKt.getGetTextColor(button));
                        userNameTv.setSingleLine();
                        int viewWidth = (int) (width * ExtSplashGuideButtonKt.getGetWidthPercent(button));
                        int viewHeight = (int) (height * ExtSplashGuideButtonKt.getGetHeightPercent(button));
                        float viewCenterX = width * ExtSplashGuideButtonKt.getGetXPercent(button);
                        float viewCenterY = height * ExtSplashGuideButtonKt.getGetYPercent(button);
                        FrameLayout.LayoutParams userNameLayoutParams = new FrameLayout.LayoutParams(viewWidth, viewHeight);
                        userNameTv.setX(viewCenterX - (viewWidth / 2));
                        userNameTv.setY(viewCenterY - (viewHeight / 2));
                        float mTextSize = viewHeight * button.getFontRatio();
                        userNameTv.setTextSize(0, mTextSize);
                        userNameTv.setLayoutParams(userNameLayoutParams);
                        addView(userNameTv);
                        break;
                    }
                    break;
                case 20:
                    TextView sloganTv = new TextView(getContext());
                    sloganTv.setText(button.getGuideInstructions());
                    int textColor = ExtSplashGuideButtonKt.getGetTextColor(button);
                    sloganTv.setShadowLayer(10.0f, 0.0f, 0.0f, withAlpha(textColor, 0.7f));
                    sloganTv.setGravity(17);
                    sloganTv.setTextColor(textColor);
                    sloganTv.setSingleLine();
                    sloganTv.setEllipsize(TextUtils.TruncateAt.END);
                    int viewWidth2 = (int) (width * ExtSplashGuideButtonKt.getGetWidthPercent(button));
                    int viewHeight2 = (int) (height * ExtSplashGuideButtonKt.getGetHeightPercent(button));
                    float viewCenterX2 = width * ExtSplashGuideButtonKt.getGetXPercent(button);
                    float viewCenterY2 = height * ExtSplashGuideButtonKt.getGetYPercent(button);
                    FrameLayout.LayoutParams userNameLayoutParams2 = new FrameLayout.LayoutParams(viewWidth2, viewHeight2);
                    $this$forEach$iv = $this$forEach$iv2;
                    sloganTv.setX(viewCenterX2 - (viewWidth2 / 2));
                    sloganTv.setY(viewCenterY2 - (viewHeight2 / 2));
                    float mTextSize2 = viewHeight2 * button.getFontRatio();
                    $i$f$forEach = $i$f$forEach2;
                    sloganTv.setTextSize(0, mTextSize2);
                    sloganTv.setLayoutParams(userNameLayoutParams2);
                    addView(sloganTv);
                    break;
                default:
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    break;
            }
            $this$forEach$iv2 = $this$forEach$iv;
            $i$f$forEach2 = $i$f$forEach;
        }
    }

    private final int withAlpha(int $this$withAlpha, float alphaPercentage) {
        int alpha = Math.round(((float) BR.hallCover) * alphaPercentage);
        int red = Color.red($this$withAlpha);
        int green = Color.green($this$withAlpha);
        int blue = Color.blue($this$withAlpha);
        return Color.argb(alpha, red, green, blue);
    }
}