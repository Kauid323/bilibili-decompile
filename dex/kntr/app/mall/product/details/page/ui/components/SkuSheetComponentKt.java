package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
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
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
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
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
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
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.mall.product.details.page.ui.container.BottomContainerKt;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.BottomContainerState;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkuSheetComponent.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001aW\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"SkuSheetComponent", "", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SpecGroupComponentEnhanced", "data", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;", "specIndex", "", "selectedIndex", "isValueSelectable", "Lkotlin/Function1;", "", "onValueSelect", "(Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BottomActionComponent", "selectedSku", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;", "bottomContainerState", "Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "(Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SkuSheetComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomActionComponent$lambda$0(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem, ContentModule.FooterModule footerModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomActionComponent(itemsSkuListItem, footerModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomActionComponent$lambda$1(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem, ContentModule.FooterModule footerModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomActionComponent(itemsSkuListItem, footerModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomActionComponent$lambda$4(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem, ContentModule.FooterModule footerModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomActionComponent(itemsSkuListItem, footerModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$1(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSheetComponent(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$17(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSheetComponent(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$2(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSheetComponent(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$3(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSheetComponent(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$4(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSheetComponent(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SpecGroupComponentEnhanced$lambda$1(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoListItem, int i, int i2, Function1 function1, Function1 function12, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        SpecGroupComponentEnhanced(specInfoListItem, i, i2, function1, function12, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0b74, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L148;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0852  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x08d4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x08d9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0982  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0a5d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0a69  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0a6f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0b6c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0b78  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0cd6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0ce2  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0ce8  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0d73  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x1002  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x100e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x1014  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x1134  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x113b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x117c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SkuSheetComponent(final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        final int i2;
        final int $dirty;
        final PageViewModel pageViewModel2;
        Object obj;
        Composer $composer3;
        Modifier modifier3;
        List itemsSkuList;
        List specInfoList;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer4;
        String str;
        final MutableState currentImageUrl;
        Function0 factory$iv$iv$iv6;
        boolean invalid$iv;
        Composer $composer5;
        Function0 factory$iv$iv$iv7;
        Composer $composer6;
        Function0 factory$iv$iv$iv8;
        Object value$iv;
        MutableState currentImageUrl2;
        boolean invalid$iv2;
        Object it$iv;
        Composer $composer7;
        char c;
        Composer $composer$iv$iv;
        Modifier materialized$iv$iv;
        Arrangement.Vertical verticalArrangement$iv;
        BoxScope $this$SkuSheetComponent_u24lambda_u2416;
        Function0 factory$iv$iv$iv9;
        Alignment contentAlignment$iv;
        Function1 function1;
        MeasurePolicy measurePolicy$iv$iv;
        Modifier modifier$iv$iv;
        Modifier modifier$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Modifier materialized$iv$iv2;
        Composer $composer$iv2;
        final MutableState currentImageUrl3;
        Object value$iv2;
        ContentModule it;
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer8 = $composer.startRestartGroup(1472924134);
        ComposerKt.sourceInformation($composer8, "C(SkuSheetComponent)N(pageViewModel,modifier)54@2562L16,66@3091L53,67@3176L198,73@3405L53,63@2999L459,79@3530L71,79@3513L88,82@3664L22,82@3647L39,85@3743L22,85@3726L39,145@5973L417,145@5937L453,157@6395L5159:SkuSheetComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer8.changedInstance(pageViewModel) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer8.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer8.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            final Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472924134, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.SkuSheetComponent (SkuSheetComponent.kt:53)");
            }
            State contentModules = SnapshotStateKt.collectAsState(pageViewModel.getContentModules$product_details_page_debug(), (CoroutineContext) null, $composer8, 0, 1);
            Iterator it2 = ((Iterable) contentModules.getValue()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                ContentModule it3 = (ContentModule) obj;
                if (it3.getFloorType() == FloorType.SKU_INFO) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    break;
                }
            }
            ContentModule skuInfoModule = (ContentModule) obj;
            ContentModule.SkuInfoModule skuInfoModule2 = (ContentModule.SkuInfoModule) skuInfoModule;
            if (skuInfoModule2 != null) {
                SkuInfoFloor skuInfoFloor = skuInfoModule2.getData();
                if (skuInfoFloor == null) {
                    $composer3 = $composer8;
                    modifier3 = modifier4;
                } else {
                    SkuInfoFloor.ItemsSkuListVO itemsSkuInfoVO = skuInfoFloor.getItemsSkuListVO();
                    if (itemsSkuInfoVO == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer8.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda19
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit SkuSheetComponent$lambda$2;
                                    SkuSheetComponent$lambda$2 = SkuSheetComponentKt.SkuSheetComponent$lambda$2(PageViewModel.this, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SkuSheetComponent$lambda$2;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    List specInfoList2 = itemsSkuInfoVO.getSpecInfoList();
                    if (specInfoList2 == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = $composer8.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda22
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit SkuSheetComponent$lambda$3;
                                    SkuSheetComponent$lambda$3 = SkuSheetComponentKt.SkuSheetComponent$lambda$3(PageViewModel.this, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SkuSheetComponent$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    List itemsSkuList2 = itemsSkuInfoVO.getItemsSkuList();
                    if (itemsSkuList2 == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup3 = $composer8.endRestartGroup();
                        if (endRestartGroup3 != null) {
                            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit SkuSheetComponent$lambda$4;
                                    SkuSheetComponent$lambda$4 = SkuSheetComponentKt.SkuSheetComponent$lambda$4(PageViewModel.this, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SkuSheetComponent$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859093125, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    Object it$iv2 = $composer8.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2, Object obj3) {
                                List SkuSheetComponent$lambda$5$0;
                                SkuSheetComponent$lambda$5$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$5$0((SaverScope) obj2, (SnapshotStateMap) obj3);
                                return SkuSheetComponent$lambda$5$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv3);
                        it$iv2 = value$iv3;
                    }
                    Function2 function2 = (Function2) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859090260, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    Object it$iv3 = $composer8.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                SnapshotStateMap SkuSheetComponent$lambda$6$0;
                                SkuSheetComponent$lambda$6$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$6$0((List) obj2);
                                return SkuSheetComponent$lambda$6$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv4);
                        it$iv3 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    Saver listSaver = ListSaverKt.listSaver(function2, (Function1) it$iv3);
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859083077, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    Object it$iv4 = $composer8.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                SnapshotStateMap SkuSheetComponent$lambda$7$0;
                                SkuSheetComponent$lambda$7$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$7$0();
                                return SkuSheetComponent$lambda$7$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    SnapshotStateMap selectedSpecIndices = (SnapshotStateMap) RememberSaveableKt.rememberSaveable(objArr, listSaver, (Function0) it$iv4, $composer8, 384);
                    Object[] objArr2 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859079059, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    Object it$iv5 = $composer8.rememberedValue();
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                MutableState SkuSheetComponent$lambda$8$0;
                                SkuSheetComponent$lambda$8$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$8$0();
                                return SkuSheetComponent$lambda$8$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv6);
                        it$iv5 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    MutableState currentSelectedSku = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) it$iv5, $composer8, 48);
                    Object[] objArr3 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859074820, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    Object it$iv6 = $composer8.rememberedValue();
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                MutableState SkuSheetComponent$lambda$9$0;
                                SkuSheetComponent$lambda$9$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$9$0();
                                return SkuSheetComponent$lambda$9$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv7);
                        it$iv6 = value$iv7;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    MutableState currentImageUrl4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) it$iv6, $composer8, 48);
                    Object[] objArr4 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859072292, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    Object it$iv7 = $composer8.rememberedValue();
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                MutableState SkuSheetComponent$lambda$10$0;
                                SkuSheetComponent$lambda$10$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$10$0();
                                return SkuSheetComponent$lambda$10$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv8);
                        it$iv7 = value$iv8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    MutableState currentPrice = (MutableState) RememberSaveableKt.rememberSaveable(objArr4, (Function0) it$iv7, $composer8, 48);
                    ComposerKt.sourceInformationMarkerStart($composer8, -1859000537, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    boolean invalid$iv3 = $composer8.changedInstance(specInfoList2) | $composer8.changed(selectedSpecIndices) | $composer8.changedInstance(itemsSkuList2) | $composer8.changed(currentSelectedSku) | $composer8.changed(currentImageUrl4) | $composer8.changed(currentPrice);
                    Object value$iv9 = $composer8.rememberedValue();
                    if (!invalid$iv3 && value$iv9 != Composer.Companion.getEmpty()) {
                        itemsSkuList = itemsSkuList2;
                        specInfoList = specInfoList2;
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        EffectsKt.LaunchedEffect(specInfoList, (Function2) value$iv9, $composer8, 0);
                        Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                        CompositionLocalMap localMap$iv$iv = $composer8.getCurrentCompositionLocalMap();
                        Modifier modifier5 = modifier4;
                        Composer $composer$iv3 = $composer8;
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer8, modifier$iv);
                        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                        Alignment contentAlignment$iv3 = contentAlignment$iv2;
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        MutableState currentSelectedSku2 = currentSelectedSku;
                        ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer8.startReusableNode();
                        if ($composer8.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv10;
                            $composer8.useNode();
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv10;
                            $composer8.createNode(factory$iv$iv$iv);
                        }
                        Function0 factory$iv$iv$iv11 = factory$iv$iv$iv;
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer8);
                        final List specInfoList3 = specInfoList;
                        SnapshotStateMap selectedSpecIndices2 = selectedSpecIndices;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        int i5 = ((0 >> 6) & 112) | 6;
                        BoxScope $this$SkuSheetComponent_u24lambda_u24162 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer8, -464368973, "C158@6444L4612,284@11273L16,280@11091L457:SkuSheetComponent.kt#o90vz8");
                        BoxScope $this$SkuSheetComponent_u24lambda_u24163 = $this$SkuSheetComponent_u24lambda_u24162;
                        Modifier materialized$iv$iv4 = materialized$iv$iv3;
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer8, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv, $composer8, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv2 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer8.getCurrentCompositionLocalMap();
                        Composer $composer$iv4 = $composer8;
                        Arrangement.Vertical verticalArrangement$iv3 = verticalArrangement$iv2;
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer8, modifier$iv2);
                        Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                        Modifier modifier$iv$iv3 = modifier$iv2;
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer8.startReusableNode();
                        if ($composer8.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv12;
                            $composer8.useNode();
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv12;
                            $composer8.createNode(factory$iv$iv$iv2);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer8);
                        MutableState currentPrice2 = currentPrice;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                        int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer8, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i7 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, 507623692, "C160@6521L395,173@6955L2344,237@9478L21,233@9334L1712:SkuSheetComponent.kt#o90vz8");
                        Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment contentAlignment$iv4 = Alignment.Companion.getTopEnd();
                        Modifier materialized$iv$iv6 = materialized$iv$iv5;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                        int $changed$iv$iv3 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer8.getCurrentCompositionLocalMap();
                        Composer $composer$iv$iv$iv2 = $composer8;
                        Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer8, modifier$iv3);
                        Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer8.startReusableNode();
                        if ($composer8.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv13;
                            $composer8.useNode();
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv13;
                            $composer8.createNode(factory$iv$iv$iv3);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer8);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                        int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i9 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1159084048, "C165@6712L20,166@6771L6,164@6663L239:SkuSheetComponent.kt#o90vz8");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_line_500($composer8, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText3-0d7_KjU(), $composer8, Painter.$stable | 432, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer8.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer8, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer8, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv4 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer8.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer8, modifier$iv4);
                        Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer8.startReusableNode();
                        if ($composer8.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv14;
                            $composer8.useNode();
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv14;
                            $composer8.createNode(factory$iv$iv$iv4);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer8);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                        int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        int i11 = ((6 >> 6) & 112) | 6;
                        RowScope $this$SkuSheetComponent_u24lambda_u2416_u240_u241 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer8, -982317073, "C187@7462L6,180@7159L1017,205@8223L1062:SkuSheetComponent.kt#o90vz8");
                        Modifier modifier$iv5 = BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(88)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getLine_light-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                        ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        int $changed$iv$iv5 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                        CompositionLocalMap localMap$iv$iv5 = $composer8.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer8, modifier$iv5);
                        Function0 factory$iv$iv$iv15 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer8.startReusableNode();
                        if ($composer8.getInserting()) {
                            factory$iv$iv$iv5 = factory$iv$iv$iv15;
                            $composer8.useNode();
                        } else {
                            factory$iv$iv$iv5 = factory$iv$iv$iv15;
                            $composer8.createNode(factory$iv$iv$iv5);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer8);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv9, ComposeUiNode.Companion.getSetModifier());
                        int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1410423833, "C:SkuSheetComponent.kt#o90vz8");
                        if (((CharSequence) currentImageUrl4.getValue()).length() <= 0) {
                            $composer4 = $composer8;
                            str = "CC(remember):SkuSheetComponent.kt#9igjgp";
                            currentImageUrl = currentImageUrl4;
                            $composer8.startReplaceGroup(-1417998622);
                        } else {
                            $composer8.startReplaceGroup(-1410385394);
                            ComposerKt.sourceInformation($composer8, "197@7966L143,192@7684L452");
                            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl((String) currentImageUrl4.getValue());
                            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                            Unit unit = Unit.INSTANCE;
                            ImmutableImageRequest build = imageRequest.build();
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            str = "CC(remember):SkuSheetComponent.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart($composer8, -1015318129, str);
                            $composer4 = $composer8;
                            currentImageUrl = currentImageUrl4;
                            boolean invalid$iv4 = $composer4.changedInstance(pageViewModel) | $composer4.changed(currentImageUrl);
                            Object it$iv8 = $composer8.rememberedValue();
                            if (!invalid$iv4 && it$iv8 != Composer.Companion.getEmpty()) {
                                value$iv2 = it$iv8;
                                ComposerKt.sourceInformationMarkerEnd($composer8);
                                BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer8, 0, 508);
                            }
                            Object obj2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda16
                                public final Object invoke() {
                                    Unit SkuSheetComponent$lambda$16$0$1$0$0$0;
                                    SkuSheetComponent$lambda$16$0$1$0$0$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$16$0$1$0$0$0(PageViewModel.this, currentImageUrl);
                                    return SkuSheetComponent$lambda$16$0$1$0$0$0;
                                }
                            };
                            $composer8.updateRememberedValue(obj2);
                            value$iv2 = obj2;
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer8, 0, 508);
                        }
                        $composer8.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer8.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        Modifier modifier$iv6 = RowScope.-CC.weight$default($this$SkuSheetComponent_u24lambda_u2416_u240_u241, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer8, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv2, $composer8, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv6 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                        CompositionLocalMap localMap$iv$iv6 = $composer8.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer8, modifier$iv6);
                        Function0 factory$iv$iv$iv16 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer8.startReusableNode();
                        if ($composer8.getInserting()) {
                            factory$iv$iv$iv6 = factory$iv$iv$iv16;
                            $composer8.useNode();
                        } else {
                            factory$iv$iv$iv6 = factory$iv$iv$iv16;
                            $composer8.createNode(factory$iv$iv$iv6);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer8);
                        $composer2 = $composer4;
                        MutableState currentImageUrl5 = currentImageUrl;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv10, ComposeUiNode.Companion.getSetModifier());
                        int i14 = ($changed$iv$iv$iv6 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer8, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        int i15 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer8, 1047095436, "C213@8533L6,214@8594L9,211@8428L203,219@8771L268,225@9110L6,226@9166L9,217@8653L614:SkuSheetComponent.kt#o90vz8");
                        TextKt.Text-Nvy7gAk("¥" + currentPrice2.getValue(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT16b(), $composer8, 0, 0, 131066);
                        Set entrySet = selectedSpecIndices2.entrySet();
                        ComposerKt.sourceInformationMarkerStart($composer8, -1074590980, str);
                        invalid$iv = $composer8.changedInstance(specInfoList3);
                        Object it$iv9 = $composer8.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv10 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda17
                            public final Object invoke(Object obj3) {
                                CharSequence SkuSheetComponent$lambda$16$0$1$1$0$0;
                                SkuSheetComponent$lambda$16$0$1$1$0$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$16$0$1$1$0$0(specInfoList3, (Map.Entry) obj3);
                                return SkuSheetComponent$lambda$16$0$1$1$0$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv10);
                        it$iv9 = value$iv10;
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        TextKt.Text-Nvy7gAk("已选：" + CollectionsKt.joinToString$default(entrySet, r127, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) it$iv9, 30, (Object) null), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT12(), $composer8, 48, 0, 131064);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer8.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer8.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer5 = $composer8;
                        Modifier modifier$iv7 = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer5, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv7 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv3, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv7 = (0 << 3) & 112;
                        Modifier modifier$iv$iv4 = modifier$iv7;
                        MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv7;
                        ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                        CompositionLocalMap localMap$iv$iv7 = $composer5.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer5, modifier$iv$iv4);
                        Function0 factory$iv$iv$iv17 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer5.startReusableNode();
                        if ($composer5.getInserting()) {
                            factory$iv$iv$iv7 = factory$iv$iv$iv17;
                            $composer5.useNode();
                        } else {
                            factory$iv$iv$iv7 = factory$iv$iv$iv17;
                            $composer5.createNode(factory$iv$iv$iv7);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer5);
                        Composer $composer$iv$iv2 = $composer5;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv11, ComposeUiNode.Companion.getSetModifier());
                        int i16 = ($changed$iv$iv$iv7 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                        char c2 = 6;
                        int i17 = ((0 >> 6) & 112) | 6;
                        Composer $composer9 = $composer5;
                        ComposerKt.sourceInformationMarkerStart($composer9, -1710246667, "C259@10422L610:SkuSheetComponent.kt#o90vz8");
                        $composer9.startReplaceGroup(1468851157);
                        ComposerKt.sourceInformation($composer9, "*244@9861L209,250@10112L161,240@9615L747");
                        List $this$forEachIndexed$iv = specInfoList3;
                        boolean z = false;
                        int index$iv = 0;
                        for (Object item$iv : $this$forEachIndexed$iv) {
                            int index$iv2 = index$iv + 1;
                            if (index$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoListItem = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) item$iv;
                            final int specIndex = index$iv;
                            Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                            boolean z2 = z;
                            final SnapshotStateMap selectedSpecIndices3 = selectedSpecIndices2;
                            Integer num = (Integer) selectedSpecIndices3.get(Integer.valueOf(specIndex));
                            int intValue = num != null ? num.intValue() : -1;
                            ComposerKt.sourceInformationMarkerStart($composer9, -1147566424, str);
                            CompositionLocalMap localMap$iv$iv8 = localMap$iv$iv7;
                            final List itemsSkuList3 = itemsSkuList;
                            Modifier materialized$iv$iv12 = materialized$iv$iv11;
                            boolean invalid$iv5 = $composer9.changed(selectedSpecIndices3) | $composer9.changedInstance(itemsSkuList3) | $composer9.changedInstance(specInfoList3) | $composer9.changed(specIndex);
                            Composer $this$cache$iv = $composer9;
                            int $changed$iv$iv$iv8 = $changed$iv$iv$iv7;
                            Object it$iv10 = $this$cache$iv.rememberedValue();
                            if (!invalid$iv5 && it$iv10 != Composer.Companion.getEmpty()) {
                                value$iv = it$iv10;
                                Function1 function12 = (Function1) value$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer9);
                                ComposerKt.sourceInformationMarkerStart($composer9, -1147558440, str);
                                final MutableState currentSelectedSku3 = currentSelectedSku2;
                                String str2 = str;
                                currentImageUrl2 = currentImageUrl5;
                                final MutableState currentImageUrl6 = currentPrice2;
                                invalid$iv2 = $composer9.changed(selectedSpecIndices3) | $composer9.changed(specIndex) | $composer9.changedInstance(specInfoList3) | $composer9.changedInstance(itemsSkuList3) | $composer9.changed(currentSelectedSku3) | $composer9.changed(currentImageUrl2) | $composer9.changed(currentImageUrl6);
                                Composer $this$cache$iv2 = $composer9;
                                Composer $composer10 = $composer5;
                                it$iv = $this$cache$iv2.rememberedValue();
                                if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                                    $composer7 = $composer9;
                                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                    modifier$iv$iv = modifier$iv$iv4;
                                    c = c2;
                                    modifier$iv$iv2 = modifier$iv$iv3;
                                    $composer$iv$iv = $composer$iv$iv2;
                                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                    function1 = it$iv;
                                    $composer$iv = $composer$iv3;
                                    $this$SkuSheetComponent_u24lambda_u2416 = $this$SkuSheetComponent_u24lambda_u24163;
                                    materialized$iv$iv2 = materialized$iv$iv4;
                                    $composer$iv2 = $composer$iv4;
                                    materialized$iv$iv = materialized$iv$iv6;
                                    currentImageUrl3 = currentImageUrl2;
                                    factory$iv$iv$iv9 = factory$iv$iv$iv11;
                                    verticalArrangement$iv = verticalArrangement$iv3;
                                    contentAlignment$iv = contentAlignment$iv3;
                                    ComposerKt.sourceInformationMarkerEnd($composer7);
                                    SpecGroupComponentEnhanced(specInfoListItem, specIndex, intValue, function12, function1, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), $composer7, 196608, 0);
                                    currentPrice2 = currentImageUrl6;
                                    materialized$iv$iv11 = materialized$iv$iv12;
                                    contentAlignment$iv3 = contentAlignment$iv;
                                    str = str2;
                                    factory$iv$iv$iv11 = factory$iv$iv$iv9;
                                    $composer$iv3 = $composer$iv;
                                    verticalArrangement$iv3 = verticalArrangement$iv;
                                    materialized$iv$iv6 = materialized$iv$iv;
                                    index$iv = index$iv2;
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    $composer$iv$iv2 = $composer$iv$iv;
                                    $composer9 = $composer7;
                                    c2 = c;
                                    measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                    modifier$iv$iv3 = modifier$iv$iv2;
                                    modifier$iv$iv4 = modifier$iv$iv;
                                    $this$SkuSheetComponent_u24lambda_u24163 = $this$SkuSheetComponent_u24lambda_u2416;
                                    itemsSkuList = itemsSkuList3;
                                    currentSelectedSku2 = currentSelectedSku3;
                                    localMap$iv$iv7 = localMap$iv$iv8;
                                    currentImageUrl5 = currentImageUrl3;
                                    $changed$iv$iv$iv7 = $changed$iv$iv$iv8;
                                    $composer5 = $composer10;
                                    selectedSpecIndices2 = selectedSpecIndices3;
                                    $composer$iv4 = $composer$iv2;
                                    materialized$iv$iv4 = materialized$iv$iv2;
                                    z = z2;
                                    $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                                }
                                $composer7 = $composer9;
                                c = c2;
                                $composer$iv$iv = $composer$iv$iv2;
                                materialized$iv$iv = materialized$iv$iv6;
                                verticalArrangement$iv = verticalArrangement$iv3;
                                $this$SkuSheetComponent_u24lambda_u2416 = $this$SkuSheetComponent_u24lambda_u24163;
                                factory$iv$iv$iv9 = factory$iv$iv$iv11;
                                contentAlignment$iv = contentAlignment$iv3;
                                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                modifier$iv$iv = modifier$iv$iv4;
                                modifier$iv$iv2 = modifier$iv$iv3;
                                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                $composer$iv = $composer$iv3;
                                materialized$iv$iv2 = materialized$iv$iv4;
                                $composer$iv2 = $composer$iv4;
                                currentImageUrl3 = currentImageUrl2;
                                function1 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda20
                                    public final Object invoke(Object obj3) {
                                        Unit SkuSheetComponent$lambda$16$0$2$0$1$0;
                                        SkuSheetComponent$lambda$16$0$2$0$1$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$16$0$2$0$1$0(selectedSpecIndices3, specIndex, specInfoList3, itemsSkuList3, currentSelectedSku3, currentImageUrl6, currentImageUrl3, ((Integer) obj3).intValue());
                                        return SkuSheetComponent$lambda$16$0$2$0$1$0;
                                    }
                                };
                                $this$cache$iv2.updateRememberedValue(function1);
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                SpecGroupComponentEnhanced(specInfoListItem, specIndex, intValue, function12, function1, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), $composer7, 196608, 0);
                                currentPrice2 = currentImageUrl6;
                                materialized$iv$iv11 = materialized$iv$iv12;
                                contentAlignment$iv3 = contentAlignment$iv;
                                str = str2;
                                factory$iv$iv$iv11 = factory$iv$iv$iv9;
                                $composer$iv3 = $composer$iv;
                                verticalArrangement$iv3 = verticalArrangement$iv;
                                materialized$iv$iv6 = materialized$iv$iv;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                $composer$iv$iv2 = $composer$iv$iv;
                                $composer9 = $composer7;
                                c2 = c;
                                measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                modifier$iv$iv3 = modifier$iv$iv2;
                                modifier$iv$iv4 = modifier$iv$iv;
                                $this$SkuSheetComponent_u24lambda_u24163 = $this$SkuSheetComponent_u24lambda_u2416;
                                itemsSkuList = itemsSkuList3;
                                currentSelectedSku2 = currentSelectedSku3;
                                localMap$iv$iv7 = localMap$iv$iv8;
                                currentImageUrl5 = currentImageUrl3;
                                $changed$iv$iv$iv7 = $changed$iv$iv$iv8;
                                $composer5 = $composer10;
                                selectedSpecIndices2 = selectedSpecIndices3;
                                $composer$iv4 = $composer$iv2;
                                materialized$iv$iv4 = materialized$iv$iv2;
                                z = z2;
                                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                            }
                            Object obj3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda18
                                public final Object invoke(Object obj4) {
                                    boolean SkuSheetComponent$lambda$16$0$2$0$0$0;
                                    SkuSheetComponent$lambda$16$0$2$0$0$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$16$0$2$0$0$0(specIndex, selectedSpecIndices3, itemsSkuList3, specInfoList3, ((Integer) obj4).intValue());
                                    return Boolean.valueOf(SkuSheetComponent$lambda$16$0$2$0$0$0);
                                }
                            };
                            $this$cache$iv.updateRememberedValue(obj3);
                            value$iv = obj3;
                            Function1 function122 = (Function1) value$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer9);
                            ComposerKt.sourceInformationMarkerStart($composer9, -1147558440, str);
                            final MutableState currentSelectedSku32 = currentSelectedSku2;
                            String str22 = str;
                            currentImageUrl2 = currentImageUrl5;
                            final MutableState currentImageUrl62 = currentPrice2;
                            invalid$iv2 = $composer9.changed(selectedSpecIndices3) | $composer9.changed(specIndex) | $composer9.changedInstance(specInfoList3) | $composer9.changedInstance(itemsSkuList3) | $composer9.changed(currentSelectedSku32) | $composer9.changed(currentImageUrl2) | $composer9.changed(currentImageUrl62);
                            Composer $this$cache$iv22 = $composer9;
                            Composer $composer102 = $composer5;
                            it$iv = $this$cache$iv22.rememberedValue();
                            if (!invalid$iv2) {
                                $composer7 = $composer9;
                                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                modifier$iv$iv = modifier$iv$iv4;
                                c = c2;
                                modifier$iv$iv2 = modifier$iv$iv3;
                                $composer$iv$iv = $composer$iv$iv2;
                                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                function1 = it$iv;
                                $composer$iv = $composer$iv3;
                                $this$SkuSheetComponent_u24lambda_u2416 = $this$SkuSheetComponent_u24lambda_u24163;
                                materialized$iv$iv2 = materialized$iv$iv4;
                                $composer$iv2 = $composer$iv4;
                                materialized$iv$iv = materialized$iv$iv6;
                                currentImageUrl3 = currentImageUrl2;
                                factory$iv$iv$iv9 = factory$iv$iv$iv11;
                                verticalArrangement$iv = verticalArrangement$iv3;
                                contentAlignment$iv = contentAlignment$iv3;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                SpecGroupComponentEnhanced(specInfoListItem, specIndex, intValue, function122, function1, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), $composer7, 196608, 0);
                                currentPrice2 = currentImageUrl62;
                                materialized$iv$iv11 = materialized$iv$iv12;
                                contentAlignment$iv3 = contentAlignment$iv;
                                str = str22;
                                factory$iv$iv$iv11 = factory$iv$iv$iv9;
                                $composer$iv3 = $composer$iv;
                                verticalArrangement$iv3 = verticalArrangement$iv;
                                materialized$iv$iv6 = materialized$iv$iv;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                $composer$iv$iv2 = $composer$iv$iv;
                                $composer9 = $composer7;
                                c2 = c;
                                measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                modifier$iv$iv3 = modifier$iv$iv2;
                                modifier$iv$iv4 = modifier$iv$iv;
                                $this$SkuSheetComponent_u24lambda_u24163 = $this$SkuSheetComponent_u24lambda_u2416;
                                itemsSkuList = itemsSkuList3;
                                currentSelectedSku2 = currentSelectedSku32;
                                localMap$iv$iv7 = localMap$iv$iv8;
                                currentImageUrl5 = currentImageUrl3;
                                $changed$iv$iv$iv7 = $changed$iv$iv$iv8;
                                $composer5 = $composer102;
                                selectedSpecIndices2 = selectedSpecIndices3;
                                $composer$iv4 = $composer$iv2;
                                materialized$iv$iv4 = materialized$iv$iv2;
                                z = z2;
                                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                            }
                            $composer7 = $composer9;
                            c = c2;
                            $composer$iv$iv = $composer$iv$iv2;
                            materialized$iv$iv = materialized$iv$iv6;
                            verticalArrangement$iv = verticalArrangement$iv3;
                            $this$SkuSheetComponent_u24lambda_u2416 = $this$SkuSheetComponent_u24lambda_u24163;
                            factory$iv$iv$iv9 = factory$iv$iv$iv11;
                            contentAlignment$iv = contentAlignment$iv3;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            modifier$iv$iv = modifier$iv$iv4;
                            modifier$iv$iv2 = modifier$iv$iv3;
                            $composer$iv$iv$iv = $composer$iv$iv$iv2;
                            $composer$iv = $composer$iv3;
                            materialized$iv$iv2 = materialized$iv$iv4;
                            $composer$iv2 = $composer$iv4;
                            currentImageUrl3 = currentImageUrl2;
                            function1 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda20
                                public final Object invoke(Object obj32) {
                                    Unit SkuSheetComponent$lambda$16$0$2$0$1$0;
                                    SkuSheetComponent$lambda$16$0$2$0$1$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$16$0$2$0$1$0(selectedSpecIndices3, specIndex, specInfoList3, itemsSkuList3, currentSelectedSku32, currentImageUrl62, currentImageUrl3, ((Integer) obj32).intValue());
                                    return SkuSheetComponent$lambda$16$0$2$0$1$0;
                                }
                            };
                            $this$cache$iv22.updateRememberedValue(function1);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            SpecGroupComponentEnhanced(specInfoListItem, specIndex, intValue, function122, function1, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), $composer7, 196608, 0);
                            currentPrice2 = currentImageUrl62;
                            materialized$iv$iv11 = materialized$iv$iv12;
                            contentAlignment$iv3 = contentAlignment$iv;
                            str = str22;
                            factory$iv$iv$iv11 = factory$iv$iv$iv9;
                            $composer$iv3 = $composer$iv;
                            verticalArrangement$iv3 = verticalArrangement$iv;
                            materialized$iv$iv6 = materialized$iv$iv;
                            index$iv = index$iv2;
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            $composer$iv$iv2 = $composer$iv$iv;
                            $composer9 = $composer7;
                            c2 = c;
                            measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                            modifier$iv$iv3 = modifier$iv$iv2;
                            modifier$iv$iv4 = modifier$iv$iv;
                            $this$SkuSheetComponent_u24lambda_u24163 = $this$SkuSheetComponent_u24lambda_u2416;
                            itemsSkuList = itemsSkuList3;
                            currentSelectedSku2 = currentSelectedSku32;
                            localMap$iv$iv7 = localMap$iv$iv8;
                            currentImageUrl5 = currentImageUrl3;
                            $changed$iv$iv$iv7 = $changed$iv$iv$iv8;
                            $composer5 = $composer102;
                            selectedSpecIndices2 = selectedSpecIndices3;
                            $composer$iv4 = $composer$iv2;
                            materialized$iv$iv4 = materialized$iv$iv2;
                            z = z2;
                            $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                        }
                        Composer $composer11 = $composer5;
                        $composer6 = $composer9;
                        MutableState currentSelectedSku4 = currentSelectedSku2;
                        BoxScope $this$SkuSheetComponent_u24lambda_u24164 = $this$SkuSheetComponent_u24lambda_u24163;
                        Composer $composer$iv$iv3 = $composer$iv$iv2;
                        Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                        Composer $composer$iv5 = $composer$iv3;
                        Composer $composer$iv6 = $composer$iv4;
                        $composer6.endReplaceGroup();
                        Modifier modifier$iv8 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(22), 0.0f, 0.0f, 13, (Object) null);
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
                        ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv8 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv8 = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv8 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                        CompositionLocalMap localMap$iv$iv9 = $composer6.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv13 = ComposedModifierKt.materializeModifier($composer6, modifier$iv8);
                        Function0 factory$iv$iv$iv18 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv9 = (($changed$iv$iv8 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer6.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer6.startReusableNode();
                        if ($composer6.getInserting()) {
                            factory$iv$iv$iv8 = factory$iv$iv$iv18;
                            $composer6.useNode();
                        } else {
                            factory$iv$iv$iv8 = factory$iv$iv$iv18;
                            $composer6.createNode(factory$iv$iv$iv8);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv8 = Updater.constructor-impl($composer6);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, measurePolicy$iv8, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, localMap$iv$iv9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv8, Integer.valueOf(compositeKeyHash$iv$iv8), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, materialized$iv$iv13, ComposeUiNode.Companion.getSetModifier());
                        int i18 = ($changed$iv$iv$iv9 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i19 = ((438 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer6, 1678366137, "C269@10851L6,270@10907L9,267@10764L180:SkuSheetComponent.kt#o90vz8");
                        TextKt.Text-Nvy7gAk("数量确认", (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT13b(), $composer6, 6, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        $composer6.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        $composer5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer11);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer$iv$iv$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                        SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) currentSelectedSku4.getValue();
                        BottomContainerState bottomContainerState = (BottomContainerState) SnapshotStateKt.collectAsState(pageViewModel.getBottomContainerState$product_details_page_debug(), (CoroutineContext) null, $composer8, 0, 1).getValue();
                        BottomActionComponent(itemsSkuListItem, bottomContainerState == null ? bottomContainerState.getData() : null, pageViewModel.getWrapper$product_details_page_debug(), $this$SkuSheetComponent_u24lambda_u24164.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), $composer8, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        $composer8.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        pageViewModel2 = pageViewModel;
                        i2 = $changed;
                        $dirty = i;
                        modifier2 = modifier5;
                    }
                    itemsSkuList = itemsSkuList2;
                    specInfoList = specInfoList2;
                    value$iv9 = new SkuSheetComponentKt$SkuSheetComponent$1$1(specInfoList2, selectedSpecIndices, itemsSkuList, currentSelectedSku, currentPrice, currentImageUrl4, null);
                    $composer8.updateRememberedValue(value$iv9);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    EffectsKt.LaunchedEffect(specInfoList, (Function2) value$iv9, $composer8, 0);
                    Modifier modifier$iv9 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv22 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv9 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                    int $changed$iv$iv9 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv9 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv10 = $composer8.getCurrentCompositionLocalMap();
                    Modifier modifier52 = modifier4;
                    Composer $composer$iv32 = $composer8;
                    Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer8, modifier$iv9);
                    Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                    Alignment contentAlignment$iv32 = contentAlignment$iv22;
                    int $changed$iv$iv$iv10 = (($changed$iv$iv9 << 6) & 896) | 6;
                    MutableState currentSelectedSku22 = currentSelectedSku;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                    }
                    Function0 factory$iv$iv$iv112 = factory$iv$iv$iv;
                    Composer $this$Layout_u24lambda_u240$iv$iv9 = Updater.constructor-impl($composer8);
                    final List specInfoList32 = specInfoList;
                    SnapshotStateMap selectedSpecIndices22 = selectedSpecIndices;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv9, measurePolicy$iv9, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv9, localMap$iv$iv10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv9, Integer.valueOf(compositeKeyHash$iv$iv9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv9, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                    int i42 = ($changed$iv$iv$iv10 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i52 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$SkuSheetComponent_u24lambda_u241622 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer8, -464368973, "C158@6444L4612,284@11273L16,280@11091L457:SkuSheetComponent.kt#o90vz8");
                    BoxScope $this$SkuSheetComponent_u24lambda_u241632 = $this$SkuSheetComponent_u24lambda_u241622;
                    Modifier materialized$iv$iv42 = materialized$iv$iv32;
                    Modifier modifier$iv22 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer8, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv4 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv4, $composer8, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv22 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer8.getCurrentCompositionLocalMap();
                    Composer $composer$iv42 = $composer8;
                    Arrangement.Vertical verticalArrangement$iv32 = verticalArrangement$iv22;
                    Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer8, modifier$iv22);
                    Function0 factory$iv$iv$iv122 = ComposeUiNode.Companion.getConstructor();
                    Modifier modifier$iv$iv32 = modifier$iv22;
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer8);
                    MutableState currentPrice22 = currentPrice;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                    int i62 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
                    int i72 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, 507623692, "C160@6521L395,173@6955L2344,237@9478L21,233@9334L1712:SkuSheetComponent.kt#o90vz8");
                    Modifier modifier$iv32 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment contentAlignment$iv42 = Alignment.Companion.getTopEnd();
                    Modifier materialized$iv$iv62 = materialized$iv$iv52;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv42, false);
                    int $changed$iv$iv32 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv32 = $composer8.getCurrentCompositionLocalMap();
                    Composer $composer$iv$iv$iv22 = $composer8;
                    Modifier materialized$iv$iv72 = ComposedModifierKt.materializeModifier($composer8, modifier$iv32);
                    Function0 factory$iv$iv$iv132 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer8);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv72, ComposeUiNode.Companion.getSetModifier());
                    int i82 = ($changed$iv$iv$iv32 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i92 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1159084048, "C165@6712L20,166@6771L6,164@6663L239:SkuSheetComponent.kt#o90vz8");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_line_500($composer8, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText3-0d7_KjU(), $composer8, Painter.$stable | 432, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    Modifier modifier$iv42 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer8, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv42 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer8, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv42 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv42 = $composer8.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv82 = ComposedModifierKt.materializeModifier($composer8, modifier$iv42);
                    Function0 factory$iv$iv$iv142 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer8);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv82, ComposeUiNode.Companion.getSetModifier());
                    int i102 = ($changed$iv$iv$iv42 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i112 = ((6 >> 6) & 112) | 6;
                    RowScope $this$SkuSheetComponent_u24lambda_u2416_u240_u2412 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer8, -982317073, "C187@7462L6,180@7159L1017,205@8223L1062:SkuSheetComponent.kt#o90vz8");
                    Modifier modifier$iv52 = BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(88)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getLine_light-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                    ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    int $changed$iv$iv52 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv52 = $composer8.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv92 = ComposedModifierKt.materializeModifier($composer8, modifier$iv52);
                    Function0 factory$iv$iv$iv152 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer8);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv92, ComposeUiNode.Companion.getSetModifier());
                    int i122 = ($changed$iv$iv$iv52 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                    int i132 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1410423833, "C:SkuSheetComponent.kt#o90vz8");
                    if (((CharSequence) currentImageUrl4.getValue()).length() <= 0) {
                    }
                    $composer8.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    Modifier modifier$iv62 = RowScope.-CC.weight$default($this$SkuSheetComponent_u24lambda_u2416_u240_u2412, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer8, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv42 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv62 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv42, horizontalAlignment$iv22, $composer8, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv62 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv62 = $composer8.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv102 = ComposedModifierKt.materializeModifier($composer8, modifier$iv62);
                    Function0 factory$iv$iv$iv162 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv62 = (($changed$iv$iv62 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer8);
                    $composer2 = $composer4;
                    MutableState currentImageUrl52 = currentImageUrl;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv102, ComposeUiNode.Companion.getSetModifier());
                    int i142 = ($changed$iv$iv$iv62 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                    int i152 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1047095436, "C213@8533L6,214@8594L9,211@8428L203,219@8771L268,225@9110L6,226@9166L9,217@8653L614:SkuSheetComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk("¥" + currentPrice22.getValue(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT16b(), $composer8, 0, 0, 131066);
                    Set entrySet2 = selectedSpecIndices22.entrySet();
                    ComposerKt.sourceInformationMarkerStart($composer8, -1074590980, str);
                    invalid$iv = $composer8.changedInstance(specInfoList32);
                    Object it$iv92 = $composer8.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv102 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj32) {
                            CharSequence SkuSheetComponent$lambda$16$0$1$1$0$0;
                            SkuSheetComponent$lambda$16$0$1$1$0$0 = SkuSheetComponentKt.SkuSheetComponent$lambda$16$0$1$1$0$0(specInfoList32, (Map.Entry) obj32);
                            return SkuSheetComponent$lambda$16$0$1$1$0$0;
                        }
                    };
                    $composer8.updateRememberedValue(value$iv102);
                    it$iv92 = value$iv102;
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    TextKt.Text-Nvy7gAk("已选：" + CollectionsKt.joinToString$default(entrySet2, r127, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) it$iv92, 30, (Object) null), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT12(), $composer8, 48, 0, 131064);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer5 = $composer8;
                    Modifier modifier$iv72 = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer5, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv52 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv32 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv72 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv52, horizontalAlignment$iv32, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv72 = (0 << 3) & 112;
                    Modifier modifier$iv$iv42 = modifier$iv72;
                    MeasurePolicy measurePolicy$iv$iv22 = measurePolicy$iv72;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv72 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                    CompositionLocalMap localMap$iv$iv72 = $composer5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv112 = ComposedModifierKt.materializeModifier($composer5, modifier$iv$iv42);
                    Function0 factory$iv$iv$iv172 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv72 = (($changed$iv$iv72 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer5.getApplier() instanceof Applier)) {
                    }
                    $composer5.startReusableNode();
                    if ($composer5.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv72 = Updater.constructor-impl($composer5);
                    Composer $composer$iv$iv22 = $composer5;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, measurePolicy$iv$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, localMap$iv$iv72, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv72, Integer.valueOf(compositeKeyHash$iv$iv72), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv72, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, materialized$iv$iv112, ComposeUiNode.Companion.getSetModifier());
                    int i162 = ($changed$iv$iv$iv72 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope32 = ColumnScopeInstance.INSTANCE;
                    char c22 = 6;
                    int i172 = ((0 >> 6) & 112) | 6;
                    Composer $composer92 = $composer5;
                    ComposerKt.sourceInformationMarkerStart($composer92, -1710246667, "C259@10422L610:SkuSheetComponent.kt#o90vz8");
                    $composer92.startReplaceGroup(1468851157);
                    ComposerKt.sourceInformation($composer92, "*244@9861L209,250@10112L161,240@9615L747");
                    List $this$forEachIndexed$iv3 = specInfoList32;
                    boolean z3 = false;
                    int index$iv3 = 0;
                    while (r108.hasNext()) {
                    }
                    Composer $composer112 = $composer5;
                    $composer6 = $composer92;
                    MutableState currentSelectedSku42 = currentSelectedSku22;
                    BoxScope $this$SkuSheetComponent_u24lambda_u241642 = $this$SkuSheetComponent_u24lambda_u241632;
                    Composer $composer$iv$iv32 = $composer$iv$iv22;
                    Composer $composer$iv$iv$iv32 = $composer$iv$iv$iv22;
                    Composer $composer$iv52 = $composer$iv32;
                    Composer $composer$iv62 = $composer$iv42;
                    $composer6.endReplaceGroup();
                    Modifier modifier$iv82 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(22), 0.0f, 0.0f, 13, (Object) null);
                    Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getSpaceBetween();
                    ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv82 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer6, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv82 = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv82 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv92 = $composer6.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv132 = ComposedModifierKt.materializeModifier($composer6, modifier$iv82);
                    Function0 factory$iv$iv$iv182 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv92 = (($changed$iv$iv82 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer6.getApplier() instanceof Applier)) {
                    }
                    $composer6.startReusableNode();
                    if ($composer6.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv82 = Updater.constructor-impl($composer6);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, measurePolicy$iv82, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, localMap$iv$iv92, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv82, Integer.valueOf(compositeKeyHash$iv$iv82), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv82, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, materialized$iv$iv132, ComposeUiNode.Companion.getSetModifier());
                    int i182 = ($changed$iv$iv$iv92 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                    int i192 = ((438 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1678366137, "C269@10851L6,270@10907L9,267@10764L180:SkuSheetComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk("数量确认", (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT13b(), $composer6, 6, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    $composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv32);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer112);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer$iv$iv$iv32.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv32);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv62);
                    SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem2 = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) currentSelectedSku42.getValue();
                    BottomContainerState bottomContainerState2 = (BottomContainerState) SnapshotStateKt.collectAsState(pageViewModel.getBottomContainerState$product_details_page_debug(), (CoroutineContext) null, $composer8, 0, 1).getValue();
                    BottomActionComponent(itemsSkuListItem2, bottomContainerState2 == null ? bottomContainerState2.getData() : null, pageViewModel.getWrapper$product_details_page_debug(), $this$SkuSheetComponent_u24lambda_u241642.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), $composer8, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv52);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    pageViewModel2 = pageViewModel;
                    i2 = $changed;
                    $dirty = i;
                    modifier2 = modifier52;
                }
            } else {
                $composer3 = $composer8;
                modifier3 = modifier4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup4 = $composer3.endRestartGroup();
            if (endRestartGroup4 != null) {
                final Modifier modifier6 = modifier3;
                endRestartGroup4.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj4, Object obj5) {
                        Unit SkuSheetComponent$lambda$1;
                        SkuSheetComponent$lambda$1 = SkuSheetComponentKt.SkuSheetComponent$lambda$1(PageViewModel.this, modifier6, $changed, i, (Composer) obj4, ((Integer) obj5).intValue());
                        return SkuSheetComponent$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer8;
        i2 = $changed;
        $dirty = i;
        pageViewModel2 = pageViewModel;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup5 = $composer2.endRestartGroup();
        if (endRestartGroup5 != null) {
            endRestartGroup5.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj4, Object obj5) {
                    Unit SkuSheetComponent$lambda$17;
                    SkuSheetComponent$lambda$17 = SkuSheetComponentKt.SkuSheetComponent$lambda$17(PageViewModel.this, modifier2, i2, $dirty, (Composer) obj4, ((Integer) obj5).intValue());
                    return SkuSheetComponent$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List SkuSheetComponent$lambda$5$0(SaverScope $this$listSaver, SnapshotStateMap map) {
        Intrinsics.checkNotNullParameter($this$listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(map, "map");
        Iterable $this$map$iv = map.entrySet();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Map.Entry it = (Map.Entry) item$iv$iv;
            destination$iv$iv.add(new Pair(it.getKey(), it.getValue()));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapshotStateMap SkuSheetComponent$lambda$6$0(List pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        SnapshotStateMap $this$SkuSheetComponent_u24lambda_u246_u240_u240 = SnapshotStateKt.mutableStateMapOf();
        List $this$forEach$iv = pairs;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair) element$iv;
            int key = ((Number) pair.component1()).intValue();
            int value = ((Number) pair.component2()).intValue();
            $this$SkuSheetComponent_u24lambda_u246_u240_u240.put(Integer.valueOf(key), Integer.valueOf(value));
        }
        return $this$SkuSheetComponent_u24lambda_u246_u240_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapshotStateMap SkuSheetComponent$lambda$7$0() {
        return SnapshotStateKt.mutableStateMapOf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SkuSheetComponent$lambda$8$0() {
        return SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SkuSheetComponent$lambda$9$0() {
        return SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SkuSheetComponent$lambda$10$0() {
        return SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SkuSheetComponent$updateSelectedSku(SnapshotStateMap<Integer, Integer> snapshotStateMap, List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem> list, List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> list2, MutableState<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3) {
        List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList;
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem;
        String it;
        Object obj;
        Iterator it2;
        boolean z;
        boolean z2;
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem2;
        if (snapshotStateMap.size() != list.size()) {
            Integer num = (Integer) snapshotStateMap.get(0);
            int selectedValueIndex = num != null ? num.intValue() : 0;
            SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfoListItem = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) CollectionsKt.getOrNull(list, 0);
            if (specInfoListItem != null && (specValueVOList = specInfoListItem.getSpecValueVOList()) != null && (specValueListItem = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) CollectionsKt.getOrNull(specValueVOList, selectedValueIndex)) != null && (it = specValueListItem.getSpecValueImg()) != null) {
                mutableState3.setValue(it);
            }
            mutableState.setValue((Object) null);
            mutableState2.setValue("--");
            return;
        }
        Iterator it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj = null;
                break;
            }
            Object next = it3.next();
            SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem sku = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) next;
            Iterable $this$all$iv = CollectionsKt.withIndex(list);
            if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                Iterator it4 = $this$all$iv.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        Object element$iv = it4.next();
                        IndexedValue indexedValue = (IndexedValue) element$iv;
                        int specIndex = indexedValue.component1();
                        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfo = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) indexedValue.component2();
                        Integer num2 = (Integer) snapshotStateMap.get(Integer.valueOf(specIndex));
                        if (num2 == null) {
                            it2 = it3;
                            z2 = false;
                        } else {
                            int selectedValueIndex2 = num2.intValue();
                            List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList2 = specInfo.getSpecValueVOList();
                            if (specValueVOList2 == null || (specValueListItem2 = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) CollectionsKt.getOrNull(specValueVOList2, selectedValueIndex2)) == null) {
                                it2 = it3;
                            } else {
                                String selectedSpecValue = specValueListItem2.getSpecValueName();
                                if (selectedSpecValue == null) {
                                    it2 = it3;
                                } else {
                                    it2 = it3;
                                    List<String> specValues = sku.getSpecValues();
                                    z2 = Intrinsics.areEqual(specValues != null ? specValues.get(specIndex) : null, selectedSpecValue);
                                }
                            }
                            z2 = false;
                        }
                        if (!z2) {
                            z = false;
                            break;
                        }
                        it3 = it2;
                    } else {
                        it2 = it3;
                        z = true;
                        break;
                    }
                }
            } else {
                it2 = it3;
                z = true;
            }
            if (z) {
                obj = next;
                break;
            }
            it3 = it2;
        }
        SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem matchedSku = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) obj;
        mutableState.setValue(matchedSku);
        if (matchedSku != null) {
            String it5 = matchedSku.getImg();
            if (it5 != null) {
                mutableState3.setValue(it5);
            }
            String it6 = matchedSku.getPrice();
            if (it6 == null) {
                it6 = "0";
            }
            mutableState2.setValue(it6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[LOOP:1: B:14:0x0056->B:35:0x00bb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd A[LOOP:0: B:8:0x0031->B:48:0x00dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean SkuSheetComponent$isSpecValueSelectable(SnapshotStateMap<Integer, Integer> snapshotStateMap, List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> list, List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem> list2, int specIndex, int valueIndex) {
        Map tempSelectedIndices;
        boolean z;
        boolean z2;
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem;
        boolean matches;
        Map tempSelectedIndices2 = MapsKt.toMutableMap((Map) snapshotStateMap);
        tempSelectedIndices2.put(Integer.valueOf(specIndex), Integer.valueOf(valueIndex));
        List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> $this$any$iv = list;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem sku : $this$any$iv) {
            Map $this$all$iv = tempSelectedIndices2;
            if (!$this$all$iv.isEmpty()) {
                Iterator it = $this$all$iv.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        tempSelectedIndices = tempSelectedIndices2;
                        z = true;
                        break;
                    }
                    Map.Entry element$iv = (Map.Entry) it.next();
                    int tSpecIndex = ((Number) element$iv.getKey()).intValue();
                    int tValueIndex = ((Number) element$iv.getValue()).intValue();
                    List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList = list2.get(tSpecIndex).getSpecValueVOList();
                    String selectedSpecValue = (specValueVOList == null || (specValueListItem = specValueVOList.get(tValueIndex)) == null) ? null : specValueListItem.getSpecValueName();
                    if (selectedSpecValue != null) {
                        tempSelectedIndices = tempSelectedIndices2;
                        List<String> specValues = sku.getSpecValues();
                        if (!Intrinsics.areEqual(specValues != null ? (String) CollectionsKt.getOrNull(specValues, tSpecIndex) : null, selectedSpecValue)) {
                            z2 = false;
                            if (z2) {
                                z = false;
                                break;
                            }
                            tempSelectedIndices2 = tempSelectedIndices;
                        }
                    } else {
                        tempSelectedIndices = tempSelectedIndices2;
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
            } else {
                tempSelectedIndices = tempSelectedIndices2;
                z = true;
            }
            boolean matches2 = z;
            if (matches2) {
                Integer stock = sku.getStock();
                if ((stock != null ? stock.intValue() : 0) > 0) {
                    matches = true;
                    if (!matches) {
                        return true;
                    }
                    tempSelectedIndices2 = tempSelectedIndices;
                }
            }
            matches = false;
            if (!matches) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$16$0$1$0$0$0(PageViewModel $pageViewModel, MutableState $currentImageUrl) {
        PageViewModel.updateImagePreview$product_details_page_debug$default($pageViewModel, CollectionsKt.listOf($currentImageUrl.getValue()), 0, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence SkuSheetComponent$lambda$16$0$1$1$0$0(List $specInfoList, Map.Entry entry) {
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem;
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        int specIndex = ((Number) entry.getKey()).intValue();
        int valueIndex = ((Number) entry.getValue()).intValue();
        List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList = ((SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) $specInfoList.get(specIndex)).getSpecValueVOList();
        String specValue = (specValueVOList == null || (specValueListItem = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) CollectionsKt.getOrNull(specValueVOList, valueIndex)) == null || (specValue = specValueListItem.getSpecValueName()) == null) ? "" : "";
        return specValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SkuSheetComponent$lambda$16$0$2$0$0$0(int $specIndex, SnapshotStateMap $selectedSpecIndices, List $itemsSkuList, List $specInfoList, int valueIndex) {
        return SkuSheetComponent$isSpecValueSelectable($selectedSpecIndices, $itemsSkuList, $specInfoList, $specIndex, valueIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSheetComponent$lambda$16$0$2$0$1$0(SnapshotStateMap $selectedSpecIndices, int $specIndex, List $specInfoList, List $itemsSkuList, MutableState $currentSelectedSku, MutableState $currentPrice, MutableState $currentImageUrl, int valueIndex) {
        ((Map) $selectedSpecIndices).put(Integer.valueOf($specIndex), Integer.valueOf(valueIndex));
        SkuSheetComponent$updateSelectedSku($selectedSpecIndices, $specInfoList, $itemsSkuList, $currentSelectedSku, $currentPrice, $currentImageUrl);
        return Unit.INSTANCE;
    }

    public static final void SpecGroupComponentEnhanced(final SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem data, final int specIndex, final int selectedIndex, final Function1<? super Integer, Boolean> function1, final Function1<? super Integer, Unit> function12, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function1, "isValueSelectable");
        Intrinsics.checkNotNullParameter(function12, "onValueSelect");
        Composer $composer2 = $composer.startRestartGroup(1585553147);
        ComposerKt.sourceInformation($composer2, "C(SpecGroupComponentEnhanced)N(data,specIndex,selectedIndex,isValueSelectable,onValueSelect,modifier)306@11838L2799:SkuSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 4 : 2;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(selectedIndex) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((74883 & $dirty2) != 74882, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1585553147, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.SpecGroupComponentEnhanced (SkuSheetComponent.kt:305)");
            }
            int $changed$iv = ($dirty2 >> 15) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1502554245, "C309@11952L6,310@11996L9,307@11876L145,320@12302L2329,313@12031L2600:SkuSheetComponent.kt#o90vz8");
            String specName = data.getSpecName();
            if (specName == null) {
                specName = "";
            }
            TextKt.Text-Nvy7gAk(specName, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13b(), $composer2, 0, 0, 131066);
            FlowLayoutKt.FlowRow(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1319924416, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SpecGroupComponentEnhanced$lambda$0$0;
                    SpecGroupComponentEnhanced$lambda$0$0 = SkuSheetComponentKt.SpecGroupComponentEnhanced$lambda$0$0(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.this, selectedIndex, function1, function12, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SpecGroupComponentEnhanced$lambda$0$0;
                }
            }, $composer2, 54), $composer2, 1573302, 56);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit SpecGroupComponentEnhanced$lambda$1;
                    SpecGroupComponentEnhanced$lambda$1 = SkuSheetComponentKt.SpecGroupComponentEnhanced$lambda$1(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.this, specIndex, selectedIndex, function1, function12, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SpecGroupComponentEnhanced$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SpecGroupComponentEnhanced$lambda$0$0(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem $data, int $selectedIndex, Function1 $isValueSelectable, Function1 $onValueSelect, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        boolean z;
        Iterator it;
        Modifier modifier;
        Function0 factory$iv$iv$iv;
        long j;
        final Function1 function1 = $onValueSelect;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C:SkuSheetComponent.kt#o90vz8");
        if (composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1319924416, $changed, -1, "kntr.app.mall.product.details.page.ui.components.SpecGroupComponentEnhanced.<anonymous>.<anonymous> (SkuSheetComponent.kt:321)");
            }
            Iterable specValueVOList = $data.getSpecValueVOList();
            if (specValueVOList == null) {
                composer.startReplaceGroup(1442788662);
                $composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1442788663);
                ComposerKt.sourceInformation(composer, "*351@13916L84,325@12500L2107");
                Iterable $this$forEachIndexed$iv = specValueVOList;
                boolean z2 = false;
                final int index$iv = 0;
                Iterator it2 = $this$forEachIndexed$iv.iterator();
                while (it2.hasNext()) {
                    Object item$iv = it2.next();
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem item = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) item$iv;
                    boolean isSelected = $selectedIndex == index$iv;
                    boolean canSelect = ((Boolean) $isValueSelectable.invoke(Integer.valueOf(index$iv))).booleanValue();
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    Modifier clip = ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                    if (isSelected) {
                        composer.startReplaceGroup(636995673);
                        ComposerKt.sourceInformation(composer, "335@12977L6,340@13312L6");
                        z = z2;
                        it = it2;
                        modifier = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU$default(Modifier.Companion, TopContainerKt.m587withOverlayAlphaDxMtmZc(BiliTheme.INSTANCE.getColors(composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.1f), (Shape) null, 2, (Object) null), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors(composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                        $composer.endReplaceGroup();
                    } else {
                        z = z2;
                        it = it2;
                        if (!canSelect) {
                            composer.startReplaceGroup(637012266);
                            $composer.endReplaceGroup();
                            modifier = AlphaKt.alpha(BackgroundKt.background-bw27NRU$default(Modifier.Companion, TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getGray-0d7_KjU(), 0.1f), (Shape) null, 2, (Object) null), 0.4f);
                        } else {
                            composer.startReplaceGroup(637014417);
                            ComposerKt.sourceInformation(composer, "349@13798L6");
                            modifier = BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors(composer, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU(), (Shape) null, 2, (Object) null);
                            $composer.endReplaceGroup();
                        }
                    }
                    Modifier then = clip.then(modifier);
                    ComposerKt.sourceInformationMarkerStart(composer, 637019155, "CC(remember):SkuSheetComponent.kt#9igjgp");
                    boolean invalid$iv = composer.changed(function1) | composer.changed(index$iv);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda10
                            public final Object invoke() {
                                Unit SpecGroupComponentEnhanced$lambda$0$0$0$0$0;
                                SpecGroupComponentEnhanced$lambda$0$0$0$0$0 = SkuSheetComponentKt.SpecGroupComponentEnhanced$lambda$0$0$0$0$0(function1, index$iv);
                                return SpecGroupComponentEnhanced$lambda$0$0$0$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(then, canSelect, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (48 << 3) & 112;
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
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i2 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1776630241, "C364@14553L9,356@14144L445:SkuSheetComponent.kt#o90vz8");
                    String specValueName = item.getSpecValueName();
                    if (specValueName == null) {
                        specValueName = "";
                    }
                    String str = specValueName;
                    if (isSelected) {
                        $composer.startReplaceGroup(1304242383);
                        ComposerKt.sourceInformation($composer, "360@14330L6");
                        j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                        $composer.endReplaceGroup();
                    } else if (canSelect) {
                        $composer.startReplaceGroup(1304246762);
                        ComposerKt.sourceInformation($composer, "362@14467L6");
                        j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(1304244746);
                        ComposerKt.sourceInformation($composer, "361@14404L6");
                        j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU();
                        $composer.endReplaceGroup();
                    }
                    TextKt.Text-Nvy7gAk(str, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    function1 = $onValueSelect;
                    composer = $composer;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z2 = z;
                    it2 = it;
                    index$iv = index$iv2;
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SpecGroupComponentEnhanced$lambda$0$0$0$0$0(Function1 $onValueSelect, int $index) {
        $onValueSelect.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    public static final void BottomActionComponent(final SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem selectedSku, final ContentModule.FooterModule bottomContainerState, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(154364705);
        ComposerKt.sourceInformation($composer3, "C(BottomActionComponent)N(selectedSku,bottomContainerState,pageViewModelWrapper,modifier)391@15364L11,393@15404L11,385@15151L324:SkuSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(selectedSku) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(bottomContainerState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 256 : 128;
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
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(154364705, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.BottomActionComponent (SkuSheetComponent.kt:378)");
            }
            if (bottomContainerState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BottomActionComponent$lambda$0;
                            BottomActionComponent$lambda$0 = SkuSheetComponentKt.BottomActionComponent$lambda$0(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem.this, bottomContainerState, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BottomActionComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            FooterFloor footerFloor = bottomContainerState.getData();
            FooterFloor.PurchaseButton purchaseButton = footerFloor.getPurchaseButton();
            if (purchaseButton == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier6 = modifier4;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda11
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BottomActionComponent$lambda$1;
                            BottomActionComponent$lambda$1 = SkuSheetComponentKt.BottomActionComponent$lambda$1(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem.this, bottomContainerState, pageViewModelWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BottomActionComponent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(modifier4, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            FooterFloor.AddCartButton addCartButton = footerFloor.getAddCartButton();
            ComposerKt.sourceInformationMarkerStart($composer3, -1979351380, "CC(remember):SkuSheetComponent.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1979350100, "CC(remember):SkuSheetComponent.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier8 = modifier4;
            $composer2 = $composer3;
            BottomContainerKt.PurchaseButtonComponent(pageViewModelWrapper, modifier7, purchaseButton, addCartButton, function0, (Function0) it$iv2, false, null, false, $composer2, (($dirty2 >> 6) & 14) | 221184, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier8;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier9 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSheetComponentKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomActionComponent$lambda$4;
                    BottomActionComponent$lambda$4 = SkuSheetComponentKt.BottomActionComponent$lambda$4(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem.this, bottomContainerState, pageViewModelWrapper, modifier9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomActionComponent$lambda$4;
                }
            });
        }
    }

    private static final boolean BottomActionComponent$checkSkuAvailability(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem $selectedSku) {
        if ($selectedSku != null) {
            Integer stock = $selectedSku.getStock();
            return (stock != null ? stock.intValue() : 0) > 0;
        }
        return false;
    }
}