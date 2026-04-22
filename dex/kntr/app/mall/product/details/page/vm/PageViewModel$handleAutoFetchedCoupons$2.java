package kntr.app.mall.product.details.page.vm;

import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CouponReceiveApiService;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleAutoFetchedCoupons$2", f = "PageViewModel.kt", i = {}, l = {2543}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$handleAutoFetchedCoupons$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $dayInterval;
    final /* synthetic */ List<Map<String, String>> $sourceInfos;
    final /* synthetic */ CouponPackageInfoModel $upCouponPackageInfo;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PageViewModel$handleAutoFetchedCoupons$2(CouponPackageInfoModel couponPackageInfoModel, List<? extends Map<String, String>> list, int i, PageViewModel pageViewModel, Continuation<? super PageViewModel$handleAutoFetchedCoupons$2> continuation) {
        super(2, continuation);
        this.$upCouponPackageInfo = couponPackageInfoModel;
        this.$sourceInfos = list;
        this.$dayInterval = i;
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handleAutoFetchedCoupons$2(this.$upCouponPackageInfo, this.$sourceInfos, this.$dayInterval, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object mallKntrReceiveCoupon$product_details_page_debug;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        Object nextValue$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                mallKntrReceiveCoupon$product_details_page_debug = CouponReceiveApiService.INSTANCE.mallKntrReceiveCoupon$product_details_page_debug(this.$upCouponPackageInfo.getPackagePopInfoVO().getCouponInfoList(), this.$sourceInfos, (Continuation) this);
                if (mallKntrReceiveCoupon$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                mallKntrReceiveCoupon$product_details_page_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CouponReceiveApiService.Response response = (CouponReceiveApiService.Response) mallKntrReceiveCoupon$product_details_page_debug;
        Long code = response.getCode();
        if (code != null && code.longValue() == 0) {
            CouponReceiveApiService.Response.Data data = response.getData();
            List<String> successReceivedAuthorityIds = data != null ? data.getSuccessReceivedAuthorityIds() : null;
            if (!(successReceivedAuthorityIds == null || successReceivedAuthorityIds.isEmpty()) && Intrinsics.areEqual(this.$upCouponPackageInfo.getPopup(), Boxing.boxBoolean(true)) && this.$dayInterval >= 1) {
                $this$update$iv = this.this$0.mUpCouponAutoFetchDisplayStateFlow;
                CouponPackageInfoModel couponPackageInfoModel = this.$upCouponPackageInfo;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) prevValue$iv;
                    nextValue$iv = new ProductDetailsPageUpCouponDisplayModel(couponPackageInfoModel.getPackagePopInfoVO(), response.getData().getSuccessReceivedAuthorityIds());
                } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
            }
        }
        return Unit.INSTANCE;
    }
}