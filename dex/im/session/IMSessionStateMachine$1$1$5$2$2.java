package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.smtt.sdk.TbsListener;
import im.base.IMLog;
import im.session.RequestStatus;
import im.session.model.IMSessionPageData;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", UtilsKt.DATA_KEY, "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$5$2$2", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 1, 1, 1}, l = {TbsListener.ErrorCode.RENAME_NO_NEED_SENDREQUEST, 135}, m = "invokeSuspend", n = {UtilsKt.DATA_KEY, "state", "overrideQuickLink", UtilsKt.DATA_KEY, "state", "overrideQuickLink"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
public final class IMSessionStateMachine$1$1$5$2$2 extends SuspendLambda implements Function3<Result<? extends IMSessionPageData>, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$5$2$2(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$5$2$2> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(Object obj, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$5$2$2 iMSessionStateMachine$1$1$5$2$2 = new IMSessionStateMachine$1$1$5$2$2(this.this$0, continuation);
        iMSessionStateMachine$1$1$5$2$2.L$0 = obj;
        iMSessionStateMachine$1$1$5$2$2.L$1 = state;
        return iMSessionStateMachine$1$1$5$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Result) obj).unbox-impl(), (State) obj2, (Continuation) obj3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    public final Object invokeSuspend(Object $result) {
        String str;
        int i2;
        Object receive;
        Object data = this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                boolean z = Result.isSuccess-impl(data);
                IMSessionPageData iMSessionPageData = (IMSessionPageData) (Result.isFailure-impl(data) ? null : data);
                companion.i(str, "收到首页数据结果, 是否成功 " + z + ", 数据是否来自本地缓存 " + (iMSessionPageData != null ? Boxing.boxBoolean(iMSessionPageData.isCache()) : null));
                RequestStatus type$session_debug = ((IMState) state.getSnapshot()).getType$session_debug();
                RequestStatus.Loading loading = type$session_debug instanceof RequestStatus.Loading ? (RequestStatus.Loading) type$session_debug : null;
                int refreshQuickLink = loading != null ? loading.getRefreshQuickLink() : 0;
                IMSessionStateMachine iMSessionStateMachine = this.this$0;
                IMSessionPageData iMSessionPageData2 = Result.isFailure-impl(data) ? null : data;
                boolean isCache = iMSessionPageData2 != null ? iMSessionPageData2.isCache() : false;
                this.L$0 = data;
                this.L$1 = state;
                this.I$0 = refreshQuickLink;
                this.label = 1;
                if (iMSessionStateMachine.dispatch(new IMActionOnLoadFinished(isCache, Result.exceptionOrNull-impl(data)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i2 = refreshQuickLink;
                break;
            case 1:
                int i3 = this.I$0;
                ResultKt.throwOnFailure($result);
                i2 = i3;
                break;
            case 2:
                int i4 = this.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IMSessionStateMachine iMSessionStateMachine2 = this.this$0;
        boolean z2 = i2 != 0;
        this.L$0 = SpillingKt.nullOutSpilledVariable(data);
        this.L$1 = SpillingKt.nullOutSpilledVariable(state);
        this.I$0 = i2;
        this.label = 2;
        receive = iMSessionStateMachine2.receive(state, data, false, z2, (Continuation) this);
        if (receive == coroutine_suspended) {
            return coroutine_suspended;
        }
        return receive;
    }
}