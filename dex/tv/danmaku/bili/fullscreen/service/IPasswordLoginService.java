package tv.danmaku.bili.fullscreen.service;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: interface.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IPasswordLoginService;", "", "login", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "account", "", "password", "captcha", "", "loginReportParams", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IPasswordLoginService {
    Object login(LoginWay loginWay, String str, String str2, Map<String, String> map, LoginReportParams loginReportParams, Continuation<? super ILoginResult> continuation);
}