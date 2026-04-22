package curtains.internal;

import curtains.KeyEventInterceptor;
import curtains.OnContentChangedListener;
import curtains.OnWindowFocusChangedListener;
import curtains.TouchEventInterceptor;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

/* compiled from: WindowListeners.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcurtains/internal/WindowListeners;", "", "()V", "keyEventInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcurtains/KeyEventInterceptor;", "getKeyEventInterceptors", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "onContentChangedListeners", "Lcurtains/OnContentChangedListener;", "getOnContentChangedListeners", "onWindowFocusChangedListeners", "Lcurtains/OnWindowFocusChangedListener;", "getOnWindowFocusChangedListeners", "touchEventInterceptors", "Lcurtains/TouchEventInterceptor;", "getTouchEventInterceptors", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowListeners {
    private final CopyOnWriteArrayList<TouchEventInterceptor> touchEventInterceptors = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<KeyEventInterceptor> keyEventInterceptors = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<OnContentChangedListener> onContentChangedListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<OnWindowFocusChangedListener> onWindowFocusChangedListeners = new CopyOnWriteArrayList<>();

    public final CopyOnWriteArrayList<TouchEventInterceptor> getTouchEventInterceptors() {
        return this.touchEventInterceptors;
    }

    public final CopyOnWriteArrayList<KeyEventInterceptor> getKeyEventInterceptors() {
        return this.keyEventInterceptors;
    }

    public final CopyOnWriteArrayList<OnContentChangedListener> getOnContentChangedListeners() {
        return this.onContentChangedListeners;
    }

    public final CopyOnWriteArrayList<OnWindowFocusChangedListener> getOnWindowFocusChangedListeners() {
        return this.onWindowFocusChangedListeners;
    }
}