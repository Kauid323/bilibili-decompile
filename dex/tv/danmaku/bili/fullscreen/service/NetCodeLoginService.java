package tv.danmaku.bili.fullscreen.service;

import android.content.Context;
import androidx.activity.ComponentActivity;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageTypeKt;
import tv.danmaku.bili.fullscreen.route.PhoneBindingFrom;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: NetCodeLoginService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/NetCodeLoginService;", "", "<init>", "()V", "login", "Lcom/bilibili/lib/accounts/VerifyBundle;", "bizSeq", "", "codeSecret", "extendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redirectToPhoneBinding", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/activity/ComponentActivity;", "platform", "appId", "openId", "(Landroidx/activity/ComponentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetCodeLoginService {
    public static final int $stable = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object login(String bizSeq, String codeSecret, String extendCode, Continuation<? super VerifyBundle> continuation) {
        NetCodeLoginService$login$1 netCodeLoginService$login$1;
        Object withContext;
        if (continuation instanceof NetCodeLoginService$login$1) {
            netCodeLoginService$login$1 = (NetCodeLoginService$login$1) continuation;
            if ((netCodeLoginService$login$1.label & Integer.MIN_VALUE) != 0) {
                netCodeLoginService$login$1.label -= Integer.MIN_VALUE;
                Object $result = netCodeLoginService$login$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (netCodeLoginService$login$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        netCodeLoginService$login$1.label = 1;
                        withContext = BuildersKt.withContext(Dispatchers.getIO(), new NetCodeLoginService$login$2(bizSeq, codeSecret, extendCode, null), netCodeLoginService$login$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNullExpressionValue(withContext, "withContext(...)");
                return withContext;
            }
        }
        netCodeLoginService$login$1 = new NetCodeLoginService$login$1(this, continuation);
        Object $result2 = netCodeLoginService$login$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (netCodeLoginService$login$1.label) {
        }
        Intrinsics.checkNotNullExpressionValue(withContext, "withContext(...)");
        return withContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object redirectToPhoneBinding(ComponentActivity activity, String str, String str2, String str3, Continuation<? super Unit> continuation) {
        NetCodeLoginService$redirectToPhoneBinding$1 netCodeLoginService$redirectToPhoneBinding$1;
        Object buildPhoneBinding;
        if (continuation instanceof NetCodeLoginService$redirectToPhoneBinding$1) {
            netCodeLoginService$redirectToPhoneBinding$1 = (NetCodeLoginService$redirectToPhoneBinding$1) continuation;
            if ((netCodeLoginService$redirectToPhoneBinding$1.label & Integer.MIN_VALUE) != 0) {
                netCodeLoginService$redirectToPhoneBinding$1.label -= Integer.MIN_VALUE;
                Object $result = netCodeLoginService$redirectToPhoneBinding$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (netCodeLoginService$redirectToPhoneBinding$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PhoneBindingFrom phoneBindingFrom = PhoneBindingFrom.NetCode;
                        netCodeLoginService$redirectToPhoneBinding$1.L$0 = activity;
                        netCodeLoginService$redirectToPhoneBinding$1.label = 1;
                        buildPhoneBinding = LoginPageTypeKt.buildPhoneBinding((Context) activity, phoneBindingFrom, str, str2, str3, netCodeLoginService$redirectToPhoneBinding$1);
                        if (buildPhoneBinding == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        activity = (ComponentActivity) netCodeLoginService$redirectToPhoneBinding$1.L$0;
                        ResultKt.throwOnFailure($result);
                        buildPhoneBinding = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                RouteRequest routeRequest = (RouteRequest) buildPhoneBinding;
                BLRouter.routeTo(routeRequest, (Context) activity);
                return Unit.INSTANCE;
            }
        }
        netCodeLoginService$redirectToPhoneBinding$1 = new NetCodeLoginService$redirectToPhoneBinding$1(this, continuation);
        Object $result2 = netCodeLoginService$redirectToPhoneBinding$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (netCodeLoginService$redirectToPhoneBinding$1.label) {
        }
        RouteRequest routeRequest2 = (RouteRequest) buildPhoneBinding;
        BLRouter.routeTo(routeRequest2, (Context) activity);
        return Unit.INSTANCE;
    }
}