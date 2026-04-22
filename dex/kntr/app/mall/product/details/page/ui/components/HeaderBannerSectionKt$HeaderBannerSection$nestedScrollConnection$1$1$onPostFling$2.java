package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.State;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HeaderBannerSection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$2", f = "HeaderBannerSection.kt", i = {0, 0}, l = {265}, m = "invokeSuspend", n = {"finalPagerState", "targetPage"}, s = {"L$0", "I$0"}, v = 1)
final class HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<PagerState> $bannerPagerState$delegate;
    final /* synthetic */ State<PagerState> $bannerPreviewPagerState$delegate;
    final /* synthetic */ boolean $isInPreview;
    final /* synthetic */ LazyStaggeredGridState $listState;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ CoroutineScope $scope;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$2(boolean z, int i, PageViewModel pageViewModel, State<? extends PagerState> state, State<? extends PagerState> state2, CoroutineScope coroutineScope, LazyStaggeredGridState lazyStaggeredGridState, Continuation<? super HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$2> continuation) {
        super(2, continuation);
        this.$isInPreview = z;
        this.$pageCount = i;
        this.$pageViewModel = pageViewModel;
        this.$bannerPreviewPagerState$delegate = state;
        this.$bannerPagerState$delegate = state2;
        this.$scope = coroutineScope;
        this.$listState = lazyStaggeredGridState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$2(this.$isInPreview, this.$pageCount, this.$pageViewModel, this.$bannerPreviewPagerState$delegate, this.$bannerPagerState$delegate, this.$scope, this.$listState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int targetPage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PagerState finalPagerState = this.$isInPreview ? HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$8(this.$bannerPreviewPagerState$delegate) : HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$7(this.$bannerPagerState$delegate);
                int targetPage2 = this.$pageCount - 2;
                if (finalPagerState != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(finalPagerState);
                    this.I$0 = targetPage2;
                    this.label = 1;
                    if (PagerState.animateScrollToPage$default(finalPagerState, targetPage2, 0.0f, (AnimationSpec) null, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    targetPage = targetPage2;
                    break;
                }
                break;
            case 1:
                targetPage = this.I$0;
                PagerState pagerState = (PagerState) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.$isInPreview) {
            this.$pageViewModel.toggleHeaderFullScreenPreview$product_details_page_debug(false);
        }
        HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$scrollToDetail(this.$pageViewModel, this.$scope, this.$listState);
        return Unit.INSTANCE;
    }
}