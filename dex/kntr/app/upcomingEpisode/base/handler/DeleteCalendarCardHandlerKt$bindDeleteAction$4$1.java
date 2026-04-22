package kntr.app.upcomingEpisode.base.handler;

import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestParam;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeleteCalendarCardHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$bindDeleteAction$4$1", f = "DeleteCalendarCardHandler.kt", i = {0, 0, 0, 0}, l = {70}, m = "invokeSuspend", n = {"state", "delParam", "bizType", "bizId"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class DeleteCalendarCardHandlerKt$bindDeleteAction$4$1 extends SuspendLambda implements Function2<State<UpcomingEpisodeData>, Continuation<? super ChangedState<? extends UpcomingEpisodeData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeleteCalendarCardHandlerKt$bindDeleteAction$4$1(Continuation<? super DeleteCalendarCardHandlerKt$bindDeleteAction$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deleteCalendarCardHandlerKt$bindDeleteAction$4$1 = new DeleteCalendarCardHandlerKt$bindDeleteAction$4$1(continuation);
        deleteCalendarCardHandlerKt$bindDeleteAction$4$1.L$0 = obj;
        return deleteCalendarCardHandlerKt$bindDeleteAction$4$1;
    }

    public final Object invoke(State<UpcomingEpisodeData> state, Continuation<? super ChangedState<UpcomingEpisodeData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object deleteCalendarCard;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    RequestParam param = ((UpcomingEpisodeData) state.getSnapshot()).getRequestModel().getDelCalendarCardReqState().getParam();
                    RequestParam.DeleteCalendarReqParam delParam = param instanceof RequestParam.DeleteCalendarReqParam ? (RequestParam.DeleteCalendarReqParam) param : null;
                    if (delParam != null) {
                        KWatchBizType bizType = delParam.getBizType();
                        String bizId = delParam.getBizId();
                        KLog_androidKt.getKLog().i("DeleteCalendarCardHandler", "request deleteCalendarCard. bizType: " + bizType + ", bizId: " + bizId);
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(delParam);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(bizType);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(bizId);
                        this.label = 1;
                        deleteCalendarCard = DeleteCalendarCardHandlerKt.deleteCalendarCard(bizType, bizId, (Continuation) this);
                        if (deleteCalendarCard != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        return state.noChange();
                    }
                case 1:
                    String str = (String) this.L$3;
                    KWatchBizType kWatchBizType = (KWatchBizType) this.L$2;
                    RequestParam.DeleteCalendarReqParam deleteCalendarReqParam = (RequestParam.DeleteCalendarReqParam) this.L$1;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$bindDeleteAction$4$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    UpcomingEpisodeData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = DeleteCalendarCardHandlerKt$bindDeleteAction$4$1.invokeSuspend$lambda$0(state, (UpcomingEpisodeData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("DeleteCalendarCardHandler", "delete calendar card exception occurred. error message: " + e.getMessage());
            return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$bindDeleteAction$4$1$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    UpcomingEpisodeData invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = DeleteCalendarCardHandlerKt$bindDeleteAction$4$1.invokeSuspend$lambda$1(e, (UpcomingEpisodeData) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$0(final State $state, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$bindDeleteAction$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeleteCalendarCardHandlerKt$bindDeleteAction$4$1.invokeSuspend$lambda$0$0($state, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(State $state, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getDelCalendarCardReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), RequestStatus.Success.INSTANCE);
        ((UpcomingEpisodeData) $state.getSnapshot()).getRequestModel().getDelCalendarCardReqState().getOnReqSuccess().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$1(final Exception $e, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$bindDeleteAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = DeleteCalendarCardHandlerKt$bindDeleteAction$4$1.invokeSuspend$lambda$1$0($e, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Exception $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getDelCalendarCardReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), new RequestStatus.Error($e));
        return Unit.INSTANCE;
    }
}