package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframerListener;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

public class ApplicationThreadDeframer implements Deframer {
    private final ApplicationThreadDeframerListener appListener;
    private final MessageDeframer deframer;
    private final MessageDeframer.Listener storedListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface TransportExecutor extends ApplicationThreadDeframerListener.TransportExecutor {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationThreadDeframer(MessageDeframer.Listener listener, TransportExecutor transportExecutor, MessageDeframer deframer) {
        this.storedListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) Preconditions.checkNotNull(listener, "listener"));
        this.appListener = new ApplicationThreadDeframerListener(this.storedListener, transportExecutor);
        deframer.setListener(this.appListener);
        this.deframer = deframer;
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int messageSize) {
        this.deframer.setMaxInboundMessageSize(messageSize);
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer fullStreamDecompressor) {
        this.deframer.setFullStreamDecompressor(fullStreamDecompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void request(final int numMessages) {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ApplicationThreadDeframer.this.deframer.isClosed()) {
                    try {
                        ApplicationThreadDeframer.this.deframer.request(numMessages);
                    } catch (Throwable t) {
                        ApplicationThreadDeframer.this.appListener.deframeFailed(t);
                        ApplicationThreadDeframer.this.deframer.close();
                    }
                }
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(final ReadableBuffer data) {
        this.storedListener.messagesAvailable(new CloseableInitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ApplicationThreadDeframer.this.deframer.deframe(data);
                } catch (Throwable t) {
                    ApplicationThreadDeframer.this.appListener.deframeFailed(t);
                    ApplicationThreadDeframer.this.deframer.close();
                }
            }
        }, new Closeable() { // from class: io.grpc.internal.ApplicationThreadDeframer.3
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                data.close();
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.4
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.deframer.closeWhenComplete();
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        this.deframer.stopDelivery();
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.5
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.deframer.close();
            }
        }));
    }

    MessageDeframer.Listener getAppListener() {
        return this.appListener;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private class InitializingMessageProducer implements StreamListener.MessageProducer {
        private boolean initialized;
        private final Runnable runnable;

        private InitializingMessageProducer(Runnable runnable) {
            this.initialized = false;
            this.runnable = runnable;
        }

        private void initialize() {
            if (!this.initialized) {
                this.runnable.run();
                this.initialized = true;
            }
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        @Nullable
        public InputStream next() {
            initialize();
            return ApplicationThreadDeframer.this.appListener.messageReadQueuePoll();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private class CloseableInitializingMessageProducer extends InitializingMessageProducer implements Closeable {
        private final Closeable closeable;

        public CloseableInitializingMessageProducer(Runnable runnable, Closeable closeable) {
            super(runnable);
            this.closeable = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closeable.close();
        }
    }
}