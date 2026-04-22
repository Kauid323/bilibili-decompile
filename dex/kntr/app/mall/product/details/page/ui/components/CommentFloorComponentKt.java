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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.model.CommentFloor;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
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

/* compiled from: CommentFloorComponent.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001aI\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001aC\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u001a\u001a\u007f\u0010\u001b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u001d28\u0010\u001e\u001a4\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0004\u0012\u00020 \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120!0\u000f\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\u0010$\u001aC\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00102\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010+\u001a7\u0010,\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010/\u001a\u0017\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102H\u0000¢\u0006\u0002\u00103¨\u00064²\u0006\n\u00105\u001a\u000206X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020 X\u008a\u008e\u0002"}, d2 = {"CommentFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ManyImagesCommentComponent", "comment", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "images", "", "", "scale", "", "innerSpacing", "Landroidx/compose/ui/unit/Dp;", "ManyImagesCommentComponent-WH-ejsw", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Ljava/util/List;FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CommentsComponent", "imagesComments", "noImageComments", "(Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SingleCommentComponent", "onCommentDetail", "Lkotlin/Function1;", "updateImagePreview", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "showImage", "", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "UserInfoComponent", "avatarUrl", "userName", "tagText", "score", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TagListComponent", "tags", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$SubTagModel;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Ljava/util/List;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "parseDoubleCount", "count", "", "(Ljava/lang/Double;)Ljava/lang/String;", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "maxVisible"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommentFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentFloorComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CommentFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentFloorComponent$lambda$1(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CommentFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentFloorComponent$lambda$7(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CommentFloorComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentsComponent$lambda$2(List list, List list2, PageViewModelWrapper pageViewModelWrapper, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CommentsComponent(list, list2, pageViewModelWrapper, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ManyImagesCommentComponent_WH_ejsw$lambda$1(CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel, PageViewModelWrapper pageViewModelWrapper, List list, float f, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m426ManyImagesCommentComponentWHejsw(commentModel, pageViewModelWrapper, list, f, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleCommentComponent$lambda$2(CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel, Function1 function1, Function3 function3, float f, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        SingleCommentComponent(commentModel, function1, function3, f, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TagListComponent$lambda$0(PageViewModelWrapper pageViewModelWrapper, List list, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TagListComponent(pageViewModelWrapper, list, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TagListComponent$lambda$7(PageViewModelWrapper pageViewModelWrapper, List list, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TagListComponent(pageViewModelWrapper, list, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserInfoComponent$lambda$1(String str, String str2, String str3, Byte b, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        UserInfoComponent(str, str2, str3, b, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CommentFloorComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        List combinedList;
        List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentTag> tags;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentTag commentTag;
        Long totalCount;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(-357768285);
        ComposerKt.sourceInformation($composer3, "C(CommentFloorComponent)N(module,pageViewModel,modifier)83@3806L16,85@3882L25,96@4250L6507,87@3913L6844:CommentFloorComponent.kt#o90vz8");
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
                ComposerKt.traceEventStart(-357768285, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CommentFloorComponent (CommentFloorComponent.kt:63)");
            }
            if (module instanceof ContentModule.CommentModule) {
                CommentInfoApiService.CommentInfoResponse.CommentInfoData commentData = ((ContentModule.CommentModule) module).getCommentApiData();
                final CommentFloor productApiData = ((ContentModule.CommentModule) module).getProductApiData();
                if (!(commentData != null && commentData.shouldShowComment$product_details_page_debug())) {
                    if (!(productApiData != null ? Intrinsics.areEqual(productApiData.getShowPreBuyComment(), true) : false)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit CommentFloorComponent$lambda$1;
                                    CommentFloorComponent$lambda$1 = CommentFloorComponentKt.CommentFloorComponent$lambda$1(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return CommentFloorComponent$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                final boolean showCommentGuide = productApiData != null ? Intrinsics.areEqual(productApiData.getShowPreBuyComment(), true) : false;
                if (commentData == null || (combinedList = commentData.getCombinedCommentList$product_details_page_debug()) == null) {
                    combinedList = CollectionsKt.emptyList();
                }
                final long count = (commentData == null || (totalCount = commentData.getTotalCount()) == null) ? 0L : totalCount.longValue();
                List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> $this$flatMap$iv = combinedList;
                Collection destination$iv$iv = new ArrayList();
                for (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it : $this$flatMap$iv) {
                    Iterable imgs = it.getImgs();
                    if (imgs == null) {
                        imgs = CollectionsKt.emptyList();
                    }
                    Iterable list$iv$iv = imgs;
                    CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                }
                final List allImages = (List) destination$iv$iv;
                List $this$filter$iv = combinedList;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it2 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) element$iv$iv;
                    List<String> imgs2 = it2.getImgs();
                    if ((imgs2 != null ? imgs2.size() : 0) > 0) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                final List imageComments = (List) destination$iv$iv2;
                List $this$filter$iv2 = combinedList;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel it3 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) element$iv$iv2;
                    List<String> imgs3 = it3.getImgs();
                    if ((imgs3 != null ? imgs3.size() : 0) == 0) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                }
                final List noImageComments = (List) destination$iv$iv3;
                final List subTags = (commentData == null || (tags = commentData.getTags()) == null || (commentTag = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentTag) CollectionsKt.firstOrNull(tags)) == null) ? null : commentTag.getSubTags();
                State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                final float scale = CommentFloorComponent$lambda$5(scaleModel$delegate).getScale();
                final CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
                $composer2 = $composer3;
                PaddingCardKt.PaddingCard(modifier3, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(1185273768, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit CommentFloorComponent$lambda$6;
                        CommentFloorComponent$lambda$6 = CommentFloorComponentKt.CommentFloorComponent$lambda$6(PageViewModel.this, scale, subTags, allImages, imageComments, noImageComments, showCommentGuide, productApiData, collectorHolder, count, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return CommentFloorComponent$lambda$6;
                    }
                }, $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | 24576, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CommentFloorComponent$lambda$0;
                            CommentFloorComponent$lambda$0 = CommentFloorComponentKt.CommentFloorComponent$lambda$0(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return CommentFloorComponent$lambda$0;
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
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommentFloorComponent$lambda$7;
                    CommentFloorComponent$lambda$7 = CommentFloorComponentKt.CommentFloorComponent$lambda$7(ContentModule.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CommentFloorComponent$lambda$7;
                }
            });
        }
    }

    private static final UiScaleModel CommentFloorComponent$lambda$5(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -92
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit CommentFloorComponent$lambda$6(kntr.app.mall.product.details.page.vm.PageViewModel r158, float r159, java.util.List r160, java.util.List r161, java.util.List r162, java.util.List r163, boolean r164, kntr.app.mall.product.details.page.api.model.CommentFloor r165, kntr.app.mall.product.details.page.ui.components.CollectorHolder r166, long r167, androidx.compose.foundation.layout.BoxScope r169, androidx.compose.runtime.Composer r170, int r171) {
        /*
            Method dump skipped, instructions count: 2900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt.CommentFloorComponent$lambda$6(kntr.app.mall.product.details.page.vm.PageViewModel, float, java.util.List, java.util.List, java.util.List, java.util.List, boolean, kntr.app.mall.product.details.page.api.model.CommentFloor, kntr.app.mall.product.details.page.ui.components.CollectorHolder, long, androidx.compose.foundation.layout.BoxScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentFloorComponent$lambda$6$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleGoToCommentList$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentFloorComponent$lambda$6$0$1$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleCommentPublishGuideClick$product_details_page_debug();
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_CREATECOMMENT_0_CLICK, null, true, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentFloorComponent$lambda$6$0$2$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_CREATECOMMENT_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* renamed from: ManyImagesCommentComponent-WH-ejsw  reason: not valid java name */
    public static final void m426ManyImagesCommentComponentWHejsw(final CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment, final PageViewModelWrapper pageViewModelWrapper, final List<String> list, final float scale, final float f, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer4 = $composer.startRestartGroup(-762708174);
        ComposerKt.sourceInformation($composer4, "C(ManyImagesCommentComponent)N(comment,pageViewModelWrapper,images,scale,innerSpacing:c#ui.unit.Dp,modifier)256@11054L1656:CommentFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(comment) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModelWrapper) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(list) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(scale) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changed(f) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if (($changed & 196608) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-762708174, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ManyImagesCommentComponent (CommentFloorComponent.kt:254)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            Composer $composer5 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer5, -1395337814, "C261@11151L1233,299@12633L33,296@12509L89,293@12393L311:CommentFloorComponent.kt#o90vz8");
            Modifier modifier5 = modifier4;
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(12, scale), 7, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            RowScope $this$ManyImagesCommentComponent_WH_ejsw_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            $composer5.startReplaceGroup(-336813444);
            ComposerKt.sourceInformation($composer5, "C:CommentFloorComponent.kt#o90vz8");
            final List takenImages = list != null ? CollectionsKt.take(list, 4) : null;
            List list2 = takenImages;
            if (list2 == null || list2.isEmpty()) {
                $composer5.endReplaceGroup();
                $composer3 = $composer5;
            } else {
                $composer5.startReplaceGroup(958970901);
                ComposerKt.sourceInformation($composer5, "*284@12086L116,273@11569L652");
                Iterable $this$forEachIndexed$iv = takenImages;
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
                    Modifier materialized$iv$iv3 = materialized$iv$iv2;
                    ImmutableImageRequest build = new ImageRequest(imgUrl).contentScale(ContentScale.Companion.getFillWidth()).build();
                    RowScope $this$ManyImagesCommentComponent_WH_ejsw_u24lambda_u240_u2402 = $this$ManyImagesCommentComponent_WH_ejsw_u24lambda_u240_u240;
                    Composer $composer6 = $composer5;
                    boolean z2 = z;
                    Modifier modifier6 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(AspectRatioKt.aspectRatio$default(RowScope.-CC.weight$default($this$ManyImagesCommentComponent_WH_ejsw_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), Color.Companion.getLightGray-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 381537830, "CC(remember):CommentFloorComponent.kt#9igjgp");
                    boolean invalid$iv = $composer5.changedInstance(pageViewModel) | $composer5.changedInstance(takenImages) | $composer5.changed(index);
                    Object it$iv = $composer5.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit ManyImagesCommentComponent_WH_ejsw$lambda$0$0$0$0$0;
                                ManyImagesCommentComponent_WH_ejsw$lambda$0$0$0$0$0 = CommentFloorComponentKt.ManyImagesCommentComponent_WH_ejsw$lambda$0$0$0$0$0(PageViewModel.this, takenImages, index);
                                return ManyImagesCommentComponent_WH_ejsw$lambda$0$0$0$0$0;
                            }
                        };
                        $composer5.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), null, null, null, null, null, null, null, $composer5, 0, 508);
                    if (index != takenImages.size() - 1) {
                        $composer5.startReplaceGroup(-1057044551);
                        ComposerKt.sourceInformation($composer5, "289@12295L47");
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, f), $composer5, 0);
                    } else {
                        $composer5.startReplaceGroup(-1069223056);
                    }
                    $composer5.endReplaceGroup();
                    z = z2;
                    $composer5 = $composer6;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    materialized$iv$iv2 = materialized$iv$iv3;
                    $this$ManyImagesCommentComponent_WH_ejsw_u24lambda_u240_u240 = $this$ManyImagesCommentComponent_WH_ejsw_u24lambda_u240_u2402;
                }
                $composer3 = $composer5;
                $composer5.endReplaceGroup();
                $composer5.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Composer $composer7 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer7, -1846080311, "CC(remember):CommentFloorComponent.kt#9igjgp");
            boolean invalid$iv2 = $composer7.changedInstance(pageViewModel);
            Object it$iv2 = $composer7.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (KFunction) new CommentFloorComponentKt$ManyImagesCommentComponent$1$2$1(pageViewModel);
                $composer7.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function3 function3 = (KFunction) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerStart($composer7, -1846084223, "CC(remember):CommentFloorComponent.kt#9igjgp");
            boolean invalid$iv3 = $composer7.changedInstance(pageViewModel);
            Object it$iv3 = $composer7.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit ManyImagesCommentComponent_WH_ejsw$lambda$0$2$0;
                        ManyImagesCommentComponent_WH_ejsw$lambda$0$2$0 = CommentFloorComponentKt.ManyImagesCommentComponent_WH_ejsw$lambda$0$2$0(PageViewModel.this, (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) obj);
                        return ManyImagesCommentComponent_WH_ejsw$lambda$0$2$0;
                    }
                };
                $composer7.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer7);
            modifier3 = modifier5;
            SingleCommentComponent(comment, (Function1) it$iv3, function3, scale, null, false, $composer7, ($dirty2 & 14) | 196608 | ($dirty2 & 7168), 16);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit ManyImagesCommentComponent_WH_ejsw$lambda$1;
                    ManyImagesCommentComponent_WH_ejsw$lambda$1 = CommentFloorComponentKt.ManyImagesCommentComponent_WH_ejsw$lambda$1(CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.this, pageViewModelWrapper, list, scale, f, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ManyImagesCommentComponent_WH_ejsw$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ManyImagesCommentComponent_WH_ejsw$lambda$0$0$0$0$0(PageViewModel $pageViewModel, List $takenImages, int $index) {
        PageViewModel.updateImagePreview$product_details_page_debug$default($pageViewModel, $takenImages, $index, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ManyImagesCommentComponent_WH_ejsw$lambda$0$2$0(PageViewModel $pageViewModel, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        $pageViewModel.handleGoToCommentDetail$product_details_page_debug(comment);
        return Unit.INSTANCE;
    }

    public static final void CommentsComponent(final List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> list, final List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel> list2, final PageViewModelWrapper pageViewModelWrapper, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Iterable $this$forEachIndexed$iv;
        List takenList;
        Object value$iv;
        boolean invalid$iv;
        Intrinsics.checkNotNullParameter(list, "imagesComments");
        Intrinsics.checkNotNullParameter(list2, "noImageComments");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(-892614352);
        ComposerKt.sourceInformation($composer3, "C(CommentsComponent)N(imagesComments,noImageComments,pageViewModelWrapper,scale,modifier)320@13188L625:CommentFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 256 : 128;
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
        if ($composer3.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-892614352, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.CommentsComponent (CommentFloorComponent.kt:312)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            List $this$CommentsComponent_u24lambda_u240 = new ArrayList();
            $this$CommentsComponent_u24lambda_u240.addAll(list);
            $this$CommentsComponent_u24lambda_u240.addAll(list2);
            List takenList2 = CollectionsKt.take($this$CommentsComponent_u24lambda_u240, 2);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            Composer $composer$iv$iv = $composer$iv;
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
            $composer2 = $composer3;
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
            Composer $composer4 = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, -786534637, "C:CommentFloorComponent.kt#o90vz8");
            $composer4.startReplaceGroup(1221554214);
            ComposerKt.sourceInformation($composer4, "*335@13718L33,332@13582L97,329@13450L347");
            List $this$forEachIndexed$iv2 = takenList2;
            boolean z = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv2) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel commentModel = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) item$iv;
                int index = index$iv;
                if (index > 0) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    $composer4.startReplaceGroup(-642992444);
                    ComposerKt.sourceInformation($composer4, "327@13380L43");
                    takenList = takenList2;
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer4, 0);
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    takenList = takenList2;
                    $composer4.startReplaceGroup(-656250865);
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart($composer4, 1918932308, "CC(remember):CommentFloorComponent.kt#9igjgp");
                boolean invalid$iv2 = $composer4.changedInstance(pageViewModel);
                Composer $this$cache$iv = $composer4;
                boolean z2 = z;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                    value$iv = it$iv;
                    Function3 function3 = (KFunction) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1918928020, "CC(remember):CommentFloorComponent.kt#9igjgp");
                    invalid$iv = $composer4.changedInstance(pageViewModel);
                    Composer $this$cache$iv2 = $composer4;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    Object it$iv2 = $this$cache$iv2.rememberedValue();
                    if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Composer $composer5 = $composer4;
                        SingleCommentComponent(commentModel, (Function1) it$iv2, function3, scale, null, true, $composer5, ($dirty & 7168) | 196608, 16);
                        $composer$iv = $composer$iv;
                        verticalArrangement$iv = verticalArrangement$iv;
                        index$iv = index$iv2;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        takenList2 = takenList;
                        z = z2;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        $composer$iv$iv = $composer$iv$iv;
                        horizontalAlignment$iv = horizontalAlignment$iv;
                        localMap$iv$iv2 = localMap$iv$iv2;
                        $composer4 = $composer5;
                    }
                    Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj) {
                            Unit CommentsComponent$lambda$1$0$1$0;
                            CommentsComponent$lambda$1$0$1$0 = CommentFloorComponentKt.CommentsComponent$lambda$1$0$1$0(PageViewModel.this, (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) obj);
                            return CommentsComponent$lambda$1$0$1$0;
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Composer $composer52 = $composer4;
                    SingleCommentComponent(commentModel, (Function1) it$iv2, function3, scale, null, true, $composer52, ($dirty & 7168) | 196608, 16);
                    $composer$iv = $composer$iv;
                    verticalArrangement$iv = verticalArrangement$iv;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    takenList2 = takenList;
                    z = z2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    $composer$iv$iv = $composer$iv$iv;
                    horizontalAlignment$iv = horizontalAlignment$iv;
                    localMap$iv$iv2 = localMap$iv$iv2;
                    $composer4 = $composer52;
                }
                value$iv = (KFunction) new CommentFloorComponentKt$CommentsComponent$1$1$1$1(pageViewModel);
                $this$cache$iv.updateRememberedValue(value$iv);
                Function3 function32 = (KFunction) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, 1918928020, "CC(remember):CommentFloorComponent.kt#9igjgp");
                invalid$iv = $composer4.changedInstance(pageViewModel);
                Composer $this$cache$iv22 = $composer4;
                MeasurePolicy measurePolicy$iv$iv22 = measurePolicy$iv$iv;
                Object it$iv22 = $this$cache$iv22.rememberedValue();
                if (!invalid$iv) {
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Composer $composer522 = $composer4;
                    SingleCommentComponent(commentModel, (Function1) it$iv22, function32, scale, null, true, $composer522, ($dirty & 7168) | 196608, 16);
                    $composer$iv = $composer$iv;
                    verticalArrangement$iv = verticalArrangement$iv;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    takenList2 = takenList;
                    z = z2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv22;
                    $composer$iv$iv = $composer$iv$iv;
                    horizontalAlignment$iv = horizontalAlignment$iv;
                    localMap$iv$iv2 = localMap$iv$iv2;
                    $composer4 = $composer522;
                }
                Object value$iv22 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit CommentsComponent$lambda$1$0$1$0;
                        CommentsComponent$lambda$1$0$1$0 = CommentFloorComponentKt.CommentsComponent$lambda$1$0$1$0(PageViewModel.this, (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel) obj);
                        return CommentsComponent$lambda$1$0$1$0;
                    }
                };
                $this$cache$iv22.updateRememberedValue(value$iv22);
                it$iv22 = value$iv22;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Composer $composer5222 = $composer4;
                SingleCommentComponent(commentModel, (Function1) it$iv22, function32, scale, null, true, $composer5222, ($dirty & 7168) | 196608, 16);
                $composer$iv = $composer$iv;
                verticalArrangement$iv = verticalArrangement$iv;
                index$iv = index$iv2;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                takenList2 = takenList;
                z = z2;
                measurePolicy$iv$iv = measurePolicy$iv$iv22;
                $composer$iv$iv = $composer$iv$iv;
                horizontalAlignment$iv = horizontalAlignment$iv;
                localMap$iv$iv2 = localMap$iv$iv2;
                $composer4 = $composer5222;
            }
            Composer $composer6 = $composer4;
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommentsComponent$lambda$2;
                    CommentsComponent$lambda$2 = CommentFloorComponentKt.CommentsComponent$lambda$2(list, list2, pageViewModelWrapper, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CommentsComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentsComponent$lambda$1$0$1$0(PageViewModel $pageViewModel, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        $pageViewModel.handleGoToCommentDetail$product_details_page_debug(comment);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0858  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SingleCommentComponent(final CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment, final Function1<? super CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel, Unit> function1, final Function3<? super List<String>, ? super Integer, ? super List<Pair<Float, Float>>, Unit> function3, final float scale, Modifier modifier, boolean showImage, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean showImage2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Composer $composer$iv$iv$iv;
        Composer $composer3;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(function1, "onCommentDetail");
        Intrinsics.checkNotNullParameter(function3, "updateImagePreview");
        Composer $composer4 = $composer.startRestartGroup(1406569277);
        ComposerKt.sourceInformation($composer4, "C(SingleCommentComponent)N(comment,onCommentDetail,updateImagePreview,scale,modifier,showImage)354@14182L64,351@14110L2701:CommentFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(comment) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            z = showImage;
        } else if ((196608 & $changed) == 0) {
            z = showImage;
            $dirty |= $composer4.changed(z) ? 131072 : 65536;
        } else {
            z = showImage;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                showImage2 = z;
            } else {
                showImage2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1406569277, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.SingleCommentComponent (CommentFloorComponent.kt:350)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -1201611971, "CC(remember):CommentFloorComponent.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer4.changedInstance(comment);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        Unit SingleCommentComponent$lambda$0$0;
                        SingleCommentComponent$lambda$0$0 = CommentFloorComponentKt.SingleCommentComponent$lambda$0$0(function1, comment);
                        return SingleCommentComponent$lambda$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            RowScope $this$SingleCommentComponent_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 232224893, "C358@14264L891:CommentFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$SingleCommentComponent_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1439847744, "C363@14377L443,378@14927L6,379@14975L9,376@14834L311:CommentFloorComponent.kt#o90vz8");
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userinfo = comment.getUserinfo();
            String str2 = (userinfo == null || (str2 = userinfo.getAvatar()) == null) ? "" : "";
            String uname = comment.getUname();
            if (!(uname == null || uname.length() == 0)) {
                str = comment.getUname();
            } else {
                CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userinfo2 = comment.getUserinfo();
                if (userinfo2 == null || (str = userinfo2.getUname()) == null) {
                    str = "";
                }
            }
            UserInfoComponent(str2, str, comment.getCrowdfundingDesc(), comment.getScore(), scale, null, $composer4, ($dirty2 << 3) & 57344, 32);
            String displayMessage = comment.getDisplayMessage();
            TextKt.Text-Nvy7gAk(displayMessage == null ? "" : displayMessage, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(28, scale), ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), scale), $composer4, 0, 24576, 114680);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (showImage2) {
                List<String> imgs = comment.getImgs();
                if ((imgs != null ? imgs.size() : 0) > 0) {
                    $composer4.startReplaceGroup(233136881);
                    ComposerKt.sourceInformation($composer4, "387@15276L1519");
                    List<String> imgs2 = comment.getImgs();
                    Intrinsics.checkNotNull(imgs2);
                    int imageCount = imgs2.size();
                    Modifier modifier$iv3 = ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(58, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale)));
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv3 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    $composer$iv$iv$iv = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer4.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i9 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$SingleCommentComponent_u24lambda_u241_u241 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -845420292, "C399@15786L123,394@15550L378:CommentFloorComponent.kt#o90vz8");
                    String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(comment.getImgs().get(0));
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit = Unit.INSTANCE;
                    ImmutableImageRequest build = imageRequest.build();
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1496755475, "CC(remember):CommentFloorComponent.kt#9igjgp");
                    boolean invalid$iv2 = (($dirty2 & 896) == 256) | $composer4.changedInstance(comment);
                    Object it$iv2 = $composer4.rememberedValue();
                    if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer4, 0, 508);
                        if (imageCount <= 1) {
                            $composer4.startReplaceGroup(-845020517);
                            ComposerKt.sourceInformation($composer4, "405@15988L775");
                            Modifier modifier$iv4 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4($this$SingleCommentComponent_u24lambda_u241_u241.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ProvideUiScaleKt.dpScaled(17, scale), ProvideUiScaleKt.dpScaled(14, scale)), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ProvideUiScaleKt.dpScaled(4, scale), 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 10, (Object) null)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null);
                            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                            int $changed$iv$iv4 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                                $composer4.createNode(factory$iv$iv$iv4);
                            } else {
                                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                            $composer2 = $composer4;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i11 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 300262840, "C417@16687L9,414@16529L212:CommentFloorComponent.kt#o90vz8");
                            TextKt.Text-Nvy7gAk("+" + (imageCount - 1), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), scale), $composer4, 384, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                        } else {
                            $composer2 = $composer4;
                            $composer4.startReplaceGroup(-860885046);
                        }
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceGroup();
                        $composer3 = $composer4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit SingleCommentComponent$lambda$1$1$0$0;
                            SingleCommentComponent$lambda$1$1$0$0 = CommentFloorComponentKt.SingleCommentComponent$lambda$1$1$0$0(function3, comment);
                            return SingleCommentComponent$lambda$1$1$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer4, 0, 508);
                    if (imageCount <= 1) {
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endReplaceGroup();
                    $composer3 = $composer4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
            $composer$iv$iv$iv = $composer4;
            $composer2 = $composer4;
            $composer3 = $composer4;
            $composer3.startReplaceGroup(217995241);
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showImage2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = showImage2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleCommentComponent$lambda$2;
                    SingleCommentComponent$lambda$2 = CommentFloorComponentKt.SingleCommentComponent$lambda$2(CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.this, function1, function3, scale, modifier4, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleCommentComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleCommentComponent$lambda$0$0(Function1 $onCommentDetail, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel $comment) {
        $onCommentDetail.invoke($comment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleCommentComponent$lambda$1$1$0$0(Function3 $updateImagePreview, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel $comment) {
        $updateImagePreview.invoke(CollectionsKt.listOf($comment.getImgs().get(0)), 0, CollectionsKt.emptyList());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x074f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void UserInfoComponent(final String avatarUrl, final String userName, final String tagText, final Byte score, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        String str;
        String str2;
        int $dirty2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Composer $composer4 = $composer.startRestartGroup(1007674954);
        ComposerKt.sourceInformation($composer4, "C(UserInfoComponent)N(avatarUrl,userName,tagText,score,scale,modifier)435@17005L3164:CommentFloorComponent.kt#o90vz8");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer4.changed(avatarUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer4.changed(userName) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer4.changed(tagText) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer4.changed(score) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty3 |= $composer4.changed(scale) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty3 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if (!$composer4.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1007674954, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.UserInfoComponent (CommentFloorComponent.kt:434)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty3 >> 15) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Modifier modifier4 = modifier3;
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$UserInfoComponent_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -2010743247, "C447@17455L6,439@17111L455,453@17640L6,454@17684L9,451@17575L363:CommentFloorComponent.kt#o90vz8");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(avatarUrl);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(0.5d, scale), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), null, null, null, null, null, null, null, $composer4, 0, 508);
            TextKt.Text-Nvy7gAk(userName, $this$UserInfoComponent_u24lambda_u240.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), scale), $composer4, ($dirty3 >> 3) & 14, 24960, 110584);
            String str3 = tagText;
            if (!(str3 == null || str3.length() == 0)) {
                $composer4.startReplaceGroup(-2009947044);
                ComposerKt.sourceInformation($composer4, "471@18301L6,464@17992L968");
                Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(16, scale)), ProvideUiScaleKt.dpScaled(0.5d, scale), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getPi3-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str2);
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                $composer2 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -1830754456, "C479@18654L6,476@18540L406:CommentFloorComponent.kt#o90vz8");
                int i7 = ($dirty3 >> 6) & 14;
                $composer3 = $composer4;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $dirty = $dirty3;
                $dirty2 = 6;
                TextKt.Text-Nvy7gAk(tagText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(11), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer4, i7, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $dirty = $dirty3;
                $composer2 = $composer4;
                $composer3 = $composer4;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $dirty2 = 6;
                $composer3.startReplaceGroup(-2027812964);
            }
            $composer3.endReplaceGroup();
            if (score != null) {
                int byteValue = score.byteValue();
                if (1 <= byteValue && byteValue < $dirty2) {
                    $composer3.startReplaceGroup(-2008912543);
                    ComposerKt.sourceInformation($composer3, "491@19030L1123");
                    Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled($dirty2, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    Composer $composer$iv = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv3 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str);
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str2);
                    if (!($composer$iv.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv.startReusableNode();
                    if ($composer$iv.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer$iv.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer$iv.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i9 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -743522312, "C:CommentFloorComponent.kt#o90vz8");
                    $composer$iv.startReplaceGroup(1915677577);
                    ComposerKt.sourceInformation($composer$iv, "*498@19286L22,500@19402L6,497@19233L406");
                    byte byteValue2 = score.byteValue();
                    int i10 = 0;
                    while (i10 < byteValue2) {
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getStar_favorite_fill_200($composer$iv, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(10, scale)), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer$iv, Painter.$stable | 48, 0);
                        i10++;
                        byteValue2 = byteValue2;
                        materialized$iv$iv3 = materialized$iv$iv3;
                    }
                    $composer$iv.endReplaceGroup();
                    $composer$iv.startReplaceGroup(1915693280);
                    ComposerKt.sourceInformation($composer$iv, "*510@19773L22,512@19889L6,509@19720L401");
                    int i11 = 0;
                    for (int byteValue3 = 5 - score.byteValue(); i11 < byteValue3; byteValue3 = byteValue3) {
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getStar_favorite_fill_500($composer$iv, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(10, scale)), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), $composer$iv, Painter.$stable | 48, 0);
                        i11++;
                    }
                    $composer$iv.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                }
            }
            $composer3.startReplaceGroup(-2027812964);
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit UserInfoComponent$lambda$1;
                    UserInfoComponent$lambda$1 = CommentFloorComponentKt.UserInfoComponent$lambda$1(avatarUrl, userName, tagText, score, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UserInfoComponent$lambda$1;
                }
            });
        }
    }

    public static final void TagListComponent(final PageViewModelWrapper pageViewModelWrapper, final List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.SubTagModel> list, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(1013158212);
        ComposerKt.sourceInformation($composer3, "C(TagListComponent)N(pageViewModelWrapper,tags,scale,modifier)541@20685L22,542@20730L44,579@22341L887,543@20779L2449:CommentFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 32 : 16;
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
                ComposerKt.traceEventStart(1013158212, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.TagListComponent (CommentFloorComponent.kt:530)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.SubTagModel> list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                List<CommentInfoApiService.CommentInfoResponse.CommentInfoData.SubTagModel> $this$map$iv = list;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    CommentInfoApiService.CommentInfoResponse.CommentInfoData.SubTagModel tag = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.SubTagModel) item$iv$iv;
                    destination$iv$iv.add(new Triple(tag.getTagName(), String.valueOf(tag.getVCount1()), tag.getTagId()));
                    $this$map$iv = $this$map$iv;
                }
                List tagData = (List) destination$iv$iv;
                TextMeasurerHelperKt.rememberTextMeasurer(0, $composer3, 0, 1);
                String str = "CC(remember):CommentFloorComponent.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, -1312517264, "CC(remember):CommentFloorComponent.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = SnapshotIntStateKt.mutableIntStateOf(tagData.size());
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                MutableIntState maxVisible$delegate = (MutableIntState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(24, scale));
                ComposerKt.sourceInformationMarkerStart($composer3, -1312464869, "CC(remember):CommentFloorComponent.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = (MeasurePolicy) new CommentFloorComponentKt$TagListComponent$3$1(maxVisible$delegate);
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                String str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv = ((384 << 6) & 896) | 6;
                String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv = factory$iv$iv2;
                    $composer3.createNode(factory$iv$iv);
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer3);
                modifier3 = modifier4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv >> 6) & 14;
                boolean z = false;
                ComposerKt.sourceInformationMarkerStart($composer3, -598055779, "C:CommentFloorComponent.kt#o90vz8");
                $composer3.startReplaceGroup(-19291874);
                ComposerKt.sourceInformation($composer3, "*552@21209L6,555@21409L43,546@20891L1301");
                List $this$forEachIndexed$iv = tagData;
                boolean z2 = false;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Triple triple = (Triple) item$iv;
                    String name = (String) triple.component1();
                    String count = (String) triple.component2();
                    List tagData2 = tagData;
                    final String tagId = (String) triple.component3();
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    boolean z3 = z2;
                    int $changed$iv$iv2 = $changed$iv$iv;
                    Modifier materialized$iv2 = materialized$iv;
                    Composer $composer4 = $composer3;
                    Modifier modifier5 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), index$iv > 0 ? ProvideUiScaleKt.dpScaled(8, scale) : ProvideUiScaleKt.dpScaled(0, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale))), ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 340074239, str);
                    boolean invalid$iv = $composer3.changedInstance(pageViewModel) | $composer3.changed(tagId);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit TagListComponent$lambda$5$0$0$0;
                                TagListComponent$lambda$5$0$0$0 = CommentFloorComponentKt.TagListComponent$lambda$5$0$0$0(PageViewModel.this, tagId);
                                return TagListComponent$lambda$5$0$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                    String str4 = str;
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str2);
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    String str5 = str2;
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = ((((432 << 3) & 112) << 6) & 896) | 6;
                    CompositionLocalMap localMap$iv2 = localMap$iv;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str3);
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
                    String str6 = str3;
                    boolean z4 = z;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i5 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 40407623, "C561@21717L9,563@21826L6,559@21626L235,565@21882L41,568@22030L9,570@22139L6,566@21944L230:CommentFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(name == null ? "" : name, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24576, 114682);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(6, scale)), $composer3, 0);
                    TextKt.Text-Nvy7gAk(count, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24576, 114682);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    materialized$iv = materialized$iv2;
                    $changed$iv$iv = $changed$iv$iv2;
                    localMap$iv = localMap$iv2;
                    index$iv = index$iv2;
                    z2 = z3;
                    tagData = tagData2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    $composer3 = $composer4;
                    str = str4;
                    str2 = str5;
                    str3 = str6;
                    z = z4;
                }
                $composer2 = $composer3;
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
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
                    final Modifier modifier6 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TagListComponent$lambda$0;
                            TagListComponent$lambda$0 = CommentFloorComponentKt.TagListComponent$lambda$0(PageViewModelWrapper.this, list, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TagListComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TagListComponent$lambda$7;
                    TagListComponent$lambda$7 = CommentFloorComponentKt.TagListComponent$lambda$7(PageViewModelWrapper.this, list, scale, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TagListComponent$lambda$7;
                }
            });
        }
    }

    private static final int TagListComponent$lambda$3(MutableIntState $maxVisible$delegate) {
        IntState $this$getValue$iv = (IntState) $maxVisible$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TagListComponent$lambda$5$0$0$0(PageViewModel $pageViewModel, String $tagId) {
        $pageViewModel.handleCommentTagId$product_details_page_debug($tagId);
        return Unit.INSTANCE;
    }

    public static final String parseDoubleCount(Double count) {
        if (count == null) {
            return "";
        }
        if (count.doubleValue() > 9999.0d) {
            double roundedDouble = Math.rint(count.doubleValue() / ((double) MediaAttrUtils.TYPE_PAY_SEASON)) / 10.0d;
            int roundedInt = (int) roundedDouble;
            if (roundedDouble == ((double) roundedInt)) {
                return roundedInt + "万";
            }
            return roundedDouble + "万";
        }
        return String.valueOf((int) Math.rint(count.doubleValue()));
    }
}