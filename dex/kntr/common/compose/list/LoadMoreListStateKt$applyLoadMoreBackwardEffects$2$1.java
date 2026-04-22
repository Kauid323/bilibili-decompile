package kntr.common.compose.list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoadMoreListState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1", f = "LoadMoreListState.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableSharedFlow<Unit> $scrollToTopState;
    final /* synthetic */ LazyListState $this_applyLoadMoreBackwardEffects;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1(LazyListState lazyListState, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1> continuation) {
        super(2, continuation);
        this.$this_applyLoadMoreBackwardEffects = lazyListState;
        this.$scrollToTopState = mutableSharedFlow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1(this.$this_applyLoadMoreBackwardEffects, this.$scrollToTopState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyListState lazyListState = this.$this_applyLoadMoreBackwardEffects;
                final Flow $this$filter$iv = FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Pair invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1.invokeSuspend$lambda$0(lazyListState);
                        return invokeSuspend$lambda$0;
                    }
                }), 1);
                final MutableSharedFlow<Unit> mutableSharedFlow = this.$scrollToTopState;
                this.label = 1;
                if (new Flow<Pair<? extends Boolean, ? extends Boolean>>() { // from class: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1$invokeSuspend$$inlined$filter$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* renamed from: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1$invokeSuspend$$inlined$filter$1$2", f = "LoadMoreListState.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass1 = $continuation;
                                            Pair it = (Pair) value;
                                            if ((((Boolean) it.getFirst()).booleanValue() || ((Boolean) it.getSecond()).booleanValue()) ? false : true) {
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
                                            int i = $continuation.I$0;
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
                }.collect(new FlowCollector() { // from class: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$2$1.3
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Pair) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Pair<Boolean, Boolean> pair, Continuation<? super Unit> continuation) {
                        Object emit = mutableSharedFlow.emit(Unit.INSTANCE, continuation);
                        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState $this_applyLoadMoreBackwardEffects) {
        return new Pair(Boolean.valueOf($this_applyLoadMoreBackwardEffects.isScrollInProgress()), Boolean.valueOf($this_applyLoadMoreBackwardEffects.getCanScrollBackward()));
    }
}