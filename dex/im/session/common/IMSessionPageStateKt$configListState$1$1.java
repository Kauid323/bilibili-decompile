package im.session.common;

import androidx.compose.runtime.SnapshotStateKt;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPageState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.common.IMSessionPageStateKt$configListState$1$1", f = "IMSessionPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionPageStateKt$configListState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionPageState $this_configListState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionPageStateKt$configListState$1$1(IMSessionPageState iMSessionPageState, Continuation<? super IMSessionPageStateKt$configListState$1$1> continuation) {
        super(2, continuation);
        this.$this_configListState = iMSessionPageState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionPageStateKt$configListState$1$1 = new IMSessionPageStateKt$configListState$1$1(this.$this_configListState, continuation);
        iMSessionPageStateKt$configListState$1$1.L$0 = obj;
        return iMSessionPageStateKt$configListState$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final IMSessionPageState iMSessionPageState = this.$this_configListState;
                final Flow $this$filter$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: im.session.common.IMSessionPageStateKt$configListState$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Pair invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMSessionPageStateKt$configListState$1$1.invokeSuspend$lambda$0(IMSessionPageState.this);
                        return invokeSuspend$lambda$0;
                    }
                });
                final IMSessionPageState iMSessionPageState2 = this.$this_configListState;
                FlowKt.launchIn(FlowKt.onEach(new Flow<Pair<? extends Integer, ? extends Integer>>() { // from class: im.session.common.IMSessionPageStateKt$configListState$1$1$invokeSuspend$$inlined$filter$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, iMSessionPageState2), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: im.session.common.IMSessionPageStateKt$configListState$1$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ IMSessionPageState $this_configListState$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "im.session.common.IMSessionPageStateKt$configListState$1$1$invokeSuspend$$inlined$filter$1$2", f = "IMSessionPageState.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: im.session.common.IMSessionPageStateKt$configListState$1$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, IMSessionPageState iMSessionPageState) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$this_configListState$inlined = iMSessionPageState;
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
                                            Pair pair = (Pair) value;
                                            if (this.$this_configListState$inlined.getColumnState().isScrollInProgress()) {
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
                }, new AnonymousClass3(this.$this_configListState, null)), $this$LaunchedEffect);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(IMSessionPageState $this_configListState) {
        return TuplesKt.to(Integer.valueOf($this_configListState.getColumnState().getFirstVisibleItemIndex()), Integer.valueOf($this_configListState.getColumnState().getFirstVisibleItemScrollOffset()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMSessionPageState.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.common.IMSessionPageStateKt$configListState$1$1$3", f = "IMSessionPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.common.IMSessionPageStateKt$configListState$1$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
        final /* synthetic */ IMSessionPageState $this_configListState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(IMSessionPageState iMSessionPageState, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$this_configListState = iMSessionPageState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$this_configListState, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(Pair<Integer, Integer> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Pair it = (Pair) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.$this_configListState.getItemIndex$session_ui_debug().setIntValue(((Number) it.getFirst()).intValue());
                    this.$this_configListState.getItemOffset$session_ui_debug().setIntValue(((Number) it.getSecond()).intValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}