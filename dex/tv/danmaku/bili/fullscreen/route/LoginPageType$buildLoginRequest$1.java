package tv.danmaku.bili.fullscreen.route;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginPageType.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.route.LoginPageType", f = "LoginPageType.kt", i = {0, 0, 0}, l = {BR.followNum}, m = "buildLoginRequest", n = {FavoritesConstsKt.SPMID, "validTypes", InnerPushReceiverKt.KEY_EXTRA}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class LoginPageType$buildLoginRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginPageType this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPageType$buildLoginRequest$1(LoginPageType loginPageType, Continuation<? super LoginPageType$buildLoginRequest$1> continuation) {
        super(continuation);
        this.this$0 = loginPageType;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildLoginRequest(null, null, null, null, (Continuation) this);
    }
}