package tv.danmaku.bili.ui.login.helper.reducer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginTypeCheckerReducer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.reducer.LoginTypeCheckerReducer", f = "LoginTypeCheckerReducer.kt", i = {0, 0}, l = {19}, m = "check", n = {"fromSpmid", "data"}, s = {"L$0", "L$1"}, v = 1)
public final class LoginTypeCheckerReducer$check$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginTypeCheckerReducer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginTypeCheckerReducer$check$1(LoginTypeCheckerReducer loginTypeCheckerReducer, Continuation<? super LoginTypeCheckerReducer$check$1> continuation) {
        super(continuation);
        this.this$0 = loginTypeCheckerReducer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.check(null, null, null, (Continuation) this);
    }
}