package tv.danmaku.bili.inner;

import android.content.Context;
import androidx.activity.ComponentActivity;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.FullscreenLoginActivityKt;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerCaptchaDialog$1", f = "InnerLoginFragment.kt", i = {}, l = {BR.leftBadgeText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginFragment$registerCaptchaDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InnerLoginFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginFragment$registerCaptchaDialog$1(InnerLoginFragment innerLoginFragment, Continuation<? super InnerLoginFragment$registerCaptchaDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginFragment$registerCaptchaDialog$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InnerLoginFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerCaptchaDialog$1$1", f = "InnerLoginFragment.kt", i = {}, l = {BR.needReplay}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.inner.InnerLoginFragment$registerCaptchaDialog$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<LoginCaptchaInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InnerLoginFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InnerLoginFragment innerLoginFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = innerLoginFragment;
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
                        ComponentActivity activity = this.this$0.getActivity();
                        ComponentActivity ac = activity instanceof ComponentActivity ? activity : null;
                        if (ac == null) {
                            return Unit.INSTANCE;
                        }
                        InnerLoginFragment innerLoginFragment = this.this$0;
                        String captchaUrl = it.getCaptchaUrl();
                        final InnerLoginFragment innerLoginFragment2 = this.this$0;
                        this.label = 1;
                        showCaptchaDialog = innerLoginFragment.showCaptchaDialog(new CaptchaDialogV2((Context) ac, captchaUrl, false, new JsBridgeCallHandlerSecure.CaptchaCallback() { // from class: tv.danmaku.bili.inner.InnerLoginFragment.registerCaptchaDialog.1.1.1
                            public void replyWithGeeCaptcha(Map<String, String> map) {
                                Intrinsics.checkNotNullParameter(map, "param");
                                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "replyWithGeeCaptcha: " + map);
                                InnerLoginFragment.this.getViewModel().dispatchAction((IFullscreenAction) it.getAfterAction().invoke(FullscreenLoginActivityKt.unified(map), it.getLoginWay().onGeeCaptcha()));
                                InnerLoginFragment.this.getViewModel().dispatchAction(IFullscreenLoginReportAction.CaptchaVerified.INSTANCE);
                            }

                            public void replyWithImageCaptcha(int callbackId, Map<String, String> map) {
                                Intrinsics.checkNotNullParameter(map, "param");
                                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "replyWithImageCaptcha: " + map);
                                InnerLoginFragment.this.getViewModel().dispatchAction((IFullscreenAction) it.getAfterAction().invoke(FullscreenLoginActivityKt.unified(map), it.getLoginWay().onImageCaptcha()));
                                InnerLoginFragment.this.getViewModel().dispatchAction(IFullscreenLoginReportAction.CaptchaVerified.INSTANCE);
                            }

                            public void closeCaptchaDialog() {
                                InnerLoginFragment.this.getViewModel().dispatchAction(IFullscreenLoginAction.DismissCaptchaAction.INSTANCE);
                                InnerLoginFragment.this.getViewModel().dispatchAction(IFullscreenLoginReportAction.CaptchaClosed.INSTANCE);
                            }
                        }), (Continuation) this);
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
                if (FlowKt.collectLatest(this.this$0.getViewModel().getCaptchaState(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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