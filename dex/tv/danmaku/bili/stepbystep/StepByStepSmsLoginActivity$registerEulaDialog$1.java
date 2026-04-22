package tv.danmaku.bili.stepbystep;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import bili.resource.account.R;
import com.bilibili.droid.ToastHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkItemListener;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.eula.LoginEulaDialog;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginPhonePage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1", f = "StepByStepSmsLoginActivity.kt", i = {}, l = {BR.preSaleCountdownClickable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginActivity$registerEulaDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StepByStepSmsLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginActivity$registerEulaDialog$1(StepByStepSmsLoginActivity stepByStepSmsLoginActivity, Continuation<? super StepByStepSmsLoginActivity$registerEulaDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = stepByStepSmsLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StepByStepSmsLoginActivity$registerEulaDialog$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StepByStepSmsLoginActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "eula", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1$1", f = "StepByStepSmsLoginActivity.kt", i = {0}, l = {BR.sponsorHeadDiverVisible}, m = "invokeSuspend", n = {"eula"}, s = {"L$0"}, v = 1)
    /* renamed from: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<EulaDisplayInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
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

        public final Object invoke(EulaDisplayInfo eulaDisplayInfo, Continuation<? super Unit> continuation) {
            return create(eulaDisplayInfo, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    EulaDisplayInfo eula = (EulaDisplayInfo) this.L$0;
                    if (eula != null && eula.getShow()) {
                        final StepByStepSmsLoginActivity stepByStepSmsLoginActivity = this.this$0;
                        this.L$0 = eula;
                        this.L$1 = stepByStepSmsLoginActivity;
                        this.label = 1;
                        Continuation uCont$iv = (Continuation) this;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        CancellableContinuation continuation = cancellableContinuationImpl;
                        final LoginEulaDialog dialog = new LoginEulaDialog();
                        FragmentManager supportFragmentManager = stepByStepSmsLoginActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                        dialog.show(supportFragmentManager, "login", eula.isPhoneLogin(), eula.getTriggerType(), R.string.account_global_string_115, MapsKt.mapOf(TuplesKt.to("login_type", eula.getLoginType())), eula.getIspCode().getIspName(), new Function0<Unit>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1$1$1$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1505invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1505invoke() {
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(IStepByStepLoginAction.DismissEulaAction.INSTANCE);
                                boolean z = true;
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(new IStepByStepLoginAction.AgreementCheckedAction(true, true));
                                Object $this$asTo$iv = StepByStepSmsLoginActivity.this.getViewModel().getStateSmsFlow().getValue();
                                if (!($this$asTo$iv instanceof StepByStepSmsLoginPhonePage)) {
                                    $this$asTo$iv = null;
                                }
                                StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage = (StepByStepSmsLoginPhonePage) $this$asTo$iv;
                                if (stepByStepSmsLoginPhonePage == null || !stepByStepSmsLoginPhonePage.getConfirmButtonEnable()) {
                                    z = false;
                                }
                                if (z) {
                                    StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(StepByStepSmsLoginAction.PageTransitionAction.INSTANCE);
                                } else {
                                    ToastHelper.showToastShort((Context) StepByStepSmsLoginActivity.this, StepByStepSmsLoginActivity.this.getString(R.string.account_global_string_4));
                                }
                            }
                        }, new Function0<Unit>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1$1$1$2
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1506invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1506invoke() {
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(IStepByStepLoginAction.DismissEulaAction.INSTANCE);
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(new IStepByStepLoginAction.AgreementCheckedAction(false, true));
                            }
                        }, new EulaLinkItemListener() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1$1$1$3
                            @Override // tv.danmaku.bili.eula.EulaLinkItemListener
                            public final void onItemLinkClick(EulaLinkType it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                StepByStepSmsLoginActivity.this.getViewModel().dispatchAction(new StepByStepSmsLoginAction.ReportAction.ClickProvisionPopupTerms(it));
                            }
                        });
                        stepByStepSmsLoginActivity.getViewModel().dispatchAction(StepByStepSmsLoginAction.ReportAction.ShowProvisionPopup.INSTANCE);
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity$registerEulaDialog$1$1$1$4
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                if (LoginEulaDialog.this.isAdded()) {
                                    LoginEulaDialog.this.dismiss();
                                }
                            }
                        });
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        break;
                    }
                    break;
                case 1:
                    $result2 = $result;
                    StepByStepSmsLoginActivity stepByStepSmsLoginActivity2 = (StepByStepSmsLoginActivity) this.L$1;
                    EulaDisplayInfo eulaDisplayInfo = (EulaDisplayInfo) this.L$0;
                    ResultKt.throwOnFailure($result2);
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
                if (FlowKt.collectLatest(this.this$0.getViewModel().getEulaDisplay(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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