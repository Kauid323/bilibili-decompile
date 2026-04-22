package kntr.app.ad.ui.inspector.ui;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.State;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InspectorScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.InspectorScreenKt$SimplisticMainContent$3$1", f = "InspectorScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InspectorScreenKt$SimplisticMainContent$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<Integer, Unit>> $onTabSelectState;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ int $selectedTabIndex;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InspectorScreenKt$SimplisticMainContent$3$1(int i, PagerState pagerState, State<? extends Function1<? super Integer, Unit>> state, Continuation<? super InspectorScreenKt$SimplisticMainContent$3$1> continuation) {
        super(2, continuation);
        this.$selectedTabIndex = i;
        this.$pagerState = pagerState;
        this.$onTabSelectState = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InspectorScreenKt$SimplisticMainContent$3$1(this.$selectedTabIndex, this.$pagerState, this.$onTabSelectState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$selectedTabIndex != this.$pagerState.getCurrentPage()) {
                    ((Function1) this.$onTabSelectState.getValue()).invoke(Boxing.boxInt(this.$pagerState.getCurrentPage()));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}