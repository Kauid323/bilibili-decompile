package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
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
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.AttrListItem;
import kntr.app.mall.product.details.page.api.model.DetailDescFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.Quality;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: DetailDescComponent.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a-\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001ae\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b26\u0010\u001d\u001a2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000b\u0012\u0004\u0012\u00020 \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0!0\u000b\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\"\u001a¢\u0001\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010/¢\u0006\u0002\b02&\b\u0002\u00101\u001a \u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0001\u0018\u000102¢\u0006\u0002\b0¢\u0006\u0002\b5H\u0001¢\u0006\u0004\b6\u00107\u001a\r\u00108\u001a\u00020\u0001H\u0001¢\u0006\u0002\u00109¨\u0006:²\u0006\n\u0010;\u001a\u00020<X\u008a\u0084\u0002"}, d2 = {"DetailDescComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AttrTable", "attrGroups", "", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$ItemsAttrGroup;", "scale", "", "(Ljava/util/List;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "borderRight", "borderColor", "Landroidx/compose/ui/graphics/Color;", "borderRight-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "drawBottomLine", "shouldDraw", "", "drawBottomLine-mxwnekA", "(Landroidx/compose/ui/Modifier;ZJ)Landroidx/compose/ui/Modifier;", "ItemsContentsComponent", "contents", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Content;", "onImagePreview", "Lkotlin/Function3;", "", "", "Lkotlin/Pair;", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ImageWithDynamicRatio", "imageUrl", "quality", "Lkntr/base/imageloader/Quality;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "useRaw", "presetRatio", "requestWidth", "Lkntr/base/imageloader/Pixel;", "requestHeight", "loadingPlaceHolder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "failedPlaceHolder", "Lkotlin/Function2;", "Lkntr/base/imageloader/ImageFailScope;", "Lkntr/base/imageloader/ImageException;", "Lkotlin/ExtensionFunctionType;", "ImageWithDynamicRatio-Q4leyOY", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/layout/ContentScale;ZLjava/lang/Float;Lkntr/base/imageloader/Pixel;Lkntr/base/imageloader/Pixel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "DefaultImagePlaceHolder", "(Landroidx/compose/runtime/Composer;I)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DetailDescComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AttrTable$lambda$1(List list, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AttrTable(list, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultImagePlaceHolder$lambda$0(int i, Composer composer, int i2) {
        DefaultImagePlaceHolder(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailDescComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailDescComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailDescComponent$lambda$3(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailDescComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageWithDynamicRatio_Q4leyOY$lambda$4(String str, Modifier modifier, int i, ContentScale contentScale, boolean z, Float f, Pixel pixel, Pixel pixel2, Function2 function2, Function4 function4, int i2, int i3, Composer composer, int i4) {
        m463ImageWithDynamicRatioQ4leyOY(str, modifier, i, contentScale, z, f, pixel, pixel2, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsContentsComponent$lambda$0$4$0(List list, Function3 function3, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ItemsContentsComponent(list, function3, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsContentsComponent$lambda$1(List list, Function3 function3, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ItemsContentsComponent(list, function3, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DetailDescComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(1349179213);
        ComposerKt.sourceInformation($composer3, "C(DetailDescComponent)N(module,pageViewModel,modifier)67@2897L16,78@3288L1048,69@2951L1385:DetailDescComponent.kt#o90vz8");
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
                ComposerKt.traceEventStart(1349179213, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.DetailDescComponent (DetailDescComponent.kt:60)");
            }
            if (module instanceof ContentModule.DetailDescModule) {
                DetailDescFloor floorData = ((ContentModule.DetailDescModule) module).getData();
                final List attrs = floorData.getItemsAttrGroups();
                final List contents = floorData.getContents();
                State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                final float scale = DetailDescComponent$lambda$1(scaleModel$delegate).getScale();
                $composer2 = $composer3;
                PaddingCardKt.PaddingCard(modifier3, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(304125394, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit DetailDescComponent$lambda$2;
                        DetailDescComponent$lambda$2 = DetailDescComponentKt.DetailDescComponent$lambda$2(scale, attrs, contents, pageViewModel, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return DetailDescComponent$lambda$2;
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
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DetailDescComponent$lambda$0;
                            DetailDescComponent$lambda$0 = DetailDescComponentKt.DetailDescComponent$lambda$0(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return DetailDescComponent$lambda$0;
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
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailDescComponent$lambda$3;
                    DetailDescComponent$lambda$3 = DetailDescComponentKt.DetailDescComponent$lambda$3(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailDescComponent$lambda$3;
                }
            });
        }
    }

    private static final UiScaleModel DetailDescComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0259, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit DetailDescComponent$lambda$2(float $scale, List $attrs, List $contents, final PageViewModel $pageViewModel, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        boolean z;
        int i;
        Composer $composer3;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C79@3298L1032:DetailDescComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(304125394, $changed, -1, "kntr.app.mall.product.details.page.ui.components.DetailDescComponent.<anonymous> (DetailDescComponent.kt:79)");
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 322550073, "C85@3493L6,86@3540L9,82@3378L204,88@3595L54:DetailDescComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("商品详情", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getLeft-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $scale), $composer, 6, 0, 130042);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(14, $scale)), $composer, 0);
            List list = $attrs;
            if (list == null || list.isEmpty()) {
                $composer$iv$iv$iv = $composer;
                $composer$iv = $composer;
                $composer2 = $composer;
                z = false;
                i = 319168902;
                $composer2.startReplaceGroup(319168902);
                $composer2.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(322836760);
                ComposerKt.sourceInformation($composer, "90@3708L103,94@3828L54");
                $composer$iv = $composer;
                $composer$iv$iv$iv = $composer;
                AttrTable($attrs, $scale, null, $composer, 0, 4);
                $composer2 = $composer;
                z = false;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, $scale)), $composer2, 0);
                $composer2.endReplaceGroup();
                i = 319168902;
            }
            List list2 = $contents;
            if ((list2 == null || list2.isEmpty()) ? true : true) {
                $composer3 = $composer2;
                $composer3.startReplaceGroup(i);
                $composer3.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(323107018);
                ComposerKt.sourceInformation($composer2, "100@4095L136,97@3958L348");
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1118805636, "CC(remember):DetailDescComponent.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance($pageViewModel);
                Composer $this$cache$iv = $composer2;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit DetailDescComponent$lambda$2$0$0$0;
                        DetailDescComponent$lambda$2$0$0$0 = DetailDescComponentKt.DetailDescComponent$lambda$2$0$0$0(PageViewModel.this, (List) obj, ((Integer) obj2).intValue(), (List) obj3);
                        return DetailDescComponent$lambda$2$0$0$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Composer $composer4 = $composer2;
                ItemsContentsComponent($contents, (Function3) it$iv, $scale, fillMaxWidth$default, $composer2, 3072, 0);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailDescComponent$lambda$2$0$0$0(PageViewModel $pageViewModel, List images, int index, List imageSizes) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(imageSizes, "imageSizes");
        $pageViewModel.updateImagePreview$product_details_page_debug(images, index, imageSizes);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x020d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020f A[LOOP:2: B:52:0x01da->B:67:0x020f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AttrTable(final List<DetailDescFloor.ItemsAttrGroup> $this$forEachIndexed$iv, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        boolean firstGroupEmpty;
        Iterable $this$none$iv;
        Iterator it;
        boolean z;
        boolean z2;
        Function0 factory$iv$iv$iv2;
        boolean firstGroupEmpty2;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        String str;
        String str2;
        String str3;
        int index;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$forEachIndexed$iv, "attrGroups");
        Composer $composer3 = $composer.startRestartGroup(-1834944391);
        ComposerKt.sourceInformation($composer3, "C(AttrTable)N(attrGroups,scale,modifier)122@4685L6,116@4491L4572:DetailDescComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance($this$forEachIndexed$iv) ? 4 : 2;
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
                ComposerKt.traceEventStart(-1834944391, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.AttrTable (DetailDescComponent.kt:115)");
            }
            Modifier modifier$iv = ClipKt.clip(BorderKt.border-xT4_qwU(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(0.5d, scale), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_light-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale))), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale)));
            boolean z3 = false;
            Composer $composer$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            Composer $composer$iv$iv2 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            Composer $composer$iv$iv$iv2 = $composer$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv2.startReusableNode();
            if ($composer$iv$iv$iv2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer$iv$iv$iv2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer$iv$iv$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv2);
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv4 = $composer$iv$iv$iv2;
            boolean z4 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1851708827, "C:DetailDescComponent.kt#o90vz8");
            List<DetailDescFloor.ItemsAttrGroup> $this$none$iv2 = $this$forEachIndexed$iv;
            if (($this$none$iv2 instanceof Collection) && $this$none$iv2.isEmpty()) {
                firstGroupEmpty = true;
            } else {
                Iterator it2 = $this$none$iv2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        firstGroupEmpty = true;
                        break;
                    }
                    Object element$iv = it2.next();
                    DetailDescFloor.ItemsAttrGroup it3 = (DetailDescFloor.ItemsAttrGroup) element$iv;
                    String attrGroupName = it3.getAttrGroupName();
                    if (attrGroupName != null) {
                        if (attrGroupName.length() > 0) {
                            $this$none$iv = $this$none$iv2;
                            z2 = true;
                        } else {
                            $this$none$iv = $this$none$iv2;
                            z2 = false;
                        }
                        it = it2;
                        if (z2) {
                            z = true;
                            if (!z) {
                                firstGroupEmpty = false;
                                break;
                            } else {
                                $this$none$iv2 = $this$none$iv;
                                it2 = it;
                            }
                        }
                    } else {
                        $this$none$iv = $this$none$iv2;
                        it = it2;
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            $composer4.startReplaceGroup(910101882);
            String str6 = "";
            ComposerKt.sourceInformation($composer4, "");
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DetailDescFloor.ItemsAttrGroup group = (DetailDescFloor.ItemsAttrGroup) item$iv;
                int groupIndex = index$iv;
                List attrs = group.getItemsAttrs();
                if (attrs == null) {
                    attrs = CollectionsKt.emptyList();
                }
                Modifier materialized$iv$iv2 = materialized$iv$iv;
                $composer4.startReplaceGroup(910105189);
                ComposerKt.sourceInformation($composer4, "*130@5105L3928");
                Iterable $this$forEachIndexed$iv2 = attrs;
                int index$iv3 = 0;
                for (Object item$iv2 : $this$forEachIndexed$iv2) {
                    int index$iv4 = index$iv3 + 1;
                    if (index$iv3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    AttrListItem attr = (AttrListItem) item$iv2;
                    Iterable $this$forEachIndexed$iv3 = $this$forEachIndexed$iv2;
                    boolean z5 = z3;
                    boolean z6 = z4;
                    Modifier modifier$iv2 = IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), IntrinsicSize.Min);
                    Composer $composer$iv5 = $composer4;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                    Composer $composer5 = $composer3;
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv2 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str4);
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer$iv5.getCurrentCompositionLocalMap();
                    Composer $composer$iv6 = $composer$iv3;
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv2);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    Composer $composer$iv$iv3 = $composer$iv$iv2;
                    Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str5);
                    if (!($composer$iv5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv5.startReusableNode();
                    if ($composer$iv5.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv7;
                        $composer$iv5.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv7;
                        $composer$iv5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv5);
                    Composer $composer$iv7 = $composer$iv4;
                    Composer $composer6 = $composer4;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i6 = ((6 >> 6) & 112) | 6;
                    RowScope $this$AttrTable_u24lambda_u240_u241_u240_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -670925877, "C180@7495L6,181@7586L6,176@7319L801,200@8491L6,194@8173L842:DetailDescComponent.kt#o90vz8");
                    if (firstGroupEmpty) {
                        firstGroupEmpty2 = firstGroupEmpty;
                        $composer$iv$iv = $composer$iv5;
                        $composer$iv$iv$iv = $composer$iv5;
                        $composer$iv = $composer$iv5;
                        $composer$iv2 = $composer$iv5;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str2 = str5;
                        str3 = str4;
                        index = index$iv3;
                        $composer$iv5.startReplaceGroup(-676357295);
                    } else {
                        $composer$iv5.startReplaceGroup(-670958955);
                        ComposerKt.sourceInformation($composer$iv5, str6);
                        index = index$iv3;
                        if (index == 0) {
                            firstGroupEmpty2 = firstGroupEmpty;
                            $composer$iv5.startReplaceGroup(-670951546);
                            ComposerKt.sourceInformation($composer$iv5, "143@5677L6,139@5454L723");
                            Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(m464borderRight4WTKRHQ(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(60, scale)), BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU()), 0.0f, 1, (Object) null);
                            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                            $composer$iv = $composer$iv5;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv3 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str4);
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer$iv5.getCurrentCompositionLocalMap();
                            $composer$iv$iv = $composer$iv5;
                            $composer$iv$iv$iv = $composer$iv5;
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv3);
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            $composer$iv2 = $composer$iv5;
                            str3 = str4;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str5);
                            if (!($composer$iv5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv5.startReusableNode();
                            if ($composer$iv5.getInserting()) {
                                factory$iv$iv$iv5 = factory$iv$iv$iv8;
                                $composer$iv5.createNode(factory$iv$iv$iv5);
                            } else {
                                factory$iv$iv$iv5 = factory$iv$iv$iv8;
                                $composer$iv5.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv5);
                            str2 = str5;
                            str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i8 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 716883058, "C149@6017L6,150@6085L9,147@5887L260:DetailDescComponent.kt#o90vz8");
                            String attrGroupName2 = group.getAttrGroupName();
                            TextKt.Text-Nvy7gAk(attrGroupName2 == null ? str6 : attrGroupName2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv5, BiliTheme.$stable).getT12(), scale), $composer$iv5, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer$iv5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer$iv5.endReplaceGroup();
                        } else {
                            firstGroupEmpty2 = firstGroupEmpty;
                            $composer$iv$iv = $composer$iv5;
                            $composer$iv$iv$iv = $composer$iv5;
                            $composer$iv = $composer$iv5;
                            $composer$iv2 = $composer$iv5;
                            str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                            str2 = str5;
                            str3 = str4;
                            $composer$iv5.startReplaceGroup(-670164890);
                            ComposerKt.sourceInformation($composer$iv5, str6);
                            if (index == CollectionsKt.getLastIndex(attrs)) {
                                $composer$iv5.startReplaceGroup(-670121242);
                                ComposerKt.sourceInformation($composer$iv5, "159@6562L6,160@6648L6,155@6303L459");
                                SpacerKt.Spacer(SizeKt.fillMaxHeight$default(m464borderRight4WTKRHQ(m466drawBottomLinemxwnekA$default(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(60, scale)), false, BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU(), 1, null), BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU()), 0.0f, 1, (Object) null), $composer$iv5, 0);
                                $composer$iv5.endReplaceGroup();
                            } else {
                                $composer$iv5.startReplaceGroup(-669599667);
                                ComposerKt.sourceInformation($composer$iv5, "168@7074L6,164@6832L356");
                                SpacerKt.Spacer(SizeKt.fillMaxHeight$default(m464borderRight4WTKRHQ(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(60, scale)), BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU()), 0.0f, 1, (Object) null), $composer$iv5, 0);
                                $composer$iv5.endReplaceGroup();
                            }
                            $composer$iv5.endReplaceGroup();
                        }
                    }
                    $composer$iv5.endReplaceGroup();
                    Modifier modifier$iv4 = SizeKt.fillMaxHeight$default(PaddingKt.padding-VpY3zN4(m466drawBottomLinemxwnekA$default(m464borderRight4WTKRHQ(RowScope.-CC.weight$default($this$AttrTable_u24lambda_u240_u241_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU()), false, BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU(), 1, null), ProvideUiScaleKt.dpScaled(8, scale), ProvideUiScaleKt.dpScaled(8, scale)), 0.0f, 1, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenterStart();
                    String str7 = str;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, str7);
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    String str8 = str6;
                    String str9 = str3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str9);
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer$iv5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv4);
                    Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    String str10 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str10);
                    if (!($composer$iv5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv5.startReusableNode();
                    if ($composer$iv5.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv9;
                        $composer$iv5.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv9;
                        $composer$iv5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i10 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 286896266, "C188@7984L6,189@8044L9,186@7872L226:DetailDescComponent.kt#o90vz8");
                    String attrName = attr.getAttrName();
                    TextKt.Text-Nvy7gAk(attrName == null ? str8 : attrName, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv5, BiliTheme.$stable).getT12(), scale), $composer$iv5, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    $composer$iv5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    int groupIndex2 = groupIndex;
                    Modifier modifier$iv5 = SizeKt.fillMaxHeight$default(PaddingKt.padding-VpY3zN4(m465drawBottomLinemxwnekA(RowScope.-CC.weight$default($this$AttrTable_u24lambda_u240_u241_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), (groupIndex2 == CollectionsKt.getLastIndex($this$forEachIndexed$iv) && index == CollectionsKt.getLastIndex(attrs)) ? false : true, BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getLine_light-0d7_KjU()), ProvideUiScaleKt.dpScaled(8, scale), ProvideUiScaleKt.dpScaled(8, scale)), 0.0f, 1, (Object) null);
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenterStart();
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, str7);
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv5 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str9);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer$iv5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int groupIndex3 = $changed$iv$iv5 << 6;
                    int $changed$iv$iv$iv5 = (groupIndex3 & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str10);
                    if (!($composer$iv5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv5.startReusableNode();
                    if ($composer$iv5.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv10;
                        $composer$iv5.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv10;
                        $composer$iv5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i12 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 2066485854, "C207@8879L6,208@8939L9,205@8778L215:DetailDescComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(attr.getDisplay(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv5, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv5, BiliTheme.$stable).getT12(), scale), $composer$iv5, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    $composer$iv5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    index$iv3 = index$iv4;
                    z3 = z5;
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv3;
                    z4 = z6;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    $composer3 = $composer5;
                    $composer$iv3 = $composer$iv6;
                    $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                    $composer$iv$iv2 = $composer$iv$iv3;
                    $composer4 = $composer6;
                    $composer$iv4 = $composer$iv7;
                    str6 = str8;
                    groupIndex = groupIndex2;
                    firstGroupEmpty = firstGroupEmpty2;
                    str4 = str9;
                    str5 = str10;
                }
                $composer4.endReplaceGroup();
                index$iv = index$iv2;
                materialized$iv$iv = materialized$iv$iv2;
            }
            Composer $composer7 = $composer4;
            $composer2 = $composer3;
            Composer $composer$iv$iv$iv4 = $composer$iv$iv$iv2;
            $composer7.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv$iv$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AttrTable$lambda$1;
                    AttrTable$lambda$1 = DetailDescComponentKt.AttrTable$lambda$1($this$forEachIndexed$iv, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AttrTable$lambda$1;
                }
            });
        }
    }

    /* renamed from: borderRight-4WTKRHQ  reason: not valid java name */
    public static final Modifier m464borderRight4WTKRHQ(Modifier $this$borderRight_u2d4WTKRHQ, final long j) {
        Intrinsics.checkNotNullParameter($this$borderRight_u2d4WTKRHQ, "$this$borderRight");
        return $this$borderRight_u2d4WTKRHQ.then(DrawModifierKt.drawBehind(Modifier.Companion, new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit borderRight_4WTKRHQ$lambda$0;
                borderRight_4WTKRHQ$lambda$0 = DetailDescComponentKt.borderRight_4WTKRHQ$lambda$0(j, (DrawScope) obj);
                return borderRight_4WTKRHQ$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit borderRight_4WTKRHQ$lambda$0(long j, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        float strokeWidth = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float x = Float.intBitsToFloat(bits$iv$iv$iv) - (strokeWidth / 2);
        long v1$iv$iv = Float.floatToRawIntBits(x);
        long v2$iv$iv = Float.floatToRawIntBits(0.0f);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        long v1$iv$iv2 = Float.floatToRawIntBits(x);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawBehind, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        return Unit.INSTANCE;
    }

    /* renamed from: drawBottomLine-mxwnekA$default  reason: not valid java name */
    public static /* synthetic */ Modifier m466drawBottomLinemxwnekA$default(Modifier modifier, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return m465drawBottomLinemxwnekA(modifier, z, j);
    }

    /* renamed from: drawBottomLine-mxwnekA  reason: not valid java name */
    public static final Modifier m465drawBottomLinemxwnekA(Modifier $this$drawBottomLine_u2dmxwnekA, boolean shouldDraw, final long j) {
        Modifier drawBehind;
        Intrinsics.checkNotNullParameter($this$drawBottomLine_u2dmxwnekA, "$this$drawBottomLine");
        if (!shouldDraw) {
            drawBehind = (Modifier) Modifier.Companion;
        } else {
            drawBehind = DrawModifierKt.drawBehind(Modifier.Companion, new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit drawBottomLine_mxwnekA$lambda$0;
                    drawBottomLine_mxwnekA$lambda$0 = DetailDescComponentKt.drawBottomLine_mxwnekA$lambda$0(j, (DrawScope) obj);
                    return drawBottomLine_mxwnekA$lambda$0;
                }
            });
        }
        return $this$drawBottomLine_u2dmxwnekA.then(drawBehind);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawBottomLine_mxwnekA$lambda$0(long j, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        float strokeWidth = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float y = Float.intBitsToFloat(bits$iv$iv$iv) - (strokeWidth / 2);
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(y);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(y);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawBehind, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02a5, code lost:
        if (r4.intValue() != 2) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02a7, code lost:
        r4 = r41.getContent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02ad, code lost:
        if (r4 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02b3, code lost:
        if (r4.length() != 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b6, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02b8, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02b9, code lost:
        if (r4 != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02bb, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d6, code lost:
        if (r43.intValue() != 1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01e4, code lost:
        if (r3.intValue() != 2) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e6, code lost:
        r3 = r41.getContent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ec, code lost:
        if (r3 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01f2, code lost:
        if (r3.length() != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01f5, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f7, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f8, code lost:
        if (r3 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01fa, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0297, code lost:
        if (r4 != 1) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ItemsContentsComponent(final List<DetailDescFloor.Content> list, final Function3<? super List<String>, ? super Integer, ? super List<Pair<Float, Float>>, Unit> function3, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        String str;
        Iterator it;
        String str2;
        Composer $composer$iv$iv$iv;
        int i2;
        int i3;
        int i4;
        Modifier materialized$iv$iv;
        int $changed$iv$iv$iv;
        double d;
        MeasurePolicy measurePolicy$iv$iv;
        Modifier modifier$iv$iv;
        Intrinsics.checkNotNullParameter(list, "contents");
        Intrinsics.checkNotNullParameter(function3, "onImagePreview");
        Composer $composer2 = $composer.startRestartGroup(-1494662420);
        ComposerKt.sourceInformation($composer2, "C(ItemsContentsComponent)N(contents,onImagePreview,scale,modifier)261@10334L3976:DetailDescComponent.kt#o90vz8");
        int currentMarker = $composer2.getCurrentMarker();
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(scale) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1494662420, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ItemsContentsComponent (DetailDescComponent.kt:260)");
            }
            int $changed$iv = ($dirty2 >> 9) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv2 = modifier$iv;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv2);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
            Composer $composer$iv$iv$iv2 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv2.startReusableNode();
            if ($composer$iv$iv$iv2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv$iv$iv2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv$iv$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv2);
            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            Composer $composer$iv = $composer$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = (($changed$iv >> 6) & 112) | 6;
            $composer$iv.startReplaceGroup(-908101647);
            ComposerKt.sourceInformation($composer$iv, "C:DetailDescComponent.kt#o90vz8");
            List<DetailDescFloor.Content> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Iterable $this$filter$iv2 = $this$filter$iv;
                DetailDescFloor.Content it2 = (DetailDescFloor.Content) element$iv$iv;
                Integer type = it2.getType();
                Composer $composer$iv2 = $composer$iv;
                if (type == null) {
                    modifier$iv$iv = modifier$iv$iv2;
                } else {
                    modifier$iv$iv = modifier$iv$iv2;
                }
                Integer type2 = it2.getType();
                if (type2 != null) {
                }
                boolean z = false;
                if (z) {
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = $this$filter$iv2;
                $composer$iv = $composer$iv2;
                modifier$iv$iv2 = modifier$iv$iv;
            }
            Composer $composer$iv3 = $composer$iv;
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterator it3 = $this$map$iv.iterator();
            while (true) {
                str = "";
                if (!it3.hasNext()) {
                    break;
                }
                Object item$iv$iv = it3.next();
                String content = ((DetailDescFloor.Content) item$iv$iv).getContent();
                if (content != null) {
                    str = content;
                }
                destination$iv$iv2.add(str);
            }
            final List contentImages = (List) destination$iv$iv2;
            List<DetailDescFloor.Content> $this$filter$iv3 = list;
            boolean z2 = false;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv3) {
                Iterable $this$filter$iv4 = $this$filter$iv3;
                DetailDescFloor.Content it4 = (DetailDescFloor.Content) element$iv$iv2;
                Integer type3 = it4.getType();
                boolean z3 = z2;
                if (type3 == null) {
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                } else {
                    int $i$f$filter = type3.intValue();
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                }
                Integer type4 = it4.getType();
                if (type4 != null) {
                }
                boolean z4 = false;
                if (z4) {
                    destination$iv$iv3.add(element$iv$iv2);
                }
                $this$filter$iv3 = $this$filter$iv4;
                z2 = z3;
                measurePolicy$iv$iv2 = measurePolicy$iv$iv;
            }
            Iterable $this$map$iv2 = (List) destination$iv$iv3;
            int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
            Collection destination$iv$iv4 = new ArrayList($i$f$map);
            Iterable $this$mapTo$iv$iv = $this$map$iv2;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                DetailDescFloor.Content it5 = (DetailDescFloor.Content) item$iv$iv2;
                Double width = it5.getWidth();
                double d2 = 0.0d;
                if (width != null) {
                    materialized$iv$iv = materialized$iv$iv2;
                    $changed$iv$iv$iv = $changed$iv$iv$iv2;
                    d = width.doubleValue();
                } else {
                    materialized$iv$iv = materialized$iv$iv2;
                    $changed$iv$iv$iv = $changed$iv$iv$iv2;
                    d = 0.0d;
                }
                float width2 = (float) d;
                Double height = it5.getHeight();
                if (height != null) {
                    d2 = height.doubleValue();
                }
                Iterable $this$map$iv3 = $this$map$iv2;
                float height2 = (float) d2;
                destination$iv$iv4.add(new Pair(Float.valueOf(width2), Float.valueOf(height2)));
                currentMarker = currentMarker;
                $this$map$iv2 = $this$map$iv3;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                materialized$iv$iv2 = materialized$iv$iv;
                $changed$iv$iv$iv2 = $changed$iv$iv$iv;
            }
            int $changed$iv$iv$iv3 = currentMarker;
            final List contentImageSizes = (List) destination$iv$iv4;
            $composer$iv.startReplaceGroup(-444916564);
            ComposerKt.sourceInformation($composer$iv, "");
            List<DetailDescFloor.Content> $this$forEach$iv = list;
            Iterator it6 = $this$forEach$iv.iterator();
            while (it6.hasNext()) {
                Object element$iv = it6.next();
                DetailDescFloor.Content content2 = (DetailDescFloor.Content) element$iv;
                Integer type5 = content2.getType();
                if (type5 != null && type5.intValue() == 0) {
                    $composer$iv.startReplaceGroup(-366609299);
                    ComposerKt.sourceInformation($composer$iv, "283@11186L6,284@11242L9,281@11084L289");
                    String content3 = content2.getContent();
                    TextKt.Text-Nvy7gAk(content3 == null ? str : content3, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT13(), scale), $composer$iv, 0, 0, 131064);
                    $composer$iv.endReplaceGroup();
                    it = it6;
                    str2 = str;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    i2 = $changed$iv$iv$iv3;
                } else if ((type5 != null && type5.intValue() == 1) || (type5 != null && type5.intValue() == 2)) {
                    $composer$iv.startReplaceGroup(-366200037);
                    ComposerKt.sourceInformation($composer$iv, "301@11959L16,304@12145L7,308@12329L7,323@13118L178,327@13343L868,312@12522L1712");
                    String content4 = content2.getContent();
                    if (content4 == null || content4.length() == 0) {
                        $composer$iv.endReplaceGroup();
                        it = it6;
                        str2 = str;
                        $composer$iv$iv$iv = $composer$iv$iv$iv2;
                        i2 = $changed$iv$iv$iv3;
                    } else {
                        String imageUrl = HelperKt.customizedImageUrl(content2.getContent());
                        Number width3 = content2.getWidth();
                        if (width3 == null) {
                            i3 = 0;
                            width3 = 0;
                        } else {
                            i3 = 0;
                        }
                        float contentWidth = width3.floatValue();
                        Number height3 = content2.getHeight();
                        if (height3 == null) {
                            height3 = Integer.valueOf(i3);
                        }
                        float contentHeight = height3.floatValue();
                        if (((int) contentHeight) == 0) {
                            i4 = $changed$iv$iv$iv3;
                        } else if (((int) contentWidth) == 0) {
                            i4 = $changed$iv$iv$iv3;
                        } else {
                            it = it6;
                            float screenWidth = ScreenKt.getScreenWidth($composer$iv, 0);
                            float other$iv = contentHeight / contentWidth;
                            float other$iv2 = Dp.constructor-impl(screenWidth * other$iv);
                            str2 = str;
                            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                            i2 = $changed$iv$iv$iv3;
                            $composer$iv$iv$iv = $composer$iv$iv$iv2;
                            ComposerKt.sourceInformationMarkerStart($composer$iv, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer$iv.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            Density $this$ItemsContentsComponent_u24lambda_u240_u244_u241 = (Density) consume;
                            int contentWidthPixel = MathKt.roundToInt($this$ItemsContentsComponent_u24lambda_u240_u244_u241.toPx-0680j_4(screenWidth));
                            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer$iv, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer$iv.consume(this_$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            Density $this$ItemsContentsComponent_u24lambda_u240_u244_u242 = (Density) consume2;
                            int contentHeightPixel = MathKt.roundToInt($this$ItemsContentsComponent_u24lambda_u240_u244_u242.toPx-0680j_4(other$iv2));
                            final int imageIndex = contentImages.indexOf(content2.getContent());
                            String $this$asRequest$iv = HelperKt.customizedImageUrl(imageUrl);
                            ImageRequest $this$ItemsContentsComponent_u24lambda_u240_u244_u243 = new ImageRequest($this$asRequest$iv);
                            $this$ItemsContentsComponent_u24lambda_u240_u244_u243.m1493requestWidth3VbuI34(Pixel.m1517constructorimpl(contentWidthPixel));
                            $this$ItemsContentsComponent_u24lambda_u240_u244_u243.m1488requestHeight3VbuI34(Pixel.m1517constructorimpl(contentHeightPixel));
                            $this$ItemsContentsComponent_u24lambda_u240_u244_u243.contentScale(ContentScale.Companion.getFillWidth());
                            ImmutableImageRequest build = $this$ItemsContentsComponent_u24lambda_u240_u244_u243.build();
                            Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), contentWidth / contentHeight, false, 2, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer$iv, -565950458, "CC(remember):DetailDescComponent.kt#9igjgp");
                            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer2.changedInstance(contentImages) | $composer2.changed(imageIndex) | $composer2.changedInstance(contentImageSizes);
                            Object it$iv = $composer$iv.rememberedValue();
                            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda11
                                    public final Object invoke() {
                                        Unit ItemsContentsComponent$lambda$0$4$4$0;
                                        ItemsContentsComponent$lambda$0$4$4$0 = DetailDescComponentKt.ItemsContentsComponent$lambda$0$4$4$0(function3, contentImages, imageIndex, contentImageSizes);
                                        return ItemsContentsComponent$lambda$0$4$4$0;
                                    }
                                };
                                $composer$iv.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(aspectRatio$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1109212174, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda12
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit ItemsContentsComponent$lambda$0$4$5;
                                    ItemsContentsComponent$lambda$0$4$5 = DetailDescComponentKt.ItemsContentsComponent$lambda$0$4$5(scale, (Composer) obj, ((Integer) obj2).intValue());
                                    return ItemsContentsComponent$lambda$0$4$5;
                                }
                            }, $composer$iv, 54), null, $composer$iv, 12582912, 380);
                            $composer$iv.endReplaceGroup();
                        }
                        $composer$iv.endToMarker(i4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda10
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit ItemsContentsComponent$lambda$0$4$0;
                                    ItemsContentsComponent$lambda$0$4$0 = DetailDescComponentKt.ItemsContentsComponent$lambda$0$4$0(list, function3, scale, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return ItemsContentsComponent$lambda$0$4$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                } else {
                    $composer$iv.startReplaceGroup(-363449748);
                    $composer$iv.endReplaceGroup();
                    it = it6;
                    str2 = str;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    i2 = $changed$iv$iv$iv3;
                }
                it6 = it;
                str = str2;
                $changed$iv$iv$iv3 = i2;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
            }
            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
            $composer$iv.endReplaceGroup();
            $composer$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit ItemsContentsComponent$lambda$1;
                    ItemsContentsComponent$lambda$1 = DetailDescComponentKt.ItemsContentsComponent$lambda$1(list, function3, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ItemsContentsComponent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsContentsComponent$lambda$0$4$4$0(Function3 $onImagePreview, List $contentImages, int $imageIndex, List $contentImageSizes) {
        $onImagePreview.invoke($contentImages, Integer.valueOf($imageIndex), $contentImageSizes);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsContentsComponent$lambda$0$4$5(float $scale, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C332@13583L6,328@13373L812:DetailDescComponent.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1109212174, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ItemsContentsComponent.<anonymous>.<anonymous>.<anonymous> (DetailDescComponent.kt:328)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer, -1084495035, "C336@13794L29,337@13878L6,335@13729L426:DetailDescComponent.kt#o90vz8");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getBrandtv_defaultimage_fill_100($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(40, $scale)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 48, 0);
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

    /* JADX WARN: Code restructure failed: missing block: B:152:0x01dd, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x02f9, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L101;
     */
    /* renamed from: ImageWithDynamicRatio-Q4leyOY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m463ImageWithDynamicRatioQ4leyOY(final String imageUrl, Modifier modifier, int i, ContentScale contentScale, boolean useRaw, Float presetRatio, Pixel requestWidth, Pixel requestHeight, Function2<? super Composer, ? super Integer, Unit> function2, Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        int i3;
        ContentScale contentScale2;
        boolean useRaw2;
        Float presetRatio2;
        Pixel requestWidth2;
        Pixel requestHeight2;
        Function2 loadingPlaceHolder;
        Function4 failedPlaceHolder;
        Modifier modifier3;
        int i4;
        ContentScale contentScale3;
        boolean useRaw3;
        final Float presetRatio3;
        Pixel requestHeight3;
        Function2 loadingPlaceHolder2;
        Function4 failedPlaceHolder2;
        int i5;
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Composer $composer2 = $composer.startRestartGroup(-848499586);
        ComposerKt.sourceInformation($composer2, "C(ImageWithDynamicRatio)N(imageUrl,modifier,quality:kntr.base.imageloader.Quality,contentScale,useRaw,presetRatio,requestWidth:kntr.base.imageloader.Pixel,requestHeight:kntr.base.imageloader.Pixel,loadingPlaceHolder,failedPlaceHolder)369@14912L111,373@15077L93,402@16046L1003,377@15176L1880:DetailDescComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(imageUrl) ? 4 : 2;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(i) ? 256 : 128;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(contentScale) ? 2048 : 1024;
        }
        int i9 = i2 & 16;
        if (i9 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(useRaw) ? 16384 : 8192;
        }
        int i10 = i2 & 32;
        if (i10 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer2.changed(presetRatio) ? 131072 : 65536;
        }
        int i11 = i2 & 64;
        if (i11 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(requestWidth) ? 1048576 : 524288;
        }
        int i12 = i2 & 128;
        if (i12 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(requestHeight) ? 8388608 : 4194304;
        }
        int i13 = i2 & 256;
        if (i13 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 67108864 : 33554432;
        }
        int i14 = i2 & 512;
        if (i14 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (!$composer2.shouldExecute(($dirty & 306783379) != 306783378, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            i3 = i;
            contentScale2 = contentScale;
            useRaw2 = useRaw;
            presetRatio2 = presetRatio;
            requestWidth2 = requestWidth;
            requestHeight2 = requestHeight;
            loadingPlaceHolder = function2;
            failedPlaceHolder = function4;
        } else {
            if (i6 != 0) {
                modifier3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            } else {
                modifier3 = modifier;
            }
            if (i7 == 0) {
                i4 = i;
            } else {
                i4 = Quality.m1542constructorimpl(85);
            }
            if (i8 == 0) {
                contentScale3 = contentScale;
            } else {
                contentScale3 = ContentScale.Companion.getCrop();
            }
            if (i9 == 0) {
                useRaw3 = useRaw;
            } else {
                useRaw3 = false;
            }
            if (i10 == 0) {
                presetRatio3 = presetRatio;
            } else {
                presetRatio3 = null;
            }
            if (i11 == 0) {
                requestWidth2 = requestWidth;
            } else {
                requestWidth2 = null;
            }
            if (i12 == 0) {
                requestHeight3 = requestHeight;
            } else {
                requestHeight3 = null;
            }
            if (i13 == 0) {
                loadingPlaceHolder2 = function2;
            } else {
                loadingPlaceHolder2 = null;
            }
            if (i14 == 0) {
                failedPlaceHolder2 = function4;
            } else {
                failedPlaceHolder2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-848499586, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.ImageWithDynamicRatio (DetailDescComponent.kt:366)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 635702669, "CC(remember):DetailDescComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty & 458752) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(presetRatio3 != null ? presetRatio3.floatValue() : 1.0f);
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            final MutableFloatState imageRatio = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 635707931, "CC(remember):DetailDescComponent.kt#9igjgp");
            Object value$iv2 = $composer2.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(presetRatio3 != null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
            }
            final MutableState hasLoaded = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String $this$asRequest$iv = HelperKt.customizedImageUrl(imageUrl);
            ImageRequest $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242 = new ImageRequest($this$asRequest$iv);
            $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242.contentScale(contentScale3);
            $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242.m1491requestQualityAc6X4_Q(i4);
            $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242.useRaw(useRaw3);
            if (requestWidth2 == null) {
                i5 = i4;
            } else {
                i5 = i4;
                $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242.m1493requestWidth3VbuI34(requestWidth2.m1522unboximpl());
            }
            if (requestHeight3 != null) {
                $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242.m1488requestHeight3VbuI34(requestHeight3.m1522unboximpl());
            }
            ImmutableImageRequest build = $this$ImageWithDynamicRatio_Q4leyOY_u24lambda_u242.build();
            Function2 m434getLambda$2126148540$product_details_page_debug = loadingPlaceHolder2 == null ? ComposableSingletons$DetailDescComponentKt.INSTANCE.m434getLambda$2126148540$product_details_page_debug() : loadingPlaceHolder2;
            Function4 m435getLambda$570053922$product_details_page_debug = failedPlaceHolder2 == null ? ComposableSingletons$DetailDescComponentKt.INSTANCE.m435getLambda$570053922$product_details_page_debug() : failedPlaceHolder2;
            Pixel requestHeight4 = requestHeight3;
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(AspectRatioKt.aspectRatio$default(modifier3, imageRatio.getValue().floatValue(), false, 2, (Object) null), !((Boolean) hasLoaded.getValue()).booleanValue() ? ColorKt.Color(4294572537L) : Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 635739849, "CC(remember):DetailDescComponent.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(imageRatio) | ((458752 & $dirty) == 131072);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit ImageWithDynamicRatio_Q4leyOY$lambda$3$0;
                    ImageWithDynamicRatio_Q4leyOY$lambda$3$0 = DetailDescComponentKt.ImageWithDynamicRatio_Q4leyOY$lambda$3$0(presetRatio3, imageRatio, hasLoaded, (ImageState) obj);
                    return ImageWithDynamicRatio_Q4leyOY$lambda$3$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv2 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliImageKt.BiliImage(build, modifier4, null, (Function1) it$iv2, null, null, null, m434getLambda$2126148540$product_details_page_debug, m435getLambda$570053922$product_details_page_debug, $composer2, 0, 116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i3 = i5;
            requestHeight2 = requestHeight4;
            modifier2 = modifier3;
            loadingPlaceHolder = loadingPlaceHolder2;
            failedPlaceHolder = failedPlaceHolder2;
            contentScale2 = contentScale3;
            useRaw2 = useRaw3;
            presetRatio2 = presetRatio3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final int i15 = i3;
            final ContentScale contentScale4 = contentScale2;
            final boolean z = useRaw2;
            final Float f = presetRatio2;
            final Pixel pixel = requestWidth2;
            final Pixel pixel2 = requestHeight2;
            final Function2 function22 = loadingPlaceHolder;
            final Function4 function42 = failedPlaceHolder;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageWithDynamicRatio_Q4leyOY$lambda$4;
                    ImageWithDynamicRatio_Q4leyOY$lambda$4 = DetailDescComponentKt.ImageWithDynamicRatio_Q4leyOY$lambda$4(imageUrl, modifier5, i15, contentScale4, z, f, pixel, pixel2, function22, function42, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageWithDynamicRatio_Q4leyOY$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageWithDynamicRatio_Q4leyOY$lambda$3$0(Float $presetRatio, MutableFloatState $imageRatio, MutableState $hasLoaded, ImageState state) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ImageState.Success) {
            long imageSize = ImageKt.getSize(((ImageState.Success) state).getSource());
            int bits$iv$iv$iv = (int) (imageSize >> 32);
            if (Float.intBitsToFloat(bits$iv$iv$iv) > 0.0f) {
                int bits$iv$iv$iv2 = (int) (imageSize & 4294967295L);
                if (Float.intBitsToFloat(bits$iv$iv$iv2) > 0.0f) {
                    if ($presetRatio == null) {
                        bool = true;
                        int bits$iv$iv$iv3 = (int) (imageSize >> 32);
                        int bits$iv$iv$iv4 = (int) (imageSize & 4294967295L);
                        float calculatedRatio = Float.intBitsToFloat(bits$iv$iv$iv3) / Float.intBitsToFloat(bits$iv$iv$iv4);
                        $imageRatio.setValue(calculatedRatio <= 0.0f ? 1.0f : calculatedRatio);
                    } else {
                        bool = true;
                    }
                    $hasLoaded.setValue(bool);
                }
            }
            bool = true;
            $hasLoaded.setValue(bool);
        } else if (state instanceof ImageState.Error) {
            $hasLoaded.setValue(true);
        }
        return Unit.INSTANCE;
    }

    public static final void DefaultImagePlaceHolder(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1546583494);
        ComposerKt.sourceInformation($composer2, "C(DefaultImagePlaceHolder)434@17117L82:DetailDescComponent.kt#o90vz8");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1546583494, $changed, -1, "kntr.app.mall.product.details.page.ui.components.DefaultImagePlaceHolder (DetailDescComponent.kt:433)");
            }
            BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit DefaultImagePlaceHolder$lambda$0;
                    DefaultImagePlaceHolder$lambda$0 = DetailDescComponentKt.DefaultImagePlaceHolder$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DefaultImagePlaceHolder$lambda$0;
                }
            });
        }
    }
}