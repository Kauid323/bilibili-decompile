package curtains.internal;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import curtains.DispatchState;
import curtains.KeyEventInterceptor;
import curtains.OnContentChangedListener;
import curtains.OnWindowFocusChangedListener;
import curtains.TouchEventInterceptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowCallbackWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\b\u0007¨\u0006\u0013"}, d2 = {"Lcurtains/internal/WindowCallbackWrapper;", "Lcurtains/internal/FixedWindowCallback;", "delegate", "Landroid/view/Window$Callback;", "(Landroid/view/Window$Callback;)V", "listeners", "Lcurtains/internal/WindowListeners;", "listeners$1", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "onContentChanged", "", "onWindowFocusChanged", "hasFocus", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowCallbackWrapper extends FixedWindowCallback {
    private final Window.Callback delegate;
    private final WindowListeners listeners$1;
    public static final Companion Companion = new Companion(null);
    private static final Lazy jetpackWrapperClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Class<? extends Object>>() { // from class: curtains.internal.WindowCallbackWrapper$Companion$jetpackWrapperClass$2
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke */
        public final Class<? extends Object> m786invoke() {
            Class<?> cls;
            try {
                return Class.forName("androidx.appcompat.view.WindowCallbackWrapper");
            } catch (Throwable th) {
                try {
                    cls = Class.forName("android.support.v7.view.WindowCallbackWrapper");
                } catch (Throwable th2) {
                    cls = null;
                }
                return cls;
            }
        }
    });
    private static final Lazy jetpackWrappedField$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Field>() { // from class: curtains.internal.WindowCallbackWrapper$Companion$jetpackWrappedField$2
        public final Field invoke() {
            Class jetpackWrapperClass;
            jetpackWrapperClass = WindowCallbackWrapper.Companion.getJetpackWrapperClass();
            if (jetpackWrapperClass != null) {
                try {
                    Field $this$apply = jetpackWrapperClass.getDeclaredField("mWrapped");
                    $this$apply.setAccessible(true);
                    return $this$apply;
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }
    });
    private static final WeakHashMap<Window, WeakReference<WindowCallbackWrapper>> callbackCache = new WeakHashMap<>();
    private static final Object listenersLock = new Object();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowCallbackWrapper(Window.Callback delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.listeners$1 = new WindowListeners();
    }

    @Override // curtains.internal.FixedWindowCallback, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        DispatchState from$curtains_release;
        if (event != null) {
            final Iterator iterator = this.listeners$1.getKeyEventInterceptors().iterator();
            Intrinsics.checkNotNullExpressionValue(iterator, "listeners.keyEventInterceptors.iterator()");
            Function1 dispatch = new Function1<KeyEvent, DispatchState>() { // from class: curtains.internal.WindowCallbackWrapper$dispatchKeyEvent$dispatch$1
                public DispatchState invoke(KeyEvent interceptedEvent) {
                    Intrinsics.checkNotNullParameter(interceptedEvent, "interceptedEvent");
                    if (!iterator.hasNext()) {
                        return DispatchState.Companion.from$curtains_release(WindowCallbackWrapper.this.delegate.dispatchKeyEvent(interceptedEvent));
                    }
                    KeyEventInterceptor nextInterceptor = (KeyEventInterceptor) iterator.next();
                    return nextInterceptor.intercept(interceptedEvent, this);
                }
            };
            if (iterator.hasNext()) {
                KeyEventInterceptor firstInterceptor = iterator.next();
                from$curtains_release = firstInterceptor.intercept(event, dispatch);
            } else {
                from$curtains_release = DispatchState.Companion.from$curtains_release(this.delegate.dispatchKeyEvent(event));
            }
            return from$curtains_release instanceof DispatchState.Consumed;
        }
        return this.delegate.dispatchKeyEvent(event);
    }

    @Override // curtains.internal.FixedWindowCallback, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        DispatchState from$curtains_release;
        if (event != null) {
            final Iterator iterator = this.listeners$1.getTouchEventInterceptors().iterator();
            Intrinsics.checkNotNullExpressionValue(iterator, "listeners.touchEventInterceptors.iterator()");
            Function1 dispatch = new Function1<MotionEvent, DispatchState>() { // from class: curtains.internal.WindowCallbackWrapper$dispatchTouchEvent$dispatch$1
                public DispatchState invoke(MotionEvent interceptedEvent) {
                    Intrinsics.checkNotNullParameter(interceptedEvent, "interceptedEvent");
                    if (!iterator.hasNext()) {
                        return DispatchState.Companion.from$curtains_release(WindowCallbackWrapper.this.delegate.dispatchTouchEvent(interceptedEvent));
                    }
                    TouchEventInterceptor nextInterceptor = (TouchEventInterceptor) iterator.next();
                    return nextInterceptor.intercept(interceptedEvent, this);
                }
            };
            if (iterator.hasNext()) {
                TouchEventInterceptor firstInterceptor = iterator.next();
                from$curtains_release = firstInterceptor.intercept(event, dispatch);
            } else {
                from$curtains_release = DispatchState.Companion.from$curtains_release(this.delegate.dispatchTouchEvent(event));
            }
            return from$curtains_release instanceof DispatchState.Consumed;
        }
        return this.delegate.dispatchTouchEvent(event);
    }

    @Override // curtains.internal.FixedWindowCallback, android.view.Window.Callback
    public void onContentChanged() {
        Iterable $this$forEach$iv = this.listeners$1.getOnContentChangedListeners();
        for (Object element$iv : $this$forEach$iv) {
            OnContentChangedListener it = (OnContentChangedListener) element$iv;
            it.onContentChanged();
        }
        this.delegate.onContentChanged();
    }

    @Override // curtains.internal.FixedWindowCallback, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        Iterable $this$forEach$iv = this.listeners$1.getOnWindowFocusChangedListeners();
        for (Object element$iv : $this$forEach$iv) {
            OnWindowFocusChangedListener it = (OnWindowFocusChangedListener) element$iv;
            it.onWindowFocusChanged(hasFocus);
        }
        this.delegate.onWindowFocusChanged(hasFocus);
    }

    /* compiled from: WindowCallbackWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0086\u0010R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR%\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015*\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u00020\u001c*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcurtains/internal/WindowCallbackWrapper$Companion;", "", "()V", "callbackCache", "Ljava/util/WeakHashMap;", "Landroid/view/Window;", "Ljava/lang/ref/WeakReference;", "Lcurtains/internal/WindowCallbackWrapper;", "jetpackWrappedField", "Ljava/lang/reflect/Field;", "getJetpackWrappedField", "()Ljava/lang/reflect/Field;", "jetpackWrappedField$delegate", "Lkotlin/Lazy;", "jetpackWrapperClass", "Ljava/lang/Class;", "getJetpackWrapperClass", "()Ljava/lang/Class;", "jetpackWrapperClass$delegate", "listenersLock", "isJetpackWrapper", "", "Landroid/view/Window$Callback;", "(Landroid/view/Window$Callback;)Z", "jetpackWrapped", "getJetpackWrapped", "(Landroid/view/Window$Callback;)Landroid/view/Window$Callback;", "listeners", "Lcurtains/internal/WindowListeners;", "getListeners", "(Landroid/view/Window;)Lcurtains/internal/WindowListeners;", "unwrap", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        private final Field getJetpackWrappedField() {
            Lazy lazy = WindowCallbackWrapper.jetpackWrappedField$delegate;
            Companion companion = WindowCallbackWrapper.Companion;
            return (Field) lazy.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Class<? extends Object> getJetpackWrapperClass() {
            Lazy lazy = WindowCallbackWrapper.jetpackWrapperClass$delegate;
            Companion companion = WindowCallbackWrapper.Companion;
            return (Class) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private final boolean isJetpackWrapper(Window.Callback $this$isJetpackWrapper) {
            Class<? extends Object> jetpackWrapperClass = WindowCallbackWrapper.Companion.getJetpackWrapperClass();
            if (jetpackWrapperClass != null) {
                return jetpackWrapperClass.isInstance($this$isJetpackWrapper);
            }
            return false;
        }

        private final Window.Callback getJetpackWrapped(Window.Callback $this$jetpackWrapped) {
            Field jetpackWrappedField = WindowCallbackWrapper.Companion.getJetpackWrappedField();
            Intrinsics.checkNotNull(jetpackWrappedField);
            return (Window.Callback) jetpackWrappedField.get($this$jetpackWrapped);
        }

        public final WindowListeners getListeners(Window $this$listeners) {
            WindowListeners windowListeners;
            Intrinsics.checkNotNullParameter($this$listeners, "$this$listeners");
            synchronized (WindowCallbackWrapper.listenersLock) {
                WeakReference weakReference = (WeakReference) WindowCallbackWrapper.callbackCache.get($this$listeners);
                WindowCallbackWrapper existingWrapper = weakReference != null ? (WindowCallbackWrapper) weakReference.get() : null;
                if (existingWrapper != null) {
                    return existingWrapper.listeners$1;
                }
                Window.Callback currentCallback = $this$listeners.getCallback();
                if (currentCallback == null) {
                    windowListeners = new WindowListeners();
                } else {
                    WindowCallbackWrapper windowCallbackWrapper = new WindowCallbackWrapper(currentCallback);
                    $this$listeners.setCallback(windowCallbackWrapper);
                    WindowCallbackWrapper.callbackCache.put($this$listeners, new WeakReference(windowCallbackWrapper));
                    windowListeners = windowCallbackWrapper.listeners$1;
                }
                return windowListeners;
            }
        }

        public final Window.Callback unwrap(Window.Callback $this$unwrap) {
            while ($this$unwrap != null) {
                if ($this$unwrap instanceof WindowCallbackWrapper) {
                    $this$unwrap = ((WindowCallbackWrapper) $this$unwrap).delegate;
                } else if (!isJetpackWrapper($this$unwrap)) {
                    return $this$unwrap;
                } else {
                    $this$unwrap = getJetpackWrapped($this$unwrap);
                }
            }
            return null;
        }
    }
}