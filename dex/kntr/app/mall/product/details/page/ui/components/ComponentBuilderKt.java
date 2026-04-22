package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.ModuleViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComponentBuilder.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001aC\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0016\u001aC\u0010\u0017\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {"CustomModuleSection", "", "name", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageVmWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GroupedModuleSection", "modules", "", "getViewModel", "Lkotlin/Function1;", "Lkntr/app/mall/product/details/page/vm/FloorType;", "Lkntr/app/mall/product/details/page/vm/ModuleViewModel;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FirstGroupedModuleSection", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SecondGroupedModuleSection", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComponentBuilderKt {

    /* compiled from: ComponentBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FloorType.values().length];
            try {
                iArr[FloorType.DETAIL_DESC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FloorType.SERVICE_DESC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FloorType.SHOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FloorType.SHOP_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[FloorType.COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[FloorType.ACTIVITY_INFO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[FloorType.FILE_INFO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[FloorType.COURSE_INFO.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[FloorType.REC.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[FloorType.SERIES.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[FloorType.CROWDFUNDING_PROGRESS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[FloorType.CROWDFUNDING_STAIRS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomModuleSection$lambda$0(String str, ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CustomModuleSection(str, contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstGroupedModuleSection$lambda$2(List list, Function1 function1, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FirstGroupedModuleSection(list, function1, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GroupedModuleSection$lambda$1(List list, Function1 function1, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GroupedModuleSection(list, function1, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondGroupedModuleSection$lambda$2(List list, Function1 function1, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SecondGroupedModuleSection(list, function1, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CustomModuleSection(final String name, final ContentModule module, final PageViewModelWrapper pageVmWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageVmWrapper, "pageVmWrapper");
        Composer $composer2 = $composer.startRestartGroup(-1573499993);
        ComposerKt.sourceInformation($composer2, "C(CustomModuleSection)N(name,module,pageVmWrapper,modifier):ComponentBuilder.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(module) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(pageVmWrapper) ? 256 : 128;
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
        if (!$composer2.shouldExecute(($dirty2 & 1169) != 1168, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1573499993, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CustomModuleSection (ComponentBuilder.kt:30)");
            }
            PageViewModel pageViewModel = pageVmWrapper.getViewModel();
            switch (WhenMappings.$EnumSwitchMapping$0[module.getFloorType().ordinal()]) {
                case 1:
                    $composer2.startReplaceGroup(-864961649);
                    ComposerKt.sourceInformation($composer2, "34@1382L52");
                    DetailDescComponentKt.DetailDescComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 2:
                    $composer2.startReplaceGroup(-864850514);
                    ComposerKt.sourceInformation($composer2, "38@1494L53");
                    ServiceDescComponentKt.ServiceDescComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 3:
                    $composer2.startReplaceGroup(-864746416);
                    ComposerKt.sourceInformation($composer2, "42@1599L51");
                    ShopFloorComponentKt.ShopFloorComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 4:
                    $composer2.startReplaceGroup(-864639156);
                    ComposerKt.sourceInformation($composer2, "46@1707L55");
                    ShopInfoFloorComponentKt.ShopInfoFloorComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 5:
                    $composer2.startReplaceGroup(-864530067);
                    ComposerKt.sourceInformation($composer2, "50@1817L54");
                    CommentFloorComponentKt.CommentFloorComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 6:
                    $composer2.startReplaceGroup(-864415832);
                    ComposerKt.sourceInformation($composer2, "54@1932L59");
                    ActivityInfoFloorComponentKt.ActivityInfoFloorComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                    $composer2.startReplaceGroup(-864300884);
                    ComposerKt.sourceInformation($composer2, "58@2048L55");
                    FileInfoFloorComponentKt.FileInfoFloorComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 8:
                    $composer2.startReplaceGroup(-864187734);
                    ComposerKt.sourceInformation($composer2, "62@2162L57");
                    CourseInfoFloorComponentKt.CourseInfoFloorComponent(module, pageViewModel, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case ConstantsKt.SPACER_9 /* 9 */:
                    $composer2.startReplaceGroup(-864080815);
                    ComposerKt.sourceInformation($composer2, "66@2270L50");
                    RecFloorComponentKt.RecFloorComponent(module, pageVmWrapper, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 10:
                    $composer2.startReplaceGroup(-863977554);
                    ComposerKt.sourceInformation($composer2, "70@2374L53");
                    SeriesFloorComponentKt.SeriesFloorComponent(module, pageVmWrapper, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case MediaAttrUtils.TYPE_MENU /* 11 */:
                    $composer2.startReplaceGroup(-863856096);
                    ComposerKt.sourceInformation($composer2, "74@2496L67");
                    CrowdfundingProgressFloorComponentKt.CrowdfundingProgressFloorComponent(module, pageVmWrapper, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 12:
                    $composer2.startReplaceGroup(-863723230);
                    ComposerKt.sourceInformation($composer2, "78@2630L65");
                    CrowdfundingStairsFloorComponentKt.CrowdfundingStairsFloorComponent(module, pageVmWrapper, modifier4, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                    $composer2.endReplaceGroup();
                    break;
                default:
                    $composer2.startReplaceGroup(-863618729);
                    $composer2.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomModuleSection$lambda$0;
                    CustomModuleSection$lambda$0 = ComponentBuilderKt.CustomModuleSection$lambda$0(name, module, pageVmWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomModuleSection$lambda$0;
                }
            });
        }
    }

    public static final void GroupedModuleSection(final List<? extends ContentModule> list, final Function1<? super FloorType, ? extends ModuleViewModel> function1, final PageViewModelWrapper pageVmWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(list, "modules");
        Intrinsics.checkNotNullParameter(function1, "getViewModel");
        Intrinsics.checkNotNullParameter(pageVmWrapper, "pageVmWrapper");
        Composer $composer2 = $composer.startRestartGroup(-1643884619);
        ComposerKt.sourceInformation($composer2, "C(GroupedModuleSection)N(modules,getViewModel,pageVmWrapper,modifier):ComponentBuilder.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(pageVmWrapper) ? 256 : 128;
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
        boolean z = true;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643884619, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.GroupedModuleSection (ComponentBuilder.kt:93)");
            }
            PageViewModel pageViewModel = pageVmWrapper.getViewModel();
            List<? extends ContentModule> $this$any$iv = list;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator<T> it = $this$any$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        ContentModule it2 = (ContentModule) element$iv;
                        if (it2 instanceof ContentModule.BasicInfoModule) {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            boolean isFirst = z;
            if (isFirst) {
                $composer2.startReplaceGroup(-1749246043);
                ComposerKt.sourceInformation($composer2, "97@3126L184");
                FirstGroupedModuleSection(list, function1, pageViewModel, modifier3, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1749041660);
                ComposerKt.sourceInformation($composer2, "104@3332L185");
                SecondGroupedModuleSection(list, function1, pageViewModel, modifier3, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GroupedModuleSection$lambda$1;
                    GroupedModuleSection$lambda$1 = ComponentBuilderKt.GroupedModuleSection$lambda$1(list, function1, pageVmWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GroupedModuleSection$lambda$1;
                }
            });
        }
    }

    public static final void FirstGroupedModuleSection(final List<? extends ContentModule> list, final Function1<? super FloorType, ? extends ModuleViewModel> function1, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(list, "modules");
        Intrinsics.checkNotNullParameter(function1, "getViewModel");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer2 = $composer.startRestartGroup(995468116);
        ComposerKt.sourceInformation($composer2, "C(FirstGroupedModuleSection)N(modules,getViewModel,pageViewModel,modifier)120@3790L16,131@4184L1036,122@3844L1376:ComponentBuilder.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
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
        if (!$composer2.shouldExecute(($dirty2 & 1155) != 1154, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(995468116, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.FirstGroupedModuleSection (ComponentBuilder.kt:119)");
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            final float scale = FirstGroupedModuleSection$lambda$0(scaleModel$delegate).getScale();
            PaddingCardKt.PaddingCard(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0)), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, 0.0f, ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(12, scale), 3, (Object) null), ComposableLambdaKt.rememberComposableLambda(-1756457127, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit FirstGroupedModuleSection$lambda$1;
                    FirstGroupedModuleSection$lambda$1 = ComponentBuilderKt.FirstGroupedModuleSection$lambda$1(list, scale, pageViewModel, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return FirstGroupedModuleSection$lambda$1;
                }
            }, $composer2, 54), $composer2, 24960, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit FirstGroupedModuleSection$lambda$2;
                    FirstGroupedModuleSection$lambda$2 = ComponentBuilderKt.FirstGroupedModuleSection$lambda$2(list, function1, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FirstGroupedModuleSection$lambda$2;
                }
            });
        }
    }

    private static final UiScaleModel FirstGroupedModuleSection$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstGroupedModuleSection$lambda$1(List $modules, float $scale, PageViewModel $pageViewModel, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C132@4194L1020:ComponentBuilder.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1756457127, $changed, -1, "kntr.app.mall.product.details.page.ui.components.FirstGroupedModuleSection.<anonymous> (ComponentBuilder.kt:132)");
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
            ComposerKt.sourceInformationMarkerStart($composer, -272070178, "C152@5150L54:ComponentBuilder.kt#o90vz8");
            $composer.startReplaceGroup(-1671344262);
            ComposerKt.sourceInformation($composer, "");
            List $this$forEachIndexed$iv = $modules;
            boolean z = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                ContentModule module = (ContentModule) item$iv;
                boolean z2 = z;
                if (!(module instanceof ContentModule.MergeAtmospherePriceModule)) {
                    if (!(module instanceof ContentModule.BasicInfoModule)) {
                        if (!(module instanceof ContentModule.CouponInfoModule)) {
                            if (module instanceof ContentModule.CrowdfundingAtmosModule) {
                                $composer.startReplaceGroup(2050393193);
                                ComposerKt.sourceInformation($composer, "148@5002L72");
                                CrowdfundingAtmosFloorComponentKt.CrowdfundingAtmosFloorComponent(module, $pageViewModel.getWrapper$product_details_page_debug(), Modifier.Companion, $composer, 384, 0);
                                $composer.endReplaceGroup();
                            } else {
                                $composer.startReplaceGroup(-862222433);
                                $composer.endReplaceGroup();
                            }
                        } else {
                            $composer.startReplaceGroup(2050388258);
                            ComposerKt.sourceInformation($composer, "146@4848L65");
                            CouponInfoFloorComponentKt.CouponInfoFloorComponent(module, $pageViewModel.getWrapper$product_details_page_debug(), Modifier.Companion, $composer, 384, 0);
                            $composer.endReplaceGroup();
                        }
                    } else {
                        $composer.startReplaceGroup(2050383585);
                        ComposerKt.sourceInformation($composer, "144@4702L64");
                        BasicInfoFloorComponentKt.BasicInfoFloorComponent(module, $pageViewModel.getWrapper$product_details_page_debug(), Modifier.Companion, $composer, 384, 0);
                        $composer.endReplaceGroup();
                    }
                } else {
                    $composer.startReplaceGroup(2050375163);
                    ComposerKt.sourceInformation($composer, "138@4435L186");
                    MergeAtmospherePriceFloorComponentKt.MergeAtmospherePriceFloorComponent(module, $pageViewModel.getWrapper$product_details_page_debug(), Modifier.Companion, $composer, 384, 0);
                    $composer.endReplaceGroup();
                }
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z2;
            }
            $composer.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scale)), $composer, 0);
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

    public static final void SecondGroupedModuleSection(final List<? extends ContentModule> list, final Function1<? super FloorType, ? extends ModuleViewModel> function1, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(list, "modules");
        Intrinsics.checkNotNullParameter(function1, "getViewModel");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer2 = $composer.startRestartGroup(-1855658124);
        ComposerKt.sourceInformation($composer2, "C(SecondGroupedModuleSection)N(modules,getViewModel,pageViewModel,modifier)164@5488L16,177@5923L1401,166@5542L1782:ComponentBuilder.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
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
        if (!$composer2.shouldExecute(($dirty2 & 1155) != 1154, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1855658124, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.SecondGroupedModuleSection (ComponentBuilder.kt:163)");
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            final float scale = SecondGroupedModuleSection$lambda$0(scaleModel$delegate).getScale();
            PaddingCardKt.PaddingCard(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(16, scale), ProvideUiScaleKt.dpScaled(12, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(-1265994737, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SecondGroupedModuleSection$lambda$1;
                    SecondGroupedModuleSection$lambda$1 = ComponentBuilderKt.SecondGroupedModuleSection$lambda$1(list, pageViewModel, scale, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SecondGroupedModuleSection$lambda$1;
                }
            }, $composer2, 54), $composer2, 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit SecondGroupedModuleSection$lambda$2;
                    SecondGroupedModuleSection$lambda$2 = ComponentBuilderKt.SecondGroupedModuleSection$lambda$2(list, function1, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SecondGroupedModuleSection$lambda$2;
                }
            });
        }
    }

    private static final UiScaleModel SecondGroupedModuleSection$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondGroupedModuleSection$lambda$1(List $modules, PageViewModel $pageViewModel, float $scale, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        boolean z;
        CompositionLocalMap localMap$iv$iv;
        int $changed$iv;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C178@5933L1385:ComponentBuilder.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1265994737, $changed, -1, "kntr.app.mall.product.details.page.ui.components.SecondGroupedModuleSection.<anonymous> (ComponentBuilder.kt:178)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            int $changed$iv2 = 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 807136568, "C:ComponentBuilder.kt#o90vz8");
            $composer.startReplaceGroup(-389605085);
            ComposerKt.sourceInformation($composer, "");
            List $this$forEachIndexed$iv = $modules;
            boolean z3 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                ContentModule it = (ContentModule) item$iv;
                int index = index$iv;
                boolean z4 = z3;
                if (!(it instanceof ContentModule.AdvStateModule)) {
                    if (!(it instanceof ContentModule.DeliveryInfoModule)) {
                        if (!(it instanceof ContentModule.ServiceModule)) {
                            if (!(it instanceof ContentModule.AttrModule)) {
                                if (!(it instanceof ContentModule.SkuInfoModule)) {
                                    if (it instanceof ContentModule.IpBrandModule) {
                                        $composer.startReplaceGroup(-980496425);
                                        ComposerKt.sourceInformation($composer, "186@6631L48");
                                        IpBrandFloorComponentKt.IpBrandFloorComponent(it, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 4);
                                        $composer.endReplaceGroup();
                                    } else {
                                        $composer.startReplaceGroup(-330543143);
                                        $composer.endReplaceGroup();
                                    }
                                } else {
                                    $composer.startReplaceGroup(-980499721);
                                    ComposerKt.sourceInformation($composer, "185@6528L48");
                                    SkuInfoFloorComponentKt.SkuInfoFloorComponent(it, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 4);
                                    $composer.endReplaceGroup();
                                }
                            } else {
                                $composer.startReplaceGroup(-980502924);
                                ComposerKt.sourceInformation($composer, "184@6428L45");
                                AttrFloorComponentKt.AttrFloorComponent(it, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 4);
                                $composer.endReplaceGroup();
                            }
                        } else {
                            $composer.startReplaceGroup(-980506121);
                            ComposerKt.sourceInformation($composer, "183@6328L48");
                            ServiceFloorComponentKt.ServiceFloorComponent(it, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 4);
                            $composer.endReplaceGroup();
                        }
                    } else {
                        $composer.startReplaceGroup(-980509572);
                        ComposerKt.sourceInformation($composer, "182@6220L53");
                        DeliveryInfoFloorComponentKt.DeliveryInfoFloorComponent(it, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 4);
                        $composer.endReplaceGroup();
                    }
                } else {
                    $composer.startReplaceGroup(-980513064);
                    ComposerKt.sourceInformation($composer, "181@6111L49");
                    AdvStateFloorComponentKt.AdvStateFloorComponent(it, $pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                }
                if (index != $modules.size() - 1) {
                    $composer.startReplaceGroup(-330458730);
                    ComposerKt.sourceInformation($composer, "192@6857L48,198@7166L6,193@6926L281,200@7228L48");
                    float marginHeight = ProvideUiScaleKt.dpScaled(10, $scale);
                    z = z2;
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, marginHeight), $composer, 0);
                    localMap$iv$iv = localMap$iv$iv2;
                    $changed$iv = $changed$iv2;
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(0.5d, $scale)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_light-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, marginHeight), $composer, 0);
                } else {
                    z = z2;
                    localMap$iv$iv = localMap$iv$iv2;
                    $changed$iv = $changed$iv2;
                    $composer.startReplaceGroup(-337198533);
                }
                $composer.endReplaceGroup();
                localMap$iv$iv2 = localMap$iv$iv;
                $changed$iv2 = $changed$iv;
                z2 = z;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z3 = z4;
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
}