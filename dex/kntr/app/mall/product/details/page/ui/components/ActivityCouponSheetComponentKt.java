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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.MarketingGiftApiService;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.mall.product.details.page.api.model.LabelObject;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0012\u001a/\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0017\u001aA\u0010\u0018\u001a\u00020\u00012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u001d\u001aa\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u00052 \b\u0002\u0010%\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010'\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010&H\u0001¢\u0006\u0002\u0010)\u001a?\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00100\u001a1\u00101\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00102\u001a'\u00103\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00104\u001a)\u00105\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u0015H\u0001¢\u0006\u0002\u00107\u001a)\u00108\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u0015H\u0001¢\u0006\u0002\u00107\u001a'\u00109\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010:\u001a\u0010\u0010;\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0000\u001a\u0010\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020,H\u0000\u001a\u0010\u0010>\u001a\u00020\u00152\u0006\u0010=\u001a\u00020,H\u0000\u001a1\u0010?\u001a\u00020\u00012\b\u0010@\u001a\u0004\u0018\u00010\u00152\u0006\u0010A\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010B\u001a\u0012\u0010C\u001a\u00020\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0000\u001a6\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u001a2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020$0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0000¨\u0006H²\u0006\f\u0010I\u001a\u0004\u0018\u00010JX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\f\u0010K\u001a\u0004\u0018\u00010LX\u008a\u008e\u0002"}, d2 = {"ActivityCouponSheetComponent", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ActivityPanelComponent", "activityPanelVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityPanelVO;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "(Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityPanelVO;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DetailNetPriceComponent", "info", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "(Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PriceTagItem", "price", "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CouponListComponent", "couponList", "", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "detailNetPriceInfo", "(Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;Lkntr/app/mall/product/details/page/vm/PageViewModel;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CouponItemComponent", "index", "", "isDetailNetPrice", "", "coupon", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "fetchCoupon", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(IZLkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "CouponLeftPriceComponent", "discountY", "", "isDiscount", "isLongPrice", "isDisabled", "(DZZZLkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DetailPriceRuleComponent", "(Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;Lkntr/app/mall/product/details/page/vm/PageViewModel;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CouponOwnerTagWrapper", "(Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CouponFansTagComponent", "text", "(Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "CouponNewTagComponent", "CouponOwnerTagComponent", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getCouponRightTimeText", "formatDoubleDiscount", "value", "formatDoublePrice", "GiftActivityComponent", "marketingId", "pageVmWrapper", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "useNetPriceInfo", "mergeCouponData", "Lkntr/app/mall/product/details/page/ui/components/MergedCouponItem;", "pageInterfaceCoupons", "backendCoupons", "product-details-page_debug", "productDetailsResponse", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "response", "Lkntr/app/mall/product/details/page/api/MarketingGiftApiService$MarketingGiftResponse;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ActivityCouponSheetComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityCouponSheetComponent$lambda$1(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityCouponSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityCouponSheetComponent$lambda$5(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityCouponSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityPanelComponent$lambda$3(ActivityInfoFloor.ActivityPanelVO activityPanelVO, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityPanelComponent(activityPanelVO, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponFansTagComponent$lambda$1(UiScaleModel uiScaleModel, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        CouponFansTagComponent(uiScaleModel, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponItemComponent$lambda$3(int i, boolean z, CouponListResponse.CouponListItem couponListItem, PageViewModelWrapper pageViewModelWrapper, UiScaleModel uiScaleModel, Modifier modifier, Function1 function1, int i2, int i3, Composer composer, int i4) {
        CouponItemComponent(i, z, couponListItem, pageViewModelWrapper, uiScaleModel, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponLeftPriceComponent$lambda$1(double d, boolean z, boolean z2, boolean z3, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponLeftPriceComponent(d, z, z2, z3, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponListComponent$lambda$0(List list, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, PageViewModel pageViewModel, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponListComponent(list, detailNetPriceInfo, pageViewModel, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponListComponent$lambda$3(List list, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, PageViewModel pageViewModel, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponListComponent(list, detailNetPriceInfo, pageViewModel, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponListComponent$lambda$5(List list, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, PageViewModel pageViewModel, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponListComponent(list, detailNetPriceInfo, pageViewModel, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponNewTagComponent$lambda$1(UiScaleModel uiScaleModel, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        CouponNewTagComponent(uiScaleModel, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponOwnerTagComponent$lambda$1(String str, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponOwnerTagComponent(str, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponOwnerTagWrapper$lambda$0(CouponListResponse.CouponListItem couponListItem, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponOwnerTagWrapper(couponListItem, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailNetPriceComponent$lambda$0(CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailNetPriceComponent(detailNetPriceInfo, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailNetPriceComponent$lambda$3(CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailNetPriceComponent(detailNetPriceInfo, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailPriceRuleComponent$lambda$0(CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, PageViewModel pageViewModel, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailPriceRuleComponent(detailNetPriceInfo, pageViewModel, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailPriceRuleComponent$lambda$2(CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, PageViewModel pageViewModel, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailPriceRuleComponent(detailNetPriceInfo, pageViewModel, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$0(String str, PageViewModelWrapper pageViewModelWrapper, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GiftActivityComponent(str, pageViewModelWrapper, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$5(String str, PageViewModelWrapper pageViewModelWrapper, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GiftActivityComponent(str, pageViewModelWrapper, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$7(String str, PageViewModelWrapper pageViewModelWrapper, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GiftActivityComponent(str, pageViewModelWrapper, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceTagItem$lambda$1(String str, String str2, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PriceTagItem(str, str2, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x05e3, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ActivityCouponSheetComponent(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final PageViewModelWrapper pageViewModelWrapper2;
        final int i2;
        final int i3;
        Composer $composer2;
        Composer $composer3;
        Modifier modifier3;
        ArrayList arrayList;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Modifier materialized$iv$iv;
        MeasurePolicy measurePolicy$iv$iv;
        Composer $composer$iv$iv$iv;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer4;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv3;
        Composer $composer$iv4;
        Composer $composer$iv5;
        Composer $composer$iv6;
        Composer $composer5;
        ActivityInfoFloor.GiftActivityVO giftActivityVO;
        Iterable detailCouponInfos;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer6 = $composer.startRestartGroup(-2019541883);
        ComposerKt.sourceInformation($composer6, "C(ActivityCouponSheetComponent)N(pageViewModelWrapper,modifier)83@3962L16,95@4511L16,97@4533L3745:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer6.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer6.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer6.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019541883, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponent (ActivityCouponSheetComponent.kt:81)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            State productDetailsResponse$delegate = SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer6, 0, 1);
            ProductDetailsResponse ActivityCouponSheetComponent$lambda$0 = ActivityCouponSheetComponent$lambda$0(productDetailsResponse$delegate);
            if (ActivityCouponSheetComponent$lambda$0 != null) {
                ProductDetailsResponse.ProductDetailsData productDetails = ActivityCouponSheetComponent$lambda$0.getData();
                if (productDetails == null) {
                    $composer3 = $composer6;
                    modifier3 = modifier4;
                } else {
                    ActivityInfoFloor activityInfoFloor = productDetails.getActivityInfoFloorVO();
                    CouponInfoFloor couponInfoFloor = productDetails.getCouponInfoFloorVO();
                    Iterable activityPanelVOs = activityInfoFloor != null ? activityInfoFloor.getActivityPanelVOs() : null;
                    CouponInfoFloor.DetailNetPriceInfo detailInfo = activityInfoFloor != null ? activityInfoFloor.getDetailNetPriceInfo() : null;
                    List couponList = couponInfoFloor != null ? couponInfoFloor.getCouponList() : null;
                    if (detailInfo == null || (detailCouponInfos = detailInfo.getDetailCouponInfos()) == null) {
                        arrayList = null;
                    } else {
                        Iterable $this$mapNotNull$iv = detailCouponInfos;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo it = (CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo) element$iv$iv$iv;
                            String sourceAuthorityId = it.getSourceAuthorityId();
                            if (sourceAuthorityId != null) {
                                destination$iv$iv.add(sourceAuthorityId);
                            }
                        }
                        arrayList = (List) destination$iv$iv;
                    }
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer6, 0, 1);
                    Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer6.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer6.startReusableNode();
                    if ($composer6.getInserting()) {
                        $composer6.createNode(factory$iv$iv$iv4);
                    } else {
                        $composer6.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i6 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, -807944061, "C98@4571L3701:ActivityCouponSheetComponent.kt#o90vz8");
                    Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv2 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                    Modifier modifier$iv$iv = modifier4;
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
                    $composer2 = $composer6;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i8 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1848831396, "C99@4616L1163,134@5921L21,131@5817L2445:ActivityCouponSheetComponent.kt#o90vz8");
                    Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale()));
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopCenter();
                    ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i10 = ((48 >> 6) & 112) | 6;
                    BoxScope $this$ActivityCouponSheetComponent_u24lambda_u244_u240_u240 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1232244260, "C109@4998L6,110@5050L9,106@4869L239,113@5126L639:ActivityCouponSheetComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk("优惠明细", (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT16b(), ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale()), $composer6, 6, 0, 130042);
                    Modifier modifier$iv4 = $this$ActivityCouponSheetComponent_u24lambda_u244_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd());
                    ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv4 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer6.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer6.startReusableNode();
                    if ($composer6.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer6.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer6.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i12 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, 155131639, "C117@5289L20,118@5352L6,122@5550L123,116@5236L511:ActivityCouponSheetComponent.kt#o90vz8");
                    Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer6, 6);
                    long j = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU();
                    Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale()));
                    ComposerKt.sourceInformationMarkerStart($composer6, 1806129224, "CC(remember):ActivityCouponSheetComponent.kt#9igjgp");
                    boolean invalid$iv = $composer6.changedInstance(pageViewModel);
                    Object it$iv = $composer6.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit ActivityCouponSheetComponent$lambda$4$0$0$0$0$0;
                            ActivityCouponSheetComponent$lambda$4$0$0$0$0$0 = ActivityCouponSheetComponentKt.ActivityCouponSheetComponent$lambda$4$0$0$0$0$0(PageViewModel.this);
                            return ActivityCouponSheetComponent$lambda$4$0$0$0$0$0;
                        }
                    };
                    $composer6.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer6, Painter.$stable | 48, 0);
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
                    Modifier modifier$iv5 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer6, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv5 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer6.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer6, modifier$iv5);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer6.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer6.startReusableNode();
                    if ($composer6.getInserting()) {
                        $composer6.createNode(factory$iv$iv$iv8);
                    } else {
                        $composer6.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer6);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i13 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i14 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, 955959789, "C:ActivityCouponSheetComponent.kt#o90vz8");
                    if (detailInfo != null) {
                        $composer6.startReplaceGroup(955924789);
                        ComposerKt.sourceInformation($composer6, "137@6023L259,144@6303L54");
                        materialized$iv$iv = materialized$iv$iv6;
                        measurePolicy$iv$iv = measurePolicy$iv5;
                        $composer$iv$iv$iv = $composer6;
                        DetailNetPriceComponent(detailInfo, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer6, 384, 0);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale())), $composer6, 0);
                    } else {
                        materialized$iv$iv = materialized$iv$iv6;
                        measurePolicy$iv$iv = measurePolicy$iv5;
                        $composer$iv$iv$iv = $composer6;
                        $composer6.startReplaceGroup(949959211);
                    }
                    $composer6.endReplaceGroup();
                    List<ActivityInfoFloor.ActivityPanelVO> list = (Collection) activityPanelVOs;
                    if (list == null || list.isEmpty()) {
                        $composer6.startReplaceGroup(949959211);
                    } else {
                        $composer6.startReplaceGroup(956360246);
                        ComposerKt.sourceInformation($composer6, "150@6534L6,151@6590L9,148@6454L198,160@6989L54");
                        TextKt.Text-Nvy7gAk("促销活动", (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT14b(), ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale()), $composer6, 6, 0, 131066);
                        $composer6.startReplaceGroup(1693426221);
                        ComposerKt.sourceInformation($composer6, "*154@6724L222");
                        Iterable $this$forEach$iv = activityPanelVOs;
                        for (Object element$iv : $this$forEach$iv) {
                            ActivityInfoFloor.ActivityPanelVO it2 = (ActivityInfoFloor.ActivityPanelVO) element$iv;
                            ActivityPanelComponent(it2, pageViewModel, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer6, 384, 0);
                        }
                        $composer6.endReplaceGroup();
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale())), $composer6, 0);
                    }
                    $composer6.endReplaceGroup();
                    List list2 = couponList;
                    if (list2 == null || list2.isEmpty()) {
                        z = true;
                        str = null;
                        z2 = false;
                        $composer6.startReplaceGroup(949959211);
                    } else {
                        $composer6.startReplaceGroup(957030435);
                        ComposerKt.sourceInformation($composer6, "164@7134L373,173@7528L54");
                        str = null;
                        z = true;
                        CouponListComponent(couponList, detailInfo, pageViewModel, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer6, 24576, 0);
                        z2 = false;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate).getScale())), $composer6, 0);
                    }
                    $composer6.endReplaceGroup();
                    if (detailInfo != null) {
                        $composer6.startReplaceGroup(957548755);
                        ComposerKt.sourceInformation($composer6, "177@7664L208");
                        z3 = z2;
                        DetailPriceRuleComponent(detailInfo, pageViewModel, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate), null, $composer6, 0, 8);
                    } else {
                        z3 = z2;
                        $composer6.startReplaceGroup(949959211);
                    }
                    $composer6.endReplaceGroup();
                    String giftId = (activityInfoFloor == null || (giftActivityVO = activityInfoFloor.getGiftActivityVO()) == null) ? str : giftActivityVO.getActId();
                    String str2 = giftId;
                    if (str2 != null && str2.length() != 0) {
                        z = z3;
                    }
                    if (z) {
                        $composer$iv$iv = $composer6;
                        $composer$iv = $composer6;
                        $composer$iv2 = $composer6;
                        $composer4 = $composer6;
                        $composer$iv$iv$iv2 = $composer6;
                        $composer$iv3 = $composer6;
                        $composer$iv4 = $composer6;
                        $composer$iv5 = $composer6;
                        $composer$iv6 = $composer6;
                        $composer5 = $composer6;
                        $composer5.startReplaceGroup(949959211);
                        $composer5.endReplaceGroup();
                    } else {
                        $composer6.startReplaceGroup(957910618);
                        ComposerKt.sourceInformation($composer6, "186@8029L201");
                        $composer$iv$iv = $composer6;
                        $composer$iv4 = $composer6;
                        $composer$iv$iv$iv2 = $composer6;
                        $composer$iv5 = $composer6;
                        $composer$iv6 = $composer6;
                        $composer$iv = $composer6;
                        $composer$iv2 = $composer6;
                        $composer4 = $composer6;
                        $composer$iv3 = $composer6;
                        GiftActivityComponent(giftId, pageViewModelWrapper, ActivityCouponSheetComponent$lambda$3(scaleModel$delegate), null, $composer6, ($dirty2 << 3) & 112, 8);
                        $composer6.endReplaceGroup();
                        $composer5 = $composer6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv$iv$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pageViewModelWrapper2 = pageViewModelWrapper;
                    i2 = $changed;
                    i3 = i;
                    modifier2 = modifier$iv$iv;
                }
            } else {
                $composer3 = $composer6;
                modifier3 = modifier4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier6 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ActivityCouponSheetComponent$lambda$1;
                        ActivityCouponSheetComponent$lambda$1 = ActivityCouponSheetComponentKt.ActivityCouponSheetComponent$lambda$1(PageViewModelWrapper.this, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return ActivityCouponSheetComponent$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        pageViewModelWrapper2 = pageViewModelWrapper;
        i2 = $changed;
        i3 = i;
        $composer2 = $composer6;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ActivityCouponSheetComponent$lambda$5;
                    ActivityCouponSheetComponent$lambda$5 = ActivityCouponSheetComponentKt.ActivityCouponSheetComponent$lambda$5(PageViewModelWrapper.this, modifier2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return ActivityCouponSheetComponent$lambda$5;
                }
            });
        }
    }

    private static final ProductDetailsResponse ActivityCouponSheetComponent$lambda$0(State<ProductDetailsResponse> state) {
        Object thisObj$iv = state.getValue();
        return (ProductDetailsResponse) thisObj$iv;
    }

    private static final UiScaleModel ActivityCouponSheetComponent$lambda$3(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityCouponSheetComponent$lambda$4$0$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    public static final void ActivityPanelComponent(final ActivityInfoFloor.ActivityPanelVO activityPanelVO, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        LabelObject copy;
        Intrinsics.checkNotNullParameter(activityPanelVO, "activityPanelVO");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(-36007739);
        ComposerKt.sourceInformation($composer3, "C(ActivityPanelComponent)N(activityPanelVO,pageViewModel,modifier)206@8534L16,210@8666L83,207@8555L2664:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(activityPanelVO) ? 4 : 2;
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
                ComposerKt.traceEventStart(-36007739, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ActivityPanelComponent (ActivityCouponSheetComponent.kt:205)");
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            Modifier modifier5 = PaddingKt.padding-VpY3zN4$default(modifier4, 0.0f, ProvideUiScaleKt.dpScaled(12, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -243687784, "CC(remember):ActivityCouponSheetComponent.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(pageViewModel) | (($dirty2 & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        Unit ActivityPanelComponent$lambda$1$0;
                        ActivityPanelComponent$lambda$1$0 = ActivityCouponSheetComponentKt.ActivityPanelComponent$lambda$1$0(PageViewModel.this, activityPanelVO);
                        return ActivityPanelComponent$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
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
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1618195962, "C214@8767L1819:ActivityCouponSheetComponent.kt#o90vz8");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(6, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), 7, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -430276549, "C:ActivityCouponSheetComponent.kt#o90vz8");
            if (activityPanelVO.getActLabel() != null) {
                $composer3.startReplaceGroup(-430255253);
                ComposerKt.sourceInformation($composer3, "234@9589L482");
                LabelObject model = activityPanelVO.getActLabel();
                IntRange intRange = new IntRange(1, 5);
                Integer tagType = model.getTagType();
                if (!(tagType != null && intRange.contains(tagType.intValue()))) {
                    copy = model.copy((r53 & 1) != 0 ? model.rightIconImgUrl : null, (r53 & 2) != 0 ? model.rightIconNightImgUrl : null, (r53 & 4) != 0 ? model.rightIconImgWidth : null, (r53 & 8) != 0 ? model.rightIconImgHeight : null, (r53 & 16) != 0 ? model.backDayColor1 : null, (r53 & 32) != 0 ? model.backDayColor2 : null, (r53 & 64) != 0 ? model.backImgHeight : null, (r53 & 128) != 0 ? model.backImgUrl : null, (r53 & 256) != 0 ? model.backImgWidth : null, (r53 & 512) != 0 ? model.backNightColor1 : null, (r53 & 1024) != 0 ? model.backNightColor2 : null, (r53 & 2048) != 0 ? model.backNightImgUrl : null, (r53 & 4096) != 0 ? model.boardDayColor1 : "FFFF6699", (r53 & 8192) != 0 ? model.boardDayColor2 : null, (r53 & 16384) != 0 ? model.boardNightColor1 : "FFD44E7D", (r53 & 32768) != 0 ? model.boardNightColor2 : null, (r53 & 65536) != 0 ? model.cornerRadius : null, (r53 & 131072) != 0 ? model.tagType : 1, (r53 & 262144) != 0 ? model.title : null, (r53 & 524288) != 0 ? model.titleDayColor1 : "FFFF6699", (r53 & 1048576) != 0 ? model.titleDayColor2 : null, (r53 & 2097152) != 0 ? model.titleNightColor1 : "FFD44E7D", (r53 & 4194304) != 0 ? model.titleNightColor2 : null, (r53 & 8388608) != 0 ? model.useBoard : 1, (r53 & 16777216) != 0 ? model.backImgUrlDay : null, (r53 & 33554432) != 0 ? model.backImgUrlNight : null, (r53 & 67108864) != 0 ? model.location : null, (r53 & 134217728) != 0 ? model.priority : null, (r53 & 268435456) != 0 ? model.tagId : null, (r53 & 536870912) != 0 ? model.tagVersion : null, (r53 & 1073741824) != 0 ? model.actionType : null, (r53 & Integer.MIN_VALUE) != 0 ? model.targetUrl : null, (r54 & 1) != 0 ? model.showImgUrl : null, (r54 & 2) != 0 ? model.showImgUrlHeight : null, (r54 & 4) != 0 ? model.showImgUrlWidth : null);
                    model = copy;
                }
                LabelComponentKt.m491LabelComponentTN_CM5M(model, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale(), ProvideUiScaleKt.dpScaled(20, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale())), $composer3, 0, 0);
            } else {
                $composer3.startReplaceGroup(-439264969);
            }
            $composer3.endReplaceGroup();
            String actUrl = activityPanelVO.getActUrl();
            if (actUrl == null || actUrl.length() == 0) {
                $composer3.startReplaceGroup(-439264969);
            } else {
                $composer3.startReplaceGroup(-429170873);
                ComposerKt.sourceInformation($composer3, "249@10211L28,250@10278L6,248@10162L400");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(10, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale())), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String benefitText = activityPanelVO.getBenefitText();
            if (benefitText == null || benefitText.length() == 0) {
                $composer3.startReplaceGroup(-1626969645);
            } else {
                $composer3.startReplaceGroup(-1616401094);
                ComposerKt.sourceInformation($composer3, "263@10752L6,264@10800L9,261@10660L193");
                TextKt.Text-Nvy7gAk(activityPanelVO.getBenefitText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), $composer3, 0, 0, 131066);
            }
            $composer3.endReplaceGroup();
            String timeStr = activityPanelVO.getTimeStr();
            if (timeStr == null || timeStr.length() == 0) {
                $composer3.startReplaceGroup(-1626969645);
            } else {
                $composer3.startReplaceGroup(-1616114747);
                ComposerKt.sourceInformation($composer3, "271@11021L6,272@11069L9,269@10933L270");
                TextKt.Text-Nvy7gAk(activityPanelVO.getTimeStr(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(4, ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), ActivityPanelComponent$lambda$0(scaleModel$delegate).getScale()), $composer3, 0, 0, 131064);
            }
            $composer3.endReplaceGroup();
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
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit ActivityPanelComponent$lambda$3;
                    ActivityPanelComponent$lambda$3 = ActivityCouponSheetComponentKt.ActivityPanelComponent$lambda$3(ActivityInfoFloor.ActivityPanelVO.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ActivityPanelComponent$lambda$3;
                }
            });
        }
    }

    private static final UiScaleModel ActivityPanelComponent$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityPanelComponent$lambda$1$0(PageViewModel $pageViewModel, ActivityInfoFloor.ActivityPanelVO $activityPanelVO) {
        $pageViewModel.handleJumpUrl$product_details_page_debug($activityPanelVO.getActUrl());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DetailNetPriceComponent(final CouponInfoFloor.DetailNetPriceInfo info, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Boolean hasMultipleDiscount;
        String detailPriceText;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer3;
        Iterable expressionInfoList;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer4 = $composer.startRestartGroup(2022736414);
        ComposerKt.sourceInformation($composer4, "C(DetailNetPriceComponent)N(info,scaleModel,modifier)301@11908L4714:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(info) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(scaleModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2022736414, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.DetailNetPriceComponent (ActivityCouponSheetComponent.kt:285)");
            }
            String detailPrice = info.getDetailPrice();
            String str2 = detailPrice;
            if (!(str2 == null || str2.length() == 0)) {
                CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression netPriceExpression = info.getNetPriceExpression();
                if (netPriceExpression == null || (expressionInfoList = netPriceExpression.getExpressionInfoList()) == null) {
                    hasMultipleDiscount = null;
                } else {
                    Iterable $this$any$iv = expressionInfoList;
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator<T> it = $this$any$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object element$iv = it.next();
                                CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression.ExpressionInfo it2 = (CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression.ExpressionInfo) element$iv;
                                Byte useDiscountType = it2.getUseDiscountType();
                                if (!(useDiscountType != null && useDiscountType.byteValue() == 5)) {
                                    Byte useDiscountType2 = it2.getUseDiscountType();
                                    if (!(useDiscountType2 != null && useDiscountType2.byteValue() == 6)) {
                                        z2 = false;
                                        continue;
                                        if (z2) {
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = true;
                                continue;
                                if (z2) {
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                    hasMultipleDiscount = Boolean.valueOf(z);
                }
                CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression netPriceExpression2 = info.getNetPriceExpression();
                List expressionInfoList2 = netPriceExpression2 != null ? netPriceExpression2.getExpressionInfoList() : null;
                if (!StringsKt.startsWith$default(detailPrice, "¥", false, 2, (Object) null)) {
                    detailPriceText = "¥" + detailPrice;
                } else {
                    detailPriceText = detailPrice;
                }
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                int $changed$iv = (($dirty2 >> 6) & 14) | 384;
                Modifier modifier$iv = modifier3;
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv6;
                    $composer4.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv6;
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
                int i4 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 2115299996, "C305@12021L1061,334@13092L3524:ActivityCouponSheetComponent.kt#o90vz8");
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(105, scaleModel.getScale()), 0.0f, 2, (Object) null), ProvideUiScaleKt.dpScaled(64, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()))), ColorKt.Color(4294964215L), (Shape) null, 2, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), horizontalAlignment$iv2, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv7;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv7;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i6 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -893903998, "C317@12553L6,318@12606L9,315@12473L216,329@12966L6,330@13019L9,321@12702L370:ActivityCouponSheetComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(detailPriceText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT22(), scaleModel.getScale()), $composer4, 0, 24576, 114682);
                if (Intrinsics.areEqual(hasMultipleDiscount, true)) {
                    str = "单件到手价约";
                } else {
                    str = "到手价约";
                }
                TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), scaleModel.getScale()), $composer4, 0, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(13, scaleModel.getScale()), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i8 = ((0 >> 6) & 112) | 6;
                BoxScope $this$DetailNetPriceComponent_u24lambda_u242_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, 2064639267, "C340@13272L570,359@14040L6,354@13856L2427,410@16580L6,404@16297L309:ActivityCouponSheetComponent.kt#o90vz8");
                BoxKt.Box(BorderKt.border-xT4_qwU(SizeKt.size-3ABfNKs(RotateKt.rotate(OffsetKt.absoluteOffset-VpY3zN4$default($this$DetailNetPriceComponent_u24lambda_u242_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, ProvideUiScaleKt.dpScaled(-6, scaleModel.getScale()), 1, (Object) null), 45.0f), ProvideUiScaleKt.dpScaled(15, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(1, scaleModel.getScale()), ColorKt.Color(4294951382L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(3, scaleModel.getScale()))), $composer4, 0);
                Modifier modifier$iv4 = PaddingKt.padding-3ABfNKs(BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()))), ProvideUiScaleKt.dpScaled(1, scaleModel.getScale()), ColorKt.Color(4294951382L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()))), ProvideUiScaleKt.dpScaled(20, scaleModel.getScale()));
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer4.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i10 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -2094648927, "C368@14560L21,368@14530L1739:ActivityCouponSheetComponent.kt#o90vz8");
                Modifier modifier$iv5 = ScrollKt.horizontalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv5 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer4.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i12 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -693141285, "C371@14692L6,372@14753L9,369@14606L208,376@14919L6,377@14980L9,374@14835L302,380@15158L199:ActivityCouponSheetComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk("到手价", (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), scaleModel.getScale()), $composer4, 6, 0, 131066);
                TextKt.Text-Nvy7gAk("=", PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scaleModel.getScale()), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), scaleModel.getScale()), $composer4, 6, 0, 131064);
                CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression netPriceExpression3 = info.getNetPriceExpression();
                String str3 = (netPriceExpression3 == null || (str3 = netPriceExpression3.getOriginalPrice()) == null) ? "" : "";
                Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
                $composer2 = $composer4;
                PriceTagItem(str3, "原价", scaleModel, null, $composer4, (($dirty2 << 3) & 896) | 48, 8);
                if (expressionInfoList2 == null) {
                    $composer4.startReplaceGroup(-692380175);
                    $composer4.endReplaceGroup();
                    $composer3 = $composer4;
                } else {
                    Composer $composer5 = $composer4;
                    $composer5.startReplaceGroup(-692380174);
                    ComposerKt.sourceInformation($composer5, "*389@15652L6,390@15717L9,386@15460L322,394@15953L276");
                    Iterable $this$forEachIndexed$iv = expressionInfoList2;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression.ExpressionInfo expressionInfo = (CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression.ExpressionInfo) item$iv;
                        TextKt.Text-Nvy7gAk("-", PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scaleModel.getScale()), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT16(), scaleModel.getScale()), $composer5, 6, 0, 131064);
                        String price = expressionInfo.getReductionMoney();
                        if (price == null) {
                            price = "";
                        }
                        String name = expressionInfo.getUseDiscountName();
                        if (name == null) {
                            name = "优惠";
                        }
                        PriceTagItem(price, name, scaleModel, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scaleModel.getScale()), 0.0f, 2, (Object) null), $composer5, ($dirty2 << 3) & 896, 0);
                        expressionInfoList2 = expressionInfoList2;
                        verticalArrangement$iv2 = verticalArrangement$iv2;
                        $composer5 = $composer5;
                        index$iv = index$iv2;
                    }
                    $composer3 = $composer5;
                    $composer3.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$DetailNetPriceComponent_u24lambda_u242_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), ProvideUiScaleKt.dpScaled(15, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(1, scaleModel.getScale())), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), $composer4, 0);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DetailNetPriceComponent$lambda$0;
                            DetailNetPriceComponent$lambda$0 = ActivityCouponSheetComponentKt.DetailNetPriceComponent$lambda$0(CouponInfoFloor.DetailNetPriceInfo.this, scaleModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return DetailNetPriceComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailNetPriceComponent$lambda$3;
                    DetailNetPriceComponent$lambda$3 = ActivityCouponSheetComponentKt.DetailNetPriceComponent$lambda$3(CouponInfoFloor.DetailNetPriceInfo.this, scaleModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailNetPriceComponent$lambda$3;
                }
            });
        }
    }

    public static final void PriceTagItem(final String price, final String name, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer2 = $composer.startRestartGroup(300702313);
        ComposerKt.sourceInformation($composer2, "C(PriceTagItem)N(price,name,scaleModel,modifier)424@16786L932:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(price) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(name) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(scaleModel) ? 256 : 128;
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
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(300702313, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.PriceTagItem (ActivityCouponSheetComponent.kt:423)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier3, ProvideUiScaleKt.dpScaled(44, scaleModel.getScale()));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier4 = modifier3;
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
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1315186066, "C433@17088L6,434@17137L9,431@17022L164,438@17256L6,439@17305L9,443@17468L6,436@17195L517:ActivityCouponSheetComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("¥" + price, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), scaleModel.getScale()), $composer2, 0, 0, 131066);
            TextKt.Text-Nvy7gAk(name, PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scaleModel.getScale()))), ProvideUiScaleKt.dpScaled(5, scaleModel.getScale()), ProvideUiScaleKt.dpScaled(3, scaleModel.getScale())), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), scaleModel.getScale()), $composer2, ($dirty >> 3) & 14, 0, 131064);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceTagItem$lambda$1;
                    PriceTagItem$lambda$1 = ActivityCouponSheetComponentKt.PriceTagItem$lambda$1(price, name, scaleModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceTagItem$lambda$1;
                }
            });
        }
    }

    public static final void CouponListComponent(final List<CouponInfoFloor.CouponInfo> list, final CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, final PageViewModel pageViewModel, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv;
        Modifier modifier$iv$iv;
        Composer $composer3;
        SnapshotStateList mergedCouponListState;
        Alignment.Horizontal horizontalAlignment$iv;
        Composer $composer$iv;
        Arrangement.Vertical verticalArrangement$iv;
        int compositeKeyHash$iv$iv;
        Modifier materialized$iv$iv;
        Composer $composer$iv2;
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer4 = $composer.startRestartGroup(1371150362);
        ComposerKt.sourceInformation($composer4, "C(CouponListComponent)N(couponList,detailNetPriceInfo,pageViewModel,scaleModel,modifier)462@18075L63,475@18608L65,475@18581L92,484@18796L801:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(detailNetPriceInfo) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModel) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(scaleModel) ? 2048 : 1024;
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
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1371150362, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponListComponent (ActivityCouponSheetComponent.kt:457)");
            }
            List<CouponInfoFloor.CouponInfo> list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                String str = "CC(remember):ActivityCouponSheetComponent.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer4, -879451303, "CC(remember):ActivityCouponSheetComponent.kt#9igjgp");
                boolean invalid$iv = $composer4.changed(list);
                Object it$iv = $composer4.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = SnapshotStateKt.mutableStateListOf();
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                SnapshotStateList mergedCouponListState2 = (SnapshotStateList) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -879434245, "CC(remember):ActivityCouponSheetComponent.kt#9igjgp");
                boolean invalid$iv2 = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(list) | $composer4.changedInstance(detailNetPriceInfo) | $composer4.changed(mergedCouponListState2);
                Object value$iv2 = $composer4.rememberedValue();
                if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                    value$iv2 = new ActivityCouponSheetComponentKt$CouponListComponent$2$1(pageViewModel, list, detailNetPriceInfo, mergedCouponListState2, null);
                    $composer4.updateRememberedValue(value$iv2);
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(list, (Function2) value$iv2, $composer4, $dirty2 & 14);
                List mergedCouponList = mergedCouponListState2.toList();
                if (!mergedCouponList.isEmpty()) {
                    SnapshotStateList mergedCouponListState3 = mergedCouponListState2;
                    int $changed$iv = ($dirty2 >> 12) & 14;
                    Modifier modifier$iv = modifier3;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                    int $changed$iv$iv = ($changed$iv << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                    Composer $composer$iv3 = $composer4;
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    Modifier modifier$iv$iv2 = modifier$iv;
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    Composer $composer$iv$iv2 = $composer4;
                    Alignment.Horizontal horizontalAlignment$iv3 = horizontalAlignment$iv2;
                    Composer $composer$iv$iv$iv = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv$iv$iv.startReusableNode();
                    if ($composer$iv$iv$iv.getInserting()) {
                        $composer$iv$iv$iv.createNode(factory$iv$iv$iv2);
                    } else {
                        $composer$iv$iv$iv.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv);
                    Function0 factory$iv$iv$iv3 = factory$iv$iv$iv2;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i4 = (($changed$iv >> 6) & 112) | 6;
                    Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, 568714937, "C489@18937L6,490@18981L9,487@18849L182:ActivityCouponSheetComponent.kt#o90vz8");
                    Composer $composer$iv4 = $composer$iv$iv$iv;
                    TextKt.Text-Nvy7gAk("优惠券(" + mergedCouponList.size() + ")", (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv$iv$iv2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv$iv2, BiliTheme.$stable).getT14b(), scaleModel.getScale()), $composer$iv$iv$iv2, 0, 0, 131066);
                    $composer$iv$iv$iv2.startReplaceGroup(-1090026535);
                    ComposerKt.sourceInformation($composer$iv$iv$iv2, "*494@19108L65,501@19496L29,495@19186L395");
                    List $this$forEachIndexed$iv = mergedCouponList;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        MergedCouponItem mergedCoupon = (MergedCouponItem) item$iv;
                        SnapshotStateList mergedCouponListState4 = mergedCouponListState3;
                        CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
                        int idx = index$iv;
                        Arrangement.Vertical verticalArrangement$iv3 = verticalArrangement$iv2;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(10, scaleModel.getScale())), $composer$iv$iv$iv2, 0);
                        CouponListResponse.CouponListItem couponItem = mergedCoupon.getCouponItem();
                        boolean isDetailNetPrice = mergedCoupon.isDetailNetPrice();
                        PageViewModelWrapper wrapper$product_details_page_debug = pageViewModel.getWrapper$product_details_page_debug();
                        Modifier materialized$iv$iv3 = materialized$iv$iv2;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -2144949297, str);
                        boolean invalid$iv3 = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(list) | $composer4.changedInstance(detailNetPriceInfo) | $composer4.changed(mergedCouponListState4);
                        Composer $this$cache$iv = $composer$iv$iv$iv2;
                        Object value$iv3 = $this$cache$iv.rememberedValue();
                        if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                            $composer$iv$iv = $composer$iv$iv2;
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            modifier$iv$iv = modifier$iv$iv2;
                            $composer3 = $composer$iv$iv$iv2;
                            mergedCouponListState = mergedCouponListState4;
                            horizontalAlignment$iv = horizontalAlignment$iv3;
                            $composer$iv = $composer$iv4;
                            verticalArrangement$iv = verticalArrangement$iv3;
                            compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                            materialized$iv$iv = materialized$iv$iv3;
                            $composer$iv2 = $composer$iv3;
                            value$iv3 = new ActivityCouponSheetComponentKt$CouponListComponent$4$1$1$1(pageViewModel, list, detailNetPriceInfo, mergedCouponListState, null);
                            $this$cache$iv.updateRememberedValue(value$iv3);
                        } else {
                            verticalArrangement$iv = verticalArrangement$iv3;
                            $composer3 = $composer$iv$iv$iv2;
                            mergedCouponListState = mergedCouponListState4;
                            compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                            $composer$iv$iv = $composer$iv$iv2;
                            horizontalAlignment$iv = horizontalAlignment$iv3;
                            $composer$iv = $composer$iv4;
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            materialized$iv$iv = materialized$iv$iv3;
                            $composer$iv2 = $composer$iv3;
                            modifier$iv$iv = modifier$iv$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CouponItemComponent(idx, isDetailNetPrice, couponItem, wrapper$product_details_page_debug, scaleModel, fillMaxWidth$default, (Function1) value$iv3, $composer3, (57344 & ($dirty2 << 3)) | 196608, 0);
                        compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                        str = str;
                        $composer$iv$iv$iv = $composer$iv$iv$iv;
                        modifier$iv$iv2 = modifier$iv$iv;
                        index$iv = index$iv2;
                        localMap$iv$iv = localMap$iv$iv2;
                        $composer4 = $composer4;
                        verticalArrangement$iv2 = verticalArrangement$iv;
                        $composer$iv3 = $composer$iv2;
                        $dirty2 = $dirty2;
                        $composer$iv$iv2 = $composer$iv$iv;
                        factory$iv$iv$iv3 = factory$iv$iv$iv;
                        $composer$iv$iv$iv2 = $composer3;
                        mergedCouponListState3 = mergedCouponListState;
                        horizontalAlignment$iv3 = horizontalAlignment$iv;
                        $composer$iv4 = $composer$iv;
                        materialized$iv$iv2 = materialized$iv$iv;
                    }
                    Composer $composer5 = $composer$iv$iv$iv2;
                    $composer2 = $composer4;
                    Composer $composer6 = $composer$iv$iv$iv;
                    $composer5.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier4 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit CouponListComponent$lambda$3;
                                CouponListComponent$lambda$3 = ActivityCouponSheetComponentKt.CouponListComponent$lambda$3(list, detailNetPriceInfo, pageViewModel, scaleModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return CouponListComponent$lambda$3;
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
                ScopeUpdateScope endRestartGroup2 = $composer4.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CouponListComponent$lambda$0;
                            CouponListComponent$lambda$0 = ActivityCouponSheetComponentKt.CouponListComponent$lambda$0(list, detailNetPriceInfo, pageViewModel, scaleModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return CouponListComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponListComponent$lambda$5;
                    CouponListComponent$lambda$5 = ActivityCouponSheetComponentKt.CouponListComponent$lambda$5(list, detailNetPriceInfo, pageViewModel, scaleModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponListComponent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object CouponListComponent$fetchAndMergeCouponList(PageViewModel $pageViewModel, List<CouponInfoFloor.CouponInfo> list, CouponInfoFloor.DetailNetPriceInfo $detailNetPriceInfo, SnapshotStateList<MergedCouponItem> snapshotStateList, Continuation<? super Unit> continuation) {
        ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1 activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1;
        boolean z;
        Object userCouponList$product_details_page_debug;
        List list2;
        if (continuation instanceof ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1) {
            activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1 = (ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1) continuation;
            if ((activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.label & Integer.MIN_VALUE) != 0) {
                activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.label -= Integer.MIN_VALUE;
                Object $result = activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                z = true;
                switch (activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$0 = SpillingKt.nullOutSpilledVariable($pageViewModel);
                        activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$1 = list;
                        activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$2 = $detailNetPriceInfo;
                        activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$3 = snapshotStateList;
                        activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.label = 1;
                        userCouponList$product_details_page_debug = $pageViewModel.getUserCouponList$product_details_page_debug(list, activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1);
                        if (userCouponList$product_details_page_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        snapshotStateList = (SnapshotStateList) activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$3;
                        $detailNetPriceInfo = (CouponInfoFloor.DetailNetPriceInfo) activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$2;
                        list = (List) activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$1;
                        PageViewModel pageViewModel = (PageViewModel) activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.L$0;
                        ResultKt.throwOnFailure($result);
                        userCouponList$product_details_page_debug = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CouponListResponse response = (CouponListResponse) userCouponList$product_details_page_debug;
                List backendCouponList = response.getData();
                list2 = backendCouponList;
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    List mergedList = mergeCouponData(list, backendCouponList, $detailNetPriceInfo);
                    snapshotStateList.clear();
                    snapshotStateList.addAll(mergedList);
                }
                return Unit.INSTANCE;
            }
        }
        activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1 = new ActivityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1(continuation);
        Object $result2 = activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        z = true;
        switch (activityCouponSheetComponentKt$CouponListComponent$fetchAndMergeCouponList$1.label) {
        }
        CouponListResponse response2 = (CouponListResponse) userCouponList$product_details_page_debug;
        List backendCouponList2 = response2.getData();
        list2 = backendCouponList2;
        if (list2 != null) {
            z = false;
        }
        if (!z) {
        }
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -20
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void CouponItemComponent(int r235, boolean r236, kntr.app.mall.product.details.page.api.CouponListResponse.CouponListItem r237, kntr.app.mall.product.details.page.vm.PageViewModelWrapper r238, kntr.app.mall.product.details.page.ui.scale.UiScaleModel r239, androidx.compose.ui.Modifier r240, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r241, androidx.compose.runtime.Composer r242, int r243, int r244) {
        /*
            Method dump skipped, instructions count: 6465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt.CouponItemComponent(int, boolean, kntr.app.mall.product.details.page.api.CouponListResponse$CouponListItem, kntr.app.mall.product.details.page.vm.PageViewModelWrapper, kntr.app.mall.product.details.page.ui.scale.UiScaleModel, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponItemComponent$lambda$0$0(CoroutineScope $coroutineScope, PageViewModel $pageViewModel, CouponListResponse.CouponListItem $coupon, int $index, Function1 $fetchCoupon) {
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ActivityCouponSheetComponentKt$CouponItemComponent$1$1$1($pageViewModel, $coupon, $index, $fetchCoupon, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponItemComponent$lambda$1$0(PageViewModel $pageViewModel, CouponListResponse.CouponListItem $coupon, int $index) {
        PageActionHandler actionHandler$product_details_page_debug = $pageViewModel.getActionHandler$product_details_page_debug();
        Pair[] pairArr = new Pair[2];
        String sourceAuthorityId = $coupon.getSourceAuthorityId();
        if (sourceAuthorityId == null) {
            sourceAuthorityId = "";
        }
        pairArr[0] = TuplesKt.to("coupon_id", sourceAuthorityId);
        pairArr[1] = TuplesKt.to("index", String.valueOf($index + 1));
        PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, TrackConsts.MALL_MALL_DETAIL_OIDF_OFFER_0_SHOW, MapsKt.mapOf(pairArr), false, false, 8, null);
        return Unit.INSTANCE;
    }

    public static final void CouponLeftPriceComponent(final double discountY, final boolean isDiscount, final boolean isLongPrice, final boolean isDisabled, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        String formatDoublePrice;
        long Color;
        TextStyle scaled;
        long Color2;
        long Color3;
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer2 = $composer.startRestartGroup(2042500481);
        ComposerKt.sourceInformation($composer2, "C(CouponLeftPriceComponent)N(discountY,isDiscount,isLongPrice,isDisabled,scaleModel,modifier)888@36569L2030:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(discountY) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isDiscount) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(isLongPrice) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(isDisabled) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(scaleModel) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if (!$composer2.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2042500481, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.CouponLeftPriceComponent (ActivityCouponSheetComponent.kt:887)");
            }
            int $changed$iv = ($dirty3 >> 15) & 14;
            Modifier modifier$iv$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            Modifier modifier5 = modifier4;
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $dirty = $dirty3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$CouponLeftPriceComponent_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -553190943, "C904@37135L1002:ActivityCouponSheetComponent.kt#o90vz8");
            if (isDiscount) {
                $composer2.startReplaceGroup(-589564763);
            } else {
                $composer2.startReplaceGroup(-553206940);
                ComposerKt.sourceInformation($composer2, "890@36635L481");
                if (isDisabled) {
                    $composer2.startReplaceGroup(-553126495);
                    ComposerKt.sourceInformation($composer2, "894@36765L6");
                    long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU();
                    $composer2.endReplaceGroup();
                    Color3 = j;
                } else {
                    $composer2.startReplaceGroup(-553053180);
                    $composer2.endReplaceGroup();
                    Color3 = ColorKt.Color(4294901882L);
                }
                TextKt.Text-Nvy7gAk("¥", PaddingKt.padding-qDBjuR0$default($this$CouponLeftPriceComponent_u24lambda_u240.alignByBaseline(Modifier.Companion), 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scaleModel.getScale()), 0.0f, 11, (Object) null), Color3, (TextAutoSize) null, ProvideUiScaleKt.spScaled(16, scaleModel.getScale()), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 1572870, 24576, 245672);
            }
            $composer2.endReplaceGroup();
            if (isDiscount) {
                formatDoublePrice = formatDoubleDiscount(discountY);
            } else {
                formatDoublePrice = formatDoublePrice(discountY);
            }
            if (isDisabled) {
                $composer2.startReplaceGroup(-552470039);
                ComposerKt.sourceInformation($composer2, "913@37423L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU();
                $composer2.endReplaceGroup();
                Color = j2;
            } else {
                $composer2.startReplaceGroup(-552404660);
                $composer2.endReplaceGroup();
                Color = ColorKt.Color(4294901882L);
            }
            if (isLongPrice) {
                scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(30), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scaleModel.getScale());
            } else {
                scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(30), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scaleModel.getScale());
            }
            TextKt.Text-Nvy7gAk(formatDoublePrice, $this$CouponLeftPriceComponent_u24lambda_u240.alignByBaseline(Modifier.Companion), Color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled, $composer2, 0, 24576, 114680);
            if (isDiscount) {
                $composer2.startReplaceGroup(-551680562);
                ComposerKt.sourceInformation($composer2, "935@38176L407");
                if (isDisabled) {
                    $composer2.startReplaceGroup(-551597823);
                    ComposerKt.sourceInformation($composer2, "939@38306L6");
                    long j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU();
                    $composer2.endReplaceGroup();
                    Color2 = j3;
                } else {
                    $composer2.startReplaceGroup(-551524508);
                    $composer2.endReplaceGroup();
                    Color2 = ColorKt.Color(4294901882L);
                }
                TextKt.Text-Nvy7gAk("折", $this$CouponLeftPriceComponent_u24lambda_u240.alignByBaseline(Modifier.Companion), Color2, (TextAutoSize) null, ProvideUiScaleKt.spScaled(16, scaleModel.getScale()), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 1572870, 0, 262056);
            } else {
                $composer2.startReplaceGroup(-589564763);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponLeftPriceComponent$lambda$1;
                    CouponLeftPriceComponent$lambda$1 = ActivityCouponSheetComponentKt.CouponLeftPriceComponent$lambda$1(discountY, isDiscount, isLongPrice, isDisabled, scaleModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponLeftPriceComponent$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0295, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DetailPriceRuleComponent(final CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, final PageViewModel pageViewModel, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer2 = $composer.startRestartGroup(-393992102);
        ComposerKt.sourceInformation($composer2, "C(DetailPriceRuleComponent)N(detailNetPriceInfo,pageViewModel,scaleModel,modifier)970@39164L1221:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(detailNetPriceInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModel) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(scaleModel) ? 256 : 128;
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
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-393992102, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.DetailPriceRuleComponent (ActivityCouponSheetComponent.kt:957)");
            }
            String detailPrice = detailNetPriceInfo != null ? detailNetPriceInfo.getDetailPrice() : null;
            if (!(detailPrice == null || detailPrice.length() == 0)) {
                String netPriceDescription = detailNetPriceInfo.getNetPriceDescription();
                final String netPriceUrl = detailNetPriceInfo.getNetPriceUrl();
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(20, scaleModel.getScale()), 7, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                modifier3 = modifier4;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1048409179, "C979@39465L6,977@39379L161,982@39549L52,986@39694L62,983@39610L769:ActivityCouponSheetComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(netPriceDescription == null ? "" : netPriceDescription, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(12, scaleModel.getScale()), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 0, 0, 262122);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(3, scaleModel.getScale())), $composer2, 0);
                Modifier modifier5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, 1074568148, "CC(remember):ActivityCouponSheetComponent.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(netPriceUrl) | $composer2.changedInstance(pageViewModel);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda27
                    public final Object invoke() {
                        Unit DetailPriceRuleComponent$lambda$1$0$0;
                        DetailPriceRuleComponent$lambda$1$0$0 = ActivityCouponSheetComponentKt.DetailPriceRuleComponent$lambda$1$0$0(netPriceUrl, pageViewModel);
                        return DetailPriceRuleComponent$lambda$1$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1523712702, "C991@39842L151,998@40052L28,997@40007L362:ActivityCouponSheetComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk("详细规则", (Modifier) null, ColorKt.Color(4284573293L), (TextAutoSize) null, ProvideUiScaleKt.spScaled(12, scaleModel.getScale()), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 390, 0, 262122);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scaleModel.getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, scaleModel.getScale())), ColorKt.Color(4284573293L), $composer2, Painter.$stable | 3120, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda26
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DetailPriceRuleComponent$lambda$0;
                            DetailPriceRuleComponent$lambda$0 = ActivityCouponSheetComponentKt.DetailPriceRuleComponent$lambda$0(CouponInfoFloor.DetailNetPriceInfo.this, pageViewModel, scaleModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return DetailPriceRuleComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailPriceRuleComponent$lambda$2;
                    DetailPriceRuleComponent$lambda$2 = ActivityCouponSheetComponentKt.DetailPriceRuleComponent$lambda$2(CouponInfoFloor.DetailNetPriceInfo.this, pageViewModel, scaleModel, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailPriceRuleComponent$lambda$2;
                }
            });
        }
    }

    private static final void DetailPriceRuleComponent$handleGoRule(String netPriceUrl, PageViewModel $pageViewModel) {
        String str = netPriceUrl;
        if (!(str == null || str.length() == 0)) {
            $pageViewModel.handleJumpUrl$product_details_page_debug(netPriceUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailPriceRuleComponent$lambda$1$0$0(String $netPriceUrl, PageViewModel $pageViewModel) {
        DetailPriceRuleComponent$handleGoRule($netPriceUrl, $pageViewModel);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CouponOwnerTagWrapper(final CouponListResponse.CouponListItem coupon, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        String text;
        Intrinsics.checkNotNullParameter(coupon, "coupon");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer2 = $composer.startRestartGroup(-1809763912);
        ComposerKt.sourceInformation($composer2, "C(CouponOwnerTagWrapper)N(coupon,scaleModel,modifier):ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(coupon) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(scaleModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        boolean z = true;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1809763912, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponOwnerTagWrapper (ActivityCouponSheetComponent.kt:1015)");
            }
            String followId = coupon.getFollowId();
            if (followId == null || followId.length() == 0) {
                String couponTag = coupon.getCouponTag();
                if (couponTag == null || couponTag.length() == 0) {
                    Byte newUserLimit = coupon.getNewUserLimit();
                    if (!(newUserLimit != null && newUserLimit.byteValue() == 14)) {
                        String discountLayerName = coupon.getDiscountLayerName();
                        if (discountLayerName != null && discountLayerName.length() != 0) {
                            z = false;
                        }
                        if (z) {
                            $composer2.startReplaceGroup(7676586);
                        } else {
                            $composer2.startReplaceGroup(48564997);
                            ComposerKt.sourceInformation($composer2, "1036@41222L149");
                            CouponOwnerTagComponent(coupon.getDiscountLayerName(), scaleModel, modifier, $composer2, ($dirty2 & 112) | ($dirty2 & 896), 0);
                        }
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
            }
            $composer2.startReplaceGroup(48057558);
            ComposerKt.sourceInformation($composer2, "1030@41026L127");
            String couponTag2 = coupon.getCouponTag();
            if (!(couponTag2 == null || couponTag2.length() == 0)) {
                text = coupon.getCouponTag();
            } else {
                Byte newUserLimit2 = coupon.getNewUserLimit();
                if (newUserLimit2 != null && newUserLimit2.byteValue() == 14) {
                    text = "新人专享";
                } else {
                    String followId2 = coupon.getFollowId();
                    if (followId2 != null && followId2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        text = "粉丝专享";
                    } else {
                        text = "";
                    }
                }
            }
            CouponNewTagComponent(scaleModel, modifier, text, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112), 0);
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponOwnerTagWrapper$lambda$0;
                    CouponOwnerTagWrapper$lambda$0 = ActivityCouponSheetComponentKt.CouponOwnerTagWrapper$lambda$0(CouponListResponse.CouponListItem.this, scaleModel, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponOwnerTagWrapper$lambda$0;
                }
            });
        }
    }

    public static final void CouponFansTagComponent(final UiScaleModel scaleModel, Modifier modifier, String text, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String text2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer2 = $composer.startRestartGroup(-434186907);
        ComposerKt.sourceInformation($composer2, "C(CouponFansTagComponent)N(scaleModel,modifier,text)1050@41530L1045:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scaleModel) ? 4 : 2;
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
            text2 = text;
        } else if (($changed & 384) == 0) {
            text2 = text;
            $dirty |= $composer2.changed(text2) ? 256 : 128;
        } else {
            text2 = text;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                text2 = "粉丝专享";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434186907, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponFansTagComponent (ActivityCouponSheetComponent.kt:1049)");
            }
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background$default(ClipKt.clip(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(modifier4, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(15, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape(50)), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294965746L)), Color.box-impl(ColorKt.Color(4294961629L)), Color.box-impl(ColorKt.Color(4294961629L)), Color.box-impl(ColorKt.Color(4294956731L))}), 0L, 0L, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), ProvideUiScaleKt.dpScaled(5, scaleModel.getScale()), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv2 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1745361138, "C1073@42454L9,1071@42393L176:ActivityCouponSheetComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk(text2, (Modifier) null, ColorKt.Color(4294934308L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10b(), scaleModel.getScale()), $composer2, (($dirty2 >> 6) & 14) | 384, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier$iv$iv2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str = text2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponFansTagComponent$lambda$1;
                    CouponFansTagComponent$lambda$1 = ActivityCouponSheetComponentKt.CouponFansTagComponent$lambda$1(UiScaleModel.this, modifier5, str, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponFansTagComponent$lambda$1;
                }
            });
        }
    }

    public static final void CouponNewTagComponent(final UiScaleModel scaleModel, Modifier modifier, String text, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String text2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer2 = $composer.startRestartGroup(-755452963);
        ComposerKt.sourceInformation($composer2, "C(CouponNewTagComponent)N(scaleModel,modifier,text)1086@42727L742:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scaleModel) ? 4 : 2;
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
            text2 = text;
        } else if (($changed & 384) == 0) {
            text2 = text;
            $dirty |= $composer2.changed(text2) ? 256 : 128;
        } else {
            text2 = text;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                text2 = "新人专享";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-755452963, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponNewTagComponent (ActivityCouponSheetComponent.kt:1085)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(modifier4, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scaleModel.getScale()), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(15, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape(50)), ColorKt.Color(4294960046L), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1597350975, "C1098@43204L259:ActivityCouponSheetComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk(text2, (Modifier) null, ColorKt.Color(4292034304L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), $composer2, (($dirty2 >> 6) & 14) | 384, 12607488, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str = text2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponNewTagComponent$lambda$1;
                    CouponNewTagComponent$lambda$1 = ActivityCouponSheetComponentKt.CouponNewTagComponent$lambda$1(UiScaleModel.this, modifier5, str, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponNewTagComponent$lambda$1;
                }
            });
        }
    }

    public static final void CouponOwnerTagComponent(final String text, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer3 = $composer.startRestartGroup(-1269466840);
        ComposerKt.sourceInformation($composer3, "C(CouponOwnerTagComponent)N(text,scaleModel,modifier)1117@43614L653:ActivityCouponSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scaleModel) ? 32 : 16;
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
                ComposerKt.traceEventStart(-1269466840, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponOwnerTagComponent (ActivityCouponSheetComponent.kt:1116)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(15, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape(50)), ColorKt.Color(4294928025L), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(5, scaleModel.getScale()), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -648645299, "C1131@44152L9,1129@44091L170:ActivityCouponSheetComponent.kt#o90vz8");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10b(), scaleModel.getScale()), $composer3, ($dirty2 & 14) | 384, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponOwnerTagComponent$lambda$1;
                    CouponOwnerTagComponent$lambda$1 = ActivityCouponSheetComponentKt.CouponOwnerTagComponent$lambda$1(text, scaleModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponOwnerTagComponent$lambda$1;
                }
            });
        }
    }

    public static final String getCouponRightTimeText(CouponListResponse.CouponListItem coupon) {
        Integer useEndTime;
        String unit;
        Intrinsics.checkNotNullParameter(coupon, "coupon");
        Integer useEffectDays = coupon.getUseEffectDays();
        if ((useEffectDays != null ? useEffectDays.intValue() : 0) != 0) {
            Integer useEffectUnit = coupon.getUseEffectUnit();
            if (useEffectUnit != null && useEffectUnit.intValue() == 1) {
                unit = "周";
            } else if (useEffectUnit != null && useEffectUnit.intValue() == 2) {
                unit = "月";
            } else {
                unit = (useEffectUnit != null && useEffectUnit.intValue() == 3) ? "年" : "天";
            }
            return "使用有效期：领取后" + coupon.getUseEffectDays() + unit + "内";
        }
        Integer useStartTime = coupon.getUseStartTime();
        int intValue = useStartTime != null ? useStartTime.intValue() : 0;
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        long startTime = intValue * j;
        long endTime = j * (coupon.getUseEndTime() != null ? useEndTime.intValue() : 0);
        String startTimeText = DateFormatKt.formatTimestamp$default(startTime, true, false, ".", false, 20, null);
        String endTimeText = DateFormatKt.formatTimestamp$default(endTime, true, false, ".", false, 20, null);
        String str = startTimeText + "-" + endTimeText;
        if (Intrinsics.areEqual(coupon.getCouponStatus(), "83110082")) {
            return str + " 生效";
        }
        return str;
    }

    public static final String formatDoubleDiscount(double value) {
        double rounded = MathKt.roundToInt(10 * value) / 10.0d;
        int intPart = (int) rounded;
        if (rounded == ((double) intPart)) {
            return String.valueOf(intPart);
        }
        return String.valueOf(rounded);
    }

    public static final String formatDoublePrice(double value) {
        int intPart = (int) value;
        if (value == ((double) intPart)) {
            return String.valueOf(intPart);
        }
        return String.valueOf(MathKt.roundToInt(100 * value) / 100.0d);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -70
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    private static final void GiftActivityComponent(java.lang.String r303, kntr.app.mall.product.details.page.vm.PageViewModelWrapper r304, kntr.app.mall.product.details.page.ui.scale.UiScaleModel r305, androidx.compose.ui.Modifier r306, androidx.compose.runtime.Composer r307, int r308, int r309) {
        /*
            Method dump skipped, instructions count: 8150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt.GiftActivityComponent(java.lang.String, kntr.app.mall.product.details.page.vm.PageViewModelWrapper, kntr.app.mall.product.details.page.ui.scale.UiScaleModel, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MarketingGiftApiService.MarketingGiftResponse GiftActivityComponent$lambda$2(MutableState<MarketingGiftApiService.MarketingGiftResponse> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (MarketingGiftApiService.MarketingGiftResponse) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$6$0$0$1$0$0(MarketingGiftApiService.MarketingGiftData $giftData, PageViewModel $pageVm) {
        String jumpUrl = $giftData.getActivityUrl();
        String str = jumpUrl;
        if (!(str == null || str.length() == 0)) {
            $pageVm.bridgeShowHalfWebView$product_details_page_debug(jumpUrl + "&fullScreen=1");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$6$0$1$0$0$0$1$0$0$0(MarketingGiftApiService.MarketingGiftData.MarketingStage.MarketingStageBenefit $benefit, PageViewModel $pageVm) {
        String itemsDetailUrl = $benefit.getItemsDetailUrl();
        String str = itemsDetailUrl;
        if (!(str == null || str.length() == 0)) {
            $pageVm.handleJumpUrl$product_details_page_debug(itemsDetailUrl);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$6$0$2$0(MarketingGiftApiService.MarketingGiftData $giftData, PageViewModel $pageVm) {
        String jumpUrl = $giftData.getRuleUrl();
        String str = jumpUrl;
        if (!(str == null || str.length() == 0)) {
            $pageVm.handleJumpUrl$product_details_page_debug(jumpUrl);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GiftActivityComponent$lambda$6$0$3$1(UiScaleModel $scaleModel, String it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)1455@60083L1233:ActivityCouponSheetComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-556023972, $changed, -1, "kntr.app.mall.product.details.page.ui.components.GiftActivityComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ActivityCouponSheetComponent.kt:1455)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1546033676, "C1461@60482L6,1462@60562L9,1459@60347L362,1466@60831L28,1467@60926L6,1465@60754L520:ActivityCouponSheetComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("活动规则", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $scaleModel.getScale()), $composer, 6, 24576, 114682);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scaleModel.getScale())), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), $composer, Painter.$stable | 48, 0);
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

    public static final boolean useNetPriceInfo(CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo) {
        if ((detailNetPriceInfo != null ? detailNetPriceInfo.getDetailPrice() : null) != null) {
            Integer detailPriceType = detailNetPriceInfo.getDetailPriceType();
            return (detailPriceType != null ? detailPriceType.intValue() : 0) == 1;
        }
        return false;
    }

    public static final List<MergedCouponItem> mergeCouponData(List<CouponInfoFloor.CouponInfo> list, List<CouponListResponse.CouponListItem> list2, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo) {
        Iterable emptyList;
        Intrinsics.checkNotNullParameter(list2, "backendCoupons");
        if (!useNetPriceInfo(detailNetPriceInfo)) {
            emptyList = CollectionsKt.emptyList();
        } else if (detailNetPriceInfo == null || (emptyList = detailNetPriceInfo.getDetailCouponInfos()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = emptyList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo it = (CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo) item$iv$iv;
            destination$iv$iv.add(it.getAsCouponListItem());
        }
        List<CouponListResponse.CouponListItem> netPriceCoupons = (List) destination$iv$iv;
        List<CouponListResponse.CouponListItem> $this$mapNotNull$iv = list2;
        Collection destination$iv$iv2 = new ArrayList();
        Iterator<T> it2 = $this$mapNotNull$iv.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object element$iv$iv$iv = it2.next();
            CouponListResponse.CouponListItem it3 = (CouponListResponse.CouponListItem) element$iv$iv$iv;
            String trimmed = mergeCouponData$trimmedID(it3.getSourceAuthorityId());
            String str = trimmed;
            String str2 = str.length() == 0 ? null : str;
            if (str2 != null) {
                destination$iv$iv2.add(str2);
            }
        }
        Set backendIDSet = CollectionsKt.toSet((List) destination$iv$iv2);
        List $this$mapNotNull$iv2 = netPriceCoupons;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
            CouponListResponse.CouponListItem it4 = (CouponListResponse.CouponListItem) element$iv$iv$iv2;
            String trimmed2 = mergeCouponData$trimmedID(it4.getSourceAuthorityId());
            String str3 = trimmed2;
            if (str3.length() == 0) {
                str3 = null;
            }
            String str4 = str3;
            if (str4 != null) {
                destination$iv$iv3.add(str4);
            }
        }
        Set netPriceIDSet = CollectionsKt.toSet((List) destination$iv$iv3);
        List leadingViewModels = new ArrayList();
        for (CouponListResponse.CouponListItem coupon : netPriceCoupons) {
            String id = mergeCouponData$trimmedID(coupon.getSourceAuthorityId());
            if ((id.length() == 0) || !backendIDSet.contains(id)) {
                leadingViewModels.add(new MergedCouponItem(coupon, true));
            }
        }
        List matchedBackend = new ArrayList();
        List unmatchedBackend = new ArrayList();
        for (CouponListResponse.CouponListItem backendCoupon : list2) {
            String id2 = mergeCouponData$trimmedID(backendCoupon.getSourceAuthorityId());
            if ((id2.length() > 0) && netPriceIDSet.contains(id2)) {
                matchedBackend.add(new MergedCouponItem(backendCoupon, true));
            } else {
                unmatchedBackend.add(new MergedCouponItem(backendCoupon, false));
            }
        }
        return CollectionsKt.plus(CollectionsKt.plus(leadingViewModels, matchedBackend), unmatchedBackend);
    }

    private static final String mergeCouponData$trimmedID(String id) {
        String obj;
        return (id == null || (obj = StringsKt.trim(id).toString()) == null) ? "" : obj;
    }
}