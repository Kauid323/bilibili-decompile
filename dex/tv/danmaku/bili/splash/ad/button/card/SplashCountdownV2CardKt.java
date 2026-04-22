package tv.danmaku.bili.splash.ad.button.card;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.splash.ad.model.ExtSplashGuideButtonKt;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: SplashCountdownV2Card.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001aK\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u001f\u0010 \u001a\u001d\u0010'\u001a\u00020\u0001*\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0004\b)\u0010*\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010!\u001a\u00020\u001a*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020\u000f*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u000200X\u008a\u0084\u0002²\u0006\n\u00101\u001a\u00020.X\u008a\u008e\u0002"}, d2 = {"DefaultCardBg", "Landroidx/compose/ui/graphics/Color;", "J", "createSplashCountdownV2Card", "Landroid/view/View;", "context", "Landroid/content/Context;", "screenWidth", "", "screenHeight", "buttonData", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "CountdownCard", "", ReportUtilKt.POS_TITLE, "", "time", "", "timeShowType", "activityStartTime", "cardBgColor", "textColor", "CountdownCard-wBJOh4Y", "(Ljava/lang/String;JIJJJLandroidx/compose/runtime/Composer;II)V", "CountDownWidget", "date", "Ltv/danmaku/bili/splash/ad/button/card/CountdownDate;", "CountDownWidget-FNF3uiM", "(Ltv/danmaku/bili/splash/ad/button/card/CountdownDate;IJLandroidx/compose/runtime/Composer;II)V", "TimeView", "level", "TimeView-FNF3uiM", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "toCountdownDate", "getToCountdownDate", "(J)Ltv/danmaku/bili/splash/ad/button/card/CountdownDate;", "format", "getFormat", "(J)Ljava/lang/String;", "toComposeColor", "defaultColor", "toComposeColor-4WTKRHQ", "(Ljava/lang/String;J)J", "adsplash_debug", "timeLeft", "playAlpha", "", "boxAlpha", "", "disposed"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCountdownV2CardKt {
    private static final long DefaultCardBg = ColorKt.Color(1712855324);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownWidget_FNF3uiM$lambda$1(CountdownDate countdownDate, int i, long j, int i2, int i3, Composer composer, int i4) {
        m1389CountDownWidgetFNF3uiM(countdownDate, i, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountdownCard_wBJOh4Y$lambda$14(String str, long j, int i, long j2, long j3, long j4, int i2, int i3, Composer composer, int i4) {
        m1390CountdownCardwBJOh4Y(str, j, i, j2, j3, j4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeView_FNF3uiM$lambda$1(String str, String str2, long j, int i, int i2, Composer composer, int i3) {
        m1391TimeViewFNF3uiM(str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final View createSplashCountdownV2Card(Context context, int screenWidth, int screenHeight, SplashGuideButton buttonData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        final long time = RangesKt.coerceAtLeast(buttonData.getActivityTime() - (System.currentTimeMillis() / 1000), 0L);
        if (time <= 0) {
            return null;
        }
        View composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        int buttonHeight = ListExtentionsKt.toPx(81);
        int buttonWidth = ListExtentionsKt.toPx(buttonData.getTimeShowType() == 0 ? BR.foregroundTitleTextColor : BR.emptyType);
        float startX = (screenWidth * ExtSplashGuideButtonKt.getGetXPercent(buttonData)) - (buttonWidth / 2);
        float startY = (screenHeight * ExtSplashGuideButtonKt.getGetYPercent(buttonData)) - (buttonHeight / 2);
        String guideInstructions = buttonData.getGuideInstructions();
        if (guideInstructions == null) {
            guideInstructions = "";
        }
        final String title = guideInstructions;
        final int timeShowType = buttonData.getTimeShowType();
        final long cardBgColor = m1392toComposeColor4WTKRHQ(buttonData.getBgColor(), DefaultCardBg);
        final long textColor = m1392toComposeColor4WTKRHQ(buttonData.getTextColor(), Color.Companion.getWhite-0d7_KjU());
        final long activityStartTime = buttonData.getActivityTime();
        composeView.setLayoutParams(new ViewGroup.LayoutParams(buttonWidth, buttonHeight));
        composeView.setX(startX);
        composeView.setY(startY);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1734754716, true, new Function2() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit createSplashCountdownV2Card$lambda$0$0;
                createSplashCountdownV2Card$lambda$0$0 = SplashCountdownV2CardKt.createSplashCountdownV2Card$lambda$0$0(title, time, timeShowType, activityStartTime, cardBgColor, textColor, (Composer) obj, ((Integer) obj2).intValue());
                return createSplashCountdownV2Card$lambda$0$0;
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSplashCountdownV2Card$lambda$0$0(String $title, long $time, int $timeShowType, long $activityStartTime, long $cardBgColor, long $textColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C77@3465L297:SplashCountdownV2Card.kt#om307r");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1734754716, $changed, -1, "tv.danmaku.bili.splash.ad.button.card.createSplashCountdownV2Card.<anonymous>.<anonymous> (SplashCountdownV2Card.kt:77)");
            }
            m1390CountdownCardwBJOh4Y($title, $time, $timeShowType, $activityStartTime, $cardBgColor, $textColor, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01d7, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x04da, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L70;
     */
    /* renamed from: CountdownCard-wBJOh4Y  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1390CountdownCardwBJOh4Y(String title, long time, int timeShowType, long activityStartTime, long j, long j2, Composer $composer, final int $changed, final int i) {
        long time2;
        int timeShowType2;
        long activityStartTime2;
        int $dirty;
        String title2;
        long j3;
        long j4;
        long time3;
        int timeShowType3;
        long activityStartTime3;
        String title3;
        long j5;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean z;
        Composer $composer2 = $composer.startRestartGroup(1753280536);
        ComposerKt.sourceInformation($composer2, "C(CountdownCard)N(title,time,timeShowType,activityStartTime,cardBgColor:c#ui.graphics.Color,textColor:c#ui.graphics.Color)101@4044L49,105@4116L46,109@4184L185,117@4435L48,115@4375L911,143@5308L46,147@5390L65,147@5360L95,153@5489L319,153@5461L347:SplashCountdownV2Card.kt#om307r");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(title) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            time2 = time;
        } else if (($changed & 48) == 0) {
            time2 = time;
            $dirty2 |= $composer2.changed(time2) ? 32 : 16;
        } else {
            time2 = time;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= BR.negativeBtnVisible;
            timeShowType2 = timeShowType;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            timeShowType2 = timeShowType;
            $dirty2 |= $composer2.changed(timeShowType2) ? BR.hallEnterHotText : BR.cover;
        } else {
            timeShowType2 = timeShowType;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            activityStartTime2 = activityStartTime;
        } else if (($changed & 3072) == 0) {
            activityStartTime2 = activityStartTime;
            $dirty2 |= $composer2.changed(activityStartTime2) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        } else {
            activityStartTime2 = activityStartTime;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty = $dirty2 | 24576;
        } else if (($changed & 24576) == 0) {
            $dirty = $dirty2 | ($composer2.changed(j) ? RingBuffer.CONSUME_SIZE : 8192);
        } else {
            $dirty = $dirty2;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer2.changed(j2) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int $dirty3 = $dirty;
        if (!$composer2.shouldExecute(($dirty3 & 74899) != 74898, $dirty3 & 1)) {
            $composer2.skipToGroupEnd();
            title2 = title;
            j3 = j;
            j4 = j2;
            time3 = time2;
            timeShowType3 = timeShowType2;
            activityStartTime3 = activityStartTime2;
        } else {
            if (i2 != 0) {
                title3 = "";
            } else {
                title3 = title;
            }
            if (i3 != 0) {
                time2 = 0;
            }
            if (i4 != 0) {
                timeShowType2 = 0;
            }
            if (i5 != 0) {
                activityStartTime2 = 0;
            }
            if (i6 == 0) {
                j5 = j;
            } else {
                j5 = DefaultCardBg;
            }
            if (i7 == 0) {
                j4 = j2;
            } else {
                j4 = Color.Companion.getWhite-0d7_KjU();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1753280536, $dirty3, -1, "tv.danmaku.bili.splash.ad.button.card.CountdownCard (SplashCountdownV2Card.kt:99)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1275422281, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotLongStateKt.mutableLongStateOf(time2);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableLongState timeLeft$delegate = (MutableLongState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1275424582, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            time3 = time2;
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState playAlpha$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State boxAlpha$delegate = AnimateAsStateKt.animateFloatAsState(CountdownCard_wBJOh4Y$lambda$4(playAlpha$delegate) ? 0.0f : 1.0f, AnimationSpecKt.tween$default((int) BR.rightBtnBackDrawable, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, "alpha animation", (Function1) null, $composer2, 3072, 20);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 1275434792, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(boxAlpha$delegate);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv3 = new Function1() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit CountdownCard_wBJOh4Y$lambda$7$0;
                    CountdownCard_wBJOh4Y$lambda$7$0 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$7$0(boxAlpha$delegate, (GraphicsLayerScope) obj);
                    return CountdownCard_wBJOh4Y$lambda$7$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv$iv = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv3), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10))), j5, (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(12));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            j3 = j5;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            activityStartTime3 = activityStartTime2;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i9 = ((48 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1152005929, "C126@4690L590:SplashCountdownV2Card.kt#om307r");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i11 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -150818796, "C127@4763L289,136@5065L41,137@5142L75,137@5119L151:SplashCountdownV2Card.kt#om307r");
            TextKt.Text--4IGK_g(title3, (Modifier) null, j4, TextUnitKt.getSp(12), (FontStyle) null, new FontWeight((int) BR.officialImageDrawable), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, ($dirty3 & 14) | 199680 | (($dirty3 >> 9) & 896), 3120, 120274);
            title2 = title3;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer2, 6);
            long CountdownCard_wBJOh4Y$lambda$1 = CountdownCard_wBJOh4Y$lambda$1(timeLeft$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 1657714559, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(CountdownCard_wBJOh4Y$lambda$1);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4 = getToCountdownDate(CountdownCard_wBJOh4Y$lambda$1(timeLeft$delegate));
            $composer2.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m1389CountDownWidgetFNF3uiM((CountdownDate) it$iv3, timeShowType2, j4, $composer2, (($dirty3 >> 3) & BR.containerVisible) | (($dirty3 >> 9) & 896), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1275462726, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                z = false;
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            } else {
                z = false;
            }
            final MutableState disposed$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1275465369, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        DisposableEffectResult CountdownCard_wBJOh4Y$lambda$12$0;
                        CountdownCard_wBJOh4Y$lambda$12$0 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$12$0(disposed$delegate, (DisposableEffectScope) obj);
                        return CountdownCard_wBJOh4Y$lambda$12$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit, (Function1) it$iv5, $composer2, 54);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1275468791, "CC(remember):SplashCountdownV2Card.kt#9igjgp");
            if (($dirty3 & 7168) == 2048) {
                z = true;
            }
            boolean invalid$iv3 = z;
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv7 = (Function2) new SplashCountdownV2CardKt$CountdownCard$4$1(activityStartTime3, timeLeft$delegate, disposed$delegate, playAlpha$delegate, null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv6, $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            timeShowType3 = timeShowType2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str = title2;
            final long j6 = time3;
            final int i12 = timeShowType3;
            final long j7 = activityStartTime3;
            final long j8 = j3;
            final long j9 = j4;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CountdownCard_wBJOh4Y$lambda$14;
                    CountdownCard_wBJOh4Y$lambda$14 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$14(str, j6, i12, j7, j8, j9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CountdownCard_wBJOh4Y$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CountdownCard_wBJOh4Y$lambda$1(MutableLongState $timeLeft$delegate) {
        LongState $this$getValue$iv = (LongState) $timeLeft$delegate;
        return $this$getValue$iv.getLongValue();
    }

    private static final boolean CountdownCard_wBJOh4Y$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CountdownCard_wBJOh4Y$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final float CountdownCard_wBJOh4Y$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountdownCard_wBJOh4Y$lambda$7$0(State $boxAlpha$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha(CountdownCard_wBJOh4Y$lambda$6($boxAlpha$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CountdownCard_wBJOh4Y$lambda$10(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CountdownCard_wBJOh4Y$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CountdownCard_wBJOh4Y$lambda$12$0(final MutableState $disposed$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$CountdownCard_wBJOh4Y$lambda$12$0$$inlined$onDispose$1
            public void dispose() {
                SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$11($disposed$delegate, true);
            }
        };
    }

    /* renamed from: CountDownWidget-FNF3uiM  reason: not valid java name */
    private static final void m1389CountDownWidgetFNF3uiM(CountdownDate date, int timeShowType, long j, Composer $composer, final int $changed, final int i) {
        CountdownDate date2;
        int i2;
        long j2;
        Composer $composer2;
        CountdownDate date3;
        int timeShowType2;
        int timeShowType3;
        Function0 factory$iv$iv$iv;
        int i3;
        Composer $composer3 = $composer.startRestartGroup(2113765553);
        ComposerKt.sourceInformation($composer3, "C(CountDownWidget)N(date,timeShowType,textColor:c#ui.graphics.Color)174@5975L549:SplashCountdownV2Card.kt#om307r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            if ((i & 1) == 0) {
                date2 = date;
                if ($composer3.changed(date2)) {
                    i3 = 4;
                    $dirty |= i3;
                }
            } else {
                date2 = date;
            }
            i3 = 2;
            $dirty |= i3;
        } else {
            date2 = date;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            i2 = timeShowType;
        } else if (($changed & 48) == 0) {
            i2 = timeShowType;
            $dirty |= $composer3.changed(i2) ? 32 : 16;
        } else {
            i2 = timeShowType;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= BR.negativeBtnVisible;
            j2 = j;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            j2 = j;
            $dirty |= $composer3.changed(j2) ? BR.hallEnterHotText : BR.cover;
        } else {
            j2 = j;
        }
        if (!$composer3.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            date3 = date2;
            timeShowType2 = i2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty &= -15;
                }
                timeShowType3 = i2;
            } else {
                if ((i & 1) != 0) {
                    date2 = new CountdownDate(null, null, null, null, 15, null);
                    $dirty &= -15;
                }
                if (i4 == 0) {
                    timeShowType3 = i2;
                } else {
                    timeShowType3 = 0;
                }
                if (i5 != 0) {
                    j2 = Color.Companion.getWhite-0d7_KjU();
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2113765553, $dirty, -1, "tv.danmaku.bili.splash.ad.button.card.CountDownWidget (SplashCountdownV2Card.kt:173)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (48 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159314023, "C175@6041L61:SplashCountdownV2Card.kt#om307r");
            m1391TimeViewFNF3uiM(date2.getDay(), "天", j2, $composer3, ($dirty & 896) | 48, 0);
            if (timeShowType3 <= 2) {
                $composer3.startReplaceGroup(-1159216033);
                ComposerKt.sourceInformation($composer3, "177@6166L62");
                m1391TimeViewFNF3uiM(date2.getHour(), "时", j2, $composer3, ($dirty & 896) | 48, 0);
            } else {
                $composer3.startReplaceGroup(-1165322475);
            }
            $composer3.endReplaceGroup();
            if (timeShowType3 <= 1) {
                $composer3.startReplaceGroup(-1159079075);
                ComposerKt.sourceInformation($composer3, "180@6304L64");
                m1391TimeViewFNF3uiM(date2.getMinute(), "分", j2, $composer3, ($dirty & 896) | 48, 0);
            } else {
                $composer3.startReplaceGroup(-1165322475);
            }
            $composer3.endReplaceGroup();
            if (timeShowType3 <= 0) {
                $composer3.startReplaceGroup(-1158940195);
                ComposerKt.sourceInformation($composer3, "183@6444L64");
                m1391TimeViewFNF3uiM(date2.getSecond(), "秒", j2, $composer3, ($dirty & 896) | 48, 0);
            } else {
                $composer3.startReplaceGroup(-1165322475);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            date3 = date2;
            timeShowType2 = timeShowType3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final CountdownDate countdownDate = date3;
            final int i8 = timeShowType2;
            final long j3 = j2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CountDownWidget_FNF3uiM$lambda$1;
                    CountDownWidget_FNF3uiM$lambda$1 = SplashCountdownV2CardKt.CountDownWidget_FNF3uiM$lambda$1(CountdownDate.this, i8, j3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CountDownWidget_FNF3uiM$lambda$1;
                }
            });
        }
    }

    /* renamed from: TimeView-FNF3uiM  reason: not valid java name */
    private static final void m1391TimeViewFNF3uiM(String time, String level, long j, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        long j2;
        Composer $composer2;
        String time2;
        String level2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1039143886);
        ComposerKt.sourceInformation($composer3, "C(TimeView)N(time,level,textColor:c#ui.graphics.Color)191@6650L814:SplashCountdownV2Card.kt#om307r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = time;
        } else if (($changed & 6) == 0) {
            str = time;
            $dirty |= $composer3.changed(str) ? 4 : 2;
        } else {
            str = time;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = level;
        } else if (($changed & 48) == 0) {
            str2 = level;
            $dirty |= $composer3.changed(str2) ? 32 : 16;
        } else {
            str2 = level;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= BR.negativeBtnVisible;
            j2 = j;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            j2 = j;
            $dirty |= $composer3.changed(j2) ? BR.hallEnterHotText : BR.cover;
        } else {
            j2 = j;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & BR.danmakuNumIcon) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            time2 = str;
            level2 = str2;
        } else {
            String time3 = i2 != 0 ? MineReporter.LIVE_TYPE_NOT_UPPER_NO_LIVE : str;
            String level3 = i3 != 0 ? "天" : str2;
            if (i4 != 0) {
                j2 = Color.Companion.getWhite-0d7_KjU();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1039143886, $dirty2, -1, "tv.danmaku.bili.splash.ad.button.card.TimeView (SplashCountdownV2Card.kt:190)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.pendentVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 495579313, "C195@6786L478,210@7273L185:SplashCountdownV2Card.kt#om307r");
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -363089067, "C201@7008L246:SplashCountdownV2Card.kt#om307r");
            String str3 = time3;
            TextKt.Text--4IGK_g(str3, (Modifier) null, Color.Companion.getBlack-0d7_KjU(), TextUnitKt.getSp(18), (FontStyle) null, new FontWeight((int) BR.vipBarAnimIconTopMargin), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(20), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 200064, 6, 129490);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(level3, (Modifier) null, j2, TextUnitKt.getSp(13), (FontStyle) null, new FontWeight((int) BR.vipBarAnimIconTopMargin), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty2 >> 3) & 14) | 199680 | ($dirty2 & 896), 0, 130514);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            time2 = time3;
            level2 = level3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str4 = time2;
            final String str5 = level2;
            final long j3 = j2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeView_FNF3uiM$lambda$1;
                    TimeView_FNF3uiM$lambda$1 = SplashCountdownV2CardKt.TimeView_FNF3uiM$lambda$1(str4, str5, j3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeView_FNF3uiM$lambda$1;
                }
            });
        }
    }

    private static final CountdownDate getToCountdownDate(long $this$toCountdownDate) {
        long j = 86400;
        long day = $this$toCountdownDate / j;
        long j2 = 3600;
        long hour = ($this$toCountdownDate - (day * j)) / j2;
        long j3 = ($this$toCountdownDate - (j * day)) - (j2 * hour);
        long j4 = 60;
        long minute = j3 / j4;
        long second = $this$toCountdownDate % j4;
        return new CountdownDate(getFormat(day), getFormat(hour), getFormat(minute), getFormat(second));
    }

    private static final String getFormat(long $this$format) {
        return $this$format < 10 ? "0" + $this$format : $this$format < 100 ? String.valueOf($this$format) : String.valueOf($this$format % 100);
    }

    /* renamed from: toComposeColor-4WTKRHQ  reason: not valid java name */
    private static final long m1392toComposeColor4WTKRHQ(String $this$toComposeColor_u2d4WTKRHQ, long j) {
        if ($this$toComposeColor_u2d4WTKRHQ == null) {
            return j;
        }
        try {
            return ColorKt.Color(android.graphics.Color.parseColor($this$toComposeColor_u2d4WTKRHQ));
        } catch (Exception e) {
            return j;
        }
    }
}