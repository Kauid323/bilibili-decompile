package kntr.app.upcomingEpisode;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import kntr.app.upcomingEpisode.base.UpcomingEpisodeViewModel;
import kntr.app.upcomingEpisode.base.stateMachine.RequestFrom;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UpcomingEpisodePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.UpcomingEpisodePageKt$UpcomingEpisodePage$1$1", f = "UpcomingEpisodePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UpcomingEpisodePageKt$UpcomingEpisodePage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KCalendarTimeRange $timeRange;
    final /* synthetic */ UpcomingEpisodeViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpcomingEpisodePageKt$UpcomingEpisodePage$1$1(UpcomingEpisodeViewModel upcomingEpisodeViewModel, KCalendarTimeRange kCalendarTimeRange, Continuation<? super UpcomingEpisodePageKt$UpcomingEpisodePage$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = upcomingEpisodeViewModel;
        this.$timeRange = kCalendarTimeRange;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpcomingEpisodePageKt$UpcomingEpisodePage$1$1(this.$viewModel, this.$timeRange, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$viewModel.dispatch(new UpcomingEpisodeAction.WatchCalendar(this.$timeRange, RequestFrom.Initial.INSTANCE));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}