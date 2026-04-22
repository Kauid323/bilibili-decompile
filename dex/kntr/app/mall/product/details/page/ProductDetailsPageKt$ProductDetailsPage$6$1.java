package kntr.app.mall.product.details.page;

import java.util.Map;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: ProductDetailsPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ProductDetailsPageKt$ProductDetailsPage$6$1", f = "ProductDetailsPage.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ProductDetailsPageKt$ProductDetailsPage$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SharedFlow<Pair<String, Map<String, Object>>> $eventFlow;
    final /* synthetic */ PageViewModel $pageViewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductDetailsPageKt$ProductDetailsPage$6$1(SharedFlow<? extends Pair<String, ? extends Map<String, ? extends Object>>> sharedFlow, PageViewModel pageViewModel, Continuation<? super ProductDetailsPageKt$ProductDetailsPage$6$1> continuation) {
        super(2, continuation);
        this.$eventFlow = sharedFlow;
        this.$pageViewModel = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageKt$ProductDetailsPage$6$1(this.$eventFlow, this.$pageViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<Pair<String, Map<String, Object>>> sharedFlow = this.$eventFlow;
                if (sharedFlow == null) {
                    return Unit.INSTANCE;
                }
                final PageViewModel pageViewModel = this.$pageViewModel;
                this.label = 1;
                if (sharedFlow.collect(new FlowCollector() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$ProductDetailsPage$6$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Pair) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Pair<String, ? extends Map<String, ? extends Object>> pair, Continuation<? super Unit> continuation) {
                        String key = pair.component1();
                        pair.component2();
                        if (Intrinsics.areEqual(key, "refreshPage")) {
                            PageViewModel.this.reloadProductDetails$product_details_page_debug();
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}