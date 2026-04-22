package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginResultService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.LoginResultService", f = "LoginResultService.kt", i = {0}, l = {BR.chatRoomConfig}, m = "getAccountInfo", n = {"login"}, s = {"L$0"}, v = 1)
public final class LoginResultService$getAccountInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginResultService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginResultService$getAccountInfo$1(LoginResultService loginResultService, Continuation<? super LoginResultService$getAccountInfo$1> continuation) {
        super(continuation);
        this.this$0 = loginResultService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAccountInfo(null, (Continuation) this);
    }
}