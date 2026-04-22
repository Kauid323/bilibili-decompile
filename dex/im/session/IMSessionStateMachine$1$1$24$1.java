package im.session;

import com.bapis.bilibili.app.im.v1.KAlertToastType;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KClearAlertReply;
import com.bapis.bilibili.app.im.v1.KClearAlertReq;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bapis.bilibili.app.im.v1.KimMoss;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lim/session/IMActionDismissBehaviorAlert;", "snapshot", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$24$1", f = "IMSessionStateMachine.kt", i = {0, 0, 0}, l = {374}, m = "invokeSuspend", n = {"snapshot", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionStateMachine$1$1$24$1$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class IMSessionStateMachine$1$1$24$1 extends SuspendLambda implements Function3<IMActionDismissBehaviorAlert, IMState, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$24$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$24$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionDismissBehaviorAlert iMActionDismissBehaviorAlert, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$1$1$24$1 iMSessionStateMachine$1$1$24$1 = new IMSessionStateMachine$1$1$24$1(this.this$0, continuation);
        iMSessionStateMachine$1$1$24$1.L$0 = iMState;
        return iMSessionStateMachine$1$1$24$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        String str;
        String str2;
        KAlertToastType kAlertToastType;
        Object clearAlert;
        KBehaviorAlertToast behaviorAlertToast;
        IMState snapshot = (IMState) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Result.Companion companion = Result.Companion;
                    KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    KSessionListExtraInfo extraInfo = snapshot.getData().getExtraInfo();
                    if (extraInfo == null || (behaviorAlertToast = extraInfo.getBehaviorAlertToast()) == null || (kAlertToastType = behaviorAlertToast.getType()) == null) {
                        kAlertToastType = KAlertToastType.ALERT_TOAST_TYPE_UNSPECIFIED.INSTANCE;
                    }
                    KClearAlertReq kClearAlertReq = new KClearAlertReq(kAlertToastType);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(snapshot);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    clearAlert = kimMoss.clearAlert(kClearAlertReq, this);
                    if (clearAlert != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i2 = this.I$1;
                    int i3 = this.I$0;
                    ResultKt.throwOnFailure($result);
                    clearAlert = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = Result.constructor-impl((KClearAlertReply) clearAlert);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        JobKt.ensureActive(getContext());
        IMSessionStateMachine iMSessionStateMachine = this.this$0;
        if (Result.isSuccess-impl(obj)) {
            KClearAlertReply kClearAlertReply = (KClearAlertReply) obj;
            ILogger kLog = KLog_androidKt.getKLog();
            str2 = iMSessionStateMachine.sessionLogTag;
            kLog.i(str2, "行为警告弹窗消除成功");
        }
        IMSessionStateMachine iMSessionStateMachine2 = this.this$0;
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            ILogger kLog2 = KLog_androidKt.getKLog();
            str = iMSessionStateMachine2.sessionLogTag;
            kLog2.e(str, "行为警告弹窗消除失败", it);
        }
        return Unit.INSTANCE;
    }
}