package im.session;

import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import im.base.IMLog;
import im.base.IMToast;
import im.session.RequestStatus;
import im.session.log.LogTagKt;
import im.session.model.IMSessionAlert;
import im.session.model.IMSessionPageData;
import im.session.observer.IMSessionEventObserver;
import java.util.Set;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B4\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0011\u0010\b\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J,\u0010.\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\n0\t2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a00¢\u0006\u0002\b1H\u0082\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#R$\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010)R$\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0%8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010)¨\u00062"}, d2 = {"Lim/session/IMSessionViewModelImpl;", "Lim/session/IMSessionViewModel;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateMachine", "Lim/session/IMSessionStateMachine;", "observers", "", "Lim/session/observer/IMSessionEventObserver;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lkotlinx/coroutines/CoroutineScope;Lim/session/IMSessionStateMachine;Ljava/util/Set;)V", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lim/session/IMState;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "close", "", "dispatch", AuthActivity.ACTION_KEY, "Lim/session/IMAction;", "toastFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lim/base/IMToast;", "getToastFlow$annotations", "getToastFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "autoReplyBubble", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;", "getAutoReplyBubble$annotations", "getAutoReplyBubble", "()Lkotlinx/coroutines/flow/Flow;", "alertFlow", "Lim/session/model/IMSessionAlert;", "getAlertFlow$annotations", "getAlertFlow", "call", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionViewModelImpl implements IMSessionViewModel {
    private final Flow<IMSessionAlert> alertFlow;
    private final Flow<KAutoReplyToast> autoReplyBubble;
    private final Set<IMSessionEventObserver> observers;
    private final KSessionPageType pageType;
    private final CoroutineScope scope;
    private final StateFlow<IMState> state;
    private final IMSessionStateMachine stateMachine;
    private final SharedFlow<IMToast> toastFlow;

    public static /* synthetic */ void getAlertFlow$annotations() {
    }

    public static /* synthetic */ void getAutoReplyBubble$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public static /* synthetic */ void getToastFlow$annotations() {
    }

    @Inject
    public IMSessionViewModelImpl(KSessionPageType pageType, CoroutineScope scope, IMSessionStateMachine stateMachine, Set<IMSessionEventObserver> set) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(set, "observers");
        this.pageType = pageType;
        this.scope = scope;
        this.stateMachine = stateMachine;
        this.observers = set;
        this.state = FlowKt.stateIn(FlowKt.onEach(FlowKt.onCompletion(FlowKt.onStart(this.stateMachine.getState(), new IMSessionViewModelImpl$state$1(this, null)), new IMSessionViewModelImpl$state$2(this, null)), new IMSessionViewModelImpl$state$3(null)), getScope(), SharingStarted.Companion.getLazily(), new IMState(getPageType(), new IMSessionPageData(null, null, null, null, null, null, null, null, null, null, false, 2047, null), null, false, null, null, false, null, 252, null));
        Iterable $this$call$iv = this.observers;
        Iterable $this$forEach$iv$iv = $this$call$iv;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            IMSessionEventObserver it$iv = (IMSessionEventObserver) element$iv$iv;
            it$iv.onPageInitialed(getPageType());
        }
        BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
        BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(null), 3, (Object) null);
        final Flow $this$map$iv = getState();
        this.toastFlow = FlowKt.shareIn(FlowKt.distinctUntilChanged(FlowKt.filterNotNull(new Flow<IMToast>() { // from class: im.session.IMSessionViewModelImpl$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.session.IMSessionViewModelImpl$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.session.IMSessionViewModelImpl$special$$inlined$map$1$2", f = "IMSessionViewModel.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.session.IMSessionViewModelImpl$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
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
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
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
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    IMState it = (IMState) value;
                                    IMToast toast = it.getToast();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(toast, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i2 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
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
        })), getScope(), SharingStarted.Companion.getLazily(), 0);
        final Flow $this$map$iv2 = getState();
        this.autoReplyBubble = FlowKt.onEach(FlowKt.onEach(FlowKt.debounceDuration(FlowKt.distinctUntilChanged(new Flow<KAutoReplyToast>() { // from class: im.session.IMSessionViewModelImpl$special$$inlined$map$2
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.session.IMSessionViewModelImpl$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.session.IMSessionViewModelImpl$special$$inlined$map$2$2", f = "IMSessionViewModel.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.session.IMSessionViewModelImpl$special$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
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

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    KAutoReplyToast it;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    KSessionListExtraInfo extraInfo = ((IMState) value).getData().getExtraInfo();
                                    KAutoReplyToast kAutoReplyToast = null;
                                    if (extraInfo != null && (it = extraInfo.getAutoReplyToast()) != null && !StringsKt.isBlank(it.getTitle())) {
                                        kAutoReplyToast = it;
                                    }
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(kAutoReplyToast, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    int i2 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
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
        }), new Function1() { // from class: im.session.IMSessionViewModelImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Duration autoReplyBubble$lambda$1;
                autoReplyBubble$lambda$1 = IMSessionViewModelImpl.autoReplyBubble$lambda$1((KAutoReplyToast) obj);
                return autoReplyBubble$lambda$1;
            }
        }), new IMSessionViewModelImpl$autoReplyBubble$3(null)), new IMSessionViewModelImpl$autoReplyBubble$4(this, null));
        final Flow $this$map$iv3 = getState();
        this.alertFlow = FlowKt.distinctUntilChanged(new Flow<IMSessionAlert>() { // from class: im.session.IMSessionViewModelImpl$special$$inlined$map$3
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv3.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.session.IMSessionViewModelImpl$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.session.IMSessionViewModelImpl$special$$inlined$map$3$2", f = "IMSessionViewModel.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.session.IMSessionViewModelImpl$special$$inlined$map$3$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
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
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
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
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    IMState it = (IMState) value;
                                    IMSessionAlert alert$session_debug = it.getData().getAlert$session_debug();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(alert$session_debug, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i2 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
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
        });
    }

    @Override // im.session.IMSessionViewModel
    public KSessionPageType getPageType() {
        return this.pageType;
    }

    @Override // im.session.IMSessionViewModel
    public CoroutineScope getScope() {
        return this.scope;
    }

    @Override // im.session.IMSessionViewModel
    public StateFlow<IMState> getState() {
        return this.state;
    }

    /* compiled from: IMSessionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.IMSessionViewModelImpl$2", f = "IMSessionViewModel.kt", i = {}, l = {WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.IMSessionViewModelImpl$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object firstOrNull;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final Flow $this$filter$iv = IMSessionViewModelImpl.this.getState();
                    this.label = 1;
                    firstOrNull = FlowKt.firstOrNull(new Flow<IMState>() { // from class: im.session.IMSessionViewModelImpl$2$invokeSuspend$$inlined$filter$1

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: im.session.IMSessionViewModelImpl$2$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "im.session.IMSessionViewModelImpl$2$invokeSuspend$$inlined$filter$1$2", f = "IMSessionViewModel.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                            /* renamed from: im.session.IMSessionViewModelImpl$2$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int I$0;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
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
                            /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
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
                                                AnonymousClass1 anonymousClass1 = $continuation;
                                                IMState it = (IMState) value;
                                                if ((it.getType$session_debug() instanceof RequestStatus.Idle) && it.getData().getHasContent()) {
                                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                    $continuation.I$0 = 0;
                                                    $continuation.label = 1;
                                                    if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                        break;
                                                    } else {
                                                        return coroutine_suspended;
                                                    }
                                                }
                                                break;
                                            case 1:
                                                int i2 = $continuation.I$0;
                                                FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                Object obj = $continuation.L$2;
                                                AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                                Object value2 = $continuation.L$0;
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
                    }, (Continuation) this);
                    if (firstOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    firstOrNull = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((IMState) firstOrNull) != null) {
                IMSessionViewModelImpl iMSessionViewModelImpl = IMSessionViewModelImpl.this;
                Iterable $this$call$iv = iMSessionViewModelImpl.observers;
                Iterable $this$forEach$iv$iv = $this$call$iv;
                for (Object element$iv$iv : $this$forEach$iv$iv) {
                    IMSessionEventObserver it$iv = (IMSessionEventObserver) element$iv$iv;
                    it$iv.onPageFirstLoaded(iMSessionViewModelImpl.getPageType());
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: IMSessionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.IMSessionViewModelImpl$3", f = "IMSessionViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.IMSessionViewModelImpl$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                IMSessionViewModelImpl.this.close();
                throw th;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterable $this$call$iv = this.observers;
        Iterable $this$forEach$iv$iv = $this$call$iv;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            IMSessionEventObserver it$iv = (IMSessionEventObserver) element$iv$iv;
            it$iv.onPageClosed(getPageType());
        }
    }

    @Override // im.session.IMSessionViewModel
    public void dispatch(IMAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        if (!(action instanceof IMSilentAction)) {
            IMLog.Companion.i(LogTagKt.getVMLogTag(), "Dispatch Action " + action);
        }
        BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new IMSessionViewModelImpl$dispatch$1(this, action, null), 3, (Object) null);
    }

    @Override // im.session.IMSessionViewModel
    public SharedFlow<IMToast> getToastFlow() {
        return this.toastFlow;
    }

    @Override // im.session.IMSessionViewModel
    public Flow<KAutoReplyToast> getAutoReplyBubble() {
        return this.autoReplyBubble;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Duration autoReplyBubble$lambda$1(KAutoReplyToast it) {
        if (it == null) {
            Duration.Companion companion = Duration.Companion;
            return Duration.box-impl(DurationKt.toDuration(0, DurationUnit.SECONDS));
        }
        Duration.Companion companion2 = Duration.Companion;
        return Duration.box-impl(DurationKt.toDuration(0.5d, DurationUnit.SECONDS));
    }

    @Override // im.session.IMSessionViewModel
    public Flow<IMSessionAlert> getAlertFlow() {
        return this.alertFlow;
    }

    private final void call(Set<? extends IMSessionEventObserver> set, Function1<? super IMSessionEventObserver, Unit> function1) {
        Set<? extends IMSessionEventObserver> $this$forEach$iv = set;
        for (Object element$iv : $this$forEach$iv) {
            IMSessionEventObserver it = (IMSessionEventObserver) element$iv;
            function1.invoke(it);
        }
    }
}