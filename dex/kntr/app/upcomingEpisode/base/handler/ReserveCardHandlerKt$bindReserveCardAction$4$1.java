package kntr.app.upcomingEpisode.base.handler;

import com.bapis.bilibili.community.interfacess.watch.v1.KRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestParam;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt;
import kntr.app.upcomingEpisode.base.util.ReservationApi;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReserveCardHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.handler.ReserveCardHandlerKt$bindReserveCardAction$4$1", f = "ReserveCardHandler.kt", i = {0, 0, 0, 0}, l = {51}, m = "invokeSuspend", n = {"state", "reserveReqParam", "bizId", "spmId"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class ReserveCardHandlerKt$bindReserveCardAction$4$1 extends SuspendLambda implements Function2<State<UpcomingEpisodeData>, Continuation<? super ChangedState<? extends UpcomingEpisodeData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReserveCardHandlerKt$bindReserveCardAction$4$1(Continuation<? super ReserveCardHandlerKt$bindReserveCardAction$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> reserveCardHandlerKt$bindReserveCardAction$4$1 = new ReserveCardHandlerKt$bindReserveCardAction$4$1(continuation);
        reserveCardHandlerKt$bindReserveCardAction$4$1.L$0 = obj;
        return reserveCardHandlerKt$bindReserveCardAction$4$1;
    }

    public final Object invoke(State<UpcomingEpisodeData> state, Continuation<? super ChangedState<UpcomingEpisodeData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final String bizId;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    RequestParam param = ((UpcomingEpisodeData) state.getSnapshot()).getRequestModel().getReserveCardReqState().getParam();
                    RequestParam.ReserveReqParam reserveReqParam = param instanceof RequestParam.ReserveReqParam ? (RequestParam.ReserveReqParam) param : null;
                    if (reserveReqParam != null) {
                        bizId = reserveReqParam.getBizId();
                        KLog_androidKt.getKLog().i("ReserveCardHandler", "request reserveCard. bizId: " + bizId + ", spmId: main.reserve-calendar.0.0");
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(reserveReqParam);
                        this.L$2 = bizId;
                        this.L$3 = SpillingKt.nullOutSpilledVariable("main.reserve-calendar.0.0");
                        this.label = 1;
                        if (ReservationApi.INSTANCE.reserveCard(bizId, "main.reserve-calendar.0.0", (Continuation) this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        return state.noChange();
                    }
                case 1:
                    String str = (String) this.L$3;
                    bizId = (String) this.L$2;
                    RequestParam.ReserveReqParam reserveReqParam2 = (RequestParam.ReserveReqParam) this.L$1;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.ReserveCardHandlerKt$bindReserveCardAction$4$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    UpcomingEpisodeData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ReserveCardHandlerKt$bindReserveCardAction$4$1.invokeSuspend$lambda$0(state, bizId, (UpcomingEpisodeData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Throwable e) {
            KLog_androidKt.getKLog().e("ReserveCardHandler", "reserve card exception occurred. error message: " + e.getMessage());
            return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.ReserveCardHandlerKt$bindReserveCardAction$4$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    UpcomingEpisodeData invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = ReserveCardHandlerKt$bindReserveCardAction$4$1.invokeSuspend$lambda$1(e, (UpcomingEpisodeData) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$0(final State $state, final String $bizId, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.ReserveCardHandlerKt$bindReserveCardAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = ReserveCardHandlerKt$bindReserveCardAction$4$1.invokeSuspend$lambda$0$0($state, $bizId, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(State $state, String $bizId, CopyScope $this$copy) {
        Iterable $this$map$iv;
        KRecommend kRecommend;
        int i;
        KReserveRecommend kReserveRecommend;
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getReserveCardReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), RequestStatus.Success.INSTANCE);
        ((UpcomingEpisodeData) $state.getSnapshot()).getRequestModel().getReserveCardReqState().getOnReqSuccess().invoke();
        Iterable $this$map$iv2 = (Iterable) $this$copy.get(UpcomingEpisodeDataLensKt.getRecommendData(UpcomingEpisodeData.Companion));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv : $this$map$iv2) {
            KRecommend item = (KRecommend) item$iv$iv;
            KReserveRecommend recommend = item.getReserveRecommend();
            if (Intrinsics.areEqual(String.valueOf(recommend != null ? Long.valueOf(recommend.getReserveId()) : null), $bizId)) {
                boolean z = false;
                if (recommend != null && recommend.getReserveState() == 0) {
                    z = true;
                }
                long toggledState = z ? 1L : 0L;
                if (recommend != null) {
                    $this$map$iv = $this$map$iv2;
                    i = 1;
                    kReserveRecommend = KReserveRecommend.copy$default(recommend, (String) null, 0L, toggledState, 0L, 0L, 0L, (Map) null, 123, (Object) null);
                } else {
                    $this$map$iv = $this$map$iv2;
                    i = 1;
                    kReserveRecommend = null;
                }
                kRecommend = KRecommend.copy$default(item, (KUpInfo) null, kReserveRecommend, i, (Object) null);
            } else {
                $this$map$iv = $this$map$iv2;
                kRecommend = item;
            }
            destination$iv$iv.add(kRecommend);
            $this$map$iv2 = $this$map$iv;
        }
        List newRecommendData = (List) destination$iv$iv;
        $this$copy.set(UpcomingEpisodeDataLensKt.getRecommendData(UpcomingEpisodeData.Companion), newRecommendData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$1(final Throwable $e, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.ReserveCardHandlerKt$bindReserveCardAction$4$1$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = ReserveCardHandlerKt$bindReserveCardAction$4$1.invokeSuspend$lambda$1$0($e, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Throwable $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getReserveCardReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), new RequestStatus.Error($e));
        return Unit.INSTANCE;
    }
}