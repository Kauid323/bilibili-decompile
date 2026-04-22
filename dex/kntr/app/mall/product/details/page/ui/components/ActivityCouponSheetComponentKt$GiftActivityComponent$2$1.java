package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableState;
import kntr.app.mall.product.details.page.api.MarketingGiftApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$GiftActivityComponent$2$1", f = "ActivityCouponSheetComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ActivityCouponSheetComponentKt$GiftActivityComponent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ String $marketingId;
    final /* synthetic */ MutableState<MarketingGiftApiService.MarketingGiftResponse> $response$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityCouponSheetComponentKt$GiftActivityComponent$2$1(String str, CoroutineScope coroutineScope, MutableState<MarketingGiftApiService.MarketingGiftResponse> mutableState, Continuation<? super ActivityCouponSheetComponentKt$GiftActivityComponent$2$1> continuation) {
        super(2, continuation);
        this.$marketingId = str;
        this.$coroutineScope = coroutineScope;
        this.$response$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityCouponSheetComponentKt$GiftActivityComponent$2$1(this.$marketingId, this.$coroutineScope, this.$response$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((r0 == null || (r0 = r0.getData()) == null) ? null : r0.getMarketingId(), r8.$marketingId) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MarketingGiftApiService.MarketingGiftResponse GiftActivityComponent$lambda$2;
        MarketingGiftApiService.MarketingGiftResponse GiftActivityComponent$lambda$22;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GiftActivityComponent$lambda$2 = ActivityCouponSheetComponentKt.GiftActivityComponent$lambda$2(this.$response$delegate);
                if (GiftActivityComponent$lambda$2 != null) {
                    GiftActivityComponent$lambda$22 = ActivityCouponSheetComponentKt.GiftActivityComponent$lambda$2(this.$response$delegate);
                    break;
                }
                BuildersKt.launch$default(this.$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$marketingId, this.$response$delegate, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityCouponSheetComponent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$GiftActivityComponent$2$1$1", f = "ActivityCouponSheetComponent.kt", i = {}, l = {1197}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt$GiftActivityComponent$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $marketingId;
        final /* synthetic */ MutableState<MarketingGiftApiService.MarketingGiftResponse> $response$delegate;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, MutableState<MarketingGiftApiService.MarketingGiftResponse> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$marketingId = str;
            this.$response$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$marketingId, this.$response$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object marketingGift$product_details_page_debug;
            MutableState<MarketingGiftApiService.MarketingGiftResponse> mutableState;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MutableState<MarketingGiftApiService.MarketingGiftResponse> mutableState2 = this.$response$delegate;
                    this.L$0 = mutableState2;
                    this.label = 1;
                    marketingGift$product_details_page_debug = MarketingGiftApiService.INSTANCE.getMarketingGift$product_details_page_debug(this.$marketingId, (Continuation) this);
                    if (marketingGift$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableState = mutableState2;
                    break;
                case 1:
                    mutableState = (MutableState) this.L$0;
                    ResultKt.throwOnFailure($result);
                    marketingGift$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState.setValue((MarketingGiftApiService.MarketingGiftResponse) marketingGift$product_details_page_debug);
            return Unit.INSTANCE;
        }
    }
}