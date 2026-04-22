package kntr.app.mall.product.details.page.vm;

import androidx.lifecycle.ViewModelKt;
import java.util.concurrent.CancellationException;
import kntr.app.mall.product.details.page.api.WishApiService;
import kntr.app.mall.product.details.page.api.model.WishInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleFooterButtonClick$1", f = "PageViewModel.kt", i = {}, l = {1344}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$handleFooterButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isWished;
    final /* synthetic */ byte $wishType;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handleFooterButtonClick$1(PageViewModel pageViewModel, byte b, boolean z, Continuation<? super PageViewModel$handleFooterButtonClick$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$wishType = b;
        this.$isWished = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handleFooterButtonClick$1(this.this$0, this.$wishType, this.$isWished, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object mallKntrSetWish$product_details_page_debug;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        Object nextValue$iv;
        Integer num;
        MutableStateFlow $this$update$iv2;
        Object prevValue$iv2;
        Object nextValue$iv2;
        Job job;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow $this$update$iv3;
        Object prevValue$iv3;
        Object nextValue$iv3;
        Job job2;
        int intValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    WishApiService wishApiService = WishApiService.INSTANCE;
                    String itemsId$product_details_page_debug = this.this$0.getItemsId$product_details_page_debug();
                    long parseLong = itemsId$product_details_page_debug != null ? Long.parseLong(itemsId$product_details_page_debug) : 0L;
                    String track_id$product_details_page_debug = this.this$0.getTrack_id$product_details_page_debug();
                    String msource$product_details_page_debug = this.this$0.getMsource$product_details_page_debug();
                    String from$product_details_page_debug = this.this$0.getFrom$product_details_page_debug();
                    String is_ad$product_details_page_debug = this.this$0.is_ad$product_details_page_debug();
                    this.label = 1;
                    mallKntrSetWish$product_details_page_debug = wishApiService.mallKntrSetWish$product_details_page_debug(parseLong, (r26 & 2) != 0 ? null : null, (r26 & 4) != 0 ? null : null, (r26 & 8) != 0 ? null : null, this.$wishType, track_id$product_details_page_debug, from$product_details_page_debug, msource$product_details_page_debug, is_ad$product_details_page_debug, (Continuation) this);
                    if (mallKntrSetWish$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    mallKntrSetWish$product_details_page_debug = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WishApiService.WishResponse response = (WishApiService.WishResponse) mallKntrSetWish$product_details_page_debug;
            Integer code = response.getCode();
            if (code != null && code.intValue() == 0) {
                $this$update$iv = this.this$0._wishInfo;
                boolean z = this.$isWished;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    WishInfo prev = (WishInfo) prevValue$iv;
                    Boolean boxBoolean = Boxing.boxBoolean(!z);
                    if (prev.getCount() != null) {
                        if (z) {
                            intValue = RangesKt.coerceAtLeast(prev.getCount().intValue() - 1, 0);
                        } else {
                            intValue = prev.getCount().intValue() + 1;
                        }
                        num = Boxing.boxInt(intValue);
                    } else {
                        num = null;
                    }
                    nextValue$iv = new WishInfo(boxBoolean, num);
                } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                if (this.$isWished) {
                    mutableStateFlow = this.this$0._isUserTriggeredWishAction;
                    mutableStateFlow.setValue(Boxing.boxBoolean(false));
                    $this$update$iv3 = this.this$0._showLikedCollectionLayer;
                    do {
                        prevValue$iv3 = $this$update$iv3.getValue();
                        ((Boolean) prevValue$iv3).booleanValue();
                        nextValue$iv3 = Boxing.boxBoolean(false);
                    } while (!$this$update$iv3.compareAndSet(prevValue$iv3, nextValue$iv3));
                    job2 = this.this$0.hideWishLayerJob;
                    if (job2 != null) {
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                    }
                    this.this$0.hideWishLayerJob = null;
                } else {
                    $this$update$iv2 = this.this$0._showLikedCollectionLayer;
                    do {
                        prevValue$iv2 = $this$update$iv2.getValue();
                        ((Boolean) prevValue$iv2).booleanValue();
                        nextValue$iv2 = Boxing.boxBoolean(true);
                    } while (!$this$update$iv2.compareAndSet(prevValue$iv2, nextValue$iv2));
                    job = this.this$0.hideWishLayerJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.this$0.hideWishLayerJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(this.this$0, null), 3, (Object) null);
                }
            } else {
                this.this$0.showToast$product_details_page_debug("操作失败");
            }
        } catch (Exception e) {
            this.this$0.showToast$product_details_page_debug("操作失败");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleFooterButtonClick$1$4", f = "PageViewModel.kt", i = {}, l = {1381}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.mall.product.details.page.vm.PageViewModel$handleFooterButtonClick$1$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(PageViewModel pageViewModel, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = pageViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MutableStateFlow $this$update$iv;
            Object prevValue$iv;
            Object nextValue$iv;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DelayKt.delay(3000L, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            $this$update$iv = this.this$0._showLikedCollectionLayer;
            do {
                prevValue$iv = $this$update$iv.getValue();
                ((Boolean) prevValue$iv).booleanValue();
                nextValue$iv = Boxing.boxBoolean(false);
            } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
            return Unit.INSTANCE;
        }
    }
}