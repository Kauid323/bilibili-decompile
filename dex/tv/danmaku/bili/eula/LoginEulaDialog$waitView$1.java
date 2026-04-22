package tv.danmaku.bili.eula;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginEulaDialog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.eula.LoginEulaDialog", f = "LoginEulaDialog.kt", i = {}, l = {109}, m = "waitView", n = {}, s = {}, v = 1)
public final class LoginEulaDialog$waitView$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginEulaDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginEulaDialog$waitView$1(LoginEulaDialog loginEulaDialog, Continuation<? super LoginEulaDialog$waitView$1> continuation) {
        super(continuation);
        this.this$0 = loginEulaDialog;
    }

    public final Object invokeSuspend(Object obj) {
        Object waitView;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        waitView = this.this$0.waitView((Continuation) this);
        return waitView;
    }
}