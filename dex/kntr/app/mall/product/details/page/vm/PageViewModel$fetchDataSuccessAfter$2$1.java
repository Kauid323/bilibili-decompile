package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
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
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$fetchDataSuccessAfter$2$1", f = "PageViewModel.kt", i = {}, l = {741}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$fetchDataSuccessAfter$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ipRightId;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$fetchDataSuccessAfter$2$1(String str, PageViewModel pageViewModel, Continuation<? super PageViewModel$fetchDataSuccessAfter$2$1> continuation) {
        super(2, continuation);
        this.$ipRightId = str;
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$fetchDataSuccessAfter$2$1(this.$ipRightId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object kntrGetIPFeedRecommend$product_details_page_debug;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                kntrGetIPFeedRecommend$product_details_page_debug = IPFeedRecommendV2ApiService.INSTANCE.kntrGetIPFeedRecommend$product_details_page_debug(this.$ipRightId, this.this$0.getItemsId$product_details_page_debug(), (Continuation) this);
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
        $this$update$iv = this.this$0._ipFeedRecommendFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            IPFeedRecommendV2ApiService.Response response2 = (IPFeedRecommendV2ApiService.Response) prevValue$iv;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, response));
        IPFeedRecommendV2ApiService.Response it = this.this$0.shouldShowIpFeedRecommend$product_details_page_debug(response.getData()) ? response : null;
        PageViewModel pageViewModel = this.this$0;
        mutableStateFlow = pageViewModel._productDetailsResponse;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) mutableStateFlow.getValue();
        if (productDetailsResponse != null) {
            pageViewModel.updateBannerContainer(productDetailsResponse, it);
        }
        return Unit.INSTANCE;
    }
}