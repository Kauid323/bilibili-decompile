package kntr.app.upcomingEpisode.base.handler;

import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import com.bapis.bilibili.community.interfacess.watch.v1.KFeatures;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchCalendarResp;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestFrom;
import kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestParam;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kntr.app.upcomingEpisode.list.model.CalendarCardKt;
import kntr.app.upcomingEpisode.list.model.CalendarDate;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.datetime.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchCalendarHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1", f = "WatchCalendarHandler.kt", i = {0, 0, 0}, l = {85}, m = "invokeSuspend", n = {"state", "watchCalendarReqParam", "timeRange"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class WatchCalendarHandlerKt$bindCalendarAction$4$1 extends SuspendLambda implements Function2<State<UpcomingEpisodeData>, Continuation<? super ChangedState<? extends UpcomingEpisodeData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchCalendarHandlerKt$bindCalendarAction$4$1(Continuation<? super WatchCalendarHandlerKt$bindCalendarAction$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> watchCalendarHandlerKt$bindCalendarAction$4$1 = new WatchCalendarHandlerKt$bindCalendarAction$4$1(continuation);
        watchCalendarHandlerKt$bindCalendarAction$4$1.L$0 = obj;
        return watchCalendarHandlerKt$bindCalendarAction$4$1;
    }

    public final Object invoke(State<UpcomingEpisodeData> state, Continuation<? super ChangedState<UpcomingEpisodeData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Exception e;
        final KCalendarTimeRange timeRange;
        Object watchCalendar;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestParam param = ((UpcomingEpisodeData) state.getSnapshot()).getRequestModel().getWatchCalendarReqState().getParam();
                RequestParam.WatchCalendarReqParam watchCalendarReqParam = param instanceof RequestParam.WatchCalendarReqParam ? (RequestParam.WatchCalendarReqParam) param : null;
                if (watchCalendarReqParam != null) {
                    KCalendarTimeRange timeRange2 = watchCalendarReqParam.getTimeRange();
                    try {
                        KLog_androidKt.getKLog().i("WatchCalendarHandler", "request watchCalendar. timeRange: " + timeRange2);
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(watchCalendarReqParam);
                        this.L$2 = timeRange2;
                        this.label = 1;
                        watchCalendar = WatchCalendarHandlerKt.watchCalendar(timeRange2, new KFeatures(((Boolean) UpcomingEpisodeDataLensKt.getFeature(UpcomingEpisodeData.Companion).get(state.getSnapshot())).booleanValue()), (Continuation) this);
                        if (watchCalendar == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        timeRange = timeRange2;
                        final KWatchCalendarResp response = (KWatchCalendarResp) watchCalendar;
                        return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                UpcomingEpisodeData invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = WatchCalendarHandlerKt$bindCalendarAction$4$1.invokeSuspend$lambda$0(response, timeRange, (UpcomingEpisodeData) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    } catch (Exception e2) {
                        e = e2;
                        timeRange = timeRange2;
                        KLog_androidKt.getKLog().e("WatchCalendarHandler", "watch calendar exception occurred. error message: " + e.getMessage());
                        return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                UpcomingEpisodeData invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = WatchCalendarHandlerKt$bindCalendarAction$4$1.invokeSuspend$lambda$1(e, timeRange, (UpcomingEpisodeData) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                }
                return state.noChange();
            case 1:
                timeRange = (KCalendarTimeRange) this.L$2;
                RequestParam.WatchCalendarReqParam watchCalendarReqParam2 = (RequestParam.WatchCalendarReqParam) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    watchCalendar = $result;
                    final KWatchCalendarResp response2 = (KWatchCalendarResp) watchCalendar;
                    return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            UpcomingEpisodeData invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = WatchCalendarHandlerKt$bindCalendarAction$4$1.invokeSuspend$lambda$0(response2, timeRange, (UpcomingEpisodeData) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Exception e3) {
                    e = e3;
                    KLog_androidKt.getKLog().e("WatchCalendarHandler", "watch calendar exception occurred. error message: " + e.getMessage());
                    return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            UpcomingEpisodeData invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = WatchCalendarHandlerKt$bindCalendarAction$4$1.invokeSuspend$lambda$1(e, timeRange, (UpcomingEpisodeData) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$0(final KWatchCalendarResp $response, final KCalendarTimeRange $timeRange, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = WatchCalendarHandlerKt$bindCalendarAction$4$1.invokeSuspend$lambda$0$0($response, $timeRange, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(KWatchCalendarResp $response, KCalendarTimeRange $timeRange, CopyScope $this$copy) {
        CalendarType type;
        if (!$response.getCalendarItem().isEmpty()) {
            Map map = (SnapshotStateMap) $this$copy.get(UpcomingEpisodeDataLensKt.getCardListMap(UpcomingEpisodeData.Companion));
            Map map2 = (SnapshotStateMap) $this$copy.get(UpcomingEpisodeDataLensKt.getPointTypeMap(UpcomingEpisodeData.Companion));
            Iterable $this$forEach$iv = CalendarCardKt.transformToDates($response.getCalendarItem());
            for (Object element$iv : $this$forEach$iv) {
                CalendarDate it = (CalendarDate) element$iv;
                LocalDate date = BiliCalendarExtensionsKt.toLocalDate$default(it.getItemDate(), null, 1, null);
                if (!map.containsKey(date)) {
                    map.put(date, it.getCardList());
                }
                if (!map2.containsKey(date)) {
                    map2.put(date, it.getPointType());
                }
            }
        }
        if (((Boolean) $this$copy.get(UpcomingEpisodeDataLensKt.getFeature(UpcomingEpisodeData.Companion))).booleanValue()) {
            $this$copy.set(UpcomingEpisodeDataLensKt.getFeature(UpcomingEpisodeData.Companion), false);
            $this$copy.set(UpcomingEpisodeDataLensKt.getRecommendData(UpcomingEpisodeData.Companion), $response.getRecommend());
        }
        SnapshotStateSet pageSet = (SnapshotStateSet) $this$copy.get(UpcomingEpisodeDataLensKt.getPageSet(UpcomingEpisodeData.Companion));
        pageSet.add(BiliCalendarExtensionsKt.toLocalDate$default($timeRange.getBeginDate(), null, 1, null));
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), RequestStatus.Success.INSTANCE);
        $this$copy.set(RequestStateLensKt.getFrom(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), RequestFrom.Default.INSTANCE);
        if (!((Boolean) $this$copy.get(UpcomingEpisodeDataLensKt.getHasRequestCalendarApi(UpcomingEpisodeData.Companion))).booleanValue()) {
            type = WatchCalendarHandlerKt.calculateCalendarType(BiliCalendarExtensionsKt.now$default(LocalDate.Companion, null, null, 3, null), $response.getCalendarItem());
            $this$copy.set(UpcomingEpisodeDataLensKt.getCalendarType(UpcomingEpisodeData.Companion), type);
            $this$copy.set(UpcomingEpisodeDataLensKt.getHasRequestCalendarApi(UpcomingEpisodeData.Companion), true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$1(final Exception $e, final KCalendarTimeRange $timeRange, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$4$1$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = WatchCalendarHandlerKt$bindCalendarAction$4$1.invokeSuspend$lambda$1$0($e, $timeRange, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Exception $e, KCalendarTimeRange $timeRange, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), new RequestStatus.Error($e));
        $this$copy.set(RequestStateLensKt.getFrom(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), RequestFrom.Default.INSTANCE);
        SnapshotStateSet pageSet = (SnapshotStateSet) $this$copy.get(UpcomingEpisodeDataLensKt.getPageSet(UpcomingEpisodeData.Companion));
        LocalDate beginLocalDate = BiliCalendarExtensionsKt.toLocalDate$default($timeRange.getBeginDate(), null, 1, null);
        if (pageSet.contains(beginLocalDate)) {
            pageSet.add(beginLocalDate);
        }
        if (!((Boolean) $this$copy.get(UpcomingEpisodeDataLensKt.getHasRequestCalendarApi(UpcomingEpisodeData.Companion))).booleanValue()) {
            $this$copy.set(UpcomingEpisodeDataLensKt.getHasRequestCalendarApi(UpcomingEpisodeData.Companion), true);
        }
        return Unit.INSTANCE;
    }
}