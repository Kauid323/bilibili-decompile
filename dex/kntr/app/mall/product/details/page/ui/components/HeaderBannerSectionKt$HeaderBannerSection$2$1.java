package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeaderBannerSection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$2$1", f = "HeaderBannerSection.kt", i = {0}, l = {164}, m = "invokeSuspend", n = {"currentPage"}, s = {"I$0"}, v = 1)
public final class HeaderBannerSectionKt$HeaderBannerSection$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<PagerState> $bannerPagerState$delegate;
    final /* synthetic */ State<PagerState> $bannerPreviewPagerState$delegate;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBannerSectionKt$HeaderBannerSection$2$1(State<? extends PagerState> state, State<? extends PagerState> state2, Continuation<? super HeaderBannerSectionKt$HeaderBannerSection$2$1> continuation) {
        super(2, continuation);
        this.$bannerPreviewPagerState$delegate = state;
        this.$bannerPagerState$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderBannerSectionKt$HeaderBannerSection$2$1(this.$bannerPreviewPagerState$delegate, this.$bannerPagerState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        r3 = kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$7(r9.$bannerPagerState$delegate);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PagerState HeaderBannerSection_gSuKmCU$lambda$8;
        PagerState HeaderBannerSection_gSuKmCU$lambda$7;
        PagerState HeaderBannerSection_gSuKmCU$lambda$72;
        int currentPage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HeaderBannerSection_gSuKmCU$lambda$8 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$8(this.$bannerPreviewPagerState$delegate);
                boolean z = false;
                int currentPage2 = HeaderBannerSection_gSuKmCU$lambda$8 != null ? HeaderBannerSection_gSuKmCU$lambda$8.getCurrentPage() : 0;
                HeaderBannerSection_gSuKmCU$lambda$7 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$7(this.$bannerPagerState$delegate);
                if (HeaderBannerSection_gSuKmCU$lambda$7 != null && HeaderBannerSection_gSuKmCU$lambda$7.getCurrentPage() == currentPage2) {
                    z = true;
                }
                if (!z && HeaderBannerSection_gSuKmCU$lambda$72 != null) {
                    this.I$0 = currentPage2;
                    this.label = 1;
                    if (PagerState.scrollToPage$default(HeaderBannerSection_gSuKmCU$lambda$72, currentPage2, 0.0f, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentPage = currentPage2;
                    break;
                }
                break;
            case 1:
                currentPage = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}