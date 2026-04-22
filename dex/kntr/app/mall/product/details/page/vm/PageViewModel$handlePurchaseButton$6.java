package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.AddCartApiService;
import kntr.app.mall.product.details.page.api.WishApiService;
import kntr.app.mall.product.details.page.api.model.CalendarRemindModel;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$6", f = "PageViewModel.kt", i = {}, l = {1550}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$handlePurchaseButton$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CalendarRemindModel $calendarModel;
    final /* synthetic */ FooterFloor.PurchaseButton $model;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handlePurchaseButton$6(PageViewModel pageViewModel, CalendarRemindModel calendarRemindModel, FooterFloor.PurchaseButton purchaseButton, Continuation<? super PageViewModel$handlePurchaseButton$6> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$calendarModel = calendarRemindModel;
        this.$model = purchaseButton;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handlePurchaseButton$6(this.this$0, this.$calendarModel, this.$model, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$6$1", f = "PageViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {1569, 1570, 1595}, m = "invokeSuspend", n = {"$this$supervisorScope", "calendarResultDeferred", "addCartResultDeferred", "$this$supervisorScope", "calendarResultDeferred", "addCartResultDeferred", "calendarResult", "$this$supervisorScope", "calendarResultDeferred", "addCartResultDeferred", "calendarResult", "addCartResult", "calendarSuccess", "addCartSuccess"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0"}, v = 1)
    /* renamed from: kntr.app.mall.product.details.page.vm.PageViewModel$handlePurchaseButton$6$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CalendarRemindModel $calendarModel;
        final /* synthetic */ FooterFloor.PurchaseButton $model;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        final /* synthetic */ PageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PageViewModel pageViewModel, CalendarRemindModel calendarRemindModel, FooterFloor.PurchaseButton purchaseButton, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pageViewModel;
            this.$calendarModel = calendarRemindModel;
            this.$model = purchaseButton;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$calendarModel, this.$model, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00c0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x012f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Deferred calendarResultDeferred;
            Deferred addCartResultDeferred;
            Object await;
            Object await2;
            Deferred addCartResultDeferred2;
            Object calendarResult;
            Deferred calendarResultDeferred2;
            boolean calendarSuccess;
            AddCartApiService.AddCartResponse addCartResponse;
            int i;
            Object mallKntrSetWish$product_details_page_debug;
            Long code;
            Integer code2;
            CoroutineScope $this$supervisorScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = 1;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    calendarResultDeferred = BuildersKt.async$default($this$supervisorScope, (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handlePurchaseButton$6$1$calendarResultDeferred$1(this.this$0, this.$calendarModel, null), 3, (Object) null);
                    addCartResultDeferred = BuildersKt.async$default($this$supervisorScope, (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handlePurchaseButton$6$1$addCartResultDeferred$1(this.$model, this.this$0, null), 3, (Object) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$supervisorScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(calendarResultDeferred);
                    this.L$2 = addCartResultDeferred;
                    this.label = 1;
                    await = calendarResultDeferred.await((Continuation) this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object calendarResult2 = ((Result) await).m2645unboximpl();
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$supervisorScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(calendarResultDeferred);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(addCartResultDeferred);
                    this.L$3 = calendarResult2;
                    this.label = 2;
                    await2 = addCartResultDeferred.await((Continuation) this);
                    if (await2 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    addCartResultDeferred2 = addCartResultDeferred;
                    calendarResult = calendarResult2;
                    calendarResultDeferred2 = calendarResultDeferred;
                    Object addCartResult = ((Result) await2).m2645unboximpl();
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    if (!Result.m2642isFailureimpl(calendarResult)) {
                        boxBoolean = calendarResult;
                    }
                    calendarSuccess = boxBoolean.booleanValue();
                    addCartResponse = Result.m2642isFailureimpl(addCartResult) ? null : addCartResult;
                    if (addCartResponse != null || (code = addCartResponse.getCode()) == null || code.longValue() != 0) {
                        i2 = 0;
                    }
                    i = i2;
                    if (!calendarSuccess && i != 0) {
                        this.this$0.showToast$product_details_page_debug("加车成功，将在开售前收到日历提醒");
                    } else if (i == 0 && !calendarSuccess) {
                        this.this$0.showToast$product_details_page_debug("加车成功");
                    } else if (i == 0 || !calendarSuccess) {
                        this.this$0.showToast$product_details_page_debug("操作失败，请稍后重试");
                    } else {
                        this.this$0.showToast$product_details_page_debug("添加成功，将在开售前日历提醒");
                    }
                    if (calendarSuccess) {
                        WishApiService wishApiService = WishApiService.INSTANCE;
                        String from$product_details_page_debug = this.this$0.getFrom$product_details_page_debug();
                        String itemsId$product_details_page_debug = this.this$0.getItemsId$product_details_page_debug();
                        long parseLong = itemsId$product_details_page_debug != null ? Long.parseLong(itemsId$product_details_page_debug) : 0L;
                        String track_id$product_details_page_debug = this.this$0.getTrack_id$product_details_page_debug();
                        String msource$product_details_page_debug = this.this$0.getMsource$product_details_page_debug();
                        String is_ad$product_details_page_debug = this.this$0.is_ad$product_details_page_debug();
                        Byte boxByte = Boxing.boxByte((byte) 20);
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$supervisorScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(calendarResultDeferred2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(addCartResultDeferred2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(calendarResult);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(addCartResult);
                        this.Z$0 = calendarSuccess;
                        this.I$0 = i;
                        this.label = 3;
                        mallKntrSetWish$product_details_page_debug = wishApiService.mallKntrSetWish$product_details_page_debug(parseLong, (r26 & 2) != 0 ? null : null, (r26 & 4) != 0 ? null : boxByte, (r26 & 8) != 0 ? null : null, (byte) 1, track_id$product_details_page_debug, from$product_details_page_debug, msource$product_details_page_debug, is_ad$product_details_page_debug, (Continuation) this);
                        if (mallKntrSetWish$product_details_page_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        WishApiService.WishResponse wishResponse = (WishApiService.WishResponse) mallKntrSetWish$product_details_page_debug;
                        code2 = wishResponse.getCode();
                        if (code2 != null && code2.intValue() == 0) {
                            this.this$0.reloadProductDetails$product_details_page_debug();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    addCartResultDeferred = (Deferred) this.L$2;
                    ResultKt.throwOnFailure($result);
                    calendarResultDeferred = (Deferred) this.L$1;
                    await = $result;
                    Object calendarResult22 = ((Result) await).m2645unboximpl();
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$supervisorScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(calendarResultDeferred);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(addCartResultDeferred);
                    this.L$3 = calendarResult22;
                    this.label = 2;
                    await2 = addCartResultDeferred.await((Continuation) this);
                    if (await2 != coroutine_suspended) {
                    }
                    break;
                case 2:
                    Object calendarResult3 = this.L$3;
                    ResultKt.throwOnFailure($result);
                    calendarResult = calendarResult3;
                    addCartResultDeferred2 = (Deferred) this.L$2;
                    calendarResultDeferred2 = (Deferred) this.L$1;
                    await2 = $result;
                    Object addCartResult2 = ((Result) await2).m2645unboximpl();
                    Boolean boxBoolean2 = Boxing.boxBoolean(false);
                    if (!Result.m2642isFailureimpl(calendarResult)) {
                    }
                    calendarSuccess = boxBoolean2.booleanValue();
                    addCartResponse = Result.m2642isFailureimpl(addCartResult2) ? null : addCartResult2;
                    if (addCartResponse != null) {
                        break;
                    }
                    i2 = 0;
                    i = i2;
                    if (!calendarSuccess) {
                    }
                    if (i == 0) {
                    }
                    if (i == 0) {
                    }
                    this.this$0.showToast$product_details_page_debug("操作失败，请稍后重试");
                    if (calendarSuccess) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    int i3 = this.I$0;
                    boolean z = this.Z$0;
                    Object obj = this.L$4;
                    Object obj2 = this.L$3;
                    Deferred deferred = (Deferred) this.L$2;
                    Deferred deferred2 = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    mallKntrSetWish$product_details_page_debug = $result;
                    WishApiService.WishResponse wishResponse2 = (WishApiService.WishResponse) mallKntrSetWish$product_details_page_debug;
                    code2 = wishResponse2.getCode();
                    if (code2 != null) {
                        this.this$0.reloadProductDetails$product_details_page_debug();
                        break;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (SupervisorKt.supervisorScope(new AnonymousClass1(this.this$0, this.$calendarModel, this.$model, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}