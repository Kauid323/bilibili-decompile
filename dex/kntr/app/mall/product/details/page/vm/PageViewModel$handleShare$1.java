package kntr.app.mall.product.details.page.vm;

import java.util.Map;
import kntr.app.mall.product.details.page.api.ShareImageGenerateApiService;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleShare$1", f = "PageViewModel.kt", i = {}, l = {1916}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$handleShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extParams;
    final /* synthetic */ String $templateId;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handleShare$1(String str, PageViewModel pageViewModel, Map<String, String> map, Continuation<? super PageViewModel$handleShare$1> continuation) {
        super(2, continuation);
        this.$templateId = str;
        this.this$0 = pageViewModel;
        this.$extParams = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handleShare$1(this.$templateId, this.this$0, this.$extParams, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestGenerateShareImage$product_details_page_debug;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ShareImageGenerateApiService shareImageGenerateApiService = ShareImageGenerateApiService.INSTANCE;
                String str = this.$templateId;
                String str2 = this.$templateId;
                ShareImageGenerateApiService.RequestParams.Params params = new ShareImageGenerateApiService.RequestParams.Params(new ShareImageGenerateApiService.RequestParams.Params.ShareQuery(Boxing.boxInt(1), this.this$0.getItemsId$product_details_page_debug(), this.this$0.getMerchantId()));
                Long userId = UserInfoKt.getUserId();
                this.label = 1;
                requestGenerateShareImage$product_details_page_debug = shareImageGenerateApiService.requestGenerateShareImage$product_details_page_debug(new ShareImageGenerateApiService.RequestParams(str, str2, params, new ShareImageGenerateApiService.RequestParams.Map(Boxing.boxInt(1), userId)), (Continuation) this);
                if (requestGenerateShareImage$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                requestGenerateShareImage$product_details_page_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ShareImageGenerateApiService.Response response = (ShareImageGenerateApiService.Response) requestGenerateShareImage$product_details_page_debug;
        ShareImageGenerateApiService.Response.Data data = response.getData();
        String imageUrl = data != null ? data.getUrl() : null;
        Map shareParams = HelperKt.buildShareParams(imageUrl == null ? "" : imageUrl, this.this$0.getMsource$product_details_page_debug(), this.$extParams);
        Function3 function3 = this.this$0.bridgeCall;
        final PageViewModel pageViewModel = this.this$0;
        function3.invoke("showShare", shareParams, new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$handleShare$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = PageViewModel$handleShare$1.invokeSuspend$lambda$0(PageViewModel.this, (Map) obj);
                return invokeSuspend$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(PageViewModel this$0, Map result) {
        KLog_androidKt.getKLog().i("PageViewModel", "Share result: " + result);
        this$0.isProcessingShare = false;
        return Unit.INSTANCE;
    }
}