package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class SquelchLateMessagesAvailableDeframerListener extends ForwardingDeframerListener {
    private boolean closed;
    private final MessageDeframer.Listener delegate;

    public SquelchLateMessagesAvailableDeframerListener(MessageDeframer.Listener delegate) {
        this.delegate = delegate;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener
    protected MessageDeframer.Listener delegate() {
        return this.delegate;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer producer) {
        if (this.closed) {
            if (producer instanceof Closeable) {
                GrpcUtil.closeQuietly((Closeable) producer);
                return;
            }
            return;
        }
        super.messagesAvailable(producer);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean hasPartialMessage) {
        this.closed = true;
        super.deframerClosed(hasPartialMessage);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable cause) {
        this.closed = true;
        super.deframeFailed(cause);
    }
}