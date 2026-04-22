package home.sidecenter.selection;

import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import home.sidecenter.recent.MineSelection;
import home.sidecenter.recent.RecentIconItem;
import home.sidecenter.selection.ISideCenterSelectionAction;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SideCenterSelectionHolder.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010*\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010%R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lhome/sidecenter/selection/SideCenterSelectionHolder;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$sidecenter_debug$annotations", "()V", "getScope$sidecenter_debug", "()Lkotlinx/coroutines/CoroutineScope;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lhome/sidecenter/selection/SideCenterSelectionState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow$annotations", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "toastFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getToastFlow$annotations", "getToastFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentState", "getCurrentState", "()Lhome/sidecenter/selection/SideCenterSelectionState;", "handleAction", "", AuthActivity.ACTION_KEY, "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "dispatchAction", "Lhome/sidecenter/selection/SideCenterSelectionActionResult;", "(Lhome/sidecenter/selection/SideCenterSelectionState;Lhome/sidecenter/selection/ISideCenterSelectionAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickSelectedItem", "item", "Lhome/sidecenter/recent/RecentIconItem;", "clickOptionItem", "selectionOptionUpdate", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSelectionHolder {
    public static final int $stable = 8;
    private final MutableStateFlow<SideCenterSelectionState> _stateFlow;
    private final CoroutineScope scope;
    private final StateFlow<SideCenterSelectionState> stateFlow;
    private final SharedFlow<String> toastFlow;

    public static /* synthetic */ void getScope$sidecenter_debug$annotations() {
    }

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    public static /* synthetic */ void getToastFlow$annotations() {
    }

    public SideCenterSelectionHolder(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.scope = CoroutineScopeKt.CoroutineScope(context);
        this._stateFlow = StateFlowKt.MutableStateFlow(new SideCenterSelectionState(SideCenterSelectionPageStatus.Idle, "", null, null, null, 28, null));
        this.stateFlow = FlowKt.asStateFlow(this._stateFlow);
        final Flow $this$map$iv = this.stateFlow;
        final Flow $this$filter$iv = FlowKt.distinctUntilChanged(new Flow<String>() { // from class: home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$map$1$2", f = "SideCenterSelectionHolder.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$map$1$2$1  reason: invalid class name */
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
                                    SideCenterSelectionState it = (SideCenterSelectionState) value;
                                    String toast = it.getToast();
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
        });
        this.toastFlow = FlowKt.shareIn$default(new Flow<String>() { // from class: home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$filter$1$2", f = "SideCenterSelectionHolder.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: home.sidecenter.selection.SideCenterSelectionHolder$special$$inlined$filter$1$2$1  reason: invalid class name */
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
                                    String it = (String) value;
                                    if (!StringsKt.isBlank(it)) {
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
        }, this.scope, SharingStarted.Companion.getEagerly(), 0, 4, (Object) null);
    }

    public final CoroutineScope getScope$sidecenter_debug() {
        return this.scope;
    }

    public final StateFlow<SideCenterSelectionState> getStateFlow() {
        return this.stateFlow;
    }

    public final SharedFlow<String> getToastFlow() {
        return this.toastFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SideCenterSelectionState getCurrentState() {
        return (SideCenterSelectionState) this.stateFlow.getValue();
    }

    public final void handleAction(ISideCenterSelectionAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        KLog_androidKt.getKLog().d("SideCenterSelectionHolder", "handleAction: " + action);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SideCenterSelectionHolder$handleAction$1(this, action, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchAction(SideCenterSelectionState currentState, ISideCenterSelectionAction action, Continuation<? super SideCenterSelectionActionResult> continuation) {
        String message;
        if (action instanceof ISideCenterSelectionAction.LoadData) {
            return loadData(continuation);
        }
        if (action instanceof ISideCenterSelectionAction.LoadDataSuccess) {
            return new SideCenterSelectionActionResult(((ISideCenterSelectionAction.LoadDataSuccess) action).getState(), null, 2, null);
        }
        if (action instanceof ISideCenterSelectionAction.LoadDataFailed) {
            SideCenterSelectionPageStatus sideCenterSelectionPageStatus = SideCenterSelectionPageStatus.Error;
            Throwable throwable = ((ISideCenterSelectionAction.LoadDataFailed) action).getThrowable();
            return new SideCenterSelectionActionResult(SideCenterSelectionState.copy$default(currentState, sideCenterSelectionPageStatus, (throwable == null || (message = throwable.getMessage()) == null) ? "" : message, null, null, null, 28, null), null, 2, null);
        } else if (action instanceof ISideCenterSelectionAction.ClickSelectedItem) {
            return clickSelectedItem(((ISideCenterSelectionAction.ClickSelectedItem) action).getItem());
        } else {
            if (action instanceof ISideCenterSelectionAction.ClickOptionItem) {
                return clickOptionItem(((ISideCenterSelectionAction.ClickOptionItem) action).getItem());
            }
            if (action instanceof ISideCenterSelectionAction.UpdateSelectedItem) {
                return selectionOptionUpdate(continuation);
            }
            if (action instanceof ISideCenterSelectionAction.UpdateSelectedItemSuccess) {
                return new SideCenterSelectionActionResult(SideCenterSelectionState.copy$default(currentState, SideCenterSelectionPageStatus.UpdateSuccess, ((ISideCenterSelectionAction.UpdateSelectedItemSuccess) action).getMessage(), new MineSelection(currentState.getSelected()), null, null, 24, null), null, 2, null);
            }
            if (!(action instanceof ISideCenterSelectionAction.UpdateSelectedItemFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            SideCenterSelectionPageStatus sideCenterSelectionPageStatus2 = SideCenterSelectionPageStatus.Success;
            String message2 = ((ISideCenterSelectionAction.UpdateSelectedItemFailed) action).getThrowable().getMessage();
            return new SideCenterSelectionActionResult(SideCenterSelectionState.copy$default(currentState, sideCenterSelectionPageStatus2, message2 == null ? "" : message2, null, null, null, 28, null), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadData(Continuation<? super SideCenterSelectionActionResult> continuation) {
        return new SideCenterSelectionActionResult(SideCenterSelectionState.copy$default(getCurrentState(), SideCenterSelectionPageStatus.Loading, null, null, null, null, 30, null), new SideCenterSelectionHolder$loadData$2(null));
    }

    private final SideCenterSelectionActionResult clickSelectedItem(RecentIconItem item) {
        SideCenterSelectionState state;
        if (item.getFixed()) {
            state = SideCenterSelectionState.copy$default(getCurrentState(), null, "本功能为常驻功能，无法编辑", null, null, null, 29, null);
        } else {
            state = getCurrentState().removeItem(item);
        }
        return new SideCenterSelectionActionResult(state, null, 2, null);
    }

    private final SideCenterSelectionActionResult clickOptionItem(RecentIconItem item) {
        SideCenterSelectionState state;
        if (item.isChecked()) {
            state = SideCenterSelectionState.copy$default(getCurrentState(), null, "", null, null, null, 29, null);
        } else if (getCurrentState().getSelected().size() >= 8) {
            state = SideCenterSelectionState.copy$default(getCurrentState(), null, "最多可以选择8个快捷功能", null, null, null, 29, null);
        } else {
            state = getCurrentState().addItem(item);
        }
        return new SideCenterSelectionActionResult(state, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object selectionOptionUpdate(Continuation<? super SideCenterSelectionActionResult> continuation) {
        return new SideCenterSelectionActionResult(SideCenterSelectionState.copy$default(getCurrentState(), SideCenterSelectionPageStatus.Loading, null, null, null, null, 30, null), new SideCenterSelectionHolder$selectionOptionUpdate$2(this, null));
    }
}