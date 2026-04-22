package tv.danmaku.bili.ui.login.helper.reducer;

import android.content.Context;
import com.bilibili.lib.accounts.model.TInfoLogin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.helper.AutoLoginCheckResult;
import tv.danmaku.bili.ui.login.helper.AutoLoginData;
import tv.danmaku.bili.ui.login.helper.LoginWay;
import tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer;

/* compiled from: NetworkCheckReducer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/reducer/NetworkCheckReducer;", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "<init>", "()V", "check", "Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "context", "Landroid/content/Context;", "fromSpmid", "", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetworkCheckReducer implements QuickLoginCheckReducer {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public /* synthetic */ Object afterCheck(String str, AutoLoginCheckResult autoLoginCheckResult, Continuation continuation) {
        Object afterCheck$suspendImpl;
        afterCheck$suspendImpl = QuickLoginCheckReducer.CC.afterCheck$suspendImpl(this, str, autoLoginCheckResult, continuation);
        return afterCheck$suspendImpl;
    }

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /* renamed from: beforeCheck-5k-lyPk */
    public /* synthetic */ Object mo1802beforeCheck5klyPk(Context context, String str, AutoLoginData autoLoginData, Continuation continuation) {
        Object m1804beforeCheck5klyPk$suspendImpl;
        m1804beforeCheck5klyPk$suspendImpl = QuickLoginCheckReducer.CC.m1804beforeCheck5klyPk$suspendImpl(this, context, str, autoLoginData, continuation);
        return m1804beforeCheck5klyPk$suspendImpl;
    }

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public /* synthetic */ String getTAG() {
        return QuickLoginCheckReducer.CC.$default$getTAG(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object check(Context context, String fromSpmid, AutoLoginData autoLoginData, Continuation<? super AutoLoginCheckResult> continuation) {
        NetworkCheckReducer$check$1 networkCheckReducer$check$1;
        AutoLoginData data;
        Pair type;
        TInfoLogin.LoginBean loginBean;
        TInfoLogin.QuickBean quick;
        Object withContext;
        LoginWay this_$iv;
        LoginWay loginWay;
        if (continuation instanceof NetworkCheckReducer$check$1) {
            networkCheckReducer$check$1 = (NetworkCheckReducer$check$1) continuation;
            if ((networkCheckReducer$check$1.label & Integer.MIN_VALUE) != 0) {
                networkCheckReducer$check$1.label -= Integer.MIN_VALUE;
                Object $result = networkCheckReducer$check$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (networkCheckReducer$check$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        data = autoLoginData;
                        TInfoLogin loginInfo = data.getLoginInfo();
                        if (loginInfo != null && (loginBean = loginInfo.login) != null && (quick = loginBean.quick) != null) {
                            networkCheckReducer$check$1.L$0 = data;
                            networkCheckReducer$check$1.label = 1;
                            withContext = BuildersKt.withContext(Dispatchers.getDefault(), new NetworkCheckReducer$check$type$1$1(context, fromSpmid, quick, null), networkCheckReducer$check$1);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            type = (Pair) withContext;
                            break;
                        } else {
                            type = null;
                            break;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        data = (AutoLoginData) networkCheckReducer$check$1.L$0;
                        withContext = $result;
                        type = (Pair) withContext;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AutoLoginData data2 = data;
                this_$iv = data2.getLoginWay();
                if (this_$iv != null) {
                    loginWay = null;
                } else {
                    if (type == null || !((Boolean) type.getSecond()).booleanValue()) {
                        z = false;
                    }
                    loginWay = !z ? LoginWay.copy$default(this_$iv, 0, false, false, 5, null) : this_$iv;
                }
                return new AutoLoginCheckResult(AutoLoginData.copy$default(data2, null, loginWay, null, type, false, 21, null), false, 2, null);
            }
        }
        networkCheckReducer$check$1 = new NetworkCheckReducer$check$1(this, continuation);
        Object $result2 = networkCheckReducer$check$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (networkCheckReducer$check$1.label) {
        }
        AutoLoginData data22 = data;
        this_$iv = data22.getLoginWay();
        if (this_$iv != null) {
        }
        return new AutoLoginCheckResult(AutoLoginData.copy$default(data22, null, loginWay, null, type, false, 21, null), false, 2, null);
    }
}