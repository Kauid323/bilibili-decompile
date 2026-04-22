package rx.internal.util.unsafe;

/* compiled from: SpscUnboundedArrayQueue.java */
abstract class SpscUnboundedArrayQueueConsumerColdField<E> extends SpscUnboundedArrayQueueL2Pad<E> {
    protected E[] consumerBuffer;
    protected long consumerMask;
}