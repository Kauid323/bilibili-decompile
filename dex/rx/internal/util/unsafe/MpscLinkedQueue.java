package rx.internal.util.unsafe;

import com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$;
import rx.internal.util.atomic.LinkedQueueNode;

public final class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public MpscLinkedQueue() {
        this.consumerNode = new LinkedQueueNode<>();
        xchgProducerNode(this.consumerNode);
    }

    protected LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> newVal) {
        Object oldVal;
        do {
            oldVal = this.producerNode;
        } while (!AbstractFuture$UnsafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(UnsafeAccess.UNSAFE, this, P_NODE_OFFSET, oldVal, newVal));
        return (LinkedQueueNode) oldVal;
    }

    @Override // java.util.Queue
    public boolean offer(E nextValue) {
        if (nextValue == null) {
            throw new NullPointerException("null elements not allowed");
        }
        LinkedQueueNode<E> nextNode = new LinkedQueueNode<>(nextValue);
        LinkedQueueNode<E> prevProducerNode = xchgProducerNode(nextNode);
        prevProducerNode.soNext(nextNode);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> nextNode;
        LinkedQueueNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> nextNode2 = currConsumerNode.lvNext();
        if (nextNode2 != null) {
            E nextValue = nextNode2.getAndNullValue();
            spConsumerNode(nextNode2);
            return nextValue;
        } else if (currConsumerNode != lvProducerNode()) {
            do {
                nextNode = currConsumerNode.lvNext();
            } while (nextNode == null);
            E nextValue2 = nextNode.getAndNullValue();
            this.consumerNode = nextNode;
            return nextValue2;
        } else {
            return null;
        }
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> nextNode;
        LinkedQueueNode<E> currConsumerNode = this.consumerNode;
        LinkedQueueNode<E> nextNode2 = currConsumerNode.lvNext();
        if (nextNode2 != null) {
            return nextNode2.lpValue();
        }
        if (currConsumerNode != lvProducerNode()) {
            do {
                nextNode = currConsumerNode.lvNext();
            } while (nextNode == null);
            return nextNode.lpValue();
        }
        return null;
    }
}