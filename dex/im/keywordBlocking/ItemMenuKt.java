package im.keywordBlocking;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsReaderView;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: ItemMenu.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00068AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"KeywordItemMenu", "", "menuList", "Lim/keywordBlocking/KBDropList;", "onClick", "Lkotlin/Function1;", "Lim/keywordBlocking/KBDropListItem;", "onDismiss", "Lkotlin/Function0;", "(Lim/keywordBlocking/KBDropList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "getIcon", "(Lim/keywordBlocking/KBDropListItem;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "titleResource", "Lorg/jetbrains/compose/resources/StringResource;", "getTitleResource", "(Lim/keywordBlocking/KBDropListItem;)Lorg/jetbrains/compose/resources/StringResource;", "keyword-blocking-ui_debug", "showBottomSheet", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordItemMenu$lambda$6(KBDropList kBDropList, Function1 function1, Function0 function0, int i2, Composer composer, int i3) {
        KeywordItemMenu(kBDropList, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void KeywordItemMenu(final KBDropList menuList, final Function1<? super KBDropListItem, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(-380219020);
        ComposerKt.sourceInformation($composer3, "C(KeywordItemMenu)N(menuList,onClick,onDismiss)49@1985L45,52@2064L31:ItemMenu.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(menuList) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-380219020, $dirty2, -1, "im.keywordBlocking.KeywordItemMenu (ItemMenu.kt:48)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -318253407, "CC(remember):ItemMenu.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState showBottomSheet$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, (Function1) null, $composer3, 0, 3);
            if (KeywordItemMenu$lambda$1(showBottomSheet$delegate)) {
                $composer3.startReplaceGroup(-1275693328);
                ComposerKt.sourceInformation($composer3, "57@2233L156,63@2430L6,69@2646L2203,54@2131L2718");
                ComposerKt.sourceInformationMarkerStart($composer3, -318245360, "CC(remember):ItemMenu.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: im.keywordBlocking.ItemMenuKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit KeywordItemMenu$lambda$3$0;
                            KeywordItemMenu$lambda$3$0 = ItemMenuKt.KeywordItemMenu$lambda$3$0(function0, showBottomSheet$delegate);
                            return KeywordItemMenu$lambda$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv2, (Modifier) null, sheetState, (float) CropImageView.DEFAULT_ASPECT_RATIO, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU(), 0L, (float) CropImageView.DEFAULT_ASPECT_RATIO, 0L, (Function2) null, new Function2() { // from class: im.keywordBlocking.ItemMenuKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        WindowInsets KeywordItemMenu$lambda$4;
                        KeywordItemMenu$lambda$4 = ItemMenuKt.KeywordItemMenu$lambda$4((Composer) obj, ((Integer) obj2).intValue());
                        return KeywordItemMenu$lambda$4;
                    }
                }, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-1806547347, true, new Function3() { // from class: im.keywordBlocking.ItemMenuKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit KeywordItemMenu$lambda$5;
                        KeywordItemMenu$lambda$5 = ItemMenuKt.KeywordItemMenu$lambda$5(KBDropList.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return KeywordItemMenu$lambda$5;
                    }
                }, $composer3, 54), $composer3, 6, 3078, (int) TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1277892530);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.ItemMenuKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit KeywordItemMenu$lambda$6;
                    KeywordItemMenu$lambda$6 = ItemMenuKt.KeywordItemMenu$lambda$6(KBDropList.this, function1, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return KeywordItemMenu$lambda$6;
                }
            });
        }
    }

    private static final boolean KeywordItemMenu$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void KeywordItemMenu$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordItemMenu$lambda$3$0(Function0 $onDismiss, MutableState $showBottomSheet$delegate) {
        KeywordItemMenu$lambda$2($showBottomSheet$delegate, false);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets KeywordItemMenu$lambda$4(Composer $composer, int $changed) {
        $composer.startReplaceGroup(737922617);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(737922617, $changed, -1, "im.keywordBlocking.KeywordItemMenu.<anonymous> (ItemMenu.kt:67)");
        }
        WindowInsets WindowInsets$default = WindowInsetsKt.WindowInsets$default(0, 0, 0, 0, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return WindowInsets$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordItemMenu$lambda$5(KBDropList $menuList, Function1 $onClick, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final Function1 function1 = $onClick;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C75@2899L12,77@3009L17,70@2660L2179:ItemMenu.kt#sbjqfg");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1806547347, $changed, -1, "im.keywordBlocking.KeywordItemMenu.<anonymous> (ItemMenu.kt:70)");
            }
            Modifier modifier$iv = PaddingKt.padding(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(24), Dp.constructor-impl(16), Dp.constructor-impl(16)), WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            Composer $composer2 = $composer;
            ComposerKt.sourceInformationMarkerStart($composer2, 717112994, "C82@3174L6,83@3226L9,80@3087L170,92@3532L6,86@3275L1550:ItemMenu.kt#sbjqfg");
            TextKt.Text-Nvy7gAk($menuList.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getH2(), $composer, 0, 0, 131066);
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(16), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
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
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 62571586, "C:ItemMenu.kt#sbjqfg");
            $composer2.startReplaceGroup(-1244907024);
            ComposerKt.sourceInformation($composer2, "*101@3932L15,97@3738L1047");
            Iterable $this$forEach$iv = $menuList.getActions();
            boolean z2 = false;
            for (Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                final KBDropListItem it = (KBDropListItem) element$iv;
                boolean z3 = z2;
                int compositeKeyHash$iv$iv3 = compositeKeyHash$iv$iv2;
                boolean z4 = z;
                CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv2;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -2022766182, "CC(remember):ItemMenu.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(function1) | $composer2.changedInstance(it);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: im.keywordBlocking.ItemMenuKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit KeywordItemMenu$lambda$5$0$0$0$0$0;
                            KeywordItemMenu$lambda$5$0$0$0$0$0 = ItemMenuKt.KeywordItemMenu$lambda$5$0$0$0$0$0(function1, it);
                            return KeywordItemMenu$lambda$5$0$0$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv3 = PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(16));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                int $changed$iv$iv$iv3 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv3 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                String str3 = str;
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                Modifier materialized$iv$iv4 = materialized$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, str2);
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer2.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer2.useNode();
                }
                String str4 = str2;
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i7 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1291926279, "C107@4271L4,108@4326L6,106@4220L273,113@4567L32,114@4651L6,115@4715L9,112@4522L237:ItemMenu.kt#sbjqfg");
                IconKt.Icon-ww6aTOc(getIcon(it, $composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(getTitleResource(it), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                function1 = $onClick;
                z = z4;
                materialized$iv$iv2 = materialized$iv$iv4;
                localMap$iv$iv2 = localMap$iv$iv3;
                $this$forEach$iv = $this$forEach$iv2;
                compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv3;
                z2 = z3;
                $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                str = str3;
                str2 = str4;
                $composer2 = $composer2;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeywordItemMenu$lambda$5$0$0$0$0$0(Function1 $onClick, KBDropListItem $it) {
        $onClick.invoke($it);
        return Unit.INSTANCE;
    }

    public static final Painter getIcon(KBDropListItem $this$icon, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$icon, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1455871941, "C(<get-icon>):ItemMenu.kt#sbjqfg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1455871941, $changed, -1, "im.keywordBlocking.<get-icon> (ItemMenu.kt:128)");
        }
        if (!($this$icon instanceof KBDropListItemDelete)) {
            $composer.startReplaceGroup(1066404316);
            $composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        }
        $composer.startReplaceGroup(1066406352);
        ComposerKt.sourceInformation($composer, "129@5003L21");
        Painter trash_delete_line_500 = BiliIconfont.INSTANCE.getTrash_delete_line_500($composer, 6);
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return trash_delete_line_500;
    }

    public static final StringResource getTitleResource(KBDropListItem $this$titleResource) {
        Intrinsics.checkNotNullParameter($this$titleResource, "<this>");
        if ($this$titleResource instanceof KBDropListItemDelete) {
            return String0_commonMainKt.getCommon_global_string_113(Res.string.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}