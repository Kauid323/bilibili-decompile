package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KHomeMoss;
import com.bapis.bilibili.app.home.v1.KRecentReq;
import com.bapis.bilibili.app.home.v1.KRecentRes;
import com.bilibili.moss.ext.PlayerArgs;
import com.bilibili.moss.ext.PlayerArgsInstance_androidKt;
import home.sidecenter.recent.IRecentAction;
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

/* compiled from: RecentPageStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/recent/IRecentAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.recent.RecentPageStateHolder$loadData$1", f = "RecentPageStateHolder.kt", i = {0, 1, 1, 2, 2}, l = {138, 139, 142}, m = "invokeSuspend", n = {"$this$RecentActionResult", "$this$RecentActionResult", "result", "$this$RecentActionResult", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
final class RecentPageStateHolder$loadData$1 extends SuspendLambda implements Function2<FlowCollector<? super IRecentAction>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecentPageStateHolder$loadData$1(Continuation<? super RecentPageStateHolder$loadData$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> recentPageStateHolder$loadData$1 = new RecentPageStateHolder$loadData$1(continuation);
        recentPageStateHolder$loadData$1.L$0 = obj;
        return recentPageStateHolder$loadData$1;
    }

    public final Object invoke(FlowCollector<? super IRecentAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object recent;
        KRecentRes result;
        FlowCollector $this$RecentActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            KLog_androidKt.getKLog().e("RecentPageStateHolder", "Fail to load data", e2);
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$RecentActionResult);
            this.L$1 = SpillingKt.nullOutSpilledVariable(e2);
            this.label = 3;
            if ($this$RecentActionResult.emit(new IRecentAction.LoadDataFailed(e2), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("RecentPageStateHolder", "Start load recent page data");
                this.L$0 = $this$RecentActionResult;
                this.label = 1;
                recent = new KHomeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).recent(new KRecentReq(PlayerArgs.-CC.getPlayerArgs$default(PlayerArgsInstance_androidKt.getPlayerArgsInstance(), false, 1, (Object) null)), (Continuation) this);
                if (recent == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (KRecentRes) recent;
                this.L$0 = $this$RecentActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$RecentActionResult.emit(new IRecentAction.LoadDataSuccess(new RecentPageState(result)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                recent = $result;
                result = (KRecentRes) recent;
                this.L$0 = $this$RecentActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$RecentActionResult.emit(new IRecentAction.LoadDataSuccess(new RecentPageState(result)), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                KRecentRes kRecentRes = (KRecentRes) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}