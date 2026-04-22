package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
import kntr.app.mall.product.details.page.api.model.TextColorModel;
import kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt;
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
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.ResizeOption;
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
import kotlin.ranges.RangesKt;

/* compiled from: CrowdfundingStairsFloorComponent.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001aG\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0012\u001a'\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u001d\u001a'\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002"}, d2 = {"CrowdfundingStairsFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageVMWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TitleRowComponent", "achieveAmountPrefix", "", "achieveAmountStr", "targetAmountDesc", "percentage", "", "scale", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ProgressComponent", "progress", "(IFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LevelItemComponent", "item", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;", "onClick", "Lkotlin/Function0;", "(Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LevelInterComponent", "(FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LevelGiftItemComponent", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;", "(Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CrowdfundingStairsFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingStairsFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CrowdfundingStairsFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingStairsFloorComponent$lambda$3(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CrowdfundingStairsFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LevelGiftItemComponent$lambda$3(CrowdfundingStairsFloor.LevelItem.GiftItem giftItem, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LevelGiftItemComponent(giftItem, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LevelInterComponent$lambda$1(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LevelInterComponent(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LevelItemComponent$lambda$1(CrowdfundingStairsFloor.LevelItem levelItem, Function0 function0, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LevelItemComponent(levelItem, function0, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressComponent$lambda$4(int i, float f, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        ProgressComponent(i, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleRowComponent$lambda$1(String str, String str2, String str3, Integer num, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TitleRowComponent(str, str2, str3, num, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CrowdfundingStairsFloorComponent(final ContentModule module, final PageViewModelWrapper pageVMWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageVMWrapper, "pageVMWrapper");
        Composer $composer3 = $composer.startRestartGroup(-501651716);
        ComposerKt.sourceInformation($composer3, "C(CrowdfundingStairsFloorComponent)N(module,pageVMWrapper,modifier)72@3269L16,86@3705L3522,75@3324L3903:CrowdfundingStairsFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageVMWrapper) ? 32 : 16;
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
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-501651716, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponent (CrowdfundingStairsFloorComponent.kt:65)");
            }
            if (module instanceof ContentModule.CrowdfundingStairsModule) {
                final PageViewModel pageVM = pageVMWrapper.getViewModel();
                final CrowdfundingStairsFloor floorData = ((ContentModule.CrowdfundingStairsModule) module).getData();
                final List outShowLevelList = floorData.getOutShowLevelList();
                State scaleModel$delegate = SnapshotStateKt.collectAsState(pageVM.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                final float scale = CrowdfundingStairsFloorComponent$lambda$1(scaleModel$delegate).getScale();
                Modifier modifier5 = modifier4;
                $composer2 = $composer3;
                PaddingCardKt.PaddingCard(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(1075072279, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit CrowdfundingStairsFloorComponent$lambda$2;
                        CrowdfundingStairsFloorComponent$lambda$2 = CrowdfundingStairsFloorComponentKt.CrowdfundingStairsFloorComponent$lambda$2(CrowdfundingStairsFloor.this, scale, outShowLevelList, pageVM, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return CrowdfundingStairsFloorComponent$lambda$2;
                    }
                }, $composer3, 54), $composer3, 24576, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda11
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CrowdfundingStairsFloorComponent$lambda$0;
                            CrowdfundingStairsFloorComponent$lambda$0 = CrowdfundingStairsFloorComponentKt.CrowdfundingStairsFloorComponent$lambda$0(ContentModule.this, pageVMWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return CrowdfundingStairsFloorComponent$lambda$0;
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
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CrowdfundingStairsFloorComponent$lambda$3;
                    CrowdfundingStairsFloorComponent$lambda$3 = CrowdfundingStairsFloorComponentKt.CrowdfundingStairsFloorComponent$lambda$3(ContentModule.this, pageVMWrapper, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CrowdfundingStairsFloorComponent$lambda$3;
                }
            });
        }
    }

    private static final UiScaleModel CrowdfundingStairsFloorComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingStairsFloorComponent$lambda$2(final CrowdfundingStairsFloor $floorData, float $scale, List $outShowLevelList, final PageViewModel $pageVM, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String str;
        boolean z;
        int i;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C99@4207L3014:CrowdfundingStairsFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$PaddingCard) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1075072279, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponent.<anonymous> (CrowdfundingStairsFloorComponent.kt:87)");
            }
            String statusIcon = $floorData.getStatusIcon();
            if (((statusIcon == null || statusIcon.length() == 0) ? 1 : null) == null) {
                $composer.startReplaceGroup(-92796365);
                ComposerKt.sourceInformation($composer, "89@3824L364");
                String imgUrlString = $floorData.getStatusIcon();
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(imgUrlString);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(OffsetKt.offset-VpY3zN4$default($this$PaddingCard.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, ProvideUiScaleKt.dpScaled(-16, $scale), 1, (Object) null), ProvideUiScaleKt.dpScaled(34, $scale)), ProvideUiScaleKt.dpScaled(38, $scale)), null, null, null, null, null, null, null, $composer, 0, 508);
            } else {
                $composer.startReplaceGroup(-96538933);
            }
            $composer.endReplaceGroup();
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
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 252092975, "C104@4324L361,113@4699L273:CrowdfundingStairsFloorComponent.kt#o90vz8");
            TitleRowComponent($floorData.getAchieveAmountPrefix(), $floorData.getAchieveAmountStr(), $floorData.getTargetAmountDesc(), $floorData.getPercentage(), $scale, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 196608, 0);
            Integer percentage = $floorData.getPercentage();
            boolean z2 = true;
            ProgressComponent(percentage != null ? percentage.intValue() : 0, $scale, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(10, $scale), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
            List list = $outShowLevelList;
            String str2 = "CC(remember):CrowdfundingStairsFloorComponent.kt#9igjgp";
            if (list == null || list.isEmpty()) {
                str = "CC(remember):CrowdfundingStairsFloorComponent.kt#9igjgp";
                z = true;
                i = 247713077;
                $composer2 = $composer;
                $composer2.startReplaceGroup(247713077);
                $composer2.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(252719949);
                ComposerKt.sourceInformation($composer, "123@5043L43,*133@5475L175,130@5345L328");
                int i4 = 0;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, $scale)), $composer, 0);
                List $this$forEachIndexed$iv = $outShowLevelList;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CrowdfundingStairsFloor.LevelItem item = (CrowdfundingStairsFloor.LevelItem) item$iv;
                    int index = index$iv;
                    if (index > 0) {
                        $composer.startReplaceGroup(-215152703);
                        ComposerKt.sourceInformation($composer, "126@5213L89");
                        LevelInterComponent($scale, null, $composer, i4, 2);
                    } else {
                        $composer.startReplaceGroup(-220303446);
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart($composer, -1253857145, str2);
                    boolean invalid$iv = $composer.changedInstance($floorData) | $composer.changedInstance($pageVM);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit CrowdfundingStairsFloorComponent$lambda$2$0$0$0$0;
                                CrowdfundingStairsFloorComponent$lambda$2$0$0$0$0 = CrowdfundingStairsFloorComponentKt.CrowdfundingStairsFloorComponent$lambda$2$0$0$0$0(CrowdfundingStairsFloor.this, $pageVM);
                                return CrowdfundingStairsFloorComponent$lambda$2$0$0$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LevelItemComponent(item, (Function0) it$iv, $scale, null, $composer, 0, 8);
                    index$iv = index$iv2;
                    z2 = z2;
                    str2 = str2;
                    i4 = 0;
                }
                str = str2;
                z = z2;
                i = 247713077;
                $composer.endReplaceGroup();
                $composer2 = $composer;
            }
            if (Intrinsics.areEqual($floorData.getShowMore(), Boolean.valueOf(z))) {
                $composer2.startReplaceGroup(253464321);
                ComposerKt.sourceInformation($composer2, "148@5984L191,143@5769L1428");
                Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, z ? 1 : 0, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(16, $scale), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 700919116, str);
                boolean invalid$iv2 = $composer2.changedInstance($floorData) | $composer2.changedInstance($pageVM);
                Composer $this$cache$iv = $composer2;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit CrowdfundingStairsFloorComponent$lambda$2$0$1$0;
                            CrowdfundingStairsFloorComponent$lambda$2$0$1$0 = CrowdfundingStairsFloorComponentKt.CrowdfundingStairsFloorComponent$lambda$2$0$1$0(CrowdfundingStairsFloor.this, $pageVM);
                            return CrowdfundingStairsFloorComponent$lambda$2$0$1$0;
                        }
                    };
                    $this$cache$iv.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Composer $composer$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1211920418, "C158@6438L6,156@6349L406,168@6830L21,169@6894L6,167@6777L402:CrowdfundingStairsFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk("更多解锁目标", (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer$iv, 6, 0, 131066);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_expand_line_900($composer$iv, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, $scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, $scale)), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), $composer$iv, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
            } else {
                $composer2.startReplaceGroup(i);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingStairsFloorComponent$lambda$2$0$0$0$0(CrowdfundingStairsFloor $floorData, PageViewModel $pageVM) {
        String it = $floorData.getJumpUrl();
        if (it != null) {
            $pageVM.bridgeShowHalfWebView$product_details_page_debug(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingStairsFloorComponent$lambda$2$0$1$0(CrowdfundingStairsFloor $floorData, PageViewModel $pageVM) {
        String it = $floorData.getJumpUrl();
        if (it != null) {
            $pageVM.bridgeShowHalfWebView$product_details_page_debug(it);
        }
        return Unit.INSTANCE;
    }

    private static final void TitleRowComponent(final String achieveAmountPrefix, final String achieveAmountStr, final String targetAmountDesc, final Integer percentage, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        String str;
        String str2;
        Double calculatedValue;
        Object finalValue;
        String percentageText;
        Composer $composer3 = $composer.startRestartGroup(89837319);
        ComposerKt.sourceInformation($composer3, "C(TitleRowComponent)N(achieveAmountPrefix,achieveAmountStr,targetAmountDesc,percentage,scale,modifier)191@7453L2183:CrowdfundingStairsFloorComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(achieveAmountPrefix) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(achieveAmountStr) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(targetAmountDesc) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(percentage) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $dirty = $dirty3;
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
                ComposerKt.traceEventStart(89837319, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.TitleRowComponent (CrowdfundingStairsFloorComponent.kt:190)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $dirty = $dirty3;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$TitleRowComponent_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1967401163, "C197@7603L443,211@8055L335,236@8906L323,247@9238L27,252@9399L6,248@9274L356:CrowdfundingStairsFloorComponent.kt#o90vz8");
            if (achieveAmountPrefix != null) {
                str = achieveAmountPrefix;
            } else {
                str = "";
            }
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 11, (Object) null), ColorKt.Color(4288256409L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            TextKt.Text-Nvy7gAk(achieveAmountStr == null ? "" : achieveAmountStr, (Modifier) null, ColorKt.Color(4294668953L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114682);
            if ((percentage != null ? percentage.intValue() : 0) <= 0) {
                str2 = "";
                percentageText = str2;
            } else {
                if (percentage != null) {
                    str2 = "";
                    calculatedValue = Double.valueOf(percentage.intValue() / 100);
                } else {
                    str2 = "";
                    calculatedValue = null;
                }
                int intValue = (percentage != null ? percentage.intValue() : 0) / 100;
                if (Intrinsics.areEqual(calculatedValue, intValue)) {
                    finalValue = Integer.valueOf(intValue);
                } else {
                    finalValue = calculatedValue;
                }
                percentageText = "（" + finalValue + "%）";
            }
            TextKt.Text-Nvy7gAk(percentageText, (Modifier) null, ColorKt.Color(4280361249L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114682);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$TitleRowComponent_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            TextKt.Text-Nvy7gAk(targetAmountDesc == null ? str2 : targetAmountDesc, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114682);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TitleRowComponent$lambda$1;
                    TitleRowComponent$lambda$1 = CrowdfundingStairsFloorComponentKt.TitleRowComponent$lambda$1(achieveAmountPrefix, achieveAmountStr, targetAmountDesc, percentage, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TitleRowComponent$lambda$1;
                }
            });
        }
    }

    private static final void ProgressComponent(final int progress, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Object obj;
        Float f;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1141589983);
        ComposerKt.sourceInformation($composer3, "C(ProgressComponent)N(progress,scale,modifier)271@9894L27,271@9877L44,272@9937L43,274@10017L736,274@9986L767,294@10758L2326:CrowdfundingStairsFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(progress) ? 4 : 2;
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
                ComposerKt.traceEventStart(-1141589983, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ProgressComponent (CrowdfundingStairsFloorComponent.kt:268)");
            }
            float targetFraction = RangesKt.coerceIn(progress, 0, 10000) / 10000.0f;
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart($composer3, -1851305668, "CC(remember):CrowdfundingStairsFloorComponent.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        MutableFloatState ProgressComponent$lambda$0$0;
                        ProgressComponent$lambda$0$0 = CrowdfundingStairsFloorComponentKt.ProgressComponent$lambda$0$0();
                        return ProgressComponent$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            MutableFloatState lastFraction = (MutableFloatState) RememberSaveableKt.rememberSaveable(objArr, (Function0) it$iv, $composer3, 48);
            ComposerKt.sourceInformationMarkerStart($composer3, -1851304276, "CC(remember):CrowdfundingStairsFloorComponent.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                obj = null;
                Object value$iv2 = AnimatableKt.Animatable$default(lastFraction.getValue().floatValue(), 0.0f, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                obj = null;
            }
            Animatable anim = (Animatable) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Float valueOf = Float.valueOf(targetFraction);
            ComposerKt.sourceInformationMarkerStart($composer3, -1851301023, "CC(remember):CrowdfundingStairsFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(anim) | $composer3.changed(targetFraction) | (($dirty2 & 14) == 4) | $composer3.changed(lastFraction);
            Object value$iv3 = $composer3.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                f = valueOf;
                value$iv3 = new CrowdfundingStairsFloorComponentKt$ProgressComponent$1$1(anim, targetFraction, progress, lastFraction, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                f = valueOf;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(f, (Function2) value$iv3, $composer3, 0);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(10, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(5, scale))), ColorKt.Color(4294243572L), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1726285533, "C305@11101L1977:CrowdfundingStairsFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.wrapContentSize(PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), RangesKt.coerceIn(((Number) anim.getValue()).floatValue(), 0.0f, 1.0f)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(5, scale))), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294946974L)), Color.box-impl(ColorKt.Color(4294921871L))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(5, scale))), ProvideUiScaleKt.dpScaled(3, scale), 0.0f, 2, (Object) null), Alignment.Companion.getCenterStart(), true);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
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
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 926375146, "C334@12408L660:CrowdfundingStairsFloorComponent.kt#o90vz8");
            String $this$asRequest$iv = HelperKt.customizedImageUrl("http://i0.hdslb.com/bfs/kfptfe/floor/5c1e7b2d7ab0887325783c5678536375af1b7b9c.png");
            ImageRequest $this$ProgressComponent_u24lambda_u243_u240_u240 = new ImageRequest($this$asRequest$iv);
            int $changed$iv$iv$iv3 = Pixel.m1517constructorimpl(1040);
            int $changed$iv = Pixel.m1517constructorimpl(24);
            $this$ProgressComponent_u24lambda_u243_u240_u240.resizeOption(new ResizeOption($changed$iv$iv$iv3, $changed$iv, null));
            $this$ProgressComponent_u24lambda_u243_u240_u240.align(Alignment.Companion.getCenterStart());
            $this$ProgressComponent_u24lambda_u243_u240_u240.contentScale(ContentScale.Companion.getFillHeight());
            BiliImageKt.BiliImage($this$ProgressComponent_u24lambda_u243_u240_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(347, scale)), ProvideUiScaleKt.dpScaled(8, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ProgressComponent$lambda$4;
                    ProgressComponent$lambda$4 = CrowdfundingStairsFloorComponentKt.ProgressComponent$lambda$4(progress, scale, modifier5, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return ProgressComponent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableFloatState ProgressComponent$lambda$0$0() {
        return PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0bb6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0bec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void LevelItemComponent(final CrowdfundingStairsFloor.LevelItem item, final Function0<Unit> function0, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int $dirty;
        Composer $composer3;
        String str;
        String str2;
        Composer $composer$iv;
        List list;
        Modifier modifier4;
        Composer $composer$iv$iv$iv;
        Composer $composer4;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv2;
        Composer $composer$iv$iv;
        Composer $composer5;
        Modifier materialized$iv$iv;
        char c;
        long dayColor;
        long nightColor;
        long backDayColor;
        long backDayColor2;
        boolean hasBackground;
        Function0 factory$iv$iv$iv4;
        String text;
        long j;
        long j2;
        long j3;
        Composer $composer6 = $composer.startRestartGroup(650601223);
        ComposerKt.sourceInformation($composer6, "C(LevelItemComponent)N(item,onClick,scale,modifier)362@13263L5471:CrowdfundingStairsFloorComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer6.changedInstance(item) ? 4 : 2;
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
        if ($composer6.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(650601223, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.LevelItemComponent (CrowdfundingStairsFloorComponent.kt:361)");
            }
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier5 = modifier3;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer6.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -1893795057, "C370@13445L3451:CrowdfundingStairsFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            $composer2 = $composer6;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -57345581, "C:CrowdfundingStairsFloorComponent.kt#o90vz8");
            String icon = item.getRewardStatusIcon();
            String str3 = icon;
            if (str3 == null || str3.length() == 0) {
                $composer6.startReplaceGroup(-70957899);
            } else {
                $composer6.startReplaceGroup(-57365856);
                ComposerKt.sourceInformation($composer6, "378@13709L277");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(icon);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(14, scale)), null, null, null, null, null, null, null, $composer6, 0, 508);
            }
            $composer6.endReplaceGroup();
            TextColorModel targetAmountDesc = item.getTargetAmountDesc();
            if (targetAmountDesc != null) {
                String text2 = targetAmountDesc.getText();
                if (!(text2 == null || text2.length() == 0)) {
                    $composer6.startReplaceGroup(-56901941);
                    ComposerKt.sourceInformation($composer6, "395@14505L21,391@14359L580");
                    String dayColor2 = targetAmountDesc.getDayColor();
                    Color color = dayColor2 != null ? Color.box-impl(ComposeColorParserKt.parseColor(dayColor2)) : null;
                    if (color == null) {
                        $composer6.startReplaceGroup(1660734610);
                        ComposerKt.sourceInformation($composer6, "389@14229L6");
                        j = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU();
                        $composer6.endReplaceGroup();
                    } else {
                        $composer6.startReplaceGroup(1660732750);
                        $composer6.endReplaceGroup();
                        j = color.unbox-impl();
                    }
                    long dayColor3 = j;
                    String nightColor2 = targetAmountDesc.getNightColor();
                    Color color2 = nightColor2 != null ? Color.box-impl(ComposeColorParserKt.parseColor(nightColor2)) : null;
                    if (color2 == null) {
                        $composer6.startReplaceGroup(1660737842);
                        ComposerKt.sourceInformation($composer6, "390@14330L6");
                        j2 = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU();
                        $composer6.endReplaceGroup();
                    } else {
                        $composer6.startReplaceGroup(1660735920);
                        $composer6.endReplaceGroup();
                        j2 = color2.unbox-impl();
                    }
                    long nightColor3 = j2;
                    String text3 = targetAmountDesc.getText();
                    if (ThemesKt.isCurrentThemeLight($composer6, 0)) {
                        j3 = dayColor3;
                    } else {
                        j3 = nightColor3;
                    }
                    TextKt.Text-Nvy7gAk(text3, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(13), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer6, 0, 24576, 114682);
                    $composer6.endReplaceGroup();
                    if (item.getRewardGapDesc() != null) {
                        String text4 = item.getRewardGapDesc().getText();
                        if (!(text4 == null || text4.length() == 0)) {
                            $composer6.startReplaceGroup(-55977118);
                            ComposerKt.sourceInformation($composer6, "422@15889L21,416@15615L1257");
                            TextColorModel textModel = item.getRewardGapDesc();
                            String dayColor4 = textModel.getDayColor();
                            Color color3 = dayColor4 != null ? Color.box-impl(ComposeColorParserKt.parseColor(dayColor4)) : null;
                            if (color3 == null) {
                                $composer6.startReplaceGroup(1660764828);
                                ComposerKt.sourceInformation($composer6, "411@15173L6");
                                dayColor = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU();
                                $composer6.endReplaceGroup();
                            } else {
                                $composer6.startReplaceGroup(1660763185);
                                $composer6.endReplaceGroup();
                                dayColor = color3.unbox-impl();
                            }
                            String nightColor4 = textModel.getNightColor();
                            Color color4 = nightColor4 != null ? Color.box-impl(ComposeColorParserKt.parseColor(nightColor4)) : null;
                            if (color4 == null) {
                                $composer6.startReplaceGroup(1660768156);
                                ComposerKt.sourceInformation($composer6, "412@15277L6");
                                nightColor = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU();
                                $composer6.endReplaceGroup();
                            } else {
                                $composer6.startReplaceGroup(1660766451);
                                $composer6.endReplaceGroup();
                                nightColor = color4.unbox-impl();
                            }
                            String backDayColor3 = textModel.getBackDayColor();
                            long backDayColor4 = backDayColor3 != null ? ComposeColorParserKt.parseColor(backDayColor3) : Color.Companion.getTransparent-0d7_KjU();
                            String backNightColor = textModel.getBackNightColor();
                            long backNightColor2 = backNightColor != null ? ComposeColorParserKt.parseColor(backNightColor) : Color.Companion.getTransparent-0d7_KjU();
                            int $dirty3 = $dirty2;
                            $composer3 = $composer6;
                            if (Color.equals-impl0(backDayColor4, Color.Companion.getTransparent-0d7_KjU())) {
                                backDayColor = backDayColor4;
                                backDayColor2 = backNightColor2;
                                if (Color.equals-impl0(backDayColor2, Color.Companion.getTransparent-0d7_KjU())) {
                                    hasBackground = false;
                                    Modifier modifier$iv3 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(16, scale)), !ThemesKt.isCurrentThemeLight($composer6, 0) ? backDayColor : backDayColor2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))).then(!hasBackground ? PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null) : Modifier.Companion);
                                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                                    ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv3 = (48 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                                    CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
                                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    $dirty = $dirty3;
                                    str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                                    ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!($composer6.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer6.startReusableNode();
                                    if (!$composer6.getInserting()) {
                                        factory$iv$iv$iv4 = factory$iv$iv$iv7;
                                        $composer6.createNode(factory$iv$iv$iv4);
                                    } else {
                                        factory$iv$iv$iv4 = factory$iv$iv$iv7;
                                        $composer6.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
                                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                                    $composer$iv = $composer6;
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                                    int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                    int i8 = ((48 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer6, 842332921, "C435@16556L21,433@16448L406:CrowdfundingStairsFloorComponent.kt#o90vz8");
                                    text = item.getRewardGapDesc().getText();
                                    if (text == null) {
                                        text = "";
                                    }
                                    TextKt.Text-Nvy7gAk(text, (Modifier) null, !ThemesKt.isCurrentThemeLight($composer6, 0) ? dayColor : nightColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), $composer6, 0, 0, 131066);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    $composer6.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    $composer6.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    $composer6.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                    List giftList = item.getCrowdfundingLevelGiftList();
                                    list = giftList;
                                    if (list != null || list.isEmpty()) {
                                        Composer $composer7 = $composer3;
                                        $composer7.startReplaceGroup(-1890387352);
                                        ComposerKt.sourceInformation($composer7, "448@17005L1713");
                                        Modifier modifier$iv4 = SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(12, scale), 0.0f, 0.0f, 13, (Object) null), ProvideUiScaleKt.dpScaled(70, scale));
                                        ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                                        MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                        int $changed$iv$iv4 = (0 << 3) & 112;
                                        String str4 = str;
                                        ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, str4);
                                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
                                        CompositionLocalMap localMap$iv$iv4 = $composer7.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer7, modifier$iv4);
                                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                        String str5 = str2;
                                        ComposerKt.sourceInformationMarkerStart($composer7, -553112988, str5);
                                        if (!($composer7.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer7.startReusableNode();
                                        if ($composer7.getInserting()) {
                                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                            $composer7.createNode(factory$iv$iv$iv3);
                                        } else {
                                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                            $composer7.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer7);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                                        int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                        int i10 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer7, -79631483, "C:CrowdfundingStairsFloorComponent.kt#o90vz8");
                                        if (giftList.size() == 1) {
                                            $composer7.startReplaceGroup(-79641528);
                                            ComposerKt.sourceInformation($composer7, "456@17296L322");
                                            $composer5 = $composer7;
                                            modifier4 = modifier5;
                                            $composer$iv$iv$iv = $composer6;
                                            $composer$iv2 = $composer7;
                                            $composer$iv$iv = $composer7;
                                            LevelGiftItemComponent((CrowdfundingStairsFloor.LevelItem.GiftItem) CollectionsKt.first(giftList), scale, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(22, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer5, ($dirty >> 3) & 112, 0);
                                            $composer5.endReplaceGroup();
                                        } else {
                                            $composer$iv2 = $composer7;
                                            int $dirty4 = $dirty;
                                            modifier4 = modifier5;
                                            $composer$iv$iv$iv = $composer6;
                                            $composer$iv$iv = $composer7;
                                            $composer7.startReplaceGroup(-79254772);
                                            ComposerKt.sourceInformation($composer7, "469@17838L21,465@17664L1022");
                                            Modifier modifier$iv5 = ScrollKt.horizontalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer7, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                                            ComposerKt.sourceInformationMarkerStart($composer7, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer7, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                            int $changed$iv$iv5 = (384 << 3) & 112;
                                            Composer $composer$iv$iv2 = $composer7;
                                            Composer $composer$iv$iv$iv2 = $composer7;
                                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -1159599143, str4);
                                            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv2, 0));
                                            CompositionLocalMap localMap$iv$iv5 = $composer$iv$iv$iv2.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv2, modifier$iv5);
                                            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                                            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                                            Composer $composer8 = $composer7;
                                            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, str5);
                                            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer$iv$iv$iv2.startReusableNode();
                                            if ($composer$iv$iv$iv2.getInserting()) {
                                                $composer$iv$iv$iv2.createNode(factory$iv$iv$iv9);
                                            } else {
                                                $composer$iv$iv$iv2.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv$iv$iv2);
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                                            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                                            Composer $composer$iv3 = $composer$iv$iv$iv2;
                                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                                            int i12 = ((384 >> 6) & 112) | 6;
                                            Composer $composer9 = $composer$iv3;
                                            ComposerKt.sourceInformationMarkerStart($composer9, 1126126097, "C472@17982L42:CrowdfundingStairsFloorComponent.kt#o90vz8");
                                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(22, scale)), $composer9, 0);
                                            $composer9.startReplaceGroup(1975991654);
                                            ComposerKt.sourceInformation($composer9, "*477@18279L359");
                                            List $this$forEachIndexed$iv = giftList;
                                            int index$iv = 0;
                                            for (Object item$iv : $this$forEachIndexed$iv) {
                                                int index$iv2 = index$iv + 1;
                                                if (index$iv < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                CrowdfundingStairsFloor.LevelItem.GiftItem item2 = (CrowdfundingStairsFloor.LevelItem.GiftItem) item$iv;
                                                int index = index$iv;
                                                if (index > 0) {
                                                    $composer9.startReplaceGroup(2034306233);
                                                    ComposerKt.sourceInformation($composer9, "475@18167L53");
                                                    materialized$iv$iv = materialized$iv$iv6;
                                                    c = 16;
                                                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), $composer9, 0);
                                                } else {
                                                    materialized$iv$iv = materialized$iv$iv6;
                                                    c = 16;
                                                    $composer9.startReplaceGroup(2016313678);
                                                }
                                                $composer9.endReplaceGroup();
                                                Composer $composer$iv4 = $composer8;
                                                $composer9 = $composer9;
                                                Composer $composer$iv$iv3 = $composer$iv$iv$iv3;
                                                Composer $composer$iv$iv$iv4 = $composer$iv$iv2;
                                                LevelGiftItemComponent(item2, scale, SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(234, scale)), $composer9, ($dirty4 >> 3) & 112, 0);
                                                materialized$iv$iv6 = materialized$iv$iv;
                                                $composer$iv$iv$iv2 = $composer$iv$iv$iv2;
                                                index$iv = index$iv2;
                                                $composer$iv3 = $composer$iv3;
                                                $composer8 = $composer$iv4;
                                                $composer$iv$iv$iv3 = $composer$iv$iv3;
                                                $composer$iv$iv2 = $composer$iv$iv$iv4;
                                            }
                                            Composer $composer$iv5 = $composer8;
                                            $composer5 = $composer$iv$iv2;
                                            Composer $composer10 = $composer$iv$iv$iv3;
                                            Composer $composer$iv6 = $composer9;
                                            Composer $composer$iv$iv4 = $composer$iv$iv$iv2;
                                            $composer$iv6.endReplaceGroup();
                                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                            $composer$iv$iv4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv4);
                                            ComposerKt.sourceInformationMarkerEnd($composer10);
                                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                            $composer5.endReplaceGroup();
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                        $composer7.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                        $composer3.endReplaceGroup();
                                        $composer4 = $composer3;
                                    } else {
                                        modifier4 = modifier5;
                                        $composer$iv$iv$iv = $composer6;
                                        $composer4 = $composer3;
                                        $composer4.startReplaceGroup(-1907297263);
                                        $composer4.endReplaceGroup();
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    $composer$iv$iv$iv.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier4;
                                }
                            } else {
                                backDayColor = backDayColor4;
                                backDayColor2 = backNightColor2;
                            }
                            hasBackground = true;
                            Modifier modifier$iv32 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(16, scale)), !ThemesKt.isCurrentThemeLight($composer6, 0) ? backDayColor : backDayColor2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))).then(!hasBackground ? PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null) : Modifier.Companion);
                            Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                            int $changed$iv$iv32 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                            CompositionLocalMap localMap$iv$iv32 = $composer6.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer6, modifier$iv32);
                            Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                            $dirty = $dirty3;
                            str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer6.getApplier() instanceof Applier)) {
                            }
                            $composer6.startReusableNode();
                            if (!$composer6.getInserting()) {
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer6);
                            str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            $composer$iv = $composer6;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                            int i72 = ($changed$iv$iv$iv32 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                            int i82 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer6, 842332921, "C435@16556L21,433@16448L406:CrowdfundingStairsFloorComponent.kt#o90vz8");
                            text = item.getRewardGapDesc().getText();
                            if (text == null) {
                            }
                            TextKt.Text-Nvy7gAk(text, (Modifier) null, !ThemesKt.isCurrentThemeLight($composer6, 0) ? dayColor : nightColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), $composer6, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            $composer6.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            $composer6.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            $composer6.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            List giftList2 = item.getCrowdfundingLevelGiftList();
                            list = giftList2;
                            if (list != null || list.isEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            $composer$iv$iv$iv.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier4;
                        }
                    }
                    $dirty = $dirty2;
                    $composer3 = $composer6;
                    str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv = $composer6;
                    $composer6.startReplaceGroup(-70957899);
                    $composer6.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    $composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    List giftList22 = item.getCrowdfundingLevelGiftList();
                    list = giftList22;
                    if (list != null || list.isEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier4;
                }
            }
            $composer6.startReplaceGroup(-70957899);
            $composer6.endReplaceGroup();
            if (item.getRewardGapDesc() != null) {
            }
            $dirty = $dirty2;
            $composer3 = $composer6;
            str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            $composer$iv = $composer6;
            $composer6.startReplaceGroup(-70957899);
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            List giftList222 = item.getCrowdfundingLevelGiftList();
            list = giftList222;
            if (list != null || list.isEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit LevelItemComponent$lambda$1;
                    LevelItemComponent$lambda$1 = CrowdfundingStairsFloorComponentKt.LevelItemComponent$lambda$1(CrowdfundingStairsFloor.LevelItem.this, function0, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LevelItemComponent$lambda$1;
                }
            });
        }
    }

    private static final void LevelInterComponent(final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1669390547);
        ComposerKt.sourceInformation($composer2, "C(LevelInterComponent)N(scale,modifier)498@18844L510:CrowdfundingStairsFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scale) ? 4 : 2;
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
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1669390547, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.LevelInterComponent (CrowdfundingStairsFloorComponent.kt:497)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 5, (Object) null), ProvideUiScaleKt.dpScaled(1, scale)), ProvideUiScaleKt.dpScaled(20, scale));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -972469816, "C508@19204L6,507@19154L194:CrowdfundingStairsFloorComponent.kt#o90vz8");
            DashedComponentKt.m547DashedVerticalLineGCwHvm0(ProvideUiScaleKt.dpScaled(1, scale), ProvideUiScaleKt.dpScaled(2, scale), ProvideUiScaleKt.dpScaled(2, scale), null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer2, 0, 8);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LevelInterComponent$lambda$1;
                    LevelInterComponent$lambda$1 = CrowdfundingStairsFloorComponentKt.LevelInterComponent$lambda$1(scale, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LevelInterComponent$lambda$1;
                }
            });
        }
    }

    private static final void LevelGiftItemComponent(final CrowdfundingStairsFloor.LevelItem.GiftItem item, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        ArrayList arrayList;
        String specString;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        String str;
        Composer $composer3 = $composer.startRestartGroup(-620832033);
        ComposerKt.sourceInformation($composer3, "C(LevelGiftItemComponent)N(item,scale,modifier)531@19782L3004:CrowdfundingStairsFloorComponent.kt#o90vz8");
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
                ComposerKt.traceEventStart(-620832033, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.LevelGiftItemComponent (CrowdfundingStairsFloorComponent.kt:521)");
            }
            String cover = item.getGiftImg();
            Integer count = item.getGiftNum();
            String name = item.getGiftName();
            Iterable bindSkuVOS = item.getBindSkuVOS();
            if (bindSkuVOS != null) {
                Iterable $this$filter$iv = bindSkuVOS;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    CrowdfundingStairsFloor.LevelItem.GiftItem.BindSkuInfo it = (CrowdfundingStairsFloor.LevelItem.GiftItem.BindSkuInfo) element$iv$iv;
                    String specDesc = it.getSpecDesc();
                    if (!(specDesc == null || specDesc.length() == 0)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                arrayList = (List) destination$iv$iv;
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                $composer3.startReplaceGroup(-1077565994);
                $composer3.endReplaceGroup();
                specString = null;
            } else {
                $composer3.startReplaceGroup(380881803);
                ComposerKt.sourceInformation($composer3, "529@19750L26");
                ArrayList arrayList2 = arrayList;
                ComposerKt.sourceInformationMarkerStart($composer3, 380882361, "CC(remember):CrowdfundingStairsFloorComponent.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            CharSequence LevelGiftItemComponent$lambda$1$0;
                            LevelGiftItemComponent$lambda$1$0 = CrowdfundingStairsFloorComponentKt.LevelGiftItemComponent$lambda$1$0((CrowdfundingStairsFloor.LevelItem.GiftItem.BindSkuInfo) obj);
                            return LevelGiftItemComponent$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                specString = CollectionsKt.joinToString$default(arrayList2, r21, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) it$iv, 30, (Object) null);
                $composer3.endReplaceGroup();
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 6) & 14) | 384;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            modifier3 = modifier4;
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$LevelGiftItemComponent_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 590103764, "C541@20127L6,535@19888L520,552@20418L41,554@20469L2311:CrowdfundingStairsFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(70, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale))), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            String specString2 = specString;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 503198854, "C:CrowdfundingStairsFloorComponent.kt#o90vz8");
            String str2 = cover;
            if (str2 == null || str2.length() == 0) {
                $composer3.startReplaceGroup(483166777);
            } else {
                $composer3.startReplaceGroup(503225761);
                ComposerKt.sourceInformation($composer3, "545@20232L152");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(cover);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer3, 48, 508);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer3, 0);
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$LevelGiftItemComponent_u24lambda_u242, $this$LevelGiftItemComponent_u24lambda_u242.align(Modifier.Companion, Alignment.Companion.getTop()), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 950863944, "C560@20624L1279,595@21916L42,598@22050L6,596@21971L368,607@22352L42,610@22481L6,608@22407L363:CrowdfundingStairsFloorComponent.kt#o90vz8");
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -960594293, "C563@20723L6,561@20646L398,574@21154L6,572@21061L414,585@21568L6,583@21492L397:CrowdfundingStairsFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("购买", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 6, 24576, 114682);
            TextKt.Text-Nvy7gAk(specString2 == null ? "" : specString2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114682);
            TextKt.Text-Nvy7gAk("送", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 6, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer3, 0);
            if (name == null) {
                str = "";
            } else {
                str = name;
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114682);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer3, 0);
            TextKt.Text-Nvy7gAk("x" + count, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114682);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit LevelGiftItemComponent$lambda$3;
                    LevelGiftItemComponent$lambda$3 = CrowdfundingStairsFloorComponentKt.LevelGiftItemComponent$lambda$3(CrowdfundingStairsFloor.LevelItem.GiftItem.this, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LevelGiftItemComponent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence LevelGiftItemComponent$lambda$1$0(CrowdfundingStairsFloor.LevelItem.GiftItem.BindSkuInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getSpecDesc());
    }
}