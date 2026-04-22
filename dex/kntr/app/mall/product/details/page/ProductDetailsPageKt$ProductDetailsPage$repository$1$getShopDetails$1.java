package kntr.app.mall.product.details.page;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ProductDetailsPageKt$ProductDetailsPage$repository$1", f = "ProductDetailsPage.kt", i = {0}, l = {173}, m = "getShopDetails", n = {"merchantId"}, s = {"J$0"}, v = 1)
public final class ProductDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductDetailsPageKt$ProductDetailsPage$repository$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1(ProductDetailsPageKt$ProductDetailsPage$repository$1 productDetailsPageKt$ProductDetailsPage$repository$1, Continuation<? super ProductDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1> continuation) {
        super(continuation);
        this.this$0 = productDetailsPageKt$ProductDetailsPage$repository$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getShopDetails(0L, (Continuation) this);
    }
}