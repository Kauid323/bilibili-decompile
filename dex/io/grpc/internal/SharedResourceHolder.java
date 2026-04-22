package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class SharedResourceHolder {
    static final long DESTROY_DELAY_SECONDS = 1;
    private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory() { // from class: io.grpc.internal.SharedResourceHolder.1
        @Override // io.grpc.internal.SharedResourceHolder.ScheduledExecutorFactory
        public ScheduledExecutorService createScheduledExecutor() {
            return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
        }
    });
    private ScheduledExecutorService destroyer;
    private final ScheduledExecutorFactory destroyerFactory;
    private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap<>();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Resource<T> {
        void close(T t);

        T create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ScheduledExecutorFactory {
        ScheduledExecutorService createScheduledExecutor();
    }

    SharedResourceHolder(ScheduledExecutorFactory destroyerFactory) {
        this.destroyerFactory = destroyerFactory;
    }

    public static <T> T get(Resource<T> resource) {
        return (T) holder.getInternal(resource);
    }

    public static <T> T release(Resource<T> resource, T instance) {
        return (T) holder.releaseInternal(resource, instance);
    }

    synchronized <T> T getInternal(Resource<T> resource) {
        Instance instance;
        instance = this.instances.get(resource);
        if (instance == null) {
            instance = new Instance(resource.create());
            this.instances.put(resource, instance);
        }
        if (instance.destroyTask != null) {
            instance.destroyTask.cancel(false);
            instance.destroyTask = null;
        }
        instance.refcount++;
        return (T) instance.payload;
    }

    synchronized <T> T releaseInternal(final Resource<T> resource, final T instance) {
        final Instance cached = this.instances.get(resource);
        if (cached == null) {
            throw new IllegalArgumentException("No cached instance found for " + resource);
        }
        Preconditions.checkArgument(instance == cached.payload, "Releasing the wrong instance");
        Preconditions.checkState(cached.refcount > 0, "Refcount has already reached zero");
        cached.refcount--;
        if (cached.refcount == 0) {
            Preconditions.checkState(cached.destroyTask == null, "Destroy task already scheduled");
            if (this.destroyer == null) {
                this.destroyer = this.destroyerFactory.createScheduledExecutor();
            }
            cached.destroyTask = this.destroyer.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.SharedResourceHolder.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (SharedResourceHolder.this) {
                        if (cached.refcount == 0) {
                            resource.close(instance);
                            SharedResourceHolder.this.instances.remove(resource);
                            if (SharedResourceHolder.this.instances.isEmpty()) {
                                SharedResourceHolder.this.destroyer.shutdown();
                                SharedResourceHolder.this.destroyer = null;
                            }
                        }
                    }
                }
            }), 1L, TimeUnit.SECONDS);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class Instance {
        ScheduledFuture<?> destroyTask;
        final Object payload;
        int refcount;

        Instance(Object payload) {
            this.payload = payload;
        }
    }
}