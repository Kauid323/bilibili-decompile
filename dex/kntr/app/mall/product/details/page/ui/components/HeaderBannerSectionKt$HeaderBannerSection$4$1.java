package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$4$1", f = "HeaderBannerSection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HeaderBannerSectionKt$HeaderBannerSection$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $accumulatedOffsetPx$delegate;
    final /* synthetic */ MutableState<Boolean> $firedThisGesture$delegate;
    final /* synthetic */ MutableState<Boolean> $gestureStarted$delegate;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBannerSectionKt$HeaderBannerSection$4$1(PagerState pagerState, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableFloatState mutableFloatState, Continuation<? super HeaderBannerSectionKt$HeaderBannerSection$4$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$firedThisGesture$delegate = mutableState;
        this.$gestureStarted$delegate = mutableState2;
        this.$accumulatedOffsetPx$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderBannerSectionKt$HeaderBannerSection$4$1(this.$pagerState, this.$firedThisGesture$delegate, this.$gestureStarted$delegate, this.$accumulatedOffsetPx$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean HeaderBannerSection_gSuKmCU$lambda$18;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$pagerState.isScrollInProgress()) {
                    HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$11(this.$firedThisGesture$delegate, false);
                    HeaderBannerSection_gSuKmCU$lambda$18 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$18(this.$gestureStarted$delegate);
                    if (HeaderBannerSection_gSuKmCU$lambda$18) {
                        HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$19(this.$gestureStarted$delegate, false);
                        this.$accumulatedOffsetPx$delegate.setFloatValue(0.0f);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}