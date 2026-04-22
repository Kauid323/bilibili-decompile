package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.tencent.open.SocialConstants;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ConnectivityStateManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private volatile ConnectivityState state = ConnectivityState.IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyWhenStateChanged(Runnable callback, Executor executor, ConnectivityState source) {
        Preconditions.checkNotNull(callback, "callback");
        Preconditions.checkNotNull(executor, "executor");
        Preconditions.checkNotNull(source, SocialConstants.PARAM_SOURCE);
        Listener stateChangeListener = new Listener(callback, executor);
        if (this.state != source) {
            stateChangeListener.runInExecutor();
        } else {
            this.listeners.add(stateChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gotoState(@Nonnull ConnectivityState newState) {
        Preconditions.checkNotNull(newState, "newState");
        if (this.state != newState && this.state != ConnectivityState.SHUTDOWN) {
            this.state = newState;
            if (this.listeners.isEmpty()) {
                return;
            }
            ArrayList<Listener> savedListeners = this.listeners;
            this.listeners = new ArrayList<>();
            Iterator<Listener> it = savedListeners.iterator();
            while (it.hasNext()) {
                Listener listener = it.next();
                listener.runInExecutor();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityState getState() {
        ConnectivityState stateCopy = this.state;
        if (stateCopy == null) {
            throw new UnsupportedOperationException("Channel state API is not implemented");
        }
        return stateCopy;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class Listener {
        final Runnable callback;
        final Executor executor;

        Listener(Runnable callback, Executor executor) {
            this.callback = callback;
            this.executor = executor;
        }

        void runInExecutor() {
            this.executor.execute(this.callback);
        }
    }
}