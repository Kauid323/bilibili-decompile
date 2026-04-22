package kntr.app.deepsearch.ui.input;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.deepsearch.ui.colors.DSColorsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Res;
import srcs.app.deepsearch.compose.generated.resources.String0_commonMainKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 2, 0}, xi = 48)
public final class InputKt$Input$5 implements TextFieldDecorator {
    final /* synthetic */ Function1<DeepSearchAction.InputAction, Unit> $actionHandler;
    final /* synthetic */ float $bottomPadding;
    final /* synthetic */ boolean $clearShow;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ long $hintColor;
    final /* synthetic */ InputState $inputState;
    final /* synthetic */ ScrollState $scrollableState;
    final /* synthetic */ State<Float> $scrollbarAlpha$delegate;
    final /* synthetic */ boolean $showCursor;
    final /* synthetic */ TextFieldState $textState;
    final /* synthetic */ float $topPadding;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public InputKt$Input$5(float f, float f2, ScrollState scrollState, boolean z, boolean z2, TextFieldState textFieldState, InputState inputState, Function1<? super DeepSearchAction.InputAction, Unit> function1, State<Float> state, long j2, FocusRequester focusRequester) {
        this.$topPadding = f;
        this.$bottomPadding = f2;
        this.$scrollableState = scrollState;
        this.$clearShow = z;
        this.$showCursor = z2;
        this.$textState = textFieldState;
        this.$inputState = inputState;
        this.$actionHandler = function1;
        this.$scrollbarAlpha$delegate = state;
        this.$hintColor = j2;
        this.$focusRequester = focusRequester;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$1(InputKt$Input$5 inputKt$Input$5, Function2 function2, int i, Composer composer, int i2) {
        inputKt$Input$5.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x03d8, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        float Input$lambda$11;
        Modifier modifier$iv;
        Function0 factory$iv$iv$iv2;
        final Function1<DeepSearchAction.InputAction, Unit> function1;
        Intrinsics.checkNotNullParameter(function2, "innerTextField");
        Composer $composer2 = $composer.startRestartGroup(1298318186);
        ComposerKt.sourceInformation($composer2, "C(Decoration)N(innerTextField)191@7295L6,191@7285L27,187@7135L3282:Input.kt#t8834");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1298318186, $dirty, -1, "kntr.app.deepsearch.ui.input.Input.<no name provided>.Decoration (Input.kt:187)");
            }
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(Modifier.Companion, DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable), DSColorsKt.INPUT_BOX, $composer2, 48), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)));
            float f = this.$topPadding;
            float f2 = this.$bottomPadding;
            ScrollState scrollState = this.$scrollableState;
            boolean z = this.$clearShow;
            boolean z2 = this.$showCursor;
            final TextFieldState textFieldState = this.$textState;
            InputState inputState = this.$inputState;
            Function1<DeepSearchAction.InputAction, Unit> function12 = this.$actionHandler;
            State<Float> state = this.$scrollbarAlpha$delegate;
            long j2 = this.$hintColor;
            final FocusRequester focusRequester = this.$focusRequester;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$Decoration_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 152916400, "C195@7452L1798,237@9539L646,232@9299L886,254@10237L66,257@10351L48:Input.kt#t8834");
            Modifier modifier = SizeKt.heightIn-VpY3zN4(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), f, Dp.constructor-impl(54), f2), 0.0f, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(168));
            Input$lambda$11 = InputKt.Input$lambda$11(state);
            modifier$iv = InputKt.m743textFieldVerticalScrollbarHgIXhM4(modifier, scrollState, (r14 & 2) != 0 ? ColorKt.Color(4292467161L) : 0L, (r14 & 4) != 0 ? Dp.constructor-impl(3) : 0.0f, (r14 & 8) != 0 ? Dp.constructor-impl(0) : 0.0f, Input$lambda$11);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1201074979, "C:Input.kt#t8834");
            if ((textFieldState.getText().length() == 0) || !z2) {
                $composer2.startReplaceGroup(1201119525);
                ComposerKt.sourceInformation($composer2, "211@8285L7,213@8366L37,217@8615L39,219@8753L240,224@9045L9,212@8321L768");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final SoftwareKeyboardController soft = (SoftwareKeyboardController) consume;
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getInput_hint(Res.string.INSTANCE), $composer2, 0);
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, 2116967805, "CC(remember):Input.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 2116972422, "CC(remember):Input.kt#9igjgp");
                function1 = function12;
                boolean invalid$iv = $composer2.changed(function1) | $composer2.changed(soft);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.input.InputKt$Input$5$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit Decoration$lambda$0$0$1$0;
                        Decoration$lambda$0$0$1$0 = InputKt$Input$5.Decoration$lambda$0$0$1$0(focusRequester, function1, soft);
                        return Decoration$lambda$0$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text-Nvy7gAk(stringResource, ClickableKt.clickable-O2vRcR0$default(modifier2, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131064);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1192944236);
                $composer2.endReplaceGroup();
                function1 = function12;
            }
            if (z2) {
                $composer2.startReplaceGroup(1202030212);
                ComposerKt.sourceInformation($composer2, "228@9186L16");
                function2.invoke($composer2, Integer.valueOf($dirty & 14));
            } else {
                $composer2.startReplaceGroup(1192944236);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AnimatedVisibilityKt.AnimatedVisibility(z, $this$Decoration_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd()), EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-2131641016, true, new Function3() { // from class: kntr.app.deepsearch.ui.input.InputKt$Input$5$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Decoration$lambda$0$1;
                    Decoration$lambda$0$1 = InputKt$Input$5.Decoration$lambda$0$1(textFieldState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Decoration$lambda$0$1;
                }
            }, $composer2, 54), $composer2, 200064, 16);
            InputKt.InputLengthText($this$Decoration_u24lambda_u240, z2, textFieldState.getText().toString(), inputState, $composer2, $changed2 & 14);
            InputKt.SenderBox($this$Decoration_u24lambda_u240, inputState, z2, function1, $composer2, $changed2 & 14);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.input.InputKt$Input$5$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Decoration$lambda$1;
                    Decoration$lambda$1 = InputKt$Input$5.Decoration$lambda$1(InputKt$Input$5.this, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Decoration$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$0$0$1$0(FocusRequester $focusRequester, Function1 $actionHandler, SoftwareKeyboardController $soft) {
        FocusRequester.requestFocus-3ESFkO8$default($focusRequester, 0, 1, (Object) null);
        $actionHandler.invoke(DeepSearchAction.InputAction.InputClick.INSTANCE);
        if ($soft != null) {
            $soft.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$0$1(final TextFieldState $textState, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C240@9660L93,238@9565L598:Input.kt#t8834");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2131641016, $changed, -1, "kntr.app.deepsearch.ui.input.Input.<no name provided>.Decoration.<anonymous>.<anonymous> (Input.kt:238)");
        }
        Modifier modifier = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart($composer, 192387781, "CC(remember):Input.kt#9igjgp");
        boolean invalid$iv = $composer.changed($textState);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.input.InputKt$Input$5$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit Decoration$lambda$0$1$0$0;
                    Decoration$lambda$0$1$0$0 = InputKt$Input$5.Decoration$lambda$0$1$0$0($textState);
                    return Decoration$lambda$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
        int i = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -523413457, "C245@9872L27,247@10030L6,244@9811L326:Input.kt#t8834");
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_circle_fill_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, Painter.$stable | 432, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$0$1$0$0(TextFieldState $textState) {
        TextFieldStateKt.clearText($textState);
        return Unit.INSTANCE;
    }
}