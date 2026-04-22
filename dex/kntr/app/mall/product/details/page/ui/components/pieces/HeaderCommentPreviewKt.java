package kntr.app.mall.product.details.page.ui.components.pieces;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt;
import kntr.app.mall.product.details.page.ui.components.PaddingCardKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.ConstsKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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
import kotlin.reflect.KFunction;

/* compiled from: HeaderCommentPreview.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"HeaderCommentPreview", "", "commentData", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HeaderCommentPreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderCommentPreview$lambda$6(CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HeaderCommentPreview(commentInfoData, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void HeaderCommentPreview(final CommentInfoApiService.CommentInfoResponse.CommentInfoData commentData, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        final String countString;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(commentData, "commentData");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(1910713394);
        ComposerKt.sourceInformation($composer3, "C(HeaderCommentPreview)N(commentData,pageViewModel,modifier)72@3265L16,75@3320L8241:HeaderCommentPreview.kt#v057zd");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(commentData) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(pageViewModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $dirty = $dirty2;
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
                ComposerKt.traceEventStart(1910713394, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreview (HeaderCommentPreview.kt:51)");
            }
            Iterable combinedList = commentData.getCombinedCommentList$product_details_page_debug();
            Iterable $this$filter$iv = combinedList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) element$iv$iv;
                Byte score = it.getScore();
                if ((score != null ? score.byteValue() : (byte) 0) >= 0) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable goodCommentList = (List) destination$iv$iv;
            Iterable<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> $this$flatMap$iv = goodCommentList;
            Collection destination$iv$iv2 = new ArrayList();
            for (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it2 : $this$flatMap$iv) {
                Iterable imgs = it2.getImgs();
                if (imgs == null) {
                    imgs = CollectionsKt.emptyList();
                }
                Iterable list$iv$iv = imgs;
                CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
            }
            final List allImages = (List) destination$iv$iv2;
            Iterable $this$filter$iv2 = goodCommentList;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it3 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) element$iv$iv2;
                List<String> imgs2 = it3.getImgs();
                if ((imgs2 != null ? imgs2.size() : 0) > 0) {
                    destination$iv$iv3.add(element$iv$iv2);
                }
            }
            final List imageComments = (List) destination$iv$iv3;
            Iterable $this$filter$iv3 = goodCommentList;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it4 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) element$iv$iv3;
                List<String> imgs3 = it4.getImgs();
                if ((imgs3 != null ? imgs3.size() : 0) == 0) {
                    destination$iv$iv4.add(element$iv$iv3);
                }
            }
            final List noImageComments = (List) destination$iv$iv4;
            Long totalCount = commentData.getTotalCount();
            long count = totalCount != null ? totalCount.longValue() : 0L;
            if (count < 10) {
                countString = "";
            } else if (count < 100) {
                countString = String.valueOf(count);
            } else if (count < 1000) {
                countString = (count / 100) + "00+";
            } else if (count < 10000) {
                countString = (count / ((long) MediaAttrUtils.TYPE_PAY_SEASON)) + "000+";
            } else {
                countString = (count / 10000) + "万+";
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            final float scale = HeaderCommentPreview$lambda$4(scaleModel$delegate).getScale();
            Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            $dirty = $dirty2;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((48 >> 6) & 112) | 6;
            BoxScope $this$HeaderCommentPreview_u24lambda_u245 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 323693066, "C81@3458L512,97@3980L510,130@5068L6487,114@4500L7055:HeaderCommentPreview.kt#v057zd");
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4291879167L)), Color.box-impl(ColorKt.Color(4294961137L))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 6);
            Modifier modifier$iv2 = SizeKt.size-3ABfNKs($this$HeaderCommentPreview_u24lambda_u245.align(Modifier.Companion, Alignment.Companion.getTopEnd()), ProvideUiScaleKt.dpScaled((int) ConstsKt.DEFAULT_UI_SCREEN_WIDTH, scale));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1655522076, "C103@4150L330:HeaderCommentPreview.kt#v057zd");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl("http://i0.hdslb.com/bfs/kfptfe/floor/56a868130063c74255a98b52786cf80efd68838d.png");
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer3, 48, 508);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PaddingCardKt.PaddingCard(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), PaddingKt.PaddingValues-a9UjIt4$default(ProvideUiScaleKt.dpScaled(8, scale), ProvideUiScaleKt.dpScaled(9, scale), ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 8, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(8, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(1451068243, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreviewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit HeaderCommentPreview$lambda$5$1;
                    HeaderCommentPreview$lambda$5$1 = HeaderCommentPreviewKt.HeaderCommentPreview$lambda$5$1(scale, countString, pageViewModel, allImages, imageComments, noImageComments, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return HeaderCommentPreview$lambda$5$1;
                }
            }, $composer3, 54), $composer3, 24582, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreviewKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeaderCommentPreview$lambda$6;
                    HeaderCommentPreview$lambda$6 = HeaderCommentPreviewKt.HeaderCommentPreview$lambda$6(CommentInfoApiService.CommentInfoResponse.CommentInfoData.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HeaderCommentPreview$lambda$6;
                }
            });
        }
    }

    private static final UiScaleModel HeaderCommentPreview$lambda$4(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0d30  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0a40  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0a5e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0b8e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0b97  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0bbb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit HeaderCommentPreview$lambda$5$1(float $scale, String $countString, final PageViewModel $pageViewModel, List $allImages, List $imageComments, List $noImageComments, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 value$iv;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv$iv2;
        MeasurePolicy measurePolicy$iv$iv;
        Modifier materialized$iv$iv;
        Composer $composer$iv$iv$iv;
        String str;
        final PageViewModel pageViewModel;
        Function0 factory$iv$iv$iv4;
        Function0 value$iv2;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C131@5082L6463:HeaderCommentPreview.kt#v057zd");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1451068243, $changed, -1, "kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreview.<anonymous>.<anonymous> (HeaderCommentPreview.kt:131)");
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
            Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 909402149, "C134@5174L1896,177@7087L4444:HeaderCommentPreview.kt#v057zd");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            Modifier materialized$iv$iv3 = materialized$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((438 >> 6) & 112) | 6;
            RowScope $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1984201965, "C143@5551L6,141@5449L419,151@5889L27,156@6126L109,152@5937L1115:HeaderCommentPreview.kt#v057zd");
            TextKt.Text-Nvy7gAk("大家都在晒（" + $countString + "）", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer, 0, 0, 131066);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$HeaderCommentPreview_u24lambda_u245_u241_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer, 0);
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(36, $scale), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1033817670, "CC(remember):HeaderCommentPreview.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($pageViewModel);
            Object it$iv = $composer.rememberedValue();
            if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                String str2 = "CC(remember):HeaderCommentPreview.kt#9igjgp";
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer$iv$iv = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer.useNode();
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer.createNode(factory$iv$iv$iv3);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1206561775, "C163@6450L6,164@6510L9,161@6357L207,167@6646L28,168@6721L6,166@6589L441:HeaderCommentPreview.kt#v057zd");
                TextKt.Text-Nvy7gAk("全部", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $scale), $composer, 6, 0, 131066);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, $scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, $scale)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 48, 0);
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
                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(12, $scale), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv4 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer$iv$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                Modifier modifier$iv$iv = modifier$iv4;
                Composer $composer$iv = $composer$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv.startReusableNode();
                if ($composer$iv$iv.getInserting()) {
                    $composer$iv$iv.useNode();
                } else {
                    $composer$iv$iv.createNode(factory$iv$iv$iv8);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv$iv);
                Function0 factory$iv$iv$iv9 = factory$iv$iv$iv8;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1742364099, "C183@7304L4209:HeaderCommentPreview.kt#v057zd");
                Composer $composer$iv2 = $composer$iv$iv;
                Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, Alignment.Companion.getStart(), $composer$iv$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv5 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer$iv$iv.getCurrentCompositionLocalMap();
                Composer $composer$iv3 = $composer$iv$iv;
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                $composer$iv$iv2 = $composer$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv2.startReusableNode();
                if ($composer$iv$iv2.getInserting()) {
                    $composer$iv$iv2.useNode();
                } else {
                    $composer$iv$iv2.createNode(factory$iv$iv$iv10);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv$iv2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                CompositionLocalMap localMap$iv$iv6 = localMap$iv$iv5;
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i10 = ((6 >> 6) & 112) | 6;
                Composer $composer2 = $composer$iv$iv2;
                Composer $composer$iv4 = $composer$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, -19848489, "C228@9821L6,226@9726L440,236@10191L42:HeaderCommentPreview.kt#v057zd");
                if ($allImages.size() < 4) {
                    $composer2.startReplaceGroup(-19879955);
                    ComposerKt.sourceInformation($composer2, "189@7577L6,187@7475L475,197@7979L42,199@8114L1489,224@9632L43");
                    TextKt.Text-Nvy7gAk("晒图秀", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer2, 6, 0, 131066);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, $scale)), $composer2, 0);
                    final List takenImages = CollectionsKt.take($allImages, 4);
                    measurePolicy$iv$iv = measurePolicy$iv5;
                    materialized$iv$iv = materialized$iv$iv7;
                    $composer$iv$iv$iv = $composer$iv$iv2;
                    Modifier modifier$iv6 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    boolean z = true;
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                    int $changed$iv = ((6 >> 3) & 14) | ((6 >> 3) & 112);
                    MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer2, $changed$iv);
                    int $changed$iv$iv6 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv7 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer2, modifier$iv6);
                    Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer2.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
                    boolean z2 = false;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i12 = ((6 >> 6) & 112) | 6;
                    RowScope $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1878889109, "C:HeaderCommentPreview.kt#v057zd");
                    $composer2.startReplaceGroup(60609698);
                    ComposerKt.sourceInformation($composer2, "*215@9140L156,204@8403L932");
                    List $this$forEachIndexed$iv = takenImages;
                    boolean z3 = false;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String img = (String) item$iv;
                        final int index = index$iv;
                        Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        String imgUrl = HelperKt.customizedImageUrl(img);
                        boolean z4 = z3;
                        ImmutableImageRequest build = new ImageRequest(imgUrl).contentScale(ContentScale.Companion.getFillWidth()).build();
                        boolean z5 = z;
                        int $changed$iv$iv$iv7 = $changed$iv$iv$iv6;
                        Modifier materialized$iv$iv9 = materialized$iv$iv8;
                        boolean z6 = z2;
                        Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(AspectRatioKt.aspectRatio$default(RowScope.-CC.weight$default($this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, $scale))), Color.Companion.getLightGray-0d7_KjU(), (Shape) null, 2, (Object) null);
                        String str3 = str2;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1316078982, str3);
                        boolean invalid$iv2 = $composer2.changedInstance($pageViewModel) | $composer2.changedInstance(takenImages) | $composer2.changed(index);
                        Object it$iv2 = $composer2.rememberedValue();
                        if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                            value$iv2 = it$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer2, 0, 508);
                            if (index == takenImages.size() - 1) {
                                $composer2.startReplaceGroup(2144006900);
                                ComposerKt.sourceInformation($composer2, "220@9449L52");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, $scale)), $composer2, 0);
                            } else {
                                $composer2.startReplaceGroup(2134670072);
                            }
                            $composer2.endReplaceGroup();
                            str2 = str3;
                            materialized$iv$iv8 = materialized$iv$iv9;
                            index$iv = index$iv2;
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            z3 = z4;
                            z = z5;
                            $changed$iv$iv$iv6 = $changed$iv$iv$iv7;
                            z2 = z6;
                        }
                        value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreviewKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit HeaderCommentPreview$lambda$5$1$0$1$0$0$0$0$0;
                                HeaderCommentPreview$lambda$5$1$0$1$0$0$0$0$0 = HeaderCommentPreviewKt.HeaderCommentPreview$lambda$5$1$0$1$0$0$0$0$0(PageViewModel.this, takenImages, index);
                                return HeaderCommentPreview$lambda$5$1$0$1$0$0$0$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer2, 0, 508);
                        if (index == takenImages.size() - 1) {
                        }
                        $composer2.endReplaceGroup();
                        str2 = str3;
                        materialized$iv$iv8 = materialized$iv$iv9;
                        index$iv = index$iv2;
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        z3 = z4;
                        z = z5;
                        $changed$iv$iv$iv6 = $changed$iv$iv$iv7;
                        z2 = z6;
                    }
                    str = str2;
                    pageViewModel = $pageViewModel;
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scale)), $composer2, 0);
                } else {
                    measurePolicy$iv$iv = measurePolicy$iv5;
                    materialized$iv$iv = materialized$iv$iv7;
                    $composer$iv$iv$iv = $composer$iv$iv2;
                    str = str2;
                    pageViewModel = $pageViewModel;
                    $composer2.startReplaceGroup(-27336323);
                }
                $composer2.endReplaceGroup();
                TextKt.Text-Nvy7gAk("同好讨论", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer2, 6, 0, 131066);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, $scale)), $composer2, 0);
                List $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u241 = new ArrayList();
                $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u241.addAll($imageComments);
                $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u241.addAll($noImageComments);
                Iterable takenComments = $allImages.size() < 4 ? CollectionsKt.take($this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u241, 1) : CollectionsKt.take($this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u241, 2);
                $composer2.startReplaceGroup(2077673992);
                ComposerKt.sourceInformation($composer2, "*258@11354L33,255@11170L129,252@10997L468");
                int index$iv3 = 0;
                for (Object item$iv2 : takenComments) {
                    int index$iv4 = index$iv3 + 1;
                    if (index$iv3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel model = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) item$iv2;
                    if (index$iv3 != 0) {
                        $composer2.startReplaceGroup(1309187685);
                        ComposerKt.sourceInformation($composer2, "250@10895L43");
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scale)), $composer2, 0);
                    } else {
                        $composer2.startReplaceGroup(1298409264);
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart($composer2, 319342227, str);
                    boolean invalid$iv3 = $composer2.changedInstance(pageViewModel);
                    Composer $this$cache$iv = $composer2;
                    Object it$iv3 = $this$cache$iv.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = (KFunction) new HeaderCommentPreviewKt$HeaderCommentPreview$1$2$1$2$1$2$1$1(pageViewModel);
                        $this$cache$iv.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    Function3 function3 = (KFunction) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, 319336435, str);
                    boolean invalid$iv4 = $composer2.changedInstance(pageViewModel);
                    Composer $this$cache$iv2 = $composer2;
                    Object it$iv4 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreviewKt$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj) {
                                Unit HeaderCommentPreview$lambda$5$1$0$1$0$2$1$0;
                                HeaderCommentPreview$lambda$5$1$0$1$0$2$1$0 = HeaderCommentPreviewKt.HeaderCommentPreview$lambda$5$1$0$1$0$2$1$0(PageViewModel.this, (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) obj);
                                return HeaderCommentPreview$lambda$5$1$0$1$0$2$1$0;
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function0 factory$iv$iv$iv12 = factory$iv$iv$iv9;
                    Composer $composer3 = $composer$iv$iv;
                    Composer $composer4 = $composer$iv$iv2;
                    CompositionLocalMap localMap$iv$iv8 = localMap$iv$iv6;
                    Composer $composer5 = $composer2;
                    CommentFloorComponentKt.SingleCommentComponent(model, (Function1) it$iv4, function3, $scale, null, true, $composer5, 196608, 16);
                    index$iv3 = index$iv4;
                    modifier$iv$iv = modifier$iv$iv;
                    str = str;
                    $composer2 = $composer5;
                    measurePolicy$iv$iv = measurePolicy$iv$iv;
                    $composer$iv3 = $composer$iv3;
                    localMap$iv$iv6 = localMap$iv$iv8;
                    $composer$iv4 = $composer$iv4;
                    $composer$iv = $composer$iv;
                    $composer$iv$iv2 = $composer4;
                    $composer$iv$iv = $composer3;
                    factory$iv$iv$iv9 = factory$iv$iv$iv12;
                    horizontalAlignment$iv2 = horizontalAlignment$iv2;
                    materialized$iv$iv = materialized$iv$iv;
                    $composer$iv2 = $composer$iv2;
                    materialized$iv$iv3 = materialized$iv$iv3;
                }
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                Composer $composer6 = $composer2;
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreviewKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit HeaderCommentPreview$lambda$5$1$0$0$0$0;
                    HeaderCommentPreview$lambda$5$1$0$0$0$0 = HeaderCommentPreviewKt.HeaderCommentPreview$lambda$5$1$0$0$0$0(PageViewModel.this);
                    return HeaderCommentPreview$lambda$5$1$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv32 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
            String str22 = "CC(remember):HeaderCommentPreview.kt#9igjgp";
            MeasurePolicy measurePolicy$iv32 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv32 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer, modifier$iv32);
            Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
            $composer$iv$iv = $composer;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv32 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i62 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1206561775, "C163@6450L6,164@6510L9,161@6357L207,167@6646L28,168@6721L6,166@6589L441:HeaderCommentPreview.kt#v057zd");
            TextKt.Text-Nvy7gAk("全部", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $scale), $composer, 6, 0, 131066);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, $scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, $scale)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 48, 0);
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
            Modifier modifier$iv42 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(12, $scale), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv42 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv42 = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv42);
            Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
            Modifier modifier$iv$iv2 = modifier$iv42;
            Composer $composer$iv5 = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv.getApplier() instanceof Applier)) {
            }
            $composer$iv$iv.startReusableNode();
            if ($composer$iv$iv.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer$iv$iv);
            Function0 factory$iv$iv$iv92 = factory$iv$iv$iv82;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
            int i72 = ($changed$iv$iv$iv42 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i82 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1742364099, "C183@7304L4209:HeaderCommentPreview.kt#v057zd");
            Composer $composer$iv22 = $composer$iv$iv;
            Modifier modifier$iv52 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv52 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, Alignment.Companion.getStart(), $composer$iv$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv52 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer$iv$iv.getCurrentCompositionLocalMap();
            Composer $composer$iv32 = $composer$iv$iv;
            Modifier materialized$iv$iv72 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv52);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
            $composer$iv$iv2 = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
            }
            $composer$iv$iv2.startReusableNode();
            if ($composer$iv$iv2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer$iv$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            CompositionLocalMap localMap$iv$iv62 = localMap$iv$iv52;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv72, ComposeUiNode.Companion.getSetModifier());
            int i92 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
            int i102 = ((6 >> 6) & 112) | 6;
            Composer $composer22 = $composer$iv$iv2;
            Composer $composer$iv42 = $composer$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer22, -19848489, "C228@9821L6,226@9726L440,236@10191L42:HeaderCommentPreview.kt#v057zd");
            if ($allImages.size() < 4) {
            }
            $composer22.endReplaceGroup();
            TextKt.Text-Nvy7gAk("同好讨论", (Modifier) null, BiliTheme.INSTANCE.getColors($composer22, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer22, 6, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, $scale)), $composer22, 0);
            List $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u2412 = new ArrayList();
            $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u2412.addAll($imageComments);
            $this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u2412.addAll($noImageComments);
            Iterable takenComments2 = $allImages.size() < 4 ? CollectionsKt.take($this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u2412, 1) : CollectionsKt.take($this$HeaderCommentPreview_u24lambda_u245_u241_u240_u241_u240_u2412, 2);
            $composer22.startReplaceGroup(2077673992);
            ComposerKt.sourceInformation($composer22, "*258@11354L33,255@11170L129,252@10997L468");
            int index$iv32 = 0;
            while (r24.hasNext()) {
            }
            Composer $composer$iv$iv$iv22 = $composer$iv$iv$iv;
            Composer $composer62 = $composer22;
            $composer62.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer62);
            ComposerKt.sourceInformationMarkerEnd($composer$iv42);
            $composer$iv$iv$iv22.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv22);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv22);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderCommentPreview$lambda$5$1$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleGoToCommentList$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderCommentPreview$lambda$5$1$0$1$0$0$0$0$0(PageViewModel $pageViewModel, List $takenImages, int $index) {
        PageViewModel.updateImagePreview$product_details_page_debug$default($pageViewModel, $takenImages, $index, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderCommentPreview$lambda$5$1$0$1$0$2$1$0(PageViewModel $pageViewModel, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        $pageViewModel.handleGoToCommentDetail$product_details_page_debug(comment);
        return Unit.INSTANCE;
    }
}