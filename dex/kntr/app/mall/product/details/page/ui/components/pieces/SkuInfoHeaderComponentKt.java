package kntr.app.mall.product.details.page.ui.components.pieces;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkuInfoHeaderComponent.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a]\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0015H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002"}, d2 = {"SkuInfoHeaderComponent", "", "skuInfoFloor", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "isInPreview", "", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;ZLkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SkuSelectorComponent", "specInfoListItem", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;", "onHeaderSkuClick", "Lkotlin/Function0;", "scale", "", "selectedIndex", "", "onSelect", "Lkotlin/Function1;", "(ZLkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SkuInfoHeaderComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuInfoHeaderComponent$lambda$0(SkuInfoFloor skuInfoFloor, boolean z, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuInfoHeaderComponent(skuInfoFloor, z, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuInfoHeaderComponent$lambda$1(SkuInfoFloor skuInfoFloor, boolean z, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuInfoHeaderComponent(skuInfoFloor, z, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuInfoHeaderComponent$lambda$6(SkuInfoFloor skuInfoFloor, boolean z, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuInfoHeaderComponent(skuInfoFloor, z, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSelectorComponent$lambda$1(boolean z, SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoListItem, Function0 function0, float f, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        SkuSelectorComponent(z, specInfoListItem, function0, f, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSelectorComponent$lambda$3(boolean z, SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoListItem, Function0 function0, float f, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        SkuSelectorComponent(z, specInfoListItem, function0, f, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x02ff, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SkuInfoHeaderComponent(final SkuInfoFloor skuInfoFloor, final boolean isInPreview, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier$iv$iv;
        Modifier modifier3;
        List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem> specInfoList;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        Composer $composer$iv;
        Intrinsics.checkNotNullParameter(skuInfoFloor, "skuInfoFloor");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer2 = $composer.startRestartGroup(219542532);
        ComposerKt.sourceInformation($composer2, "C(SkuInfoHeaderComponent)N(skuInfoFloor,isInPreview,pageViewModel,modifier)53@2455L16,54@2525L16,57@2580L917:SkuInfoHeaderComponent.kt#v057zd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(skuInfoFloor) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isInPreview) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModel) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219542532, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponent (SkuInfoHeaderComponent.kt:48)");
            }
            SkuInfoFloor.ItemsSkuListVO skuInfo = skuInfoFloor.getItemsSkuListVO();
            if (skuInfo == null || (specInfoList = skuInfo.getSpecInfoList()) == null) {
                modifier3 = modifier4;
            } else {
                SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfo = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) CollectionsKt.firstOrNull(specInfoList);
                if (specInfo == null) {
                    modifier3 = modifier4;
                } else {
                    List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList = specInfo.getSpecValueVOList();
                    if (specValueVOList == null) {
                        final Modifier modifier5 = modifier4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SkuInfoHeaderComponent$lambda$1;
                                    SkuInfoHeaderComponent$lambda$1 = SkuInfoHeaderComponentKt.SkuInfoHeaderComponent$lambda$1(SkuInfoFloor.this, isInPreview, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return SkuInfoHeaderComponent$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    specValueVOList.size();
                    Iterable $this$map$iv = specInfo.getSpecValueVOList();
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem it = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) item$iv$iv;
                        destination$iv$iv.add(it.getSpecValueImg());
                    }
                    List imageList = (List) destination$iv$iv;
                    State selectedIndex$delegate = SnapshotStateKt.collectAsState(pageViewModel.getHeaderSkuSelectedIndex(), (CoroutineContext) null, $composer2, 0, 1);
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
                    float scale = SkuInfoHeaderComponent$lambda$4(scaleModel$delegate).getScale();
                    Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    modifier$iv$iv = modifier4;
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
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
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i4 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$SkuInfoHeaderComponent_u24lambda_u245 = BoxScopeInstance.INSTANCE;
                    $composer2.startReplaceGroup(-1242797997);
                    ComposerKt.sourceInformation($composer2, "C66@2800L134,78@3235L40,75@3112L90,71@2944L547:SkuInfoHeaderComponent.kt#v057zd");
                    String selectedImg = (String) imageList.get(SkuInfoHeaderComponent$lambda$3(selectedIndex$delegate));
                    String str = selectedImg;
                    if (str == null || str.length() == 0) {
                        $composer2.endReplaceGroup();
                        $composer$iv = $composer2;
                    } else {
                        String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(selectedImg);
                        BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer2, 48, 508);
                        int SkuInfoHeaderComponent$lambda$3 = SkuInfoHeaderComponent$lambda$3(selectedIndex$delegate);
                        Modifier modifier6 = OffsetKt.offset-VpY3zN4($this$SkuInfoHeaderComponent_u24lambda_u245.align(Modifier.Companion, Alignment.Companion.getBottomStart()), ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(-32, scale));
                        ComposerKt.sourceInformationMarkerStart($composer2, -2118283034, "CC(remember):SkuInfoHeaderComponent.kt#9igjgp");
                        boolean invalid$iv2 = $composer2.changedInstance(pageViewModel);
                        Object value$iv = $composer2.rememberedValue();
                        if (!invalid$iv2 && value$iv != Composer.Companion.getEmpty()) {
                            Function0 function0 = (Function0) value$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerStart($composer2, -2118286920, "CC(remember):SkuInfoHeaderComponent.kt#9igjgp");
                            invalid$iv = $composer2.changedInstance(pageViewModel);
                            Object it$iv = $composer2.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj) {
                                    Unit SkuInfoHeaderComponent$lambda$5$1$0;
                                    SkuInfoHeaderComponent$lambda$5$1$0 = SkuInfoHeaderComponentKt.SkuInfoHeaderComponent$lambda$5$1$0(PageViewModel.this, ((Integer) obj).intValue());
                                    return SkuInfoHeaderComponent$lambda$5$1$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv2);
                            it$iv = value$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer$iv = $composer2;
                            SkuSelectorComponent(isInPreview, specInfo, function0, scale, modifier6, SkuInfoHeaderComponent$lambda$3, (Function1) it$iv, $composer2, ($dirty2 >> 3) & 14, 0);
                            $composer2.endReplaceGroup();
                        }
                        value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit SkuInfoHeaderComponent$lambda$5$0$0;
                                SkuInfoHeaderComponent$lambda$5$0$0 = SkuInfoHeaderComponentKt.SkuInfoHeaderComponent$lambda$5$0$0(PageViewModel.this);
                                return SkuInfoHeaderComponent$lambda$5$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        Function0 function02 = (Function0) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -2118286920, "CC(remember):SkuInfoHeaderComponent.kt#9igjgp");
                        invalid$iv = $composer2.changedInstance(pageViewModel);
                        Object it$iv2 = $composer2.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv22 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                Unit SkuInfoHeaderComponent$lambda$5$1$0;
                                SkuInfoHeaderComponent$lambda$5$1$0 = SkuInfoHeaderComponentKt.SkuInfoHeaderComponent$lambda$5$1$0(PageViewModel.this, ((Integer) obj).intValue());
                                return SkuInfoHeaderComponent$lambda$5$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv22);
                        it$iv2 = value$iv22;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer$iv = $composer2;
                        SkuSelectorComponent(isInPreview, specInfo, function02, scale, modifier6, SkuInfoHeaderComponent$lambda$3, (Function1) it$iv2, $composer2, ($dirty2 >> 3) & 14, 0);
                        $composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
            if (endRestartGroup2 != null) {
                final Modifier modifier7 = modifier3;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SkuInfoHeaderComponent$lambda$0;
                        SkuInfoHeaderComponent$lambda$0 = SkuInfoHeaderComponentKt.SkuInfoHeaderComponent$lambda$0(SkuInfoFloor.this, isInPreview, pageViewModel, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return SkuInfoHeaderComponent$lambda$0;
                    }
                });
                return;
            }
            return;
        }
        $composer2.skipToGroupEnd();
        modifier$iv$iv = modifier2;
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier8 = modifier$iv$iv;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit SkuInfoHeaderComponent$lambda$6;
                    SkuInfoHeaderComponent$lambda$6 = SkuInfoHeaderComponentKt.SkuInfoHeaderComponent$lambda$6(SkuInfoFloor.this, isInPreview, pageViewModel, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SkuInfoHeaderComponent$lambda$6;
                }
            });
        }
    }

    private static final int SkuInfoHeaderComponent$lambda$3(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    private static final UiScaleModel SkuInfoHeaderComponent$lambda$4(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuInfoHeaderComponent$lambda$5$1$0(PageViewModel $pageViewModel, int index) {
        $pageViewModel.updateHeaderSkuSelectedIndex$product_details_page_debug(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuInfoHeaderComponent$lambda$5$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleHeaderSkuClick$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSelectorComponent$lambda$0$0(int it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0bc0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0bcc  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0bd2  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0d2f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0d3b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0d41  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0dbb  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0e38  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0e57  */
    /* JADX WARN: Type inference failed for: r5v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SkuSelectorComponent(final boolean isInPreview, final SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoListItem, final Function0<Unit> function0, final float scale, Modifier modifier, int selectedIndex, Function1<? super Integer, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        int selectedIndex2;
        Function1 onSelect;
        Modifier modifier3;
        int selectedIndex3;
        Function1 onSelect2;
        String str;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Modifier modifier4;
        Function0 factory$iv$iv$iv6;
        Composer $composer$iv;
        int imageCount;
        Composer $composer$iv$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer3;
        Composer $composer$iv3;
        Composer $composer$iv4;
        int selectedIndex4;
        Modifier materialized$iv$iv;
        int $changed$iv$iv$iv;
        Composer $composer$iv$iv$iv2;
        Modifier modifier5;
        final Function1 onSelect3;
        Composer $composer$iv5;
        Function0 factory$iv$iv$iv7;
        int imageCount2;
        Function0 factory$iv$iv$iv8;
        String specValueName;
        Composer $composer4;
        Composer $composer5;
        Intrinsics.checkNotNullParameter(specInfoListItem, "specInfoListItem");
        Intrinsics.checkNotNullParameter(function0, "onHeaderSkuClick");
        Composer $composer6 = $composer.startRestartGroup(2088953756);
        ComposerKt.sourceInformation($composer6, "C(SkuSelectorComponent)N(isInPreview,specInfoListItem,onHeaderSkuClick,scale,modifier,selectedIndex,onSelect)96@3787L2,115@4258L6441:SkuInfoHeaderComponent.kt#v057zd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer6.changed(isInPreview) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer6.changedInstance(specInfoListItem) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer6.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer6.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer6.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty |= $composer6.changed(selectedIndex) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
        } else if ((1572864 & $changed) == 0) {
            $dirty |= $composer6.changedInstance(function1) ? 1048576 : 524288;
        }
        if ($composer6.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                selectedIndex3 = selectedIndex;
            } else {
                selectedIndex3 = 0;
            }
            if (i4 == 0) {
                onSelect2 = function1;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer6, 1734840766, "CC(remember):SkuInfoHeaderComponent.kt#9igjgp");
                Object it$iv = $composer6.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit SkuSelectorComponent$lambda$0$0;
                            SkuSelectorComponent$lambda$0$0 = SkuInfoHeaderComponentKt.SkuSelectorComponent$lambda$0$0(((Integer) obj).intValue());
                            return SkuSelectorComponent$lambda$0$0;
                        }
                    };
                    $composer6.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onSelect4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer6);
                onSelect2 = onSelect4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2088953756, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.pieces.SkuSelectorComponent (SkuInfoHeaderComponent.kt:97)");
            }
            String specName = specInfoListItem.getSpecName();
            if ((specName != null ? specName.length() : 0) <= 2) {
                str = specInfoListItem.getSpecName();
                if (str == null) {
                    str = "规格";
                }
            } else {
                str = "规格";
            }
            String specName2 = str;
            List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList = specInfoListItem.getSpecValueVOList();
            int specCount = specValueVOList != null ? specValueVOList.size() : 0;
            if (specCount >= 2) {
                int $dirty2 = $dirty;
                Function1 onSelect5 = onSelect2;
                int selectedIndex5 = selectedIndex3;
                int $changed$iv = ($dirty2 >> 12) & 14;
                Modifier modifier$iv = modifier3;
                ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv9;
                    $composer6.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv9;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -167880100, "C118@4308L6385:SkuInfoHeaderComponent.kt#v057zd");
                Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(76, scale)), ProvideUiScaleKt.dpScaled(SkuSelectorComponent$calculatedSpecWidth(specCount), scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale))), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(6, scale));
                ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv10;
                    $composer6.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv10;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, 943241085, "C127@4693L1367,163@6074L4609:SkuInfoHeaderComponent.kt#v057zd");
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv3 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv11;
                    $composer6.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv11;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i10 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -1172423268, "C140@5212L9,137@5075L183,143@5276L770:SkuInfoHeaderComponent.kt#v057zd");
                TextKt.Text-Nvy7gAk(specName2 + "(" + specCount + ")", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), scale), $composer6, 384, 0, 131066);
                Modifier modifier$iv4 = Modifier.Companion;
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv4 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                Composer $composer7 = $composer6;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv12;
                    $composer6.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv12;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i12 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -9017515, "C:SkuInfoHeaderComponent.kt#v057zd");
                if (!isInPreview) {
                    $composer6.startReplaceGroup(-9000218);
                    ComposerKt.sourceInformation($composer6, "150@5567L6,151@5627L9,148@5474L207,154@5763L28,155@5838L6,153@5706L300");
                    TextKt.Text-Nvy7gAk("全部", (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), scale), $composer6, 6, 0, 131066);
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer6, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText4-0d7_KjU(), $composer6, Painter.$stable | 48, 0);
                } else {
                    $composer6.startReplaceGroup(-14423606);
                }
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 13, (Object) null);
                String str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, str2);
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv5 = (0 << 3) & 112;
                String str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, str3);
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer6, modifier$iv5);
                Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Box = $changed$iv$iv5 << 6;
                int $changed$iv$iv$iv6 = ($i$f$Box & 896) | 6;
                String str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, str4);
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv13;
                    $composer6.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv13;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i13 = ($changed$iv$iv$iv6 >> 6) & 14;
                String str5 = "C72@3469L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, str5);
                int i14 = ((0 >> 6) & 112) | 6;
                BoxScope $this$SkuSelectorComponent_u24lambda_u242_u240_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer6, 493551830, "C170@6361L21,171@6399L3331:SkuInfoHeaderComponent.kt#v057zd");
                List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList2 = specInfoListItem.getSpecValueVOList();
                int imageCount3 = specValueVOList2 != null ? specValueVOList2.size() : 0;
                ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer6, 0, 1);
                Modifier modifier6 = SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(44, scale));
                if (imageCount3 > 4) {
                    modifier4 = ScrollKt.horizontalScroll$default(Modifier.Companion, scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                } else {
                    modifier4 = Modifier.Companion;
                }
                Modifier modifier$iv6 = modifier6.then(modifier4);
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                Composer $composer$iv6 = $composer6;
                ComposerKt.sourceInformationMarkerStart($composer$iv6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer$iv6, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv6 = (384 << 3) & 112;
                Composer $composer$iv$iv2 = $composer$iv6;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, str3);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer$iv$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv6);
                Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                Composer $composer$iv$iv$iv3 = $composer$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -553112988, str4);
                if (!($composer$iv$iv$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv3.startReusableNode();
                if ($composer$iv$iv$iv3.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv14;
                    $composer$iv$iv$iv3.createNode(factory$iv$iv$iv6);
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv14;
                    $composer$iv$iv$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer$iv$iv$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                int i15 = ($changed$iv$iv$iv7 >> 6) & 14;
                Composer $composer$iv7 = $composer$iv$iv$iv3;
                ComposerKt.sourceInformationMarkerStart($composer$iv7, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                int i16 = ((384 >> 6) & 112) | 6;
                Composer $composer8 = $composer$iv7;
                ComposerKt.sourceInformationMarkerStart($composer8, 1656918337, "C:SkuInfoHeaderComponent.kt#v057zd");
                Iterable specValueVOList3 = specInfoListItem.getSpecValueVOList();
                if (specValueVOList3 == null) {
                    $composer8.startReplaceGroup(1656951009);
                    $composer8.endReplaceGroup();
                    $composer$iv = $composer$iv6;
                    imageCount = imageCount3;
                    $composer$iv$iv = $composer$iv$iv2;
                    $composer$iv2 = $composer$iv7;
                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                    $composer3 = $composer8;
                    selectedIndex2 = selectedIndex5;
                    $composer2 = $composer7;
                } else {
                    $composer8.startReplaceGroup(1656951010);
                    ComposerKt.sourceInformation($composer8, "*202@8022L103,185@7038L2350");
                    Iterable $this$forEachIndexed$iv = specValueVOList3;
                    boolean z = false;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem item = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) item$iv;
                        Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        boolean z2 = z;
                        Modifier modifier7 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(44, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), Color.Companion.getWhite-0d7_KjU(), (Shape) null, 2, (Object) null);
                        int selectedIndex6 = selectedIndex5;
                        CompositionLocalMap localMap$iv$iv7 = localMap$iv$iv6;
                        final int index = index$iv;
                        if (index == selectedIndex6) {
                            selectedIndex4 = selectedIndex6;
                            $composer8.startReplaceGroup(312085008);
                            ComposerKt.sourceInformation($composer8, "195@7626L6");
                            materialized$iv$iv = materialized$iv$iv7;
                            $changed$iv$iv$iv = $changed$iv$iv$iv7;
                            $composer$iv3 = $composer$iv6;
                            $composer$iv4 = $composer$iv7;
                            $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                            modifier5 = BorderKt.border-xT4_qwU(Modifier.Companion, ProvideUiScaleKt.dpScaled(1, scale), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale)));
                            $composer8.endReplaceGroup();
                        } else {
                            $composer$iv3 = $composer$iv6;
                            $composer$iv4 = $composer$iv7;
                            selectedIndex4 = selectedIndex6;
                            materialized$iv$iv = materialized$iv$iv7;
                            $changed$iv$iv$iv = $changed$iv$iv$iv7;
                            $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                            $composer8.startReplaceGroup(312460077);
                            $composer8.endReplaceGroup();
                            modifier5 = Modifier.Companion;
                        }
                        Modifier then = modifier7.then(modifier5);
                        ComposerKt.sourceInformationMarkerStart($composer8, -267008996, "CC(remember):SkuInfoHeaderComponent.kt#9igjgp");
                        Composer $composer9 = $composer7;
                        boolean invalid$iv = (($dirty2 & 3670016) == 1048576) | $composer9.changed(index);
                        Composer $this$cache$iv = $composer8;
                        Object it$iv2 = $this$cache$iv.rememberedValue();
                        if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                            onSelect3 = onSelect5;
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            Modifier modifier$iv7 = ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                            $composer$iv5 = $composer8;
                            onSelect5 = onSelect3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, str2);
                            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                            int $changed$iv$iv7 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str3);
                            int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                            CompositionLocalMap localMap$iv$iv8 = $composer$iv5.getCurrentCompositionLocalMap();
                            Composer $composer$iv$iv3 = $composer$iv$iv2;
                            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv7);
                            Function0 factory$iv$iv$iv15 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
                            Composer $composer$iv$iv$iv4 = $composer$iv$iv$iv2;
                            Composer $composer$iv$iv$iv5 = $composer8;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str4);
                            if (!($composer$iv5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv5.startReusableNode();
                            if (!$composer$iv5.getInserting()) {
                                factory$iv$iv$iv7 = factory$iv$iv$iv15;
                                $composer$iv5.createNode(factory$iv$iv$iv7);
                            } else {
                                factory$iv$iv$iv7 = factory$iv$iv$iv15;
                                $composer$iv5.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer$iv5);
                            imageCount2 = imageCount3;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                            int i17 = ($changed$iv$iv$iv8 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, str5);
                            int i18 = ((0 >> 6) & 112) | 6;
                            BoxScope $this$SkuSelectorComponent_u24lambda_u242_u240_u241_u240_u240_u241 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -101332076, "C207@8222L202,212@8454L908:SkuInfoHeaderComponent.kt#v057zd");
                            String specValueImg = item.getSpecValueImg();
                            Intrinsics.checkNotNull(specValueImg);
                            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(specValueImg);
                            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                            Unit unit = Unit.INSTANCE;
                            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer$iv5, 48, 508);
                            Modifier modifier$iv8 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$SkuSelectorComponent_u24lambda_u242_u240_u241_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(16, scale)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null);
                            Alignment contentAlignment$iv4 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, str2);
                            MeasurePolicy measurePolicy$iv8 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                            int $changed$iv$iv8 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str3);
                            int compositeKeyHash$iv$iv8 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                            String str6 = str3;
                            CompositionLocalMap localMap$iv$iv9 = $composer$iv5.getCurrentCompositionLocalMap();
                            String str7 = str2;
                            Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv8);
                            Function0 factory$iv$iv$iv16 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv9 = (($changed$iv$iv8 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str4);
                            if (!($composer$iv5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv5.startReusableNode();
                            if (!$composer$iv5.getInserting()) {
                                factory$iv$iv$iv8 = factory$iv$iv$iv16;
                                $composer$iv5.createNode(factory$iv$iv$iv8);
                            } else {
                                factory$iv$iv$iv8 = factory$iv$iv$iv16;
                                $composer$iv5.useNode();
                            }
                            String str8 = str4;
                            Composer $this$Layout_u24lambda_u240$iv$iv8 = Updater.constructor-impl($composer$iv5);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, measurePolicy$iv8, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, localMap$iv$iv9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv8, Integer.valueOf(compositeKeyHash$iv$iv8), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, materialized$iv$iv9, ComposeUiNode.Companion.getSetModifier());
                            int i19 = ($changed$iv$iv$iv9 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, str5);
                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                            int i20 = ((48 >> 6) & 112) | 6;
                            String str9 = str5;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 551503442, "C226@9270L9,221@8964L368:SkuInfoHeaderComponent.kt#v057zd");
                            specValueName = item.getSpecValueName();
                            if (specValueName == null) {
                                specValueName = "";
                            }
                            TextKt.Text-Nvy7gAk(specValueName, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv5, BiliTheme.$stable).getT10(), scale), $composer$iv5, 384, 24960, 110586);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer$iv5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer$iv5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            if (index >= imageCount2 - 1) {
                                $composer4 = $composer$iv$iv$iv5;
                                $composer4.startReplaceGroup(314068853);
                                ComposerKt.sourceInformation($composer4, "232@9472L192");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer4, 0);
                            } else {
                                $composer4 = $composer$iv$iv$iv5;
                                $composer4.startReplaceGroup(304693709);
                            }
                            $composer4.endReplaceGroup();
                            $composer8 = $composer4;
                            localMap$iv$iv6 = localMap$iv$iv7;
                            index$iv = index$iv2;
                            z = z2;
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            selectedIndex5 = selectedIndex4;
                            materialized$iv$iv7 = materialized$iv$iv;
                            $changed$iv$iv$iv7 = $changed$iv$iv$iv;
                            $composer$iv6 = $composer$iv3;
                            $composer$iv7 = $composer$iv4;
                            $composer$iv$iv2 = $composer$iv$iv3;
                            $composer7 = $composer9;
                            $composer$iv$iv$iv3 = $composer$iv$iv$iv4;
                            imageCount3 = imageCount2;
                            str3 = str6;
                            str2 = str7;
                            str4 = str8;
                            str5 = str9;
                        }
                        onSelect3 = onSelect5;
                        Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit SkuSelectorComponent$lambda$2$0$1$0$0$0$0;
                                SkuSelectorComponent$lambda$2$0$1$0$0$0$0 = SkuInfoHeaderComponentKt.SkuSelectorComponent$lambda$2$0$1$0$0$0$0(onSelect3, index);
                                return SkuSelectorComponent$lambda$2$0$1$0$0$0$0;
                            }
                        };
                        $this$cache$iv.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        Modifier modifier$iv72 = ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                        $composer$iv5 = $composer8;
                        onSelect5 = onSelect3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, str2);
                        Alignment contentAlignment$iv32 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv72 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
                        int $changed$iv$iv72 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str3);
                        int compositeKeyHash$iv$iv72 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                        CompositionLocalMap localMap$iv$iv82 = $composer$iv5.getCurrentCompositionLocalMap();
                        Composer $composer$iv$iv32 = $composer$iv$iv2;
                        Modifier materialized$iv$iv82 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv72);
                        Function0 factory$iv$iv$iv152 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv82 = (($changed$iv$iv72 << 6) & 896) | 6;
                        Composer $composer$iv$iv$iv42 = $composer$iv$iv$iv2;
                        Composer $composer$iv$iv$iv52 = $composer8;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str4);
                        if (!($composer$iv5.getApplier() instanceof Applier)) {
                        }
                        $composer$iv5.startReusableNode();
                        if (!$composer$iv5.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv72 = Updater.constructor-impl($composer$iv5);
                        imageCount2 = imageCount3;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, measurePolicy$iv72, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, localMap$iv$iv82, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv72, Integer.valueOf(compositeKeyHash$iv$iv72), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv72, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, materialized$iv$iv82, ComposeUiNode.Companion.getSetModifier());
                        int i172 = ($changed$iv$iv$iv82 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, str5);
                        int i182 = ((0 >> 6) & 112) | 6;
                        BoxScope $this$SkuSelectorComponent_u24lambda_u242_u240_u241_u240_u240_u2412 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -101332076, "C207@8222L202,212@8454L908:SkuInfoHeaderComponent.kt#v057zd");
                        String specValueImg2 = item.getSpecValueImg();
                        Intrinsics.checkNotNull(specValueImg2);
                        String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(specValueImg2);
                        ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                        Unit unit2 = Unit.INSTANCE;
                        BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer$iv5, 48, 508);
                        Modifier modifier$iv82 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$SkuSelectorComponent_u24lambda_u242_u240_u241_u240_u240_u2412.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(16, scale)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null);
                        Alignment contentAlignment$iv42 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, str2);
                        MeasurePolicy measurePolicy$iv82 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv42, false);
                        int $changed$iv$iv82 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str3);
                        int compositeKeyHash$iv$iv82 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                        String str62 = str3;
                        CompositionLocalMap localMap$iv$iv92 = $composer$iv5.getCurrentCompositionLocalMap();
                        String str72 = str2;
                        Modifier materialized$iv$iv92 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv82);
                        Function0 factory$iv$iv$iv162 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv92 = (($changed$iv$iv82 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str4);
                        if (!($composer$iv5.getApplier() instanceof Applier)) {
                        }
                        $composer$iv5.startReusableNode();
                        if (!$composer$iv5.getInserting()) {
                        }
                        String str82 = str4;
                        Composer $this$Layout_u24lambda_u240$iv$iv82 = Updater.constructor-impl($composer$iv5);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, measurePolicy$iv82, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, localMap$iv$iv92, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv82, Integer.valueOf(compositeKeyHash$iv$iv82), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv82, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, materialized$iv$iv92, ComposeUiNode.Companion.getSetModifier());
                        int i192 = ($changed$iv$iv$iv92 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, str5);
                        BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                        int i202 = ((48 >> 6) & 112) | 6;
                        String str92 = str5;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 551503442, "C226@9270L9,221@8964L368:SkuInfoHeaderComponent.kt#v057zd");
                        specValueName = item.getSpecValueName();
                        if (specValueName == null) {
                        }
                        TextKt.Text-Nvy7gAk(specValueName, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv5, BiliTheme.$stable).getT10(), scale), $composer$iv5, 384, 24960, 110586);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer$iv5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer$iv5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        if (index >= imageCount2 - 1) {
                        }
                        $composer4.endReplaceGroup();
                        $composer8 = $composer4;
                        localMap$iv$iv6 = localMap$iv$iv7;
                        index$iv = index$iv2;
                        z = z2;
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        selectedIndex5 = selectedIndex4;
                        materialized$iv$iv7 = materialized$iv$iv;
                        $changed$iv$iv$iv7 = $changed$iv$iv$iv;
                        $composer$iv6 = $composer$iv3;
                        $composer$iv7 = $composer$iv4;
                        $composer$iv$iv2 = $composer$iv$iv32;
                        $composer7 = $composer9;
                        $composer$iv$iv$iv3 = $composer$iv$iv$iv42;
                        imageCount3 = imageCount2;
                        str3 = str62;
                        str2 = str72;
                        str4 = str82;
                        str5 = str92;
                    }
                    $composer$iv = $composer$iv6;
                    imageCount = imageCount3;
                    $composer$iv$iv = $composer$iv$iv2;
                    $composer$iv2 = $composer$iv7;
                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                    $composer3 = $composer8;
                    selectedIndex2 = selectedIndex5;
                    $composer2 = $composer7;
                    $composer3.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (imageCount <= 4 || !scrollState.getCanScrollForward()) {
                    $composer5 = $composer6;
                    $composer5.startReplaceGroup(487198472);
                } else {
                    $composer5 = $composer6;
                    $composer5.startReplaceGroup(496948003);
                    ComposerKt.sourceInformation($composer5, "242@9822L829");
                    BoxKt.Box(BackgroundKt.background$default(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs($this$SkuSelectorComponent_u24lambda_u242_u240_u241.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), ProvideUiScaleKt.dpScaled(44, scale)), ProvideUiScaleKt.dpScaled(24, scale)), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer5, 0);
                }
                $composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                onSelect = onSelect5;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer6.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier8 = modifier3;
                    final Function1 onSelect6 = onSelect2;
                    final int i21 = selectedIndex3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SkuSelectorComponent$lambda$1;
                            SkuSelectorComponent$lambda$1 = SkuInfoHeaderComponentKt.SkuSelectorComponent$lambda$1(isInPreview, specInfoListItem, function0, scale, modifier8, i21, onSelect6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return SkuSelectorComponent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            selectedIndex2 = selectedIndex;
            onSelect = function1;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier9 = modifier3;
            final int i22 = selectedIndex2;
            final Function1 function12 = onSelect;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SkuSelectorComponent$lambda$3;
                    SkuSelectorComponent$lambda$3 = SkuInfoHeaderComponentKt.SkuSelectorComponent$lambda$3(isInPreview, specInfoListItem, function0, scale, modifier9, i22, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SkuSelectorComponent$lambda$3;
                }
            });
        }
    }

    private static final int SkuSelectorComponent$calculatedSpecWidth(int specCount) {
        if (specCount <= 4) {
            return (specCount * 44) + ((specCount - 1) * 4) + 12;
        }
        return 228;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSelectorComponent$lambda$2$0$1$0$0$0$0(Function1 $onSelect, int $index) {
        $onSelect.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }
}