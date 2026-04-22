package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeaderBannerSection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$6$1", f = "HeaderBannerSection.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HeaderBannerSectionKt$HeaderBannerSection$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isInPreview;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ VideoPlayerViewModel $videoViewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBannerSectionKt$HeaderBannerSection$6$1(PageViewModel pageViewModel, boolean z, PagerState pagerState, VideoPlayerViewModel videoPlayerViewModel, Continuation<? super HeaderBannerSectionKt$HeaderBannerSection$6$1> continuation) {
        super(2, continuation);
        this.$pageViewModel = pageViewModel;
        this.$isInPreview = z;
        this.$pagerState = pagerState;
        this.$videoViewModel = videoPlayerViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderBannerSectionKt$HeaderBannerSection$6$1(this.$pageViewModel, this.$isInPreview, this.$pagerState, this.$videoViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PageViewModel pageViewModel = this.$pageViewModel;
                final boolean z = this.$isInPreview;
                final PagerState pagerState = this.$pagerState;
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$6$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Triple invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = HeaderBannerSectionKt$HeaderBannerSection$6$1.invokeSuspend$lambda$0(PageViewModel.this, z, pagerState);
                        return invokeSuspend$lambda$0;
                    }
                }));
                final VideoPlayerViewModel videoPlayerViewModel = this.$videoViewModel;
                this.label = 1;
                if (distinctUntilChanged.collect(new FlowCollector() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$6$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Triple) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Triple<Integer, Integer, Integer> triple, Continuation<? super Unit> continuation) {
                        if (triple == null) {
                            return Unit.INSTANCE;
                        }
                        int current = triple.component1().intValue();
                        int videoIdx = triple.component2().intValue();
                        int upIdx = triple.component3().intValue();
                        VideoPlayerViewModel.this.updatePauseByOther$product_details_page_debug(current != videoIdx);
                        VideoPlayerViewModel.this.upSayUpdatePauseByOther$product_details_page_debug(current != upIdx);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Triple invokeSuspend$lambda$0(PageViewModel $pageViewModel, boolean $isInPreview, PagerState $pagerState) {
        boolean active;
        if (((Boolean) $pageViewModel.getShowHeaderFullScreenPreview().getValue()).booleanValue()) {
            active = $isInPreview;
        } else {
            active = !$isInPreview;
        }
        int current = $pagerState.getCurrentPage();
        Integer bannerVideoIndex = $pageViewModel.getBannerVideoIndex();
        int videoIdx = bannerVideoIndex != null ? bannerVideoIndex.intValue() : -1;
        Integer bannerCommentOrUpSayIndex = $pageViewModel.getBannerCommentOrUpSayIndex();
        int upIdx = bannerCommentOrUpSayIndex != null ? bannerCommentOrUpSayIndex.intValue() : -1;
        if (active) {
            return new Triple(Integer.valueOf(current), Integer.valueOf(videoIdx), Integer.valueOf(upIdx));
        }
        return null;
    }
}