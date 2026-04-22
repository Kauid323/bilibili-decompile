package tv.danmaku.bili.fullscreen.route;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginPageType.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.route.LoginPageType$FastReLoginDialog", f = "LoginPageType.kt", i = {}, l = {BR.count}, m = "getLoginRequest$accountui_apinkDebug", n = {}, s = {}, v = 1)
public final class LoginPageType$FastReLoginDialog$getLoginRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginPageType.FastReLoginDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPageType$FastReLoginDialog$getLoginRequest$1(LoginPageType.FastReLoginDialog fastReLoginDialog, Continuation<? super LoginPageType$FastReLoginDialog$getLoginRequest$1> continuation) {
        super(continuation);
        this.this$0 = fastReLoginDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLoginRequest$accountui_apinkDebug(null, (Continuation) this);
    }
}