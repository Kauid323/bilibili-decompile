package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ApplicationThreadDeframerListener implements MessageDeframer.Listener {
    private final Queue<InputStream> messageReadQueue = new ArrayDeque();
    private final MessageDeframer.Listener storedListener;
    private final TransportExecutor transportExecutor;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface TransportExecutor {
        void runOnTransportThread(Runnable runnable);
    }

    public ApplicationThreadDeframerListener(MessageDeframer.Listener listener, TransportExecutor transportExecutor) {
        this.storedListener = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, "listener");
        this.transportExecutor = (TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(final int numBytes) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframerListener.1
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframerListener.this.storedListener.bytesRead(numBytes);
            }
        });
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer producer) {
        while (true) {
            InputStream message = producer.next();
            if (message != null) {
                this.messageReadQueue.add(message);
            } else {
                return;
            }
        }
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(final boolean hasPartialMessage) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframerListener.2
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframerListener.this.storedListener.deframerClosed(hasPartialMessage);
            }
        });
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(final Throwable cause) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframerListener.3
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframerListener.this.storedListener.deframeFailed(cause);
            }
        });
    }

    public InputStream messageReadQueuePoll() {
        return this.messageReadQueue.poll();
    }
}