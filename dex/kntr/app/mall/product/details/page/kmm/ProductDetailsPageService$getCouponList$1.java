package kntr.app.mall.product.details.page.kmm;

import java.util.List;
import kntr.app.mall.product.details.page.api.CouponListApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageDataState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$getCouponList$1", f = "ProductDetailsPageService.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ProductDetailsPageService$getCouponList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mid;
    final /* synthetic */ Byte $personalStatus;
    final /* synthetic */ List<String> $sourceAuthorityIdList;
    final /* synthetic */ String $sourceId;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$getCouponList$1(String str, Byte b, List<String> list, String str2, ProductDetailsPageService productDetailsPageService, Continuation<? super ProductDetailsPageService$getCouponList$1> continuation) {
        super(2, continuation);
        this.$mid = str;
        this.$personalStatus = b;
        this.$sourceAuthorityIdList = list;
        this.$sourceId = str2;
        this.this$0 = productDetailsPageService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageService$getCouponList$1(this.$mid, this.$personalStatus, this.$sourceAuthorityIdList, this.$sourceId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        Object mallKntrGetCouponList$product_details_page_debug;
        ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    mallKntrGetCouponList$product_details_page_debug = CouponListApiService.INSTANCE.mallKntrGetCouponList$product_details_page_debug(this.$mid, this.$personalStatus, this.$sourceAuthorityIdList, this.$sourceId, (Continuation) this);
                    if (mallKntrGetCouponList$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    mallKntrGetCouponList$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CouponListResponse response = (CouponListResponse) mallKntrGetCouponList$product_details_page_debug;
            if (response.getCode() == 0) {
                pageStatus = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
            } else {
                pageStatus = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
            }
            ProductDetailsPageService productDetailsPageService = this.this$0;
            $receiver$iv2 = this.this$0._couponListResponseFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = pageStatus;
            do {
                prevValue$iv$iv2 = $receiver$iv2.getValue();
                ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv2;
                nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv, response, null);
            } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
        } catch (Exception e) {
            ProductDetailsPageService productDetailsPageService2 = this.this$0;
            $receiver$iv = this.this$0._couponListResponseFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
            do {
                prevValue$iv$iv = $receiver$iv.getValue();
                ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv;
                nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv2, null, null);
            } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
        }
        return Unit.INSTANCE;
    }
}