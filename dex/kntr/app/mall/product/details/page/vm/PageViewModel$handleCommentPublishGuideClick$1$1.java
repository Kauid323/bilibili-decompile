package kntr.app.mall.product.details.page.vm;

import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CommentAddApiService;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleCommentPublishGuideClick$1$1", f = "PageViewModel.kt", i = {0, 0, 0, 0}, l = {1021}, m = "invokeSuspend", n = {"subjectName", "shopId", "imgList", "imgs"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class PageViewModel$handleCommentPublishGuideClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $result;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handleCommentPublishGuideClick$1$1(PageViewModel pageViewModel, Map<String, ? extends Object> map, Continuation<? super PageViewModel$handleCommentPublishGuideClick$1$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$result = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handleCommentPublishGuideClick$1$1(this.this$0, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Long shopId;
        String imgs;
        Object addComment$product_details_page_debug;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        ProductDetailsResponse.ProductDetailsData data2;
        BasicInfoFloor basicInfoFloorVO2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this.this$0.getProductDetailsResponse().getValue();
                if (productDetailsResponse == null || (data2 = productDetailsResponse.getData()) == null || (basicInfoFloorVO2 = data2.getBasicInfoFloorVO()) == null) {
                    str = null;
                } else {
                    str = basicInfoFloorVO2.getItemsName();
                }
                String subjectName = str;
                ProductDetailsResponse productDetailsResponse2 = (ProductDetailsResponse) this.this$0.getProductDetailsResponse().getValue();
                if (productDetailsResponse2 == null || (data = productDetailsResponse2.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
                    shopId = null;
                } else {
                    shopId = basicInfoFloorVO.getShopId();
                }
                Object imgList = this.$result.get("imgList");
                if (!(imgList instanceof List)) {
                    imgs = null;
                } else {
                    String imgs2 = CollectionsKt.joinToString$default((Iterable) imgList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    imgs = imgs2;
                }
                CommentAddApiService commentAddApiService = CommentAddApiService.INSTANCE;
                String itemsId$product_details_page_debug = this.this$0.getItemsId$product_details_page_debug();
                long parseLong = itemsId$product_details_page_debug != null ? Long.parseLong(itemsId$product_details_page_debug) : 0L;
                String str2 = subjectName == null ? "" : subjectName;
                Object obj = this.$result.get("content");
                String str3 = obj instanceof String ? (String) obj : null;
                if (str3 == null) {
                    str3 = "";
                }
                Object obj2 = this.$result.get("isAgreePub");
                Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                this.L$0 = SpillingKt.nullOutSpilledVariable(subjectName);
                this.L$1 = SpillingKt.nullOutSpilledVariable(shopId);
                this.L$2 = SpillingKt.nullOutSpilledVariable(imgList);
                this.L$3 = SpillingKt.nullOutSpilledVariable(imgs);
                this.label = 1;
                addComment$product_details_page_debug = commentAddApiService.addComment$product_details_page_debug(parseLong, str2, (r24 & 4) != 0 ? 1 : 1, (r24 & 8) != 0 ? "" : str3, (r24 & 16) != 0 ? 0 : null, (r24 & 32) != 0 ? null : shopId, (r24 & 64) != 0 ? null : num, (r24 & 128) != 0 ? null : imgs, (Continuation) this);
                if (addComment$product_details_page_debug != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                String str4 = (String) this.L$3;
                Object obj3 = this.L$2;
                Long l = (Long) this.L$1;
                String str5 = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                addComment$product_details_page_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CommentAddApiService.CommentAddResponse response = (CommentAddApiService.CommentAddResponse) addComment$product_details_page_debug;
        Long code = response.getCode();
        if (code != null && code.longValue() == 0) {
            this.this$0.bridgeCall.invoke("toast", MapsKt.mapOf(new Pair[]{TuplesKt.to("text", "审核中，通过后将在评论区展示~"), TuplesKt.to("autoCloseSeconds", Boxing.boxInt(3))}), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$handleCommentPublishGuideClick$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj4) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = PageViewModel$handleCommentPublishGuideClick$1$1.invokeSuspend$lambda$0((Map) obj4);
                    return invokeSuspend$lambda$0;
                }
            });
            this.this$0.bridgeCall.invoke("hideEditor", MapsKt.emptyMap(), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$handleCommentPublishGuideClick$1$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj4) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = PageViewModel$handleCommentPublishGuideClick$1$1.invokeSuspend$lambda$1((Map) obj4);
                    return invokeSuspend$lambda$1;
                }
            });
        } else {
            String message = response.getMessage();
            if (message == null) {
                message = "发表失败，请检查网络状态后重试";
            }
            this.this$0.bridgeCall.invoke("toast", MapsKt.mapOf(new Pair[]{TuplesKt.to("text", message), TuplesKt.to("autoCloseSeconds", Boxing.boxInt(3))}), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$handleCommentPublishGuideClick$1$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj4) {
                    Unit invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = PageViewModel$handleCommentPublishGuideClick$1$1.invokeSuspend$lambda$2((Map) obj4);
                    return invokeSuspend$lambda$2;
                }
            });
            this.this$0.bridgeCall.invoke("enableEditor", MapsKt.mapOf(TuplesKt.to("enable", Boxing.boxBoolean(true))), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$handleCommentPublishGuideClick$1$1$$ExternalSyntheticLambda3
                public final Object invoke(Object obj4) {
                    Unit invokeSuspend$lambda$3;
                    invokeSuspend$lambda$3 = PageViewModel$handleCommentPublishGuideClick$1$1.invokeSuspend$lambda$3((Map) obj4);
                    return invokeSuspend$lambda$3;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Map map) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Map map) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(Map map) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3(Map map) {
        return Unit.INSTANCE;
    }
}