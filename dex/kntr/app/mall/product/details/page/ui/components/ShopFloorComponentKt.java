package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.mall.product.details.page.api.ProductShopDetailsMerchantInfo;
import kntr.app.mall.product.details.page.api.ProductShopDetailsShopItem;
import kntr.app.mall.product.details.page.api.model.PriceModel;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.mall.product.details.page.generated.resources.Drawable0_commonMainKt;
import srcs.app.mall.product.details.page.generated.resources.Res;

/* compiled from: ShopFloorComponent.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001ac\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0018\u001a\u00020\u00012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010 \u001a;\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010#¨\u0006$²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"ShopFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MerchantInfoComponent", "avatarUrl", "", "shopName", "upOfficialType", "", "shopSales", "itemsNum", "", "upName", "positiveRatio", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HotItemsComponent", "hotItems", "", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "onItem", "Lkotlin/Function1;", "scale", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HotItemComponent", "item", "(Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShopFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemComponent$lambda$2(ProductShopDetailsShopItem productShopDetailsShopItem, Function1 function1, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HotItemComponent(productShopDetailsShopItem, function1, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemsComponent$lambda$0(List list, Function1 function1, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HotItemsComponent(list, function1, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemsComponent$lambda$2(List list, Function1 function1, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HotItemsComponent(list, function1, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MerchantInfoComponent$lambda$4(String str, String str2, Integer num, String str3, Long l, String str4, Double d, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MerchantInfoComponent(str, str2, num, str3, l, str4, d, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopFloorComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopFloorComponent$lambda$1(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopFloorComponent$lambda$2(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopFloorComponent$lambda$5(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ShopFloorComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(-1033680665);
        ComposerKt.sourceInformation($composer3, "C(ShopFloorComponent)N(module,pageViewModel,modifier)67@3159L16,79@3551L886,70@3214L1223:ShopFloorComponent.kt#o90vz8");
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
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1033680665, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ShopFloorComponent (ShopFloorComponent.kt:53)");
            }
            if (!(module instanceof ContentModule.ShopModule)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ShopFloorComponent$lambda$0;
                            ShopFloorComponent$lambda$0 = ShopFloorComponentKt.ShopFloorComponent$lambda$0(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ShopFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData shopFloorData = ((ContentModule.ShopModule) module).getData();
            final ProductShopDetailsMerchantInfo merchantInfo = shopFloorData.getMerchantInfo();
            if (merchantInfo == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ShopFloorComponent$lambda$1;
                            ShopFloorComponent$lambda$1 = ShopFloorComponentKt.ShopFloorComponent$lambda$1(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ShopFloorComponent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            final String merchantShopName = merchantInfo.getMerchantShopName();
            if (merchantShopName == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup3 = $composer3.endRestartGroup();
                if (endRestartGroup3 != null) {
                    final Modifier modifier6 = modifier3;
                    endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ShopFloorComponent$lambda$2;
                            ShopFloorComponent$lambda$2 = ShopFloorComponentKt.ShopFloorComponent$lambda$2(ContentModule.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ShopFloorComponent$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            final String upPortrait = merchantInfo.getUpPortrait();
            final String upName = merchantInfo.getUpName();
            final String shopSales = merchantInfo.getShopSales();
            final Double positiveRatio = merchantInfo.getPositiveRatio();
            final List shopItems = shopFloorData.getShopItems();
            List list = shopItems;
            final boolean showItems = !(list == null || list.isEmpty()) && shopItems.size() >= 3;
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            final float scale = ShopFloorComponent$lambda$3(scaleModel$delegate).getScale();
            $composer2 = $composer3;
            PaddingCardKt.PaddingCard(modifier3, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(2031150252, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShopFloorComponent$lambda$4;
                    ShopFloorComponent$lambda$4 = ShopFloorComponentKt.ShopFloorComponent$lambda$4(scale, upPortrait, merchantShopName, merchantInfo, shopSales, upName, positiveRatio, pageViewModel, showItems, shopItems, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShopFloorComponent$lambda$4;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup4 = $composer2.endRestartGroup();
        if (endRestartGroup4 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup4.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShopFloorComponent$lambda$5;
                    ShopFloorComponent$lambda$5 = ShopFloorComponentKt.ShopFloorComponent$lambda$5(ContentModule.this, pageViewModel, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShopFloorComponent$lambda$5;
                }
            });
        }
    }

    private static final UiScaleModel ShopFloorComponent$lambda$3(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x01a6, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ShopFloorComponent$lambda$4(float $scale, String $upPortrait, String $merchantShopName, ProductShopDetailsMerchantInfo $merchantInfo, String $shopSales, String $upName, Double $positiveRatio, final PageViewModel $pageViewModel, boolean $showItems, List $shopItems, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C80@3561L870:ShopFloorComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2031150252, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ShopFloorComponent.<anonymous> (ShopFloorComponent.kt:80)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 172045825, "C83@3641L53,84@3707L414:ShopFloorComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, $scale)), $composer, 0);
            MerchantInfoComponent($upPortrait, $merchantShopName, $merchantInfo.getUpOfficialType(), $shopSales, $merchantInfo.getItemsNum(), $upName, $positiveRatio, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 256);
            if ($showItems) {
                $composer.startReplaceGroup(172534973);
                ComposerKt.sourceInformation($composer, "98@4238L123,96@4168L239");
                ComposerKt.sourceInformationMarkerStart($composer, 836852305, "CC(remember):ShopFloorComponent.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($pageViewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit ShopFloorComponent$lambda$4$0$0$0;
                        ShopFloorComponent$lambda$4$0$0$0 = ShopFloorComponentKt.ShopFloorComponent$lambda$4$0$0$0(PageViewModel.this, (ProductShopDetailsShopItem) obj);
                        return ShopFloorComponent$lambda$4$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                HotItemsComponent($shopItems, (Function1) it$iv, $scale, null, $composer, 0, 8);
            } else {
                $composer.startReplaceGroup(168408780);
            }
            $composer.endReplaceGroup();
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
    public static final Unit ShopFloorComponent$lambda$4$0$0$0(PageViewModel $pageViewModel, ProductShopDetailsShopItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        $pageViewModel.handleShopItemClick$product_details_page_debug(item);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07dc  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x07e2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x09de  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x09e4  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0ad3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void MerchantInfoComponent(final String avatarUrl, final String shopName, final Integer upOfficialType, final String shopSales, final Long itemsNum, final String upName, final Double positiveRatio, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        Modifier modifier3;
        String valueOf;
        boolean z;
        boolean invalid$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        String str2;
        String str3;
        String str4;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        long Color;
        Function0 factory$iv$iv$iv5;
        Composer $composer3 = $composer.startRestartGroup(1149412139);
        ComposerKt.sourceInformation($composer3, "C(MerchantInfoComponent)N(avatarUrl,shopName,upOfficialType,shopSales,itemsNum,upName,positiveRatio,pageViewModelWrapper,modifier)121@4849L16,142@5529L78,136@5350L4105:ShopFloorComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(avatarUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(shopName) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(upOfficialType) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(shopSales) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(itemsNum) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changed(upName) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changed(positiveRatio) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(pageViewModelWrapper) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty2 |= 100663296;
        } else if ((100663296 & $changed) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 67108864 : 33554432;
        }
        if (!$composer3.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1149412139, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.MerchantInfoComponent (ShopFloorComponent.kt:119)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            float scale = MerchantInfoComponent$lambda$0(scaleModel$delegate).getScale();
            String str5 = shopSales;
            if (!(str5 == null || str5.length() == 0)) {
                valueOf = "销量 " + shopSales;
            } else if (itemsNum != null && itemsNum.longValue() > 0) {
                valueOf = itemsNum + "件商品";
            } else {
                valueOf = String.valueOf(upName);
            }
            if (positiveRatio != null) {
                double it = positiveRatio.doubleValue();
                if ((it >= 0.9d ? 1 : 0) == 1) {
                    z = true;
                    if (z) {
                        double roundedRatio = Math.rint(positiveRatio.doubleValue() * 10000) / 100.0d;
                        valueOf = ((Object) valueOf) + (valueOf.length() == 0 ? "" : " | ") + "好评 " + roundedRatio + "%";
                    }
                    Modifier modifier4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, scale));
                    ComposerKt.sourceInformationMarkerStart($composer3, 778504761, "CC(remember):ShopFloorComponent.kt#9igjgp");
                    invalid$iv = $composer3.changedInstance(pageViewModel);
                    it$iv = $composer3.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        modifier2 = modifier3;
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda10
                            public final Object invoke() {
                                Unit MerchantInfoComponent$lambda$2$0;
                                MerchantInfoComponent$lambda$2$0 = ShopFloorComponentKt.MerchantInfoComponent$lambda$2$0(PageViewModel.this);
                                return MerchantInfoComponent$lambda$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    } else {
                        modifier2 = modifier3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv6;
                        $composer3.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv6;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i4 = ((384 >> 6) & 112) | 6;
                    RowScope $this$MerchantInfoComponent_u24lambda_u243 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -910047977, "C148@5700L2498,209@8207L53,211@8270L672,235@9180L6,230@8952L497:ShopFloorComponent.kt#o90vz8");
                    Modifier modifier$iv2 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(44, scale));
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    String str6 = valueOf;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv7;
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv7;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                    $dirty = $dirty2;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i6 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$MerchantInfoComponent_u24lambda_u243_u240 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1609203701, "C:ShopFloorComponent.kt#o90vz8");
                    str = avatarUrl;
                    if (str != null || str.length() == 0) {
                        $composer3.startReplaceGroup(1609178683);
                        ComposerKt.sourceInformation($composer3, "153@5857L518");
                        String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(avatarUrl);
                        ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                        Unit unit = Unit.INSTANCE;
                        $composer$iv$iv$iv = $composer3;
                        BiliImageKt.BiliImage(imageRequest.build(), BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(0.5d, scale), ColorKt.Color(4293125607L), RoundedCornerShapeKt.RoundedCornerShape(50)), null, null, null, null, null, null, null, $composer3, 0, 508);
                        $composer3.endReplaceGroup();
                        $composer$iv = $composer3;
                    } else {
                        $composer$iv$iv$iv = $composer3;
                        $composer3.startReplaceGroup(1609750168);
                        ComposerKt.sourceInformation($composer3, "167@6450L45,166@6413L617");
                        $composer$iv = $composer3;
                        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShopAvatarPlace(Res.drawable.INSTANCE), $composer3, 0), (String) null, BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(1, scale), ColorKt.Color(4293125607L), RoundedCornerShapeKt.RoundedCornerShape(50)), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
                        $composer3.endReplaceGroup();
                    }
                    if ((upOfficialType != null && upOfficialType.intValue() == 1) || (upOfficialType != null && upOfficialType.intValue() == 2)) {
                        $composer3.startReplaceGroup(1610452039);
                        ComposerKt.sourceInformation($composer3, "183@7124L1050");
                        Modifier clip = ClipKt.clip($this$MerchantInfoComponent_u24lambda_u243_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(14, scale)), Alignment.Companion.getBottomEnd()), RoundedCornerShapeKt.RoundedCornerShape(50));
                        if (upOfficialType != null && upOfficialType.intValue() == 2) {
                            Color = ColorKt.Color(4282435057L);
                        } else {
                            Color = ColorKt.Color(4294953984L);
                        }
                        Modifier modifier$iv3 = BackgroundKt.background-bw27NRU$default(clip, Color, (Shape) null, 2, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if (!$composer3.getInserting()) {
                            factory$iv$iv$iv5 = factory$iv$iv$iv8;
                            $composer3.createNode(factory$iv$iv$iv5);
                        } else {
                            factory$iv$iv$iv5 = factory$iv$iv$iv8;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i8 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -447982629, "C199@7814L44,198@7773L383:ShopFloorComponent.kt#o90vz8");
                        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShopAvatarCert(Res.drawable.INSTANCE), $composer3, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(9, scale), ProvideUiScaleKt.dpScaled(10, scale)), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(1603368353);
                        $composer3.endReplaceGroup();
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
                    Modifier modifier$iv4 = RowScope.-CC.weight$default($this$MerchantInfoComponent_u24lambda_u243, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv4 = (0 << 3) & 112;
                    String str7 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str7);
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                    Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    String str8 = str4;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str8);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv9;
                        $composer3.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv9;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i10 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 200988113, "C214@8390L21,215@8489L9,212@8323L289,219@8625L53,223@8764L6,224@8810L9,221@8692L240:ShopFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(shopName, (Modifier) null, ColorKt.Color(!ThemesKt.isCurrentThemeLight($composer3, 0) ? 4279308561L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), scale), $composer3, ($dirty >> 3) & 14, 24960, 110586);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale)), $composer3, 0);
                    TextKt.Text-Nvy7gAk(str6, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24960, 110586);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(72, scale), ProvideUiScaleKt.dpScaled(26, scale)), RoundedCornerShapeKt.RoundedCornerShape(50)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str3);
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv5 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str7);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $i$f$Box = $changed$iv$iv5 << 6;
                    int $changed$iv$iv$iv5 = ($i$f$Box & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str8);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv10;
                        $composer3.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv10;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i12 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 982064371, "C240@9344L6,241@9397L9,238@9273L166:ShopFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk("进店逛逛", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), scale), $composer3, 6, 0, 131066);
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
            }
            z = false;
            if (z) {
            }
            Modifier modifier42 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, scale));
            ComposerKt.sourceInformationMarkerStart($composer3, 778504761, "CC(remember):ShopFloorComponent.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(pageViewModel);
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            modifier2 = modifier3;
            Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit MerchantInfoComponent$lambda$2$0;
                    MerchantInfoComponent$lambda$2$0 = ShopFloorComponentKt.MerchantInfoComponent$lambda$2$0(PageViewModel.this);
                    return MerchantInfoComponent$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv6 = ClickableKt.clickable-oSLSa3U$default(modifier42, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv6 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i42 = ((384 >> 6) & 112) | 6;
            RowScope $this$MerchantInfoComponent_u24lambda_u2432 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -910047977, "C148@5700L2498,209@8207L53,211@8270L672,235@9180L6,230@8952L497:ShopFloorComponent.kt#o90vz8");
            Modifier modifier$iv22 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(44, scale));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv4 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
            int $changed$iv$iv22 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
            Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            String str62 = valueOf;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
            $dirty = $dirty2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i62 = ((0 >> 6) & 112) | 6;
            BoxScope $this$MerchantInfoComponent_u24lambda_u243_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1609203701, "C:ShopFloorComponent.kt#o90vz8");
            str = avatarUrl;
            if (str != null || str.length() == 0) {
            }
            if (upOfficialType != null) {
                $composer3.startReplaceGroup(1610452039);
                ComposerKt.sourceInformation($composer3, "183@7124L1050");
                Modifier clip2 = ClipKt.clip($this$MerchantInfoComponent_u24lambda_u243_u2402.align(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(14, scale)), Alignment.Companion.getBottomEnd()), RoundedCornerShapeKt.RoundedCornerShape(50));
                if (upOfficialType != null) {
                    Color = ColorKt.Color(4282435057L);
                    Modifier modifier$iv32 = BackgroundKt.background-bw27NRU$default(clip2, Color, (Shape) null, 2, (Object) null);
                    Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                    int $changed$iv$iv32 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv32 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer3, modifier$iv32);
                    Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                    str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer3);
                    str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                    int i72 = ($changed$iv$iv$iv32 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i82 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -447982629, "C199@7814L44,198@7773L383:ShopFloorComponent.kt#o90vz8");
                    ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShopAvatarCert(Res.drawable.INSTANCE), $composer3, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(9, scale), ProvideUiScaleKt.dpScaled(10, scale)), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
                    Modifier modifier$iv42 = RowScope.-CC.weight$default($this$MerchantInfoComponent_u24lambda_u2432, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv42 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv42 = (0 << 3) & 112;
                    String str72 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str72);
                    int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv42 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer3, modifier$iv42);
                    Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                    String str82 = str4;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str82);
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                    int i92 = ($changed$iv$iv$iv42 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i102 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 200988113, "C214@8390L21,215@8489L9,212@8323L289,219@8625L53,223@8764L6,224@8810L9,221@8692L240:ShopFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(shopName, (Modifier) null, ColorKt.Color(!ThemesKt.isCurrentThemeLight($composer3, 0) ? 4279308561L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), scale), $composer3, ($dirty >> 3) & 14, 24960, 110586);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale)), $composer3, 0);
                    TextKt.Text-Nvy7gAk(str62, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24960, 110586);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv52 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(72, scale), ProvideUiScaleKt.dpScaled(26, scale)), RoundedCornerShapeKt.RoundedCornerShape(50)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
                    Alignment contentAlignment$iv32 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str3);
                    MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
                    int $changed$iv$iv52 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str72);
                    int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv52 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer3, modifier$iv52);
                    Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                    int $i$f$Box2 = $changed$iv$iv52 << 6;
                    int $changed$iv$iv$iv52 = ($i$f$Box2 & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str82);
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                    int i112 = ($changed$iv$iv$iv52 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                    int i122 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 982064371, "C240@9344L6,241@9397L9,238@9273L166:ShopFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk("进店逛逛", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), scale), $composer3, 6, 0, 131066);
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
                    }
                }
                Color = ColorKt.Color(4294953984L);
                Modifier modifier$iv322 = BackgroundKt.background-bw27NRU$default(clip2, Color, (Shape) null, 2, (Object) null);
                Alignment contentAlignment$iv222 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv322 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv222, false);
                int $changed$iv$iv322 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv322 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv322 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv322 = ComposedModifierKt.materializeModifier($composer3, modifier$iv322);
                Function0 factory$iv$iv$iv822 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv322 = (($changed$iv$iv322 << 6) & 896) | 6;
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv322 = Updater.constructor-impl($composer3);
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, measurePolicy$iv322, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, localMap$iv$iv322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv322, Integer.valueOf(compositeKeyHash$iv$iv322), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv322, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, materialized$iv$iv322, ComposeUiNode.Companion.getSetModifier());
                int i722 = ($changed$iv$iv$iv322 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope32 = BoxScopeInstance.INSTANCE;
                int i822 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -447982629, "C199@7814L44,198@7773L383:ShopFloorComponent.kt#o90vz8");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShopAvatarCert(Res.drawable.INSTANCE), $composer3, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(9, scale), ProvideUiScaleKt.dpScaled(10, scale)), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
                Modifier modifier$iv422 = RowScope.-CC.weight$default($this$MerchantInfoComponent_u24lambda_u2432, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv422 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv422 = (0 << 3) & 112;
                String str722 = str2;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str722);
                int compositeKeyHash$iv$iv422 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv422 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv422 = ComposedModifierKt.materializeModifier($composer3, modifier$iv422);
                Function0 factory$iv$iv$iv922 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv422 = (($changed$iv$iv422 << 6) & 896) | 6;
                String str822 = str4;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str822);
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv422 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, measurePolicy$iv422, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, localMap$iv$iv422, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv422, Integer.valueOf(compositeKeyHash$iv$iv422), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv422, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, materialized$iv$iv422, ComposeUiNode.Companion.getSetModifier());
                int i922 = ($changed$iv$iv$iv422 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                int i1022 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 200988113, "C214@8390L21,215@8489L9,212@8323L289,219@8625L53,223@8764L6,224@8810L9,221@8692L240:ShopFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(shopName, (Modifier) null, ColorKt.Color(!ThemesKt.isCurrentThemeLight($composer3, 0) ? 4279308561L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), scale), $composer3, ($dirty >> 3) & 14, 24960, 110586);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale)), $composer3, 0);
                TextKt.Text-Nvy7gAk(str62, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv522 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(72, scale), ProvideUiScaleKt.dpScaled(26, scale)), RoundedCornerShapeKt.RoundedCornerShape(50)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment contentAlignment$iv322 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str3);
                MeasurePolicy measurePolicy$iv522 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv322, false);
                int $changed$iv$iv522 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str722);
                int compositeKeyHash$iv$iv522 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv522 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv522 = ComposedModifierKt.materializeModifier($composer3, modifier$iv522);
                Function0 factory$iv$iv$iv1022 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Box22 = $changed$iv$iv522 << 6;
                int $changed$iv$iv$iv522 = ($i$f$Box22 & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str822);
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv522 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, measurePolicy$iv522, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, localMap$iv$iv522, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv522, Integer.valueOf(compositeKeyHash$iv$iv522), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv522, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, materialized$iv$iv522, ComposeUiNode.Companion.getSetModifier());
                int i1122 = ($changed$iv$iv$iv522 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
                int i1222 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 982064371, "C240@9344L6,241@9397L9,238@9273L166:ShopFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk("进店逛逛", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), scale), $composer3, 6, 0, 131066);
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
                }
            }
            $composer3.startReplaceGroup(1610452039);
            ComposerKt.sourceInformation($composer3, "183@7124L1050");
            Modifier clip22 = ClipKt.clip($this$MerchantInfoComponent_u24lambda_u243_u2402.align(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(14, scale)), Alignment.Companion.getBottomEnd()), RoundedCornerShapeKt.RoundedCornerShape(50));
            if (upOfficialType != null) {
            }
            Color = ColorKt.Color(4294953984L);
            Modifier modifier$iv3222 = BackgroundKt.background-bw27NRU$default(clip22, Color, (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv2222 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2222, false);
            int $changed$iv$iv3222 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3222 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3222);
            Function0 factory$iv$iv$iv8222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3222 = (($changed$iv$iv3222 << 6) & 896) | 6;
            str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3222 = Updater.constructor-impl($composer3);
            str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, measurePolicy$iv3222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, localMap$iv$iv3222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3222, Integer.valueOf(compositeKeyHash$iv$iv3222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, materialized$iv$iv3222, ComposeUiNode.Companion.getSetModifier());
            int i7222 = ($changed$iv$iv$iv3222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope322 = BoxScopeInstance.INSTANCE;
            int i8222 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -447982629, "C199@7814L44,198@7773L383:ShopFloorComponent.kt#o90vz8");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShopAvatarCert(Res.drawable.INSTANCE), $composer3, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(9, scale), ProvideUiScaleKt.dpScaled(10, scale)), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
            Modifier modifier$iv4222 = RowScope.-CC.weight$default($this$MerchantInfoComponent_u24lambda_u2432, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv222 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4222 = (0 << 3) & 112;
            String str7222 = str2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str7222);
            int compositeKeyHash$iv$iv4222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4222 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4222);
            Function0 factory$iv$iv$iv9222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4222 = (($changed$iv$iv4222 << 6) & 896) | 6;
            String str8222 = str4;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str8222);
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4222 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, measurePolicy$iv4222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, localMap$iv$iv4222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4222, Integer.valueOf(compositeKeyHash$iv$iv4222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, materialized$iv$iv4222, ComposeUiNode.Companion.getSetModifier());
            int i9222 = ($changed$iv$iv$iv4222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope222 = ColumnScopeInstance.INSTANCE;
            int i10222 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 200988113, "C214@8390L21,215@8489L9,212@8323L289,219@8625L53,223@8764L6,224@8810L9,221@8692L240:ShopFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk(shopName, (Modifier) null, ColorKt.Color(!ThemesKt.isCurrentThemeLight($composer3, 0) ? 4279308561L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), scale), $composer3, ($dirty >> 3) & 14, 24960, 110586);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale)), $composer3, 0);
            TextKt.Text-Nvy7gAk(str62, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv5222 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(72, scale), ProvideUiScaleKt.dpScaled(26, scale)), RoundedCornerShapeKt.RoundedCornerShape(50)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv3222 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str3);
            MeasurePolicy measurePolicy$iv5222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3222, false);
            int $changed$iv$iv5222 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str7222);
            int compositeKeyHash$iv$iv5222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5222 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5222);
            Function0 factory$iv$iv$iv10222 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box222 = $changed$iv$iv5222 << 6;
            int $changed$iv$iv$iv5222 = ($i$f$Box222 & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str8222);
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5222 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5222, measurePolicy$iv5222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5222, localMap$iv$iv5222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5222, Integer.valueOf(compositeKeyHash$iv$iv5222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5222, materialized$iv$iv5222, ComposeUiNode.Companion.getSetModifier());
            int i11222 = ($changed$iv$iv$iv5222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2222 = BoxScopeInstance.INSTANCE;
            int i12222 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 982064371, "C240@9344L6,241@9397L9,238@9273L166:ShopFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("进店逛逛", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), scale), $composer3, 6, 0, 131066);
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
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit MerchantInfoComponent$lambda$4;
                    MerchantInfoComponent$lambda$4 = ShopFloorComponentKt.MerchantInfoComponent$lambda$4(avatarUrl, shopName, upOfficialType, shopSales, itemsNum, upName, positiveRatio, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MerchantInfoComponent$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel MerchantInfoComponent$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MerchantInfoComponent$lambda$2$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleShopJump$product_details_page_debug();
        return Unit.INSTANCE;
    }

    private static final void HotItemsComponent(final List<ProductShopDetailsShopItem> list, final Function1<? super ProductShopDetailsShopItem, Unit> function1, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-792385261);
        ComposerKt.sourceInformation($composer3, "C(HotItemsComponent)N(hotItems,onItem,scale,modifier)258@9743L548:ShopFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scale) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-792385261, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.HotItemsComponent (ShopFloorComponent.kt:253)");
            }
            if (list != null) {
                List list2 = CollectionsKt.take(list, 3);
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(12, scale), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                Modifier modifier$iv$iv = modifier$iv;
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                Composer $composer$iv$iv$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv.startReusableNode();
                if ($composer$iv$iv$iv.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer$iv$iv$iv.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer$iv$iv$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv);
                Function0 factory$iv$iv$iv3 = factory$iv$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                Composer $composer4 = $composer$iv$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i4 = ((0 >> 6) & 112) | 6;
                RowScope $this$HotItemsComponent_u24lambda_u241 = RowScopeInstance.INSTANCE;
                Composer $composer5 = $composer4;
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
                ComposerKt.sourceInformationMarkerStart($composer5, -1075390393, "C:ShopFloorComponent.kt#o90vz8");
                $composer5.startReplaceGroup(796594135);
                ComposerKt.sourceInformation($composer5, "*265@9935L215");
                List $this$forEachIndexed$iv = list2;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ProductShopDetailsShopItem it = (ProductShopDetailsShopItem) item$iv;
                    int index = index$iv;
                    Composer $composer6 = $composer5;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    Composer $composer$iv = $composer4;
                    Function0 factory$iv$iv$iv4 = factory$iv$iv$iv3;
                    Modifier modifier$iv$iv2 = modifier$iv$iv;
                    Alignment.Vertical verticalAlignment$iv2 = verticalAlignment$iv;
                    Arrangement.Horizontal horizontalArrangement$iv2 = horizontalArrangement$iv;
                    Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                    HotItemComponent(it, function1, scale, RowScope.-CC.weight$default($this$HotItemsComponent_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer6, ($dirty2 & 112) | ($dirty2 & 896), 0);
                    if (index < list2.size() - 1) {
                        $composer2 = $composer6;
                        $composer2.startReplaceGroup(2038967056);
                        ComposerKt.sourceInformation($composer2, "275@10209L52");
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer2, 0);
                    } else {
                        $composer2 = $composer6;
                        $composer2.startReplaceGroup(2028853988);
                    }
                    $composer2.endReplaceGroup();
                    $composer5 = $composer2;
                    modifier$iv$iv = modifier$iv$iv2;
                    verticalAlignment$iv = verticalAlignment$iv2;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    factory$iv$iv$iv3 = factory$iv$iv$iv4;
                    index$iv = index$iv2;
                    $composer4 = $composer$iv;
                    horizontalArrangement$iv = horizontalArrangement$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                }
                Composer $composer$iv2 = $composer4;
                Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                Composer $composer$iv3 = $composer5;
                $composer$iv3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
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
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2) {
                            Unit HotItemsComponent$lambda$0;
                            HotItemsComponent$lambda$0 = ShopFloorComponentKt.HotItemsComponent$lambda$0(list, function1, scale, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return HotItemsComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit HotItemsComponent$lambda$2;
                    HotItemsComponent$lambda$2 = ShopFloorComponentKt.HotItemsComponent$lambda$2(list, function1, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HotItemsComponent$lambda$2;
                }
            });
        }
    }

    private static final void HotItemComponent(final ProductShopDetailsShopItem item, final Function1<? super ProductShopDetailsShopItem, Unit> function1, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        String priceSymbol;
        Composer $composer3 = $composer.startRestartGroup(-2038645268);
        ComposerKt.sourceInformation($composer3, "C(HotItemComponent)N(item,onItem,scale,modifier)293@10629L60,289@10523L2162:ShopFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scale) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
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
                ComposerKt.traceEventStart(-2038645268, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.HotItemComponent (ShopFloorComponent.kt:287)");
            }
            String imgUrl = item.getItemsImg();
            if (imgUrl == null) {
                imgUrl = "";
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -633005464, "CC(remember):ShopFloorComponent.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit HotItemComponent$lambda$0$0;
                        HotItemComponent$lambda$0$0 = ShopFloorComponentKt.HotItemComponent$lambda$0$0(function1, item);
                        return HotItemComponent$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -469224544, "C298@10726L623,320@11425L21,321@11520L9,318@11359L365,327@11734L945:ShopFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 368500206, "C305@10942L397:ShopFloorComponent.kt#o90vz8");
            BiliImageKt.BiliImage(new ImageRequest(HelperKt.customizedImageUrl(imgUrl)).useRaw(true).contentScale(ContentScale.Companion.getFit()).build(), BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getLightGray-0d7_KjU(), (Shape) null, 2, (Object) null), null, null, null, null, null, null, null, $composer3, 48, 508);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String name = item.getName();
            String str = name == null ? "" : name;
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(7, scale), 0.0f, ProvideUiScaleKt.dpScaled(9, scale), 5, (Object) null), ColorKt.Color(ThemesKt.isCurrentThemeLight($composer3, 0) ? 4280361249L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24960, 110584);
            Modifier modifier$iv3 = Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv3 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 627917360, "C:ShopFloorComponent.kt#o90vz8");
            PriceModel netPriceInfo = item.getNetPriceInfo();
            String it = netPriceInfo != null ? netPriceInfo.getPricePrefix() : null;
            if (it == null) {
                $composer3.startReplaceGroup(627932517);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(627932518);
                ComposerKt.sourceInformation($composer3, "*335@12032L9,332@11910L242");
                TextKt.Text-Nvy7gAk(it, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 11, (Object) null), ColorKt.Color(4288256409L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 384, 0, 131064);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            PriceModel netPriceInfo2 = item.getNetPriceInfo();
            String it2 = netPriceInfo2 != null ? netPriceInfo2.getNetPrice() : null;
            if (it2 == null) {
                $composer3.startReplaceGroup(628255630);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(628255631);
                ComposerKt.sourceInformation($composer3, "*349@12609L9,346@12470L185");
                String priceSymbol2 = item.getNetPriceInfo().getPriceSymbol();
                if (priceSymbol2 == null || priceSymbol2.length() == 0) {
                    priceSymbol = "¥";
                } else {
                    priceSymbol = item.getNetPriceInfo().getPriceSymbol();
                }
                String priceSymbol3 = priceSymbol;
                TextKt.Text-Nvy7gAk(priceSymbol3 + it2, (Modifier) null, ColorKt.Color(4294901882L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 384, 0, 131066);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopFloorComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HotItemComponent$lambda$2;
                    HotItemComponent$lambda$2 = ShopFloorComponentKt.HotItemComponent$lambda$2(ProductShopDetailsShopItem.this, function1, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HotItemComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemComponent$lambda$0$0(Function1 $onItem, ProductShopDetailsShopItem $item) {
        $onItem.invoke($item);
        return Unit.INSTANCE;
    }
}