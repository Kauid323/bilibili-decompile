package tv.danmaku.bili.sms;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginDialogActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.sms.SmsLoginDialogActivityV2$handleOversea$4$1", f = "SmsLoginDialogActivityV2.kt", i = {}, l = {BR.reviewRatingNum}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginDialogActivityV2$handleOversea$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SmsLoginDialogActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginDialogActivityV2$handleOversea$4$1(SmsLoginDialogActivityV2 smsLoginDialogActivityV2, Continuation<? super SmsLoginDialogActivityV2$handleOversea$4$1> continuation) {
        super(2, continuation);
        this.this$0 = smsLoginDialogActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsLoginDialogActivityV2$handleOversea$4$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HashMap track;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BLog.i("SmsLoginDialogActivityV", "pwdLogin to fullscreen");
                LoginPageType loginPageType = LoginPageType.PwdFullscreen;
                Context context = (Context) this.this$0;
                String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
                if (fromSpmid == null) {
                    fromSpmid = "";
                }
                String str = fromSpmid;
                Bundle $this$invokeSuspend_u24lambda_u240 = new Bundle();
                $this$invokeSuspend_u24lambda_u240.putString("skip_check", "1");
                Unit unit = Unit.INSTANCE;
                this.label = 1;
                Object buildLoginRequest$default = LoginPageType.buildLoginRequest$default(loginPageType, context, str, null, $this$invokeSuspend_u24lambda_u240, (Continuation) this, 4, null);
                if (buildLoginRequest$default != coroutine_suspended) {
                    $result = buildLoginRequest$default;
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
        RouteRequest request = (RouteRequest) $result;
        BLRouter.routeTo(request, (Context) this.this$0);
        track = this.this$0.getTrackCommonValue();
        track.put("type", "pwd");
        LoginReporterV2.Click.report(LoginReporterV2.Click.CLICK_SMS_LOGIN_DIALOG_TO_PWD_LOGIN_BUTTON, track);
        this.this$0.goOtherPage = true;
        return Unit.INSTANCE;
    }
}