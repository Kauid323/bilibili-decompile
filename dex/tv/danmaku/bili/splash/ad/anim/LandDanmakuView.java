package tv.danmaku.bili.splash.ad.anim;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;

/* compiled from: LandDanmakuView.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0015\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0012J?\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\u00020\"*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0018\u0010%\u001a\u00020\"*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006'²\u0006\n\u0010(\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u008e\u0002"}, d2 = {"Ltv/danmaku/bili/splash/ad/anim/LandDanmakuView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defAttr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", AuthResultCbHelper.ARGS_STATE, "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/splash/ad/anim/DanmakuData;", ReportUtilKt.POS_UPDATE, "", "data", "DanmakuPanel", "(Ltv/danmaku/bili/splash/ad/anim/DanmakuData;Landroidx/compose/runtime/Composer;I)V", "ShadowTextView", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", GarbJsBridgeCallHandlerKt.PURE_THEME, "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "shadowStyle", "Landroidx/compose/ui/text/TextStyle;", "shadowColor", "ShadowTextView-safFUMA", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JJLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/runtime/Composer;I)V", "spToPx", "", "getSpToPx", "(I)F", "pxToDp", "getPxToDp", "splashwidget_debug", "states", "start", ""}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LandDanmakuView extends FrameLayout {
    public static final int $stable = 8;
    private final MutableStateFlow<DanmakuData> state;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LandDanmakuView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LandDanmakuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LandDanmakuView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DanmakuPanel$lambda$2(LandDanmakuView landDanmakuView, DanmakuData danmakuData, int i, Composer composer, int i2) {
        landDanmakuView.DanmakuPanel(danmakuData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShadowTextView_safFUMA$lambda$1(LandDanmakuView landDanmakuView, Modifier modifier, String str, long j, long j2, TextStyle textStyle, long j3, int i, Composer composer, int i2) {
        landDanmakuView.m1372ShadowTextViewsafFUMA(modifier, str, j, j2, textStyle, j3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LandDanmakuView(Context context, AttributeSet attributeSet, int defAttr, int defStyle) {
        super(context, attributeSet, defAttr, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.state = StateFlowKt.MutableStateFlow(new DanmakuData(null, 0, 0, 0, 15, null));
        ComposeView $this$_init__u24lambda_u240 = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$_init__u24lambda_u240.setContent(ComposableLambdaKt.composableLambdaInstance(-1678521000, true, new Function2() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                return LandDanmakuView.lambda$0$0(LandDanmakuView.this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        addView((View) $this$_init__u24lambda_u240, new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ LandDanmakuView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(LandDanmakuView this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C47@1833L16,48@1874L20:LandDanmakuView.kt#t5vbv8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1678521000, $changed, -1, "tv.danmaku.bili.splash.ad.anim.LandDanmakuView.<anonymous>.<anonymous> (LandDanmakuView.kt:47)");
            }
            State states$delegate = SnapshotStateKt.collectAsState(this$0.state, (CoroutineContext) null, $composer, 0, 1);
            this$0.DanmakuPanel(lambda$0$0$0(states$delegate), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final DanmakuData lambda$0$0$0(State<DanmakuData> state) {
        Object thisObj$iv = state.getValue();
        return (DanmakuData) thisObj$iv;
    }

    public final void update(DanmakuData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.state.setValue(data);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0454  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void DanmakuPanel(final DanmakuData data, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        boolean propagateMinConstraints$iv;
        Object value$iv;
        Object value$iv2;
        Composer $composer$iv;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv2;
        CompositionLocalMap localMap$iv$iv;
        boolean invalid$iv2;
        Object it$iv;
        DanmakuItem danmaku;
        Object it$iv2;
        Composer $composer2 = $composer.startRestartGroup(726988790);
        ComposerKt.sourceInformation($composer2, "C(DanmakuPanel)N(data)62@2246L118,65@2377L2506:LandDanmakuView.kt#t5vbv8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(726988790, $dirty2, -1, "tv.danmaku.bili.splash.ad.anim.LandDanmakuView.DanmakuPanel (LandDanmakuView.kt:60)");
            }
            String str = "CC(remember):LandDanmakuView.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer2, -1443439284, "CC(remember):LandDanmakuView.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(data);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = Float.valueOf(getPxToDp(data.getContainerHeightPx() / RangesKt.coerceAtLeast(data.getMaxLine(), 1)));
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            float lineHeight = ((Number) it$iv3).floatValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            float $this$dp$iv = getPxToDp(data.getContainerHeightPx());
            Modifier modifier$iv = SizeKt.height-3ABfNKs(fillMaxWidth$default, Dp.constructor-impl($this$dp$iv));
            Composer $composer$iv2 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            boolean propagateMinConstraints$iv2 = false;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Composer $composer$iv$iv$iv = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            Composer $composer3 = $composer$iv$iv$iv;
            Composer $composer$iv3 = $composer$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1219836890, "C:LandDanmakuView.kt#t5vbv8");
            $composer3.startReplaceGroup(39349887);
            ComposerKt.sourceInformation($composer3, "*68@2567L270,74@2871L34,76@2964L448,87@3472L187,99@4078L179,91@3681L1067,114@4791L60,114@4769L82");
            Iterable $this$forEach$iv = data.getList();
            for (Object element$iv : $this$forEach$iv) {
                DanmakuItem danmaku2 = (DanmakuItem) element$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, 690680851, str);
                boolean invalid$iv4 = $composer3.changed(danmaku2);
                Composer $this$cache$iv = $composer3;
                Alignment contentAlignment$iv2 = contentAlignment$iv;
                Object it$iv4 = $this$cache$iv.rememberedValue();
                if (!invalid$iv4 && it$iv4 != Composer.Companion.getEmpty()) {
                    value$iv = it$iv4;
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                    float textWidth = ((Number) value$iv).floatValue();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 690690343, str);
                    Composer $this$cache$iv2 = $composer3;
                    value$iv2 = $this$cache$iv2.rememberedValue();
                    Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                    if (value$iv2 != Composer.Companion.getEmpty()) {
                        $composer$iv = $composer$iv2;
                        value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $this$cache$iv2.updateRememberedValue(value$iv2);
                    } else {
                        $composer$iv = $composer$iv2;
                    }
                    MutableState start$delegate = (MutableState) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    final State offsetX = AnimateAsStateKt.animateIntAsState(!DanmakuPanel$lambda$1$0$2(start$delegate) ? -((int) textWidth) : data.getContainerWidthPx(), AnimationSpecKt.tween(danmaku2.getDuration(), danmaku2.getAppearTime(), EasingKt.getLinearEasing()), (String) null, (Function1) null, $composer3, 0, 12);
                    int lineLocation = danmaku2.getLineLocation();
                    ComposerKt.sourceInformationMarkerStart($composer3, 690709728, str);
                    invalid$iv = $composer3.changed(lineLocation);
                    Composer $this$cache$iv3 = $composer3;
                    Object it$iv5 = $this$cache$iv3.rememberedValue();
                    if (!invalid$iv && it$iv5 != Composer.Companion.getEmpty()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv;
                        localMap$iv$iv = localMap$iv$iv2;
                        final double offsetY = ((Number) it$iv5).doubleValue();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        String text = danmaku2.getText();
                        long Color = ColorKt.Color(danmaku2.getTextColor());
                        long sp = TextUnitKt.getSp(danmaku2.getTextSize());
                        float $this$dp$iv2 = Dp.constructor-impl(lineHeight);
                        Modifier materialized$iv$iv2 = materialized$iv$iv;
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, $this$dp$iv2), 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 690729112, str);
                        invalid$iv2 = $composer3.changed(offsetX) | $composer3.changed(offsetY);
                        Composer $this$cache$iv4 = $composer3;
                        it$iv = $this$cache$iv4.rememberedValue();
                        if (!invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                            danmaku = danmaku2;
                            Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj) {
                                    Unit DanmakuPanel$lambda$1$0$5$0;
                                    DanmakuPanel$lambda$1$0$5$0 = LandDanmakuView.DanmakuPanel$lambda$1$0$5$0(offsetX, offsetY, (GraphicsLayerScope) obj);
                                    return DanmakuPanel$lambda$1$0$5$0;
                                }
                            };
                            $this$cache$iv4.updateRememberedValue(value$iv4);
                            it$iv = value$iv4;
                        } else {
                            danmaku = danmaku2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Composer $composer4 = $composer3;
                        Composer $composer$iv4 = $composer$iv3;
                        boolean propagateMinConstraints$iv3 = propagateMinConstraints$iv;
                        Composer $composer$iv5 = $composer$iv;
                        String str2 = str;
                        CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv;
                        Function0 factory$iv$iv$iv4 = factory$iv$iv$iv2;
                        int $dirty3 = $dirty2;
                        m1372ShadowTextViewsafFUMA(GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth$default2, (Function1) it$iv), text, Color, sp, new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, new Stroke(4.0f, 0.0f, 0, 0, PathEffect.Companion.cornerPathEffect(5.0f), 14, (DefaultConstructorMarker) null), 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16760831, (DefaultConstructorMarker) null), Color.Companion.getBlack-0d7_KjU(), $composer4, (($dirty2 << 15) & 3670016) | 196608);
                        Boolean valueOf = Boolean.valueOf(DanmakuPanel$lambda$1$0$2(start$delegate));
                        ComposerKt.sourceInformationMarkerStart($composer4, 690751809, str2);
                        it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 != Composer.Companion.getEmpty()) {
                            Object value$iv5 = (Function2) new LandDanmakuView$DanmakuPanel$1$1$2$1(start$delegate, null);
                            $composer4.updateRememberedValue(value$iv5);
                            it$iv2 = value$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer4, 0);
                        $composer3 = $composer4;
                        str = str2;
                        $composer$iv2 = $composer$iv5;
                        materialized$iv$iv = materialized$iv$iv2;
                        contentAlignment$iv = contentAlignment$iv2;
                        localMap$iv$iv2 = localMap$iv$iv3;
                        propagateMinConstraints$iv2 = propagateMinConstraints$iv3;
                        $composer$iv3 = $composer$iv4;
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer$iv$iv$iv = $composer$iv$iv$iv2;
                        $dirty2 = $dirty3;
                    }
                    factory$iv$iv$iv2 = factory$iv$iv$iv;
                    localMap$iv$iv = localMap$iv$iv2;
                    Object value$iv6 = Double.valueOf(((data.getContainerHeightPx() / data.getMaxLine()) * (danmaku2.getLineLocation() - 0.5d)) - (getSpToPx(danmaku2.getTextSize()) / 2));
                    $this$cache$iv3.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                    final double offsetY2 = ((Number) it$iv5).doubleValue();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    String text2 = danmaku2.getText();
                    long Color2 = ColorKt.Color(danmaku2.getTextColor());
                    long sp2 = TextUnitKt.getSp(danmaku2.getTextSize());
                    float $this$dp$iv22 = Dp.constructor-impl(lineHeight);
                    Modifier materialized$iv$iv22 = materialized$iv$iv;
                    Modifier fillMaxWidth$default22 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, $this$dp$iv22), 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 690729112, str);
                    invalid$iv2 = $composer3.changed(offsetX) | $composer3.changed(offsetY2);
                    Composer $this$cache$iv42 = $composer3;
                    it$iv = $this$cache$iv42.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    danmaku = danmaku2;
                    Object value$iv42 = new Function1() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit DanmakuPanel$lambda$1$0$5$0;
                            DanmakuPanel$lambda$1$0$5$0 = LandDanmakuView.DanmakuPanel$lambda$1$0$5$0(offsetX, offsetY2, (GraphicsLayerScope) obj);
                            return DanmakuPanel$lambda$1$0$5$0;
                        }
                    };
                    $this$cache$iv42.updateRememberedValue(value$iv42);
                    it$iv = value$iv42;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Composer $composer42 = $composer3;
                    Composer $composer$iv42 = $composer$iv3;
                    boolean propagateMinConstraints$iv32 = propagateMinConstraints$iv;
                    Composer $composer$iv52 = $composer$iv;
                    String str22 = str;
                    CompositionLocalMap localMap$iv$iv32 = localMap$iv$iv;
                    Function0 factory$iv$iv$iv42 = factory$iv$iv$iv2;
                    int $dirty32 = $dirty2;
                    m1372ShadowTextViewsafFUMA(GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth$default22, (Function1) it$iv), text2, Color2, sp2, new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, new Stroke(4.0f, 0.0f, 0, 0, PathEffect.Companion.cornerPathEffect(5.0f), 14, (DefaultConstructorMarker) null), 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16760831, (DefaultConstructorMarker) null), Color.Companion.getBlack-0d7_KjU(), $composer42, (($dirty2 << 15) & 3670016) | 196608);
                    Boolean valueOf2 = Boolean.valueOf(DanmakuPanel$lambda$1$0$2(start$delegate));
                    ComposerKt.sourceInformationMarkerStart($composer42, 690751809, str22);
                    it$iv2 = $composer42.rememberedValue();
                    if (it$iv2 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer42);
                    EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv2, $composer42, 0);
                    $composer3 = $composer42;
                    str = str22;
                    $composer$iv2 = $composer$iv52;
                    materialized$iv$iv = materialized$iv$iv22;
                    contentAlignment$iv = contentAlignment$iv2;
                    localMap$iv$iv2 = localMap$iv$iv32;
                    propagateMinConstraints$iv2 = propagateMinConstraints$iv32;
                    $composer$iv3 = $composer$iv42;
                    factory$iv$iv$iv = factory$iv$iv$iv42;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    $dirty2 = $dirty32;
                }
                Paint $this$DanmakuPanel_u24lambda_u241_u240_u240_u240 = AndroidPaint_androidKt.Paint().asFrameworkPaint();
                propagateMinConstraints$iv = propagateMinConstraints$iv2;
                $this$DanmakuPanel_u24lambda_u241_u240_u240_u240.setTextSize(getSpToPx(danmaku2.getTextSize()));
                Object valueOf3 = Float.valueOf($this$DanmakuPanel_u24lambda_u241_u240_u240_u240.measureText(danmaku2.getText()));
                $this$cache$iv.updateRememberedValue(valueOf3);
                value$iv = valueOf3;
                float textWidth2 = ((Number) value$iv).floatValue();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 690690343, str);
                Composer $this$cache$iv22 = $composer3;
                value$iv2 = $this$cache$iv22.rememberedValue();
                Composer $composer$iv$iv$iv22 = $composer$iv$iv$iv;
                if (value$iv2 != Composer.Companion.getEmpty()) {
                }
                MutableState start$delegate2 = (MutableState) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final State offsetX2 = AnimateAsStateKt.animateIntAsState(!DanmakuPanel$lambda$1$0$2(start$delegate2) ? -((int) textWidth2) : data.getContainerWidthPx(), AnimationSpecKt.tween(danmaku2.getDuration(), danmaku2.getAppearTime(), EasingKt.getLinearEasing()), (String) null, (Function1) null, $composer3, 0, 12);
                int lineLocation2 = danmaku2.getLineLocation();
                ComposerKt.sourceInformationMarkerStart($composer3, 690709728, str);
                invalid$iv = $composer3.changed(lineLocation2);
                Composer $this$cache$iv32 = $composer3;
                Object it$iv52 = $this$cache$iv32.rememberedValue();
                if (!invalid$iv) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv;
                    localMap$iv$iv = localMap$iv$iv2;
                    final double offsetY22 = ((Number) it$iv52).doubleValue();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    String text22 = danmaku2.getText();
                    long Color22 = ColorKt.Color(danmaku2.getTextColor());
                    long sp22 = TextUnitKt.getSp(danmaku2.getTextSize());
                    float $this$dp$iv222 = Dp.constructor-impl(lineHeight);
                    Modifier materialized$iv$iv222 = materialized$iv$iv;
                    Modifier fillMaxWidth$default222 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, $this$dp$iv222), 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 690729112, str);
                    invalid$iv2 = $composer3.changed(offsetX2) | $composer3.changed(offsetY22);
                    Composer $this$cache$iv422 = $composer3;
                    it$iv = $this$cache$iv422.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    danmaku = danmaku2;
                    Object value$iv422 = new Function1() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit DanmakuPanel$lambda$1$0$5$0;
                            DanmakuPanel$lambda$1$0$5$0 = LandDanmakuView.DanmakuPanel$lambda$1$0$5$0(offsetX2, offsetY22, (GraphicsLayerScope) obj);
                            return DanmakuPanel$lambda$1$0$5$0;
                        }
                    };
                    $this$cache$iv422.updateRememberedValue(value$iv422);
                    it$iv = value$iv422;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Composer $composer422 = $composer3;
                    Composer $composer$iv422 = $composer$iv3;
                    boolean propagateMinConstraints$iv322 = propagateMinConstraints$iv;
                    Composer $composer$iv522 = $composer$iv;
                    String str222 = str;
                    CompositionLocalMap localMap$iv$iv322 = localMap$iv$iv;
                    Function0 factory$iv$iv$iv422 = factory$iv$iv$iv2;
                    int $dirty322 = $dirty2;
                    m1372ShadowTextViewsafFUMA(GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth$default222, (Function1) it$iv), text22, Color22, sp22, new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, new Stroke(4.0f, 0.0f, 0, 0, PathEffect.Companion.cornerPathEffect(5.0f), 14, (DefaultConstructorMarker) null), 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16760831, (DefaultConstructorMarker) null), Color.Companion.getBlack-0d7_KjU(), $composer422, (($dirty2 << 15) & 3670016) | 196608);
                    Boolean valueOf22 = Boolean.valueOf(DanmakuPanel$lambda$1$0$2(start$delegate2));
                    ComposerKt.sourceInformationMarkerStart($composer422, 690751809, str222);
                    it$iv2 = $composer422.rememberedValue();
                    if (it$iv2 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer422);
                    EffectsKt.LaunchedEffect(valueOf22, (Function2) it$iv2, $composer422, 0);
                    $composer3 = $composer422;
                    str = str222;
                    $composer$iv2 = $composer$iv522;
                    materialized$iv$iv = materialized$iv$iv222;
                    contentAlignment$iv = contentAlignment$iv2;
                    localMap$iv$iv2 = localMap$iv$iv322;
                    propagateMinConstraints$iv2 = propagateMinConstraints$iv322;
                    $composer$iv3 = $composer$iv422;
                    factory$iv$iv$iv = factory$iv$iv$iv422;
                    $composer$iv$iv$iv = $composer$iv$iv$iv22;
                    $dirty2 = $dirty322;
                }
                factory$iv$iv$iv2 = factory$iv$iv$iv;
                localMap$iv$iv = localMap$iv$iv2;
                Object value$iv62 = Double.valueOf(((data.getContainerHeightPx() / data.getMaxLine()) * (danmaku2.getLineLocation() - 0.5d)) - (getSpToPx(danmaku2.getTextSize()) / 2));
                $this$cache$iv32.updateRememberedValue(value$iv62);
                it$iv52 = value$iv62;
                final double offsetY222 = ((Number) it$iv52).doubleValue();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                String text222 = danmaku2.getText();
                long Color222 = ColorKt.Color(danmaku2.getTextColor());
                long sp222 = TextUnitKt.getSp(danmaku2.getTextSize());
                float $this$dp$iv2222 = Dp.constructor-impl(lineHeight);
                Modifier materialized$iv$iv2222 = materialized$iv$iv;
                Modifier fillMaxWidth$default2222 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, $this$dp$iv2222), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 690729112, str);
                invalid$iv2 = $composer3.changed(offsetX2) | $composer3.changed(offsetY222);
                Composer $this$cache$iv4222 = $composer3;
                it$iv = $this$cache$iv4222.rememberedValue();
                if (!invalid$iv2) {
                }
                danmaku = danmaku2;
                Object value$iv4222 = new Function1() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit DanmakuPanel$lambda$1$0$5$0;
                        DanmakuPanel$lambda$1$0$5$0 = LandDanmakuView.DanmakuPanel$lambda$1$0$5$0(offsetX2, offsetY222, (GraphicsLayerScope) obj);
                        return DanmakuPanel$lambda$1$0$5$0;
                    }
                };
                $this$cache$iv4222.updateRememberedValue(value$iv4222);
                it$iv = value$iv4222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Composer $composer4222 = $composer3;
                Composer $composer$iv4222 = $composer$iv3;
                boolean propagateMinConstraints$iv3222 = propagateMinConstraints$iv;
                Composer $composer$iv5222 = $composer$iv;
                String str2222 = str;
                CompositionLocalMap localMap$iv$iv3222 = localMap$iv$iv;
                Function0 factory$iv$iv$iv4222 = factory$iv$iv$iv2;
                int $dirty3222 = $dirty2;
                m1372ShadowTextViewsafFUMA(GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth$default2222, (Function1) it$iv), text222, Color222, sp222, new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, new Stroke(4.0f, 0.0f, 0, 0, PathEffect.Companion.cornerPathEffect(5.0f), 14, (DefaultConstructorMarker) null), 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16760831, (DefaultConstructorMarker) null), Color.Companion.getBlack-0d7_KjU(), $composer4222, (($dirty2 << 15) & 3670016) | 196608);
                Boolean valueOf222 = Boolean.valueOf(DanmakuPanel$lambda$1$0$2(start$delegate2));
                ComposerKt.sourceInformationMarkerStart($composer4222, 690751809, str2222);
                it$iv2 = $composer4222.rememberedValue();
                if (it$iv2 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer4222);
                EffectsKt.LaunchedEffect(valueOf222, (Function2) it$iv2, $composer4222, 0);
                $composer3 = $composer4222;
                str = str2222;
                $composer$iv2 = $composer$iv5222;
                materialized$iv$iv = materialized$iv$iv2222;
                contentAlignment$iv = contentAlignment$iv2;
                localMap$iv$iv2 = localMap$iv$iv3222;
                propagateMinConstraints$iv2 = propagateMinConstraints$iv3222;
                $composer$iv3 = $composer$iv4222;
                factory$iv$iv$iv = factory$iv$iv$iv4222;
                $composer$iv$iv$iv = $composer$iv$iv$iv22;
                $dirty2 = $dirty3222;
            }
            Composer $composer5 = $composer3;
            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DanmakuPanel$lambda$2;
                    DanmakuPanel$lambda$2 = LandDanmakuView.DanmakuPanel$lambda$2(LandDanmakuView.this, data, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DanmakuPanel$lambda$2;
                }
            });
        }
    }

    private static final boolean DanmakuPanel$lambda$1$0$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DanmakuPanel$lambda$1$0$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DanmakuPanel$lambda$1$0$5$0(State $offsetX, double $offsetY, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationX(((Number) $offsetX.getValue()).intValue());
        $this$graphicsLayer.setTranslationY((float) $offsetY);
        return Unit.INSTANCE;
    }

    /* renamed from: ShadowTextView-safFUMA  reason: not valid java name */
    private final void m1372ShadowTextViewsafFUMA(final Modifier modifier, final String text, final long j, final long j2, final TextStyle shadowStyle, final long j3, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-2057276807);
        ComposerKt.sourceInformation($composer2, "C(ShadowTextView)N(modifier,text,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,shadowStyle,shadowColor:c#ui.graphics.Color)130@5159L386:LandDanmakuView.kt#t5vbv8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changed(j) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(j2) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(shadowStyle) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(j3) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2057276807, $dirty2, -1, "tv.danmaku.bili.splash.ad.anim.LandDanmakuView.ShadowTextView (LandDanmakuView.kt:129)");
            }
            int $changed$iv = $dirty2 & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = (($changed$iv >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1319112763, "C131@5202L179,138@5399L132:LandDanmakuView.kt#t5vbv8");
            TextKt.Text-Nvy7gAk(text, (Modifier) null, j3, (TextAutoSize) null, j2, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, shadowStyle, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 9) & 896) | (($dirty2 << 3) & 57344), ($dirty2 << 9) & 29360128, 131050);
            TextKt.Text-Nvy7gAk(text, (Modifier) null, j, (TextAutoSize) null, j2, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, (($dirty2 >> 3) & 14) | ($dirty2 & 896) | (($dirty2 << 3) & 57344), 0, 262122);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.anim.LandDanmakuView$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShadowTextView_safFUMA$lambda$1;
                    ShadowTextView_safFUMA$lambda$1 = LandDanmakuView.ShadowTextView_safFUMA$lambda$1(LandDanmakuView.this, modifier, text, j, j2, shadowStyle, j3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ShadowTextView_safFUMA$lambda$1;
                }
            });
        }
    }

    private final float getSpToPx(int $this$spToPx) {
        return TypedValue.applyDimension(2, $this$spToPx, getContext().getResources().getDisplayMetrics());
    }

    private final float getPxToDp(int $this$pxToDp) {
        return $this$pxToDp / getContext().getResources().getDisplayMetrics().density;
    }
}