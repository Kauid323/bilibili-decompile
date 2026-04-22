package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
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
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CoverVO;
import kntr.app.mall.product.details.page.api.model.ShopInfoFloor;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.api.model.TextColorModel;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.mall.product.details.page.generated.resources.Drawable0_commonMainKt;
import srcs.app.mall.product.details.page.generated.resources.Res;

/* compiled from: ShopInfoFloorComponent.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a5\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0010\u001aU\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0018\u001aO\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u001f\u001aS\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\u000fH\u0003¢\u0006\u0004\b*\u0010+¨\u0006,²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020&X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"ShopInfoFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ShopInfoComponent", "shopInfoVO", "Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;", "onClick", "Lkotlin/Function0;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HotItemsComponent", "shopItems", "", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "onShopItemClick", "Lkotlin/Function1;", "onItem", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HotItemComponent", "item", "(Lkntr/app/mall/product/details/page/api/model/ShopItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ShopDataInfoRow", "shopDataInfo", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "(Ljava/util/List;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BreathingBorderEffect", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "animationDuration", "", "initialAlpha", "startScale", "endScale", "BreathingBorderEffect-_JZKGX4", "(FLandroidx/compose/ui/Modifier;JIFFFLandroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "availableWidth", "animationProgress"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShopInfoFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BreathingBorderEffect__JZKGX4$lambda$2(float f, Modifier modifier, long j, int i, float f2, float f3, float f4, int i2, int i3, Composer composer, int i4) {
        m528BreathingBorderEffect_JZKGX4(f, modifier, j, i, f2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemComponent$lambda$2(ShopItem shopItem, Function1 function1, Function1 function12, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HotItemComponent(shopItem, function1, function12, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemsComponent$lambda$1(List list, Function1 function1, Function1 function12, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HotItemsComponent(list, function1, function12, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopDataInfoRow$lambda$7(List list, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopDataInfoRow(list, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoComponent$lambda$1(ShopInfoFloor.ShopInfoVO shopInfoVO, Function0 function0, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopInfoComponent(shopInfoVO, function0, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$1(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$5(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopInfoFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ShopInfoFloorComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(1609125671);
        ComposerKt.sourceInformation($composer3, "C(ShopInfoFloorComponent)N(module,pageViewModel,modifier)77@3572L25,78@3651L16,89@4022L75,84@3776L321,99@4394L792,81@3706L1480:ShopInfoFloorComponent.kt#o90vz8");
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
                ComposerKt.traceEventStart(1609125671, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponent (ShopInfoFloorComponent.kt:69)");
            }
            if (module instanceof ContentModule.ShopInfoModule) {
                ShopInfoFloor shopFloorData = ((ContentModule.ShopInfoModule) module).getData();
                final ShopInfoFloor.ShopInfoVO shopInfoVO = shopFloorData.getShopInfoVO();
                if (shopInfoVO != null) {
                    final List shopItems = shopFloorData.getShopItems();
                    List list = shopItems;
                    final boolean showItems = !(list == null || list.isEmpty()) && shopItems.size() >= 3;
                    CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    final float scale = ShopInfoFloorComponent$lambda$2(scaleModel$delegate).getScale();
                    ComposerKt.sourceInformationMarkerStart($composer3, 181572050, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
                    boolean invalid$iv = $composer3.changedInstance(pageViewModel);
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda15
                            public final Object invoke() {
                                Unit ShopInfoFloorComponent$lambda$3$0;
                                ShopInfoFloorComponent$lambda$3$0 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$3$0(PageViewModel.this);
                                return ShopInfoFloorComponent$lambda$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2 = $composer3;
                    PaddingCardKt.PaddingCard(ExposerKt.reportOnExposure(modifier3, "shop_info_floor", collectorHolder, null, false, 0.5f, 0, 0L, (Function0) it$iv, $composer3, (($dirty2 >> 6) & 14) | 221232, 100), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(-1586145812, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit ShopInfoFloorComponent$lambda$4;
                            ShopInfoFloorComponent$lambda$4 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$4(ShopInfoFloor.ShopInfoVO.this, pageViewModel, scale, showItems, shopItems, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return ShopInfoFloorComponent$lambda$4;
                        }
                    }, $composer3, 54), $composer3, 24576, 0);
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
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ShopInfoFloorComponent$lambda$1;
                                ShopInfoFloorComponent$lambda$1 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$1(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ShopInfoFloorComponent$lambda$1;
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
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ShopInfoFloorComponent$lambda$0;
                            ShopInfoFloorComponent$lambda$0 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$0(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ShopInfoFloorComponent$lambda$0;
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
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShopInfoFloorComponent$lambda$5;
                    ShopInfoFloorComponent$lambda$5 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$5(ContentModule.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShopInfoFloorComponent$lambda$5;
                }
            });
        }
    }

    private static final UiScaleModel ShopInfoFloorComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$3$0(PageViewModel $pageViewModel) {
        $pageViewModel.reportShopFloorShow$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x01bd, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01f4, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ShopInfoFloorComponent$lambda$4(ShopInfoFloor.ShopInfoVO $shopInfoVO, final PageViewModel $pageViewModel, float $scale, boolean $showItems, List $shopItems, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 value$iv;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C100@4404L776:ShopInfoFloorComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586145812, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponent.<anonymous> (ShopInfoFloorComponent.kt:100)");
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
            ComposerKt.sourceInformationMarkerStart($composer, 633232223, "C105@4570L70,103@4484L202:ShopInfoFloorComponent.kt#o90vz8");
            ComposerKt.sourceInformationMarkerStart($composer, -1919233668, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($pageViewModel);
            Object it$iv = $composer.rememberedValue();
            if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ShopInfoComponent($shopInfoVO, value$iv, $scale, null, $composer, 0, 8);
                if ($showItems) {
                    $composer.startReplaceGroup(628761836);
                } else {
                    $composer.startReplaceGroup(633454213);
                    ComposerKt.sourceInformation($composer, "114@4833L118,117@4982L120,112@4733L423");
                    ComposerKt.sourceInformationMarkerStart($composer, -1919225204, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changedInstance($pageViewModel);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit ShopInfoFloorComponent$lambda$4$0$1$0;
                            ShopInfoFloorComponent$lambda$4$0$1$0 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$4$0$1$0(PageViewModel.this, (ShopItem) obj);
                            return ShopInfoFloorComponent$lambda$4$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    Function1 function1 = (Function1) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1919220434, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
                    boolean invalid$iv3 = $composer.changedInstance($pageViewModel);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit ShopInfoFloorComponent$lambda$4$0$2$0;
                            ShopInfoFloorComponent$lambda$4$0$2$0 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$4$0$2$0(PageViewModel.this, (ShopItem) obj);
                            return ShopInfoFloorComponent$lambda$4$0$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    HotItemsComponent($shopItems, function1, (Function1) it$iv3, $scale, null, $composer, 0, 16);
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
            value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit ShopInfoFloorComponent$lambda$4$0$0$0;
                    ShopInfoFloorComponent$lambda$4$0$0$0 = ShopInfoFloorComponentKt.ShopInfoFloorComponent$lambda$4$0$0$0(PageViewModel.this);
                    return ShopInfoFloorComponent$lambda$4$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ShopInfoComponent($shopInfoVO, value$iv, $scale, null, $composer, 0, 8);
            if ($showItems) {
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$4$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleShopJump$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$4$0$1$0(PageViewModel $pageViewModel, ShopItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        $pageViewModel.reportShopItemClick$product_details_page_debug(String.valueOf(item.getItemsId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopInfoFloorComponent$lambda$4$0$2$0(PageViewModel $pageViewModel, ShopItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ShopItem.JumpUrlVO jumpUrlVO = item.getJumpUrlVO();
        $pageViewModel.handleJumpUrl$product_details_page_debug(jumpUrlVO != null ? jumpUrlVO.getJumpUrlNA() : null);
        return Unit.INSTANCE;
    }

    private static final void ShopInfoComponent(final ShopInfoFloor.ShopInfoVO shopInfoVO, final Function0<Unit> function0, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer3;
        BoxScope $this$ShopInfoComponent_u24lambda_u240_u240;
        String str;
        Composer $composer$iv$iv;
        int $dirty;
        String str2;
        Composer $composer4;
        String str3;
        Function0 factory$iv$iv$iv3;
        String str4;
        Composer $composer$iv$iv2;
        Composer $composer5;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv3;
        Composer $composer$iv$iv3;
        String str5;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer6 = $composer.startRestartGroup(-1190603724);
        ComposerKt.sourceInformation($composer6, "C(ShopInfoComponent)N(shopInfoVO,onClick,scale,modifier)141@5664L3820:ShopInfoFloorComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer6.changedInstance(shopInfoVO) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer6.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer6.changed(scale) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer6.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer6.shouldExecute(($dirty3 & 1171) != 1170, $dirty3 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1190603724, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.ShopInfoComponent (ShopInfoFloorComponent.kt:133)");
            }
            String shopFace = shopInfoVO.getShopFace();
            if (shopFace == null) {
                shopFace = "";
            }
            String avatarUrl = shopFace;
            String shopName = shopInfoVO.getShopName();
            if (shopName == null) {
                shopName = "";
            }
            String shopName2 = shopName;
            Boolean living = shopInfoVO.getLiving();
            boolean isLiving = living != null ? living.booleanValue() : false;
            List shopDataInfo = shopInfoVO.getShopDataInfo();
            String upOfficialTypeIcon = shopInfoVO.getUpOfficialTypeIcon();
            shopInfoVO.getUpOfficialType();
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(44, scale)), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer6.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$ShopInfoComponent_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, -1715398508, "C152@5959L2257,211@8225L53,213@8288L683,239@9209L6,234@8981L497:ShopInfoFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(44, scale));
            ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            Modifier modifier5 = modifier4;
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ShopInfoComponent_u24lambda_u240_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, 441182985, "C:ShopInfoFloorComponent.kt#o90vz8");
            if (!(avatarUrl.length() > 0)) {
                $composer$iv = $composer6;
                $composer6.startReplaceGroup(441732335);
                ComposerKt.sourceInformation($composer6, "170@6685L45,169@6648L617");
                $composer3 = $composer6;
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShopAvatarPlace(Res.drawable.INSTANCE), $composer6, 0), (String) null, BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(1, scale), ColorKt.Color(4293125607L), RoundedCornerShapeKt.RoundedCornerShape(50)), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, $composer6, Painter.$stable | 24624, 104);
                $composer6.endReplaceGroup();
            } else {
                $composer6.startReplaceGroup(441160850);
                ComposerKt.sourceInformation($composer6, "156@6092L518");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(avatarUrl);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                $composer$iv = $composer6;
                BiliImageKt.BiliImage(imageRequest.build(), BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(0.5d, scale), ColorKt.Color(4293125607L), RoundedCornerShapeKt.RoundedCornerShape(50)), null, null, null, null, null, null, null, $composer6, 0, 508);
                $composer6.endReplaceGroup();
                $composer3 = $composer6;
            }
            if (isLiving) {
                $composer6.startReplaceGroup(442397440);
                ComposerKt.sourceInformation($composer6, "191@7558L6,186@7325L408");
                $this$ShopInfoComponent_u24lambda_u240_u240 = $this$ShopInfoComponent_u24lambda_u240_u2402;
                m528BreathingBorderEffect_JZKGX4(ProvideUiScaleKt.dpScaled(1, scale), SizeKt.size-3ABfNKs($this$ShopInfoComponent_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), ProvideUiScaleKt.dpScaled(40, scale)), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0, 0.0f, 1.0f, 1.25f, $composer6, 1769472, 24);
            } else {
                $this$ShopInfoComponent_u24lambda_u240_u240 = $this$ShopInfoComponent_u24lambda_u240_u2402;
                $composer6.startReplaceGroup(435117400);
            }
            $composer6.endReplaceGroup();
            String str6 = upOfficialTypeIcon;
            if (!(str6 == null || str6.length() == 0)) {
                $composer6.startReplaceGroup(442870500);
                ComposerKt.sourceInformation($composer6, "199@7820L372");
                Modifier modifier$iv3 = $this$ShopInfoComponent_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                $composer4 = $composer3;
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $dirty = $dirty3;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer6.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv = $composer6;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -1354585642, "C204@7986L188:ShopInfoFloorComponent.kt#o90vz8");
                String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(upOfficialTypeIcon);
                ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                Unit unit2 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(15, scale)), null, null, null, null, null, null, null, $composer6, 0, 508);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
            } else {
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv = $composer6;
                $dirty = $dirty3;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer4 = $composer3;
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer6.startReplaceGroup(435117400);
            }
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            Composer $composer7 = $composer4;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer7, 0);
            Modifier modifier$iv4 = RowScope.-CC.weight$default($this$ShopInfoComponent_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer7, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4 = (0 << 3) & 112;
            String str7 = str;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, str7);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer7, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            String str8 = str2;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, str8);
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer7.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            $composer7.startReplaceGroup(-1984941827);
            ComposerKt.sourceInformation($composer7, "C216@8408L21,217@8507L9,214@8341L289,221@8643L53,227@8803L158:ShopInfoFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk(shopName2, (Modifier) null, ColorKt.Color(ThemesKt.isCurrentThemeLight($composer7, 0) ? 4279308561L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT14b(), scale), $composer7, 0, 24960, 110586);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale)), $composer7, 0);
            List list = shopDataInfo;
            if (list == null || list.isEmpty()) {
                $composer7.endReplaceGroup();
                $composer$iv$iv$iv = $composer7;
                $composer$iv$iv2 = $composer6;
                $composer$iv$iv3 = $composer7;
                $composer$iv3 = $composer6;
                modifier3 = modifier5;
                str4 = str7;
                $composer5 = $composer7;
                $composer$iv2 = $composer7;
                str5 = str8;
            } else {
                str4 = str7;
                $composer$iv$iv2 = $composer6;
                $composer5 = $composer7;
                $composer$iv2 = $composer7;
                $composer$iv$iv$iv = $composer7;
                $composer$iv3 = $composer6;
                $composer$iv$iv3 = $composer7;
                modifier3 = modifier5;
                str5 = str8;
                ShopDataInfoRow(shopDataInfo, scale, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer7, (($dirty >> 3) & 112) | 384, 0);
                $composer7.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            Composer $composer8 = $composer5;
            Modifier modifier$iv5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(72, scale), ProvideUiScaleKt.dpScaled(26, scale)), RoundedCornerShapeKt.RoundedCornerShape(50)), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, str3);
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv5 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, str4);
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer8.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer8, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer8, -553112988, str5);
            if (!($composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer8.startReusableNode();
            if ($composer8.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer8.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer8.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer8);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i12 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer8, 1802712074, "C244@9373L6,245@9426L9,242@9302L166:ShopInfoFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("进店逛逛", (Modifier) null, BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT13(), scale), $composer8, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            $composer8.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShopInfoComponent$lambda$1;
                    ShopInfoComponent$lambda$1 = ShopInfoFloorComponentKt.ShopInfoComponent$lambda$1(ShopInfoFloor.ShopInfoVO.this, function0, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShopInfoComponent$lambda$1;
                }
            });
        }
    }

    private static final void HotItemsComponent(final List<ShopItem> list, final Function1<? super ShopItem, Unit> function1, final Function1<? super ShopItem, Unit> function12, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1822456238);
        ComposerKt.sourceInformation($composer2, "C(HotItemsComponent)N(shopItems,onShopItemClick,onItem,scale,modifier)260@9729L599:ShopInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1822456238, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.HotItemsComponent (ShopInfoFloorComponent.kt:258)");
            }
            List list2 = CollectionsKt.take(list, 3);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(12, scale), 0.0f, 0.0f, 13, (Object) null);
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Alignment.Vertical verticalAlignment$iv2 = verticalAlignment$iv;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            RowScope $this$HotItemsComponent_u24lambda_u240 = RowScopeInstance.INSTANCE;
            Composer $composer3 = $composer$iv2;
            Modifier materialized$iv$iv2 = materialized$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 53822933, "C:ShopInfoFloorComponent.kt#o90vz8");
            $composer3.startReplaceGroup(-1660831607);
            ComposerKt.sourceInformation($composer3, "*267@9921L266");
            List $this$forEachIndexed$iv = list2;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ShopItem it = (ShopItem) item$iv;
                int index = index$iv;
                int index2 = $dirty2 & 896;
                Modifier materialized$iv$iv3 = materialized$iv$iv2;
                Composer $composer4 = $composer3;
                Alignment.Vertical verticalAlignment$iv3 = verticalAlignment$iv2;
                Composer $composer$iv3 = $composer$iv2;
                Arrangement.Horizontal horizontalArrangement$iv2 = horizontalArrangement$iv;
                Composer $composer$iv4 = $composer$iv;
                Modifier modifier5 = modifier4;
                CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
                HotItemComponent(it, function1, function12, scale, RowScope.-CC.weight$default($this$HotItemsComponent_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer4, ($dirty2 & 112) | index2 | ($dirty2 & 7168), 0);
                if (index < list2.size() - 1) {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(-1361253362);
                    ComposerKt.sourceInformation($composer3, "278@10246L52");
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer3, 0);
                } else {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(-1371403134);
                }
                $composer3.endReplaceGroup();
                $composer$iv = $composer$iv4;
                localMap$iv$iv = localMap$iv$iv2;
                verticalAlignment$iv2 = verticalAlignment$iv3;
                index$iv = index$iv2;
                $composer$iv2 = $composer$iv3;
                horizontalArrangement$iv = horizontalArrangement$iv2;
                modifier4 = modifier5;
                materialized$iv$iv2 = materialized$iv$iv3;
            }
            modifier3 = modifier4;
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit HotItemsComponent$lambda$1;
                    HotItemsComponent$lambda$1 = ShopInfoFloorComponentKt.HotItemsComponent$lambda$1(list, function1, function12, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HotItemsComponent$lambda$1;
                }
            });
        }
    }

    private static final void HotItemComponent(final ShopItem item, final Function1<? super ShopItem, Unit> function1, final Function1<? super ShopItem, Unit> function12, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        String priceSymbol;
        Composer $composer3 = $composer.startRestartGroup(-1214804722);
        ComposerKt.sourceInformation($composer3, "C(HotItemComponent)N(item,onShopItemClick,onItem,scale,modifier)297@10675L106,293@10569L2921:ShopInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
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
                ComposerKt.traceEventStart(-1214804722, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.HotItemComponent (ShopInfoFloorComponent.kt:291)");
            }
            CoverVO coverVO = item.getCoverVO();
            String imgUrl = (coverVO == null || (imgUrl = coverVO.getUrl()) == null) ? "" : "";
            ComposerKt.sourceInformationMarkerStart($composer3, 803777112, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer3.changedInstance(item) | (($dirty2 & 896) == 256);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit HotItemComponent$lambda$0$0;
                        HotItemComponent$lambda$0$0 = ShopInfoFloorComponentKt.HotItemComponent$lambda$0$0(function1, item, function12);
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
            Modifier modifier5 = modifier4;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1641890965, "C303@10818L623,325@11522L21,326@11617L9,323@11451L370,332@11831L1653:ShopInfoFloorComponent.kt#o90vz8");
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
            ComposerKt.sourceInformationMarkerStart($composer3, -2009315956, "C310@11034L397:ShopInfoFloorComponent.kt#o90vz8");
            BiliImageKt.BiliImage(new ImageRequest(HelperKt.customizedImageUrl(imgUrl)).useRaw(true).contentScale(ContentScale.Companion.getFit()).build(), BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getLightGray-0d7_KjU(), (Shape) null, 2, (Object) null), null, null, null, null, null, null, null, $composer3, 48, 508);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String itemsName = item.getItemsName();
            TextKt.Text-Nvy7gAk(itemsName == null ? "" : itemsName, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(7, scale), 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 5, (Object) null), ColorKt.Color(ThemesKt.isCurrentThemeLight($composer3, 0) ? 4280361249L : 4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24960, 110584);
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
            int i8 = ((390 >> 6) & 112) | 6;
            RowScope $this$HotItemComponent_u24lambda_u241_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1144307574, "C353@12595L9,354@12658L6,351@12519L256:ShopInfoFloorComponent.kt#o90vz8");
            ShopItem.PriceInfoVO priceInfoVO = item.getPriceInfoVO();
            String it = priceInfoVO != null ? priceInfoVO.getPricePrefix() : null;
            if (it == null) {
                $composer3.startReplaceGroup(-1144314458);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1144314457);
                ComposerKt.sourceInformation($composer3, "*339@12081L6,340@12138L9,337@12006L271");
                TextKt.Text-Nvy7gAk(it, $this$HotItemComponent_u24lambda_u241_u241.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24576, 114680);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ShopItem.PriceInfoVO priceInfoVO2 = item.getPriceInfoVO();
            String priceSymbol2 = priceInfoVO2 != null ? priceInfoVO2.getPriceSymbol() : null;
            if (priceSymbol2 == null || priceSymbol2.length() == 0) {
                priceSymbol = "¥";
            } else {
                priceSymbol = item.getPriceInfoVO().getPriceSymbol();
            }
            TextKt.Text-Nvy7gAk(priceSymbol, $this$HotItemComponent_u24lambda_u241_u241.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24576, 114680);
            ShopItem.PriceInfoVO priceInfoVO3 = item.getPriceInfoVO();
            String it2 = priceInfoVO3 != null ? priceInfoVO3.getNetPrice() : null;
            if (it2 == null) {
                $composer3.startReplaceGroup(-1143489114);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1143489113);
                ComposerKt.sourceInformation($composer3, "*361@12913L6,362@12970L9,359@12838L271");
                TextKt.Text-Nvy7gAk(it2, $this$HotItemComponent_u24lambda_u241_u241.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), scale), $composer3, 0, 24576, 114680);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ShopItem.PriceInfoVO priceInfoVO4 = item.getPriceInfoVO();
            String it3 = priceInfoVO4 != null ? priceInfoVO4.getPriceSuffix() : null;
            if (it3 == null) {
                $composer3.startReplaceGroup(-1143140922);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1143140921);
                ComposerKt.sourceInformation($composer3, "*370@13264L6,371@13321L9,368@13189L271");
                TextKt.Text-Nvy7gAk(it3, $this$HotItemComponent_u24lambda_u241_u241.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24576, 114680);
                Unit unit5 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
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
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit HotItemComponent$lambda$2;
                    HotItemComponent$lambda$2 = ShopInfoFloorComponentKt.HotItemComponent$lambda$2(ShopItem.this, function1, function12, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HotItemComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HotItemComponent$lambda$0$0(Function1 $onShopItemClick, ShopItem $item, Function1 $onItem) {
        $onShopItemClick.invoke($item);
        $onItem.invoke($item);
        return Unit.INSTANCE;
    }

    private static final void ShopDataInfoRow(final List<TextColorModel> list, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        TextStyle textStyle;
        String str;
        List list2;
        Function0 factory$iv$iv$iv;
        List fittingTexts;
        Iterable $this$forEachIndexed$iv;
        long dayColor;
        long dayColor2;
        long nightColor;
        Composer $composer2 = $composer.startRestartGroup(252010390);
        ComposerKt.sourceInformation($composer2, "C(ShopDataInfoRow)N(shopDataInfo,scale,modifier)386@13663L7,390@13796L9,391@13847L22,393@13897L33,397@14003L1091,432@15183L94,429@15100L842:ShopInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(scale) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(252010390, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ShopDataInfoRow (ShopInfoFloorComponent.kt:385)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            float spacing = ProvideUiScaleKt.dpScaled(8, scale);
            int spacingPx = density.roundToPx-0680j_4(spacing);
            TextStyle textStyle2 = ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), scale);
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            String str2 = "CC(remember):ShopInfoFloorComponent.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer2, 1663828503, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState availableWidth$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int ShopDataInfoRow$lambda$2 = ShopDataInfoRow$lambda$2(availableWidth$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 1663832953, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(ShopDataInfoRow$lambda$2) | $composer2.changed(list);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                boolean z = false;
                if (ShopDataInfoRow$lambda$2(availableWidth$delegate) <= 0) {
                    list2 = CollectionsKt.emptyList();
                    textStyle = textStyle2;
                    str = "CC(remember):ShopInfoFloorComponent.kt#9igjgp";
                } else {
                    List textsToShow = new ArrayList();
                    Iterator<TextColorModel> it = list.iterator();
                    int totalWidth = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            textStyle = textStyle2;
                            str = str2;
                            break;
                        }
                        boolean z2 = z;
                        TextColorModel dataInfo = it.next();
                        String text = dataInfo.getText();
                        if (text == null) {
                            text = "";
                        }
                        String text2 = text;
                        if (!(text2.length() == 0)) {
                            int $dirty3 = $dirty2;
                            Object it$iv2 = value$iv2;
                            str = str2;
                            textStyle = textStyle2;
                            int textWidth = (int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(text2, (List) null, 2, (DefaultConstructorMarker) null), textStyle2, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32);
                            int neededWidth = textsToShow.isEmpty() ? textWidth : textWidth + spacingPx;
                            if (totalWidth + neededWidth > ShopDataInfoRow$lambda$2(availableWidth$delegate)) {
                                break;
                            }
                            totalWidth += neededWidth;
                            textsToShow.add(dataInfo);
                            textStyle2 = textStyle;
                            str2 = str;
                            value$iv2 = it$iv2;
                            z = z2;
                            $dirty2 = $dirty3;
                        } else {
                            z = z2;
                        }
                    }
                    list2 = textsToShow;
                }
                value$iv2 = list2;
                $composer2.updateRememberedValue(value$iv2);
            } else {
                textStyle = textStyle2;
                str = "CC(remember):ShopInfoFloorComponent.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            List fittingTexts2 = (List) value$iv2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1663869716, str);
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit ShopDataInfoRow$lambda$5$0;
                        ShopDataInfoRow$lambda$5$0 = ShopInfoFloorComponentKt.ShopDataInfoRow$lambda$5$0(availableWidth$delegate, (LayoutCoordinates) obj);
                        return ShopDataInfoRow$lambda$5$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) it$iv3);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            Composer $composer$iv$iv = $composer2;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv.startReusableNode();
            if ($composer$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Composer $composer3 = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1244539304, "C:ShopInfoFloorComponent.kt#o90vz8");
            $composer3.startReplaceGroup(2118356814);
            ComposerKt.sourceInformation($composer3, "447@15749L21,*445@15670L256");
            List $this$forEachIndexed$iv2 = fittingTexts2;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv2) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TextColorModel model = (TextColorModel) item$iv;
                int index = index$iv;
                if (index > 0) {
                    fittingTexts = fittingTexts2;
                    $composer3.startReplaceGroup(1158915893);
                    ComposerKt.sourceInformation($composer3, "439@15442L31");
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, spacing), $composer3, 0);
                } else {
                    fittingTexts = fittingTexts2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    $composer3.startReplaceGroup(1143612340);
                }
                $composer3.endReplaceGroup();
                String dayColor3 = model.getDayColor();
                Color color = dayColor3 != null ? Color.box-impl(ComposeColorParserKt.parseColor(dayColor3)) : null;
                if (color == null) {
                    $composer3.startReplaceGroup(1561409491);
                    ComposerKt.sourceInformation($composer3, "442@15558L6");
                    dayColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1561407972);
                    $composer3.endReplaceGroup();
                    dayColor = color.unbox-impl();
                }
                String nightColor2 = model.getNightColor();
                Color color2 = nightColor2 != null ? Color.box-impl(ComposeColorParserKt.parseColor(nightColor2)) : null;
                if (color2 == null) {
                    dayColor2 = dayColor;
                    $composer3.startReplaceGroup(1561412243);
                    ComposerKt.sourceInformation($composer3, "443@15644L6");
                    nightColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    dayColor2 = dayColor;
                    $composer3.startReplaceGroup(1561410662);
                    $composer3.endReplaceGroup();
                    nightColor = color2.unbox-impl();
                }
                String text3 = model.getText();
                if (text3 == null) {
                    text3 = "";
                }
                Composer $composer4 = $composer3;
                TextKt.Text-Nvy7gAk(text3, (Modifier) null, ThemesKt.isCurrentThemeLight($composer3, 0) ? dayColor2 : nightColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, textStyle, $composer4, 0, 24960, 110586);
                $composer$iv$iv = $composer$iv$iv;
                measurePolicy$iv$iv = measurePolicy$iv$iv;
                index$iv = index$iv2;
                fittingTexts2 = fittingTexts;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                $composer3 = $composer4;
            }
            Composer $composer5 = $composer3;
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShopDataInfoRow$lambda$7;
                    ShopDataInfoRow$lambda$7 = ShopInfoFloorComponentKt.ShopDataInfoRow$lambda$7(list, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShopDataInfoRow$lambda$7;
                }
            });
        }
    }

    private static final int ShopDataInfoRow$lambda$2(MutableIntState $availableWidth$delegate) {
        IntState $this$getValue$iv = (IntState) $availableWidth$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopDataInfoRow$lambda$5$0(MutableIntState $availableWidth$delegate, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        $availableWidth$delegate.setIntValue((int) (coordinates.getSize-YbymL2g() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01d2, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /* renamed from: BreathingBorderEffect-_JZKGX4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m528BreathingBorderEffect_JZKGX4(final float f, Modifier modifier, long j, int animationDuration, float initialAlpha, float startScale, float endScale, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j2;
        int animationDuration2;
        float startScale2;
        float initialAlpha2;
        float endScale2;
        float startScale3;
        long j3;
        int animationDuration3;
        Modifier modifier3;
        float initialAlpha3;
        float endScale3;
        Composer $composer2 = $composer.startRestartGroup(1358498583);
        ComposerKt.sourceInformation($composer2, "C(BreathingBorderEffect)N(borderWidth:c#ui.unit.Dp,modifier,color:c#ui.graphics.Color,animationDuration,initialAlpha,startScale,endScale)466@16255L65,467@16369L324,481@16856L246,481@16828L274:ShopInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(f) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            j2 = j;
        } else if (($changed & 384) == 0) {
            j2 = j;
            $dirty |= $composer2.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            animationDuration2 = animationDuration;
        } else if (($changed & 3072) == 0) {
            animationDuration2 = animationDuration;
            $dirty |= $composer2.changed(animationDuration2) ? 2048 : 1024;
        } else {
            animationDuration2 = animationDuration;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(initialAlpha) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            startScale2 = startScale;
        } else if (($changed & 196608) == 0) {
            startScale2 = startScale;
            $dirty |= $composer2.changed(startScale2) ? 131072 : 65536;
        } else {
            startScale2 = startScale;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(endScale) ? 1048576 : 524288;
        }
        if (!$composer2.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            initialAlpha2 = initialAlpha;
            endScale2 = endScale;
            startScale3 = startScale2;
            j3 = j2;
            animationDuration3 = animationDuration2;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (i3 != 0) {
                j2 = ColorKt.Color(4294928025L);
            }
            if (i4 != 0) {
                animationDuration2 = 2000;
            }
            if (i5 == 0) {
                initialAlpha3 = initialAlpha;
            } else {
                initialAlpha3 = 0.6f;
            }
            if (i6 != 0) {
                startScale2 = 0.96f;
            }
            if (i7 == 0) {
                endScale3 = endScale;
            } else {
                endScale3 = 2.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1358498583, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.BreathingBorderEffect (ShopInfoFloorComponent.kt:465)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("breathing_border_transition", $composer2, 6, 0);
            State animationProgress$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(animationDuration2, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), "breathing_progress", $composer2, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            final float scale = ((endScale3 - startScale2) * BreathingBorderEffect__JZKGX4$lambda$0(animationProgress$delegate)) + startScale2;
            final float alpha = (1 - BreathingBorderEffect__JZKGX4$lambda$0(animationProgress$delegate)) * initialAlpha3;
            float initialAlpha4 = initialAlpha3;
            ComposerKt.sourceInformationMarkerStart($composer2, -152890995, "CC(remember):ShopInfoFloorComponent.kt#9igjgp");
            float endScale4 = endScale3;
            boolean invalid$iv = $composer2.changed(scale) | (($dirty & 896) == 256) | $composer2.changed(alpha) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j4 = j2;
            Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit BreathingBorderEffect__JZKGX4$lambda$1$0;
                    BreathingBorderEffect__JZKGX4$lambda$1$0 = ShopInfoFloorComponentKt.BreathingBorderEffect__JZKGX4$lambda$1$0(scale, j4, alpha, f, (DrawScope) obj);
                    return BreathingBorderEffect__JZKGX4$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier2, (Function1) it$iv, $composer2, ($dirty >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            endScale2 = endScale4;
            startScale3 = startScale2;
            j3 = j2;
            initialAlpha2 = initialAlpha4;
            animationDuration3 = animationDuration2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j5 = j3;
            final int i8 = animationDuration3;
            final float f2 = initialAlpha2;
            final float f3 = startScale3;
            final float f4 = endScale2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ShopInfoFloorComponentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit BreathingBorderEffect__JZKGX4$lambda$2;
                    BreathingBorderEffect__JZKGX4$lambda$2 = ShopInfoFloorComponentKt.BreathingBorderEffect__JZKGX4$lambda$2(f, modifier4, j5, i8, f2, f3, f4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BreathingBorderEffect__JZKGX4$lambda$2;
                }
            });
        }
    }

    private static final float BreathingBorderEffect__JZKGX4$lambda$0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BreathingBorderEffect__JZKGX4$lambda$1$0(float $scale, long j, float $alpha, float f, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        long j2 = $this$Canvas.getCenter-F1C5BW0();
        DrawContext $this$withTransform_u24lambda_u240$iv$iv = $this$Canvas.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u240$iv$iv.getSize-NH-jbRc();
        $this$withTransform_u24lambda_u240$iv$iv.getCanvas().save();
        try {
            DrawTransform $this$scale_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u240$iv$iv.getTransform();
            $this$scale_Rg1IO4c_u24lambda_u240$iv.scale-0AR0LA0($scale, $scale, j2);
            try {
                DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, Color.copy-wmQWz5c$default(j, $alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), Size.getMinDimension-impl($this$Canvas.getSize-NH-jbRc()) / 2.0f, 0L, 0.0f, new Stroke($this$Canvas.toPx-0680j_4(f) / $scale, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, (int) ConstantsKt.RESERVATION_CARD_HEIGHT, (Object) null);
                $this$withTransform_u24lambda_u240$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u240$iv$iv.setSize-uvyYCjk(previousSize$iv$iv);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                $this$withTransform_u24lambda_u240$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u240$iv$iv.setSize-uvyYCjk(previousSize$iv$iv);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}