package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.runtime.MutableState;
import kntr.app.mall.product.details.page.api.SearchTextApiService;
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
/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopSearchComponent$1$1", f = "TopContainer.kt", i = {}, l = {785}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TopContainerKt$TopSearchComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $requestedSearchText;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopContainerKt$TopSearchComponent$1$1(MutableState<String> mutableState, Continuation<? super TopContainerKt$TopSearchComponent$1$1> continuation) {
        super(2, continuation);
        this.$requestedSearchText = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TopContainerKt$TopSearchComponent$1$1(this.$requestedSearchText, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object searchText$product_details_page_debug$default;
        SearchTextApiService.SearchTextData data;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$requestedSearchText.getValue() == null) {
                    this.label = 1;
                    searchText$product_details_page_debug$default = SearchTextApiService.getSearchText$product_details_page_debug$default(SearchTextApiService.INSTANCE, null, 0L, (Continuation) this, 3, null);
                    if (searchText$product_details_page_debug$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    SearchTextApiService.SearchTextResponse response = (SearchTextApiService.SearchTextResponse) searchText$product_details_page_debug$default;
                    data = response.getData();
                    if (data != null && !data.getResult().isEmpty()) {
                        this.$requestedSearchText.setValue(data.getResult().get(0).getWord());
                        break;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                searchText$product_details_page_debug$default = $result;
                SearchTextApiService.SearchTextResponse response2 = (SearchTextApiService.SearchTextResponse) searchText$product_details_page_debug$default;
                data = response2.getData();
                if (data != null) {
                    this.$requestedSearchText.setValue(data.getResult().get(0).getWord());
                    break;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}