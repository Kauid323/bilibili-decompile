package tv.danmaku.bili.change;

import com.bilibili.lib.accountsui.AccountStatus;
import com.bilibili.lib.accountsui.LogoutResult;
import com.bilibili.lib.accountsui.switch.SwitchAccountHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ltv/danmaku/bili/change/ISwitchAction;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1$result$6", f = "AccountSwitchFragment.kt", i = {}, l = {BR.loadingViewVisible, BR.ltBadgeUri}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AccountSwitchViewModel$handleAction$1$result$6 extends SuspendLambda implements Function2<FlowCollector<? super ISwitchAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISwitchAction $action;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchViewModel$handleAction$1$result$6(ISwitchAction iSwitchAction, Continuation<? super AccountSwitchViewModel$handleAction$1$result$6> continuation) {
        super(2, continuation);
        this.$action = iSwitchAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> accountSwitchViewModel$handleAction$1$result$6 = new AccountSwitchViewModel$handleAction$1$result$6(this.$action, continuation);
        accountSwitchViewModel$handleAction$1$result$6.L$0 = obj;
        return accountSwitchViewModel$handleAction$1$result$6;
    }

    public final Object invoke(FlowCollector<? super ISwitchAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:19:0x0061, B:21:0x006b, B:22:0x0090, B:25:0x009a, B:26:0x009d), top: B:32:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090 A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:19:0x0061, B:21:0x006b, B:22:0x0090, B:25:0x009a, B:26:0x009d), top: B:32:0x0061 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.bilibili.lib.accountsui.LogoutResult] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object deleteAccount;
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            $result = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure((Object) $result);
                FlowCollector $this$ActionResult = (FlowCollector) this.L$0;
                this.label = 1;
                if ($this$ActionResult.emit(new RemoveFinishedAction(((RemoveAccountAction) this.$action).getAccount(), null, 2, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                deleteAccount = SwitchAccountHandler.INSTANCE.deleteAccount(((RemoveAccountAction) this.$action).getAccount().getMid(), "AccountSwitchViewModel_RemoveAccount", (Continuation) this);
                if (deleteAccount != coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result3 = deleteAccount;
                try {
                    $result = (LogoutResult) $result3;
                } catch (Exception e2) {
                    Object obj = $result2;
                    $result = e2;
                    $result = obj;
                    BLog.e("AccountSwitch", "Remove account failed", (Throwable) $result);
                    return Unit.INSTANCE;
                }
                if ($result.getStatus() != AccountStatus.SUCCESS) {
                    BLog.i("AccountSwitch", "Removing account " + ((RemoveAccountAction) this.$action).getAccount() + " succeed");
                    return Unit.INSTANCE;
                }
                String message = $result.getMessage();
                if (message == null) {
                    message = "";
                }
                throw new Exception(message);
            case 1:
                ResultKt.throwOnFailure((Object) $result);
                this.label = 2;
                deleteAccount = SwitchAccountHandler.INSTANCE.deleteAccount(((RemoveAccountAction) this.$action).getAccount().getMid(), "AccountSwitchViewModel_RemoveAccount", (Continuation) this);
                if (deleteAccount != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure((Object) $result);
                $result2 = $result;
                $result3 = $result;
                $result = (LogoutResult) $result3;
                if ($result.getStatus() != AccountStatus.SUCCESS) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}