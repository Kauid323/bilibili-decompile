package tv.danmaku.bili.sms;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountsui.ThirdLoginResult;
import com.bilibili.lib.accountsui.ThirdLoginStatus;
import com.bilibili.lib.accountsui.google.GoogleLoginManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.api.ConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginDialogActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.sms.SmsLoginDialogActivityV2$googleLogin$1", f = "SmsLoginDialogActivityV2.kt", i = {}, l = {BR.watchTimeVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginDialogActivityV2$googleLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SmsLoginDialogActivityV2 this$0;

    /* compiled from: SmsLoginDialogActivityV2.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThirdLoginStatus.values().length];
            try {
                iArr[ThirdLoginStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThirdLoginStatus.RISK_CONTROL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginDialogActivityV2$googleLogin$1(SmsLoginDialogActivityV2 smsLoginDialogActivityV2, Continuation<? super SmsLoginDialogActivityV2$googleLogin$1> continuation) {
        super(2, continuation);
        this.this$0 = smsLoginDialogActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsLoginDialogActivityV2$googleLogin$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        GoogleLoginManager $this$invokeSuspend_u24lambda_u240;
        Object $result2;
        FragmentActivity fragmentActivity;
        ThirdLoginResult result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$invokeSuspend_u24lambda_u240 = this.this$0.mGoogleLoginManager;
                if ($this$invokeSuspend_u24lambda_u240 != null) {
                    final FragmentActivity fragmentActivity2 = this.this$0;
                    Function1 function1 = new Function1() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$googleLogin$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = SmsLoginDialogActivityV2$googleLogin$1.invokeSuspend$lambda$0$0(((Boolean) obj).booleanValue());
                            return invokeSuspend$lambda$0$0;
                        }
                    };
                    Function1 function12 = new Function1() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$googleLogin$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$0$1;
                            invokeSuspend$lambda$0$1 = SmsLoginDialogActivityV2$googleLogin$1.invokeSuspend$lambda$0$1(SmsLoginDialogActivityV2.this, ((Boolean) obj).booleanValue());
                            return invokeSuspend$lambda$0$1;
                        }
                    };
                    this.L$0 = $this$invokeSuspend_u24lambda_u240;
                    this.L$1 = fragmentActivity2;
                    this.label = 1;
                    Object login = $this$invokeSuspend_u24lambda_u240.login(fragmentActivity2, function1, function12, this);
                    if (login == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = login;
                    fragmentActivity = fragmentActivity2;
                    result = (ThirdLoginResult) $result;
                    String message = result.getMsg();
                    switch (WhenMappings.$EnumSwitchMapping$0[result.getStatus().ordinal()]) {
                        case 1:
                            String str = message;
                            if (str != null && !StringsKt.isBlank(str)) {
                                z = false;
                            }
                            if (!z) {
                                ToastHelper.showToastShort((Context) fragmentActivity, message);
                            }
                            ((SmsLoginDialogActivityV2) fragmentActivity).loginType = ConstsKt.SP_GOOGLE;
                            fragmentActivity.alertVipStatusIfNeed();
                            if (result.isNew()) {
                                fragmentActivity.onRegisterSuccess();
                            }
                            fragmentActivity.onLoginSuccess(result.isNew());
                            fragmentActivity.onLoginSuccess();
                            fragmentActivity.finish(-1);
                            break;
                        case 2:
                            fragmentActivity.finish();
                            break;
                        default:
                            String str2 = message;
                            if (str2 != null && !StringsKt.isBlank(str2)) {
                                z = false;
                            }
                            if (!z) {
                                ToastHelper.showToastShort((Context) fragmentActivity, message);
                                break;
                            }
                            break;
                    }
                    break;
                }
                break;
            case 1:
                fragmentActivity = (SmsLoginDialogActivityV2) this.L$1;
                GoogleLoginManager googleLoginManager = (GoogleLoginManager) this.L$0;
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                result = (ThirdLoginResult) $result;
                String message2 = result.getMsg();
                switch (WhenMappings.$EnumSwitchMapping$0[result.getStatus().ordinal()]) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(boolean it) {
        BLog.i("GoogleLogin", "Google Login Success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$1(SmsLoginDialogActivityV2 this$0, boolean show) {
        CoroutineScope coroutineScope;
        coroutineScope = this$0.uiScope;
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$googleLogin$1$1$result$2$1(this$0, show, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}