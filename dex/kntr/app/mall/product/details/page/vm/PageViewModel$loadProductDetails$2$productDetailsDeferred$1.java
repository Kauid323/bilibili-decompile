package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.model.DeliveryInfoFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.vm.ContentModule;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$loadProductDetails$2$productDetailsDeferred$1", f = "PageViewModel.kt", i = {}, l = {595}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PageViewModel$loadProductDetails$2$productDetailsDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ProductDetailsResponse>, Object> {
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$loadProductDetails$2$productDetailsDeferred$1(PageViewModel pageViewModel, Continuation<? super PageViewModel$loadProductDetails$2$productDetailsDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$loadProductDetails$2$productDetailsDeferred$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ProductDetailsResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ApiRepository apiRepository;
        MutableStateFlow mutableStateFlow;
        Long l;
        String str;
        ContentModule.DeliveryInfoModule data;
        DeliveryInfoFloor data2;
        DeliveryInfoFloor.UserDefAddrVO userDefAddrVO;
        Integer addId;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                apiRepository = this.this$0.repository;
                mutableStateFlow = this.this$0.mDeliveryInfoContainerState;
                DeliveryInfoContainerState deliveryInfoContainerState = (DeliveryInfoContainerState) mutableStateFlow.getValue();
                if (deliveryInfoContainerState == null || (data = deliveryInfoContainerState.getData()) == null || (data2 = data.getData()) == null || (userDefAddrVO = data2.getUserDefAddrVO()) == null || (addId = userDefAddrVO.getAddId()) == null) {
                    l = null;
                } else {
                    l = Boxing.boxLong(addId.intValue());
                }
                str = this.this$0.originUrl;
                this.label = 1;
                Object productDetails = apiRepository.getProductDetails(l, str, (Continuation) this);
                if (productDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return productDetails;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}