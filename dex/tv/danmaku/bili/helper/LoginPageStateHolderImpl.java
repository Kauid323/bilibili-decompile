package tv.danmaku.bili.helper;

import com.bilibili.login.LoginPageState;
import com.bilibili.login.LoginPageStateHolder;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: LoginSuccessProcessor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/helper/LoginPageStateHolderImpl;", "Lcom/bilibili/login/LoginPageStateHolder;", "<init>", "()V", AuthResultCbHelper.ARGS_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/bilibili/login/LoginPageState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginPageStateHolderImpl implements LoginPageStateHolder {
    public static final int $stable = 0;

    public StateFlow<LoginPageState> getState() {
        MutableStateFlow mutableStateFlow;
        mutableStateFlow = LoginSuccessProcessorKt.pageState;
        return FlowKt.asStateFlow(mutableStateFlow);
    }
}