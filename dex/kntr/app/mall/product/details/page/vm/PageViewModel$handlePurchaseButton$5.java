package kntr.app.mall.product.details.page.vm;

import java.util.List;
import kntr.app.mall.product.details.page.api.AddCartApiService;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$5", f = "PageViewModel.kt", i = {}, l = {1532}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$handlePurchaseButton$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FooterFloor.PurchaseButton $model;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handlePurchaseButton$5(FooterFloor.PurchaseButton purchaseButton, PageViewModel pageViewModel, Continuation<? super PageViewModel$handlePurchaseButton$5> continuation) {
        super(2, continuation);
        this.$model = purchaseButton;
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handlePurchaseButton$5(this.$model, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object addCart$product_details_page_debug;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AddCartApiService addCartApiService = AddCartApiService.INSTANCE;
                Long itemsId = this.$model.getItemsId();
                long longValue = itemsId != null ? itemsId.longValue() : 0L;
                List<Long> skuIds = this.$model.getSkuIds();
                long longValue2 = skuIds != null ? skuIds.get(0).longValue() : 0L;
                Integer shopId = this.$model.getShopId();
                int intValue = shopId != null ? shopId.intValue() : 0;
                String track_id$product_details_page_debug = this.this$0.getTrack_id$product_details_page_debug();
                this.label = 1;
                addCart$product_details_page_debug = addCartApiService.addCart$product_details_page_debug((r23 & 1) != 0 ? 0L : longValue, (r23 & 2) != 0 ? 0 : intValue, (r23 & 4) != 0 ? 0L : longValue2, (r23 & 8) != 0 ? 1 : 0, (r23 & 16) != 0 ? 0 : 0, (r23 & 32) != 0 ? "" : track_id$product_details_page_debug, (Continuation) this);
                if (addCart$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                addCart$product_details_page_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PageViewModel pageViewModel = this.this$0;
        AddCartApiService.AddCartResponse response = (AddCartApiService.AddCartResponse) addCart$product_details_page_debug;
        Long code = response.getCode();
        if (code != null && code.longValue() == 0) {
            pageViewModel.showToast$product_details_page_debug("加购成功");
        } else {
            pageViewModel.showToast$product_details_page_debug("加购失败");
        }
        return Unit.INSTANCE;
    }
}