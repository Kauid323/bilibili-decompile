package kntr.app.deepsearch.handler;

import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.stateMachine.DeepSearchStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchSessionHandler.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$6$2", f = "DeepSearchSessionHandler.kt", i = {0, 0, 0}, l = {137}, m = "invokeSuspend", n = {"it", "sessionParam", "isRefreshSession"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class DeepSearchSessionHandlerKt$bindSessionAction$6$2 extends SuspendLambda implements Function2<DeepSearchPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeepSearchStateMachine $machine;
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchSessionHandlerKt$bindSessionAction$6$2(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchSessionHandlerKt$bindSessionAction$6$2> continuation) {
        super(2, continuation);
        this.$machine = deepSearchStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchSessionHandlerKt$bindSessionAction$6$2 = new DeepSearchSessionHandlerKt$bindSessionAction$6$2(this.$machine, continuation);
        deepSearchSessionHandlerKt$bindSessionAction$6$2.L$0 = obj;
        return deepSearchSessionHandlerKt$bindSessionAction$6$2;
    }

    public final Object invoke(DeepSearchPageData deepSearchPageData, Continuation<? super Unit> continuation) {
        return create(deepSearchPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        DeepSearchPageData it = (DeepSearchPageData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestParam param = it.getRequestModel().getSessionReqState().getParam();
                RequestParam.SessionReqParam sessionParam = param instanceof RequestParam.SessionReqParam ? (RequestParam.SessionReqParam) param : null;
                int i2 = (sessionParam == null || !sessionParam.isRefreshSession()) ? 0 : 1;
                if (i2 != 0) {
                    if (it.getSessionId().length() > 0) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(sessionParam);
                        this.I$0 = i2;
                        this.label = 1;
                        if (this.$machine.dispatch(DeepSearchAction.InputAction.SenderClick.INSTANCE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = i2;
                        break;
                    }
                }
                break;
            case 1:
                i = this.I$0;
                RequestParam.SessionReqParam sessionReqParam = (RequestParam.SessionReqParam) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}