package kntr.app.mall.product.details.page;

import kntr.app.mall.product.details.page.api.ProductApiService;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$requestFunction$1 extends FunctionReferenceImpl implements Function2<ProductApiService.ProductDetailRequest, Continuation<? super ProductDetailsResponse>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$requestFunction$1(Object obj) {
        super(2, obj, ProductApiService.class, "mallKntrGetProductDetails", "mallKntrGetProductDetails$product_details_page_debug(Lkntr/app/mall/product/details/page/api/ProductApiService$ProductDetailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(ProductApiService.ProductDetailRequest p0, Continuation<? super ProductDetailsResponse> continuation) {
        return ((ProductApiService) this.receiver).mallKntrGetProductDetails$product_details_page_debug(p0, continuation);
    }
}