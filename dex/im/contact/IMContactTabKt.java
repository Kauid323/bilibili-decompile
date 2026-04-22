package im.contact;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
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
import im.base.ContentStatus;
import im.base.IMListStatusKt;
import im.base.IMPageStatusAlignmentMethod;
import im.base.IMPageStatusKt;
import im.base.IdleContent;
import im.contact.item.IMContactItemKt;
import im.contact.model.IMContactActionEnterSearch;
import im.contact.model.IMContactActionExitSearch;
import im.contact.model.IMContactActionLoadMore;
import im.contact.model.IMContactActionSearch;
import im.contact.model.IMContactItem;
import im.contact.model.IMContactRefresh;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabDataKt;
import java.util.List;
import kntr.common.compose.list.LoadMoreListStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMContactTab.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"IMContactTab", "", "tabData", "Lim/contact/model/IMContactTab;", "eventHandler", "Lim/contact/IMContactPageEventHandler;", "(Lim/contact/model/IMContactTab;Lim/contact/IMContactPageEventHandler;Landroidx/compose/runtime/Composer;I)V", "IMContactSearchInput", "keyword", "", "inSearchMode", "", "(Ljava/lang/String;ZLim/contact/IMContactPageEventHandler;Landroidx/compose/runtime/Composer;I)V", "contact-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactTabKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactSearchInput$lambda$3(String str, boolean z, IMContactPageEventHandler iMContactPageEventHandler, int i2, Composer composer, int i3) {
        IMContactSearchInput(str, z, iMContactPageEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$2(IMContactTab iMContactTab, IMContactPageEventHandler iMContactPageEventHandler, int i2, Composer composer, int i3) {
        IMContactTab(iMContactTab, iMContactPageEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0200, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMContactTab(final IMContactTab tabData, final IMContactPageEventHandler eventHandler, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer2 = $composer.startRestartGroup(1784146490);
        ComposerKt.sourceInformation($composer2, "C(IMContactTab)N(tabData,eventHandler)65@2794L23,66@2861L67,66@2828L100,69@2933L2534:IMContactTab.kt#f3r7fa");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(tabData) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(eventHandler) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1784146490, $dirty2, -1, "im.contact.IMContactTab (IMContactTab.kt:64)");
            }
            LazyListState state = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer2, 872831517, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function1) new IMContactTabKt$IMContactTab$1$1(eventHandler, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LoadMoreListStateKt.applyLoadMoreEffects(state, 3, (Function1) null, (Function1) it$iv, $composer2, 48, 2);
            Modifier modifier$iv$iv = SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
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
            int i3 = ((6 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1782969344, "C75@3196L12,77@3282L17,78@3311L2150,70@2982L2479:IMContactTab.kt#f3r7fa");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer2, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1050853318, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit IMContactTab$lambda$1$0$0;
                    IMContactTab$lambda$1$0$0 = IMContactTabKt.IMContactTab$lambda$1$0$0(IMContactTab.this, eventHandler, (LazyListScope) obj);
                    return IMContactTab$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(fillMaxSize$default, state, asPaddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer2, 6, (int) TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_FAILED);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactTab$lambda$2;
                    IMContactTab$lambda$2 = IMContactTabKt.IMContactTab$lambda$2(IMContactTab.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactTab$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$1$0$0(final IMContactTab $tabData, final IMContactPageEventHandler $eventHandler, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        if ($tabData.getCanSearch()) {
            LazyListScope.-CC.item$default($this$LazyColumn, "search", (Object) null, ComposableLambdaKt.composableLambdaInstance(1848962884, true, new Function3() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMContactTab$lambda$1$0$0$0;
                    IMContactTab$lambda$1$0$0$0 = IMContactTabKt.IMContactTab$lambda$1$0$0$0(IMContactTab.this, $eventHandler, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMContactTab$lambda$1$0$0$0;
                }
            }), 2, (Object) null);
        }
        if ($tabData.getShowList().isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, "page_status", (Object) null, ComposableLambdaKt.composableLambdaInstance(1035631789, true, new Function3() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMContactTab$lambda$1$0$0$1;
                    IMContactTab$lambda$1$0$0$1 = IMContactTabKt.IMContactTab$lambda$1$0$0$1(IMContactTab.this, $eventHandler, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMContactTab$lambda$1$0$0$1;
                }
            }), 2, (Object) null);
        } else {
            final List items$iv = $tabData.getShowList();
            final Function2 key$iv = new Function2() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Object IMContactTab$lambda$1$0$0$2;
                    IMContactTab$lambda$1$0$0$2 = IMContactTabKt.IMContactTab$lambda$1$0$0$2(((Integer) obj).intValue(), (IMContactItem) obj2);
                    return IMContactTab$lambda$1$0$0$2;
                }
            };
            $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: im.contact.IMContactTabKt$IMContactTab$lambda$1$0$0$$inlined$itemsIndexed$default$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    return key$iv.invoke(Integer.valueOf(index), items$iv.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: im.contact.IMContactTabKt$IMContactTab$lambda$1$0$0$$inlined$itemsIndexed$default$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    items$iv.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: im.contact.IMContactTabKt$IMContactTab$lambda$1$0$0$$inlined$itemsIndexed$default$3
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed($this$items) ? 4 : 2;
                    }
                    if (($changed & 48) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                        }
                        Object obj = items$iv.get(it);
                        int $changed2 = ($dirty & 14) | ($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                        IMContactItem item = (IMContactItem) obj;
                        $composer.startReplaceGroup(-2102601259);
                        ComposerKt.sourceInformation($composer, "CN(index,item)*111@4662L431:IMContactTab.kt#f3r7fa");
                        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.Companion;
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
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 2001040342, "C119@5038L33:IMContactTab.kt#f3r7fa");
                        if (it > 0) {
                            $composer.startReplaceGroup(2001080982);
                            ComposerKt.sourceInformation($composer, "114@4809L6,113@4740L247");
                            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(71), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 54, 0);
                        } else {
                            $composer.startReplaceGroup(1996370253);
                        }
                        $composer.endReplaceGroup();
                        IMContactItemKt.IMContactItem(item, $eventHandler, $composer, ($changed2 >> 6) & 14);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }));
            if (!Intrinsics.areEqual(IMContactTabDataKt.getFootStatus($tabData), IdleContent.INSTANCE)) {
                LazyListScope.-CC.item$default($this$LazyColumn, "foot_status", (Object) null, ComposableLambdaKt.composableLambdaInstance(-730271095, true, new Function3() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit IMContactTab$lambda$1$0$0$4;
                        IMContactTab$lambda$1$0$0$4 = IMContactTabKt.IMContactTab$lambda$1$0$0$4(IMContactTab.this, $eventHandler, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return IMContactTab$lambda$1$0$0$4;
                    }
                }), 2, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$1$0$0$0(IMContactTab $tabData, IMContactPageEventHandler $eventHandler, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C81@3409L207:IMContactTab.kt#f3r7fa");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848962884, $changed, -1, "im.contact.IMContactTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMContactTab.kt:81)");
            }
            IMContactSearchInput($tabData.getSearchWord(), $tabData.getInSearch(), $eventHandler, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$1$0$0$1(IMContactTab $tabData, final IMContactPageEventHandler $eventHandler, LazyItemScope $this$item, Composer $composer, int $changed) {
        String emptyText;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C101@4317L100,97@4066L374:IMContactTab.kt#f3r7fa");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035631789, $changed, -1, "im.contact.IMContactTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMContactTab.kt:91)");
            }
            if ($tabData.getInSearch()) {
                $composer.startReplaceGroup(1756625516);
                ComposerKt.sourceInformation($composer, "93@3852L49");
                String stringResource = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_859(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                emptyText = stringResource;
            } else {
                $composer.startReplaceGroup(1756735845);
                ComposerKt.sourceInformation($composer, "95@3963L56");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_66(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                emptyText = stringResource2;
            }
            ContentStatus contentStatus = IMContactTabDataKt.getContentStatus($tabData);
            IMPageStatusAlignmentMethod.TopWithPadding topWithPadding = new IMPageStatusAlignmentMethod.TopWithPadding(Dp.constructor-impl(144), null);
            ComposerKt.sourceInformationMarkerStart($composer, -1190244815, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv = $composer.changed($eventHandler);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit IMContactTab$lambda$1$0$0$1$0$0;
                        IMContactTab$lambda$1$0$0$1$0$0 = IMContactTabKt.IMContactTab$lambda$1$0$0$1$0$0(IMContactPageEventHandler.this);
                        return IMContactTab$lambda$1$0$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IMPageStatusKt.IMPageStatus(contentStatus, false, emptyText, topWithPadding, null, (Function0) it$iv, $composer, IMPageStatusAlignmentMethod.TopWithPadding.$stable << 9, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$1$0$0$1$0$0(IMContactPageEventHandler $eventHandler) {
        $eventHandler.getActionHandler().invoke(IMContactRefresh.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object IMContactTab$lambda$1$0$0$2(int i2, IMContactItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Long.valueOf(item.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$1$0$0$4(IMContactTab $tabData, final IMContactPageEventHandler $eventHandler, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C125@5289L107,125@5242L155:IMContactTab.kt#f3r7fa");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-730271095, $changed, -1, "im.contact.IMContactTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMContactTab.kt:125)");
            }
            ContentStatus footStatus = IMContactTabDataKt.getFootStatus($tabData);
            ComposerKt.sourceInformationMarkerStart($composer, -1710850604, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv = $composer.changed($eventHandler);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit IMContactTab$lambda$1$0$0$4$0$0;
                        IMContactTab$lambda$1$0$0$4$0$0 = IMContactTabKt.IMContactTab$lambda$1$0$0$4$0$0(IMContactPageEventHandler.this);
                        return IMContactTab$lambda$1$0$0$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IMListStatusKt.IMPageFootStatus(footStatus, null, (Function0) it$iv, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactTab$lambda$1$0$0$4$0$0(IMContactPageEventHandler $eventHandler) {
        $eventHandler.getActionHandler().invoke(IMContactActionLoadMore.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0402, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0569  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMContactSearchInput(String keyword, boolean inSearchMode, final IMContactPageEventHandler eventHandler, Composer $composer, final int $changed) {
        Composer $composer2;
        final String str;
        final IMContactPageEventHandler iMContactPageEventHandler;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        String str2;
        int $dirty;
        int i2;
        Composer $composer4;
        final boolean z = inSearchMode;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer5 = $composer.startRestartGroup(-2027105229);
        ComposerKt.sourceInformation($composer5, "C(IMContactSearchInput)N(keyword,inSearchMode,eventHandler)142@5639L49,145@5730L7,146@5771L133,146@5742L162,153@5909L2671:IMContactTab.kt#f3r7fa");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer5.changed(keyword) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer5.changed(z) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer5.changed(eventHandler) ? 256 : 128;
        }
        int $dirty3 = $dirty2;
        if (!$composer5.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
            $composer2 = $composer5;
            str = keyword;
            iMContactPageEventHandler = eventHandler;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2027105229, $dirty3, -1, "im.contact.IMContactSearchInput (IMContactTab.kt:140)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, 1867032068, "CC(remember):IMContactTab.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FocusRequester();
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            FocusRequester focus = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer5.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            FocusManager focusManager = (FocusManager) consume;
            Boolean valueOf = Boolean.valueOf(inSearchMode);
            ComposerKt.sourceInformationMarkerStart($composer5, 1867036376, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | $composer5.changedInstance(focusManager);
            Object it$iv2 = $composer5.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new IMContactTabKt$IMContactSearchInput$1$1(z, focus, focusManager, null);
                $composer5.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer5, ($dirty3 >> 3) & 14);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            $composer2 = $composer5;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(factory$iv$iv$iv2);
            } else {
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$IMContactSearchInput_u24lambda_u242 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer5, 2073104828, "C166@6352L6,161@6182L1968:IMContactTab.kt#f3r7fa");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$IMContactSearchInput_u24lambda_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(32)), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getGraph_bg_regular-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(10), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$IMContactSearchInput_u24lambda_u242_u240 = rowScope2;
            ComposerKt.sourceInformationMarkerStart($composer5, -1612899856, "C172@6641L25,173@6701L6,171@6596L244,180@6927L49,181@7010L57,186@7248L214,191@7502L9,178@6854L711:IMContactTab.kt#f3r7fa");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer5, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(2), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText4-0d7_KjU(), $composer5, Painter.$stable | 432, 0);
            String stringResource = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_860(Res.string.INSTANCE), $composer5, 0);
            ComposerKt.sourceInformationMarkerStart($composer5, -1437490588, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv2 = ($dirty3 & 896) == 256;
            Object it$iv3 = $composer5.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function1() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit IMContactSearchInput$lambda$2$0$0$0;
                    IMContactSearchInput$lambda$2$0$0$0 = IMContactTabKt.IMContactSearchInput$lambda$2$0$0$0(IMContactPageEventHandler.this, (String) obj);
                    return IMContactSearchInput$lambda$2$0$0$0;
                }
            };
            $composer5.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function1 function1 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Modifier focusRequester = FocusRequesterModifierKt.focusRequester(RowScope.-CC.weight$default($this$IMContactSearchInput_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), focus);
            ComposerKt.sourceInformationMarkerStart($composer5, -1437482815, "CC(remember):IMContactTab.kt#9igjgp");
            boolean invalid$iv3 = ($dirty3 & 896) == 256;
            Object it$iv4 = $composer5.rememberedValue();
            if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer5);
                str = keyword;
                SimpleTextFieldKt.SimpleTextField(str, stringResource, function1, FocusChangedModifierKt.onFocusChanged(focusRequester, (Function1) it$iv4), BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT14(), (TextStyle) null, false, true, 0, (KeyboardOptions) null, (KeyboardActions) null, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer5, ($dirty3 & 14) | 12582912, 0, 16224);
                if (StringsKt.isBlank(str)) {
                    $composer3 = $composer5;
                    $composer3.startReplaceGroup(-1611913344);
                    ComposerKt.sourceInformation($composer3, "197@7672L27,198@7738L6,201@7860L188,196@7623L503");
                    Painter xmark_close_circle_fill_500 = BiliIconfont.INSTANCE.getXmark_close_circle_fill_500($composer3, 6);
                    long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_weak-0d7_KjU();
                    Modifier modifier = Modifier.Companion;
                    str2 = "CC(remember):IMContactTab.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer3, -1437463257, str2);
                    $dirty = $dirty3;
                    i2 = 256;
                    boolean invalid$iv4 = ($dirty & 896) == 256;
                    Object it$iv5 = $composer3.rememberedValue();
                    if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                        iMContactPageEventHandler = eventHandler;
                        Object value$iv4 = new Function0() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit IMContactSearchInput$lambda$2$0$2$0;
                                IMContactSearchInput$lambda$2$0$2$0 = IMContactTabKt.IMContactSearchInput$lambda$2$0$2$0(IMContactPageEventHandler.this);
                                return IMContactSearchInput$lambda$2$0$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv5 = value$iv4;
                    } else {
                        iMContactPageEventHandler = eventHandler;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    IconKt.Icon-ww6aTOc(xmark_close_circle_fill_500, (String) null, SizeKt.size-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null), Dp.constructor-impl(16)), j, $composer3, Painter.$stable | 48, 0);
                } else {
                    iMContactPageEventHandler = eventHandler;
                    $composer3 = $composer5;
                    str2 = "CC(remember):IMContactTab.kt#9igjgp";
                    $dirty = $dirty3;
                    i2 = 256;
                    $composer3.startReplaceGroup(-1619491945);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                z = inSearchMode;
                if (!z) {
                    $composer4 = $composer5;
                    $composer4.startReplaceGroup(2075036127);
                    ComposerKt.sourceInformation($composer4, "213@8221L57,214@8314L6,215@8367L9,217@8448L101,212@8192L372");
                    String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_238(Res.string.INSTANCE), $composer4, 0);
                    long j2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14();
                    Modifier modifier2 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2006607220, str2);
                    boolean invalid$iv5 = ($dirty & 896) == i2;
                    Object it$iv6 = $composer4.rememberedValue();
                    if (invalid$iv5 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit IMContactSearchInput$lambda$2$1$0;
                                IMContactSearchInput$lambda$2$1$0 = IMContactTabKt.IMContactSearchInput$lambda$2$1$0(IMContactPageEventHandler.this);
                                return IMContactSearchInput$lambda$2$1$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv5);
                        it$iv6 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    TextKt.Text-Nvy7gAk(stringResource2, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv6, 15, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14, $composer4, 0, 0, 131064);
                } else {
                    $composer4 = $composer5;
                    $composer4.startReplaceGroup(2066897139);
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv6 = new Function1() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit IMContactSearchInput$lambda$2$0$1$0;
                    IMContactSearchInput$lambda$2$0$1$0 = IMContactTabKt.IMContactSearchInput$lambda$2$0$1$0(IMContactPageEventHandler.this, (FocusState) obj);
                    return IMContactSearchInput$lambda$2$0$1$0;
                }
            };
            $composer5.updateRememberedValue(value$iv6);
            it$iv4 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            str = keyword;
            SimpleTextFieldKt.SimpleTextField(str, stringResource, function1, FocusChangedModifierKt.onFocusChanged(focusRequester, (Function1) it$iv4), BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT14(), (TextStyle) null, false, true, 0, (KeyboardOptions) null, (KeyboardActions) null, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer5, ($dirty3 & 14) | 12582912, 0, 16224);
            if (StringsKt.isBlank(str)) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            z = inSearchMode;
            if (!z) {
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.contact.IMContactTabKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMContactSearchInput$lambda$3;
                    IMContactSearchInput$lambda$3 = IMContactTabKt.IMContactSearchInput$lambda$3(str, z, iMContactPageEventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMContactSearchInput$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactSearchInput$lambda$2$0$0$0(IMContactPageEventHandler $eventHandler, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $eventHandler.getActionHandler().invoke(new IMContactActionSearch(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactSearchInput$lambda$2$0$1$0(IMContactPageEventHandler $eventHandler, FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (focusState.isFocused()) {
            $eventHandler.getActionHandler().invoke(IMContactActionEnterSearch.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactSearchInput$lambda$2$0$2$0(IMContactPageEventHandler $eventHandler) {
        $eventHandler.getActionHandler().invoke(new IMContactActionSearch(""));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMContactSearchInput$lambda$2$1$0(IMContactPageEventHandler $eventHandler) {
        $eventHandler.getActionHandler().invoke(IMContactActionExitSearch.INSTANCE);
        return Unit.INSTANCE;
    }
}