package home.sidecenter.settings;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$handleAction$1", f = "SideCenterSettingsHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SideCenterSettingsHolder$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISideCenterSettingsAction $action;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SideCenterSettingsHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterSettingsHolder$handleAction$1(SideCenterSettingsHolder sideCenterSettingsHolder, ISideCenterSettingsAction iSideCenterSettingsAction, Continuation<? super SideCenterSettingsHolder$handleAction$1> continuation) {
        super(2, continuation);
        this.this$0 = sideCenterSettingsHolder;
        this.$action = iSideCenterSettingsAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sideCenterSettingsHolder$handleAction$1 = new SideCenterSettingsHolder$handleAction$1(this.this$0, this.$action, continuation);
        sideCenterSettingsHolder$handleAction$1.L$0 = obj;
        return sideCenterSettingsHolder$handleAction$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SideCenterSettingsState currentState;
        SideCenterSettingsActionResult result;
        MutableStateFlow mutableStateFlow;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SideCenterSettingsHolder sideCenterSettingsHolder = this.this$0;
                currentState = this.this$0.getCurrentState();
                result = sideCenterSettingsHolder.dispatchAction(currentState, this.$action);
                mutableStateFlow = this.this$0._stateFlow;
                mutableStateFlow.setValue(result.getNewState());
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(result, this.this$0, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SideCenterSettingsHolder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$handleAction$1$1", f = "SideCenterSettingsHolder.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: home.sidecenter.settings.SideCenterSettingsHolder$handleAction$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SideCenterSettingsActionResult $result;
        int label;
        final /* synthetic */ SideCenterSettingsHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SideCenterSettingsActionResult sideCenterSettingsActionResult, SideCenterSettingsHolder sideCenterSettingsHolder, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = sideCenterSettingsActionResult;
            this.this$0 = sideCenterSettingsHolder;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<ISideCenterSettingsAction> sideEffect = this.$result.getSideEffect();
                    final SideCenterSettingsHolder sideCenterSettingsHolder = this.this$0;
                    this.label = 1;
                    if (sideEffect.collect(new FlowCollector() { // from class: home.sidecenter.settings.SideCenterSettingsHolder.handleAction.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((ISideCenterSettingsAction) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(ISideCenterSettingsAction it, Continuation<? super Unit> continuation) {
                            SideCenterSettingsHolder.this.handleAction(it);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
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
}