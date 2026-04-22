package tv.danmaku.bili.ui.splash.ad.button.card;

import ComposableSingletons$CustomBottomSheetKt$;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashTwistBrandCardUiState;
import tv.danmaku.bili.ui.splash.ad.button.sensor.SplashRotateSensorHelperKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.utils.UiUtilsKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashButtonTwistBrandCard.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dH\u0003¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001f"}, d2 = {"TAG", "", "topBannerRadio", "", "topIconRadio", "bottomIconRadio", "miniButtonWidth", "", "buttonRadio", "buttonBg", "Landroidx/compose/ui/graphics/Color;", "J", "createSplashButtonTwistBrandCard", "Landroidx/compose/ui/platform/ComposeView;", "context", "Landroid/content/Context;", "screenWidth", "screenHeight", "buttonData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "listener", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "SplashButtonRotateBrandCard", "", "uiState", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashTwistBrandCardUiState;", "onCardClick", "Lkotlin/Function0;", "(Ltv/danmaku/bili/ui/splash/ad/button/model/SplashTwistBrandCardUiState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashButtonTwistBrandCardKt {
    private static final String TAG = "[Splash]SplashButtonTwistBrandCard";
    private static final float bottomIconRadio = 0.4262295f;
    private static final float buttonRadio = 2.5f;
    private static final float topBannerRadio = 0.40983605f;
    private static final float topIconRadio = 0.26229507f;
    private static final int miniButtonWidth = ListExtentionsKt.toPx(300);
    private static final long buttonBg = ColorKt.Color(3439329279L);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashButtonRotateBrandCard$lambda$4(SplashTwistBrandCardUiState splashTwistBrandCardUiState, Function0 function0, int i, int i2, Composer composer, int i3) {
        SplashButtonRotateBrandCard(splashTwistBrandCardUiState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ComposeView createSplashButtonTwistBrandCard(Context context, int screenWidth, int screenHeight, final SplashGuideButton buttonData, final Splash splash, final SplashButtonClickListener listener) {
        ImageBitmap imageBitmap;
        String $this$createSplashButtonTwistBrandCard_u24lambda_u240_u241;
        Bitmap decodeFile;
        String $this$createSplashButtonTwistBrandCard_u24lambda_u240_u240;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final View composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        int buttonHeight = (int) (screenHeight * buttonData.getHeightPercent());
        int buttonWidth = RangesKt.coerceAtLeast((int) (buttonHeight * buttonRadio), miniButtonWidth);
        float startX = (screenWidth * buttonData.getXPercent()) - (buttonWidth / 2);
        float startY = (screenHeight * buttonData.getYPercent()) - (buttonHeight / 2);
        long startTime = System.currentTimeMillis();
        String brandCardTitle = buttonData.getBrandCardTitle();
        String str = brandCardTitle == null ? "" : brandCardTitle;
        String brandCardDesc = buttonData.getBrandCardDesc();
        String str2 = brandCardDesc == null ? "" : brandCardDesc;
        File fetchResourceFileByHash = BusinessSplashResHelper.fetchResourceFileByHash(buttonData.getLogoImageMD5());
        ImageBitmap imageBitmap2 = null;
        if (fetchResourceFileByHash == null || ($this$createSplashButtonTwistBrandCard_u24lambda_u240_u240 = fetchResourceFileByHash.getPath()) == null) {
            imageBitmap = null;
        } else {
            Bitmap decodeFile2 = BitmapFactory.decodeFile($this$createSplashButtonTwistBrandCard_u24lambda_u240_u240);
            imageBitmap = decodeFile2 != null ? AndroidImageBitmap_androidKt.asImageBitmap(decodeFile2) : null;
        }
        File fetchResourceFileByHash2 = BusinessSplashResHelper.fetchResourceFileByHash(buttonData.getGuideImageMD5());
        if (fetchResourceFileByHash2 != null && ($this$createSplashButtonTwistBrandCard_u24lambda_u240_u241 = fetchResourceFileByHash2.getPath()) != null && (decodeFile = BitmapFactory.decodeFile($this$createSplashButtonTwistBrandCard_u24lambda_u240_u241)) != null) {
            imageBitmap2 = AndroidImageBitmap_androidKt.asImageBitmap(decodeFile);
        }
        final SplashTwistBrandCardUiState uiState = new SplashTwistBrandCardUiState(str, str2, imageBitmap, imageBitmap2, ContextCompat.getDrawable(context2, R.drawable.bili_splash_brand_twist_card_bottom_title_bg), UiUtilsKt.getToDp(buttonHeight * topBannerRadio), UiUtilsKt.getToDp(buttonHeight * 0.59016395f), UiUtilsKt.getToDp(buttonHeight * topIconRadio), UiUtilsKt.getToDp(buttonHeight * bottomIconRadio), null);
        BLog.i(TAG, "createSplashButtonTwistBrandCard, decode cost time = " + (System.currentTimeMillis() - startTime));
        final ValueAnimator $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242 = ValueAnimator.ofFloat(-15.0f, 15.0f);
        $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.setDuration(1000L);
        $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.setCurrentPlayTime(1000 / 2);
        $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.setRepeatCount(-1);
        $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.setRepeatMode(2);
        $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashButtonTwistBrandCardKt.createSplashButtonTwistBrandCard$lambda$0$2$0(composeView, valueAnimator);
            }
        });
        composeView.setCameraDistance(10000.0f);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(buttonWidth, buttonHeight));
        composeView.setX(startX);
        composeView.setY(startY);
        composeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$createSplashButtonTwistBrandCard$1$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.start();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                $this$createSplashButtonTwistBrandCard_u24lambda_u240_u242.cancel();
            }
        });
        SplashRotateSensorHelperKt.addRotateSensor(context2, composeView, composeView, buttonData, splash, listener);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1436995906, true, new Function2() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit createSplashButtonTwistBrandCard$lambda$0$3;
                createSplashButtonTwistBrandCard$lambda$0$3 = SplashButtonTwistBrandCardKt.createSplashButtonTwistBrandCard$lambda$0$3(SplashTwistBrandCardUiState.this, buttonData, listener, splash, (Composer) obj, ((Integer) obj2).intValue());
                return createSplashButtonTwistBrandCard$lambda$0$3;
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSplashButtonTwistBrandCard$lambda$0$2$0(ComposeView $this_apply, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        $this_apply.setRotationY(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSplashButtonTwistBrandCard$lambda$0$3(SplashTwistBrandCardUiState $uiState, final SplashGuideButton $buttonData, final SplashButtonClickListener $listener, final Splash $splash, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C134@5426L24,137@5528L216,135@5459L285:SplashButtonTwistBrandCard.kt#95ueoj");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1436995906, $changed, -1, "tv.danmaku.bili.ui.splash.ad.button.card.createSplashButtonTwistBrandCard.<anonymous>.<anonymous> (SplashButtonTwistBrandCard.kt:134)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -2026399462, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(scope) | $composer.changedInstance($buttonData) | $composer.changedInstance($listener) | $composer.changedInstance($splash);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit createSplashButtonTwistBrandCard$lambda$0$3$0$0;
                        createSplashButtonTwistBrandCard$lambda$0$3$0$0 = SplashButtonTwistBrandCardKt.createSplashButtonTwistBrandCard$lambda$0$3$0$0(scope, $buttonData, $listener, $splash);
                        return createSplashButtonTwistBrandCard$lambda$0$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SplashButtonRotateBrandCard($uiState, (Function0) it$iv, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSplashButtonTwistBrandCard$lambda$0$3$0$0(CoroutineScope $scope, SplashGuideButton $buttonData, SplashButtonClickListener $listener, Splash $splash) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SplashButtonTwistBrandCardKt$createSplashButtonTwistBrandCard$1$2$1$1$1($buttonData, $listener, $splash, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x07b0  */
    /* JADX WARN: Type inference failed for: r7v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SplashButtonRotateBrandCard(SplashTwistBrandCardUiState uiState, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0 onCardClick;
        Composer $composer2;
        final SplashTwistBrandCardUiState splashTwistBrandCardUiState;
        final Function0 onCardClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Object it$iv;
        Function0 factory$iv$iv$iv3;
        Object value$iv;
        ImageBitmap bm;
        Composer $composer3 = $composer.startRestartGroup(-287961827);
        ComposerKt.sourceInformation($composer3, "C(SplashButtonRotateBrandCard)N(uiState,onCardClick)150@5876L2,156@6056L59,158@6136L44,152@5887L2827:SplashButtonTwistBrandCard.kt#95ueoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(uiState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            onCardClick = function0;
        } else if (($changed & 48) == 0) {
            onCardClick = function0;
            $dirty |= $composer3.changedInstance(onCardClick) ? 32 : 16;
        } else {
            onCardClick = function0;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            splashTwistBrandCardUiState = uiState;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1853405569, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onCardClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onCardClick2 = onCardClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-287961827, $dirty, -1, "tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonRotateBrandCard (SplashButtonTwistBrandCard.kt:151)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), buttonBg, (Shape) null, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1853399752, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1853397207, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit SplashButtonRotateBrandCard$lambda$2$0;
                        SplashButtonRotateBrandCard$lambda$2$0 = SplashButtonTwistBrandCardKt.SplashButtonRotateBrandCard$lambda$2$0(onCardClick2);
                        return SplashButtonRotateBrandCard$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(fillMaxWidth$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            Function0 onCardClick3 = onCardClick2;
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1590524178, "C163@6198L1025,192@7232L1476:SplashButtonTwistBrandCard.kt#95ueoj");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), uiState.m1491getTopHeightD9Ej5fM()), Color.Companion.getWhite-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2062407028, "C184@7006L9,182@6928L284:SplashButtonTwistBrandCard.kt#95ueoj");
            ImageBitmap bm2 = uiState.getTopIcon();
            if (bm2 == null) {
                $composer3.startReplaceGroup(-2062399900);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-2062399899);
                ComposerKt.sourceInformation($composer3, "*173@6570L82,172@6533L311,180@6861L40");
                ComposerKt.sourceInformationMarkerStart($composer3, 1959540368, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
                Object it$iv5 = $composer3.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object bitmapPainter = new BitmapPainter(bm2, 0L, 0L, 6, (DefaultConstructorMarker) null);
                    $composer3.updateRememberedValue(bitmapPainter);
                    it$iv = bitmapPainter;
                } else {
                    it$iv = it$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ImageKt.Image((BitmapPainter) it$iv, "top icon", SizeKt.size-3ABfNKs(Modifier.Companion, uiState.m1492getTopIconSizeD9Ej5fM()), (Alignment) null, ContentScale.Companion.getCrop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer3, BitmapPainter.$stable | 24624, 104);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            TextKt.Text--4IGK_g(uiState.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 11, (Object) null), BiliColorsSourceKt.getDayColors().getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 48, 3120, 55288);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), uiState.m1489getBottomHeightD9Ej5fM()), Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i8 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SplashButtonRotateBrandCard_u24lambda_u243_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1188201664, "C199@7476L9,204@7683L131,207@7848L265,198@7416L813:SplashButtonTwistBrandCard.kt#95ueoj");
            String desc = uiState.getDesc();
            TextStyle t17 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT17();
            long j = BiliColorsSourceKt.getDayColors().getText1-0d7_KjU();
            int i9 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 1285262468, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
            Object value$iv5 = $composer3.rememberedValue();
            if (value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = Dp.box-impl(uiState.getBottomIcon() != null ? Dp.constructor-impl(uiState.m1490getBottomIconSizeD9Ej5fM() + Dp.constructor-impl(10)) : Dp.constructor-impl(0));
                $composer3.updateRememberedValue(value$iv5);
            }
            float f = ((Dp) value$iv5).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(modifier, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 11, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1285267882, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 14) == 4;
            Object it$iv6 = $composer3.rememberedValue();
            if (!invalid$iv2 && it$iv6 != Composer.Companion.getEmpty()) {
                value$iv = it$iv6;
                splashTwistBrandCardUiState = uiState;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                TextKt.Text--4IGK_g(desc, $this$SplashButtonRotateBrandCard_u24lambda_u243_u241.align(PaddingKt.padding-VpY3zN4(DrawModifierKt.drawBehind(modifier2, (Function1) value$iv), Dp.constructor-impl(8), Dp.constructor-impl(5)), Alignment.Companion.getCenterStart()), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i9, false, 1, 0, (Function1) null, t17, $composer3, 0, 3120, 55288);
                bm = uiState.getBottomIcon();
                if (bm != null) {
                    $composer3.startReplaceGroup(1189014668);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1189014669);
                    ComposerKt.sourceInformation($composer3, "*217@8327L82,216@8290L394");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1094566830, "CC(remember):SplashButtonTwistBrandCard.kt#9igjgp");
                    Object it$iv7 = $composer3.rememberedValue();
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new BitmapPainter(bm, 0L, 0L, 6, (DefaultConstructorMarker) null);
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv7 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ImageKt.Image((BitmapPainter) it$iv7, "bottom icon", $this$SplashButtonRotateBrandCard_u24lambda_u243_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, uiState.m1490getBottomIconSizeD9Ej5fM()), Alignment.Companion.getCenterEnd()), (Alignment) null, ContentScale.Companion.getCrop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer3, BitmapPainter.$stable | 24624, 104);
                    Unit unit3 = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                onCardClick = onCardClick3;
            }
            splashTwistBrandCardUiState = uiState;
            Object obj = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit SplashButtonRotateBrandCard$lambda$3$1$1$0;
                    SplashButtonRotateBrandCard$lambda$3$1$1$0 = SplashButtonTwistBrandCardKt.SplashButtonRotateBrandCard$lambda$3$1$1$0(SplashTwistBrandCardUiState.this, (DrawScope) obj2);
                    return SplashButtonRotateBrandCard$lambda$3$1$1$0;
                }
            };
            $composer3.updateRememberedValue(obj);
            value$iv = obj;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(desc, $this$SplashButtonRotateBrandCard_u24lambda_u243_u241.align(PaddingKt.padding-VpY3zN4(DrawModifierKt.drawBehind(modifier2, (Function1) value$iv), Dp.constructor-impl(8), Dp.constructor-impl(5)), Alignment.Companion.getCenterStart()), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i9, false, 1, 0, (Function1) null, t17, $composer3, 0, 3120, 55288);
            bm = uiState.getBottomIcon();
            if (bm != null) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            onCardClick = onCardClick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SplashButtonRotateBrandCard$lambda$4;
                    SplashButtonRotateBrandCard$lambda$4 = SplashButtonTwistBrandCardKt.SplashButtonRotateBrandCard$lambda$4(SplashTwistBrandCardUiState.this, onCardClick, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return SplashButtonRotateBrandCard$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashButtonRotateBrandCard$lambda$2$0(Function0 $onCardClick) {
        $onCardClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashButtonRotateBrandCard$lambda$3$1$1$0(SplashTwistBrandCardUiState $uiState, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        Drawable descBgImage = $uiState.getDescBgImage();
        if (descBgImage != null) {
            int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
            int bits$iv$iv$iv2 = (int) (4294967295L & $this$drawBehind.getSize-NH-jbRc());
            DrawableKt.updateBounds(descBgImage, 0, 0, (int) Float.intBitsToFloat(bits$iv$iv$iv), (int) Float.intBitsToFloat(bits$iv$iv$iv2));
        }
        Drawable descBgImage2 = $uiState.getDescBgImage();
        if (descBgImage2 != null) {
            descBgImage2.draw(AndroidCanvas_androidKt.getNativeCanvas($this$drawBehind.getDrawContext().getCanvas()));
        }
        return Unit.INSTANCE;
    }
}