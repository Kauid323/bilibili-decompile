package tv.danmaku.bili.ui.splash.ad.button.card;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.adcommon.utils.ext.AdExtensions;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.google.common.collect.ImmutableList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import tv.danmaku.bili.splashwidget.R;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.button.sensor.SplashRotateSensorHelperKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButtonKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashShopCard;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.bili.ui.splash.utils.UiUtilsKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SplashShopButtonCard.kt */
@Metadata(d1 = {"\u0000g\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\"\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001ae\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u001426\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000e0\u0016H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 \"\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#\"\u0018\u0010$\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"createSplashShopButtonCard", "Landroidx/compose/ui/platform/ComposeView;", "context", "Landroid/content/Context;", "screenWidth", "", "screenHeight", "buttonData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "listener", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "SplashShopCardButton", "", "list", "Lcom/google/common/collect/ImmutableList;", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShopCard;", "count", "elementSize", "Landroidx/compose/ui/unit/Dp;", "onClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "card", "SplashShopCardButton-6a0pyJM", "(Lcom/google/common/collect/ImmutableList;IFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ImageForeground", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HeartbeatEasing", "tv/danmaku/bili/ui/splash/ad/button/card/SplashShopButtonCardKt$HeartbeatEasing$1", "Ltv/danmaku/bili/ui/splash/ad/button/card/SplashShopButtonCardKt$HeartbeatEasing$1;", "transformLoop3", "getTransformLoop3", "(I)I", "splash_debug", "startAnim", "", "alphaMoveMaker", "", "looperAnim"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashShopButtonCardKt {
    private static final SplashShopButtonCardKt$HeartbeatEasing$1 HeartbeatEasing = new Easing() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$HeartbeatEasing$1
        public float transform(float fraction) {
            return fraction <= 0.333f ? 3.0f * fraction : fraction <= 0.833f ? ((-2.0f) * fraction) + 1.666f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageForeground$lambda$0(Modifier modifier, int i, Composer composer, int i2) {
        ImageForeground(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashShopCardButton_6a0pyJM$lambda$8(ImmutableList immutableList, int i, float f, Function2 function2, int i2, Composer composer, int i3) {
        m1482SplashShopCardButton6a0pyJM(immutableList, i, f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final ComposeView createSplashShopButtonCard(Context context, int screenWidth, int screenHeight, final SplashGuideButton buttonData, Splash splash, final SplashButtonClickListener listener) {
        final float startX;
        boolean z;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        View composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        List<SplashShopCard> cards = buttonData.getCards();
        if (cards == null) {
            cards = CollectionsKt.emptyList();
        }
        final ImmutableList cardList = ImmutableList.copyOf(cards);
        float buttonHeight = screenHeight * buttonData.getHeightPercent();
        float buttonWidth = (cardList.size() * buttonHeight) + (RangesKt.coerceAtLeast(cardList.size() - 1, 1) * AdExtensions.getToPx(12));
        float elementSizeDp = UiUtilsKt.getToDp(buttonHeight);
        float f = 2;
        float startX2 = (screenWidth * buttonData.getXPercent()) - (buttonWidth / f);
        float startY = (screenHeight * buttonData.getYPercent()) - (buttonHeight / f);
        composeView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SplashShopButtonCardKt.createSplashShopButtonCard$lambda$0$0(view2);
            }
        });
        composeView.setLayoutParams(new ViewGroup.LayoutParams((int) buttonWidth, (int) buttonHeight));
        composeView.setX(startX2);
        composeView.setY(startY);
        if (SplashGuideButtonKt.getHitShopCardTwistStyle(buttonData)) {
            startX = elementSizeDp;
            z = true;
            SplashRotateSensorHelperKt.addRotateSensor(context2, composeView, composeView, buttonData, splash, listener);
        } else {
            startX = elementSizeDp;
            z = true;
        }
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1171642646, z, new Function2() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit createSplashShopButtonCard$lambda$0$1;
                createSplashShopButtonCard$lambda$0$1 = SplashShopButtonCardKt.createSplashShopButtonCard$lambda$0$1(cardList, startX, listener, buttonData, (Composer) obj, ((Integer) obj2).intValue());
                return createSplashShopButtonCard$lambda$0$1;
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSplashShopButtonCard$lambda$0$0(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSplashShopButtonCard$lambda$0$1(ImmutableList $cardList, float $elementSizeDp, final SplashButtonClickListener $listener, final SplashGuideButton $buttonData, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C84@3516L24,89@3698L679,85@3549L839:SplashShopButtonCard.kt#95ueoj");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1171642646, $changed, -1, "tv.danmaku.bili.ui.splash.ad.button.card.createSplashShopButtonCard.<anonymous>.<anonymous> (SplashShopButtonCard.kt:84)");
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
            Intrinsics.checkNotNull($cardList);
            int size = $cardList.size();
            ComposerKt.sourceInformationMarkerStart($composer, 667158461, "CC(remember):SplashShopButtonCard.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(scope) | $composer.changedInstance($listener) | $composer.changedInstance($buttonData);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function2() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit createSplashShopButtonCard$lambda$0$1$0$0;
                        createSplashShopButtonCard$lambda$0$1$0$0 = SplashShopButtonCardKt.createSplashShopButtonCard$lambda$0$1$0$0(scope, $listener, $buttonData, ((Integer) obj).intValue(), (SplashShopCard) obj2);
                        return createSplashShopButtonCard$lambda$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m1482SplashShopCardButton6a0pyJM($cardList, size, $elementSizeDp, (Function2) it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSplashShopButtonCard$lambda$0$1$0$0(CoroutineScope $scope, SplashButtonClickListener $listener, SplashGuideButton $buttonData, int index, SplashShopCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SplashShopButtonCardKt$createSplashShopButtonCard$1$2$1$1$1($listener, $buttonData, card, index, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0362, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /* renamed from: SplashShopCardButton-6a0pyJM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1482SplashShopCardButton6a0pyJM(final ImmutableList<SplashShopCard> immutableList, final int count, final float f, final Function2<? super Integer, ? super SplashShopCard, Unit> function2, Composer $composer, final int $changed) {
        int $dirty;
        Function0 factory$iv$iv$iv;
        Modifier materialized$iv$iv;
        float $this$dp$iv;
        int $dirty2;
        Function0 factory$iv$iv$iv2;
        float f2 = f;
        final Function2<? super Integer, ? super SplashShopCard, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(immutableList, "list");
        Intrinsics.checkNotNullParameter(function22, "onClick");
        Composer $composer2 = $composer.startRestartGroup(1538493640);
        ComposerKt.sourceInformation($composer2, "C(SplashShopCardButton)N(list,count,elementSize:c#ui.unit.Dp,onClick)118@4631L34,119@4692L374,132@5091L37,134@5152L367,149@5605L1165,182@6797L32,182@6776L53:SplashShopButtonCard.kt#95ueoj");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(immutableList) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(count) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(f2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function22) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty4 = $dirty3;
        if (!$composer2.shouldExecute(($dirty4 & 1171) != 1170, $dirty4 & 1)) {
            $dirty = $dirty4;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1538493640, $dirty4, -1, "tv.danmaku.bili.ui.splash.ad.button.card.SplashShopCardButton (SplashShopButtonCard.kt:115)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1023645034, "CC(remember):SplashShopButtonCard.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState startAnim$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State alphaMoveMaker$delegate = AnimateAsStateKt.animateFloatAsState(SplashShopCardButton_6a0pyJM$lambda$1(startAnim$delegate) ? 1.0f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween((int) 1000, 0, HeartbeatEasing), (RepeatMode) null, 0L, 6, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (String) null, (Function1) null, $composer2, InfiniteRepeatableSpec.$stable << 3, 28);
            ComposerKt.sourceInformationMarkerStart($composer2, 1023659757, "CC(remember):SplashShopButtonCard.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = Integer.valueOf(((int) 1000) * count);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            int loopDuration = ((Number) it$iv2).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String str = "CC(remember):SplashShopButtonCard.kt#9igjgp";
            State looperAnim$delegate = AnimateAsStateKt.animateIntAsState(SplashShopCardButton_6a0pyJM$lambda$1(startAnim$delegate) ? count : 0, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween(loopDuration, 0, EasingKt.getLinearEasing()), (RepeatMode) null, 0L, 6, (Object) null), (String) null, (Function1) null, $composer2, InfiniteRepeatableSpec.$stable << 3, 12);
            int currLooper = SplashShopCardButton_6a0pyJM$lambda$5(looperAnim$delegate);
            if (count == 3) {
                currLooper = getTransformLoop3(currLooper);
            }
            Modifier modifier$iv = SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            int $changed$iv = '6';
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
            String str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 626437782, "C:SplashShopButtonCard.kt#95ueoj");
            $composer2.startReplaceGroup(-1365265496);
            ComposerKt.sourceInformation($composer2, "*163@6141L39,165@6267L91,157@5859L895");
            List $this$fastForEachIndexed$iv = (List) immutableList;
            int $i$f$fastForEachIndexed = $this$fastForEachIndexed$iv.size();
            int index$iv = 0;
            while (index$iv < $i$f$fastForEachIndexed) {
                Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                final SplashShopCard card = (SplashShopCard) item$iv;
                final int index = index$iv;
                int i3 = $i$f$fastForEachIndexed;
                float alphaMove = SplashShopCardButton_6a0pyJM$lambda$3(alphaMoveMaker$delegate);
                int $changed$iv$iv$iv2 = $changed$iv$iv$iv;
                Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, f2);
                if (index == currLooper) {
                    materialized$iv$iv = materialized$iv$iv2;
                    $this$dp$iv = (-alphaMove) * 20.0f;
                } else {
                    materialized$iv$iv = materialized$iv$iv2;
                    $this$dp$iv = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                }
                int currLooper2 = currLooper;
                int $changed$iv2 = $changed$iv;
                Modifier modifier2 = OffsetKt.offset-VpY3zN4$default(modifier, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl($this$dp$iv), 1, (Object) null);
                String str4 = str;
                ComposerKt.sourceInformationMarkerStart($composer2, -444162491, str4);
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -444158407, str4);
                boolean invalid$iv = (($dirty4 & 7168) == 2048) | $composer2.changed(index) | $composer2.changed(card);
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv) {
                    $dirty2 = $dirty4;
                } else {
                    $dirty2 = $dirty4;
                }
                Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit SplashShopCardButton_6a0pyJM$lambda$6$0$1$0;
                        SplashShopCardButton_6a0pyJM$lambda$6$0$1$0 = SplashShopButtonCardKt.SplashShopCardButton_6a0pyJM$lambda$6$0$1$0(function22, index, card);
                        return SplashShopCardButton_6a0pyJM$lambda$6$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier2, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str2);
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                String str5 = str2;
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                String str6 = str3;
                boolean z2 = z;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, str6);
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Composer $composer3 = $composer2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1681180810, "C171@6455L60,170@6419L321:SplashShopButtonCard.kt#95ueoj");
                String imageHash = card.getImageHash();
                ComposerKt.sourceInformationMarkerStart($composer2, -2023977452, str4);
                boolean invalid$iv2 = $composer2.changed(imageHash);
                Object it$iv5 = $composer2.rememberedValue();
                if (!invalid$iv2 && it$iv5 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ImageKt.Image-5h-nEew((ImageBitmap) it$iv5, "", SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFit(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, 0, $composer2, 25008, 232);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    index$iv++;
                    f2 = f;
                    function22 = function2;
                    str = str4;
                    currLooper = currLooper2;
                    $changed$iv = $changed$iv2;
                    z = z2;
                    $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                    materialized$iv$iv2 = materialized$iv$iv;
                    $i$f$fastForEachIndexed = i3;
                    $changed$iv$iv$iv = $changed$iv$iv$iv2;
                    str2 = str5;
                    $dirty4 = $dirty2;
                    str3 = str6;
                    $composer2 = $composer3;
                }
                Object value$iv5 = BusinessSplashResHelperKt.getMd5ToImageBitmap(card.getImageHash());
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image-5h-nEew((ImageBitmap) it$iv5, "", SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFit(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, 0, $composer2, 25008, 232);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                index$iv++;
                f2 = f;
                function22 = function2;
                str = str4;
                currLooper = currLooper2;
                $changed$iv = $changed$iv2;
                z = z2;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                materialized$iv$iv2 = materialized$iv$iv;
                $i$f$fastForEachIndexed = i3;
                $changed$iv$iv$iv = $changed$iv$iv$iv2;
                str2 = str5;
                $dirty4 = $dirty2;
                str3 = str6;
                $composer2 = $composer3;
            }
            $dirty = $dirty4;
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1023714344, str);
            Composer $this$cache$iv = $composer2;
            Object it$iv6 = $this$cache$iv.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = (Function2) new SplashShopButtonCardKt$SplashShopCardButton$2$1(startAnim$delegate, null);
                $this$cache$iv.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SplashShopCardButton_6a0pyJM$lambda$8;
                    SplashShopCardButton_6a0pyJM$lambda$8 = SplashShopButtonCardKt.SplashShopCardButton_6a0pyJM$lambda$8(immutableList, count, f, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SplashShopCardButton_6a0pyJM$lambda$8;
                }
            });
        }
    }

    private static final boolean SplashShopCardButton_6a0pyJM$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SplashShopCardButton_6a0pyJM$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final float SplashShopCardButton_6a0pyJM$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final int SplashShopCardButton_6a0pyJM$lambda$5(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashShopCardButton_6a0pyJM$lambda$6$0$1$0(Function2 $onClick, int $index, SplashShopCard $card) {
        Integer valueOf = Integer.valueOf($index);
        Intrinsics.checkNotNull($card);
        $onClick.invoke(valueOf, $card);
        return Unit.INSTANCE;
    }

    private static final void ImageForeground(final Modifier modifier, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1050310839);
        ComposerKt.sourceInformation($composer2, "C(ImageForeground)N(modifier)191@6953L95,189@6899L230:SplashShopButtonCard.kt#95ueoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050310839, $dirty2, -1, "tv.danmaku.bili.ui.splash.ad.button.card.ImageForeground (SplashShopButtonCard.kt:188)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.bili_app_list_splash_circle_bluer_musk, $composer2, 0), "", modifier, (Alignment) null, ContentScale.Companion.getFit(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer2, Painter.$stable | 24624 | (($dirty2 << 6) & 896), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageForeground$lambda$0;
                    ImageForeground$lambda$0 = SplashShopButtonCardKt.ImageForeground$lambda$0(modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageForeground$lambda$0;
                }
            });
        }
    }

    private static final int getTransformLoop3(int $this$transformLoop3) {
        switch ($this$transformLoop3) {
            case 0:
                return 0;
            case 1:
                return 2;
            default:
                return 1;
        }
    }
}