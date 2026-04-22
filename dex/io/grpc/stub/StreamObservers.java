package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.tencent.open.SocialConstants;
import java.util.Iterator;

public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> source, final CallStreamObserver<V> target) {
        Preconditions.checkNotNull(source, SocialConstants.PARAM_SOURCE);
        Preconditions.checkNotNull(target, "target");
        target.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1FlowControllingOnReadyHandler
            private boolean completed;

            @Override // java.lang.Runnable
            public void run() {
                if (this.completed) {
                    return;
                }
                while (CallStreamObserver.this.isReady() && source.hasNext()) {
                    CallStreamObserver.this.onNext(source.next());
                }
                if (!source.hasNext()) {
                    this.completed = true;
                    CallStreamObserver.this.onCompleted();
                }
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> source, CallStreamObserver<V> target) {
        Preconditions.checkNotNull(source, SocialConstants.PARAM_SOURCE);
        copyWithFlowControl(source.iterator(), target);
    }
}