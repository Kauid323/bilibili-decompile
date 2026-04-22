package kntr.app.mall.product.details.page.kmm;

import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.ShareImageGenerateApiService;
import kntr.app.mall.product.details.page.api.model.ActionIconModel;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.HeaderFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.kmm.ProductShareActionState;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$getShareImage$1", f = "ProductDetailsPageService.kt", i = {0, 0}, l = {257}, m = "invokeSuspend", n = {"merchantId", "templateId"}, s = {"L$0", "L$1"}, v = 1)
final class ProductDetailsPageService$getShareImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$getShareImage$1(ProductDetailsPageService productDetailsPageService, Continuation<? super ProductDetailsPageService$getShareImage$1> continuation) {
        super(2, continuation);
        this.this$0 = productDetailsPageService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageService$getShareImage$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        MutableStateFlow mutableStateFlow;
        Long merchantId;
        MutableStateFlow mutableStateFlow2;
        String templateId;
        String str;
        Object requestGenerateShareImage$product_details_page_debug;
        ProductDetailsResponse.ProductDetailsData data;
        HeaderFloor headerFloorVO;
        List<ActionIconModel> header;
        Object obj;
        String it;
        ActionIconModel it2;
        ProductDetailsResponse.ProductDetailsData data2;
        BasicInfoFloor basicInfoFloorVO;
        MutableStateFlow $receiver$iv3;
        Object prevValue$iv$iv3;
        Object nextValue$iv$iv3;
        MutableStateFlow $receiver$iv4;
        Object prevValue$iv$iv4;
        Object nextValue$iv$iv4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ProductDetailsPageService productDetailsPageService = this.this$0;
                    $receiver$iv2 = this.this$0._shareImageFlow;
                    ProductShareActionState.ProductShareStatus pageStatus$iv = ProductShareActionState.ProductShareStatus.LOADING;
                    do {
                        prevValue$iv$iv2 = $receiver$iv2.getValue();
                        ProductShareActionState productShareActionState = (ProductShareActionState) prevValue$iv$iv2;
                        nextValue$iv$iv2 = new ProductShareActionState(pageStatus$iv, null, null);
                    } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
                    mutableStateFlow = this.this$0._productDetailsResponse;
                    ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) ((ProductDetailsPageDataState) mutableStateFlow.getValue()).getHoldData();
                    if (productDetailsResponse == null || (data2 = productDetailsResponse.getData()) == null || (basicInfoFloorVO = data2.getBasicInfoFloorVO()) == null) {
                        merchantId = null;
                    } else {
                        merchantId = basicInfoFloorVO.getOneShopId();
                    }
                    mutableStateFlow2 = this.this$0._productDetailsResponse;
                    ProductDetailsResponse productDetailsResponse2 = (ProductDetailsResponse) ((ProductDetailsPageDataState) mutableStateFlow2.getValue()).getHoldData();
                    if (productDetailsResponse2 != null && (data = productDetailsResponse2.getData()) != null && (headerFloorVO = data.getHeaderFloorVO()) != null && (header = headerFloorVO.getHeader()) != null) {
                        Iterator<T> it3 = header.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj = null;
                            } else {
                                obj = it3.next();
                                Integer type = ((ActionIconModel) obj).getType();
                                if (type != null && type.intValue() == 3) {
                                    it2 = 1;
                                    continue;
                                } else {
                                    it2 = null;
                                    continue;
                                }
                                if (it2 != null) {
                                }
                            }
                        }
                        ActionIconModel actionIconModel = (ActionIconModel) obj;
                        if (actionIconModel != null && (it = actionIconModel.getShareTemplateId()) != null) {
                            templateId = it.length() > 0 ? it : null;
                            if (templateId != null) {
                                ShareImageGenerateApiService shareImageGenerateApiService = ShareImageGenerateApiService.INSTANCE;
                                str = this.this$0.itemsId;
                                ShareImageGenerateApiService.RequestParams.Params params = new ShareImageGenerateApiService.RequestParams.Params(new ShareImageGenerateApiService.RequestParams.Params.ShareQuery(Boxing.boxInt(1), str, merchantId));
                                Long userId = UserInfoKt.getUserId();
                                this.L$0 = SpillingKt.nullOutSpilledVariable(merchantId);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(templateId);
                                this.label = 1;
                                requestGenerateShareImage$product_details_page_debug = shareImageGenerateApiService.requestGenerateShareImage$product_details_page_debug(new ShareImageGenerateApiService.RequestParams(templateId, templateId, params, new ShareImageGenerateApiService.RequestParams.Map(Boxing.boxInt(1), userId)), (Continuation) this);
                                if (requestGenerateShareImage$product_details_page_debug == coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    templateId = "merchantShare";
                    ShareImageGenerateApiService shareImageGenerateApiService2 = ShareImageGenerateApiService.INSTANCE;
                    str = this.this$0.itemsId;
                    ShareImageGenerateApiService.RequestParams.Params params2 = new ShareImageGenerateApiService.RequestParams.Params(new ShareImageGenerateApiService.RequestParams.Params.ShareQuery(Boxing.boxInt(1), str, merchantId));
                    Long userId2 = UserInfoKt.getUserId();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(merchantId);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(templateId);
                    this.label = 1;
                    requestGenerateShareImage$product_details_page_debug = shareImageGenerateApiService2.requestGenerateShareImage$product_details_page_debug(new ShareImageGenerateApiService.RequestParams(templateId, templateId, params2, new ShareImageGenerateApiService.RequestParams.Map(Boxing.boxInt(1), userId2)), (Continuation) this);
                    if (requestGenerateShareImage$product_details_page_debug == coroutine_suspended) {
                    }
                    break;
                case 1:
                    String str2 = (String) this.L$1;
                    Long l = (Long) this.L$0;
                    ResultKt.throwOnFailure($result);
                    requestGenerateShareImage$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ShareImageGenerateApiService.Response response = (ShareImageGenerateApiService.Response) requestGenerateShareImage$product_details_page_debug;
            Integer code = response.getCode();
            if (code != null && code.intValue() == 0 && response.getData() != null) {
                ProductDetailsPageService productDetailsPageService2 = this.this$0;
                $receiver$iv3 = this.this$0._shareImageFlow;
                ProductShareActionState.ProductShareStatus pageStatus$iv2 = ProductShareActionState.ProductShareStatus.SUCCESS;
                do {
                    prevValue$iv$iv3 = $receiver$iv3.getValue();
                    ProductShareActionState productShareActionState2 = (ProductShareActionState) prevValue$iv$iv3;
                    nextValue$iv$iv3 = new ProductShareActionState(pageStatus$iv2, response, null);
                } while (!$receiver$iv3.compareAndSet(prevValue$iv$iv3, nextValue$iv$iv3));
            } else {
                ProductDetailsPageService productDetailsPageService3 = this.this$0;
                $receiver$iv4 = this.this$0._shareImageFlow;
                ProductShareActionState.ProductShareStatus pageStatus$iv3 = ProductShareActionState.ProductShareStatus.ERROR;
                String errorMessage$iv = response.getMessage();
                if (errorMessage$iv == null) {
                    errorMessage$iv = "请求失败";
                }
                do {
                    prevValue$iv$iv4 = $receiver$iv4.getValue();
                    ProductShareActionState productShareActionState3 = (ProductShareActionState) prevValue$iv$iv4;
                    nextValue$iv$iv4 = new ProductShareActionState(pageStatus$iv3, null, errorMessage$iv);
                } while (!$receiver$iv4.compareAndSet(prevValue$iv$iv4, nextValue$iv$iv4));
            }
        } catch (Exception e) {
            ProductDetailsPageService productDetailsPageService4 = this.this$0;
            $receiver$iv = this.this$0._shareImageFlow;
            ProductShareActionState.ProductShareStatus pageStatus$iv4 = ProductShareActionState.ProductShareStatus.ERROR;
            String errorMessage$iv2 = e.getMessage();
            if (errorMessage$iv2 == null) {
                errorMessage$iv2 = "请求异常";
            }
            do {
                prevValue$iv$iv = $receiver$iv.getValue();
                ProductShareActionState productShareActionState4 = (ProductShareActionState) prevValue$iv$iv;
                nextValue$iv$iv = new ProductShareActionState(pageStatus$iv4, null, errorMessage$iv2);
            } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
        }
        return Unit.INSTANCE;
    }
}