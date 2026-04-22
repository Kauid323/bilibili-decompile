package im.customer.settings;

import com.bilibili.blens.BSetter;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import im.customer.settings.ICustomerSettingAction;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: CustomerSettingStateHolder.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001e\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020&H\u0082@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lim/customer/settings/CustomerSettingStateHolder;", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "id", "Lim/customer/settings/CustomerShopId;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lim/customer/settings/CustomerShopId;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$customer_debug$annotations", "()V", "getCoroutineScope$customer_debug", "()Lkotlinx/coroutines/CoroutineScope;", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lim/customer/settings/CustomerSettingState;", "getStateFlow$annotations", "getStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "toastFlow", "Lkotlinx/coroutines/flow/Flow;", "Lim/customer/settings/ToastHolder;", "getToastFlow$annotations", "getToastFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "getCurrentState", "()Lim/customer/settings/CustomerSettingState;", "handleAction", "", AuthActivity.ACTION_KEY, "Lim/customer/settings/ICustomerSettingAction;", "statusLens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/customer/settings/CustomerSettingPageStatus;", "toastLens", "dispatchAction", "Lim/customer/settings/CustomerSettingActionResult;", "(Lim/customer/settings/CustomerSettingState;Lim/customer/settings/ICustomerSettingAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAction", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setItemSwitch", "Lim/customer/settings/ICustomerSettingAction$ClickSettingItem;", "(Lim/customer/settings/ICustomerSettingAction$ClickSettingItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingStateHolder {
    private final CoroutineScope coroutineScope;
    private final CustomerShopId id;
    private final MutableStateFlow<CustomerSettingState> stateFlow;
    private final BSimpleLens<CustomerSettingState, CustomerSettingPageStatus> statusLens;
    private final Flow<ToastHolder> toastFlow;
    private final BSimpleLens<CustomerSettingState, ToastHolder> toastLens;

    public static /* synthetic */ void getCoroutineScope$customer_debug$annotations() {
    }

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    public static /* synthetic */ void getToastFlow$annotations() {
    }

    public CustomerSettingStateHolder(CoroutineContext coroutineContext, CustomerShopId id) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        KLog_androidKt.getKLog().i("CustomerSettingStateHolder", "init with shop " + this.id);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineContext.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.stateFlow = StateFlowKt.MutableStateFlow(new CustomerSettingState(this.id, CollectionsKt.emptyList(), null, null, 12, null));
        final Flow $this$map$iv = this.stateFlow;
        final Flow $this$filter$iv = new Flow<ToastHolder>() { // from class: im.customer.settings.CustomerSettingStateHolder$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.customer.settings.CustomerSettingStateHolder$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$special$$inlined$map$1$2", f = "CustomerSettingStateHolder.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.customer.settings.CustomerSettingStateHolder$special$$inlined$map$1$2$1  reason: invalid class name */
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
                                    CustomerSettingState it = (CustomerSettingState) value;
                                    ToastHolder toast = it.getToast();
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
        };
        this.toastFlow = FlowKt.distinctUntilChanged(new Flow<ToastHolder>() { // from class: im.customer.settings.CustomerSettingStateHolder$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.customer.settings.CustomerSettingStateHolder$special$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$special$$inlined$filter$1$2", f = "CustomerSettingStateHolder.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.customer.settings.CustomerSettingStateHolder$special$$inlined$filter$1$2$1  reason: invalid class name */
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
                                    ToastHolder it = (ToastHolder) value;
                                    if (!StringsKt.isBlank(it.getMessage())) {
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
        });
        this.statusLens = CustomerSettingStateLensKt.getStatus(CustomerSettingState.Companion);
        this.toastLens = CustomerSettingStateLensKt.getToast(CustomerSettingState.Companion);
    }

    public final CoroutineScope getCoroutineScope$customer_debug() {
        return this.coroutineScope;
    }

    public final MutableStateFlow<CustomerSettingState> getStateFlow() {
        return this.stateFlow;
    }

    public final Flow<ToastHolder> getToastFlow() {
        return this.toastFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomerSettingState getCurrentState() {
        return (CustomerSettingState) this.stateFlow.getValue();
    }

    public final void handleAction(ICustomerSettingAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CustomerSettingStateHolder$handleAction$1(this, action, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchAction(CustomerSettingState currentState, final ICustomerSettingAction action, Continuation<? super CustomerSettingActionResult> continuation) {
        CustomerSettingState triggerSettingStatus;
        if (action instanceof ICustomerSettingAction.LoadSetting) {
            return loadAction(continuation);
        }
        if (action instanceof ICustomerSettingAction.LoadSettingFailed) {
            return new CustomerSettingActionResult((CustomerSettingState) CopyScopeKt.copy(currentState, new Function1() { // from class: im.customer.settings.CustomerSettingStateHolder$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit dispatchAction$lambda$0;
                    dispatchAction$lambda$0 = CustomerSettingStateHolder.dispatchAction$lambda$0(CustomerSettingStateHolder.this, action, (CopyScope) obj);
                    return dispatchAction$lambda$0;
                }
            }), null, 2, null);
        }
        if (action instanceof ICustomerSettingAction.LoadSettingSuccess) {
            return new CustomerSettingActionResult(((ICustomerSettingAction.LoadSettingSuccess) action).getSettingState(), null, 2, null);
        }
        if (action instanceof ICustomerSettingAction.ClickSettingItem) {
            return setItemSwitch((ICustomerSettingAction.ClickSettingItem) action, continuation);
        }
        if (action instanceof ICustomerSettingAction.SettingItemSwitchFailed) {
            triggerSettingStatus = CustomerSettingStateHolderKt.triggerSettingStatus(currentState, ((ICustomerSettingAction.SettingItemSwitchFailed) action).getItem());
            return new CustomerSettingActionResult((CustomerSettingState) CopyScopeKt.copy(triggerSettingStatus, new Function1() { // from class: im.customer.settings.CustomerSettingStateHolder$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit dispatchAction$lambda$1;
                    dispatchAction$lambda$1 = CustomerSettingStateHolder.dispatchAction$lambda$1(CustomerSettingStateHolder.this, action, (CopyScope) obj);
                    return dispatchAction$lambda$1;
                }
            }), null, 2, null);
        } else if (!(action instanceof ICustomerSettingAction.SettingItemSwitchSuccess)) {
            throw new NoWhenBranchMatchedException();
        } else {
            return new CustomerSettingActionResult((CustomerSettingState) CopyScopeKt.copy(currentState, new Function1() { // from class: im.customer.settings.CustomerSettingStateHolder$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit dispatchAction$lambda$2;
                    dispatchAction$lambda$2 = CustomerSettingStateHolder.dispatchAction$lambda$2(CustomerSettingStateHolder.this, action, (CopyScope) obj);
                    return dispatchAction$lambda$2;
                }
            }), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$0(CustomerSettingStateHolder this$0, ICustomerSettingAction $action, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.statusLens, CustomerSettingPageStatus.Error);
        BSetter bSetter = this$0.toastLens;
        String message = ((ICustomerSettingAction.LoadSettingFailed) $action).getThrowable().getMessage();
        if (message == null) {
            message = "";
        }
        $this$copy.set(bSetter, new ToastHolder(message, 0L, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$1(CustomerSettingStateHolder this$0, ICustomerSettingAction $action, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.statusLens, CustomerSettingPageStatus.Success);
        BSetter bSetter = this$0.toastLens;
        String message = ((ICustomerSettingAction.SettingItemSwitchFailed) $action).getThrowable().getMessage();
        if (message == null) {
            message = "";
        }
        $this$copy.set(bSetter, new ToastHolder(message, 0L, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$2(CustomerSettingStateHolder this$0, ICustomerSettingAction $action, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.statusLens, CustomerSettingPageStatus.Success);
        $this$copy.set(this$0.toastLens, new ToastHolder(((ICustomerSettingAction.SettingItemSwitchSuccess) $action).getMessage(), 0L, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAction(Continuation<? super CustomerSettingActionResult> continuation) {
        return new CustomerSettingActionResult((CustomerSettingState) this.statusLens.set(getCurrentState(), CustomerSettingPageStatus.Loading), new CustomerSettingStateHolder$loadAction$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setItemSwitch(ICustomerSettingAction.ClickSettingItem action, Continuation<? super CustomerSettingActionResult> continuation) {
        CustomerSettingState triggerSettingStatus;
        ILogger kLog = KLog_androidKt.getKLog();
        CustomerSettingType type = action.getItem().getType();
        kLog.i("CustomerSettingStateHolder", "Set switch for setting " + type + " of shop " + this.id);
        if (getCurrentState().getStatus() != CustomerSettingPageStatus.Success) {
            ILogger kLog2 = KLog_androidKt.getKLog();
            CustomerSettingType type2 = action.getItem().getType();
            kLog2.w("CustomerSettingStateHolder", "Now not success, reject switch for setting " + type2 + " of shop " + this.id);
            return new CustomerSettingActionResult(getCurrentState(), null, 2, null);
        } else if (!(action.getItem().getButton() instanceof CustomerSettingRouteButton)) {
            triggerSettingStatus = CustomerSettingStateHolderKt.triggerSettingStatus((CustomerSettingState) this.statusLens.set(getCurrentState(), CustomerSettingPageStatus.SettingLoading), action.getItem());
            return new CustomerSettingActionResult(triggerSettingStatus, new CustomerSettingStateHolder$setItemSwitch$2(this, action, null));
        } else {
            KLog_androidKt.getKLog().i("CustomerSettingStateHolder", "Click on route button, handled by ui");
            return new CustomerSettingActionResult(getCurrentState(), null, 2, null);
        }
    }
}