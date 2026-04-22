package tv.danmaku.bili.inner;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
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
import tv.danmaku.bili.eula.LoginEulaDialog;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.stat.Facebook;
import tv.danmaku.bili.fullscreen.stat.Google;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerEulaDialog$1", f = "InnerLoginFragment.kt", i = {}, l = {BR.numberOfRater}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginFragment$registerEulaDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InnerLoginFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginFragment$registerEulaDialog$1(InnerLoginFragment innerLoginFragment, Continuation<? super InnerLoginFragment$registerEulaDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginFragment$registerEulaDialog$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InnerLoginFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "eula", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerEulaDialog$1$1", f = "InnerLoginFragment.kt", i = {0}, l = {BR.rankNoneLayoutVisible}, m = "invokeSuspend", n = {"eula"}, s = {"L$0"}, v = 1)
    /* renamed from: tv.danmaku.bili.inner.InnerLoginFragment$registerEulaDialog$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<EulaDisplayInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
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

        public final Object invoke(EulaDisplayInfo eulaDisplayInfo, Continuation<? super Unit> continuation) {
            return create(eulaDisplayInfo, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            EulaLinkItemListener eulaLinkItemListener;
            EulaLinkItemListener eulaLinkItemListener2;
            Object $result2;
            EulaLinkItemListener eulaLinkItemListener3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final EulaDisplayInfo eula = (EulaDisplayInfo) this.L$0;
                    if (eula != null && eula.getShow()) {
                        final InnerLoginFragment innerLoginFragment = this.this$0;
                        this.L$0 = eula;
                        this.L$1 = innerLoginFragment;
                        this.label = 1;
                        Continuation uCont$iv = (Continuation) this;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        CancellableContinuation continuation = cancellableContinuationImpl;
                        final LoginEulaDialog dialog = new LoginEulaDialog();
                        FragmentManager childFragmentManager = innerLoginFragment.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                        boolean isPhoneLogin = eula.isPhoneLogin();
                        EulaTriggerType triggerType = eula.getTriggerType();
                        String ispName = eula.getIspCode().getIspName();
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$registerEulaDialog$1$1$1$1

                            /* compiled from: InnerLoginFragment.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                            public static final /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[EulaTriggerType.values().length];
                                    try {
                                        iArr[EulaTriggerType.Submit.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[EulaTriggerType.GetSms.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    try {
                                        iArr[EulaTriggerType.Google.ordinal()] = 3;
                                    } catch (NoSuchFieldError e3) {
                                    }
                                    try {
                                        iArr[EulaTriggerType.Facebook.ordinal()] = 4;
                                    } catch (NoSuchFieldError e4) {
                                    }
                                    try {
                                        iArr[EulaTriggerType.NetCode.ordinal()] = 5;
                                    } catch (NoSuchFieldError e5) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1153invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1153invoke() {
                                switch (WhenMappings.$EnumSwitchMapping$0[EulaDisplayInfo.this.getTriggerType().ordinal()]) {
                                    case 1:
                                        InnerLoginViewModel.checkAndLogin$default(innerLoginFragment.getViewModel(), null, 1, null);
                                        return;
                                    case 2:
                                        innerLoginFragment.getViewModel().checkAndSendSmsCode();
                                        return;
                                    case 3:
                                        innerLoginFragment.getViewModel().checkAndLogin(Google.GoogleLogin.INSTANCE);
                                        return;
                                    case 4:
                                        innerLoginFragment.getViewModel().checkAndLogin(Facebook.FacebookLogin.INSTANCE);
                                        return;
                                    case 5:
                                        return;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                            }
                        };
                        Function0<Unit> function02 = new Function0<Unit>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$registerEulaDialog$1$1$1$2
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1154invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1154invoke() {
                                InnerLoginFragment.this.getViewModel().dispatchAction(new IFullscreenLoginAction.DismissEulaAction(false));
                            }
                        };
                        if (eula.getTriggerType() == EulaTriggerType.GetSms) {
                            eulaLinkItemListener3 = innerLoginFragment.clickEulaLinkListener2;
                            eulaLinkItemListener2 = eulaLinkItemListener3;
                        } else {
                            eulaLinkItemListener = innerLoginFragment.clickEulaLinkListener3;
                            eulaLinkItemListener2 = eulaLinkItemListener;
                        }
                        LoginEulaDialog.show$default(dialog, childFragmentManager, "login", isPhoneLogin, triggerType, 0, null, ispName, function0, function02, eulaLinkItemListener2, 48, null);
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$registerEulaDialog$1$1$1$3
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                if (LoginEulaDialog.this.isAdded()) {
                                    LoginEulaDialog.this.dismissAllowingStateLoss();
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
                    InnerLoginFragment innerLoginFragment2 = (InnerLoginFragment) this.L$1;
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