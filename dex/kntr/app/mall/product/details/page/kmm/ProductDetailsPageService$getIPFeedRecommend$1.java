package kntr.app.mall.product.details.page.kmm;

import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
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
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$getIPFeedRecommend$1", f = "ProductDetailsPageService.kt", i = {}, l = {614}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ProductDetailsPageService$getIPFeedRecommend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ipRightId;
    final /* synthetic */ String $itemIds;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$getIPFeedRecommend$1(ProductDetailsPageService productDetailsPageService, String str, String str2, Continuation<? super ProductDetailsPageService$getIPFeedRecommend$1> continuation) {
        super(2, continuation);
        this.this$0 = productDetailsPageService;
        this.$ipRightId = str;
        this.$itemIds = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageService$getIPFeedRecommend$1(this.this$0, this.$ipRightId, this.$itemIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        Object kntrGetIPFeedRecommend$product_details_page_debug;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        MutableStateFlow $receiver$iv3;
        Object prevValue$iv$iv3;
        Object nextValue$iv$iv3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ProductDetailsPageService productDetailsPageService = this.this$0;
                $receiver$iv = this.this$0._ipFeedRecommendFlow;
                ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.LOADING;
                do {
                    prevValue$iv$iv = $receiver$iv.getValue();
                    ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                    nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, null, null);
                } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
                this.label = 1;
                kntrGetIPFeedRecommend$product_details_page_debug = IPFeedRecommendV2ApiService.INSTANCE.kntrGetIPFeedRecommend$product_details_page_debug(this.$ipRightId, this.$itemIds, (Continuation) this);
                if (kntrGetIPFeedRecommend$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                kntrGetIPFeedRecommend$product_details_page_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IPFeedRecommendV2ApiService.Response response = (IPFeedRecommendV2ApiService.Response) kntrGetIPFeedRecommend$product_details_page_debug;
        Long code = response.getCode();
        if (code != null && code.longValue() == 0 && response.getData() != null) {
            ProductDetailsPageService productDetailsPageService2 = this.this$0;
            $receiver$iv3 = this.this$0._ipFeedRecommendFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
            do {
                prevValue$iv$iv3 = $receiver$iv3.getValue();
                ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv3;
                nextValue$iv$iv3 = new ProductDetailsPageDataState(pageStatus$iv2, response, null);
            } while (!$receiver$iv3.compareAndSet(prevValue$iv$iv3, nextValue$iv$iv3));
        } else {
            ProductDetailsPageService productDetailsPageService3 = this.this$0;
            $receiver$iv2 = this.this$0._ipFeedRecommendFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv3 = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
            String message = response.getMessage();
            if (message == null) {
                message = "请求失败";
            }
            String errorMessage$iv = message;
            do {
                prevValue$iv$iv2 = $receiver$iv2.getValue();
                ProductDetailsPageDataState productDetailsPageDataState3 = (ProductDetailsPageDataState) prevValue$iv$iv2;
                nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv3, null, errorMessage$iv);
            } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
        }
        return Unit.INSTANCE;
    }
}