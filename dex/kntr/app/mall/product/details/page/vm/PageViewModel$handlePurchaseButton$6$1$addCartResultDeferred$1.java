package kntr.app.mall.product.details.page.vm;

import java.util.List;
import kntr.app.mall.product.details.page.api.AddCartApiService;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lkntr/app/mall/product/details/page/api/AddCartApiService$AddCartResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1", f = "PageViewModel.kt", i = {0, 0, 0}, l = {1561}, m = "invokeSuspend", n = {"$this$async", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends AddCartApiService.AddCartResponse>>, Object> {
    final /* synthetic */ FooterFloor.PurchaseButton $model;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1(FooterFloor.PurchaseButton purchaseButton, PageViewModel pageViewModel, Continuation<? super PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1> continuation) {
        super(2, continuation);
        this.$model = purchaseButton;
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1 = new PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1(this.$model, this.this$0, continuation);
        pageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1.L$0 = obj;
        return pageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<AddCartApiService.AddCartResponse>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object m2636constructorimpl;
        Object addCart$product_details_page_debug;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    FooterFloor.PurchaseButton purchaseButton = this.$model;
                    PageViewModel pageViewModel = this.this$0;
                    Result.Companion companion = Result.Companion;
                    AddCartApiService addCartApiService = AddCartApiService.INSTANCE;
                    Long itemsId = purchaseButton.getItemsId();
                    long longValue = itemsId != null ? itemsId.longValue() : 0L;
                    List<Long> skuIds = purchaseButton.getSkuIds();
                    long longValue2 = skuIds != null ? skuIds.get(0).longValue() : 0L;
                    Integer shopId = purchaseButton.getShopId();
                    int intValue = shopId != null ? shopId.intValue() : 0;
                    String track_id$product_details_page_debug = pageViewModel.getTrack_id$product_details_page_debug();
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$async);
                    this.I$0 = 0;
                    this.label = 1;
                    addCart$product_details_page_debug = addCartApiService.addCart$product_details_page_debug((r23 & 1) != 0 ? 0L : longValue, (r23 & 2) != 0 ? 0 : intValue, (r23 & 4) != 0 ? 0L : longValue2, (r23 & 8) != 0 ? 1 : 0, (r23 & 16) != 0 ? 0 : 0, (r23 & 32) != 0 ? "" : track_id$product_details_page_debug, this);
                    if (addCart$product_details_page_debug != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$1;
                    ResultKt.throwOnFailure($result);
                    addCart$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m2636constructorimpl = Result.m2636constructorimpl((AddCartApiService.AddCartResponse) addCart$product_details_page_debug);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2635boximpl(m2636constructorimpl);
    }
}