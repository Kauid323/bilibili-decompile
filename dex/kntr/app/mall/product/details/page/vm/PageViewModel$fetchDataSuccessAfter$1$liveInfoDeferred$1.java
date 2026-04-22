package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.LiveInfoApiService;
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

/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$fetchDataSuccessAfter$1$liveInfoDeferred$1", f = "PageViewModel.kt", i = {}, l = {707}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PageViewModel$fetchDataSuccessAfter$1$liveInfoDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LiveInfoApiService.LiveInfoResponse>, Object> {
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$fetchDataSuccessAfter$1$liveInfoDeferred$1(PageViewModel pageViewModel, Continuation<? super PageViewModel$fetchDataSuccessAfter$1$liveInfoDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$fetchDataSuccessAfter$1$liveInfoDeferred$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LiveInfoApiService.LiveInfoResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ApiRepository apiRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                apiRepository = this.this$0.repository;
                this.label = 1;
                Object liveInfo = apiRepository.getLiveInfo((Continuation) this);
                return liveInfo == coroutine_suspended ? coroutine_suspended : liveInfo;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}