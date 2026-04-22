package kntr.app.tribee.operation.viewmodel;

import javax.inject.Inject;
import kntr.app.tribee.operation.viewmodel.state.TribeeOperationState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: TribeeOperationViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel;", "Lkntr/app/tribee/operation/viewmodel/ITribeeOperationViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "fromTribeeId", "", "stateMachine", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;JLkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiActionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "getUiActionFlow$annotations", "getUiActionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "dispatch", "", "action", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "close", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeOperationViewModel implements ITribeeOperationViewModel {
    public static final int $stable = 8;
    private final CoroutineScope scope;
    private final StateFlow<TribeeOperationState> state;
    private final TribeeOperationStateMachine stateMachine;
    private final SharedFlow<TribeeOperationUIAction> uiActionFlow;

    public static /* synthetic */ void getState$annotations() {
    }

    public static /* synthetic */ void getUiActionFlow$annotations() {
    }

    @Inject
    public TribeeOperationViewModel(CoroutineScope scope, @FromTribeeId long fromTribeeId, TribeeOperationStateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        this.scope = scope;
        this.stateMachine = stateMachine;
        this.state = FlowKt.stateIn(this.stateMachine.getState(), getScope(), SharingStarted.Companion.getLazily(), new TribeeOperationState.TribeeOperationInitiateState(Long.valueOf(fromTribeeId)));
        final Flow $this$map$iv = getState();
        this.uiActionFlow = FlowKt.shareIn(FlowKt.distinctUntilChanged(FlowKt.filterNotNull(new Flow<TribeeOperationUIAction>() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.app.tribee.operation.viewmodel.TribeeOperationViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.app.tribee.operation.viewmodel.TribeeOperationViewModel$special$$inlined$map$1$2", f = "TribeeOperationViewModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.tribee.operation.viewmodel.TribeeOperationViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
                                    TribeeOperationState it = (TribeeOperationState) value;
                                    TribeeOperationUIAction uiAction = it.getUiAction();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(uiAction, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
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
    }

    @Override // kntr.app.tribee.operation.viewmodel.ITribeeOperationViewModel
    public CoroutineScope getScope() {
        return this.scope;
    }

    @Override // kntr.app.tribee.operation.viewmodel.ITribeeOperationViewModel
    public StateFlow<TribeeOperationState> getState() {
        return this.state;
    }

    @Override // kntr.app.tribee.operation.viewmodel.ITribeeOperationViewModel
    public SharedFlow<TribeeOperationUIAction> getUiActionFlow() {
        return this.uiActionFlow;
    }

    @Override // kntr.app.tribee.operation.viewmodel.ITribeeOperationViewModel
    public void dispatch(TribeeOperationStateAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new TribeeOperationViewModel$dispatch$1(this, action, null), 3, (Object) null);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }
}