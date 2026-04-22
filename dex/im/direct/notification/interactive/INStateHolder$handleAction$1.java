package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$handleAction$1", f = "INStateHolder.kt", i = {1}, l = {131, 133}, m = "invokeSuspend", n = {"result"}, s = {"L$0"}, v = 1)
public final class INStateHolder$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ INAction $action;
    Object L$0;
    int label;
    final /* synthetic */ INStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$handleAction$1(INStateHolder iNStateHolder, INAction iNAction, Continuation<? super INStateHolder$handleAction$1> continuation) {
        super(2, continuation);
        this.this$0 = iNStateHolder;
        this.$action = iNAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new INStateHolder$handleAction$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        INState currentState;
        Object dispatchAction;
        INActionResult result;
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                INStateHolder iNStateHolder = this.this$0;
                currentState = this.this$0.getCurrentState();
                this.label = 1;
                dispatchAction = iNStateHolder.dispatchAction(currentState, this.$action, (Continuation) this);
                if (dispatchAction == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (INActionResult) dispatchAction;
                mutableStateFlow = this.this$0._stateFlow;
                mutableStateFlow.setValue(result.getNext());
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(result, this.this$0, null), (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                dispatchAction = $result;
                result = (INActionResult) dispatchAction;
                mutableStateFlow = this.this$0._stateFlow;
                mutableStateFlow.setValue(result.getNext());
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(result, this.this$0, null), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                INActionResult iNActionResult = (INActionResult) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: INStateHolder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$handleAction$1$1", f = "INStateHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.direct.notification.interactive.INStateHolder$handleAction$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ INActionResult $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ INStateHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(INActionResult iNActionResult, INStateHolder iNStateHolder, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = iNActionResult;
            this.this$0 = iNStateHolder;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$result, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: INStateHolder.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$handleAction$1$1$1", f = "INStateHolder.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: im.direct.notification.interactive.INStateHolder$handleAction$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class C00271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ INActionResult $result;
            int label;
            final /* synthetic */ INStateHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00271(INActionResult iNActionResult, INStateHolder iNStateHolder, Continuation<? super C00271> continuation) {
                super(2, continuation);
                this.$result = iNActionResult;
                this.this$0 = iNStateHolder;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00271(this.$result, this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Flow<INAction> sideEffect = this.$result.getSideEffect();
                        final INStateHolder iNStateHolder = this.this$0;
                        this.label = 1;
                        if (sideEffect.collect(new FlowCollector() { // from class: im.direct.notification.interactive.INStateHolder.handleAction.1.1.1.1
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((INAction) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(INAction it, Continuation<? super Unit> continuation) {
                                INStateHolder.this.handleAction(it);
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

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00271(this.$result, this.this$0, null), 3, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}