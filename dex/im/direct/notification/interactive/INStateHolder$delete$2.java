package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KDelMsgCardReq;
import com.bapis.bilibili.im.gateway.interfaces.v1.KImGatewayApiMoss;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgTabType;
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
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$delete$2", f = "INStateHolder.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {512, 521, 527}, m = "invokeSuspend", n = {"$this$INActionResult", "msgType", "msgID", "$this$INActionResult", "msgType", "msgID", "$this$INActionResult", "msgType", "t", "msgID"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"}, v = 1)
public final class INStateHolder$delete$2 extends SuspendLambda implements Function2<FlowCollector<? super INAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ INMessageCard $card;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ INStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$delete$2(INMessageCard iNMessageCard, INStateHolder iNStateHolder, Continuation<? super INStateHolder$delete$2> continuation) {
        super(2, continuation);
        this.$card = iNMessageCard;
        this.this$0 = iNStateHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iNStateHolder$delete$2 = new INStateHolder$delete$2(this.$card, this.this$0, continuation);
        iNStateHolder$delete$2.L$0 = obj;
        return iNStateHolder$delete$2;
    }

    public final Object invoke(FlowCollector<? super INAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0040: MOVE  (r11 I:??[long, double]) = (r4 I:??[long, double] A[D('msgID' long)]), block:B:14:0x0040 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0041: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY] A[D('msgType' com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgType)]), block:B:14:0x0040 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        long msgID;
        long msgID2;
        KMsgFeedMsgType msgType;
        KMsgFeedMsgType msgType2;
        long msgID3;
        INPageType iNPageType;
        KImGatewayApiMoss kImGatewayApiMoss;
        KMsgTabType tabType;
        INState currentState;
        long msgID4;
        KMsgFeedMsgType msgType3;
        FlowCollector $this$INActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            t = th;
            msgID2 = msgID;
            msgType2 = msgType;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                msgID2 = this.$card.getMessage().getMsgId();
                KMsgFeedMsgType msgType4 = this.$card.getMessage().getMsgType();
                try {
                    ILogger kLog = KLog_androidKt.getKLog();
                    iNPageType = this.this$0.pageType;
                    kLog.i(INStateHolderKt.TAG, "Start to delete message. msgID = " + msgID2 + ", msgType = " + msgType4 + " pageType = " + iNPageType);
                    kImGatewayApiMoss = new KImGatewayApiMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    tabType = this.this$0.getTabType();
                    currentState = this.this$0.getCurrentState();
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(msgType4);
                    this.J$0 = msgID2;
                    this.label = 1;
                } catch (Throwable th2) {
                    t = th2;
                    msgType2 = msgType4;
                    if (t instanceof CancellationException) {
                        throw t;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$INActionResult);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(msgType2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(t);
                    this.J$0 = msgID2;
                    this.label = 3;
                    if ($this$INActionResult.emit(new INActionDeleteFail(t), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    msgID3 = msgID2;
                    return Unit.INSTANCE;
                }
                if (kImGatewayApiMoss.delMsgCard(new KDelMsgCardReq(msgID2, tabType, msgType4, INStateKt.currentFilterType(currentState.getFilters()), this.$card.isPinned()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                msgID4 = msgID2;
                msgType3 = msgType4;
                this.L$0 = $this$INActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(msgType3);
                this.J$0 = msgID4;
                this.label = 2;
                if ($this$INActionResult.emit(new INActionDeleteSuccess(this.$card), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                msgID4 = this.J$0;
                msgType3 = (KMsgFeedMsgType) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$INActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(msgType3);
                this.J$0 = msgID4;
                this.label = 2;
                if ($this$INActionResult.emit(new INActionDeleteSuccess(this.$card), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                long j = this.J$0;
                KMsgFeedMsgType kMsgFeedMsgType = (KMsgFeedMsgType) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                msgID3 = this.J$0;
                Throwable th3 = (Throwable) this.L$2;
                msgType2 = (KMsgFeedMsgType) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}