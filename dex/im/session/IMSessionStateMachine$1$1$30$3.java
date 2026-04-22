package im.session;

import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KClearBubbleMsgReq;
import com.bapis.bilibili.im.gateway.interfaces.v1.KClearBubbleMsgRsp;
import com.bapis.bilibili.im.gateway.interfaces.v1.KImGatewayApiMoss;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgTabType;
import im.base.IMLog;
import im.session.model.IMQuickLink;
import im.session.model.IMQuickLinkKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lim/session/IMActionDismissQuickLinkBubble;", "state", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$30$3", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 0, 0}, l = {456}, m = "invokeSuspend", n = {"state", "item", "reqType", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionStateMachine$1$1$30$3$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
public final class IMSessionStateMachine$1$1$30$3 extends SuspendLambda implements Function3<IMActionDismissQuickLinkBubble, IMState, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$30$3(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$30$3> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionDismissQuickLinkBubble iMActionDismissQuickLinkBubble, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$1$1$30$3 iMSessionStateMachine$1$1$30$3 = new IMSessionStateMachine$1$1$30$3(this.this$0, continuation);
        iMSessionStateMachine$1$1$30$3.L$0 = iMState;
        return iMSessionStateMachine$1$1$30$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KQuickLinkItemType item;
        String str;
        KMsgTabType reqType;
        Object clearBubbleMsg;
        KMsgTabType reqType2;
        KQuickLinkItemType item2;
        KQuickLinkBubble bubble;
        Object obj;
        Throwable it;
        String str2;
        String str3;
        IMState state = (IMState) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMQuickLink quickLinks = state.getData().getQuickLinks();
                item = (quickLinks == null || (bubble = quickLinks.getBubble()) == null) ? null : bubble.getQuickLinkItem();
                KMsgTabType reqType3 = item != null ? IMQuickLinkKt.mapToOldType(item) : null;
                if (reqType3 != null) {
                    IMLog.Companion companion = IMLog.Companion;
                    str = this.this$0.sessionLogTag;
                    companion.i(str, "通知服务端清除金刚位气泡(ClearBubbleMsg) " + item + ", 映射服务端proto金刚位类型 " + reqType3);
                    try {
                        Result.Companion companion2 = Result.Companion;
                        KImGatewayApiMoss kImGatewayApiMoss = new KImGatewayApiMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KClearBubbleMsgReq kClearBubbleMsgReq = new KClearBubbleMsgReq(reqType3);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                        this.L$1 = item;
                        this.L$2 = reqType3;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        clearBubbleMsg = kImGatewayApiMoss.clearBubbleMsg(kClearBubbleMsgReq, this);
                    } catch (Throwable th) {
                        th = th;
                        reqType = reqType3;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        JobKt.ensureActive(getContext());
                        IMSessionStateMachine iMSessionStateMachine = this.this$0;
                        if (Result.isSuccess-impl(obj)) {
                        }
                        IMSessionStateMachine iMSessionStateMachine2 = this.this$0;
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (clearBubbleMsg == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    reqType2 = reqType3;
                    item2 = item;
                    try {
                        obj = Result.constructor-impl((KClearBubbleMsgRsp) clearBubbleMsg);
                        reqType = reqType2;
                        item = item2;
                    } catch (Throwable th2) {
                        th = th2;
                        reqType = reqType2;
                        item = item2;
                        Result.Companion companion32 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        JobKt.ensureActive(getContext());
                        IMSessionStateMachine iMSessionStateMachine3 = this.this$0;
                        if (Result.isSuccess-impl(obj)) {
                        }
                        IMSessionStateMachine iMSessionStateMachine22 = this.this$0;
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    JobKt.ensureActive(getContext());
                    IMSessionStateMachine iMSessionStateMachine32 = this.this$0;
                    if (Result.isSuccess-impl(obj)) {
                        KClearBubbleMsgRsp kClearBubbleMsgRsp = (KClearBubbleMsgRsp) obj;
                        ILogger kLog = KLog_androidKt.getKLog();
                        str3 = iMSessionStateMachine32.sessionLogTag;
                        kLog.i(str3, "清除金刚位气泡(ClearBubbleMsg)成功, " + item + ", 映射服务端proto金刚位类型 " + reqType);
                    }
                    IMSessionStateMachine iMSessionStateMachine222 = this.this$0;
                    it = Result.exceptionOrNull-impl(obj);
                    if (it != null) {
                        ILogger kLog2 = KLog_androidKt.getKLog();
                        str2 = iMSessionStateMachine222.sessionLogTag;
                        kLog2.e(str2, "清除金刚位气泡(ClearBubbleMsg)失败, " + item + ", 映射服务端proto金刚位类型 " + reqType, it);
                    }
                }
                break;
            case 1:
                int i2 = this.I$1;
                int i3 = this.I$0;
                reqType = (KMsgTabType) this.L$2;
                item = (KQuickLinkItemType) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    item2 = item;
                    reqType2 = reqType;
                    clearBubbleMsg = $result;
                    obj = Result.constructor-impl((KClearBubbleMsgRsp) clearBubbleMsg);
                    reqType = reqType2;
                    item = item2;
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion322 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    JobKt.ensureActive(getContext());
                    IMSessionStateMachine iMSessionStateMachine322 = this.this$0;
                    if (Result.isSuccess-impl(obj)) {
                    }
                    IMSessionStateMachine iMSessionStateMachine2222 = this.this$0;
                    it = Result.exceptionOrNull-impl(obj);
                    if (it != null) {
                    }
                    return Unit.INSTANCE;
                }
                JobKt.ensureActive(getContext());
                IMSessionStateMachine iMSessionStateMachine3222 = this.this$0;
                if (Result.isSuccess-impl(obj)) {
                }
                IMSessionStateMachine iMSessionStateMachine22222 = this.this$0;
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}