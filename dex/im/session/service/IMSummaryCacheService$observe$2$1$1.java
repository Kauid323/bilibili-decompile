package im.session.service;

import com.tencent.smtt.sdk.TbsListener;
import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSummaryCacheService$observe$2$1$1", f = "IMMessageSummaryService.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSummaryCacheService$observe$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionCard $session;
    final /* synthetic */ StateFlow<Summary> $stateFlow;
    int label;
    final /* synthetic */ IMSummaryCacheService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSummaryCacheService$observe$2$1$1(StateFlow<Summary> stateFlow, IMSessionCard iMSessionCard, IMSummaryCacheService iMSummaryCacheService, Continuation<? super IMSummaryCacheService$observe$2$1$1> continuation) {
        super(2, continuation);
        this.$stateFlow = stateFlow;
        this.$session = iMSessionCard;
        this.this$0 = iMSummaryCacheService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSummaryCacheService$observe$2$1$1(this.$stateFlow, this.$session, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Flow $this$map$iv = FlowKt.drop(this.$stateFlow, 1);
                final IMSessionCard iMSessionCard = this.$session;
                final IMSummaryCacheService iMSummaryCacheService = this.this$0;
                this.label = 1;
                if (new Flow<ConversationSummaryHolder>() { // from class: im.session.service.IMSummaryCacheService$observe$2$1$1$invokeSuspend$$inlined$map$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$map$iv.collect(new AnonymousClass2(collector, iMSessionCard), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: im.session.service.IMSummaryCacheService$observe$2$1$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ IMSessionCard $session$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "im.session.service.IMSummaryCacheService$observe$2$1$1$invokeSuspend$$inlined$map$1$2", f = "IMMessageSummaryService.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: im.session.service.IMSummaryCacheService$observe$2$1$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, IMSessionCard iMSessionCard) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$session$inlined = iMSessionCard;
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
                                            Summary it = (Summary) value;
                                            ConversationSummaryHolder conversationSummaryHolder = new ConversationSummaryHolder(this.$session$inlined.getId(), it);
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$map_u24lambda_u245.emit(conversationSummaryHolder, $continuation) != coroutine_suspended) {
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
                }.collect(new FlowCollector() { // from class: im.session.service.IMSummaryCacheService$observe$2$1$1.2
                    public final Object emit(ConversationSummaryHolder it, Continuation<? super Unit> continuation) {
                        MutableSharedFlow mutableSharedFlow;
                        mutableSharedFlow = IMSummaryCacheService.this.draftNotifyFlow;
                        Object emit = mutableSharedFlow.emit(it, continuation);
                        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                    }

                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ConversationSummaryHolder) value, (Continuation<? super Unit>) $completion);
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