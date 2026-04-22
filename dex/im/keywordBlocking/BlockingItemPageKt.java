package im.keywordBlocking;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.IMPageStatusAlignmentMethod;
import im.base.IMPageStatusKt;
import im.base.IMStatusKt;
import im.base.IMTopBarKt;
import im.base.IdleContent;
import im.keywordBlocking.di.KBEntryPoint;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.compose.res.CommonRes;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: BlockingItemPage.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"BlockingItemPage", "", "(Landroidx/compose/runtime/Composer;I)V", "page", "Lim/keywordBlocking/KBPageData;", "onAction", "Lkotlin/Function1;", "Lim/keywordBlocking/KBAction;", "(Lim/keywordBlocking/KBPageData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EmptyPage", "onAddClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "keyword-blocking-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BlockingItemPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$3(int i2, Composer composer, int i3) {
        BlockingItemPage(composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$5(KBPageData kBPageData, Function1 function1, int i2, Composer composer, int i3) {
        BlockingItemPage(kBPageData, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyPage$lambda$1(Function0 function0, int i2, Composer composer, int i3) {
        EmptyPage(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void BlockingItemPage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(119646340);
        ComposerKt.sourceInformation($composer2, "C(BlockingItemPage)57@2336L24,59@2389L198,66@2622L16,68@2675L7,70@2688L62,72@2777L75,72@2756L96,76@2868L1070,76@2858L1080:BlockingItemPage.kt#sbjqfg");
        if ($composer2.shouldExecute($changed != 0, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(119646340, $changed, -1, "im.keywordBlocking.BlockingItemPage (BlockingItemPage.kt:56)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -983981046, "CC(remember):BlockingItemPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((KBEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KBEntryPoint.class))).getKBComponentFactory().create(scope).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final KBViewModel viewmodel = (KBViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final KBPageData page = (KBPageData) SnapshotStateKt.collectAsState(viewmodel.getDataFlow(), (CoroutineContext) null, $composer2, 0, 1).getValue();
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Toaster toast = (Toaster) consume;
            PvTriggerEntranceKt.rememberPvEventTrigger("im.im-setting-blacklist-words.0.0.pv", $composer2, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -983968753, "CC(remember):BlockingItemPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(viewmodel) | $composer2.changedInstance(toast);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new BlockingItemPageKt$BlockingItemPage$1$1(viewmodel, toast, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-571526708, true, new Function2() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItemPage$lambda$2;
                    BlockingItemPage$lambda$2 = BlockingItemPageKt.BlockingItemPage$lambda$2(KBPageData.this, viewmodel, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItemPage$lambda$2;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItemPage$lambda$3;
                    BlockingItemPage$lambda$3 = BlockingItemPageKt.BlockingItemPage$lambda$3($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItemPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$2(KBPageData $page, final KBViewModel $viewmodel, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C77@2901L25,77@2878L49:BlockingItemPage.kt#sbjqfg");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-571526708, $changed, -1, "im.keywordBlocking.BlockingItemPage.<anonymous> (BlockingItemPage.kt:77)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 518648581, "CC(remember):BlockingItemPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewmodel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (KFunction) new BlockingItemPageKt$BlockingItemPage$2$1$1($viewmodel);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BlockingItemPage($page, (KFunction) it$iv, $composer, 0);
            KBInputBox input = $page.getInputBox();
            if (input == null) {
                $composer.startReplaceGroup(-1104642730);
            } else {
                $composer.startReplaceGroup(-1101665397);
                ComposerKt.sourceInformation($composer, "83@3085L57,84@3172L48,85@3249L47,81@3004L307");
                ComposerKt.sourceInformationMarkerStart($composer, 518654501, "CC(remember):BlockingItemPage.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($viewmodel);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit BlockingItemPage$lambda$2$1$0;
                            BlockingItemPage$lambda$2$1$0 = BlockingItemPageKt.BlockingItemPage$lambda$2$1$0(KBViewModel.this, (String) obj);
                            return BlockingItemPage$lambda$2$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 function1 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 518657276, "CC(remember):BlockingItemPage.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance($viewmodel);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit BlockingItemPage$lambda$2$2$0;
                            BlockingItemPage$lambda$2$2$0 = BlockingItemPageKt.BlockingItemPage$lambda$2$2$0(KBViewModel.this);
                            return BlockingItemPage$lambda$2$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function0 function0 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 518659739, "CC(remember):BlockingItemPage.kt#9igjgp");
                boolean invalid$iv4 = $composer.changedInstance($viewmodel);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit BlockingItemPage$lambda$2$3$0;
                            BlockingItemPage$lambda$2$3$0 = BlockingItemPageKt.BlockingItemPage$lambda$2$3$0(KBViewModel.this);
                            return BlockingItemPage$lambda$2$3$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                InputKt.KeywordInputPanel(input, function1, function0, (Function0) it$iv4, $composer, 0);
            }
            $composer.endReplaceGroup();
            KBDropList menuList = $page.getDropList();
            if (menuList == null) {
                $composer.startReplaceGroup(-1104642730);
            } else {
                $composer.startReplaceGroup(-1101266303);
                ComposerKt.sourceInformation($composer, "93@3484L167,97@3681L89,91@3404L381");
                ComposerKt.sourceInformationMarkerStart($composer, 518667379, "CC(remember):BlockingItemPage.kt#9igjgp");
                boolean invalid$iv5 = $composer.changedInstance($viewmodel);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit BlockingItemPage$lambda$2$4$0;
                            BlockingItemPage$lambda$2$4$0 = BlockingItemPageKt.BlockingItemPage$lambda$2$4$0(KBViewModel.this, (KBDropListItem) obj);
                            return BlockingItemPage$lambda$2$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                Function1 function12 = (Function1) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 518673605, "CC(remember):BlockingItemPage.kt#9igjgp");
                boolean invalid$iv6 = $composer.changedInstance($viewmodel);
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit BlockingItemPage$lambda$2$5$0;
                            BlockingItemPage$lambda$2$5$0 = BlockingItemPageKt.BlockingItemPage$lambda$2$5$0(KBViewModel.this);
                            return BlockingItemPage$lambda$2$5$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ItemMenuKt.KeywordItemMenu(menuList, function12, (Function0) it$iv6, $composer, 0);
            }
            $composer.endReplaceGroup();
            KBAlert alert = $page.getAlert();
            if (alert == null) {
                $composer.startReplaceGroup(-1104642730);
            } else {
                $composer.startReplaceGroup(-1100815191);
                ComposerKt.sourceInformation($composer, "105@3896L25,105@3869L53");
                ComposerKt.sourceInformationMarkerStart($composer, 518680421, "CC(remember):BlockingItemPage.kt#9igjgp");
                boolean invalid$iv7 = $composer.changedInstance($viewmodel);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = (KFunction) new BlockingItemPageKt$BlockingItemPage$2$7$1($viewmodel);
                    $composer.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                DeleteConfirmDialogKt.DeleteConfirmDialog(alert, (KFunction) it$iv7, $composer, 0);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$2$1$0(KBViewModel $viewmodel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewmodel.dispatchAction(new KBActionInputBoxChanged(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$2$2$0(KBViewModel $viewmodel) {
        $viewmodel.dispatchAction(KBActionAddConfirm.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$2$3$0(KBViewModel $viewmodel) {
        $viewmodel.dispatchAction(KBActionAddCancel.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$2$4$0(KBViewModel $viewmodel, KBDropListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        KBAction it = item.getAction();
        if (it != null) {
            $viewmodel.dispatchAction(it);
        }
        $viewmodel.dispatchAction(new KBActionClickItem(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$2$5$0(KBViewModel $viewmodel) {
        $viewmodel.dispatchAction(new KBActionClickItem(null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0232, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0286, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BlockingItemPage(final KBPageData page, final Function1<? super KBAction, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-1640692153);
        ComposerKt.sourceInformation($composer3, "C(BlockingItemPage)N(page,onAction)115@4066L28,116@4110L20,117@4205L6,117@4135L627:BlockingItemPage.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1640692153, $dirty2, -1, "im.keywordBlocking.BlockingItemPage (BlockingItemPage.kt:114)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer3, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer3, 0);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ColumnScope $this$BlockingItemPage_u24lambda_u244 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -1117414782, "C118@4228L89:BlockingItemPage.kt#sbjqfg");
            IMTopBarKt.m3090IMTopBarnWoaYo(ComposableSingletons$BlockingItemPageKt.INSTANCE.getLambda$1351735810$keyword_blocking_ui_debug(), null, 0L, 0L, false, false, null, null, null, $composer3, 6, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
            ContentStatus contentStatus = page.getContentStatus();
            if (Intrinsics.areEqual(contentStatus, IdleContent.INSTANCE)) {
                $composer3.startReplaceGroup(-1117274973);
                ComposerKt.sourceInformation($composer3, "122@4400L78");
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                BlockingItemContentKt.BlockingItemContent(page, function1, ColumnScope.-CC.weight$default($this$BlockingItemPage_u24lambda_u244, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, ($dirty2 & 14) | ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW), 0);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer$iv$iv$iv = $composer3;
                $composer$iv = $composer3;
                if (Intrinsics.areEqual(contentStatus, EmptyContent.INSTANCE)) {
                    $composer2 = $composer3;
                    $composer2.startReplaceGroup(-1117136868);
                    ComposerKt.sourceInformation($composer2, "126@4563L29,126@4540L53");
                    ComposerKt.sourceInformationMarkerStart($composer2, -867319410, "CC(remember):BlockingItemPage.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit BlockingItemPage$lambda$4$0$0;
                            BlockingItemPage$lambda$4$0$0 = BlockingItemPageKt.BlockingItemPage$lambda$4$0$0(function1);
                            return BlockingItemPage$lambda$4$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EmptyPage((Function0) it$iv, $composer2, 0);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2 = $composer3;
                    $composer2.startReplaceGroup(-1117029732);
                    ComposerKt.sourceInformation($composer2, "130@4700L31,130@4647L85");
                    ContentStatus contentStatus2 = page.getContentStatus();
                    ComposerKt.sourceInformationMarkerStart($composer2, -867315024, "CC(remember):BlockingItemPage.kt#9igjgp");
                    boolean invalid$iv2 = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv2 = new Function0() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit BlockingItemPage$lambda$4$1$0;
                            BlockingItemPage$lambda$4$1$0 = BlockingItemPageKt.BlockingItemPage$lambda$4$1$0(function1);
                            return BlockingItemPage$lambda$4$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    IMPageStatusKt.IMPageStatus(contentStatus2, false, null, null, null, (Function0) it$iv2, $composer2, 0, 30);
                    $composer2.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItemPage$lambda$5;
                    BlockingItemPage$lambda$5 = BlockingItemPageKt.BlockingItemPage$lambda$5(KBPageData.this, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItemPage$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$4$0$0(Function1 $onAction) {
        $onAction.invoke(KBActionAddItem.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemPage$lambda$4$1$0(Function1 $onAction) {
        $onAction.invoke(KBActionRetryLoad.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void EmptyPage(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv$iv;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function0, "onAddClick");
        Composer $composer2 = $composer.startRestartGroup(101978313);
        ComposerKt.sourceInformation($composer2, "C(EmptyPage)N(onAddClick)138@4831L1815:BlockingItemPage.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(101978313, $dirty2, -1, "im.keywordBlocking.EmptyPage (BlockingItemPage.kt:137)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 306470902, "CC(IMPageStatus)N(modifier,alignmentMethod,content)27@898L14,28@917L246:IMPageStatus.kt#uu6lp7");
            Modifier modifier$iv = Modifier.Companion;
            IMPageStatusAlignmentMethod alignmentMethod$iv = new IMPageStatusAlignmentMethod.CenterWithMinimumPadding(Dp.constructor-impl(144), null);
            Alignment alignment$iv = alignmentMethod$iv.getAlignment($composer2, (0 >> 3) & 14);
            Modifier it$iv = SizeKt.fillMaxSize$default(modifier$iv, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            Modifier modifier$iv$iv$iv = alignmentMethod$iv.applyModifier(it$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(alignment$iv, false);
            int $changed$iv$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv$iv);
            Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv$iv);
            } else {
                factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -555003426, "C37@1148L9:IMPageStatus.kt#uu6lp7");
            int i4 = (0 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1632354868, "C139@4854L1786:BlockingItemPage.kt#sbjqfg");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1430537170, "C144@5045L51,145@5147L14,143@5012L207,150@5262L49,151@5347L6,152@5395L9,149@5233L191,156@5467L49,157@5552L6,158@5600L9,155@5438L190,164@5757L6,161@5642L988:BlockingItemPage.kt#sbjqfg");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_empty(CommonRes.INSTANCE.getDrawable()), $composer2, 0), (String) null, IMStatusKt.dayNightTint(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), $composer2, 6), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer2, Painter.$stable | 48, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_864(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16b(), $composer2, 0, 0, 131066);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_865(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131066);
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), Dp.constructor-impl(24), Dp.constructor-impl(5));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1540279193, "C171@6138L17,172@6194L6,170@6089L241,177@6380L57,178@6477L9,179@6530L6,176@6347L269:BlockingItemPage.kt#sbjqfg");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getPlus_add_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_124(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 0, 130042);
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
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmptyPage$lambda$1;
                    EmptyPage$lambda$1 = BlockingItemPageKt.EmptyPage$lambda$1(function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return EmptyPage$lambda$1;
                }
            });
        }
    }
}