package tv.danmaku.bili.stepbystep;

import android.content.Context;
import com.bilibili.lib.accountsui.captcha.CaptchaDialogV2;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.FullscreenLoginActivityKt;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerCaptchaDialog$1", f = "StepByStepSmsLoginActivity.kt", i = {}, l = {BR.rootVisibility}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginActivity$registerCaptchaDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StepByStepSmsLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginActivity$registerCaptchaDialog$1(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, Continuation<? super StepByStepSmsLoginActivity$registerCaptchaDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = stepByStepSmsLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StepByStepSmsLoginActivity$registerCaptchaDialog$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StepByStepSmsLoginActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerCaptchaDialog$1$1", f = "StepByStepSmsLoginActivity.kt", i = {}, l = {BR.showGif}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerCaptchaDialog$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<LoginCaptchaInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StepByStepSmsLoginActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = stepByStepSmsLoginActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(LoginCaptchaInfo loginCaptchaInfo, Continuation<? super Unit> continuation) {
            return create(loginCaptchaInfo, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object showCaptchaDialog;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final LoginCaptchaInfo it = (LoginCaptchaInfo) this.L$0;
                    if (it != null && !StringsKt.isBlank(it.getCaptchaUrl())) {
                        final Ref.ObjectRef dialog = new Ref.ObjectRef();
                        final StepByStepSmsLoginActivity stepByStepSmsLoginActivity = this.this$0;
                        dialog.element = new CaptchaDialogV2((Context) this.this$0, it.getCaptchaUrl(), false, new JsBridgeCallHandlerSecure.CaptchaCallback() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerCaptchaDialog$1$1$captchaCallback$1
                            public void replyWithGeeCaptcha(Map<String, String> map) {
                                Intrinsics.checkNotNullParameter(map, "param");
                                closeCaptchaDialog();
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(new StepByStepSmsLoginAction.GetSmsAction(it.getLoginWay().onGeeCaptcha(), FullscreenLoginActivityKt.unified(map)));
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.OnCaptureVerifySuccess.INSTANCE);
                            }

                            public void replyWithImageCaptcha(int callbackId, Map<String, String> map) {
                                CaptchaDialogV2 captchaDialogV2;
                                Intrinsics.checkNotNullParameter(map, "param");
                                CaptchaDialogV2 captchaDialogV22 = (CaptchaDialogV2) dialog.element;
                                boolean z = false;
                                if (captchaDialogV22 != null && captchaDialogV22.isShowing()) {
                                    z = true;
                                }
                                if (z && (captchaDialogV2 = (CaptchaDialogV2) dialog.element) != null) {
                                    captchaDialogV2.setJsCallbackId(callbackId);
                                }
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(new StepByStepSmsLoginAction.GetSmsAction(it.getLoginWay().onImageCaptcha(), FullscreenLoginActivityKt.unified(map)));
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.OnCaptureVerifySuccess.INSTANCE);
                            }

                            public void closeCaptchaDialog() {
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.DismissCaptchaAction.INSTANCE);
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.CloseCaptureDialog.INSTANCE);
                            }
                        });
                        this.label = 1;
                        showCaptchaDialog = this.this$0.showCaptchaDialog((CaptchaDialogV2) dialog.element, (Continuation) this);
                        if (showCaptchaDialog == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collectLatest(this.this$0.getViewModel().getCaptchaDisplay(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}