package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer$CC;
import j$.util.function.Consumer$CC;
import j$.util.stream.DistinctOps;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

final class DistinctOps {
    private DistinctOps() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: j$.util.stream.DistinctOps$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class AnonymousClass1<T> extends ReferencePipeline.StatefulOp<T, T> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, T, ?> */
        AnonymousClass1(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags) {
            super(abstractPipeline, inputShape, opFlags);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.TerminalOp != java.util.stream.TerminalOp<T, java.util.LinkedHashSet<T>> */
        <P_IN> Node<T> reduce(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
            return Nodes.node((Collection) ReduceOps.makeRef(new Supplier() { // from class: j$.util.stream.DistinctOps$1$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new LinkedHashSet();
                }
            }, new BiConsumer() { // from class: j$.util.stream.DistinctOps$1$$ExternalSyntheticLambda2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((LinkedHashSet) obj).add(obj2);
                }

                @Override // java.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer$CC.$default$andThen(this, biConsumer);
                }
            }, new BiConsumer() { // from class: j$.util.stream.DistinctOps$1$$ExternalSyntheticLambda3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                }

                @Override // java.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer$CC.$default$andThen(this, biConsumer);
                }
            }).evaluateParallel(pipelineHelper, spliterator));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<T, java.lang.Boolean> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.TerminalOp != java.util.stream.TerminalOp<T, java.lang.Void> */
        @Override // j$.util.stream.ReferencePipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
            if (StreamOpFlag.DISTINCT.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.evaluate(spliterator, false, generator);
            }
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return reduce(pipelineHelper, spliterator);
            }
            final AtomicBoolean seenNull = new AtomicBoolean(false);
            final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ForEachOps.makeRef(new Consumer() { // from class: j$.util.stream.DistinctOps$1$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    DistinctOps.AnonymousClass1.lambda$opEvaluateParallel$0(seenNull, concurrentHashMap, obj);
                }

                @Override // java.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer$CC.$default$andThen(this, consumer);
                }
            }, false).evaluateParallel(pipelineHelper, spliterator);
            Collection keySet = concurrentHashMap.keySet();
            HashSet hashSet = keySet;
            if (seenNull.get()) {
                HashSet hashSet2 = new HashSet(keySet);
                hashSet2.add(null);
                hashSet = hashSet2;
            }
            return Nodes.node(hashSet);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$opEvaluateParallel$0(AtomicBoolean seenNull, ConcurrentHashMap map, Object t) {
            if (t == null) {
                seenNull.set(true);
            } else {
                map.putIfAbsent(t, Boolean.TRUE);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.DISTINCT.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.wrapSpliterator(spliterator);
            }
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return reduce(pipelineHelper, spliterator).spliterator();
            }
            return new StreamSpliterators.DistinctSpliterator(pipelineHelper.wrapSpliterator(spliterator));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<T> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<T> opWrapSink(int flags, Sink<T> sink) {
            Objects.requireNonNull(sink);
            if (StreamOpFlag.DISTINCT.isKnown(flags)) {
                return sink;
            }
            if (StreamOpFlag.SORTED.isKnown(flags)) {
                return new Sink.ChainedReference<T, T>(sink) { // from class: j$.util.stream.DistinctOps.1.1
                    T lastSeen;
                    boolean seenNull;

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.seenNull = false;
                        this.lastSeen = null;
                        this.downstream.begin(-1L);
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void end() {
                        this.seenNull = false;
                        this.lastSeen = null;
                        this.downstream.end();
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t) {
                        if (t == null) {
                            if (!this.seenNull) {
                                this.seenNull = true;
                                Consumer consumer = this.downstream;
                                this.lastSeen = null;
                                consumer.accept(null);
                            }
                        } else if (this.lastSeen == null || !t.equals(this.lastSeen)) {
                            Consumer consumer2 = this.downstream;
                            this.lastSeen = t;
                            consumer2.accept(t);
                        }
                    }
                };
            }
            return new Sink.ChainedReference<T, T>(sink) { // from class: j$.util.stream.DistinctOps.1.2
                Set<T> seen;

                @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                public void begin(long size) {
                    this.seen = new HashSet();
                    this.downstream.begin(-1L);
                }

                @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                public void end() {
                    this.seen = null;
                    this.downstream.end();
                }

                @Override // java.util.function.Consumer
                public void accept(T t) {
                    if (!this.seen.contains(t)) {
                        this.seen.add(t);
                        this.downstream.accept(t);
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, T, ?> */
    public static <T> ReferencePipeline<T, T> makeRef(AbstractPipeline<?, T, ?> abstractPipeline) {
        return new AnonymousClass1(abstractPipeline, StreamShape.REFERENCE, StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED);
    }
}