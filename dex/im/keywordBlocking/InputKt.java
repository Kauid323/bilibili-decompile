package im.keywordBlocking;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.BottomSheetDefaults;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.text.TextFieldColors;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"KeywordInputPanel", "", "input", "Lim/keywordBlocking/KBInputBox;", "onTextChange", "Lkotlin/Function1;", "", "onConfirm", "Lkotlin/Function0;", "onCancel", "(Lim/keywordBlocking/KBInputBox;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "keyword-blocking-ui_debug", "showBottomSheet", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordInputPanel$lambda$6(KBInputBox kBInputBox, Function1 function1, Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        KeywordInputPanel(kBInputBox, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0804, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void KeywordInputPanel(final KBInputBox input, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        FocusRequester focus;
        long j;
        long buttonColor;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(function1, "onTextChange");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function02, "onCancel");
        Composer $composer2 = $composer.startRestartGroup(1659991606);
        ComposerKt.sourceInformation($composer2, "C(KeywordInputPanel)N(input,onTextChange,onConfirm,onCancel)65@2731L45,69@2801L49:Input.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(input) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1659991606, $dirty2, -1, "im.keywordBlocking.KeywordInputPanel (Input.kt:64)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1819071907, "CC(remember):Input.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState showBottomSheet$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1819074151, "CC(remember):Input.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            FocusRequester focus2 = (FocusRequester) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (KeywordInputPanel$lambda$1(showBottomSheet$delegate)) {
                $composer2.startReplaceGroup(556948709);
                ComposerKt.sourceInformation($composer2, "77@3026L10,79@3103L106,73@2886L4887");
                Modifier imePadding = WindowInsetsPadding_androidKt.imePadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BottomSheetDefaults.INSTANCE.getScrimColor($composer2, 6), (Shape) null, 2, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer2, 1819083872, "CC(remember):Input.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 7168) == 2048;
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: im.keywordBlocking.InputKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit KeywordInputPanel$lambda$4$0;
                            KeywordInputPanel$lambda$4$0 = InputKt.KeywordInputPanel$lambda$4$0(function02, showBottomSheet$delegate);
                            return KeywordInputPanel$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(imePadding, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getBottomCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv5;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv5;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i3 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 456869909, "C89@3437L6,93@3721L12,95@3831L17,85@3290L4473:Input.kt#sbjqfg");
                Modifier modifier$iv2 = PaddingKt.padding(PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 12, (Object) null)), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(20)), WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer2, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer2, 0));
                ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, $i$f$Column);
                int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 2098268388, "C98@3909L975,124@5073L6,120@4902L1867,169@7128L57,177@7611L6,178@7668L9,168@7095L654:Input.kt#sbjqfg");
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(12), 7, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(20));
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv3 = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer2.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i7 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                RowScope $this$KeywordInputPanel_u24lambda_u245_u240_u240 = rowScope;
                ComposerKt.sourceInformationMarkerStart($composer2, -1008849803, "C104@4212L49,106@4361L9,107@4417L6,103@4175L373,113@4623L20,114@4686L6,112@4570L296:Input.kt#sbjqfg");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_867(Res.string.INSTANCE), $composer2, 0), RowScope.-CC.weight$default($this$KeywordInputPanel_u24lambda_u245_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getH2(), $composer2, 0, 24960, 110584);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_line_500($composer2, 6), (String) null, ClickableKt.clickable-oSLSa3U$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (String) null, (Role) null, (MutableInteractionSource) null, function02, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv4 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_regular-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(12), Dp.constructor-impl(6));
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv4 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer2.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i9 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                RowScope $this$KeywordInputPanel_u24lambda_u245_u240_u241 = rowScope2;
                ComposerKt.sourceInformationMarkerStart($composer2, 1907398910, "C131@5466L49,132@5589L21,134@5735L9,139@6013L75,129@5374L738,144@6155L68,144@6134L89,150@6310L210,155@6564L9,148@6245L506:Input.kt#sbjqfg");
                String text = input.getText();
                String stringResource = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_696(Res.string.INSTANCE), $composer2, 0);
                Modifier focusRequester = FocusRequesterModifierKt.focusRequester(ScrollKt.horizontalScroll$default(RowScope.-CC.weight$default($this$KeywordInputPanel_u24lambda_u245_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), focus2);
                TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.getDone-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 61548143, "CC(remember):Input.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 896) == 256;
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv4 = new Function1() { // from class: im.keywordBlocking.InputKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit KeywordInputPanel$lambda$5$0$1$0$0;
                        KeywordInputPanel$lambda$5$0$1$0$0 = InputKt.KeywordInputPanel$lambda$5$0$1$0$0(function0, (KeyboardActionScope) obj);
                        return KeywordInputPanel$lambda$5$0$1$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SimpleTextFieldKt.SimpleTextField(text, stringResource, function1, focusRequester, t14, (TextStyle) null, false, true, 1, keyboardOptions, new KeyboardActions((Function1) it$iv4, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 62, (DefaultConstructorMarker) null), (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer2, (($dirty2 << 3) & 896) | 918552576, 0, 14432);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 61552680, "CC(remember):Input.kt#9igjgp");
                Object it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    focus = focus2;
                    Object value$iv5 = (Function2) new InputKt$KeywordInputPanel$2$1$2$2$1(focus, null);
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                } else {
                    focus = focus2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer2, 6);
                String stringResource2 = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_861(Res.string.INSTANCE), new Object[]{Integer.valueOf(input.getTextCount()), Integer.valueOf(input.getCharLimit())}, $composer2, 0);
                TextStyle t142 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
                if (input.getLengthExceed()) {
                    $composer2.startReplaceGroup(61568526);
                    ComposerKt.sourceInformation($composer2, "156@6645L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU();
                } else {
                    $composer2.startReplaceGroup(61569577);
                    ComposerKt.sourceInformation($composer2, "156@6678L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU();
                }
                $composer2.endReplaceGroup();
                TextKt.Text-Nvy7gAk(stringResource2, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, t142, $composer2, 0, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (input.getButtonEnable()) {
                    $composer2.startReplaceGroup(2101067160);
                    ComposerKt.sourceInformation($composer2, "162@6884L6");
                    buttonColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(2101149806);
                    ComposerKt.sourceInformation($composer2, "164@6965L6");
                    buttonColor = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null);
                    $composer2.endReplaceGroup();
                }
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_124(Res.string.INSTANCE), $composer2, 0), PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(32), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), buttonColor, RoundedCornerShapeKt.getCircleShape()), input.getButtonEnable(), (String) null, (Role) null, (MutableInteractionSource) null, function0, 14, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(11), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getH2(), $composer2, 0, 0, 130040);
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
                $composer2.endReplaceGroup();
                $composer2 = $composer2;
            } else {
                $composer2.startReplaceGroup(553942732);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.InputKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit KeywordInputPanel$lambda$6;
                    KeywordInputPanel$lambda$6 = InputKt.KeywordInputPanel$lambda$6(KBInputBox.this, function1, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return KeywordInputPanel$lambda$6;
                }
            });
        }
    }

    private static final boolean KeywordInputPanel$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void KeywordInputPanel$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordInputPanel$lambda$4$0(Function0 $onCancel, MutableState $showBottomSheet$delegate) {
        KeywordInputPanel$lambda$2($showBottomSheet$delegate, false);
        $onCancel.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordInputPanel$lambda$5$0$1$0$0(Function0 $onConfirm, KeyboardActionScope $this$KeyboardActions) {
        Intrinsics.checkNotNullParameter($this$KeyboardActions, "$this$KeyboardActions");
        $onConfirm.invoke();
        return Unit.INSTANCE;
    }
}