package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginResultService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.LoginResultService", f = "LoginResultService.kt", i = {0, 0}, l = {BR.buttonWidths}, m = "handleLoginResult", n = {"loginWay", "login"}, s = {"L$0", "L$1"}, v = 1)
public final class LoginResultService$handleLoginResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginResultService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginResultService$handleLoginResult$1(LoginResultService loginResultService, Continuation<? super LoginResultService$handleLoginResult$1> continuation) {
        super(continuation);
        this.this$0 = loginResultService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleLoginResult(null, null, null, (Continuation) this);
    }
}