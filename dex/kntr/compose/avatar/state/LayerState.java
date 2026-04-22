package kntr.compose.avatar.state;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.AvatarGroupScope;
import kntr.compose.avatar.internal.LayerScopeImpl;
import kntr.compose.avatar.internal.mask.EmptyMaskPainter;
import kntr.compose.avatar.internal.mask.MaskPainter;
import kntr.compose.avatar.model.layers.Layer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayerState.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010B\u001a\u00020C*\u00020DH\u0001¢\u0006\u0004\bE\u0010FR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\u0011\u0010\u001d\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R+\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010!R+\u0010#\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R+\u0010'\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010*R/\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0011\u001a\u0004\u0018\u00010,8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00104\u001a\u0002032\u0006\u0010\u0011\u001a\u0002038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0019\u001a\u0004\b5\u00106\"\u0004\b7\u00108R/\u0010:\u001a\u0004\u0018\u00010,2\b\u0010\u0011\u001a\u0004\u0018\u00010,8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0019\u001a\u0004\b;\u0010/\"\u0004\b<\u00101R\u001b\u0010>\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b?\u0010\u0010¨\u0006G"}, d2 = {"Lkntr/compose/avatar/state/LayerState;", "", "layer", "Lkntr/compose/avatar/model/layers/Layer;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Lkntr/compose/avatar/model/layers/Layer;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLayer", "()Lkntr/compose/avatar/model/layers/Layer;", "getNormalSize-D9Ej5fM", "()F", "F", "originVisibility", "", "getOriginVisibility", "()Z", "<set-?>", "Landroidx/compose/ui/geometry/Rect;", "originPosition", "getOriginPosition", "()Landroidx/compose/ui/geometry/Rect;", "setOriginPosition$ui_debug", "(Landroidx/compose/ui/geometry/Rect;)V", "originPosition$delegate", "Landroidx/compose/runtime/MutableState;", "originAlpha", "", "getOriginAlpha", "isCritical", "visible", "getVisible", "setVisible", "(Z)V", "visible$delegate", "drawPosition", "getDrawPosition", "setDrawPosition", "drawPosition$delegate", "alpha", "getAlpha", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Lkntr/compose/avatar/internal/mask/MaskPainter;", "maskPainter", "getMaskPainter", "()Lkntr/compose/avatar/internal/mask/MaskPainter;", "setMaskPainter", "(Lkntr/compose/avatar/internal/mask/MaskPainter;)V", "maskPainter$delegate", "pluginPainter", "getPluginPainter", "setPluginPainter", "pluginPainter$delegate", "readyToDraw", "getReadyToDraw", "readyToDraw$delegate", "Landroidx/compose/runtime/State;", "Content", "", "Lkntr/compose/avatar/AvatarGroupScope;", "Content$ui_debug", "(Lkntr/compose/avatar/AvatarGroupScope;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerState {
    public static final int $stable = 0;
    private final MutableState alpha$delegate;
    private final MutableState drawPosition$delegate;
    private final boolean isCritical;
    private final Layer layer;
    private final MutableState maskPainter$delegate;
    private final float normalSize;
    private final float originAlpha;
    private final MutableState originPosition$delegate;
    private final boolean originVisibility;
    private final MutableState painter$delegate;
    private final MutableState pluginPainter$delegate;
    private final State readyToDraw$delegate;
    private final MutableState visible$delegate;

    public /* synthetic */ LayerState(Layer layer, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(layer, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(LayerState layerState, AvatarGroupScope avatarGroupScope, int i, Composer composer, int i2) {
        layerState.Content$ui_debug(avatarGroupScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private LayerState(Layer layer, float normalSize) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        this.layer = layer;
        this.normalSize = normalSize;
        this.originVisibility = this.layer.getVisible();
        this.originPosition$delegate = SnapshotStateKt.mutableStateOf$default(RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.Companion.getZero-NH-jbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.originAlpha = this.layer.getGeneralSpec().getRenderSpec().getOpacity();
        this.isCritical = this.layer.getLayerConfig().isCritical();
        this.visible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(this.originVisibility), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.drawPosition$delegate = SnapshotStateKt.mutableStateOf$default(getOriginPosition(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.alpha$delegate = SnapshotStateKt.mutableStateOf$default(Float.valueOf(this.originAlpha), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.painter$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.maskPainter$delegate = SnapshotStateKt.mutableStateOf$default(EmptyMaskPainter.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.pluginPainter$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.readyToDraw$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.compose.avatar.state.LayerState$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean readyToDraw_delegate$lambda$0;
                readyToDraw_delegate$lambda$0 = LayerState.readyToDraw_delegate$lambda$0(LayerState.this);
                return Boolean.valueOf(readyToDraw_delegate$lambda$0);
            }
        });
    }

    public final Layer getLayer() {
        return this.layer;
    }

    /* renamed from: getNormalSize-D9Ej5fM  reason: not valid java name */
    public final float m2562getNormalSizeD9Ej5fM() {
        return this.normalSize;
    }

    public final boolean getOriginVisibility() {
        return this.originVisibility;
    }

    public final Rect getOriginPosition() {
        State $this$getValue$iv = this.originPosition$delegate;
        return (Rect) $this$getValue$iv.getValue();
    }

    public final void setOriginPosition$ui_debug(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        MutableState $this$setValue$iv = this.originPosition$delegate;
        $this$setValue$iv.setValue(rect);
    }

    public final float getOriginAlpha() {
        return this.originAlpha;
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    public final boolean getVisible() {
        State $this$getValue$iv = this.visible$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setVisible(boolean z) {
        MutableState $this$setValue$iv = this.visible$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    public final Rect getDrawPosition() {
        State $this$getValue$iv = this.drawPosition$delegate;
        return (Rect) $this$getValue$iv.getValue();
    }

    public final void setDrawPosition(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        MutableState $this$setValue$iv = this.drawPosition$delegate;
        $this$setValue$iv.setValue(rect);
    }

    public final float getAlpha() {
        State $this$getValue$iv = this.alpha$delegate;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public final void setAlpha(float f) {
        MutableState $this$setValue$iv = this.alpha$delegate;
        Object value$iv = Float.valueOf(f);
        $this$setValue$iv.setValue(value$iv);
    }

    public final Painter getPainter() {
        State $this$getValue$iv = this.painter$delegate;
        return (Painter) $this$getValue$iv.getValue();
    }

    public final void setPainter(Painter painter) {
        MutableState $this$setValue$iv = this.painter$delegate;
        $this$setValue$iv.setValue(painter);
    }

    public final MaskPainter getMaskPainter() {
        State $this$getValue$iv = this.maskPainter$delegate;
        return (MaskPainter) $this$getValue$iv.getValue();
    }

    public final void setMaskPainter(MaskPainter maskPainter) {
        Intrinsics.checkNotNullParameter(maskPainter, "<set-?>");
        MutableState $this$setValue$iv = this.maskPainter$delegate;
        $this$setValue$iv.setValue(maskPainter);
    }

    public final Painter getPluginPainter() {
        State $this$getValue$iv = this.pluginPainter$delegate;
        return (Painter) $this$getValue$iv.getValue();
    }

    public final void setPluginPainter(Painter painter) {
        MutableState $this$setValue$iv = this.pluginPainter$delegate;
        $this$setValue$iv.setValue(painter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean readyToDraw_delegate$lambda$0(LayerState this$0) {
        return this$0.getPainter() != null;
    }

    public final boolean getReadyToDraw() {
        State $this$getValue$iv = this.readyToDraw$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01ad, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Content$ui_debug(final AvatarGroupScope $this$Content, Composer $composer, final int $changed) {
        Function0 factory$iv$iv;
        Intrinsics.checkNotNullParameter($this$Content, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-1677437816);
        ComposerKt.sourceInformation($composer2, "C(Content)59@2156L7,60@2203L7,62@2248L250,*72@2559L16,73@2605L13,74@2655L65,74@2631L89,77@2755L139,77@2733L161:LayerState.kt#iflarf");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 17) != 16, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1677437816, $dirty, -1, "kntr.compose.avatar.state.LayerState.Content (LayerState.kt:58)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Enum r6 = (ThemeDayNight) consume2;
            Layer layer = this.layer;
            ComposerKt.sourceInformationMarkerStart($composer2, -1404999806, "CC(remember):LayerState.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(layer) | $composer2.changed(r6.ordinal());
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new LayerScopeImpl(this.layer, this.normalSize, r6, density, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            LayerScopeImpl layerScope = (LayerScopeImpl) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Painter painter = layerScope.contentPainter(this.layer, $composer2, 0);
            MaskPainter mask = layerScope.maskPainter(this.layer, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -881025564, "CC(remember):LayerState.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 112) == 32) | $composer2.changedInstance(painter);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new LayerState$Content$1$1$1(this, painter, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(painter, (Function2) it$iv2, $composer2, Painter.$stable);
            Layer layer2 = this.layer;
            ComposerKt.sourceInformationMarkerStart($composer2, -881022290, "CC(remember):LayerState.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 112) == 32) | $composer2.changed(layerScope);
            Object it$iv3 = $composer2.rememberedValue();
            if (!invalid$iv3 && it$iv3 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(layer2, (Function2) it$iv3, $composer2, 0);
                if (painter == null) {
                    $composer2.startReplaceGroup(-1541657223);
                    ComposerKt.sourceInformation($composer2, "93@3431L1505,83@3006L1930");
                    Painter content = mask.painterWithMask(painter);
                    Modifier modifier$iv = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer2, -880999292, "CC(remember):LayerState.kt#9igjgp");
                    boolean invalid$iv4 = ($dirty & 112) == 32;
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv3 = (MeasurePolicy) new LayerState$Content$1$4$1(this);
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv4 = value$iv3;
                    MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv = ((48 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv = factory$iv$iv2;
                        $composer2.createNode(factory$iv$iv);
                    } else {
                        factory$iv$iv = factory$iv$iv2;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 532739864, "C85@3070L278:LayerState.kt#iflarf");
                    ImageKt.Image(content, (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(mask.getModifier()), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 24624, 104);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    $composer2.startReplaceGroup(-1544625473);
                }
                $composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv4 = (Function2) new LayerState$Content$1$2$1(this, layerScope, null);
            $composer2.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(layer2, (Function2) it$iv3, $composer2, 0);
            if (painter == null) {
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.compose.avatar.state.LayerState$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$2;
                    Content$lambda$2 = LayerState.Content$lambda$2(LayerState.this, $this$Content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$2;
                }
            });
        }
    }
}