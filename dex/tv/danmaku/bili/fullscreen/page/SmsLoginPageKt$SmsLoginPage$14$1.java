package tv.danmaku.bili.fullscreen.page;

import android.app.Activity;
import android.content.Context;
import androidx.activity.ComponentActivity;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.ThirdLoginResult;
import com.bilibili.lib.accountsui.thirdpart.HandleLoginResultKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.NetCodeLoginService;
import tv.danmaku.bili.fullscreen.state.Authorizing;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.LoginFailed;
import tv.danmaku.bili.fullscreen.state.LoginVerifying;
import tv.danmaku.bili.fullscreen.state.NetCodeLoadingState;
import tv.danmaku.bili.fullscreen.state.NetCodeState;
import tv.danmaku.bili.fullscreen.state.SmsLoginInput;
import tv.danmaku.bili.wauth.WAuthInvoker;
import tv.danmaku.bili.wauth.WAuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.page.SmsLoginPageKt$SmsLoginPage$14$1", f = "SmsLoginPage.kt", i = {}, l = {BR.errorText, 204, BR.flContainerVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginPageKt$SmsLoginPage$14$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<IFullscreenAction, Unit> $onAction;
    final /* synthetic */ SmsLoginInput $pageState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SmsLoginPageKt$SmsLoginPage$14$1(SmsLoginInput smsLoginInput, Context context, Function1<? super IFullscreenAction, Unit> function1, Continuation<? super SmsLoginPageKt$SmsLoginPage$14$1> continuation) {
        super(2, continuation);
        this.$pageState = smsLoginInput;
        this.$context = context;
        this.$onAction = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> smsLoginPageKt$SmsLoginPage$14$1 = new SmsLoginPageKt$SmsLoginPage$14$1(this.$pageState, this.$context, this.$onAction, continuation);
        smsLoginPageKt$SmsLoginPage$14$1.L$0 = obj;
        return smsLoginPageKt$SmsLoginPage$14$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        Object $result4;
        Object $result5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                NetCodeState netCodeState = this.$pageState.getNetCodeState();
                BLog.i("netcode_state", "state=" + netCodeState + ", loading=" + (netCodeState instanceof NetCodeLoadingState));
                if (netCodeState instanceof Authorizing) {
                    ComponentActivity activity = ContextUtilKt.findTypedActivityOrNull(this.$context, ComponentActivity.class);
                    if (activity != null) {
                        Result.Companion companion = Result.Companion;
                        WAuthInvoker wAuthInvoker = new WAuthInvoker();
                        this.label = 1;
                        Object auth$default = WAuthInvoker.auth$default(wAuthInvoker, activity, (String) null, this, 2, (Object) null);
                        if (auth$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = auth$default;
                        try {
                            $result3 = Result.constructor-impl((WAuthResult) $result);
                        } catch (Throwable th3) {
                            Object obj = $result2;
                            th = th3;
                            $result = obj;
                            Result.Companion companion2 = Result.Companion;
                            Object obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            $result2 = $result;
                            $result3 = obj2;
                            this.$onAction.invoke(new IFullscreenLoginAction.NetCodeAuthResult($result3));
                            return Unit.INSTANCE;
                        }
                        this.$onAction.invoke(new IFullscreenLoginAction.NetCodeAuthResult($result3));
                    }
                } else if (netCodeState instanceof LoginFailed.PhoneBindingRequested) {
                    LoginFailed.PhoneBindingRequested $this$invokeSuspend_u24lambda_u241 = (LoginFailed.PhoneBindingRequested) netCodeState;
                    ComponentActivity activity2 = ContextUtilKt.findTypedActivityOrNull(this.$context, ComponentActivity.class);
                    if (activity2 != null) {
                        NetCodeLoginService netCodeLoginService = new NetCodeLoginService();
                        String snsPlatform = $this$invokeSuspend_u24lambda_u241.getSnsPlatform();
                        String snsAppId = $this$invokeSuspend_u24lambda_u241.getSnsAppId();
                        String snsOpenId = $this$invokeSuspend_u24lambda_u241.getSnsOpenId();
                        this.label = 2;
                        if (netCodeLoginService.redirectToPhoneBinding(activity2, snsPlatform, snsAppId, snsOpenId, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (netCodeState instanceof LoginVerifying) {
                    Context context = this.$context;
                    Result.Companion companion3 = Result.Companion;
                    Activity findTypedActivityOrNull = ContextUtilKt.findTypedActivityOrNull(context, ComponentActivity.class);
                    VerifyBundle verifyBundle = ((LoginVerifying) netCodeState).getVerifyBundle();
                    this.label = 3;
                    Object verifyLogin = HandleLoginResultKt.verifyLogin(findTypedActivityOrNull, verifyBundle, this);
                    if (verifyLogin == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result4 = $result;
                    $result = verifyLogin;
                    try {
                        $result5 = Result.constructor-impl((ThirdLoginResult) $result);
                    } catch (Throwable th4) {
                        Object obj3 = $result4;
                        th = th4;
                        $result = obj3;
                        Result.Companion companion4 = Result.Companion;
                        Object obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        $result4 = $result;
                        $result5 = obj4;
                        this.$onAction.invoke(new IFullscreenLoginAction.NetCodeVerifyResult($result5));
                        return Unit.INSTANCE;
                    }
                    this.$onAction.invoke(new IFullscreenLoginAction.NetCodeVerifyResult($result5));
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                $result3 = Result.constructor-impl((WAuthResult) $result);
                this.$onAction.invoke(new IFullscreenLoginAction.NetCodeAuthResult($result3));
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                $result4 = $result;
                $result5 = Result.constructor-impl((ThirdLoginResult) $result);
                this.$onAction.invoke(new IFullscreenLoginAction.NetCodeVerifyResult($result5));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}