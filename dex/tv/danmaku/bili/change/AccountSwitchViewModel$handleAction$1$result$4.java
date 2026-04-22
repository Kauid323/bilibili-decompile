package tv.danmaku.bili.change;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;

/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ltv/danmaku/bili/change/ISwitchAction;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1$result$4", f = "AccountSwitchFragment.kt", i = {1}, l = {BR.lbBadgeColor, BR.lbBadgeSize, BR.lbBadgeText}, m = "invokeSuspend", n = {"$this$ActionResult"}, s = {"L$0"}, v = 1)
final class AccountSwitchViewModel$handleAction$1$result$4 extends SuspendLambda implements Function2<FlowCollector<? super ISwitchAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISwitchAction $action;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchViewModel$handleAction$1$result$4(ISwitchAction iSwitchAction, Continuation<? super AccountSwitchViewModel$handleAction$1$result$4> continuation) {
        super(2, continuation);
        this.$action = iSwitchAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> accountSwitchViewModel$handleAction$1$result$4 = new AccountSwitchViewModel$handleAction$1$result$4(this.$action, continuation);
        accountSwitchViewModel$handleAction$1$result$4.L$0 = obj;
        return accountSwitchViewModel$handleAction$1$result$4;
    }

    public final Object invoke(FlowCollector<? super ISwitchAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0078 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$ActionResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$ActionResult = (FlowCollector) this.L$0;
                if (((SwitchAccountFinishedAction) this.$action).getError() != null) {
                    String message = ((SwitchAccountFinishedAction) this.$action).getError().getMessage();
                    if (message == null) {
                        message = "";
                    }
                    this.label = 1;
                    if ($this$ActionResult.emit(new ToastAction(message, 0, 2, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                this.L$0 = $this$ActionResult;
                this.label = 2;
                if ($this$ActionResult.emit(LoadAccountListAction.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.L$0 = null;
                this.label = 3;
                if ($this$ActionResult.emit(RouteToMineAction.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                $this$ActionResult = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                this.L$0 = null;
                this.label = 3;
                if ($this$ActionResult.emit(RouteToMineAction.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}