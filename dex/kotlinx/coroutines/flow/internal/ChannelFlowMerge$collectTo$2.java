package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;

/* compiled from: Merge.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "inner", "Lkotlinx/coroutines/flow/Flow;", "emit", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ChannelFlowMerge$collectTo$2<T> implements FlowCollector {
    final /* synthetic */ SendingCollector<T> $collector;
    final /* synthetic */ Job $job;
    final /* synthetic */ ProducerScope<T> $scope;
    final /* synthetic */ Semaphore $semaphore;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2(Job job, Semaphore semaphore, ProducerScope<? super T> producerScope, SendingCollector<T> sendingCollector) {
        this.$job = job;
        this.$semaphore = semaphore;
        this.$scope = producerScope;
        this.$collector = sendingCollector;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((Flow) ((Flow) value), (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Flow<? extends T> flow, Continuation<? super Unit> continuation) {
        ChannelFlowMerge$collectTo$2$emit$1 channelFlowMerge$collectTo$2$emit$1;
        ChannelFlowMerge$collectTo$2$emit$1 channelFlowMerge$collectTo$2$emit$12;
        ChannelFlowMerge$collectTo$2 channelFlowMerge$collectTo$2;
        if (continuation instanceof ChannelFlowMerge$collectTo$2$emit$1) {
            channelFlowMerge$collectTo$2$emit$1 = (ChannelFlowMerge$collectTo$2$emit$1) continuation;
            if ((channelFlowMerge$collectTo$2$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelFlowMerge$collectTo$2$emit$1.label -= IntCompanionObject.MIN_VALUE;
                channelFlowMerge$collectTo$2$emit$12 = channelFlowMerge$collectTo$2$emit$1;
                Object $result = channelFlowMerge$collectTo$2$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelFlowMerge$collectTo$2$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Job job = this.$job;
                        if (job != null) {
                            JobKt.ensureActive(job);
                        }
                        Semaphore semaphore = this.$semaphore;
                        channelFlowMerge$collectTo$2$emit$12.L$0 = this;
                        channelFlowMerge$collectTo$2$emit$12.L$1 = flow;
                        channelFlowMerge$collectTo$2$emit$12.label = 1;
                        if (semaphore.acquire(channelFlowMerge$collectTo$2$emit$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelFlowMerge$collectTo$2 = this;
                        break;
                    case 1:
                        flow = (Flow) channelFlowMerge$collectTo$2$emit$12.L$1;
                        channelFlowMerge$collectTo$2 = (ChannelFlowMerge$collectTo$2) channelFlowMerge$collectTo$2$emit$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                BuildersKt__Builders_commonKt.launch$default(channelFlowMerge$collectTo$2.$scope, null, null, new AnonymousClass1(flow, channelFlowMerge$collectTo$2.$collector, channelFlowMerge$collectTo$2.$semaphore, null), 3, null);
                return Unit.INSTANCE;
            }
        }
        channelFlowMerge$collectTo$2$emit$1 = new ChannelFlowMerge$collectTo$2$emit$1(this, continuation);
        channelFlowMerge$collectTo$2$emit$12 = channelFlowMerge$collectTo$2$emit$1;
        Object $result2 = channelFlowMerge$collectTo$2$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelFlowMerge$collectTo$2$emit$12.label) {
        }
        BuildersKt__Builders_commonKt.launch$default(channelFlowMerge$collectTo$2.$scope, null, null, new AnonymousClass1(flow, channelFlowMerge$collectTo$2.$collector, channelFlowMerge$collectTo$2.$semaphore, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Merge.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendingCollector<T> $collector;
        final /* synthetic */ Flow<T> $inner;
        final /* synthetic */ Semaphore $semaphore;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, SendingCollector<T> sendingCollector, Semaphore semaphore, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$inner = flow;
            this.$collector = sendingCollector;
            this.$semaphore = semaphore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$inner, this.$collector, this.$semaphore, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Throwable th;
            AnonymousClass1 anonymousClass1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        this.label = 1;
                        if (this.$inner.collect(this.$collector, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass1 = this;
                        anonymousClass1.$semaphore.release();
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass1 = this;
                        anonymousClass1.$semaphore.release();
                        throw th;
                    }
                case 1:
                    anonymousClass1 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1.$semaphore.release();
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        anonymousClass1.$semaphore.release();
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}