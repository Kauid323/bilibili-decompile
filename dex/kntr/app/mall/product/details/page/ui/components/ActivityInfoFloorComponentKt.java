package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import androidx.compose.ui.text.style.TextOverflow;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityInfoFloorComponent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"ActivityInfoFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ActivityInfoFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityInfoFloorComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityInfoFloorComponent$lambda$1(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityInfoFloorComponent$lambda$4(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ActivityInfoFloorComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(2052960455);
        ComposerKt.sourceInformation($composer3, "C(ActivityInfoFloorComponent)N(module,pageViewModel,modifier)45@1790L16,62@2279L3311,47@1812L3778:ActivityInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052960455, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponent (ActivityInfoFloorComponent.kt:35)");
            }
            if (module instanceof ContentModule.ActivityInfoModule) {
                ActivityInfoFloor floorData = ((ContentModule.ActivityInfoModule) module).getData();
                final List activityInfo = floorData.getActivityInfoList();
                List list = activityInfo;
                if (!(list == null || list.isEmpty())) {
                    final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    $composer2 = $composer3;
                    PaddingCardKt.PaddingCard(modifier3, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, ActivityInfoFloorComponent$lambda$2(scaleModel$delegate).getScale()), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, ActivityInfoFloorComponent$lambda$2(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, ActivityInfoFloorComponent$lambda$2(scaleModel$delegate).getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, ActivityInfoFloorComponent$lambda$2(scaleModel$delegate).getScale())), ComposableLambdaKt.rememberComposableLambda(590160524, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponentKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit ActivityInfoFloorComponent$lambda$3;
                            ActivityInfoFloorComponent$lambda$3 = ActivityInfoFloorComponentKt.ActivityInfoFloorComponent$lambda$3(scaleModel$delegate, activityInfo, pageViewModel, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return ActivityInfoFloorComponent$lambda$3;
                        }
                    }, $composer3, 54), $composer3, (($dirty2 >> 6) & 14) | 24576, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier4 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponentKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ActivityInfoFloorComponent$lambda$1;
                                ActivityInfoFloorComponent$lambda$1 = ActivityInfoFloorComponentKt.ActivityInfoFloorComponent$lambda$1(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ActivityInfoFloorComponent$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ActivityInfoFloorComponent$lambda$0;
                            ActivityInfoFloorComponent$lambda$0 = ActivityInfoFloorComponentKt.ActivityInfoFloorComponent$lambda$0(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ActivityInfoFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit ActivityInfoFloorComponent$lambda$4;
                    ActivityInfoFloorComponent$lambda$4 = ActivityInfoFloorComponentKt.ActivityInfoFloorComponent$lambda$4(ContentModule.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ActivityInfoFloorComponent$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel ActivityInfoFloorComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x035a, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ActivityInfoFloorComponent$lambda$3(State $scaleModel$delegate, List $activityInfo, PageViewModel $pageViewModel, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Iterable $this$forEachIndexed$iv;
        boolean z;
        int compositeKeyHash$iv$iv;
        Function0 factory$iv$iv$iv3;
        String str;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv4;
        String str2;
        Composer $composer$iv;
        final PageViewModel pageViewModel = $pageViewModel;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C63@2289L3295:ActivityInfoFloorComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590160524, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponent.<anonymous> (ActivityInfoFloorComponent.kt:63)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            String str3 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
            String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            String str6 = "C101@5233L9:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1322826471, "C71@2519L6,72@2567L9,69@2450L244,75@2707L2867:ActivityInfoFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("活动", SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale())), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()), $composer, 6, 0, 131064);
            Composer $composer$iv2 = $composer;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv2, $i$f$Row);
            int $changed$iv$iv2 = (0 << 3) & 112;
            Composer $composer$iv$iv = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv2 = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv2.startReusableNode();
            if ($composer$iv$iv$iv2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer$iv$iv$iv2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer$iv$iv$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            Composer $composer$iv3 = $composer$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1129926267, "C:ActivityInfoFloorComponent.kt#o90vz8");
            $composer$iv3.startReplaceGroup(517740497);
            ComposerKt.sourceInformation($composer$iv3, "*83@3060L122,80@2940L2602");
            List $this$forEachIndexed$iv2 = $activityInfo;
            boolean z2 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv2) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ActivityInfoFloor.ActivityInfoModel activityModel = (ActivityInfoFloor.ActivityInfoModel) item$iv;
                if (index$iv > 0) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    $composer$iv3.startReplaceGroup(-1887315771);
                    ComposerKt.sourceInformation($composer$iv3, "78@2843L54");
                    z = z2;
                    compositeKeyHash$iv$iv = compositeKeyHash$iv$iv3;
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale())), $composer$iv3, 0);
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z = z2;
                    compositeKeyHash$iv$iv = compositeKeyHash$iv$iv3;
                    $composer$iv3.startReplaceGroup(-1890114389);
                }
                $composer$iv3.endReplaceGroup();
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1169252015, "CC(remember):ActivityInfoFloorComponent.kt#9igjgp");
                boolean invalid$iv = $composer$iv3.changedInstance(pageViewModel);
                Object it$iv = $composer$iv3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityInfoFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit ActivityInfoFloorComponent$lambda$3$0$0$0$0$0;
                        ActivityInfoFloorComponent$lambda$3$0$0$0$0$0 = ActivityInfoFloorComponentKt.ActivityInfoFloorComponent$lambda$3$0$0$0$0$0(PageViewModel.this);
                        return ActivityInfoFloorComponent$lambda$3$0$0$0$0$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, str3);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                Modifier materialized$iv$iv3 = materialized$iv$iv2;
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str4);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer$iv3.getCurrentCompositionLocalMap();
                CompositionLocalMap localMap$iv$iv4 = localMap$iv$iv2;
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                int $changed$iv$iv$iv4 = $changed$iv$iv$iv2;
                String str7 = str3;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str5);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer$iv3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv3);
                Composer $composer$iv4 = $composer$iv2;
                Composer $composer$iv$iv2 = $composer$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, str6);
                int i6 = ((384 >> 6) & 112) | 6;
                RowScope $this$ActivityInfoFloorComponent_u24lambda_u243_u240_u240_u240_u241 = RowScopeInstance.INSTANCE;
                String str8 = str6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1006243904, "C120@5113L28,121@5188L6,119@5056L464:ActivityInfoFloorComponent.kt#o90vz8");
                String it = activityModel.getActLabel();
                if (it == null) {
                    $composer$iv3.startReplaceGroup(-1006257236);
                    $composer$iv3.endReplaceGroup();
                    str2 = str5;
                    $composer$iv = $composer$iv3;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    str = str4;
                } else {
                    $composer$iv3.startReplaceGroup(-1006257235);
                    ComposerKt.sourceInformation($composer$iv3, "*94@3648L6,89@3362L958");
                    Modifier modifier2 = Modifier.Companion;
                    float dpScaled = ProvideUiScaleKt.dpScaled(1, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale());
                    BiliTheme biliTheme = BiliTheme.INSTANCE;
                    int $changed$iv$iv$iv5 = BiliTheme.$stable;
                    Modifier modifier$iv4 = PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(modifier2, dpScaled, biliTheme.getColors($composer$iv3, $changed$iv$iv$iv5).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()))), ProvideUiScaleKt.dpScaled(4, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(1, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()));
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str4);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer$iv3.getCurrentCompositionLocalMap();
                    str = str4;
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv4);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv4 << 6) & 896) | 6;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str5);
                    if (!($composer$iv3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv3.startReusableNode();
                    if ($composer$iv3.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer$iv3.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer$iv3.useNode();
                    }
                    str2 = str5;
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv3);
                    $composer$iv = $composer$iv3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i7 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i8 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034881841, "C101@4144L6,102@4217L9,99@4037L253:ActivityInfoFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(it, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT12(), ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()), $composer$iv3, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    Unit unit = Unit.INSTANCE;
                    $composer$iv3.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                String it2 = activityModel.getActText();
                if (it2 == null) {
                    $composer$iv3.startReplaceGroup(-1005211575);
                    $composer$iv3.endReplaceGroup();
                } else {
                    $composer$iv3.startReplaceGroup(-1005211574);
                    ComposerKt.sourceInformation($composer$iv3, "*109@4527L6,110@4591L9,107@4428L577");
                    TextKt.Text-Nvy7gAk(it2, PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$ActivityInfoFloorComponent_u24lambda_u243_u240_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), ProvideUiScaleKt.dpScaled(8, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT13(), ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()), $composer$iv3, 0, 24960, 110584);
                    Unit unit3 = Unit.INSTANCE;
                    $composer$iv3.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                }
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer$iv3, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(10, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, ActivityInfoFloorComponent$lambda$2($scaleModel$delegate).getScale())), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText3-0d7_KjU(), $composer$iv3, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                pageViewModel = $pageViewModel;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                index$iv = index$iv2;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                compositeKeyHash$iv$iv3 = compositeKeyHash$iv$iv;
                z2 = z;
                materialized$iv$iv2 = materialized$iv$iv3;
                localMap$iv$iv2 = localMap$iv$iv4;
                str3 = str7;
                $changed$iv$iv$iv2 = $changed$iv$iv$iv4;
                $composer$iv$iv = $composer$iv$iv2;
                $composer$iv2 = $composer$iv4;
                str6 = str8;
                str4 = str;
                str5 = str2;
                $composer$iv3 = $composer$iv;
            }
            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
            $composer$iv3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityInfoFloorComponent$lambda$3$0$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }
}