package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class ForwardingDeframerListener implements MessageDeframer.Listener {
    protected abstract MessageDeframer.Listener delegate();

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(int numBytes) {
        delegate().bytesRead(numBytes);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer producer) {
        delegate().messagesAvailable(producer);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean hasPartialMessage) {
        delegate().deframerClosed(hasPartialMessage);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable cause) {
        delegate().deframeFailed(cause);
    }
}