package im.contact;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.ContentStatus;
import im.base.IMPageStatusKt;
import im.base.IMTopBarKt;
import im.contact.di.IMContactEntryPoint;
import im.contact.model.IMContactActionTabChange;
import im.contact.model.IMContactPageData;
import im.contact.model.IMContactRefresh;
import im.contact.model.IMContactTab;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: IMContactPage.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u0002\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG_PAGE", "", "IMContactPage", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "viewModel", "Lim/contact/IMContactViewModel;", "(Lim/contact/IMContactViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "state", "Lim/contact/IMContactPageState;", "(Landroidx/compose/foundation/layout/ColumnScope;Lim/contact/IMContactPageState;Landroidx/compose/runtime/Composer;I)V", "contact-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageKt {
    public static final String TAG_PAGE = "IMContact-page";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$1(Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMContactPage(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$4(IMContactViewModel iMContactViewModel, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMContactPage(iMContactViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$6(ColumnScope columnScope, IMContactPageState iMContactPageState, int i2, Composer composer, int i3) {
        IMContactPage(columnScope, iMContactPageState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void IMContactPage(Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1844558025);
        ComposerKt.sourceInformation($composer2, "C(IMContactPage)N(modifier)53@2171L24,55@2244L203,62@2452L34:IMContactPage.kt#f3r7fa");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844558025, $dirty, -1, "im.contact.IMContactPage (IMContactPage.kt:52)");
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
            ComposerKt.sourceInformationMarkerStart($composer2, -1201226540, "CC(remember):IMContactPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((IMContactEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IMContactEntryPoint.class))).getComponentFactory().create(scope).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            IMContactViewModel viewModel = (IMContactViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IMContactPage(viewModel, modifier3, $composer2, ($dirty << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactPage$lambda$1;
                    IMContactPage$lambda$1 = IMContactPageKt.IMContactPage$lambda$1(modifier3, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactPage$lambda$1;
                }
            });
        }
    }

    public static final void IMContactPage(final IMContactViewModel viewModel, final Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer2 = $composer.startRestartGroup(1971471095);
        ComposerKt.sourceInformation($composer2, "C(IMContactPage)N(viewModel,modifier)70@2634L16,72@2675L98,75@2788L426,75@2778L436:IMContactPage.kt#f3r7fa");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i3 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1971471095, $dirty2, -1, "im.contact.IMContactPage (IMContactPage.kt:69)");
            }
            State dataState = SnapshotStateKt.collectAsState(viewModel.getDataFlow(), (CoroutineContext) null, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, 503150393, "CC(remember):IMContactPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new IMContactPageState(dataState, new IMContactPageKt$IMContactPage$state$1$1(viewModel));
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final IMContactPageState state = (IMContactPageState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(186388143, true, new Function2() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactPage$lambda$3;
                    IMContactPage$lambda$3 = IMContactPageKt.IMContactPage$lambda$3(modifier, state, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactPage$lambda$3;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactPage$lambda$4;
                    IMContactPage$lambda$4 = IMContactPageKt.IMContactPage$lambda$4(IMContactViewModel.this, modifier, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactPage$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$3(Modifier $modifier, IMContactPageState $state, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C76@2815L28,77@2863L20,82@3033L6,78@2892L316:IMContactPage.kt#f3r7fa");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(186388143, $changed, -1, "im.contact.IMContactPage.<anonymous> (IMContactPage.kt:76)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope $this$IMContactPage_u24lambda_u243_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 2075047210, "C84@3070L95,85@3178L20:IMContactPage.kt#f3r7fa");
            IMTopBarKt.m3090IMTopBarnWoaYo(ComposableSingletons$IMContactPageKt.INSTANCE.getLambda$1851973866$contact_ui_debug(), null, 0L, 0L, false, false, null, null, null, $composer, 6, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
            IMContactPage($this$IMContactPage_u24lambda_u243_u240, $state, $composer, ((((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6) & 14) | 48);
            ComposerKt.sourceInformationMarkerEnd($composer);
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

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0197, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0308, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMContactPage(final ColumnScope $this$IMContactPage, final IMContactPageState state, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Iterable $this$forEachIndexed$iv;
        TextStyle style;
        Composer $this$cache$iv;
        Function0 factory$iv$iv$iv4;
        Modifier modifier$iv$iv;
        Function0 value$iv;
        Composer $composer2;
        Composer $composer3;
        Composer $composer4;
        MeasurePolicy measurePolicy$iv$iv;
        MeasurePolicy measurePolicy$iv$iv2;
        Composer $composer$iv$iv;
        String str;
        Composer $composer$iv$iv$iv2;
        Alignment.Vertical verticalAlignment$iv;
        CompositionLocalMap localMap$iv$iv;
        PagerState pagerState;
        CoroutineScope scope;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv5;
        Arrangement.Vertical verticalArrangement$iv;
        Intrinsics.checkNotNullParameter($this$IMContactPage, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer5 = $composer.startRestartGroup(654257160);
        ComposerKt.sourceInformation($composer5, "C(IMContactPage)N(state)93@3334L2940:IMContactPage.kt#f3r7fa");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed($this$IMContactPage) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changed(state) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer5.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(654257160, $dirty2, -1, "im.contact.IMContactPage (IMContactPage.kt:91)");
            }
            final IMContactPageData page = (IMContactPageData) state.getPage().getValue();
            Modifier modifier$iv = ColumnScope.-CC.weight$default($this$IMContactPage, SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier$iv$iv2 = modifier$iv;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer5.useNode();
            }
            Function0 factory$iv$iv$iv7 = factory$iv$iv$iv;
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            Composer $composer6 = $composer5;
            ComposerKt.sourceInformationMarkerStart($composer6, 1842543685, "C101@3538L82,99@3456L175:IMContactPage.kt#f3r7fa");
            ContentStatus pageContentStatus = page.getPageContentStatus();
            String str2 = "CC(remember):IMContactPage.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer6, 1167815444, "CC(remember):IMContactPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
            Object it$iv = $composer6.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit IMContactPage$lambda$5$0$0;
                    IMContactPage$lambda$5$0$0 = IMContactPageKt.IMContactPage$lambda$5$0$0(IMContactPageState.this);
                    return IMContactPage$lambda$5$0$0;
                }
            };
            $composer6.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            IMPageStatusKt.IMPageStatus(pageContentStatus, false, null, null, null, (Function0) it$iv, $composer6, 0, 30);
            if (page.getTabList().isEmpty()) {
                $composer$iv$iv$iv = $composer5;
                $composer6.startReplaceGroup(1839027168);
                $composer6.endReplaceGroup();
            } else {
                $composer6.startReplaceGroup(1842750299);
                ComposerKt.sourceInformation($composer6, "106@3685L2573");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv, $composer6, ((6 >> 3) & 14) | ((6 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv2 = (6 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                Composer $composer$iv$iv2 = $composer6;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer$iv$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv2);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                Arrangement.Vertical verticalArrangement$iv3 = verticalArrangement$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv2.startReusableNode();
                if ($composer$iv$iv2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer$iv$iv2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer$iv$iv2.useNode();
                }
                Function0 factory$iv$iv$iv9 = factory$iv$iv$iv2;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                MeasurePolicy measurePolicy$iv$iv4 = measurePolicy$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ColumnScope $this$IMContactPage_u24lambda_u245_u241 = columnScope;
                Composer $composer$iv$iv$iv3 = $composer$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -2050812945, "C108@3835L65,108@3782L118,111@3917L1526,144@5499L349,144@5460L388,157@6097L37,158@6154L90,151@5865L379:IMContactPage.kt#f3r7fa");
                int selectedIndex = page.getSelectedIndex();
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 349487186, "CC(remember):IMContactPage.kt#9igjgp");
                boolean invalid$iv2 = $composer$iv$iv2.changed(page);
                Composer $composer$iv2 = $composer$iv$iv2;
                Object it$iv2 = $composer$iv$iv2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv3 = new Function0() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        int IMContactPage$lambda$5$1$0$0;
                        IMContactPage$lambda$5$1$0$0 = IMContactPageKt.IMContactPage$lambda$5$1$0$0(IMContactPageData.this);
                        return Integer.valueOf(IMContactPage$lambda$5$1$0$0);
                    }
                };
                $composer$iv$iv2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                Composer $composer$iv$iv3 = $composer$iv$iv2;
                PagerState pagerState2 = PagerStateKt.rememberPagerState(selectedIndex, (float) CropImageView.DEFAULT_ASPECT_RATIO, (Function0) it$iv2, $composer$iv$iv3, 0, 2);
                Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(40));
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(56), Alignment.Companion.getCenterHorizontally());
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv2, $composer$iv$iv2, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv3 = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                Alignment.Vertical verticalAlignment$iv3 = verticalAlignment$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer$iv$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv3);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                Composer $composer$iv$iv4 = $composer$iv$iv2;
                $composer$iv$iv$iv = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv2.startReusableNode();
                if ($composer$iv$iv2.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer$iv$iv2.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer$iv$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv$iv2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i7 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                Composer $composer7 = $composer$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer7, 1022853337, "C123@4416L24:IMContactPage.kt#f3r7fa");
                CompositionLocalMap localMap$iv$iv5 = localMap$iv$iv4;
                ComposerKt.sourceInformationMarkerStart($composer7, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer7, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object value$iv$iv = $composer7.rememberedValue();
                if (value$iv$iv == Composer.Companion.getEmpty()) {
                    value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer7);
                    $composer7.updateRememberedValue(value$iv$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                CoroutineScope scope2 = (CoroutineScope) value$iv$iv;
                $composer7.startReplaceGroup(1279923428);
                ComposerKt.sourceInformation($composer7, "*135@5063L313,131@4879L524");
                Iterable $this$forEachIndexed$iv2 = page.getTabList();
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv2) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    final IMContactTab tab = (IMContactTab) item$iv;
                    final int index = index$iv;
                    if (index == page.getSelectedIndex()) {
                        $composer7.startReplaceGroup(136063257);
                        ComposerKt.sourceInformation($composer7, "127@4646L9,127@4676L6");
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        TextStyle textStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT14b(), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                        $composer7.endReplaceGroup();
                        style = textStyle;
                    } else {
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        $composer7.startReplaceGroup(136190295);
                        ComposerKt.sourceInformation($composer7, "129@4774L9,129@4811L6");
                        TextStyle textStyle2 = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                        $composer7.endReplaceGroup();
                        style = textStyle2;
                    }
                    String name = tab.getName();
                    Modifier modifier = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer7, -272690584, str2);
                    boolean invalid$iv3 = $composer5.changed(index) | (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | $composer5.changed(tab) | $composer5.changedInstance(scope2) | $composer5.changed(pagerState2);
                    Composer $this$cache$iv2 = $composer7;
                    Modifier materialized$iv$iv4 = materialized$iv$iv3;
                    Object it$iv3 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv3) {
                        $this$cache$iv = $this$cache$iv2;
                    } else {
                        $this$cache$iv = $this$cache$iv2;
                        if (it$iv3 != Composer.Companion.getEmpty()) {
                            $composer2 = $composer7;
                            pagerState = pagerState2;
                            scope = scope2;
                            $composer$iv$iv = $composer$iv$iv2;
                            value$iv = it$iv3;
                            $composer3 = $composer$iv$iv3;
                            $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                            $composer$iv = $composer$iv2;
                            verticalAlignment$iv = verticalAlignment$iv3;
                            localMap$iv$iv = localMap$iv$iv5;
                            str = str2;
                            $composer4 = $composer$iv$iv4;
                            measurePolicy$iv$iv = measurePolicy$iv$iv3;
                            measurePolicy$iv$iv2 = measurePolicy$iv$iv4;
                            Modifier modifier2 = modifier$iv$iv2;
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            modifier$iv$iv = modifier2;
                            Arrangement.Vertical vertical = verticalArrangement$iv3;
                            factory$iv$iv$iv5 = factory$iv$iv$iv9;
                            verticalArrangement$iv = vertical;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            TextKt.Text-Nvy7gAk(name, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, style, $composer2, 0, 0, 131068);
                            str2 = str;
                            measurePolicy$iv$iv4 = measurePolicy$iv$iv2;
                            scope2 = scope;
                            localMap$iv$iv5 = localMap$iv$iv;
                            index$iv = index$iv2;
                            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                            $composer7 = $composer2;
                            $composer$iv$iv2 = $composer$iv$iv;
                            $composer$iv2 = $composer$iv;
                            pagerState2 = pagerState;
                            measurePolicy$iv$iv3 = measurePolicy$iv$iv;
                            $composer$iv$iv4 = $composer4;
                            verticalAlignment$iv3 = verticalAlignment$iv;
                            $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                            $composer$iv$iv3 = $composer3;
                            materialized$iv$iv3 = materialized$iv$iv4;
                            Function0 function0 = factory$iv$iv$iv4;
                            modifier$iv$iv2 = modifier$iv$iv;
                            factory$iv$iv$iv7 = function0;
                            Function0 function02 = factory$iv$iv$iv5;
                            verticalArrangement$iv3 = verticalArrangement$iv;
                            factory$iv$iv$iv9 = function02;
                        }
                    }
                    Modifier modifier3 = modifier$iv$iv2;
                    factory$iv$iv$iv4 = factory$iv$iv$iv7;
                    modifier$iv$iv = modifier3;
                    $composer2 = $composer7;
                    $composer3 = $composer$iv$iv3;
                    $composer4 = $composer$iv$iv4;
                    measurePolicy$iv$iv = measurePolicy$iv$iv3;
                    measurePolicy$iv$iv2 = measurePolicy$iv$iv4;
                    $composer$iv$iv = $composer$iv$iv2;
                    str = str2;
                    final CoroutineScope coroutineScope = scope2;
                    $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                    verticalAlignment$iv = verticalAlignment$iv3;
                    localMap$iv$iv = localMap$iv$iv5;
                    final PagerState pagerState3 = pagerState2;
                    pagerState = pagerState2;
                    scope = scope2;
                    $composer$iv = $composer$iv2;
                    Arrangement.Vertical vertical2 = verticalArrangement$iv3;
                    factory$iv$iv$iv5 = factory$iv$iv$iv9;
                    verticalArrangement$iv = vertical2;
                    value$iv = new Function0() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit IMContactPage$lambda$5$1$1$0$0$0;
                            IMContactPage$lambda$5$1$1$0$0$0 = IMContactPageKt.IMContactPage$lambda$5$1$1$0$0$0(IMContactPageState.this, tab, coroutineScope, pagerState3, index);
                            return IMContactPage$lambda$5$1$1$0$0$0;
                        }
                    };
                    $this$cache$iv.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextKt.Text-Nvy7gAk(name, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, style, $composer2, 0, 0, 131068);
                    str2 = str;
                    measurePolicy$iv$iv4 = measurePolicy$iv$iv2;
                    scope2 = scope;
                    localMap$iv$iv5 = localMap$iv$iv;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    $composer7 = $composer2;
                    $composer$iv$iv2 = $composer$iv$iv;
                    $composer$iv2 = $composer$iv;
                    pagerState2 = pagerState;
                    measurePolicy$iv$iv3 = measurePolicy$iv$iv;
                    $composer$iv$iv4 = $composer4;
                    verticalAlignment$iv3 = verticalAlignment$iv;
                    $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                    $composer$iv$iv3 = $composer3;
                    materialized$iv$iv3 = materialized$iv$iv4;
                    Function0 function03 = factory$iv$iv$iv4;
                    modifier$iv$iv2 = modifier$iv$iv;
                    factory$iv$iv$iv7 = function03;
                    Function0 function022 = factory$iv$iv$iv5;
                    verticalArrangement$iv3 = verticalArrangement$iv;
                    factory$iv$iv$iv9 = function022;
                }
                Composer $composer8 = $composer7;
                PagerState pagerState4 = pagerState2;
                Composer $composer$iv$iv5 = $composer$iv$iv2;
                Composer $composer9 = $composer$iv$iv3;
                Composer $composer$iv$iv$iv4 = $composer$iv$iv$iv3;
                Composer $composer$iv3 = $composer$iv2;
                String str3 = str2;
                Composer $composer10 = $composer$iv$iv4;
                $composer8.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                $composer$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer10);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                Integer valueOf = Integer.valueOf(pagerState4.getCurrentPage());
                ComposerKt.sourceInformationMarkerStart($composer9, 349540718, str3);
                boolean invalid$iv4 = $composer5.changed(pagerState4) | $composer5.changed(page) | (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32);
                Object it$iv4 = $composer9.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = (Function2) new IMContactPageKt$IMContactPage$4$2$2$1(pagerState4, page, state, null);
                    $composer9.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer9);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv4, $composer9, 0);
                Modifier weight$default = ColumnScope.-CC.weight$default($this$IMContactPage_u24lambda_u245_u241, SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer9, 349559542, str3);
                boolean invalid$iv5 = $composer9.changed(page);
                Object it$iv5 = $composer9.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Object IMContactPage$lambda$5$1$3$0;
                            IMContactPage$lambda$5$1$3$0 = IMContactPageKt.IMContactPage$lambda$5$1$3$0(IMContactPageData.this, ((Integer) obj).intValue());
                            return IMContactPage$lambda$5$1$3$0;
                        }
                    };
                    $composer9.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer9);
                PagerKt.HorizontalPager--8jOkeI(pagerState4, weight$default, (PaddingValues) null, (PageSize) null, 0, (float) CropImageView.DEFAULT_ASPECT_RATIO, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) it$iv5, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(54783472, true, new Function4() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit IMContactPage$lambda$5$1$4;
                        IMContactPage$lambda$5$1$4 = IMContactPageKt.IMContactPage$lambda$5$1$4(IMContactPageData.this, state, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return IMContactPage$lambda$5$1$4;
                    }
                }, $composer9, 54), $composer9, 0, 24576, 15356);
                ComposerKt.sourceInformationMarkerEnd($composer9);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv$iv$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv5);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endReplaceGroup();
                $composer6 = $composer6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer5.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer5.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.contact.IMContactPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactPage$lambda$6;
                    IMContactPage$lambda$6 = IMContactPageKt.IMContactPage$lambda$6($this$IMContactPage, state, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactPage$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$5$0$0(IMContactPageState $state) {
        $state.getEventHandler().getActionHandler().invoke(IMContactRefresh.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int IMContactPage$lambda$5$1$0$0(IMContactPageData $page) {
        return $page.getTabList().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$5$1$1$0$0$0(IMContactPageState $state, IMContactTab $tab, CoroutineScope $scope, PagerState $pagerState, int $index) {
        $state.getEventHandler().getActionHandler().invoke(new IMContactActionTabChange($tab.getCurrentTab()));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMContactPageKt$IMContactPage$4$2$1$1$1$1$1($pagerState, $index, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object IMContactPage$lambda$5$1$3$0(IMContactPageData $page, int it) {
        return Integer.valueOf($page.getTabList().get(it).getCurrentTab().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactPage$lambda$5$1$4(IMContactPageData $page, IMContactPageState $state, PagerScope $this$HorizontalPager, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(it)159@6176L50:IMContactPage.kt#f3r7fa");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(54783472, $changed, -1, "im.contact.IMContactPage.<anonymous>.<anonymous>.<anonymous> (IMContactPage.kt:159)");
        }
        IMContactTabKt.IMContactTab($page.getTabList().get(it), $state.getEventHandler(), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}