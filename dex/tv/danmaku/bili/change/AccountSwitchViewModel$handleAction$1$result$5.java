package tv.danmaku.bili.change;

import com.bilibili.lib.accounts.AccountsKtHelper;
import com.bilibili.lib.accounts.model.SimpleAccountInfo;
import com.bilibili.lib.accountsui.switch.SwitchAccountHandler;
import java.util.List;
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
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1$result$5", f = "AccountSwitchFragment.kt", i = {0, 1, 2}, l = {BR.leftBtnVisible, BR.leftText, BR.leftTextColor, BR.limitTextColor}, m = "invokeSuspend", n = {"$this$ActionResult", "$this$ActionResult", "$this$ActionResult"}, s = {"L$0", "L$0", "L$0"}, v = 1)
final class AccountSwitchViewModel$handleAction$1$result$5 extends SuspendLambda implements Function2<FlowCollector<? super ISwitchAction>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AccountSwitchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchViewModel$handleAction$1$result$5(AccountSwitchViewModel accountSwitchViewModel, Continuation<? super AccountSwitchViewModel$handleAction$1$result$5> continuation) {
        super(2, continuation);
        this.this$0 = accountSwitchViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> accountSwitchViewModel$handleAction$1$result$5 = new AccountSwitchViewModel$handleAction$1$result$5(this.this$0, continuation);
        accountSwitchViewModel$handleAction$1$result$5.L$0 = obj;
        return accountSwitchViewModel$handleAction$1$result$5;
    }

    public final Object invoke(FlowCollector<? super ISwitchAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        FlowCollector $this$ActionResult;
        Object requestAccountInfos;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
        } catch (Exception e) {
            e = e;
        }
        switch (r1) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$ActionResult2 = (FlowCollector) this.L$0;
                this.L$0 = $this$ActionResult2;
                this.label = 1;
                Object fetchAvailableAccountsSync = SwitchAccountHandler.INSTANCE.fetchAvailableAccountsSync((Continuation) this);
                if (fetchAvailableAccountsSync == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = fetchAvailableAccountsSync;
                $this$ActionResult = $this$ActionResult2;
                try {
                    List midList = (List) $result;
                    this.L$0 = $this$ActionResult;
                    this.label = 2;
                    requestAccountInfos = AccountsKtHelper.INSTANCE.requestAccountInfos(this.this$0.getApplication(), midList, (Continuation) this);
                } catch (Exception e2) {
                    FlowCollector flowCollector = $this$ActionResult;
                    e = e2;
                    r1 = flowCollector;
                    BLog.e("AccountSwitch", "Load account list failed", e);
                    this.L$0 = null;
                    this.label = 4;
                    if (r1.emit(new AccountListLoadFailedAction(e), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (requestAccountInfos != coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = requestAccountInfos;
                SimpleAccountInfo accountInfo = (SimpleAccountInfo) $result;
                this.L$0 = $this$ActionResult;
                this.label = 3;
                return $this$ActionResult.emit(new AccountListLoadedAction(accountInfo), (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                FlowCollector $this$ActionResult3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$ActionResult = $this$ActionResult3;
                $result2 = $result;
                List midList2 = (List) $result;
                this.L$0 = $this$ActionResult;
                this.label = 2;
                requestAccountInfos = AccountsKtHelper.INSTANCE.requestAccountInfos(this.this$0.getApplication(), midList2, (Continuation) this);
                if (requestAccountInfos != coroutine_suspended) {
                }
                break;
            case 2:
                FlowCollector $this$ActionResult4 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$ActionResult = $this$ActionResult4;
                $result2 = $result;
                SimpleAccountInfo accountInfo2 = (SimpleAccountInfo) $result;
                this.L$0 = $this$ActionResult;
                this.label = 3;
                if ($this$ActionResult.emit(new AccountListLoadedAction(accountInfo2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 3:
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
            case 4:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}