package kntr.app.mall.product.details.page.ui.components;

import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$CouponItemComponent$1$1$1", f = "ActivityCouponSheetComponent.kt", i = {0, 1, 1}, l = {569, 571}, m = "invokeSuspend", n = {"couponStatus", "couponStatus", "finished"}, s = {"L$0", "L$0", "Z$0"}, v = 1)
public final class ActivityCouponSheetComponentKt$CouponItemComponent$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CouponListResponse.CouponListItem $coupon;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $fetchCoupon;
    final /* synthetic */ int $index;
    final /* synthetic */ PageViewModel $pageViewModel;
    Object L$0;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityCouponSheetComponentKt$CouponItemComponent$1$1$1(PageViewModel pageViewModel, CouponListResponse.CouponListItem couponListItem, int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super ActivityCouponSheetComponentKt$CouponItemComponent$1$1$1> continuation) {
        super(2, continuation);
        this.$pageViewModel = pageViewModel;
        this.$coupon = couponListItem;
        this.$index = i;
        this.$fetchCoupon = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityCouponSheetComponentKt$CouponItemComponent$1$1$1(this.$pageViewModel, this.$coupon, this.$index, this.$fetchCoupon, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String couponStatus;
        Object coupon$product_details_page_debug;
        Function1<Continuation<? super Unit>, Object> function1;
        boolean finished;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PageActionHandler actionHandler$product_details_page_debug = this.$pageViewModel.getActionHandler$product_details_page_debug();
                Pair[] pairArr = new Pair[3];
                String sourceAuthorityId = this.$coupon.getSourceAuthorityId();
                if (sourceAuthorityId == null) {
                    sourceAuthorityId = "";
                }
                boolean z = false;
                pairArr[0] = TuplesKt.to("coupon_id", sourceAuthorityId);
                pairArr[1] = TuplesKt.to("index", String.valueOf(this.$index + 1));
                pairArr[2] = TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, String.valueOf(Intrinsics.areEqual(this.$coupon.isReceived(), Boxing.boxBoolean(true)) ? 2 : 1));
                PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, TrackConsts.MALL_MALL_DETAIL_OIDF_OFFER_0_CLICK, MapsKt.mapOf(pairArr), true, false, 8, null);
                String couponStatus2 = this.$coupon.getCouponStatus();
                couponStatus = couponStatus2 != null ? couponStatus2 : "";
                if (Intrinsics.areEqual(couponStatus, "83110040") || Intrinsics.areEqual(couponStatus, "83110037")) {
                    return Unit.INSTANCE;
                }
                if (Intrinsics.areEqual(this.$coupon.isReceived(), Boxing.boxBoolean(true))) {
                    String landingPageUrl = this.$coupon.getLandingPageUrl();
                    if (landingPageUrl == null || landingPageUrl.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        this.$pageViewModel.handleJumpUrl$product_details_page_debug(this.$coupon.getLandingPageUrl());
                    } else {
                        this.$pageViewModel.handleJumpUrl$product_details_page_debug("bilibili://mall/home");
                    }
                    return Unit.INSTANCE;
                } else if (!UserInfoKt.isUserLoggedIn()) {
                    this.$pageViewModel.handleJumpUrl$product_details_page_debug("bilibili://login");
                    return Unit.INSTANCE;
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(couponStatus);
                    this.label = 1;
                    coupon$product_details_page_debug = this.$pageViewModel.getCoupon$product_details_page_debug(this.$coupon, (Continuation) this);
                    if (coupon$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                couponStatus = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                coupon$product_details_page_debug = $result;
                break;
            case 2:
                finished = this.Z$0;
                String str = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean finished2 = ((Boolean) coupon$product_details_page_debug).booleanValue();
        if (finished2 && (function1 = this.$fetchCoupon) != null) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(couponStatus);
            this.Z$0 = finished2;
            this.label = 2;
            if (function1.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            finished = finished2;
        }
        return Unit.INSTANCE;
    }
}