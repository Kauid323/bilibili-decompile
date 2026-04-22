package tv.danmaku.bili.fast;

import com.bilibili.lib.accountsui.AccountResult;
import com.bilibili.lib.accountsui.AccountStatus;
import com.bilibili.lib.accountsui.TrackParams;
import com.bilibili.lib.accountsui.fast.FastLoginHandler;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fast.FastReLoginActivity$performLogin$1", f = "FastReLoginActivity.kt", i = {}, l = {BR.danmakuInputVm}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastReLoginActivity$performLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FastReLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastReLoginActivity$performLogin$1(FastReLoginActivity fastReLoginActivity, Continuation<? super FastReLoginActivity$performLogin$1> continuation) {
        super(2, continuation);
        this.this$0 = fastReLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FastReLoginActivity$performLogin$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v12, types: [com.bilibili.lib.accountsui.AccountResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str = "";
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure((Object) $result);
                    mutableStateFlow = this.this$0.pageStateFlow;
                    mutableStateFlow2 = this.this$0.pageStateFlow;
                    FastReLoginState fastReLoginState = (FastReLoginState) mutableStateFlow2.getValue();
                    mutableStateFlow.setValue(fastReLoginState != null ? FastReLoginState.copy$default(fastReLoginState, null, true, false, false, 13, null) : null);
                    BLog.i(FastReLoginActivityKt.TAG, "Start fast re-login");
                    this.label = 1;
                    Object fastLogin = FastLoginHandler.INSTANCE.fastLogin(this.this$0, new TrackParams(LoginReportHelper.INSTANCE.getLoginSessionId(), LoginReportHelper.INSTANCE.getFromSpmid(), "", LoginReportHelper.INSTANCE.getExtend()), (Continuation) this);
                    if (fastLogin != coroutine_suspended) {
                        $result2 = $result;
                        $result3 = fastLogin;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure((Object) $result);
                    $result2 = $result;
                    $result3 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (AccountRiskControlException e) {
            $result = e;
        } catch (Exception e2) {
            $result = e2;
        }
        try {
            $result = (AccountResult) $result3;
        } catch (AccountRiskControlException e3) {
            Object obj = $result2;
            $result = e3;
            $result = obj;
            BLog.e(FastReLoginActivityKt.TAG, "Fast re-login failed, risk control, do nothing", (Throwable) $result);
            this.this$0.finish();
            return Unit.INSTANCE;
        } catch (Exception e4) {
            Object obj2 = $result2;
            $result = e4;
            $result = obj2;
            BLog.e(FastReLoginActivityKt.TAG, "Fast re-login failed", (Throwable) $result);
            this.this$0.routeToLogin();
            return Unit.INSTANCE;
        }
        if ($result.getStatus() == AccountStatus.SUCCESS) {
            BLog.i(FastReLoginActivityKt.TAG, "Fast re-login success");
            Neurons.reportExposure$default(false, LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, MapsKt.plus(LoginReportHelper.getCommonParams().build(), MapsKt.mapOf(TuplesKt.to("method", LoginReporterV2.Show.LOGIN_SUCCEED_FAST_RE_LOGIN))), (List) null, 8, (Object) null);
            this.this$0.finish();
            return Unit.INSTANCE;
        } else if ($result.getStatus() != AccountStatus.RISK_CONTROL) {
            BLog.i(FastReLoginActivityKt.TAG, "Fast re-login " + ((Object) $result));
            throw new Exception($result.getMessage());
        } else {
            BLog.i(FastReLoginActivityKt.TAG, "Fast re-login failed, risk control");
            AccountStatus status = $result.getStatus();
            String message = $result.getMessage();
            if (message != null) {
                str = message;
            }
            throw new AccountRiskControlException(status, str);
        }
    }
}