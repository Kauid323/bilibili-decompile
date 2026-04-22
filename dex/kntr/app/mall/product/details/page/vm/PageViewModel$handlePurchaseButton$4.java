package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.WishApiService;
import kntr.app.mall.product.details.page.api.model.CalendarRemindModel;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$4", f = "PageViewModel.kt", i = {1}, l = {1498, 1505}, m = "invokeSuspend", n = {"success"}, s = {"Z$0"}, v = 1)
public final class PageViewModel$handlePurchaseButton$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CalendarRemindModel $calendarModel;
    boolean Z$0;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handlePurchaseButton$4(PageViewModel pageViewModel, CalendarRemindModel calendarRemindModel, Continuation<? super PageViewModel$handlePurchaseButton$4> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$calendarModel = calendarRemindModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handlePurchaseButton$4(this.this$0, this.$calendarModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object addRemindSuspend$product_details_page_debug;
        boolean success;
        Object mallKntrSetWish$product_details_page_debug;
        boolean success2;
        Integer code;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                addRemindSuspend$product_details_page_debug = this.this$0.addRemindSuspend$product_details_page_debug(this.$calendarModel, "提醒已添加至日历", "设置提醒失败", (Continuation) this);
                if (addRemindSuspend$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                addRemindSuspend$product_details_page_debug = $result;
                break;
            case 2:
                success2 = this.Z$0;
                ResultKt.throwOnFailure($result);
                mallKntrSetWish$product_details_page_debug = $result;
                WishApiService.WishResponse wishResponse = (WishApiService.WishResponse) mallKntrSetWish$product_details_page_debug;
                code = wishResponse.getCode();
                if (code != null && code.intValue() == 0) {
                    this.this$0.reloadProductDetails$product_details_page_debug();
                }
                success = success2;
                KLog_androidKt.getKLog().i("addRemind", "Result: " + (success));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        success = ((Boolean) addRemindSuspend$product_details_page_debug).booleanValue();
        if (success) {
            WishApiService wishApiService = WishApiService.INSTANCE;
            String from$product_details_page_debug = this.this$0.getFrom$product_details_page_debug();
            String itemsId$product_details_page_debug = this.this$0.getItemsId$product_details_page_debug();
            long parseLong = itemsId$product_details_page_debug != null ? Long.parseLong(itemsId$product_details_page_debug) : 0L;
            String track_id$product_details_page_debug = this.this$0.getTrack_id$product_details_page_debug();
            String msource$product_details_page_debug = this.this$0.getMsource$product_details_page_debug();
            String is_ad$product_details_page_debug = this.this$0.is_ad$product_details_page_debug();
            Byte boxByte = Boxing.boxByte((byte) 20);
            this.Z$0 = success;
            this.label = 2;
            mallKntrSetWish$product_details_page_debug = wishApiService.mallKntrSetWish$product_details_page_debug(parseLong, (r26 & 2) != 0 ? null : null, (r26 & 4) != 0 ? null : boxByte, (r26 & 8) != 0 ? null : null, (byte) 1, track_id$product_details_page_debug, from$product_details_page_debug, msource$product_details_page_debug, is_ad$product_details_page_debug, (Continuation) this);
            if (mallKntrSetWish$product_details_page_debug == coroutine_suspended) {
                return coroutine_suspended;
            }
            success2 = success;
            WishApiService.WishResponse wishResponse2 = (WishApiService.WishResponse) mallKntrSetWish$product_details_page_debug;
            code = wishResponse2.getCode();
            if (code != null) {
                this.this$0.reloadProductDetails$product_details_page_debug();
            }
            success = success2;
        }
        KLog_androidKt.getKLog().i("addRemind", "Result: " + (success));
        return Unit.INSTANCE;
    }
}