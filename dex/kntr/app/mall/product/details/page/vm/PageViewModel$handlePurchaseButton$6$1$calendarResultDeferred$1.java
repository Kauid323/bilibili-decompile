package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.model.CalendarRemindModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1", f = "PageViewModel.kt", i = {0, 0, 0}, l = {1554}, m = "invokeSuspend", n = {"$this$async", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ CalendarRemindModel $calendarModel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1(PageViewModel pageViewModel, CalendarRemindModel calendarRemindModel, Continuation<? super PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$calendarModel = calendarRemindModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1 = new PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1(this.this$0, this.$calendarModel, continuation);
        pageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1.L$0 = obj;
        return pageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Boolean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object m2636constructorimpl;
        Object addRemindSuspend$product_details_page_debug$default;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PageViewModel pageViewModel = this.this$0;
                    CalendarRemindModel calendarRemindModel = this.$calendarModel;
                    Result.Companion companion = Result.Companion;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$async);
                    this.I$0 = 0;
                    this.label = 1;
                    addRemindSuspend$product_details_page_debug$default = PageViewModel.addRemindSuspend$product_details_page_debug$default(pageViewModel, calendarRemindModel, null, null, this, 6, null);
                    if (addRemindSuspend$product_details_page_debug$default != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$1;
                    ResultKt.throwOnFailure($result);
                    addRemindSuspend$product_details_page_debug$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m2636constructorimpl = Result.m2636constructorimpl(Boxing.boxBoolean(((Boolean) addRemindSuspend$product_details_page_debug$default).booleanValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2635boximpl(m2636constructorimpl);
    }
}