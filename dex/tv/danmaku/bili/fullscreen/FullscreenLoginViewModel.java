package tv.danmaku.bili.fullscreen;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accounts.model.TInfoLogin;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.IFullscreenLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.LoginCountDownLatchService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;

/* compiled from: FullscreenLoginViewModel.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u0016\u0010B\u001a\u00020-2\u0006\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010CJ\u0006\u0010D\u001a\u00020?J\u0006\u0010E\u001a\u00020?J\u0006\u0010F\u001a\u00020?R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0019\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010,¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002040'¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0019\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070\"¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020;0:¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006G"}, d2 = {"Ltv/danmaku/bili/fullscreen/FullscreenLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "stateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/IFullscreenLoginStateMachineFactory;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "loginExpGroup", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "loginCountDownLatchService", "Ltv/danmaku/bili/fullscreen/service/LoginCountDownLatchService;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ltv/danmaku/bili/fullscreen/service/IFullscreenLoginStateMachineFactory;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/exp/LoginExpType;Ltv/danmaku/bili/fullscreen/service/LoginCountDownLatchService;)V", "getLoginReportService", "()Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "getLoginExpGroup", "()Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "validTypes", "", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "getValidTypes$annotations", "()V", "getValidTypes", "()Ljava/util/List;", "startAt", "getStartAt$annotations", "getStartAt", "()Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "stateMachine", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginStateMachine;", "getStateMachine", "()Ltv/danmaku/bili/fullscreen/state/FullscreenLoginStateMachine;", AuthResultCbHelper.ARGS_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "redirect", "Lkotlinx/coroutines/flow/SharedFlow;", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Lkotlinx/coroutines/flow/SharedFlow;", "dialogState", "Lkotlinx/coroutines/flow/Flow;", "", "getDialogState", "()Lkotlinx/coroutines/flow/Flow;", "captchaState", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaState", "toast", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToast", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "interceptedActionFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "getInterceptedActionFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "dispatchAction", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "interceptAction", "(Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAndLogin", "checkAndSendSmsCode", "checkAndNetCodeAuth", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Flow<LoginCaptchaInfo> captchaState;
    private final Flow<Boolean> dialogState;
    private final StateFlow<EulaDisplayInfo> eulaDisplay;
    private final MutableSharedFlow<IFullscreenLoginAction> interceptedActionFlow;
    private final LoginCountDownLatchService loginCountDownLatchService;
    private final LoginExpType loginExpGroup;
    private final LoginReportService loginReportService;
    private final SharedFlow<IAccountRedirect> redirect;
    private final ValidLoginType startAt;
    private final StateFlow<IFullscreenLoginState> state;
    private final FullscreenLoginStateMachine stateMachine;
    private final SharedFlow<ToastInfo> toast;
    private final List<ValidLoginType> validTypes;

    public static /* synthetic */ void getStartAt$annotations() {
    }

    public static /* synthetic */ void getValidTypes$annotations() {
    }

    @Inject
    public FullscreenLoginViewModel(SavedStateHandle savedStateHandle, IFullscreenLoginStateMachineFactory stateMachineProvider, LoginReportService loginReportService, LoginExpType loginExpGroup, LoginCountDownLatchService loginCountDownLatchService) {
        ValidLoginType validLoginType;
        ArrayList parcelableArrayList;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(stateMachineProvider, "stateMachineProvider");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(loginExpGroup, "loginExpGroup");
        Intrinsics.checkNotNullParameter(loginCountDownLatchService, "loginCountDownLatchService");
        this.loginReportService = loginReportService;
        this.loginExpGroup = loginExpGroup;
        this.loginCountDownLatchService = loginCountDownLatchService;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle bundle = (Bundle) savedStateHandle.get(str);
        this.validTypes = (bundle == null || (parcelableArrayList = bundle.getParcelableArrayList(StartLoginPageKt.KEY_VALID_TYPES)) == null) ? CollectionsKt.toList(ValidLoginType.Companion.getAllValues()) : parcelableArrayList;
        String str2 = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str2, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle bundle2 = (Bundle) savedStateHandle.get(str2);
        this.startAt = (bundle2 == null || (validLoginType = (ValidLoginType) bundle2.getParcelable(FullscreenLoginActivityKt.KEY_PAGE_START_AT)) == null) ? ValidLoginType.QuickLogin : validLoginType;
        this.stateMachine = stateMachineProvider.create(this.validTypes, IFullscreenLoginPageKt.toInitialState(this.startAt, savedStateHandle));
        this.state = FlowKt.stateIn(this.stateMachine.getState(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), this.stateMachine.getInitial());
        final Flow $this$map$iv = this.state;
        this.redirect = FlowKt.shareIn(FlowKt.distinctUntilChanged(new Flow<IAccountRedirect>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$1$2", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    IFullscreenLoginState it = (IFullscreenLoginState) value;
                                    IAccountRedirect redirect = it.getCurrentPage().getRedirect();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(redirect, $continuation) != coroutine_suspended) {
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
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), 0);
        final Flow $this$map$iv2 = this.state;
        this.dialogState = new Flow<Boolean>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$2$2", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    IFullscreenLoginState it = (IFullscreenLoginState) value;
                                    Boolean boxBoolean = Boxing.boxBoolean(it.getCurrentPage().getShowLoading());
                                    $continuation.label = 1;
                                    if (flowCollector.emit(boxBoolean, $continuation) != coroutine_suspended) {
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
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        final Flow $this$map$iv3 = this.state;
        this.captchaState = new Flow<LoginCaptchaInfo>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$3$2", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$3$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    IFullscreenLoginState it = (IFullscreenLoginState) value;
                                    LoginCaptchaInfo captchaDisplay = it.getCurrentPage().getCaptchaDisplay();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(captchaDisplay, $continuation) != coroutine_suspended) {
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
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv3.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        final Flow $this$map$iv4 = this.state;
        final Flow $this$filter$iv = new Flow<ToastInfo>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$4$2", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$4$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    IFullscreenLoginState it = (IFullscreenLoginState) value;
                                    ToastInfo toastInfo = it.getCurrentPage().getToastInfo();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(toastInfo, $continuation) != coroutine_suspended) {
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
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv4.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.toast = FlowKt.shareIn(FlowKt.distinctUntilChanged(new Flow<ToastInfo>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$filter$1$2", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                    ToastInfo it = (ToastInfo) value;
                                    ToastInfo it2 = !StringsKt.isBlank(it.getToast()) ? 1 : null;
                                    if (it2 != null) {
                                        $continuation.label = 1;
                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), 0);
        final Flow $this$map$iv5 = this.state;
        this.eulaDisplay = FlowKt.stateIn(FlowKt.distinctUntilChanged(new Flow<EulaDisplayInfo>() { // from class: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$5

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$5$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$5$2", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$special$$inlined$map$5$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    IFullscreenLoginState it = (IFullscreenLoginState) value;
                                    EulaDisplayInfo eulaDisplay = it.getCurrentPage().getEulaDisplay();
                                    $continuation.label = 1;
                                    if (flowCollector.emit(eulaDisplay, $continuation) != coroutine_suspended) {
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
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv5.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), (Object) null);
        this.interceptedActionFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    public final LoginReportService getLoginReportService() {
        return this.loginReportService;
    }

    public final LoginExpType getLoginExpGroup() {
        return this.loginExpGroup;
    }

    /* compiled from: FullscreenLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$1", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.bannerControl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FullscreenLoginViewModel.this.loginCountDownLatchService.countDown((Continuation) this) == coroutine_suspended) {
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

    public final List<ValidLoginType> getValidTypes() {
        return this.validTypes;
    }

    public final ValidLoginType getStartAt() {
        return this.startAt;
    }

    public final FullscreenLoginStateMachine getStateMachine() {
        return this.stateMachine;
    }

    public final StateFlow<IFullscreenLoginState> getState() {
        return this.state;
    }

    public final SharedFlow<IAccountRedirect> getRedirect() {
        return this.redirect;
    }

    public final Flow<Boolean> getDialogState() {
        return this.dialogState;
    }

    public final Flow<LoginCaptchaInfo> getCaptchaState() {
        return this.captchaState;
    }

    public final SharedFlow<ToastInfo> getToast() {
        return this.toast;
    }

    public final StateFlow<EulaDisplayInfo> getEulaDisplay() {
        return this.eulaDisplay;
    }

    public final MutableSharedFlow<IFullscreenLoginAction> getInterceptedActionFlow() {
        return this.interceptedActionFlow;
    }

    public final void dispatchAction(IFullscreenAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginViewModel$dispatchAction$1(this, action, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object interceptAction(IFullscreenAction action, Continuation<? super Boolean> continuation) {
        FullscreenLoginViewModel$interceptAction$1 fullscreenLoginViewModel$interceptAction$1;
        FullscreenLoginViewModel fullscreenLoginViewModel;
        int i;
        Object suspendGetLoginType$default;
        TInfoLogin infoLogin;
        int i2;
        if (continuation instanceof FullscreenLoginViewModel$interceptAction$1) {
            fullscreenLoginViewModel$interceptAction$1 = (FullscreenLoginViewModel$interceptAction$1) continuation;
            if ((fullscreenLoginViewModel$interceptAction$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenLoginViewModel$interceptAction$1.label -= Integer.MIN_VALUE;
                Object $result = fullscreenLoginViewModel$interceptAction$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fullscreenLoginViewModel$interceptAction$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        fullscreenLoginViewModel = this;
                        i = 0;
                        if (action instanceof IFullscreenLoginAction.SwitchToSms) {
                            LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                            fullscreenLoginViewModel$interceptAction$1.label = 1;
                            suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(loginRuleProcessor, false, false, fullscreenLoginViewModel$interceptAction$1, 3, null);
                            if (suspendGetLoginType$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).component2();
                            if (infoLogin == null && infoLogin.isSmsLoginEnable()) {
                                TInfoLogin.AB ab = infoLogin.ab;
                                if (ab != null && ab.isSmsLoginExp()) {
                                    i2 = 1;
                                    if (i2 == 0) {
                                        i = i2;
                                    } else {
                                        MutableSharedFlow<IFullscreenLoginAction> mutableSharedFlow = fullscreenLoginViewModel.interceptedActionFlow;
                                        IFullscreenLoginAction.RouterToSmsB1ExpLogin routerToSmsB1ExpLogin = IFullscreenLoginAction.RouterToSmsB1ExpLogin.INSTANCE;
                                        fullscreenLoginViewModel$interceptAction$1.I$0 = i2;
                                        fullscreenLoginViewModel$interceptAction$1.label = 2;
                                        if (mutableSharedFlow.emit(routerToSmsB1ExpLogin, fullscreenLoginViewModel$interceptAction$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i = i2;
                                    }
                                }
                            }
                            i2 = 0;
                            if (i2 == 0) {
                            }
                        }
                        return Boxing.boxBoolean(i != 0);
                    case 1:
                        ResultKt.throwOnFailure($result);
                        fullscreenLoginViewModel = this;
                        suspendGetLoginType$default = $result;
                        infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).component2();
                        if (infoLogin == null) {
                            break;
                        }
                        if (infoLogin == null && infoLogin.isSmsLoginEnable()) {
                        }
                        i2 = 0;
                        if (i2 == 0) {
                        }
                        break;
                    case 2:
                        i2 = fullscreenLoginViewModel$interceptAction$1.I$0;
                        ResultKt.throwOnFailure($result);
                        i = i2;
                        return Boxing.boxBoolean(i != 0);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fullscreenLoginViewModel$interceptAction$1 = new FullscreenLoginViewModel$interceptAction$1(this, continuation);
        Object $result2 = fullscreenLoginViewModel$interceptAction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fullscreenLoginViewModel$interceptAction$1.label) {
        }
    }

    public final void checkAndLogin() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginViewModel$checkAndLogin$1(this, null), 3, (Object) null);
    }

    public final void checkAndSendSmsCode() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginViewModel$checkAndSendSmsCode$1(this, null), 3, (Object) null);
    }

    public final void checkAndNetCodeAuth() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginViewModel$checkAndNetCodeAuth$1(this, null), 3, (Object) null);
    }
}