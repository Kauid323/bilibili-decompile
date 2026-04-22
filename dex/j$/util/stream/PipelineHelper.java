package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Node;
import java.util.function.IntFunction;

abstract class PipelineHelper<P_OUT> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> void copyInto(Sink<P_IN> sink, Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> boolean copyIntoWithCancel(Sink<P_IN> sink, Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> Node<P_OUT> evaluate(Spliterator<P_IN> spliterator, boolean z, IntFunction<P_OUT[]> intFunction);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> long exactOutputSizeIfKnown(Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StreamShape getSourceShape();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getStreamAndOpFlags();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Node.Builder<P_OUT> makeNodeBuilder(long j, IntFunction<P_OUT[]> intFunction);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN, S extends Sink<P_OUT>> S wrapAndCopyInto(S s, Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> Sink<P_IN> wrapSink(Sink<P_OUT> sink);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> Spliterator<P_OUT> wrapSpliterator(Spliterator<P_IN> spliterator);
}