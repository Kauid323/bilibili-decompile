package kntr.common.ouro.ui.textField;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.utils.BulletStyle;
import kntr.common.ouro.core.utils.ListOrderUtilsKt;
import kntr.common.ouro.ui.inlineContent.DrawableLayout;
import kntr.common.ouro.ui.utils.ListOrderStyle;
import kntr.common.ouro.ui.utils.OuroCacheMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroComposeTextField.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4 implements TextFieldDecorator {
    final /* synthetic */ AnnotatedString $annotatedString;
    final /* synthetic */ MutableState<List<BackgroundLayout>> $backgroundLayoutList$delegate;
    final /* synthetic */ MutableState<List<BlockQuoteLayout>> $blockQuoteLayoutList$delegate;
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<List<DrawableLayout>> $drawableLayoutList$delegate;
    final /* synthetic */ MutableState<List<ListItemLayout>> $listItemLayoutList$delegate;
    final /* synthetic */ MutableState<OuroCacheMap<String, TextLayoutResult>> $listOrderLayoutCache$delegate;
    final /* synthetic */ MutableIntState $mainAxisLength$delegate;
    final /* synthetic */ MutableState<OuroState> $ouroState$delegate;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ OuroStore $store;
    final /* synthetic */ MutableState<TextLayoutResult> $textLayout$delegate;
    final /* synthetic */ TextMeasurer $textMeasurer;

    /* compiled from: OuroComposeTextField.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BulletStyle.values().length];
            try {
                iArr[BulletStyle.FilledCircle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BulletStyle.StrokedCircle.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[BulletStyle.RoundedRectangle.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4(ScrollState scrollState, TextMeasurer textMeasurer, AnnotatedString annotatedString, Density density, MutableState<TextLayoutResult> mutableState, MutableState<List<BlockQuoteLayout>> mutableState2, MutableState<List<ListItemLayout>> mutableState3, MutableState<OuroCacheMap<String, TextLayoutResult>> mutableState4, MutableState<List<BackgroundLayout>> mutableState5, OuroStore ouroStore, MutableState<List<DrawableLayout>> mutableState6, MutableState<OuroState> mutableState7, MutableIntState mutableIntState) {
        this.$scrollState = scrollState;
        this.$textMeasurer = textMeasurer;
        this.$annotatedString = annotatedString;
        this.$density = density;
        this.$textLayout$delegate = mutableState;
        this.$blockQuoteLayoutList$delegate = mutableState2;
        this.$listItemLayoutList$delegate = mutableState3;
        this.$listOrderLayoutCache$delegate = mutableState4;
        this.$backgroundLayoutList$delegate = mutableState5;
        this.$store = ouroStore;
        this.$drawableLayoutList$delegate = mutableState6;
        this.$ouroState$delegate = mutableState7;
        this.$mainAxisLength$delegate = mutableIntState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$2(OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4 ouroComposeTextFieldKt$OuroComposeTextField$4$1$3$4, Function2 function2, int i, Composer composer, int i2) {
        ouroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0233  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        List OuroComposeTextField$lambda$16;
        OuroState OuroComposeTextField$lambda$1;
        int OuroComposeTextField$lambda$4;
        Intrinsics.checkNotNullParameter(function2, "innerTextField");
        Composer $composer3 = $composer.startRestartGroup(1368859653);
        ComposerKt.sourceInformation($composer3, "C(Decoration)N(innerTextField)376@17442L11595,370@17148L12168:OuroComposeTextField.kt#equpx4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(this) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1368859653, $dirty, -1, "kntr.common.ouro.ui.textField.OuroComposeTextField.<anonymous>.<anonymous>.<anonymous>.<no name provided>.Decoration (OuroComposeTextField.kt:367)");
            }
            final long verticalLineColor = ColorKt.Color(4291415248L);
            ColorKt.Color(4291415248L);
            Modifier clipToBounds = ClipKt.clipToBounds(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer3, 1214160528, "CC(remember):OuroComposeTextField.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(this.$scrollState) | $composer3.changed(this.$textMeasurer) | $composer3.changed(this.$annotatedString) | $composer3.changed(this.$density);
            final MutableState<TextLayoutResult> mutableState = this.$textLayout$delegate;
            final ScrollState scrollState = this.$scrollState;
            final MutableState<List<BlockQuoteLayout>> mutableState2 = this.$blockQuoteLayoutList$delegate;
            final MutableState<List<ListItemLayout>> mutableState3 = this.$listItemLayoutList$delegate;
            final Density density = this.$density;
            final MutableState<OuroCacheMap<String, TextLayoutResult>> mutableState4 = this.$listOrderLayoutCache$delegate;
            final TextMeasurer textMeasurer = this.$textMeasurer;
            final AnnotatedString annotatedString = this.$annotatedString;
            final MutableState<List<BackgroundLayout>> mutableState5 = this.$backgroundLayoutList$delegate;
            Object it$iv = $composer3.rememberedValue();
            if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv = DrawModifierKt.drawBehind(clipToBounds, (Function1) it$iv);
                Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
                OuroStore ouroStore = this.$store;
                ScrollState scrollState2 = this.$scrollState;
                MutableState<List<DrawableLayout>> mutableState6 = this.$drawableLayoutList$delegate;
                MutableState<OuroState> mutableState7 = this.$ouroState$delegate;
                MutableIntState mutableIntState = this.$mainAxisLength$delegate;
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                $composer2 = $composer3;
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
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
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope $this$Decoration_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 1211210363, "C540@29165L80,541@29274L16:OuroComposeTextField.kt#equpx4");
                OuroComposeTextField$lambda$16 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$16(mutableState6);
                OuroComposeTextField$lambda$1 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$1(mutableState7);
                OuroComposeTextField$lambda$4 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$4(mutableIntState);
                OuroComposeTextFieldKt.DrawableLayer($this$Decoration_u24lambda_u241, OuroComposeTextField$lambda$16, ouroStore, OuroComposeTextField$lambda$1, scrollState2, OuroComposeTextField$lambda$4, $composer3, (((48 >> 6) & 112) | 6) & 14);
                function2.invoke($composer3, Integer.valueOf($dirty & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit Decoration$lambda$0$0;
                    Decoration$lambda$0$0 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0(mutableState, scrollState, mutableState2, verticalLineColor, mutableState3, density, mutableState4, textMeasurer, annotatedString, mutableState5, (DrawScope) obj);
                    return Decoration$lambda$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = DrawModifierKt.drawBehind(clipToBounds, (Function1) it$iv);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenterStart();
            OuroStore ouroStore2 = this.$store;
            ScrollState scrollState22 = this.$scrollState;
            MutableState<List<DrawableLayout>> mutableState62 = this.$drawableLayoutList$delegate;
            MutableState<OuroState> mutableState72 = this.$ouroState$delegate;
            MutableIntState mutableIntState2 = this.$mainAxisLength$delegate;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope $this$Decoration_u24lambda_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1211210363, "C540@29165L80,541@29274L16:OuroComposeTextField.kt#equpx4");
            OuroComposeTextField$lambda$16 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$16(mutableState62);
            OuroComposeTextField$lambda$1 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$1(mutableState72);
            OuroComposeTextField$lambda$4 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$4(mutableIntState2);
            OuroComposeTextFieldKt.DrawableLayer($this$Decoration_u24lambda_u2412, OuroComposeTextField$lambda$16, ouroStore2, OuroComposeTextField$lambda$1, scrollState22, OuroComposeTextField$lambda$4, $composer3, (((48 >> 6) & 112) | 6) & 14);
            function2.invoke($composer3, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Decoration$lambda$2;
                    Decoration$lambda$2 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$2(OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.this, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Decoration$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$0$0(MutableState $textLayout$delegate, ScrollState $scrollState, MutableState $blockQuoteLayoutList$delegate, long $verticalLineColor, MutableState $listItemLayoutList$delegate, Density $density, MutableState $listOrderLayoutCache$delegate, final TextMeasurer $textMeasurer, final AnnotatedString $annotatedString, MutableState $backgroundLayoutList$delegate, DrawScope $this$drawBehind) {
        TextLayoutResult OuroComposeTextField$lambda$13;
        List OuroComposeTextField$lambda$19;
        Iterable visibleQuotes;
        List OuroComposeTextField$lambda$22;
        Iterable visibleListItems;
        List OuroComposeTextField$lambda$25;
        Iterable visibleBackgrounds;
        TextLayoutResult layout;
        float lineLeft;
        float lineRight;
        int i;
        int i2;
        TextLayoutResult layout2;
        OuroCacheMap OuroComposeTextField$lambda$7;
        DrawScope drawScope = $this$drawBehind;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        OuroComposeTextField$lambda$13 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$13($textLayout$delegate);
        if (OuroComposeTextField$lambda$13 != null) {
            final TextLayoutResult layout3 = OuroComposeTextField$lambda$13;
            OuroComposeTextField$lambda$19 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$19($blockQuoteLayoutList$delegate);
            int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
            visibleQuotes = OuroComposeTextFieldKt.filterVisibleItems(OuroComposeTextField$lambda$19, $scrollState.getValue(), Float.intBitsToFloat(bits$iv$iv$iv), new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    float Decoration$lambda$0$0$0$0;
                    Decoration$lambda$0$0$0$0 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0$0$0(layout3, (BlockQuoteLayout) obj);
                    return Float.valueOf(Decoration$lambda$0$0$0$0);
                }
            }, new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    float Decoration$lambda$0$0$0$1;
                    Decoration$lambda$0$0$0$1 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0$0$1(layout3, (BlockQuoteLayout) obj);
                    return Float.valueOf(Decoration$lambda$0$0$0$1);
                }
            });
            Iterable $this$forEach$iv = visibleQuotes;
            for (Object element$iv : $this$forEach$iv) {
                BlockQuoteLayout blockQuote = (BlockQuoteLayout) element$iv;
                float firstLineTop = layout3.getLineTop(blockQuote.getStartLine());
                float lastLineBottom = layout3.getLineBottom(blockQuote.getEndLine());
                float y$iv = firstLineTop - $scrollState.getValue();
                long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                long j = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                float width$iv = drawScope.toPx-0680j_4(Dp.constructor-impl(2));
                float height$iv = lastLineBottom - firstLineTop;
                long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
                long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
                long j2 = Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
                float x$iv = drawScope.toPx-0680j_4(Dp.constructor-impl(1));
                float y$iv2 = drawScope.toPx-0680j_4(Dp.constructor-impl(1));
                long v1$iv$iv3 = Float.floatToRawIntBits(x$iv);
                long v2$iv$iv3 = Float.floatToRawIntBits(y$iv2);
                DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBehind, $verticalLineColor, j, j2, CornerRadius.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
                layout3 = layout3;
                drawScope = $this$drawBehind;
            }
            final TextLayoutResult layout4 = layout3;
            OuroComposeTextField$lambda$22 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$22($listItemLayoutList$delegate);
            int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
            visibleListItems = OuroComposeTextFieldKt.filterVisibleItems(OuroComposeTextField$lambda$22, $scrollState.getValue(), Float.intBitsToFloat(bits$iv$iv$iv2), new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    float Decoration$lambda$0$0$0$3;
                    Decoration$lambda$0$0$0$3 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0$0$3(layout4, (ListItemLayout) obj);
                    return Float.valueOf(Decoration$lambda$0$0$0$3);
                }
            }, new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    float Decoration$lambda$0$0$0$4;
                    Decoration$lambda$0$0$0$4 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0$0$4(layout4, (ListItemLayout) obj);
                    return Float.valueOf(Decoration$lambda$0$0$0$4);
                }
            });
            Iterable $this$forEach$iv2 = visibleListItems;
            for (Object element$iv2 : $this$forEach$iv2) {
                ListItemLayout info = (ListItemLayout) element$iv2;
                float firstLineTop2 = layout4.getLineTop(info.getLine());
                float firstLineBottom = layout4.getLineBottom(info.getLine());
                int firstCharOffset = layout4.getLineStart(info.getLine());
                float firstLineLeft = layout4.getBoundingBox(firstCharOffset).getLeft();
                ListOrderStyle style = info.getStyle();
                if (style instanceof ListOrderStyle.Ordered) {
                    OuroComposeTextField$lambda$7 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$7($listOrderLayoutCache$delegate);
                    TextLayoutResult textLayoutResult = (TextLayoutResult) OuroComposeTextField$lambda$7.getOrPut(((ListOrderStyle.Ordered) style).getText().getText(), new Function0() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            TextLayoutResult textLayoutResult2;
                            textLayoutResult2 = TextMeasurer.measure-xDpz5zY$default($textMeasurer, $annotatedString, null, 0, false, 0, null, 0L, null, null, null, false, 2046, null);
                            return textLayoutResult2;
                        }
                    });
                    long mo2128getColor0d7_KjU = ((ListOrderStyle.Ordered) style).mo2128getColor0d7_KjU();
                    float y$iv3 = (firstLineBottom - $scrollState.getValue()) - ((int) (textLayoutResult.getSize-YbymL2g() & 4294967295L));
                    long v1$iv$iv4 = Float.floatToRawIntBits(firstLineLeft + $density.toPx-0680j_4(((ListOrderStyle.Ordered) style).mo2129getOffsetXD9Ej5fM()));
                    long v2$iv$iv4 = Float.floatToRawIntBits(y$iv3);
                    TextPainterKt.drawText-d8-rzKo$default($this$drawBehind, textLayoutResult, mo2128getColor0d7_KjU, Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L)), 0.0f, (Shadow) null, (TextDecoration) null, (DrawStyle) null, 0, 248, (Object) null);
                    layout2 = layout4;
                } else if (!(style instanceof ListOrderStyle.Unordered)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    TextLayoutResult layout5 = layout4;
                    float width$iv2 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(6));
                    float height$iv2 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(6));
                    long v1$iv$iv5 = Float.floatToRawIntBits(width$iv2);
                    long v2$iv$iv5 = Float.floatToRawIntBits(height$iv2);
                    long unorderedPrefixSize = Size.constructor-impl((v1$iv$iv5 << 32) | (v2$iv$iv5 & 4294967295L));
                    BulletStyle prefixIcon = ListOrderUtilsKt.bulletStyle(((ListOrderStyle.Unordered) style).getLevel());
                    float f = 2;
                    int bits$iv$iv$iv3 = (int) (unorderedPrefixSize >> 32);
                    float topLeftX = ((firstLineLeft + $this$drawBehind.toPx-0680j_4(((ListOrderStyle.Unordered) style).mo2129getOffsetXD9Ej5fM())) + ($this$drawBehind.toPx-0680j_4(DpSize.getWidth-D9Ej5fM(((ListOrderStyle.Unordered) style).mo2130getSizeMYxV2XQ())) / f)) - (Float.intBitsToFloat(bits$iv$iv$iv3) / f);
                    int bits$iv$iv$iv4 = (int) (unorderedPrefixSize & 4294967295L);
                    float y$iv4 = (((firstLineBottom + firstLineTop2) / f) - $scrollState.getValue()) - (Float.intBitsToFloat(bits$iv$iv$iv4) / f);
                    long v1$iv$iv6 = Float.floatToRawIntBits(topLeftX);
                    long v2$iv$iv6 = Float.floatToRawIntBits(y$iv4);
                    long topLeftOffset = Offset.constructor-impl((v1$iv$iv6 << 32) | (v2$iv$iv6 & 4294967295L));
                    switch (WhenMappings.$EnumSwitchMapping$0[prefixIcon.ordinal()]) {
                        case 1:
                            layout2 = layout5;
                            DrawScope.-CC.drawOval-n-J9OG0$default($this$drawBehind, ((ListOrderStyle.Unordered) style).mo2128getColor0d7_KjU(), topLeftOffset, unorderedPrefixSize, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 104, (Object) null);
                            Unit unit = Unit.INSTANCE;
                            continue;
                        case 2:
                            layout2 = layout5;
                            DrawScope.-CC.drawOval-n-J9OG0$default($this$drawBehind, ((ListOrderStyle.Unordered) style).mo2128getColor0d7_KjU(), topLeftOffset, unorderedPrefixSize, 0.0f, new Stroke($this$drawBehind.toPx-0680j_4(Dp.constructor-impl(1)), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
                            Unit unit2 = Unit.INSTANCE;
                            continue;
                        case 3:
                            long mo2128getColor0d7_KjU2 = ((ListOrderStyle.Unordered) style).mo2128getColor0d7_KjU();
                            float x$iv2 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(1));
                            long v1$iv$iv7 = Float.floatToRawIntBits(x$iv2);
                            long v2$iv$iv7 = Float.floatToRawIntBits(x$iv2);
                            layout2 = layout5;
                            DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBehind, mo2128getColor0d7_KjU2, topLeftOffset, unorderedPrefixSize, CornerRadius.constructor-impl((v1$iv$iv7 << 32) | (v2$iv$iv7 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
                            Unit unit3 = Unit.INSTANCE;
                            continue;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                layout4 = layout2;
            }
            DrawScope drawScope2 = $this$drawBehind;
            OuroComposeTextField$lambda$25 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$25($backgroundLayoutList$delegate);
            int bits$iv$iv$iv5 = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
            final TextLayoutResult layout6 = layout4;
            visibleBackgrounds = OuroComposeTextFieldKt.filterVisibleItems(OuroComposeTextField$lambda$25, $scrollState.getValue(), Float.intBitsToFloat(bits$iv$iv$iv5), new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    float Decoration$lambda$0$0$0$6;
                    Decoration$lambda$0$0$0$6 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0$0$6(layout6, (BackgroundLayout) obj);
                    return Float.valueOf(Decoration$lambda$0$0$0$6);
                }
            }, new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4$$ExternalSyntheticLambda8
                public final Object invoke(Object obj) {
                    float Decoration$lambda$0$0$0$7;
                    Decoration$lambda$0$0$0$7 = OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4.Decoration$lambda$0$0$0$7(layout6, (BackgroundLayout) obj);
                    return Float.valueOf(Decoration$lambda$0$0$0$7);
                }
            });
            Iterable $this$forEach$iv3 = visibleBackgrounds;
            for (Object element$iv3 : $this$forEach$iv3) {
                BackgroundLayout background = (BackgroundLayout) element$iv3;
                int i3 = background.getStartLine();
                int endLine = background.getEndLine();
                if (i3 <= endLine) {
                    int i4 = i3;
                    while (true) {
                        if (i4 == background.getStartLine()) {
                            lineLeft = layout6.getBoundingBox(background.getStartOffset()).getLeft();
                        } else {
                            lineLeft = layout6.getLineLeft(i4);
                        }
                        float offsetX = lineLeft;
                        float offsetY = (layout6.getLineBottom(i4) - $scrollState.getValue()) - drawScope2.toPx-0680j_4(background.getStyle().m2115getHeightD9Ej5fM());
                        if (i4 == background.getEndLine()) {
                            lineRight = layout6.getBoundingBox(background.getEndOffset()).getRight() - offsetX;
                        } else {
                            lineRight = layout6.getLineRight(i4) - offsetX;
                        }
                        float width = lineRight;
                        if (width <= 0.0f) {
                            i = i4;
                            layout = layout6;
                            i2 = endLine;
                        } else {
                            float height = drawScope2.toPx-0680j_4(background.getStyle().m2115getHeightD9Ej5fM());
                            long m2114getColor0d7_KjU = background.getStyle().m2114getColor0d7_KjU();
                            long v1$iv$iv8 = Float.floatToRawIntBits(offsetX);
                            long v2$iv$iv8 = Float.floatToRawIntBits(offsetY);
                            long j3 = Offset.constructor-impl((v1$iv$iv8 << 32) | (v2$iv$iv8 & 4294967295L));
                            long v1$iv$iv9 = Float.floatToRawIntBits(width);
                            long v2$iv$iv9 = Float.floatToRawIntBits(height);
                            i = i4;
                            layout = layout6;
                            i2 = endLine;
                            DrawScope.-CC.drawRect-n-J9OG0$default($this$drawBehind, m2114getColor0d7_KjU, j3, Size.constructor-impl((v1$iv$iv9 << 32) | (v2$iv$iv9 & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
                        }
                        int i5 = i;
                        if (i5 != i2) {
                            i4 = i5 + 1;
                            drawScope2 = $this$drawBehind;
                            endLine = i2;
                            layout6 = layout;
                        }
                    }
                } else {
                    layout = layout6;
                }
                drawScope2 = $this$drawBehind;
                layout6 = layout;
            }
            Unit unit4 = Unit.INSTANCE;
            Unit unit5 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Decoration$lambda$0$0$0$0(TextLayoutResult $layout, BlockQuoteLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $layout.getLineTop(it.getStartLine());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Decoration$lambda$0$0$0$1(TextLayoutResult $layout, BlockQuoteLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $layout.getLineBottom(it.getEndLine());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Decoration$lambda$0$0$0$3(TextLayoutResult $layout, ListItemLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $layout.getLineTop(it.getLine());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Decoration$lambda$0$0$0$4(TextLayoutResult $layout, ListItemLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $layout.getLineBottom(it.getLine());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Decoration$lambda$0$0$0$6(TextLayoutResult $layout, BackgroundLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $layout.getLineTop(it.getStartLine());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Decoration$lambda$0$0$0$7(TextLayoutResult $layout, BackgroundLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $layout.getLineBottom(it.getEndLine());
    }
}