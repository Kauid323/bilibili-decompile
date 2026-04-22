package io.grpc.internal;

import io.grpc.Context;

abstract class ContextRunnable implements Runnable {
    private final Context context;

    public abstract void runInContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public ContextRunnable(Context context) {
        this.context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context previous = this.context.attach();
        try {
            runInContext();
        } finally {
            this.context.detach(previous);
        }
    }
}