package kntr.app.mall.product.details.page.kmm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPageApiRepositoryImp.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageApiRepositoryImp", f = "ProductDetailsPageApiRepositoryImp.kt", i = {0}, l = {72}, m = "getCouponList", n = {"mid"}, s = {"L$0"}, v = 1)
public final class ProductDetailsPageApiRepositoryImp$getCouponList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductDetailsPageApiRepositoryImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageApiRepositoryImp$getCouponList$1(ProductDetailsPageApiRepositoryImp productDetailsPageApiRepositoryImp, Continuation<? super ProductDetailsPageApiRepositoryImp$getCouponList$1> continuation) {
        super(continuation);
        this.this$0 = productDetailsPageApiRepositoryImp;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCouponList((Continuation) this);
    }
}