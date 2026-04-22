package tv.danmaku.bili.fullscreen.service;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;

/* compiled from: PasswordLoginService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/PasswordLoginService;", "Ltv/danmaku/bili/fullscreen/service/IPasswordLoginService;", "<init>", "()V", "login", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "account", "", "password", "captcha", "", "loginReportParams", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PasswordLoginService implements IPasswordLoginService {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.fullscreen.service.IPasswordLoginService
    public Object login(LoginWay loginWay, String account, String password, Map<String, String> map, LoginReportParams loginReportParams, Continuation<? super ILoginResult> continuation) {
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Start login for account " + account);
        return BuildersKt.withContext(Dispatchers.getIO(), new PasswordLoginService$login$2(account, password, loginReportParams, map, loginWay, null), continuation);
    }
}