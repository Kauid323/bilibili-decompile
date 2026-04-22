package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KImGatewayApiMoss;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KSetMsgFeedNoticeReq;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/direct/notification/interactive/INAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$mute$2", f = "INStateHolder.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {544, 554, 561}, m = "invokeSuspend", n = {"$this$INActionResult", "bizType", "msgID", "$this$INActionResult", "bizType", "msgID", "$this$INActionResult", "bizType", "t", "msgID"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"}, v = 1)
public final class INStateHolder$mute$2 extends SuspendLambda implements Function2<FlowCollector<? super INAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ INMessageCard $card;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ INStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$mute$2(INMessageCard iNMessageCard, INStateHolder iNStateHolder, Continuation<? super INStateHolder$mute$2> continuation) {
        super(2, continuation);
        this.$card = iNMessageCard;
        this.this$0 = iNStateHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iNStateHolder$mute$2 = new INStateHolder$mute$2(this.$card, this.this$0, continuation);
        iNStateHolder$mute$2.L$0 = obj;
        return iNStateHolder$mute$2;
    }

    public final Object invoke(FlowCollector<? super INAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        long msgID;
        String bizType;
        KImGatewayApiMoss kImGatewayApiMoss;
        KMsgFeedMsgType msgType;
        int i2;
        boolean isPinned;
        INState currentState;
        String bizType2;
        KCommonMsgCard common2;
        INMessageCard iNMessageCard;
        long msgID2;
        FlowCollector $this$INActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                msgID = this.$card.getMessage().getMsgId();
                INMessageCard it = this.$card;
                if (!Intrinsics.areEqual(it.getMessage().getMsgType(), KMsgFeedMsgType.REPLY_MSG.INSTANCE)) {
                    it = null;
                }
                String bizType3 = (it == null || (common2 = it.getCommon()) == null) ? null : common2.getBizType();
                if (bizType3 == null) {
                    bizType3 = "";
                }
                String bizType4 = bizType3;
                try {
                    KLog_androidKt.getKLog().i(INStateHolderKt.TAG, "Start to set notice. msgID = " + msgID);
                    kImGatewayApiMoss = new KImGatewayApiMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    msgType = this.$card.getMessage().getMsgType();
                    i2 = this.$card.isMuted() ? 0 : 1;
                    isPinned = this.$card.isPinned();
                    currentState = this.this$0.getCurrentState();
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(bizType4);
                    this.J$0 = msgID;
                    this.label = 1;
                } catch (Throwable th) {
                    t = th;
                    bizType = bizType4;
                    if (!(t instanceof CancellationException)) {
                    }
                }
                if (kImGatewayApiMoss.setMsgFeedNotice(new KSetMsgFeedNoticeReq(msgID, msgType, i2, isPinned, bizType4, INStateKt.currentFilterType(currentState.getFilters())), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bizType2 = bizType4;
                try {
                    iNMessageCard = this.$card;
                    if (!this.$card.isMuted()) {
                        z = false;
                    }
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(bizType2);
                    this.J$0 = msgID;
                    this.label = 2;
                } catch (Throwable th2) {
                    t = th2;
                    bizType = bizType2;
                    if (!(t instanceof CancellationException)) {
                        throw t;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$INActionResult);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(bizType);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(t);
                    this.J$0 = msgID;
                    this.label = 3;
                    if ($this$INActionResult.emit(new INActionMuteMsgFail(this.$card, t), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    msgID2 = msgID;
                }
                return $this$INActionResult.emit(new INActionMuteMsgSuccess(iNMessageCard, z), (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                long msgID3 = this.J$0;
                String bizType5 = (String) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    msgID = msgID3;
                    bizType2 = bizType5;
                    iNMessageCard = this.$card;
                    if (!this.$card.isMuted()) {
                    }
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(bizType2);
                    this.J$0 = msgID;
                    this.label = 2;
                    if ($this$INActionResult.emit(new INActionMuteMsgSuccess(iNMessageCard, z), (Continuation) this) != coroutine_suspended) {
                    }
                } catch (Throwable th3) {
                    t = th3;
                    msgID = msgID3;
                    bizType = bizType5;
                    if (!(t instanceof CancellationException)) {
                    }
                }
                break;
            case 2:
                long msgID4 = this.J$0;
                String bizType6 = (String) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Throwable th4) {
                    t = th4;
                    msgID = msgID4;
                    bizType = bizType6;
                    if (!(t instanceof CancellationException)) {
                    }
                }
            case 3:
                msgID2 = this.J$0;
                Throwable th5 = (Throwable) this.L$2;
                bizType = (String) this.L$1;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}