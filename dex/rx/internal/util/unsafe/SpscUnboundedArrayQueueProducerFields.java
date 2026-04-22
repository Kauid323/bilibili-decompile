package rx.internal.util.unsafe;

import java.util.AbstractQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpscUnboundedArrayQueue.java */
public abstract class SpscUnboundedArrayQueueProducerFields<E> extends AbstractQueue<E> {
    protected long producerIndex;
}