package kntr.app.mall.product.details.page.ui.components;

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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CoverVO;
import kntr.app.mall.product.details.page.api.model.LabelObject;
import kntr.app.mall.product.details.page.api.model.RecFloor;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: RecFloorComponent.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"TITLE_BACK_IMG", "", "TITLE_BACK_IMG_NIGHT", "MAIN_TITLE_ICON", "BLIND_BOX_TAG", "RecFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "RecommendItemComponent", "item", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/ShopItem;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "tagMeasure", "", "tag", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "tagHeight", "Landroidx/compose/ui/unit/Dp;", "tagMeasure-TDGSqEk", "(Lkntr/app/mall/product/details/page/api/model/LabelObject;FFLandroidx/compose/runtime/Composer;I)I", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RecFloorComponentKt {
    private static final String BLIND_BOX_TAG = "https://i0.hdslb.com/bfs/kfptfe/floor/8e4c0b22f172bcf7169cbeff99fe28b62da50fde.png";
    private static final String MAIN_TITLE_ICON = "//i0.hdslb.com/bfs/kfptfe/floor/dbb46b6ec6a1fb12568b41bddcc6365cd5baea0d.png";
    private static final String TITLE_BACK_IMG = "https://i0.hdslb.com/bfs/kfptfe/floor/1b54ee4105b24baadfb4f7b678c88c1c670841b5.png";
    private static final String TITLE_BACK_IMG_NIGHT = "https://i0.hdslb.com/bfs/kfptfe/floor/86941cccba4110f585ada976d42b5a57cfd2bd41.png";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$1(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$5(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendItemComponent$lambda$1(ShopItem shopItem, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecommendItemComponent(shopItem, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RecFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(-747878912);
        ComposerKt.sourceInformation($composer3, "C(RecFloorComponent)N(module,pageViewModelWrapper,modifier)75@3584L16,78@3661L25,87@3977L72,82@3745L304,93@4229L5824,80@3692L6361:RecFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 32 : 16;
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
                ComposerKt.traceEventStart(-747878912, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.RecFloorComponent (RecFloorComponent.kt:66)");
            }
            if (module instanceof ContentModule.RecModule) {
                final RecFloor floorData = ((ContentModule.RecModule) module).getData();
                List<ShopItem> items = floorData.getItems();
                if (!(items == null || items.isEmpty())) {
                    final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    final float scale = RecFloorComponent$lambda$2(scaleModel$delegate).getScale();
                    final CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
                    String str = "rec_floor_item_header_" + floorData.hashCode();
                    ComposerKt.sourceInformationMarkerStart($composer3, -1452070296, "CC(remember):RecFloorComponent.kt#9igjgp");
                    boolean invalid$iv = $composer3.changedInstance(pageViewModel);
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit RecFloorComponent$lambda$3$0;
                                RecFloorComponent$lambda$3$0 = RecFloorComponentKt.RecFloorComponent$lambda$3$0(PageViewModel.this);
                                return RecFloorComponent$lambda$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2 = $composer3;
                    PaddingCardKt.PaddingCard(ExposerKt.reportOnExposure(modifier3, str, collectorHolder, null, false, 0.5f, 0, 0L, (Function0) it$iv, $composer2, (($dirty2 >> 6) & 14) | 221184, 100), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(271727963, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit RecFloorComponent$lambda$4;
                            RecFloorComponent$lambda$4 = RecFloorComponentKt.RecFloorComponent$lambda$4(scale, pageViewModel, floorData, collectorHolder, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return RecFloorComponent$lambda$4;
                        }
                    }, $composer2, 54), $composer2, 24960, 0);
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
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit RecFloorComponent$lambda$1;
                                RecFloorComponent$lambda$1 = RecFloorComponentKt.RecFloorComponent$lambda$1(ContentModule.this, pageViewModelWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return RecFloorComponent$lambda$1;
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
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RecFloorComponent$lambda$0;
                            RecFloorComponent$lambda$0 = RecFloorComponentKt.RecFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return RecFloorComponent$lambda$0;
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
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecFloorComponent$lambda$5;
                    RecFloorComponent$lambda$5 = RecFloorComponentKt.RecFloorComponent$lambda$5(ContentModule.this, pageViewModelWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RecFloorComponent$lambda$5;
                }
            });
        }
    }

    private static final UiScaleModel RecFloorComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$3$0(PageViewModel $pageViewModel) {
        $pageViewModel.reportRecFloorT3MoreShow$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0547, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0a6b, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0ac7, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit RecFloorComponent$lambda$4(float $scale, final PageViewModel $pageViewModel, final RecFloor $floorData, CollectorHolder $collectorHolder, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean isLight;
        String str;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        boolean z;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C94@4239L5808:RecFloorComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(271727963, $changed, -1, "kntr.app.mall.product.details.page.ui.components.RecFloorComponent.<anonymous> (RecFloorComponent.kt:94)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(222, $scale));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Composer $composer$iv$iv = $composer;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            Modifier materialized$iv$iv2 = materialized$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1751340001, "C100@4402L3256,177@7672L2365:RecFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(56, $scale));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Composer $composer2 = $composer;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$RecFloorComponent_u24lambda_u244_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 963745932, "C106@4602L21,109@4733L162,126@5460L2184:RecFloorComponent.kt#o90vz8");
            boolean isLight2 = ThemesKt.isCurrentThemeLight($composer, 0);
            String backgroundImage = isLight2 ? TITLE_BACK_IMG : TITLE_BACK_IMG_NIGHT;
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(backgroundImage);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer, 48, 508);
            if (isLight2) {
                $composer.startReplaceGroup(964044771);
                ComposerKt.sourceInformation($composer, "116@4992L432");
                String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(MAIN_TITLE_ICON);
                ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                Unit unit2 = Unit.INSTANCE;
                ImmutableImageRequest build = imageRequest2.build();
                isLight = isLight2;
                str = "C72@3469L9:Box.kt#2w3rfo";
                BiliImageKt.BiliImage(build, SizeKt.size-VpY3zN4(OffsetKt.offset-VpY3zN4($this$RecFloorComponent_u24lambda_u244_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopStart()), ProvideUiScaleKt.dpScaled(14, $scale), ProvideUiScaleKt.dpScaled(30, $scale)), ProvideUiScaleKt.dpScaled(44, $scale), ProvideUiScaleKt.dpScaled(8.25d, $scale)), null, null, null, null, null, null, null, $composer, 0, 508);
            } else {
                isLight = isLight2;
                str = "C72@3469L9:Box.kt#2w3rfo";
                $composer.startReplaceGroup(959098907);
            }
            $composer.endReplaceGroup();
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(16, $scale), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, $scale), 7, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$RecFloorComponent_u24lambda_u244_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -401097402, "C136@5902L6,137@5958L9,134@5816L217,140@6054L41,143@6209L6,144@6265L9,141@6116L279,153@6609L302,149@6417L1209:RecFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("会员购", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14b(), $composer, 6, 24576, 114682);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, $scale)), $composer, 0);
            TextKt.Text-Nvy7gAk("来会员购，享更多优惠", RowScope.-CC.weight$default($this$RecFloorComponent_u24lambda_u244_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 6, 24576, 114680);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1121293415, "CC(remember):RecFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($pageViewModel) | $composer.changedInstance($floorData);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit RecFloorComponent$lambda$4$0$0$0$0$0;
                    RecFloorComponent$lambda$4$0$0$0$0$0 = RecFloorComponentKt.RecFloorComponent$lambda$4$0$0$0$0$0(PageViewModel.this, $floorData);
                    return RecFloorComponent$lambda$4$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $i$f$Row = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, $i$f$Row);
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -817030511, "C162@7055L6,163@7115L9,160@6961L318,168@7361L28,170@7491L6,167@7304L300:RecFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("去逛逛", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, $scale), 0.0f, 11, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 6, 24576, 114680);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scale)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv5 = SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(48, $scale), 0.0f, 0.0f, 13, (Object) null), ProvideUiScaleKt.dpScaled(158, $scale));
            String str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, str3);
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv5 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv = $composer2;
            String str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, str4);
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv10);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            CompositionLocalMap localMap$iv$iv6 = localMap$iv$iv5;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
            String str5 = str2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, str5);
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            Composer $composer$iv = $composer2;
            Composer $composer3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer2, -558110004, "C188@8076L21,184@7918L2105:RecFloorComponent.kt#o90vz8");
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv5;
            Modifier modifier$iv6 = ScrollKt.horizontalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            boolean z2 = true;
            Composer $composer4 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv6 = (384 << 3) & 112;
            Alignment.Vertical verticalAlignment$iv4 = verticalAlignment$iv3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv7 = $composer2.getCurrentCompositionLocalMap();
            Arrangement.Horizontal horizontalArrangement$iv4 = horizontalArrangement$iv3;
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer2, modifier$iv6);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier$iv$iv = modifier$iv6;
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, str4);
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer2.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer2);
            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv6;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            CompositionLocalMap localMap$iv$iv8 = localMap$iv$iv7;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
            int $changed$iv = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i11 = ((384 >> 6) & 112) | 6;
            Composer $composer5 = $composer2;
            Composer $composer$iv2 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer5, 2120739356, "C191@8208L42,223@9963L42:RecFloorComponent.kt#o90vz8");
            Composer $composer$iv$iv$iv2 = $composer2;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, $scale)), $composer5, 0);
            $composer5.startReplaceGroup(206960665);
            ComposerKt.sourceInformation($composer5, "*206@9079L188,201@8719L548,209@9278L346,196@8480L1440");
            Iterable $this$forEachIndexed$iv = $floorData.getItems();
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final ShopItem item = (ShopItem) item$iv;
                final int index = index$iv;
                if (index > 0) {
                    $composer5.startReplaceGroup(-849750415);
                    ComposerKt.sourceInformation($composer5, "194@8388L41");
                    z = z2;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, $scale)), $composer5, 0);
                } else {
                    z = z2;
                    $composer5.startReplaceGroup(-858045550);
                }
                $composer5.endReplaceGroup();
                int $changed$iv2 = $changed$iv;
                MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv$iv2;
                Modifier modifier2 = SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(100, $scale));
                String str6 = "rec_floor_item_" + item.getItemsId();
                ComposerKt.sourceInformationMarkerStart($composer5, 803895852, "CC(remember):RecFloorComponent.kt#9igjgp");
                boolean invalid$iv2 = $composer5.changedInstance($pageViewModel) | $composer5.changedInstance(item) | $composer5.changed(index);
                Composer $this$cache$iv = $composer5;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit RecFloorComponent$lambda$4$0$1$0$0$0$0;
                        RecFloorComponent$lambda$4$0$1$0$0$0$0 = RecFloorComponentKt.RecFloorComponent$lambda$4$0$1$0$0$0$0(PageViewModel.this, item, index);
                        return RecFloorComponent$lambda$4$0$1$0$0$0$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Modifier reportOnExposure = ExposerKt.reportOnExposure(modifier2, str6, $collectorHolder, null, true, 0.5f, 0, 0L, (Function0) it$iv2, $composer5, 221184, 100);
                ComposerKt.sourceInformationMarkerStart($composer5, 803902378, "CC(remember):RecFloorComponent.kt#9igjgp");
                boolean invalid$iv3 = $composer5.changedInstance($pageViewModel) | $composer5.changedInstance(item) | $composer5.changed(index);
                Composer $this$cache$iv2 = $composer5;
                Object it$iv3 = $this$cache$iv2.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit RecFloorComponent$lambda$4$0$1$0$0$1$0;
                        RecFloorComponent$lambda$4$0$1$0$0$1$0 = RecFloorComponentKt.RecFloorComponent$lambda$4$0$1$0$0$1$0(PageViewModel.this, item, index);
                        return RecFloorComponent$lambda$4$0$1$0$0$1$0;
                    }
                };
                $this$cache$iv2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Modifier modifier$iv7 = ClickableKt.clickable-oSLSa3U$default(reportOnExposure, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                Composer $composer$iv3 = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, str3);
                Composer $composer6 = $composer5;
                Alignment contentAlignment$iv4 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                int $changed$iv$iv7 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv9 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv7);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    $composer$iv3.createNode(factory$iv$iv$iv12);
                } else {
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, str5);
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i13 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1898414169, "C216@9682L212:RecFloorComponent.kt#o90vz8");
                Composer $composer$iv$iv2 = $composer$iv$iv;
                CompositionLocalMap localMap$iv$iv10 = localMap$iv$iv6;
                Modifier materialized$iv$iv9 = materialized$iv$iv2;
                Composer $composer$iv$iv3 = $composer$iv$iv$iv;
                Composer $composer$iv$iv4 = $composer3;
                Composer $composer$iv$iv$iv3 = $composer4;
                RecommendItemComponent(item, $scale, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer$iv3, 384, 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv$iv$iv2 = $composer$iv$iv$iv2;
                $composer$iv2 = $composer$iv2;
                $composer5 = $composer6;
                index$iv = index$iv2;
                $changed$iv = $changed$iv2;
                measurePolicy$iv$iv2 = measurePolicy$iv$iv3;
                str4 = str4;
                str5 = str5;
                str3 = str3;
                localMap$iv$iv8 = localMap$iv$iv8;
                modifier$iv$iv = modifier$iv$iv;
                verticalAlignment$iv4 = verticalAlignment$iv4;
                horizontalArrangement$iv4 = horizontalArrangement$iv4;
                $composer$iv = $composer$iv;
                $composer4 = $composer$iv$iv$iv3;
                localMap$iv$iv6 = localMap$iv$iv10;
                $composer3 = $composer$iv$iv4;
                $composer$iv$iv = $composer$iv$iv2;
                $composer$iv$iv$iv = $composer$iv$iv3;
                materialized$iv$iv2 = materialized$iv$iv9;
                z2 = z;
                $composer2 = $composer2;
                measurePolicy$iv$iv = measurePolicy$iv$iv;
            }
            Composer $composer7 = $composer5;
            Composer $composer$iv$iv5 = $composer$iv$iv$iv;
            Composer $composer$iv$iv6 = $composer3;
            Composer $composer$iv$iv$iv4 = $composer4;
            Composer $composer$iv$iv$iv5 = $composer$iv$iv$iv2;
            $composer7.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, $scale)), $composer7, 0);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$4$0$0$0$0$0(PageViewModel $pageViewModel, RecFloor $floorData) {
        $pageViewModel.reportRecFloorT3MoreClick$product_details_page_debug();
        String jumpUrl = $floorData.getJumpUrl();
        $pageViewModel.handleJumpUrl$product_details_page_debug(jumpUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$4$0$1$0$0$0$0(PageViewModel $pageViewModel, ShopItem $item, int $index) {
        $pageViewModel.reportRecFloorItemShow$product_details_page_debug($item, $index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecFloorComponent$lambda$4$0$1$0$0$1$0(PageViewModel $pageViewModel, ShopItem $item, int $index) {
        $pageViewModel.reportRecFloorItemClick$product_details_page_debug($item, $index);
        ShopItem.JumpUrlVO jumpUrlVO = $item.getJumpUrlVO();
        String jumpUrl = jumpUrlVO != null ? jumpUrlVO.getJumpUrlNA() : null;
        $pageViewModel.handleJumpUrl$product_details_page_debug(jumpUrl);
        return Unit.INSTANCE;
    }

    private static final void RecommendItemComponent(final ShopItem item, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        List<LabelObject> emptyList;
        List<LabelObject> emptyList2;
        int inlineWidth;
        Function0 factory$iv$iv$iv5;
        Composer $composer3 = $composer.startRestartGroup(-355283787);
        ComposerKt.sourceInformation($composer3, "C(RecommendItemComponent)N(item,scale,modifier)236@10186L6739:RecFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scale) ? 32 : 16;
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
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-355283787, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.RecommendItemComponent (RecFloorComponent.kt:235)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            modifier3 = modifier4;
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 885614090, "C237@10221L6698:RecFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1615146567, "C244@10476L6,240@10300L589,257@10903L3647,336@14564L2345:RecFloorComponent.kt#o90vz8");
            Modifier modifier$iv3 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale))), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1355879246, "C:RecFloorComponent.kt#o90vz8");
            CoverVO coverVO = item.getCoverVO();
            String imgUrl = coverVO != null ? coverVO.getUrl() : null;
            String str = imgUrl;
            if (str == null || str.length() == 0) {
                $composer3.startReplaceGroup(1345430447);
            } else {
                $composer3.startReplaceGroup(1355952281);
                ComposerKt.sourceInformation($composer3, "248@10619L238");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(imgUrl);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(100, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 36487318, "C291@12222L6,308@13074L1416,288@12111L2425:RecFloorComponent.kt#o90vz8");
            List $this$RecommendItemComponent_u24lambda_u240_u240_u241_u240 = CollectionsKt.createListBuilder();
            ShopItem.LabelGroup feedLabel = item.getFeedLabel();
            if (feedLabel == null || (emptyList = feedLabel.getFrontTag()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            $this$RecommendItemComponent_u24lambda_u240_u240_u241_u240.addAll(emptyList);
            ShopItem.LabelGroup feedTag = item.getFeedTag();
            if (feedTag == null || (emptyList2 = feedTag.getFrontTag()) == null) {
                emptyList2 = CollectionsKt.emptyList();
            }
            $this$RecommendItemComponent_u24lambda_u240_u240_u241_u240.addAll(emptyList2);
            List frontTags = CollectionsKt.build($this$RecommendItemComponent_u24lambda_u240_u240_u241_u240);
            final LabelObject frontTag = (LabelObject) CollectionsKt.firstOrNull(frontTags);
            boolean isBlindBox = frontTag != null;
            AnnotatedString.Builder $this$RecommendItemComponent_u24lambda_u240_u240_u241_u241 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            if (isBlindBox) {
                InlineTextContentKt.appendInlineContent($this$RecommendItemComponent_u24lambda_u240_u240_u241_u241, "tag", "[tag]");
            }
            String itemsName = item.getItemsName();
            if (itemsName == null) {
                itemsName = "";
            }
            $this$RecommendItemComponent_u24lambda_u240_u240_u241_u241.append(itemsName);
            AnnotatedString text = $this$RecommendItemComponent_u24lambda_u240_u240_u241_u241.toAnnotatedString();
            if (isBlindBox) {
                $composer3.startReplaceGroup(37090298);
                ComposerKt.sourceInformation($composer3, "280@11829L184");
                inlineWidth = m515tagMeasureTDGSqEk(frontTag, scale, ProvideUiScaleKt.dpScaled(17, scale), $composer3, $dirty2 & 112) + 4;
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(37324565);
                $composer3.endReplaceGroup();
                inlineWidth = 0;
            }
            TextKt.Text-Z58ophY(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, MapsKt.mapOf(TuplesKt.to("tag", new InlineTextContent(new Placeholder(ProvideUiScaleKt.spScaled(inlineWidth, scale), ProvideUiScaleKt.spScaled(17, scale), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(1395183096, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RecommendItemComponent$lambda$0$0$1$2;
                    RecommendItemComponent$lambda$0$0$1$2 = RecFloorComponentKt.RecommendItemComponent$lambda$0$0$1$2(scale, frontTag, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RecommendItemComponent$lambda$0$0$1$2;
                }
            }, $composer3, 54)))), (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24960, 176122);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv5 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv5 << 6;
            int $changed$iv$iv$iv5 = ($i$f$Row & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i12 = ((384 >> 6) & 112) | 6;
            RowScope $this$RecommendItemComponent_u24lambda_u240_u240_u242 = RowScopeInstance.INSTANCE;
            $composer3.startReplaceGroup(39105427);
            ComposerKt.sourceInformation($composer3, "C346@14987L6,344@14883L491,358@15495L6,356@15391L491,370@16000L6,368@15899L488,382@16508L6,380@16404L491:RecFloorComponent.kt#o90vz8");
            ShopItem.PriceInfoVO priceInfo = item.getPriceInfoVO();
            if (priceInfo == null) {
                $composer3.endReplaceGroup();
            } else {
                String pricePrefix = priceInfo.getPricePrefix();
                String str2 = pricePrefix == null ? "" : pricePrefix;
                BiliTheme biliTheme = BiliTheme.INSTANCE;
                int $changed$iv$iv$iv6 = BiliTheme.$stable;
                TextKt.Text-Nvy7gAk(str2, $this$RecommendItemComponent_u24lambda_u240_u240_u242.alignByBaseline(Modifier.Companion), biliTheme.getColors($composer3, $changed$iv$iv$iv6).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(15), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114680);
                String priceSymbol = priceInfo.getPriceSymbol();
                TextKt.Text-Nvy7gAk(priceSymbol == null ? "" : priceSymbol, $this$RecommendItemComponent_u24lambda_u240_u240_u242.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(15), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114680);
                String netPrice = priceInfo.getNetPrice();
                TextKt.Text-Nvy7gAk(netPrice == null ? "" : netPrice, $this$RecommendItemComponent_u24lambda_u240_u240_u242.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114680);
                String priceSuffix = priceInfo.getPriceSuffix();
                TextKt.Text-Nvy7gAk(priceSuffix == null ? "" : priceSuffix, $this$RecommendItemComponent_u24lambda_u240_u240_u242.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(15), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114680);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.RecFloorComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecommendItemComponent$lambda$1;
                    RecommendItemComponent$lambda$1 = RecFloorComponentKt.RecommendItemComponent$lambda$1(ShopItem.this, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RecommendItemComponent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendItemComponent$lambda$0$0$1$2(float $scale, LabelObject $frontTag, String it, Composer $composer, int $changed) {
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)309@13112L1344:RecFloorComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1395183096, $changed, -1, "kntr.app.mall.product.details.page.ui.components.RecommendItemComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecFloorComponent.kt:309)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, $scale), 0.0f, 11, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv);
            } else {
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
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1962649235, "C:RecFloorComponent.kt#o90vz8");
            if ($frontTag != null) {
                $composer.startReplaceGroup(1962713280);
                ComposerKt.sourceInformation($composer, "317@13592L784");
                Modifier modifier$iv$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                $composer$iv$iv$iv = $composer;
                $composer$iv = $composer;
                LabelComponentKt.m491LabelComponentTN_CM5M($frontTag, $scale, ProvideUiScaleKt.dpScaled(17, $scale), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), modifier$iv$iv, $composer, 24576, 0);
                $composer.endReplaceGroup();
                $composer2 = $composer;
            } else {
                $composer$iv$iv$iv = $composer;
                $composer$iv = $composer;
                $composer2 = $composer;
                $composer2.startReplaceGroup(1949204720);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: tagMeasure-TDGSqEk  reason: not valid java name */
    public static final int m515tagMeasureTDGSqEk(LabelObject tag, float scale, float f, Composer $composer, int $changed) {
        Integer tagType;
        int tagWidth;
        int i;
        Intrinsics.checkNotNullParameter(tag, "tag");
        ComposerKt.sourceInformationMarkerStart($composer, -1594913645, "C(tagMeasure)N(tag,scale,tagHeight:c#ui.unit.Dp)403@17057L22:RecFloorComponent.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1594913645, $changed, -1, "kntr.app.mall.product.details.page.ui.components.tagMeasure (RecFloorComponent.kt:402)");
        }
        TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer, 0, 1);
        TextStyle textStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
        Integer tagType2 = tag.getTagType();
        boolean isImage = tagType2 != null && tagType2.intValue() == 2;
        if (isImage) {
            Integer tagVersion = tag.getTagVersion();
            if (tagVersion != null && tagVersion.intValue() == 2) {
                double targetHeight = f;
                Double backImgHeight = tag.getBackImgHeight();
                double originalHeight = backImgHeight != null ? backImgHeight.doubleValue() : targetHeight;
                Double backImgWidth = tag.getBackImgWidth();
                imageWidth = backImgWidth != null ? backImgWidth.doubleValue() : 0.0d;
                imageWidth *= targetHeight / originalHeight;
                tagWidth = MathKt.roundToInt(imageWidth);
            }
            Double backImgWidth2 = tag.getBackImgWidth();
            if (backImgWidth2 != null) {
                imageWidth = backImgWidth2.doubleValue();
            }
            tagWidth = MathKt.roundToInt(imageWidth);
        } else {
            Integer tagType3 = tag.getTagType();
            if (tagType3 != null && tagType3.intValue() == 1) {
                i = 2;
            } else {
                Integer tagType4 = tag.getTagType();
                if (tagType4 != null && tagType4.intValue() == 3) {
                    i = 2;
                } else {
                    Integer tagType5 = tag.getTagType();
                    if ((tagType5 != null && tagType5.intValue() == 4) || ((tagType = tag.getTagType()) != null && tagType.intValue() == 5)) {
                        Integer tagType6 = tag.getTagType();
                        if (tagType6 != null && tagType6.intValue() == 5) {
                            Double rightIconImgWidth = tag.getRightIconImgWidth();
                            if (rightIconImgWidth != null) {
                                imageWidth = rightIconImgWidth.doubleValue();
                            }
                        } else {
                            Double backImgWidth3 = tag.getBackImgWidth();
                            if (backImgWidth3 != null) {
                                imageWidth = backImgWidth3.doubleValue();
                            }
                        }
                        double imageWidth = imageWidth;
                        String title = tag.getTitle();
                        int textWidth = (int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(title != null ? title : "", (List) null, 2, (DefaultConstructorMarker) null), textStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32);
                        tagWidth = MathKt.roundToInt(imageWidth + textWidth + 12 + 2);
                    } else {
                        tagWidth = 0;
                    }
                }
            }
            String title2 = tag.getTitle();
            tagWidth = 12 + ((int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(title2 != null ? title2 : "", (List) null, i, (DefaultConstructorMarker) null), textStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return tagWidth;
    }
}