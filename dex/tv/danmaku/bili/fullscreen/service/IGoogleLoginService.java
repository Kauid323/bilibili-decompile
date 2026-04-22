package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tv.danmaku.bili.BR;

/* compiled from: interface.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IGoogleLoginService;", "", "login", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "reportParams", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "(Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IGoogleLoginService {
    Object login(LoginReportParams loginReportParams, Continuation<? super ILoginResult> continuation);
}