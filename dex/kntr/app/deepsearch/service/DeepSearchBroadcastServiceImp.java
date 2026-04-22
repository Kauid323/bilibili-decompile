package kntr.app.deepsearch.service;

import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import kntr.app.deepsearch.base.model.biz.DeepSearchBroadcastService;
import kntr.app.deepsearch.di.DeepSearchScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;

/* compiled from: DeepSearchBroadcastServiceImp.kt */
@DeepSearchScope
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/deepsearch/service/DeepSearchBroadcastServiceImp;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;", "<init>", "()V", "deepSearchFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchBroadcastServiceImp implements DeepSearchBroadcastService {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private static final SharedFlow<Result<KDeepSearchResponse>> mossFlow = FlowKt.shareIn(Companion.startFlow(), scope, SharingStarted.Companion.getLazily(), 0);

    /* compiled from: DeepSearchBroadcastServiceImp.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/deepsearch/service/DeepSearchBroadcastServiceImp$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$biz_debug", "()Lkotlinx/coroutines/CoroutineScope;", "startFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "mossFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoroutineScope getScope$biz_debug() {
            return DeepSearchBroadcastServiceImp.scope;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Flow<Result<KDeepSearchResponse>> startFlow() {
            return FlowKt.callbackFlow(new DeepSearchBroadcastServiceImp$Companion$startFlow$1(null));
        }
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchBroadcastService
    public Flow<Result<KDeepSearchResponse>> deepSearchFlow() {
        final Flow $this$mapNotNull$iv = mossFlow;
        return new Flow<Result<? extends KDeepSearchResponse>>() { // from class: kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$deepSearchFlow$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$deepSearchFlow$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$deepSearchFlow$$inlined$mapNotNull$1$2", f = "DeepSearchBroadcastServiceImp.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                /* renamed from: kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$deepSearchFlow$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
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
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
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
                                    FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                    Object result = ((Result) value).unbox-impl();
                                    Object transformed = Result.box-impl(result);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNull_u24lambda_u246);
                                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable(transformed);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$mapNotNull_u24lambda_u246.emit(transformed, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    Result result2 = (Result) $continuation.L$4;
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
                Object collect = $this$mapNotNull$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}