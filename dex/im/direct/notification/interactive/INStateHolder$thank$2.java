package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KImGatewayApiMoss;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedActionReq;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedActionRsp;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedActionThankParams;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedActionType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgType;
import java.util.concurrent.CancellationException;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/direct/notification/interactive/INAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$thank$2", f = "INStateHolder.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2}, l = {482, 492, 498}, m = "invokeSuspend", n = {"$this$INActionResult", "thankCtrl", "actionType", "params", "$this$INActionResult", "thankCtrl", "actionType", "params", "response", "$this$INActionResult", "thankCtrl", "t"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"}, v = 1)
public final class INStateHolder$thank$2 extends SuspendLambda implements Function2<FlowCollector<? super INAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ INMessageCard $card;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ INStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$thank$2(INMessageCard iNMessageCard, INStateHolder iNStateHolder, Continuation<? super INStateHolder$thank$2> continuation) {
        super(2, continuation);
        this.$card = iNMessageCard;
        this.this$0 = iNStateHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iNStateHolder$thank$2 = new INStateHolder$thank$2(this.$card, this.this$0, continuation);
        iNStateHolder$thank$2.L$0 = obj;
        return iNStateHolder$thank$2;
    }

    public final Object invoke(FlowCollector<? super INAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x013b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ThankCtrl thankCtrl;
        ThankCtrl thankCtrl2;
        INPageType iNPageType;
        INState currentState;
        Object msgFeedAction;
        KMsgFeedActionType kMsgFeedActionType;
        ThankCtrl thankCtrl3;
        KMsgFeedActionThankParams params;
        KMsgFeedActionRsp response;
        FlowCollector $this$INActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            t = th;
            thankCtrl = thankCtrl3;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                thankCtrl = this.$card.getThankCtrl();
                if (thankCtrl != null && !thankCtrl.isSelected()) {
                    try {
                        ILogger kLog = KLog_androidKt.getKLog();
                        long msgId = this.$card.getMessage().getMsgId();
                        iNPageType = this.this$0.pageType;
                        kLog.i(INStateHolderKt.TAG, "Start to thank message. msgID = " + msgId + ", " + iNPageType);
                        KMsgFeedActionType kMsgFeedActionType2 = KMsgFeedActionType.MSG_FEED_ACTION_TYPE_THANK.INSTANCE;
                        KMsgFeedActionThankParams params2 = new KMsgFeedActionThankParams(thankCtrl.getReceiverMid$interactive_debug());
                        KImGatewayApiMoss kImGatewayApiMoss = new KImGatewayApiMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KMsgFeedMsgType msgType = this.$card.getMessage().getMsgType();
                        currentState = this.this$0.getCurrentState();
                        this.L$0 = $this$INActionResult;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(thankCtrl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(kMsgFeedActionType2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(params2);
                        this.label = 1;
                        msgFeedAction = kImGatewayApiMoss.msgFeedAction(new KMsgFeedActionReq(this.$card.getMessage().getMsgId(), kMsgFeedActionType2, params2, msgType, INStateKt.currentFilterType(currentState.getFilters()), this.$card.isPinned()), (Continuation) this);
                        if (msgFeedAction == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kMsgFeedActionType = kMsgFeedActionType2;
                        thankCtrl3 = thankCtrl;
                        params = params2;
                        response = (KMsgFeedActionRsp) msgFeedAction;
                        this.L$0 = $this$INActionResult;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(thankCtrl3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(kMsgFeedActionType);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(params);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                        this.label = 2;
                        if ($this$INActionResult.emit(new INActionThankSuccess(this.$card, response), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        t = th2;
                        if (t instanceof CancellationException) {
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                KMsgFeedActionThankParams params3 = (KMsgFeedActionThankParams) this.L$3;
                KMsgFeedActionType kMsgFeedActionType3 = (KMsgFeedActionType.MSG_FEED_ACTION_TYPE_THANK) this.L$2;
                ThankCtrl thankCtrl4 = (ThankCtrl) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    msgFeedAction = $result;
                    thankCtrl3 = thankCtrl4;
                    kMsgFeedActionType = kMsgFeedActionType3;
                    params = params3;
                    response = (KMsgFeedActionRsp) msgFeedAction;
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(thankCtrl3);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(kMsgFeedActionType);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(params);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                    this.label = 2;
                    if ($this$INActionResult.emit(new INActionThankSuccess(this.$card, response), (Continuation) this) == coroutine_suspended) {
                    }
                } catch (Throwable th3) {
                    t = th3;
                    thankCtrl = thankCtrl4;
                    if (t instanceof CancellationException) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$INActionResult);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(thankCtrl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(t);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        if ($this$INActionResult.emit(new INActionThankFail(t), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        thankCtrl2 = thankCtrl;
                        return Unit.INSTANCE;
                    }
                    throw t;
                }
                return Unit.INSTANCE;
            case 2:
                KMsgFeedActionRsp kMsgFeedActionRsp = (KMsgFeedActionRsp) this.L$4;
                KMsgFeedActionThankParams kMsgFeedActionThankParams = (KMsgFeedActionThankParams) this.L$3;
                KMsgFeedActionType.MSG_FEED_ACTION_TYPE_THANK msg_feed_action_type_thank = (KMsgFeedActionType.MSG_FEED_ACTION_TYPE_THANK) this.L$2;
                thankCtrl3 = (ThankCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Throwable th4 = (Throwable) this.L$2;
                thankCtrl2 = (ThankCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}