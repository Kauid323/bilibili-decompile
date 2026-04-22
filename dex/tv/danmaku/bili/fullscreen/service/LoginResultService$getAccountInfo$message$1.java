package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.AccountInfoMessage;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/model/AccountInfoMessage;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.LoginResultService$getAccountInfo$message$1", f = "LoginResultService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoginResultService$getAccountInfo$message$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AccountInfoMessage>, Object> {
    final /* synthetic */ LoginSucceed $login;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginResultService$getAccountInfo$message$1(LoginSucceed loginSucceed, Continuation<? super LoginResultService$getAccountInfo$message$1> continuation) {
        super(2, continuation);
        this.$login = loginSucceed;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginResultService$getAccountInfo$message$1(this.$login, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AccountInfoMessage> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return BiliAccounts.get(FoundationAlias.getFapp()).requestAccountInfoForResult(this.$login.getAccessKey());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}