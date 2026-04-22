package im.customer.settings;

import host.R;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomerSettingStateHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$handleAction$1", f = "CustomerSettingStateHolder.kt", i = {1}, l = {R.styleable.CameraView_cameraVideoSizeSmallest, 57}, m = "invokeSuspend", n = {"result"}, s = {"L$0"}, v = 1)
public final class CustomerSettingStateHolder$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ICustomerSettingAction $action;
    Object L$0;
    int label;
    final /* synthetic */ CustomerSettingStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerSettingStateHolder$handleAction$1(CustomerSettingStateHolder customerSettingStateHolder, ICustomerSettingAction iCustomerSettingAction, Continuation<? super CustomerSettingStateHolder$handleAction$1> continuation) {
        super(2, continuation);
        this.this$0 = customerSettingStateHolder;
        this.$action = iCustomerSettingAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerSettingStateHolder$handleAction$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object dispatchAction;
        CustomerSettingActionResult result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                dispatchAction = this.this$0.dispatchAction((CustomerSettingState) this.this$0.getStateFlow().getValue(), this.$action, (Continuation) this);
                if (dispatchAction == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (CustomerSettingActionResult) dispatchAction;
                this.this$0.getStateFlow().setValue(result.getNewState());
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(result, this.this$0, null), (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                dispatchAction = $result;
                result = (CustomerSettingActionResult) dispatchAction;
                this.this$0.getStateFlow().setValue(result.getNewState());
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(result, this.this$0, null), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                CustomerSettingActionResult customerSettingActionResult = (CustomerSettingActionResult) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomerSettingStateHolder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$handleAction$1$1", f = "CustomerSettingStateHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.customer.settings.CustomerSettingStateHolder$handleAction$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomerSettingActionResult $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CustomerSettingStateHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CustomerSettingActionResult customerSettingActionResult, CustomerSettingStateHolder customerSettingStateHolder, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = customerSettingActionResult;
            this.this$0 = customerSettingStateHolder;
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
        /* compiled from: CustomerSettingStateHolder.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "im.customer.settings.CustomerSettingStateHolder$handleAction$1$1$1", f = "CustomerSettingStateHolder.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: im.customer.settings.CustomerSettingStateHolder$handleAction$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CustomerSettingActionResult $result;
            int label;
            final /* synthetic */ CustomerSettingStateHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00251(CustomerSettingActionResult customerSettingActionResult, CustomerSettingStateHolder customerSettingStateHolder, Continuation<? super C00251> continuation) {
                super(2, continuation);
                this.$result = customerSettingActionResult;
                this.this$0 = customerSettingStateHolder;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00251(this.$result, this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Flow<ICustomerSettingAction> sideEffect = this.$result.getSideEffect();
                        final CustomerSettingStateHolder customerSettingStateHolder = this.this$0;
                        this.label = 1;
                        if (sideEffect.collect(new FlowCollector() { // from class: im.customer.settings.CustomerSettingStateHolder.handleAction.1.1.1.1
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((ICustomerSettingAction) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(ICustomerSettingAction it, Continuation<? super Unit> continuation) {
                                CustomerSettingStateHolder.this.handleAction(it);
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
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00251(this.$result, this.this$0, null), 3, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}