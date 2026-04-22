package kntr.app.mall.product.details.page.vm;

import androidx.compose.foundation.pager.PagerState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$updateBannerContainer$topTabItems$1$1$1", f = "PageViewModel.kt", i = {}, l = {2300}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$updateBannerContainer$topTabItems$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$updateBannerContainer$topTabItems$1$1$1(PageViewModel pageViewModel, Continuation<? super PageViewModel$updateBannerContainer$topTabItems$1$1$1> continuation) {
        super(1, continuation);
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PageViewModel$updateBannerContainer$topTabItems$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PagerState pagerState = (PagerState) this.this$0.getBannerPagerState().getValue();
                if (pagerState != null) {
                    this.label = 1;
                    if (PagerState.scrollToPage$default(pagerState, 0, 0.0f, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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