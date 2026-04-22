package kntr.app.ad.ui.inspector.ui;

import androidx.compose.foundation.pager.PagerState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InspectorScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.InspectorScreenKt$SimplisticMainContent$2$1", f = "InspectorScreen.kt", i = {}, l = {661}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InspectorScreenKt$SimplisticMainContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ int $selectedTabIndex;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InspectorScreenKt$SimplisticMainContent$2$1(PagerState pagerState, int i, Continuation<? super InspectorScreenKt$SimplisticMainContent$2$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$selectedTabIndex = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InspectorScreenKt$SimplisticMainContent$2$1(this.$pagerState, this.$selectedTabIndex, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$pagerState.getCurrentPage() != this.$selectedTabIndex) {
                        this.label = 1;
                        if (PagerState.scrollToPage$default(this.$pagerState, this.$selectedTabIndex, 0.0f, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
        }
        return Unit.INSTANCE;
    }
}