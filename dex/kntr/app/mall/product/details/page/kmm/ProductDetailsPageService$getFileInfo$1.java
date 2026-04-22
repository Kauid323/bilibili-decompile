package kntr.app.mall.product.details.page.kmm;

import kntr.app.mall.product.details.page.api.ItemsFileApiService;
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

/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$getFileInfo$1", f = "ProductDetailsPageService.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ProductDetailsPageService$getFileInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $itemsId;
    final /* synthetic */ long $skuId;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$getFileInfo$1(String str, long j, ProductDetailsPageService productDetailsPageService, Continuation<? super ProductDetailsPageService$getFileInfo$1> continuation) {
        super(2, continuation);
        this.$itemsId = str;
        this.$skuId = j;
        this.this$0 = productDetailsPageService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageService$getFileInfo$1(this.$itemsId, this.$skuId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object itemFiles$product_details_page_debug;
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    itemFiles$product_details_page_debug = ItemsFileApiService.INSTANCE.getItemFiles$product_details_page_debug(this.$itemsId, this.$skuId, (Continuation) this);
                    if (itemFiles$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    itemFiles$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ItemsFileApiService.ItemsFileResponse response = (ItemsFileApiService.ItemsFileResponse) itemFiles$product_details_page_debug;
            Long code = response.getCode();
            if (code != null && code.longValue() == 0 && response.getData() != null) {
                ProductDetailsPageService productDetailsPageService = this.this$0;
                $receiver$iv = this.this$0._fileInfoFlow;
                ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
                Object holdData$iv = response.getData();
                do {
                    prevValue$iv$iv = $receiver$iv.getValue();
                    ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                    nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, holdData$iv, null);
                } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
            } else {
                ProductDetailsPageService productDetailsPageService2 = this.this$0;
                $receiver$iv2 = this.this$0._fileInfoFlow;
                ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
                do {
                    prevValue$iv$iv2 = $receiver$iv2.getValue();
                    ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv2;
                    nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv2, null, null);
                } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
            }
        } catch (Exception e) {
        }
        return Unit.INSTANCE;
    }
}