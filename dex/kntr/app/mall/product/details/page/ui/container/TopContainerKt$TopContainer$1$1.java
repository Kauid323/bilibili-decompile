package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopContainer$1$1", f = "TopContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TopContainerKt$TopContainer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: $$v$c$androidx-compose-ui-unit-Dp$-topPadding$0  reason: not valid java name */
    final /* synthetic */ float f5$$v$c$androidxcomposeuiunitDp$topPadding$0;
    final /* synthetic */ Density $density;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ State<UiScaleModel> $scaleModel$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopContainerKt$TopContainer$1$1(float f, Density density, PageViewModel pageViewModel, State<UiScaleModel> state, Continuation<? super TopContainerKt$TopContainer$1$1> continuation) {
        super(2, continuation);
        this.f5$$v$c$androidxcomposeuiunitDp$topPadding$0 = f;
        this.$density = density;
        this.$pageViewModel = pageViewModel;
        this.$scaleModel$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TopContainerKt$TopContainer$1$1(this.f5$$v$c$androidxcomposeuiunitDp$topPadding$0, this.$density, this.$pageViewModel, this.$scaleModel$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UiScaleModel TopContainer_EUb7tLY$lambda$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                float f = this.f5$$v$c$androidxcomposeuiunitDp$topPadding$0;
                TopContainer_EUb7tLY$lambda$0 = TopContainerKt.TopContainer_EUb7tLY$lambda$0(this.$scaleModel$delegate);
                float f2 = Dp.constructor-impl(f + ProvideUiScaleKt.dpScaled(76, TopContainer_EUb7tLY$lambda$0.getScale()));
                Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                int heightInPixels = MathKt.roundToInt($this$invokeSuspend_u24lambda_u240.toPx-0680j_4(f2));
                this.$pageViewModel.updateTopContainerHeight$product_details_page_debug(heightInPixels);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}