package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCursor;
import com.bapis.bilibili.im.gateway.interfaces.v1.KImGatewayApiMoss;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedFilterType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListReq;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListRsp;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgTabType;
import com.tencent.smtt.sdk.TbsListener;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/direct/notification/interactive/INAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$requestList$2", f = "INStateHolder.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {TbsListener.ErrorCode.INFO_CODE_BASE, TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR}, m = "invokeSuspend", n = {"$this$INActionResult", "requestIDBefore", "$this$INActionResult", "requestIDBefore", "response", "$this$INActionResult", "requestIDBefore", "t"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class INStateHolder$requestList$2 extends SuspendLambda implements Function2<FlowCollector<? super INAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestScope $requestScope;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ INStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$requestList$2(INStateHolder iNStateHolder, RequestScope requestScope, Continuation<? super INStateHolder$requestList$2> continuation) {
        super(2, continuation);
        this.this$0 = iNStateHolder;
        this.$requestScope = requestScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iNStateHolder$requestList$2 = new INStateHolder$requestList$2(this.this$0, this.$requestScope, continuation);
        iNStateHolder$requestList$2.L$0 = obj;
        return iNStateHolder$requestList$2;
    }

    public final Object invoke(FlowCollector<? super INAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00f2: INVOKE  (r6 I:boolean) = (r5 I:java.lang.Object A[D('requestIDBefore' java.lang.Long)]), (r6 I:java.lang.Object) type: STATIC call: kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Object, java.lang.Object):boolean, block:B:27:0x00e8 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8 A[Catch: all -> 0x00e7, TRY_LEAVE, TryCatch #0 {all -> 0x00e7, blocks: (B:8:0x002f, B:11:0x0039, B:20:0x00b5, B:22:0x00c8, B:14:0x004d, B:16:0x008e, B:17:0x0098), top: B:39:0x000f }] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        INState currentState;
        ?? r5;
        INPageType iNPageType;
        Long requestIDBefore;
        INState currentState2;
        Long requestIDBefore2;
        INPageType iNPageType2;
        KMsgTabType tabType;
        INState currentState3;
        Object msgFeedMsgList;
        INState currentState4;
        INState currentState5;
        FlowCollector $this$INActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable t) {
            currentState = this.this$0.getCurrentState();
            if (Intrinsics.areEqual((Object) r5, currentState.getRequestID$interactive_debug())) {
                if (t instanceof CancellationException) {
                    throw t;
                }
                ILogger kLog = KLog_androidKt.getKLog();
                iNPageType = this.this$0.pageType;
                kLog.e(INStateHolderKt.TAG, "Fail to load first-page data of " + iNPageType, t);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$INActionResult);
                this.L$1 = SpillingKt.nullOutSpilledVariable((Object) r5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(t);
                this.label = 3;
                if ($this$INActionResult.emit(new INActionRequestListFail(t), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                requestIDBefore = r5;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                currentState2 = this.this$0.getCurrentState();
                requestIDBefore2 = currentState2.getRequestID$interactive_debug();
                ILogger kLog2 = KLog_androidKt.getKLog();
                iNPageType2 = this.this$0.pageType;
                kLog2.i(INStateHolderKt.TAG, "Start to load first-page data of " + iNPageType2);
                KCursor kCursor = null;
                KImGatewayApiMoss kImGatewayApiMoss = new KImGatewayApiMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                tabType = this.this$0.getTabType();
                currentState3 = this.this$0.getCurrentState();
                KMsgFeedFilterType currentFilterType = INStateKt.currentFilterType(currentState3.getFilters());
                if (this.$requestScope == RequestScope.NEXT) {
                    currentState4 = this.this$0.getCurrentState();
                    kCursor = currentState4.getCursor$interactive_debug();
                }
                this.L$0 = $this$INActionResult;
                this.L$1 = requestIDBefore2;
                this.label = 1;
                msgFeedMsgList = kImGatewayApiMoss.msgFeedMsgList(new KMsgListReq(kCursor, 20L, tabType, currentFilterType), (Continuation) this);
                if (msgFeedMsgList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                KMsgListRsp response = (KMsgListRsp) msgFeedMsgList;
                currentState5 = this.this$0.getCurrentState();
                if (Intrinsics.areEqual(requestIDBefore2, currentState5.getRequestID$interactive_debug())) {
                    this.L$0 = $this$INActionResult;
                    this.L$1 = requestIDBefore2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(response);
                    this.label = 2;
                    if ($this$INActionResult.emit(new INActionRequestListSuccess(response, this.$requestScope), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                requestIDBefore2 = (Long) this.L$1;
                ResultKt.throwOnFailure($result);
                msgFeedMsgList = $result;
                KMsgListRsp response2 = (KMsgListRsp) msgFeedMsgList;
                currentState5 = this.this$0.getCurrentState();
                if (Intrinsics.areEqual(requestIDBefore2, currentState5.getRequestID$interactive_debug())) {
                }
                return Unit.INSTANCE;
            case 2:
                KMsgListRsp kMsgListRsp = (KMsgListRsp) this.L$2;
                Long l = (Long) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Throwable th = (Throwable) this.L$2;
                requestIDBefore = (Long) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}