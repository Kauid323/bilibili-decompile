package kntr.app.mall.product.details.page.kmm;

import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageDataState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$fetchDataSuccessAfter$1", f = "ProductDetailsPageService.kt", i = {0, 0}, l = {660}, m = "invokeSuspend", n = {"$this$launch", "liveInfoDeferred"}, s = {"L$0", "L$1"}, v = 1)
public final class ProductDetailsPageService$fetchDataSuccessAfter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$fetchDataSuccessAfter$1(ProductDetailsPageService productDetailsPageService, Continuation<? super ProductDetailsPageService$fetchDataSuccessAfter$1> continuation) {
        super(2, continuation);
        this.this$0 = productDetailsPageService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> productDetailsPageService$fetchDataSuccessAfter$1 = new ProductDetailsPageService$fetchDataSuccessAfter$1(this.this$0, continuation);
        productDetailsPageService$fetchDataSuccessAfter$1.L$0 = obj;
        return productDetailsPageService$fetchDataSuccessAfter$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        String it;
        Object await;
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Deferred liveInfoDeferred = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$fetchDataSuccessAfter$1$liveInfoDeferred$1(this.this$0, null), 3, (Object) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(liveInfoDeferred);
                    this.label = 1;
                    await = liveInfoDeferred.await((Continuation) this);
                    if (await != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    Deferred deferred = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    await = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LiveInfoApiService.LiveInfoResponse liveInfoResponse = (LiveInfoApiService.LiveInfoResponse) await;
            ProductDetailsPageService productDetailsPageService = this.this$0;
            $receiver$iv = this.this$0._liveApiResponse;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
            do {
                prevValue$iv$iv = $receiver$iv.getValue();
                ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, liveInfoResponse, null);
            } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
        } catch (Exception e) {
            $this$update$iv = this.this$0._errorState;
            do {
                prevValue$iv = $this$update$iv.getValue();
                String str = (String) prevValue$iv;
                String message = e.getMessage();
                if (message == null) {
                    message = "Failed to refresh live info";
                }
                it = message;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it));
        }
        return Unit.INSTANCE;
    }
}