package leakcanary;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.SharkLog;

/* compiled from: ObjectWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\"J\u0018\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u000e\u0010-\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011J\b\u0010.\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0014H\u0007J\u0018\u0010/\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u001fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lleakcanary/ObjectWatcher;", "Lleakcanary/ReachabilityWatcher;", "clock", "Lleakcanary/Clock;", "checkRetainedExecutor", "Ljava/util/concurrent/Executor;", "isEnabled", "Lkotlin/Function0;", "", "(Lleakcanary/Clock;Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "hasRetainedObjects", "getHasRetainedObjects", "()Z", "hasWatchedObjects", "getHasWatchedObjects", "onObjectRetainedListeners", "", "Lleakcanary/OnObjectRetainedListener;", "queue", "Ljava/lang/ref/ReferenceQueue;", "", "retainedObjectCount", "", "getRetainedObjectCount", "()I", "retainedObjects", "", "getRetainedObjects", "()Ljava/util/List;", "watchedObjects", "", "", "Lleakcanary/KeyedWeakReference;", "addOnObjectRetainedListener", "", "listener", "clearObjectsWatchedBefore", "heapDumpUptimeMillis", "", "clearWatchedObjects", "expectWeaklyReachable", "watchedObject", "description", "moveToRetained", "key", "removeOnObjectRetainedListener", "removeWeaklyReachableObjects", "watch", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
public final class ObjectWatcher implements ReachabilityWatcher {
    private final Executor checkRetainedExecutor;
    private final Clock clock;
    private final Function0<Boolean> isEnabled;
    private final Set<OnObjectRetainedListener> onObjectRetainedListeners;
    private final ReferenceQueue<Object> queue;
    private final Map<String, KeyedWeakReference> watchedObjects;

    public ObjectWatcher(Clock clock, Executor checkRetainedExecutor, Function0<Boolean> isEnabled) {
        Intrinsics.checkParameterIsNotNull(clock, "clock");
        Intrinsics.checkParameterIsNotNull(checkRetainedExecutor, "checkRetainedExecutor");
        Intrinsics.checkParameterIsNotNull(isEnabled, "isEnabled");
        this.clock = clock;
        this.checkRetainedExecutor = checkRetainedExecutor;
        this.isEnabled = isEnabled;
        this.onObjectRetainedListeners = new LinkedHashSet();
        this.watchedObjects = new LinkedHashMap();
        this.queue = new ReferenceQueue<>();
    }

    public /* synthetic */ ObjectWatcher(Clock clock, Executor executor, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clock, executor, (i & 4) != 0 ? new Function0<Boolean>() { // from class: leakcanary.ObjectWatcher.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return true;
            }
        } : anonymousClass1);
    }

    public final synchronized boolean getHasRetainedObjects() {
        boolean z;
        Map.Entry it;
        removeWeaklyReachableObjects();
        Map $this$any$iv = this.watchedObjects;
        z = false;
        if (!$this$any$iv.isEmpty()) {
            Iterator<Map.Entry<String, KeyedWeakReference>> it2 = $this$any$iv.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry element$iv = it2.next();
                if (element$iv.getValue().getRetainedUptimeMillis() != -1) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public final synchronized int getRetainedObjectCount() {
        int i;
        removeWeaklyReachableObjects();
        Map $this$count$iv = this.watchedObjects;
        i = 0;
        if (!$this$count$iv.isEmpty()) {
            int count$iv = 0;
            for (Map.Entry element$iv : $this$count$iv.entrySet()) {
                if (element$iv.getValue().getRetainedUptimeMillis() != -1) {
                    count$iv++;
                }
            }
            i = count$iv;
        }
        return i;
    }

    public final synchronized boolean getHasWatchedObjects() {
        removeWeaklyReachableObjects();
        return !this.watchedObjects.isEmpty();
    }

    public final synchronized List<Object> getRetainedObjects() {
        List instances;
        Object instance;
        removeWeaklyReachableObjects();
        instances = new ArrayList();
        for (KeyedWeakReference weakReference : this.watchedObjects.values()) {
            if (weakReference.getRetainedUptimeMillis() != -1 && (instance = weakReference.get()) != null) {
                instances.add(instance);
            }
        }
        return instances;
    }

    public final synchronized void addOnObjectRetainedListener(OnObjectRetainedListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.onObjectRetainedListeners.add(listener);
    }

    public final synchronized void removeOnObjectRetainedListener(OnObjectRetainedListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.onObjectRetainedListeners.remove(listener);
    }

    @Deprecated(message = "Add description parameter explaining why an object is watched to help understand leak traces.", replaceWith = @ReplaceWith(expression = "expectWeaklyReachable(watchedObject, \"Explain why this object should be garbage collected soon\")", imports = {}))
    public final void watch(Object watchedObject) {
        Intrinsics.checkParameterIsNotNull(watchedObject, "watchedObject");
        expectWeaklyReachable(watchedObject, "");
    }

    @Deprecated(message = "Method renamed expectWeaklyReachable() to clarify usage.", replaceWith = @ReplaceWith(expression = "expectWeaklyReachable(watchedObject, description)", imports = {}))
    public final void watch(Object watchedObject, String description) {
        Intrinsics.checkParameterIsNotNull(watchedObject, "watchedObject");
        Intrinsics.checkParameterIsNotNull(description, "description");
        expectWeaklyReachable(watchedObject, description);
    }

    @Override // leakcanary.ReachabilityWatcher
    public synchronized void expectWeaklyReachable(Object watchedObject, String description) {
        Intrinsics.checkParameterIsNotNull(watchedObject, "watchedObject");
        Intrinsics.checkParameterIsNotNull(description, "description");
        if (this.isEnabled.invoke().booleanValue()) {
            removeWeaklyReachableObjects();
            final String key = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(key, "UUID.randomUUID()\n      .toString()");
            long watchUptimeMillis = this.clock.uptimeMillis();
            KeyedWeakReference reference = new KeyedWeakReference(watchedObject, key, description, watchUptimeMillis, this.queue);
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("Watching " + (watchedObject instanceof Class ? watchedObject.toString() : "instance of " + watchedObject.getClass().getName()) + (description.length() > 0 ? " (" + description + ')' : "") + " with key " + key);
            }
            this.watchedObjects.put(key, reference);
            this.checkRetainedExecutor.execute(new Runnable() { // from class: leakcanary.ObjectWatcher$expectWeaklyReachable$2
                @Override // java.lang.Runnable
                public final void run() {
                    ObjectWatcher.this.moveToRetained(key);
                }
            });
        }
    }

    public final synchronized void clearObjectsWatchedBefore(long heapDumpUptimeMillis) {
        Map $this$filter$iv = this.watchedObjects;
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry element$iv$iv : $this$filter$iv.entrySet()) {
            if (element$iv$iv.getValue().getWatchUptimeMillis() <= heapDumpUptimeMillis) {
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
        }
        Iterable $this$forEach$iv = destination$iv$iv.values();
        for (Object element$iv : $this$forEach$iv) {
            KeyedWeakReference it = (KeyedWeakReference) element$iv;
            it.clear();
        }
        this.watchedObjects.keySet().removeAll(destination$iv$iv.keySet());
    }

    public final synchronized void clearWatchedObjects() {
        Iterable $this$forEach$iv = this.watchedObjects.values();
        for (Object element$iv : $this$forEach$iv) {
            KeyedWeakReference it = (KeyedWeakReference) element$iv;
            it.clear();
        }
        this.watchedObjects.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void moveToRetained(String key) {
        removeWeaklyReachableObjects();
        KeyedWeakReference retainedRef = this.watchedObjects.get(key);
        if (retainedRef != null) {
            retainedRef.setRetainedUptimeMillis(this.clock.uptimeMillis());
            Iterable $this$forEach$iv = this.onObjectRetainedListeners;
            for (Object element$iv : $this$forEach$iv) {
                OnObjectRetainedListener it = (OnObjectRetainedListener) element$iv;
                it.onObjectRetained();
            }
        }
    }

    private final void removeWeaklyReachableObjects() {
        KeyedWeakReference ref;
        do {
            ref = (KeyedWeakReference) this.queue.poll();
            if (ref != null) {
                this.watchedObjects.remove(ref.getKey());
                continue;
            }
        } while (ref != null);
    }
}