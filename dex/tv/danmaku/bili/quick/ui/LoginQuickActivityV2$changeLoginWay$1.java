package tv.danmaku.bili.quick.ui;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageDisplay;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.report.LoginReportHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginQuickActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.quick.ui.LoginQuickActivityV2$changeLoginWay$1", f = "LoginQuickActivityV2.kt", i = {}, l = {BR.useTintColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoginQuickActivityV2$changeLoginWay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LoginQuickActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginQuickActivityV2$changeLoginWay$1(LoginQuickActivityV2 loginQuickActivityV2, Continuation<? super LoginQuickActivityV2$changeLoginWay$1> continuation) {
        super(2, continuation);
        this.this$0 = loginQuickActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginQuickActivityV2$changeLoginWay$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loginPageRequest;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Context context = (Context) this.this$0;
                String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
                if (fromSpmid == null) {
                    fromSpmid = "";
                }
                LoginPageType loginPageType = LoginPageType.QuickLoginDialog;
                this.label = 1;
                loginPageRequest = StartLoginPageKt.getLoginPageRequest(context, fromSpmid, (r14 & 4) != 0 ? LoginPageDisplay.Companion.getDefaultArray() : null, (r14 & 8) != 0 ? LoginPageType.Invalid : loginPageType, (r14 & 16) != 0 ? ValidLoginType.Companion.getAllValues() : null, (r14 & 32) != 0 ? new Function1() { // from class: tv.danmaku.bili.fullscreen.route.StartLoginPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit loginPageRequest$lambda$0;
                        loginPageRequest$lambda$0 = StartLoginPageKt.getLoginPageRequest$lambda$0((Bundle) obj);
                        return loginPageRequest$lambda$0;
                    }
                } : null, (Continuation) this);
                if (loginPageRequest != coroutine_suspended) {
                    $result = loginPageRequest;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RouteRequest it = (RouteRequest) $result;
        if (it != null) {
            BLRouter.routeTo(it, (Context) this.this$0);
        }
        this.this$0.finish(true);
        return Unit.INSTANCE;
    }
}